;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2042)
(include sci.sh)
(use Main)
(use Location)
(use VidmailChoices)
(use ExitFeature)
(use InvInitialize)
(use cplainRegion)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use System)

(public
	BeamRgn3 0
)

(instance BeamRgn3 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(self addPicObj: faceE faceS faceW faceN faceE)
		((ScriptID 200 0) addMigrant: 77) ; cplainRegion
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2107
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(matrixL32yNorth init: global117)
		(hanger_0 init:)
		(sea_0 init:)
		(northHCyl_0 init:)
		(horns_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2110
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(cond
			((IsFlag 67)
				(= showBlack 1)
				(= picture 38519)
				(gCurRoom setScript: reggieFidgets)
			)
			(
				(and
					(== (proc70_9 21) -1)
					(not (proc55_5 22))
					(not (IsFlag 121))
				)
				(gCurRoom setScript: talkToReggie)
				(= showBlack 1)
				(= picture 38519)
				(SetFlag 67)
			)
			((IsFlag 64)
				(= picture 2141)
			)
			(else
				(= showBlack 1)
				(gCurRoom setScript: raiseTheBiot)
			)
		)
		(super init: &rest)
		(sea_90 init:)
		(lights_90 init:)
		(binExitFeat init:)
		(trashBiot_90 init:)
	)

	(method (dispose)
		(proc1111_6)
		(reggieFidgets dispose:)
		(super dispose: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2109
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2108
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(twoExit_270 init:)
		(if (IsFlag 58)
			(if (== (proc70_9 55) 2043)
				(= picture 2142)
			else
				(= picture 2143)
			)
		)
		(super init: &rest)
		(sea_270 init:)
		(lights_270 init:)
		(if (not (IsFlag 58))
			(waxCube_270 init:)
		)
	)
)

(instance matrixL32yNorth of MigratingView
	(properties
		x 153
		y 292
		view 2021
		cel 3
		invItemID 77
	)

	(method (checkLocation param1)
		(return (== (param1 owner:) -1))
	)
)

(instance reggieFidgets of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(proc1111_7 2148 323 157 0 0 -1 0 self)
				(= start state)
			)
			(2
				(self init:)
			)
		)
	)

	(method (dispose)
		(= start 0)
		(super dispose:)
	)
)

(instance talkToReggie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(reggieNTrash play: self)
			)
			(2
				(proc70_1 21)
				(gGame handsOn:)
				(self setScript: reggieFidgets)
				(reggieFidgets cue:)
			)
		)
	)
)

(instance raiseTheBiot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(SetFlag 64)
				(biotRaising play:)
				(self dispose:)
			)
		)
	)
)

(instance biotRaising of VMDMovie
	(properties
		movieName 21101
		frameRate 8
		endPic 2141
	)
)

(instance reggieNTrash of VMDMovie
	(properties
		movieName 38511
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
				((Polygon new:)
					type: PTotalAccess
					init: 1 1 128 3 106 36 55 65 2 75
					yourself:
				)
		)
	)
)

(instance lights_90 of Feature
	(properties
		noun 7
		nsLeft 122
		nsTop 17
		nsRight 287
		nsBottom 32
		x 204
		y 24
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance hanger_0 of Feature
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
					init: 383 191 448 118 491 106 521 70 587 48 588 230
					yourself:
				)
		)
	)
)

(instance sea_0 of Feature
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
					init: 54 2 195 2 188 60 214 111 151 102 90 54
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 397 3 540 1 459 92 377 111 401 53
					yourself:
				)
		)
	)
)

(instance northHCyl_0 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 199 0 391 2 401 50 375 110 219 113 193 60
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
	(properties
		noun 4
		nsLeft 285
		nsTop 84
		nsRight 307
		nsBottom 107
		x 296
		y 95
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance waxCube_270 of Feature
	(properties
		noun 8
		nsLeft 284
		nsTop 145
		nsRight 306
		nsBottom 170
		x 295
		y 157
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
					init: 466 1 589 2 590 82 511 54
					yourself:
				)
		)
	)
)

(instance lights_270 of Feature
	(properties
		noun 7
		nsLeft 128
		nsTop 19
		nsRight 474
		nsBottom 32
		x 301
		y 25
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance trashBiot_90 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 239 241 229 195 230 190 243 191 241 154 229 154 176 129 184 105 229 110 227 100 234 84 240 78 235 73 235 65 242 54 240 40 250 26 268 37 286 55 289 55 294 45 296 24 310 20 311 -1 349 -1 351 15 364 15 366 48 372 48 396 15 418 -2 435 8 432 27 442 34 442 46 432 60 445 72 427 97 429 101 481 85 486 88 523 77 534 109 495 126 445 143 454 191 464 236 548 241 561 255 559 269 361 258 374 247
					yourself:
				)
		)
	)
)

(instance binExitFeat of ExitFeature
	(properties
		nextRoom 2055
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 383 241 404 236 549 240 562 254 560 266 367 257
					yourself:
				)
		)
	)
)

(instance twoExit_270 of ExitFeature
	(properties
		nsLeft 139
		nsTop 93
		nsRight 471
		nsBottom 232
		x 305
		y 162
		nextRoom 2041
	)
)

