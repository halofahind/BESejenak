package com.sejenak.be_sejenakapp.repository;

import com.sejenak.be_sejenakapp.vo.Konseling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KonselingRepository extends JpaRepository<Konseling, Long> {
    List<Konseling> findBySenderUsernameAndReceiverUsernameOrReceiverUsernameAndSenderUsername(
            String sender1, String receiver1, String sender2, String receiver2
    );
}
