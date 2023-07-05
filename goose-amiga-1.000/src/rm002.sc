;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Game)

(public
	rm002 0
)

(instance rm002 of Rm
	(properties
		picture 2
		style 0
		horizon 95
		east 3
		west 1
		picAngle 75
	)

	(method (init)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(1
				(gEgo y: (+ (/ (* (- (gEgo y:) 107) 54) 83) 136))
			)
			(3
				(gEgo posn: 296 181)
			)
			(8
				(gEgo x: (+ (/ (* (- (gEgo x:) 189) 62) 129) 1))
			)
			(9
				(gEgo posn: 296 181)
			)
			(10
				(gEgo posn: 296 181)
			)
			(else
				(gEgo posn: 160 125)
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
			)
		)
		(gEgo init:)
		(proc0_10 95 135)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) 3)
				(if (< (gEgo x:) 64)
					(gCurRoom newRoom: 8)
				else
					(gCurRoom newRoom: 9)
				)
			)
			((== (gEgo edgeHit:) 4)
				(if (== global111 56)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 1)
			)
		)
		(super doit:)
	)
)

