Am implementat doua interfete Visitable si Payable. Clasele care implementeaza Visitable specifica in ce zile ale saptamanii si in ce interval orar este disponibila o anumita atractie pentru vizitare. Pentru retinerea acestor date am folosit un LinkedHashMap care are drept key un obiect de tip DayOfWeek si drept value un obiect de tip Pair, clasa care contine doua obiecte de tip LocalTime. Clasele care implementeaza Payable contin un ticketPrice care specifica cat costa un bilet pentru acea atractie. Clasele Statue, Church si Concert extind Atraction si in functie de caz implementeaza Visitable si/sau Payable. Clasa Trip retine numele orasului in care sunt atractiile, intervalul de timp pe care il sta persoana respectiva in oras si atractiile care vor fi vizitate.