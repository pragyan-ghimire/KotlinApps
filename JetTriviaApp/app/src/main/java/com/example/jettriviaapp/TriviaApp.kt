package com.example.jettriviaapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//for allowing hilt to bind everything and modification in manifest too(adding android: name)
@HiltAndroidApp
class TriviaApp: Application() {
}