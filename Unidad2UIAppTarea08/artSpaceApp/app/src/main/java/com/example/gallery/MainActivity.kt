package com.example.gallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            galleryLayout()
        }
    }
}

data class image(val image: Int, val description: String, val author: String)

@Composable fun galleryLayout(){
    val images=mutableListOf(
        image(R.drawable.image1, "Image 1", "Author 1"),
        image(R.drawable.image2, "Image 2", "Author 2"),
        image(R.drawable.image3, "Image 3", "Author 3"),
    )

    var currentImageIndex by remember { mutableStateOf(0) }
    val currentImage=images[currentImageIndex]
    Column(modifier = Modifier.fillMaxSize().background(Color.White).padding(16.dp),
           verticalArrangement = Arrangement.SpaceBetween,
           horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.height(24.dp))
        Image(painter = painterResource(id=currentImage.image),
              contentDescription = currentImage.description,
              modifier = Modifier.fillMaxWidth().weight(1f).padding(16.dp),
              contentScale = ContentScale.Fit)
        Text(currentImage.description)
        Text(currentImage.author)
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)){
            Button(onClick = { currentImageIndex=(currentImageIndex-1+images.size)%images.size }){
                Text("Previous")
            }
            Spacer(Modifier.width(16.dp))
            Button(onClick = { currentImageIndex=(currentImageIndex+1)%images.size }){
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true) @Composable fun preview(){
    galleryLayout()
}