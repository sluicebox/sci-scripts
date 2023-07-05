;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2010)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	wheelRgn1 0
)

(instance wheelRgn1 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2011 ; wheelRgn2
				(self addPicObj: faceN faceS faceN)
			)
			(else
				(self addPicObj: faceS faceN faceS)
			)
		)
		((ScriptID 200 0) addMigrantIfEqualTo: 2013 49 51 54 60) ; cplainRegion
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 2000) ; cplains
			(= exitStyle 13)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2201
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2000 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(lights_315 init:)
		(london_315 init:)
		(sea_315 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2202
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2011 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(corn_135 init:)
		(if (and (== global200 0) (not (OneOf (proc70_9 79) -3 -2)))
			(mechCorn init: global117)
		)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance mechCorn of View
	(properties
		view 2203
	)

	(method (init &tmp [temp0 2])
		(= loop (- 5 (>> ((ScriptID 200 0) curCornDispenser:) $0008))) ; cplainRegion
		(= cel (& $00ff ((ScriptID 200 0) curCornDispenser:))) ; cplainRegion
		(switch loop
			(3
				(self posn: 109 202)
			)
			(4
				(self posn: 145 199)
			)
			(5
				(self posn: 180 201)
			)
		)
		(super init: &rest)
	)
)

(instance lights_315 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 10 362 81 383 93 -2 30
					yourself:
				)
		)
	)
)

(instance london_315 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 19 170 25 181 46 153 40
					yourself:
				)
		)
	)
)

(instance sea_315 of Feature
	(properties
		noun 20
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 304 1 434 1 444 45 467 83 504 112 539 124 519 134 483 129 463 120 429 90 416 89 392 97 356 74 332 48 314 24
					yourself:
				)
		)
	)
)

(instance corn_135 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 40 252 61 230 103 244 145 279 154 290 78 291 74 269
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 107 208 117 195 153 192 192 198 204 210 154 208 121 211
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 401 235 425 214 439 237 yourself:)
		)
	)
)

