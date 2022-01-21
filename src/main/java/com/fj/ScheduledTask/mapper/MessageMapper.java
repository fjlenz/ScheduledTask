package com.fj.ScheduledTask.mapper;

import com.fj.ScheduledTask.entity.Message;
import com.fj.ScheduledTask.model.MessageModel;

public class MessageMapper {

	public Message mapDtoToEntity (MessageModel messageModel, boolean mapForInsert) {

		Message mappedMessageEntity = new Message();
		if (!mapForInsert) {
			mappedMessageEntity.setId(messageModel.getId());	
		}
		mappedMessageEntity.setText(messageModel.getMessage());
		mappedMessageEntity.setRating(messageModel.getRating());
		
		return mappedMessageEntity;
	}
	
	public MessageModel mapEntityToDto (Message foundMessage) {
		
		MessageModel mappedMessageDto = new MessageModel();
		mappedMessageDto.setId(foundMessage.getId());
		mappedMessageDto.setMessage(foundMessage.getText());
		mappedMessageDto.setRating(foundMessage.getRating());
		
		return mappedMessageDto;
	}

}