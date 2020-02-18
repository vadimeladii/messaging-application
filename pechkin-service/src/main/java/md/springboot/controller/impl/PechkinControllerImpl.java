package md.springboot.controller.impl;

import lombok.RequiredArgsConstructor;
import md.springboot.controller.PechkinController;
import md.springboot.dto.Message;
import md.springboot.service.PechkinService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PechkinControllerImpl implements PechkinController {

    private final PechkinService pechkinService;

    @Override
    public void sendMessages(int numberOfRequest, Message message) {
        pechkinService.sendMessages(numberOfRequest, message);
    }
}
