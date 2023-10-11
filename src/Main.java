import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<CadastroLivro> Livro = new ArrayList<>();

        CadastroLivro metodosLivro = new CadastroLivro();

        System.out.println("Bem Vindo ao Sistema de Cadastro e Listagem de Livros em Sebo!");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção: 1 - Cadastrar Livros / 2 - Listar Livros / 0 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    CadastroLivro novoLivro = new CadastroLivro();
                    CadastroAutor novoAutor = new CadastroAutor();

                    System.out.println("Digite o título do livro: ");
                    novoLivro.titulo = scanner.nextLine();

                    System.out.println("Digite o autor: ");
                    novoAutor.nome = scanner.nextLine();

                    System.out.println("Digite o local de Nascimento do autor: ");
                    novoAutor.localNasc = scanner.nextLine();

                    System.out.println("Digite o preço (Digite somente números): ");
                    novoLivro.preco = scanner.nextFloat();

                    System.out.println("Digite a data de Lançamento (dd/MM/aaaa): ");
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")); //recebe como string e converte para localdate
                    Period periodo = Period.between(date, LocalDate.now());
                    //comparação entre a data de nascimento convertida em localdate e data atual(localdate)

                    novoLivro.dataLancamento = date;

                    if (periodo.getYears() >= 5){      //comparação de maioridade
                        System.out.println("O livro tem mais de 5 anos");
                    } else {
                        System.out.println("O livro tem menos de 5 anos. Retornando menu...");
                        break;
                    }

                    novoLivro.autor = novoAutor;

                    Livro.add(novoLivro);

                    System.out.println("Cadastro realizado com sucesso! ");

                    break;
                    case 2:

                        if(Livro.size() > 0){
                                for( CadastroLivro cadaLivro : Livro ) {
                                System.out.println();
                                System.out.println("Título: " + cadaLivro.titulo);
                                System.out.println("Nome do Autor: " + cadaLivro.autor.nome);
                                System.out.println("Local de Nascimento: " + cadaLivro.autor.localNasc);
                                System.out.println("Preço a ser pago: " + cadaLivro.preco);
                                System.out.println("Data de Lançamento: " + metodosLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                System.out.println();
                                System.out.println("Digite 0 para continuar");
                                scanner.nextLine();
                            }

                            opcao = scanner.nextInt();

                        } else {
                            System.out.println("Lista vazia");
                        }

                        break;
                    case 0:
                        System.out.println("Obrigado por utilizar nosso sistema! Forte abraço! ");
                        break;
                    default:
                        System.out.println("Opção inválida, por favor digite uma opção válida! ");
                        break;
            }
        } while(opcao != 0);
    }
}