package com.shridhar.SpeakingClock.service;

import com.shridhar.SpeakingClock.exceptions.InvalidTimeFormatException;
import com.shridhar.SpeakingClock.proccessor.Speakingclock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpeakingclockService {
    @Autowired
    private Speakingclock speakingclock;
    public static String num1;
    public static String num2;

    public static String hours;

    public static String minutes;

    public static String info =  "";

    public String timeINWords(){
       String time = speakingclock.currentTime();

       String tp[] = time.split(":");
       if(tp[0].startsWith("0")){
          num1 = tp[0].substring(1);
       }else{
           num1 = tp[0];
       }


        if(tp[1].startsWith("0")){
            num2 = tp[1].substring(1);
        }else{
            num2 = tp[1];
        }


        if(time.length()==5){
            if(time == "00:00"){
                info = "It's Midnight";
                return "It's Zero Hours and Zero Minutes " + info;
            }
            else if(time == "12:00"){
                return "It's Twelve Zero It's MidNoon";
            }
            info = "";
            return "It's"+" " +convertToWords(num1) + " " + convertToWords(num2);
        }
        else{
            System.out.println(time.length());
            throw new InvalidTimeFormatException();
        }

    }

    public String convertToWords(String time){
        String[] single_digits = new String[] {
                "zero", "one", "two",   "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        String[] two_digits = new String[] {
                "",          "ten",      "eleven",  "twelve",
                "thirteen",  "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen"
        };
        String[] tens_multiple = new String[] {
                "" ,"","twenty",  "thirty", "forty",
                "fifty"
        };
        if(time.length() == 1){
            int t1 = Integer.parseInt(time);
            return single_digits[t1];

        }
        else if(time.startsWith("1")){
            int t2 = Integer.parseInt(time);
            return two_digits[t2-9];
            
        } else if (time.endsWith("0")) {
            List<Integer> t3 = proccessor(time);
            return tens_multiple[t3.get(0)];

        }else{
            List<Integer> t4 = proccessor(time);
            return tens_multiple[t4.get(0)] + " "+ single_digits[t4.get(1)];
        }

    }
    public  ArrayList<Integer> proccessor(String time){
        int t3 = Integer.parseInt(String.valueOf(time.charAt(0)));
        int t4 = Integer.parseInt(String.valueOf(time.charAt(1)));
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(t3);
        integers.add(t4);
        return integers;
    }

}
