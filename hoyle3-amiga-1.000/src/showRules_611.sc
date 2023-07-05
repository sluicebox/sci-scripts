;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 611)
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
		(while (!= local0 3)
			(switch local0
				(0
					(Format @global550 699 5) ; "The object of Snakes and Ladders is to be the first to climb to the last square on the board."
				)
				(1
					(Format @global550 699 6) ; "Each player in turn spins the spinner and then moves their child the number of spaces shown on the spinner. If the Star Option is ON, you will see a gold star where the child is to move to."
				)
				(2
					(Format @global550 699 7) ; "When a child moves to a square that has the bottom of a ladder in it, the child climbs the ladder. When a child moves to a square that has an end of a snake in it, the child slides down the snake."
				)
			)
			(cond
				((== local0 0)
					(Format @temp0 699 8) ; "Next"
					(Format @temp20 699 9) ; "Cancel"
					(= local1
						(Print @global550 81 @temp0 2 81 @temp20 0 70 250 1)
					)
				)
				((== local0 2)
					(Format @temp10 699 11) ; "Prev"
					(Format @temp20 699 10) ; "Cancel"
					(= local1
						(Print @global550 81 @temp10 1 81 @temp20 0 70 250 1)
					)
				)
				(else
					(Format @temp0 699 8) ; "Next"
					(Format @temp10 699 11) ; "Prev"
					(Format @temp20 699 10) ; "Cancel"
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
					(= local0 3)
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
		(DisposeScript 611)
	)
)

