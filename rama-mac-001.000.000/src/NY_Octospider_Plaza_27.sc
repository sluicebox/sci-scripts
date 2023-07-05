;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5327)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	NY_Octospider_Plaza_27 0
)

(local
	local0
)

(instance NY_Octospider_Plaza_27 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5306 ; NY_Octospider_Plaza_6
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
			(7015 ; octoRampGate
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
			(5330 ; NY_Octospider_Plaza_30
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
			(else
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
		)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5375
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 239)
			(= picture 5394)
		)
		(if (and (not local0) (== gPrevRoomNum 7015)) ; octoRampGate
			(= local0 1)
			(= showBlack 1)
		)
		(super init: &rest)
		(= showBlack 0)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5376
		heading 135
		edgeN 0
		edgeS 0
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5373
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(cond
			((IsFlag 241)
				(= picture 5395)
				(= showBlack 1)
				(keyPadFeat init:)
				(lairExit init:)
			)
			((IsFlag 240)
				(= showBlack 1)
				(= picture 5396)
				(keyPadFeat init:)
			)
		)
		(super init: &rest)
		(octoKey init: global117)
		(octoTalisman init: global117)
		(if (IsFlag 240)
			(lairKeypad_45 init:)
			(lairDoor_45 init:)
		)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5374
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom6 init:)
		(super init: &rest)
	)
)

(instance exitToRoom6 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5306
	)
)

(instance keyPadFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 137 195 151 170 177 170 191 195 177 219 150 219
					yourself:
				)
			setHotspot: 2 18 106
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5330) ; NY_Octospider_Plaza_30
			)
			(18
				(gCurRoom newRoom: 5330) ; NY_Octospider_Plaza_30
			)
			(106
				(gCurRoom newRoom: 5330) ; NY_Octospider_Plaza_30
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lairExit of ExitFeature
	(properties
		nextRoom 7015
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 208 154 212 131 225 103 245 82 272 67 304 61 337 66 367 83 389 109 399 138 401 165 393 193 381 214 359 236 336 248 310 252 277 249 249 236 226 212 212 183
					yourself:
				)
		)
	)
)

(instance octoKey of View
	(properties
		x 153
		y 192
		view 5396
	)

	(method (init)
		(if (!= (proc70_9 91) 5330)
			(return)
		)
		(super init: &rest)
	)
)

(instance octoTalisman of View
	(properties
		x 153
		y 211
		view 5396
		cel 1
	)

	(method (init)
		(if (!= (proc70_9 104) 5330)
			(return)
		)
		(super init: &rest)
	)
)

(instance lairKeypad_45 of Feature
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
					init: 135 194 149 169 177 170 191 193 175 217 148 216
					yourself:
				)
		)
	)
)

(instance lairDoor_45 of Feature
	(properties
		noun 21
	)

	(method (init)
		(if (IsFlag 241)
			(= case 2)
		else
			(= case 1)
		)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 303 59 344 70 380 96 397 129 400 165 390 200 365 230 333 248 294 252 242 232 216 198 207 160 216 111 249 75
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (IsFlag 241)
					(= case 2)
					(super doVerb: theVerb)
				else
					(= case 0)
					(super doVerb: theVerb)
				)
			)
			(144
				(if (IsFlag 241)
					(gMessager say: noun theVerb 2 0 0 215) ; "A colorful hallway lies through this door."
				else
					(gMessager say: noun theVerb 1 0 0 215) ; "It appears to be a round door, but it is shut."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

