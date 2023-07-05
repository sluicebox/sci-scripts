;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2051)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	BeamRgn12 0
)

(instance BeamRgn12 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2000 ; cplains
				(self addPicObj: faceS faceN faceS)
			)
			(2049 ; BeamRgn10
				(self addPicObj: faceN faceS faceN)
			)
			(else
				(self addPicObj: faceS faceN faceS)
			)
		)
		((ScriptID 200 0) addMigrantIfEqualTo: 2042 107 11 85 72 73 77 66) ; cplainRegion
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
		picture 2137
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cplainExit_0 init:)
		(super init: &rest)
		(sea_0 init:)
		(northHCyl_0 init:)
		(artifact_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2138
		edgeS 0
		edgeN 0
	)

	(method (init)
		(tenExit_180 init:)
		(super init: &rest)
		(beam_180 init:)
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
					init: 53 0 200 -1 189 32 191 66 121 65 98 51 89 51
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 393 0 538 0 519 12 480 72 390 85 399 61 397 26
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
					init: 198 -1 390 -1 401 31 397 65 389 87 294 82 229 72 195 67 191 37
					yourself:
				)
		)
	)
)

(instance artifact_0 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 501 93 540 75 568 96 552 125 501 150 480 134
					yourself:
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
				((Polygon new:)
					type: PTotalAccess
					init: -1 0 354 1 588 75 587 193 395 170 0 50
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

(instance cplainExit_0 of ExitFeature
	(properties
		x 316
		y 159
		nsBottom 260
		nsLeft 105
		nsRight 528
		nsTop 58
		nextRoom 2000
	)
)

(instance tenExit_180 of ExitFeature
	(properties
		x 281
		y 152
		nsBottom 231
		nsLeft 96
		nsRight 467
		nsTop 74
		nextRoom 2049
	)
)

