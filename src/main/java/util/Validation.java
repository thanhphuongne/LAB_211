
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation
{
    public static boolean isNumericInt(String str)
    {
        if(str== null)
            return false;
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    public static boolean isNumericDouble(String str)
    {
        if(str == null)
            return false;
        try {
            double d =Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    public static boolean isNumericDate(String dateString, String dateFormat)
    {
        if(dateString== null)
            return false;
        SimpleDateFormat format = new SimpleDateFormat(dateString);
        format.setLenient(false);
        try {
            Date dob = format.parse(dateString);
        } catch (ParseException ex) {
            System.out.println("Khong dung dinh dang");
            return false;
        }
        return true;
    }
    
}
