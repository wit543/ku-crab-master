                            CRAB WORLD

Author: Michael Kšlling, 2007
Author: modified by James Brucker, April 2009

Prerequisites: none

Goals: 
       understand what are classes and objects.
       learn to create objects using "new".
       invoke behavior of an object interactively and by programming.
       learn to write some simple behavior (programming) using Java.
       examine the state of an object.
       understand how objects can interact.

Modification from original crab world:

      (1) added a crab2.png image to enable animation, 
      (2) added addObject(Actor) to CrabWorld, to put actor at random location


Welcome to CRAB WORLD.  This is a simple Greenfoot scenario, designed 
for learning the basics of programming. 

In this world, crabs walk along a beach. Everything else is up to you.
At Kasetsart, we will follow these steps:
1. explore basic behavior and state of objects interactively, in order
   to understand concepts of "state" and "behavior"
2. add some behavior to a crab, so it can move and turn by itself
3. add a worm class
4. add behavior to Crab so it eats worms
5. automatically populate the crab world whenever scenario is opened.
   We'll write a populate() method and invoke it from the constructor.
   This also shows how to use a loop to create many worms.

In the next lesson we add:
6. animate the crab
7. animate the worms
8. teach crab to make a sound when it eats a worm
9. add lobsters, which eat crabs
   In this part, we will learn how to use randomness so that lobsters
   turn at random
10. add keyboard interaction, so we can help the crab avoid the lobsters. 

This scenario is designed to be used with "The Greenfoot Book", which 
tells you how to approach programming this scenario.
