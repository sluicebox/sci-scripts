;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6106)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Feature)
(use Actor)
(use System)

(public
	avianSecurity6 0
)

(instance avianSecurity6 of Location
	(properties)

	(method (init)
		(super init:)
		(faceN down: faceDownN)
		(faceDownN up: faceN)
		(switch gPrevRoomNum
			(6105 ; avianSecurity5
				(self setPicObj: faceDownN)
			)
		)
		(self addPicObj: faceN faceS faceN)
	)

	(method (notify)
		(if (and picObj (or (== picObj faceN) (== picObj faceDownN)))
			(proc70_1 3 1)
			(self setScript: sqwaukBoxScript)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6151
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 6107 exitVMD: 0 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(if (IsFlag 122)
			(ledges init: global117)
		)
		(console_180 init:)
	)
)

(instance faceDownN of CameraAngle
	(properties
		picture 6152
		edgeS 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(super init:)
		(microphone init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6153
		edgeN 0
	)

	(method (init)
		(super init:)
		(microphone init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance elevatorDown of VMDMovie
	(properties
		movieName 6104
		frameRate 10
		options 256
		endPic 6141
	)
)

(instance microphone of Feature
	(properties
		noun 12
		nsLeft 208
		nsTop 75
		nsRight 310
		nsBottom 166
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
				(elevatorDown play:)
				(gCurRoom newRoom: 6105) ; avianSecurity5
				(gGame handsOn:)
			)
		)
	)
)

(instance ledges of View
	(properties
		x 263
		y 151
		view 6162
		loop 3
	)

	(method (init)
		(self setPri: 0)
		(= cel (not (IsFlag 122)))
		(super init: &rest)
	)
)

(instance console_180 of Feature
	(properties
		noun 56
		nsLeft 217
		nsTop 62
		nsRight 392
		nsBottom 219
		x 304
		y 140
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance microphone_0 of Feature ; UNUSED
	(properties
		noun 12
		nsLeft 188
		nsTop 251
		nsRight 312
		nsBottom 288
		x 250
		y 269
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

