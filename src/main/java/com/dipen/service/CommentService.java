package com.dipen.service;

import com.dipen.dao.DatabaseClass;
import com.dipen.model.Comment;
import com.dipen.model.ErrorMessage;
import com.dipen.model.Message;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getAllMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Message message =  messages.get(messageId);
		/* without response object
		if(message == null)
		{
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}*/

		//with response object
		// not good practiece as business logic and presetation layer got mixed up
		ErrorMessage errorMessage = new ErrorMessage("Messege Not fouund",404,"www.google.com");
		Response response = Response.status(Response.Status.NOT_FOUND).
				entity(errorMessage).
				build();
		if(message == null)
		{
			throw new WebApplicationException(response);
		}

		Map<Long, Comment> comments =message.getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
		
}
