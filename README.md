

#OOPS CONCEPTS USED:
    Inheritance: inheritance can be through the abstract class GameObject which likely serves as a base class for game elements.
    This demonstrates the "is-a" relationship.
    Composition and Aggregation: There are multiple "has-a" relationships shown:
        The Game class has composition relationships with Player, Level, Settings, and HomePage
        The Level class contains collections of Bird and Pig objects, and has relationships with Structure and PauseMenu
        The Structure class maintains lists of Block objects and Vector2D positions
    Encapsulation: Classes properly encapsulate their data using private (-) and public (+) members. For example:
        Player has private attributes like userName and playerLevel
        Bird and Pig classes protect their internal states while providing public methods
    Abstraction:  abstract classes (LevelDesign, GameObject,Pig and Bird), showing how common behaviors are abstracted.
        There are also three types of Pigs and Birds which extends the Pig and the Bird class 
    Polymorphism: This is implied through the abstract classes , allowing different objects to be treated uniformly while having specific implementations.
