/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author vujke
 */
public class ServerTransfer implements Serializable {
    private Object podaci;
    private int uspesnostOperacije;
    private Exception exception;

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public int getUspesnostOperacije() {
        return uspesnostOperacije;
    }

    public void setUspesnostOperacije(int uspesnostOperacije) {
        this.uspesnostOperacije = uspesnostOperacije;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    
    
}
