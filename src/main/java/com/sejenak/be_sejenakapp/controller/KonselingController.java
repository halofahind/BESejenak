package com.sejenak.be_sejenakapp.controller;

import com.sejenak.be_sejenakapp.service.KonselingService;
import com.sejenak.be_sejenakapp.vo.Konseling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KonselingController {
    @Autowired
    private KonselingService konselingService;

    @GetMapping("/messages")
    public List<Konseling> getMessages(
            @RequestParam String user1,
            @RequestParam String user2
    ) {
        return konselingService.getMessages(user1, user2);
    }

    @PostMapping("/messages")
    public Konseling sendMessage(@RequestBody Konseling message) {
        return konselingService.sendMessage(message);
    }
}
