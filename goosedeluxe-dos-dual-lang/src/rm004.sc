;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use MGRoom)
(use MoveProp)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm004 0
)

(instance rm004 of MGRoom
	(properties
		picture 4
		east 5
		south 11
		west 3
		edgeN -1
		edgeE 237
		edgeW 33
	)

	(method (init)
		(= global305 outCode)
		(super init:)
		(= global521 0)
		(gEgo init: hide:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 156 66 106 66 92 121 -10 120 -10 136 21 136 30 166 223 166 223 138 267 138 267 119 166 119 166 95
					yourself:
				)
		)
		((MoveProp new:) init: 123 0 213 96 14 yourself:)
		((MoveProp new:) init: 123 1 53 97 14 yourself:)
		((MoveProp new:) init: 123 2 216 66 6 yourself:)
		((MoveProp new:) init: 123 3 62 70 6 yourself:)
		(door init:)
		(switch gPrevRoomNum
			(37
				(door setScript: closeDoorScript)
				(gEgo posn: 132 65)
				(self setScript: gStdClimbIn)
			)
			(south
				(gEgo posn: (proc0_13 51 (gEgo x:) 152) 139)
				(self setScript: gStdWalkIn)
				(fountainS play:)
			)
			(east
				(gEgo posn: 220 (proc0_13 118 (gEgo y:) 132))
				(self setScript: gStdWalkIn)
				(fountainS play:)
			)
			(west
				(gEgo posn: 58 (proc0_13 119 (gEgo y:) 138))
				(self setScript: gStdWalkIn)
				(fountainS play:)
			)
			(45 ; mapRoom
				(gEgo posn: global173 global174 init:)
				(fountainS play:)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 130 140 init:)
				(fountainS play:)
				(gGame handsOn:)
			)
		)
		(proc0_8 86 137)
	)

	(method (doit &tmp temp0 temp1)
		(if
			(and
				(gEgo mover:)
				(!=
					(= temp1 (if (< (gEgo y:) 80) 3 else 2))
					(gEgo yStep:)
				)
			)
			(gEgo yStep: temp1)
			(InitBresen (gEgo mover:))
		)
		(cond
			(script
				(script doit:)
			)
			((>= gScore gPossibleScore)
				(self setScript: (ScriptID 205)) ; walkTo
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(= global521 1)
		(fountainS stop:)
		(super dispose: &rest)
	)
)

(instance fountainS of Sound
	(properties
		flags 1
		number 27
		loop -1
	)

	(method (stop)
		(if handle
			(super stop: &rest)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: PolyPath (proc0_13 119 (gEgo x:) 143) 66 self
				)
			)
			(1
				(gEgo setScript: gStdClimbOut self)
				(= cycles 70)
			)
			(2
				(gSfx number: 580 play:)
				(= cycles 10)
			)
			(3
				(door setCycle: End self)
			)
			(4
				(door setLoop: 5 cel: 0)
				(= cycles 5)
			)
			(5
				(gCurRoom newRoom: 37)
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
				(gSfx number: 581 play: self)
				(door cycleSpeed: 15 setCycle: Beg)
			)
			(1
				(fountainS play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 131
		y 36
		z -30
		view 123
		loop 4
		cycleSpeed 10
	)

	(method (init)
		(super init:)
		(self setPri: 0)
		(self cel: (if (== gPrevRoomNum 37) 7 else 0))
	)

	(method (doVerb)
		(gCurRoom setScript: openDoor)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 108 (gEgo x:) 154))
				(= temp1 66)
			)
			(2
				(= temp0 250)
				(= temp1 (proc0_13 119 (gEgo y:) 137))
			)
			(3
				(= temp0 (proc0_13 36 (gEgo x:) 222))
				(= temp1 166)
			)
			(4
				(= temp0 20)
				(= temp1 (proc0_13 122 (gEgo y:) 144))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

