from flask_wtf import FlaskForm
from wtforms import StringField
from wtforms.validators import DataRequired
#create a separate file for forms for organization
#create a class for each form that we can call later
class addQuestionForm(FlaskForm):                   #calling premade function to check for input
    userQuestion = StringField('Question', validators=[DataRequired()])