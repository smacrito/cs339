from flask import Flask, render_template

app = Flask(__name__)
question = 
@app.route('/')
def hello():
    return render_template('home.html')






#allows running flask from python directly, doesnt require env vars
if __name__ == '__main__':
    app.run(debug=True)
