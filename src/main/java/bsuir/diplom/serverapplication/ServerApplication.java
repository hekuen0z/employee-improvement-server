package bsuir.diplom.serverapplication;

import bsuir.diplom.serverapplication.servises.IAccountsService;
import bsuir.diplom.serverapplication.servises.impl.AccountsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import bsuir.diplom.serverapplication.utilities.Server;
import bsuir.diplom.serverapplication.constants.ConstantsMSG;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import static bsuir.diplom.serverapplication.constants.ConstantsMSG.*;

@Log4j2
@RequiredArgsConstructor
@SpringBootApplication
public class ServerApplication {
//    private static boolean isOn = true;
//    private static Thread serverThread = null;
//    private static final AtomicInteger countOfConnected = new AtomicInteger(0);

    public static void main(String[] args) {
        showMenu();
        //SpringApplication.run(ServerApplication.class, args);
//        Scanner scanner = new Scanner(System.in);
//        int adminAnswer;
//        String answerString = null;
//
//        showMenu();

//        while (isOn) {
//            try {
//                answerString = scanner.nextLine();
//                adminAnswer = Integer.parseInt(answerString);
//
//                switch (adminAnswer) {
//                    case 1 -> {
//
//                    }
//                    case 2 -> log.info(CURRENT_CONNECTION_MSG + getCountOfConnected());
//                    case 3 -> {
//                        isOn = false;
//                        Server.changeServerActivity(false);
//                        try {
//                            if (serverThread != null)
//                                serverThread.join();
//                            log.error(SERVER_SWITCHED_OFF_MSG);
//                        } catch (InterruptedException e) {
//                            log.error(SERVER_SWITCHED_OFF_ERROR_MSG);
//                            e.printStackTrace();
//                        }
//                    }
//                    default -> throw new NumberFormatException();
//                }
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println(INCORRECT_VALUE_MSG + answerString);
//            }
//        }
    }

    private final Server server;

    private static void showMenu() {
        int i = 0;
        System.out.println(++i + ConstantsMSG.DELIMITER_MSG + ConstantsMSG.MENU_1_MSG);
        System.out.println(++i + ConstantsMSG.DELIMITER_MSG + ConstantsMSG.MENU_2_MSG);
        System.out.println(++i + ConstantsMSG.DELIMITER_MSG + ConstantsMSG.MENU_3_MSG);
        System.out.print(MENU_CHOOSE_MSG);
    }

    @SuppressWarnings({"Convert2Lambda", "java:S1604"})
    @Bean
    public ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener(){
        return new ApplicationListener<>() {
            @Override
            public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
                server.start();
            }
        };
    }
}
