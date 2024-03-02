package engtelecom.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe que representa um jogador de truco, que tem pontuação da rodada e da partida e uma lista de cartas.
 * O jogador pode marcar pontos, vencer rodadas e pegar cartas de um baralho.
 */
public class Jogador {
    /**
     * Cartas do jogador
     */
    protected List<Carta> cartas;

    /**
     * Pontuação referente a rodada específica, isto é, referente a melhor de 3
     */
    private int pontuacaoRodada;

    /**
     * Pontuação referente a partida, isto é, vai até 12.
     */
    private int pontuacaoPartida;

    /**
     * Atributo que indica a pontuação inicial do jogador na rodada
     */
    private final int PONTUACAOINICIALRODADA = 0;

    /**
     * Atributo que indica a pontuação inicial do jogador na partida
     */
    private final int PONTUACAOINICIALPARTIDA = 0;

    /**
     * Atributo que indica a pontuação máxima que um jogador pode alcançar em uma rodada.
     */
    private final int PONTUACAOMAXIMARODADA = 3;

    /**
     * Construtor do jogador
     * @param cartas do jogador
     */
    public Jogador() {
        cartas = new ArrayList<>();
        pontuacaoRodada = this.PONTUACAOINICIALRODADA;
        pontuacaoPartida = this.PONTUACAOINICIALPARTIDA;
    }

    /**
     * Método que incrementa a pontuação de rodada do jogador
     */
    public void marcaPonto(int valorAposta){
        this.pontuacaoRodada++;
        if (this.pontuacaoRodada >= this.PONTUACAOMAXIMARODADA){
            venceRodada(valorAposta);
        }
    }

    /**
     * Método que incrementa a pontuação da partida do jogador
     */
    public void venceRodada(int valorAposta){
        this.pontuacaoPartida += valorAposta;
    }

    /**
     * Método que gera uma nova carta aleatória
     * recebe as dimensões de onde a carta ficará desenhada como parametro
     * @param x dimensão horizontal de onde a carta deve ser desenhada
     * @param y dimensão vertical de onde a carta deve ser desenhada
     * @return uma nova carta, com valor e naipe aleatórios.
     */
    public void pegarNovaCarta(int x, int y) {
        Naipe[] naipes = Naipe.values();
        Valor[] valores = Valor.values();

        Random random = new Random();

        // Gera valor e naipe aleatório pra carta
        int randValor = random.nextInt(valores.length);
        int randNaipe = random.nextInt(naipes.length);
        Valor valorAleatorio = valores[randValor];
        Naipe naipeAleatorio = naipes[randNaipe];

        String imagem = String.format("cartas/%c%c.png", valorAleatorio.getCodigo(), naipeAleatorio.getCodigo());
        Carta carta = new Carta(x, y, imagem, "cartas/fundoa.png", naipeAleatorio, valorAleatorio);
        cartas.add(carta);
    }

    /**
     * Método pra quando o jogador pedir truco
     */
    public boolean recebePropostaTruco(){
        System.out.println("TRUUUUUUUCO!");
        return true;
        // TODO lógica de o que deve acontecer quando alguém pedir truco.
        
    }

    /**
     * Obtém a pontuação atual do jogador
     * @return a pontuação
     */
    public int getPontuacaoRodada() {
        return pontuacaoRodada;
    }

    /**
     * Método pra obter as cartas do jogador
     * @return a lista de cartas
     */
    public List<Carta> getCartas() {
        return cartas;
    }

    /**
     * Método que simboliza que o jogador escolheu uma carta
     * então ela é descartada de sua mão
     * @param carta
     */
    public void escolheCarta(Carta c) {
        cartas.remove(c);
    }

    /**
     * Método que obtêm a pontuação atual do jogador na partida
     * @return a pontuação atual
     */
    public int getPontuacaoPartida() {
        return pontuacaoPartida;
    }

    /**
     * Reinicia a pontuação da rodada do jogador
     */
    public void reiniciaPontuacao() {
        this.pontuacaoRodada = 0;
    }

    /**
     * Altera a pontuação da rodada do jogador
     * @param pontuacaoRodada nova pontuação do jogador
     */
    public void setPontuacaoRodada(int pontuacaoRodada) {
        this.pontuacaoRodada = pontuacaoRodada;
    }

    
    
}