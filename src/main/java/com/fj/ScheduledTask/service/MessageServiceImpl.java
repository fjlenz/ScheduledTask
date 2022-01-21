package com.fj.ScheduledTask.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fj.ScheduledTask.entity.Message;
import com.fj.ScheduledTask.mapper.MessageMapper;
import com.fj.ScheduledTask.model.MessageModel;
import com.fj.ScheduledTask.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
    private MessageRepository messageRepository;

	private MessageMapper transactionMapper = new MessageMapper(); 

	@Override
	public List<MessageModel> retrieveAllMessages() {
	    List<MessageModel> messagesFound = new ArrayList<MessageModel>();
	    
	    for (Message m : messageRepository.findAll()) {	    	
	    	messagesFound.add(transactionMapper.mapEntityToDto(m));
	    }
	    
		return messagesFound;
	}


	@Override
	public MessageModel retrieveSingleMessage(Long id) {
		Optional<Message> foundMessage = messageRepository.findById(id);
	
		if (foundMessage.isPresent()) {
			return transactionMapper.mapEntityToDto(foundMessage.get());
		} else {
			return null;
		}	
	}
	

	@Override
	public MessageModel addSingleMessage(MessageModel messageModel, boolean mapForInsert) {

		Message messageForPersist = transactionMapper.mapDtoToEntity(messageModel, mapForInsert);
		
		Message savedMesage = messageRepository.save(messageForPersist);
		
		return transactionMapper.mapEntityToDto(savedMesage);
	}


	@Override
	public MessageModel updateMessage(Long id, MessageModel messageModel) {
	
		Optional<Message> foundMessage = messageRepository.findById(id);
		
		if (foundMessage.isPresent()) {
			Message messageForUpdate = foundMessage.get();
			
			messageForUpdate.setText(messageModel.getMessage());
			messageForUpdate.setRating(messageModel.getRating());
			
			Message savedMesage = messageRepository.save(messageForUpdate);
			
			return transactionMapper.mapEntityToDto(savedMesage);
			
		}
		
		return null;
			
	}


	@Override
	public MessageModel deleteSingleMessage(Long id) {
		
		Optional<Message> foundMessage = messageRepository.findById(id);
		
		if (foundMessage.isPresent()) {
			Message messageForDelete = foundMessage.get();
		
			messageRepository.delete(messageForDelete);
			
			return transactionMapper.mapEntityToDto(messageForDelete);
		}		

		return null;
	}


}
