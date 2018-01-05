# LibraryManagement

This my implementation a simple java project with the console interface for library management. I implement such commands: greet, help, add, edit, remove, all books, exit, back and added validation commands, checking availability . I used in the project: Java, MySql 5.1.23, Maven, JDBC, Intellij IDEA.


# Task

Create a simple java project with the console interaface for library managing. Implement such commands:<br/>
add book<br/>
remove {book_name}<br/>
edit book {book_name}<br/>
               user enters new name: {book_name}<br/>
all books : return a list of all books ordered by name<br/>
If there are few books with the same name show user the list of these books with the ability to choose only one.<br/>
Book shoud have name and author.<br/>
For storing books use relational DB. <br/>
<br/>
Please send us a link to the GitHub repository with your version of this project.<br/>
<br/>
Example (U - user, P - program):<br/>
U: add J. Rowling “Harry Potter”<br/>
P: book J. Rowling “Harry Potter” was added <br/>
U : add Unknown “Harry Potter”<br/>
P: book Unknown “Harry Potter” was added <br/>
U : add J. Martin “A Song of Ice and Fire”<br/>
P: book J. Martin “A Song of Ice and Fire” was added <br/>
U: remove A Song of Ice and Fire<br/>
P: book J. Martin “A Song of Ice and Fire” was removed <br/>
U: all books<br/>
P:   Our books : <br/>
           		 J. Rowling “Harry Potter”<br/>
          		 Unknown “Harry Potter”<br/>
U: remove Harry Potter<br/>
 P:  we have few books with such name please choose one by typing a number of book:<br/>
 J. Rowling “Harry Potter”<br/>
 Unknown “Harry Potter”<br/>
<br/>
U: 2<br/>
P: book Unknown “Harry Potter” was removed <br/>
This was just an example, feel free to use your creativity to change the program flow.<br/>
