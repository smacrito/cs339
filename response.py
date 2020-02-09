import xml.etree.ElementTree as ET

def initResponseXML():
    data = ET.Element('data')
    return data

def response(data, userAnswerin):
    ResponseType = ET.SubElement(data, 'ResponseType')
    ResponseType.text = userAnswerin
    return data

def ExportToResponseXML (data):
    mydata = ET.tostring(data)
    myfile = open("temp-response.xml", "wb")
    myfile.write(mydata)

def Main():
    data=initResponseXML()
    response(data, "Q1")
    response(data, "Q2")
    ExportToResponseXML(data)
#Main()