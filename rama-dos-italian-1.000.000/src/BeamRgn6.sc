;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2045)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	BeamRgn6 0
)

(instance BeamRgn6 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2041 ; BeamRgn2
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(2046 ; BeamRgn7
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(2048
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(2049 ; BeamRgn10
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2117
		edgeS 0
		edgeN 0
	)

	(method (init)
		(tenExit_0 init:)
		(super init: &rest)
		(beam_0 init:)
		(sea_0 init:)
		(northHCyl_0 init:)
		(canyon_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 2120
		edgeS 0
		edgeN 0
	)

	(method (init)
		(sevenExit_90 init:)
		(super init: &rest)
		(entrance_90 init:)
		(hanger_90 init:)
		(lights_90 init:)
		(sea_90 init:)
		(redCrystal_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2119
		edgeS 0
		edgeN 0
	)

	(method (init)
		(twoExit_180 init:)
		(super init: &rest)
		(canyon_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 2118
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(sea_270 init:)
		(lights_270 init:)
		(canyon_270 init:)
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
					init: 0 110 334 -1 589 0 591 70 0 208
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
					init: 56 -1 196 1 191 52 112 72
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
				((Polygon new:) type: PTotalAccess init: 201 1 332 0 189 52 yourself:)
		)
	)
)

(instance sea_270 of Feature
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
					init: 463 1 589 1 589 85 511 56
					yourself:
				)
		)
	)
)

(instance lights_270 of Feature
	(properties
		noun 7
		x 297
		y 25
		nsBottom 32
		nsLeft 124
		nsRight 471
		nsTop 19
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance hanger_90 of Feature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 278 168 290 113 363 114 384 84 525 75 332 156 274 173
					yourself:
				)
		)
	)
)

(instance lights_90 of Feature
	(properties
		noun 7
		x 297
		y 24
		nsBottom 31
		nsLeft 127
		nsRight 467
		nsTop 18
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_90 of Feature
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
					init: 1 -1 129 1 92 47 53 71 3 50
					yourself:
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
					init: 245 224 326 176 298 166 301 161 592 157 592 287 401 257 301 238
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1)
			(144
				(proc1111_31 20)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance canyon_270 of Feature
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
					init: -3 148 186 148 212 157 296 154 590 151 590 238 370 236 212 216 -2 210
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

(instance canyon_0 of Feature
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
					init: -2 209 125 175 173 188 90 213 -1 233
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

(instance redCrystal_90 of Feature
	(properties
		noun 12
		x 341
		y 175
		nsBottom 184
		nsLeft 329
		nsRight 353
		nsTop 166
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance entrance_90 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 296 173 297 134 315 132 318 160
					yourself:
				)
		)
	)
)

(instance tenExit_0 of ExitFeature
	(properties
		x 287
		y 149
		nsBottom 222
		nsLeft 78
		nsRight 497
		nsTop 76
		nextRoom 2049
	)
)

(instance twoExit_180 of ExitFeature
	(properties
		x 189
		y 150
		nsBottom 222
		nsLeft 33
		nsRight 346
		nsTop 78
		nextRoom 2041
	)
)

(instance sevenExit_90 of ExitFeature
	(properties
		x 288
		y 150
		nsBottom 230
		nsLeft 101
		nsRight 476
		nsTop 70
		nextRoom 2046
	)
)

