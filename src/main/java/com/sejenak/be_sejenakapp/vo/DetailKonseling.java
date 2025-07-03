package com.sejenak.be_sejenakapp.vo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tr_konsultasi_detail")
public class DetailKonseling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "det_id")
    private Integer id;

    @Column(name = "kon_id")
    private Integer konId;

    @Column(name = "det_pengirim")
    private String pengirim;

    @Column(name = "det_pesan", columnDefinition = "TEXT")
    private String pesan;

    @Column(name = "det_waktu")
    private LocalDateTime waktu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKonId() {
        return konId;
    }

    public void setKonId(Integer konId) {
        this.konId = konId;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public LocalDateTime getWaktu() {
        return waktu;
    }

    public void setWaktu(LocalDateTime waktu) {
        this.waktu = waktu;
    }
}
