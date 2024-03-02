package engtelecom.poo;

import java.awt.Image;
import java.awt.MediaTracker;
import java.net.URL;

import javax.swing.ImageIcon;

import edu.princeton.cs.algs4.Draw;

/**
 * Classe que representa um elemento gráfico,
 * ele tem coordenadas, altura, largura e imagem de frente e/ou de verso.
 */
public class Elemento {
    /**
     * Coordenada horizontal do elemento gráfico
     */
    private double x;

    /**
     * Coordenada vertical do elemento gráfico
     */
    private double y;

    /**
     * Imagem de frente do elemento gráfico
     */
    private String primeiraImagem;

    /**
     * Imagem de verso do elemento gráfico (caso houver)
     */
    private String segundaImagem;

    /**
     * Booleano que indica qual imagem atual deve estar sendo desenhada, a primeira ou a segunda.
     */
    private boolean qualImagem;

    /**
     * Largura do elemento (referente ao eixo horizontal)
     */
    protected int largura;

    /**
     * Altura do elemento gráfico (referente ao eixo vertical)
     */
    protected int altura;

     /**
     * Construtor padrão de elemento gráfico
     * @param x coordenada x do elemento
     * @param y coordenada y do elemento
     * @param primeiraImagem imagem da frente
     * @param segundaImagem imagem do verso
     * @param altura altura do elemento
     * @param largura largura do elemento
     */
    public Elemento(double x, double y, String primeiraImagem, String segundaImagem) {
    this.x = x;
    this.y = y;
    this.primeiraImagem = primeiraImagem;
    this.segundaImagem = segundaImagem;
    this.qualImagem = true;
    Image imagem = carregarImagem(primeiraImagem);
    this.altura = imagem.getHeight(null);
    this.largura = imagem.getWidth(null);
}


    /**
     * Construtor de elemento para altura e largura que precisam ser declarados para evitar erros de renderização de imagem
     * @param x coordenada x do elemento
     * @param y coordenada y do elemento
     * @param primeiraImagem imagem da frente
     * @param segundaImagem imagem do verso
     * @param altura altura do elemento
     * @param largura largura do elemento
     */
    public Elemento(double x, double y, String primeiraImagem, String segundaImagem, int altura, int largura) {
    this.x = x;
    this.y = y;
    this.primeiraImagem = primeiraImagem;
    this.segundaImagem = segundaImagem;
    this.qualImagem = true;
    Image imagem = carregarImagem(primeiraImagem);
    this.largura = imagem.getWidth(null);
    this.setLargura(largura);
    this.altura = imagem.getHeight(null);
    this.setAltura(altura);
}

    /**
     * Carrega uma imagem e retorna ela
     * @param arquivo arquivo da imagem
     * @return a imagem.
     */
    protected Image carregarImagem(String arquivo) {
        ImageIcon ii = new ImageIcon(arquivo);

        if ((ii == null) || (ii.getImageLoadStatus() != MediaTracker.COMPLETE)) {
            URL url = Draw.class.getResource("/" + arquivo);
            if (url == null)
                throw new IllegalArgumentException("imagem " + arquivo + " não encontrada");
            ii = new ImageIcon(url);
        }

        Image image = ii.getImage();
        return image;
    }

    /**
     * Método que desenha
     * @param draw arquivo draw a ser desenhado
     */
    public void desenhar(Draw draw) {
        // verifica se deve desenhar a imagem de frente ou a imagem de verso
        if (this.qualImagem) {
            draw.picture(this.x, this.y, this.primeiraImagem);
        } else {
            draw.picture(this.x, this.y, this.segundaImagem);
        }
    }

    /**
     * Verifica se as coordenadas do clique do mouse estão contidas dentro dos
     * limites da carta. O método draw.picture desenha a imagem a partir do centro (x,y)
     * 
     * @param px -- coordenada X do clique
     * @param py -- coordenada Y do clique
     * @return true se o clique foi dentro da area da carta
     */
    public boolean clicouDentro(double px, double py) {
        if (this.x + this.largura > px && this.x - this.largura < px && this.y + this.altura > py && this.y - this.altura < py){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que vira o elemento para a imagem secundária
     */
    public void virar(Draw draw) {
        this.qualImagem = !this.qualImagem;
        desenhar(draw);
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Obtém a largura do elemento
     * @return a largura
     */
    public int getLargura() {
        return largura;
    }

    /**
     * Obtém a altura do elemento
     * @return a altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Altera a largura do elemento
     * @param largura nova largura
     */
    public void setLargura(int largura) {
        this.largura = largura;
    }

    /**
     * Altera a altura do elemento
     * @param altura nova altura
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Booleano pra descobrir em qual imagem o elemento está
     * @return um booleano que é true se for a imagem da frente ou false se for a imagem de trás
     */
    public boolean isQualImagem() {
        return qualImagem;
    }
    
}