import estrutura_arvore.ArvoreAVL;
import estrutura_arvore.ArvoreBinaria;
import leitura_arquivo.TitleBasic;
import leitura_arquivo.TitleBasicLoader;
import metodos_insercao.ListaArranjo;
import metodos_insercao.ListaDuplaEncadeada;
import metodos_insercao.ListaEncadeada;
import metodos_ordenacao.MergeSort;
import metodos_pesquisa.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {                                                                                       // nao tem simple
            ArrayList<TitleBasic> dadosOriginais = TitleBasicLoader.load("DatabaseTeste/title.basics.sample.tsv");
            System.out.println("Registros carregados: " + dadosOriginais.size());

            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                exibirMenu();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1 -> testarArvoreBinaria(dadosOriginais);
                    case 2 -> testarArvoreAVL(dadosOriginais);
                    case 3 -> testarListaArranjo(dadosOriginais);
                    case 4 -> testarListaEncadeada(dadosOriginais);
                    case 5 -> testarListaDuplaEncadeada(dadosOriginais);
                    case 6 -> executarTodos(dadosOriginais);
                    case 7 -> testarPesquisaSequencial(dadosOriginais, scanner);
                    case 8 -> testarPesquisaBinaria(dadosOriginais, scanner);
                    case 0 -> System.out.println("Encerrando...");
                    default -> System.out.println("Opcao invalida!");
                }

            } while (opcao != 0);

            scanner.close();

        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo: " + e.getMessage());
        }
    }

    private static void exibirMenu() {
        System.out.println("\n===== MENU DE TESTES =====");
        System.out.println("1. ArvoreBinaria (BST)");
        System.out.println("2. ArvoreAVL");
        System.out.println("3. ListaArranjo (todos os algoritmos)");
        System.out.println("4. ListaEncadeada (todos os algoritmos)");
        System.out.println("5. ListaDuplaEncadeada (todos os algoritmos)");
        System.out.println("6. Executar TODOS (arvores + listas)");
        System.out.println("7. Pesquisa Sequencial (por tconst ID)");
        System.out.println("8. Pesquisa Binaria (por tconst ID)");
        System.out.println("0. Sair");
        System.out.println("==========================");
        System.out.print("Escolha: ");
    }

    // ======================================================
    // Listas (metodos_insercao.ListaArranjo, metodos_insercao.ListaEncadeada, metodos_insercao.ListaDuplaEncadeada)
    // guardam leitura_arquivo.TitleBasic e ordenam pelo ano de lancamento (startYear)
    // ======================================================

    private static ListaArranjo construirListaArranjo(ArrayList<TitleBasic> original) {
        ListaArranjo lista = new ListaArranjo(original.size());
        for (TitleBasic t : original) {
            lista.InsereFinal(t);
        }
        return lista;
    }

    private static ListaEncadeada construirListaEncadeada(ArrayList<TitleBasic> original) {
        ListaEncadeada lista = new ListaEncadeada();
        for (TitleBasic t : original) {
            lista.InsereFinal(t);
        }
        return lista;
    }

    private static ListaDuplaEncadeada construirListaDuplaEncadeada(ArrayList<TitleBasic> original) {
        ListaDuplaEncadeada lista = new ListaDuplaEncadeada();
        for (TitleBasic t : original) {
            lista.InsereFinal(t);
        }
        return lista;
    }

    private static final String[] ALGORITMOS = {
            "metodos_ordenacao.BubbleSort", "metodos_ordenacao.SelectionSort", "metodos_ordenacao.InsertionSort", "metodos_ordenacao.MergeSort", "metodos_ordenacao.QuickSort", "HeapSort"
    };

    private static void aplicarAlgoritmo(ListaArranjo lista, String algoritmo) {
        switch (algoritmo) {
            case "metodos_ordenacao.BubbleSort" -> lista.bubbleSort();
            case "metodos_ordenacao.SelectionSort" -> lista.selectionSort();
            case "metodos_ordenacao.InsertionSort" -> lista.insertionSort();
            case "metodos_ordenacao.MergeSort" -> lista.mergeSort();
            case "metodos_ordenacao.QuickSort" -> lista.quickSort();
            case "HeapSort" -> lista.heapSort();
        }
    }

    private static void aplicarAlgoritmo(ListaEncadeada lista, String algoritmo) {
        switch (algoritmo) {
            case "metodos_ordenacao.BubbleSort" -> lista.bubbleSort();
            case "metodos_ordenacao.SelectionSort" -> lista.selectionSort();
            case "metodos_ordenacao.InsertionSort" -> lista.insertionSort();
            case "metodos_ordenacao.MergeSort" -> lista.mergeSort();
            case "metodos_ordenacao.QuickSort" -> lista.quickSort();
            case "HeapSort" -> lista.heapSort();
        }
    }

    private static void aplicarAlgoritmo(ListaDuplaEncadeada lista, String algoritmo) {
        switch (algoritmo) {
            case "metodos_ordenacao.BubbleSort" -> lista.bubbleSort();
            case "metodos_ordenacao.SelectionSort" -> lista.selectionSort();
            case "metodos_ordenacao.InsertionSort" -> lista.insertionSort();
            case "metodos_ordenacao.MergeSort" -> lista.mergeSort();
            case "metodos_ordenacao.QuickSort" -> lista.quickSort();
            case "HeapSort" -> lista.heapSort();
        }
    }

    private static void testarListaArranjo(ArrayList<TitleBasic> original) {
        System.out.println("\n--- ListaArranjo: Comparativo de Ordenacao (por ano) ---");
        System.out.printf("%-15s | %10s | %s\n", "Algoritmo", "Tempo (ms)", "Movimentacoes");
        System.out.println("----------------------------------------");

        for (String algoritmo : ALGORITMOS) {
            ListaArranjo lista = construirListaArranjo(original);
            long inicio = System.currentTimeMillis();
            aplicarAlgoritmo(lista, algoritmo);
            long fim = System.currentTimeMillis();
            System.out.printf("%-15s | %10d | %d\n", algoritmo, fim - inicio, lista.getMovimentacoes());
        }
    }

    private static void testarListaEncadeada(ArrayList<TitleBasic> original) {
        System.out.println("\n--- ListaEncadeada: Comparativo de Ordenacao (por ano) ---");
        System.out.printf("%-15s | %10s | %s\n", "Algoritmo", "Tempo (ms)", "Movimentacoes");
        System.out.println("----------------------------------------");

        for (String algoritmo : ALGORITMOS) {
            ListaEncadeada lista = construirListaEncadeada(original);
            long inicio = System.currentTimeMillis();
            aplicarAlgoritmo(lista, algoritmo);
            long fim = System.currentTimeMillis();
            System.out.printf("%-15s | %10d | %d\n", algoritmo, fim - inicio, lista.getMovimentacoes());
        }
    }

    private static void testarListaDuplaEncadeada(ArrayList<TitleBasic> original) {
        System.out.println("\n--- ListaDuplaEncadeada: Comparativo de Ordenacao (por ano) ---");
        System.out.printf("%-15s | %10s | %s\n", "Algoritmo", "Tempo (ms)", "Movimentacoes");
        System.out.println("----------------------------------------");

        for (String algoritmo : ALGORITMOS) {
            ListaDuplaEncadeada lista = construirListaDuplaEncadeada(original);
            long inicio = System.currentTimeMillis();
            aplicarAlgoritmo(lista, algoritmo);
            long fim = System.currentTimeMillis();
            System.out.printf("%-15s | %10d | %d\n", algoritmo, fim - inicio, lista.getMovimentacoes());
        }
    }

    private static void testarArvoreBinaria(ArrayList<TitleBasic> original) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        long inicio = System.currentTimeMillis();
        arvore.inserirTodos(original);
        long fim = System.currentTimeMillis();
        System.out.println("\n--- Arvore.ArvoreBinaria (BST) ---");
        System.out.println("Tempo de insercao: " + (fim - inicio) + " ms");
        System.out.println("Altura da arvore: " + arvore.altura());
    }

    private static void testarArvoreAVL(ArrayList<TitleBasic> original) {
        ArvoreAVL arvore = new ArvoreAVL();
        long inicio = System.currentTimeMillis();
        arvore.inserirTodos(original);
        long fim = System.currentTimeMillis();
        System.out.println("\n--- Arvore.ArvoreAVL ---");
        System.out.println("Tempo de insercao: " + (fim - inicio) + " ms");
        System.out.println("Altura da arvore: " + arvore.altura());
        System.out.println("Fator de balanceamento da raiz: " + arvore.fatorBalanceamento());
    }

    private static void executarTodos(ArrayList<TitleBasic> original) {
        System.out.println("\n--- Comparativo: Arvores ---");
        System.out.printf("%-15s | %10s | %s\n", "Estrutura", "Tempo (ms)", "Altura");
        System.out.println("----------------------------------------");

        ArvoreBinaria bst = new ArvoreBinaria();
        long t1 = System.currentTimeMillis();
        bst.inserirTodos(original);
        System.out.printf("%-15s | %10d | %d\n", "ArvoreBinaria", System.currentTimeMillis() - t1, bst.altura());

        ArvoreAVL avl = new ArvoreAVL();
        long t2 = System.currentTimeMillis();
        avl.inserirTodos(original);
        System.out.printf("%-15s | %10d | %d\n", "ArvoreAVL", System.currentTimeMillis() - t2, avl.altura());

        testarListaArranjo(original);
        testarListaEncadeada(original);
        testarListaDuplaEncadeada(original);
    }

    private static void testarPesquisaSequencial(ArrayList<TitleBasic> original, Scanner scanner) {
        System.out.print("Digite o ID numerico do tconst (ex: 1, 42, 100): ");
        int id = scanner.nextInt();

        ArrayList<TitleBasic> copia = new ArrayList<>(original);
        MergeSort sorter = new MergeSort();
        sorter.mergeSortPorTconstId(copia);

        PesquisaSequencial pesq = new PesquisaSequencial();
        long inicio = System.nanoTime();
        TitleBasic resultado = pesq.buscar(copia, id);
        long fim = System.nanoTime();

        System.out.println("\n--- Pesquisa Sequencial ---");
        System.out.println("ID buscado: " + id);
        System.out.println("Resultado: " + (resultado != null
                ? resultado.getPrimaryTitle() + " (" + resultado.getStartYear() + ")"
                : "Nao encontrado"));
        System.out.println("Tempo: " + ((fim - inicio) / 1_000_000.0) + " ms");
        System.out.println("Consultas (comparacoes): " + pesq.getConsultas());
    }

    private static void testarPesquisaBinaria(ArrayList<TitleBasic> original, Scanner scanner) {
        System.out.print("Digite o ID numerico do tconst (ex: 1, 42, 100): ");
        int id = scanner.nextInt();

        ArrayList<TitleBasic> copia = new ArrayList<>(original);
        MergeSort sorter = new MergeSort();
        sorter.mergeSortPorTconstId(copia);

        PesquisaBinaria pesq = new PesquisaBinaria();
        long inicio = System.nanoTime();
        TitleBasic resultado = pesq.buscar(copia, id);
        long fim = System.nanoTime();

        System.out.println("\n--- Pesquisa Binaria ---");
        System.out.println("ID buscado: " + id);
        System.out.println("Resultado: " + (resultado != null
                ? resultado.getPrimaryTitle() + " (" + resultado.getStartYear() + ")"
                : "Nao encontrado"));
        System.out.println("Tempo: " + ((fim - inicio) / 1_000_000.0) + " ms");
        System.out.println("Consultas (comparacoes): " + pesq.getConsultas());
    }

}