;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5006)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)

(public
	NYAvian6 0
)

(instance NYAvian6 of Location
	(properties
		noun 2
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(switch gPrevRoomNum
			(5004 ; NYAvian4
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
			(5005 ; NYAvian5
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
			(else
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
		)
		(= temp0
			(if (IsFlag 246)
				(IsFlag 234)
			)
		)
		(switch global413
			(0
				(if temp0
					(= global413 1)
				)
			)
			(2
				(if temp0
					(= global413 3)
				)
			)
		)
	)

	(method (setPicObj)
		(super setPicObj: &rest)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5023
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5502 init: exitStyle: 256)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(mazeExit_45 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5026
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
		picture 5025
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc4Exit init:)
		(gCurRoom exitN: loc4Exit)
		(super init: &rest)
		(sign_225 init:)
		(Pylons_225 init:)
		(tetrahedron_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5024
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc5Exit init:)
		(gCurRoom exitN: loc5Exit)
		(if (>= global413 2)
			(= picture 5103)
			(lairDoor_315 case: 5 init:)
		else
			(= picture 5024)
			(lairDoor_315 case: 4 init:)
		)
		(super init: &rest)
		(if (== global413 3)
			(= global413 4)
			(avian_Beckons play:)
		)
	)
)

(instance loc4Exit of ExitFeature
	(properties
		nsLeft 159
		nsTop 101
		nsRight 454
		nsBottom 227
		nextRoom 5004
	)
)

(instance loc5Exit of ExitFeature
	(properties
		nsLeft 77
		nsTop 100
		nsRight 239
		nsBottom 208
		nextRoom 5005
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance avian_Beckons of VMDMovie
	(properties
		movieName 5033
		endPic 5103
		cacheSize 1000
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
					init: 216 150 247 152 252 180 217 179
					yourself:
				)
		)
	)
)

(instance sign_225 of Feature
	(properties
		noun 3
		nsLeft 388
		nsTop 113
		nsRight 407
		nsBottom 133
		x 397
		y 123
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance mazeExit_45 of Feature
	(properties
		noun 11
		nsLeft 141
		nsTop -2
		nsRight 565
		nsBottom 195
		x 353
		y 96
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lairDoor_315 of Feature
	(properties
		noun 35
		nsLeft 94
		nsTop 77
		nsRight 205
		nsBottom 185
		x 149
		y 131
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance Pylons_225 of Feature
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
					init: 189 180 192 159 198 160 200 181 188 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 202 178 203 164 208 163 210 181 202 181
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 244 158 250 157 252 181 242 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 274 166 280 167 282 182 274 180 274 168
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 345 160 353 160 357 181 344 183
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 304 170 307 171 308 178 304 178
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 356 169 363 169 363 179 356 181
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 356 169 363 169 363 179 356 181 224 165 230 165 229 182 224 183 224 168
					yourself:
				)
		)
	)
)

