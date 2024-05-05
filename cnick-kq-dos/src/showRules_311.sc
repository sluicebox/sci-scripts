;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 311)
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
	(properties
		sel_20 {showRules}
	)

	(method (sel_57)
		(= local2 (gSystemWindow sel_25:))
		(= local3 (gSystemWindow sel_26:))
		(gSystemWindow sel_25: 24 sel_26: 28)
		(= local0 0)
		(while (!= local0 20)
			(switch local0
				(0
					(Format @global550 399 36) ; "The object of Backgammon is to be the first to move all one's pieces `Home'. One player moves his pieces in a clockwise direction and the other player moves his pieces in a counterclockwise direction. Pieces may never move backwards."
				)
				(1
					(Format @global550 399 37) ; "The first player is decided by a roll of the dice. In subsequent games, the loser of the previous game plays first."
				)
				(2
					(Format @global550 399 38) ; "Pieces advance from one point to another corresponding to the numbers on the dice. One piece may move twice (or up to 4 times in the case of doublets), or different pieces may be moved for each of the dice."
				)
				(3
					(Format @global550 399 39) ; "Whenever a player rolls Doubles on the dice, then twice the number of pieces may be moved. Thus from one to four pieces can be moved when doubles are rolled."
				)
				(4
					(Format @global550 399 40) ; "Pieces may not land on a point which has two or more opponent's pieces, thus that point is Blocked. Pieces may however jump over blocked points. There is no limit to the number of your pieces that can occupy a single point."
				)
				(5
					(Format @global550 399 41) ; "When one of your pieces lands on a point which has only one opponent's piece on it (called a Blot), then that Blot is `Hit' and sent to the `Bar' and must be reentered in the quadrant of the board furthest away from your `Home'."
				)
				(6
					(Format @global550 399 42) ; "No other piece may be moved while any of your pieces are on the `Bar'. A player must play all possible dice if he can. When this is not possible, the player must play as much of his turn as possible and passes the rest of his turn."
				)
				(7
					(Format @global550 399 43) ; "If only one number on the dice can be played but not both, then the higher of the two numbers must be played."
				)
				(8
					(Format @global550 399 44) ; "All of your pieces must be in the quadrant of the board closest to `Home' before actually moving any piece from the board into your `Home' container."
				)
				(9
					(Format @global550 399 45) ; "Pieces are not forced `Home' but may be moved elsewhere if they can. Pieces do not have to land `Home' by exact count, but in that case, the piece furthest away from `Home' possible must be moved."
				)
				(10
					(Format @global550 399 46) ; "The player who removes all his pieces first wins one game. Then, if the opponent has not removed any pieces you score 1 additional game point for `Gammon'."
				)
				(11
					(Format @global550 399 47) ; "Additionally, if your opponent still has any piece either on the `Bar' or in your `Home' quadrant, you win 1 more additional game point for `BackGammon'."
				)
				(12
					(Format @global550 399 48) ; "Doubling Cube: The use of the doubling cube is optional. At the start of each turn a player may `Double' the stakes of the game by calling a `Double'."
				)
				(13
					(Format @global550 399 49) ; "The opponent then may decide to accept the doubled stakes of the game and play on or may decline the doubled stakes and accept the loss of the game immediately at the previous stakes."
				)
				(14
					(Format @global550 399 50) ; "The Doubled stakes applies also to Gammons and Backgammons. In Hoyle 3, players may continue redoubling until the stakes are at 64 times normal."
				)
				(15
					(Format @global550 399 51) ; "If a Double is accepted, the Doubling Cube is under the control of the player who accepted the Double, and only he may offer the next `Double' in that game if and when it is desired."
				)
				(16
					(Format @global550 399 52) ; "A Player scores a Gammon when he has removed all of his pieces from the board before his opponent has removed any of his pieces. Gammons are worth 2 X game points."
				)
				(17
					(Format @global550 399 53) ; "A Player scores Backgammon when all of his pieces are removed before his opponent has removed any AND while his opponent still has a piece on the Bar or in your Inner Table. Backgammons are worth 3 X game points."
				)
			)
			(cond
				((== local0 0)
					(= local1
						(Print
							@global550
							78
							{Next}
							2
							78
							{___Cancel____}
							0
							67
							250
							1
						)
					)
				)
				((== local0 19)
					(= local1
						(Print @global550 78 {Prev} 1 78 {Cancel} 0 67 250 1)
					)
				)
				(else
					(= local1
						(Print
							@global550
							78
							{Next}
							2
							78
							{Prev}
							1
							78
							{Cancel}
							0
							67
							250
							1
						)
					)
				)
			)
			(switch local1
				(0
					(= local0 20)
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
		(gSystemWindow sel_25: local2 sel_26: local3)
		(DisposeScript 311)
	)
)

