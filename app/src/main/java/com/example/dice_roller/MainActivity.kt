package com.example.dice_roller

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.dice_roller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

//        findViewById<Button>(R.id.buttonId).setOnClickListener{
//            addNickName(it);
//        }
        binding.buttonId.setOnClickListener{
            addNickName(it);
        }
    }

    private fun addNickName(view: View){
//        val editText = findViewById<EditText>(R.id.nickNameEditText)
//        val nickNameTextView = findViewById<TextView>(R.id.nickNameTextViewId)
        binding.apply {
            nickNameTextViewId.text = binding.nickNameEditText.text
            invalidateAll()
            nickNameEditText.visibility = View.GONE
            view.visibility = View.GONE
            nickNameTextViewId.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

//        editText.hideKeyBoard()

    }

}