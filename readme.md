#**Data-Processor Application.**
* This application is built using Spring framework.
* For csv parsing, org.apache.commons library is used.
* To store the data,application is currently pointing to Spring in-memory database H2.
* To Change to a different DB change the data source URL accordingly.
* Pass the file path as a first argument to execute the application.
    Example : mvn spring-boot:run -Dspring-boot.run.arguments="classpath:sales.csv" 
    Assuming the csv file is in resource folder.
* With OrderId,CustomerId, ProductId are unique, the given sales.csv will not be persisted as it contains duplicate values for these IDs.
