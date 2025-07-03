package com.sejenak.be_sejenakapp.service;

import com.sejenak.be_sejenakapp.repository.KonselingRepository;
import com.sejenak.be_sejenakapp.repository.KonselingRepository;
import com.sejenak.be_sejenakapp.vo.Konseling;
import com.sejenak.be_sejenakapp.vo.Konseling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class KonselingService {
    @Qualifier("KonselingRepository")
    @Autowired
    KonselingRepository mKonselingRepository;

    public Konseling getKonseling(int id){
        Konseling Konseling = mKonselingRepository.getKonselingById(id);
        return Konseling;
    }

    public List<Konseling> getKonselings(){
        List<Konseling> konselingList = mKonselingRepository.findAll();
        return konselingList;
    }

    public boolean saveKonseling(Konseling konseling){
        Konseling result = mKonselingRepository.save(konseling);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return  isSuccess;
    }
    public boolean updateKonseling(Konseling konseling){
        Konseling result = mKonselingRepository.getKonselingById(konseling.getId());
        if (result == null){
            return false;
        }
//        if (StringUtils.hasLength(konseling.get())){
//            result.setAbout(konseling.getUsername());
//        }
        mKonselingRepository.save(result);
        return true;
    }

    public boolean deleteKonseling(int id){
        Konseling result = mKonselingRepository.getKonselingById(id);
        if (result == null){
            return false;
        }
        mKonselingRepository.delete(result);
        return true;
    }
}
