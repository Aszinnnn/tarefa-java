
package com.mycompany.tarefa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GerenciadorDeTarefas {
    private List<Tarefa> tarefas;
    private Scanner scanner;

    public GerenciadorDeTarefas() {
        this.tarefas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Método para adicionar tarefa
    public void adicionarTarefa() {
        System.out.print("Digite a descricao da tarefa: ");
        String descricao = scanner.nextLine();
        tarefas.add(new Tarefa(descricao));
        System.out.println("Tarefa adicionada!");
    }

    // Método para listar tarefas
    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa na lista.");
        } else {
            System.out.println("\n=== LISTA DE TAREFAS ===");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    // Método para marcar tarefa como concluída
    public void marcarComoConcluida() {
        listarTarefas();
        if (!tarefas.isEmpty()) {
            System.out.print("Digite o numero da tarefa concluída: ");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            if (numero > 0 && numero <= tarefas.size()) {
                tarefas.get(numero - 1).setConcluida(true);
                System.out.println("Tarefa marcada como concluida!");
            } else {
                System.out.println("Numero invalido.");
            }
        }
    }

    // Método para remover tarefa
    public void removerTarefa() {
        listarTarefas();
        if (!tarefas.isEmpty()) {
            System.out.print("Digite o numero da tarefa a remover: ");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            if (numero > 0 && numero <= tarefas.size()) {
                tarefas.remove(numero - 1);
                System.out.println("Tarefa removida!");
            } else {
                System.out.println("Número invalido.");
            }
        }
    }

    // Menu interativo
    public void executar() {
        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Marcar como Concluida");
            System.out.println("4. Remover Tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> adicionarTarefa();
                case 2 -> listarTarefas();
                case 3 -> marcarComoConcluida();
                case 4 -> removerTarefa();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        gerenciador.executar();
    }
}
