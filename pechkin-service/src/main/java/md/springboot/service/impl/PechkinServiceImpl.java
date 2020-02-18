package md.springboot.service.impl;

import lombok.RequiredArgsConstructor;
import md.springboot.dto.Message;
import md.springboot.service.MessageService;
import md.springboot.service.PechkinService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class PechkinServiceImpl implements PechkinService {

    private final MessageService messageService;

    @Override
    public void sendMessages(int numberOfRequest, Message message) {
        IntStream.range(0, numberOfRequest).forEach((i -> {
                    Optional.of(message)
                            .map(m -> new Message(extractText(message)))
                            .ifPresent(messageService::send);
                })
        );
    }

    private String extractText(Message message) {
        Random random = new Random();

        int a = random.nextInt(message.getText().length());
        int b = random.nextInt(message.getText().length());

        int min = Math.min(a, b);
        int max = Math.max(a, b);

        return message.getText().substring(min, max);
    }
}
