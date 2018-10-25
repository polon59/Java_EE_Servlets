package src.main.java;

public class Login{

    private String login = "admin";
    private String password = "1234";

    protected Login(){
        this.login = "admin";
        this.password = "1234";
    }

    public boolean validate(String recivedLogin, String recivedPassword){
        if (recivedLogin.equals(login) && recivedPassword.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
}