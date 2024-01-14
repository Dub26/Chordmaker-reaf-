public class Main {
    public static void main(String[] args) {
        Notes notalar=new Notes();
        for(int i=0;i<7;i++){
            System.out.println(notalar.notes[i].name +" "+notalar.notes[i].interval[0] +" "+notalar.notes[i].interval[1] );
        }

    }
}