;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 884)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	ginRummyRules 0
)

(instance ginRummyRules of Obj
	(properties)

	(method (doit &tmp [temp0 200])
		(gGame setCursor: 999)
		(gSysWindow setColor: 14 setBack: 1)
		(Print 884 0) ; "OBJECT: Create sets of three or more cards within your hand. These sets should be grouped by rank or by a run of the same suit. (Example: Three Aces, or a run of the 5, 6, and 7 of Diamonds.) Try to have the lowest possible value of ungrouped cards (Deadwood) in your hand when you or the other player Knocks (ends the hand.)"
		(Print 884 1) ; "PLAY: Each player chooses a card either from the discard pile or the top of the deck, then discards one card from their own hand. This continues until one player has ten or less in Deadwood and chooses to Knock. If neither player has Knocked and only two cards remain in the deck, the hand ends in a draw."
		(Print 884 2) ; "KNOCKING: You may knock when you have ten points or less of Deadwood. Knock just before you discard a card. You are not required to Knock at any time."
		(Print 884 3) ; "SCORING: Face cards are ten points, all other cards count as their face value. The player with the lowest Deadwood scores the difference between his Deadwood and the other player's Deadwood, plus any bonus points. The winner is the first player to reach a designated score (usually 100 points.)"
		(Print 884 4) ; "PLAYING OFF: If a player Knocks and does not have Gin, he does not get points for any cards that his opponent has that can continue the grouped sets in the Knocking player's hand."
		(Print 884 5) ; "GIN: Gin is Knocking with no Deadwood, with all cards in the hand in completed sets. A player who Knocks with Gin receives a 25 point bonus."
		(Print 884 6) ; "UNDERCUT BONUS: If the non-Knocking player has equal or lower Deadwood than in the Knocking player's hand (except in a Gin hand), he receives a 25 point bonus in addition to the normal Deadwood points."
		(gSysWindow setColor: 12 setBack: 14)
	)
)

