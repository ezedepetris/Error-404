-------------------------------------------------
---------------PARTIDO DE VISITANTE--------------
vuelta::[a]->[(a,a)]
vuelta [x] = []
vuelta (x:xs) = combinacion2 (x:xs) ++ vuelta xs

combinacion2:: [a]->[(a,a)]
combinacion2 [] = []
combinacion2 (x:xs) = [swap(x,y) | y<-xs]
-------------------------------------------------
---------------PARTIDO DE LOCAL------------------
ida::[a]->[(a,a)]
ida [x] = []
ida (x:xs) = combinacion (x:xs) ++ ida xs

combinacion:: [a]->[(a,a)]
combinacion [] = []
combinacion (x:xs) = [(x,y) | y<-xs]
-------------------------------------------------
-----------PARTIDO DE IDA Y VUELTA---------------
partido::[a]->[[(a,a)]]
partido [] = []
partido (x:xs) = listOfList (ida(x:xs)) (vuelta(x:xs))
-------------------------------------------------
--------------FUNCIONES AUXILIARES---------------
cut:: Eq a=> a->[a]->[a]
cut x [] = []
cut x (y:ys) | x==y = ys
			 | otherwise = [y]++(cut x ys)

swap::(a,a)->(a,a)
swap (x,y) = (y,x)

listOfList:: [(a,a)]->[(a,a)]->[[(a,a)]]
listOfList xs ys = [[y] | y<-xs ]++ [[y] | y<-ys]
