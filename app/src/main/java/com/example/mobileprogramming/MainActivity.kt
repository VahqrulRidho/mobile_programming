package com.example.mobileprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

//    deklarasi variable
    private lateinit var panjang: EditText
    private lateinit var lebar: EditText
    private lateinit var tinggi: EditText
    private lateinit var btn: Button
    private lateinit var result: TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        inisialisasi variable
        panjang = findViewById(R.id.edt_length)
        lebar = findViewById(R.id.edt_width)
        tinggi = findViewById(R.id.edt_height)
        btn = findViewById(R.id.btn_result)
        result = findViewById(R.id.result)

        btn.setOnClickListener (this)

        if(savedInstanceState != null){
            result.text = savedInstanceState.getString(STATE_RESULT)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    outState.putString(STATE_RESULT, result.text.toString())
    }

    override fun onClick(v: View?) {
        if(v?.id==R.id.btn_result){
            var t = tinggi.text.toString().trim()
            var p = panjang.text.toString().trim()
            var l = lebar.text.toString().trim()

            var isEmpaty = false
            if(t.isEmpty()){
                isEmpaty = true
                tinggi.error = "Ang isi lah dulu"
            }

            if(p.isEmpty()){
                isEmpaty = true
                panjang.error = "Ang isi lah dulu"
            }

            if(l.isEmpty()){
                isEmpaty = true
                lebar.error = "Ang isi lah dulu"
            }

            if (!isEmpaty){
                var volume = t.toDouble() * p.toDouble() * l.toDouble()
                result.text = volume.toString()
            }


        }
    }
}