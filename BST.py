class BST:
    def __init__(self, key):
        self.key = key
        self.lchild = None
        self.rchild = None

    def insert(self, data):
        if self.key is None:
            self.key = data
            return

        if data < self.key:
            if self.lchild:
                self.lchild.insert(data)
            else:
                self.lchild = BST(data)
        else:
            if self.rchild:
                self.rchild.insert(data)
            else:
                self.rchild = BST(data)

    def search(self, data):
        if self.key == data:
            print("----------Data found----------")
            return

        if data < self.key:
            if self.lchild is None:
                print("--------Data not found-------")
            else:
                self.lchild.search(data)

        else:
            if self.rchild is None:
                print("--------Data not found-------")
            else:
                self.rchild.search(data)

    def traversal(self):
        if self.key is None:
            print("Tree is empty")
            return

        else:
            print(self.key , end="|")

            if self.lchild:
                self.lchild.traversal()

            if self.rchild:
                self.rchild.traversal()





root = BST(10)
root.insert(2)
root.insert(21)
root.traversal()
print("---------level1st----------")


root.insert(0)
root.insert(15)
root.insert(7)
root.traversal()
print("---------level2nd----------")

root.insert(4)
root.traversal()
print("---------level3rd----------")


# root.search(3)


# print(root.rchild.key)
# print(root.key)
# print(root.lchild)
# print(root.lchild)