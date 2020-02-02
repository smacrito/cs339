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
    FindType(question[0]) #will then use this function to find type
    #will use that type to decide what subfunction to use

def FindType():
    return 0