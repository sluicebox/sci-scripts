;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2020)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	wheelRgn11 0
)

(local
	local0
)

(instance wheelRgn11 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2012 ; wheelRgn3
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(2016 ; wheelRgn7
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2229
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(london_315 init:)
		(lights_315 init:)
		(sea_315 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2232
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(sevenExit_45 init:)
		(stillExit_45 init:)
		(if (and (== gPrevRoomNum 2021) (not local0)) ; wheelRgn12
			(= local0 1)
			(= showBlack 1)
		)
		(super init: &rest)
		(= showBlack 0)
		(sea_45 init:)
		(newyork_45 init:)
		(lights_45 init:)
		(laser_45 init:)
		(still_45 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2231
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2230
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(twelveExit_225 init:)
		(super init: &rest)
		(wheel_225 init:)
		(lights_225 init:)
		(london_225 init:)
	)
)

(instance wheel_225 of Feature
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
					init: -2 131 193 121 231 100 233 57 243 58 242 99 259 116 296 122 445 138 524 145 527 175 448 187 314 190 291 231 227 234 201 195 170 190 -2 192
					yourself:
				)
		)
	)
)

(instance lights_225 of Feature
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
					init: 204 95 590 37 591 55 193 107
					yourself:
				)
		)
	)
)

(instance london_225 of Feature
	(properties
		noun 16
		nsLeft 456
		nsTop 42
		nsRight 485
		nsBottom 59
		x 470
		y 50
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance london_315 of Feature
	(properties
		noun 16
		nsLeft 146
		nsTop 21
		nsRight 175
		nsBottom 45
		x 160
		y 33
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
				((Polygon new:) type: PTotalAccess init: 2 9 318 68 289 77 0 32 yourself:)
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
					init: 303 0 435 -1 438 32 455 65 403 74 370 64 347 65 321 35
					yourself:
				)
		)
	)
)

(instance sea_45 of Feature
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
					init: 7 134 62 120 105 99 135 62 142 31 139 -1 257 -1 249 36 230 69 194 100 154 118 126 121 97 131 63 124 30 138
					yourself:
				)
		)
	)
)

(instance newyork_45 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 158 84 171 44 173 0 207 0 202 36 185 64
					yourself:
				)
		)
	)
)

(instance lights_45 of Feature
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
					init: 62 58 137 26 133 50 65 70
					yourself:
				)
		)
	)
)

(instance laser_45 of Feature
	(properties
		noun 2
		nsLeft 274
		nsTop 157
		nsRight 327
		nsBottom 192
		x 300
		y 174
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance still_45 of Feature
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
					init: 494 129 593 125 593 186 547 179 527 169 511 168 489 160 483 144
					yourself:
				)
		)
	)
)

(instance twelveExit_225 of ExitFeature
	(properties
		nsLeft 138
		nsTop 43
		nsRight 380
		nsBottom 237
		x 259
		y 140
		nextRoom 2021
	)
)

(instance sevenExit_45 of ExitFeature
	(properties
		nsLeft 108
		nsTop 97
		nsRight 498
		nsBottom 223
		x 303
		y 160
		nextRoom 2016
	)
)

(instance stillExit_45 of ExitFeature
	(properties
		nsLeft 478
		nsTop 113
		nsRight 592
		nsBottom 202
		x 535
		y 157
		nextRoom 2017
	)
)

