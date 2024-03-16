package Repo;

import models.Hotel;

import java.util.*;

public class HotelRepo {

    HashMap<Integer, Hotel> hotelHashMap = new HashMap<>();

    List<Hotel> hotelList = new ArrayList<>();

    TreeSet<Hotel> plusHotelDescRating = new TreeSet<>((a,b) -> {
        int ratingComparator = b.getAverageRating().compareTo(a.getAverageRating());
        if (ratingComparator == 0){
            return a.getId().compareTo(b.getId());
        }
        return ratingComparator;
    });

    TreeSet<Hotel> nonPlusHotelDesRating = new TreeSet<>((a,b) -> {
        int ratingComparator = b.getAverageRating().compareTo(a.getAverageRating());
        if (ratingComparator == 0){
            return a.getId().compareTo(b.getId());
        }
        return ratingComparator;
    });



    public void addPlusHotel(Integer hotelId, Hotel hotel){
        hotelHashMap.put(hotelId, hotel);
        hotelList.add(hotel);
        plusHotelDescRating.add(hotel);
    }

    public  Hotel getHotel(Integer hotelId) throws Exception {
        if (hotelHashMap.containsKey(hotelId)){
            return hotelHashMap.get(hotelId);
        }else{
            throw new Exception("NO hotel with this hotelID is present !!");
        }
    }

    public void removeHotel(Integer hotelId) throws  Exception {
        if (!hotelHashMap.containsKey(hotelId)){
            throw new Exception("NO hotel with this hotelID is present !!");
        }
        Hotel hotel = hotelHashMap.get(hotelId);
        hotelHashMap.remove(hotelId);
        if (hotel.isPlusHotel()){
            plusHotelDescRating.remove(hotel);
        }else{
            nonPlusHotelDesRating.remove(hotel);
        }
    }

    public void addHotel(Hotel hotel){
        hotelHashMap.put(hotel.getId(), hotel);
        if (hotel.isPlusHotel()){
            plusHotelDescRating.add(hotel);
        }else{
            nonPlusHotelDesRating.add(hotel);
        }
//        System.out.println("hotelid "+ hotel.getId());
//        System.out.println(plusHotelDescRating);
//        System.out.println(nonPlusHotelDesRating);
    }
    public void describeHotel(Integer hotelId) throws Exception {
        if (hotelHashMap.containsKey(hotelId)){
            Hotel hotel = hotelHashMap.get(hotelId);
            System.out.println(hotel.toString());
        }else{
            throw new Exception("NO hotel with this hotelID is present !!");
        }

    }

    public List<Hotel> getAllHotelList(){
        return hotelList;
    }

    public List<Hotel> listHotels(){

        List<Hotel> hotelList = new ArrayList<>();

        hotelList.addAll(plusHotelDescRating);
        hotelList.addAll(nonPlusHotelDesRating);

        return hotelList;

//        List<Hotel> hotelList = getAllHotelList();
//        System.out.println("printing hotelList "+ hotelList);
//
//        return hotelList.stream().sorted(Comparator.comparing(Hotel::getAvgRating).reversed().thenComparing(Hotel::getLabel)).collect(Collectors.toList());

    }

}
