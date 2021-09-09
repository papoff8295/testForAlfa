package ru.popov.testForAlfa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
        "msg", "status", "response_id"
})
public class GiphyMeta {

    @JsonProperty("msg")
    String msg;
    @JsonProperty("status")
    Integer status;
    @JsonProperty("response_id")
    String responseId;
}
