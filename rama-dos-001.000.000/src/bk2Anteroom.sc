;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4104)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use n1111)
(use VMDMovie)
(use Feature)
(use Sound)
(use System)

(public
	bk2Anteroom 0
)

(instance bk2Anteroom of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(= global269 2)
		(switch gPrevRoomNum
			(4031 ; bkElev1
				(self
					addPicObj:
						faceMuseum
						faceScreens
						faceElev
						facePuzzles
						faceMuseum
				)
			)
			(4105 ; bk2AntMusDoor
				(self
					addPicObj:
						faceElev
						facePuzzles
						faceMuseum
						faceScreens
						faceElev
				)
			)
			(4109 ; bk2Screen1
				(self
					addPicObj:
						faceScreens
						faceElev
						facePuzzles
						faceMuseum
						faceScreens
				)
			)
			(4010 ; bkScreen2
				(self
					addPicObj:
						faceScreens
						faceElev
						facePuzzles
						faceMuseum
						faceScreens
				)
			)
			(4111 ; bk2Screen3
				(self
					addPicObj:
						faceScreens
						faceElev
						facePuzzles
						faceMuseum
						faceScreens
				)
			)
			(else
				(self
					addPicObj:
						facePuzzles
						faceMuseum
						faceScreens
						faceElev
						facePuzzles
				)
			)
		)
	)
)

(instance facePuzzles of CameraAngle
	(properties
		heading 90
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToPuzzle1 init:)
		(gCurRoom exitNW: exitToPuzzle1)
		(exitToPuzzle2 init:)
		(gCurRoom exitN: exitToPuzzle2)
		(exitToPuzzle3 init:)
		(gCurRoom exitNE: exitToPuzzle3)
		(if (not (IsFlag 38))
			(= picture 38320)
			(gCurRoom setScript: sRichardComesIn)
		else
			(= picture 4102)
		)
		(super init:)
	)
)

(instance faceMuseum of CameraAngle
	(properties
		heading 180
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 40)
			(= picture 4115)
			(super init:)
		else
			(= picture 4118)
			(super init:)
			(DOOR2MUSEUM_180 init:)
		)
		(exitToMuseum init:)
		(gCurRoom exitN: exitToMuseum)
	)
)

(instance faceScreens of CameraAngle
	(properties
		heading 270
		picture 4119
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToScreen1 init:)
		(gCurRoom exitNW: exitToScreen1)
		(exitToScreen2 init:)
		(gCurRoom exitN: exitToScreen2)
		(exitToScreen3 init:)
		(gCurRoom exitNE: exitToScreen3)
		(super init:)
	)
)

(instance faceElev of CameraAngle
	(properties
		picture 4120
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToElev init:)
		(gCurRoom exitN: exitToElev)
		(super init:)
		(ELEV_0 init:)
	)
)

(instance sRichardComesIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SoundManager pauseMusic: 1 10 20)
				(= seconds 1)
			)
			(1
				(SetFlag 38)
				(richardSnd play: self)
			)
			(2
				(richardVMD play: self)
			)
			(3
				(gGame handsOff:)
				(elevDnSnd play: self)
			)
			(4
				(= seconds 1)
			)
			(5
				(gGame handsOn:)
				(SoundManager pauseMusic: 0 10 20)
				(self dispose:)
			)
		)
	)
)

(instance exitToElev of ExitFeature
	(properties
		nsBottom 203
		nsLeft 142
		nsRight 456
		nsTop 62
		nextRoom 4031
		exitStyle 256
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsBottom 201
		nsLeft 243
		nsRight 348
		nsTop 58
		nextRoom 4105
	)
)

(instance exitToPuzzle1 of Feature
	(properties
		noun 22
		nsBottom 249
		nsLeft 41
		nsRight 148
		nsTop 125
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 4006) ; bkRepetition
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToPuzzle2 of Feature
	(properties
		noun 22
		nsBottom 262
		nsLeft 256
		nsRight 333
		nsTop 127
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 4007) ; bkRecognition
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToPuzzle3 of Feature
	(properties
		noun 22
		nsBottom 265
		nsLeft 437
		nsRight 540
		nsTop 129
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 4008) ; bkManipulation
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToScreen1 of Feature
	(properties
		noun 23
		nsBottom 184
		nsLeft 11
		nsRight 126
		nsTop 105
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 4109) ; bk2Screen1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToScreen2 of Feature
	(properties
		noun 24
		nsBottom 183
		nsLeft 178
		nsRight 336
		nsTop 105
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 4010) ; bkScreen2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToScreen3 of Feature
	(properties
		noun 25
		nsBottom 186
		nsLeft 398
		nsRight 583
		nsTop 106
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 4111) ; bk2Screen3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance richardSnd of Sound
	(properties
		number 4124
	)
)

(instance elevDnSnd of Sound
	(properties
		number 4125
	)
)

(instance richardVMD of VMDMovie
	(properties
		movieName 38321
		begPic 38320
		endPic 38329
	)

	(method (play)
		(if (<= global188 3)
			(= cacheSize 700)
			(= preLoadPCT 70)
		)
		(super play: &rest)
	)
)

(instance DOOR2MUSEUM_180 of Feature
	(properties
		noun 7
		nsBottom 214
		nsLeft 237
		nsRight 371
		nsTop 44
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance ELEV_0 of Feature
	(properties
		noun 21
		nsBottom 201
		nsLeft 229
		nsRight 362
		nsTop 54
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

