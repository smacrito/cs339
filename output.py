import xml.etree.ElementTree as ET

def ReadXML(path):
    tree = ET.parse(path)
    root = tree.getroot()
    return root

def GetQuestionCount(root):
    count = 0
    for child in root:
        count+=1
    return count

def GetQuestion(number, root):
    question = root[number] #gets question
    return question

def GetQuestionType(question):
    type = question.tag #finds type w/o need for subfunction!
    return type

#Will change XML to have a unified format across all types (which is already basically followed)
#Types will continue to exist to show the front end what it needs to look for from these next functions
#Since not all will be used for every type

def GetQuestionsQuestion(question):
    return question[0].text

def GetOptions(question):
    options = []
    for option in question[1]:
        options.append(option.text)
    return options

def GetAnswer(question):
    return question[2].text

def Main(): #demo / test
    root = ReadXML("temp.xml")
    count = GetQuestionCount(root)
    print(count)

    #First Question
    question = GetQuestion(0, root)
    #Typically would be some kinda logic to determine the question type
    type = GetQuestionType(question)

    print("Question: " + GetQuestionsQuestion(question))

    print("Options: ")
    options = GetOptions(question)
    for option in options:
        print(option)

    print("Answer: "+ GetAnswer(question))


Main()