package ru.popov.testForAlfa.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.popov.testForAlfa.model.Currency;
import ru.popov.testForAlfa.model.Giphy;

import java.util.Date;

@FeignClient(name = "openexchangerates", url = "${openexchangerates.url}")
public interface CurrenciesClient {

    @RequestMapping(method = RequestMethod.GET, value =
            "/historical/{date}.json?app_id={appId}&symbols={money}&show_alternative=false&prettyprint=false")
    Currency getHistorical(@PathVariable String date, @PathVariable String appId, @PathVariable String money);

    @RequestMapping(method = RequestMethod.GET, value =
            "/latest.json?app_id={appId}&symbols={money}&show_alternative=false&prettyprint=false")
    Currency getLatest(@PathVariable String appId, @PathVariable String money);

}
