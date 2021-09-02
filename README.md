Database project simulating an electronic library.

Use the app on heroku: https://goodreads-library.herokuapp.com/

The library has two types of users: patrons and librarians. Every new user has the role of patron by default. 

A patron can:

- create an user account

- browse the library collection

- borrow books and return them (after borrowing, user is supposed to get access to the e-book but this function is not implemented here)

A librarian can:

- see the list of  all users and their roles

- add librarian's privileges to another user

- see the list of all loans and by whom they were borrowed

- add new books to the library collection

To use the librarian's functions, you may login with these credentials: 

username: Libby

password: Librarian1

The Heroku version of the app persists the data so you may add users, books and loans permanently. The Github version drops the database tables and recreates them every time the program is run. 

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
Exit psql with \q. Download and extract the repository and cd to GoodReadsLibrary-main. Run the app:
```
mvn spring-boot:run
```
In a browser, navigate to localhost:8080 to use the app.
