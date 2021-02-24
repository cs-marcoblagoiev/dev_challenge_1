/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    ImageList()
}

@Composable
fun ImageList() {
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()

    val doggoList: MutableList<Doggo> = ArrayList()
    doggoList.add(Doggo("Cookie", 2, "https://i.imgur.com/oo67PIH.jpg", "Pizza"))
    doggoList.add(Doggo("Bandit", 1, "https://i.imgur.com/jl4Oje0.jpg", "Hamburgers"))
    doggoList.add(Doggo("Lucky", 1, "https://i.imgur.com/kzTTvMI.jpeg", "All treats"))
    doggoList.add(Doggo("Peanut", 4, "https://i.imgur.com/7S3NAHs.jpeg", "Bones"))
    doggoList.add(Doggo("Thor", 5, "https://i.imgur.com/Gg4jxJ3.jpeg", "Meatballs"))
    doggoList.add(Doggo("Ella", 3, "https://i.imgur.com/LI44M9n.jpeg", "Watermelon"))
    doggoList.add(Doggo("Brutus", 1, "https://i.imgur.com/G4byIo1.jpeg", "Bananas"))
    doggoList.add(Doggo("Minnie", 1, "https://i.imgur.com/VaA1YdA.jpeg", "Peanut butter"))
    doggoList.add(Doggo("Noodles", 2, "https://i.imgur.com/ZV5kWcf.jpeg", "Noodles"))

    LazyColumn(Modifier.fillMaxWidth()) {
        items(doggoList) { doggo ->
            ImageListItem(doggo = doggo)
        }
    }
}

@Composable
fun ImageListItem(doggo: Doggo) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        CoilImage(
            data = doggo.photo,
            contentDescription = doggo.name,
            modifier = Modifier.size(100.dp).padding(6.dp),
            fadeIn = true
        )
        Spacer(Modifier.width(10.dp))
        Text(doggo.name, style = MaterialTheme.typography.h4)
    }
}

@Preview("Light Theme", widthDp = 660, heightDp = 1040)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

/*@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}*/
