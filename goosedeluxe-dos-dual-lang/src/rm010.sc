;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use MGRoom)
(use PolyPath)
(use Polygon)
(use Follow)
(use Motion)
(use Actor)
(use System)

(public
	rm010 0
)

(instance rm010 of MGRoom
	(properties
		picture 10
		north 36
		south 17
		edgeN 16
		edgeE 320
		edgeW -1
	)

	(method (init)
		(= picture 10)
		(= global305 outCode)
		(super init:)
		(gEgo init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 117 166 153 166 155 138 146 137 146 126 163 126 162 122 145 121 138 120 128 120 119 121 108 136
					yourself:
				)
		)
		(door init:)
		(switch gPrevRoomNum
			(36
				(door cel: 7)
				(self setScript: closeDoorScript)
			)
			(south
				(gEgo posn: 133 139)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo posn: global173 global174)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 135 130)
				(gGame handsOn:)
			)
		)
		(proc0_8 222 152 136 110)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((>= gScore gPossibleScore)
				(self setScript: (ScriptID 205)) ; walkTo
				(gGame handsOff:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
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
				(gEgo setMotion: PolyPath 133 122 self)
			)
			(1
				(gEgo setMotion: PolyPath 133 121)
				(gSfx number: 38 play:)
				(door setCycle: End self)
			)
			(2
				(gCurRoom newRoom: 36)
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
				(gEgo posn: 136 125 init: setMotion: MoveTo 136 127 self)
			)
			(1
				(gSfx number: 36 play:)
				(door cycleSpeed: 5 setCycle: Beg self)
			)
			(2
				(if (>= gScore gPossibleScore)
					(gEgo setMotion: MoveTo 133 175)
				else
					(if global129
						(global129 setMotion: Follow gEgo 30)
					)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 122
		y 118
		view 124
		cycleSpeed 10
	)

	(method (init)
		(super init:)
	)

	(method (doVerb)
		(gCurRoom setScript: openDoorScript)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 117 (gEgo x:) 146))
				(= temp1 16)
			)
			(2
				(= temp0 262)
				(= temp1 (proc0_13 122 (gEgo y:) 144))
			)
			(3
				(= temp0 (proc0_13 118 (gEgo x:) 153))
				(= temp1 166)
			)
			(4
				(= temp0 -5)
				(= temp1 (proc0_13 127 (gEgo y:) 141))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

