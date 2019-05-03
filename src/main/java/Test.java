import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        try {
            Date date = dateFormat.parse("2019-01-01T01:01");
            System.out.println(date);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}
