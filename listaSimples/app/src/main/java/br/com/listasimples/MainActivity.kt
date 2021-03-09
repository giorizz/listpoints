package br.com.listasimples


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_save = findViewById<Button>(R.id.btn_salva)
        val et_nome = findViewById<EditText>(R.id.txt_nome)
        val et_pos = findViewById<EditText>(R.id.txt_pos)

        //crio id, nome e pontos
        //salvo o id --- com nome e pontos em JSON

        btn_save.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            intent.putExtra(ConstantsPlayers.USER_NAME, et_nome.text.toString())
            intent.putExtra(ConstantsPlayers.USER_POINTS, et_pos.text.toString())
            startActivity(intent)
        }
    }
}
