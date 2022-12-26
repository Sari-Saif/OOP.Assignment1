# OOP.Assignment1
 
In Our Assignment We Talk About  And Develop UndoStringBuilder :
: [https://github.com/SariSafe/OOP_HW_00_ARIEL]()

Here We Design And Implement Our Interfaces , General Program 
Depending On Principal  Of Unique Design Pattern Observer....

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
![Screenshot 2022-12-26 135113](https://user-images.githubusercontent.com/98646866/209545886-f5bf854e-1db8-435f-b937-177d442dd1dc.png)
 
Asked To Implement Tow Interfaces, We will add an option to organize a group of recipients of updates on the status of
UndoableStringBuilder and send all updates to it in real time.
 **We will add tracking of the size of the Heap object** 
: 


````
Sender -> observable
Member -> observer 
````
