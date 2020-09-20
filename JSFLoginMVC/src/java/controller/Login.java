/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import clases.Conexion;

public class Login {
    private String respuesta;
    

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public Login(){
    }
    
    public String  conectarUsuario(String usuario, String password){
        this.respuesta = "el usuario y contrasena" + usuario + " " + password;
        if (!usuario.equals("") || !password.equals("")) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select tipo_nivel, estatus from usuarios where username = '" + usuario
                        + "' and password = '" + password + "'");

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    String tipo_nivel = rs.getString("tipo_nivel");
                    String estatus = rs.getString("estatus");
                    
                    if (tipo_nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")) {
                        this.respuesta = "usuario Administrador";
                    }else if (tipo_nivel.equalsIgnoreCase("Capturista") && estatus.equalsIgnoreCase("Activo")) {
                        this.respuesta = "usuario Capturista";
                    }else if (tipo_nivel.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {
                        this.respuesta = "usuario Tecnico";
                    }
                }else{
                   this.respuesta = "Datos incorrectos"; 
                }
                
            } catch (Exception e) {
                this.respuesta = "Error al conectarse" + e.getMessage();
            }
        }else{
            this.respuesta = "Debes ingresar el usuario y contrasena";
        }
       return this.respuesta; 
    }
}
