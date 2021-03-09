package br.com.listasimples

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.paperdb.Paper
import kotlin.collections.ArrayList


class Home : AppCompatActivity() {

    var mExampleList: ArrayList<PlayerGame> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Paper.init(this)

        val sharedPreferences: SharedPreferences = getPreferences(Context.MODE_PRIVATE)


        //VARIAVEIS DOS NOMES
        var username = intent.getStringExtra(ConstantsPlayers.USER_NAME)
        var userpoints = intent.getStringExtra(ConstantsPlayers.USER_POINTS)

        //AQUI O TEXTO DA TELA
        var texto_home = findViewById<TextView>(R.id.tv_score)
        texto_home.text = "${username.toString()} e tambem o ${userpoints.toString()}"

        val arrayAdapter: ArrayAdapter<*>
        val listaPlayers: MutableList<PlayerGame> = mutableListOf()


        listaPlayers.imprimeComMarcadores()
        if (userpoints != null) {
            listaPlayers.add(
                PlayerGame(
                    name = username.toString(),
                    position = userpoints.toLong()
                )
            )
            saveData()
        }
        listaPlayers.imprimeComMarcadores()

        var listaGames: MutableList<String> = Paper.book().allKeys

        println("LIST PLAYERS = $listaPlayers")

        println("AQUI O LOAD DATA = ${loadData()}")



        val ordenadoPositions: List<PlayerGame> = listaPlayers.sorted().takeLast(5).reversed()
        ordenadoPositions.imprimeComMarcadores()

//        for (indice in jogadores.indices) {
//            var positions = jogadores[indice].name
//            println("POSITIONS >>> $positions")
//            return jogadores[indice].name.toList()
//        }


        var mListView = findViewById<ListView>(R.id.userlist)

        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, listaPlayers
        )

        mListView.adapter = arrayAdapter

//        println("ARRAYADAPTER DA listinhaaa >>>>> ${listinha!!.toList()}")

    }

        fun List<PlayerGame>.imprimeComMarcadores() {
        val textoFormatado = this.joinToString(separator = "\n") {
            " ->    ${it.name} - ${it.position}"
        }
        println("##LISTA DE LIVROS## \n$textoFormatado\n")
    }

    class StoreManager(_context: Context) {
        private val editor: SharedPreferences.Editor
        private val _context: Context
        var pref: SharedPreferences
        private val PRIVATE_MODE = 0
        fun setToken(Token: String) {
            editor.putString("Token", Token)
            println("token saved $Token")
            editor.commit()
        }

        val token: String?
            get() = pref.getString("Token", "")

        companion object {
            private const val PREF_NAME = "_store"
        }

        init {
            this._context = _context
            pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
            editor = pref.edit()
        }
    }

    private fun loadData() {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("shared", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("task list", null)
        val type = object : TypeToken<ArrayList<PlayerGame>>() {}.type

        mExampleList = gson.fromJson(json, type)

        if (mExampleList == null){
            mExampleList = ArrayList()
        }
    }

    fun saveData(){
        val sharedPreferences: SharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(mExampleList)
        editor.putString("task list", json)
        editor.apply()
        println("AQUI O SAVE $json")
    }
}


//fun addPlayers(): MutableList<PlayerGame> {
//    val players: MutableList<PlayerGame> = mutableListOf()
//
//
//    println("LISTA DOS GAMES" + players[0].name)
//    var zero = 0
//    for (i in players) {
//        println("ITEM " + zero + " " + players[zero].position)
//        zero++
//    }
//
//    return players
//
//}


