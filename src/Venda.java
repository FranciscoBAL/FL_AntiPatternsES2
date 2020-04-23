import java.time.LocalDate;

public class Venda {
    private Carro carro;
    private LocalDate dataVenda;
    private int custo;
    private Cliente cliente;

    public Venda(Carro carro, LocalDate dataVenda, int custo, Cliente cliente) {
        this.carro = carro;
        this.dataVenda = dataVenda;
        this.custo = custo;
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
