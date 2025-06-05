/*
 * Copyright (C) 2023 The Android Open Source Project
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

// Indica el paquete al que pertenece este archivo
package com.example.unscramble.data

// Constante que indica el número máximo de palabras por juego
const val MAX_NO_OF_WORDS = 10

// Constante que indica cuántos puntos se suman al acertar una palabra
const val SCORE_INCREASE = 20

// Conjunto (Set) inmutable que contiene todas las palabras posibles que se usarán en el juego
// Las palabras están desordenadas al usuario para que las descubra (Unscramble)
val allWords: Set<String> =
    setOf(
        // Palabras que comienzan con la letra A
        "animal",
        "auto",
        "anecdote",
        "alphabet",
        "all",
        "awesome",
        "arise",

        // Palabras con B
        "balloon",
        "basket",
        "bench",
        "best",
        "birthday",
        "book",
        "briefcase",

        // Palabras con C
        "camera",
        "camping",
        "candle",
        "cat",
        "cauliflower",
        "chat",
        "children",
        "class",
        "classic",
        "classroom",
        "coffee",
        "colorful",
        "cookie",
        "creative",
        "cruise",

        // Palabras con D
        "dance",
        "daytime",
        "dinosaur",
        "doorknob",
        "dine",
        "dream",
        "dusk",

        // Palabras con E
        "eating",
        "elephant",
        "emerald",
        "eerie",
        "electric",

        // Palabras con F
        "finish",
        "flowers",
        "follow",
        "fox",
        "frame",
        "free",
        "frequent",
        "funnel",

        // Palabras con G
        "green",
        "guitar",
        "grocery",
        "glass",
        "great",
        "giggle",

        // Palabras con H
        "haircut",
        "half",
        "homemade",
        "happen",
        "honey",
        "hurry",
        "hundred",

        // Palabras con I
        "ice",
        "igloo",
        "invest",
        "invite",
        "icon",
        "introduce",

        // Palabras con J
        "joke",
        "jovial",
        "journal",
        "jump",
        "join",

        // Palabras con K
        "kangaroo",
        "keyboard",
        "kitchen",
        "koala",
        "kind",
        "kaleidoscope",

        // Palabras con L
        "landscape",
        "late",
        "laugh",
        "learning",
        "lemon",
        "letter",
        "lily",

        // Palabras con M
        "magazine",
        "marine",
        "marshmallow",
        "maze",
        "meditate",
        "melody",
        "minute",
        "monument",
        "moon",
        "motorcycle",
        "mountain",
        "music",

        // Palabras con N
        "north",
        "nose",
        "night",
        "name",
        "never",
        "negotiate",
        "number",

        // Palabras con O
        "opposite",
        "octopus",
        "oak",
        "order",
        "open",

        // Palabras con P
        "polar",
        "pack",
        "painting",
        "person",
        "picnic",
        "pillow",
        "pizza",
        "podcast",
        "presentation",
        "puppy",
        "puzzle",

        // Palabras con R
        "recipe",
        "release",
        "restaurant",
        "revolve",
        "rewind",
        "room",
        "run",

        // Palabras con S
        "secret",
        "seed",
        "ship",
        "shirt",
        "should",
        "small",
        "spaceship",
        "stargazing",
        "skill",
        "street",
        "style",
        "sunrise",

        // Palabras con T
        "taxi",
        "tidy",
        "timer",
        "together",
        "tooth",
        "tourist",
        "travel",
        "truck",

        // Palabras con U
        "under",
        "useful",
        "unicorn",
        "unique",
        "uplift",
        "uniform",

        // Palabras con V
        "vase",
        "violin",
        "visitor",
        "vision",
        "volume",
        "view",

        // Palabras con W
        "walrus",
        "wander",
        "world",
        "winter",
        "well",
        "whirlwind",

        // Palabras con X
        "x-ray",
        "xylophone",

        // Palabras con Y
        "yoga",
        "yogurt",
        "yoyo",
        "you",
        "year",
        "yummy",

        // Palabras con Z
        "zebra",
        "zigzag",
        "zoology",
        "zone",
        "zeal"
    )
