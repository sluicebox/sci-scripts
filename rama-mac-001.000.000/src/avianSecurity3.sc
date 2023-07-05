;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6103)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	avianSecurity3 0
)

(local
	local0
)

(instance avianSecurity3 of Location
	(properties)

	(method (init)
		(super init:)
		(= local0 1)
		(Load rsAUDIO 6104)
		(switch gPrevRoomNum
			(6102 ; avianSecurity2
				(self addPicObj: faceN faceS faceN)
				(doorMoving play:)
				(ClearFlag 123)
			)
			(else
				(self addPicObj: faceS faceN faceS)
			)
		)
	)

	(method (notify)
		(if (and picObj (== picObj faceS) local0 (proc1111_24 123))
			(proc70_1 3 1)
			(self setScript: sqwaukBoxScript)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6123
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 123)
			(defaultExit nextRoom: 6101 exitStyle: 256 init:)
			(gCurRoom exitN: defaultExit)
		else
			(securityDoor_180 init:)
			(microphone init:)
		)
		(super init:)
		(topDoor init: global117)
		(bottomDoor init: global117)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6121
		edgeN 0
		edgeS 0
	)

	(method (init)
		(consoleExit init:)
		(elevatorExit init:)
		(gCurRoom exitNW: consoleExit)
		(gCurRoom exitNE: elevatorExit)
		(super init:)
		(screenView init: global117)
		(screenKnob init: global117)
		(blankNumbers init: global117)
		(controlPanel_0 init:)
		(elevNumbers_0 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance consoleExit of ExitFeature
	(properties
		nsLeft 74
		nsTop 81
		nsRight 299
		nsBottom 252
		nextRoom 6104
	)
)

(instance elevatorExit of ExitFeature
	(properties
		nsLeft 461
		nsTop 56
		nsRight 567
		nsBottom 292
		nextRoom 6105
		exitStyle 13
	)
)

(instance microphone of Feature
	(properties
		noun 12
		nsLeft 263
		nsTop 180
		nsRight 321
		nsBottom 210
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
				(topDoor setCycle: (End new:))
				(bottomDoor setCycle: (End new:))
				(doorMoving play:)
				(SetFlag 123)
				(defaultExit nextRoom: 6101 init:)
				(securityDoor_180 dispose:)
				(microphone dispose:)
				(gCurRoom exitN: defaultExit)
				(gGame handsOn:)
			)
		)
	)
)

(instance bottomDoor of Prop
	(properties
		x 66
		y 291
		view 6172
		loop 1
	)

	(method (init)
		(if (IsFlag 123)
			(= cel 9)
		)
		(super init: &rest)
	)
)

(instance topDoor of Prop
	(properties
		x 180
		y 1
		view 6172
	)

	(method (init)
		(if (IsFlag 123)
			(= cel 9)
		)
		(super init: &rest)
	)
)

(instance doorMoving of Sound
	(properties
		number 6104
	)
)

(instance screenView of Prop
	(properties
		view 6120
	)

	(method (init)
		(self setPri: 0)
		(self setCycle: 0)
		(if (== global233 2)
			(switch global234
				(1
					(self x: 189 y: 108 loop: 1 cel: 0)
					(self setCycle: Fwd)
					(super init: &rest)
				)
				(else
					(self x: 191 y: 144 loop: 0 cel: 4)
					(super init: &rest)
				)
			)
		)
	)
)

(instance screenKnob of View
	(properties
		x 117
		y 253
		view 6120
		loop 7
	)

	(method (init)
		(switch global233
			(0)
			(1
				(self x: 99 y: 197 loop: 0 cel: 2)
				(super init: &rest)
			)
			(2
				(self x: 99 y: 177 loop: 0 cel: 0)
				(super init: &rest)
			)
			(3
				(self x: 98 y: 198 loop: 0 cel: 3)
				(super init: &rest)
			)
		)
	)
)

(instance blankNumbers of View
	(properties
		x 210
		y 103
		view 6120
		cel 5
	)

	(method (init)
		(self setPri: 0)
		(if (!= global233 2)
			(super init: &rest)
		)
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
					init: 71 287 141 1 458 2 524 287
					yourself:
				)
		)
	)
)

(instance controlPanel_0 of Feature
	(properties
		noun 56
		nsLeft 58
		nsTop 98
		nsRight 280
		nsBottom 268
		x 169
		y 183
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance elevNumbers_0 of Feature
	(properties
		noun 55
		nsLeft 473
		nsTop 3
		nsRight 585
		nsBottom 46
		x 529
		y 24
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

