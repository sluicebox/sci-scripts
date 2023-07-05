;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Game)

(public
	rm016 0
)

(instance rm016 of Rm
	(properties
		picture 16
		style 0
		horizon 94
		north 9
		east 17
		picAngle 70
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(9 4)
					(15 2)
					(23 5)
					(17 3)
					(else 7)
				)
		)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(9
				(gEgo x: (+ (/ (* (- (gEgo x:) 0) 31) 27) 0))
			)
			(15
				(gEgo y: (+ (/ (* (- (gEgo y:) 88) 93) 100) 95))
			)
			(17
				(if (and (> (gEgo y:) 122) (< (gEgo y:) 134))
					(gEgo y: 120)
				else
					(gEgo y: (+ (/ (* (- (gEgo y:) 106) 63) 27) 95))
				)
			)
			(22
				(gEgo x: (+ (/ (* (- (gEgo x:) 270) 50) 48) 1))
			)
			(23
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 19) 32) 51))
			)
			(24
				(gEgo
					setPri: -1
					x: (+ (/ (* (- (gEgo x:) 1) 53) 29) 240)
					y: 188
				)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10 50 160)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) 4)
				(if (== global111 58)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 15)
			)
			((== (gEgo edgeHit:) 3)
				(cond
					((< (gEgo x:) 51)
						(gCurRoom newRoom: 22)
					)
					((> (gEgo x:) 239)
						(gCurRoom newRoom: 24)
					)
					(else
						(gCurRoom newRoom: 23)
					)
				)
			)
		)
		(super doit:)
	)
)

