# asg_customer

1. I've created one microservices Customer (using Java 15 & Spring boot 2.4.2).
2. JWT API is implemented in /customer microservice as /authenticate to retrieve JWT token using username/password to call subsentential APIs.
3. Currently the password is mocked as `password`. Username can be anything which we will insert into database.
4. I've implemented CRUD APIs for `/customer`.
5. There is also an API to retrieve all customers.
6. For this application I've considered two roles as `CUSTOMER` & `BRANCH_MANAGER`
7. `BRANCH_MANAGER`: Has permssions to do all CRUD operations.
8. `CUSTOMER`: Has permission to only view/modify his own details.
9. 8 & 9 is handled using Pre/Post authorization feature of spring security.
10. Database script I'm attaching along with this readme file.
11. This application is created using mvn. So can be run from the main file `com.ashwin.customer.CustomerServiceApplication`


## Database Tables:
```
CREATE TABLE ashwin_user (
user_id character varying(100) PRIMARY KEY,
user_name character varying(50),
date_of_birth timestamp without time zone,
gender  char(1) NOT NULL,
phone_number character varying(15),
fk_role_id character varying(100) REFERENCES ashwin_role(role_id) UNIQUE
);

CREATE TABLE ashwin_role
(
role_id character varying(100) PRIMARY KEY,
role_name character varying(200) UNIQUE,
role_code character varying(200) UNIQUE,
role_type character varying(50)
);
```