;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 885)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	cribbageRules 0
)

(instance cribbageRules of Obj
	(properties)

	(method (doit &tmp [temp0 200])
		(gGame setCursor: 999)
		(gSysWindow setColor: 14 setBack: 1)
		(Print 885 0) ; "OBJECT: Race your opponent to the last hole in the cribbage board. Form certain card combinations which are worth points in the hand, crib, and during play, which will help you to out-peg your opponent."
		(Print 885 1) ; "DISCARDING THE CRIB: Before the play of each hand, each player chooses 2 cards from his hand to go into the Crib hand. The Crib hand belongs to the dealer and is used later."
		(Print 885 2) ; "PLAY: Play any card, unless that card would bring the count over 31, in which case you have to tell your opponent `Go.'"
		(Print 885 3) ; "COUNTING HANDS: Non-dealer counts his hand first, and pegs his points. Then the dealer counts and pegs his hand. Then the dealer counts and pegs for his Crib hand."
		(Print 885 4) ; "SCORING: A game is the first player to peg 121 points. A Match is the first to win 7 game points. One win equals 1 game point. A skunk, or winning by more than 30, is worth 2 game points. A double skunk, or winning by more than 60, is worth 4 game points."
		(Print 885 5) ; "Please see HOYLE'S RULES OF GAMES for complete rules."
		(gSysWindow setColor: 12 setBack: 14)
	)
)

