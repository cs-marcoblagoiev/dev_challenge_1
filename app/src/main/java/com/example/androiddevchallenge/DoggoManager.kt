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

class DoggoManager {
    val doggoList: MutableList<Doggo>

    init {
        doggoList = ArrayList()
        doggoList.add(Doggo(0, "Cookie", 2, "https://i.imgur.com/oo67PIH.jpg", "Pizza"))
        doggoList.add(Doggo(1, "Bandit", 1, "https://i.imgur.com/jl4Oje0.jpg", "Hamburgers"))
        doggoList.add(Doggo(2, "Lucky", 1, "https://i.imgur.com/kzTTvMI.jpeg", "All treats"))
        doggoList.add(Doggo(3, "Peanut", 4, "https://i.imgur.com/7S3NAHs.jpeg", "Bones"))
        doggoList.add(Doggo(4, "Thor", 5, "https://i.imgur.com/Gg4jxJ3.jpeg", "Meatballs"))
        doggoList.add(Doggo(5, "Ella", 3, "https://i.imgur.com/LI44M9n.jpeg", "Watermelon"))
        doggoList.add(Doggo(6, "Brutus", 1, "https://i.imgur.com/G4byIo1.jpeg", "Bananas"))
        doggoList.add(Doggo(7, "Minnie", 1, "https://i.imgur.com/VaA1YdA.jpeg", "Peanut butter"))
        doggoList.add(Doggo(8, "Noodles", 2, "https://i.imgur.com/ZV5kWcf.jpeg", "Noodles"))
    }

    fun getAllDoggos(): MutableList<Doggo> {
        return doggoList
    }

    fun getDoggoById(id: Int): Doggo {
        return doggoList.get(id)
    }
}
