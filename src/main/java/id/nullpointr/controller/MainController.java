package id.nullpointr.controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.nullpointr.constant.GlobalConstant;
import id.nullpointr.service.AmqProducerService;

@RestController
public class MainController {
	
	private AmqProducerService producer;
	
	@Autowired
	public MainController(AmqProducerService producer){
		this.producer = producer;
	}
	
	@RequestMapping("/produce")
	public String produce(){
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);
		for(int i = 0; i < 1000; i++){
			executor.execute(producer);
		}
		
		return "ok";
	}
	
	/*@Component
	public class Consumer {

		@JmsListener(destination = GlobalConstant.QUEUE_NAME)
		public void receiveQueue(String text) {
			System.out.println("Got msg: "+text);
		}

	}*/
	
	
}
