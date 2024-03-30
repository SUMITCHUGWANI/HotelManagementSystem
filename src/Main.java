import Repo.HotelRepo;
import Repo.RatingRepo;
import models.*;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
//

        HotelRepo hotelRepo = new HotelRepo();
        RatingRepo ratingRepo = new RatingRepo(hotelRepo);

        TreeSet<Hotel> allHotelDescRating = new TreeSet<>((a, b)->{
            if (a.isPlusHotel() && !b.isPlusHotel()) {
                return -1;
            } else if (!a.isPlusHotel() && b.isPlusHotel()){
                return 1;
            }else{
                return b.getAverageRating().compareTo(a.getAverageRating());
            }
        });
//
//        Hotel hotel1 = new Hotel(1, "A2B");
//
//        Hotel hotel2 = new Hotel(2, "C2D", true);
//
        Hotel hotel3 = new Hotel(78913, "sample", true);
//
//        hotelRepo.addHotel( hotel1);
//
//        hotelRepo.addHotel( hotel2);
        hotelRepo.addHotel(hotel3);
//
//        User user1 =  new User(1, "SUMIT");
//
//        User user2 = new User(2, "ANAND");
//
//        User user3 = new User(3, "HRUSHI");
//
//        User user4 = new User(4, "NITIN");
//        User user5 = new User(5, "POOJA");
//        User user6 = new User(6, "ADITYA");
//
//        ratingRepo.addRating(3, user2, 78913, "Good Hotel");
//
//        List<Rating>ratingList =  ratingRepo.getRating(78913, Order.DESC, Filter.MEDIUM_RANGE);
//        System.out.println(ratingList);
//
//        hotelRepo.describeHotel(78913);
//        hotelRepo.describeHotel(2);
//
//        List<Hotel> hotelList = hotelRepo.listHotels();
//        System.out.println(hotelList);
//
//        ratingRepo.addRating(5, user1, 78913, "Excellent Hotel");
//
//        ratingRepo.addRating(4, user4, 78913, "Tasty food!");
//
//        ratingList =  ratingRepo.getRating(78913, Order.ASC, Filter.HIGH_RANGE);
//        System.out.println(ratingList);
//
//        hotelList = hotelRepo.listHotels();
//        System.out.println(hotelList);
//        ratingRepo.addRating(1, user1, 78913, "bad food today :(");
//        ratingRepo.addRating(1, user5, 78913, "drinks were not good:(");
//
//        hotelList = hotelRepo.listHotels();
//        System.out.println(hotelList);
//
//        ratingList =  ratingRepo.getRating(78913, Order.DESC, Filter.LOWER_RANGE);
//        System.out.println(ratingList);
//
//
//
//        ratingRepo.addRating(5, user3, 78913, "awesome food :)");
//
//        ratingRepo.addRating(3, user6, 78913, "cost effective hotel");
//
//        ratingList =  ratingRepo.getRating(78913, Order.DESC, Filter.MEDIUM_RANGE);
//        System.out.println(ratingList);
//
//        ratingList =  ratingRepo.getRating(78913, Order.ASC, Filter.MEDIUM_RANGE);
//        System.out.println(ratingList);

        Scanner sc = new Scanner(System.in);

        while (true){
            String command = sc.nextLine();

            String[] commandList = command.split(" ");
            System.out.println(Arrays.toString(commandList));
            if (Objects.equals(commandList[0], "ADD_RATING")){
                if (commandList.length < 4){
                    throw new Exception("Invalid Command, missing parameters");
                }else{
                    int rating = Integer.parseInt(commandList[1]);
                    String userName = commandList[2];
                    int hotelId = Integer.parseInt(commandList[3]);
                    User user = new User(5, userName);
                    if (commandList.length > 4){
                        StringBuilder review = new StringBuilder();
                        for (int  i = 4; i< commandList.length; i++){
                            review.append(commandList[i]);
                        }

                        ratingRepo.addRating(rating, user, hotelId, review.toString());

                    }else{
                        ratingRepo.addRating(rating, user, hotelId);
                    }
                }
            }
        }


    }
}