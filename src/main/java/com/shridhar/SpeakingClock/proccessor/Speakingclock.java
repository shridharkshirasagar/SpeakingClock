package com.shridhar.SpeakingClock.proccessor;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
public class Speakingclock {

    public String currentTime(){
        SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        formatDate.setTimeZone(TimeZone.getTimeZone("IST"));
        return formatDate.format(date);
    }

}
