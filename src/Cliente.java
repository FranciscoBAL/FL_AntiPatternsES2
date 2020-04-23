public class Cliente {
    private String nome;
    private int idade;
    private String tipoCarta;
    private String morada;

    public Cliente(String nome, int idade, String tipoCarta, String morada) {
        this.nome = nome;
        this.idade = idade;
        this.tipoCarta = tipoCarta;
        this.morada = morada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTipoCarta() {
        return tipoCarta;
    }

    public void setTipoCarta(String tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }
}
