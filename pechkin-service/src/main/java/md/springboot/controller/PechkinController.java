package md.springboot.controller;

import md.springboot.dto.Message;
import org.springframework.web.bind.annotation.*;

@RequestMapping("pechkin")
public interface PechkinController {

    @PostMapping
    void sendMessages(@RequestParam int numberOfRequest, @RequestBody Message message);
}
