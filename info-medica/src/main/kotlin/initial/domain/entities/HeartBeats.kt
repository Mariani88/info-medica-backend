package initial.domain.entities

import java.io.Serializable

class HeartBeats (val samples: MutableList<Int>): Serializable {

    fun addSamples(heartbeats: List<Int>) {
        samples.addAll(heartbeats)
    }

    companion object createEmpty {
    val empty = HeartBeats(mutableListOf())
    }
}