package Models;

import java.util.Date;

public class Event {
	private Long id;
    private String name;
    private String location;
    private Date date;
    private double basePrice;

    // Constructors
    public Event() {}

    public Event(Long id, String name, String location, Date date, double basePrice) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.basePrice = basePrice;
    }
    
    public Event(String name, String location, Date date, double basePrice) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.basePrice = basePrice;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
    
	@Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", basePrice=" + basePrice +
                '}';
    }
}
