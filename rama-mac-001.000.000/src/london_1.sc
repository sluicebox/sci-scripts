;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3001)
(include sci.sh)
(use Main)
(use Location)
(use VidmailChoices)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Osc)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)

(public
	london_1 0
)

(instance london_1 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(108 ; matrixPuzzle
				(if (IsFlag 35)
					(ClearFlag 35)
				else
					(proc70_10 70 2007)
				)
				(self addPicObj: faceN faceE faceS faceSW faceN)
			)
			(3002 ; london_2
				(self addPicObj: faceS faceSW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceN faceE faceS faceSW faceN)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(137
				(if (global117 contains: rayBeam)
					(rayBeam show:)
				)
			)
			(138
				(if (global117 contains: rayBeam)
					(rayBeam hide:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 2319
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(southExitToCP init:)
		(super init:)
		(rayBeam init: global117)
		(rayBiot_225 init:)
		(switch_225 init:)
		(if
			(and
				(!= (proc70_9 40) 3063)
				(not (proc55_5 41))
				(not (SetFlag 310))
			)
			((ScriptID 200 0) setScript: 1) ; cplainRegion
			(sQuake play:)
			(gCurRoom setScript: (ScriptID 113 0)) ; sRamaQuake
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2318
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2317
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(london_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3001
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 98)
			(= picture 3008)
		)
		(super init:)
		(door_0 init:)
		(door init: setHotspot: 2)
		(if (IsFlag 98)
			(northExitToLondon2 init:)
		)
		(matrixPuzzle_1 init: setHotspot: 2)
	)
)

(instance southExitToCP of ExitFeature
	(properties
		nsLeft 72
		nsTop 71
		nsRight 469
		nsBottom 230
		nextRoom 2062
	)
)

(instance northExitToLondon2 of ExitFeature
	(properties
		nsLeft 259
		nsTop 78
		nsRight 345
		nsBottom 183
		nextRoom 3002
		exitStyle 256
	)
)

(instance door of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(if (IsFlag 98)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 261 179 260 139 283 107 310 107 332 139 332 181 398 181 397 138 336 82 264 81 200 131 199 179 261 179
						yourself:
					)
			)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 232 115 281 90 312 90 353 112 385 153 385 180 207 184 209 146 231 115
						yourself:
					)
			)
		)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 3009) ; london_Door_1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance matrixPuzzle_1 of Feature
	(properties
		nsLeft 400
		nsTop 145
		nsRight 433
		nsBottom 175
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 108) ; matrixPuzzle
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rayBeam of Prop
	(properties
		noun 21
		x 80
		y 190
		view 2319
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

(instance sQuake of Sound
	(properties
		flags 5
		number 3006
	)
)

(instance door_0 of Feature
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
					init: 171 180 216 92 159 70 294 49 428 69 372 88 423 180
					yourself:
				)
		)
	)
)

(instance rayBiot_225 of Feature
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
					init: 22 83 68 76 91 105 85 132 105 143 107 179
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 194 167 207 122 227 121 235 172
					yourself:
				)
		)
	)
)

(instance switch_225 of Feature
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
					init: 262 158 271 156 276 173 260 172
					yourself:
				)
		)
	)
)

(instance london_90 of Feature
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
					init: -6 0 118 5 140 72 117 139 165 180 -1 249
					yourself:
				)
		)
	)
)

