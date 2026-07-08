import estrutura_arvore.ArvoreAVL;
import estrutura_arvore.ArvoreBinaria;
import leitura_arquivo.TitleBasic;
import leitura_arquivo.TitleBasicLoader;
import metodos_insercao.ListaArranjo;
import metodos_insercao.ListaDuplaEncadeada;
import metodos_insercao.ListaEncadeada;
import metodos_ordenacao.*;

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
                    case 1 -> testarBubbleSort(dadosOriginais);
                    case 2 -> testarInsertionSort(dadosOriginais);
                    case 3 -> testarMergeSort(dadosOriginais);
                    case 4 -> testarQuickSort(dadosOriginais);
                    case 5 -> testarSelectionSort(dadosOriginais);
                    case 6 -> testarArvoreBinaria(dadosOriginais);
                    case 7 -> testarArvoreAVL(dadosOriginais);
                    case 8 -> testarListaArranjo(dadosOriginais);
                    case 9 -> testarListaEncadeada(dadosOriginais);
                    case 10 -> testarListaDuplaEncadeada(dadosOriginais);
                    case 11 -> executarTodos(dadosOriginais);
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
        System.out.println("1. metodos_ordenacao.BubbleSort (ArrayList)");
        System.out.println("2. metodos_ordenacao.InsertionSort (ArrayList)");
        System.out.println("3. metodos_ordenacao.MergeSort (ArrayList)");
        System.out.println("4. metodos_ordenacao.QuickSort (ArrayList)");
        System.out.println("5. metodos_ordenacao.SelectionSort (ArrayList)");
        System.out.println("6. Arvore.ArvoreBinaria (BST)");
        System.out.println("7. Arvore.ArvoreAVL");
        System.out.println("8. metodos_insercao.ListaArranjo (todos os algoritmos)");
        System.out.println("9. metodos_insercao.ListaEncadeada (todos os algoritmos)");
        System.out.println("10. metodos_insercao.ListaDuplaEncadeada (todos os algoritmos)");
        System.out.println("11. Executar TODOS (comparativo completo)");
        System.out.println("0. Sair");
        System.out.println("==========================");
        System.out.print("Escolha: ");
    }

    private static void testarBubbleSort(ArrayList<TitleBasic> original) {
        ArrayList<TitleBasic> copia = new ArrayList<>(original);
        BubbleSort sorter = new BubbleSort();
        long inicio = System.currentTimeMillis();
        sorter.bubbleSort(copia);
        long fim = System.currentTimeMillis();
        System.out.println("\n--- metodos_ordenacao.BubbleSort ---");
        System.out.println("Tempo: " + (fim - inicio) + " ms");
        System.out.println("Movimentacoes: " + sorter.getMovimentacoes());
        exibirPrimeiros(copia);
    }

    private static void testarInsertionSort(ArrayList<TitleBasic> original) {
        ArrayList<TitleBasic> copia = new ArrayList<>(original);
        InsertionSort sorter = new InsertionSort();
        long inicio = System.currentTimeMillis();
        sorter.insertSort(copia);
        long fim = System.currentTimeMillis();
        System.out.println("\n--- metodos_ordenacao.InsertionSort ---");
        System.out.println("Tempo: " + (fim - inicio) + " ms");
        System.out.println("Movimentacoes: " + sorter.getMovimentacoes());
        exibirPrimeiros(copia);
    }

    private static void testarMergeSort(ArrayList<TitleBasic> original) {
        ArrayList<TitleBasic> copia = new ArrayList<>(original);
        MergeSort sorter = new MergeSort();
        long inicio = System.currentTimeMillis();
        sorter.mergeSort(copia);
        long fim = System.currentTimeMillis();
        System.out.println("\n--- metodos_ordenacao.MergeSort ---");
        System.out.println("Tempo: " + (fim - inicio) + " ms");
        System.out.println("Movimentacoes: " + sorter.getMovimentacoes());
        exibirPrimeiros(copia);
    }

    private static void testarQuickSort(ArrayList<TitleBasic> original) {
        ArrayList<TitleBasic> copia = new ArrayList<>(original);
        QuickSort sorter = new QuickSort();
        long inicio = System.currentTimeMillis();
        sorter.quickSort(copia);
        long fim = System.currentTimeMillis();
        System.out.println("\n--- metodos_ordenacao.QuickSort ---");
        System.out.println("Tempo: " + (fim - inicio) + " ms");
        System.out.println("Movimentacoes: " + sorter.getMovimentacoes());
        exibirPrimeiros(copia);
    }

    private static void testarSelectionSort(ArrayList<TitleBasic> original) {
        ArrayList<TitleBasic> copia = new ArrayList<>(original);
        SelectionSort sorter = new SelectionSort();
        long inicio = System.currentTimeMillis();
        sorter.selectionSort(copia);
        long fim = System.currentTimeMillis();
        System.out.println("\n--- metodos_ordenacao.SelectionSort ---");
        System.out.println("Tempo: " + (fim - inicio) + " ms");
        System.out.println("Movimentacoes: " + sorter.getMovimentacoes());
        exibirPrimeiros(copia);
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
        System.out.println("\n--- metodos_insercao.ListaArranjo: Comparativo de Ordenacao (por ano) ---");
        System.out.printf("%-15s | %10s | %s\n", "Algoritmo", "Tempo (ms)", "Movimentacoes");
        System.out.println("----------------------------------------");

        ListaArranjo ultima = null;
        for (String algoritmo : ALGORITMOS) {
            ListaArranjo lista = construirListaArranjo(original);
            long inicio = System.currentTimeMillis();
            aplicarAlgoritmo(lista, algoritmo);
            long fim = System.currentTimeMillis();
            System.out.printf("%-15s | %10d | %d\n", algoritmo, fim - inicio, lista.getMovimentacoes());
            ultima = lista;
        }

        exibirPrimeirosListaArranjo(ultima);
    }

    private static void testarListaEncadeada(ArrayList<TitleBasic> original) {
        System.out.println("\n--- metodos_insercao.ListaEncadeada: Comparativo de Ordenacao (por ano) ---");
        System.out.printf("%-15s | %10s | %s\n", "Algoritmo", "Tempo (ms)", "Movimentacoes");
        System.out.println("----------------------------------------");

        ListaEncadeada ultima = null;
        for (String algoritmo : ALGORITMOS) {
            ListaEncadeada lista = construirListaEncadeada(original);
            long inicio = System.currentTimeMillis();
            aplicarAlgoritmo(lista, algoritmo);
            long fim = System.currentTimeMillis();
            System.out.printf("%-15s | %10d | %d\n", algoritmo, fim - inicio, lista.getMovimentacoes());
            ultima = lista;
        }

        exibirPrimeirosListaEncadeada(ultima);
    }

    private static void testarListaDuplaEncadeada(ArrayList<TitleBasic> original) {
        System.out.println("\n--- metodos_insercao.ListaDuplaEncadeada: Comparativo de Ordenacao (por ano) ---");
        System.out.printf("%-15s | %10s | %s\n", "Algoritmo", "Tempo (ms)", "Movimentacoes");
        System.out.println("----------------------------------------");

        ListaDuplaEncadeada ultima = null;
        for (String algoritmo : ALGORITMOS) {
            ListaDuplaEncadeada lista = construirListaDuplaEncadeada(original);
            long inicio = System.currentTimeMillis();
            aplicarAlgoritmo(lista, algoritmo);
            long fim = System.currentTimeMillis();
            System.out.printf("%-15s | %10d | %d\n", algoritmo, fim - inicio, lista.getMovimentacoes());
            ultima = lista;
        }

        exibirPrimeirosListaDuplaEncadeada(ultima);
    }

    private static void exibirPrimeirosListaArranjo(ListaArranjo lista) {
        System.out.println("Primeiros 5 registros apos ordenacao:");
        int count = 0;
        for (int i = lista.Primeiro; i < lista.Ultimo && count < 5; i++, count++) {
            System.out.println("  " + lista.Item[i].getStartYear() + " - " + lista.Item[i].getPrimaryTitle());
        }
    }

    private static void exibirPrimeirosListaEncadeada(ListaEncadeada lista) {
        System.out.println("Primeiros 5 registros apos ordenacao:");
        ListaEncadeada.NodoLista p = lista.Primeiro.Proximo;
        int count = 0;
        while (p != null && count < 5) {
            System.out.println("  " + p.Item.getStartYear() + " - " + p.Item.getPrimaryTitle());
            p = p.Proximo;
            count++;
        }
    }

    private static void exibirPrimeirosListaDuplaEncadeada(ListaDuplaEncadeada lista) {
        System.out.println("Primeiros 5 registros apos ordenacao:");
        ListaDuplaEncadeada.NodoLista p = lista.Primeiro.Proximo;
        int count = 0;
        while (p != null && count < 5) {
            System.out.println("  " + p.Item.getStartYear() + " - " + p.Item.getPrimaryTitle());
            p = p.Proximo;
            count++;
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
        System.out.println("\n--- Comparativo: Algoritmos de Ordenacao ---");
        System.out.printf("%-15s | %10s | %s\n", "Algoritmo", "Tempo (ms)", "Movimentacoes");
        System.out.println("----------------------------------------");

        ArrayList<TitleBasic> copia1 = new ArrayList<>(original);
        BubbleSort s1 = new BubbleSort();
        long t1 = System.currentTimeMillis();
        s1.bubbleSort(copia1);
        System.out.printf("%-15s | %10d | %d\n", "metodos_ordenacao.BubbleSort", System.currentTimeMillis() - t1, s1.getMovimentacoes());

        ArrayList<TitleBasic> copia2 = new ArrayList<>(original);
        InsertionSort s2 = new InsertionSort();
        long t2 = System.currentTimeMillis();
        s2.insertSort(copia2);
        System.out.printf("%-15s | %10d | %d\n", "metodos_ordenacao.InsertionSort", System.currentTimeMillis() - t2, s2.getMovimentacoes());

        ArrayList<TitleBasic> copia3 = new ArrayList<>(original);
        MergeSort s3 = new MergeSort();
        long t3 = System.currentTimeMillis();
        s3.mergeSort(copia3);
        System.out.printf("%-15s | %10d | %d\n", "metodos_ordenacao.MergeSort", System.currentTimeMillis() - t3, s3.getMovimentacoes());

        ArrayList<TitleBasic> copia4 = new ArrayList<>(original);
        QuickSort s4 = new QuickSort();
        long t4 = System.currentTimeMillis();
        s4.quickSort(copia4);
        System.out.printf("%-15s | %10d | %d\n", "metodos_ordenacao.QuickSort", System.currentTimeMillis() - t4, s4.getMovimentacoes());

        ArrayList<TitleBasic> copia5 = new ArrayList<>(original);
        SelectionSort s5 = new SelectionSort();
        long t5 = System.currentTimeMillis();
        s5.selectionSort(copia5);
        System.out.printf("%-15s | %10d | %d\n", "metodos_ordenacao.SelectionSort", System.currentTimeMillis() - t5, s5.getMovimentacoes());

        System.out.println("\n--- Comparativo: Arvores ---");
        System.out.printf("%-15s | %10s | %s\n", "Estrutura", "Tempo (ms)", "Altura");
        System.out.println("----------------------------------------");

        ArvoreBinaria bst = new ArvoreBinaria();
        long t6 = System.currentTimeMillis();
        bst.inserirTodos(original);
        System.out.printf("%-15s | %10d | %d\n", "Arvore.ArvoreBinaria", System.currentTimeMillis() - t6, bst.altura());

        ArvoreAVL avl = new ArvoreAVL();
        long t7 = System.currentTimeMillis();
        avl.inserirTodos(original);
        System.out.printf("%-15s | %10d | %d\n", "Arvore.ArvoreAVL", System.currentTimeMillis() - t7, avl.altura());

        testarListaArranjo(original);
        testarListaEncadeada(original);
        testarListaDuplaEncadeada(original);
    }

    private static void exibirPrimeiros(ArrayList<TitleBasic> titulos) {
        System.out.println("Primeiros 5 registros apos ordenacao:");
        for (int i = 0; i < 5 && i < titulos.size(); i++) {
            System.out.println("  " + titulos.get(i).getStartYear() + " - " + titulos.get(i).getPrimaryTitle());
        }
    }
}