;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Game)
(use Actor)

(public
	rm006 0
)

(instance rm006 of Rm
	(properties
		picture 6
		style 0
		horizon 85
		east 7
		west 5
		picAngle 70
	)

	(method (init)
		(Load rsVIEW 300)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(5
				(gEgo
					setPri: -1
					y: (+ (/ (* (- (gEgo y:) 109) 73) 55) 116)
					x: 10
				)
			)
			(7
				(gEgo y: (+ (/ (* (- (gEgo y:) 113) 59) 77) 131))
			)
			(12
				(gEgo setPri: -1 x: (+ (/ (* (- (gEgo x:) 283) 76) 35) 1))
			)
			(13
				(cond
					((< (gEgo x:) 75)
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 1) 99) 73) 78)
							y: 187
						)
					)
					((< (gEgo x:) 137)
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 79) 60) 51) 177)
							y: 187
						)
					)
					(else
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 253) 81) 65) 237)
							y: 187
						)
					)
				)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(if (and (not [global675 5]) (!= gPrevRoomNum 7) (!= gPrevRoomNum 13))
			(gGlobalMGSound number: 1 priority: 5 loop: -1)
			(if (== global208 0)
				(gGlobalMGSound play:)
			)
		)
		(gEgo init:)
		(proc0_10 85 160)
		(gAddToPics
			add:
				flower
				((Clone flower) loop: 8 cel: 2 x: 202 y: 167)
				((Clone flower) loop: 8 cel: 2 x: 207 y: 169)
				((Clone flower) loop: 7 cel: 1 x: 132 y: 153 priority: 11)
				((Clone flower) loop: 8 cel: 0 x: 299 y: 129)
			eachElementDo: #init
			doit:
		)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(if (== global111 48)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 7)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(if (not [global675 5])
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 5)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(if (< (gEgo x:) 78)
					(gCurRoom newRoom: 12)
				else
					(if (== global111 47)
						(gGlobalMGSound fade:)
					)
					(gCurRoom newRoom: 13)
				)
			)
		)
		(super doit:)
	)
)

(instance flower of PicView
	(properties
		x 212
		y 171
		view 300
		loop 7
		cel 2
	)
)

