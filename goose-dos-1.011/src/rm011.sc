;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm011 0
)

(local
	local0
	local1
)

(instance rm011 of Rm
	(properties
		picture 11
		style 0
		horizon 123
		north 4
		east 12
		west 10
		picAngle 70
		vanishingY 50
	)

	(method (init)
		(Load rsVIEW 138)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(3
				(gEgo x: (+ (/ (* (- (gEgo x:) 278) 20) 38) 33))
			)
			(4
				(cond
					((< (gEgo x:) 44)
						(gEgo x: (+ (/ (* (- (gEgo x:) 6) 27) 36) 54))
					)
					((< (gEgo x:) 222)
						(gEgo x: (+ (/ (* (- (gEgo x:) 93) 84) 127) 118))
					)
					(else
						(gEgo x: (+ (/ (* (- (gEgo x:) 275) 24) 39) 239))
					)
				)
			)
			(5
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(gEgo x: (+ (/ (* (- (gEgo x:) 3) 17) 40) 264))
			)
			(10
				(gEgo
					setPri: -1
					y: (+ (/ (* (- (gEgo y:) 138) 50) 51) 139)
				)
			)
			(12
				(gEgo y: (+ (/ (* (- (gEgo y:) 170) 49) 19) 140))
			)
			(18 0)
			(else
				(gEgo posn: 160 125)
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
			)
		)
		(gEgo init:)
		(proc0_10 95 150)
		(if global131
			(flag1 init:)
			(flag2 init:)
		else
			(flag1 init: addToPic:)
			(flag2 init: addToPic:)
		)
	)

	(method (doit)
		(if (== (gEgo edgeHit:) EDGE_BOTTOM)
			(if (== global111 60)
				(gGlobalMGSound fade:)
			)
			(gCurRoom newRoom: 18)
		)
		(super doit:)
		(if (!= (= local0 (gEgo onControl: 1)) local1)
			(= local1 local0)
			(switch local0
				(2
					(self newRoom: 3)
				)
				(4
					(gGlobalMGSound fade:)
					(self newRoom: 5)
				)
				(else 0)
			)
		)
	)
)

(instance flag1 of Prop
	(properties)

	(method (init)
		(self view: 138 loop: 0 posn: 115 9 cycleSpeed: 2 setCycle: Fwd)
		(super init:)
	)
)

(instance flag2 of Prop
	(properties)

	(method (init)
		(self view: 138 loop: 0 cel: 2 posn: 214 10 cycleSpeed: 2 setCycle: Fwd)
		(super init:)
	)
)

