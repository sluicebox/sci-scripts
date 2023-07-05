;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2026)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use System)

(public
	wheelRgn17 0
)

(local
	local0
	local1
	local2
	local3
)

(instance wheelRgn17 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= local3 0)
		(if local2
			(= local0 (= local1 ((ScriptID 210 0) wheelPosition:))) ; wheelRegion
		)
		(switch gPrevRoomNum
			(2022 ; wheelRgn13
				(self
					addPicObj:
						faceClockwise
						faceHub
						faceCounter
						faceAway
						faceClockwise
				)
			)
			(2025 ; wheelRgn16
				(self
					addPicObj:
						faceCounter
						faceAway
						faceClockwise
						faceHub
						faceCounter
				)
			)
			(2038 ; wheelRgn23
				(self
					addPicObj:
						faceAway
						faceClockwise
						faceHub
						faceCounter
						faceAway
				)
			)
			(else
				(self
					addPicObj:
						faceHub
						faceCounter
						faceAway
						faceClockwise
						faceHub
				)
			)
		)
		(if (not local2)
			(switch picObj
				(faceClockwise
					(= local0 ((ScriptID 210 0) wheelPosition:)) ; wheelRegion
					(= local1 ((ScriptID 210 0) advanceSpokes:)) ; wheelRegion
					(self setScript: play_Shadow_Robot)
				)
				(faceCounter
					(= local1 ((ScriptID 210 0) advanceSpokes:)) ; wheelRegion
					(self setScript: (ScriptID 210 1)) ; soundsOfAdvancement
				)
				(else
					(= local1 ((ScriptID 210 0) wheelPosition:)) ; wheelRegion
				)
			)
		)
		(= local2 0)
	)

	(method (serialize param1)
		(= local2 param1)
		(super serialize: param1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(149
				(if script
					(proc1111_6)
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

(instance faceClockwise of CameraAngle
	(properties
		picture 2248
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2025 init: 2)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(= global107 (+ 2400 local0))
		(WalkieTalkie showFrame: global107 0 198 172 1 global116)
		(lights_225 init:)
		(wheel_225 init:)
		(walkwayFeat init:)
	)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)
)

(instance faceHub of CameraAngle
	(properties
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(switch local1
			(0
				(= picture 2277)
			)
			(1
				(= picture 2278)
			)
			(2
				(= picture 2279)
			)
			(3
				(= picture 2280)
			)
			(4
				(= picture 2281)
			)
		)
		(defaultExit nextRoom: 2038 init: 1)
		(super init: &rest)
		(if (and (== local1 4) (not local3))
			(= local3 1)
			(gCurRoom setScript: (ScriptID 210 3)) ; flashLight
			(proc1111_31 17)
		)
		(sea_315 init:)
		(lights_315 init:)
		(walkwayFeat init:)
	)
)

(instance faceCounter of CameraAngle
	(properties
		picture 2249
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2022 init: 0)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(sea_0 init:)
		(newyork_0 init:)
		(horns_0 init:)
		(wheelExit_0 init:)
		(wheel_0 init:)
		(lights_0 init:)
		(walkwayFeat init:)
	)
)

(instance faceAway of CameraAngle
	(properties
		picture 2250
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(lights_135 init:)
		(wheel_135 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)

	(method (init param1)
		(super init:)
		(= noun 11)
		(self
			setPolygon:
				(switch param1
					(0
						((Polygon new:)
							type: PBarredAccess
							init: 210 125 395 116 520 116 520 211 403 211 407 184 394 170 369 162 315 156 210 153
							yourself:
						)
					)
					(1
						(= noun 10)
						((Polygon new:)
							type: PBarredAccess
							init: 253 235 290 127 304 127 335 235
							yourself:
						)
					)
					(2
						((Polygon new:)
							type: PBarredAccess
							init: 63 211 63 113 201 116 370 125 370 152 302 155 225 162 192 171 182 186 188 211
							yourself:
						)
					)
				)
		)
	)
)

(instance walkwayFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= noun (defaultExit noun:))
		(self setHotspot: 144)
	)

	(method (onMe param1)
		(return (defaultExit onMe: param1))
	)
)

(instance play_Shadow_Robot of Script
	(properties)

	(method (dispose)
		(= local0 local1)
		(= global107 (+ 2400 local0))
		(WalkieTalkie showFrame: global107 0 198 172 1 global116)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc1111_7 (+ 2400 local0) 198 172 global161 0 1 1 self)
				(= local0 (mod (+ local0 1) 5))
			)
			(1
				(if (== local0 local1)
					(gGame handsOn:)
					(self dispose:)
				else
					(= state -1)
					(= cycles 1)
				)
			)
		)
	)
)

(instance sea_0 of Feature
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
					init: -1 -1 112 -2 115 29 130 71 154 102 184 125 138 125 90 106 58 88 26 65 -1 42
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 347 115 375 84 391 48 397 0 521 -1 500 31 471 63 436 92 404 112
					yourself:
				)
		)
	)
)

(instance newyork_0 of Feature
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
					init: 390 94 413 50 421 23 427 -1 464 -1 448 32 431 57 413 77
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
	(properties
		noun 14
		nsLeft 241
		nsTop 56
		nsRight 285
		nsBottom 100
		x 263
		y 78
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance wheelExit_0 of Feature
	(properties
		noun 23
		nsLeft 277
		nsTop 120
		nsRight 323
		nsBottom 154
		x 300
		y 137
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance wheel_0 of Feature
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
					init: -1 124 241 123 441 109 589 78 591 292 -2 292
					yourself:
				)
		)
	)
)

(instance lights_0 of Feature
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
					init: 337 62 395 21 381 69 334 94
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 156 91 200 108 211 122 189 122
					yourself:
				)
		)
	)
)

(instance lights_135 of Feature
	(properties
		noun 15
		nsLeft 217
		nsTop -1
		nsRight 275
		nsBottom 30
		x 246
		y 14
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: -2 120 591 93 591 292 -4 292
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
					init: 213 45 441 -2 592 -2 591 13 198 66
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
					init: -4 84 238 118 422 125 593 125 594 293 -3 294
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
					init: 333 -1 456 -1 459 32 471 63 497 93 521 110 549 123 487 127 442 111 403 91 364 58 343 25
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
					init: 123 -1 366 63 383 78 18 -1
					yourself:
				)
		)
	)
)

