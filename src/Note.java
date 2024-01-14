public class Note {
    public String name;
    public int[] interval;
    public Note(String name,int[] inter){
        this.name=name;
        interval=inter;
    }
    public Note(){
        name="N";
        interval=new int[]{0,0};
    }
}
