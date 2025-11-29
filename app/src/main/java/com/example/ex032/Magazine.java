package com.example.ex032;

public class Magazine extends LibraryItem implements Searchable, Displayable {
    private int issueNumber;
    private String editorName;

    public Magazine(int yearPublished, String title, int issueNumber, String editorName) {
        super(yearPublished, title);
        this.issueNumber = issueNumber;
        this.editorName = editorName;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }


    @Override
    public void displayFullDetails() {
        System.out.println(toString());
    }

    @Override
    public double calculateLateFee(int daysPastDue) {
        return daysPastDue * 2;
    }

    @Override
    public boolean matches(String query) {
        if(this.getTitle().contains(query) || this.editorName.contains(query))
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " Magazine{" +
                "issueNumber=" + issueNumber +
                ", editorName='" + editorName + '\'' +
                '}';
    }
}
