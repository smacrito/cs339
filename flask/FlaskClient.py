from flask import Flask, render_template, url_for, flash, redirect
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

@app.route('/home')
def home():
    return render_template('home.html', questions=questions)

#pass in get and post to allow sending data from user
@app.route('/addQuestion', methods=['GET','POST'])
def addQuestion():
    form = addQuestionForm()
    #flash msg
   # if form.validate_on_submit():
        #flash msg, pass in f to pass data
        #flash(f'Question added: {form.question.data}.')
        #return redirect(url_for('/home'))
    return render_template('addQuestion.html', title='Add Question', form=form)


#allows running flask from python directly, doesnt require env vars
#if __name__ == '__main__':
    #app.run(debug=True)
