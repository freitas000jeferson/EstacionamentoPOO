package Model;

public class Estacionamento {
    private int idEstacionamento;
    private String nome;
    private String login;
    private String senha;
    private int qntAndar;

    Estacionamento(String nome, int qntAndar, String login, String senha){
        this.nome = nome;
        this.qntAndar = qntAndar;
        this.login = login;
        this.senha = senha;
    }
    
    Estacionamento(){
        this.nome = "Exemplo";
        this.qntAndar = 2;
        this.login = "admin";
        this.senha = "admin";
    }
    
    
    public int getIdEstacionamento() {
        return idEstacionamento;
    }

    public void setIdEstacionamento(int idEstacionamento) {
        this.idEstacionamento = idEstacionamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getQntAndar() {
        return qntAndar;
    }

    public void setQntAndar(int qntAndar) {
        this.qntAndar = qntAndar;
    }
    
}
