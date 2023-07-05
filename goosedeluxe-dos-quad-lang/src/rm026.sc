;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use MGRoom)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm026 0
)

(instance rm026 of MGRoom
	(properties
		picture 26
		north 19
		east 27
		south 33
		west 25
	)

	(method (init &tmp [temp0 3])
		(Load rsVIEW 130)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 125 169 125 168 113 151 103 155 94 143 90 129 90 105 85 118 75 105 75 77 84 42 91 0 93
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: -10 185 256 185 256 140 -10 140
					yourself:
				)
		)
		(door init:)
		(mailBox init:)
		(proc0_1)
		(smoke init: setCycle: Fwd)
		(switch gPrevRoomNum
			(43
				(= global305 outCode1)
				(gEgo posn: 144 90 init:)
				(self setScript: closeDoorScript)
			)
			(north
				(= global305 outCode1)
				(gEgo posn: 98 86)
				(self setScript: gStdWalkIn)
			)
			(south
				(= global305 outCode2)
				(gEgo
					posn:
						(proc0_13
							(gCurRoom edgeW:)
							(gEgo x:)
							(gCurRoom edgeE:)
						)
						140
				)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo
					posn:
						26
						(proc0_13
							95
							(proc0_14 126 (gEgo y:) 139)
							(gCurRoom edgeS:)
						)
				)
				(if (<= (gEgo y:) 131)
					(= global305 outCode1)
				else
					(= global305 outCode2)
				)
				(self setScript: gStdWalkIn)
			)
			(east
				(= global305 outCode2)
				(gEgo posn: 231 (proc0_13 137 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
				(if (<= (gEgo y:) 131)
					(= global305 outCode1)
				else
					(= global305 outCode2)
				)
				(gGame handsOn:)
			)
			(else
				(= global305 outCode1)
				(gEgo posn: 150 120 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8 72 100)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			(script
				(script doit:)
			)
			((>= gScore gPossibleScore)
				(self setScript: (ScriptID 205)) ; walkTo
			)
			((gEgo inRect: 75 75 118 80)
				(gCurRoom newRoom: north)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 145 93 self 0)
			)
			(1
				(gEgo setMotion: MoveTo 145 92)
				(gSfx number: 38 play:)
				(door setCycle: End self)
			)
			(2
				(gCurRoom newRoom: 43)
			)
		)
	)
)

(instance closeDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 140 96 self)
				(door setCycle: Beg)
				(= cycles 4)
			)
			(1
				(gSfx number: 36 play:)
			)
			(2
				(if (< gScore gPossibleScore)
					(gGame handsOn:)
				)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 135
		y 50
		view 130
		cycleSpeed 2
	)

	(method (init)
		(if (== gPrevRoomNum 43)
			(= cel (- (NumCels self) 1))
		)
		(super init:)
	)

	(method (doVerb)
		(if (< (gEgo y:) 136)
			(gCurRoom setScript: openDoorScript)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance smoke of Prop
	(properties
		x 237
		y 11
		view 130
		loop 1
		cycleSpeed 12
	)
)

(instance mailBox of View
	(properties
		x 22
		y 111
		priority 128
		view 130
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 128 1)
	)

	(method (onMe)
		(return 0)
	)
)

(instance outCode1 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 106 (gEgo x:) 119))
				(= temp1 75)
			)
			(2
				(= temp0 156)
				(= temp1 (proc0_13 113 (gEgo y:) 125))
			)
			(3
				(= temp0 (proc0_13 8 (gEgo x:) 254))
				(= temp1 125)
			)
			(4
				(= temp0 0)
				(= temp1 (proc0_13 93 (gEgo y:) 125))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

(instance outCode2 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 10 (gEgo x:) 245))
				(= temp1 140)
			)
			(2
				(= temp0 256)
				(= temp1 (proc0_13 141 (gEgo y:) 144))
			)
			(3
				(= temp0 (proc0_13 5 (gEgo x:) 253))
				(= temp1 156)
			)
			(4
				(= temp0 0)
				(= temp1 (proc0_13 141 (gEgo y:) 144))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 2)
	)
)

