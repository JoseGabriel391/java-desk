/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Pedido {
    protected int idPedido;
    protected Mozo mozo;
    protected Menu menu;
    protected float monto;
    protected String turno;

    public Pedido() {
    }

    public Pedido(int idPedido, Mozo mozo, Menu menu, float monto, String turno) {
        this.idPedido = idPedido;
        this.mozo = mozo;
        this.menu = menu;
        this.monto = monto;
        this.turno = turno;
    }

    public Pedido(Mozo mozo, Menu menu, float monto, String turno) {
        this.mozo = mozo;
        this.menu = menu;
        this.monto = monto;
        this.turno = turno;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Mozo getMozo() {
        return mozo;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", mozo=" + mozo + ", menu=" + menu + ", monto=" + monto + ", turno=" + turno + '}';
    }
    
    
}
