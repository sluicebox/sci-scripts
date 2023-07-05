;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use n013)
(use ExitFeature)
(use Inset)
(use Polygon)
(use Feature)
(use Cursor)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm300 0
)

(local
	local0
	local1
)

(instance rm300 of Room
	(properties
		modNum 301
		noun 1
		picture 300
		style 14
		exitStyle 13
		east 310
		west 200
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 50) (not (OneOf newRoomNumber 300 310 320 302))) ; interrogation
			(gGkMusic1 fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (init)
		(super init:)
		(if (and (!= gPrevRoomNum 50) (!= gPrevRoomNum 50) (!= gPrevRoomNum 310)) ; interrogation, interrogation
			(gGkMusic1
				number: 300
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 5 10 0
			)
		else
			(gGkMusic1 setVol: (gGkMusic1 musicVolume:))
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 145 319 145 319 103 265 103 265 87 193 87 177 90 94 91 39 91 26 107 0 119 0 143
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 197 128 197 118 255 118 255 128
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 56 98 196 102 150 120 52 112
					yourself:
				)
		)
		(if (== gCurRoomNum ((ScriptID 301 1) tileLoc1:)) ; xKeeper
			((ScriptID 301 1) ignoreActors: 0 posn: 200 135 init:) ; xKeeper
			(= local1
				((Polygon new:)
					type: PBarredAccess
					init: 163 130 234 130 234 144 185 139
					yourself:
				)
			)
			(gCurRoom addObstacle: local1)
			(keeperTimer setReal: keeperTimer (Random 25 40))
		)
		(gEgo normalize: init: state: 2)
		(cond
			((IsFlag 246)
				(if (IsFlag 394)
					(gabeMessage setCel: 4)
				)
				(gabeMessage init: approachVerbs: 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			)
			((IsFlag 250) 0)
			((< gDay 5)
				(message1 init: approachVerbs: 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			)
			((not (== gPrevRoomNum 302))
				(message2 init: approachVerbs: 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			)
		)
		(offerings1 init:)
		(offerings2 init:)
		(snake init:)
		(fence init:)
		(plant1 init:)
		(plant2 init:)
		(vase1 init:)
		(vase2 init:)
		(vase3 init:)
		(laveauTomb init: approachVerbs: 7 66) ; Look, brick
		(plaque init: approachVerbs: 7) ; Look
		(rossTomb init: approachVerbs: 7) ; Look
		(tomb1 init: approachVerbs: 7) ; Look
		(tomb2 init: approachVerbs: 7) ; Look
		(tomb3 init: approachVerbs: 7) ; Look
		(tomb4 init: approachVerbs: 7) ; Look
		(tomb5 init: approachVerbs: 7) ; Look
		(if (and (not (gEgo has: 44)) (not (IsFlag 246))) ; brick
			(myBrick init: approachVerbs: 7 12) ; Look, Pickup
		)
		(angelFront init: approachVerbs: 7) ; Look
		(angelBack init: approachVerbs: 7) ; Look
		(westExit init:)
		(eastExit init:)
		(switch gPrevRoomNum
			(50 ; interrogation
				(self setScript: (ScriptID 301 4)) ; sStopTalkingToKeeper
			)
			(302
				(cond
					((IsFlag 246)
						(gCurRoom setScript: sCorrectMessage)
					)
					((IsFlag 247)
						(gCurRoom setScript: sIncorrectMessage)
					)
					(else
						(gGame handsOn:)
						(gEgo normalize: 6 posn: 96 120)
					)
				)
			)
			(310
				(gGame handsOn:)
				(gEgo normalize: posn: 310 130 setMotion: MoveTo 290 130)
			)
			(else
				(gGame handsOn:)
				(gEgo normalize: posn: 5 130 setMotion: MoveTo 25 130)
			)
		)
	)

	(method (dispose)
		(if ((gCurRoom obstacles:) contains: local1)
			((gCurRoom obstacles:) delete: local1)
			(local1 dispose:)
		)
		(keeperTimer client: 0 dispose: delete:)
		(DisposeScript 21)
		(super dispose:)
	)
)

(instance sCorrectMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 44) ; brick
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 11 0 12 0 self) ; "Pleased with his message, Gabriel tosses the brick down. Now, if only "dj" reads it in time!"
				(gEgo
					posn: 96 120
					view: 312
					setCel: 0
					setLoop: 1
					setSpeed: 8
					setCycle: End self
				)
			)
			(2 0)
			(3
				(gEgo getPoints: -999 5)
				(gGame handsOn:)
				(gEgo normalize: 6)
				(self dispose:)
			)
		)
	)
)

(instance sIncorrectMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 250)
					(self changeState: 2)
				else
					(gEgo
						posn: 96 120
						view: 311
						setCel: 0
						setLoop: 4
						setCycle: Fwd
					)
					(= seconds 4)
				)
			)
			(1
				(gMessager say: 11 0 13) ; "Sensing that his message isn't quite right, Gabriel rubs it off in frustration."
				(gEgo setCel: 4 setLoop: 3 setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(gEgo normalize: 6)
				(SetFlag 250)
				(self dispose:)
			)
		)
	)
)

(instance sCopyCode of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 311
					setCel: 0
					setLoop: 0
					setSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gMessager say: (if register 4 else 6) 15 (if register 2 else 5))
				(gEgo setCel: 0 setLoop: 1 setCycle: Fwd)
				(= seconds 5)
			)
			(2
				(gEgo setCel: 6 setLoop: 0 setCycle: Beg self)
			)
			(3
				(gGame handsOn:)
				(gEgo normalize: 6)
				(self dispose:)
			)
		)
	)
)

(instance sGoToCode of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 5 66 4 0 self) ; "I think I'll leave a message of my own."
			)
			(1
				(if (IsFlag 250)
					(self changeState: 6)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo view: 311 setCel: 0 setLoop: 3 setCycle: End self)
			)
			(3
				(gEgo setCel: 0 setLoop: 4 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(message2 dispose:)
				(= seconds 3)
			)
			(5
				(gEgo setCel: 4 setLoop: 3 setCycle: Beg self)
			)
			(6
				(gEgo view: 312 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(7
				(ClearFlag 250)
				(gCurRoom newRoom: 302)
			)
		)
	)
)

(instance sKeeperLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if ((gCurRoom obstacles:) contains: local1)
					((gCurRoom obstacles:) delete: local1)
					(local1 dispose:)
				)
				(gEgo setMotion: 0)
				((ScriptID 301 1) ; xKeeper
					ignoreActors: 1
					view: 304
					setCel: 0
					setLoop: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				((ScriptID 301 3) dispose:) ; trashCan
				((ScriptID 301 1) setCel: 5 setCycle: End self) ; xKeeper
			)
			(2
				((ScriptID 301 1) ; xKeeper
					tileLoc1: 310
					view: 306
					setCel: 0
					setLoop: 0
					setSpeed: 8
					setCycle: Fwd
					setMotion: MoveTo 360 135 self
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPickUpBrick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 311
					setCel: 0
					setLoop: 2
					get: 44 ; brick
					setCycle: CT 4 1 self
				)
			)
			(1
				(gMessager say: 3 12 0) ; "!!!Blank msg"
				(gEgo setCycle: End self)
				(myBrick dispose:)
			)
			(2
				(gEgo getPoints: -999 1)
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoTheInsetThang of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 7 0 0 self) ; "!!!Comment msg"
			)
			(1
				(gGame handsOn:)
				(if (gGame keepBar:)
					(gTheIconBar erase:)
				)
				(switch register
					(3022
						(theInView x: 44 y: 22 view: 3022 loop: 0 cel: 0)
						(codeCloseUpInset init: self rm300 1)
					)
					(3023
						(theInView x: 35 y: 22 view: 3023 loop: 0 cel: 0)
						(codeCloseUpInset init: self rm300 1)
					)
					(3024
						(theInView x: 142 y: 31 view: register loop: 0 cel: 0)
						(codeCloseUpInset init: self rm300 1)
					)
					(else
						(theInView x: 140 y: 31 view: register loop: 0 cel: 0)
						(codeCloseUpInset init: self rm300 1)
					)
				)
				(gCurRoom inset: codeCloseUpInset)
				(if (gGame keepBar:)
					(gTheIconBar draw:)
				)
			)
			(2
				(gGame handsOff:)
				(= cycles 2)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance vase1 of Feature
	(properties
		noun 3
		modNum 301
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 20
		approachY 107
		approachDist 39
		x 4
		y 105
		z 30
	)
)

(instance vase2 of Feature
	(properties
		noun 3
		modNum 301
		nsLeft 69
		nsTop 77
		nsRight 81
		nsBottom 91
		sightAngle 20
		approachX 57
		approachY 113
		approachDist 37
		x 75
		y 112
		z 28
	)
)

(instance angelFront of Feature
	(properties
		noun 2
		nsLeft 205
		nsTop 57
		nsRight 231
		nsBottom 106
		sightAngle 20
		approachX 190
		approachY 125
		approachDist 56
		x 218
		y 124
		z 43
	)
)

(instance angelBack of Feature
	(properties
		noun 1
		nsLeft 234
		nsTop 30
		nsRight 251
		nsBottom 64
		sightAngle 20
		approachX 259
		approachY 80
		approachDist 40
		x 242
		y 76
		z 29
	)
)

(instance plant1 of Feature
	(properties
		noun 4
		modNum 301
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		approachX 21
		approachY 107
		approachDist 58
		x 3
		y 101
		z 47
	)
)

(instance plant2 of Feature
	(properties
		noun 4
		modNum 301
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		approachX 248
		approachY 124
		x 311
		y 179
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 298 88 292 68 278 69 286 65 274 54 296 66 278 37 290 46 282 27 270 27 257 35 272 21 292 28 288 20 294 21 301 36 306 20 304 42 311 68 315 52 311 40 319 26 319 61 313 81 319 71 319 88
					yourself:
				)
		)
		(super init:)
	)
)

(instance offerings1 of Feature
	(properties
		noun 8
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		x 102
		y 108
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 108 92 84 97 100 107 101 108 111
					yourself:
				)
		)
		(super init:)
	)
)

(instance offerings2 of Feature
	(properties
		noun 8
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		x 165
		y 108
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 168 88 170 103 175 100 180 101 169 108 162 106 162 89
					yourself:
				)
		)
		(super init:)
	)
)

(instance vase3 of Feature
	(properties
		noun 3
		modNum 301
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 311
		y 179
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 273 124 278 115 286 111 287 98 281 94 284 80 296 80 299 87 319 87 319 145 287 145 284 140 283 128 279 126
					yourself:
				)
		)
		(super init:)
	)
)

(instance fence of Feature
	(properties
		noun 2
		modNum 301
		sightAngle 40
		x 45
		y 131
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 116 9 143 16 101 28 136 37 108 49 144 55 144 63 124 69 144 81 144 85 132 91 147 0 146
					yourself:
				)
		)
		(super init:)
	)
)

(instance snake of Feature
	(properties
		noun 7
		sightAngle 40
		x 254
		y 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 212 145 218 136 227 135 224 117 260 120 262 116 243 115 242 111 261 105 274 110 277 119 269 126 281 126 285 133 284 139 278 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance rossTomb of Feature
	(properties
		noun 10
		nsLeft 31
		nsTop 24
		nsRight 61
		nsBottom 87
		sightAngle 20
		approachX 41
		approachY 105
		x 46
		y 55
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 76 32 76 32 73 28 73 28 60 34 51 34 42 28 33 37 23 50 23 59 34 53 44 54 51 61 60 61 80 52 80 51 87 38 87
					yourself:
				)
		)
		(super init:)
	)
)

(instance plaque of Feature
	(properties
		noun 9
		nsLeft 145
		nsTop 100
		nsRight 150
		nsBottom 106
		sightAngle 20
		approachX 173
		approachY 125
		x 147
		y 103
	)
)

(instance laveauTomb of Feature
	(properties
		noun 5
		approachX 96
		approachY 120
		x 121
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 80 55 76 46 91 38 156 38 170 44 170 105 147 114 85 110
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					((IsFlag 246)
						(gMessager say: 5 7 7) ; "This is the tomb of Marie Laveau, "Voodoo queen" of New Orleans."
					)
					((IsFlag 250)
						(gMessager say: 5 7 10) ; "This is the tomb of Marie Laveau, "Voodoo queen" of New Orleans."
					)
					((== local0 3022)
						(gMessager say: 5 7 8) ; "This is the tomb of Marie Laveau, "Voodoo queen" of New Orleans."
					)
					((== local0 3023)
						(gMessager say: 5 7 9) ; "This is the tomb of Marie Laveau, "Voodoo queen" of New Orleans."
					)
				)
				(return 1)
			)
			(66 ; brick
				(cond
					((== ((ScriptID 301 1) tileLoc1:) 300) ; xKeeper
						(gMessager say: noun theVerb 18 1) ; "(GK-AM2)Gabriel should at least wait until the watchman is gone before defacing the tomb."
					)
					((IsFlag 246)
						(gMessager say: noun theVerb 7) ; "I don't want to rewrite it. It's perfect."
					)
					(
						(and
							(not (IsFlag 246))
							(IsFlag 249)
							(gEgo has: 32) ; VoodooCode1
							(gEgo has: 33) ; sVoodooCode
						)
						(gCurRoom setScript: sGoToCode)
					)
					(else
						(gMessager say: noun theVerb 1) ; "Gabriel likes the idea of leaving marks on the tomb, but at the moment he's not sure what to say or how to say it."
					)
				)
				(return 1)
			)
			(40 ; VoodooCode1
				(gMessager say: 6 theVerb 0) ; "(GK-AM2)Gabriel can't put his sketch back on the wall."
				(return 1)
			)
			(59 ; sVoodooCode
				(gMessager say: 6 theVerb 0) ; "(GK-AM2)Gabriel can't put his sketch back on the wall."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tomb1 of Feature
	(properties
		noun 12
		nsLeft 269
		nsTop 33
		nsRight 319
		nsBottom 101
		sightAngle 20
		approachX 248
		approachY 102
		x 294
		y 67
	)
)

(instance tomb2 of Feature
	(properties
		noun 13
		nsLeft 143
		nsTop 27
		nsRight 198
		nsBottom 85
		sightAngle 20
		approachX 195
		approachY 92
		x 170
		y 56
	)
)

(instance tomb3 of Feature
	(properties
		noun 14
		nsLeft 190
		nsTop 22
		nsRight 253
		nsBottom 70
		sightAngle 20
		approachX 261
		approachY 76
		x 221
		y 46
	)
)

(instance tomb4 of Feature
	(properties
		noun 15
		nsTop 31
		nsRight 22
		nsBottom 95
		sightAngle 20
		approachX 41
		approachY 105
		x 11
		y 63
	)
)

(instance tomb5 of Feature
	(properties
		noun 16
		nsLeft 65
		nsTop 45
		nsRight 81
		nsBottom 87
		sightAngle 20
		approachX 41
		approachY 105
		x 73
		y 66
	)
)

(instance myBrick of View
	(properties
		noun 3
		approachX 122
		approachY 120
		x 143
		y 115
		view 3001
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (not (gEgo has: 44)) ; brick
					(gCurRoom setScript: sPickUpBrick)
				else
					(gMessager say: 11 0 12) ; "Pleased with his message, Gabriel tosses the brick down. Now, if only "dj" reads it in time!"
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance message1 of View
	(properties
		noun 4
		approachX 96
		approachY 120
		x 105
		y 72
		priority 116
		fixPriority 1
		view 3001
		cel 1
	)

	(method (init)
		(super init:)
		(= local0 3022)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(66 ; brick
				(if
					(and
						(not (IsFlag 246))
						(IsFlag 249)
						(gEgo has: 32) ; VoodooCode1
						(gEgo has: 33) ; sVoodooCode
					)
					(gCurRoom setScript: sGoToCode)
				else
					(gMessager say: 5 theVerb 1) ; "Gabriel likes the idea of leaving marks on the tomb, but at the moment he's not sure what to say or how to say it."
				)
			)
			(7 ; Look
				(gCurRoom setScript: sDoTheInsetThang 0 3022)
			)
			(15 ; sketchBook
				(if (gEgo has: 32) ; VoodooCode1
					(gMessager say: noun theVerb 3) ; "Gabriel already copied the marks on the tomb."
				else
					(gEgo get: 32) ; VoodooCode1
					(gEgo getPoints: -999 2)
					(gCurRoom setScript: sCopyCode 0 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance message2 of View
	(properties
		noun 6
		approachX 96
		approachY 120
		x 105
		y 72
		priority 116
		fixPriority 1
		view 3001
		cel 2
	)

	(method (init)
		(super init:)
		(= local0 3023)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(66 ; brick
				(cond
					((== ((ScriptID 301 1) tileLoc1:) 300) ; xKeeper
						(gMessager say: noun theVerb 18 1) ; "(GK-AM2)Gabriel should at least wait until the watchman is gone before defacing the tomb."
					)
					(
						(and
							(not (IsFlag 246))
							(IsFlag 249)
							(gEgo has: 32) ; VoodooCode1
							(gEgo has: 33) ; sVoodooCode
						)
						(gCurRoom setScript: sGoToCode)
					)
					(else
						(gMessager say: 5 theVerb 1) ; "Gabriel likes the idea of leaving marks on the tomb, but at the moment he's not sure what to say or how to say it."
					)
				)
			)
			(7 ; Look
				(gCurRoom setScript: sDoTheInsetThang 0 3023)
			)
			(15 ; sketchBook
				(if (gEgo has: 33) ; sVoodooCode
					(gMessager say: noun theVerb 6) ; "Gabriel already copied the marks on the tomb."
				else
					(gEgo get: 33) ; sVoodooCode
					(gEgo getPoints: -999 2)
					(gCurRoom setScript: sCopyCode)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gabeMessage of View
	(properties
		noun 4
		approachX 96
		approachY 120
		x 105
		y 72
		priority 116
		fixPriority 1
		view 3001
		cel 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 7) ; Look
			(gCurRoom
				setScript: sDoTheInsetThang 0 (if (IsFlag 394) 3025 else 3024)
			)
			(return 1)
		else
			(laveauTomb doVerb: theVerb)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 110
		nsBottom 150
		nsRight 15
		cursor 962
		exitDir 4
		eCursor 0
	)
)

(instance eastExit of ExitFeature
	(properties
		nsTop 80
		nsLeft 304
		nsBottom 150
		nsRight 319
		cursor 963
		exitDir 2
		eCursor 0
	)
)

(instance codeCloseUpInset of Inset
	(properties
		picture 305
		disposeNotOnMe 1
		modNum 302
		noun 2
	)

	(method (init)
		(= picture 305)
		(gTheIconBar disable: 0)
		(super init: &rest)
		(theInView init:)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (dispose &tmp temp0)
		(theInView dispose:)
		(gTheIconBar enable: 0)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
		(super dispose:)
	)

	(method (doVerb)
		(self dispose:)
	)

	(method (doit &tmp temp0)
		(if disposeNotOnMe
			(FrameOut)
			(= temp0 (gUser curEvent:))
			(if (not (temp0 type:))
				(temp0 localize: (gCast plane:))
				(cond
					((not (theInView onMe: temp0))
						(if
							(and
								(!= gTheCursor inExitCurs)
								(not (& (gTheIconBar state:) $0020))
							)
							(gGame setCursor: inExitCurs 1)
						)
					)
					(
						(and
							(!= (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
							(!= gTheCursor ((gTheIconBar curIcon:) cursorView:))
						)
						(gGame setCursor: ((gTheIconBar curIcon:) cursorView:) 1)
					)
					(
						(and
							(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
							gTheCursor
							(!=
								(gTheCursor view:)
								((gTheIconBar curIcon:) cursorView:)
							)
						)
						(inCursor
							view: ((gTheIconBar useIconItem:) cursorView:)
							loop: ((gTheIconBar useIconItem:) cursorLoop:)
							cel: ((gTheIconBar useIconItem:) cursorCel:)
						)
						(gGame setCursor: inCursor 1)
					)
				)
			)
		)
		(if script
			(script doit:)
		)
	)
)

(instance keeperTimer of Timer
	(properties)

	(method (cue)
		(if
			(and
				(== ((ScriptID 301 1) script:) (ScriptID 301 2)) ; xKeeper, sKeeperStuff
				(not (gCurRoom script:))
				(not (gCurRoom inset:))
			)
			((ScriptID 301 1) setScript: sKeeperLeaves) ; xKeeper
		else
			(self setReal: keeperTimer (Random 25 40))
		)
	)
)

(instance theInView of View
	(properties
		noun 2
		modNum 302
	)

	(method (doVerb theVerb)
		(switch theVerb
			(66 ; brick
				(cond
					((IsFlag 246)
						(gMessager say: 5 theVerb 7 0 0 300) ; "I don't want to rewrite it. It's perfect."
					)
					(
						(and
							(not (IsFlag 246))
							(IsFlag 249)
							(gEgo has: 32) ; VoodooCode1
							(gEgo has: 33) ; sVoodooCode
						)
						(gCurRoom setScript: sGoToCode)
						(codeCloseUpInset dispose:)
					)
					(else
						(gMessager say: 5 theVerb 1 0 0 300) ; "Gabriel likes the idea of leaving marks on the tomb, but at the moment he's not sure what to say or how to say it."
					)
				)
				(return 1)
			)
			(15 ; sketchBook
				(cond
					((IsFlag 246)
						(gMessager say: 2 theVerb 2 0 0 302) ; "Gabriel doesn't need to make a copy of his own message."
					)
					((== view 3022)
						(if (gEgo has: 32) ; VoodooCode1
							(gMessager say: 4 theVerb 3 0 0 300) ; "Gabriel already copied the marks on the tomb."
						else
							(gEgo get: 32) ; VoodooCode1
							(gEgo getPoints: -999 2)
							(gCurRoom setScript: sCopyCode 0 1)
							(codeCloseUpInset dispose:)
						)
					)
					((gEgo has: 33) ; sVoodooCode
						(gMessager say: 6 theVerb 6 0 0 300) ; "Gabriel already copied the marks on the tomb."
					)
					(else
						(gEgo get: 33) ; sVoodooCode
						(gEgo getPoints: -999 2)
						(gCurRoom setScript: sCopyCode)
						(codeCloseUpInset dispose:)
					)
				)
				(return 1)
			)
			(7 ; Look
				(cond
					((IsFlag 246)
						(gMessager say: 5 theVerb 7 2 0 300) ; "Gabriel's coded message is on the wall."
					)
					((== view 3022)
						(if (IsFlag 248)
							(gMessager say: 2 theVerb 12 0 0 302) ; "The Voodoo code message is still on the wall."
						else
							(gMessager say: 2 theVerb 11 0 0 302) ; "The marks are reddish in color and remind Gabriel of crosses. They look like they've been here a few days at least."
						)
					)
					(else
						(gMessager say: 2 theVerb 13 0 0 302) ; "A second message made from the Voodoo crosses is on the wall."
					)
				)
				(return 1)
			)
			(40 ; VoodooCode1
				(gMessager say: 6 theVerb 0 0 0 300) ; "(GK-AM2)Gabriel can't put his sketch back on the wall."
				(return 1)
			)
			(59 ; sVoodooCode
				(gMessager say: 6 theVerb 0 0 0 300) ; "(GK-AM2)Gabriel can't put his sketch back on the wall."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inCursor of Cursor
	(properties)
)

(instance inExitCurs of Cursor
	(properties
		view 968
	)
)

