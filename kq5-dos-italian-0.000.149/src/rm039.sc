;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Motion)
(use Actor)
(use System)

(public
	rm039 0
)

(instance rm039 of KQ5Room
	(properties
		picture 39
		east 35
		west 92
	)

	(method (init)
		(super init:)
		(self setRegions: 763) ; cartoonRegion
		(gEgo
			view: 564
			posn: -18 32
			normal: 0
			moveSpeed: 3
			cycleSpeed: 3
			xStep: 2
			yStep: 1
			init:
			setPri: 6
		)
		((gEgo head:) hide:)
		(wolf xStep: 2 yStep: 1 init:)
		(if (and (== ((gInventory at: 2) owner:) 36) (== gPrevRoomNum 92)) ; Pie
			(owl init:)
		)
		(if (== gPrevRoomNum 92)
			(self setScript: egoWalkingEast)
		else
			(self setScript: egoWalkingWest)
		)
		(gGlobalSound number: 5 loop: -1 play:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
		)
		(wolf
			moveSpeed: (gGame egoMoveSpeed:)
			cycleSpeed: (gGame egoMoveSpeed:)
		)
		(owl
			moveSpeed: (gGame egoMoveSpeed:)
			cycleSpeed: (gGame egoMoveSpeed:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)
)

(instance wolfWalkingEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(wolf setCycle: Walk setLoop: 0 setMotion: MoveTo 175 90 self)
			)
			(2
				(wolf setLoop: 1 setMotion: MoveTo 153 105 self)
			)
			(3
				(wolf setLoop: 4 setMotion: MoveTo 194 121 self)
			)
			(4
				(wolf setMotion: MoveTo 236 130 self)
			)
			(5
				(wolf setMotion: MoveTo 279 138 self)
			)
			(6
				(wolf setMotion: MoveTo 349 139 self)
			)
			(7
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance owlFlyingEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(owl
					setCycle: Walk
					moveSpeed: 3
					cycleSpeed: 3
					setLoop: 0
					setMotion: MoveTo 319 149 self
				)
			)
			(2
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance wolfWalkingWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(wolf
					setLoop: 5
					setCycle: Walk
					posn: 336 137
					setMotion: MoveTo 270 136 self
				)
			)
			(2
				(wolf setMotion: MoveTo 199 123 self)
			)
			(3
				(wolf setMotion: MoveTo 152 105 self)
			)
			(4
				(wolf posn: 155 95 setLoop: 7 setMotion: MoveTo 176 81 self)
			)
			(5
				(wolf setLoop: 6 posn: 177 75 setMotion: MoveTo 131 57 self)
			)
			(6
				(wolf setMotion: MoveTo 90 44 self)
			)
			(7
				(wolf setMotion: MoveTo 60 38 self)
			)
			(8
				(wolf setMotion: MoveTo 29 28 self)
			)
			(9
				(wolf setMotion: MoveTo -27 21 self)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance egoWalkingEast of Script
	(properties)

	(method (doit)
		(gEgo priority: (- (wolf priority:) 1))
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 20)
			)
			(1
				(gEgo setCycle: KQ5SyncWalk setMotion: MoveTo 52 47 self)
			)
			(2
				(gEgo setMotion: MoveTo 105 63 self)
			)
			(3
				(gEgo setMotion: MoveTo 163 84 self)
			)
			(4
				(gEgo setMotion: MoveTo 188 92 self)
			)
			(5
				(gEgo setMotion: MoveTo 139 113 self)
			)
			(6
				(gEgo setMotion: MoveTo 180 117 self)
			)
			(7
				(gEgo setMotion: MoveTo 217 124 self)
			)
			(8
				(gEgo setMotion: MoveTo 259 132 self)
			)
			(9
				(gEgo setMotion: MoveTo 337 137 self)
			)
			(10
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance egoWalkingWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 55)
			)
			(1
				(gEgo
					posn: 328 139
					setLoop: 5
					setCel: 0
					setCycle: KQ5SyncWalk
					setPri: 1
					setMotion: MoveTo 275 136 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 219 126 self)
			)
			(3
				(gEgo setMotion: MoveTo 181 118 self)
			)
			(4
				(gEgo setMotion: MoveTo 149 113 self)
			)
			(5
				(gEgo
					setCel: 0
					setLoop: 7
					setCycle: KQ5SyncWalk
					setMotion: MoveTo 190 98 self
				)
			)
			(6
				(gEgo
					setCel: 0
					setLoop: 5
					setCycle: KQ5SyncWalk
					setPri: -1
					setMotion: MoveTo -18 32 self
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance wolf of Actor
	(properties
		x -27
		y 20
		view 566
		priority 6
		signal 16400
	)

	(method (init)
		(super init:)
		(if (== gPrevRoomNum 92)
			(self setScript: wolfWalkingEast)
		else
			(self setScript: wolfWalkingWest)
		)
	)
)

(instance owl of Actor
	(properties
		x -27
		y 30
		view 568
		priority 16
		signal 16400
	)

	(method (init)
		(super init:)
		(self setScript: owlFlyingEast)
	)
)

