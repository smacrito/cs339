import xml.etree.ElementTree as ET

tree = ET.parse("demo2.xml")
root = tree.getroot()

def printAttrib():
    for qText in root.iter('qText'):
        print (qText.attrib)
        
def printAll():
    for qText in root.findall('question'):
        qText = qText.find('qText').text
        print(qText)

def xPath():
    findAll = root.findall(".")
    print (findAll)
    findAll = root.findall("./question/qText").text
    print(findAll)
    
