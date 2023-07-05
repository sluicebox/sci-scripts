;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm130 0
	varazTalker 1
	rmTalker 2
)

(local
	local0
)

(instance rm130 of Room
	(properties
		picture 130
		style 0
	)

	(method (init)
		(gGame handsOn:)
		(gTheIconBar enable:)
		(proc0_4 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 135 242 135 263 130 284 130 319 135 319 122 0 122
					yourself:
				)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(110
				(gEgo setHeading: 270 posn: 305 127)
			)
			(140
				(gEgo setHeading: 90 posn: 75 127)
			)
			(else
				(gEgo setHeading: 180 posn: 150 130)
			)
		)
		(gEgo
			setScaler: Scaler 88 52 152 115
			setTalker: careyTalker
			normalize: 0
			init:
		)
		(super init: &rest)
		(leftDoor init: approachVerbs: 4) ; Do
		(rightDoor init:)
		(burnedBldg init:)
		(doorBack init: signal: (| (doorBack signal:) $4000))
		(fence init:)
		(pole init:)
		(rainbow init:)
		(leftSky init:)
		(rightSky init:)
		(sidewalk init:)
		(if (== gPrevRoomNum 110)
			(gCurRoom setScript: musicScript)
		)
		(gGame handsOn:)
		(if (and (== gPrevRoomNum 140) (gPqFlags test: 159))
			(gGame handsOff:)
			(gCurRoom setScript: knockLeftDoorScript)
		)
		(gTheIconBar enable:)
	)

	(method (doit)
		(super doit:)
		(if (< (gEgo x:) 50)
			(gCurRoom newRoom: 140)
		)
		(if (> (gEgo x:) 312)
			(gCurRoom newRoom: 110)
		)
	)

	(method (dispose)
		(gGlobalSound2 number: 0 stop:)
		(super dispose:)
	)
)

(instance musicScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gGlobalSound0 client: 0)
		(super dispose: &rest)
		(gTheDoits delete: self)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound0 setVol: 127 fade: 0 1 5 1 self)
			)
			(1
				(gGlobalSound1
					number: 130
					loop: -1
					play:
					setVol: 0
					fade: 127 1 5 0 self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance rightDoor of Feature
	(properties
		noun 7
		nsLeft 204
		nsTop 68
		nsRight 225
		nsBottom 117
		sightAngle 90
		approachX 215
		approachY 119
		approachDist 20
		x 213
		y 110
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 7 1 (if (> gDay 2) 9 else 3) 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorBack of Prop
	(properties
		x 84
		y 68
		priority 68
		fixPriority 1
		view 134
	)
)

(instance varaz of Actor
	(properties
		noun 2
		x 92
		y 120
		priority 70
		fixPriority 1
		view 130
	)
)

(instance leftDoor of Prop
	(properties
		noun 5
		approachX 111
		approachY 126
		approachDist 10
		x 65
		y 72
		z 10
		priority 69
		fixPriority 1
		view 133
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< gDay 3)
					(gCurRoom setScript: knockLeftDoorScript)
				else
					(gMessager say: 5 4 9 0) ; "The door is locked up tight as a drum, Detective."
				)
			)
			(1 ; Look
				(gMessager say: 5 1 (if (> gDay 2) 9 else 3) 0)
			)
			(22 ; handgun
				(gMessager say: 5 22 (if (> gDay 2) 9 else 3) 0)
			)
			(27 ; badge
				(gMessager say: noun theVerb 3 0) ; "Identifying yourself to the door seems rather pointless, Detective..."
			)
			(29 ; coins
				(gMessager say: noun theVerb 3 0) ; "Buying your way in is pathetic, Carey."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance knockLeftDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gPqFlags test: 159)
					(gEgo setMotion: PolyPath 111 126 self)
					(gPqFlags clear: 159)
				else
					(= cycles 2)
				)
			)
			(1
				(gEgo setHeading: 316 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(leftDoor cycleSpeed: global112 setCycle: CT 2 1 self)
				(gGlobalSound2 number: 946 loop: -1 signal: 5 play:)
			)
			(4
				(leftDoor setCycle: End)
				(varaz
					view: 130
					setSpeed: global112
					setLoop: 0
					cel: 0
					init:
					signal: (| (varaz signal:) $4000)
					setCycle: End self
				)
			)
			(5
				(varaz setLoop: 1 cel: 0 setCycle: End self)
			)
			(6
				(gMessager
					say:
						2
						0
						(cond
							((not local0) 4)
							((== local0 1) 5)
							((== local0 2) 6)
							((== local0 3) 7)
							((== local0 4) 8)
							(else
								(Random 4 8)
							)
						)
						0
						self
				)
				(++ local0)
			)
			(7
				(varaz
					view: 131
					setSpeed: 12
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(8
				(varaz
					setSpeed: global112
					setLoop: 1
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(9
				(leftDoor setCycle: Beg)
				(varaz setCycle: End self)
			)
			(10
				(gGlobalSound2 number: 0 stop:)
				(varaz dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rmMusic of Sound ; UNUSED
	(properties
		flags 1
		number 130
		loop -1
	)
)

(instance rmTalker of Narrator
	(properties
		y 10
	)
)

(instance careyTalker of Narrator
	(properties
		x 110
		y 10
	)
)

(instance varazTalker of Narrator
	(properties
		x 5
		y 10
	)
)

(instance burnedBldg of Feature
	(properties
		noun 11
		nsTop 35
		nsRight 58
		nsBottom 117
		sightAngle 40
		x 29
		y 76
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 11 1 (if (> gDay 2) 9 else 3) 0)
			)
			(22 ; handgun
				(gMessager say: 11 22 (if (> gDay 2) 9 else 3) 0)
			)
			(52 ; notebook
				(gMessager say: 11 52 (if (> gDay 2) 9 else 3) 0)
			)
			(2 ; Talk
				(gMessager say: 11 2 9 0) ; "Hello?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fence of Feature
	(properties
		noun 13
		nsLeft 245
		nsTop 73
		nsRight 319
		nsBottom 117
		sightAngle 40
		x 282
		y 95
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 4 2 63 46 22) ; Look, Do, Talk, casePryBar, keys, handgun
			(super doVerb: theVerb)
		else
			(gMessager say: 0 theVerb 0 0 0 0)
		)
	)
)

(instance pole of Feature
	(properties
		noun 12
		nsLeft 269
		nsRight 283
		nsBottom 134
		sightAngle 40
		x 276
		y 124
	)
)

(instance rainbow of Feature
	(properties
		noun 6
		nsLeft 58
		nsRight 245
		nsBottom 116
		sightAngle 40
		x 151
		y 18
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 19 27 13 74 38 12 17 22 1) ; apple, badge, caseBaggies, candyBar, caseChalk, evidenceCase, glue, handgun, Look
				(gMessager say: noun theVerb (if (> gDay 2) 9 else 3) 0)
			)
			((OneOf theVerb 10 4) ; ammoBaggie, Do
				(gMessager say: noun theVerb 3 0)
			)
			((OneOf theVerb 34 30 24 65 64) ; boneBaggie, cigarette, fullClip, caseGlassJar, caseGloves
				(gMessager say: noun theVerb 9 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftSky of Feature
	(properties
		noun 4
		nsRight 58
		nsBottom 33
		sightAngle 360
		x 29
		y 16
	)
)

(instance rightSky of Feature
	(properties
		noun 4
		sightAngle 360
		x 282
		y 33
	)

	(method (init)
		(self
			createPoly:
				244
				10
				319
				10
				319
				40
				286
				50
				285
				64
				282
				68
				263
				67
				263
				52
				252
				52
				251
				33
				245
				33
		)
		(super init:)
	)
)

(instance sidewalk of Feature
	(properties
		noun 1
		nsTop 119
		nsRight 319
		nsBottom 145
		sightAngle 360
		x 159
		y 123
	)
)

