package com.sejenak.be_sejenakapp.vo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ms_user")
public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private int id;
    @Column(name = "usr_role", nullable = false)
    private String role;
    @Column(name = "usr_username")
    private String username;
    @Column(name = "usr_password")
    private String password;
    @Column(name = "usr_nama_lengkap")
    private String nama;

    @Column(name = "usr_tanggal_lahir")
    private Date tanggalLahir;

    @Column(name = "usr_gender")
    private String gender;

    @Column(name = "usr_hobi")
    private String hobi;

    @Column(name = "usr_telepon")
    private String telepon;

    @Column(name = "usr_email")
    private String email;

    @Column(name = "usr_about")
    private String about;

    @Column(name = "usr_created_by")
    private String createdBy;

    @Column(name = "usr_created_date")
    private Date createdDate;

    @Column(name = "usr_modif_by")
    private String modifBy;

    @Column(name = "usr_modif_date")
    private Date modifDate;

    public Pengguna() {
    }

    public Pengguna(String role, String username, String password) {
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public Pengguna(int id, String role, String username, String password, String nama, Date tanggalLahir, String gender, String hobi, String telepon, String email, String about, String createdBy, Date createdDate, String modifBy, Date modifDate) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.gender = gender;
        this.hobi = hobi;
        this.telepon = telepon;
        this.email = email;
        this.about = about;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifBy = modifBy;
        this.modifDate = modifDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifBy() {
        return modifBy;
    }

    public void setModifBy(String modifBy) {
        this.modifBy = modifBy;
    }

    public Date getModifDate() {
        return modifDate;
    }

    public void setModifDate(Date modifDate) {
        this.modifDate = modifDate;
    }
}
