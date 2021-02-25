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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
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
    val navController = rememberNavController()
    val manager = DoggoManager()
    NavHost(navController, startDestination = "list") {
        composable("list") { ImageList(navHostController = navController, manager = manager) }

        composable(
            "details/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) { backStackEntry ->
            DoggoDetails(manager = manager, id = backStackEntry.arguments?.getInt("id")!!)
        }
    }
}

@Composable
fun ImageList(navHostController: NavHostController, manager: DoggoManager) {
    val doggoList = manager.getAllDoggos()

    LazyColumn(Modifier.fillMaxWidth()) {
        items(doggoList) { doggo ->
            ImageListItem(doggo = doggo, navHostController = navHostController)
        }
    }
}

@Composable
fun ImageListItem(doggo: Doggo, navHostController: NavHostController) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        CoilImage(
            data = doggo.photo,
            contentDescription = doggo.name,
            modifier = Modifier
                .size(100.dp)
                .padding(6.dp)
                .clickable(onClick = { navHostController.navigate("details/${doggo.id}") }),
            fadeIn = true
        )
        Spacer(Modifier.width(10.dp))
        Text(doggo.name, style = MaterialTheme.typography.h4)
    }
}

@Composable
fun DoggoDetails(manager: DoggoManager, id: Int) {
    val doggo = manager.getDoggoById(id)

    Column {
        CoilImage(
            data = doggo.photo,
            contentDescription = doggo.name,
            modifier = Modifier
                .size(300.dp)
                .padding(16.dp),
            fadeIn = true
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = doggo.name,
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Age: ${doggo.age}",
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Favorite snack: ${doggo.favoriteSnacks}",
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        )
        Spacer(Modifier.height(10.dp))
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
