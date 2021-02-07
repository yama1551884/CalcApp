package com.example.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.google.android.material.snackbar.Snackbar;

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (editText1.text.isEmpty() || editText2.text.isEmpty()) {
            Snackbar.make(v!!, "数値を入力してください", Snackbar.LENGTH_LONG).show()
            return
        } else if (editText1.text.toString() == "." || editText2.text.toString() == ".") {
            Snackbar.make(v!!, "数値を入力してください", Snackbar.LENGTH_LONG).show()
            return
        } else if (v!!.id == R.id.button4 && editText2.text.toString() == "0") {
            Snackbar.make(v!!, "0で割ることはできません", Snackbar.LENGTH_LONG).show()
            return
        }

        var e: Double = 0.0

        var a = editText1.text.toString()
        var b = a.toDouble()
        var c = editText2.text.toString()
        var d = c.toDouble()

        when (v!!.id) {
            R.id.button1 -> e = b + d
            R.id.button2 -> e = b - d
            R.id.button3 -> e = b * d
            R.id.button4 -> e = b / d
        }

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("VALUE1", e)
        startActivity(intent)
    }
}