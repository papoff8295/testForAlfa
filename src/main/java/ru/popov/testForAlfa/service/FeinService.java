package ru.popov.testForAlfa.service;

import org.springframework.stereotype.Service;
import ru.popov.testForAlfa.Client.CurrenciesClient;
import ru.popov.testForAlfa.Client.GiphyClient;
import ru.popov.testForAlfa.config.ClientConfig;
import ru.popov.testForAlfa.model.Currency;
import ru.popov.testForAlfa.model.Giphy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class FeinService {

    private final CurrenciesClient currenciesClient;
    private final GiphyClient giphyClient;
    private final ClientConfig config;

    public FeinService(CurrenciesClient currenciesClient, GiphyClient giphyClient, ClientConfig config) {
        this.currenciesClient = currenciesClient;
        this.giphyClient = giphyClient;
        this.config = config;
    }

    public Currency getLatest(String money) {
        return currenciesClient.getLatest(config.getAppId(), money);
    }

    public Currency getHistory(String money) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendarDateBefore = Calendar.getInstance();
        calendarDateBefore.setTime(new Date());
        calendarDateBefore.add(Calendar.DAY_OF_MONTH,  -1);
        String nowDate = df.format(calendarDateBefore.getTime());
        return currenciesClient.getHistorical(nowDate, config.getAppId(), money);
    }

    public Giphy getRandom(String tag) {
        return giphyClient.getRandom(config.getGiphyApiKey(), tag);
    }
}
