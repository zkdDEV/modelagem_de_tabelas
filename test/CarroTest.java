import dao.*;
import domain.Acessorio;
import domain.Carro;
import domain.Marca;
import org.junit.Assert;
import org.junit.Test;

public class CarroTest {


    private ICarroDAO carroDAO;
    private IMarcaDAO marcaDAO;

    public CarroTest(){
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();
    }

    @Test
    public void cadastrar(){
        Acessorio acessorio = criarAcessorio("A1");
        Marca marcaDoCarro = criarMarca("A1");

        Carro carro = new Carro();
        carro.setCodigo("A1");
        carro.setNomeModelo("XL Turbo");
        carro.addAcessorio(acessorio);
        carro.setMarca(marcaDoCarro);

        carro = carroDAO.cadastrar(carro);

        Assert.assertNotNull(carro);
        Assert.assertNotNull(carro.getId());

    }

    private Acessorio criarAcessorio(String codigo) {
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo(codigo);
        acessorio.setNome("Freios ABS");
        return acessorio;
    }

    private Marca criarMarca(String codigo) {
        Marca marca = new Marca();
        marca.setCodigo(codigo);
        marca.setNome("Toyota");
        return marcaDAO.cadastrar(marca);
    }

}
