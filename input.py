import xml.etree.ElementTree as ET

def Sample():
    #Set up tree
    data = ET.Element('data')
    items = ET.SubElement(data, 'items')
    item1 = ET.SubElement(items,'item')
    item2 = ET.SubElement(items,'item')

    #Add values
    item1.set('name', 'item1')
    item2.set('name','item2')
    item1.text = "question"
    item2.text = 'question'

    #Export
    mydata = ET.tostring(data)
    myfile = open("temp.xml","w")
    myfile.write(mydata)

def initXML():
    data = ET.Element('data')
    return data

def MultipleChoiceQuestion(data, question1in, option1in, option2in, option3in, option4in, option5in, answer1in):
    #Set up tree
    MultipleChoiceQuestionType = ET.SubElement(data, 'MultipleChoiceQuestionType')
    question1 = ET.SubElement(MultipleChoiceQuestionType,'question1')
    options = ET.SubElement(MultipleChoiceQuestionType, 'options')
    option1 = ET.SubElement(options, 'option')
    option2 = ET.SubElement(options, 'option')
    option3 = ET.SubElement(options, 'option')
    option4 = ET.SubElement(options, 'option')
    option5 = ET.SubElement(options, 'option')
    answer1 = ET.SubElement(MultipleChoiceQuestionType,'answer1')

    #Set names
    question1.set('name','question1')
    option1.set('name','option1')
    option2.set('name', 'option2')
    option3.set('name', 'option3')
    option4.set('name', 'option4')
    option5.set('name','option5')
    answer1.set('name','answer1')

    #Fill values
    question1.text = question1in
    option1.text = option1in
    option2.text = option2in
    option3.text = option3in
    option4.text = option4in
    option5.text = option5in
    answer1.text = answer1in

    return(data)

def ExportToXML (data):
    mydata = ET.tostring(data)
    myfile = open("temp.xml", "w")
    myfile.write(mydata)