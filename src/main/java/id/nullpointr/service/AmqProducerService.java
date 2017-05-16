package id.nullpointr.service;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import id.nullpointr.constant.GlobalConstant;

@Service
public class AmqProducerService implements Runnable{
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue(GlobalConstant.QUEUE_NAME);
	}
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			send("This is a message [ANU] x"+i);
			System.out.println("Message "+i+" successfully sent to "+GlobalConstant.QUEUE_NAME);
		}
	}
	
	private void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}

}
