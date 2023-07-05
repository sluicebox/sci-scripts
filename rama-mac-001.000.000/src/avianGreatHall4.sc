;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6203)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	avianGreatHall4 0
)

(instance avianGreatHall4 of Location
	(properties)

	(method (init)
		(super init:)
		(self addPicObj: faceN faceS faceN)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(if (== heading 180)
					(leftMural init: global117)
					(rightMural init: global117)
				)
			)
			(26
				(if (== heading 180)
					(leftMural dispose:)
					(rightMural dispose:)
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
		picture 6208
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(cond
			((not (IsFlag 128))
				(= picture 6224)
			)
			((not (IsFlag 130))
				(= picture 6216)
			)
			(else
				(SoundManager playMusic: 0 -1 6010)
			)
		)
		(defaultExit init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(perches_180 init:)
		(murals_180 init:)
		(dispensor_180 init:)
		(gourds_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6209
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 128))
			(gCurRoom setScript: sqwaukBoxScript)
		)
		(gourds_0 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties
		nextRoom 6201
	)
)

(instance tempExit of ExitFeature ; UNUSED
	(properties
		nextRoom 6204
	)
)

(instance elevatorUp of VMDMovie
	(properties
		movieName 6200
		frameRate 10
		options 256
		endPic 6215
	)

	(method (play)
		(if (<= global188 3)
			(= cacheSize 1200)
			(= preLoadPCT 100)
		)
		(super play: &rest)
	)
)

(instance sqwaukBoxScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sqwaukSound play: self)
			)
			(1
				(elevatorUp play:)
				(gCurRoom newRoom: 6204) ; avianGreatHall5
			)
		)
	)
)

(instance sqwaukSound of Sound
	(properties
		flags 5
		number 6106
	)
)

(instance leftMural of View
	(properties
		x 157
		y 185
		view 6201
		loop 4
	)
)

(instance rightMural of View
	(properties
		x 389
		y 185
		view 6201
		loop 4
		cel 1
	)
)

(instance gourds_0 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 223 12 221 18 235 11 245 0 246
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 133 212 148 211 148 222 147 230 132 230 131 222
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 177 210 196 207 198 223 181 223
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 389 206 402 208 406 224 391 223
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 428 212 437 211 446 222 439 230 428 227
					yourself:
				)
		)
	)
)

(instance perches_180 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 131 42 99 4 157 0 486 0 466 41 437 58 416 74 398 86 387 94 366 106 343 110 312 110 276 110 242 108 217 104 124 37
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
				((Polygon new:) type: PTotalAccess init: -2 44 60 224 1 247 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 156 108 146 205 212 185 200 123
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 393 120 374 183 443 201 437 106
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 527 223 586 45 589 238 yourself:)
		)
	)
)

(instance dispensor_180 of Feature
	(properties
		noun 16
		nsLeft 278
		nsTop 168
		nsRight 338
		nsBottom 216
		x 308
		y 192
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance gourds_180 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 28 230 39 228 41 243 25 250
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 3 36 86 200 116 153 126 120 150 182 159 109 168 108 183 174 186 113 179 76 59 4 4 3 33 132 52 123
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 92 212 106 210 108 221 94 226
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 238 143 261 177 271 178 278 167 284 142 306 142 311 166 320 167 329 168 337 169 342 168 343 154 342 142 335 130 329 124 305 119 284 123 282 133 274 134 271 124 261 124 259 138 244 142 249 168 264 155
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 424 110 431 182 437 162 448 175 469 122
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 500 63 494 123 520 191 552 113 511 53
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 495 215 516 218 517 233 493 229
					yourself:
				)
		)
	)
)

