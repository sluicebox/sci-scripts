;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6105)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	avianSecurity5 0
)

(instance avianSecurity5 of Location
	(properties
		noun 58
	)

	(method (init)
		(super init:)
		(Load rsAUDIO 6104)
		(faceN down: faceDownN)
		(faceDownN up: faceN)
		(switch gPrevRoomNum
			(6106 ; avianSecurity6
				(self setPicObj: faceDownN)
				(self addPicObj: faceN faceS faceN)
			)
			(6103 ; avianSecurity3
				(self addPicObj: faceN faceS faceN)
				(if (IsFlag 123)
					(ClearFlag 123)
					(doorMoving play:)
				)
			)
			(else
				(self addPicObj: faceN faceS faceN)
			)
		)
	)

	(method (notify)
		(if (and picObj (or (== picObj faceDownN) (== picObj faceN)))
			(proc70_1 3 1)
			(self setScript: sqwaukBoxScript)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 6142
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 6103 exitVMD: 0 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(securityDoor_180 init:)
		(doorNumbers_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6143
		edgeN 0
	)
)

(instance faceDownN of CameraAngle
	(properties
		picture 6141
		edgeW 0
		edgeE 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(microphone init:)
	)
)

(instance elevatorUp of VMDMovie
	(properties
		movieName 6103
		frameRate 10
		options 256
		endPic 6152
	)
)

(instance microphone of Feature
	(properties
		noun 12
		nsBottom 166
		nsLeft 208
		nsRight 310
		nsTop 75
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 20 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20
				((ScriptID 75 0) init: 0 gCurRoom 0 0 (gTheCursor invItem:)) ; InvInset
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sqwaukBoxScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(elevatorUp play:)
				(gCurRoom newRoom: 6106) ; avianSecurity6
				(gGame handsOn:)
			)
		)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance doorMoving of Sound
	(properties
		number 6104
	)
)

(instance securityDoor_180 of Feature
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
					init: 363 288 422 48 534 46 537 290
					yourself:
				)
		)
	)
)

(instance doorNumbers_180 of Feature
	(properties
		noun 55
		x 490
		y 26
		nsBottom 43
		nsLeft 440
		nsRight 540
		nsTop 9
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

