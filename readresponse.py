import xml.etree.ElementTree as ET

def ReadResponseXML(path):
    tree = ET.parse(path)
    root = tree.getroot()
    return root

def GetResponseCount(root):
    count = 0
    for child in root:
        count+=1
    return count

def GetResponse(number, root):
    response = root[number].text
    return response

def Main():
    root = ReadResponseXML("temp-response.xml")
    count = GetResponseCount(root)
    for x in range(0 , count):
        print(GetResponse(x, root))

Main()
