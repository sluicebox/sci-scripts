;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5004)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NYAvian4 0
)

(instance NYAvian4 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5001 ; NYAvian1
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
			(5002 ; NYAvian2
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
			(5006 ; NYAvian6
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(else
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
		)
	)

	(method (setPicObj)
		(super setPicObj: &rest)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5018
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc6Exit init:)
		(if (>= global413 2)
			(= picture 5104)
			(lairCover_45 case: 5 init:)
		else
			(= picture 5018)
			(lairCover_45 case: 4 init:)
		)
		(gCurRoom exitN: loc6Exit)
		(super init: &rest)
		(mazeExit_45 init:)
		(pylons_45 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5017
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(pylon_135 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5016
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc2Exit init:)
		(gCurRoom exitN: loc2Exit)
		(super init: &rest)
		(tetrahedron_225 init:)
		(low_wall_225 init:)
		(sign_225 init:)
		(pylons_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5019
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(pylon_315 init:)
	)
)

(instance loc2Exit of ExitFeature
	(properties
		nsLeft 76
		nsTop 89
		nsRight 420
		nsBottom 215
		nextRoom 5002
	)
)

(instance loc6Exit of ExitFeature
	(properties
		nsLeft 240
		nsTop 80
		nsRight 451
		nsBottom 220
		nextRoom 5006
	)
)

(instance low_wall_225 of Feature
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
					init: 376 168 522 151 534 192 484 193 371 186
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 73 169 171 171 169 183 90 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 0 171 4 173 11 185 1 184
					yourself:
				)
		)
	)
)

(instance sign_225 of Feature
	(properties
		noun 3
		nsLeft 366
		nsTop 84
		nsRight 388
		nsBottom 111
		x 377
		y 97
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pylons_225 of Feature
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
					init: 120 120 126 117 126 107 139 111 151 185 119 191 109 191 121 119
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 184 161 190 163 193 179 182 183 185 165
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 243 166 251 165 253 179 242 180 245 166
					yourself:
				)
		)
	)
)

(instance tetrahedron_225 of Feature
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
					init: -1 93 96 107 62 188 10 187 0 158 -1 126
					yourself:
				)
		)
	)
)

(instance pylon_135 of Feature
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
					init: 360 130 367 129 366 120 372 123 380 119 381 130 398 188 353 188 359 131
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
					init: 114 103 124 102 122 88 140 94 147 91 150 106 155 108 168 191 107 195 115 101
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 527 97 549 92 570 191 516 194 520 114
					yourself:
				)
		)
	)
)

(instance lairCover_45 of Feature
	(properties
		noun 35
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 62 100 94 109 91 181 55 183 60 99
					yourself:
				)
		)
	)
)

(instance pylon_315 of Feature
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
					init: 401 111 410 107 409 94 434 94 435 106 458 191 397 194 405 113
					yourself:
				)
		)
	)
)

(instance mazeExit_45 of Feature
	(properties
		noun 11
		nsLeft 298
		nsTop -1
		nsRight 384
		nsBottom 182
		x 341
		y 90
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

