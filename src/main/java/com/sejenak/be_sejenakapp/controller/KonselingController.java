package com.sejenak.be_sejenakapp.controller;

import com.sejenak.be_sejenakapp.repository.TopikRepository;
import com.sejenak.be_sejenakapp.service.DetailKonselingService;
import com.sejenak.be_sejenakapp.service.KonselingService;
import com.sejenak.be_sejenakapp.service.KonselingService;
import com.sejenak.be_sejenakapp.vo.*;
import com.sejenak.be_sejenakapp.vo.Konseling;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class KonselingController {
    @Autowired
    KonselingService mKonselingService;
    @Autowired
    DetailKonselingService mDetailKonselingService;
    @Autowired
    TopikRepository mTopikRepository;

    @GetMapping("/konselings")
    public List<Konseling> getKonselings() {
        List<Konseling> konselingList = mKonselingService.getKonselings();
        return konselingList;
    }

    @PostMapping("/konseling")
    public Object saveKonseling(HttpServletResponse response, @RequestBody Konseling param) {
        try {
            // Ambil ID topik dari request
            Integer topikId = param.getTopik().getId();

            // Cek dan ambil data topik dari DB
            Topik topik = mTopikRepository.findById(topikId)
                    .orElseThrow(() -> new RuntimeException("Topik tidak ditemukan"));

            // Set objek topik yang valid ke param
            param.setTopik(topik);

            // Simpan data
            boolean isSuccess = mKonselingService.saveKonseling(param);

            if (isSuccess) {
                return Map.of(
                        "status", 200,
                        "message", "Success",
                        "konId", param.getId()
                );
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                return new Result(500, "Failed to add konseling");
            }

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return new Result(400, "Error: " + e.getMessage());
        }
    }



    @PutMapping("/konseling")
    public Object updateKonseling(HttpServletResponse response, @RequestBody Konseling param) {
        boolean isSuccess = mKonselingService.updateKonseling(param);
        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Failed to update konseling");
        }
    }

    @DeleteMapping("/konseling")
    public Object deleteKonseling(HttpServletResponse response, @RequestParam int id) {
        boolean isSuccess = mKonselingService.deleteKonseling(id);
        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Failed to delete konseling");
        }
    }

    @GetMapping("/konseling")
    public Konseling getKonseling(@RequestParam int id) {
        Konseling konseling = mKonselingService.getKonseling(id);
        return konseling;
    }

    @GetMapping("/detailKonselings")
    public List<DetailKonseling> getDetailKonselings() {
        List<DetailKonseling> detailKonselingList = mDetailKonselingService.getDetailKonselings();
        return detailKonselingList;
    }

    @PostMapping("/detailKonseling")
    public Object saveDetailKonseling(HttpServletResponse response, @RequestBody DetailKonseling param) {
        boolean isSuccess = mDetailKonselingService.saveDetailKonseling(param);
        if (isSuccess) {
            return new Result(200, "Succes");
        }else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Failed to add detailKonseling");
        }
    }

    @PutMapping("/detailKonseling")
    public Object updateDetailKonseling(HttpServletResponse response, @RequestBody DetailKonseling param) {
        boolean isSuccess = mDetailKonselingService.updateDetailKonseling(param);
        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Failed to update detailKonseling");
        }
    }

    @DeleteMapping("/detailKonseling")
    public Object deleteDetailKonseling(HttpServletResponse response, @RequestParam int id) {
        boolean isSuccess = mDetailKonselingService.deleteDetailKonseling(id);
        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Failed to delete detailKonseling");
        }
    }

    @GetMapping("/detailKonseling")
    public DetailKonseling getDetailKonseling(@RequestParam int id) {
        DetailKonseling detailKonseling = mDetailKonselingService.getDetailKonseling(id);
        return detailKonseling;
    }

}
