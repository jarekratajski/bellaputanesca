# bellaputanesca

Aplikacja do zarządzania małą firmą transportową, gdzie kierowcy zasuwają wielkimi TIRami.

Główne funkcjonalności:
 - przechowywanie informacji o przesyłkach, pracownikach, operacjach, statusach...
 - generowanie faktur na podstawie historii zamówień
 - generowanie raportów na temat rentowności firmy
 - automatyczne zarządzanie trasą dostaw, rozwiązujące problemy najkrótszej ścieżki i takie tam
 
 ![alt text](https://raw.githubusercontent.com/julian4programmers/bellaputanesca/master/design.png)
 
 Ponadto:  
 C - Client
I - Info Hotline
S - Shipper
L - Lorry Driver
F - Fleet
A - Admin (CEO)

Client flow:
Create an order: C I
Edit the order: C I
Cancel the order: C I
4a. Preview the order: C I S L
4b. Preview history of orders of the client C I S
4c. Preview personal data of the client C I
Postpone delivery time C I
Submit a complaint C I
Mark a satisfaction C
Shipper standard flow:
11a. Preview finance of the order. S
11b. Preview scoring of the client. S
12. Accept the order. S
13a. Pause processing of the order. S
13b. Pause processing of the order and ask client for something to do. S
13c. Resume processing of the order. S
14. Reject the order. S
15. Give a discount. (every shipper has a limit for a month) S
16. Manually assign Lorry Driver. S
17. Consider and answer the complaint. S

Lorry Driver standard flow:
Preview the route ofr the order. L S
Manually change the route. L S
Change status of the order to status like "delivery is transporting". L
Change status of the order to status like "unloding the staff in the destination ". L
Change status of the order to status like "Order succesfully unloaded". L
Fleet standard functionalities:
Preview the vehicles.
Add a vehicle.
Edit a vechicle.
Add a repair or amendment of the vehicle.
Add information about fuelling.
SEO:
A is put to all functionalities, because CEO has authorization to everything.
What is more SEO have a possibility to previe the mark sum of the Shippers and profit of the company.
