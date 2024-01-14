public class Notes {
    public Note[] notes;
    public Notes(){
        notes=new Note[7];
        int[] full={1,1};
        int[] half={1,0};
        String[] s={"C","D","E","F","G","A","B"};
        for(int i=0;i<7;i++){
            Note a=new Note();
            a.name=s[i];
            if(i==2 || i==6) a.interval=half;
            a.interval=full;
            notes[i]=a;
        }
    }
}
