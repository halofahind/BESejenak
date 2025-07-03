package com.sejenak.be_sejenakapp.service;

import com.sejenak.be_sejenakapp.repository.TopikRepository;
import com.sejenak.be_sejenakapp.repository.TopikRepository;
import com.sejenak.be_sejenakapp.vo.Topik;
import com.sejenak.be_sejenakapp.vo.Topik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TopikService {
    @Qualifier("TopikRepository")
    @Autowired
    TopikRepository mTopikRepository;

    public Topik getTopik(int id){
        Topik topik = mTopikRepository.getTopikById(id);
        return topik;
    }

    public List<Topik> getTopiks(){
        List<Topik> topikList = mTopikRepository.findAll();
        return topikList;
    }

    public boolean saveTopik(Topik topik){
        Topik result = mTopikRepository.save(topik);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return  isSuccess;
    }
    public boolean updateTopik(Topik topik){
        Topik result = mTopikRepository.getTopikById(topik.getId());
        if (result == null){
            return false;
        }
        if (StringUtils.hasLength(topik.getNama())){
            result.setNama(topik.getNama());
        }
        mTopikRepository.save(result);
        return true;
    }

    public boolean deleteTopik(int id){
        Topik result = mTopikRepository.getTopikById(id);
        if (result == null){
            return false;
        }
        mTopikRepository.delete(result);
        return true;
    }

}
