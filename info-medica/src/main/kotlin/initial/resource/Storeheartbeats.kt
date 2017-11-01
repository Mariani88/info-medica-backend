package initial.resource

import initial.domain.action.FindHeartbeats
import initial.resource.dto.HeartbeatsSamplesDTO
import org.springframework.web.bind.annotation.*
import initial.domain.action.StorePulsations

@RestController
class Storeheartbeats {

    @PostMapping("/heartbeats")
    fun store(@RequestBody heartbeatsSamplesDTO: HeartbeatsSamplesDTO) =
        StorePulsations()(heartbeatsSamplesDTO)

    @GetMapping("/heartbeats")
    fun find() = FindHeartbeats()()
}