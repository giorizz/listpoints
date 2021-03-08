package br.com.listasimples

fun listaPlayers(jogadores: PlayerGame){
    val player1 = PlayerGame(
            name = "Bah",
            position = 12
    )

    val player2 = PlayerGame(
            name = "Gi",
            position = 43
    )

    val player3 = PlayerGame(
            name = "Du",
            position = 34
    )

    val player4 = PlayerGame(
            name = "Pati",
            position = 12
    )

    val player5 = PlayerGame(
            name = "Julio",
            position = 67
    )

    val player6 = PlayerGame(
            name = "Mae",
            position = 78
    )

    val player7 = PlayerGame(
            name = "Dr",
            position = 64
    )

    val player8 = PlayerGame(
            name = "Pri",
            position = 12
    )

    val jogadores = mutableListOf(
            player1,player2,player3,player4,player5,player6,player8, player7
    )
}