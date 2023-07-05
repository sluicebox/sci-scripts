;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Game)

(public
	rm014 0
)

(instance rm014 of Rm
	(properties
		picture 14
		style 0
		horizon 126
		south 21
		west 13
		picAngle 70
	)

	(method (init)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(7
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 14) 10) 1))
			)
			(13
				(gEgo y: (+ (/ (* (- (gEgo y:) 120) 61) 68) 127))
			)
			(21
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 136) 65) 1) setPri: -1)
			)
			(else
				(gEgo posn: 160 135)
			)
		)
		(gEgo init:)
		(proc0_10 95 160)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) 4)
				(if (== global111 47)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 13)
			)
			((== (gEgo edgeHit:) 1)
				(if (== global111 48)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 7)
			)
		)
		(super doit:)
	)
)

