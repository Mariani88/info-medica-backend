package initial.infrastructure

import initial.domain.entities.HeartBeats
import java.io.*

class HeartBeatsRepository {

    fun get(): HeartBeats = if (existFile()) findHeartBeats() else emptyHeartBeats()

    fun store(heartBeats: HeartBeats) {
        val oos = ObjectOutputStream(FileOutputStream("heartbeats.dat"))

        try {
            oos.writeObject(heartBeats)
            oos.close()
        }catch (e: Exception){
            RuntimeException("fail to write object")
        }finally {
            oos.close()
        }
    }

    private fun emptyHeartBeats(): HeartBeats {
        val emptyHeartBeats = HeartBeats.empty
        store( emptyHeartBeats)
        return emptyHeartBeats
    }

    private fun findHeartBeats(): HeartBeats {
        val ois = ObjectInputStream(FileInputStream("heartbeats.dat"))
        try {
            val data = ois.readObject()
            ois.close()
            return data as HeartBeats
        }catch (e:Exception){
            throw RuntimeException("fail to read heartbeats")
        }finally {
            ois.close()
        }
    }

    private fun existFile() = File("heartbeats.dat").exists()
}