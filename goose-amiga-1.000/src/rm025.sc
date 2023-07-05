;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Game)
(use Actor)

(public
	rm025 0
)

(instance rm025 of Rm
	(properties
		picture 25
		style 0
		horizon 99
		east 26
		west 24
		picAngle 75
		vanishingY -99
	)

	(method (init)
		(Load rsVIEW 145)
		(Load rsVIEW 300)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(17
				(gEgo x: (+ (/ (* (- (gEgo x:) 280) 18) 38) 58))
			)
			(18
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 83) 159) 77))
			)
			(19
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 15) 29) 244))
			)
			(24)
			(26)
			(31
				(gEgo x: (+ (/ (* (- (gEgo x:) 250) 68) 55) 1))
			)
			(32
				(if (and (> (gEgo x:) 150) (< (gEgo x:) 176))
					(gEgo x: 160)
				else
					(gEgo x: (+ (/ (* (- (gEgo x:) 132) 124) 93) 70))
				)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10 219 126)
		(gAddToPics
			add:
				(banburyCross priority: 5)
				flower
				((Clone flower) loop: 0 cel: 1 x: 6 y: 137)
				((Clone flower) loop: 1 cel: 1 x: 10 y: 129)
				((Clone flower) loop: 1 cel: 1 x: 45 y: 129)
				((Clone flower) loop: 1 cel: 1 x: 220 y: 178 priority: 14)
				((Clone flower) loop: 2 cel: 2 x: 233 y: 178 priority: 14)
			eachElementDo: #init
			doit:
		)
		(if (== gScore gPossibleScore)
			(proc0_14 160 110)
		)
	)

	(method (doit)
		(if (== (gEgo edgeHit:) 1)
			(cond
				((< (gEgo x:) 77)
					(gCurRoom newRoom: 17)
				)
				((> (gEgo x:) 243)
					(gCurRoom newRoom: 19)
				)
				(else
					(if (== global111 60)
						(gGlobalMGSound fade:)
					)
					(gCurRoom newRoom: 18)
				)
			)
		)
		(if (== (gEgo edgeHit:) 3)
			(if (< (gEgo x:) 70)
				(gCurRoom newRoom: 31)
			else
				(gCurRoom newRoom: 32)
			)
		)
		(super doit:)
	)
)

(instance banburyCross of PicView
	(properties
		x 164
		y 86
		view 145
		loop 3
		cel 1
	)
)

(instance flower of PicView
	(properties
		x 15
		y 140
		view 300
		cel 2
	)
)

