package pl.jakubowskiprzemyslaw.queue_pusher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubowskiprzemyslaw.queue_pusher.ObjectSender;
import pl.jakubowskiprzemyslaw.queue_pusher.QueueResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class QueueController {

    private final ObjectSender objectSender;

    @Autowired
    public QueueController(ObjectSender objectSender) {
        this.objectSender = objectSender;
    }

    @GetMapping(value = "/")
    public String getPage(Model model) {
        model.addAttribute("queueResolver", new QueueResolver());
        model.addAttribute("queues", Arrays.asList("PlayerRegistrationQueueTest","GameConfigurationRegistrationQueueTest"));
        return "mainPage";
    }

    @PostMapping(value = "/")
    public String queueResolverSubmit(@ModelAttribute("queueResolver") QueueResolver queueResolver, HttpServletRequest request) {
        System.out.println(queueResolver.getQueueName());
        objectSender.sendObject(queueResolver.getDefaultObject(), queueResolver.getQueueName());
        return "mainPage";
    }
}
