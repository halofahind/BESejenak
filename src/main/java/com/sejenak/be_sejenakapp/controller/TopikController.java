package com.sejenak.be_sejenakapp.controller;

import com.sejenak.be_sejenakapp.repository.TopikRepository;
import com.sejenak.be_sejenakapp.service.TopikService;
import com.sejenak.be_sejenakapp.service.TopikService;
import com.sejenak.be_sejenakapp.vo.Topik;
import com.sejenak.be_sejenakapp.vo.Result;
import com.sejenak.be_sejenakapp.vo.Topik;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopikController {
    @Autowired
    TopikService mTopikService;

    @GetMapping("/topiks")
    public List<Topik> getTopiks() {
        List<Topik> topikList = mTopikService.getTopiks();
        return topikList;
    }

    @PostMapping("/topik")
    public Object saveTopik(HttpServletResponse response, @RequestBody Topik param) {
        boolean isSuccess = mTopikService.saveTopik(param);
        if (isSuccess) {
            return new Result(200, "Succes");
        }else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Failed to add topik");
        }
    }

    @PutMapping("/topik")
    public Object updateTopik(HttpServletResponse response, @RequestBody Topik param) {
        boolean isSuccess = mTopikService.updateTopik(param);
        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Failed to update topik");
        }
    }

    @DeleteMapping("/topik/{id}")
    public Object deleteTopik(@PathVariable int id) {
        boolean isSuccess = mTopikService.deleteTopik(id);
        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Result(500, "Failed to delete topik"));
        }
    }


    @GetMapping("/topik")
    public Topik getTopik(@RequestParam int id) {
        Topik topik = mTopikService.getTopik(id);
        return topik;
    }

}
