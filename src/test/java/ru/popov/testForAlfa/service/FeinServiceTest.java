package ru.popov.testForAlfa.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;
import ru.popov.testForAlfa.Client.CurrenciesClient;
import ru.popov.testForAlfa.Client.GiphyClient;
import ru.popov.testForAlfa.config.ClientConfig;
import ru.popov.testForAlfa.model.Currency;
import ru.popov.testForAlfa.model.Giphy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FeinServiceTest {
    @MockBean
    CurrenciesClient currenciesClient;
    @MockBean
    GiphyClient giphyClient;

    @Autowired
    ClientConfig config;
    @Autowired
    FeinService feinService;

    @Test
    void getLatest() {
        Currency currency = feinService.getLatest("RUB");
        Mockito.verify(currenciesClient, Mockito.times(1)).getLatest(config.getAppId(), "RUB");
    }

    @Test
    void getHistory() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendarDateBefore = Calendar.getInstance();
        calendarDateBefore.setTime(new Date());
        calendarDateBefore.add(Calendar.DAY_OF_MONTH,  -1);
        String nowDate = df.format(calendarDateBefore.getTime());
        Currency currency = feinService.getHistory("RUB");
        Mockito.verify(currenciesClient, Mockito.times(1)).getHistorical(nowDate,config.getAppId(), "RUB");
    }

    @Test
    void getRandom() {
        Giphy giphy = feinService.getRandom("rich");
        Mockito.verify(giphyClient, Mockito.times(1)).getRandom(config.getGiphyApiKey(), "rich");
    }
}