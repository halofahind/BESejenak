package com.sejenak.be_sejenakapp.vo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ms_topik")
public class Topik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tpk_id")
    private Integer id;

    @Column(name = "tpk_nama")
    private String nama;

    @Column(name = "tpk_pesan_pertama")
    private String pesanPertama;

    @Column(name = "tpk_pesan_terakhir")
    private String pesanTerakhir;

    @Column(name = "tpk_created_by")
    private String createdBy;

    @Column(name = "tpk_created_date")
    private LocalDateTime createdDate;

    @Column(name = "tpk_modif_by")
    private String modifBy;

    @Column(name = "tpk_modif_date")
    private LocalDateTime modifDate;


    public Topik() {}

    public Topik(Integer id, String nama, String pesanPertama, String pesanTerakhir, String createdBy, LocalDateTime createdDate, String modifBy, LocalDateTime modifDate) {
        this.id = id;
        this.nama = nama;
        this.pesanPertama = pesanPertama;
        this.pesanTerakhir = pesanTerakhir;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifBy = modifBy;
        this.modifDate = modifDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPesanPertama() {
        return pesanPertama;
    }

    public void setPesanPertama(String pesanPertama) {
        this.pesanPertama = pesanPertama;
    }

    public String getPesanTerakhir() {
        return pesanTerakhir;
    }

    public void setPesanTerakhir(String pesanTerakhir) {
        this.pesanTerakhir = pesanTerakhir;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifBy() {
        return modifBy;
    }

    public void setModifBy(String modifBy) {
        this.modifBy = modifBy;
    }

    public LocalDateTime getModifDate() {
        return modifDate;
    }

    public void setModifDate(LocalDateTime modifDate) {
        this.modifDate = modifDate;
    }
}
