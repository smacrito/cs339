from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
from wtforms.validators import DataRequired, Length
#create a separate file for forms for organization
#create a class for each form that we can call later
class addQuestionForm(FlaskForm):                   #calling premade function to check for input
    userQuestion = StringField('Question', validators=[DataRequired(), Length(min=1,max=500)])
    userAnswer = StringField('Answer', validators=[DataRequired(), Length(min=1,max=500)])
    confirm = SubmitField('Add Question')