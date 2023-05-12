# Virtual-Casino 
This project si a virtual version of casino and contain black jack, slot machine and horse run

## Site presentation
[Web Site](https://alessiodevv.github.io/Virtual-Casino/)

## Rules
- Creando un account confermi di aver raggiunto la maggior età
- Per creare un account serve inserire la carta di credito
- Esistono 4 sezioni
```
     |-- Shop
          |-- E' possibile effettuare l'acquisto di Fish scegliendo tra 3 pacchetti diversi
     |-- Slot Machine
          |-- E' possibile effettuare la puntata nella casella apposita e attraverso il bottone gioca si fa iniziare la giocata
               |-- Ogni vittoria equivale al raddoppio della puntata
               |-- La vittoria é decisa da 11 combinazioni possibili
               |-- Se si trova la testa di Shrek si ha un bonus equivalente a un x10 della puntata
     |-- Corsa Cavalli
          |-- E' possibile effettuare la puntata nella casella apposita, inserire nell'apposita casella il cavallo su cui si vuole scommettere e attraverso il bottone gioca si fa iniziare la partita
               |-- In caso di vittoria la puntata verra raddoppiata e accreditata al saldo utente
     |-- BlackJack
          |-- É possibile effettuare la puntata attraverso l'aposita casella e premento il pulsante Gioca si darà inizio alla partita
          |-- Durante il gioco vi è possibile effettuare delle azioni grazie ai pulsanti dedicati, come ad esempio "Hit"
          |-- Il banco termina il turno nel momento in cui il suo valore delle carte e maggiore o uguale a 17 
          |-- I casi di vottoria sono 2
               |-- Se con il tuo valore delle carte superi il valore del banco fino a un massimo di 21
               |-- Se il banco supera 21
          |-- Si può pareggiare se il banco ha lo stesso valore di carte delle tue
```
- Si può effettuare il LogOut

## Structure
```
.
|-- lib/
|-- out/
|-- src/
     |-- App/
          |-- VirtualCasino.java
     |-- assets/
          |-- img, txt...
     |-- auth/
          |-- Access.java
     |-- backend/
          |-- blackJack/
          |-- slotMachine/
          |-- jsonEdit/
          |-- corsaCavalli/
          |-- auth/
     |-- blackJack/
          |-- BlackJack.java
     |-- corsaCavalli/
          |-- CorsaCavalli.java
     |-- Menu/
          |-- Menu.java
     |-- shopPage/
          |-- ShopPage.java
     |-- slotMachine/
          |-- SlotMachine.java
|-- JavaDock/
|-- README.md
```

## Documentation
Link a [Java Doc](https://alessiodevv.github.io/Virtual-Casino/JavaDoc/)
