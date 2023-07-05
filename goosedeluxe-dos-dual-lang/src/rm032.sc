;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use MGRoom)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm032 0
)

(local
	local0
)

(instance rm032 of MGRoom
	(properties
		picture 32
		north 25
		east 33
		west 31
		edgeS 255
	)

	(method (init &tmp [temp0 50])
		(= picture 32)
		(= global305 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: -15 135 65 152 140 152 294 134 294 105 252 105 236 100 250 82 200 82 214 100 188 110 133 123 93 118 72 118 59 122 -15 120
					yourself:
				)
		)
		(proc0_1 0 0)
		(Load rsVIEW 16)
		(door init:)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 26 128)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 115)
				(self setScript: gStdWalkIn)
			)
			(north
				(gEgo posn: 225 110)
				(self setScript: gStdWalkIn)
			)
			(42
				(self setScript: exitHouse)
			)
			(104 ; night
				(= global109 goose)
				(= global111 door)
				(plane setRect: 4 4 260 159 1)
				(self setScript: (ScriptID 95)) ; landing
				(goose setScript: gooseScript)
			)
			(0
				(plane setRect: 4 4 260 159 1)
				(gEgo view: global114 posn: 150 124 init:)
				(gGame handsOn:)
			)
			(45 ; mapRoom
				(gEgo init:)
				(gGame handsOn:)
			)
			(else
				(gEgo view: global114 posn: 150 124 init:)
				(gGame handsOn:)
			)
		)
		(if (!= gPrevRoomNum 104) ; night
			(goose init: ignoreActors: 0 setScript: gooseScript)
		)
		(water init: setCycle: Fwd)
		(if (< gScore gPossibleScore)
			(proc0_8)
		)
		(if (and global129 (== gPrevRoomNum 42))
			(global129 posn: 60 124)
		)
	)

	(method (dispose)
		(DisposeScript 95)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((gEgo inRect: 76 100 92 118)
				(self setScript: doorScript)
			)
			((<= (gEgo y:) 100)
				(self setScript: sExitNorth)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut self)
			)
		)
	)
)

(instance goose of Actor
	(properties
		x 134
		y 141
		view 18
		loop 1
	)

	(method (init)
		(super init:)
		(self setCycle: Walk)
	)

	(method (doVerb)
		(script changeState: 3)
	)

	(method (doit)
		(if (& signal $0400)
			(&= signal $fbff)
			(script changeState: 0)
		)
		(super doit:)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 82 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance gooseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (= local0 (Random 1 8))
					(1
						(= state 1)
					)
					(2
						(= state 2)
					)
					(else
						(= state 0)
					)
				)
				(= cycles 1)
			)
			(1
				(= state -1)
				(if (gUser controls:)
					(goose
						setMotion: MoveTo (Random 30 225) (Random 124 140) self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(= state -1)
				(if (gUser controls:)
					(goose setMotion: MoveTo (goose x:) (Random 124 140) self)
				else
					(= cycles 1)
				)
			)
			(3
				(if (or (rm032 script:) (not (gUser controls:)))
					(= state -1)
					(= cycles 1)
				else
					(gSfx number: 40 play:)
					(switch (/ (goose loop:) 2)
						(0
							(goose setLoop: (+ (goose loop:) 4))
						)
						(1
							(goose setLoop: (Random 4 5))
						)
					)
					(goose
						setCel: 0
						setMotion: 0
						cycleSpeed: 5
						setCycle: CT 2 1 self
					)
				)
			)
			(4
				(goose setCel: 3 setCycle: CT 4 1 self)
			)
			(5
				(goose setCel: 4 setCycle: CT 6 1 self)
			)
			(6
				(goose setCel: 7 setCycle: End self)
			)
			(7
				(goose setLoop: -1 setCycle: Walk cycleSpeed: 6)
				(= cycles 15)
			)
			(8
				(proc0_6)
				(= state -1)
				(= cycles 1)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (and (== (event type:) evVERB) (not state))
			(= cycles 0)
			(= seconds 3)
		)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0 setLoop: 3)
				(gSfx number: 38 play:)
				(door setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 42)
			)
		)
	)
)

(instance exitHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo init: posn: 84 110)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 84 120 self)
			)
			(2
				(door setCycle: Beg self)
				(gSfx number: 36 play:)
			)
			(3
				(proc0_5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 72
		y 118
		priority 7
		fixPriority 1
		view 131
		signal 16385
	)

	(method (init)
		(if (== gPrevRoomNum 42)
			(= cel (- (NumCels self) 1))
		)
		(super init:)
	)

	(method (onMe)
		(return 0)
	)

	(method (delete)
		(super delete:)
	)
)

(instance water of Prop
	(properties
		x 223
		y 155
		priority 15
		view 131
		loop 1
		signal 17
		cycleSpeed 14
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 219 (gEgo x:) 237))
				(= temp1 82)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 122 (gEgo y:) 134))
			)
			(3
				(= temp0 (proc0_13 30 (gEgo x:) 246))
				(= temp1 153)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 121 (gEgo y:) 139))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 2)
	)
)

