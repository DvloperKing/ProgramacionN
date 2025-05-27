package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    //propiedades val en la clase de datos Affirmation. Uno debe llamarse stringResourceId y el otro imageResourceId.
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int

)
