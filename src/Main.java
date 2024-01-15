public class Main {
    public static void main(String[] args) {
        Functions f=new Functions();
        Note[] gamC=new Note[7];
        gamC=f.major("A", gamC.length);
        for(int i=0;i< gamC.length;i++){
            System.out.println(gamC[i].name);
        }

    }
}