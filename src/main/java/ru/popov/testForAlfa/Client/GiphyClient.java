package ru.popov.testForAlfa.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.popov.testForAlfa.model.Giphy;

@FeignClient(name = "giphy", url = "${giphy.url}")
public interface GiphyClient {

    @RequestMapping(method = RequestMethod.GET, value =
            "?api_key={apiKey}&tag={tag}")
    Giphy getRandom(@PathVariable String apiKey, @PathVariable String tag);
}
