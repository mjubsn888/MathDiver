package model;

public class Answer {

    private int content;
    private boolean isCorrect=false;
    private int idx; //idx=1; 1=A; 2=B
    private String id; //id=A; idx is the number of A,B,C,D


    public Answer(){

    }

    public Answer(int content, boolean isCorrect)
    {
        setContent(content);
        setIsCorrect(isCorrect);
    }

    public String idxToId(int idx){
        String id;
        switch (idx){
            case 1: id="A";
            case 2: id="B";
            case 3: id="C";
            case 4: id="D";
            default: id="X";
        }
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setIdxAndId(int idx) {
        this.idx = idx;
        setId(idxToId(idx));
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect=isCorrect;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public int getContent() {
        return content;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public int getIdx() {
        return idx;
    }

    public String getId() {
        return id;
    }
}
