;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3064)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	london_34 0
)

(instance london_34 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3063 ; london_33
				(self addPicObj: faceE faceW faceE)
			)
			(else
				(self addPicObj: faceW faceE faceW)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3315
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(eastExitToLondon35 init:)
		(super init:)
		(laser_90 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3314
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(centipede_270 init:)
		(if (proc1111_24 114)
			(= picture 3344)
			(spider_270 init:)
		)
		(super init:)
		(westExitToLondon33 init:)
		(crane_270 init:)
	)
)

(instance eastExitToLondon35 of ExitFeature
	(properties
		nsLeft 188
		nsTop 6
		nsRight 393
		nsBottom 255
		nextRoom 3065
	)
)

(instance westExitToLondon33 of ExitFeature
	(properties
		nsLeft 130
		nsTop 45
		nsRight 451
		nsBottom 259
		nextRoom 3063
	)
)

(instance spider_270 of Feature
	(properties
		noun 31
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 17 253 15 181 93 153 92 89 144 88 155 156 199 172 204 223 195 253 21 257
					yourself:
				)
		)
	)
)

(instance crane_270 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 81 191 102 127 125 66 130 29 138 9 139 2 299 0 298 69 341 70 357 153 376 197 341 201 299 199 306 163 306 126 274 147 230 150 181 148 168 145 167 157 166 188 127 207 78 197
					yourself:
				)
		)
	)
)

(instance centipede_270 of Feature
	(properties
		noun 27
		nsLeft 404
		nsTop 80
		nsRight 586
		nsBottom 164
		x 495
		y 122
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance laser_90 of Feature
	(properties
		noun 34
		nsLeft 351
		nsTop 92
		nsRight 375
		nsBottom 123
		x 363
		y 107
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

