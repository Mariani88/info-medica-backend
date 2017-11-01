package initial.resource.dto

import com.fasterxml.jackson.annotation.JsonProperty

class HeartbeatsSamplesDTO(

        @JsonProperty("hbs")
        val heartbeats: List<Int>?,

        @JsonProperty("nh")
        val newHeartbeats: Boolean?
)