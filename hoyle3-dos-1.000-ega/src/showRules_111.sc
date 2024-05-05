;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	showRules 0
)

(local
	local0
	local1
	local2
	local3
)

(instance showRules of Code
	(properties)

	(method (doit)
		(= local2 (gSystemWindow color:))
		(= local3 (gSystemWindow back:))
		(gSystemWindow color: 24 back: 28)
		(= local0 0)
		(while (!= local0 9)
			(switch local0
				(0
					(Format @global550 111 0) ; "The Object of Dominoes (Draw Game variation) is to play your hand in such a way that you have played all of your dominoes before your opponent."
				)
				(1
					(Format @global550 111 1) ; "A game of Dominoes consists of several hands of Dominoes. Players play to an agreed upon number of points (100-500)."
				)
				(2
					(Format @global550 111 2) ; "Each player takes from the Boneyard either 5 or 7 dominoes each (depending upon options settings) to begin their hand."
				)
				(3
					(Format @global550 111 3) ; "If the Option `Highest Doublet' is set to ON, then the player who has the highest doublet (both ends the same) begins the play. If OFF, then first play of the hand alternates between players."
				)
				(4
					(Format @global550 111 4) ; "There are two Forks that dominoes can be played on. The end of the domino being played from your hand must match the end of the last domino played on the Fork."
				)
				(5
					(Format @global550 111 5) ; "If a player has no possible play on either end, he must take dominoes from the Boneyard one at a time until a play is possible. If the `Must Play' option is set to OFF, then a player may take dominoes from the Boneyard at any time."
				)
				(6
					(Format @global550 111 6) ; "When the Boneyard has reached it's lower limit (either 0 or 2 dominoes left), no more dominoes can be taken from it. If a player still does not have a play on either Fork then the player must pass his turn."
				)
				(7
					(Format @global550 111 7) ; "The hand is over when either player has played the last domino from their hand, or both players pass sequentially without a play in-between. The hand score is then added to the cumulative Score."
				)
				(8
					(Format @global550 111 8) ; "Scoring: Each player adds up the value of the dominoes in their hand (one point per pip). The player who has less points in their hand scores the difference."
				)
			)
			(cond
				((== local0 0)
					(= local1
						(Print
							@global550
							81
							{Next}
							2
							81
							{___Cancel____}
							0
							70
							250
							1
						)
					)
				)
				((== local0 8)
					(= local1
						(Print @global550 81 {Prev} 1 81 {Cancel} 0 70 250 1)
					)
				)
				(else
					(= local1
						(Print
							@global550
							81
							{Next}
							2
							81
							{Prev}
							1
							81
							{Cancel}
							0
							70
							250
							1
						)
					)
				)
			)
			(switch local1
				(0
					(= local0 9)
				)
				(1
					(if (< (-= local0 1) 0)
						(= local0 0)
					)
				)
				(2
					(+= local0 1)
				)
			)
		)
		(gSystemWindow color: local2 back: local3)
		(DisposeScript 111)
	)
)

