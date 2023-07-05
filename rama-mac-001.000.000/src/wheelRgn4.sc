;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2013)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	wheelRgn4 0
)

(instance wheelRgn4 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2012 ; wheelRgn3
				(self addPicObj: faceS faceW faceN faceE faceS)
				(if (not (IsFlag 64))
					(gCurRoom setScript: raiseTheBiot)
				)
			)
			(2017 ; wheelRgn8
				(self addPicObj: faceE faceS faceW faceN faceE)
				(if (not (IsFlag 64))
					(gCurRoom setScript: raiseTheBiot)
				)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
				(if (not (IsFlag 64))
					(gCurRoom setScript: showBiotRaiseUp)
				)
			)
		)
	)
)

(instance showBiotRaiseUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(SetFlag 64)
				(biotRaising play: self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance raiseTheBiot of Script
	(properties)

	(method (dispose)
		(biotErect number: 2232 loop: 1 play:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 64)
				(biotErect number: 2230 loop: 1 play: self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2211
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(threeExit_315 init:)
		(super init: &rest)
		(sea_315 init:)
		(lights_315 init:)
		(london_315 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2214
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(fiveExit_45 init:)
		(super init: &rest)
		(sea_45 init:)
		(newyork_45 init:)
		(spikes_45 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2213
		heading 135
		edgeN 0
		edgeS 0
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2212
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 64)
			(= picture 2254)
		)
		(= showBlack 1)
		(gCurRoom setScript: 0)
		(super init: &rest)
		(viewBin init:)
		(trashBiot_225 init:)
		(wheel_225 init:)
		(lights_225 init:)
	)
)

(instance viewBin of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 280 266 408 264 436 272 446 285 279 289 268 277
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 2029) ; trashBin
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance biotRaising of VMDMovie
	(properties
		movieName 22122
		frameRate 15
		begPic 2212
		endPic 2254
	)

	(method (play)
		(if (<= global188 3)
			(= cacheSize 700)
			(= preLoadPCT 100)
		)
		(super play: &rest)
	)
)

(instance biotErect of Sound
	(properties
		flags 5
		number 2230
	)
)

(instance trashBiot_225 of Feature
	(properties
		noun 22
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 279 59 221 77 219 77 176 -2 155 -1 108 82 129 84 126 67 105 80 93 64 72 85 53 73 41 99 23 142 71 152 68 154 34 170 33 174 -1 217 -1 216 35 233 37 232 69 242 73 283 28 305 46 296 57 316 77 300 94 312 106 295 127 297 133 372 115 385 153 303 177 300 219 318 219 310 264 404 263 434 272 523 269 522 239 591 239 591 291 270 291 259 279
					yourself:
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
					init: 384 147 402 146 408 112 421 96 430 106 434 126 437 144 492 146 497 140 531 140 539 147 589 147 590 167 393 166 370 153
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
					init: 307 78 589 38 590 59 312 94
					yourself:
				)
		)
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
					init: 304 -1 433 -1 440 38 459 74 429 87 401 84 357 74 324 40
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
				((Polygon new:) type: PTotalAccess init: 1 9 357 75 336 87 -1 32 yourself:)
		)
	)
)

(instance london_315 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 148 20 167 24 179 47 156 42
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
					init: 101 104 124 83 139 54 143 27 140 1 258 1 252 32 230 73 203 97 172 112 154 105 136 105 116 112
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
					init: 157 83 163 63 171 34 173 1 208 0 206 26 198 48 183 69
					yourself:
				)
		)
	)
)

(instance spikes_45 of Feature
	(properties
		noun 21
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 195 175 201 122 208 99 222 131 226 184 202 184
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 235 184 239 124 246 184 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 274 182 281 111 300 126 304 175 291 182
					yourself:
				)
		)
	)
)

(instance fiveExit_45 of ExitFeature
	(properties
		nsLeft 128
		nsTop 95
		nsRight 369
		nsBottom 206
		x 248
		y 150
		nextRoom 2014
	)
)

(instance threeExit_315 of ExitFeature
	(properties
		nsLeft 47
		nsTop 98
		nsRight 347
		nsBottom 217
		x 197
		y 157
		nextRoom 2012
	)
)

