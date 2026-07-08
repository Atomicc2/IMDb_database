import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {                                                                                       // nao tem simple
            ArrayList<TitleBasic> dadosOriginais = TitleBasicLoader.load("DatabaseTeste/title.basics.tsv");
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
                    case 8 -> executarTodos(dadosOriginais);
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
        System.out.println("1. BubbleSort");
        System.out.println("2. InsertionSort");
        System.out.println("3. MergeSort");
        System.out.println("4. QuickSort");
        System.out.println("5. SelectionSort");
        System.out.println("6. ArvoreBinaria (BST)");
        System.out.println("7. ArvoreAVL");
        System.out.println("8. Executar TODOS (comparativo)");
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
        System.out.println("\n--- BubbleSort ---");
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
        System.out.println("\n--- InsertionSort ---");
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
        System.out.println("\n--- MergeSort ---");
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
        System.out.println("\n--- QuickSort ---");
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
        System.out.println("\n--- SelectionSort ---");
        System.out.println("Tempo: " + (fim - inicio) + " ms");
        System.out.println("Movimentacoes: " + sorter.getMovimentacoes());
        exibirPrimeiros(copia);
    }

    private static void testarArvoreBinaria(ArrayList<TitleBasic> original) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        long inicio = System.currentTimeMillis();
        arvore.inserirTodos(original);
        long fim = System.currentTimeMillis();
        System.out.println("\n--- ArvoreBinaria (BST) ---");
        System.out.println("Tempo de insercao: " + (fim - inicio) + " ms");
        System.out.println("Altura da arvore: " + arvore.altura());
    }

    private static void testarArvoreAVL(ArrayList<TitleBasic> original) {
        ArvoreAVL arvore = new ArvoreAVL();
        long inicio = System.currentTimeMillis();
        arvore.inserirTodos(original);
        long fim = System.currentTimeMillis();
        System.out.println("\n--- ArvoreAVL ---");
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
        System.out.printf("%-15s | %10d | %d\n", "BubbleSort", System.currentTimeMillis() - t1, s1.getMovimentacoes());

        ArrayList<TitleBasic> copia2 = new ArrayList<>(original);
        InsertionSort s2 = new InsertionSort();
        long t2 = System.currentTimeMillis();
        s2.insertSort(copia2);
        System.out.printf("%-15s | %10d | %d\n", "InsertionSort", System.currentTimeMillis() - t2, s2.getMovimentacoes());

        ArrayList<TitleBasic> copia3 = new ArrayList<>(original);
        MergeSort s3 = new MergeSort();
        long t3 = System.currentTimeMillis();
        s3.mergeSort(copia3);
        System.out.printf("%-15s | %10d | %d\n", "MergeSort", System.currentTimeMillis() - t3, s3.getMovimentacoes());

        ArrayList<TitleBasic> copia4 = new ArrayList<>(original);
        QuickSort s4 = new QuickSort();
        long t4 = System.currentTimeMillis();
        s4.quickSort(copia4);
        System.out.printf("%-15s | %10d | %d\n", "QuickSort", System.currentTimeMillis() - t4, s4.getMovimentacoes());

        ArrayList<TitleBasic> copia5 = new ArrayList<>(original);
        SelectionSort s5 = new SelectionSort();
        long t5 = System.currentTimeMillis();
        s5.selectionSort(copia5);
        System.out.printf("%-15s | %10d | %d\n", "SelectionSort", System.currentTimeMillis() - t5, s5.getMovimentacoes());

        System.out.println("\n--- Comparativo: Arvores ---");
        System.out.printf("%-15s | %10s | %s\n", "Estrutura", "Tempo (ms)", "Altura");
        System.out.println("----------------------------------------");

        ArvoreBinaria bst = new ArvoreBinaria();
        long t6 = System.currentTimeMillis();
        bst.inserirTodos(original);
        System.out.printf("%-15s | %10d | %d\n", "ArvoreBinaria", System.currentTimeMillis() - t6, bst.altura());

        ArvoreAVL avl = new ArvoreAVL();
        long t7 = System.currentTimeMillis();
        avl.inserirTodos(original);
        System.out.printf("%-15s | %10d | %d\n", "ArvoreAVL", System.currentTimeMillis() - t7, avl.altura());
    }

    private static void exibirPrimeiros(ArrayList<TitleBasic> titulos) {
        System.out.println("Primeiros 5 registros apos ordenacao:");
        for (int i = 0; i < 5 && i < titulos.size(); i++) {
            System.out.println("  " + titulos.get(i).getStartYear() + " - " + titulos.get(i).getPrimaryTitle());
        }
    }
}