import java.util.Scanner;
public class Functions {
    public Note[] pattern(String s,int length){
        int[] w={2,2,1,2,2,2,1};
        Notes notes=new Notes();
        Note[] con=new Note[length];

        for(int i=0;i<length;i++){
            con[i]=new Note();
        }

        int dt=whichnote(s);

        con[0].name=s;
        int a=0;
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
    public Note[] minor(String s){
        Notes note=new Notes();
        Note m=new Note("");
        int n=whichnote(s);
        n+=3;
        if(note.notes[n%12].name=="N"){
            if(s.charAt(s.length()-1)=='#') m.name=note.notes[(n-1)%12].name+"#";
            else  m.name=note.notes[(n+1)%12].name+"b";
        } else m=note.notes[n%12];
        Note[] maj=pattern(m.name,28);
        Note[] con=new Note[14];
        for(int i=0;i<14;i++){
            boolean v=false;
            con[i]=maj[i+5];
            if((s.charAt(s.length()-1)=='#'&& con[i].name.charAt(con[i].name.length()-1)=='b') || (s.charAt(s.length()-1)=='b'&& con[i].name.charAt(con[i].name.length()-1)=='#')) v=true;
            if(v) con[i]=translator(con[i]);
        }
        con[0].name=s;
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
        return "x";
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
    public Note translator(Note s){
        Notes note=new Notes();
        int a=whichnote(s.name);
        if(s.name.charAt(s.name.length()-1)=='#'){
            a++;
            s.name=note.notes[a].name+"b";
            return s;
        }
        if(s.name.charAt(s.name.length()-1)=='b'){
            a--;
            s.name=note.notes[a].name+"#";
            return s;
        }
        return s;
    }
    public Note[] theoricly(Note[] scale){
        String[] naturals={"C","D","E","F","G","A","B"};
        int a=0;
        for(int i=0;i<7;i++){
            if(scale[0].name.charAt(0)==naturals[i].charAt(0)){
                a=i; break;
            }
        }
        Note[] con=new Note[scale.length];
        for(int i=0;i<scale.length;i++){
            con[i]=new Note();
            con[i].name=naturals[(i+a)%7];
        }
        for(int i=0;i<scale.length;i++){
            int dt=whichnote(con[i].name);
            int at=whichnote(scale[i].name);
            if(dt-at>2) at=12;
            if(dt-at<-2) dt=12;
            boolean v=true;
            while(v){
                if(dt-at>0){
                    con[i].name+="b";
                    dt--;
                }
                if(dt-at<0){
                    con[i].name+="#";
                    dt++;
                }
                if(dt-at==0) v=false;
            }
        }
        return con;
    }


}
