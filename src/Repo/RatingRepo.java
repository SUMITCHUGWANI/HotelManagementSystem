package Repo;

import models.*;

import java.util.*;

public class RatingRepo {

    HashMap<String, Rating> userRatingHashMap;

    HashMap<Integer, Rating> hotelRatingHashMap;

    HotelRepo hotelRepo;

    public RatingRepo(HotelRepo hotelRepo)  {
        this.userRatingHashMap = new HashMap<>();
        this.hotelRatingHashMap = new HashMap<>();
        this.hotelRepo = hotelRepo;
    }

    public void addRating(Integer ratingValue, User user, Integer hotelId, String review) throws Exception {
        Rating rating = new Rating(ratingValue, review, user.getName(), hotelId);

        Hotel hotel = hotelRepo.getHotel(hotelId);
        hotelRepo.removeHotel(hotelId);
        if (hotel.getRatingGivenUsers().containsKey(user.getName().toLowerCase())){
            Rating oldRating = hotel.getRatingGivenUsers().get(user.getName().toLowerCase());
            hotel.getAscendingOrderRating().remove(oldRating);
            hotel.getDescendingOrderRating().remove(oldRating);
            hotel.getRecentOrderRating().remove(oldRating);
            hotel.setTotalRatingPoints(hotel.getTotalRatingPoints() - oldRating.getRating());

        }
        hotel.addRatingGivenUsers(user.getName().toLowerCase(), rating);
        hotel.addRating(rating);
        hotelRepo.addHotel(hotel);





        System.out.println("Rating and Review added Successfully!!");
//
//        userRatingHashMap.put(user.getName(), rating);
//        user.incrementRating();
//        hotelRatingHashMap.put(hotelId, rating);
//        Hotel hotel = hotelRepo.getHotel(hotelId);
//        hotel.addRatings(rating);
//
//        Double prevRating = hotel.getAvgRating();
//
//        Double newAvgRating = (prevRating + ratingValue)/(hotel.getRatings().size());
//        hotel.setAvgRating(newAvgRating);
//
//        System.out.println("Rating and Review added Successfully!!");

    }

    public void addRating(Integer ratingValue, User user, Integer hotelId) throws Exception {
//        Rating rating = new Rating(user.getName(), ratingValue, hotelId);
//        userRatingHashMap.put(user.getName(), rating);
//        user.incrementRating();
//        hotelRatingHashMap.put(hotelId, rating);
//
//        Hotel hotel = hotelRepo.getHotel(hotelId);
//
//        hotel.setAvgRating((hotel.getAvgRating()+ratingValue)/(hotel.getRatings().size() +1));
//        System.out.println("avg rating "+ hotel.getAvgRating());
//        System.out.println("Rating and Review added Successfully!!");
    }




    public List<Rating> getRating(Integer hotelId, Order order, Filter filter) throws Exception {

        TreeSet<Rating> ratingTreeSet = null;

        Hotel hotel = hotelRepo.getHotel(hotelId);

        if (order.equals(Order.ASC)){
            ratingTreeSet = hotel.getAscendingOrderRating();
        }else if (order.equals(Order.DESC)){
            ratingTreeSet = hotel.getDescendingOrderRating();
        } else if (order.equals(Order.RECENT)){
            ratingTreeSet = hotel.getRecentOrderRating();
        }

        List<Rating> resultantRatings = new ArrayList<>();

        for (Rating rating : Objects.requireNonNull(ratingTreeSet)){
            if (Filter.LOWER_RANGE.equals(filter)){
                if (rating.getRating() >= 1 && rating.getRating() < 3){
                    resultantRatings.add(rating);
                }
            }else if (Filter.MEDIUM_RANGE.equals(filter)){
                if (rating.getRating() >= 3 && rating.getRating() < 5){
                    resultantRatings.add(rating);
                }
            }else if (Filter.HIGH_RANGE.equals(filter)){
                if (rating.getRating() == 5){
                    resultantRatings.add(rating);
                }
            }
        }





//        Hotel hotel =  hotelRepo.getHotel(hotelId);
//
//        List<Rating> ratingList = hotel.getRatings();
//        List<Rating> orderdList = new ArrayList<>();
//        List<Rating> result = new ArrayList<>();
//        if (order.equals(Order.ASC)){
//            orderdList = ratingList.stream().sorted(Comparator.comparing(Rating::getRating).thenComparing(Rating::getDate)).collect(Collectors.toList());
//        } else if (order.equals(Order.DESC)){
//            orderdList = ratingList.stream().sorted(Comparator.comparing(Rating::getRating).reversed().thenComparing(Rating::getDate)).collect(Collectors.toList());
//        }
//
//        for (Rating rating: orderdList){
//            if (rating.getRating() == ratingValue){
//                result.add(rating);
//            }
//        }
        return resultantRatings;
    }

}
