import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Map;

public class Pessoa {
    String nome = "";
    String cpf = "";

    public void cadastrarPessoa() {
        
        // pessoa.setCpf(cpf);

        // sc.close();
    }

    // public boolean BuscarCPF(String CPF){
    //     BufferedReader ler = new BufferedReader(new FileReader(null))
    // }

    public static void armazenarDados(String tipo, Map<String, String> ListaPessoa, String matricula) {
        File pasta = new File("BancoDeDados");
        if (!pasta.exists()) {
            pasta.mkdir();
        }

        String arquivo = "";
        if (tipo.equals("estudante")) {
            arquivo = "estudante.txt";
        } else if (tipo.equals("docente")) {
            arquivo = "docente.txt";
        } else {
            System.err.println("\n \n-----> Tipo não reconhecido"); // ERROR
            arquivo = null;
        }

        //Esse bloco ajuda a utilizar o banco de dados já existente
        File arq = null;
        if (!new File(pasta, arquivo).exists()) { //Se arquivo não existir, crie
            arq = new File(pasta, arquivo);
            
            try {
                arq.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("\n \n ----> OCORREU UM ERRO INESPERADO"); //ERROR
                e.printStackTrace();
            }
        } else{
            arq = new File(pasta, arquivo);
        }

        try  {
            PrintWriter gravar = new PrintWriter(new FileWriter(arq, true));
            for (Map.Entry<String, String> Entry : ListaPessoa.entrySet()) {
                gravar.append(Entry.getKey());
                gravar.append(";");
                gravar.append(Entry.getValue());
                gravar.append(";");
                gravar.append(matricula);
                gravar.append(";");
                gravar.append("\n");
            }
            gravar.close();
            System.out.println("\n----> Arquivo de armazenamento de dados criado."); // Armazenamento Dados - AVISO
        } catch (Exception e) {
            System.err.println("\n \n-----> OCORREU UM ERRO INESPERADO"); //error
            e.printStackTrace();
        }
    }

    int contador = 0000;

    public String gerarMatricula(String tipo) {
        // ANO + ID + CONTADOR
        // ID = Professor(20) ou Estudante(23)

        // Ano atual
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        
        
        // Id da pessoa
        int id = 0;
        int contadorEstudante = 0;
        int contadorDocente = 0;
        
        if (tipo.equals("estudante")) {
			id = 23;
			contadorEstudante ++;
			return ano + Integer.toString(id) + Integer.toString(contadorEstudante);
			
		} else if (tipo.equals("docente")) {
			id = 20;
			contadorDocente ++;
			return ano + Integer.toString(id) + Integer.toString(contadorDocente);
			
		} else {
			return null;
		}
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


//Verificar os estudantes no arquivo e colcar no HASHMAP
//Colocar o <CPF, Estudante> HashMap, para acessar os outros dados do estudante

// Instance of, Pessoa new Estudante - Obrigatório ter para funcionar o código abaixo
//if(x instanceof Estudante) - Verificar se o contrutor é estudante

//Criar uma classe controle com o cadastro, remover e buscar separados
//Salvar o HashMap antes de sair do programa
// HashMap estático