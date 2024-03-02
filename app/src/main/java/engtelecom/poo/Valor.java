package engtelecom.poo;

/**
 * Enum valor, representa os diversos valores que as cartas podem conter
 * assim como a força de cada um e o código de cada um para facilitar o acesso ao recurso gráfico.
 */
public enum Valor {

    // Diferentes valores com suas respectivas forças
    TRES(10,'3'),DOIS(9,'2'),A(8,'1'),K(7,'k'),J(6,'j'),Q(5,'q'),SETE(4,'7'),SEIS(3,'6'),CINCO(2,'5'),QUATRO(1,'4');
    
    /**
     * Atributo que indica a força do valor
     */
    private int forca;

    /**
     * Atributo que indica o código para acessar a imagem da carta.
     */
    private char codigo;

    /**
     * Atributo que indica a força máxima que uma carta que não é manilha pode ter
     */
    private final int FORCAMAXIMA = 10;

    /**
     * Atributo que indica a força mínima que uma carta pode ter
     */
    private final int FORCAMINIMA = 1;
    
    /**
     * Obtém a força máxima que uma carta pode ter
     * @return a força máxima
     */
    public int getFORCAMAXIMA() {
        return FORCAMAXIMA;
    }
    
    /**
     * Obtém a força mínima que uma carta pode ter
     * @return a força mínima
     */
    public int getFORCAMINIMA() {
        return FORCAMINIMA;
    }

    /**
     * Construtor padrão
     * @param forca do valor da carta
     * @param codigo código da carta
     */
    Valor(int forca, char codigo){
        this.forca = forca;
        this.codigo = codigo;
    }

    /**
     * Método pra obter a força da carta que tem tal valor
     * @return a força
     */
    public int getForca() {
        return forca;
    }

    /**
     * Método pra obter o código da carta
     * @return o código
     */
    public char getCodigo() {
        return codigo;
    }

    /**
     * Altera a força do valor da carta
     * @param força é a nova força
     */
    public void setForca(int forca) {
        this.forca = forca;
    }
    
}