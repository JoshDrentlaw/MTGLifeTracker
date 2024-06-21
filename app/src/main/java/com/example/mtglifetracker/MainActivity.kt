package com.example.mtglifetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mtglifetracker.ui.theme.MTGLifeTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MTGLifeTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Tracker()
                }
            }
        }
    }
}

@Composable
fun Tracker(modifier: Modifier = Modifier) {
    Column (
        modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.teal_200))
    ) {
        LifeBox(modifier)
        LifeBox(modifier = modifier)
    }
}

@Composable
fun LifeBox(modifier: Modifier) {
    Column (
        modifier
            .background(colorResource(id = R.color.black))
            .fillMaxWidth()
            .fillMaxHeight(0.5f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            var life by remember { mutableIntStateOf(value = 0) }

            Column (
                modifier.clickable(onClick = { life-- }),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "-", color = colorResource(R.color.white), fontSize = 75.sp)
            }
            Spacer(modifier = modifier.width(15.dp))
            Column (
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = life.toString(), color = colorResource(R.color.white), fontSize = 200.sp)
            }
            Spacer(modifier = modifier.width(10.dp))
            Column (
                modifier.clickable(onClick = { life++ }),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "+", color = colorResource(R.color.white), fontSize = 75.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrackerPreview() {
    MTGLifeTrackerTheme {
        Tracker()
    }
}