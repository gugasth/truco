package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Essa classe de testes realiza testes do truco
 * realiza testes de comparação de força de cartas comuns,
 * juntamente com teste de pontuação da rodada e da partida.
 * 
 * Não foi possível realizar mais testes pois o jogo depende de interface gráfica
 * e seus métodos foram em sua grande maioria voltados para a parte gráfica
 * 
 * Não foi possível realizar comparação de força de cartas com manilha,
 * pois a manilha depende da vira que é completamente aleatória.
 */
public class TrucoTest {
    Truco truco = new Truco();

    // Testa comparações de cartas e pontuações da rodada e da partida
    @Test
    public void comparaForcasDeCartas(){
        // Instancia uma carta e da pro player 1
        Naipe naipe1 = Naipe.Ouro;
        Valor valor1 = Valor.DOIS;
        Carta carta1 = new Carta(0,0,"cartas/2o.png","2o.png", naipe1, valor1);
        truco.getPlayer1().cartas.add(carta1);

        // Instancia uma carta e da pro player 2
        Naipe naipe2 = Naipe.Ouro;
        Valor valor2 = Valor.QUATRO;
        Carta carta2 = new Carta(0,0,"cartas/4o.png","cartas/4o.png", naipe2, valor2);
        truco.getPlayer2().cartas.add(carta2);

        truco.verificaForca(carta1, carta2);
        
        // a carta 1 deve vencer.
        assertEquals(1, truco.getPlayer1().getPontuacaoRodada());

        // Instancia uma carta e da pro player 2
        Naipe naipe3 = Naipe.Espadas;
        Valor valor3 = Valor.SEIS;
        Carta carta3 = new Carta(0,0,"cartas/6e.png","cartas/6e.png", naipe3, valor3);
        truco.getPlayer2().cartas.add(carta3);

        // a carta 1 deve vencer
        truco.verificaForca(carta1, carta3);

        // Agora deve ter 2 pontos
        assertEquals(2, truco.getPlayer1().getPontuacaoRodada());
        truco.getPlayer1().marcaPonto(1);

        // Venceu a rodada, então tem 1 de pontuação de partida
        assertEquals(1, truco.getPlayer1().getPontuacaoPartida());
    }
}