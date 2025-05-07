package com.example.flightsearchapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightsearchapp.R
import com.example.flightsearchapp.data.Airport
import com.example.flightsearchapp.data.DataSource
import com.example.flightsearchapp.data.Flight
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightSearchScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.app_name)) })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            var searchText by remember { mutableStateOf("") }
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text(stringResource(R.string.search)) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            var selectedDepartureAirport by remember { mutableStateOf<Airport?>(null) }

            val filteredAirports = remember(searchText) {
                DataSource.airportList.filter {
                    it.name.contains(searchText, ignoreCase = true) ||
                            it.iataCode.contains(searchText, ignoreCase = true)
                }
            }

            if (selectedDepartureAirport == null) {
                LazyColumn {
                    items(filteredAirports) { airport ->
                        AirportItem(airport = airport) { selectedAirport ->
                            selectedDepartureAirport = selectedAirport
                        }
                        if (filteredAirports.indexOf(airport) < filteredAirports.size - 1) {
                            Divider()
                        }
                    }
                }
            } else {
                val flightsFromDepartureAirport = remember(selectedDepartureAirport) {
                    DataSource.flightList.filter { it.departureCode == selectedDepartureAirport?.iataCode }
                }
                Text(
                    text = stringResource(R.string.flights_from, selectedDepartureAirport?.name ?: ""),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                if (flightsFromDepartureAirport.isNotEmpty()) {
                    LazyColumn {
                        items(flightsFromDepartureAirport) { flight ->
                            FlightItem(flight = flight)
                            if (flightsFromDepartureAirport.indexOf(flight) < flightsFromDepartureAirport.size - 1) {
                                Divider()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AirportItem(airport: Airport, onAirportSelected: (Airport) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onAirportSelected(airport) }
    ) {
        Text(text = airport.iataCode, fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.3f))
        Text(text = airport.name, modifier = Modifier.weight(0.7f))
    }
}

@Composable
fun FlightItem(flight: Flight) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(0.5f)) {
            Text(
                text = stringResource(R.string.departure, flight.departureCode),
                fontWeight = FontWeight.Bold
            )
            Text(text = flight.departureTime)
        }
        Column(modifier = Modifier.weight(0.5f)) {
            Text(
                text = stringResource(R.string.arrival, flight.destinationCode),
                fontWeight = FontWeight.Bold
            )
            Text(text = flight.arrivalTime)
        }
        Text(text = "$${flight.price}", fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun FlightSearchScreenPreview() {
    FlightSearchAppTheme {
        FlightSearchScreen()
    }
}