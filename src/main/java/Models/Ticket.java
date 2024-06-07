package Models;

public class Ticket {
	private Long id;
    private Event event;
    private User user;
    private double price;
    private String description;
    private String status = "pending";

    // Constructors
    public Ticket() {}

    public Ticket(Event event,User user, double price, String description) {
        this.event = event;
        this.user = user;
        this.price = price;
        this.description = description;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	@Override
	public String toString() {
		return "Ticket [event=" + event + ", user=" + user + ", price=" + price + ", status=" + status + "]";
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String Desc) {
		this.description = Desc;
	}
    
}
