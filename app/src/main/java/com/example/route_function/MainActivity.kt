package com.example.route_function

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.route_function.ui.theme.Route_functionTheme
//
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Mapbox.getInstance(applicationContext, "YOUR_MAPBOX_ACCESS_TOKEN")
        setContent {
            Route_functionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HarborRoutingScreen()
                }
            }
        }
    }
}


@Composable
fun HarborRoutingScreen() {
    var longitude by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }

    var displayResults by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter // Align the content at the bottom of the screen
    ) {
        // Display user inputs in the second Box
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray) // Background color for the map
        ) {
            // Display user inputs and results
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                // Display longitude and latitude entered by the user
                Text("Longitude: $longitude")
                Text("Latitude: $latitude")

                if (displayResults) {
                    // Display the results when the button is clicked
                    Text("Result: Longitude - $longitude, Latitude - $latitude")

                }
            }
        }

        // Input fields and button
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFF0072FF), Color(0xFF00C6FF))
                    )
                )
                .padding(16.dp)
                .height(IntrinsicSize.Min),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            BasicTextField(
                value = longitude,
                onValueChange = { text: String -> longitude = text },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray) // Change the background color here

            )

            BasicTextField(
                value = latitude,
                onValueChange = { text: String -> latitude = text },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray) // Change the background color here

            )

            Button(
                onClick = {
                    // Handle the button click, e.g., trigger the routing process.
                    displayResults = true
                }
            ) {
                Text(text = "Create Route")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HarborRoutingScreenPreview() {
    Route_functionTheme {
        var longitude by remember { mutableStateOf("") }
        var latitude by remember { mutableStateOf("") }
        var displayResults by remember { mutableStateOf(false) }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HarborRoutingScreen()
        }
    }
}