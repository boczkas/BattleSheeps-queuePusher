package pl.jakubowskiprzemyslaw.queue_pusher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubowskiprzemyslaw.queue_pusher.ObjectSender;
import pl.jakubowskiprzemyslaw.queue_pusher.QueueResolver;
import pl.jakubowskiprzemyslaw.queue_pusher.data.QueueType;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

@Controller
public class QueueController {

    private final ObjectSender objectSender;

    @Autowired
    public QueueController(ObjectSender objectSender) {
        this.objectSender = objectSender;
    }

    @GetMapping(value = "/")
    public String getPage(Model model, HttpServletRequest request) {
        model.addAttribute("queueResolver", new QueueResolver());
        model.addAttribute("queues", QueueType.asList());
        String objectSent = (String)request.getSession().getAttribute("objectSent");
        model.addAttribute("objectSent", objectSent);
        return "mainPage";
    }

    @PostMapping(value = "/", produces = "text/plain")
    public String queueResolverSubmit(@ModelAttribute("queueResolver") QueueResolver queueResolver, HttpServletRequest request) {
        System.out.println(queueResolver.getQueueName());
        if (queueResolver.getQueueName().equals("")) {
            return "redirect:/";
        }
        objectSender.sendObject(queueResolver.getQueueName());
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        request.getSession().setAttribute("objectSent",timeStamp + " | " + QueueType.valueOf(queueResolver.getQueueName()).createObjectToSend().toString());

        return "redirect:/";
    }
}
