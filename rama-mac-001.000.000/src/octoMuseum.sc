;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7600)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	octoMuseum 0
)

(instance octoMuseum of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7208 ; octoMeenie9
				(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7200)
				(self
					addPicObj:
						faceTeacher
						faceW
						faceNW
						faceN
						faceMeenie
						faceE
						faceSE
						faceS
						faceTeacher
				)
			)
			(7603 ; octoMuseumManCU
				(self
					addPicObj:
						faceSE
						faceS
						faceTeacher
						faceW
						faceNW
						faceN
						faceMeenie
						faceE
						faceSE
				)
			)
			(7606 ; octoMuseumCircle1CU
				(self
					addPicObj:
						faceE
						faceSE
						faceS
						faceTeacher
						faceW
						faceNW
						faceN
						faceMeenie
						faceE
				)
			)
			(7607 ; octoMuseumCircle2CU
				(self
					addPicObj:
						faceE
						faceSE
						faceS
						faceTeacher
						faceW
						faceNW
						faceN
						faceMeenie
						faceE
				)
			)
			(7608 ; octoMuseumCircle3CU
				(self
					addPicObj:
						faceS
						faceTeacher
						faceW
						faceNW
						faceN
						faceMeenie
						faceE
						faceSE
						faceS
				)
			)
			(7609 ; octoMuseumCircle4CU
				(self
					addPicObj:
						faceS
						faceTeacher
						faceW
						faceNW
						faceN
						faceMeenie
						faceE
						faceSE
						faceS
				)
			)
			(7610 ; octoMuseumCircle5CU
				(self
					addPicObj:
						faceNW
						faceN
						faceMeenie
						faceE
						faceSE
						faceS
						faceTeacher
						faceW
						faceNW
				)
			)
			(7611 ; octoMuseumCircle6CU
				(self
					addPicObj:
						faceNW
						faceN
						faceMeenie
						faceE
						faceSE
						faceS
						faceTeacher
						faceW
						faceNW
				)
			)
			(7604 ; octoMuseumStandCU
				(self
					addPicObj:
						faceW
						faceNW
						faceN
						faceMeenie
						faceE
						faceSE
						faceS
						faceTeacher
						faceW
				)
			)
			(7605 ; octoMuseumWheelCU
				(self
					addPicObj:
						faceN
						faceMeenie
						faceE
						faceSE
						faceS
						faceTeacher
						faceW
						faceNW
						faceN
				)
			)
			(else
				(self
					addPicObj:
						faceMeenie
						faceE
						faceSE
						faceS
						faceTeacher
						faceW
						faceNW
						faceN
						faceMeenie
				)
			)
		)
	)

	(method (dispose)
		(if (and (== picObj faceMeenie) (!= (SoundManager musicNum:) 7150))
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7150)
		)
		(super dispose: &rest)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 7602
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToWheel init:)
		(WHEEL_0 init:)
		(super init:)
	)
)

(instance faceMeenie of CameraAngle
	(properties
		picture 7603
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToMeenie init:)
		(gCurRoom exitN: exitToMeenie)
		(super init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 7604
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToCircle1 init:)
		(exitToCircle2 init:)
		(super init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 7605
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToMan init:)
		(super init:)
		(TAKAGISHI_135 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 7606
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToCircle3 init:)
		(exitToCircle4 init:)
		(super init: &rest)
	)
)

(instance faceTeacher of CameraAngle
	(properties
		picture 7607
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToTeacher init:)
		(gCurRoom exitN: exitToTeacher)
		(greyLock init: global117)
		(super init:)
		(TGATE_225 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 7608
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToStand init:)
		(super init:)
		(STFDAVIAN_270 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 7601
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToCircle5 init:)
		(exitToCircle6 init:)
		(super init: &rest)
	)
)

(instance exitToMeenie of ExitFeature
	(properties
		nsLeft 209
		nsTop 134
		nsRight 398
		nsBottom 206
		nextRoom 7208
	)
)

(instance exitToTeacher of ExitFeature
	(properties
		nsLeft 234
		nsTop 105
		nsRight 375
		nsBottom 202
		nextRoom 7601
	)
)

(instance exitToMan of Feature
	(properties
		nsLeft 331
		nsTop 106
		nsRight 379
		nsBottom 226
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7603) ; octoMuseumManCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToStand of Feature
	(properties
		nsLeft 249
		nsTop 101
		nsRight 305
		nsBottom 220
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7604) ; octoMuseumStandCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToWheel of Feature
	(properties
		nsLeft 199
		nsTop 132
		nsRight 335
		nsBottom 226
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7605) ; octoMuseumWheelCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToCircle1 of Feature
	(properties
		nsLeft 216
		nsTop 133
		nsRight 245
		nsBottom 168
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7606) ; octoMuseumCircle1CU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToCircle2 of Feature
	(properties
		nsLeft 336
		nsTop 133
		nsRight 376
		nsBottom 174
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7607) ; octoMuseumCircle2CU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToCircle3 of Feature
	(properties
		nsLeft 209
		nsTop 128
		nsRight 262
		nsBottom 174
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7608) ; octoMuseumCircle3CU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToCircle4 of Feature
	(properties
		nsLeft 341
		nsTop 130
		nsRight 387
		nsBottom 175
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7609) ; octoMuseumCircle4CU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToCircle5 of Feature
	(properties
		nsLeft 209
		nsTop 128
		nsRight 262
		nsBottom 174
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7610) ; octoMuseumCircle5CU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToCircle6 of Feature
	(properties
		nsLeft 341
		nsTop 130
		nsRight 387
		nsBottom 175
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7611) ; octoMuseumCircle6CU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance greyLock of View
	(properties
		x 296
		y 168
		view 7602
	)

	(method (init)
		(if (not (IsFlag 195))
			(super init: global117 &rest)
			(TGATE_225 case: 1)
		else
			(TGATE_225 case: 2)
		)
	)
)

(instance TAKAGISHI_135 of Feature
	(properties
		noun 44
		nsLeft 334
		nsTop 107
		nsRight 370
		nsBottom 217
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance TGATE_225 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 237 130 362 129 411 206 192 208 235 131
					yourself:
				)
		)
	)
)

(instance STFDAVIAN_270 of Feature
	(properties
		noun 43
		nsLeft 252
		nsTop 103
		nsRight 293
		nsBottom 198
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance WHEEL_0 of Feature
	(properties
		noun 45
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 209 162 227 162 266 132 306 162 323 162 325 215 206 217 213 163
					yourself:
				)
		)
	)
)

