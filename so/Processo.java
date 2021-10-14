package so;

public class Processo{
    private int id;
    private String info;
    private int precedenza;
    private String stato;
    private double attesa;
    private double inizio;
    public  double fine;
    private double CPU_burst;
    private double CPU_burst_iniziale;
    private static int numProc = 1;

    public Processo(String i, int b, double t)
    {
        id = numProc++;
        attesa = 0;
        info = i;
        precedenza = 0;
        CPU_burst = b;
        CPU_burst_iniziale = b;
        inizio = t;
    }
    public void esegui()
    {
        stato = "esecuzione";
    }
    public void pronto()
    {
        stato = "pronto";
    }
    public String getStato()
    {
        return stato;
    }
    public double getInizio()
    {
        return inizio;
    }
    public void burst()
    {
        CPU_burst--;
        if(CPU_burst==0)
            stato = "terminato";
    }
    public void invecchia()
    {
        attesa++;
    }
    public double getAttesa()
    {
        return attesa;
    }
    public String toString()
    {
        return id + "\t" + info + "\t\t" + precedenza +
                "\t" + stato + "\t\t" + attesa;
    }
    public String usage()
    {
        return id + "\t" + info + "\t\t" + precedenza +
                "\t" + CPU_burst_iniziale + "\t" + attesa +
                "\t" + (fine-inizio);
    }
}