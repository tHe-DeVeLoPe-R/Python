import schedule
import time
from plyer import notification

def console():
   notification.notify(

       title = "Drink water",
       message = "Drinking water continously will help your mind to get refresh so that you can code more properly " , 
       app_icon = "",
       timeout = 3
   )

schedule.every(2).hours.do(console)

while True:
    schedule.run_pending()
    