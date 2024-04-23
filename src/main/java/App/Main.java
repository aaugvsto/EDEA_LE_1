package App;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        final String filePath = "src/main/java/App/files/JogosDesordenados.csv";

        List<Item> jogos = new ArrayList<>();
        List<String> categorias = new ArrayList<>();


        boolean rodar = true;
        while (rodar){

            Scanner scan = new Scanner(System.in);

            System.out.println(
                    """
                    \n[1] Ler arquivo
                    [2] Ordenar por categoria
                    [3] Ordenar por avaliação
                    [4] Sair
                    """
            );

            String selecao = scan.nextLine();

            switch (selecao)
            {
                case "1":
                    jogos = Util.getJogosArquivo(filePath);
                    categorias = Util.ordenaStringOrdemAlfabetica(Util.getCategorias(filePath));

                    System.out.println("Arquivo lido com sucesso!");
                    continue;
                case "2":
                    if(!jogos.isEmpty())
                    {
                        List<Item> lista = new ArrayList<>();

                        for (String categoria : categorias) {

                            for(Item item : jogos){
                                if(item.getCategoria().equals(categoria))
                                    lista.add(item);
                            }

                            Util.ordenaJogosOrdemAlfabetica(lista, categoria);
                        }

                        Util.gerarArquivo(lista, "JogosOrdenadosporCategoria.csv");
                        continue;
                    }

                    System.out.println("Você ainda não fez a leitura do arquivo!");
                    continue;
                case "3":
                    if(!jogos.isEmpty())
                    {
                        List<Item> lista = new ArrayList<>();

                        for (String categoria : categorias) {

                            for(Item item : jogos){
                                if(item.getCategoria().equals(categoria))
                                    lista.add(item);
                            }

                            Util.ordenaJogosOrdemPorAvaliacao(lista, categoria);
                        }

                        Util.gerarArquivo(lista, "JogosOrdenadosporAvaliacao.csv");
                        continue;
                    }

                    System.out.println("Você ainda não fez a leitura do arquivo!");
                    continue;
                case "4":
                    rodar = false;
                    System.out.println("Você saiu da aplicação.");
                    continue;
                default:
                    System.out.println("Digite uma opção válida! 1, 2, 3 ou 4");
            }
        }
    }


}