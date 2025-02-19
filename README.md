# MCDA5550_HotelRes
A Springboot API for managing hotel reservations.

This project was developed as part of MCDA5550, 
demonstrating how to build a REST API using Springboot, 
SQLite, and postman for testing.

## How to Run API
1. Ensure you have Java and Maven installed:
   - java -version
   - mvn -version
   - if not installed:
     - Install Java from Oracle or OpenJDK
     - Install Maven from Apache Maven
2. Clone the respository by running:
    - git clone <https://github.com/Fearlouise/MCDA5550_HotelRes.git>
    - cd MCDA5550_HotelRes
3. Install dependencies by running: 
   - mvn clean install
4. Run the Springboot application: 
   - mvn spring-boot run
   - This will start the application on http://localhost:8080

## API Commands
### Checking API Works
There are two ways to verify that the API is working:

1. Open in Browser
    - Go to http://localhost:8080 in a browser:
    ![BrowserVerification.png](screenshots/BrowserVerification.png)  


2. Use Postman (GET Request):
   - GET http://localhost:8080/api/hotels
   ![VerifyApiWithGet.png](screenshots/VerifyApiWithGet.png)

### "POST" Request
To add a new hotel, send a POST request in Postman:

1. Method: POST
2. Endpoint: http://localhost:8080/api/hotels
3. Body example (JSON):
   {
   "hotelName": "Hilton Garden Inn",
   "streetNumber": "123",
   "streetName": "Main St",
   "city": "New York",
   "province": "NY",
   "country": "USA",
   "postalCode": "10001",
   "pricePerNight": 150.0
   }

Examples of a successful POST request:
![SuccessfulPost1.png](screenshots/SuccessfulPost1.png)
![SuccessfulPost2.png](screenshots/SuccessfulPost2.png)
![SuccessfulPost3.png](screenshots/SuccessfulPost3.png)
![SuccessfulPost4.png](screenshots/SuccessfulPost4.png)
![SuccessfulPost5.png](screenshots/SuccessfulPost5.png)


Example of a failed POST request (missing required fields)
![UnsuccessfulPost.png](screenshots/UnsuccessfulPost.png)

### Verify "POST" Request Works
After adding hotels, you can retrieve them using:

1. Postman GET Request:
![CheckPostWithGet.png](screenshots/CheckPostWithGet.png)


2. Open in Browser: http://localhost:8080
![CheckPostWithBrowser.png](screenshots/CheckPostWithBrowser.png)

### "DELETE" Request
To delete a hotel, send a DELETE request

1. Method: DELETE
2. Endpoint: http://localhost:8080/api/hotels/{id}

Example of a successful DELETE Request:
![SuccessfulDelete.png](screenshots/SuccessfulDelete.png)


Example of a failed DELETE Request (non-existent hotel)
![UnsuccessfulDelete.png](screenshots/UnsuccessfulDelete.png)

### Verify "DELETE" Request Works
After deleting hotels, you can verify deletion using:

1. Postman GET Request:
   ![CheckDeleteWithGet.png](screenshots/CheckDeleteWithGet.png)


2. Open in Browser: http://localhost:8080
   ![CheckDeleteWithBrowser.png](screenshots/CheckDeleteWithBrowser.png)
    
## Conclusion
This API provides a simple way to manage hotel listing using **Springboot** and **SQLite** .
It supports basic operations like:
- **GET**: Retrieve a list of available hotels.
- **POST**: Add new hotels to the database.
- **DELETE**: Remove hotels by their ID.

### Future Improvements
Potential enhancements for this API include:
- **Adding a Customer and Reservation System**: To track bookings and allow customers to reserve hotels.
- **Managing Hotel Availability**: Implementing logic to check and update available rooms in a hotel.
- **Access Control and Permissions**: Restricting actions like deleting hotels to authorized users only.

These features would improve the API's functionality, making it a **fully functional hotel reservation system**.

