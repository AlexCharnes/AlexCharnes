package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;

    private int possibleMarks;

    private String submitterName;



    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        String letterGrade;
        double score = (double) earnedMarks / possibleMarks;
        if (score >= .9) {
            return "A";
        } else if (score >= .8) {
            return "B";
        } else if (score >= .7) {
            return "C";
        } else if (score >= .6) {
            return "D";
        } else {
            return "F";
        }
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public HomeworkAssignment(int possibleMarks, String submitterName){
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

}
