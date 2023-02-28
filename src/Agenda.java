import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Agenda {
    private static ArrayList<Contato> todosOsContatos = new ArrayList<>();
    public static void main(String[] args) {menuInicial();}

    public static Integer proxCodContato = 0;

    public static void menuInicial(){
        Scanner ler = new Scanner(System.in);
        Integer opcao = 0;
        do {
            System.out.println("Bem-vindo ao Sistema");
            System.out.println("1 - INCLUIR");
            System.out.println("2 - EXCLUIR");
            System.out.println("3 - PESQUISAR");
            System.out.println("4 - LISTAR");
            System.out.println("5 - ALTERAR");
            System.out.println("6 - SAIR");
            System.out.println();
            System.out.println("Digite a opção desejada: ");
            opcao = Integer.parseInt(ler.nextLine());
            switch (opcao) {
                case 1 -> cadastroDeContato();
                case 2 -> excluirContato();
               // case 3 -> existe();
                case 4 -> listarContato();
                case 5 -> editarContato();
            }
        } while (opcao != 6);
    }



    public static void cadastroDeContato() {
        Scanner ler = new Scanner(System.in);
        Contato contato = new Contato();

        System.out.println("Cadastro de Contato");
        System.out.println("Digite o nome a ser cadastrado: ");
        contato.setCodigo(proxCodContato +=1);
        contato.setNome(ler.nextLine());

        todosOsContatos.add(contato);
    }

    public static void listarContato() {
        for(Contato listinha : todosOsContatos){
            System.out.print(listinha.getCodigo() + " |\t");
            System.out.println(listinha.getNome() + " |\t");
        }
    }

    public static void excluirContato() {
        Scanner ler = new Scanner(System.in);
        listarContato();
        Boolean removeu;
        do {
            System.out.println("Digite o código do contato que deseja deletar: ");
            Integer codigoADeletar = Integer.parseInt(ler.nextLine());
            removeu = todosOsContatos.removeIf(contato -> contato.getCodigo() == codigoADeletar);
            if (removeu == false) {
                System.out.println("Código Inválido");
            }
        } while (removeu == false);
    }

    public static void editarContato() {
        Scanner ler = new Scanner(System.in);
        Optional<Contato> produtoASerEditado;
        listarContato();
        do {
            System.out.println("Digite o código do contato que deseja editar: ");
            Integer codContatoAEditar = Integer.parseInt(ler.nextLine());
            produtoASerEditado = todosOsContatos.stream().filter(contato -> contato.getCodigo() == codContatoAEditar).findFirst();
            if (produtoASerEditado.isEmpty()) {
                System.out.println("Código Inválido");
            }
        } while (produtoASerEditado.isEmpty());

        System.out.println("Digite o novo nome do contato: ");
        produtoASerEditado.get().setNome(ler.nextLine());
    }

   /* public static boolean existe() {
        Scanner ler = new Scanner(System.in);
        // Contato contato = new Contato();
        Optional<Contato> contatoASerEditado;
        System.out.println("Digite o nome do contato que deseja procurar: ");
        String nomeContatoAPesquisar = ler.nextLine();
        contatoASerEditado = todosOsContatos.stream().filter(produto -> produto.getNome() == nomeContatoAPesquisar).findFirst();
        if (contatoASerEditado.isEmpty()) {
            return true;
        }
            return false;
    }
    */
}