import so.*;

public class Prova2 {
    public static void main(String[] args) {
        Sistema s = new Sistema("FCFS");
        for(int i = 0; i < 41; i++)
        {
            switch (i) {
                case 0:
                    s.crea_proc("firefox ", 16);
                    break;
                case 5:
                    s.crea_proc("virtualbox", 5);
                    s.crea_proc("netBeans", 20);
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
        for(int i = 0; i < 41; i++)
        {
            switch (i) {
                case 0:
                    s1.crea_proc("firefox ", 16);
                    break;
                case 5:
                    s1.crea_proc("virtualbox", 5);
                    s1.crea_proc("netBeans", 20);
                    break;
                default:
                    break;
            }
            s1.scorre_tempo(1);
            // System.out.println(s1.toString());
        }
        System.out.println(s1.stampaTerminati());
    }
}
