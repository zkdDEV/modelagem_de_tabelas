import dao.*;
import domain.Acessorio;
import domain.Carro;
import domain.Marca;
import org.junit.Assert;
import org.junit.Test;

public class AcessorioTest {

    private IAcessorioDAO acessorioDAO;
    private ICarroDAO carroDAO;
    private IMarcaDAO marcaDAO;

    public AcessorioTest(){
        acessorioDAO = new AcessorioDAO();
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();
    }

    @Test
    public void cadastrar(){
        Carro carro = criarCarro("A1");

        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo("A1");
        acessorio.setNome("Freios ABS");
        acessorio.setCarro(carro);

        acessorio = acessorioDAO.cadastrar(acessorio);

        Assert.assertNotNull(acessorio);
        Assert.assertNotNull(acessorio.getId());

    }

    private Carro criarCarro(String codigo) {
        Marca marcaDoCarro = criarMarca("A1");
        Carro carro = new Carro();
        carro.setCodigo(codigo);
        carro.setNomeModelo("XL Turbo");
        carro.setMarca(marcaDoCarro);
        return carroDAO.cadastrar(carro);
    }

    private Marca criarMarca(String codigo) {
        Marca marca = new Marca();
        marca.setCodigo(codigo);
        marca.setNome("Toyota");
        return marcaDAO.cadastrar(marca);
    }



}
