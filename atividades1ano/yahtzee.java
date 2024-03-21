package atividades1ano;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Menu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Jogador> jogadores = new ArrayList<>();
        List<int[]> cartela = new ArrayList<>();
        Cadastrar cadastrar = new Cadastrar(jogadores);

        System.out.println("Bem-vindo ao Yahtzee!");

        while (true) {
            System.out.println("==============================================");
            System.out.println("Menu:");
            System.out.println("----------------------------------------------");
            System.out.println("1. Jogar");
            System.out.println("2. Cadastrar Jogadores");
            System.out.println("3. Alterar jogadores");
            System.out.println("4. Apagar jogadores");
            System.out.println("5. Mostrar lista de jogadores");
            System.out.println("6. Sair");
            System.out.println("----------------------------------------------");
            System.out.print("Escolha uma das opções: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    if (jogadores.isEmpty()) {
                        System.out.println("Por favor, cadastre jogadores antes de jogar.");
                    } else {
                        Yahtzee.jogar(jogadores, cartela);
                    }
                    break;
                case 2:
                    cadastrar.cadastrarJogadores();
                    cadastrar.listarJogadores();
                    break;
                case 3:
                    if (jogadores.isEmpty()) {
                        System.out.println("Por favor, cadastre jogadores antes de alterá-los.");
                        break;
                    } else {
                        cadastrar.listarJogadores();
                        System.out.print("Digite o ID do jogador que você deseja alterar: ");
                        int idParaAlterar = scanner.nextInt();
                        scanner.nextLine();
                        cadastrar.alterarJogador(idParaAlterar);
                        cadastrar.listarJogadores();
                        break;
                    }
                case 4:
                    if (jogadores.isEmpty()) {

                        System.out.println("Por favor, cadastre jogadores antes de apagá-los.");
                    } else {
                        cadastrar.apagarJogador();
                    }
                    break;
                case 5:
                    if (jogadores.isEmpty()) {
                        System.out.println("Por favor, cadastre jogadores antes de mostrar a Lista de Jogadores.");
                    } else {
                        cadastrar.listarJogadores();
                    break;
                    }
                    break;
                case 6:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
        }
     
    }
}

class Yahtzee {

    public static final String[] categorias = {
            "Uns", "Dois", "Três", "Quatros", "Cincos", "Seis",
            "Trinca", "Quadra", "Fullhouse", "Seq. Baixa", "Seq. Alta", "Yahtzee", "Sorte"
    };

    public static void jogar (List<Jogador> jogadores, List<int[]> cartela) {
        Scanner scanner = new Scanner(System.in);

        int rodadas = 0;
        int maxRodadas = 13;

        while (rodadas < maxRodadas) {
            rodadas++;

            System.out.println("--------------------------------------------------");
            System.out.println("Rodada " + rodadas);
            System.out.println("--------------------------------------------------");

            for (Jogador jogador : jogadores) {
                System.out.println();
                System.out.println("Vez do jogador: " + jogador.getNome());
                System.out.println();

                int[] dados = new int[5];
                int[] dadosSelecionados = new int[5];

                for (int i = 0; i < dados.length; i++) {
                    dados[i] = Dado.rolarDado();
                }

                for (int valor = 0; valor < 5; valor++) {
                    System.out.print("Posição " + (valor + 1) + " = " + dados[valor] + "\n");
                }
                System.out.println();

                for (int tentativa = 0; tentativa <= 1; tentativa++) {
                    System.out.println("Tentativa " + (tentativa + 1) + ":");
                    int p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0;

                    for (int i = 0; i < 5; i++) {
                        System.out.println("Você quer alterar o valor de algum dos dados?\n"
                                + "Sim = 1.\n"
                                + "Não = Qualquer outro número.");
                        int alt = scanner.nextInt();
                        if (alt != 1) {
                            System.out.println("Ok\n");
                            break;
                        }
                        System.out.print("Qual posição você deseja alterar? (1-5): ");
                        int dadoSelecionado = scanner.nextInt();

                        if (dadoSelecionado == 1 && p1 == 0) {
                            p1 = 1;
                            dados[dadoSelecionado - 1] = Dado.rolarDado();
                        } else if (dadoSelecionado == 2 && p2 == 0) {
                            p2 = 1;
                            dados[dadoSelecionado - 1] = Dado.rolarDado();
                        } else if (dadoSelecionado == 3 && p3 == 0) {
                            p3 = 1;
                            dados[dadoSelecionado - 1] = Dado.rolarDado();
                        } else if (dadoSelecionado == 4 && p4 == 0) {
                            p4 = 1;
                            dados[dadoSelecionado - 1] = Dado.rolarDado();
                        } else if (dadoSelecionado == 5 && p5 == 0) {
                            p5 = 1;
                            dados[dadoSelecionado - 1] = Dado.rolarDado();
                        } else if (dadoSelecionado == 1 && p1 == 1) {
                            System.out.println("Já selecionado");
                            i--;
                        } else if (dadoSelecionado == 2 && p2 == 1) {
                            System.out.println("Já selecionado");
                            i--;
                        } else if (dadoSelecionado == 3 && p3 == 1) {
                            System.out.println("Já selecionado");
                            i--;
                        } else if (dadoSelecionado == 4 && p4 == 1) {
                            System.out.println("Já selecionado");
                            i--;
                        } else if (dadoSelecionado == 5 && p5 == 1) {
                            System.out.println("Já selecionado");
                            i--;
                        } else {
                            System.out.println("Índice inválido. Tente novamente.");
                            i--;
                        }
                    }

                    System.out.print("Dados lançados:\n");
                    for (int valor = 0; valor < 5; valor++) {
                        System.out.print("Posição " + (valor + 1) + " = " + dados[valor] + "\n");
                    }
                    System.out.println();
                }

                System.out.println("Calculando pontos...");
                System.out.println("----------------------");

                int[] dadosCopy = Arrays.copyOf(dados, dados.length);

                for (int i = 0; i < categorias.length; i++) {
                    int pontuacao = PontuacaoYahtzee.Score(dadosCopy, categorias[i]);
                    System.out.println((i + 1) + ". " + categorias[i] + ": " + pontuacao + " pontos");
                }

                int somaPrimeirasCategorias = 0;
                for (int i = 0; i < 6; i++) {
                    somaPrimeirasCategorias += jogador.getPontuacao(i + 1);
                }

                int categoriaEscolhida = -1;
                do {
                    System.out.println("------------------------------");
                    System.out.print("Escolha a categoria (1-13): ");
                    categoriaEscolhida = scanner.nextInt();

                    if (jogador.isCategoriaPreenchida(categoriaEscolhida)) {
                        System.out.println("Categoria já preenchida. Escolha outra.");
                        categoriaEscolhida = -1;
                    }
                } while (categoriaEscolhida < 1 || categoriaEscolhida > 15);

                int pontuacaoCategoria = PontuacaoYahtzee.Score(dadosCopy,
                        categorias[categoriaEscolhida - 1]);
                jogador.atualizarPontuacao(categoriaEscolhida, pontuacaoCategoria);
            }

            Cartela.Cartela(jogadores);

            if (rodadas == maxRodadas) {

                System.out.println("==============================================");
                System.out.println("Fim do jogo! Todas as rodadas foram concluídas.");
                Vencedor(jogadores);
                return;
            }

            System.out.println("==============================================");
            System.out.println("Opções");
            System.out.println("1. Continuar jogo");
            System.out.println("2. Salvar cartela");
            System.out.println("3. Voltar pro menu");
            System.out.println("==============================================");
            System.out.print("Escolha uma opção: ");
    
            int opcaoRodada = scanner.nextInt();
    
            switch (opcaoRodada) {
                case 1:
                    break;
                case 2:
                    Cartela.salvarCartela(jogadores, cartela, opcaoRodada);
                    System.out.println("Cartela salva.");
                    break;
                case 3:
                    Voltar(jogadores, cartela);
                    System.out.println("==============================================");
                    System.out.println("Saindo da Partida...");
                    return;
                default:
                    System.out.println("Opção inválida. Continuando jogo...");
                    break;
            }
        }
    }

    public static void Voltar(List<Jogador> jogadores, List<int[]> cartela) {
        for (Jogador jogador : jogadores) {
            jogador.zerarPontuacoes();
        }

        cartela.clear();
    }

    public static void Vencedor(List<Jogador> jogadores) {
        Jogador vencedor = jogadores.get(0);

        for (Jogador jogador : jogadores) {
            if (jogador.getPontuacaoTotal() > vencedor.getPontuacaoTotal()) {
                vencedor = jogador;
            }
        }

        System.out.println("-----------------------------------------");
        System.out.println("Vencedor da partida: " + vencedor.getNome());
        System.out.println("Pontuação Total: " + vencedor.getPontuacaoTotal());
        System.out.println("Parabéns!");
        System.out.println("-----------------------------------------");
    }
}

class Jogador {
    private static int contadorId = 1;
    private final int id;
    private String nome;
    private final List<Pontuacao> pontuacoes;

    public Jogador(String nome) {
        this.id = contadorId++;
        this.nome = nome;
        this.pontuacoes = new ArrayList<>();
    }

    public void atualizarPontuacao(int categoria, int pontuacao) {
        for (Pontuacao pontuacaoAtual : pontuacoes) {
            if (pontuacaoAtual.getCategoria() == categoria) {
                pontuacaoAtual.setPontuacao(pontuacao);
                return;
            }
        }
        adicionarPontuacao(categoria, pontuacao);
    }

    public void zerarPontuacoes() {
        pontuacoes.clear();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isCategoriaPreenchida(int categoria) {
        for (Pontuacao pontuacao : pontuacoes) {
            if (pontuacao.getCategoria() == categoria) {
                return true;
            }
        }
        return false;
    }

    public void adicionarPontuacao(int categoria, int pontuacao) {
        Pontuacao pontuacaoAtual = new Pontuacao(categoria, pontuacao);
        pontuacoes.add(pontuacaoAtual);
    }

    public int getPontuacaoTotal() {
        int pontuacaoTotal = 0;
        for (Pontuacao pontuacao : pontuacoes) {
            pontuacaoTotal += pontuacao.getPontuacao();
        }
        return pontuacaoTotal;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome;
    }

    public int getPontuacao(int categoria) {
        for (Pontuacao pontuacao : pontuacoes) {
            if (pontuacao.getCategoria() == categoria) {
                return pontuacao.getPontuacao();
            }
        }
        return 0;
    }
}

class Dado {
    private static final Random random = new Random();

    public static int rolarDado() {
        return random.nextInt(6) + 1;
    }
}

class Cartela {

        public static void Cartela (List<Jogador> jogadores) {
        int numJogadores = jogadores.size();
        int numCategorias = Yahtzee.categorias.length;
    
        System.out.printf("%-15s", "");
        for (String categoria : Yahtzee.categorias) {
            System.out.printf("%-15s", categoria.substring(0, Math.min(categoria.length(), 15)));
        }
        System.out.println();
    
        for (Jogador jogador : jogadores) {
            System.out.printf("%-15s", jogador.getNome().substring(0, Math.min(jogador.getNome().length(), 15)));
            int somaPrimeirasCategorias = 0;
    
            for (int i = 0; i < 6; i++) {
                int pontuacaoCategoria = jogador.getPontuacao(i + 1);
                somaPrimeirasCategorias += pontuacaoCategoria;
                System.out.printf("%-15d", pontuacaoCategoria);
            }
    
            if (somaPrimeirasCategorias >= 63) {
                jogador.adicionarPontuacao(-1, 35);
            } else {
                jogador.adicionarPontuacao(-1, 0);
            }
    
            for (int i = 6; i < numCategorias; i++) {
                int pontuacao = jogador.getPontuacao(i + 1);
                System.out.printf("%-15d", pontuacao);
            }
    
            System.out.println();
        }
    
        for (Jogador jogador : jogadores) {
            int pontosRestantes = 63 - jogador.getPontuacao(-1);
            System.out.println(" ");
            System.out.print("--------------------------------------------------");
            System.out.println("\nJogador: " + jogador.getNome());
            System.out.println("Pontuação Total: " + jogador.getPontuacaoTotal());
            System.out.println("--------------------------------------------------");
        }
    }

    public static void salvarCartela(List<Jogador> jogadores, List<int[]> cartela, int rodada) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Cartela.txt"))) {

            writer.write("Rodada salva: " + rodada);
            writer.newLine();
    
            for (Jogador jogador : jogadores) {
                writer.write(jogador.getNome() + " - Pontuação Total: " + jogador.getPontuacaoTotal());
                writer.newLine();
    
                for (String categoria : Yahtzee.categorias) {
                    writer.write(categoria + ": " + jogador.getPontuacao(Arrays.asList(Yahtzee.categorias).indexOf(categoria) + 1));
                    writer.newLine();
                }
                writer.newLine();
            }
    
            writer.write("Cartela:");
            writer.newLine();
            for (int[] linhaCartela : cartela) {
                for (int valor : linhaCartela) {
                    writer.write(valor + "\t");
                }
                writer.newLine();
            }

            writer.write("Rodada: " + rodada);
            writer.newLine();
    
            System.out.println("Jogo da rodada " + rodada + " salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }
}

class Cadastrar {

    public final List<Jogador> jogadores;

    public Cadastrar(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void cadastrarJogadores() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.print("Quantos jogadores você deseja cadastrar? ");
        int numJogadores = 0;
        if (scanner.hasNextInt()) {
            numJogadores = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println(" ");
            System.out.println("------------------------");
            System.out.println("Forneça um número válido");
            System.out.println("------------------------");
            System.out.println(" ");
            scanner.nextLine();
        }

        for (int i = 0; i < numJogadores; i++) {
            System.out.println(" ");
            System.out.print("Digite o nome do Jogador " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            System.out.println(" ");
            System.out.println("-------------------------------");
            System.out.println("Jogador cadastrado com sucesso!");
            System.out.println("-------------------------------");

            Jogador jogador = new Jogador(nome);
            jogadores.add(jogador);
        }
    }

    public void listarJogadores() {

        System.out.println("Lista de Jogadores:");

        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
            System.out.println("Pontuação Total: " + jogador.getPontuacaoTotal());
            System.out.println();
        }
    }

    public void apagarJogador() {
        Scanner scanner = new Scanner(System.in);
        boolean jogadorEncontrado = false;

        listarJogadores();

        System.out.println("\nDigite o nome do jogador que você quer apagar: ");
        String nomeParaApagar = scanner.nextLine();

        for (int i = 0; i < jogadores.size(); i++) {
            Jogador jogador = jogadores.get(i);
            if (jogador.getNome().equals(nomeParaApagar)) {
                jogadores.remove(i);
                jogadorEncontrado = true;
                System.out.println("Jogador removido com sucesso!");
                System.out.println("");
                break;
            }
        }

        if (!jogadorEncontrado) {
            System.out.println("O nome digitado não foi encontrado.");
            System.out.println("");
        }
    }

    public void alterarJogador(int id) {
        for (Jogador jogador : jogadores) {
            if (jogador.getId() == id) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Digite o novo nome para o Jogador " + jogador.getId() + ": ");
                String nome = scanner.nextLine();
                jogador.setNome(nome);

                System.out.println("Jogador alterado com sucesso!");
                return;
            }
        }

        System.out.println("Jogador com ID " + id + " não encontrado.");
    }
}

class PontuacaoYahtzee {
    public static int Score(int[] dados, String categoria) {
        switch (categoria.toLowerCase()) {
            case "uns":
                return somaDado(dados, 1);
            case "dois":
                return somaDado(dados, 2);
            case "três":
                return somaDado(dados, 3);
            case "quatros":
                return somaDado(dados, 4);
            case "cincos":
                return somaDado(dados, 5);
            case "seis":
                return somaDado(dados, 6);
            case "trinca":
                return trinca(dados);
            case "quadra":
                return quadra(dados);
            case "fullhouse":
                return fullHouse(dados);
            case "seqcurta":
                return sequenciaBaixa(dados);
            case "seqlonga":
                return sequenciaAlta(dados);
            case "sorte":
                return chance(dados);
            case "yahtzee":
                return yahtzee(dados);
            default:
                return 0;
        }
    }

    public static int somaDado(int[] dados, int valorDado) {
        int soma = 0;
        for (int dado : dados) {
            if (dado == valorDado) {
                soma += valorDado;
            }
        }
        return soma;
    }

    public static int trinca(int[] dados) {
        int[] contagem = new int[7];
        int soma = 0;
        for (int dado : dados) {
            contagem[dado]++;
        }

        for (int i = 6; i >= 1; i--) {
            if (contagem[i] >= 3) {
                for (int d : dados) {
                    soma += d;
                }
                break;
            }
        }
        return soma;
    }

    public static int quadra(int[] dados) {
        int[] contagem = new int[7];
        int soma = 0;
        for (int dado : dados) {
            contagem[dado]++;
        }

        for (int i = 6; i >= 1; i--) {
            if (contagem[i] >= 4) {
                for (int d : dados) {
                    soma += d;
                }
                break;
            }
        }
        return soma;
    }

    public static int fullHouse(int[] dados) {
        int[] contagem = new int[7];
        boolean trinca = false;
        boolean par = false;

        for (int dado : dados) {
            contagem[dado]++;
        }

        for (int i = 6; i >= 1; i--) {
            if (contagem[i] == 3) {
                trinca = true;
            } else if (contagem[i] == 2) {
                par = true;
            }
        }

        if (trinca && par) {
            return 25;
        } else {
            return 0;
        }
    }

    public static int calcularSequencia(int[] dados, int chave) {
        Arrays.sort(dados);
        int sequencia = 0;

        for (int i = 0; i < dados.length - 1; i++) {
            if (dados[i] + 1 == dados[i + 1]) {
                sequencia++;
            }
        }

        if (sequencia == dados.length - 1 && chave == 2) {
            return 40;
        } else if (sequencia >= dados.length - 2 && chave == 1) {
            return 30;
        } else {
            return 0;
        }
    }

    public static int sequenciaBaixa(int[] dados) {
        int resultado = calcularSequencia(dados, 1);
        return resultado;
    }

    public static int sequenciaAlta(int[] dados) {
        int resultado = calcularSequencia(dados, 2);
        return resultado;
    }

    public static int yahtzee(int[] dados) {
        for (int i = 1; i < dados.length; i++) {
            if (dados[i] != dados[0]) {
                return 0;
            }
        }
        return 50;
    }

    public static int chance(int[] dados) {
        int soma = 0;
        for (int dado : dados) {
            soma += dado;
        }
        return soma;
    }
}

class Pontuacao {

    private int categoria;
    private int pontuacao;

    public Pontuacao(int categoria, int pontuacao) {
        this.categoria = categoria;
        this.pontuacao = pontuacao;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }
}