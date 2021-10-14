package so;
import java.util.*; 

public class Sistema {
    private LinkedList<Processo> lista_pronti;
    private double tempo;
    private double overhead;
    private ArrayList<Processo> terminati;

    private final double t_cambio_contesto = 0.1;
    private String scheduling;
    private double quanto;
    private double t_quanto;

    public Sistema(String s)
    {
        scheduling = s;
        lista_pronti = new LinkedList<Processo>();
        tempo = 0;
        overhead = 0;
        terminati = new ArrayList<Processo>();
    }
    public Sistema(String s, double q)
    {
        scheduling = s;
        lista_pronti = new LinkedList<Processo>();
        tempo = 0;
        overhead = 0;
        terminati = new ArrayList<Processo>();
        quanto = q;
        t_quanto = 0;
    }
    public void scorre_tempo(int t)
    {
        if(lista_pronti.size() == 0)
        {
            return;
        }
        
        switch (scheduling) {
            case "FCFS":
                for(int i = 0; i<t; i++)
                {
                    first_come_first_served();
                }
                break;
            case "RR":
                for(int i = 0; i<t; i++)
                    {
                        round_robin();
                    }
                    break;
        }
    }
    public void inserimento_lista(Processo p)
    {
        if(lista_pronti.size()==0)
        {
            lista_pronti.add(p);
            p.esegui();
            return;
        }
        switch (scheduling) {
            case "FCFS":
                lista_pronti.add(p);
                p.pronto();
                break;
            case "RR":
                lista_pronti.addLast(p);
                p.pronto();
                break;
        }
    }
    public void crea_proc(String i, int b)
    {
        Processo p = new Processo(i, b, tempo);
        inserimento_lista(p);
    } 
    // ALGORITMI DI SCHEDULING
    public void first_come_first_served()
    {
        Processo in_esecuzione = lista_pronti.get(0);
        tempo++;
        in_esecuzione.burst();
        for (int j = 1; j < lista_pronti.size(); j++) 
            lista_pronti.get(j).invecchia();
        if(in_esecuzione.getStato()=="terminato")
        {
            in_esecuzione.fine = tempo;
            terminati.add(in_esecuzione);
            lista_pronti.removeFirst();
            if(lista_pronti.size()==0)
            {
                return;
            }
            in_esecuzione = lista_pronti.get(0);
            in_esecuzione.esegui();
            overhead += t_cambio_contesto;
        }
    }
    public void round_robin()
    {
        first_come_first_served();
        t_quanto++;
        if(t_quanto==quanto)
        {
            Processo in_esecuzione = lista_pronti.get(0);
            in_esecuzione.pronto();
            lista_pronti.removeFirst();
            lista_pronti.addLast(in_esecuzione);
            in_esecuzione = lista_pronti.get(0);
            in_esecuzione.esegui();
            overhead += t_cambio_contesto;
            t_quanto = 0;
        }

    }

    // utilita
    public double attesa_media() 
    {
        double x = 0;
        for (int i = 0; i < terminati.size(); i++) {
            x += terminati.get(i).getAttesa();
        } 
        return x/terminati.size();
    }
    public double vita_media()
    {
        double x = 0;
        for (int i = 0; i < terminati.size(); i++) {
            x += terminati.get(i).fine - terminati.get(i).getInizio();
        } 
        return x/terminati.size();
    }
    // stampa
    public String toString()
    {
        String r = "";
        for (int i = 0; i < lista_pronti.size(); i++) {
            r += lista_pronti.get(i).toString() + "\n";
        } 
        r += "t = " + tempo + "********************************* " + "\n\n";
        return r;     
    }  
    public String stampaTerminati()
    {
        String r = "id\tinfo\t\tprecedenza\tburst\tattesa\tvita\n";
        for (int i = 0; i < terminati.size(); i++) {
            r += terminati.get(i).usage() + "\n";
        } 
        r += "tempo = " + (tempo+overhead) + "\n";
        r += "attesa media = " + attesa_media() + "\n";
        r += "vita media = " + vita_media() + "\n";
        r += "overhead = " + overhead + "\n";
        return r;  
    }
}
