package com.perusudroid.customscroll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        bindViews()
        setAssets()
    }

    private fun bindViews() {
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun setAssets() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        intent.extras?.getStringArrayList("data").let {
            recyclerView.adapter = it?.let { it1 -> CustomAdapter(it1) }
        }
    }


}
