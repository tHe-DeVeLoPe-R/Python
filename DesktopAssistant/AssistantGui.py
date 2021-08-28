from tkinter.constants import SUNKEN
import  Assistant
import  tkinter

i = 0
def launched():
    global i
    if i == 0:
      Assistant.wishMe()
      Assistant.start()
      i+=1
    else:
        Assistant.speak("Yes Sir! I am here. How can I help you?")
        Assistant.start()

root = tkinter.Tk()

root.geometry("500x400+400+120")
root.resizable(False  ,False)

root.title("Echelon")

#------------optional color #138D75

root.configure(bg = "#17A589")

icon = tkinter.PhotoImage(file = "icon.png")

root.iconphoto(False , icon)

msg_label = tkinter.Label(root , text = "Everytime you want to start Echelon click on \n"
                                        "launch button. It will launch Echelon and then you\n"
                                        "can talk to him.You can complete your message in \n7seconds after that it will start recognizing" , bg="#17A589" , fg="white")
msg_label.place(x = 100 , y = 100)

launch_img = tkinter.PhotoImage(file = "launch.png")

launch_btn = tkinter.Button(root , image = launch_img , bg = "#17A589" , cursor = "hand2" , command = launched)

launch_btn.place(x = 190 , y = 250)

root.mainloop()