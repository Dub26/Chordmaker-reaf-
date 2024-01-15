import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Functions f=new Functions();
        System.out.println("Enter a chord:");
        String input=sc.nextLine();
        String[] pieces=input.split(" ");
        Note[] gamC=new Note[7];
        gamC=f.pattern(pieces[0], gamC.length,pieces[1]);
        for(int i=0;i< gamC.length;i++){
            System.out.println(gamC[i].name);
        }
        Note[] A=f.basicChord(pieces[0],pieces[1]);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i].name+",");
        }

    }
}