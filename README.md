# Hangman Word Guessing Game

Command Line Hangman Game for two players built with Java. Each player has to guess their own random word with 10 attempts.
The player who starts is chosen randomly and the turn to guess a letter is alternated.
The game ends as soon as one player either wins or looses.

## How to run the program
1. Fork and clone this repository
2. Open the project in a code editor and run ```App.java``` file
3. Follow the instructions shown in the terminal

## Output Example
```
Welcome to the hangman game!

Enter name for player one: 
Jake
Enter name for player two: 
Lucy

Welcome! Today the word to guess is: 
Lucy: L_____
Jake: D________

Lucy: Enter one letter to guess (10 attempts remaining):
O
Right!
LO__O_
Jake: Enter one letter to guess (10 attempts remaining):
O
Right!
D____O___
Lucy: Enter one letter to guess (10 attempts remaining):
S
Wrong
LO__O_
Jake: Enter one letter to guess (10 attempts remaining):
V
Right!
D_V__O___
Lucy: Enter one letter to guess (9 attempts remaining):
N
Right!
LON_ON
Jake: Enter one letter to guess (10 attempts remaining):
R
Right!
D_V__O__R
Lucy: Enter one letter to guess (9 attempts remaining):
D
Congratulations! Lucy won!
LONDON
```

## Technologies Used
- Java
- JUnit 