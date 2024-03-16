package models;


import java.util.HashMap;
import java.util.TreeSet;

public class Hotel {
    private final Integer id;
    private final String name;
    private  boolean isPlusHotel = false;

    private double averageRating;
    private HashMap<String, Rating> ratingGivenUsers;
    private TreeSet<Rating> ascendingOrderRating;

    private TreeSet<Rating> descendingOrderRating;
    private TreeSet<Rating> recentOrderRating;

    private double totalRatingPoints;

    public Hotel(int id, String name, boolean isPlusHotel) {
        this.id = id;
        this.name = name;
        this.isPlusHotel = isPlusHotel;
        this.averageRating = 0;
        this.totalRatingPoints = 0;
        ratingGivenUsers = new HashMap<>();
        ascendingOrderRating = new TreeSet<>((a, b) -> {
            int ratingComparator = a.getRating().compareTo(b.getRating());
            if (ratingComparator == 0){
                return a.getGivenBy().compareTo(b.getGivenBy());
            }
            return ratingComparator;
        });
        descendingOrderRating = new TreeSet<>((a,b) ->{
            int ratingComparator = b.getRating().compareTo(a.getRating());
            if (ratingComparator == 0){
        return a.getGivenBy().compareTo(b.getGivenBy());
            }
            return ratingComparator;
        });
        recentOrderRating = new TreeSet<>((a, b)-> b.getDate().compareTo(a.getDate()));
    }

    public Hotel(int id, String name) {
        this.id = id;
        this.name = name;
        this.averageRating = 0;
        this.totalRatingPoints = 0;
        ratingGivenUsers = new HashMap<>();
        ascendingOrderRating = new TreeSet<>((a, b) -> a.getRating().compareTo(b.getRating()));
        descendingOrderRating = new TreeSet<>((a,b) -> b.getRating().compareTo(a.getRating()));
        recentOrderRating = new TreeSet<>((a, b)-> b.getDate().compareTo(a.getDate()));
    }

    public double getTotalRatingPoints() {
        return totalRatingPoints;
    }

    public void setTotalRatingPoints(double totalRatingPoints) {
        this.totalRatingPoints = totalRatingPoints;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPlusHotel() {
        return isPlusHotel;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public HashMap<String, Rating> getRatingGivenUsers() {
        return ratingGivenUsers;
    }

    public void addRatingGivenUsers(String user, Rating rating) {
        this.ratingGivenUsers.put(user, rating);
    }

    public TreeSet<Rating> getAscendingOrderRating() {
        return ascendingOrderRating;
    }

    public void setAscendingOrderRating(TreeSet<Rating> ascendingOrderRating) {
        this.ascendingOrderRating = ascendingOrderRating;
    }

    public TreeSet<Rating> getDescendingOrderRating() {
        return descendingOrderRating;
    }

    public void setDescendingOrderRating(TreeSet<Rating> descendingOrderRating) {
        this.descendingOrderRating = descendingOrderRating;
    }

    public TreeSet<Rating> getRecentOrderRating() {
        return recentOrderRating;
    }

    public void setRecentOrderRating(TreeSet<Rating> recentOrderRating) {
        this.recentOrderRating = recentOrderRating;
    }

    public void addRating(Rating rating){
        this.ascendingOrderRating.add(rating);
        this.descendingOrderRating.add(rating);
        this.recentOrderRating.add(rating);
        this.totalRatingPoints += rating.getRating();
        this.averageRating = totalRatingPoints/ratingGivenUsers.size();
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isPlusHotel=" + isPlusHotel +
                ", averageRating=" + averageRating +
                '}';
    }
}
