import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;

public class Pessoa {
    String nome = "";
    String cpf = "";

    public void cadastrarPessoa() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine(); // TODO Tratar exceções
        this.nome = nome;
        // pessoa.setNome(nome);

        System.out.print("Digite seu cpf: ");
        String cpf = sc.nextLine(); // TODO Tratar exceções
        this.cpf = cpf;
        // pessoa.setCpf(cpf);

        sc.close();
    }

    public static void armazenarDados(String tipo, Map<String, String> ListaPessoa) {
        File pasta = new File("BancoDeDados");
        if (!pasta.exists()) {
            pasta.mkdir();
        }

        String arquivo = "";
        if (tipo.equals("estudante")) {
            arquivo = "estudante.txt";
        } else if (tipo.equals("discente")) {
            arquivo = "discente.txt";
        } else {
            System.err.println("Tipo não reconhecido"); // ERROR
        }

        try (PrintWriter gravar = new PrintWriter(new FileWriter(new File(pasta, arquivo)))) {
            for (Map.Entry<String, String> Entry : ListaPessoa.entrySet()) {
                gravar.print(Entry.getKey());
                gravar.print(";");
                gravar.print(Entry.getValue());
                gravar.print("\n");
            }
            gravar.close();
            System.out.println("\n----> Arquivo de armazenamento de dados criado."); // Armazenamento Dados - AVISO
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int contador = 0000;

    public String gerarMatriculaEstudante() {
        // ANO + ID + CONTADOR
        // ID = Professor(20) ou Estudante(23)

        // Ano atual
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);

        // Id do estudante
        int id = 23;

        // Adicionar mais um no contador
        contador++;

        return ano + Integer.toString(id) + Integer.toString(contador);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

}
