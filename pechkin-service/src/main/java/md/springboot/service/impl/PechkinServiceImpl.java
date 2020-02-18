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
    public void sendMessages(int numberOfRequest, String text) {
        IntStream.range(0, numberOfRequest).forEach((i -> {
                    Optional.of(text)
                            .map(m -> new Message(extractInfo(text)))
                            .ifPresent(messageService::send);
                })
        );
    }

    private String extractInfo(String text) {
        Random random = new Random();

        int a = random.nextInt(text.length());
        int b = random.nextInt(text.length());

        int min = Math.min(a, b);
        int max = Math.max(a, b);

        return text.substring(min, max);
    }
}
