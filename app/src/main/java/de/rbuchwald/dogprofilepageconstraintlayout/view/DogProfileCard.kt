package de.rbuchwald.dogprofilepage.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import de.rbuchwald.dogprofilepage.model.data.DogProfile

@Composable
fun DogProfileCard(
    imageId: Int,
    imageSize: Int = 140,
    border: Double = 1.5,
    dogProfile: DogProfile
) {

    var followers by remember { mutableStateOf(20768) }
    var following by remember { mutableStateOf(345) }
    var likes by remember { mutableStateOf(54678) }



    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        var (card, buttonFollowers, buttonFollowing, spacer, buttonLikes) = createRefs()
        // val horizontalChain = createHorizontalChain(followersButton, followingButton)

        Card(
            elevation = 6.dp,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            ConstraintLayout {

                val (image, textName, textBreed, textCountry, rowStats, header, body) = createRefs()

                Image(
                    painter = painterResource(imageId),
                    contentDescription = "Dog Profile",
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .size(imageSize.dp)
                        .clip(CircleShape)
                        .border(border.dp, color = Color.Gray, CircleShape)
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
                Text(
                    dogProfile.name,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(color = Color.Gray),
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 5.dp)
                        .constrainAs(textName) {
                        top.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )
                Text(
                    dogProfile.breed,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .constrainAs(textBreed) {
                        top.linkTo(textName.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )
                Text(
                    dogProfile.country,
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .constrainAs(textCountry) {
                        top.linkTo(textBreed.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 20.dp)
                        .constrainAs(rowStats) {
                            top.linkTo(textCountry.bottom)
                        }
                ) {
                    DogProfileStats(amount = followers.toString(), text = "Followers")
                    DogProfileStats(amount = following.toString(), text = "Following")
                    DogProfileStats(amount = likes.toString(), text = "Likes")
                }
                Text(
                    text = dogProfile.headText,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(color = Color.Gray),
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 10.dp)
                        .constrainAs(header) {
                        top.linkTo(rowStats.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )
                Text(
                    text = dogProfile.bodyText,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(start = 30.dp, top = 10.dp, end = 30.dp, bottom = 50.dp)
                        .constrainAs(body) {
                            top.linkTo(header.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
            }
        }
        Button(
            onClick = { followers++ },
            modifier = Modifier.constrainAs(buttonFollowers) {
                top.linkTo(card.bottom)
                start.linkTo(parent.start)
                end.linkTo(buttonFollowing.start)
                bottom.linkTo(spacer.top)
            }
        ) {
            Text(text = "Add followers")
        }
        Button(
            onClick = { following++ },
            modifier = Modifier.constrainAs(buttonFollowing) {
                top.linkTo(card.bottom)
                start.linkTo(buttonFollowers.end)
                end.linkTo(parent.end)
                bottom.linkTo(spacer.top)
            }
        ) {
            Text(text = "Add following")
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .constrainAs(spacer) {
                    top.linkTo(card.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
        Button(
            onClick = { likes++ },
            modifier = Modifier.constrainAs(buttonLikes) {
                top.linkTo(spacer.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(text = "Add likes")
        }
    }
}
