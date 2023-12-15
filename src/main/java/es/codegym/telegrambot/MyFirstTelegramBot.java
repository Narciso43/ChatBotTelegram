package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;


public class MyFirstTelegramBot extends es.codegym.telegrambot.MultiSessionTelegramBot {

//Se agrega el nombre de tu chat bot
    public static final String NAME = "codeNarcisoJava_bot";
    //Se agraga tu Token
    public static final String TOKEN = "6658619447:AAH_IgdFp1DSm31h-bhr7E0GmrWGAMSzh10";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        //Agregar sentencias condicionale
        //Se equals para comparat
        if (getMessageText().equals("/start")){
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("HACKEAR LA NEVERA","step_1_btn"));
        };
        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            //Metodo para  garle puntaje a los usuarios
            setUserGlory(30);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync( STEP_2_TEXT,
                             Map.of( "¡Tomar una salchicha + 20 de fama!","step_2_btn",
                                     "¡Tomar un pescado  +20 de fama!" ,"step_2_btn",
                                     "¡Tirar una lata  de pepinillo +20  de fama!","step_2_btn"));

        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            //Metodo para  garle puntaje a los usuarios
            setUserGlory(30);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("¡Romper  al robot aspiradora !", "step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            //Metodo para  garle puntaje a los usuarios
            addUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync( STEP_4_TEXT,
                    Map.of( "¡Enviar al robort por comida +30!","step_4_btn",
                            "¡Dar un paso en el robot aspiradora! +40 de fama" ,"step_4_btn",
                            "¡Hubir  del robot aspiradora + 30 de fama!","step_2_btn"));

        }
        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Encender y prender la Goo Pro","step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                   Map.of("¡Correr por lo tejados, grabando con la GoPro! +40  de fama","step_6_btn",
                           "Atacar a otros gatos desde tu escondite con la GoPro! + 40 de fama","step_6_btn",
                           "Atacar a otros perros desde tu escondite con la GoPro+ 40 de fama","step_6_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("¡Roper la contraseña!", "step_7_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            addUserGlory(60);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("¡Salir del patio!", "step_8_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            addUserGlory(60);
            sendTextMessageAsync(FINAL_TEXT);
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}