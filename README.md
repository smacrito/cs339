**CS339**
## Explaination
This is a basic program that allows the connection of two phones via UDP to transfer data. It utilizes the room data base to maintain consistency and redundancy. 
The heart of the program enables the user to send questions to other users in a quiz form, to which they can then answer on another phone. This app is created for android,
And required API level 26 or higher. 

## Running
We suggest running from within android studio, since it allows you to run the code immediate on a virtual device. 

The app you want to load is Roomdatabase>app

## Demo
Here are our slides: https://docs.google.com/presentation/d/1PEvtOm7MdDWw0wZ8hxj3KQgUCTPTzp5ySfDxwX6GiLw/edit?usp=sharing

Here is a video demo:https://www.youtube.com/watch?v=HB3KCG0ll6g

One you get the app open here are the instructions on how to see the full feature set running on a single device.

If at any point you get a "ROOMDATABASE ERROR" please uninstall the app and relaunch
When typing, you may see warnings on logcat. These can be ignored. 

Select HOST to start up a server

At the bottom of the screen you shuold see your address and port: (For the VM we are using localhost 9876) This will be important later

You can then use ADD A QUESTION

Make sure to put an INTEGER in question number then add your own options. 

Hit SUBMIT

Use the BACK ARROW

You may view the question by hititng VIEW_QUESTION

Now hit BACK to the Client selection screen

Select CLIENT

Enter the address and port from before (For VM: localhost 9876) 

You can then VIEW QUESTIONS or ANSWER QUESTIONS
