/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author vujke
 */
public class Paket extends AbstractObjekat{
    
    private String paketId;
    private String naziv;
    private String cena;
    private List<Termin> termini;

    public Paket(String paketId, String naziv, String cena) {
        this.paketId = paketId;
        this.naziv = naziv;
        this.cena = cena;
    }

    public Paket() {
    }
    
    

    @Override
    public String toString() {
        return naziv+" - "+cena+" RSD";
    }
    
    

    public String getPaketId() {
        return paketId;
    }

    public void setPaketId(String paketId) {
        this.paketId = paketId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    @Override
    public String vratiImeTabele() {
       return "paket";
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", paketId, naziv, cena);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        return "paketId";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiPK() {
        return paketId;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObjekat> izRsUTabelu(ResultSet rs) {
        List<AbstractObjekat> paketi = new ArrayList<>();
        try {
            while (rs.next()) {
                String paketId = rs.getString("paketId");
                String naziv = rs.getString("naziv");
                String cena = rs.getString("cena");
                
                Paket p = new Paket(paketId, naziv, cena);
                paketi.add(p);
                //System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Greska kod stavki rezervacije.");
        }
        return paketi;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUpdateUpit() {
        return String.format("paketId='%s',naziv='%s',cena='%s'",paketId,naziv, cena);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSlozeniPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPK(String lastId) {
        this.paketId = lastId;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.paketId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paket other = (Paket) obj;
        if (!Objects.equals(this.paketId, other.paketId)) {
            return false;
        }
        return true;
    }

    public List<Termin> getTermini() {
        return termini;
    }

    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }
    
    
}
