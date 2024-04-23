package App;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {

    public static List<Item> getJogosArquivo(String filePath){
        List<Item> jogosArquivo = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                jogosArquivo.add(new Item(
                        values[0],
                        values[1],
                        Double.parseDouble(values[2])
                ));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + filePath);
        }

        return jogosArquivo;
    }

    public static List<String> getCategorias(String filePath){
        List<String> listaCategorias = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                String categoria = values[1];
                if(!listaCategorias.contains(categoria))
                    listaCategorias.add(categoria);
            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + filePath);
        }

        return listaCategorias;
    }

    public static List<Item> ordenaJogosOrdemAlfabetica(List<Item> lista, String categoria){
        // Ordenar o nome dos jogos pela categoria (ordem alfabética).
        // Bubble Sort
        int size = lista.size();
        int i;
        int j;
        for(i = 0; i < size - 1; i++) {
            for (j = 0; j < size - 1 - i; j++) {
                if (lista.get(j).getCategoria().equals(categoria) && lista.get(j).getJogo().compareTo(lista.get(j + 1).getJogo()) > 0) {
                    Item temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }

        return lista;
    }

    public static List<Item> ordenaJogosOrdemPorAvaliacao(List<Item> lista, String categoria){
        // Ordenar o nome dos jogos de acordo com a avaliação (ordemb decrescente) de cada uma das categorias.
        // Selection Sort
        int size = lista.size();
        int i, j, last;
        for(i = 0; i < size - 1; i++) {
            last = i;

            for (j = i + 1; j < size; j++) {
                if (lista.get(j).getCategoria().equals(categoria) && lista.get(j).getAvaliacao() > lista.get(last).getAvaliacao()) {
                    last = j;
                }
            }

            if(lista.get(i).getCategoria().equals(categoria)){
                Item temp = lista.get(last);
                lista.set(last, lista.get(i));
                lista.set(i, temp);
            }
        }

        return lista;
    }

    public static List<String> ordenaStringOrdemAlfabetica(List<String> lista){
        int size = lista.size();
        int i;
        int j;
        for(i = 0; i < size - 1; ++i) {
            for (j = 0; j < size - 1 - i; ++j) {
                if (lista.get(j).compareTo(lista.get(j + 1)) > 0) {
                    String temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }

        return lista;
    }

    public static void gerarArquivo(List<Item> lista, String exitPath){
        try (PrintWriter writer = new PrintWriter(new FileWriter(exitPath))) {

            for (Item item : lista)
                writer.println(item.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
