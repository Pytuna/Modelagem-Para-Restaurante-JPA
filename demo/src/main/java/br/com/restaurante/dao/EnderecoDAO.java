package br.com.restaurante.dao;

import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.restaurante.entity.Categoria;
import br.com.restaurante.entity.Endereco;
import br.com.restaurante.vo.ClienteVO;

public class EnderecoDAO {
    private EntityManager entityManager;

    public EnderecoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Endereco endereco) {
        this.entityManager.persist(endereco);
    }

    public Categoria consultarPorID(final Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }

    public List<Endereco> consultarTodos() {
        String sql = "SELECT e FROM Endereco e";
        return this.entityManager.createQuery(sql, Endereco.class).getResultList();
    }

    public List<ClienteVO> consultarPorCliente(final String estado, final String cidade, final String rua) {
        String sql = "SELECT new br.com.restaurante.vo.ClienteVO(e.cliente.clienteID.CPF, e.cliente.nome) " +
                "FROM Endereco e WHERE 1=1";
        if (Objects.nonNull(estado)) {
            sql = sql.concat("AND UPPER(e.estado) = UPPER(:estado) ");
        }
        if (Objects.nonNull(cidade)) {
            sql = sql.concat("AND UPPER(e.cidade) = UPPER(:cidade) ");
        }
        if (Objects.nonNull(rua)) {
            sql = sql.concat("AND UPPER(e.rua) = UPPER(:rua) ");
        }
        TypedQuery typedQuery = this.entityManager.createQuery(sql, ClienteVO.class);
        if (Objects.nonNull(estado)) {
            typedQuery.setParameter("estado", estado);
        }
        if (Objects.nonNull(cidade)) {
            typedQuery.setParameter("cidade", cidade);
        }
        if (Objects.nonNull(rua)) {
            typedQuery.setParameter("rua", rua);
        }

        return typedQuery.getResultList();
    }

    public void atualizar(final Endereco endereco) {
        this.entityManager.merge(endereco);
    }

    public void excluir(final Endereco endereco) {
        this.entityManager.remove(endereco);
    }
}
