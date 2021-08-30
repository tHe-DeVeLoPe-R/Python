import socket
from IPy import IP


def check_input(ipadress):
    try:
        IP(ipadress)
        return ipadress
    except ValueError:
      try:
        return socket.gethostbyname(ipadress)
      except Exception:
        return "invalid"
        


def scan_port(ipadress):

    for port in range(75, 85):
        try:
            s = socket.socket()
            s.settimeout(0.5)
            s.connect((ipadress, port))

            print(f"port {port} is open")
        except:
            print(f"port {port} is closed")


def get_input():
    ipadress = input("Enter target to scan :  ")
    newip = check_input(ipadress)

    if newip == "invalid":
      print("invalid ipadress provided")
    else:
      scan_port(newip)


get_input()
