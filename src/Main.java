import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Functions f=new Functions();
        System.out.println("Enter a note");
        String n=sc.nextLine();
        System.out.println("Choose Major or minor");
        String m=sc.nextLine();
        Note[] scale=f.pattern(n,7,m);
        Note[] chord=f.basicChord(scale);
        for(int i=0;i<7;i++){
            System.out.println(scale[i].name);
        }
        System.out.println(chord[0].name+","+chord[1].name+","+chord[2].name);


    }
}