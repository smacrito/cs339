import xml.etree.ElementTree as ET

def ReadXML(path):
    tree = ET.parse(path)
    return tree

def GetQuestionCount(tree):
    count = 0
    root = tree.getroot()
    for child in root:
        count+=1
    return count

def GetQuestion(number, tree):
    question = tree[number] #gets question
    return question

def GetQuestionType(question):
    type = question.tag #finds type w/o need for subfunction!
    return type

def tempunused(): #to be removed
    #will use that type to decide what subfunction to use
    if type == 'MultipleChoiceQuestionType':
        return MultipleChoiceQuestion(question)
    elif type == 'TrueFalseQuestionType':
        return TrueFalseQuestion(question)
    elif type == 'ShortResponseQuestionType':
        return ShortResponseQuestion(question)
    else:
        raise NameError('Question Type Mismatch in GetQuestion')

def MultipleChoiceQuestion(question):
    return 0

def TrueFalseQuestion(question):
    return 0

def ShortResponseQuestion(question):
    return 0


