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
            String m;
            if(cs==1) m="major";
            else m="minor";
            Note[] scale=f.pattern(n,14,m);
            for(int j=0;j<7;j++){
                System.out.println(scale[j].name);
            }
        }




    }
}