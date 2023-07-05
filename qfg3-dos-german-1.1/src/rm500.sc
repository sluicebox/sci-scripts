;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use System)

(public
	rm500 0
)

(instance rm500 of Rm
	(properties
		picture 500
		vanishingY -20
	)

	(method (init)
		(HandsOff)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 15 58 48 58 60 57 70 52 76 49 140 49 145 51 159 50 180 58 185 59 232 59 259 77 270 79 278 86 275 114 276 123 258 133 234 138 196 146 158 149 102 160 63 160 17 114 8 91
					yourself:
				)
		)
		(= global126 (gEgo moveSpeed:))
		(gEgo changeGait: 1 setScale: 500 setSpeed: 6 ignoreActors: 1 init:) ; running
		((ScriptID 39 1) setScale: 500 origStep: 2053 ignoreActors: 1 init:) ; Yesufu
		(cond
			((== gPrevRoomNum 420)
				(gCurRoom setScript: eventOne)
			)
			((== gPrevRoomNum 510)
				(gCurRoom setScript: eventTwo)
			)
			((== gPrevRoomNum 520)
				(gCurRoom setScript: eventThree)
			)
			((== gPrevRoomNum 530)
				(if (IsFlag 30)
					(gCurRoom setScript: eventFourFreed)
				else
					(gCurRoom setScript: eventFourTrap)
				)
			)
		)
		(super init:)
	)

	(method (dispose)
		(DisposeScript 39)
		(super dispose:)
	)
)

(instance eventFourTrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x: 103
					y: 165
					setCycle: Walk
					setMotion: PolyPath 65 166 self
				)
				((ScriptID 39 1) ; Yesufu
					view: 501
					setLoop: 0
					x: 142
					y: 161
					setCycle: Fwd
				)
			)
			(1
				(gEgo setMotion: PolyPath 9 54)
				((ScriptID 39 1) setLoop: 1 setCycle: End self) ; Yesufu
			)
			(2
				((ScriptID 39 1) ; Yesufu
					cycleSpeed: 3
					moveSpeed: 3
					view: 983
					setCycle: Walk
					setMotion: PolyPath 6 88 self
				)
			)
			(3
				((ScriptID 39 1) ; Yesufu
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: PolyPath 6 54 self
				)
			)
			(4
				(gEgo setSpeed: global126 setMotion: 0)
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance eventFourFreed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x: 142
					y: 161
					setCycle: Walk
					setMotion: PolyPath 10 74 self
				)
				((ScriptID 39 1) ; Yesufu
					x: 142
					y: 165
					view: 983
					setCycle: Walk
					setMotion: PolyPath 5 74
				)
			)
			(1
				((ScriptID 39 1) ; Yesufu
					cycleSpeed: 3
					moveSpeed: 3
					setMotion: PolyPath 5 54 self
				)
				(gEgo setMotion: PolyPath 10 54)
			)
			(2
				((ScriptID 39 1) cycleSpeed: 6 moveSpeed: 6) ; Yesufu
				(gEgo setSpeed: global126 setMotion: 0)
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance eventThree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x: 255
					y: 137
					setCycle: Walk
					setMotion: PolyPath 204 153 self
				)
				((ScriptID 39 1) ; Yesufu
					x: 255
					y: 141
					view: 983
					setCycle: Walk
					setMotion: PolyPath 204 158
				)
			)
			(1
				(gEgo setMotion: PolyPath 142 161)
				((ScriptID 39 1) ; Yesufu
					cycleSpeed: 3
					moveSpeed: 3
					setMotion: PolyPath 142 164 self
				)
			)
			(2
				((ScriptID 39 1) cycleSpeed: 6 moveSpeed: 6) ; Yesufu
				(gEgo setMotion: 0)
				(gCurRoom newRoom: 530)
			)
		)
	)
)

(instance eventTwo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 1) ; Yesufu
					view: 983
					x: 228
					y: 57
					setCycle: Walk
					setMotion: PolyPath 288 87
				)
				(gEgo
					x: 224
					y: 54
					setCycle: Walk
					setMotion: PolyPath 283 87 self
				)
			)
			(1
				((ScriptID 39 1) ; Yesufu
					cycleSpeed: 3
					moveSpeed: 3
					setMotion: PolyPath 288 123 self
				)
				(gEgo setMotion: PolyPath 283 123)
			)
			(2
				((ScriptID 39 1) cycleSpeed: 6 moveSpeed: 6) ; Yesufu
				(gEgo setMotion: 0)
				(gCurRoom newRoom: 520)
			)
		)
	)
)

(instance eventOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 13 y: 57 setCycle: Walk setMotion: PolyPath 140 57)
				((ScriptID 39 1) ; Yesufu
					view: 983
					x: 15
					y: 55
					setCycle: Walk
					setMotion: PolyPath 140 51 self
				)
			)
			(1
				((ScriptID 39 1) ; Yesufu
					cycleSpeed: 3
					moveSpeed: 3
					setMotion: PolyPath 170 49 self
				)
				(gEgo setMotion: PolyPath 170 51)
			)
			(2
				((ScriptID 39 1) cycleSpeed: 6 moveSpeed: 6) ; Yesufu
				(gEgo setMotion: 0)
				(gCurRoom newRoom: 510)
			)
		)
	)
)

