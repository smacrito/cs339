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
    type = question.tag #finds type w/o need for subfunction!
    #will use that type to decide what subfunction to use
    if type == 'MultipleChoiceQuestionType':
        return MultipleChoiceQuestion(question)
    elif type == 'TrueFalseQuestionType':
        return TrueFalseQuestion(question)
    elif type == 'ShortResponseQuestionType':
        return ShortResponseQuestion(question)

def MultipleChoiceQuestion():
    return 0

def TrueFalseQuestion():
    return 0

def ShortResponseQuestion():
    return 0


