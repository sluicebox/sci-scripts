;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use CycleBet)
(use BalloonTalker)
(use ADRoom)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Maze 0
	offScreen 1
	butTalker 2
	offScreen2 18
)

(local
	[local0 64] = [8198 8202 16398 -32758 -32758 16396 -1 17684 6689 -1 16389 -1 -1 17287 -32758 -32759 -1 -1 16389 17428 -1 16389 -1 -1 18196 -1 8195 8203 16398 -32757 -32758 16396 8199 8202 16396 -1 16933 8834 16396 16389 6181 -1 16391 -30438 -32757 16398 -32471 16773 4101 -1 16389 -1 -1 18053 -1 16389 4099 -32760 16391 -32758 -32758 -32757 -32758 -32759]
	local64
	local65
	local66
	local67
	local68 = 1
	local69 = 4
	local70 = 8
	local71 = 2
	local72 = 1
	local73 = 2
	local74 = 4
	local75 = 8
	local76
	local77
	local78
	local79
	local80
	local81
	local82
	local83
	local84
	local85
	local86
	local87
	local88
	local89
	local90
	local91
)

(procedure (localproc_0)
	(= local68 1)
	(= local69 4)
	(= local70 8)
	(= local71 2)
	(= local72 1)
	(= local74 4)
	(= local75 8)
	(= local73 2)
)

(procedure (localproc_1)
	(= local68 4)
	(= local69 1)
	(= local70 2)
	(= local71 8)
	(= local72 4)
	(= local74 1)
	(= local75 2)
	(= local73 8)
)

(procedure (localproc_2)
	(= local68 2)
	(= local69 8)
	(= local70 1)
	(= local71 4)
	(= local72 2)
	(= local74 8)
	(= local75 1)
	(= local73 4)
)

(procedure (localproc_3)
	(= local68 8)
	(= local69 2)
	(= local70 4)
	(= local71 1)
	(= local72 8)
	(= local74 2)
	(= local75 4)
	(= local73 1)
)

(procedure (localproc_4)
	(if (== (Maze rowNo:) 0)
		(Maze rowNo: 0)
	else
		(Maze rowNo: (- (Maze rowNo:) 1))
	)
)

(procedure (localproc_5)
	(if (== (Maze rowNo:) 7)
		(if (== (Maze columnNo:) 2)
			(gCurRoom newRoom: 380)
		else
			(Maze rowNo: 7)
		)
	else
		(Maze rowNo: (+ (Maze rowNo:) 1))
	)
)

(procedure (localproc_6)
	(if (== (Maze columnNo:) 7)
		(Maze columnNo: 7)
	else
		(Maze columnNo: (+ (Maze columnNo:) 1))
	)
)

(procedure (localproc_7)
	(cond
		((== (Maze columnNo:) 0)
			(Maze columnNo: 0)
		)
		((and (== (Maze columnNo:) 2) (== (Maze rowNo:) 7))
			(gCurRoom newRoom: 380)
		)
		(else
			(Maze columnNo: (- (Maze columnNo:) 1))
		)
	)
)

(class Maze of ADRoom
	(properties
		noun 1
		vanishingY -60
		rowNo 7
		columnNo 2
		whereAreWe 0
		whereDoor 0
		whichDoor 0
		whereHall 0
		facingDir 1
	)

	(method (init)
		(super init: &rest)
		(gEgo init:)
		(lamp1 init:)
		(lamp2 init:)
		(lamp3 init:)
		(lamp4 init:)
		(LoadMany rsVIEW 403)
		(gWalkHandler addToFront: mazeHallW)
		(gWalkHandler addToFront: mazeHallE)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 282 187 235 148 219 147 212 140 99 140 92 147 79 148 29 186
					yourself:
				)
		)
		(switch gPrevRoomNum
			(410
				(LoadMany rsVIEW 808 401)
				((ScriptID 895 1) posn: 86 153 hide:) ; lockjaw
				(if (== ((gInventory at: 7) owner:) gCurRoomNum) ; Ima_s_Room_Key
					(glint init: stopUpd:)
					(glintFea init:)
				)
				(gCurRoom setScript: sBackFromLJsRoom)
			)
			(610
				(gLongSong number: 400 loop: -1 flags: 1 play:)
				(if (== ((gInventory at: 7) owner:) gCurRoomNum) ; Ima_s_Room_Key
					(glint init: stopUpd:)
					(glintFea init:)
				)
				(gCurRoom setScript: sBackFromReset)
			)
			(else
				(gLongSong number: 400 loop: -1 flags: 1 play:)
				(gCurRoom setScript: sShowRoom)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; Nose
				(gCurRoom setScript: sPointWayOut)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and local64 (& (gEgo onControl: 1) $0004))
				(gCurRoom setScript: sGoUp)
			)
			(
				(and
					(& (gEgo onControl: 1) $0010)
					(== (Maze whereAreWe:) 8)
					(not (IsFlag 90))
				)
				(gCurRoom setScript: sButlerGotcha)
			)
			((& (gEgo onControl: 1) $0010)
				(gCurRoom setScript: sGoDown)
			)
			((and local66 (& (gEgo onControl: 1) $0008))
				(gCurRoom setScript: sGoEast)
			)
			((and local67 (& (gEgo onControl: 1) $0002))
				(gCurRoom setScript: sGoWest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 380)
			(gLongSong fade:)
			(if (IsFlag 90)
				(= newRoomNumber 382)
			)
		)
		(gWalkHandler delete: mazeHallW)
		(gWalkHandler delete: mazeHallE)
		(saveHimTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)

	(method (showRoom param1)
		(if (gCast contains: stuffFalls)
			(openDoor dispose:)
			(stuffFalls dispose:)
		)
		(if (!= gPrevRoomNum 410)
			(gGame handsOff:)
			(gEgo
				normalize:
				setPri: 14
				posn: 146 220
				setHeading: 0
				setScale: Scaler 131 100 189 141
			)
		)
		(= whereAreWe (+ (* rowNo 8) columnNo))
		(if (== whereAreWe 58)
			(cond
				((== facingDir 4)
					(gCurRoom drawPic: 402 10)
				)
				((== facingDir 8)
					(gCurRoom drawPic: 403 10)
				)
				(else
					(gCurRoom drawPic: 400 10)
				)
			)
		else
			(gCurRoom drawPic: 400 10)
		)
		(= local77 (>> (& [local0 whereAreWe] $f000) $000c))
		(= whereHall (& [local0 whereAreWe] $000f))
		(= whichDoor (& [local0 whereAreWe] $0f00))
		(>>= whichDoor $0008)
		(if whichDoor
			(= local76 1)
			(switch (= whereDoor (>> (& [local0 whereAreWe] $00f0) $0004))
				(local68
					(mazeDoor
						loop: 5
						cel: 0
						x: 197
						y: 136
						approachX: 131
						approachY: 139
						_approachVerbs: 9
					)
					(offScreen winX: 120 winY: 70 tailPosn: 0)
				)
				(local71
					(mazeDoor
						loop: 3
						cel: 0
						x: 254
						y: 153
						approachX: 264
						approachY: 160
						_approachVerbs: 9
					)
					(offScreen winX: 100 winY: 110 tailPosn: 1)
				)
				(local70
					(mazeDoor
						loop: 4
						cel: 0
						x: 64
						y: 150
						approachX: 70
						approachY: 156
						_approachVerbs: 9
					)
					(offScreen winX: 20 winY: 100 tailPosn: 0)
				)
				(local69
					(= local76 0)
					(= whereDoor 0)
					(mazeDoor dispose:)
				)
			)
			(if local76
				(mazeDoor init: addToPic:)
			)
		else
			(= whereDoor 0)
			(mazeDoor dispose:)
		)
		(if whereHall
			(= local64 (& whereHall local72))
			(= local66 (& whereHall local73))
			(= local67 (& whereHall local75))
			(if local64
				(cond
					((and (== whereAreWe 58) (== facingDir 1))
						(mazeHallN loop: 0 cel: 0 setPri: 9 init: addToPic:)
					)
					((and (== whereAreWe 58) (!= facingDir 1)) 0)
					((and (== whereAreWe 50) (== facingDir 4))
						(mazeHallN loop: 7 cel: 1 setPri: 11 init: addToPic:)
					)
					((and (== whereAreWe 59) (== facingDir 8))
						(mazeHallN loop: 7 cel: 0 setPri: 9 init: addToPic:)
					)
					(else
						(mazeHallN loop: 0 cel: 0 setPri: 9 init: addToPic:)
					)
				)
				(switch facingDir
					(1
						(= local79 (+ (* (- rowNo 1) 8) columnNo))
					)
					(4
						(= local79 (+ (* (+ rowNo 1) 8) columnNo))
					)
					(2
						(= local79 (+ (* rowNo 8) columnNo 1))
					)
					(8
						(= local79 (+ (* rowNo 8) (- columnNo 1)))
					)
				)
				(cond
					((& (& [local0 local79] $000f) local72)
						(cond
							((and (== whereAreWe 42) (== facingDir 4))
								(overHall
									loop: 7
									cel: 2
									setPri: 10
									init:
									addToPic:
								)
							)
							((and (== whereAreWe 60) (== facingDir 8))
								(overHall
									loop: 7
									cel: 3
									setPri: 10
									init:
									addToPic:
								)
							)
							(else
								(overHall
									loop: 0
									cel: 1
									setPri: 10
									init:
									addToPic:
								)
							)
						)
					)
					((>> (& [local0 local79] $0f00) $0008)
						(switch
							(= whereDoor (>> (& [local0 local79] $00f0) $0004))
							(local68
								(overHall
									loop: 0
									cel: 2
									setPri: 10
									init:
									addToPic:
								)
							)
						)
					)
				)
			else
				(mazeHallN dispose:)
				(overHall dispose:)
			)
			(if local66
				(mazeHallE init: addToPic:)
			else
				(mazeHallE dispose:)
			)
			(if local67
				(cond
					((!= whereAreWe 58)
						(mazeHallW init: addToPic:)
					)
					((!= facingDir 8)
						(mazeHallW init: addToPic:)
					)
				)
			else
				(mazeHallW dispose:)
			)
		)
		(switch whichDoor
			(1
				(mazeDoor noun: 4)
			)
			(2
				(mazeDoor noun: 5)
			)
			(3
				(mazeDoor noun: 6)
			)
			(4
				(mazeDoor noun: 7)
			)
			(5
				(mazeDoor noun: 8)
			)
			(6
				(mazeDoor noun: 9)
			)
			(7
				(mazeDoor noun: 10)
			)
			(8
				(mazeDoor noun: 11)
			)
			(9
				(mazeDoor noun: 12)
			)
			(10
				(mazeDoor noun: 15)
			)
		)
		(param1 cue:)
	)
)

(instance sGoUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(switch (Maze facingDir:)
					(1
						(localproc_4)
					)
					(4
						(localproc_5)
					)
					(2
						(localproc_6)
					)
					(8
						(localproc_7)
					)
				)
				(= cycles 1)
			)
			(2
				(self setScript: sShowRoom self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) 220 self)
			)
			(2
				(switch (Maze facingDir:)
					(1
						(localproc_5)
						(Maze facingDir: 4)
						(localproc_1)
					)
					(4
						(localproc_4)
						(Maze facingDir: 1)
						(localproc_0)
					)
					(2
						(localproc_7)
						(Maze facingDir: 8)
						(localproc_3)
						(if
							(or
								(== (Maze whereAreWe:) 37)
								(== (Maze whereAreWe:) 47)
							)
							(sFX number: 922 play:)
							(= local81 1)
						)
					)
					(8
						(localproc_6)
						(Maze facingDir: 2)
						(localproc_2)
						(if
							(or
								(== (Maze whereAreWe:) 36)
								(== (Maze whereAreWe:) 46)
							)
							(sFX number: 922 play:)
							(= local81 1)
						)
					)
				)
				(= cycles 1)
			)
			(3
				(self setScript: sShowRoom self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(switch (Maze facingDir:)
					(1
						(localproc_7)
						(Maze facingDir: 8)
						(localproc_3)
					)
					(4
						(localproc_6)
						(Maze facingDir: 2)
						(localproc_2)
					)
					(2
						(localproc_4)
						(Maze facingDir: 1)
						(localproc_0)
					)
					(8
						(localproc_5)
						(Maze facingDir: 4)
						(localproc_1)
					)
				)
				(= cycles 1)
			)
			(2
				(self setScript: sShowRoom self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(switch (Maze facingDir:)
					(1
						(localproc_6)
						(Maze facingDir: 2)
						(localproc_2)
					)
					(4
						(localproc_7)
						(Maze facingDir: 8)
						(localproc_3)
					)
					(2
						(localproc_5)
						(Maze facingDir: 4)
						(localproc_1)
					)
					(8
						(localproc_4)
						(Maze facingDir: 1)
						(localproc_0)
					)
				)
				(= cycles 1)
			)
			(2
				(self setScript: sShowRoom self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShowRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(Maze showRoom: self)
			)
			(2
				(gGame handsOff:)
				(gEgo
					normalize:
					setPri: 14
					posn: 146 220
					show:
					setHeading: 0
					setScale: Scaler 131 100 189 141
				)
				(if (== gEgo (ScriptID 895 1)) ; lockjaw
					((ScriptID 895 0) posn: 117 230 setHeading: 0) ; pepper
				)
				(= cycles 1)
			)
			(3
				(gEgo setMotion: MoveTo 146 176 self)
			)
			(4
				(if (== gEgo (ScriptID 895 1)) ; lockjaw
					((ScriptID 895 0) ; pepper
						ignoreActors: 1
						setMotion: MoveTo 117 183 self
					)
				else
					(if (== local81 1)
						(sFX number: 923 play:)
						(= local81 0)
					)
					(= cycles 1)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPointWayOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(switch (Maze facingDir:)
					(1
						(switch local77
							(1
								(gCurRoom setScript: sPointNorth)
							)
							(4
								(gCurRoom setScript: sPointSouth)
							)
							(2
								(gCurRoom setScript: sPointEast)
							)
							(8
								(gCurRoom setScript: sPointWest)
							)
						)
					)
					(4
						(switch local77
							(1
								(gCurRoom setScript: sPointSouth)
							)
							(4
								(gCurRoom setScript: sPointNorth)
							)
							(2
								(gCurRoom setScript: sPointWest)
							)
							(8
								(gCurRoom setScript: sPointEast)
							)
						)
					)
					(2
						(switch local77
							(1
								(gCurRoom setScript: sPointWest)
							)
							(4
								(gCurRoom setScript: sPointEast)
							)
							(2
								(gCurRoom setScript: sPointNorth)
							)
							(8
								(gCurRoom setScript: sPointSouth)
							)
						)
					)
					(8
						(switch local77
							(1
								(gCurRoom setScript: sPointEast)
							)
							(4
								(gCurRoom setScript: sPointWest)
							)
							(2
								(gCurRoom setScript: sPointSouth)
							)
							(8
								(gCurRoom setScript: sPointNorth)
							)
						)
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoSniff of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 390 3)
				(= local80 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(= cycles 1)
			)
			(1
				(if (OneOf (gEgo cel:) 0 2 3 4 6)
					(= temp0 4)
				else
					(= temp0 3)
				)
				(gEgo
					view: 808
					loop: temp0
					cel: 0
					setSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(2
				(gEgo setCycle: CycleBet 4 5 -1)
				(sFX number: 911 play: self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(if (== (gEgo loop:) 3)
					(gEgo normalize: 807 1 setSpeed: local80)
				else
					(gEgo normalize: 807 0 setSpeed: local80)
				)
				(self dispose:)
			)
		)
	)
)

(instance sPointNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: sDoSniff self)
			)
			(1
				(gEgo ignoreActors: 1 setPri: 14)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: PolyPath 152 145 self)
			)
			(3
				(gEgo view: 402 loop: 4 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 50)
			)
			(5
				(gEgo normalize: 807 2 setPri: 14)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPointSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: sDoSniff self)
			)
			(1
				(gEgo ignoreActors: 1 setPri: 14)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: PolyPath 174 177 self)
			)
			(3
				(gEgo view: 402 loop: 5 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 50)
			)
			(5
				(gEgo normalize: 807 2 setPri: 14)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPointEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: sDoSniff self)
			)
			(1
				(gEgo ignoreActors: 1 setPri: 14)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: PolyPath 240 161 self)
			)
			(3
				(gEgo view: 402 loop: 6 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 50)
			)
			(5
				(gEgo normalize: 807 0 setPri: 14)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPointWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: sDoSniff self)
			)
			(1
				(gEgo ignoreActors: 1 setPri: 14)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: PolyPath 74 157 self)
			)
			(3
				(gEgo view: 402 loop: 7 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 50)
			)
			(5
				(gEgo normalize: 807 1 setPri: 14)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenWhichDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(switch (Maze whereDoor:)
					(local68
						(gEgo view: 407 setLoop: 0 cel: 0 setCycle: 0)
						(= cycles 1)
					)
					(local71
						(gEgo view: 403 loop: 2 cel: 0 setCycle: CT 3 1 self)
					)
					(local70
						(gEgo view: 406 loop: 0 cel: 0 setCycle: CT 6 1 self)
					)
				)
				(sFX number: 922 loop: 1 play:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sOpenDoor1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 4 7 0 0 self) ; "Hey, it's unlocked!"
			)
			(2
				(self setScript: sOpenWhichDoor self)
			)
			(3
				(cond
					((== (Maze whereAreWe:) 46)
						(if (== (Maze facingDir:) 4)
							(self setScript: sGoWest self)
						else
							(self setScript: sGoUp self)
						)
					)
					((== (Maze facingDir:) 1)
						(self setScript: sGoWest self)
					)
					(else
						(self setScript: sGoEast self)
					)
				)
			)
			(4
				(sFX number: 923 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDoor2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 5 7 0 0 self) ; "Cool, it's unlocked!"
			)
			(2
				(self setScript: sOpenWhichDoor self)
			)
			(3
				(if (== (Maze whereAreWe:) 36)
					(if (== (Maze facingDir:) 1)
						(self setScript: sGoEast self)
					else
						(self setScript: sGoWest self)
					)
				else
					(self setScript: sGoUp self)
				)
			)
			(4
				(sFX number: 923 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDoor3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local83 1)
				(= cycles 1)
			)
			(1
				(self setScript: sOpenWhichDoor self)
			)
			(2
				(gLongSong pause:)
				(gMessager say: 6 7 1 1 self) ; "MEEEEOOOOOOOOW!!!"
			)
			(3
				(switch (Maze facingDir:)
					(1
						(purpleCat
							setLoop: 5
							x: 52
							y: 148
							setCycle: Fwd
							setSpeed: 3
							setStep: 6 4
							init:
						)
					)
					(4
						(purpleCat
							setLoop: 4
							x: 268
							y: 150
							setCycle: Fwd
							setSpeed: 3
							setStep: 6 4
							init:
						)
					)
					(8
						(purpleCat
							setLoop: 4
							x: 158
							y: 125
							setCycle: Fwd
							setSpeed: 3
							setStep: 6 4
							init:
						)
					)
				)
				(sFX number: 2109 play:)
				(= cycles 1)
			)
			(4
				(switch (Maze facingDir:)
					(1
						(purpleCat setMotion: MoveTo 177 199 self)
					)
					(4
						(purpleCat setMotion: MoveTo 150 199 self)
					)
					(8
						(purpleCat setMotion: MoveTo 70 199 self)
					)
				)
			)
			(5
				(gEgo setCycle: Beg self)
				(purpleCat dispose:)
			)
			(6
				(sFX number: 923 play:)
				(switch (Maze facingDir:)
					(1
						(gEgo normalize: 790 1 setPri: 14)
					)
					(4
						(gEgo normalize: 790 0 setPri: 14)
					)
					(8
						(gEgo normalize: 790 3 setPri: 14)
					)
				)
				(= cycles 1)
			)
			(7
				(gLongSong play:)
				(cond
					((== (Maze facingDir:) 4)
						((ScriptID 2000 3) winX: 89 winY: 120 tailPosn: 1) ; PepperTalker
					)
					((== (Maze facingDir:) 8)
						((ScriptID 2000 3) winX: 120 winY: 100 tailPosn: 0) ; PepperTalker
					)
					(else
						((ScriptID 2000 3) winX: 71 winY: 103 tailPosn: 0) ; PepperTalker
					)
				)
				(gMessager say: 6 7 1 2 self) ; "Those...those FIENDS!"
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDoor4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local82 1)
				(dropOff init: hide:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 135 143 self)
			)
			(2
				(gLongSong pause:)
				(gEgo hide: setLoop: 3)
				(dropOff show: setCycle: End self)
				(sFX number: 922 play:)
			)
			(3
				(sFX2 number: 111 play:)
				(dropOff stopUpd:)
				(gMessager say: 7 7 3 0 self) ; "YIIIIIKES! Those Pughs are CRAZY!"
			)
			(4
				(dropOff setCycle: Beg self)
			)
			(5
				(sFX2 stop:)
				(sFX number: 923 play:)
				(gEgo show:)
				(if (== (Maze facingDir:) 1)
					(gEgo normalize: 790 3)
				else
					(gEgo normalize: 790 1)
				)
				(dropOff dispose:)
				(= cycles 1)
			)
			(6
				(gLongSong play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDoor5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local84 1)
				(maid init: hide:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 131 138 self)
			)
			(2
				(gLongSong pause:)
				(maid show:)
				(gEgo
					view: 407
					loop: 0
					cel: 0
					x: 130
					y: 138
					setCycle: CT 3 1 self
				)
				(sFX number: 922 play:)
			)
			(3
				(maid setCycle: End self)
			)
			(4
				((ScriptID 2000 3) winX: 120 winY: 100 tailPosn: 0) ; PepperTalker
				(offScreen winX: 155 winY: 92 tailPosn: 0)
				(gMessager say: 8 7 5 1 self) ; "EEEEEEEEEEEEEEE!"
			)
			(5
				(sFX number: 4005 loop: 1 play:)
				(gMessager say: 8 7 5 2 self) ; "SHUT THAT DOOR!!!"
			)
			(6
				(gEgo setCycle: CT 4 1 self)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(gMessager say: 8 7 5 3 self) ; "...Oops."
			)
			(9
				(sFX number: 923 play:)
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(maid dispose:)
				(gEgo normalize: 790 3)
				(= cycles 1)
			)
			(10
				(gLongSong play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDoor7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local86 1)
				(elvis init: hide:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 131 138 self)
			)
			(2
				(gLongSong pause:)
				(elvis show:)
				(gEgo
					view: 407
					loop: 0
					cel: 0
					x: 130
					y: 138
					setCycle: CT 3 1 self
				)
				(sFX number: 922 play:)
			)
			(3
				((ScriptID 2000 3) winX: 120 winY: 90 tailPosn: 0) ; PepperTalker
				(sFX number: 404 play:)
				(gMessager say: 10 7 9 1 self) ; "Ooh baby baby, uh-huh uh-huh uh-huh!"
			)
			(4
				(elvis setCycle: End self)
			)
			(5
				(elvis loop: 1 cel: 0 setCycle: End self)
			)
			(6
				(elvis loop: 2 cel: 0 setCycle: End self)
			)
			(7
				(elvis loop: 0 cel: 15 setCycle: Beg self)
			)
			(8
				(gMessager say: 10 7 9 2 self) ; "SCARY!"
			)
			(9 0)
			(10
				(gEgo setCycle: CT 4 1 self)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(sFX number: 923 play:)
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(elvis dispose:)
				(gEgo normalize: 790 3)
				(= cycles 1)
			)
			(13
				(gLongSong play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if
			(and
				(== state 9)
				(or (>= (sFX prevSignal:) 10) (== (sFX prevSignal:) -1))
			)
			(self cue:)
		)
		(super doit:)
	)
)

(instance sOpenDoor8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local89 1)
				(= cycles 1)
			)
			(1
				(self setScript: sOpenWhichDoor self)
			)
			(2
				(if (== (Maze facingDir:) 1)
					((ScriptID 2000 3) winX: 55 winY: 120 tailPosn: 1) ; PepperTalker
				else
					((ScriptID 2000 3) winX: 125 winY: 110 tailPosn: 0) ; PepperTalker
				)
				(gMessager say: 11 7 11 1 self) ; "Uh-oh..."
				(= local88 1)
			)
			(3
				(gLongSong pause:)
				(if (== (Maze facingDir:) 1)
					(self setScript: sOpenEast8Door self)
				else
					(self setScript: sOpenWest8Door self)
				)
			)
			(4
				(sFX2 fade:)
				(gLongSong play:)
				(gEgo normalize: 790)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenEast8Door of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFX2 number: 4007 play:)
				(stuffFalls
					loop: 2
					x: 235
					y: 155
					signal: 16384
					cycleSpeed: 3
					init:
					setCycle: End self
				)
			)
			(1
				((ScriptID 2000 3) winX: 55 winY: 120 tailPosn: 1) ; PepperTalker
				(gMessager say: 11 7 11 2 3 self) ; "YIKES!"
			)
			(2
				(stuffFalls addToPic:)
				(openDoor loop: 3 cel: 0 x: 264 y: 160 init: addToPic:)
				(= cycles 1)
			)
			(3
				(gEgo
					setScale: Scaler 131 100 189 141
					normalize: 790 0
					setLoop: 0
					posn: 228 157
					setSpeed: 4
					setCycle: Rev
					setMotion: MoveTo 150 (gEgo y:) self
				)
			)
			(4
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(self dispose:)
			)
		)
	)
)

(instance sOpenWest8Door of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFX2 number: 4007 play:)
				(stuffFalls
					view: 443
					loop: 1
					cel: 0
					x: 85
					y: 156
					signal: 16384
					cycleSpeed: 3
					init:
					setCycle: End self
				)
			)
			(1
				(gMessager say: 11 7 11 2 3 self) ; "YIKES!"
			)
			(2
				(stuffFalls addToPic:)
				(openDoor view: 405 loop: 4 cel: 0 x: 54 y: 158 init: addToPic:)
				(= cycles 1)
			)
			(3
				(gEgo
					setScale: Scaler 131 100 189 141
					normalize: 790 1
					setLoop: 1
					posn: 94 162
					setSpeed: 4
					setCycle: Rev
					setMotion: MoveTo 150 (gEgo y:) self
				)
			)
			(4
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(self dispose:)
			)
		)
	)
)

(instance sOpenDoor9 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(sFX number: 4001 play:)
				(= cycles 1)
			)
			(2
				(offScreen2
					winX: (offScreen winX:)
					winY: (- (offScreen winY:) 20)
					tailPosn: (offScreen tailPosn:)
					talkWidth: 170
				)
				(gMessager say: 12 7 0 0 self) ; "The door is locked."
			)
			(3
				(if (== (Maze facingDir:) 8)
					(gEgo normalize: 790 0)
				else
					(gEgo normalize: 790 1)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sListenDoor6 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong pause:)
				(= cycles 1)
			)
			(1
				(sFX number: 405 play:)
				(if (not local85)
					(= temp0 3)
					(= local85 1)
				else
					(= temp0 4)
				)
				(gMessager say: 9 6 temp0 0 self)
			)
			(2
				(sFX fade:)
				(gGame handsOn:)
				(gLongSong play:)
				(self dispose:)
			)
		)
	)
)

(instance sLookAtDoor of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(= temp0 0)
				(switch (Maze whichDoor:)
					(1
						(= temp1 4)
					)
					(2
						(= temp1 5)
					)
					(3
						(= temp1 6)
						(if (not local83)
							(= temp0 1)
						else
							(= temp0 2)
						)
					)
					(4
						(= temp1 7)
					)
					(5
						(= temp1 8)
						(if (not local84)
							(= temp0 5)
						else
							(= temp0 6)
						)
					)
					(6
						(client setScript: sListenDoor6)
					)
					(7
						(= temp1 10)
					)
					(8
						(= temp1 11)
						(if (not local88)
							(= temp0 11)
							(= local88 1)
						else
							(= temp0 12)
						)
					)
					(9
						(offScreen2
							winX: (offScreen winX:)
							winY: (- (offScreen winY:) 20)
							tailPosn: (offScreen tailPosn:)
							talkWidth: 170
						)
						(= temp1 12)
						(if (not local90)
							(= temp0 3)
							(= local90 1)
						else
							(= temp0 4)
						)
					)
					(10
						(gGame points: 387 1)
						(= temp1 15)
						(if (== gEgo (ScriptID 895 0)) ; pepper
							(= temp0 13)
						else
							(= temp0 15)
						)
					)
				)
				(if (== gEgo (ScriptID 895 1)) ; lockjaw
					(= temp0 19)
				)
				(if (!= (Maze whichDoor:) 6)
					(gMessager say: temp1 6 temp0 0 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBackFromLJsRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame setEgo: (ScriptID 895 0)) ; pepper
				(saveHimTimer setReal: saveHimTimer 40)
				(gEgo hide:)
				(= cycles 2)
			)
			(1
				(localproc_1)
				(= cycles 1)
			)
			(2
				(gEgo posn: 64 164 cel: 1 show:)
				(Maze facingDir: 4 rowNo: 1 columnNo: 0 showRoom: self)
			)
			(3
				(= ticks 60)
			)
			(4
				(if (== ((gInventory at: 7) owner:) gCurRoomNum) ; Ima_s_Room_Key
					(gGame handsOn:)
					(SetCursor 100 0)
					(self dispose:)
				else
					(client setScript: sButlerGotcha)
				)
			)
		)
	)
)

(instance sBackFromReset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame setEgo: (ScriptID 895 0)) ; pepper
				(gEgo hide:)
				((ScriptID 895 1) init: hide:) ; lockjaw
				(= cycles 2)
			)
			(1
				(localproc_1)
				(= cycles 1)
			)
			(2
				(Maze facingDir: 4 rowNo: 1 columnNo: 0)
				(= cycles 1)
			)
			(3
				(self setScript: sShowRoom self)
			)
			(4
				(gGame handsOn:)
				(SetCursor 100 0)
				(self dispose:)
			)
		)
	)
)

(instance sUseMagnet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 388 2)
				(= cycles 1)
			)
			(1
				(= local80 (gEgo moveSpeed:))
				(gEgo setMotion: PolyPath 76 157 self)
			)
			(2
				(gEgo setHeading: 180 setSpeed: 5 get: 7) ; Ima_s_Room_Key
				(= cycles 1)
			)
			(3
				(gEgo
					view: 401
					loop: 3
					cel: 0
					posn: (- (gEgo x:) 10) (+ (gEgo y:) 1)
					setCycle: End self
				)
				(sFX number: 931 play:)
				(glint dispose:)
				(glintFea dispose:)
			)
			(4
				(gEgo
					normalize: 790 2
					posn: (+ (gEgo x:) 10) (- (gEgo y:) 1)
					setSpeed: local80
				)
				(= cycles 1)
			)
			(5
				(gMessager say: 14 71 0 0 self) ; "I've got it! Oh, I'm just TOO good."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUseKeyLJDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 389 2)
				(saveHimTimer dispose: delete:)
				(= cycles 1)
			)
			(1
				(SetFlag 90)
				(= local80 (gEgo moveSpeed:))
				(gEgo
					setMotion:
						PolyPath
						(+ (mazeDoor x:) 4)
						(+ (mazeDoor y:) 6)
						self
				)
			)
			(2
				(gEgo stopUpd:)
				(= cycles 1)
			)
			(3
				((ScriptID 2004 0) winX: 101 winY: 124 tailPosn: 0) ; LockjawTalker
				(gMessager say: 15 32 13 1 self) ; "Here you go, boy!"
			)
			(4
				(sFX number: 928 play:)
				(gEgo view: 406 loop: 0 cel: 0 setCycle: CT 6 1 self)
			)
			(5
				(openDoor view: 405 loop: 4 cel: 0 x: 54 y: 156 init: stopUpd:)
				(= cycles 1)
			)
			(6
				(gEgo
					view: 402
					loop: 0
					cel: 0
					setSpeed: 5
					x: 101
					y: 155
					setCycle: End self
				)
			)
			(7
				((ScriptID 895 0) setScript: sDoSong) ; pepper
				(gEgo stopUpd:)
				(= cycles 1)
			)
			(8
				(gMessager say: 15 32 13 2 self) ; "Ha ha ha! I love you too, silly boy. Come on, let's blow this pop stand!"
			)
			(9
				(gEgo loop: 1 cel: 0 x: 103 y: 154 setCycle: End self)
			)
			(10
				(gEgo stopUpd:)
				(sFX number: 900 play:)
				(gMessager say: 15 32 13 3 self) ; "ARF!"
			)
			(11
				(gMessager say: 15 32 13 4 self) ; "Geez, I hope I can find my way back out of this joint! We could be lost in here for DAYS! Okay, let's see. Which way do we go..."
			)
			(12
				(sFX number: 900 play:)
				(gMessager say: 15 32 13 5 self) ; "WOOF! ARF!"
			)
			(13
				(openDoor dispose:)
				(= cycles 1)
			)
			(14
				(gEgo
					loop: 2
					cel: 0
					x: (+ (gEgo x:) 2)
					y: (gEgo y:)
					setCycle: End self
				)
			)
			(15
				((ScriptID 895 1) ; lockjaw
					normalize: 807 0
					posn: 113 154
					setPri: (+ (gEgo priority:) 1)
					show:
				)
				(gEgo normalize: 790 2 setSpeed: local80)
				(= cycles 1)
			)
			(16
				((ScriptID 895 1) setMotion: MoveTo 95 178 self) ; lockjaw
			)
			(17
				(gMessager say: 15 32 13 6 self) ; "SHH! They'll hear us! ...Say, are you trying to tell me something? You think you can find your way out? Okay, go for it, boy!"
			)
			(18
				(gGame setEgo: (ScriptID 895 1)) ; lockjaw
				((ScriptID 2004 0) winX: 0 winY: 0) ; LockjawTalker
				((ScriptID 895 1) stopUpd:) ; lockjaw
				(gGame handsOn:)
				(SetCursor 100 0)
				(self dispose:)
			)
		)
	)
)

(instance sDoSong of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 402 loop: 1 play: self)
			)
			(1
				(gLongSong number: 401 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance sButlerGotcha of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 13 0 16 1 self) ; "We've gotta hurry, Lockjaw! Somebody might--"
			)
			(2
				(if (< (gEgo x:) 150)
					(gEgo setMotion: PolyPath 90 154 self)
				else
					(gEgo setMotion: PolyPath 219 156 self)
				)
			)
			(3
				(gMessager say: 13 0 16 2 self) ; "HEY! What are you doing? Get over here, you little rascal!"
				(butler
					init:
					setCycle: Walk
					setMotion: PolyPath (butler x:) (- (butler y:) 40) self
				)
			)
			(4 0)
			(5
				(gMessager say: 13 0 16 3 self) ; "I am SOOOOO tired of this..."
			)
			(6
				(= global199 12)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sLockjawsDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 391 3)
				(gEgo view: 401 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(sFX number: 4001 play:)
				(gEgo setCycle: End self)
			)
			(2
				(gMessager say: 15 7 13 0 self) ; "Shoot! The door is locked! Lockjaw, can you try to find a way out, boy? Hurry! We don't have much time!"
			)
			(3
				(gLongSong number: 403 play:)
				(= cycles 1)
			)
			(4
				(gCurRoom newRoom: 410)
			)
		)
	)
)

(instance mazeDoor of View
	(properties
		view 400
		signal 16384
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(= temp1 0)
		(switch theVerb
			(6 ; Look
				(gCurRoom setScript: sLookAtDoor)
			)
			(30 ; Paw
				(if (== (Maze whichDoor:) 3)
					(= temp1 1)
				)
				(gMessager say: (self noun:) 30 temp1)
			)
			(86 ; Nose
				(= gDictionaryWord 65)
				(gMessager say: (self noun:) 86)
			)
			(89 ; Teeth
				(gMessager say: (self noun:) 89)
			)
			(32 ; Ima_s_Room_Key
				(if (== (Maze whichDoor:) 10)
					(gCurRoom setScript: sUseKeyLJDoor)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(71 ; Magnet
				(if (== (Maze whichDoor:) 10)
					(cond
						((gEgo has: 7) ; Ima_s_Room_Key
							(gMessager say: 15 71 21) ; "Pepper doesn't need to use the magnet anymore. She just needs to rescue Lockjaw and get OUT of here!"
						)
						((gCast contains: glint)
							(gCurRoom setScript: sUseMagnet)
						)
						(else
							(gMessager say: 15 71 20) ; "That's an interesting idea. Why don't you try it somewhere else?"
						)
					)
				else
					(gMessager say: 1 88) ; "That won't do anything for Pepper."
				)
			)
			(7 ; Do
				(= temp1 0)
				(switch (Maze whichDoor:)
					(1
						(gCurRoom setScript: sOpenDoor1)
					)
					(2
						(gCurRoom setScript: sOpenDoor2)
					)
					(3
						(= temp0 6)
						(if (not local83)
							(gCurRoom setScript: sOpenDoor3)
						else
							(= temp1 2)
							(sFX number: 928 play:)
							(gMessager say: temp0 7 temp1 0)
						)
					)
					(4
						(= temp0 7)
						(if (not local82)
							(gCurRoom setScript: sOpenDoor4)
						else
							(= temp1 4)
							(sFX number: 928 play:)
							(gMessager say: 7 7 4 0) ; "No way! Do I look like a bird to you?"
						)
					)
					(5
						(if (not local84)
							(gCurRoom setScript: sOpenDoor5)
						else
							(gMessager say: 8 7 6 0) ; "The door is locked."
							(sFX number: 928 play:)
						)
					)
					(6
						(= temp0 9)
						(if (not local85)
							(= temp1 7)
						else
							(= temp1 8)
						)
						(gMessager say: temp0 7 temp1 0)
					)
					(7
						(= temp0 10)
						(if (not local86)
							(gCurRoom setScript: sOpenDoor7)
						else
							(= temp1 10)
							(sFX number: 928 play:)
							(gMessager say: temp0 7 temp1 0)
						)
					)
					(8
						(if (not local89)
							(gCurRoom setScript: sOpenDoor8)
						else
							(gMessager say: 11 7 12 0) ; "The door is locked."
							(sFX number: 928 play:)
						)
					)
					(9
						(gCurRoom setScript: sOpenDoor9)
					)
					(10
						(cond
							((gCast contains: glint)
								(super doVerb: theVerb &rest)
							)
							((not (== gPrevRoomNum 410))
								(gCurRoom setScript: sLockjawsDoor)
							)
							((not (gEgo has: 7)) ; Ima_s_Room_Key
								(gMessager say: 15 85 14) ; "I'll have you out of there in no time, buddy! Don't worry!"
							)
							(else
								(super doVerb: theVerb &rest)
							)
						)
					)
				)
			)
			(85 ; Talk
				(= temp1 0)
				(switch (Maze whichDoor:)
					(1
						(= temp0 4)
					)
					(2
						(= temp0 5)
					)
					(3
						(= temp0 6)
						(if local83
							(= temp1 2)
						else
							(= temp1 1)
						)
					)
					(4
						(= temp0 7)
					)
					(5
						(= temp0 8)
						(if (not local84)
							(= temp1 5)
						else
							(= temp1 6)
						)
					)
					(6
						(= temp0 9)
						(if (not local85)
							(= temp1 7)
						else
							(= temp1 8)
						)
					)
					(7
						(= temp0 10)
						(if (not local86)
							(= temp1 9)
						else
							(= temp1 10)
						)
					)
					(8
						(= temp0 11)
						(cond
							((not local89)
								(= temp1 7)
							)
							((not local88)
								(= temp1 8)
							)
							(else
								(= temp1 12)
							)
						)
					)
					(9
						(= temp0 12)
						(if (not local90)
							(= temp1 7)
						else
							(= temp1 8)
						)
					)
					(10
						(= temp0 15)
						(gGame points: 386 1)
						(if (== gEgo (ScriptID 895 0)) ; pepper
							(if (not local91)
								(= temp1 13)
								(= local91 1)
							else
								(= temp1 14)
							)
						else
							(= temp1 15)
						)
					)
				)
				(gMessager say: temp0 85 temp1 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mazeHallN of View
	(properties
		x 190
		y 135
		noun 3
		view 400
		signal 16385
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 65)
		(super doVerb: theVerb)
	)
)

(instance mazeHallW of View
	(properties
		x 12
		y 184
		noun 3
		approachX 57
		approachY 161
		_approachVerbs 4
		view 400
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(mazeHallN doVerb: theVerb)
	)
)

(instance mazeHallE of View
	(properties
		x 304
		y 185
		noun 3
		approachX 252
		approachY 167
		_approachVerbs 4
		view 400
		loop 1
		signal 16385
	)
)

(instance overHall of View
	(properties
		x 147
		y 281
		z 200
		noun 3
		sightAngle 40
		view 400
		cel 2
		signal 16385
	)
)

(instance openDoor of View
	(properties
		x 54
		y 158
		view 405
		loop 4
		signal 16384
	)
)

(instance purpleCat of Actor
	(properties
		view 403
		signal 16384
		illegalBits 0
	)
)

(instance maid of Prop
	(properties
		x 136
		y 83
		view 407
		loop 1
		priority 10
		signal 16
	)
)

(instance stuffFalls of Prop
	(properties
		x 85
		y 156
		noun 16
		view 443
		loop 1
	)
)

(instance dropOff of Prop
	(properties
		x 131
		y 134
		view 405
		cel 3
		priority 10
		signal 16400
	)
)

(instance elvis of Prop
	(properties
		x 136
		y 84
		view 404
		priority 10
		signal 16
	)
)

(instance glintFea of Feature
	(properties
		x 65
		y 150
		noun 14
		nsTop 143
		nsLeft 53
		nsBottom 157
		nsRight 78
		sightAngle 40
	)

	(method (doVerb theVerb)
		(glint doVerb: theVerb)
	)
)

(instance glint of View
	(properties
		x 50
		y 153
		noun 14
		view 401
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(71 ; Magnet
				(gCurRoom setScript: sUseMagnet)
			)
			((OneOf theVerb 85 7 6 86 30 89 84) ; Talk, Do, Look, Nose, Paw, Teeth, Trivia
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 14 19) ; "That won't help Pepper get the key. She'd better hurry...!"
			)
		)
	)
)

(instance outView of View ; UNUSED
	(properties
		x 38
		y 163
		view 400
		loop 9
		priority 15
		signal 16400
	)
)

(instance butler of Actor
	(properties
		x 150
		y 210
		view 820
		loop 3
	)
)

(instance lamp1 of Feature
	(properties
		x 73
		y 56
		noun 2
		nsTop 34
		nsLeft 59
		nsBottom 78
		nsRight 87
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(= gDictionaryWord 51)
				(super doVerb: theVerb &rest)
			)
			(84 ; Trivia
				(= gDictionaryWord 51)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lamp2 of Feature
	(properties
		x 109
		y 58
		noun 2
		nsTop 36
		nsLeft 93
		nsBottom 80
		nsRight 125
		sightAngle 40
	)

	(method (doVerb theVerb)
		(lamp1 doVerb: theVerb)
	)
)

(instance lamp3 of Feature
	(properties
		x 205
		y 61
		noun 2
		nsTop 42
		nsLeft 189
		nsBottom 81
		nsRight 222
		sightAngle 40
	)

	(method (doVerb theVerb)
		(lamp1 doVerb: theVerb)
	)
)

(instance lamp4 of Feature
	(properties
		x 239
		y 61
		noun 2
		nsTop 39
		nsLeft 225
		nsBottom 83
		nsRight 253
		sightAngle 40
	)

	(method (doVerb theVerb)
		(lamp1 doVerb: theVerb)
	)
)

(instance offScreen of BalloonTalker
	(properties
		talkWidth 150
	)
)

(instance offScreen2 of BalloonTalker
	(properties
		talkWidth 150
	)
)

(instance butTalker of BalloonTalker
	(properties
		x 133
		y 135
		talkWidth 150
	)
)

(instance saveHimTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: sButlerGotcha)
	)
)

(instance sFX of Sound
	(properties)
)

(instance sFX2 of Sound
	(properties)
)

(instance song of TwistySound ; UNUSED
	(properties
		nextSong 401
	)
)

