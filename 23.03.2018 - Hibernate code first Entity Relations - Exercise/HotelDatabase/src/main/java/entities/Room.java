package entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="rooms")
public class Room {
    private Integer roomNumber;
    private RoomType typeOfRoom;
    private BedType typeOfBed;
    private BigDecimal rate;
    private RoomStatus statusOfRoom;
    private String notes;

    public Room() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_number")
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    @OneToOne
    @JoinColumn(name = "room_type", referencedColumnName = "room_type")
    public RoomType getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(RoomType typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    @OneToOne
    @JoinColumn(name="bed_type", referencedColumnName = "bed_type")
    public BedType getTypeOfBed() {
        return typeOfBed;
    }

    public void setTypeOfBed(BedType typeOfBed) {
        this.typeOfBed = typeOfBed;
    }

    @Column(name="rate")
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @OneToOne
    @JoinColumn(name="room_status", referencedColumnName = "room_status")
    public RoomStatus getStatusOfRoom() {
        return statusOfRoom;
    }

    public void setStatusOfRoom(RoomStatus statusOfRoom) {
        this.statusOfRoom = statusOfRoom;
    }

    @Column(columnDefinition = "TEXT")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
