;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2024)
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
	wheelRgn15 0
)

(local
	local0
	local1
	local2
	local3
)

(instance wheelRgn15 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= local3 0)
		(if local2
			(= local0 (= local1 ((ScriptID 210 0) wheelPosition:))) ; wheelRegion
		)
		(switch gPrevRoomNum
			(2023 ; wheelRgn14
				(self
					addPicObj:
						faceCounter
						faceAway
						faceClockwise
						faceHub
						faceCounter
				)
			)
			(2025 ; wheelRgn16
				(self
					addPicObj:
						faceClockwise
						faceHub
						faceCounter
						faceAway
						faceClockwise
				)
			)
			(2036 ; wheelRgn21
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
				(faceCounter
					(= local0 ((ScriptID 210 0) wheelPosition:)) ; wheelRegion
					(= local1 ((ScriptID 210 0) advanceSpokes:)) ; wheelRegion
					(self setScript: play_Shadow_Robot)
				)
				(faceClockwise
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
		picture 2242
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2023 init: 2)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(horns_0 init:)
		(sea_0 init:)
		(newyork_0 init:)
		(lights_0 init:)
		(wheel_0 init:)
		(walkwayFeat init:)
	)
)

(instance faceHub of CameraAngle
	(properties
		heading 90
		edgeS 0
		edgeN 0
	)

	(method (init)
		(switch local1
			(0
				(= picture 2267)
			)
			(1
				(= picture 2268)
			)
			(2
				(= picture 2269)
			)
			(3
				(= picture 2270)
			)
			(4
				(= picture 2271)
			)
		)
		(defaultExit nextRoom: 2036 init: 1)
		(super init: &rest)
		(if (and (== local1 2) (not local3))
			(= local3 1)
			(gCurRoom setScript: (ScriptID 210 3)) ; flashLight
			(proc1111_31 17)
		)
		(wheel_90 init:)
		(walkwayFeat init:)
	)
)

(instance faceCounter of CameraAngle
	(properties
		heading 270
		picture 2243
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2025 init: 0)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(= global107 (+ 2200 local0))
		(WalkieTalkie showFrame: global107 0 -1 145 1 global116)
		(wheel_270 init:)
		(walkwayFeat init:)
	)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)
)

(instance faceAway of CameraAngle
	(properties
		heading 225
		picture 2244
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(wheel_225 init:)
		(lights_225 init:)
		(london_225 init:)
		(sea_225 init:)
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
		(= global107 (+ 2200 local0))
		(WalkieTalkie showFrame: global107 0 -1 145 1 global116)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc1111_7 (+ 2200 local0) -1 145 global161 0 1 1 self)
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

(instance wheel_270 of Feature
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
					init: 0 124 314 121 592 87 592 292 -2 293
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
					init: -2 97 390 127 590 107 591 291 -3 290
					yourself:
				)
		)
	)
)

(instance lights_225 of Feature
	(properties
		noun 15
		x 314
		y 95
		nsBottom 102
		nsLeft 39
		nsRight 590
		nsTop 88
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance london_225 of Feature
	(properties
		noun 16
		x 398
		y 79
		nsBottom 87
		nsLeft 385
		nsRight 412
		nsTop 71
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_225 of Feature
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
					init: 534 -1 590 0 591 61 557 34
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
	(properties
		noun 14
		x 122
		y 66
		nsBottom 91
		nsLeft 95
		nsRight 149
		nsTop 42
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 228 115 253 90 269 57 275 19 273 1 387 0 370 41 335 81 305 107 278 121
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
					init: 270 97 281 76 294 43 302 0 337 0 329 28 311 61 289 85
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
					init: 212 76 268 37 263 61 213 90
					yourself:
				)
		)
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
					init: -2 79 88 103 311 122 493 126 589 124 591 292 -2 290
					yourself:
				)
		)
	)
)

(instance wheel_90 of Feature
	(properties
		noun 5
		x 295
		y 205
		nsBottom 291
		nsLeft -2
		nsRight 592
		nsTop 120
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

