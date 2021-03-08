package br.com.listasimples

data class PlayerGame(
    val name: String,
    val position: Long
) : Comparable<PlayerGame> {
    override fun compareTo(other: PlayerGame): Int {
        return this.position.compareTo(other.position)
    }
}