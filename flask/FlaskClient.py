from flask import Flask, render_template, url_for
#passing class in from forms.py
from forms import addQuestionForm
#import xmltodict

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

@app.route('/')
def home():
    return render_template('home.html', questions=questions)

@app.route('/addQuestion')
def addQuestion():
    form = addQuestionForm()
    return render_template('addQuestion.html', title='Add Question', form=form)


#allows running flask from python directly, doesnt require env vars
#if __name__ == '__main__':
    #app.run(debug=True)
