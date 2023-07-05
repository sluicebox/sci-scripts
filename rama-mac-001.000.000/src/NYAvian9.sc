;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5009)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NYAvian9 0
)

(instance NYAvian9 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5002 ; NYAvian2
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(5003 ; NYAvian3
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(5007 ; NYAvian7
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(5010 ; NYAvian10
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
			(else
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5037
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(avian2Exit init:)
		(avian7Exit init:)
		(gCurRoom exitNW: avian2Exit exitNE: avian7Exit)
		(super init: &rest)
		(tetrahedron_45 init:)
		(lowWall_45 init:)
		(pylons_45 init:)
		(wallIcons_45 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5040
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5039
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(alley_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5038
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance avian2Exit of ExitFeature
	(properties
		nsLeft 50
		nsRight 200
		nextRoom 5002
	)
)

(instance avian7Exit of ExitFeature
	(properties
		nsLeft 392
		nsRight 582
		nextRoom 5007
	)
)

(instance defaultExit of ExitFeature
	(properties
		nextRoom 5010
	)
)

(instance tetrahedron_45 of Feature
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
					init: 277 134 330 137 324 177 289 176 279 136
					yourself:
				)
		)
	)
)

(instance lowWall_45 of Feature
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
					init: 170 181 427 180 435 188 164 186
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 103 172 167 171 172 182 103 184 98 172
					yourself:
				)
		)
	)
)

(instance pylons_45 of Feature
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
					init: 462 152 470 147 476 154 480 182 461 183
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 142 153 147 152 149 154 153 185 138 184
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 531 182 528 168 535 167 535 180
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 19 182 26 163 30 182 18 184
					yourself:
				)
		)
	)
)

(instance wallIcons_45 of Feature
	(properties
		noun 22
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 265 -2 297 -1 297 10 262 10
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 345 -1 383 1 383 11 346 12
					yourself:
				)
		)
	)
)

(instance alley_225 of Feature
	(properties
		noun 13
		nsLeft 252
		nsTop 3
		nsRight 366
		nsBottom 199
		x 309
		y 101
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

