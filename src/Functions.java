import java.util.Scanner;
public class Functions {
    public Note[] pattern(String s,int length,String x){
        int[] w={};
        int[] wa={2,2,1,2,2,2,1};
        int[] wb={2,1,2,2,1,2,2};
        if(x.trim().equalsIgnoreCase("major"))  w=wa;
        if(x.trim().equalsIgnoreCase("minor"))  w=wb;
        Notes notes=new Notes();
        Note[] con=new Note[length];

        for(int i=0;i<length;i++){
            con[i]=new Note();
        }


        int dt=whichnote(s);

        con[0].name=s;
        int a=0;
        if(x.trim().equalsIgnoreCase("minor")) {
            String cc=notes.notes[(dt+3)%12].name;
            if(cc !="N" && cc.charAt(cc.length()-1)!='#' && cc.charAt(cc.length()-1)!='b' ) s=notes.notes[(dt+3)%12].name;
            else s=flatoraunt(s,(dt+3)%12);
        }

        for(int i=0;i<length-1;i++){
            a+=w[i%7];

            if(notes.notes[(dt+a)%12].name.equalsIgnoreCase("N")){
                con[i+1].name=flatoraunt(s,(dt+a)%12);
                continue;
            }

            con[i+1].name=notes.notes[(dt+a)%12].name;
        }

        return con;
    }
    public String flatoraunt(String f,int whn){
        Notes notes=new Notes();
        String[] aunt={"g","d","a","e","b","F#","C#"};
        String[] flat={"f","bb","eb","ab","db","gb","cb"};
        for(int i=0;i< flat.length;i++){
            if(f.equalsIgnoreCase(flat[i])) return notes.notes[(whn+1)%12].name+"b";
        }
        for(int i=0;i<aunt.length;i++) {
            if (f.equalsIgnoreCase(aunt[i])) return notes.notes[(whn%12)-1].name + "#";
        }
        if(f.charAt(f.length()-1)=='#') return notes.notes[whn - 1].name + "#";
        if(f.charAt(f.length()-1)=='b') return notes.notes[whn+1].name+"b";
        return "a";
    }
    public int whichnote(String s){
        Notes notes=new Notes();

        int dt=0;
        if(s.length()>1) {
            if(s.charAt(1)=='#') dt++;
            else dt--;
            String g=s.substring(0,1);
            for(int i=0;i<12;i++){
                if(g.equalsIgnoreCase(notes.notes[i].name)){
                    break;
                }
                dt++;
            }

        } else{
            for(int i=0;i<12;i++){
                if(s.equalsIgnoreCase(notes.notes[i].name)) break;
                dt++;
            }
        }
        return dt;
    }
    public Note[] basicChord( Note[] scale){
        int[] w={1,3,5};
        Note[] chordnotes=new Note[3];
        for(int i=0;i<3;i++){
            chordnotes[i]=scale[w[i]-1];
        }
        return chordnotes;
    }
    public Note[] add(Note[] scale,Note[] chord,int which){
        Note desired=scale[which-1];
        Note[] nch=new Note[chord.length+1];
        for(int i=0;i<chord.length;i++){
            nch[i]=chord[i];
        }
        nch[nch.length-1]=desired;
        return nch;
    }
    public Note[] combine(Note[] a,Note[] b){
        Note[] last=new Note[a.length+b.length];
        for(int i=0;i<a.length;i++){
            last[i]=a[i];
        }
        for(int i=0;i<b.length;i++){
            last[a.length+i]=b[i];
        }
        return last;
    }
    public String input(){
        Scanner sc=new Scanner(System.in);
        String n=sc.nextLine();
        return n;
    }


}