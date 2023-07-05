;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use SQNarrator)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm240 0
	Manager 1
)

(local
	local0
	local1
	local2
	local3
)

(instance rm240 of SQRoom
	(properties
		noun 1
		picture 240
	)

	(method (init)
		(gEgo setScaler: Scaler 100 70 95 70)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 18 70 23 78 8 88 9 123 114 114 144 128 240 128 265 137 306 137 306 126 269 122 228 113 224 108 189 108 176 90 172 90 162 109 135 108 126 103 77 103 88 73 29 73 26 70
					yourself:
				)
		)
		(Load rsVIEW 244)
		(if (== gPrevRoomNum 220)
			(gEgo posn: 176 90 setScript: sRogerEnters)
			(= local1 4)
			(elevCel init:)
			(manager init: setScript: sManager)
		else
			(manager init:)
			(cageDoor init:)
			(if (not (IsFlag 17))
				(gEgo init: normalize: posn: 0 72)
				(SetFlag 17)
				(blob init:)
				(blob setScript: sBlobScript)
			else
				(gEgo
					init:
					normalize:
					enterRoom: 0 72 20 70
					setScript: sEnterEgo
				)
			)
		)
		(gGSound1 number: 240 loop: -1 play:)
		(animation init: setScript: sTV)
		(if (not (IsFlag 151))
			(nigel init: setScript: sNigel)
			(singent init: setScript: sSingent)
		)
		(news setPri: 200 init: setScript: sCTV)
		(elevDoor init:)
		(elevLights init:)
		(elevatorButton init: approachVerbs: 4) ; Do
		(couch init:)
		(chair init:)
		(hd1 init:)
		(hd2 init:)
		(plant init:)
		(counter init: approachVerbs: 4) ; Do
		(dish init:)
		(fRegister init:)
		(farPlant init:)
		(counterPlant init:)
		(bell init: approachVerbs: 4) ; Do
		(exit320 init: gTheExitWCursor approachVerbs: 8) ; ExitLeft
		(if (IsFlag 18)
			(exit220 init: gTheExitCursor approachVerbs: 9) ; ExitUp
		)
		(PalCycle 0 212 214 -1 10) ; Start
		(PalCycle 0 228 232 -1 10) ; Start
	)

	(method (doit &tmp temp0)
		(if (<= (= temp0 (GetDistance (gEgo x:) (gEgo y:) 173 91)) 5)
			(PalVary 0 245 0 (- 100 (* temp0 20)) 64 79) ; PalVaryStart
		)
		(super doit:)
	)

	(method (dispose)
		(PalVary 3) ; PalVaryKill
		(gEgo setScale: 0)
		(super dispose:)
	)
)

(instance sBlobScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: DPath 20 70 30 77)
				(= ticks 100)
			)
			(1
				(manager view: 2440 loop: 1 cel: 0 setCycle: Fwd)
				(blob cycleSpeed: 12 setCycle: CT 4 1)
				(= ticks 300)
			)
			(2
				(blob cel: 5 setCycle: End self)
				(manager view: 2440 loop: 0 cel: 3 setCycle: Beg self)
			)
			(3)
			(4
				(manager view: 244 loop: 0 cel: 7 setCycle: Beg)
				(blob
					posn: 173 88
					setPri: 100
					loop: 1
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(5
				(arrowSnd play: 127 0)
				(arrow cel: 0 init:)
				(blob cel: 5 setCycle: End self)
			)
			(6
				(manager setScript: sManager)
				(doorSound number: 241 play: 80 0)
				(elevDoor loop: 3 cel: 0 setCycle: End self)
			)
			(7
				(doorSound play: 80 0)
				(cageDoor loop: 2 cel: 0 setCycle: End self)
			)
			(8
				(blob
					setPri: 90
					ignoreActors: 1
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(9
				(gGame handsOn:)
				(doorSound number: 242 play: 80 0)
				(cageDoor loop: 2 cel: 9 setCycle: Beg self)
			)
			(10
				(doorSound play: 80 0)
				(elevDoor loop: 3 cel: 6 setCycle: Beg self)
			)
			(11
				(blob hide:)
				(cageDoor hide:)
				(blobGoingUp init: setCycle: End self)
			)
			(12
				(elevLights cycleSpeed: 12 cel: 0 setCycle: CT 6 1 self)
			)
			(13
				(arrow cel: 1 init:)
				(= cycles 1)
			)
			(14
				(elevLights cel: 6 setCycle: CT 0 -1 self)
			)
			(15
				(blobGoingUp dispose:)
				(elevCel init: cel: 15 setCycle: Beg self)
			)
			(16
				(arrow dispose:)
				(elevCel dispose:)
				(cageDoor show:)
				(blob dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 4)
				(elevLights cel: 9 setCycle: Beg self)
			)
			(1
				(arrow cel: 1 init:)
				(elevCel cel: 15 setCycle: Beg self)
			)
			(2
				(elevCel dispose:)
				(arrow hide:)
				(gEgo normalize: ignoreActors: 1 init:)
				(cageDoor init:)
				(doorSound number: 241 play: 80 0)
				(elevDoor loop: 3 cel: 0 setCycle: End self)
			)
			(3
				(doorSound play: 80 0)
				(cageDoor loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setMotion: PolyPath 176 110 self)
			)
			(5
				(gEgo ignoreActors: 0)
				(doorSound number: 242 play: 80 0)
				(cageDoor loop: 2 cel: 9 setCycle: Beg self)
			)
			(6
				(doorSound play: 80 0)
				(elevDoor loop: 3 cel: 6 setCycle: Beg self)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerGoesInElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 5)
				(gEgo
					view: 240
					loop: 0
					cel: 0
					ignoreActors: 1
					setCycle: End self
				)
			)
			(1
				(arrowSnd play: 127 0)
				(arrow cel: 0 init:)
				(gEgo cel: 4 setCycle: Beg)
				(doorSound number: 241 play: 80 0)
				(elevDoor setCycle: End self)
			)
			(2
				(doorSound number: 241 play: 80 0)
				(cageDoor setCycle: End self)
			)
			(3
				(gEgo
					normalize: 3
					ignoreActors: 1
					setMotion: MoveTo 176 90 self
				)
			)
			(4
				(gEgo setHeading: 180 self)
			)
			(5
				(doorSound number: 242 play: 80 0)
				(cageDoor cel: 9 setCycle: Beg self)
			)
			(6
				(doorSound number: 242 play: 80 0)
				(elevDoor cel: 6 setCycle: Beg self)
			)
			(7
				(gEgo hide:)
				(cageDoor dispose:)
				(elevCel init: cel: 0 setCycle: End self)
			)
			(8
				(elevLights cel: 0 setCycle: End)
				(= ticks (Random 20 50))
			)
			(9
				(gEgo ignoreActors: 0)
				(gCurRoom newRoom: 220)
				(self dispose:)
			)
		)
	)
)

(instance sThugsWatch of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCTV of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 (Random 0 3))
				(= cycles 1)
			)
			(1
				(news loop: local2 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sTV of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 (Random 4 6))
				(= cycles 1)
			)
			(1
				(animation
					loop: local3
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sSingent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(singent cel: 0 setCycle: End self)
			)
			(1
				(= ticks 60)
			)
			(2
				(singent cel: 8 setCycle: Beg self)
			)
			(3
				(= ticks 400)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sNigel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nigel cel: 0 setCycle: End self)
			)
			(1
				(= ticks 60)
			)
			(2
				(nigel cel: 6 setCycle: Beg self)
			)
			(3
				(= ticks 400)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sManager of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (Random 0 2)
					(manager view: 241 loop: 0 cel: 0 setCycle: End)
				)
				(= ticks 30)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance sManagerIgnoresRoger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sManager dispose:)
				(= cycles 1)
			)
			(1
				(manager setLoop: 1 setCycle: End self)
			)
			(2
				(= ticks 60)
			)
			(3
				(manager cel: 1 setCycle: Beg self)
			)
			(4
				(gEgo normalize: setLoop: 0)
				(manager setScript: sManager)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sManagerScratches of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sManager dispose:)
				(= cycles 1)
			)
			(1
				(manager loop: 2 setCycle: End self)
			)
			(2
				(manager loop: 3 setCycle: Fwd)
				(= ticks 120)
			)
			(3
				(gMessager say: 7 2 0 0 self) ; "He seems to be ignoring you."
			)
			(4
				(manager loop: 2 cel: 3 setCycle: Beg self)
			)
			(5
				(gEgo normalize: setLoop: 0)
				(manager setScript: sManager)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sManagerTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sManager dispose:)
				(gMessager say: 7 2 1 0 self) ; "Uh, excuse me. I'd like a room, please."
			)
			(1
				(gEgo normalize: 0)
				(manager setScript: sManager)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerPaysManager of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sManager dispose:)
				(-= global150 300)
				(gEgo view: 249 loop: 0 cycleSpeed: 10 setCycle: End self)
			)
			(1
				(if (<= global150 0)
					(gEgo put: 13) ; Buckazoids
				else
					((gInventory at: 13) select: 0 1) ; Buckazoids
				)
				(gEgo normalize: 6)
				(gMessager say: 7 64 4 1 self) ; "Okay, Son. You just scribble your ol' Bill Shatner on the register screen and I'll get your keycard. It's as fine a room as you'll find on this orb."
			)
			(2
				(gEgo setMotion: MoveTo 226 112 self)
			)
			(3
				(gEgo setHeading: 90 self)
			)
			(4
				(gEgo view: 2490 setLoop: 0 1 setCycle: End self)
			)
			(5
				(gMessager say: 7 64 4 2 self) ; "You have a brief moment of what you think is cleverness."
			)
			(6
				(gEgo view: 2490 setLoop: 1 1 setCycle: End)
				(manager view: 244 loop: 0 cel: 0 setCycle: End self)
			)
			(7
				(gMessager say: 7 64 4 3 self) ; "You decide to wittily sign the name "Fronzel Neekburm"."
			)
			(8
				(gEgo loop: 2 cel: 0 setCycle: End)
				(manager loop: 1 cel: 0 setCycle: End self)
			)
			(9
				(gEgo loop: 1 cel: 1 setCycle: Beg)
				(manager loop: 2 cel: 0 setCycle: End self)
			)
			(10
				(gEgo loop: 0 cel: 6 setCycle: Beg)
				(manager loop: 4 cel: 0 setCycle: CT 6 1 self)
			)
			(11
				(gEgo normalize: 0)
				(keys setPri: 118 init:)
				(manager cel: 7 setCycle: End self)
			)
			(12
				(manager loop: 0 cel: 7 setCycle: Beg self)
			)
			(13
				(gMessager say: 7 64 4 4 self) ; "Okay, here's your keycard. Don't lose it. Room 1220 J. Up the elevator."
			)
			(14
				(gMessager sayRange: 7 64 4 5 8 self) ; "Fronzel Neekburm. If I had a buckazoid for every time I've seen that name I'd be sittin' pretty. I could afford one of those fancy furlined doughnut thingies ... uh, what was I sayin'?"
			)
			(15
				(gEgo setMotion: PolyPath 245 119 self)
			)
			(16
				(gEgo view: 249 loop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(17
				(gGame points: 3 472)
				(keys dispose:)
				(gEgo get: 59 cel: 4 setCycle: End self) ; Hotel_Keycard
			)
			(18
				(gEgo normalize: 0)
				(manager setScript: sManager)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance elevCel of Actor
	(properties
		x 166
		y 48
		view 2401
		loop 5
		cel 15
	)
)

(instance blobGoingUp of Actor
	(properties
		x 166
		y 48
		view 2401
		loop 4
	)
)

(instance blob of Actor
	(properties
		x 237
		y 114
		view 245
	)
)

(instance arrow of Prop
	(properties
		noun 8
		sightAngle 361
		x 137
		y 55
		view 2401
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100)
	)
)

(instance elevLights of Prop
	(properties
		x 174
		y 19
		view 2401
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 200)
	)
)

(instance cageDoor of Prop
	(properties
		noun 8
		sightAngle 360
		x 204
		y 93
		view 2401
		loop 2
	)
)

(instance elevDoor of Prop
	(properties
		noun 8
		sightAngle 360
		x 195
		y 95
		view 2401
		loop 3
	)
)

(instance manager of Prop
	(properties
		noun 7
		sightAngle 367
		approachX 248
		approachY 117
		x 283
		y 84
		view 241
		loop 4
		signal 18433
		cycleSpeed 7
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 2 67 64) ; Do, Talk, Alien_ID, Buckazoids
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(cond
					((not (IsFlag 19))
						(cond
							((IsFlag 18)
								(SetFlag 19)
								(gMessager say: 7 2) ; "He seems to be ignoring you."
							)
							((== local0 0)
								(gGame points: 1 473)
								(= local0 1)
								(gCurRoom setScript: sManagerScratches)
							)
							((== local0 1)
								(SetFlag 19)
								(= local0 0)
								(gCurRoom setScript: sManagerTalks)
							)
						)
					)
					((== local0 0)
						(if (IsFlag 18)
							(= local0 1)
							(gMessager say: 7 64 8) ; "I'm sure he'd like that, but you'd better hang on to what you've got. You never know when you'll need it."
						else
							(gMessager say: 7 2 6) ; "I'm busy, Son. When you give me 300 buckazoids, then we'll talk. I'm real busy. See ya."
						)
					)
					((IsFlag 18)
						(gMessager say: 7 2) ; "He seems to be ignoring you."
					)
					(else
						(gMessager say: 7 2 3) ; "Listen, I got no time allocated for deadbeats. I'm a busy executive. You want a room, you gotta shell out the units. Don't bug me unless you're serious about doin' some business. Now beat it. Tourists! My job would be so much easier without 'em."
					)
				)
			)
			((== theVerb 64) ; Buckazoids
				(if (not (IsFlag 18))
					(if (and (>= global150 300) (gEgo has: 13)) ; Buckazoids
						(exit220 init: gTheExitCursor approachVerbs: 9) ; ExitUp
						(SetFlag 18)
						(gCurRoom setScript: sRogerPaysManager)
					else
						(gMessager say: 7 64 7) ; "Hey, what's the deal?! Come back when you get some more allowance, Sonny."
					)
				else
					(gMessager say: 7 64 8) ; "I'm sure he'd like that, but you'd better hang on to what you've got. You never know when you'll need it."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nigel of Prop
	(properties
		noun 12
		x 88
		y 151
		priority 151
		view 242
		signal 20513
		cycleSpeed 12
	)
)

(instance singent of Prop
	(properties
		noun 12
		x 211
		y 144
		priority 144
		view 242
		loop 1
		cel 1
		signal 20513
		cycleSpeed 12
	)
)

(instance animation of Prop
	(properties
		noun 5
		x 273
		y 22
		view 248
		loop 4
	)
)

(instance news of Prop
	(properties
		noun 5
		x 74
		y 43
		view 248
	)
)

(instance keys of View
	(properties
		x 264
		y 83
		view 244
		loop 5
	)
)

(instance exit320 of ExitFeature
	(properties
		sightAngle 0
		approachX 20
		approachY 70
		nextRoom 320
		message 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 39 0 39 20 39 69 6 74 0 74
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; ExitLeft
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 0 72 self)
				(SetFlag 17)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(super doVerb: 8)
	)
)

(instance exit220 of ExitFeature
	(properties
		noun 8
		sightAngle 10
		approachX 171
		approachY 100
		x 176
		y 91
		nextRoom 220
		message 9
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 20 143 94 203 94 203 20
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; ExitUp
				(gCurRoom setScript: sRogerGoesInElevator)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance couch of Feature
	(properties
		noun 3
		sightAngle 40
		x 91
		y 118
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 45 122 69 105 85 101 112 99 119 107 138 111 138 118 132 133 128 134 127 130 99 138 46 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance chair of Feature
	(properties
		noun 3
		sightAngle 40
		x 232
		y 116
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 245 95 252 97 257 111 254 124 247 134 235 138 214 138 207 128 220 115 233 99
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hd1 of Feature
	(properties
		noun 5
		sightAngle 40
		x 79
		y 35
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 56 38 56 64 62 67 79 69 103 60 103 33 94 27 94 20 87 15 84 8 73 2 71 8 80 11 75 17 65 15 61 21 66 23 69 23 72 26 72 32
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance plant of Feature
	(properties
		noun 4
		sightAngle 40
		x 14
		y 122
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 137 4 130 10 126 9 116 13 120 16 107 20 115 25 129 25 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hd2 of Feature
	(properties
		noun 5
		sightAngle 40
		x 289
		y 24
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 259 18 259 44 285 49 314 46 316 17 310 13 312 4 318 4 319 0 281 0 274 12
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance counter of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 248
		approachY 117
		x 275
		y 78
		z 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 75 232 97 244 92 255 96 259 109 259 115 307 122 306 109 319 109 319 100 319 85 295 85 259 78 241 84
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fRegister of Feature
	(properties
		noun 11
		sightAngle 40
		x 246
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 243 75 236 77 241 80 254 77 256 75 249 71 246 73
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance dish of Feature
	(properties
		noun 13
		sightAngle 40
		x 238
		y 71
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 234 69 239 67 244 69 243 72 240 73 235 75 233 70
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance farPlant of Feature
	(properties
		noun 4
		sightAngle 40
		x 10
		y 73
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 9 68 13 70 15 75 19 78 10 77 5 79 3 77 2 72 5 68
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance counterPlant of Feature
	(properties
		noun 4
		sightAngle 40
		x 311
		y 122
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 112 312 112 303 119 304 122 310 117 319 117 318 121 310 122 304 129 312 132 319 127
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bell of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 248
		approachY 117
		x 257
		y 83
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 254 82 258 85 260 84 260 81
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 10 4) ; "You give the bell a pass with your hand. The manager doesn't exactly spring to life in response, but he does stir a bit and grants you a segment of one eye."
				(manager setScript: sManagerIgnoresRoger)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elevatorButton of Feature
	(properties
		sightAngle 360
		approachX 171
		approachY 100
		x 136
		y 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 133 53 140 53 140 67 133 67
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 18)
					(gCurRoom setScript: sRogerGoesInElevator)
				else
					(gMessager say: 8 4 3) ; "Hey! Where you goin', Son? That's for paying customers only."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Manager of SmallTalker
	(properties
		talkView 241
		talkLoop 4
	)

	(method (init)
		(= client manager)
		(super init:)
	)
)

(instance sound1 of Sound ; UNUSED
	(properties
		flags 1
	)
)

(instance sound2 of Sound ; UNUSED
	(properties
		flags 1
	)
)

(instance doorSound of Sound
	(properties
		flags 1
	)
)

(instance arrowSnd of Sound
	(properties
		flags 1
		number 243
	)
)

