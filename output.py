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

    root = ReadXML("temp.xml") #Step 1 read the xml

    count = GetQuestionCount(root) #Determine how many questions need to be read
    print(count)

    #First Question
    question = GetQuestion(0, root) #Get the first question

    type = GetQuestionType(question) #Get that questions type to determine what of the next functions apply and how to use them
    print (type)

    print("Question: " + GetQuestionsQuestion(question)) #Get the question text

    print("Options: ")#Get the options usage of options depends on type
    options = GetOptions(question)
    for option in options:
        print(option)

    print("Answer: "+ GetAnswer(question))#Gets answer depends on type


Main()