from flask import Flask, render_template, url_for, flash, redirect, request
#passing class in from forms.py
from forms import addQuestionForm
#import xmltodict
import xml.etree.ElementTree as ET

app = Flask(__name__)
app.config['SECRET_KEY'] = 'test'




#with open('C:/Users/Sammy/Desktop/School/COMP339/cs339/flask/demo2.xml') as fd:
#   doc = xmltodict.parse(fd.read())

questions = [
    {
        'question':'who was the last president?',
        'answer':'barack obama'
    }
]

@app.route('/home')
def home():
    return render_template('home.html', questions=questions)

#pass in get and post to allow sending data from user
@app.route('/addQuestion', methods=['GET','POST'])
def addQuestion():

    form = addQuestionForm()
    questionList={'q':'','a':''}

    print(questionList)
    #flash msg to be added...
    if form.validate_on_submit():
        print('enter flash')
        input_question = request.form['userQuestion']
        input_answer = request.form['userAnswer']
        print(input_question)
        print(input_answer)
        questionList['q']=input_question
        questionList['a']=input_answer
        #questionList[1]=input_answer
        print(questionList)
        #flash msg, pass in f to pass data
        flash(f'Question added: {form.userQuestion.data}.', 'success')
        return redirect(url_for('home'))
    return render_template('addQuestion.html', title='Add Question', form=form)



#allows running flask from python directly, doesnt require env vars
#if __name__ == '__main__':
    #app.run(debug=True)
