;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2027)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)

(public
	wheelRgn18 0
)

(instance wheelRgn18 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch ((ScriptID 210 0) wheelPosition:) ; wheelRegion
			(0
				(faceIn heading: 225)
				(faceOut heading: 45)
			)
			(1
				(faceIn heading: 180)
				(faceOut heading: 0)
			)
			(2
				(faceIn heading: 90)
				(faceOut heading: 270)
			)
			(3
				(faceIn heading: 0)
				(faceOut heading: 180)
			)
			(4
				(faceIn heading: 270)
				(faceOut heading: 90)
			)
		)
		(self addPicObj: faceIn faceOut faceIn)
	)
)

(instance faceIn of CameraAngle
	(properties
		picture 2251
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(mazeControllerCard init: global117)
		(matrixB32y init: global117)
		(monitorDisplay init:)
		(ladderFeat init:)
		(ladder init: global117)
		(monitor_225 init:)
		(platform_225 init:)
	)
)

(instance faceOut of CameraAngle
	(properties
		picture 2282
		edgeS 0
		edgeN 0
	)

	(method (init)
		(switch ((ScriptID 210 0) wheelPosition:) ; wheelRegion
			(0
				(= picture 2282)
				(defaultExit nextRoom: 2034)
			)
			(1
				(= picture 2285)
				(defaultExit nextRoom: 2035)
			)
			(2
				(= picture 2286)
				(defaultExit nextRoom: 2036)
			)
			(3
				(= picture 2287)
				(defaultExit nextRoom: 2037)
			)
			(4
				(= picture 2288)
				(defaultExit nextRoom: 2038)
			)
		)
		(defaultExit init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
	)
)

(instance defaultExit of ExitFeature
	(properties
		exitStyle 256
	)
)

(instance mazeControllerCard of View
	(properties
		x 293
		y 31
		cel 1
		view 2284
	)

	(method (init)
		(if (!= (proc70_9 47) 2039)
			(return)
		)
		(super init: &rest)
	)
)

(instance matrixB32y of View
	(properties
		x 445
		y 278
		view 2284
	)

	(method (init)
		(if (!= (proc70_9 62) gCurRoomNum)
			(return)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 62 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance monitorDisplay of View
	(properties
		x 280
		y 160
		loop 1
		view 2284
	)

	(method (init)
		(cond
			((and (== (= cel global201) 2) global297)
				(= global201 3)
			)
			((and (== global201 3) (not global297))
				(= global201 2)
			)
		)
		(if (== global201 2)
			(monitorStatic init:)
		)
		(&= signal $efff)
		(super init: global117)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 2028) ; wheelHubMonitor
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ladderFeat of Feature
	(properties)

	(method (init)
		(if (== (proc70_9 46) gCurRoomNum)
			(return)
		)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 217 71 296 52 300 290 226 283 186 242 187 216 221 132
					yourself:
				)
			setHotspot: 67
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67
				(proc70_3 46)
				(proc70_10 46 gCurRoomNum)
				(ladder init: global117)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ladder of View
	(properties
		x 148
		y 81
		cel 2
		view 2284
	)

	(method (init)
		(if (!= (proc70_9 46) gCurRoomNum)
			(return)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 2039) ; wheelHubLadder
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance monitorStatic of Prop
	(properties
		x 280
		y 160
		loop 5
		view 2284
	)

	(method (init)
		(super init: global117)
		(self setCycle: Fwd)
	)
)

(instance monitor_225 of Feature
	(properties
		noun 17
		x 296
		y 177
		nsBottom 211
		nsLeft 268
		nsRight 324
		nsTop 143
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance platform_225 of Feature
	(properties
		noun 19
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 219 70 224 21 234 -1 367 0 375 69 380 131 417 251 376 291 230 291 182 257 218 128
					yourself:
				)
		)
	)
)

(instance hubDoor_45 of Feature ; UNUSED
	(properties
		noun 7
		x 288
		y 156
		nsBottom 230
		nsLeft 230
		nsRight 347
		nsTop 83
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

