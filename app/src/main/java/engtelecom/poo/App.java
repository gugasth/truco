package engtelecom.poo;
/**
 * Classe app, é nela que está o método principal do nosso programa.
 * nela instanciamos um truco e iniciamos o jogo.
 */
public class App {
    public static void main(String[] args) {
    // Instanciando um truco
    Truco t = new Truco();

    // Iniciando o jogo
    t.iniciaRodada();
    }
}
