;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 211)
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
		(while (!= local0 7)
			(switch local0
				(0
					(Format @global550 211 0) ; "Checkers is an ancient game of strategy where opponents try to capture all of the other players' pieces or render them immobile."
				)
				(1
					(Format @global550 211 1) ; "Each player has 12 checkers (called pawns) which may only move forward on the diagonals. When a pawn advances to the opponent's back row, that pawn becomes a King and may now move backwards on the diagonals as well as forward."
				)
				(2
					(Format @global550 211 2) ; "Pieces may move to empty squares only. All pieces move only 1 space at a time unless you can make a jump (a capture), in which case you may move two spaces to the empty space just beyond the opponent's piece. Pieces which are jumped are removed from the board."
				)
				(3
					(Format @global550 211 3) ; "After a jump, if there is another jump that can be made by the same piece that did the jumping, the player must also jump the next piece and so on until there are no more jumps."
				)
				(4
					(Format @global550 211 4) ; "It is not allowable to continue a jump in which a pawn was made into a King. The move stops at the king row."
				)
				(5
					(Format @global550 211 5) ; "If a piece CAN make a jump, then the piece MUST make a jump (unless this option is turned off while two human players are playing). If there is more than one jump that can be made, the player may choose which jump to make."
				)
				(6
					(Format @global550 211 6) ; "If at any time, a player is blocked so that he cannot make any move (a stalemate), then the player who cannot move loses the game."
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
				((== local0 6)
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
					(= local0 7)
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
		(DisposeScript 211)
	)
)

