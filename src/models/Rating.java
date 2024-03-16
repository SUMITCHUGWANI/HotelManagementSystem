package models;

import java.util.Date;


public class Rating {
    private Integer rating;
    private String review;

    private String givenBy;

    private int hotelId;
    private Date date;

    @Override
public String toString() {
        return "Rating{" +
                "rating=" + rating +
                ", review='" + review + '\'' +
                ", givenBy='" + givenBy + '\'' +
                ", hotelId=" + hotelId +
                ", date=" + date +
                '}';
    }

    public Rating(int rating, String review, String givenBy, Integer hotelId) {
        this.rating = rating;
        this.review = review;
        this.givenBy = givenBy;
        this.hotelId = hotelId;
        this.date = new Date();
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(String givenBy) {
        this.givenBy = givenBy;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
