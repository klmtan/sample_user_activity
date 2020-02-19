package com.example.useractivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_submit).setOnClickListener{
                addNickname(it)
        }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener{
                updateNickname(it)
        }
    }

    private fun addNickname(view: View){
        val editTextView = findViewById<EditText>(R.id.nickname_edit)
        val nicknameView = findViewById<TextView>(R.id.nickname_text)

        editTextView.requestFocus()
        nicknameView.text = editTextView.text
        editTextView.visibility = View.GONE
        nicknameView.visibility = View.VISIBLE
        view.visibility = View.GONE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View){
        val editTextView = findViewById<EditText>(R.id.nickname_edit)
        val doneBtn = findViewById<Button>(R.id.btn_submit)

        editTextView.visibility = View.VISIBLE
        doneBtn.visibility = View.VISIBLE
        view.visibility = View.GONE
    }
}
