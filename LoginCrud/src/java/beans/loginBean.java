package beans;

import clases.UsuarioDB;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class loginBean {

    private String msgClass;
    private String message;
    private String username;
    private String password;

    public String getMsgClass() {
        return msgClass;
    }

    public void setMsgClass(String msgClass) {
        this.msgClass = msgClass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
    
    public loginBean() {
        this.msgClass = "info";
        this.message = "Ingrese usuario y password";
    }
    
    public void doLogin(){
        
        try{
            List<UsuarioDB> usuario = UsuarioDB.doLogin(null, this.username, this.password);
            if(usuario.size() > 0){
                this.message = "Bienvennido " + usuario.get(0).getNombre();
                this.msgClass = "success";
            }else{
                this.message = "Usuario y clave incorrectos";
                this.msgClass = "danger";
            }
        }catch (Exception e){
            System.out.println("Error" + e.getMessage());
        }
        
        
    }
    
}
