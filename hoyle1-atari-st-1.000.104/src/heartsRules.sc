;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 883)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	heartsRules 0
)

(instance heartsRules of Obj
	(properties)

	(method (doit &tmp [temp0 200])
		(gGame setCursor: 999)
		(gSysWindow setColor: 14 setBack: 1)
		(Print 883 0) ; "OBJECT: Avoid capturing Hearts and the Queen of Spades. Alternatively, try to capture all Hearts and the Queen of Spades to "Shoot the Moon." When one player scores 100 points or more, the player with the lowest number of points is the winner."
		(Print 883 1) ; "PASSING CARDS: At the beginning of each hand (except a "No Pass" hand), choose three cards and pass them to the player indicated."
		(Print 883 2) ; "PLAY: The player who has the Two of Clubs leads first. All players must follow suit if possible, or else play any other card. The highest ranking card of the first suit played takes the trick. Then the winner of each trick (specific round of the hand) leads the next trick. A Heart may not be lead until Hearts have been broken (until a Heart has been played in a previous trick.) Aces are always high."
		(Print 883 3) ; "SCORING: All points should be considered negative. Each Heart captured in a hand counts for 1 point. The Queen of Spades counts for 13 points. If a player captures all Hearts and the Queen of Spades in the hand, this is "Shooting the Moon," and all other players in the game score 26 points."
		(gSysWindow setColor: 12 setBack: 14)
	)
)

