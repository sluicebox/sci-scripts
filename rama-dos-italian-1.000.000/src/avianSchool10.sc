;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6609)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianSchool10 0
)

(instance avianSchool10 of Location
	(properties)

	(method (init)
		(super init:)
		(self addPicObj: faceSE faceNW faceNE faceSE)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceSE
						(southEastMural init: global117)
					)
					(faceNE
						(northEastMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceSE
						(southEastMural dispose:)
					)
					(faceNE
						(northEastMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 6635
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(mural_0 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 180
		picture 6636
		edgeS 0
		edgeN 0
	)

	(method (init)
		(= picture
			(switch [global235 1]
				(0 6655)
				(1 6656)
				(else 6636)
			)
		)
		(projectorExit init:)
		(gCurRoom exitN: projectorExit)
		(super init:)
		(podium_180 init:)
		(projector_180 init:)
		(desks_180 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 270
		picture 6634
		edgeS 0
		edgeN 0
	)

	(method (init)
		(muralExit init:)
		(gCurRoom exitN: muralExit)
		(super init:)
		(mural_270 init:)
		(desks_270 init:)
	)
)

(instance southEastMural of View
	(properties
		x 79
		y 116
		loop 2
		cel 6
		view 6626
	)
)

(instance northEastMural of View
	(properties
		x 258
		y 185
		loop 2
		cel 5
		view 6626
	)
)

(instance muralExit of ExitFeature
	(properties
		nsBottom 181
		nsLeft 219
		nsRight 383
		nsTop 98
		nextRoom 6608
	)
)

(instance projectorExit of ExitFeature
	(properties
		nsBottom 197
		nsLeft 287
		nsRight 374
		nsTop 144
		nextRoom 6602
	)
)

(instance mural_0 of Feature
	(properties
		noun 14
		x 288
		y 141
		nsBottom 277
		nsLeft 15
		nsRight 562
		nsTop 6
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance mural_270 of Feature
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
					init: 224 123 229 111 355 87 364 95 379 161 371 175 246 181 239 175
					yourself:
				)
		)
	)
)

(instance desks_270 of Feature
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
					init: 62 232 160 215 229 244 225 287 146 288 100 288 55 243
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 43 179 69 166 90 170 98 192 127 195 123 213 76 215 68 215 57 188 41 180
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 160 209 191 204 273 216 308 226 376 233 480 247 583 256 590 288 509 294 451 283 368 269 319 259 350 291 259 289 222 229 228 288 171 288 85 287 55 241 168 221 189 213 169 209
					yourself:
				)
		)
	)
)

(instance desks_180 of Feature
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
					init: 77 288 145 241 358 260 350 293
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 383 174 372 222 422 250 436 250 494 225 461 170
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 581 157 543 163 586 203 yourself:)
		)
	)
)

(instance projector_180 of Feature
	(properties
		noun 40
		x 341
		y 172
		nsBottom 193
		nsLeft 308
		nsRight 374
		nsTop 151
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance podium_180 of Feature
	(properties
		noun 42
		x 408
		y 133
		nsBottom 154
		nsLeft 363
		nsRight 453
		nsTop 112
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

