package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime
{
    private Date date;
    private int hour, minute, second;

    public DateTime()
    {
      date = Calendar.getInstance().getTime();
    }
    public String getTimestamp()
    {
      SimpleDateFormat sdf = new SimpleDateFormat(
          "dd/MM/yyyy HH:mm:ss");
      return sdf.format(date);
    }
    public String getSortableTime()
    {
      SimpleDateFormat sdf = new SimpleDateFormat(
          "yyyy-MM-dd-HH-mm-ss");
      return sdf.format(date);
    }
    public String getSortableDate()
    {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      return sdf.format(date);
    }
  public void tic()
  {
    second += 1;
    if (second > 59)
    {
      minute += 1;
      second = 0;

      if (minute > 59)
      {
        hour += 1;
        minute = 0;

        if (hour > 23)
        {
          hour = 0;
        }
      }
    }
  }
}
