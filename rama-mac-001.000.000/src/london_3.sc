;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3003)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Feature)
(use Actor)

(public
	london_3 0
)

(instance london_3 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3004 ; london_4
				(self addPicObj: faceS faceN faceS)
			)
			(else
				(self addPicObj: faceN faceS faceN)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 3102
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(southExitToLondon2 init:)
		(super init:)
		(CP_Map_Piece_E init:)
		(door2out_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3101
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 99)
			(= picture 3117)
		)
		(super init:)
		(northExitToLondon4 init:)
		(door3_0 init:)
		(mp_Piece_L31z init:)
		(CP_Map_Piece_D init:)
	)
)

(instance CP_Map_Piece_D of View
	(properties
		x 523
		y 216
		view 3100
		cel 1
	)

	(method (init)
		(if (== (proc70_9 13) 3003)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (onMe param1)
		(return (and (<= 507 (param1 x:) 563) (<= 191 (param1 y:) 225)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 13)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance CP_Map_Piece_E of View
	(properties
		x 446
		y 243
		view 3100
		loop 1
	)

	(method (init)
		(if (== (proc70_9 14) 3003)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 14)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_Piece_L31z of View
	(properties
		x 523
		y 206
		view 3100
	)

	(method (init)
		(if (== (proc70_9 75) 3003)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (onMe param1)
		(return (and (<= 507 (param1 x:) 563) (<= 191 (param1 y:) 225)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 75)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExitToLondon2 of ExitFeature
	(properties
		nsLeft 175
		nsTop 0
		nsRight 408
		nsBottom 269
		nextRoom 3002
		exitStyle 256
	)
)

(instance northExitToLondon4 of ExitFeature
	(properties
		nsLeft 174
		nsTop 93
		nsRight 430
		nsBottom 194
		nextRoom 3004
	)
)

(instance door2out_180 of Feature
	(properties
		noun 7
		nsLeft 86
		nsTop 4
		nsRight 515
		nsBottom 286
		x 300
		y 145
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance door3_0 of Feature
	(properties
		noun 9
		nsLeft 273
		nsTop 122
		nsRight 331
		nsBottom 161
		x 302
		y 141
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

