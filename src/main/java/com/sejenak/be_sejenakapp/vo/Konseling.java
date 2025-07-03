package com.sejenak.be_sejenakapp.vo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tr_konsultasi")
public class Konseling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kon_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "kon_topik") // foreign key
    private Topik topik;

    @Column(name = "usr_id", nullable = false)
    private Integer userId;

    @Column(name = "kon_tgl_mulai")
    private LocalDateTime tglMulai;

    @Column(name = "kon_tgl_selesai")
    private LocalDateTime tglSelesai;

    @Column(name = "kon_status")
    private String status;

    @Column(name = "kon_created_by")
    private String createdBy;

    @Column(name = "kon_created_date")
    private LocalDateTime createdDate;

    @Column(name = "kon_modif_by")
    private String modifBy;

    @Column(name = "kon_modif_date")
    private LocalDateTime modifDate;

    public Konseling() {
    }



    public Konseling(Integer id,Topik topik, Integer userId, LocalDateTime tglMulai, LocalDateTime tglSelesai, String status, String createdBy, LocalDateTime createdDate, String modifBy, LocalDateTime modifDate) {
        this.id = id;
        this.topik = topik;
        this.userId = userId;
        this.tglMulai = tglMulai;
        this.tglSelesai = tglSelesai;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifBy = modifBy;
        this.modifDate = modifDate;
    }

    public Topik getTopik() {
        return topik;
    }

    public void setTopik(Topik topik) {
        this.topik = topik;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getTglMulai() {
        return tglMulai;
    }

    public void setTglMulai(LocalDateTime tglMulai) {
        this.tglMulai = tglMulai;
    }

    public LocalDateTime getTglSelesai() {
        return tglSelesai;
    }

    public void setTglSelesai(LocalDateTime tglSelesai) {
        this.tglSelesai = tglSelesai;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
