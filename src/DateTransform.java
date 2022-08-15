import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateTransform {

    public static List<String> transformDateFormat(List<String> dates) {
        List<String> newDates = new ArrayList<String>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        for (int i = 0; i<dates.size(); i++){
            String date = dates.get(i);
            if (date.matches("\\d{2}-\\d{2}-\\d{4}")) {
                DateTimeFormatter oldFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                newDates.add(LocalDate.parse(date, oldFormatter).format(formatter));
            } else if (date.matches("\\d{2}/\\d{2}/\\d{4}")) {
                DateTimeFormatter oldFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                newDates.add(LocalDate.parse(date, oldFormatter).format(formatter));
            } else if (date.matches("\\d{4}/\\d{2}/\\d{2}")) {
                DateTimeFormatter oldFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                newDates.add(LocalDate.parse(date, oldFormatter).format(formatter));
            }
        }
        return newDates;
    }

    public static void main(String[] args) {
        List<String> dates = transformDateFormat(Arrays.asList("2010/02/20", "19/12/2016", "11-18-2012", "20130720"));
        for(String date : dates) {
            System.out.println(date);
        }
    }
}