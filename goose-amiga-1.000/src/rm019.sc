;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Game)
(use Actor)

(public
	rm019 0
)

(instance rm019 of Rm
	(properties
		picture 19
		style 0
		horizon 95
		north 12
		east 20
		south 26
	)

	(method (init)
		(Load rsVIEW 300)
		(Load rsVIEW 130)
		(Load rsVIEW 77)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(12
				(= global126 5)
				(cond
					((< (gEgo x:) 72)
						(gEgo posn: 4 118)
					)
					((> (gEgo x:) 228)
						(gEgo posn: 274 125 setPri: -1 edgeHit: EDGE_NONE)
					)
					(else
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 179) 24) 24) 131)
							y: 125
							edgeHit: EDGE_NONE
						)
					)
				)
			)
			(18
				(= global126 5)
				(if (> (gEgo y:) 122)
					(gEgo
						y:
							(if (<= (gEgo y:) horizon)
								(+ horizon 1)
							else
								(gEgo y:)
							)
					)
				else
					(gEgo posn: 4 118)
				)
			)
			(20
				(= global126 5)
				(gEgo
					x: 317
					y: (+ (/ (* (- (gEgo y:) 106) 5) 20) 123)
					edgeHit: EDGE_NONE
				)
			)
			(25
				(gEgo x: (+ (/ (* (- (gEgo x:) 244) 29) 15) 1))
			)
			(26
				(gEgo x: (+ (/ (* (- (gEgo x:) 17) 183) 42) 64))
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10 230 175)
		(if (not [global675 12])
			(peter init:)
		else
			(peterDone init: addToPic:)
			(wife init: addToPic:)
		)
		(gAddToPics
			add:
				pumpkins
				flower
				(cornstalk priority: 10)
				((Clone cornstalk) x: 125 y: 141 priority: 10)
				((Clone cornstalk) x: 98 y: 141 priority: 10)
				((Clone cornstalk) x: 73 y: 141 priority: 10)
				((Clone flower) loop: 1 cel: 2 x: 316 y: 176)
				((Clone flower) loop: 1 cel: 1 x: 316 y: 164)
				((Clone flower) loop: 2 cel: 0 x: 318 y: 155)
				((Clone flower) loop: 1 cel: 1 x: 305 y: 169)
				((Clone flower) loop: 1 cel: 0 x: 287 y: 172)
				((Clone flower) loop: 1 cel: 1 x: 295 y: 158)
				((Clone flower) loop: 0 cel: 0 x: 203 y: 144)
				((Clone flower) loop: 0 cel: 1 x: 258 y: 144)
				((Clone flower) loop: 1 cel: 1 x: 178 y: 142)
				((Clone flower) loop: 1 cel: 2 x: 272 y: 142)
				((Clone flower) loop: 1 cel: 2 x: 195 y: 142)
			eachElementDo: #init
			doit:
		)
	)

	(method (doit)
		(if (== (gEgo edgeHit:) EDGE_LEFT)
			(if (== global111 60)
				(gGlobalMGSound fade:)
			)
			(gCurRoom newRoom: 18)
		)
		(if (== (gEgo onControl: 1) 4)
			(if (== global111 41)
				(gGlobalMGSound fade:)
			)
			(self newRoom: 12)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 26) (< (gEgo x:) 38))
			(= newRoomNumber 25)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(= global126 35)
		(super dispose:)
	)
)

(instance flower of PicView
	(properties
		x 310
		y 182
		view 300
		loop 1
	)
)

(instance cornstalk of PicView
	(properties
		x 147
		y 141
		view 130
		loop 2
		cel 1
	)
)

(instance pumpkins of PicView
	(properties
		x 80
		y 104
		view 77
		loop 2
		cel 5
		priority 0
	)
)

(instance peter of PicView
	(properties
		x 105
		y 92
		view 77
		loop 2
		cel 6
		priority 1
	)
)

(instance peterDone of View
	(properties
		x 134
		y 96
		view 77
		loop 2
		cel 8
		priority 1
	)
)

(instance wife of View
	(properties
		x 151
		y 78
		view 77
		loop 2
		cel 7
		priority 1
	)
)

