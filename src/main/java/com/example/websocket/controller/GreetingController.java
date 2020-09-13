package com.example.websocket.controller;

import com.example.websocket.domain.Greeting;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {

        Thread.sleep(1000); // simulated delay

        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/insult")
    @SendTo("/topic/greetings")
    public Greeting insult(Message message) throws Exception {

        Thread.sleep(1000); // simulated delay

        return new Greeting("Fuck you, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
