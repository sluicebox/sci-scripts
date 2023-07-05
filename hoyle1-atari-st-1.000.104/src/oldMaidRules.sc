;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 882)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	oldMaidRules 0
)

(instance oldMaidRules of Obj
	(properties)

	(method (doit &tmp [temp0 200])
		(gGame setCursor: 999)
		(gSysWindow setColor: 14 setBack: 1)
		(Print 882 0) ; "OBJECT: Avoid capturing the Old Maid at the end of the hand."
		(Print 882 1) ; "PLAY: Each player removes all pairs from his hand when all cards have been dealt. Then each player in turn chooses a card from the player on his right, removing any pair in his hand that is created when he takes that card. The game ends when only one card is left in play: the Old Maid."
		(gSysWindow setColor: 12 setBack: 14)
	)
)

