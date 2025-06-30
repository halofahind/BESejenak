package com.sejenak.be_sejenakapp.repository;

import com.sejenak.be_sejenakapp.vo.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("PenggunaRepository")
public interface PenggunaRepository extends JpaRepository<Pengguna, String> {
    @Query("SELECT u FROM Pengguna u WHERE u.username = ?1")
    Pengguna getUserByUsername(String usrname);

    @Query(value = "SELECT * FROM Pengguna", nativeQuery = true)
    List<Pengguna> findAll();

    Pengguna findByUsernameAndPassword(String username, String password);

}
