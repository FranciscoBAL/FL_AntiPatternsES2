import java.time.LocalDate;

public class Aluguer {
    private Carro carro;
    private LocalDate dataAluguer;
    private LocalDate fimAluguer;
    private int custoMensal;
    private Cliente cliente;

    public Aluguer(Carro carro, LocalDate dataAluguer, LocalDate fimAluguer, int custoMensal, Cliente cliente) {
        this.carro = carro;
        this.dataAluguer = dataAluguer;
        this.fimAluguer = fimAluguer;
        this.custoMensal = custoMensal;
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public LocalDate getDataAluguer() {
        return dataAluguer;
    }

    public void setDataAluguer(LocalDate dataAluguer) {
        this.dataAluguer = dataAluguer;
    }

    public LocalDate getFimAluguer() {
        return fimAluguer;
    }

    public void setFimAluguer(LocalDate fimAluguer) {
        this.fimAluguer = fimAluguer;
    }

    public int getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(int custoMensal) {
        this.custoMensal = custoMensal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
