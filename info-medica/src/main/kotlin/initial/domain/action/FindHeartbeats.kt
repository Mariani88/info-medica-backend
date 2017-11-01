package initial.domain.action

import initial.infrastructure.HeartBeatsRepository
import initial.resource.dto.HeartbeatsDTO
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FindHeartbeats {

    private val repository: HeartBeatsRepository by FindHeartbeats.RepositoryBuilder()

    operator fun invoke() = HeartbeatsDTO(repository.get().samples)

    class RepositoryBuilder : ReadOnlyProperty<FindHeartbeats, HeartBeatsRepository> {
        override fun getValue(thisRef: FindHeartbeats, property: KProperty<*>): HeartBeatsRepository {
            return HeartBeatsRepository()
        }
    }
}