package md.springboot.service;

import md.springboot.dto.Message;
import org.springframework.http.ResponseEntity;

public interface MessageService {
    ResponseEntity<Message> send(Message message);
}
