package initial.resource.dto

import com.fasterxml.jackson.annotation.JsonProperty

class HeartbeatsDTO(
        @JsonProperty("hrs")
        val heartbeats: List<Int>?
)