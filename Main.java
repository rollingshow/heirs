package com.company;

import java.util.ArrayList;
import java.util.Collections;

// Суть класса в том, что у нас есть три вида курсов: стандартные, ускоренные и интенсивные. Высчитывается количество недель для прохождения курса.
abstract class Onlinecourse implements Comparable<Onlinecourse> {
    abstract int getWeeks();
    protected int Lessonsperweek;
    protected int Lessonduration;
    protected static int hours = 144;
    @Override
    public int compareTo(Onlinecourse second)
    {
        return Integer.compare(this.getWeeks(), second.getWeeks());
    }

    @Override
    public boolean equals(Object second)
    {
        if (second == this) {
            return true;
        }
        if (second == null || second.getClass() != this.getClass()) {
            return false;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "Your course will last "+ getWeeks()+" weeks";

    }
}
class Defaultcourse extends Onlinecourse
{
    Defaultcourse(int hours)
    {
        Lessonsperweek=2;
        Lessonduration=1;
        this.hours=hours;
    }
    int a;
    @Override
    int getWeeks() {
        return hours/(Lessonsperweek+Lessonduration) ;
    }
}


class Crashcourse extends Onlinecourse
{
    Crashcourse(int hours)
    {
        Lessonsperweek=2;
        Lessonduration=2;
        this.hours=hours;
    }
    int a;
    @Override
    int getWeeks() {
        return hours/(Lessonsperweek+Lessonduration) ;
    }
}


class Intensivcourse extends Onlinecourse
{
    Intensivcourse(int hours)
    {
        Lessonsperweek=3;
        Lessonduration=2;
        this.hours=hours;
    }
    int a;
    @Override
    int getWeeks() {
        return hours/(Lessonsperweek+Lessonduration) ;
    }
}

public class Main {
    public static void main(String[] args) {

        ArrayList<Onlinecourse> onlinecourses = new ArrayList<>();
        onlinecourses.add(new Defaultcourse(144));
        onlinecourses.add(new Crashcourse(160));
        onlinecourses.add(new Intensivcourse(200));

        Collections.sort(onlinecourses);
        System.out.println(onlinecourses.toString());

        Defaultcourse dc = new Defaultcourse(144);
        Crashcourse cc=new Crashcourse(144);
        Intensivcourse ic = new Intensivcourse(144);



        if (dc.getWeeks() > ic.getWeeks())
            System.out.println("Intensiv course is faster than default");
        else
            System.out.println("Default course is faster than intensiv");
    }
}