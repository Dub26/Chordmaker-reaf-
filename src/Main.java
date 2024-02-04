import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Functions f=new Functions();
        for(int i=0;i<20;i++){
            System.out.println("Enter a note");
            String n=f.input();
            System.out.println("[1]major\n"+"[2]minor");
            int cs=sc.nextInt();
            Note[] scale = new Note[0];
            if(cs==1) scale=f.pattern(n,14);
            if(cs==2) scale=f.minor(n);
            Note[] chord=f.basicChord(scale);
            Note[] teo=f.theoricly(scale);

            for(int j=0;j<8;j++){
                System.out.println(scale[j].name);
            }

            System.out.print(chord[0].name+","+chord[1].name+","+chord[2].name);

            System.out.println();
            for(int j=0;j<8;j++){
                System.out.println(teo[j].name);
            }

        }




    }
}