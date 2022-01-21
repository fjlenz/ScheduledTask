package com.fj.ScheduledTask.service;

import java.util.List;

import com.fj.ScheduledTask.model.MessageModel;

public interface MessageService {

	public abstract MessageModel retrieveSingleMessage(Long id);

	public abstract MessageModel addSingleMessage(MessageModel messageModel, boolean mapForInsert);

	public abstract MessageModel updateMessage(Long id, MessageModel messageModel);

	public abstract MessageModel deleteSingleMessage(Long id);

	public abstract List<MessageModel> retrieveAllMessages();
	

}