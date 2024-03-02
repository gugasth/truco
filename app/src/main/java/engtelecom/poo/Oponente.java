package engtelecom.poo;

import java.util.Random;

/**
 * Classe que representa o oponente(bot) que jogará contra a pessoa no jogo de truco
 * o oponente escolhe as cartas de forma aleatória, se tornando assim completamente imprevisível de suas ações
 * algo que é um ponto positivo em um jogo de sorte como o truco.
 * entretanto, para aceitar ou recusar uma proposta de truco, ele analisa suas cartas
 * e aceita o truco apenas se ele realmente estiver com boas cartas.
 * ou então se ele suspeitar que seu oponente humano está blefando (20% de chance).
 */
public class Oponente extends Jogador{
    /**
     * Atributo que indica a força média das cartas que a máquina deve ter pra aceitar a proposta de truco
     */
    private final int FORCAPRATRUCAR = 7;

    /**
     * Método que simboliza que o oponente escolheu uma carta
     * escolhe uma carta aleatória e remove ela do baralho
     * @param carta
     */
    public Carta escolheCarta() {
        // gera um indice
        Random random = new Random();
        int posicaoCarta = random.nextInt(cartas.size());
    
        // acessa a carta e remove ela do baralho
        Carta cartaEscolhida = cartas.get(posicaoCarta);
        cartas.remove(posicaoCarta);
    
        // retorna a carta
        return cartaEscolhida;
    }

    /**
     * Método que realiza a ação de quando a máquina recebe a proposta de truco feita pelo jogador humano.
     * se a média de força das cartas da máquina for superior a 7
     * então a máquina aceita o pedido de truco, caso contrário, ela recusa.
     * A máquina também aceita 20% dos trucos mesmo com a força das cartas fraca,
     * para verificar se o oponente humano pediu truco blefando.
     */
    @Override
    public boolean recebePropostaTruco() {
        int mediaForca = 0;
        for (Carta carta : cartas) {
            mediaForca += carta.getValor().getForca();
        }
        mediaForca = mediaForca / cartas.size();
        Random random = new Random();
        // gera um número aleatório entre 0 e 10
        int numeroAleatorio = random.nextInt(11);
        // Se tiver com as cartas boas ou se achar que o oponente está blefando, então aceita o truco
        if (mediaForca > this.FORCAPRATRUCAR || (numeroAleatorio >= 0 && numeroAleatorio <= 2)) {            System.out.println("O oponente aceitou a proposta de truco.");
            return true;
        } else {
            System.out.println("O oponente recusou a proposta de truco."); 
            return false;
        }
    }
    
}