package com.sejenak.be_sejenakapp.service;

import com.sejenak.be_sejenakapp.repository.KonselingRepository;
import com.sejenak.be_sejenakapp.vo.Konseling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class KonselingService {
    @Autowired
    private KonselingRepository mKonselingRepostiory;

    public List<Konseling> getMessages(String user1, String user2) {
        return mKonselingRepostiory.findBySenderUsernameAndReceiverUsernameOrReceiverUsernameAndSenderUsername(
                user1, user2, user1, user2
        );
    }

    public Konseling sendMessage(Konseling msg) {
        msg.setCreatedAt(LocalDateTime.now());
        if (msg.getMessageType() == null) msg.setMessageType("text");
        if (msg.getRead() == null) msg.setRead(false);
        return mKonselingRepostiory.save(msg);
    }
}
