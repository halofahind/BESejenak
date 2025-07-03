package com.sejenak.be_sejenakapp.service;

import com.sejenak.be_sejenakapp.repository.DetailKonselingRepository;
import com.sejenak.be_sejenakapp.repository.KonselingRepository;
import com.sejenak.be_sejenakapp.vo.DetailKonseling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailKonselingService {
    @Qualifier("DetailKonselingRepository")
    @Autowired
    DetailKonselingRepository mDetailKonselingRepository;

    public DetailKonseling getDetailKonseling(int id){
        DetailKonseling DetailKonseling = mDetailKonselingRepository.getDetailKonselingById(id);
        return DetailKonseling;
    }

    public List<DetailKonseling> getDetailKonselings(){
        List<DetailKonseling> konselingList = mDetailKonselingRepository.findAll();
        return konselingList;
    }

    public boolean saveDetailKonseling(DetailKonseling detailKonseling){
        DetailKonseling result = mDetailKonselingRepository.save(detailKonseling);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return  isSuccess;
    }
    public boolean updateDetailKonseling(DetailKonseling detailKonseling){
        DetailKonseling result = mDetailKonselingRepository.getDetailKonselingById(detailKonseling.getId());
        if (result == null){
            return false;
        }
//        if (StringUtils.hasLength(konseling.get())){
//            result.setAbout(konseling.getUsername());
//        }
        mDetailKonselingRepository.save(result);
        return true;
    }

    public boolean deleteDetailKonseling(int id){
        DetailKonseling result = mDetailKonselingRepository.getDetailKonselingById(id);
        if (result == null){
            return false;
        }
        mDetailKonselingRepository.delete(result);
        return true;
    }
}
