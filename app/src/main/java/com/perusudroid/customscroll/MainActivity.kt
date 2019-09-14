package com.perusudroid.customscroll

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.core.widget.NestedScrollView


class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var scrollView : NestedScrollView
    private lateinit var btnAdd : Button
    private lateinit var btnSubmit : Button
    private lateinit var uiLL : LinearLayout
    private var linearLayouts : ArrayList<String>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        setAssets()
    }

    private fun setAssets() {
        btnSubmit.setOnClickListener(this)
        btnAdd.setOnClickListener(this)
    }

    private fun bindViews() {
        scrollView = findViewById(R.id.scrollView)
        uiLL = findViewById(R.id.ll)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubmit = findViewById(R.id.btnSubmit)
    }

    override fun onClick(v: View?) {
       when(v?.id){
           R.id.btnSubmit->{
               linearLayouts?.clear()
               for (child in uiLL.children) {
                   val etNum = child.findViewById<EditText>(R.id.etNumber)
                   if(etNum.text.isNotEmpty()){
                       linearLayouts?.add(etNum.text.toString())
                   }
               }

               startActivity(Intent(this, RecyclerActivity::class.java).putExtra("data", linearLayouts))
           }

           R.id.btnAdd->{
               addLayout()
           }
       }
    }


    private fun addLayout() {

        val layout2 = LayoutInflater.from(this).inflate(R.layout.inflater_scroll, uiLL, false)

        val textView = layout2.findViewById(R.id.tvMobile) as TextView
        val ivRemove = layout2.findViewById(R.id.ivRemove) as ImageView
        val etNumber = layout2.findViewById(R.id.etNumber) as EditText

        textView.text = getString(R.string.mobile)

        uiLL.addView(layout2)

        ivRemove.setOnClickListener {
            uiLL.removeView(layout2)
        }

        etNumber.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

                if(s?.length!! > 0 && s.length <2){
                    addLayout()
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }
}
