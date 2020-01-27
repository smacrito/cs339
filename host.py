import xml.etree.ElementTree as ET

tree = ET.parse("demo2.xml")
root = tree.getroot()

for child in root:
    print (child.tag, child.attrib)

for text in root.iter('qText'):
    print (neighbor.attrib)
