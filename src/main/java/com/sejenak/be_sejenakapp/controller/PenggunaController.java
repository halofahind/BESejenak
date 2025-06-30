package com.sejenak.be_sejenakapp.controller;

import com.sejenak.be_sejenakapp.service.PenggunaService;
import com.sejenak.be_sejenakapp.vo.Pengguna;
import com.sejenak.be_sejenakapp.vo.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PenggunaController {
    @Autowired
    PenggunaService mPenggunaService;

    @GetMapping("/penggunas")
    public List<Pengguna> getPenggunas() {
        List<Pengguna> penggunaList = mPenggunaService.getPenggunas();
        return penggunaList;
    }

    @PostMapping("/pengguna")
    public Object savePengguna(HttpServletResponse response, @RequestBody Pengguna param) {
        boolean isSuccess = mPenggunaService.savePengguna(param);
        if (isSuccess) {
            return new Result(200, "Succes");
        }else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Failed to add pengguna");
        }
    }

    @PutMapping("/pengguna")
    public Object updatePengguna(HttpServletResponse response, @RequestBody Pengguna param) {
        boolean isSuccess = mPenggunaService.updatePengguna(param);
        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Failed to update pengguna");
        }
    }

    @DeleteMapping("/pengguna")
    public Object deletePengguna(HttpServletResponse response, @RequestParam String id) {
        boolean isSuccess = mPenggunaService.deletePengguna(id);
        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Failed to delete pengguna");
        }
    }

    @GetMapping("/pengguna")
    public Pengguna getPengguna(@RequestParam String id) {
        Pengguna pengguna = mPenggunaService.getPengguna(id);
        return pengguna;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Pengguna loginRequest) {
        Pengguna pengguna = mPenggunaService.login(loginRequest.getUsername(), loginRequest.getPassword());

        if (pengguna != null) {
            return ResponseEntity.ok(pengguna);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username atau Password salah!");
        }
    }
}
