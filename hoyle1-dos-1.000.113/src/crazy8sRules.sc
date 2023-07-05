;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 881)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	crazy8sRules 0
)

(instance crazy8sRules of Obj
	(properties)

	(method (doit &tmp [temp0 200])
		(gGame setCursor: 999)
		(gSysWindow setColor: 14 setBack: 1)
		(Print 881 0) ; "OBJECT: Be the first player to get rid of all of your cards."
		(Print 881 1) ; "PLAY: Match rank or suit with the top card of the discard pile, or play any Eight (wild card) to choose a new suit."
		(Print 881 2) ; "SCORING: The winner of each hand scores the average of points from all other players. Eights count as 50 points, face cards count 10, and all other cards count as their face value. The first player to reach 100 wins."
		(gSysWindow setColor: 12 setBack: 14)
	)
)

