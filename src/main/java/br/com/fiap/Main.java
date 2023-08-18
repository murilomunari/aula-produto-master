package br.com.fiap;

import br.com.fiap.domain.entity.ProdutoEstocado;
import br.com.fiap.domain.view.ProdutoEstocadoView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ProdutoEstocadoView view = new ProdutoEstocadoView();
        List<ProdutoEstocado> produtoEstocados = view.formEstocar();
        produtoEstocados.forEach( System.out::println );

    }
}