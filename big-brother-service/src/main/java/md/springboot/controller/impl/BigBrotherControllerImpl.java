package md.springboot.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import md.springboot.controller.BigBrotherController;
import md.springboot.dto.Message;
import md.springboot.service.BigBrotherService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BigBrotherControllerImpl implements BigBrotherController {

    private final BigBrotherService bigBrotherService;

    @Override
    @SneakyThrows
    public void checkMessage(Message message) {
        bigBrotherService.checkMessage(message);
    }
}
