;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use MGRoom)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm024 0
)

(local
	local0
)

(instance rm024 of MGRoom
	(properties
		picture 24
		north 17
		east 25
		south 31
		west 23
	)

	(method (init &tmp [temp0 3])
		(Load rsVIEW 129)
		(proc0_1)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: -10 137 -10 185 280 185 280 137
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 280 116 280 92 256 92 202 82 202 68 178 68 183 75 198 92 200 99 159 101 139 102 132 111 111 116
					yourself:
				)
		)
		(cuckoo init:)
		(door init: ignoreActors:)
		(switch gPrevRoomNum
			(41
				(= global305 outCode1)
				(gEgo loop: 0 posn: 148 108 init:)
				(self setScript: closeDoorScript)
			)
			(north
				(= global305 outCode1)
				(gEgo posn: 197 82)
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
						139
				)
				(self setScript: gStdWalkIn)
			)
			(west
				(= global305 outCode2)
				(gEgo posn: 26 (proc0_13 137 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(east
				(if (<= (gEgo y:) 130)
					(gEgo posn: 236 (proc0_13 110 (gEgo y:) 115))
					(= global305 outCode1)
				else
					(gEgo posn: 236 (proc0_13 138 (gEgo y:) 143))
					(= global305 outCode2)
				)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo posn: global173 global174 init:)
				(if (<= (gEgo y:) 130)
					(= global305 outCode1)
				else
					(= global305 outCode2)
				)
				(gGame handsOn:)
			)
			(else
				(= global305 outCode1)
				(gEgo posn: 130 115 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8 226 100)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			(script
				(script doit:)
			)
			((>= gScore gPossibleScore)
				(self setScript: (ScriptID 205)) ; walkTo
			)
			((< (gEgo y:) 80)
				(self newRoom: north)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 145 104 self)
			)
			(1
				(proc0_7 gEgo door)
				(= cycles 1)
			)
			(2
				(openDoorSnd play: self)
				(door setCycle: End self)
			)
			(3)
			(4
				(gCurRoom newRoom: 41)
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
				(door setCycle: Beg self)
				(= cycles 1)
			)
			(1
				(closeDoorSnd play: self)
			)
			(2
				(gCurRoom setScript: 0)
				(gGame handsOn:)
			)
		)
	)
)

(instance cuckooScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 8 15))
			)
			(1
				(= seconds 0)
				(cuckooSnd play:)
				(cuckoo setCycle: End self)
			)
			(2
				(cuckoo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(cuckoo setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(4
				(cuckooSnd stop:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance door of Prop
	(properties
		view 129
	)

	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			setPri: 7
			setCel: (if (== gPrevRoomNum 41) 4 else 0)
			cycleSpeed: 6
			posn: 132 106
		)
	)

	(method (delete)
		(&= signal (~ global510))
		(super delete:)
	)

	(method (doVerb)
		(self setScript: openDoorScript)
	)
)

(instance cuckoo of Prop
	(properties
		x 170
		y 27
		priority 12
		view 129
		loop 1
	)

	(method (doVerb)
		(if (== (cuckooScript state:) 0)
			(cuckooScript changeState: 1)
		)
	)

	(method (init)
		(super init:)
		(if (or (== global129 (ScriptID 601)) (== global129 (ScriptID 602))) ; petersWife, muffet
			(self setScript: 0)
		else
			(self setScript: cuckooScript)
		)
	)
)

(instance openDoorSnd of Sound
	(properties
		flags 1
		number 38
		loop 0
	)
)

(instance closeDoorSnd of Sound
	(properties
		flags 1
		number 36
		loop 0
	)
)

(instance cuckooSnd of Sound
	(properties
		flags 1
		number 583
		loop -1
	)
)

(instance outCode1 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 160 (gEgo x:) 220))
				(= temp1 39)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 93 (gEgo y:) 126))
			)
			(3
				(= temp0 (proc0_13 6 (gEgo x:) 260))
				(= temp1 130)
			)
			(4
				(= temp0 3)
				(= temp1 (proc0_13 112 (gEgo y:) 128))
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
				(= temp0 (proc0_13 4 (gEgo x:) 255))
				(= temp1 136)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 138 (gEgo y:) 155))
			)
			(3
				(= temp0 (proc0_13 1 (gEgo x:) 257))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 138 (gEgo y:) 155))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

