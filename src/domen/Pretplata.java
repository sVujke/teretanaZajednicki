/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vujke
 */
public class Pretplata extends AbstractObjekat{
    private String pretplataId;
    private Date datum;
    private Clan clan;
    private Paket paket;

    public Pretplata(String pretplataId, Date datum, Clan clan, Paket paket) {
        this.pretplataId = pretplataId;
        this.datum = datum;
        this.clan = clan;
        this.paket = paket;
    }
    
    

    public String getPretplata() {
        return pretplataId;
    }

    public void setPretplata(String pretplata) {
        this.pretplataId = pretplata;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Paket getPaket() {
        return paket;
    }

    public void setPaket(Paket paket) {
        this.paket = paket;
    }

    @Override
    public String vratiImeTabele() {
        return "pretplata";//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiParametre() {
        Date datumSQL = new java.sql.Date(getDatum().getTime());
        return String.format("'%s', '%s', '%s', '%s'", pretplataId, datumSQL, clan.getClanId(),paket.getPaketId());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        return "pretplataId"; //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiPK() {
        return pretplataId;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObjekat> izRsUTabelu(ResultSet rs) {
        List<AbstractObjekat> pretplate = new ArrayList<>();
        try {
            while (rs.next()) {

                String pretplataId = rs.getString("dolazakId");
                Date datum = rs.getDate("datum");
                String clanId = rs.getString("smena");
                String paketId = rs.getString("paketId");
    
                Pretplata p = new Pretplata(pretplataId,
                datum, new Clan(clanId, null, null, null, null, null, null), 
                new Paket(paketId, null, null));
                
                pretplate.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Greska RSuTabelu kod clana");
        }
        return pretplate;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUpdateUpit() {
        Date datumSQL = new java.sql.Date(getDatum().getTime());
        return String.format("pretplataId='%s',datum='%s',clanId='%s',,paketId='%s'",pretplataId,datumSQL, clan.getClanId(), paket.getPaketId());
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSlozeniPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
