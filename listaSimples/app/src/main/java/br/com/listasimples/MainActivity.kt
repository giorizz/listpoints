package br.com.listasimples

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_save = findViewById<Button>(R.id.btn_salva)

        btn_save.setOnClickListener {

            val intent = Intent(this, Home::class.java)
                println("$intent")
                intent.putExtra(ConstantsPlayers.USER_NAME, R.id.txt_nome.toString())
                intent.putExtra(ConstantsPlayers.USER_POINTS, R.id.position)
            startActivity(intent)
            finish()
        }
    }
}
