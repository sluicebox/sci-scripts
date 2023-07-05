;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2040)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	BeamRgn1 0
)

(instance BeamRgn1 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2041 ; BeamRgn2
				(self addPicObj: faceS faceN faceS)
			)
			(else
				(self addPicObj: faceN faceS faceN)
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
		picture 2102
		edgeS 0
		edgeN 0
	)

	(method (init)
		(twoExit_0 init:)
		(super init: &rest)
		(beam_0 init:)
		(sea_0 init:)
		(northHCyl_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2101
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cplainExit_180 init:)
		(super init: &rest)
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
				((Polygon new:)
					type: PTotalAccess
					init: 110 122 589 2 588 89 430 101 364 142 234 163 124 161
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
					init: 56 1 195 0 188 52 205 97 163 109 95 60
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 398 0 535 0 528 14 399 47 401 22
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
					init: 199 -1 389 1 400 48 209 99 189 53
					yourself:
				)
		)
	)
)

(instance twoExit_0 of ExitFeature
	(properties
		x 371
		y 149
		nsBottom 221
		nsLeft 193
		nsRight 550
		nsTop 77
		nextRoom 2041
	)
)

(instance cplainExit_180 of ExitFeature
	(properties
		x 300
		y 152
		nsBottom 245
		nsLeft 82
		nsRight 518
		nsTop 59
		nextRoom 2000
	)
)

