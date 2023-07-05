;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm030 0
)

(instance rm030 of Rm
	(properties
		picture 30
		style 0
		horizon 94
		north 23
		east 31
		west 29
		picAngle 70
		vanishingY -99
	)

	(method (init)
		(Load rsVIEW 136)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(23
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 53) 40) 1))
			)
			(29
				(gEgo y: (+ (/ (* (- (gEgo y:) 99) 63) 59) 95))
			)
			(31
				(gEgo y: (+ (/ (* (- (gEgo y:) 101) 79) 67) 95))
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo
			y:
				(if (<= (gEgo y:) horizon)
					(+ horizon 1)
				else
					(gEgo y:)
				)
		)
		(gEgo init:)
		(proc0_10 205 145)
		(if global131
			(water1 setCycle: Fwd cycleSpeed: 3 init:)
		else
			(water1 init: addToPic:)
		)
	)

	(method (doit)
		(if (== (gEgo edgeHit:) 1)
			(if (== global111 45)
				(gGlobalMGSound fade:)
			)
			(gCurRoom newRoom: 23)
		)
		(super doit:)
	)
)

(instance water1 of Prop
	(properties
		x 287
		y 189
		view 136
		loop 3
	)
)

