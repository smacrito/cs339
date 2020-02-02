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

