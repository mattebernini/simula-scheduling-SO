import so.*;

public class Prova3 {
    public static void main(String[] args) {
        
        Sistema s = new Sistema("FCFS");
        for(int i = 0; i < 80; i++)
        {
            switch (i) {
                case 0:
                    s.crea_proc("firefox ", 16);
                    s.crea_proc("netBeans", 20);
                    break;
                case 5:
                    s.crea_proc("virtualbox", 5);
                    s.crea_proc("chrome", 8);                    
                    break;
                case 20:
                    s.crea_proc("teams", 15);
                    s.crea_proc("vs-code", 3);
                    break;
                default:
                    break;
            }
            s.scorre_tempo(1);
            //System.out.println(s.toString());
        }
        System.out.println(s.stampaTerminati());
        // ***
        System.out.println("\n\n***\n\n");
        
        // ***
        Sistema s1 = new Sistema("RR", 2);
        for(int i = 0; i < 67; i++)
        {
            switch (i) {
                case 0:
                    s1.crea_proc("firefox ", 16);
                    s1.crea_proc("netBeans", 20);
                    break;
                case 5:
                    s1.crea_proc("virtualbox", 5);
                    s1.crea_proc("chrome", 8);                    
                    break;
                case 20:
                    s1.crea_proc("teams", 15);
                    s1.crea_proc("vs-code", 3);
                    break;
                default:
                    break;
            }
            s1.scorre_tempo(1);
            //System.out.println(s1.toString());
        }
        System.out.println(s1.stampaTerminati());
    }
}
