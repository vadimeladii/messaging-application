package md.springboot.service.impl;

import lombok.extern.slf4j.Slf4j;
import md.springboot.dto.Message;
import md.springboot.service.BigBrotherService;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class BigBrotherServiceImpl implements BigBrotherService {

    @Override
    public void checkMessage(Message message) {

        Message result = Optional.of(message)
                .map(m -> {
                    m.setText(decrypt(m));
                    return m;
                })
                .map(m -> {
                    m.setText(reverse(m));
                    return m;
                }).get();

        log.info("Receive message {}", result.getText());
    }

    private String decrypt(Message message) {
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword("myEncryptionPassword");

        return basicTextEncryptor.decrypt(message.getText());
    }

    private String reverse(Message message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message.getText());

        return stringBuilder.reverse().toString();
    }
}
