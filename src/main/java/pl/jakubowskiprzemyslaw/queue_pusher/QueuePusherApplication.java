package pl.jakubowskiprzemyslaw.queue_pusher;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableRabbit
public class QueuePusherApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueuePusherApplication.class, args);
    }
}
