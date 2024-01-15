public class Main {
    public static void main(String[] args) {
        Functions f=new Functions();
        Note[] gamC=new Note[20];
        gamC=f.pattern("B", gamC.length,"minor");
        for(int i=0;i< gamC.length;i++){
            System.out.println(gamC[i].name);
        }

    }
}