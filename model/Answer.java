package model;

public class Answer {

    private int content;
    private String contentTxt;
    private boolean isCorrect=false;
    //private int idx; //idx=1; 1=A, 2=B, 3=C, 4=D
    private String idx; //A, B, C, D

    public Answer(int content)
    {
        setContent(content);
        this.contentTxt=Integer.toString(content);
    }

    public Answer(int content, boolean isCorrect)
    {
        setContent(content);
        this.contentTxt=Integer.toString(content);
        setIsCorrect(isCorrect);
    }

    public void setIdx(String idx) {
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

    public String getContentTxt() {
        return contentTxt;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public String getIdx() {
        return idx;
    }
}
