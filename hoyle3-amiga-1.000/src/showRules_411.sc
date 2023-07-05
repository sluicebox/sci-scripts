;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 411)
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

	(method (doit &tmp [temp0 10] [temp10 10] [temp20 10])
		(= local2 (gSystemWindow color:))
		(= local3 (gSystemWindow back:))
		(gSystemWindow color: 24 back: 28)
		(= local0 0)
		(while (!= local0 11)
			(switch local0
				(0
					(Format @global550 499 13) ; "Pachisi is an ancient game from India where the object is to race all of your pieces around the board and be the first to get them all `Home'. Hoyle 3 Pachisi can be played using dice or shells. The rules for dice will be explained first."
				)
				(1
					(Format @global550 499 14) ; "Pieces are entered onto the board with a roll of a one on either of the dice. Whether a piece is moved onto the board or not is optional as long as you can move another piece instead. Moves cannot be passed if pieces can move."
				)
				(2
					(Format @global550 499 15) ; "On a normal roll, two pieces may be moved according to the value on each of the dice. For example: On a roll of 5 3, you may move one piece five spaces and then another piece three spaces. The second piece may be the same piece as the first."
				)
				(3
					(Format @global550 499 16) ; "When a player rolls a double on the dice, that player may move in the normal fashion and then roll again. However, If three doubles are rolled consecutively, the third roll is lost and the turn is over immediately."
				)
				(4
					(Format @global550 499 17) ; "When a piece lands on a space occupied by an opponents piece, the opponents piece is sent `Home' and must be reentered again with the roll of a one at some later time."
				)
				(5
					(Format @global550 499 18) ; "If a piece lands on a space that has its own piece on it, then those two pieces form a Blockade. No pieces may land on or pass a Blockade including pieces of its own color. Blockades may not be advanced together when a double is rolled."
				)
				(6
					(Format @global550 499 19) ; "Pieces must reach home by exact roll. Pieces may pass their Home aisle and go around the board again. (Useful for hitting a player who is about to win)."
				)
				(7
					(Format @global550 499 20) ; "When shells are used instead of dice, the remaining rules apply. One piece per turn is moved the value of the shells each turn instead of two. The shells land either face up or face down. The combination of the shells are valued as follows:"
				)
				(8
					(Format @global550 499 21) ; "2 shells up: move 2, 3 shells up: move 3 4 shells up: move 4, 5 shells up: move 5 6 shells up: move 6 and another throw 1 shell up: move 10 and another throw 0 shells up: move 25 and another throw"
				)
				(9
					(Format @global550 499 22) ; "A piece can be entered into play with a roll of a three. On the third consecutive time that a player earns another throw (by throwing a 6, 1, or 0), the third throw is not moved and is lost."
				)
				(10
					(Format @global550 499 23) ; "Since there is no such thing as a roll of a one when using shells, a piece that is one space away from home may be moved home on a roll of a two."
				)
			)
			(cond
				((== local0 0)
					(Format @temp0 499 24) ; "Next"
					(Format @temp20 499 25) ; "Cancel"
					(= local1
						(Print @global550 81 @temp0 2 81 @temp20 0 70 250 1)
					)
				)
				((== local0 10)
					(Format @temp10 499 26) ; "Prev"
					(Format @temp20 499 27) ; "Cancel"
					(= local1
						(Print @global550 81 @temp10 1 81 @temp20 0 70 250 1)
					)
				)
				(else
					(Format @temp0 499 24) ; "Next"
					(Format @temp10 499 26) ; "Prev"
					(Format @temp20 499 27) ; "Cancel"
					(= local1
						(Print
							@global550
							81
							@temp0
							2
							81
							@temp10
							1
							81
							@temp20
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
					(= local0 11)
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
		(DisposeScript 411)
	)
)

