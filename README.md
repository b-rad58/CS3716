# CS3716
CS3716 Final Project
GROUP KP
Bradley Gavan
Matthew Randall
Colin MacDonald
Ryan McCubbin

This is our final project.  When ran, the user is taken to a login screen.  If a login does not already exist, you must create an account (on the right).  After an account is created, login.  The user can create a society or join an existing society.  If they choose to create a society, they will be added to the members list of that society and will become president.  The view of a society is different depending on wheter or not you are the president.  For a standard memeber, the society will show its description, a members list and society events.  For the president, he has the options to create an event, remove members and host elections.  The button must be pressed by the president to start the election.  The president will then need to select the nominees for treasurer, vice president, and social chair.  Once this is done, any member visiting the page will be able to vote in the election.  The election is ended by the president pressing the end election button on the society page.  The board members can be seen on the upper right of the society page.  A standard user can choose to leave a society but the president can not.  

We chose to encapsulate each object in its own class (i.e., Society, Account, AccountInventory, SocietyInventory, Elections).  This allowed us to clearly define each objects' attributes and functionality and have that encapsulated.  

Account and Society information is stored in text files.  The names of those files are hard coded into the save and load functions for AccountInventory and SocietyInventory.  They use Object Input/Output Streams to handle this.

# Team_Project
