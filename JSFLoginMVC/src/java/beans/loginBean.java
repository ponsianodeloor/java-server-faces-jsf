package beans;

import controller.Login;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class loginBean {
    private String usuario;
    private String password;
    private String respuesta;
    private Login login = new Login();

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    public loginBean() {
    }
    
    public void obtenerUsuario(){
        
        //this.respuesta = "usuario "+ this.usuario + " " + this.password +" y contrasena correctos";
        this.respuesta = login.conectarUsuario(this.usuario, this.password);
    }

    
    
}
