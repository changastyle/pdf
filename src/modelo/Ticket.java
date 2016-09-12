package modelo;

public class Ticket {
    private int numeroFila;
    private int numeroButaca;

    public Ticket(int numeroFila, int numeroButaca) {
        this.numeroFila = numeroFila;
        this.numeroButaca = numeroButaca;
    }

    public int getNumeroFila() {
        return numeroFila;
    }

    public void setNumeroFila(int numeroFila) {
        this.numeroFila = numeroFila;
    }

    public int getNumeroButaca() {
        return numeroButaca;
    }

    public void setNumeroButaca(int numeroButaca) {
        this.numeroButaca = numeroButaca;
    }
    
    
}
