;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6608)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianSchool09 0
)

(instance avianSchool09 of Location
	(properties)

	(method (init)
		(super init:)
		(self addPicObj: faceE faceS faceNW faceE)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceE
						(eastMural init: global117)
					)
					(faceS
						(southMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceE
						(eastMural dispose:)
					)
					(faceS
						(southMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 315
		picture 6632
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(mural_315 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 45
		picture 6633
		edgeS 0
		edgeN 0
	)

	(method (init)
		(muralExit init:)
		(gCurRoom exitN: muralExit)
		(super init:)
		(doorNumber_45 init:)
		(mural_45 init:)
		(desks_45 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 180
		picture 6631
		edgeS 0
		edgeN 0
	)

	(method (init)
		(= picture
			(switch [global235 1]
				(0 6651)
				(1 6652)
				(2 6653)
				(3 6654)
			)
		)
		(rampExit init:)
		(gCurRoom exitN: rampExit)
		(super init:)
		(podium_180 init:)
		(ramp_180 init:)
		(desks_180 init:)
	)
)

(instance southMural of View
	(properties
		x 243
		y 161
		loop 2
		cel 4
		view 6626
	)
)

(instance eastMural of View
	(properties
		x 146
		y 155
		loop 2
		cel 3
		view 6626
	)
)

(instance rampExit of ExitFeature
	(properties
		nsBottom 214
		nsLeft 281
		nsRight 461
		nsTop 83
		nextRoom 6607
	)
)

(instance muralExit of ExitFeature
	(properties
		nsBottom 182
		nsLeft 226
		nsRight 373
		nsTop 70
		nextRoom 6609
	)
)

(instance podium_180 of Feature
	(properties
		noun 42
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 167 57 170 43 201 30 240 52 240 66 199 62 176 58
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 181 60 173 56 177 47 184 42
					yourself:
				)
		)
	)
)

(instance ramp_180 of Feature
	(properties
		noun 44
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 266 79 290 79 344 119 376 141 448 199 430 205 389 205 386 172 373 147 344 134 327 115 305 116 261 73
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
					init: 486 184 522 169 562 179 589 185 589 208 588 238 569 228 567 206 490 188
					yourself:
				)
		)
	)
)

(instance mural_45 of Feature
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
					init: 226 154 233 86 245 78 287 84 374 90 377 100 365 155 354 163 314 162 234 159 226 152
					yourself:
				)
		)
	)
)

(instance doorNumber_45 of Feature
	(properties
		noun 55
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 498 113 484 175 553 176 537 112
					yourself:
				)
		)
	)
)

(instance doorsNumbers_45 of Feature ; UNUSED
	(properties
		noun 55
		x 518
		y 114
		nsBottom 118
		nsLeft 502
		nsRight 534
		nsTop 111
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance desks_45 of Feature
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
					init: 7 273 47 273 53 290 7 292
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 130 286 145 253 190 247 209 255 201 292 134 290
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 229 285 249 268 269 244 314 238 314 264 336 276 335 298
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 376 290 348 254 370 234 404 230 404 250 389 269
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 376 285 421 260 476 249 511 253 501 299 444 296
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 470 239 500 216 507 244 477 247
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 592 238 555 243 557 277 585 281
					yourself:
				)
		)
	)
)

(instance mural_315 of Feature
	(properties
		noun 14
		x 290
		y 143
		nsBottom 286
		nsRight 580
		nsTop 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

