import xml.etree.ElementTree as ET

def ReadXML(path):
    tree = ET.parse(path)
    return tree