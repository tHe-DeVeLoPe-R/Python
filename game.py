
from random import randint, random


print('\n\n\t-----------------Instructions-----------------\n\n\tYou can decide total number of sticks (min : 10 ,  max : 30) while playing at one time you can\n\n\t choose (1-5) sticks , dont break rule')

class Game:

    def __init__(self , sticks , name):
        self.sticks = sticks

        self.computerSticks = int(0)

        self.userSticks = int(0)

        self.userChoosed = int(0)

        self.name = name
    
    #--------------method-------------------

    def start(self):

      while True:
        
        print(f"\n\tTotal Sticks available: {self.sticks}")
        
        if self.sticks == 0:

            print(f"You Loose")
            break

        else:

            self.userChoosed = int(input(f"Hey! {self.name} it's your turn : "))

            if self.userChoosed >0 and self.userChoosed <6:

                self.userSticks = self.userChoosed

                self.sticks = self.sticks - self.userSticks

            else:
                print(f"Your Turn Lost you entered {self.userChoosed} sticks which is against the rule")
            
            if self.sticks == 0:

                 print(f"You Won")
                 break

            else:

                if self.sticks > 0 and self.sticks < 6:

                    self.computerSticks = self.sticks

                else:

                    self.computerSticks = randint(1, 5)

                print(f"Computer choosed {self.computerSticks} sticks")

                self.sticks = self.sticks - self.computerSticks


if __name__ == '__main__':

    def run():
       
        userName = input("\n\tEnter your name : ")

        sticks = int(input('\n\tEnter Total Sticks : '))

        if sticks > 30 or sticks <10:

            print(f"Rule : (min : 10 ,  max : 30) but you entered {sticks}")

            run()
                    
        else:
            
            game = Game(sticks , userName)

            game.start()
        
    run()
    out = input('Enter any key to exit')
    out = 'goodbye'