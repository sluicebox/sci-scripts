;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2060)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Osc)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)

(public
	CPLondon1 0
)

(instance CPLondon1 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2000 ; cplains
				(self addPicObj: faceN faceS faceN)
			)
			(else
				(self addPicObj: faceS faceN faceS)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(137
				(if (global117 contains: lilTakagishi)
					(lilTakagishi setCycle: End)
				)
				(if (global117 contains: rayBeam)
					(rayBeam show:)
				)
				(global122 doVerb: theVerb)
			)
			(138
				(if (global117 contains: lilTakagishi)
					(lilTakagishi setCycle: Beg)
				)
				(if (global117 contains: rayBeam)
					(rayBeam hide:)
				)
				(global122 doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 2000) ; cplains
			(= exitStyle 13)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2301
		edgeS 0
		edgeN 0
	)

	(method (init)
		(twoExit_0 init:)
		(super init: &rest)
		(rayBeam init: global117)
		(if (not (IsFlag 51))
			(lilTakagishi init: global117)
		)
		(sea_0 init:)
		(barrier_0 init:)
		(london_0 init:)
		(spikes_0 init:)
		(lights_0 init:)
		(horns_0 init:)
	)
)

(instance lilTakagishi of Prop
	(properties
		x 121
		y 202
		cycleSpeed 2
		cel 5
		view 2305
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2302
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cplainExit_180 init:)
		(super init: &rest)
		(lights_180 init:)
		(hubSite_180 init:)
	)
)

(instance rayBeam of Prop
	(properties
		noun 2
		x 119
		y 198
		view 2301
	)

	(method (init)
		(if (IsFlag 117)
			(return)
		)
		(super init: &rest)
		(self setCycle: Osc -1 setHotspot: 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 21 6)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lights_180 of Feature
	(properties
		noun 6
		x 48
		y 117
		nsBottom 128
		nsLeft 5
		nsRight 92
		nsTop 107
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance hubSite_180 of Feature
	(properties
		noun 5
		x 295
		y 31
		nsBottom 60
		nsLeft 259
		nsRight 332
		nsTop 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_0 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 54 -1 199 -1 190 42 198 81 217 110 243 132 266 142 266 149 228 137 178 119 134 91 94 57 70 27
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 392 0 540 -1 521 29 499 57 470 83 458 92 425 100 388 95 388 91 398 61 399 29 392 -1
					yourself:
				)
		)
	)
)

(instance barrier_0 of Feature
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
					init: 32 118 39 102 51 93 58 86 46 74 59 73 59 40 66 42 76 80 89 85 97 96 96 121 132 123 145 129 148 188 138 191 115 187 95 191 69 187
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 477 189 474 131 478 126 528 120 528 99 537 84 549 76 557 50 560 39 565 39 564 57 564 71 567 73 580 71 581 73 568 84 579 91 590 105 590 138 569 166 555 174 535 191
					yourself:
				)
		)
	)
)

(instance london_0 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 236 175 264 151 265 131 256 127 255 114 285 106 291 92 283 80 288 77 290 49 294 51 293 75 304 70 303 52 308 53 309 69 339 57 345 62 360 57 359 12 365 14 365 46 379 45 377 19 381 20 383 50 391 50 390 55 383 56 381 73 385 82 387 94 410 96 409 38 415 38 416 82 427 82 425 98 448 90 446 49 453 49 456 90 477 85 478 59 490 52 501 59 511 81 503 97 502 101 515 104 512 121 476 128 475 175 435 179 354 179
					yourself:
				)
		)
	)
)

(instance spikes_0 of Feature
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
					init: 146 178 151 124 158 153 161 143 165 179 170 179 175 126 181 181 179 184 160 184
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 213 181 219 132 225 164 231 110 238 182
					yourself:
				)
		)
	)
)

(instance lights_0 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 201 7 243 64 239 74 196 25
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 330 42 347 0 366 0 342 46
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
	(properties
		noun 4
		x 288
		y 94
		nsBottom 104
		nsLeft 279
		nsRight 297
		nsTop 85
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance twoExit_0 of ExitFeature
	(properties
		x 311
		y 160
		nsBottom 221
		nsLeft 62
		nsRight 560
		nsTop 99
		nextRoom 2061
	)
)

(instance cplainExit_180 of ExitFeature
	(properties
		x 298
		y 163
		nsBottom 248
		nsLeft 55
		nsRight 542
		nsTop 79
		nextRoom 2000
	)
)

