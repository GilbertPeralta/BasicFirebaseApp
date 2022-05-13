package com.example.basicfirebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.reference


        //Escribir
        myRef.child("ejemplo").child("1").setValue(card("1", "rojo", "corazones"))
        myRef.child("ejemplo").child("2").setValue(card("2", "negro", "picas"))
        myRef.child("ejemplo").child("3").setValue(card("3", "rojo", "diamantes"))

        myRef.child("users").child("1").setValue(Users("Juan", "45", "1234567893"))
        myRef.child("users").child("2").setValue(Users("Ricardo", "25", "1202156325"))
        myRef.child("users").child("3").setValue(Users("Anna", "36", "3251479654"))
        myRef.child("users").child("4").setValue(Users("Martha", "28", "1245823021"))
        myRef.child("users").child("5").setValue(Users("Jose", "50", "0213546985"))


        //Leer
        myRef.child("ejemplo").child("2").get().addOnSuccessListener { response ->
            Log.d("firebaseResponse",response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }

        myRef.child("users").child("2").get().addOnSuccessListener { response ->
            Log.d("firebaseResponse2",response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse2", "Error getting data", it)
        }

    }
}