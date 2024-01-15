public class Functions {
    public Note[] major(String s,int length){
        int[] w={2,2,1,2,2,2,1};
        Notes notes=new Notes();
        Note[] con=new Note[length];
        for(int i=0;i<length;i++){
            con[i]=new Note();
        }
        int dt=0;
        for(int i=0;i<12;i++){
            if(s.equalsIgnoreCase(notes.notes[i].name)) break;
            dt++;
        }
        con[0].name=notes.notes[dt].name;
        int a=0;
        for(int i=0;i<length-1;i++){
            a+=w[i];
            if(notes.notes[(dt+a)%12].name.equalsIgnoreCase("N")){
                con[i+1].name=deterw(notes.notes[dt].name,(dt+a)%12);
                continue;
            }
            con[i+1].name=notes.notes[(dt+a)%12].name;
        }
        return con;
    }
    public String deterw(String f,int whn){
        Notes notes=new Notes();
        String[] aunt={"g","d","a","e","b"};
        String[] flat={"f"};
        if(f.equalsIgnoreCase(flat[0])) return notes.notes[whn+1].name+"b";

        for(int i=0;i<aunt.length;i++) {
            if (f.equalsIgnoreCase(aunt[i])) return notes.notes[whn - 1].name + "#";
        }
        return "a";
    }

}
