package ru.popov.testForAlfa.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientConfig {
    @Value("${openexchangerates.appId}")
    String appId;

    @Value("${openexchangerates.url}")
    String url;

    @Value("${currency}")
    String currency;

    @Value("${giphy.url}")
    String giphyUrl;

    @Value("${giphy.api_key}")
    String giphyApiKey;
}
