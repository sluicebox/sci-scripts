;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1009)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	hubCamp9 0
)

(instance hubCamp9 of Location
	(properties
		noun 20
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(1008 ; hubCamp8
				(self addPicObj: faceE faceW faceE)
			)
			(else
				(switch global164
					(0
						(self addPicObj: faceE faceW faceE)
					)
					(else
						(self addPicObj: faceW faceE faceW)
					)
				)
			)
		)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 1091
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1191)
		)
		(super init: &rest)
		(exitToLadder init:)
		(gCurRoom exitN: exitToLadder)
		(if (proc1111_24 80)
			(darkSky_270 init:)
		)
		(fence_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 1092
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1192)
		)
		(super init: &rest)
		(fence_90 init:)
		(bomb init:)
		(gCurRoom setScript: blinking_Light)
	)

	(method (dispose)
		(blinking_Light dispose:)
		(super dispose: &rest)
	)
)

(instance exitToLadder of ExitFeature
	(properties
		nsBottom 189
		nsLeft 176
		nsRight 381
		nsTop 20
		nextRoom 1008
	)
)

(instance bomb of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 2 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 231 138 403 125 429 162 417 254 259 324 205 271
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(SoundManager fadeMusic: 0 15 10 1 0 playMusic: 0 1 1000 1100)
				(gCurRoom newRoom: 1014) ; hubCampBomb
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bombLight of View
	(properties
		view 1082
	)

	(method (init)
		(if (IsFlag 80)
			(self x: 307 y: 109 cel: 1)
			(super init: global117)
		else
			(self x: 311 y: 103 cel: 4)
			(super init: global117)
		)
	)
)

(instance blinking_Light of Script
	(properties)

	(method (init)
		(bombLight init:)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bombLight show:)
				(= seconds 1)
			)
			(1
				(bombLight hide:)
				(= state -1)
				(= seconds 1)
			)
		)
	)
)

(instance fence_90 of Feature
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
					init: 8 7 588 5 586 264 393 98 227 90 5 263
					yourself:
				)
		)
	)
)

(instance bomb_90 of Feature ; UNUSED
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 99 364 73 401 206 221 261
					yourself:
				)
		)
	)
)

(instance darkSky_270 of Feature
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
					init: 352 3 580 4 581 35 343 97
					yourself:
				)
		)
	)
)

(instance fence_270 of Feature
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
					init: 217 110 343 111 587 34 590 287 524 290 328 167 214 159
					yourself:
				)
		)
	)
)

