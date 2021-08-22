Database project simulating a(n electronic) library of recommended books.

Use the app on heroku: https://goodreads-library.herokuapp.com/

The library has two types of users: patrons and librarians. Every new user has the role of patron by default. 

To use the librarian's functions, you may login with these credentials: 

username: Libby

password: Librarian1

#### Download and use the app locally ####

The application has been developed on Linux Ubuntu 18.04 device. The database system is PostgreSQL.
Install PostgreSQL:
```
$ sudo apt-get install postgresql
```
Check the status:
```
$ sudo -u postgres psql postgres

psql (10.17 (Ubuntu 10.17-0ubuntu0.18.04.1))
Type "help" for help.
```

Set the password for the user postgres:
```
postgres=# \password postgres
Enter new password: 
Enter it again: 
```
This application uses password 123 and a database called library.
Create the database:
```
$ sudo -u postgres createdb library
```
Exit psql with \q. Download the repository and cd to Library. Run the app:
```
mvn spring-boot:run
```
In a browser, navigate to localhost:8080 to use the app.
