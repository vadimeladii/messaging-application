package md.springboot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import md.springboot.dto.Message;
import md.springboot.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private RestTemplate restTemplate = new RestTemplate();

    @SneakyThrows
    @Override
    public ResponseEntity<Message> send(Message message) {
        log.info("Send message {}", message);
        return restTemplate.postForEntity("http://localhost:8081/big-brother", message, Message.class);
    }
}
