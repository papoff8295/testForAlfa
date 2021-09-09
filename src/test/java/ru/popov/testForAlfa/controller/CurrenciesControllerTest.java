package ru.popov.testForAlfa.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;
import ru.popov.testForAlfa.config.ClientConfig;
import ru.popov.testForAlfa.service.FeinService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CurrenciesControllerTest {

    @Autowired
    ClientConfig config;
    @Autowired
    FeinService feinService;

    @Test
    void getCurrency() {
        Assert.hasText(feinService.getLatest("RUB").getRates().getRub(), "Not text");
    }

}