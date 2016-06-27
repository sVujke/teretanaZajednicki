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
public class IstorijatPaketa extends AbstractObjekat{
    private boolean aktivan;
    private Date datumOdabira;
    private Clan clan;
    private Paket paket;
    private String id;

    public IstorijatPaketa() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public IstorijatPaketa(boolean aktivan, Date datumOdabira, Clan clan, Paket paket, String id) {
        this.aktivan = aktivan;
        this.datumOdabira = datumOdabira;
        this.clan = clan;
        this.paket = paket;
        this.id = id;
    }
    
    

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Date getDatumOdabira() {
        return datumOdabira;
    }

    public void setDatumOdabira(Date datumOdabira) {
        this.datumOdabira = datumOdabira;
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
        return "istorijatpaketa";
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiParametre() {
        int aktivanBr = 0;
        Date datumSQL = new java.sql.Date(getDatumOdabira().getTime());
        if(aktivan){
            aktivanBr =1;
        }
        return String.format("'%s', '%s', '%s', '%s', '%s'", aktivanBr, datumSQL, clan.getClanId(), paket.getPaketId(), id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        return "id";//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiPK() {
        return id;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObjekat> izRsUTabelu(ResultSet rs) {
        List<AbstractObjekat> listaIP = new ArrayList<>();
        try {
            while (rs.next()) {

                Boolean aktivan = rs.getBoolean("aktivan");
                Date datumOdabira = rs.getDate("datumOdabira");
                String clanId = rs.getString("clanId");
                String paketId = rs.getString("paketId");
                String id = rs.getString("id");
               
                IstorijatPaketa ip = new IstorijatPaketa(aktivan, datumOdabira,
                        new Clan(clanId, null, null, null, null, null, null),
                        new Paket(paketId, null, null), id);
                listaIP.add(ip);
            }
        } catch (SQLException ex) {
            System.out.println("Greska RSuTabelu kod clana");
        }
        return listaIP;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUpdateUpit() {
        Date datumSQL = new java.sql.Date(getDatumOdabira().getTime());
        int rd = 0;
        if(aktivan == true){
            rd = 1;
        }else{
            rd = 0;
        }
         return String.format("aktivan='%s',datumOdabira='%s',clanId='%s'"
                 + ",paketId='%s',id='%s'"
                 , rd, datumSQL, clan.getClanId(), paket.getPaketId(), id);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSlozeniPK() {
        return " WHERE id=" + id + " AND paketId=" + getPaket().getPaketId() +
                " AND clanId="+getClan().getClanId();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void postaviVrednostPK(String lastId) {
        this.id = lastId;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
