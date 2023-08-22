;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm034 0
)

(instance rm034 of Rm
	(properties
		picture 34
		style 0
		horizon 100
		east 35
		picAngle 70
		vanishingY -99
	)

	(method (init)
		(Load rsVIEW 136)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(27
				(gEgo x: (+ (/ (* (- (gEgo x:) 62) 78) 64) 5))
			)
			(33
				(if (< (gEgo y:) 150)
					(gEgo x: 7 y: (+ (/ (* (- (gEgo y:) 101) 38) 43) 106))
				)
			)
			(35 0)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10 125 110)
		(if global131
			(water1 setCycle: Fwd cycleSpeed: 3 init:)
			(water2 setCycle: Fwd cycleSpeed: 3 init:)
			(water3 setCycle: Fwd cycleSpeed: 3 init:)
		else
			(gAddToPics add: water1 --UNKNOWN-PROPERTY--)
			(gAddToPics add: water2 --UNKNOWN-PROPERTY--)
			(gAddToPics add: water3 --UNKNOWN-PROPERTY--)
		)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) EDGE_TOP)
				(if (== global111 46)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 27)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(if (== global111 55)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 33)
			)
		)
		(super doit:)
	)
)

(instance water1 of Prop
	(properties
		y 179
		x 272
		view 136
		loop 2
	)
)

(instance water2 of Prop
	(properties
		y 176
		x 258
		view 136
		loop 3
	)
)

(instance water3 of Prop
	(properties
		y 189
		x 250
		view 136
		loop 2
	)
)

