package com.one.conversormoeda;

import com.one.conversormoeda.controller.ConversaoController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final ConversaoController controller;

    public AppRunner(ConversaoController controller) {
        this.controller = controller;
    }

    @Override
    public void run(String... args) {
        controller.iniciarConversao();
    }
}
