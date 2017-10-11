package ua.singleton.tirestore.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tires")
public class Tire implements Serializable {

    private static final long serialVersionUID = 8282600172662022734L;

    @Id
    @Column(name = "tire_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int width;

    @Column
    private int height;

    @Column
    private int diameter;

    @Column(name = "speed_index")
    private String speedIndex;

    @Column
    private byte [] picture;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getSpeedIndex() {
        return speedIndex;
    }

    public void setSpeedIndex(String speedIndex) {
        this.speedIndex = speedIndex;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }
}
