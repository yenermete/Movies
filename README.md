Movies
======
This project is done with Java 1.7, JSF 2.2(Primefaces 4.0), Spring 4.0.2, Hibernate 4.3.1, JPA 2.1, Oracle 11g, Glassfish 4, Netbeans 7.4. It is a web application about a simple movie database. For database, scripts for creation and insertion are found under com.movies.db.scripts package. All you need is a Oracle 10/11g database with a user named 'yener' identified by 'yener'. To run the web application, you need to change applicationContext.xml so that 'dataSource' will have the SID of your database.

The database has three main entitites. Movies have many to many relationships with directors and actors. You can navigate through the three pages either by the upper links or through datatables. It is still work in progress though, not everything has been implemented yet.
