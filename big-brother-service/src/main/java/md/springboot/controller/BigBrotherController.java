package md.springboot.controller;

import md.springboot.dto.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("big-brother")
public interface BigBrotherController {

    @PostMapping
    void checkMessage(@RequestBody Message message);
}
