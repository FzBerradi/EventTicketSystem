# Ticket Reservation System
 is a Java Enterprise Edition (JEE) application
## This ticket reservation system facilitates users to log in, select events, and securely pay for tickets. It employs multiple design patterns including Decorator, Observer, Strategy, and Factory to ensure robust and flexible functionality.

## Features

- **User Authentication**: Secure login and authentication process for users.
- **Event Selection**: Browse and select from a variety of available events.
- **Ticket Purchase**: Seamless and secure payment gateway integration for purchasing tickets.
- **Event Notifications**: Automatic email notifications to users about newly added events.

## Design Patterns

- **Decorator Pattern**: Enhances event objects with additional functionalities or options without altering their structure.
- **Observer Pattern**: Ensures real-time updates to users about changes in event availability.
- **Strategy Pattern**: Offers multiple algorithms for event selection and ticket pricing, allowing flexibility and customization.
- **Factory Pattern**: Creates instances of event objects based on user preferences or system requirements.
## Technologies Used2

- **Java EE**: Enterprise-level Java framework for building scalable applications.
- **Servlets and JSP**: Handling HTTP requests and rendering dynamic web pages.
- **JPA (Java Persistence API)**: Object-relational mapping for managing database interactions.
- **MySQL**: Relational database for storing application data.
- **HTML/CSS**: Front-end development for user interface design.
- **Bootstrap**: Front-end framework for responsive and mobile-first design.

## Getting Started

To run the Ticket Reservation System locally:

1. Clone this repository: `git clone https://github.com/FzBerradi/EventTicketSystem.git`
2. Configure your MySQL database settings in `src/main/resources/application.properties`.
3. Build and deploy the application to your Java application server (e.g., Apache Tomcat).
4. Access the application at `http://localhost:8086/DecoratorProject/).

## Contributing

Contributions are welcome! Please follow the [contribution guidelines](CONTRIBUTING.md) in this repository.

## License

This project is licensed under the [MIT License](LICENSE).
