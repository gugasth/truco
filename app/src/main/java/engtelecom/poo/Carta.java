package engtelecom.poo;
import java.awt.Image;

/**
 * Classe que representa uma carta de baralho de truco
 * Ela tem um naipe que pode ser ouro,espadas,paus ou copas.
 * Ela tem um valor que pode ser 3,2,A,K,Q,J,7,6,5,4.
 * Ela é um elemento, ou seja, é uma imagem com frente e verso.
 */
public class Carta extends Elemento {
    /**
     * Atributo que representa o Naipe da carta
     */
    private Naipe naipe;

    /**
     * Atributo que representa o valor da carta
     */
    private Valor valor;

    /**
     * Construtor principal da classe Carta
     * @param naipe da carta
     * @param valor da carta
     */
    public Carta(double x, double y, String primeiraImagem, String segundaImagem, Naipe naipe, Valor valor) {
        super(x, y, primeiraImagem, segundaImagem);
        this.naipe = naipe;
        this.valor = valor;
        Image imagem = carregarImagem(primeiraImagem);
        this.altura = imagem.getHeight(null);
        this.largura = imagem.getWidth(null);
    }

    /**
     * Obtém o naipe da carta
     * @return o naipe da carta
     */
    public Naipe getNaipe() {
        return naipe;
    }

    /**
     * Obtém o número da carta
     * @return o número da carta
     */
    public Valor getValor() {
        return valor;
    }

}