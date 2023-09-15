package com.example.androiddasar

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class IntentApp : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_app)

        // simple intent
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)

        btnMoveActivity.setOnClickListener {
            val moveIntent = Intent(this, MoveActivity::class.java)
            startActivity(moveIntent)
        }

        // intent with pass data
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)

        btnMoveWithDataActivity.setOnClickListener {
            val moveWithDataIntent = Intent(this, MoveWithDataActivity::class.java)
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy")
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
            startActivity(moveWithDataIntent)
        }

        // intent with pass object data
        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)

        btnMoveWithObject.setOnClickListener {
            val person = Person(
                "DicodingAcademy",
                5,
                "academy@dicoding.com",
                "Bandung"
            )
            val moveWithObjectIntent = Intent(this, MoveWithObjectActivity::class.java)
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)

            // mengirimkan array of object
            var persons = ArrayList<Person>()
            moveWithObjectIntent.putParcelableArrayListExtra(
                MoveWithObjectActivity.EXTRA_PERSONS,
                persons
            )

            startActivity(moveWithObjectIntent)
        }

        // implicit intent
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener {
            val phoneNumber = "081210841382"
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneIntent)
        }

        // get back pass data intent
        val btnMoveForResult:Button = findViewById(R.id.btn_move_for_result)
        tvResult = findViewById(R.id.tv_result)

        btnMoveForResult.setOnClickListener {
            val moveForResultIntent = Intent(this, MoveForResultActivity::class.java)
            resultLauncher.launch(moveForResultIntent)
        }
    }
}