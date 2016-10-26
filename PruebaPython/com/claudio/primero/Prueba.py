'''
Created on Aug 25, 2016

@author: cserrano_ex
'''

print "hola mundo"

cadena = "12"
lista = [1,2,3,4,5]

print(lista);
print(cadena*3)
print(lista + [6,7,])
print(lista)

print(cadena[1])
print(int(cadena) + 2)
print(cadena + str(123))

if lista[0] == 1:
    print("Contiene el elemento 1")
else:
    print("No contiene el elemento 1 en la primera posicion")
    
contador = 0    
while True:
    print("Python es bkn " + str(contador))
    
    if contador == 10 :
        print("Se salta el 10")
        continue
    elif contador == 20 :
        print("LLego a 20, fin")
        break

    contador = int(contador) + 1