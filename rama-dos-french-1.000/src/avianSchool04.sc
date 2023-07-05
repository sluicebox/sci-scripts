;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6603)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianSchool04 0
)

(instance avianSchool04 of Location
	(properties)

	(method (init)
		(super init:)
		(self addPicObj: faceSW faceNW faceNE faceSW)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceSW
						(southWestMural init: global117)
					)
					(faceNW
						(northWestMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceSW
						(southWestMural dispose:)
					)
					(faceNW
						(northWestMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 90
		picture 6612
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(mural_90 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 180
		picture 6613
		edgeS 0
		edgeN 0
	)

	(method (init)
		(muralExit init:)
		(gCurRoom exitN: muralExit)
		(super init:)
		(mural_180 init:)
		(desks_180 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 270
		picture 6614
		edgeS 0
		edgeN 0
	)

	(method (init)
		(projectorExit init:)
		(gCurRoom exitN: projectorExit)
		(super init:)
		(podium_270 init:)
		(projector_270 init:)
		(desks_270 init:)
	)
)

(instance southWestMural of View
	(properties
		x 67
		y 75
		loop 1
		cel 2
		view 6626
	)
)

(instance northWestMural of View
	(properties
		x 229
		y 159
		loop 1
		cel 3
		view 6626
	)
)

(instance muralExit of ExitFeature
	(properties
		nsBottom 186
		nsLeft 227
		nsRight 357
		nsTop 81
		nextRoom 6604
	)
)

(instance projectorExit of ExitFeature
	(properties
		nsBottom 188
		nsLeft 217
		nsRight 309
		nsTop 118
		nextRoom 6602
	)
)

(instance mural_90 of Feature
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
					init: 31 36 63 3 524 7 549 40 552 251 524 282 58 289 27 253
					yourself:
				)
		)
	)
)

(instance podium_270 of Feature
	(properties
		noun 42
		x 196
		y 126
		nsBottom 145
		nsLeft 166
		nsRight 226
		nsTop 107
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance projector_270 of Feature
	(properties
		noun 40
		x 245
		y 166
		nsBottom 182
		nsLeft 215
		nsRight 276
		nsTop 151
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 131 251 137 232 85 231 87 213 146 211 149 196 113 184 114 161 172 161 204 167 200 194 174 202 173 213 208 215 207 230 171 230 168 245 158 255 137 253
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 252 262 257 288 482 293 515 281 462 252
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 3 163 44 163 50 175 17 181 1 194
					yourself:
				)
		)
	)
)

(instance mural_180 of Feature
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
					init: 208 167 223 99 234 89 359 107 365 119 351 173 343 182 215 177
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 417 201 324 210 123 237 12 256 0 282 -1 291 96 294 229 272 272 257 235 290 453 292 445 274 564 247 445 217 394 218 413 212
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 501 171 535 166 536 193 583 189 587 202 529 203 527 211 488 214 486 207 463 207 462 185
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
					init: -1 259 335 212 415 202 422 206 550 242 443 270 446 292 346 293 235 290 265 259 220 261 100 289
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 499 179 473 193 462 207 525 215 528 205 588 202 589 194 533 195 544 173 526 163
					yourself:
				)
		)
	)
)

