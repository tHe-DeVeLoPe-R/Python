from tkinter.filedialog import askopenfilename , asksaveasfilename
from tkinter import *
from tkinter.messagebox import showinfo
import os

root = Tk()

root.geometry("1000x600+200+50")
root.title("Untitled - Notepad")
root.wm_iconbitmap("icon.ico")
textArea = Text(root , font = "lucida 13")
file = None
textArea.pack(fill = BOTH , expand= True)

#horizontal menu in root
menuBar = Menu(root)

#vertical file menu inside main menu starts---------------------------------

def newFile():
    global file
    root.title("Untitled - Notepad")
    file = None
    textArea.delete(1.0 , END)


def existingFile():
    global file

    file = askopenfilename(defaultextension = ".txt" , filetypes = [("All Files", "*.*") ,
                                                                    ("text Documents" , "*.txt")])
    if file == "":
        file = None
    else:
        root.title(os.path.basename(file)+" - "+"Notepad")
        textArea.delete(1.0 , END)
        f = open(file , "r")
        textArea.insert(1.0 , f.read())
        f.close()

def saveFile():
    global file

    if file == None:
        file = asksaveasfilename(initialfile = "Untitled.txt" , defaultextension = ".txt" , filetypes = [("All Files", "*.*") ,
                                                                    ("text Documents" , "*.txt")])
        if file == "":
            file = None
        else:
            f = open(file , "w")
            f.write(textArea.get(1.0 , END))
            f.close()
            root.title(os.path.basename(file)+" - Notepad")
    else:
        f = open(file, "w")
        f.write(textArea.get(1.0, END))
        f.close()
        root.title(os.path.basename(file) + " - Notepad")

def exitNotepad():
    root.destroy()

fileMenu = Menu(menuBar , tearoff = 0)

#options inside filemenu

#new file
fileMenu.add_command(label = "New" , command = newFile)

#existingfile
fileMenu.add_command(label = "Open file" , command = existingFile)

#saveFile
fileMenu.add_command(label = "Save" , command = saveFile)

#add separator
fileMenu.add_separator()

#exit
fileMenu.add_command(label = "Exit" , command = exitNotepad)

#cascade main menubar
menuBar.add_cascade(label = "File" , menu = fileMenu)

#edit menu starts---------------------------------------------------------


def cut():
    textArea.event_generate("<<Cut>>")

def copy():
    textArea.event_generate("<<Copy>>")

def paste():
    textArea.event_generate("<<Paste>>")

editMenu = Menu(menuBar , tearoff = 0)

editMenu.add_command(label = "Cut" , command = cut)
editMenu.add_command(label = "Copy" , command = copy)
editMenu.add_command(label = "Paste" , command = paste)
menuBar.add_cascade(label = "Edit" , menu = editMenu)

#help menu starts-----------------

def aboutNotepad():
    showinfo("Notepad", "Improved Notepad version with new Theme Functionality added."
                        "Dark and light grey theme also avaiable now ")

def helpOption():
    pass


helpMenu = Menu(menuBar , tearoff =0)
helpMenu.add_command(label = "About Notepad" , command= aboutNotepad)
helpMenu.add_command(label = "Help" , command= helpOption)

menuBar.add_cascade(label = "Help" , menu = helpMenu)

#theme menu started----------

def lightTheme():
    textArea.config(bg="white" , fg="black" ,insertbackground="black")

def darkTheme():
    textArea.config(bg="black" , fg="white" , insertbackground="white")

def lightGrey():
    textArea.config(bg="grey" , fg="white" , insertbackground="white" , cursor="hand2 white")

themeMenu = Menu(menuBar , tearoff=0)
themeMenu.add_command(label= "Light" , command=lightTheme)
themeMenu.add_separator()
themeMenu.add_command(label= "Dark" , command=darkTheme)
themeMenu.add_separator()
themeMenu.add_command(label= "Light Grey" , command=lightGrey)

menuBar.add_cascade(label="Theme" , menu=themeMenu)

root.config(menu = menuBar)

# adding scrollBar --------------

scrollbar = Scrollbar(textArea)
scrollbar.pack(fill= Y , side = RIGHT)
textArea.config(yscrollcommand = scrollbar.set)
scrollbar.config(command = textArea.yview)

root.mainloop()