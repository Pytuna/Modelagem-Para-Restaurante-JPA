package br.com.restaurante.util;

import javax.persistence.EntityManager;
import br.com.restaurante.dao.CategoriaDAO;
import br.com.restaurante.dao.ClienteDAO;
import br.com.restaurante.dao.EnderecoDAO;
import br.com.restaurante.dao.OrdemDAO;
import br.com.restaurante.dao.CardapioDAO;
import br.com.restaurante.entity.Categoria;
import br.com.restaurante.entity.Cliente;
import br.com.restaurante.entity.Endereco;
import br.com.restaurante.entity.Ordem;
import br.com.restaurante.entity.OrdensCardapio;
import br.com.restaurante.entity.Cardapio;
import java.util.List;

public class CargaDeDadosUtil {
        private CargaDeDadosUtil() {
        };

        public static void cadastrarCategoria(EntityManager entityManager) {
                Categoria entrada = new Categoria("Entradas");
                Categoria salada = new Categoria("Saladas");
                Categoria principal = new Categoria("Pratos Principais");

                CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

                categoriaDAO.cadastrar(entrada);
                entityManager.flush();
                categoriaDAO.cadastrar(salada);
                entityManager.flush();
                categoriaDAO.cadastrar(principal);
                entityManager.flush();
        }

        public static void cadastrarProdutoCardapio(EntityManager entityManager) {
                CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
                CardapioDAO cardapioDAO = new CardapioDAO(entityManager);

                List<Categoria> categorias = categoriaDAO.consultarTodos();
                Cardapio moqueca = new Cardapio("Moqueca",
                                "Peixe branco, banana da terra, arroz e uma porção de farofa", true,
                                95.00, categorias.get(2));
                Cardapio spaguetti = new Cardapio("Spaguetti", "Spaguetti ao molho parmesão e cogumelos", true, 68.00,
                                categorias.get(2));
                Cardapio bife = new Cardapio("Bife", "Bife acebolado com arroz branco, farofa e batata frita", true,
                                59.00,
                                categorias.get(2));
                Cardapio cordeiro = new Cardapio("Cordeiro", "Cordeiro com rissoto de funghi", true, 88.00,
                                categorias.get(2));
                Cardapio burrata = new Cardapio("Burrata", "Tomates queimados, rúcula e torrada", true, 15.00,
                                categorias.get(0));
                Cardapio bruschetta = new Cardapio("Bruschetta", "Tomates, mucarela e manjericão", true, 20.00,
                                categorias.get(0));
                Cardapio scappeta = new Cardapio("Scappeta", "Ragu de linguiça e torradinhas", true, 25.00,
                                categorias.get(0));
                Cardapio caprese = new Cardapio("Caprese", "Mini rúculas e muçarella", true, 47.00,
                                categorias.get(1));
                Cardapio caesar = new Cardapio("Caesar", "Salada de franco com molho ceasar", true, 40.00,
                                categorias.get(1));
                Cardapio chevre = new Cardapio("Chevre", "Mix de folhas, mostarda e mel", true, 50.00,
                                categorias.get(1));

                cardapioDAO.cadastrar(moqueca);
                cardapioDAO.cadastrar(spaguetti);
                cardapioDAO.cadastrar(bife);
                cardapioDAO.cadastrar(cordeiro);
                cardapioDAO.cadastrar(burrata);
                cardapioDAO.cadastrar(bruschetta);
                cardapioDAO.cadastrar(scappeta);
                cardapioDAO.cadastrar(caprese);
                cardapioDAO.cadastrar(caesar);
                cardapioDAO.cadastrar(chevre);

                entityManager.flush();
                entityManager.clear();
        }

        public static void cadastrarClientes(EntityManager entityManager) {
                ClienteDAO clienteDAO = new ClienteDAO(entityManager);
                EnderecoDAO enderecoDAO = new EnderecoDAO(entityManager);

                Endereco augusta = new Endereco("000000000", "Augusta", "casa 43", "Sao Paulo", "Sao Paulo");
                Cliente cliente1 = new Cliente("000.000.000-00", "Felipe@gmail.com", "Felipe da Silva");
                cliente1.addEndereco(augusta);

                Endereco rioVermelho = new Endereco("000000001", "Rio Vermelho", "apto 1001", "Teresina", "Piauí");
                Cliente cliente2 = new Cliente("000.000.000-01","Cleber@gmail.com", "Cleber Machado");
                cliente2.addEndereco(rioVermelho);

                Endereco leblon = new Endereco("000000002", "leblon", "apto 991", "Rio de Janeiro", "Rio de Janeiro");
                Cliente cliente3 = new Cliente("000.000.000-02", "Lisa@gmail.com", "Lisa Santos");
                cliente3.addEndereco(leblon);

                Endereco heitorPenteado = new Endereco("000000003", "Heitor Penteado", "casa 41", "Rio Branco", "Acre");
                Cliente cliente4 = new Cliente("000.000.000-03","Tayane@gmail.com", "Tayane Lopes Costas");
                cliente4.addEndereco(heitorPenteado);

                Endereco consolacao = new Endereco("000000004", "Consolacao", "casa 21", "Lucia Costa", "Jardineirinho do Sul");
                Cliente cliente5 = new Cliente("000.000.000-04","Denise@gmail.com", "Denise Costa");
                cliente5.addEndereco(consolacao);

                Endereco nacoesUnidas = new Endereco("000000005", "Nacoes Unidas", "apto 1", "Sao Paulo", "Sao Paulo");
                Cliente cliente6 = new Cliente("000.000.000-05","Claudia@gmail.com", "Claudia Rocha");
                cliente6.addEndereco(nacoesUnidas);

                enderecoDAO.cadastrar(augusta);
                clienteDAO.cadastrar(cliente1);
                enderecoDAO.cadastrar(rioVermelho);
                clienteDAO.cadastrar(cliente2);
                enderecoDAO.cadastrar(leblon);
                clienteDAO.cadastrar(cliente3);
                enderecoDAO.cadastrar(heitorPenteado);
                clienteDAO.cadastrar(cliente4);
                enderecoDAO.cadastrar(consolacao);
                clienteDAO.cadastrar(cliente5);
                enderecoDAO.cadastrar(nacoesUnidas);
                clienteDAO.cadastrar(cliente6);

                entityManager.flush();
                entityManager.clear();
        }

        public static void cadastrarOrdemClientes(EntityManager entityManager) {
                ClienteDAO clienteDAO = new ClienteDAO(entityManager);
                CardapioDAO cardapioDAO = new CardapioDAO(entityManager);
                OrdemDAO ordemDAO = new OrdemDAO(entityManager);
                List<Cliente> clientes = clienteDAO.consultarTodos();
                List<Cardapio> cardapios = cardapioDAO.consultarTodos();

                Ordem ordemCLiente0 = new Ordem(clientes.get(0));
                ordemCLiente0.addOrdemCardapio(new OrdensCardapio(cardapios.get(0), 2));
                ordemCLiente0.addOrdemCardapio(new OrdensCardapio(cardapios.get(5), 3));

                Ordem ordemCLiente1 = new Ordem(clientes.get(1));
                ordemCLiente1.addOrdemCardapio(new OrdensCardapio(cardapios.get(0), 1));
                ordemCLiente1.addOrdemCardapio(new OrdensCardapio(cardapios.get(1), 2));
                ordemCLiente1.addOrdemCardapio(new OrdensCardapio(cardapios.get(6), 3));

                Ordem ordemCLiente2 = new Ordem(clientes.get(2));
                ordemCLiente2.addOrdemCardapio(new OrdensCardapio(cardapios.get(0), 2));
                ordemCLiente2.addOrdemCardapio(new OrdensCardapio(cardapios.get(9), 3));

                Ordem ordemCLiente3 = new Ordem(clientes.get(3));
                ordemCLiente3.addOrdemCardapio(new OrdensCardapio(cardapios.get(0), 2));
                ordemCLiente3.addOrdemCardapio(new OrdensCardapio(cardapios.get(2), 1));

                Ordem ordemCLiente4 = new Ordem(clientes.get(4));
                ordemCLiente4.addOrdemCardapio(new OrdensCardapio(cardapios.get(3), 2));
                ordemCLiente4.addOrdemCardapio(new OrdensCardapio(cardapios.get(5), 3));

                Ordem ordemCLiente5 = new Ordem(clientes.get(5));
                ordemCLiente5.addOrdemCardapio(new OrdensCardapio(cardapios.get(3), 2));
                ordemCLiente5.addOrdemCardapio(new OrdensCardapio(cardapios.get(5), 3));

                ordemDAO.cadastrar(ordemCLiente0);
                ordemDAO.cadastrar(ordemCLiente1);
                ordemDAO.cadastrar(ordemCLiente2);
                ordemDAO.cadastrar(ordemCLiente3);
                ordemDAO.cadastrar(ordemCLiente4);
                ordemDAO.cadastrar(ordemCLiente5);

                entityManager.flush();
                entityManager.clear();
        }
}