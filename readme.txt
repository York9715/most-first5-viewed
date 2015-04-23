## Using MySQL in Spring Boot via Spring Data JPA and Hibernate

### Database:
url=jdbc:mysql://localhost:3306/testdb
username = york
password = password

### Data
DROP TABLE usehistory;
CREATE TABLE `usehistory` (
    `id` INT(6) UNSIGNED NOT NULL AUTO_INCREMENT,
    `userid` VARCHAR(20) ,
    `prodid` VARCHAR(20) NOT NULL,
    `updated` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE product;
CREATE TABLE `product` (
	`id` INT(6) UNSIGNED NOT NULL AUTO_INCREMENT,
    `prodid` VARCHAR(20) NOT NULL,
    `prodname` VARCHAR(20) NOT NULL,
    `prodtype` VARCHAR(20) NOT NULL,
    `updated` VARCHAR(20) NOT NULL,
    CONSTRAINT pk_ProductID UNIQUE  (prodid),
    PRIMARY KEY (`id`)
);

INSERT INTO product ( prodid, prodname, prodtype ) VALUES('1000-01','Toronto Ice Cream','food');
INSERT INTO product ( prodid, prodname, prodtype ) VALUES('1000-02','Beijing Noodle','food');
INSERT INTO product ( prodid, prodname, prodtype ) VALUES('2000-01','Oh Canada','book');
INSERT INTO product ( prodid, prodname, prodtype ) VALUES('2000-02','Oh China','book');
INSERT INTO product ( prodid, prodname, prodtype ) VALUES('3000-01','Rav4','car');
INSERT INTO product ( prodid, prodname, prodtype ) VALUES('3000-02,'Camry','car');
INSERT INTO product ( prodid, prodname, prodtype ) values('3000-03,'Rogue','car');

INSERT INTO usehistory(prodid,updated,userid) VALUES('1000-01','2015-04-15','ychen');
INSERT INTO usehistory(prodid,updated,userid) VALUES('1000-02','2015-04-15','ychen');
INSERT INTO usehistory(prodid,updated,userid) VALUES('2000-01','2015-04-15','ychen');
INSERT INTO usehistory(prodid,updated,userid) VALUES('2000-02','2015-04-15','ychen');

### Usage
- Run the application and go on http://localhost:8080/
- Use the following urls to invoke controllers methods and see the interactions
  with the database:
    * `/productlist`: show all products
	
- curl localhost:8080/mostviewed
- curl localhost:8080/listusehistory
- curl localhost:8080/listproducts
 

### Build and run

#### Configurations

Open the `application.properties` file and set your own configurations.

#### Prerequisites

- Java 7
- Maven 3

#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.
