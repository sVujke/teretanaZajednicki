/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vujke
 */
public class Termin extends AbstractObjekat{
    private String smena;
    private boolean radniDan;
    private Paket paket;
    private String id;

    public Termin(String smena, boolean radniDan, Paket paket, String id) {
        this.smena = smena;
        this.radniDan = radniDan;
        this.paket = paket;
        this.id = id;
    }

    public Termin() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public String getSmena() {
        return smena;
    }

    public void setSmena(String smena) {
        this.smena = smena;
    }

    public boolean isRadniDan() {
        return radniDan;
    }

    public void setRadniDan(boolean radniDan) {
        this.radniDan = radniDan;
    }

    public Paket getPaket() {
        return paket;
    }

    public void setPaket(Paket paket) {
        this.paket = paket;
    }

    @Override
    public String vratiImeTabele() {
        return "termin";//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiParametre() {
        
        int rad = 0;
        if(radniDan == true){
            rad = 1;
        }
        return String.format("'%s', '%s', '%s', '%s'", id , smena, rad, paket.getPaketId());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        return "terminId";//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiPK() {
        return id;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObjekat> izRsUTabelu(ResultSet rs) {
        List<AbstractObjekat> termini = new ArrayList<>();
        try {
            while (rs.next()) {
                String terminId = rs.getString("terminId");
                String smena= rs.getString("smena");
                Boolean radniDan = rs.getBoolean("radniDan");
                String paketId = rs.getString("paketId");
                
                Termin t = new Termin(smena, radniDan, new Paket(paketId, null, null), terminId);
                termini.add(t);
                //System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Greska kod stavki rezervacije.");
        }
        return termini;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUpdateUpit() {
        int br = 0;
        if(radniDan == true){
            br = 1;
        }
        return String.format("terminId='%s',smena='%s',radniDan='%s',paketId='%s'",id,smena, br, paket.getPaketId());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSlozeniPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPK(String lastId) {
        id = lastId;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
