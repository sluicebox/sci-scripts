;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2046)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	BeamRgn7 0
)

(instance BeamRgn7 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2045 ; BeamRgn6
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(2047 ; BeamRgn8
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2121
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(artifact_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 2124
		edgeS 0
		edgeN 0
	)

	(method (init)
		(eightExit_90 init:)
		(super init: &rest)
		(sea_90 init:)
		(lights_90 init:)
		(hanger_90 init:)
		(entrance_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2123
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(redFilter init: global117)
		(artifact_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		edgeS 0
		edgeN 0
	)

	(method (init)
		(sixExit_270 init:)
		(if
			(and
				(== gPrevRoomNum 2047) ; BeamRgn8
				(> ((ScriptID 200 0) numPiecesDropped:) 2) ; cplainRegion
				(not (IsFlag 26))
				(not (OneOf (proc70_9 67) -2 -3))
			)
			(= showBlack 1)
			(gCurRoom drawPic: 38160)
			(= picture 38160)
			(gCurRoom setScript: nicoleHandsOverMatrix)
		else
			(= picture 2122)
		)
		(super init: &rest)
		(lights_270 init:)
		(sea_270 init:)
	)
)

(instance redFilter of View
	(properties
		noun 12
		x 135
		y 289
		cel 6
		view 2021
	)

	(method (init)
		(if (!= (proc70_9 115) gCurRoomNum)
			(return)
		)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 115 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sea_90 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 3 0 128 0 70 61 4 46 yourself:)
		)
	)
)

(instance lights_90 of Feature
	(properties
		noun 7
		x 292
		y 24
		nsBottom 30
		nsLeft 123
		nsRight 462
		nsTop 18
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance hanger_90 of Feature
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
					init: 348 164 364 98 448 97 473 60 592 48 593 96 473 177 415 178 354 168
					yourself:
				)
		)
	)
)

(instance entrance_90 of Feature
	(properties
		noun 13
		x 378
		y 151
		nsBottom 183
		nsLeft 364
		nsRight 393
		nsTop 120
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance artifact_0 of Feature
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
					init: 123 141 202 73 359 109 365 187 343 195 293 152 214 222 129 161
					yourself:
				)
		)
	)
)

(instance lights_270 of Feature
	(properties
		noun 7
		x 300
		y 24
		nsBottom 33
		nsLeft 130
		nsRight 471
		nsTop 16
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_270 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 463 0 590 2 588 85 508 56
					yourself:
				)
		)
	)
)

(instance artifact_180 of Feature
	(properties
		noun 12
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 56 253 93 195 162 187 190 216 160 261 83 262
					yourself:
				)
		)
	)
)

(instance nicoleWMatrix of VMDMovie
	(properties
		movieName 38161
		begPic 38160
		endPic 38169
	)

	(method (play)
		(if (<= global188 3)
			(= cacheSize 1000)
			(= preLoadPCT 80)
		)
		(super play: &rest)
		(proc70_1 67 0)
	)
)

(instance nicoleHandsOverMatrix of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(nicoleWMatrix play: self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance eightExit_90 of ExitFeature
	(properties
		x 307
		y 152
		nsBottom 229
		nsLeft 115
		nsRight 500
		nsTop 75
		nextRoom 2047
	)
)

(instance sixExit_270 of ExitFeature
	(properties
		x 301
		y 156
		nsBottom 243
		nsLeft 59
		nsRight 544
		nsTop 70
		nextRoom 2045
	)
)

