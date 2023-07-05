;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2023)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use System)

(public
	wheelRgn14 0
)

(local
	local0
	local1
	local2
)

(instance wheelRgn14 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= local2 0)
		(if local1
			(= local0 ((ScriptID 210 0) wheelPosition:)) ; wheelRegion
		)
		(switch gPrevRoomNum
			(2022 ; wheelRgn13
				(self
					addPicObj:
						faceCounter
						faceAway
						faceClockwise
						faceHub
						faceCounter
				)
			)
			(2024 ; wheelRgn15
				(self
					addPicObj:
						faceClockwise
						faceHub
						faceCounter
						faceAway
						faceClockwise
				)
			)
			(2035 ; wheelRgn20
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
		(if (and (not local1) (OneOf picObj faceCounter faceClockwise))
			(= local0 ((ScriptID 210 0) advanceSpokes:)) ; wheelRegion
			(self setScript: (ScriptID 210 1)) ; soundsOfAdvancement
		)
		(= local1 0)
	)

	(method (serialize param1)
		(= local1 param1)
		(super serialize: param1)
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

(instance faceClockwise of CameraAngle
	(properties
		heading 90
		picture 2239
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2022 init: 2)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(wheel_90 init:)
		(ladder_90 init:)
		(walkwayFeat init:)
	)
)

(instance faceHub of CameraAngle
	(properties
		heading 180
		edgeS 0
		edgeN 0
	)

	(method (init)
		(switch local0
			(0
				(= picture 2262)
			)
			(1
				(= picture 2263)
			)
			(2
				(= picture 2264)
			)
			(3
				(= picture 2265)
			)
			(4
				(= picture 2266)
			)
		)
		(defaultExit nextRoom: 2035 init: 1)
		(super init: &rest)
		(if (and (== local0 1) (not local2))
			(= local2 1)
			(gCurRoom setScript: (ScriptID 210 3)) ; flashLight
			(proc1111_31 17)
		)
		(wheel_180 init:)
		(walkwayFeat init:)
	)
)

(instance faceCounter of CameraAngle
	(properties
		picture 2240
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2024 init: 0)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(lights_0 init:)
		(wheel_0 init:)
		(walkwayFeat init:)
	)
)

(instance faceAway of CameraAngle
	(properties
		heading 225
		picture 2241
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(wheel_225 init:)
		(lights_225 init:)
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
					init: 329 53 471 0 563 1 318 65
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
					init: -1 125 173 125 355 119 592 84 592 292 -2 294
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
					init: -3 95 591 122 593 291 -4 291
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
					init: -1 48 131 100 66 98 -2 77
					yourself:
				)
		)
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
					init: 138 -1 293 -1 266 43 259 81 260 105 165 101 145 57
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 533 -1 590 -1 591 83 573 119 542 117 552 82 552 35
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
					init: -2 77 147 110 347 124 590 123 591 292 -3 291
					yourself:
				)
		)
	)
)

(instance ladder_90 of Feature
	(properties
		noun 23
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 256 113 283 114 328 150 291 153
					yourself:
				)
		)
	)
)

(instance wheel_180 of Feature
	(properties
		noun 5
		x 295
		y 206
		nsBottom 292
		nsLeft -2
		nsRight 592
		nsTop 120
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

