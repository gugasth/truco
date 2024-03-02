package engtelecom.poo;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;
import edu.princeton.cs.algs4.StdAudio;

/**
 * Classe que representa o jogo de truco
 * essa classe é responsável pelas regras e interações de um jogo de truco jogo.
 * assim como é responsável por toda a interface gráfica do jogo.
 */
public class Truco implements DrawListener{
    /**
     * Atributo que representa o jogador humano do truco
     */
    private Jogador player1;

    /**
     * Atributo que representa o jogador 2 (máquina)
     */
    private Oponente player2;

    /**
     * Atributo que representa a lista de elementos gráficos do truco
     */
    private List<Elemento>elementos;

    /**
     * Atributo que é o objeto de desenho Draw.
     */
    private Draw draw;

    /**
     * Atributo que define o valor atual da aposta
     * inicia em 1, mas caso alguem peça truco, o valor pode aumentar para 3,6,9,12.
     */
    private int valorAposta = 1;

    /**
     * Atributo que representa a coordenada x do local das cartas descartadas
     */
    private final int XVIRA = 600;

    /**
     * Atributo que representa a coordenada y do local das cartas descartadas
     */
    private final int YVIRA = 430;

    /**
     * Atributo que representa a coordenada x do botão de truco
     */
    private final int XBOTAO = 1020;

    /**
     * Atributo que representa a coordenada y do botão de truco
     */
    private final int YBOTAO = 428;

    /**
     * Atributo que representa a largura correta da imagem do botão
     */
    private final int LARGURABOTAO = 74;

    /**
     * Atributo que representa a altura correta da imagem do botão
     */
    private final int ALTURABOTAO = 167;

    /**
     * Atributo elemento que representa um botão de truco
     */
    private final Elemento BOTAOTRUCO = new Elemento(XBOTAO,YBOTAO, "botoes/botaoTruco.png","botoes/botaoTruco.png", LARGURABOTAO,ALTURABOTAO);

    /**
     * Atributo que indica o valor padrão que vale cada rodada na partida do truco.
     */
    private final int VALORAPOSTAPADRAO = 1;

    /**
     * Atributo que indica a pontuação máxima em que se pode alcançar em uma partida de truco.
     */
    private final int PONTUACAOMAXIMAPARTIDA = 12;

    /**
     * Coordenada x de cartas descartadas, utilizada para localiza-las
     */
    private final int COORDENADAXDESCARTADAS = 1500;

    /**
     * Coordenada x referente a localização do placar da rodada e da partida
     */
    private final int COORDENADAXPLACAR = 1500;

    /**
     * Coordenada y referente a localização do placar da rodada do truco
     */
    private final int COORDENADAYPLACARRODADA = 700;

    /**
     * Coordenada y referente a localização do placar da partida de truco
     */
    private final int COORDENADAYPLACARPARTIDA = 750;

    /**
     * Tamanho horizontal da janela do truco
     */
    private final int TAMANHOHORIZONTALTRUCO = 1600;

    /**
     * Tamanho vertical da janela do truco
     */
    private final int TAMANHOVERTICALTRUCO = 800;

    /**
     * Atributo que representa o valor zero, utilizado para diversas finalidades no código.
     */
    private final int ZERO = 0;

    /**
     * Atributo que indica a coordenada y que estarão localizadas as
     * cartas do jogador na interface gráfica do jogo de truco
     */
    private final int COORDENADAVERTICALCARTASJOGADOR = 200;

    /**
     * Atributo que indica a coordenada y que estarão localizadas as
     * cartas da máquina na interface gráfica do jogo de truco
     */
    private final int COORDENADAVERTICALCARTASMAQUINA = 650;

    /**
     * Atributo que indica a coordenada x da primeira carta dos dois jogadores
     * tanto do jogador humano quanto da máquina
     * ambas as cartas estarão alinhadas nessa mesma coordenada x
     */
    private final int COORDENADAXPRIMEIRACARTA = 200;

    /**
     * Atributo que indica a coordenada x da segunda carta dos dois jogadores
     * tanto do jogador humano quanto da máquina
     * ambas as cartas estarão alinhadas nessa mesma coordenada x
     */
    private final int COORDENADAXSEGUNDACARTA = 600;

    /**
     * Atributo que indica a coordenada x da terceira carta dos dois jogadores
     * tanto do jogador humano quanto da máquina
     * ambas as cartas estarão alinhadas nessa mesma coordenada x
     */
    private final int COORDENADAXTERCEIRACARTA = 1000;

    /**
     * Atributo que indica a coordenada y referente as cartas descartadas pelo jogador humano
     */
    private final int YDESCARTADASHUMANO = 200;

    /**
     * Atributo que indica a coordenada y referente as cartas descartadas pela máquina
     */
    private final int YDESCARTADASMAQUINA = 600;

    /**
     * Atributo que indica a pontuação mínima que deve ser feita em uma rodada de truco
     * para que alguém vença a rodada.
     */
    private final int PONTUACAOVITORIARODADA = 2;

    /**
     * Pontuação necessária que ambos os jogadores devem ter para acontecer a "mão de ferro"
     */
    private final int PONTUACAOMAODEFERRO = 11;

    /**
     * Construtor do truco
     * @param player1 é o jogador humano
     * @param player2 é o oponente do jogador humano, ou seja, a máquina.
     */
    public Truco() {
        this.draw = new Draw("Jogo de truco");
        draw.setXscale(this.ZERO, this.TAMANHOHORIZONTALTRUCO);
        draw.setYscale(this.ZERO, this.TAMANHOVERTICALTRUCO);
        this.draw.addListener(this);
        elementos = new ArrayList<>();
        // Para evitar piscar na tela ao desenhar os componentes
        // Veja mais em
        // https://docs.oracle.com/javase/tutorial/extra/fullscreen/doublebuf.html
        this.draw.enableDoubleBuffering();

        this.draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //String carta = String.format("cartas/%c%c.png", valor, naipe);
        //this.elemento = new Elemento(400, 300, carta, "cartas/fundoa.png");
        

        Jogador jogador = new Jogador();
        this.player1 = jogador;

        Oponente oponente = new Oponente();
        this.player2 = oponente;
    }

    /**
     * Método que inicia a rodada do jogo de truco
     * ambos os jogadores compram as 3 cartas, tudo é adicionado a interface gráfica (reiniciada)
     * e a rodada começa/recomeça.
     * então o jogador humano é aguardado para começar a jogar.
     */
    public void iniciaRodada(){
        reiniciaValorPadrao();
        Carta vira = geraVira();
        adicionaElemento(vira);

        player1.pegarNovaCarta(this.COORDENADAXPRIMEIRACARTA,this.COORDENADAVERTICALCARTASJOGADOR);
        player1.pegarNovaCarta(this.COORDENADAXSEGUNDACARTA, this.COORDENADAVERTICALCARTASJOGADOR);
        player1.pegarNovaCarta(this.COORDENADAXTERCEIRACARTA, this.COORDENADAVERTICALCARTASJOGADOR);

        player2.pegarNovaCarta(this.COORDENADAXPRIMEIRACARTA, this.COORDENADAVERTICALCARTASMAQUINA);
        player2.pegarNovaCarta(this.COORDENADAXSEGUNDACARTA, this.COORDENADAVERTICALCARTASMAQUINA);
        player2.pegarNovaCarta(this.COORDENADAXTERCEIRACARTA, this.COORDENADAVERTICALCARTASMAQUINA);

        for (Carta carta : player1.getCartas()) {
            voltaManilha(carta);
            verificaManilha(vira, carta);
            adicionaElemento(carta);

        }

        for (Carta carta : player2.getCartas()) {
            carta.virar(draw);
            voltaManilha(carta);
            verificaManilha(vira, carta);
            adicionaElemento(carta);

        }

        // verifica mão de ferro
        if (this.player1.getPontuacaoPartida() == this.PONTUACAOMAODEFERRO && this.player2.getPontuacaoPartida() == this.PONTUACAOMAODEFERRO){
            for (Carta carta : player1.getCartas()) {
                carta.virar(draw);
            }
        }

        adicionaElemento(BOTAOTRUCO);
        this.desenhar();
    }

    

    public Jogador getPlayer1() {
        return player1;
    }

    public Oponente getPlayer2() {
        return player2;
    }

    /**
     * Método que adiciona um elemento a lista de elementos
     * @param elemento a ser adicionado
     */
    public void adicionaElemento(Elemento elemento){
        elementos.add(elemento);
    }

    /**
     * Método pra obter a lista de elementos do jogo de truco
     * @return a lista de elementos
     */
    public List<Elemento> getElementos() {
        return elementos;
    }

        /**
     * Limpa a área de desenho não visível, pede para o elemento se desenhar e
     * depois essa área é exibida
     */
    public void desenhar() {
        // Limpa a área de desenho
        this.draw.clear(Color.DARK_GRAY);

        // Pede para o elemento se desenhar
        for (Elemento elemento : elementos) {
            elemento.desenhar(this.draw);
        }
        atualizaPlacar();

        // Com double buffering é necessário invocar o show para exibir a área de
        // desenho onde o elemento foi desenhado
        this.draw.show();
    }

    /**
     * Método que gera a carta virada
     * a qual a carta a seguir (numéricamente) será a manilha.
     */
    public Carta geraVira(){
        Naipe[] naipes = Naipe.values();
        Valor[] valores = Valor.values();

        Random random = new Random();

        // Gera valor e naipe aleatório pra carta
        int randValor = random.nextInt(valores.length);
        int randNaipe = random.nextInt(naipes.length);
        Valor valorAleatorio = valores[randValor];
        Naipe naipeAleatorio = naipes[randNaipe];

        String imagem = String.format("cartas/%c%c.png", valorAleatorio.getCodigo(), naipeAleatorio.getCodigo());
        Carta vira = new Carta(XVIRA, YVIRA, imagem, "cartas/fundoa.png", naipeAleatorio, valorAleatorio);
        return vira;
    }

    /**
     * Método que recebe a vira como parametro, além de uma carta normal, e verifica se ela é a manilha, 
     * se for, aumenta a força dela e guarda as informações da carta referente a manilha sem o aumento de força. 
     * utiliza-se como base para obter a manilha, a carta que foi virada (vira)
     * a manilha sempre terá o valor sucessor da vira.
     * @param vira é a carta que foi virada, que tem valor numérico antecessor ao da manilha
     */
    public void verificaManilha(Carta vira, Carta manilha){
        // recebo o indice da vira e atualizo pra virar o indice da manilha
        int indiceManilha = vira.getValor().getForca();
        // indice da manilha sempre é um acima do indice da vira 
        if (indiceManilha == vira.getValor().getFORCAMAXIMA()){
            indiceManilha = vira.getValor().getFORCAMINIMA();
        } else {
            indiceManilha ++;
        }
            
        // se a carta tiver força igual ao indice manilha, é uma manilha
        if (manilha.getValor().getForca() == indiceManilha){
            // então verifica o naipe e atribui a força equivalente
            switch (manilha.getNaipe().getForca()){
                case 1:
                    manilha.getValor().setForca(manilha.getNaipe().getFORCAOURO());
                    break;
                case 2:
                    manilha.getValor().setForca(manilha.getNaipe().getFORCAESPADA());
                    break;
                case 3:
                    manilha.getValor().setForca(manilha.getNaipe().getFORCACOPAS());
                    break;
                case 4:
                    manilha.getValor().setForca(manilha.getNaipe().getFORCAPAUS());
                    break;
            }
        }
    }

    /**
     * Faz a manilha voltar a ser uma carta comum
     * atribui a força da carta conforme o número (ou letra) que estiver escrito nela
     */
    public void voltaManilha(Carta c){
        if (c.getValor().getForca() > c.getValor().getFORCAMAXIMA()){
            switch(c.getValor().getCodigo()){
                case '1':
                    c.getValor().setForca(8);
                    break;
                case '2':
                    c.getValor().setForca(9);
                    break;
                case '3':
                    c.getValor().setForca(10);
                    break;
                case '4':
                    c.getValor().setForca(1);
                    break;
                case '5':
                    c.getValor().setForca(2);
                    break;
                case '6':
                    c.getValor().setForca(3);
                    break;
                case '7':
                    c.getValor().setForca(4);
                    break;
                case 'q':
                    c.getValor().setForca(5);
                    break;
                case 'j':
                    c.getValor().setForca(6);
                    break;
                case 'k':
                    c.getValor().setForca(7);
                    break;
            }
        }
    }

    /**
     * Método que mostra o placar na tela
     */
    public void atualizaPlacar(){
        draw.setPenColor(Color.BLUE);
        draw.text(this.COORDENADAXPLACAR, this.COORDENADAYPLACARPARTIDA, player1.getPontuacaoPartida() + "X" + player2.getPontuacaoPartida());
        draw.show();
        draw.setPenColor(Color.WHITE);
        draw.text(this.COORDENADAXPLACAR, this.COORDENADAYPLACARRODADA, player1.getPontuacaoRodada() + "X" + player2.getPontuacaoRodada());
        draw.show();
    }

    /**
     * Método que verifica qual das duas cartas é mais forte, a do player 1 ou a do player 2
     * @param a carta do player 1
     * @param b carta do player 2
     */
    public void verificaForca(Carta a, Carta b){
        // se a carta a for mais forte que a carta a
        if (a.getValor().getForca() > b.getValor().getForca()){
            player1.marcaPonto(this.valorAposta);
        }
        // se a carta b for mais forte que a carta a
        if (b.getValor().getForca() > a.getValor().getForca()){
            player2.marcaPonto(this.valorAposta);
        }
        // se as cartas forem iguais, então empata
        if (b.getValor().getForca() == a.getValor().getForca()){
            player1.marcaPonto(this.valorAposta);
            player2.marcaPonto(this.valorAposta);
        }

    }

    /**
     * Método pra clique com o mouse
     * @param x coordenada x do mouse
     * @param y coordenada y do mouse
     */
    @Override
    public void mousePressed(double x, double y) {
        // lista de elementos gráficos a serem removidos do truco

        // acessa as cartas do jogador
        List<Carta> cartas = new ArrayList<>(player1.getCartas());
        Carta cartaHumano = null;
        Carta cartaOponente = null;

        for (Carta carta : cartas) {
            for (Elemento elemento : elementos) {
                if (elemento != null){
                    // Clicou na carta
                    if (elemento.clicouDentro(x, y) && elemento.equals(carta)) {
                        cartaHumano = carta;
                        // jogador escolheu a carta
                        player1.escolheCarta(cartaHumano);
                        // se estiver virada (mão de ferro)
                        if (!carta.isQualImagem()){
                            // desvira
                            carta.virar(draw);
                        }
                        cartaHumano.setX(COORDENADAXDESCARTADAS);
                        cartaHumano.setY(this.YDESCARTADASHUMANO);
                        player1.getCartas().remove(cartaHumano);

                        // máquina escolhe a carta
                        cartaOponente = player2.escolheCarta();
                        cartaOponente.virar(draw);
                        cartaOponente.setX(COORDENADAXDESCARTADAS);
                        cartaOponente.setY(this.YDESCARTADASMAQUINA);
                        player2.getCartas().remove(cartaOponente);

                        // compara forças
                        verificaForca(carta, cartaOponente);

                    }
                    // Se alguém clicou no botão de truco, foi o player 1, então o player 2 deve ver se ele aceita ou não.
                    else if (elemento.clicouDentro(x, y) && elemento.equals(BOTAOTRUCO)){
                        if (player2.recebePropostaTruco()){
                            // Se a máquina aceitou a proposta de truco
                            if (valorAposta == this.VALORAPOSTAPADRAO){
                                valorAposta = 3;
                            } else { // 6 9 12
                                valorAposta += 3;
                            }
                        } else {
                            // Se a máquina recusou a proposta de truco
                            // então o player 1 vence
                            player1.setPontuacaoRodada(2);
                            terminaRodada();
                        }
                        return;
                    }
                }
                
            }
        }
        if (cartaHumano != null){
            adicionaElemento(cartaHumano);
        }
        if (cartaOponente != null){
            adicionaElemento(cartaOponente);
        }

        // Se a rodada está 2 a 0, então ela deve terminar.
        // pra isso aumentamos o 2 pra 3, pra ser considerado fim de rodada
        if (player1.getPontuacaoRodada() == this.PONTUACAOVITORIARODADA && player2.getPontuacaoRodada() == this.ZERO){
            player1.marcaPonto(this.valorAposta);
        } else if (player1.getPontuacaoRodada() == this.ZERO && player2.getPontuacaoRodada() == this.PONTUACAOVITORIARODADA){
            player2.marcaPonto(this.valorAposta);
        }

        // Se a rodada chegou a 3 pontos, então ela terminou.
        if (player1.getPontuacaoRodada() + player2.getPontuacaoRodada() >= 3){
            terminaRodada();
        }

        this.desenhar();
        
    }

    public void terminaRodada(){
        if (player1.getPontuacaoRodada() == this.PONTUACAOVITORIARODADA){
                player1.marcaPonto(this.valorAposta);
            } 
            else if (player2.getPontuacaoRodada() == this.PONTUACAOVITORIARODADA){
                player2.marcaPonto(this.valorAposta);
            }
            
            // Reinicia pontuação dos jogadores
            player1.reiniciaPontuacao();
            player2.reiniciaPontuacao();

            // Se for uma carta descartada, então mantém ela, o resto dos elementos devem ser excluídos da interface gráfica
            elementos.removeIf(elemento->elemento.getX() != COORDENADAXDESCARTADAS);
        
            player1.getCartas().clear();
            player2.getCartas().clear();

            // Caso a partida ainda não tenha terminado, reinicia a rodada.
            if (player1.getPontuacaoPartida() < PONTUACAOMAXIMAPARTIDA && player2.getPontuacaoPartida() < PONTUACAOMAXIMAPARTIDA){
                iniciaRodada();
            }
    }



    /**
     * Método que retorna o valor de aposta para o valor padrão
     * @param valorAposta é o valor padrão de cada rodada
     */
    public void reiniciaValorPadrao() {
        this.valorAposta = VALORAPOSTAPADRAO;
    }

    // --------------------------------------------
    // Override de métodos que não foram utilizados
    @Override
    public void keyReleased(int keycode) {

    }
    
    @Override
    public void mouseDragged(double x, double y) {

    }

    @Override
    public void mouseReleased(double x, double y) {

    }

    @Override
    public void mouseClicked(double x, double y) {

    }

    @Override
    public void keyTyped(char c) {

    }

    @Override
    public void keyPressed(int keycode) {

        // A classe java.awt.event.KeyEvent apresenta constantes para cada tecla. O
        // VSCode por padrão deixa o pacote java.awt.* desabilitado. Você pode habilitar
        // por meio da paleta de comandos (CTRL+SHIFT+P), buscando por Java: Help Center
        // e na aba Student clicando em Enable AWT Development
        //if (keycode == KeyEvent.VK_S) {
            // this.draw.setPenColor(Color.WHITE);
            // this.draw.text(400, 200, "Tecla S foi pressionada");
            // com double buffering é necessário invocar o método show
            // this.draw.show();

            // https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdAudio.html
        //    StdAudio.play("sons/game-over.wav");
       // }
    }
    // --------------------------------------------
}