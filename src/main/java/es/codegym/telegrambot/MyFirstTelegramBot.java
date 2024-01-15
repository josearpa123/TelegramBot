package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "JosePrimer_bot";
    public static final String TOKEN = "6976484703:AAGhO-wTLj9BiZboziK7qBhOZfrgmNJ8yIc";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if (getMessageText().equals("/start")) {
            sendTextMessageAsync("Hola _futuro_ *programador*");
        }
        if (getMessageText().contains("hola")) {
            sendTextMessageAsync("Hola, ¿Cual es tu nombre?");
        }
        if (getMessageText().contains("Mi nombre es")) {
            sendTextMessageAsync("Es un placer yo soy *gato* c\uD83D\uDE3A");
        }
        
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}