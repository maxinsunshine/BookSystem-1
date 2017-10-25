package model;

public class Books {
    private String booksid;

    private String booksname;

    private Double booksprice;

    private String bookscategory;

    private Integer booksnum;

    private String booksimgurl;

    private String description;

    private Integer booksstate;//1在库，2借出，3丢失

    public String getBooksid() {
        return booksid;
    }

    public void setBooksid(String booksid) {
        this.booksid = booksid == null ? null : booksid.trim();
    }

    public String getBooksname() {
        return booksname;
    }

    public void setBooksname(String booksname) {
        this.booksname = booksname == null ? null : booksname.trim();
    }

    public Double getBooksprice() {
        return booksprice;
    }

    public void setBooksprice(Double booksprice) {
        this.booksprice = booksprice;
    }

    public String getBookscategory() {
        return bookscategory;
    }

    public void setBookscategory(String bookscategory) {
        this.bookscategory = bookscategory == null ? null : bookscategory.trim();
    }

    public Integer getBooksnum() {
        return booksnum;
    }

    public void setBooksnum(Integer booksnum) {
        this.booksnum = booksnum;
    }

    public String getBooksimgurl() {
        return booksimgurl;
    }

    public void setBooksimgurl(String booksimgurl) {
        this.booksimgurl = booksimgurl == null ? null : booksimgurl.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getBooksstate() {
        return booksstate;
    }

    public void setBooksstate(Integer booksstate) {
        this.booksstate = booksstate;
    }
}