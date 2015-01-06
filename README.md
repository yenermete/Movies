Movies
======
This project is done with Java 1.8, JSF 2.2(Primefaces 4.0), Spring 4.0.2, Hibernate 4.3.1, JPA 2.1, Oracle 11g, Glassfish 4, Netbeans 8. It is a web application about a simple movie database. Scripts for creation and insertion are found under com.movies.db.scripts package for the database. All you need is an Oracle 10/11g database with a user named 'yener' identified by 'yener'.(Or you can change this in your own branch however you wish.) To run the web application, you need to change applicationContext.xml so that 'dataSource' will have the SID of your database.

The database has three main entitites. Movies have many to many relationships with directors and actors. You can navigate through the three pages either by the upper links or through datatables. It is still work in progress though, not everything has been implemented yet.
