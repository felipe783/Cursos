

public final class Manager extends Employee{ //Ele extende a classe, em resumo ele vai pegar todas as variaveis,e metodos da classe employee e aplicar em Manager, O employee é a Super-Classe ou classe Pai
    private String login;
    private String password;
    private double commission;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
}
