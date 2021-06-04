# Game of Multiples
The game generates 3 secret numbers between 1 and 10.  
The goal of the player is to enter a number that is a multiple of the 3 secret numbers generated.  
Each time the player inputs a number the game shows the player a result between 0 and 3.  
The result is determined by the amount of secret numbers that are a factor of the submitted number.  
The game ends when the player finds a multiple of all 3 secret numbers.

## Requirements
- Java 8 : [JDK 8]
- Maven 3.6.2 : [Maven 3.6.2]

## Build the application

- Build with Maven:
```
mvn clean verify
```

- Build with script run.sh:
```
./run.sh
```

## Run the application after build
- Run with run.sh script. After building the jar the script can run the game.
```
./run.sh
```

- Run from IDE running as java application in Main class:
```
com.charliocat.game.Main;
```

- Run jar with:
```
java -jar target/game-of-multiples-1.0.0.jar
```

## Docker
- Build & Run docker image:
```
docker build -t game-of-multiples .  

docker run --rm -it game-of-multiples:latest
```


## Assumptions
- Single player local game
     - No need of logging, persistence layer or multithreading
- No UI interface
- Valid input is only positive integers 
- Generated game values are unique

## Application flow

From top to down:
- Main starts the game
- MultiplesGameService handles input from user using a Console.
- GameEngine takes responsibility on the game flow.
- GameInitializer generates the random values
- Game calculates the multiples from user input
- Console reads and writes to user terminal

## Game Commands:
- To stop the game you can type 'exit' to the user console.
  ```
  exit
  ```

- To see the game values you can type 'hint' to the user console.
  ```
  hint
  ```

## Next Steps
- Improve the console and user interaction
    - Use external libraries for it.
- Improve test coverage
- Improve code robustness:
    - Better input validation
    - Improve error & exception handling (log handling). 

## Sample:

```
Game: Welcome to the game of multiples!
Game: Type <hint> to see the game values
Game: Type <exit> to stop playing
Game: Enter a positive integer to play
1
Game: 0
hint
Game: [6, 8, 10]
8
Game: 1
test
Game: Input error. Try again.
480
Game: win

```


[JDK 8]: https://jdk.java.net/8/
[Maven 3.6.2]: https://docs.gradle.org/6.8/release-notes.html
