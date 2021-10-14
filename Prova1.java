import so.*;

public class Prova1 {
    public static void main(String[] args) {
        Sistema s = new Sistema("FCFS");
        for(int i = 0; i < 28; i++)
        {
            switch (i) {
                case 0:
                    s.crea_proc("chrome", 8);
                    break;
                case 5:
                    s.crea_proc("teams", 15);
                    s.crea_proc("vs-code", 3);
                    break;
                default:
                    break;
            }
            s.scorre_tempo(1);
            System.out.println(s.toString());
        }
        System.out.println(s.stampaTerminati());
    }
}
