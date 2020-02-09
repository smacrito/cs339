from flask import Flask, render_template, url_for, flash, redirect, request
#passing class in from forms.py
from forms import addQuestionForm, submitAnswerForm
#import xmltodict
import xml.etree.ElementTree as ET
from input import *
from output import *
from response import *
from readresponse import *

app = Flask(__name__)
#creates key to allow wsgi
app.config['SECRET_KEY'] = 'test'

#dict to read questions from for def home()
questions = [
    {
        'question':'who was the last president?',
        'answer':'barack obama'
    }
]

#sample page that shows displaying from dict
@app.route('/home')
def home():
    return render_template('home.html', questions=questions)

#sample add question to variable
#pass in get and post to allow sending data from user
@app.route('/addQuestion', methods=['GET','POST'])
def addQuestion():

    form = addQuestionForm()
    questionList={'q':'','a':''}
    print(questionList)

    #flash msg to be added...
    if form.validate_on_submit():
        print('enter flash')
        input_question = request.form['questionin']
        input_answer = request.form['answerin']
        print(input_question)
        print(input_answer)
        questionList['q']=input_question
        questionList['a']=input_answer
        #questionList[1]=input_answer
        print(questionList)
        #flash msg, pass in f to pass data
        flash(f'Question added: {form.questionin.data}.', 'success')
        #redirect to ensure success
        return redirect(url_for('home'))

    return render_template('addQuestion.html', title='Add Question', form=form)

#Add multiple choice question and write to XML
@app.route('/addMultipleChoice', methods=['GET','POST'])
def addMultipleChoice():
    data = initXML()
    form = addQuestionForm()

    #flash msg to be added...
    if form.validate_on_submit():
        #rertrieve questions from user input 
        questionin = request.form['questionin']
        option1in = request.form['option1in']
        option2in = request.form['option2in']
        option3in = request.form['option3in']
        option4in = request.form['option4in']
        option5in = request.form['option5in']
        answerin = request.form['answerin']
        data = MultipleChoiceQuestion(data, questionin, option1in, option2in, option3in, option4in, option5in, answerin)
        ExportToXML(data)

        #flash msg, pass in f to pass data
        flash(f'Question added: {form.questionin.data}.', 'success')
        return redirect(url_for('submitAnswer'))
    return render_template('addMultipleChoice.html', title='Add Question', form=form)

@app.route('/submitAnswer', methods=['GET','POST'])
def submitAnswer():
    responseData = initResponseXML()
    form = submitAnswerForm()

   # question = GetQuestion(0, responseData)
  #  print(question)
    #flash msg to be added...
    if form.validate_on_submit():
        #rertrieve questions from user input 
        userAnswerin = request.form['userAnswerin']
        responseData = response(responseData, userAnswerin)
        ExportToResponseXML(responseData)

        #flash msg, pass in f to pass data
        flash(f'Answer added: {form.userAnswerin.data}.', 'success')
        return redirect(url_for('checkAnswer'))
    return render_template('submitAnswer.html', title='Submit an Answer', form=form)

@app.route('/checkAnswer', methods=['GET','POST'])
def checkAnswer():
    root = ReadXML("temp.xml")
    count = GetQuestionCount(root)

    for x in range(0, count):
        print('\n')
        question = GetQuestion(x,root)
        questionText = GetQuestionsQuestion(question)
        type = GetQuestionType(question) #Get that questions type to determine what of the next functions apply and how to use them
        print (type)

        print("Question: " + GetQuestionsQuestion(question))

        options = GetOptions(question)
        print("Options: ")

        for option in options:
            print(option)

    root2 = ReadResponseXML("temp-response.xml")
    userAnswer = GetResponse(0,root2)

    print("Answer: ")
    answer = GetAnswer(question)
    print(answer)
    return render_template('checkAnswer.html', title='Check Answers', options=options, questionText=questionText, answer=answer, userAnswer=userAnswer)

#checkAnswer()




#allows running flask from python directly, doesnt require env vars
#if __name__ == '__main__':
    #app.run(debug=True)
