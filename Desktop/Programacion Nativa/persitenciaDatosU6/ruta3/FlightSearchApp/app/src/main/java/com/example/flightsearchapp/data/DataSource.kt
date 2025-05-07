package com.example.flightsearchapp.data

object DataSource {
    val airportList = listOf(
        Airport(id = 1, iataCode = "JFK", name = "John F. Kennedy International Airport", city = "New York", country = "United States"),
        Airport(id = 2, iataCode = "LAX", name = "Los Angeles International Airport", city = "Los Angeles", country = "United States"),
        Airport(id = 3, iataCode = "ORD", name = "O'Hare International Airport", city = "Chicago", country = "United States"),
        Airport(id = 4, iataCode = "CDG", name = "Charles de Gaulle Airport", city = "Paris", country = "France"),
        Airport(id = 5, iataCode = "LHR", name = "Heathrow Airport", city = "London", country = "United Kingdom"),
        Airport(id = 6, iataCode = "MEX", name = "Aeropuerto Internacional de la Ciudad de México", city = "Ciudad de México", country = "Mexico"),
        Airport(id = 7, iataCode = "YYZ", name = "Toronto Pearson International Airport", city = "Toronto", country = "Canada"),
        Airport(id = 8, iataCode = "HND", name = "Haneda Airport", city = "Tokyo", country = "Japan"),
        Airport(id = 9, iataCode = "ICN", name = "Incheon International Airport", city = "Seoul", country = "South Korea"),
        Airport(id = 10, iataCode = "DXB", name = "Dubai International Airport", city = "Dubai", country = "United Arab Emirates")
    )

    val flightList = listOf(
        Flight(id = 1, departureCode = "JFK", destinationCode = "LAX", departureTime = "08:00", arrivalTime = "11:00", price = 350.00),
        Flight(id = 2, departureCode = "LAX", destinationCode = "JFK", departureTime = "14:00", arrivalTime = "19:00", price = 400.00),
        Flight(id = 3, departureCode = "ORD", destinationCode = "JFK", departureTime = "09:30", arrivalTime = "12:30", price = 280.00),
        Flight(id = 4, departureCode = "CDG", destinationCode = "LHR", departureTime = "11:00", arrivalTime = "12:00", price = 120.00),
        Flight(id = 5, departureCode = "LHR", destinationCode = "CDG", departureTime = "15:00", arrivalTime = "16:00", price = 150.00),
        Flight(id = 6, departureCode = "MEX", destinationCode = "LAX", departureTime = "16:00", arrivalTime = "18:00", price = 300.00),
        Flight(id = 7, departureCode = "YYZ", destinationCode = "JFK", departureTime = "12:00", arrivalTime = "14:00", price = 250.00),
        Flight(id = 8, departureCode = "HND", destinationCode = "ICN", departureTime = "10:00", arrivalTime = "12:00", price = 200.00),
        Flight(id = 9, departureCode = "ICN", destinationCode = "HND", departureTime = "14:00", arrivalTime = "16:00", price = 220.00),
        Flight(id = 10, departureCode = "DXB", destinationCode = "LHR", departureTime = "18:00", arrivalTime = "23:00", price = 450.00),
        Flight(id = 11, departureCode = "JFK", destinationCode = "ORD", departureTime = "15:00", arrivalTime = "17:00", price = 320.00),
        Flight(id = 12, departureCode = "LAX", destinationCode = "MEX", departureTime = "09:00", arrivalTime = "13:00", price = 280.00),
        Flight(id = 13, departureCode = "ORD", destinationCode = "LAX", departureTime = "18:00", arrivalTime = "20:00", price = 380.00),
        Flight(id = 14, departureCode = "CDG", destinationCode = "JFK", departureTime = "09:00", arrivalTime = "14:00", price = 500.00),
        Flight(id = 15, departureCode = "LHR", destinationCode = "YYZ", departureTime = "13:00", arrivalTime = "17:00", price = 420.00),
        Flight(id = 16, departureCode = "MEX", destinationCode = "ORD", departureTime = "20:00", arrivalTime = "00:00", price = 310.00),
        Flight(id = 17, departureCode = "YYZ", destinationCode = "LHR", departureTime = "19:00", arrivalTime = "07:00", price = 480.00),
        Flight(id = 18, departureCode = "HND", destinationCode = "LAX", departureTime = "16:00", arrivalTime = "10:00", price = 600.00),
        Flight(id = 19, departureCode = "ICN", destinationCode = "JFK", departureTime = "22:00", arrivalTime = "22:00", price = 550.00),
        Flight(id = 20, departureCode = "DXB", destinationCode = "CDG", departureTime = "07:00", arrivalTime = "12:00", price = 400.00)
    )
}