package com.gary.pojo;

import lombok.Data;

@Data
public class BorrowInfo {
    private int stu_id;
    private int book_id;
    private String bkName;
    private int bkCount;
    private String description;
    private long fund;
    private String borrowTime;
    
    public BorrowInfo() {
    
    }
    
    public BorrowInfo(Books books, long fund) {
        this.book_id = books.getBook_id();
        this.bkName = books.getBkName();
        this.bkCount = books.getBkCount();
        this.description = books.getDescription();
        this.fund = fund;
    }
    
    public int getStu_id() {
        return stu_id;
    }
    
    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }
    
    public int getBook_id() {
        return book_id;
    }
    
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    
    public String getBkName() {
        return bkName;
    }
    
    public void setBkName(String bkName) {
        this.bkName = bkName;
    }
    
    public int getBkCount() {
        return bkCount;
    }
    
    public void setBkCount(int bkCount) {
        this.bkCount = bkCount;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public long getFund() {
        return fund;
    }
    
    public void setFund(long fund) {
        this.fund = fund;
    }
    
    public String getBorrowTime() {
        return borrowTime;
    }
    
    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }
}
