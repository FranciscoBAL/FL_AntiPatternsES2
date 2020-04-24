import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AntiPatternTesting {
    private static StandAutomoveis _standAutomoveis;
    private static Carro _carro;
    private static Cliente _cliente;
    private static Aluguer _aluguer;
    private static Venda _venda;

    //MotherHen
    //GenerousLeftover
    @BeforeAll
    static void initialize(){
        _standAutomoveis = StandAutomoveis.getInstance();
        _carro = new Carro(2000, "14-PE-01", "Fiat", "Punto", null, 10000);
        _cliente = new Cliente("Luis", 33, "ligeiros", "Viseu");
        _aluguer = new Aluguer(_carro, LocalDate.now(), null, 300, _cliente);
        _venda = new Venda(_carro, LocalDate.now(), _carro.getPreco(), _cliente);
    }

    //Test-per-Method
    //Dodger
    @Test
    public void testClienteSetNome(){
        _cliente.setNome("Siul");
        assertEquals("Siul", _cliente.getNome());
    }

    //Test-per-Method
    //Happy-Path
    @Test
    public void testClienteSetIdade(){
        _cliente.setIdade(93);
        assertEquals(93, _cliente.getIdade());
    }

    //Test-per-Method
    @Test
    public void testClienteSetMorada(){
        _cliente.setMorada("Lisboa");
        assertEquals("Lisboa", _cliente.getMorada());
    }

    //Test-per-Method
    @Test
    public void testClienteSetTipoCarta(){
        _cliente.setTipoCarta("ligeiros");
        assertEquals("ligeiros", _cliente.getTipoCarta());
    }

    //Enumerator
    //FreeRide
    @Test
    public void test1(){
        Carro carro = new Carro(2000, "12-SG-93", "Fiat", "Punto", null, 10000);
        Cliente cliente = new Cliente("Francisco", 48, "pesados", "Aveiro");

        carro.setDono(cliente);
        assertEquals(cliente, carro.getDono());
    }

    //NitPicker
    //Loudmouth?
    @Test
    public void testAluguerGetCusto(){
        Cliente cliente = new Cliente("Francisco", 48, "pesados", "Aveiro");
        Carro carro = new Carro(2000, "12-SG-93", "Fiat", "Punto", cliente, 10000);

        System.out.println("Foi criado um carro:");
        System.out.println("\nMarca: " + carro.getMarca());
        System.out.println("\nModelo: " + carro.getModelo());
        System.out.println("\nAno: " + carro.getAno());
        System.out.println("\nMatrícula: " + carro.getMatricula());
        System.out.println("\nMarca: " + carro.getMarca());
        System.out.println("\nPreço: " + carro.getPreco());

        Aluguer aluguer = new Aluguer(carro, LocalDate.now(), null, 300, cliente);

        System.out.println("\n\nO Carro foi alugado!");
        System.out.println("\nData do aluguer: " + aluguer.getDataAluguer());
        System.out.println("\nCusto mensal: " + aluguer.getCustoMensal());
        System.out.println("\nCliente: " + cliente.getNome());

        assertEquals(300, aluguer.getCustoMensal());
    }

    //FreeRide
    @Test
    public void testStandAlugarVeiculo(){
        assertDoesNotThrow(() -> {
            Aluguer aluguer = _standAutomoveis.alugarVeiculo(_cliente);
            assertEquals("Siul", _cliente.getNome());
            assertDoesNotThrow(() -> {
                _standAutomoveis.devolverVeiculo(aluguer);
            });
        });
    }

}
