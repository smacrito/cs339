from flask import Flask, render_template, url_for, flash, redirect, request
#passing class in from forms.py
from forms import addQuestionForm
#import xmltodict
import xml.etree.ElementTree as ET
from input import initXML, MultipleChoiceQuestion, ExportToXML
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
        return redirect(url_for('home'))
    return render_template('addMultipleChoice.html', title='Add Question', form=form)

@app.route('/submitAnsweer', methods=['GET','POST'])
def addMultipleChoice():
    data = initXML()
    form = submitAnswerForm()

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
        return redirect(url_for('home'))
    return render_template('addMultipleChoice.html', title='Add Question', form=form)



#allows running flask from python directly, doesnt require env vars
#if __name__ == '__main__':
    #app.run(debug=True)
