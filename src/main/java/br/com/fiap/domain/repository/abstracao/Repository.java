package br.com.fiap.domain.repository.abstracao;

import br.com.fiap.domain.entity.Produto;

import java.util.List;

public interface Repository<T, U> {

    public List<T> findAll();

    public T findById(U id);

    public List<T> findByName(String texto);

    public T persist(T t);

}
