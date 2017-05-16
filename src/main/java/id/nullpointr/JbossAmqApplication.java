package id.nullpointr;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Service;

import id.nullpointr.service.AmqProducerService;

@SpringBootApplication
@EnableJms
public class JbossAmqApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JbossAmqApplication.class, args);
	}
}
