package model

data class Team(val name: String, val city: String) {
    private val _players = mutableListOf<Player>()
    val players: List<Player> get() = _players

    fun addPlayer(player: Player) {
        _players.add(player)
    }

    // Task 9: lazy properties
    val totalTransferCost: Long by lazy { _players.sumOf { it.transferCost } }
    val averageRedCards: Double by lazy {
        if (_players.isEmpty()) 0.0 else _players.map { it.redCards }.average()
    }
}
