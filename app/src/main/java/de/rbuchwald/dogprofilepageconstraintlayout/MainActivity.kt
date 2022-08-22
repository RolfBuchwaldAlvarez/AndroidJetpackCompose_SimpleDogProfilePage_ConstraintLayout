package de.rbuchwald.dogprofilepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.rbuchwald.dogprofilepage.composables.DogProfileCard
import de.rbuchwald.dogprofilepage.model.data.DogProfile
import de.rbuchwald.dogprofilepage.ui.theme.DogProfilePageTheme
import de.rbuchwald.dogprofilepageconstraintlayout.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogProfilePageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DogProfileCard(
                        imageId =  R.drawable.profile_robbi,
                        dogProfile = DogProfile(
                            "Robbi",
                            "Greek Mongrel",
                            "Germany",
                            "Most beautiful dog in the world",
                            "Robbi loves to go for a walk or to be lying in the sun. He gives you the 'mediteranian' dog vibe. You think he might not like you? Have some treats ready at hand and he certainly will fall in love with you!"
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDogProfileCard() {
    DogProfileCard(
        imageId = R.drawable.profile_robbi,
        dogProfile = DogProfile(
            "Robbi",
            "Greek Mongrel",
            "Germany",
            "Most beautiful dog in the world",
            "Robbi loves to go for a walk or to be lying in the sun. He gives you the 'mediteranian' dog vibe. You think he might not like you? Have some treats ready at hand and he certainly will fall in love with you!"
        )
    )
}