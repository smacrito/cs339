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

    #Fill Values
    question.text = questionin
    #answer is reserved to be filled by user?

    return  data

def FillInTheBlankQuestion(data, part1in, part2in, answerin):
    #Setup Tree
    FillInTheBlankQuestionType = ET.SubElement(data, 'FillInTheBlankQuestionType')
    parts = ET.SubElement(FillInTheBlankQuestionType,'parts')
    part1 = ET.SubElement(parts, 'part')
    part2 = ET.SubElement(parts, 'part')
    answer = ET.SubElement(FillInTheBlankQuestionType,'answer')

    #Fill Values
    part1.text = part1in
    part2.text = part2in
    answer.text = answerin

    return data

#Finally when published it will use this method to produce an XML to be sent to a recipient
def ExportToXML (data):
    mydata = ET.tostring(data)
    myfile = open("temp.xml", "wb")
    myfile.write(mydata)

def Main():
    data = initXML()
    data = MultipleChoiceQuestion(data, "Question", "Choice1", "Choice2", "Choice3", "Choice4", "Choice5", "Choice2")
    data = TrueFalseQuestion(data, "Question", "True")
    data = ShortResponseQuestion(data, "Question")
    data = ShortResponseQuestion(data, "Question")
    ExportToXML(data)

Main()