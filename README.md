# Bulletin System
 

## This Assignment 01 :

The Mission is to Extend the Functionality of UndoStringBuilder From [Assignment_00](https://github.com/SariSafe/OOP_HW_00_ARIEL)




## Observer Design Pattern :
````
In software design and engineering, the observer pattern is a software design pattern in which an object,
is Observerable, maintains a list of its dependents, called observers, and notifies them automatically of 
any state changes, usually by calling one of their methods(update, notify...).

It is often used for implementing distributed event handling systems, in "event driven" software. In those systems,
Observerable is usually named a "stream of events" or "stream source of events", while the observers are called "sinks of events". 
The stream nomenclature alludes to a physical setup where the observers are physically separated have no control over the emitted events from the subject/stream-source.

````
## UML:
![UML_Bulletin](https://user-images.githubusercontent.com/98646866/209549218-75eac602-6b5e-47c9-a526-1eb6f593878c.png)

 
Asked To Implement Tow Interfaces, We will add an option to organize a group of recipients of updates on the status of
UndoableStringBuilder and send all updates to it in real time.
 **We will add tracking of the size of the Heap object** 
: 


````
Sender -> observable
Member -> observer 
````
