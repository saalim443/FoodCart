package com.example.navigationapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.navigationapplication.ui.theme.NavigationApplicationTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

class UICheckActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.orange))
    ) {
        // Main content (images)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // First image (sidebar)
            Image(
                painter = painterResource(id = R.drawable.sidebar),
                contentDescription = "App Icon",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .padding(start = 5.dp, end = 5.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(5.dp))

            // Second image (artboard)
            Image(
                painter = painterResource(id = R.drawable.artboard),
                contentDescription = "App Icon",
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.weight(1f))
        }

        // Google Map that hovers on the screen with transparency
        val singapore = LatLng(1.35, 103.87)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(singapore, 10f)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp) // Adjust the height of the hovering map
                .align(Alignment.BottomCenter) // Position the map at the bottom center
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)) // Rounded top-left and top-right corners
                .background(Color.White.copy(alpha = 0.6f)) // Semi-transparent background

        ) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            )
        }



//fix this on here hower
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp) // Adjust the height of the box
                .align(Alignment.BottomCenter) // Position the box at the bottom center
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)) // Rounded top-left and top-right corners
                .background(Color.White.copy(alpha = 0.0f)) // Semi-transparent background
        ) {
            var search by remember { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), // Padding around the Row
                verticalAlignment = Alignment.CenterVertically // Align items vertically in the center
            ) {
                // OutlinedTextField with weight 2.5
                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it },
                    label = { Text("Search as per taste") }, // Label inside the field
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.search_icon), // Replace with your search icon resource
                            contentDescription = "Search Icon",
                            modifier = Modifier.size(24.dp) // Set size for the icon
                        )
                    },
                    modifier = Modifier
                        .weight(2.5f) // Weight for OutlinedTextField
                        .padding(end = 8.dp), // Add space between TextField and the icon
                    singleLine = true,
                    shape = RoundedCornerShape(280.dp)
                )


                // Card to hold the image icon with rounded corners
                Card(
                    modifier = Modifier
                        .weight(0.5f) // Weight for the image card
                        .size(50.dp) // Set size for the card
                        .padding(start = 8.dp), // Add space on the left of the card
                    shape = RoundedCornerShape(50.dp) // Set corner radius for the card
                ) {
                    // Image icon for scanning with an orange background
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFFFA500)), // Set the background color to orange
                        contentAlignment = Alignment.Center // Center the image in the box
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.scan), // Replace with your scan icon resource
                            contentDescription = "Scan Icon",
                            modifier = Modifier
                                .height(30.dp)
                                .width(35.dp), // Fill the box
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }


        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp) // Adjust the height of the hovering map
                .align(Alignment.BottomCenter) // Position the map at the bottom center
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)) // Rounded top-left and top-right corners
                .background(Color.White) // Semi-transparent background
        ) {


        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationApplicationTheme {
        Greeting("Android")
    }
}
