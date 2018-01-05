# LibraryManagement

This my implementation a simple java project with the console interface for library management. I implement such commands: greet, help, add, edit, remove, all books, exit, back and added validation commands, checking availability . I used in the project: Java, MySql 5.1.23, Maven, JDBC, Intellij IDEA.


# Task

Create a simple java project with the console interaface for library managing. Implement such commands:
add book
remove {book_name}
edit book {book_name}
               user enters new name: {book_name}
all books : return a list of all books ordered by name
If there are few books with the same name show user the list of these books with the ability to choose only one.
Book shoud have name and author.
For storing books use relational DB. 

Please send us a link to the GitHub repository with your version of this project.

Example (U - user, P - program):
U: add J. Rowling “Harry Potter”
P: book J. Rowling “Harry Potter” was added 
U : add Unknown “Harry Potter”
P: book Unknown “Harry Potter” was added 
U : add J. Martin “A Song of Ice and Fire”
P: book J. Martin “A Song of Ice and Fire” was added 
U: remove A Song of Ice and Fire
P: book J. Martin “A Song of Ice and Fire” was removed 
U: all books
P:   Our books : 
           		 J. Rowling “Harry Potter”
          		 Unknown “Harry Potter”
U: remove Harry Potter
 P:  we have few books with such name please choose one by typing a number of book:
 J. Rowling “Harry Potter”
 Unknown “Harry Potter”

U: 2
P: book Unknown “Harry Potter” was removed 
This was just an example, feel free to use your creativity to change the program flow.
