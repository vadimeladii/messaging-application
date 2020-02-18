package md.springboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("pechkin")
public interface PechkinController {

    @PostMapping
    void sendMessages(@RequestParam int numberOfRequest, @RequestParam String text);
}
