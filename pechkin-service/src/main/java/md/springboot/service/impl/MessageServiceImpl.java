package md.springboot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.springboot.configuration.properties.PechkinProperties;
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
    private final PechkinProperties pechkinProperties;

    @Override
    public ResponseEntity<Message> send(Message message) {
        log.info("Send message {}", message);
        return restTemplate.postForEntity(pechkinProperties.getUrl(), message, Message.class);
    }
}
