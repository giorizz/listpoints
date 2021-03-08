package br.com.listasimples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class initial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)

        val arrayAdapter: ArrayAdapter<*>

        val listaPlayers: MutableList<PlayerGame> = mutableListOf(
            PlayerGame(
                name = "Bah",
                position = 12
            ),
            PlayerGame(
                name = "Gi",
                position = 43
            ),
            PlayerGame(
                name = "Du",
                position = 34
            ),
            PlayerGame(
                name = "Pati",
                position = 12
            ),
            PlayerGame(
                name = "Julio",
                position = 67
            ),
            PlayerGame(
                name = "Mae",
                position = 78
            ),
            PlayerGame(
                name = "Dr",
                position = 64
            ), PlayerGame(
                name = "Pri",
                position = 12
            )
        )

//        val jogadores = mutableListOf(
//                player1, player2, player3, player4, player5, player6, player8, player7
//        )

        listaPlayers.imprimeComMarcadores()

        listaPlayers.add(
            PlayerGame(
                name = "Chucru",
                position = 99
            )
        )

        listaPlayers.imprimeComMarcadores()


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
            android.R.layout.simple_list_item_1, ordenadoPositions
        )
        mListView.adapter = arrayAdapter

        println("aqui a LISTA FINAL ${ordenadoPositions}")



    }

//    fun maiores(jogadores: MutableList<PlayerGame>){
//        for (indice in jogadores.indices) {
//            var positions = jogadores[indice].name
//            println("POSITIONS >>> $positions")
//        }
//    }

}


fun addPlayers(): MutableList<PlayerGame> {
    val players: MutableList<PlayerGame> = mutableListOf()


    println("LISTA DOS GAMES" + players[0].name)
    var zero = 0
    for (i in players) {
        println("ITEM " + zero + " " + players[zero].position)
        zero++
    }

    return players

}


fun List<PlayerGame>.imprimeComMarcadores() {
    val textoFormatado = this.joinToString(separator = "\n") {
        " ->    ${it.name} - ${it.position}"
    }
    println("##LISTA DE LIVROS## \n$textoFormatado\n")
}

//val salarios = mutableListOf<PlayerGame>//todo seguir com idle
