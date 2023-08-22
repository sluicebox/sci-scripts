;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm022 0
)

(instance rm022 of Rm
	(properties
		picture 22
		style 0
		horizon 110
		south 29
		picAngle 70
	)

	(method (init)
		(Load rsVIEW 320)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(15
				(gEgo x: (+ (/ (* (- (gEgo x:) 17) 17) 30) 80))
			)
			(16
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 18) 50) 300))
			)
			(23
				(gEgo y: (+ (/ (* (- (gEgo y:) 101) 77) 87) 111))
			)
			(29
				(gEgo x: (+ (/ (* (- (gEgo x:) 131) 52) 37) 54))
				(gEgo y: 185)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(if (and (> (gEgo y:) 157) (< (gEgo y:) 169))
			(gEgo y: 170)
		)
		(if global131
			(smoke init:)
		else
			(smoke init: addToPic:)
		)
		(gEgo init:)
		(proc0_10 210 155)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(if (== global111 45)
					(gGlobalMGSound fade:)
					(if (< (gEgo y:) 143)
						(gEgo y: 144)
					)
				)
				(gCurRoom newRoom: 23)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(if (< (gEgo x:) 270)
					(if (== global111 58)
						(gGlobalMGSound fade:)
					)
					(gCurRoom newRoom: 15)
				else
					(gCurRoom newRoom: 16)
				)
			)
		)
		(super doit:)
	)
)

(instance smoke of Prop
	(properties
		signal 16384
	)

	(method (init)
		(super init:)
		(self
			view: 320
			setLoop: 1
			posn: 135 20
			cycleSpeed: 2
			setPri: 1
			setCycle: Fwd
		)
	)
)

