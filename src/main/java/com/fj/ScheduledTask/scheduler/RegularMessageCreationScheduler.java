package com.fj.ScheduledTask.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fj.ScheduledTask.mapper.MessageMapper;
import com.fj.ScheduledTask.model.MessageModel;
import com.fj.ScheduledTask.service.MessageService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RegularMessageCreationScheduler {

	@Autowired
	private MessageService messageService;
		
    @Scheduled(fixedDelay = 10000) // every 10 secs
    public void scheduleFixedDelayTask() {
 	
        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
        
        int numberOfExisingMessages = messageService.retrieveAllMessages().size();
        System.out.println("### Number of messages in GCP DataStore: " + numberOfExisingMessages);
        
        MessageModel messageToBeCreated = new MessageModel();
        
        if (numberOfExisingMessages < 5) {
        	
        	int numberOfCreationRuns = 0;
        	
           	do { 		
            	numberOfCreationRuns++;
            	
            	messageToBeCreated.setMessage("AutomatedRun # " + numberOfCreationRuns + " - " + new Timestamp(System.currentTimeMillis()));
            	messageService.addSingleMessage(messageToBeCreated, true);
            	System.out.println("   ### Add new Message to GCP DataStore: " + numberOfCreationRuns);
            
        	}
        	while (messageService.retrieveAllMessages().size() < 5);	
        	
        	System.out.println("### Total number of Messages created: " + numberOfCreationRuns);
        	
           	numberOfCreationRuns = 0;
           	
        }
        
        
    }
    
    
}