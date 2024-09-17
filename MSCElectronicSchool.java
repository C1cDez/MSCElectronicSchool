import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MSCElectronicSchool {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, getHomeworkIn(calendar));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = dateFormat.format(calendar.getTime());
        URI uri = new URI(String.format(args[0], date));
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(uri);
        }
    }

    public static int getHomeworkIn(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.FRIDAY) return 3;
        else if (dayOfWeek == Calendar.SATURDAY) return 2;
        else return 1;
    }
}
