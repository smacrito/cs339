import xml.etree.ElementTree as ET

tree = ET.parse("demo2.xml")
root = tree.getroot()

#prints all attributes, isnt really useful right now but we can use it to reference
#locations of attributes
#... also isnt working..?
def printAttrib():
    for qText in root.iter('qText'):
        print (qText.attrib)

#prints all questions by looping through all parents "question" and all
#children "qText" | .text gets text from .find which returns a location
def printAll():
    for qText in root.findall('question'):
        qText = qText.find('qText').text
        location = qText.find('qText')
        print("question: ", qText,  "Location: " , location)

#using xPath syntax to iterate through tree
def xPath():
    #findall locations
    findAll = root.findall(".")
    print (findAll)
    #findall parents named question with children qText, get text of element
    findAll = root.find("./question/qText").text
    print(findAll)
    
