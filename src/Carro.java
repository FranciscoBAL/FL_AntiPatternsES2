public class Carro {
    private int ano;
    private String matricula;
    private String marca;
    private String modelo;
    private Cliente dono;
    private int preco;

    public Carro(int ano, String matricula, String marca, String modelo, Cliente dono, int preco) {
        this.ano = ano;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.dono = dono;
        this.preco = preco;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
