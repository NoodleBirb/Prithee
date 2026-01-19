SDE Homework Assignment 1: Prithee

The problem is as follows:

"""
Given a sonnet, write a program that writes out the sonnet and stops at a random word, printing a series of underscores instead, and not printing the rest of the sonnet. The program should prompt the user for the next word. Once the user responds, the program should indicate correct or error, and restart the sonnet, stopping at a different word. Program continues until the user gets three words correct or three words incorrect.
"""

Take this sentence from the sonnet as an example:
"Two households, both alike in dignity,"

Treat each word as an index in an array. In this example, we'll assume the random index picked was index 3.
The following should be printed:
"Two households, both _____"

We assume the number of underscores is equal to the word length.

The user is then prompted for an input--case is ignored, and a counter is incremented based on whether their answer was correct.

Repeat until either counter is equal to three.

The following assumptions are made:
- The sonnet is passed as a String
- The sonnet is never empty
- When PlayIndexRound is run, it is with a working index

Important tests:
- Case-sensitive
- Index = 0
- Index = sonnet.length()
- 3 Correct
- 3 incorrect

Code structure:

Sonnet Object
Params:
- private int correct // default 0
- private int incorrect // default 0
- final String[] SONNET
One argument Constructor (String sonnet)
Methods
boolean GameOver() // When returns true, also prints end message
void PlayRound()
void PlayIndexRound(int sonnetWordInd) // For testing specific indexes
int getCorrect() // For testing correct number
int getIncorrect() // For testing incorrect number

Main Method:
Create Sonnet Object
while (!GameOver) Sonnet.PlayRound();

Tests:
Each test creates its own Sonnet object