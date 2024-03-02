package engtelecom.poo;

/**
 * Enum naipe, representa os diversos naipes que as cartas podem conter
 * assim como a força de cada um e o código de cada um para facilitar o acesso ao recurso gráfico.
 */
public enum Naipe {
    
    // Diferentes naipes com suas respectivas forças
    Ouro(1,'o'),Copas(2,'c'),Espadas(3,'e'),Paus(4,'p');

    /**
     * Atributo que indica a força do naipe
     */
    public int forca;

    /**
     * Atributo que indica o código para acessar a imagem da carta.
     */
    public char codigo;

    /**
     * Atributo que representa a força de uma manilha caso seja do naipe de paus
     */
    private final int FORCAPAUS = 14;

    /**
     * Atributo que representa a força de uma manilha caso seja do naipe de copas
     */
    private final int FORCACOPAS = 13;

    /**
     * Atributo que representa a força de uma manilha caso seja do naipe de espada
     */
    private final int FORCAESPADA = 12;

    /**
     * Atributo que representa a força de uma manilha caso seja do naipe de ouro
     */
    private final int FORCAOURO = 11;

    /**
     * Construtor padrão
     * @param forca do Naipe
     * @param codigo do Naipe
     */
    Naipe (int forca, char codigo){
        this.forca = forca;
        this.codigo = codigo;
    }

    /**
     * Método pra obter a força do naipe
     * @return a força
     */
    public int getForca() {
        return forca;
    }

    /**
     * Método pra obter o código do naipe
     * @return o código
     */
    public char getCodigo() {
        return codigo;
    }

    /**
     * Método pra obter a força da manilha de paus
     * @return força da manilha de paus
     */
    public int getFORCAPAUS() {
        return FORCAPAUS;
    }

    /**
     * Método pra obter a força da manilha de copas
     * @return força da manilha de copas
     */
    public int getFORCACOPAS() {
        return FORCACOPAS;
    }

    /**
     * Método pra obter a força da manilha de espadas
     * @return força da manilha de espadas
     */
    public int getFORCAESPADA() {
        return FORCAESPADA;
    }

    /**
     * Método pra obter a força da manilha de ouro
     * @return força da manilha de ouro
     */
    public int getFORCAOURO() {
        return FORCAOURO;
    }
}