package com.example.androiddasar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IntentApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_app)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)

        btnMoveActivity.setOnClickListener {
            val moveIntent = Intent(this, MoveActivity::class.java)
            startActivity(moveIntent)
        }

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)

        btnMoveWithDataActivity.setOnClickListener {

        }
    }
}