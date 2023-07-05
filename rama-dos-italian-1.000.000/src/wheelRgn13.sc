;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2022)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use System)

(public
	wheelRgn13 0
)

(local
	local0
	local1
	local2
	local3
)

(instance wheelRgn13 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= local3 0)
		(if local2
			(= local0 (= local1 ((ScriptID 210 0) wheelPosition:))) ; wheelRegion
		)
		(switch gPrevRoomNum
			(2021 ; wheelRgn12
				(self
					addPicObj:
						faceHub
						faceCounter
						faceAway
						faceClockwise
						faceHub
				)
			)
			(2023 ; wheelRgn14
				(self
					addPicObj:
						faceClockwise
						faceHub
						faceCounter
						faceAway
						faceClockwise
				)
			)
			(2026 ; wheelRgn17
				(self
					addPicObj:
						faceCounter
						faceAway
						faceClockwise
						faceHub
						faceCounter
				)
			)
			(2034 ; wheelRgn19
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
		heading 180
		picture 2236
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2026 init: 2)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(= global107 (+ 2100 local0))
		(WalkieTalkie showFrame: global107 0 377 142 1 global116)
		(wheel_180 init:)
		(hubSite_180 init:)
		(walkwayFeat init:)
	)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)
)

(instance faceHub of CameraAngle
	(properties
		heading 225
		edgeS 0
		edgeN 0
	)

	(method (init)
		(switch local1
			(0
				(= picture 2257)
			)
			(1
				(= picture 2258)
			)
			(2
				(= picture 2259)
			)
			(3
				(= picture 2260)
			)
			(4
				(= picture 2261)
			)
		)
		(defaultExit nextRoom: 2034 init: 1)
		(super init: &rest)
		(cond
			((and (not (SetFlag 65)) (== gPrevRoomNum 2021)) ; wheelRgn12
				(= local1 ((ScriptID 210 0) advanceSpokes:)) ; wheelRegion
				(hubTurn play:)
			)
			((and (== local1 0) (not local3))
				(= local3 1)
				(gCurRoom setScript: (ScriptID 210 3)) ; flashLight
				(proc1111_31 17)
			)
		)
		(lights_225 init:)
		(walkwayFeat init:)
	)

	(method (dispose)
		(if (gCurRoom script:)
			((gCurRoom script:) dispose:)
		)
		(super dispose: &rest)
	)
)

(instance faceCounter of CameraAngle
	(properties
		heading 315
		picture 2237
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2023 init: 0)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(lights_315 init:)
		(wheel_315 init:)
		(london_315 init:)
		(sea_315 init:)
		(walkwayFeat init:)
	)
)

(instance faceAway of CameraAngle
	(properties
		heading 45
		picture 2238
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit
			nextRoom: 2021
			init: -1
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 265 72 328 74 373 286 225 289
					yourself:
				)
		)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(wheel_45 init:)
		(sea_45 init:)
		(newyork_45 init:)
		(wheelExit_45 init:)
		(lights_45 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)

	(method (init param1)
		(super init:)
		(if (and argc (!= param1 -1))
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

(instance hubTurn of VMDMovie
	(properties
		movieName 2257
		endPic 2258
	)
)

(instance play_Shadow_Robot of Script
	(properties)

	(method (dispose)
		(= local0 local1)
		(= global107 (+ 2100 local0))
		(WalkieTalkie showFrame: global107 0 377 142 1 global116)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc1111_7 (+ 2100 local0) 377 142 global161 0 1 1 self)
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
					init: 330 32 485 -1 574 0 334 51
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
					init: 118 -1 433 57 451 72 0 9 1 -2
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
					init: -2 124 207 125 395 114 592 79 591 291 -2 292
					yourself:
				)
		)
	)
)

(instance wheel_45 of Feature
	(properties
		noun 5
		x 295
		y 197
		nsBottom 292
		nsLeft -1
		nsRight 591
		nsTop 102
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 134 102 144 72 144 36 133 -1 273 -1 269 30 259 69 241 101
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
					init: 164 103 174 78 181 43 185 1 203 1 214 33 210 71 193 103
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
				((Polygon new:) type: PTotalAccess init: 96 103 135 86 130 103 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 271 30 331 1 390 0 265 60
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
					init: -3 79 192 115 412 126 590 124 592 291 -3 291
					yourself:
				)
		)
	)
)

(instance london_315 of Feature
	(properties
		noun 16
		x 268
		y 23
		nsBottom 34
		nsLeft 257
		nsRight 280
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
					init: 396 1 543 1 553 32 568 54 592 80 497 99 456 75 416 36
					yourself:
				)
		)
	)
)

(instance wheelExit_45 of Feature
	(properties
		noun 23
		x 303
		y 195
		nsBottom 292
		nsLeft 251
		nsRight 355
		nsTop 98
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance hubSite_180 of Feature
	(properties
		noun 25
		x 330
		y 10
		nsBottom 20
		nsLeft 285
		nsRight 376
		nsTop 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

