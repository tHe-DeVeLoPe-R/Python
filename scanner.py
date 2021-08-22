from genericpath import getsize
import os
import time

folders = list()
results = dict(path = '' , dir = 0 , files = 0 , size = 0)
def pathInput():

    global results

    tempPath = os.path.abspath(input('Enter path of directory to scan : '))
    
    if not os.path.exists(tempPath):
        print(f'oops! path => {tempPath} not found')
        time.sleep(1)
        print('shuting down scanner')
        time.sleep(2)
        exit(0)
    
    if not os.path.isdir(tempPath):
        print(f'oops! path => {tempPath} not a directory')
        time.sleep(1)
        print('shuting down scanner')
        time.sleep(2)
        exit(0)
    
    print('Getting path')
    time.sleep(1)
    print('Path found')
    results['path'] = tempPath
    scanPath()


def scanPath():
     
    global results

    global folders
    print(f"scanning path => {results['path']}")
    
    for dirs,subDirs,files in os.walk(results['path'],onerror=None,followlinks=False):        
         folders.append(dirs)

         results['dir']+=len(subDirs)

         results['files']+=len(files)

         for file in files:
             fullName = os.path.join(dirs , file)
             results['size']+= os.path.getsize(fullName)

def display():
    print(f"Folders = {results['dir']} , Files = {results['files']} , Data => {results['size']} bytes")
    print("\n\n\t---------------Detailed Review ------------\n\n\t")
    del folders[0]
    print(f"Folders Found => {folders}")

pathInput()
display()

