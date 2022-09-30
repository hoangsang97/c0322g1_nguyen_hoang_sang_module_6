package vn.book.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String promotionName;
    private String promotionCode;
    private int promotionPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "promotion")
    @JsonBackReference
    private List<Book> books;

    public Promotion() {
    }

    public Promotion(int id, String promotionName, String promotionCode, int promotionPrice, LocalDate startDate, LocalDate endDate, List<Book> books) {
        this.id = id;
        this.promotionName = promotionName;
        this.promotionCode = promotionCode;
        this.promotionPrice = promotionPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public int getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(int promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
