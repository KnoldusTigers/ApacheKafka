package com.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafkaapp")
public class KafkaController {
    @GetMapping(value="/post")
    public String sendMessage() {

        return "published successfully";
    }
}

