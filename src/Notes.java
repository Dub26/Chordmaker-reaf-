public class Notes {
    public Note[] notes;
    public Notes(){
        Note[] con=new Note[12];
        for(int i=0;i<con.length;i++){
            con[i]=new Note();
        }
        con[0].name="C";
        con[1].name="N";
        con[2].name="D";
        con[3].name="N";
        con[4].name="E";
        con[5].name="F";
        con[6].name="N";
        con[7].name="G";
        con[8].name="N";
        con[9].name="A";
        con[10].name="N";
        con[11].name="B";
        notes=con;
    }
}

