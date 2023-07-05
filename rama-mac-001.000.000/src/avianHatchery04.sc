;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6804)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Compass)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianHatchery04 0
)

(instance avianHatchery04 of Location
	(properties)

	(method (init)
		(super init:)
		(faceS up: faceUpS)
		(faceUpS down: faceS)
		(faceN up: faceUpN)
		(faceUpN down: faceN)
		(switch gPrevRoomNum
			(6803 ; avianHatchery03
				(switch global164
					(0
						(self addPicObj: faceS faceW faceN faceE faceS)
					)
					(90
						(self addPicObj: faceW faceN faceE faceS faceW)
					)
					(180
						(self addPicObj: faceN faceE faceS faceW faceN)
					)
					(270
						(self addPicObj: faceE faceS faceW faceN faceE)
					)
				)
			)
			(6805 ; avianHatchery05
				(switch global164
					(0
						(self addPicObj: faceS faceW faceN faceE faceS)
					)
					(90
						(self addPicObj: faceW faceN faceE faceS faceW)
					)
					(180
						(self addPicObj: faceN faceE faceS faceW faceN)
					)
					(270
						(self addPicObj: faceE faceS faceW faceN faceE)
					)
				)
			)
			(6820 ; avNicheHatcheryDoor
				(switch global164
					(0
						(self addPicObj: faceN faceE faceS faceW faceN)
					)
					(90
						(self addPicObj: faceW faceN faceE faceS faceW)
					)
					(270
						(self addPicObj: faceE faceS faceW faceN faceE)
					)
				)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceS
						(northMural init: global117)
					)
					(faceE
						(westMural init: global117)
					)
					(faceUpS
						(northUpMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceS
						(northMural dispose:)
					)
					(faceE
						(westMural dispose:)
					)
					(faceUpS
						(northUpMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceUpS of CameraAngle
	(properties
		picture 6821
		heading 180
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(if (not (IsFlag 147))
			(SetFlag 147)
			(Compass update:)
			(avianFly play:)
		)
		(super init:)
		(murals_180_up init:)
		(elevatedRoom_180_up init:)
		(jungleGym_180_up init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6820
		heading 180
		edgeS 0
	)

	(method (init)
		(super init:)
		(murals_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6822
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(boxExit init:)
		(hatchery03Exit1 init:)
		(incubatorExit init:)
		(gCurRoom exitNW: boxExit)
		(gCurRoom exitN: incubatorExit)
		(gCurRoom exitNE: hatchery03Exit1)
		(super init:)
		(jungleGym_270 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6823
		edgeS 0
	)

	(method (init)
		(leftExit init:)
		(gCurRoom exitNW: leftExit)
		(rightExit init:)
		(gCurRoom exitNW: rightExit)
		(super init:)
		(niche init:)
		(column_0 init:)
	)
)

(instance faceUpN of CameraAngle
	(properties
		picture 6824
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(super init:)
		(column_0_up init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6825
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(rampExit init:)
		(gCurRoom exitN: rampExit)
		(super init:)
		(murals_90 init:)
		(incubator_90 init:)
	)
)

(instance niche of Feature
	(properties
		nsLeft 287
		nsTop 160
		nsRight 330
		nsBottom 184
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 6820) ; avNicheHatcheryDoor
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hatchery03Exit1 of ExitFeature
	(properties
		nsLeft 494
		nsTop 140
		nsRight 568
		nsBottom 249
		nextRoom 6803
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 90)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boxExit of ExitFeature
	(properties
		nsLeft 138
		nsTop 109
		nsRight 211
		nsBottom 189
		nextRoom 6807
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 0)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance incubatorExit of ExitFeature
	(properties
		nsLeft 344
		nsTop 102
		nsRight 446
		nsBottom 180
		nextRoom 6807
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 90)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rampExit of ExitFeature
	(properties
		nsLeft 71
		nsTop 120
		nsRight 224
		nsBottom 232
		nextRoom 6805
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 270)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hatchery03Exit2 of ExitFeature ; UNUSED
	(properties
		nsLeft 1
		nsTop 46
		nsRight 75
		nsBottom 180
		nextRoom 6803
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 180)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 72
		nsRight 72
		nsBottom 215
		nextRoom 6803
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 180)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightExit of ExitFeature
	(properties
		nsLeft 491
		nsTop 67
		nsRight 589
		nsBottom 225
		nextRoom 6805
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 180)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance avianFly of VMDMovie
	(properties
		movieName 6827
		endPic 6824
	)
)

(instance northMural of View
	(properties
		x 202
		y 47
		view 6804
	)
)

(instance westMural of View
	(properties
		x 179
		y 165
		view 6804
		cel 1
	)
)

(instance northUpMural of View
	(properties
		x 238
		y 274
		view 6804
		cel 2
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
					init: 179 117 227 117 225 141 180 145
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 258 119 306 115 304 138 255 138
					yourself:
				)
		)
	)
)

(instance incubator_90 of Feature
	(properties
		noun 38
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 23 126 52 119 77 129 75 141 100 144 113 135 99 127 116 123 119 83 120 151 6 151 10 141 25 138 25 127 18 127 18 127 48 117
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 214 150 222 137 301 138 333 137 334 80 360 76 371 121 373 135 378 149 221 149
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 142 77 157 118 165 129 159 135 157 147 153 149 145 130 140 124 140 84
					yourself:
				)
		)
	)
)

(instance column_0 of Feature
	(properties
		noun 37
		nsLeft 94
		nsTop 2
		nsRight 547
		nsBottom 94
		x 320
		y 48
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance column_0_up of Feature
	(properties
		noun 37
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 102 -1 120 48 116 55 106 46 94 52 47 180 55 249 49 286 560 290 549 243 518 211 543 204 520 171 497 167 466 47 486 0
					yourself:
				)
		)
	)
)

(instance murals_180 of Feature
	(properties
		noun 14
		nsLeft 137
		nsTop 3
		nsRight 482
		nsBottom 78
		x 309
		y 40
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance murals_180_up of Feature
	(properties
		noun 14
		nsLeft 188
		nsTop 233
		nsRight 532
		nsBottom 296
		x 360
		y 264
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance jungleGym_180_up of Feature
	(properties
		noun 39
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 240 26 227 76 240 141 298 146 327 229 406 255 414 215 370 171 344 169 344 145 433 146 442 220 590 209 590 38 463 56 464 17 432 18 428 85 396 90 391 115 341 118 342 76 260 78 264 56 250 17
					yourself:
				)
		)
	)
)

(instance elevatedRoom_180_up of Feature
	(properties
		noun 62
		nsLeft 159
		nsTop 37
		nsRight 390
		nsBottom 60
		x 274
		y 48
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance jungleGym_270 of Feature
	(properties
		noun 39
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 107 2 197 -2 204 115 113 113 88 5
					yourself:
				)
		)
	)
)

