package com.dafa.challenge_synrgy

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchBox: EditText
    private lateinit var searchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchBox = findViewById(R.id.searchBox)
        searchButton = findViewById(R.id.searchButton)

        // Menampilkan daftar huruf abjad A-Z menggunakan RecyclerView
        val alphabetList = ('A'..'Z').map { it.toString() }
        val adapter = AlphabetAdapter(alphabetList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 5) // Tampilkan dalam bentuk grid

        searchButton.setOnClickListener {
            val searchText = searchBox.text.toString()
            if (searchText.isNotEmpty()) {
                val searchUrl = "https://www.google.com/search?q=$searchText"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Masukkan kata untuk dicari", Toast.LENGTH_SHORT).show()
            }
        }
    }
}