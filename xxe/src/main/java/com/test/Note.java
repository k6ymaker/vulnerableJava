package com.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="note")
public class Note {
    public String To;

    @XmlElement(name ="to")
            public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }
}
