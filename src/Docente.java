import java.util.HashMap;
import java.util.Map;

public class Docente {

	String matricula, cpf, nome;
	String tipo = "docente";
	Map<String, String> ListaDocentes = new HashMap<String, String>();

	public void cadastrarDocente() {
		System.out.println("\n \n-----> Cadastrando docente");
		Pessoa pessoa = new Pessoa();

		pessoa.cadastrarPessoa();// Cadastra o docente como pessoa

		this.ListaDocentes.put(pessoa.getCpf(), pessoa.getNome());

		System.out.printf("\n----> Cadastro do docente %s, realizado com sucesso!", pessoa.getNome()); // Cadastro
																										// Estudante
																										// Completo
																										// - AVISO

		String matricula = pessoa.gerarMatricula("docente");
		Pessoa.armazenarDados("docente", ListaDocentes, matricula);

		System.out.println("----> Para acessar o portal use as seguntes credenciais: "); // Credenciais Estudante-
																							// AVISO
		System.out.printf("\n - Matrícula: %s", matricula); // Login Matricula Estudante - AVISO
		System.out.printf("\n - Senha: %s (Seu CPF) \n", pessoa.getCpf()); // Senha CPF Estudante - AVISO
		System.out.println("\n-----> OBS: GUARDE ESSES DADOS, SÓ É POSSÍVEL O CADASTRO COM ESSAS INFORMAÇÕES"); // Alerta
																												// -
																												// AVISO
	}

	public void getDados() {
		int contador = 0;
		for (Map.Entry<String, String> Entry : this.ListaDocentes.entrySet()) {
			System.out.println("Docente n° " + contador);
			System.out.printf("\nNome: %s", Entry.getValue());
			System.out.printf("\nCPF: %s", Entry.getKey());
			contador++;
		}
		// ListaEstudantes.forEach((k, v) -> System.out.printf("\n \nkey: %s | value:
		// %s", k, v)); //Método 2 de mostrar dados
	}

}
