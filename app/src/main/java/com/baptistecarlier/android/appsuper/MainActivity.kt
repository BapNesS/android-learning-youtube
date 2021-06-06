package com.baptistecarlier.android.appsuper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

var currentScreen = Screen.Connexion

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initScreen(currentScreen)
    }

    private fun initScreen(screen: Screen) {
        currentScreen = screen
        when ( screen ) {
            Screen.Connexion -> { screenConnexion() }
            Screen.Home -> { screenHome() }
            Screen.Profile -> { screenProfile() }
        }
    }

    private fun screenConnexion() {
        setContentView(R.layout.activity_main_linear)
        // init Listeners
        findViewById<Button>(R.id.btn_connexion)?.setOnClickListener {
            // Ugly but working
            val emailView = findViewById<EditText>(R.id.email)
            val password = findViewById<EditText>(R.id.password)

            if ( emailView?.text.isNullOrEmpty() ) {
                emailView.error = "Ne pas laisser vide"
            } else {
                password.error = null
            }

            if ( password?.text.isNullOrEmpty() ) {
                password.error = "Ne pas laisser vide"
            } else {
                password.error = null
            }

            if ( emailView?.text?.isNotEmpty() == true && password?.text?.isNotEmpty() == true) {
                initScreen(Screen.Home)
            }
        }
    }

    private fun screenHome() {
        setContentView(R.layout.activity_main_constraint)
        // init Listeners
        findViewById<ImageView>(R.id.picture)?.setOnClickListener {
            initScreen(Screen.Profile)
        }
    }

    private fun screenProfile() {
        setContentView(R.layout.activity_main_relative)
        findViewById<Button>(R.id.back)?.setOnClickListener {
            initScreen(Screen.Home)
        }
        findViewById<Button>(R.id.github)?.setOnClickListener {
            Toast.makeText(this, "Ouvrir GitHub", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.youtube)?.setOnClickListener {
            Toast.makeText(this, "Ouvrir YouTube", Toast.LENGTH_SHORT).show()
        }
    }
}

enum class Screen {
    Connexion,
    Home,
    Profile
}