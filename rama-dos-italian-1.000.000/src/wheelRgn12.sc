;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2021)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	wheelRgn12 0
)

(local
	local0
)

(instance wheelRgn12 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(ClearFlag 65)
		(faceW down: faceDownW)
		(faceDownW up: faceW)
		(switch gPrevRoomNum
			(2020 ; wheelRgn11
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
				(self setScript: (ScriptID 210 2)) ; resetWheel
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(149
				(if script
					(script dispose:)
					(= script 0)
					(gGame handsOn:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 315
		picture 2290
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(wheel_315 init:)
		(lights_315 init:)
		(london_315 init:)
		(sea_315 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 45
		picture 2233
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2020 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(sea_45 init:)
		(newyork_45 init:)
		(lights_45 init:)
		(wheel_45 init:)
		(still_45 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 135
		picture 2291
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(wheel_135 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 225
		picture 2934
		edgeN 0
	)

	(method (init)
		(if (and (== gPrevRoomNum 2020) (not local0)) ; wheelRgn11
			(= local0 1)
			(= showBlack 1)
		)
		(super init: &rest)
		(= showBlack 0)
		(wheel_225 init:)
		(lights_225 init:)
		(if (not (SetFlag 309))
			(gMessager say: 7 144 0 0 0 210) ; "I detect an empty space inside the hub of this structure, and an opening facing us."
		)
	)
)

(instance faceDownW of CameraAngle
	(properties
		heading 225
		picture 2234
		edgeW 0
		edgeE 0
		edgeS 0
	)

	(method (init)
		(defaultExit
			nextRoom: 2022
			init:
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 127 136 174 100 260 80 331 84 391 100 433 126 444 152 430 183 388 211 329 225 249 224 193 214 151 192 126 169
					yourself:
				)
		)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(pads_225_down init:)
		(roomInWheel_225_down init:)
		(walkway_225_down init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
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
					init: -1 147 264 147 265 84 288 57 288 -1 301 -1 301 56 320 76 324 109 323 146 589 148 590 292 -2 292
					yourself:
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
					init: 271 53 481 -1 579 -1 263 66
					yourself:
				)
		)
	)
)

(instance wheel_315 of Feature
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
					init: -3 152 141 152 152 126 161 152 285 157 286 213 308 210 320 193 371 190 435 198 445 197 464 133 482 197 590 204 591 292 -2 291
					yourself:
				)
		)
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
					init: 93 -1 438 58 454 72 0 5 0 0
					yourself:
				)
		)
	)
)

(instance london_315 of Feature
	(properties
		noun 16
		x 269
		y 24
		nsBottom 35
		nsLeft 257
		nsRight 281
		nsTop 13
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
					init: 395 -1 545 -1 556 37 575 62 591 76 590 123 523 106 472 85 430 54 409 26
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
					init: 80 165 112 138 136 103 146 59 142 23 133 1 271 1 268 40 254 81 234 111 204 140 169 161 154 157 131 160 95 168
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
					init: 128 153 137 139 160 106 177 63 181 22 186 1 203 -1 215 31 210 69 193 105 165 131 137 152
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
					init: 56 123 136 89 124 114 54 135
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 273 28 332 1 391 0 266 56
					yourself:
				)
		)
	)
)

(instance wheel_45 of Feature
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
					init: -1 205 47 185 96 181 172 186 173 153 183 135 195 163 198 186 224 188 361 187 396 178 405 135 419 183 499 182 543 186 551 200 592 206 592 293 -2 293
					yourself:
				)
		)
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
					init: 491 165 592 160 593 205 553 201 543 186 481 181
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

(instance wheel_135 of Feature
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
					init: -1 200 107 196 117 152 128 131 134 154 145 196 175 198 218 188 269 194 280 210 305 212 306 156 432 150 439 123 445 149 590 149 591 293 -3 293
					yourself:
				)
		)
	)
)

(instance pads_225_down of Feature
	(properties
		noun 6
		x 296
		y 155
		nsBottom 169
		nsLeft 255
		nsRight 338
		nsTop 141
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance roomInWheel_225_down of Feature
	(properties
		noun 7
		x 296
		y 17
		nsBottom 35
		nsLeft 274
		nsRight 319
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance walkway_225_down of Feature
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
					init: -2 38 184 35 179 17 191 17 276 28 316 27 402 16 417 17 407 37 592 38 591 83 314 66 331 142 263 141 277 69 -2 83
					yourself:
				)
		)
	)
)

