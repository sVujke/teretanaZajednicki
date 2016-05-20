/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vujke
 */
public class Clan extends AbstractObjekat {
    private String clanId;
    private String ime;
    private String prezime;
    private String email;
    private String adresa;
    private String telefon;
    private Mesto mesto;

    public Clan(String clanId, String ime, String prezime, String email, String adresa, String telefon, Mesto mesto) {
        this.clanId = clanId;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.adresa = adresa;
        this.telefon = telefon;
        this.mesto = mesto;
    }
    
    

    public String getClanId() {
        return clanId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String vratiImeTabele() {
        return "clan"; //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s', '%s', '%s', '%s'", clanId, ime, prezime, email, adresa, telefon, mesto.getMestoid());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        return "clanId";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiPK() {
        return clanId;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObjekat> izRsUTabelu(ResultSet rs) {
        List<AbstractObjekat> clanovi = new ArrayList<>();
        try {
            while (rs.next()) {

                String id = rs.getString("clanId");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String email = rs.getString("email");
                String adresa = rs.getString("adresa");
                String telefon = rs.getString("telefon");
                String mestoId = rs.getString("mestoId");
                Clan c = new Clan(clanId, ime, prezime, email, adresa, telefon, new Mesto(null, null, mestoId));
                clanovi.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Greska RSuTabelu kod clana");
        }
        return clanovi;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUpdateUpit() {
        return String.format("clanId='%s',ime='%s',prezime='%s',email='%s',adresa='%s',telefon='%s',mestoId='%s'", clanId, ime, prezime, email, adresa, telefon, mesto.getMestoid());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSlozeniPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
