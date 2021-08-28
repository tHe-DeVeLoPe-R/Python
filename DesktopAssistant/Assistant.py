import wikipedia
import pyttsx3
import time
import webbrowser
import datetime
import speech_recognition as sr
import os
import random

firstTime = True

routine = ["Sir! First you have a jim in the morning 5:30Am" , "second you have a breakfast at 7am" , "I think then we have some time to take rest" , "Fourth we have to write some code in python" , "then we have to write some java script as you are doing web developmenrt as well" , "Sir! one thing is very important I want to remember you. you have to drink more than three litres of water per day.It will be good for your health."]

voiceEngine = pyttsx3.init('sapi5')
voices = voiceEngine.getProperty('voices')

voiceEngine.setProperty('voice' , voices[0].id)

def speak(audio):
    voiceEngine.say(audio)
    voiceEngine.runAndWait()

def takeCommand():
    r = sr.Recognizer()
    with sr.Microphone() as source:
        audio = r.listen(source , phrase_time_limit=7)

    try:
        speak("ok Sir let me recognize")
        command = r.recognize_google(audio , language="en-US")
    
    except Exception as e:
        #print(e)
        # print("say again ...")
        return "none"
    return command


def wishMe():
    hour = int(datetime.datetime.now().hour)

    if hour>=0 and hour <=12:
        speak("Aslaaam u Alaikum! I am Echelon. Good Morning to you Sir. You can speak now I am Listening to you Sir for next seven seconds ")
    elif hour>=12 and hour <=17:
        speak("Aslaaam u Alaikum! I am Echelon. Good Afternoon to you Sir. You can speak now I am Listening to you Sir for next seven seconds")
    elif hour>=17 and hour <=19:
        speak("Aslaaam u Alaikum! I am Echelon. Good Evenning to you Sir.You can speak now I am Listening to you Sir for next seven seconds ")
    elif hour>=19 and hour <=24:
        speak("Aslaaam u Alaikum! I am Echelon .You can speak now I am Listening to you Sir for next seven seconds")

# if __name__ == '__main__':
    #speak("Hey I am Python AI speaking")
def start():
        
        command = takeCommand().lower()

        if 'wikipedia' in command:
            speak("Echelon is Searching Wikipedia...")
            command = command.replace("wikipedia" , "")
            results = wikipedia.summary(command , sentences = 2)
            speak("According to wikipedia")
            speak(results)
            
        elif 'open youtube' in command:
            speak('Ok Sir I am openning youtube for you')
            webbrowser.open('youtube.com')

        elif 'open google' in command:
            speak('Ok Sir I am openning google for you')
            webbrowser.open('google.com')

        elif 'open stackoverflow' in command:
            speak('Ok Sir I am openning stack overflow for you')
            webbrowser.open('stackoverflow.com')

        elif 'play music ' in command:
            speak('Ok Sir I am going to play something')
            try:
                musicPath = "E:\\QALAM E IQBAL"
                musicList = os.listdir(musicPath)
                musicNo_ = random.randint(0,2)
                os.startfile(os.path.join(musicPath , musicList[musicNo_]))
            except Exception as e:
                speak("An exception occured")

        elif 'go for sleep' in command:
            speak("Ok Sir I am Going to Sleep. But on launch I will be again available for you Sir.")
            exit(0)

        elif 'how are you' in command:
            speak("By The Grace Of Almighty Creater I am fine How are you Sir?")
            command = takeCommand()
            speak("May The Almighty Creater give you Goodness Take care of yourself Sir!")

        elif 'your age' in command:
            speak("Alhamdulilah I am 1 year old. I am programmed in two k twenty")
        
        elif 'introduce yourself' in command:
            speak("I am echelon from Pakistan. I was programmed in two k twenty one in a language known as python. I am working as saad zafar's personal assisstant software.")

        elif 'who are you' in command:
            speak("I am echelon from Pakistan. I was programmed in two k twenty one in a language known as python. I am working as saad zafar's personal assisstant software.")
        
        elif 'routine' in command:
            for item in routine:
                speak(item)
        
        elif 'thankyou' in command:
            speak("you are welcome Sir!")

        elif 'you doing' in command:
            speak("Sir! Currently I am talking to you")

        else:
            speak("Sorry Sir I am not able to recognize . Contact Saad Zafar for working properly with me Sir")
        
        time.sleep(1)
        speak("Sir! If you want Any thing else click on launch button. I will be here for you. ThankYou!")
