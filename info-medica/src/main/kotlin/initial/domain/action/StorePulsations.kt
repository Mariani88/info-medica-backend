package initial.domain.action

import initial.domain.entities.HeartBeats
import initial.infrastructure.HeartBeatsRepository
import initial.resource.dto.HeartbeatsSamplesDTO
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class StorePulsations {

    private val repository: HeartBeatsRepository by RepositoryBuilder()



    operator fun invoke(heartbeatsSamplesDTO: HeartbeatsSamplesDTO) {

        if(heartbeatsSamplesDTO.newHeartbeats!!)
            storeNewHeartBeats(heartbeatsSamplesDTO)
        else addNewHeartBeats(heartbeatsSamplesDTO)
    }

    private fun addNewHeartBeats(heartbeatsSamplesDTO: HeartbeatsSamplesDTO) {
        var heartBeats: HeartBeats = repository.get()
        heartBeats.addSamples(heartbeatsSamplesDTO.heartbeats!!)
        repository.store(heartBeats)

    }

    private fun storeNewHeartBeats(heartbeatsSamplesDTO: HeartbeatsSamplesDTO) {
        var heartBeats = HeartBeats(heartbeatsSamplesDTO.heartbeats!!.toMutableList())
        repository.store(heartBeats)
    }


    class RepositoryBuilder : ReadOnlyProperty<StorePulsations, HeartBeatsRepository> {
        override fun getValue(thisRef: StorePulsations, property: KProperty<*>): HeartBeatsRepository {
            return HeartBeatsRepository()
        }
    }

}