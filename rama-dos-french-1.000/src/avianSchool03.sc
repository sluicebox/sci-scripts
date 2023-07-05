;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6602)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianSchool03 0
)

(instance avianSchool03 of Location
	(properties)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(6607 ; avianSchool08
				(self addPicObj: faceNW faceN faceNE faceSE faceS faceSW faceNW)
			)
			(6605 ; avianSchool06
				(self addPicObj: faceNE faceSE faceS faceSW faceNW faceN faceNE)
			)
			(else
				(self addPicObj: faceN faceNE faceSE faceS faceSW faceNW faceN)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceNE
						(northEastMural init: global117)
					)
					(faceSE
						(southEastMural init: global117)
					)
					(faceS
						(leftSouthMural init: global117)
						(rightSouthMural init: global117)
					)
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
					(faceNE
						(northEastMural dispose:)
					)
					(faceSE
						(southEastMural dispose:)
					)
					(faceS
						(leftSouthMural dispose:)
						(rightSouthMural dispose:)
					)
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

(instance faceSE of CameraAngle
	(properties
		picture 6608
		edgeS 0
		edgeN 0
	)

	(method (init)
		(SEexit init:)
		(gCurRoom exitN: SEexit)
		(doorExitSE init:)
		(gCurRoom exitNE: doorExitSE)
		(super init:)
		(murals_0 init:)
		(desks_0 init:)
		(doorNumbers_0 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 90
		picture 6610
		edgeS 0
		edgeN 0
	)

	(method (init)
		(SWexit init:)
		(gCurRoom exitN: SWexit)
		(doorExitSW init:)
		(gCurRoom exitNW: doorExitSW)
		(super init:)
		(murals_90 init:)
		(desks_90 init:)
		(doorNumbers_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 45
		picture 6609
		edgeS 0
		edgeN 0
	)

	(method (init)
		(muralExitSE init:)
		(gCurRoom exitNW: muralExitSE)
		(muralExitSW init:)
		(gCurRoom exitNE: muralExitSW)
		(doorExitS init:)
		(gCurRoom exitN: doorExitS)
		(super init:)
		(murals_45 init:)
		(desks_45 init:)
		(doorNumbers_45 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 270
		edgeS 0
		edgeN 0
	)

	(method (init)
		(= picture
			(switch [global235 1]
				(0 6645)
				(1 6646)
				(3 6646)
				(else 6607)
			)
		)
		(NEexit init:)
		(gCurRoom exitN: NEexit)
		(super init:)
		(projector_270 init:)
		(mural_270 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 180
		picture 6611
		edgeS 0
		edgeN 0
	)

	(method (init)
		(NWexit init:)
		(gCurRoom exitN: NWexit)
		(super init:)
		(projector_180 init:)
		(murals_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 225
		picture 6606
		edgeS 0
		edgeN 0
	)

	(method (init)
		(= picture
			(switch [global235 1]
				(0 6643)
				(1 6644)
				(3 6644)
				(else 6606)
			)
		)
		(super init: &rest)
		(projector_225 init:)
	)
)

(instance northEastMural of View
	(properties
		x 557
		y 149
		cel 6
		view 6626
	)
)

(instance southEastMural of View
	(properties
		x 243
		y 135
		cel 7
		view 6626
	)
)

(instance leftSouthMural of View
	(properties
		x 21
		y 134
		cel 8
		view 6626
	)
)

(instance rightSouthMural of View
	(properties
		x 481
		y 108
		cel 9
		view 6626
	)
)

(instance southWestMural of View
	(properties
		x 217
		y 151
		loop 1
		view 6626
	)
)

(instance northWestMural of View
	(properties
		x 3
		y 167
		loop 1
		cel 1
		view 6626
	)
)

(instance defaultExit of ExitFeature ; UNUSED
	(properties)
)

(instance NEexit of ExitFeature
	(properties
		nsBottom 201
		nsLeft 237
		nsRight 421
		nsTop 80
		nextRoom 6607
	)
)

(instance NWexit of ExitFeature
	(properties
		nsBottom 188
		nsLeft 188
		nsRight 297
		nsTop 72
		nextRoom 6605
	)
)

(instance SWexit of ExitFeature
	(properties
		nsBottom 165
		nsLeft 142
		nsRight 418
		nsTop 75
		nextRoom 6603
	)
)

(instance doorExitSW of ExitFeature
	(properties
		nsBottom 178
		nsLeft 6
		nsRight 76
		nsTop 92
		nextRoom 6601
	)
)

(instance doorExitS of ExitFeature
	(properties
		nsBottom 179
		nsLeft 247
		nsRight 357
		nsTop 77
		nextRoom 6601
	)
)

(instance SEexit of ExitFeature
	(properties
		nsBottom 167
		nsLeft 160
		nsRight 443
		nsTop 77
		nextRoom 6609
	)
)

(instance doorExitSE of ExitFeature
	(properties
		nsBottom 187
		nsLeft 491
		nsRight 586
		nsTop 89
		nextRoom 6601
	)
)

(instance muralExitSE of ExitFeature
	(properties
		nsBottom 162
		nsLeft 2
		nsRight 158
		nsTop 56
		nextRoom 6609
	)
)

(instance muralExitSW of ExitFeature
	(properties
		nsBottom 164
		nsLeft 426
		nsRight 577
		nsTop 65
		nextRoom 6603
	)
)

(instance projector_225 of Feature
	(properties
		noun 40
		x 298
		y 160
		nsBottom 246
		nsLeft 202
		nsRight 394
		nsTop 75
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance projector_180 of Feature
	(properties
		noun 40
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 589 87 545 91 511 126 474 157 463 218 479 266 535 292 591 291
					yourself:
				)
		)
	)
)

(instance murals_180 of Feature
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
					init: 97 99 0 72 -2 154 56 158 72 146 79 92
					yourself:
				)
		)
	)
)

(instance murals_90 of Feature
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
					init: 207 92 215 82 351 83 357 92 355 145 346 152 220 153 209 145
					yourself:
				)
		)
	)
)

(instance desks_90 of Feature
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
					init: 227 244 240 233 287 231 290 264 272 275
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 337 233 325 250 332 264 365 267 341 279 341 287 419 287 445 268 430 257 396 250 389 230
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 445 233 429 249 452 272 471 271 481 258 485 235
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 545 250 508 254 515 267 536 279 578 281 590 281 592 259
					yourself:
				)
		)
	)
)

(instance doorNumbers_90 of Feature
	(properties
		noun 55
		x 34
		y 101
		nsBottom 107
		nsLeft 17
		nsRight 52
		nsTop 95
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance doorNumbers_45 of Feature
	(properties
		noun 55
		x 295
		y 103
		nsBottom 108
		nsLeft 280
		nsRight 311
		nsTop 98
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance murals_45 of Feature
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
					init: -1 52 113 67 117 151 108 163 2 164
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 467 83 478 70 593 60 591 158 481 163 470 151
					yourself:
				)
		)
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
					init: 10 251 73 253 77 278 69 294 1 291
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 521 250 492 271 515 289 584 292 585 262
					yourself:
				)
		)
	)
)

(instance murals_0 of Feature
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
					init: 230 91 237 82 283 80 373 79 382 94 377 150 367 159 327 157 242 157 231 149
					yourself:
				)
		)
	)
)

(instance doorNumbers_0 of Feature
	(properties
		noun 55
		x 556
		y 100
		nsBottom 107
		nsLeft 535
		nsRight 577
		nsTop 94
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
					init: 291 232 354 233 354 254 328 270 304 271 294 254
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 200 228 151 259 179 284 252 284 230 262 246 254 239 234
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 96 233 137 231 151 252 131 270 106 270 94 261 93 245
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 8 238 25 240 87 255 61 283 -1 285
					yourself:
				)
		)
	)
)

(instance projector_270 of Feature
	(properties
		noun 40
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 92 26 91 44 105 83 132 128 186 99 275 57 291 -9 289
					yourself:
				)
		)
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
					init: 515 76 505 91 514 159 528 165 592 165 591 72
					yourself:
				)
		)
	)
)

