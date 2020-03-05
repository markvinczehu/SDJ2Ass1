package model;

public class DateTime
{
  private int hour, minute, second;

  public DateTime(int hour, int minute, int second)
  {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }

  public int getSecond()
  {
    return second;
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
