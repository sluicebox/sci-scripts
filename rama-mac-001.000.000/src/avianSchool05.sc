;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6604)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianSchool05 0
)

(instance avianSchool05 of Location
	(properties)

	(method (init)
		(super init:)
		(self addPicObj: faceW faceNE faceS faceW)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceS
						(southMural init: global117)
					)
					(faceW
						(westMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceS
						(southMural dispose:)
					)
					(faceW
						(westMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6616
		edgeN 0
		edgeS 0
	)

	(method (init)
		(muralExit init:)
		(gCurRoom exitN: muralExit)
		(super init:)
		(mural_0 init:)
		(doorNumbers_0 init:)
		(desks_0 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 6617
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(platformExit init:)
		(gCurRoom exitN: platformExit)
		(super init:)
		(desks_225 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6615
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(mural_135 init:)
	)
)

(instance southMural of View
	(properties
		x 223
		y 155
		view 6626
		loop 1
		cel 5
	)
)

(instance westMural of View
	(properties
		x 59
		y 80
		view 6626
		loop 1
		cel 4
	)
)

(instance platformExit of ExitFeature
	(properties
		nsLeft 159
		nsTop 37
		nsRight 424
		nsBottom 221
		nextRoom 6605
	)
)

(instance muralExit of ExitFeature
	(properties
		nsLeft 207
		nsTop 87
		nsRight 365
		nsBottom 171
		nextRoom 6603
	)
)

(instance mural_135 of Feature
	(properties
		noun 14
		nsLeft 19
		nsTop 8
		nsRight 568
		nsBottom 278
		x 293
		y 143
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance mural_0 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 208 99 217 87 341 73 353 81 365 151 353 163 230 163 224 157
					yourself:
				)
		)
	)
)

(instance doorNumbers_0 of Feature
	(properties
		noun 55
		nsLeft 58
		nsTop 109
		nsRight 87
		nsBottom 121
		x 72
		y 115
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance desks_0 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 17 239 31 248 29 265 2 272
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 98 278 108 264 82 260 82 244 75 231 112 226 120 243 168 250 176 274 230 284 229 293
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 177 261 167 226 219 229 232 252 222 272
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 248 288 248 265 274 261 259 241 325 237 321 261 334 262 334 272 366 283 368 292
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 399 290 389 278 368 249 426 249 448 285 462 292
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 519 288 512 272 582 271 yourself:)
		)
	)
)

(instance desks_225 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 33 193 85 173 152 170 151 180 115 191 113 235 132 240 132 252 64 256 62 287 -3 288 -3 201 37 201
					yourself:
				)
		)
	)
)

