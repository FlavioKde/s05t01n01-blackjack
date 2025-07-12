# 🃏 Business Logic Documentation - Blackjack Game

## 🎯 Game Objective

Blackjack is a card game where the player competes against Dealer (the bank). The objective is to add the closest possible value to 21 without passing. If the player surpasses Dealer without going from 21, he wins the game.

## 👥 Main entities

- ** Player **: It has name, hand (letters), bet, current state.
- ** Dealer **: Banking hand. Play with fixed rules (steal up to 17).
- ** Letter **: It has a stick, value, name (eg, "as of hearts").
- ** Baraja **: Set of letters available to distribute.
- ** Item **: Current state of the game and active dealer.
- ** Bet **: Value bet on the player in the game.

## 🔁 General Game Flow

1. ** Home **: A new game is created, the cards are considered.
2. ** Initial cast **: Two cards are distributed to the player and two to the dealer (a mouth down).
3. ** Player's turn **: 
- You can choose *"ask for a letter" *, *"plant" *or *"duplicate" *. 
- If it exceeds 21, it automatically loses (*"passes"*).
4. ** Dealer turn **: 
- Steal cards until you reach at least 17 points. 
- If you pass, the player wins.
5. ** Result **: 
- Wins who is closer to 21 without passing. 
- If there is a tie (the same score), the game is canceled.

## 📐 Letters value rules

- Numerical letters: value equal to number.
- Figures (J, Q, K): They are worth 10.
- As: 1 or 11 can be worth, as appropriate.

## ⚠️ Special cases

- ** Blackjack Natural **: AS + letter of value 10 in the first hand.
- ** ATTACK **: If player and dealer have the same final hand.
- ** Canceled item **: If the deck is empty or the system fails.

## 💾 Persistence

- Mongodb: History of games, letters plays, game states.
- MYSQL: Registered users, betting data, statistics.

---

*This documentation can be expanded with examples of the game, diagrams and detailed explanation of each action. Last update: July 2025.*
Enviar comentarios
Paneles laterales
Historial
Guardado