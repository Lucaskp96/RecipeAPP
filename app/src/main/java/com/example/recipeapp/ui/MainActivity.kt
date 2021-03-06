package com.example.recipeapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.recipeapp.R
import com.example.recipeapp.R.id
import com.google.firebase.auth.FirebaseAuth
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult


class MainActivity : AppCompatActivity() {
    private var firebaseAuth: FirebaseAuth?=null
    private var callbackManager: CallbackManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FacebookSdk.sdkInitialize(applicationContext)

        setContentView(R.layout.main_activity)

        val btnFacebookLogin = findViewById<Button>(id.btn_facebook_login)

        firebaseAuth = FirebaseAuth.getInstance()

        btnFacebookLogin.setOnClickListener {
            callbackManager = CallbackManager.Factory.create()
            LoginManager.getInstance()
                .logInWithReadPermissions(this, listOf("public_profile", "email"))
                LoginManager.getInstance().registerCallback(
                    callbackManager,
                    object : FacebookCallback<LoginResult> {
                        override fun onSuccess(result: LoginResult) {
                            Log.d("MainActivity", "Facebook token: " + result.accessToken.token)
                            startActivity(
                                Intent(
                                    applicationContext,
                                    HomeActivity::class.java
                                )
                            )
                        }

                        override fun onCancel() {
                            Log.d("MainActivity", "Facebook onCancel.")
                        }

                        override fun onError(error: FacebookException?) {
                            Log.d("MainActivity", "Facebook onError.")
                        }

                    })
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (callbackManager!!.onActivityResult(requestCode, resultCode, data)) {
            return
        } else {
            print("Error.")
        }
    }
}


