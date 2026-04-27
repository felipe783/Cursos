package Ex_03.Banco;

public class Conta {
    private double saldo;
    private double chequeEspecial;
    private boolean usando;

    public Conta(double saldo, double chequeEspecial) {
        this.saldo = saldo;
        this.chequeEspecial = (chequeEspecial<=500) ? 50 : chequeEspecial * 0.5;
        this.usando = false;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public boolean getUsando() {
        return usando;
    }

    public void setUsando(boolean usando) {
        this.usando = usando;
    }
}
