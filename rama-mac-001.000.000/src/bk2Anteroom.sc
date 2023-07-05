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
		edgeN 0
		edgeS 0
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
		edgeN 0
		edgeS 0
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
		picture 4119
		heading 270
		edgeN 0
		edgeS 0
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
		edgeN 0
		edgeS 0
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
		nsLeft 142
		nsTop 62
		nsRight 456
		nsBottom 203
		nextRoom 4031
		exitStyle 256
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsLeft 243
		nsTop 58
		nsRight 348
		nsBottom 201
		nextRoom 4105
	)
)

(instance exitToPuzzle1 of Feature
	(properties
		noun 22
		nsLeft 41
		nsTop 125
		nsRight 148
		nsBottom 249
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
		nsLeft 256
		nsTop 127
		nsRight 333
		nsBottom 262
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
		nsLeft 437
		nsTop 129
		nsRight 540
		nsBottom 265
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
		nsLeft 11
		nsTop 105
		nsRight 126
		nsBottom 184
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
		nsLeft 178
		nsTop 105
		nsRight 336
		nsBottom 183
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
		nsLeft 398
		nsTop 106
		nsRight 583
		nsBottom 186
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
			(= cacheSize 1000)
			(= preLoadPCT 100)
		)
		(super play: &rest)
	)
)

(instance DOOR2MUSEUM_180 of Feature
	(properties
		noun 7
		nsLeft 237
		nsTop 44
		nsRight 371
		nsBottom 214
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance ELEV_0 of Feature
	(properties
		noun 21
		nsLeft 229
		nsTop 54
		nsRight 362
		nsBottom 201
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

