import xml.etree.ElementTree as ET

def initResponseXML():
    data = ET.Element('data')
    return data

def response(reply):
    ResponseType = ET.SubElement(data, 'ResponseType')
    ResponseType.text = reply
    return data

def ExportToResponseXML (data):
    mydata = ET.tostring(data)
    myfile = open("temp-response.xml", "wb")
    myfile.write(mydata)
