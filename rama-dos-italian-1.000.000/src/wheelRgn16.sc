;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2025)
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
	wheelRgn16 0
)

(local
	local0
	local1
	local2
	local3
)

(instance wheelRgn16 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= local3 0)
		(if local2
			(= local0 (= local1 ((ScriptID 210 0) wheelPosition:))) ; wheelRegion
		)
		(switch gPrevRoomNum
			(2024 ; wheelRgn15
				(self
					addPicObj:
						faceCounter
						faceAway
						faceClockwise
						faceHub
						faceCounter
				)
			)
			(2026 ; wheelRgn17
				(self
					addPicObj:
						faceClockwise
						faceHub
						faceCounter
						faceAway
						faceClockwise
				)
			)
			(2037 ; wheelRgn22
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
		heading 315
		picture 2245
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2024 init: 2)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(lights_315 init:)
		(london_315 init:)
		(sea_315 init:)
		(horns_315 init:)
		(wheel_315 init:)
		(walkwayFeat init:)
	)
)

(instance faceHub of CameraAngle
	(properties
		edgeS 0
		edgeN 0
	)

	(method (init)
		(switch local1
			(0
				(= picture 2272)
			)
			(1
				(= picture 2273)
			)
			(2
				(= picture 2274)
			)
			(3
				(= picture 2275)
			)
			(4
				(= picture 2276)
			)
		)
		(defaultExit nextRoom: 2037 init: 1)
		(super init: &rest)
		(if (and (== local1 3) (not local3))
			(= local3 1)
			(gCurRoom setScript: (ScriptID 210 3)) ; flashLight
			(proc1111_31 17)
		)
		(wheel_0 init:)
		(wheelExit_0 init:)
		(sea_0 init:)
		(walkwayFeat init:)
	)
)

(instance faceCounter of CameraAngle
	(properties
		heading 180
		picture 2246
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2026 init: 0)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(= global107 (+ 2300 local0))
		(WalkieTalkie showFrame: global107 0 1 147 1 global116)
		(sea_180 init:)
		(wheel_180 init:)
		(walkwayFeat init:)
	)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)
)

(instance faceAway of CameraAngle
	(properties
		heading 90
		picture 2247
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(wheel_90 init:)
		(lights_90 init:)
		(hubCamp_90 init:)
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
		(= global107 (+ 2300 local0))
		(WalkieTalkie showFrame: global107 0 1 147 1 global116)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc1111_7 (+ 2300 local0) 1 147 global161 0 1 1 self)
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

(instance sea_180 of Feature
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
					init: 14 0 101 1 83 25 44 55 -1 77 -1 18
					yourself:
				)
		)
	)
)

(instance wheel_180 of Feature
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
					init: -1 124 94 125 275 123 498 102 591 78 591 292 -3 291
					yourself:
				)
		)
	)
)

(instance wheel_90 of Feature
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
					init: -3 105 197 126 591 95 592 292 -3 292
					yourself:
				)
		)
	)
)

(instance lights_90 of Feature
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
					init: 460 104 591 51 591 74 498 102
					yourself:
				)
		)
	)
)

(instance hubCamp_90 of Feature
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
					init: 188 15 201 9 216 9 231 15 239 30 237 43 225 59 210 59 193 51
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
					init: 96 -1 309 64 329 84 38 -1
					yourself:
				)
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
					init: 134 1 158 1 170 25 141 16
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
					init: 275 0 397 0 396 39 413 81 443 112 468 127 405 126 351 101 310 65 284 24
					yourself:
				)
		)
	)
)

(instance horns_315 of Feature
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
					init: 531 54 542 41 555 34 571 29 592 36 591 68 574 78 556 81 538 74
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
					init: -3 87 16 91 277 121 453 126 590 124 591 291 -3 291
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
					init: -2 123 199 129 354 129 535 125 590 121 592 292 -3 292
					yourself:
				)
		)
	)
)

(instance wheelExit_0 of Feature
	(properties
		noun 23
		x 432
		y 137
		nsBottom 150
		nsLeft 417
		nsRight 447
		nsTop 125
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
					init: 0 -1 20 -1 29 31 47 65 77 97 117 125 67 124 -2 100
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 267 131 298 106 311 88 333 -2 450 -2 422 46 372 94 307 130
					yourself:
				)
		)
	)
)

