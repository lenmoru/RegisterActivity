package com.example.registeractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var text: EditText? = null
    var spinner: Spinner? = null
    var email: EditText? = null
    var telepon: EditText? = null
    var alamat: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text)
        spinner = findViewById(R.id.spinner)
        email = findViewById(R.id.email)
        telepon = findViewById(R.id.telepon)
        alamat = findViewById(R.id.alamat)

        button.setOnClickListener {
            validasiinput()
        }
        setDataSpinner()
    }

    fun setDataSpinner() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.gender_list, android.R.layout.simple_spinner_dropdown_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner?.adapter=adapter
    }

    fun validasiinput() {
        val textInput: String = text?.text.toString()
        val emailInput: String = email?.text.toString()
        val teleponInput: String = telepon?.text.toString()
        val alamatInput: String = alamat?.text.toString()
        val genderInput: String = spinner?.selectedItem.toString()

        when {
            genderInput.equals("Pilih jenbis kelamin") ->
                Toast.makeText(this, "Kelamin harus dipilih", Toast.LENGTH_SHORT).show()
            textInput.isEmpty() -> text?.error = "Nama tidak boleh kosong"
            emailInput.isEmpty() -> email?.error = "Nama tidak boleh kosong"
            teleponInput.isEmpty() -> telepon?.error = "Nama tidak boleh kosong"
            alamatInput.isEmpty() -> alamat?.error = "Nama tidak boleh kosong"

            else -> {
                Toast.makeText(this, "Data berhasil terkirim", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
