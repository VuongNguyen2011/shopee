/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nguyen
 */
public class Ncc {
    private String nccID;
    private String nccName;
    private String sdt;
    private String email;
    private String diachi;

    public String getNccID() {
        return nccID;
    }

    public Ncc() {
    }

    public Ncc(String nccName, String sdt, String email, String diachi) {
        this.nccName = nccName;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
    }

    public Ncc(String nccID, String nccName, String sdt, String email, String diachi) {
        this.nccID = nccID;
        this.nccName = nccName;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
    }

    public void setNccID(String nccID) {
        this.nccID = nccID;
    }

    public String getNccName() {
        return nccName;
    }

    public void setNccName(String nccName) {
        this.nccName = nccName;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
}
