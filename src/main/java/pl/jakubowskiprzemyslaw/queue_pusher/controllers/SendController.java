package pl.jakubowskiprzemyslaw.queue_pusher.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubowskiprzemyslaw.queue_pusher.QueueResolver;

@Controller
public class SendController {

    @PostMapping(value = "/sender")
    public String getPage(Model model) {
//        QueueResolver queueResolver = (QueueResolver) model.asMap().get("queueResolver");
//        System.out.println(queueResolver.getQueueName());
        return "sentPage";
    }
}
