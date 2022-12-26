# Bulletin System
 

## Assignment 01

The mission is to extend the new functionality of UndoableStringBuilder from [Assignment_00](https://github.com/SariSafe/OOP_HW_00_ARIEL)


The new functionality gives us the option to hold a central UndoableStringBuilder object,

with user that notify when any change was created in the central UndoableStringBuilder.

All of that made by Design Pattern named OBSERVER.

 


For the Hebrew instruction [click here.](https://github.com/SariSafe/OOP.Assignment1/blob/master/Matala1.pdf)

There are tow links we used to understand the Observer Design Pattern:

- [Wikipidea](https://en.wikipedia.org/wiki/Observer_pattern)
- [YouTube](https://www.youtube.com/watch?v=_BpmfnqjgzQ)

## System Review:
![UML_Bulletin](https://user-images.githubusercontent.com/98646866/209549218-75eac602-6b5e-47c9-a526-1eb6f593878c.png)

 
Asked To Implement Tow Interfaces, We will add an option to organize a group of recipients of updates on the status of
UndoableStringBuilder and send all updates to it in real time.
 **We will add tracking of the size of the Heap object** 
: 


````
Sender -> observable
Member -> observer 
````
