package ru.popov.testForAlfa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;

@JsonPropertyOrder({
        "data",
        "meta"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
public class Giphy {

    @JsonProperty("data")
    GiphyData data;
    @JsonProperty("meta")
    GiphyMeta meta;
}
