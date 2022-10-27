**Team Members:**

    Mirna Masri

    Lauren Paredes

**Runtime version:** 17.0.3+7-b469.37 x86_64

**VM:** OpenJDK 64-Bit Server VM

This is a game where there are four adventurers of different types travel around a temple to find treasure or fight
monsters.
There are three different types of Monsters: blinkers, orbiters, and seekers. The goal of the Adventurers is to find
enough treasure or kill all the 12 monsters located around the temple.

User will have the ability to choose which adventure want to play
Instead of the game controlling 4 random adventurers, the game will be modified as follows:
A user will start a game by selecting an Adventurer type to play (Brawler, Sneaker, Runner, Thief) and will
provide a custom name to be used for the Adventurer.
All interactions with the user will be via the command line with prompts for numeric or text inputs.  Present the Facility drawing of the Rooms to the user prior to asking for commands.

**Changes summery:**
1. The new user-controlled Adventurer has a damage capacity based on type:  Brawlers 12, Runners and Thieves 10,
2. Sneakers 8
2. Adventurers with Quick Search skill will not skip searches.
3. All Search skill checks will be easier by 3
4. The game ends when the Adventurer enters Room 0-1-1 after having left it at the start of the game.
5. The Adventurer wins if
    1. they enter Room 0-1-1 after finding one of each type of treasure
    2. all Creatures are defeated.
6. The Adventurer loses immediately if:
    1. defeated by having 0 damage remaining
    2. by going to Room 0-1-1 without meeting the Treasure or Creature victory conditions above. 
