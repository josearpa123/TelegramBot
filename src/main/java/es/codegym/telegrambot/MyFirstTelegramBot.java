package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

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
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT,
            Map.of("Hackear la nevera", "step_1_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Tomar una salchicha + 20 de fama", "step_2_btn",
                            "Tomar un pescado + 20 de fama","step_2_btn",
                            "¡Tirar una lata de pepinillo! + 20 de fama","step_2_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear al robot aspiradora", "step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot aspiradora a por comida + 30 de fama","step_4_btn",
                            "Dar un paseo al robot aspiradora + 30 de fama","step_4_btn",
                            "huir del robot aspiradora + 30 de fama","step_4_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            addUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT, Map.of());
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}