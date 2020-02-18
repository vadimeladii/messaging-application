package md.springboot.service;

import md.springboot.dto.Message;

public interface PechkinService {
    void sendMessages(int numberOfRequest, Message message);
}
