# Implementation of vending machine

Entities:
VendingMachine (Singleton)
    │
    │ aggregation
    ▼
PaymentService (Singleton)
    │
    │ aggregation
    ▼
PaymentMethod (interface)
   /          \
CardPayment   UpiPayment
(Singleton)   (Singleton)

Transaction
InventoryManager

Learnings:
1. Needed to Override boolean equal(Object o) and int hashcode() function in Product class because I have used this class's object as key in map
2. usage of concurrenthash map to track the inventory count - for addition and reduction usage of compute function with functional interface (BiFunction) as lambda expression
