from flask import Flask, render_template
import xmltodict

app = Flask(__name__)

with open('C:/Users/Sammy/Desktop/School/COMP339/cs339/flask/demo2.xml') as fd:
    doc = xmltodict.parse(fd.read())

@app.route('/')
def hello():
    return render_template('home.html')






#allows running flask from python directly, doesnt require env vars
#if __name__ == '__main__':
    #app.run(debug=True)
