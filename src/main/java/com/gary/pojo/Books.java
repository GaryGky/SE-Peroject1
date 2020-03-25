package com.gary.pojo;

import lombok.Data;

@Data

public class Books {
    private int book_id;
    private String bkName;
    private int bkCount;
    private String description;
    
    public Books() {
    }
    
    public Books(int book_id, String bkName, int bkCount, String description) {
        this.book_id = book_id;
        this.bkName = bkName;
        this.bkCount = bkCount;
        this.description = description;
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
}
