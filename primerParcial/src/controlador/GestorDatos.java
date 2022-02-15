/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.DtoPedido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Menu;
import modelo.Mozo;
import modelo.Pedido;


public class GestorDatos {
    
    Connection conn;
    String cadena = "jdbc:sqlserver://localhost\\SOPINV-78\\SQLEXPRESS:1433;databaseName=Restaurant";
    String user = "sa";
    String pass = "sa123";
    
    public void abrirConexion(){
        try {
            conn = DriverManager.getConnection(cadena, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(GestorDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cerrarConexion(){
        try {
            if(conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Mozo> obtenerMozo(){
        ArrayList<Mozo> lista = new ArrayList<>();
        
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("select * from mozo");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                
                Mozo m = new Mozo(id, nombre);
                lista.add(m);
            }
            
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        finally
        {
            cerrarConexion();
        }
        return lista;
    }
    
    public ArrayList<Menu> obtenerMenu(){
        ArrayList<Menu> lista = new ArrayList<>();
        
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("select * from menu");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt(1);
                String descripcion = rs.getString(2);
                
                Menu m = new Menu(id, descripcion);
                lista.add(m);
            }
            
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            System.out.println("Error");
        }
        finally
        {
            cerrarConexion();
        }
        return lista;
    }
    
    public boolean insertarPedido(Pedido p){
        boolean inserto = false;
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("insert into pedido values(?,?,?,?)");
            ps.setInt(1, p.getMenu().getIdMenu());
            ps.setInt(2, p.getMozo().getId());
            ps.setFloat(3, p.getMonto());
            ps.setString(4, p.getTurno());
            ps.executeUpdate();
           
            ps.close();
            inserto = true;
        } catch (Exception e) {
            System.out.println("Error");
        }
        finally
        {
            cerrarConexion();
        }
        return inserto;
    }
    public int totalPedidoNoche(){
       int total = 0;
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("select count(*) from Pedido where turno = 'noche';");
            ResultSet rs = ps.executeQuery();
            rs.next();
            total = rs.getInt(1);
           
            ps.close();
            
        } catch (Exception e) {
            System.out.println("Error");
        }
        finally
        {
            cerrarConexion();
        }
        return total;
    }
    
    public ArrayList<DtoPedido> obtenerListadoSolicitado(int valor){
        ArrayList<DtoPedido> lista = new ArrayList<>();
        
        try {
            abrirConexion();
            
            PreparedStatement ps = conn.prepareStatement("Select me.Descripcion, m.Nombre, p.Monto, p.Turno \n" +
                                                            "  from Pedido p \n" +
                                                            "  join mozo m on p.IdMozo = m.IdMozo\n" +
                                                            "  join menu me on p.IdMenu = me.IdMenu\n" +
                                                            "  where p.Monto > ?;");
            ps.setInt(1, valor);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                String descripcion = rs.getString(1);
                String nombre = rs.getString(2);
                float importe = rs.getFloat(3);
                String turno = rs.getString(4);
                
                DtoPedido dto = new DtoPedido(descripcion, nombre, importe, turno);
                lista.add(dto);
            }
            
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        finally
        {
            cerrarConexion();
        }
        return lista;
    }
}
