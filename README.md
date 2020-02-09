**CS339**

0) Make sure to have Python 3.6 or later

## Setting up Flask

1) First we must install flask and flaskwtf
	

    pip install flask
    
    pip install flask-wtf

1.5) Note you may need to use pip3

    pip3 install flask

    pip3 install flask-wtf

2) To run our program, cd into the directory that holds "FlaskClient.py" using terminal or command prompt. 
3) Now, we must set our Flask_App in terminal or command prompt, which can be done through program execution as well, but is not set up that way currently, as this is a demo of base functionality.

    set FLASK_APP=FlaskClient.py
	
    or

    export FLASK_APP=FlaskClient.py

	Then, we may now run
	
    flask run

4) In a browser of your choice, navigate to *127.0.0.1:5000/addMultipleChoice*
5) Here, you can run through the prompts.

 - addMultipleChoice displays adding a question via user input to temp.xml
 - submitAnswer displays submitting an answer via user input to temp-response.xml
 - checkAnswer displays parsing both XML files and passing them to html with flask

