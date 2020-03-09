**CS339**

0) Make sure to have Python 3.6 or later

## Setting up Flask

1) First we must install flask and flaskwtf


    pip install -r requirements.txt

    >If this fails you may have to install the packages manually:	

    pip install flask
    
    pip install flask-wtf

    >Note you may need to use pip3:

    pip3 install flask

    pip3 install flask-wtf

2) To run our program, cd into the directory that holds "FlaskClient.py" using terminal or command prompt. 
3) Now, we must set our Flask_App in terminal or command prompt, which can be done through program execution as well, but is not set up that way currently, as this is a demo of base functionality.

    >Depending on OS:

    export FLASK_APP=FlaskClient.py

    >or

    set FLASK_APP=FlaskClient.py

    >Then, we may now run
	
    flask run

4) In a browser of your choice, navigate to *127.0.0.1:5000/addMultipleChoice*
5) Here, you can run through the prompts.

 - addMultipleChoice displays adding a question via user input to temp.xml
 - submitAnswer displays submitting an answer via user input to temp-response.xml
 - checkAnswer displays parsing both XML files and passing them to html with flask

## Files

input.py
initXML() : Initalized the ElementTree ( ET )
MultipleChoiceQuestion(...) : Takes Multiple Choice Type and places in ET
TrueFalseQuestion(...) : Takes T/F Type and places in ET
ShortResponseQuestion(...) : Takes Short Response Type and places in ET
FillInTheBlankQuestion(...) : Takes FiTB Type and places in ET
ExportToXML(data) : Prints ET as XML
Main() : Testing function

output.py
ReadXML(path) : Opens XML and finds ROOT
GetQuestionCount(root) : Returns number of Questions
GetQuestion(number, root) : Returns question object at number index
GetQuestionType(question) : Returns type of question obj
GetQuestionQuestion(question) : Returns question text
GetOptions(question) : Returns list of options. Usage: all choices in a multi choice question
GetAnswer(question) : Returns answer text
Main(): Testing function

response.py
initResponseXML() : Initalized the ElementTree ( ET )
response(data,userAnswerin) : Takes response and places in ET
ExportToResponseXML(data) : Prints ET as XML
Main() : Testing function

readresponse.py
ReadResponseXML(path) : Opens XML and finds ROOT
GetResponseCount(root) : Returns number of Responses
GetResponse(number,root) : Returns response text at number index
Main() : Testing function
