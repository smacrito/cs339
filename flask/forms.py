from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
from wtforms.validators import DataRequired, Length
#create a separate file for forms for organization
#create a class for each form that we can call later
class addQuestionForm(FlaskForm):                   #calling premade function to check for input
    questionin = StringField('Question', validators=[DataRequired(), Length(min=1,max=500)])
    option1in = StringField('Option 1', validators=[DataRequired(), Length(min=1,max=500)])
    option2in = StringField('Option 2', validators=[DataRequired(), Length(min=1,max=500)])
    option3in = StringField('Option 3', validators=[DataRequired(), Length(min=1,max=500)])
    option4in = StringField('Option 4', validators=[DataRequired(), Length(min=1,max=500)])
    option5in = StringField('Option 5', validators=[DataRequired(), Length(min=1,max=500)])
    answerin = StringField('Answer', validators=[DataRequired(), Length(min=1,max=500)])
    userAnswerin = StringField('Answer', validators=[DataRequired(), Length(min=1,max=500)])
    confirm = SubmitField('Add Question')

class submitAnswerForm(FlaskForm):
    userAnswerin = StringField('Answer', validators=[DataRequired(), Length(min=1,max=500)])
    confirm = SubmitField('Submit Answer')