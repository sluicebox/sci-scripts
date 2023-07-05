;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2017)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	wheelRgn8 0
)

(instance wheelRgn8 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2033 ; valveCU
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(2032 ; trayCU
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(2020 ; wheelRgn11
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(2016 ; wheelRgn7
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 315
		picture 2223
		edgeS 0
		edgeN 0
	)

	(method (init)
		(sevenExit_315 init:)
		(super init: &rest)
		(laser_315 init:)
		(lights_315 init:)
		(london_315 init:)
		(sea_315 init:)
		(ruinBiot_315 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 45
		picture 2226
		edgeS 0
		edgeN 0
	)

	(method (init)
		(threeExit_45 init:)
		(fourExit_45 init:)
		(super init: &rest)
		(sea_45 init:)
		(newyork_45 init:)
		(lights_45 init:)
		(spikes_45 init:)
		(still_45 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 135
		picture 2225
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(valveCUExit init:)
		(trayCUExit init:)
		(glassDome init: global117)
		(fermentBox init: global117)
		(fluidLevel init: global117)
		(inputBoxFeat init:)
		(trayFeat init:)
		(pipe_135 init:)
		(still_135 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 225
		picture 2224
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(wheel_225 init:)
		(still_225 init:)
		(lights_225 init:)
		(london_225 init:)
	)
)

(instance glassDome of View
	(properties
		x 112
		y 201
		loop 1
		cel 2
		view 2019
	)

	(method (init)
		(if (not (IsFlag 60))
			(return)
		)
		(super init: &rest)
	)
)

(instance fermentBox of View
	(properties
		x 197
		y 244
		loop 1
		view 2019
	)

	(method (init)
		(if (!= (proc70_9 34) 2017)
			(return)
		)
		(super init: &rest)
	)
)

(instance fluidLevel of Prop
	(properties
		x 516
		y 228
		view 2019
	)

	(method (init)
		(if (not (IsFlag 60))
			(return)
		)
		(= cel global200)
		(super init: &rest)
	)
)

(instance inputBoxFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 189 222 260 222 260 245 185 245
					yourself:
				)
			setHotspot: 57 79
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 57 79)
			(gCurRoom newRoom: 2033) ; valveCU
		else
			(super doVerb: theVerb)
		)
	)
)

(instance trayFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 553 222 578 222 578 240 553 240
					yourself:
				)
			setHotspot: 40 38 39
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 40 38 39)
			(gCurRoom newRoom: 2032) ; trayCU
		else
			(super doVerb: theVerb)
		)
	)
)

(instance still_135 of Feature
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
					init: 174 114 351 117 356 140 338 160 337 202 357 200 359 173 376 173 387 188 501 187 518 181 520 170 538 164 554 171 556 183 565 191 571 218 583 226 559 256 557 272 573 291 502 291 504 280 515 270 515 259 494 223 474 221 394 224 389 234 377 234 373 220 340 219 332 243 380 290 125 292 173 247 165 232 167 197 179 165 168 140
					yourself:
				)
		)
	)
)

(instance pipe_135 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 40 592 42 591 236 -1 240
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 15)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wheel_225 of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 428 144 429 126 447 91 461 120 469 152 501 142 558 141 590 151 592 191 527 183 470 181
					yourself:
				)
		)
	)
)

(instance still_225 of Feature
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
					init: -1 13 74 69 145 216 139 241 106 291 -1 291
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 15)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lights_225 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 203 97 590 40 590 57 191 108
					yourself:
				)
		)
	)
)

(instance london_225 of Feature
	(properties
		noun 16
		x 471
		y 50
		nsBottom 58
		nsLeft 458
		nsRight 485
		nsTop 42
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance laser_315 of Feature
	(properties
		noun 2
		x 190
		y 174
		nsBottom 195
		nsLeft 173
		nsRight 208
		nsTop 154
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lights_315 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 7 358 76 382 93 -2 31
					yourself:
				)
		)
	)
)

(instance london_315 of Feature
	(properties
		noun 16
		x 162
		y 32
		nsBottom 45
		nsLeft 148
		nsRight 176
		nsTop 20
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_315 of Feature
	(properties
		noun 20
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 304 -1 435 -1 442 41 465 81 492 102 403 103 357 75 320 33
					yourself:
				)
		)
	)
)

(instance ruinBiot_315 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 258 171 270 154 291 137 313 140 298 161 270 179
					yourself:
				)
		)
	)
)

(instance sea_45 of Feature
	(properties
		noun 20
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 100 101 130 70 141 39 139 0 257 -1 246 45 214 87 147 118
					yourself:
				)
		)
	)
)

(instance newyork_45 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 155 85 170 46 171 1 209 0 204 33 187 61
					yourself:
				)
		)
	)
)

(instance lights_45 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 65 56 139 24 134 51 67 71
					yourself:
				)
		)
	)
)

(instance spikes_45 of Feature
	(properties
		noun 21
		x 326
		y 155
		nsBottom 171
		nsLeft 303
		nsRight 349
		nsTop 140
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance still_45 of Feature
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
					init: 519 163 572 54 589 46 590 291 558 291 519 259 505 214
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 15)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance threeExit_45 of ExitFeature
	(properties
		x 146
		y 151
		nsBottom 214
		nsLeft 32
		nsRight 261
		nsTop 88
		nextRoom 2012
	)
)

(instance fourExit_45 of ExitFeature
	(properties
		x 353
		y 150
		nsBottom 191
		nsLeft 274
		nsRight 433
		nsTop 109
		nextRoom 2013
	)
)

(instance sevenExit_315 of ExitFeature
	(properties
		x 259
		y 165
		nsBottom 226
		nsLeft 120
		nsRight 398
		nsTop 104
		nextRoom 2016
	)
)

(instance valveCUExit of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 74 174 263 174 263 268 74 268
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 2033) ; valveCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trayCUExit of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 481 166 582 166 582 272 481 272
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 2032) ; trayCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

