package com.gitHub.xMIFx.welcomeWebApp.server.domain;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Created by Bukatin Vlad on 14.09.2015.
 */
public class WelcomeMessage implements Serializable {

    private String helloMessage;
    private LocalTime from;
    private LocalTime to;

    public WelcomeMessage() {
    }

    public WelcomeMessage(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getTo() {
        return to;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }

    public boolean isTimeBetweenFromTo(LocalTime now) {
        if (from.equals(now)) {
            return true;
        } else if (from.isBefore(to)
                && from.isBefore(now)
                && now.isBefore(to)) {
            return true;
        } else if (from.isAfter(to)
                && ((now.isAfter(from)
                && now.isBefore(LocalTime.MAX))
                || (now.isAfter(LocalTime.MIN)
                && now.isBefore(to)))) {
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WelcomeMessage that = (WelcomeMessage) o;

        if (helloMessage != null ? !helloMessage.equals(that.helloMessage) : that.helloMessage != null) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        return !(to != null ? !to.equals(that.to) : that.to != null);

    }

    @Override
    public int hashCode() {
        int result = helloMessage != null ? helloMessage.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WelcomeMessage{" +
                "helloMessage='" + helloMessage + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}' + "\n";
    }
}
