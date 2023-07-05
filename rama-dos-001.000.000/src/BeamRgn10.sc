;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2049)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use cplainRegion)
(use n1111)
(use Polygon)
(use Feature)

(public
	BeamRgn10 0
)

(instance BeamRgn10 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2048
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(2051 ; BeamRgn12
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
		((ScriptID 200 0) addMigrant: 66) ; cplainRegion
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2131
		edgeS 0
		edgeN 0
	)

	(method (init)
		(twelveExit_0 init:)
		(super init: &rest)
		(beam_0 init:)
		(sea_0 init:)
		(northHCyl_0 init:)
		(horns_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 2134
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(beam_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2133
		edgeS 0
		edgeN 0
	)

	(method (init)
		(sixExit_180 init:)
		(super init: &rest)
		(beam_180 init:)
		(bareMetal_180 init:)
		(canyon_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 2132
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(matrixL11z init: global117)
		(beam_270 init:)
	)
)

(instance matrixL11z of MigratingView
	(properties
		x 198
		y 274
		cel 1
		view 2021
		invItemID 66
	)
)

(instance beam_0 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 3 -1 532 -1 0 152 yourself:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 19)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sea_0 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 402 39 538 -2 506 47 468 85 413 116 367 117 390 86 399 58
					yourself:
				)
		)
	)
)

(instance northHCyl_0 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 206 95 398 39 398 64 388 88 368 117 290 122 240 97 211 100
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 293 83 303 86 307 96 302 107 288 108 284 97
					yourself:
				)
		)
	)
)

(instance beam_270 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 220 0 121 -1 2 590 1 589 124 431 227
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 19)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance beam_180 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 122 0 589 -1 591 177 yourself:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 19)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bareMetal_180 of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 389 219 475 192 588 198 588 279 490 240
					yourself:
				)
		)
	)
)

(instance beam_90 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 35 2 1 590 0 588 32 358 88 85 63
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 19)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance canyon_180 of Feature
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
					init: 223 178 416 160 556 163 593 178 593 282 557 260 442 228 299 209 261 195
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1)
			(144
				(proc1111_31 noun)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sixExit_180 of ExitFeature
	(properties
		x 224
		y 139
		nsBottom 252
		nsLeft 39
		nsRight 410
		nsTop 26
		nextRoom 2045
	)
)

(instance twelveExit_0 of ExitFeature
	(properties
		x 337
		y 148
		nsBottom 250
		nsLeft 145
		nsRight 530
		nsTop 47
		nextRoom 2051
	)
)

