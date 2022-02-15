/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


public class DtoPedido {
    protected String descripcion;
    protected String nombre;
    protected float importe;
    protected String turno;

    public DtoPedido() {
    }

    public DtoPedido(String descripcion, String nombre, float importe, String turno) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.importe = importe;
        this.turno = turno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "dtoPedido{" + "descripcion=" + descripcion + ", nombre=" + nombre + ", importe=" + importe + ", turno=" + turno + '}';
    }
    
    
}
