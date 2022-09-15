package j.websocdemo.controller;

import j.websocdemo.model.Message;
import j.websocdemo.model.MyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    @MessageMapping("/myMessage")
    @SendTo("/topic")
    public MyResponse messageHandler(Message message){
        System.out.println("received request: " + message.getMessage());
        // game logic here
        return new MyResponse(message.getMessage());
    }
}
