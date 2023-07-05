;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 552)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	spiderRegion 0
)

(instance spiderRegion of Rgn
	(properties)

	(method (init)
		(super init: &rest)
		(spider
			setLoop: 10
			cycleSpeed: 2
			ignoreActors: 1
			ignoreHorizon: 1
			init:
		)
	)
)

(instance spider of Act
	(properties
		y -100
		x -100
		view 452
		illegalBits 0
	)

	(method (init)
		(super init:)
		(if
			(or
				(and
					(IsFlag 19)
					(or
						(and
							(not (gEgo has: 6)) ; Brass_Bottle
							(!= ((gInventory at: 6) owner:) 200) ; Brass_Bottle
						)
						(and
							(not (gEgo has: 17)) ; Honeycomb
							(!= ((gInventory at: 17) owner:) 24) ; Honeycomb
						)
					)
				)
				(and (not (IsFlag 57)) (== global312 0))
			)
			(cond
				((and (== gCurRoomNum 24) (== gPrevRoomNum 25))
					(HandsOff)
					(self setScript: plantEats)
				)
				((and (== gCurRoomNum 26) (== gPrevRoomNum 22))
					(plantEats register: 1)
					(HandsOff)
					(self setScript: plantEats)
				)
				((& (Random 0 99) $0001)
					(self setScript: spiderKill)
				)
			)
		)
	)
)

(instance spiderKill of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (spider mover:)
			(DrawCel 452 11 0 (spider x:) (- (spider y:) 14) (spider priority:))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(if (not (gCurRoom script:))
					(HandsOff)
					(spider
						posn: (gEgo x:) 0
						setCycle: Fwd
						setPri: (+ (gEgo priority:) 1)
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 33) self
					)
					(gGlobalSound2 number: 785 loop: 1 play:)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(cls)
				(gGlobalSound2 stop:)
				(= global330
					{It looks like Graham will be hanging around here for awhile.}
				)
				(EgoDead 452 12)
			)
		)
	)
)

(instance plantEats of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (User canControl:)
			(HandsOff)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 30)
			)
			(1
				(gGlobalSound2 number: 785 loop: 1 play:)
				(plant1 init: cycleSpeed: 5 setCycle: End self)
				(gEgo moveSpeed: 2)
				(if register
					(gEgo setMotion: MoveTo 185 98)
					(plant1 loop: register x: 260 y: 85)
					(plant2 loop: register x: 255 y: 100)
				else
					(gEgo setMotion: MoveTo 100 165)
				)
			)
			(2
				(if (not register)
					(gEgo
						setMotion:
							MoveTo
							(- (gEgo x:) 10)
							(- (gEgo y:) 5)
							self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(plant2 init: cycleSpeed: 5 setCycle: End self)
			)
			(4
				(if register
					(gEgo setMotion: MoveTo (gEgo x:) (- (gEgo y:) 3))
				)
				(plant1 setCycle: CT 4 -1 self)
			)
			(5
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 465
					y: (+ (gEgo y:) 1)
					setLoop: 2
					cel: 0
					setMotion: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(6
				(= cycles 15)
			)
			(7
				(gEgo
					normal: 1
					view: 0
					cycleSpeed: 0
					setCycle: Walk
					setLoop: -1
				)
				((gEgo head:) show:)
				(if register
					(plant2 setCycle: CT 4 -1 self)
					(gEgo
						setMotion: MoveTo (+ (gEgo x:) 18) (+ (gEgo y:) 4)
					)
				else
					(plant2 setCycle: CT 3 -1 self)
					(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 8))
				)
			)
			(8
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 465
					y: (+ (gEgo y:) 1)
					setLoop: 3
					cel: 0
					setMotion: 0
				)
				(= seconds 4)
			)
			(9
				(gGlobalSound2 stop:)
				(= global330
					{It looks like Graham is having a "vine" time now.}
				)
				(EgoDead 253)
			)
		)
	)
)

(instance plant1 of Prop
	(properties
		y 155
		x 170
		view 465
	)
)

(instance plant2 of Prop
	(properties
		y 175
		x 143
		view 465
	)
)

