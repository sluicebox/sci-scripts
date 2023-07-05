;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2061)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use n1111)
(use Osc)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	CPLondon2 0
)

(instance CPLondon2 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2060 ; CPLondon1
				(self addPicObj: faceN faceS faceN)
			)
			(else
				(self addPicObj: faceS faceN faceS)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(149
				(if (== script takagishiTellsAboutBarrier)
					(self setScript: 0)
				)
			)
			(137
				(if (global117 contains: rayBeam)
					(rayBeam show:)
				)
				(global122 doVerb: theVerb)
			)
			(138
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
)

(instance faceN of CameraAngle
	(properties
		picture 2303
		edgeS 0
		edgeN 0
	)

	(method (init)
		(threeExit_0 init:)
		(super init: &rest)
		(rayBeam init: global117)
		(if (not (SetFlag 51))
			(gCurRoom setScript: takagishiTellsAboutBarrier)
		)
		(barrier_0 init:)
		(spikes_0 init:)
		(sea_0 init:)
		(london_0 init:)
		(lights_0 init:)
		(horns_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2304
		edgeS 0
		edgeN 0
	)

	(method (init)
		(oneExit_180 init:)
		(super init: &rest)
		(hubSite_180 init:)
	)
)

(instance rayBeam of Prop
	(properties
		noun 2
		x 344
		y 214
		view 2303
	)

	(method (init)
		(if (IsFlag 117)
			(return)
		)
		(super init: &rest)
		(self setHotspot: 144 setCycle: Osc -1)
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

(instance takagishiTellsAboutBarrier of Script
	(properties)

	(method (dispose)
		(proc1111_6)
		(global122 initialized: 0 init:)
		(rayBeam setCycle: Osc)
		(ClearFlag 117)
		(gGame handsOn:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 117)
				(gCurRoom doVerb: 137)
				(Robot 0 3106 global116 255 0 145) ; Open
				(Robot 1 0 0 145) ; DisplayFrame
				(= global107 3106)
				(= seconds 2)
			)
			(1
				(SoundManager stopMusic:)
				(rayBeam setCycle: 0)
				(global122 doVerb: 138)
				(SoundManager stopSounds:)
				(proc1111_7 3106 0 145 0 0 -1 0 self)
				(= register 0)
			)
			(2
				(rayBeam hide:)
			)
			(3
				(rayBeam show:)
				(if (<= (++ register) 19)
					(= state 1)
				else
					(= cycles 1)
				)
			)
			(4
				(self dispose:)
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
					init: 249 161 262 150 266 125 257 124 254 102 300 78 298 67 288 54 297 48 297 19 304 19 304 44 316 34 317 21 325 22 325 33 353 13 363 25 381 14 381 -1 398 0 389 13 404 22 409 17 410 -2 426 -1 426 6 415 10 414 20 415 36 419 49 421 60 458 66 457 1 464 -1 466 47 481 49 477 71 491 74 512 63 511 -1 519 -2 523 59 532 58 539 61 557 53 557 13 571 13 589 19 590 180 372 184 342 184 249 180
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
					init: 34 -1 47 32 68 45 80 70 82 110 151 117 180 126 183 134 180 244 168 252 133 259 98 257 77 264 27 247 -2 217 -7 0
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
				((Polygon new:) type: PTotalAccess init: 214 187 219 142 225 187 yourself:)
				((Polygon new:) type: PTotalAccess init: 233 190 241 117 254 189 yourself:)
				((Polygon new:) type: PTotalAccess init: 267 186 270 143 274 184 yourself:)
				((Polygon new:) type: PTotalAccess init: 284 187 287 121 295 187 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 332 189 337 125 344 166 347 125 352 146 355 90 363 187
					yourself:
				)
		)
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
					init: 52 -1 199 -1 192 24 191 61 203 93 221 117 242 133 267 139 267 146 223 137 179 119 137 96 100 65 73 32
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 392 -1 540 0 518 33 481 74 420 64 421 48 402 45 402 41 411 38 412 19 397 23
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
					init: 202 9 246 67 242 77 197 23
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 333 42 344 1 363 1 348 42
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
	(properties
		noun 4
		x 293
		y 82
		nsBottom 92
		nsLeft 284
		nsRight 302
		nsTop 73
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance hubSite_180 of Feature
	(properties
		noun 5
		x 300
		y 29
		nsBottom 60
		nsLeft 265
		nsRight 336
		nsTop -1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance oneExit_180 of ExitFeature
	(properties
		x 287
		y 165
		nsBottom 237
		nsLeft 69
		nsRight 506
		nsTop 94
		nextRoom 2060
	)
)

(instance threeExit_0 of ExitFeature
	(properties
		x 334
		y 178
		nsBottom 268
		nsLeft 118
		nsRight 550
		nsTop 88
		nextRoom 2062
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(if (and (not (IsFlag 117)) (== nextRoom 2062))
					(if (not (global122 beamStatus:))
						(super doVerb: theVerb)
					else
						(gGame autoSave: 1)
						(gCurRoom setScript: steppedIntoTheBarrier)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lectroSound of Sound
	(properties
		number 2061
		flags 1
	)
)

(instance steppedIntoTheBarrier of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 2061)
				(gCurRoom doVerb: 137)
				(UpdateScreenItem rayBeam)
				(FrameOut)
				(Load rsPIC 2305)
				(Load rsPIC 61)
				(= ticks 1)
			)
			(1
				(gCurRoom drawPic: 2305)
				(rayBeam dispose:)
				(lectroSound play:)
				(PalVary 0 -1 0 100 0 192) ; PalVaryStart
				(= ticks 30)
			)
			(2
				(lectroSound stop:)
				(PalVary 1 0 0) ; PalVaryReverse
				(= ticks 15)
			)
			(3
				(lectroSound play:)
				(PalVary 0 -1 0 100 0 192) ; PalVaryStart
				(= ticks 15)
			)
			(4
				(lectroSound stop:)
				(PalVary 1 0 0) ; PalVaryReverse
				(= ticks 15)
			)
			(5
				(lectroSound play:)
				(PalVary 0 -1 0 100 0 192) ; PalVaryStart
				(= ticks 30)
			)
			(6
				(lectroSound stop:)
				(PalVary 1 0 0) ; PalVaryReverse
				(= ticks 15)
			)
			(7
				(lectroSound play:)
				(PalVary 0 -1 0 100 0 192) ; PalVaryStart
				(= ticks 30)
			)
			(8
				(lectroSound stop:)
				(PalVary 1 0 0) ; PalVaryReverse
				(gCurRoom drawPic: 61)
				(= cycles 1)
			)
			(9
				(gCurRoom newRoom: 95) ; morgue
			)
		)
	)
)

