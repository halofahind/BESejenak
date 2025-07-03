package com.sejenak.be_sejenakapp.service;

import com.sejenak.be_sejenakapp.repository.PenggunaRepository;
import com.sejenak.be_sejenakapp.vo.Pengguna;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PenggunaService {
    @Qualifier("PenggunaRepository")
    @Autowired
    PenggunaRepository mPenggunaRepository;

    public Pengguna getPenggunaUsername(String id){
        Pengguna Pengguna = mPenggunaRepository.getUserByUsername(id);
        return Pengguna;
    }
    public Pengguna getPengguna(int id){
        Pengguna Pengguna = mPenggunaRepository.getPenggunaById(id);
        return Pengguna;
    }

    public List<Pengguna> getPenggunas(){
        List<Pengguna> penggunaList = mPenggunaRepository.findAll();
        return penggunaList;
    }

    public boolean savePengguna(Pengguna pengguna){
        Pengguna result = mPenggunaRepository.save(pengguna);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return  isSuccess;
    }
    public boolean updatePengguna(Pengguna pengguna){
        Pengguna result = mPenggunaRepository.getUserByUsername(pengguna.getUsername());
        if (result == null){
            return false;
        }
        if (StringUtils.hasLength(pengguna.getUsername())){
            result.setAbout(pengguna.getUsername());
        }
        mPenggunaRepository.save(result);
        return true;
    }

    public boolean deletePengguna(String id){
        Pengguna result = mPenggunaRepository.getUserByUsername(id);
        if (result == null){
            return false;
        }
        mPenggunaRepository.delete(result);
        return true;
    }

    public Pengguna login( String username, String password) {
        return mPenggunaRepository.findByUsernameAndPassword( username, password);
    }
}
