import xml.etree.ElementTree as ET


def func():
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

func()