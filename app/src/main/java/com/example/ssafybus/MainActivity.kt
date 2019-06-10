package com.example.ssafybus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_new_route.setOnClickListener{
            val intent = Intent(this, NewRouteActivity::class.java)
            startActivity(intent)
        }

        btn_route_list.setOnClickListener {
            Toast.makeText(this, "route list", Toast.LENGTH_SHORT).show()
        }
    }
}
