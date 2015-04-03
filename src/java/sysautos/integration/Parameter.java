/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.integration;

/**
 *
 * @author hp
 */
public class Parameter {

    private int posicion;
    private Object valor;
    private int tipoDato;

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public int getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(int tipoDato) {
        this.tipoDato = tipoDato;
    }

    public Parameter(int posicion, Object valor, int tipoDato) {
        this.posicion = posicion;
        this.valor = valor;
        this.tipoDato = tipoDato;
    }
}
