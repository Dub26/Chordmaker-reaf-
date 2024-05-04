import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Functions f=new Functions();
        System.out.println("""
                [1]Define chord
                [2]Create chord
                """);
        int choice1=sc.nextInt();
        if(choice1==1){
            int annen=0;
            while(annen<21){
                annen++;
                String input=f.input();
                String main=input.substring(0,1);
                Data datamaj=f.control(input,"maj");
                Data dataadd=f.control(input,"add");
                Data datamm=f.control(input,"mm");
                String min="";
                for(int i=0;i<input.length()+1;i++){
                    min=input.substring(0,i);
                }

                Data datam=f.control(min,"m");
                if(datamaj.v) datam.v=false;
                if(datamm.v) datam.v=true;
                try{
                    if(input.charAt(1)=='#' || input.charAt(1)=='b') main=input.substring(0,2);
                }catch (Exception e){
                    System.out.println();
                }
                Note[] scale=f.pattern(main,14);
                if(datam.v) scale=f.minor(main);
                scale=f.theoricly(scale);
                Note[] chord=f.basicChord(scale);
                if(datamaj.v){
                    Note[] majscale=f.pattern(main,14);
                    majscale=f.theoricly(majscale);
                    chord=f.add(majscale,chord,f.getnumber(input,datamaj.n));
                    if(f.getnumber(input,datamaj.n)>7) chord=f.add(majscale,chord,7);
                }
                if(dataadd.v){
                    chord=f.add(scale,chord,f.getnumber(input,dataadd.n));
                }
                for(Note nigga:scale){
                    System.out.println(nigga.name);
                }
                for(Note n:chord){
                    System.out.print(n.name+" ");
                }
                System.out.println();
            }



        }
        if(choice1==2){
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
                Note[] tchord=f.basicChord(teo);

                for(int j=0;j<8;j++){
                    System.out.println(scale[j].name);
                }

                System.out.print(chord[0].name+","+chord[1].name+","+chord[2].name);
                System.out.println();
                System.out.println("""
                    Add note?
                    [1]Yes
                    [2]No""");
                int answer=sc.nextInt();
                if(answer==1){
                    while(true){
                        int a=sc.nextInt();
                        chord=f.add(scale,chord,a);
                        tchord=f.add(teo,tchord,a);
                        for (Note note : chord) {
                            System.out.print(note.name + " ");
                        }
                        System.out.println("Continue?\n"+"[1]Yes\n"+"[2]No");
                        a=sc.nextInt();
                        if(a==2) break;

                    }
                }

                System.out.println("""
                    Do you want to see theory version?
                    [1]Yes
                    [2]No""");
                int answer2=sc.nextInt();
                if(answer2==1){
                    for(int j=0;j<8;j++){
                        System.out.println(teo[j].name+" ");
                    }
                    System.out.println();
                    for(Note note:tchord){
                        System.out.print(note.name+" ");
                    }
                    System.out.println();
                }
                System.out.println();

            }
        }





    }
}