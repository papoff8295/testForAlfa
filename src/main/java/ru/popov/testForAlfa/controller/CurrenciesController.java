package ru.popov.testForAlfa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.popov.testForAlfa.config.ClientConfig;
import ru.popov.testForAlfa.model.Currency;
import ru.popov.testForAlfa.model.Giphy;
import ru.popov.testForAlfa.model.Rates;
import ru.popov.testForAlfa.service.FeinService;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class CurrenciesController {

    private final FeinService service;

    public CurrenciesController(FeinService service) {
        this.service = service;
    }

    @GetMapping("/{money}")
    public Giphy getCurrency(@PathVariable String money) throws JsonProcessingException {

        Currency currencyLatest = service.getLatest(money);
        Currency currencyYesterday = service.getHistory(money);

        double baseLatest = getMap(currencyLatest).get(money);
        double baseHistoric = getMap(currencyYesterday).get(money);

        if (baseHistoric < baseLatest) {
            return service.getRandom("rich");
        } else
        return service.getRandom("broke");
    }

    private Map<String, Double> getMap(Currency currency) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        String s1 = ow.writeValueAsString(currency);
        JsonNode node = mapper.readTree(s1);
        Iterator<Map.Entry<String, JsonNode>> fieldNames = node.get("rates").fields();
        Map<String, Double> exchangeRates = new HashMap<>();
        fieldNames.forEachRemaining(e -> exchangeRates.put(e.getKey(), e.getValue().doubleValue()));
        return exchangeRates;
    }
}
