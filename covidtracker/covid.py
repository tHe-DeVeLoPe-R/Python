from tkinter import * 
import requests
import bs4

readable_data_ww = ""
readable_data_cw = ""
data_headings = ['Covid-19 Cases' , 'Deaths' , 'Recoveries']
i = -1
url_world_wide = "https://worldometers.info/coronavirus/"

def worldWideDetail():

    global readable_data_ww , i , data_headings , url_world_wide
    
    data = requests.get(url_world_wide)
    html_data = bs4.BeautifulSoup(data.text , 'html.parser')
    count_div = html_data.find("div", class_="content-inner").findAll("div", class_="maincounter-number")
    
    for block in count_div:
        i+=1
        count = block.find("span" , class_= None).get_text()
        readable_data_ww += data_headings[i]+" : "+count+'\n'+'\n'+'\n'
    i = -1
    dataType.config(text="World-Wide Data :" , font = ("jost" , 15 , "bold") , fg='purple')
    results.config(text=readable_data_ww , font = ("jost" , 13 , "bold"))
    readable_data_ww = ""


def countryWiseDetail():
    global readable_data_cw , i , data_headings
    
    country = entry.get()
    try:
        url_country_wise = "https://worldometers.info/coronavirus/country/"+country 
    
        data = requests.get(url_country_wise)
        html_data = bs4.BeautifulSoup(data.text , 'html.parser')
        count_div = html_data.find("div", class_="content-inner").findAll("div", class_="maincounter-number")
    
        for block in count_div:
            i+=1
            count = block.find("span" , class_= None).get_text()
            readable_data_cw += data_headings[i]+" : "+count+'\n'+'\n'+'\n'
        i = -1
        dataType.config(text="Data For "+country , font = ("jost" , 15 , "bold") , fg='purple')
        results.config(text=readable_data_cw , font = ("jost" , 13 , "bold"))
        readable_data_cw = ""
        country = ""

    except AttributeError:
        results.config(text="country name not available" , font = ("jost" , 13 , "bold"))
        





root = Tk()

root.geometry("900x550+200+100")
root.resizable(width=False , height=False)
root.title("Covid Tracker - Live")
bg_img = PhotoImage(file= 'bgimg.png')
root.iconphoto(False , bg_img)
background = Label(root , image = bg_img , width = 900 , height = 550)
background.place(x=0 , y = 0)

heading = Label(root , text = "Covid-19" , fg = "red", font = ("jost" , 25 , 'bold'))
heading.place(x = 370 , y = 50)

entryLabel = Label(root , text = "Enter Country name below : " , font = ("jost" , 16 , "bold"))
entryLabel.place(x = 270 , y= 120)

entry = Entry(root , width = 40  , borderwidth = 3 , fg = "green" , font = ("jost" , 13 , "bold"))
entry.place(x = 270 , y = 200)

btn1 = Button(root , font = ("jost" , 10 , "bold"), text = "Check For Given Name" , bg = 'red' , fg = 'white' , command = countryWiseDetail)
btn1.place(x = 280 , y = 250)

btn2 = Button(root , font = ("jost" , 10 , "bold"), text = "Get World-Wide results" , bg = 'red' , fg = 'white' , command=worldWideDetail)
btn2.place(x = 460 , y = 250)

dataType = Label(root , text="Result Type will appear here" , font = ("jost" , 15 , "bold") , fg='purple')
dataType.place(x = 350 , y = 320)

results = Label(root , text="Results will be shown here" , font = ("jost" , 10 , "bold") , fg='red')
results.place(x = 350 , y = 370)

root.mainloop()