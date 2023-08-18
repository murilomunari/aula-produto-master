package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.ProdutoEstocado;
import br.com.fiap.domain.repository.ProdutoEstocadoRepository;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Random;

public class ProdutoEstocadoService {

    public static ProdutoEstocado entrada(ProdutoEstocado pe) {

        ProdutoEstocadoRepository repo = new ProdutoEstocadoRepository();

        if (pe.getProduto().equals( null )) return null;
        if (pe.getDeposito().equals( null )) return null;
        pe.setEntrada( LocalDateTime.now() );
        pe.setSaida( null );
        pe.setNumeroDeSerie( gerarNumeroDeSerie( pe ) );
        return repo.persist( pe );
    }

    private static String gerarNumeroDeSerie(ProdutoEstocado pe) {
        Random random = new Random();
        var numeroAleatorio = random.nextInt( 10000, 99999 );
        return numeroAleatorio + "" + gerarDigito( numeroAleatorio );
    }

    public static String gerarDigito(int numeroAleatorio) {


        //Nas três próximas linhas eu garanto que estou pegando os dois últimos dígitos
        //do número informado, mesmo que o número tenha 1 dígito, pois o formatador
        // colocou uma casa a esqueda neste caso.
        var formatador = new DecimalFormat( "00" );
        var s = formatador.format( numeroAleatorio );
        var n = Integer.valueOf( s.substring( s.length() - 2 ) );

        //Binário
        String x = Integer.toBinaryString( n );
        //Binário após deslocar uma casa para direita com o operador >>
        String y = Integer.toBinaryString( n >> 1 );

        //Gerando o dígito:
        var digito = formatador.format( n >> 1 );


        //  System.out.println( n + ": x -> " + x + " y -> " + y + " Dígito: " + digito );

        return digito;
    }
}
