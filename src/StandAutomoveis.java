import java.time.LocalDate;
import java.util.ArrayList;

public class StandAutomoveis {
    private static volatile StandAutomoveis instance;
    private ArrayList<Carro> listaVeiculosDisponiveis = new ArrayList<>();
    private ArrayList<Aluguer> listaAlugueres = new ArrayList<>();
    private ArrayList<Venda> listaVendas = new ArrayList<>();
    private int numMaximoVeiculos;

    private StandAutomoveis() {
        this.numMaximoVeiculos = 30;
        Carro carro = new Carro(2000, "12-SG-93", "Fiat", "Punto", null, 10000);
        for (int i = 0; i < numMaximoVeiculos; i++) {
            listaVeiculosDisponiveis.add(carro);
        }
    }

    public static StandAutomoveis getInstance() {
        if (instance == null) {
            synchronized (StandAutomoveis.class) {
                if (instance == null) {
                    instance = new StandAutomoveis();
                }
            }
        }
        return instance;
    }

    public synchronized Aluguer alugarVeiculo(Cliente cliente) throws VeiculosEsgotadosException{
        if (listaVeiculosDisponiveis.size() == 0){
            throw new VeiculosEsgotadosException();
        }
        else{
            Carro carro = listaVeiculosDisponiveis.get(listaVeiculosDisponiveis.size() - 1);
            carro.setDono(cliente);
            Aluguer aluguer = new Aluguer(carro, LocalDate.now(), null, carro.getPreco()/100, cliente);
            listaAlugueres.add(aluguer);
            listaVeiculosDisponiveis.remove(carro);
            return aluguer;
        }
    }

    public synchronized void devolverVeiculo(Aluguer aluguer) throws VeiculoNaoExisteException{
        if(!listaAlugueres.contains(aluguer)){
            throw new VeiculoNaoExisteException();
        }
        else{
            listaAlugueres.remove(aluguer);
            listaVeiculosDisponiveis.add(aluguer.getCarro());
        }
    }

    public synchronized Venda venderCarro(Cliente cliente) throws VeiculosEsgotadosException{
        if (listaVeiculosDisponiveis.size() + listaAlugueres.size() == this.numMaximoVeiculos){
            throw new VeiculosEsgotadosException();
        }
        else{
            Carro carro = listaVeiculosDisponiveis.get(listaVeiculosDisponiveis.size() - 1);
            carro.setDono(cliente);
            Venda venda = new Venda(carro, LocalDate.now(), carro.getPreco(), cliente);
            listaVendas.add(venda);
            listaVeiculosDisponiveis.remove(carro);
            return venda;
        }
    }

    public synchronized void resetStand(){
        listaVeiculosDisponiveis.clear();
        listaAlugueres.clear();
        listaVendas.clear();
    }

    public synchronized void setNumMaximoVeiculos(int size){
        if (numMaximoVeiculos < size){
            Carro carro = new Carro(2000, "12-SG-93", "Fiat", "Punto", null, 10000);
            for (int i = numMaximoVeiculos; i < size; i++) {
                listaVeiculosDisponiveis.add(carro);
            }
        }
        this.numMaximoVeiculos = size;
    }
}
