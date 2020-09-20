package clases;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDB implements Serializable {
    private int id;
    private String nombre;
    private String username;
    private String password;
    
    public UsuarioDB(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static List<UsuarioDB> doLogin( DB db, String user, String pass) throws Exception{
        List<UsuarioDB> list = new ArrayList<UsuarioDB>();
        PreparedStatement prepareState = null;
        ResultSet resulset = null;
        
        try{
            if(db==null){
                db = new DB();
            }
            String sql = "SELECT id, nombre FROM users WHERE username=? AND password=?";
            prepareState.setString(1, user);
            prepareState.setString(2, pass);
            
            resulset = prepareState.executeQuery();
            while(resulset.next()){
                list.add(new UsuarioDB(resulset.getInt(1), resulset.getString(2)));
            }
        }catch(Exception e){
            System.out.println("ERROR" + e.getMessage());
        }
        
        return list;
    }
}
