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
        for(int i=0;i<length-1;i++){
            a+=w[i%7];
            if(notes.notes[(dt+a)%12].name.equalsIgnoreCase("N")){
                if(x.trim().equalsIgnoreCase("minor")) {
                    s=notes.notes[(dt+3)%12].name;
                }
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
            if(f.equalsIgnoreCase(flat[i])) return notes.notes[whn+1].name+"b";
        }

        for(int i=0;i<aunt.length;i++) {
            if (f.equalsIgnoreCase(aunt[i])) return notes.notes[whn - 1].name + "#";
        }
        return "a";
    }
    public int whichnote(String s){
        Notes notes=new Notes();
        String af="#b";
        int dt=0;
        if(s.length()>1) {
            if(s.charAt(1)==af.charAt(0)) dt++;
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

}