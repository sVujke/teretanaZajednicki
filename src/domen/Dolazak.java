/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vujke
 */
public class Dolazak extends AbstractObjekat{
    private String dolazakId;
    private Date datum;
    private String smena;
    private boolean radniDan;
    private Clan clan;

    public Dolazak() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDolazakId() {
        return dolazakId;
    }

    public Dolazak(String dolazakId, Date datum, String smena, boolean radniDan, Clan clan) {
        this.dolazakId = dolazakId;
        this.datum = datum;
        this.smena = smena;
        this.radniDan = radniDan;
        this.clan = clan;
    }

    @Override
    public String toString() {
        return datum +"=" + datum + ", smena=" + smena + ", radniDan=" + radniDan + '}';
    }

    

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    @Override
    public String vratiImeTabele() {
        return "dolazak";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiParametre() {
        Date datumSQL = new java.sql.Date(getDatum().getTime());
        int rd = 0;
        if(radniDan == true){
            rd = 1;
        }else{
            rd = 0;
        }
        return String.format("'%s', '%s', '%s', '%s', '%s'", dolazakId, datumSQL, smena, rd, clan.getClanId());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        return dolazakId;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiPK() {
        return dolazakId;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObjekat> izRsUTabelu(ResultSet rs) {
        List<AbstractObjekat> dolasci = new ArrayList<>();
        try {
            while (rs.next()) {

                String dolazakId = rs.getString("dolazakId");
                Date datum = rs.getDate("datum");
                String smena = rs.getString("smena");
                Boolean radniDan = rs.getBoolean("radniDan");
                String clanId = rs.getString("clanId");
               
                Dolazak d = new Dolazak(clanId, datum, smena, radniDan,  new Clan(clanId, null, null, null, null, null, null));
                dolasci.add(d);
            }
        } catch (SQLException ex) {
            System.out.println("Greska RSuTabelu kod clana");
        }
        return dolasci;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUpdateUpit() {
        Date datumSQL = new java.sql.Date(getDatum().getTime());
        int rd = 0;
        if(radniDan == true){
            rd = 1;
        }else{
            rd = 0;
        }
         return String.format("dolazakId='%s',datum='%s',smena='%s',radniDan='%s',clanId='%s'", dolazakId, datumSQL, smena, rd, clan.getClanId());
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSlozeniPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPK(String lastId) {
        this.dolazakId = lastId;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
