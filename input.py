import xml.etree.ElementTree as ET

#Setup Program will run this first
def initXML():
    data = ET.Element('data')
    return data

#Then the user will set as many questions as they like using these methods
def MultipleChoiceQuestion(data, questionin, option1in, option2in, option3in, option4in, option5in, answerin):
    #Set up tree
    MultipleChoiceQuestionType = ET.SubElement(data, 'MultipleChoiceQuestionType')
    question = ET.SubElement(MultipleChoiceQuestionType,'question')
    options = ET.SubElement(MultipleChoiceQuestionType, 'options')
    option1 = ET.SubElement(options, 'option')
    option2 = ET.SubElement(options, 'option')
    option3 = ET.SubElement(options, 'option')
    option4 = ET.SubElement(options, 'option')
    option5 = ET.SubElement(options, 'option')
    answer = ET.SubElement(MultipleChoiceQuestionType,'answer')

    #Set names
    question.set('name','question')
    option1.set('name','option1')
    option2.set('name', 'option2')
    option3.set('name', 'option3')
    option4.set('name', 'option4')
    option5.set('name','option5')
    answer.set('name','answer')

    #Fill values
    question.text = questionin
    option1.text = option1in
    option2.text = option2in
    option3.text = option3in
    option4.text = option4in
    option5.text = option5in
    answer.text = answerin

    return(data)

def TrueFalseQuestion(data, questionin, answerin):
    #Setup Tree
    TrueFalseQuestionType = ET.SubElement(data, 'TrueFalseQuestionType')
    question = ET.SubElement(TrueFalseQuestionType, 'question')
    options = ET.SubElement(TrueFalseQuestionType, 'options')
    true = ET.SubElement(options, 'option')
    false = ET.SubElement(options, 'option')
    answer = ET.SubElement(TrueFalseQuestionType, 'answer')

    #Set Names
    question.set('name', 'question')
    true.set('name', 'true')
    false.set('name', 'false')
    answer.set('name', 'answer')

    #Fill Values
    question.text = questionin
    answer.text = answerin
    true.text = "True"
    false.text = "False"

    return(data)

def ShortResponseQuestion(data, questionin):
    #Setup Tree
    ShortResponseQuestionType = ET.SubElement(data, 'ShortResponseQuestionType')
    question = ET.SubElement(ShortResponseQuestionType, 'question')
    answer = ET.SubElement(ShortResponseQuestionType, 'answer')

    #Set Names
    question.set('name', 'question')
    answer.set('name', 'answer')

    #Fill Values
    question.text = questionin
    #answer is reserved to be filled by user?

    return  data



#Finally when published it will use this method to produce an XML to be sent to a recipient
def ExportToXML (data):
    mydata = ET.tostring(data)
    myfile = open("temp.xml", "wb")
    myfile.write(mydata)

def Main():
    data = initXML()
    data = MultipleChoiceQuestion(data, "Question", "Choice1", "Choice2", "Choice3", "Choice4", "Choice5", "Choice2")
    ExportToXML(data)

Main()