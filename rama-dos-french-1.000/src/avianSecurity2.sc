;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6102)
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
	avianSecurity2 0
)

(local
	local0
)

(instance avianSecurity2 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(Load rsAUDIO 6104)
		(= local0 1)
		(switch gPrevRoomNum
			(6103 ; avianSecurity3
				(self addPicObj: faceS faceN faceS)
				(doorMoving play:)
				(ClearFlag 123)
			)
			(6108 ; securityDoorWindow
				(switch global164
					(0
						(self addPicObj: faceN faceS faceN)
					)
					(else
						(self addPicObj: faceS faceN faceS)
					)
				)
			)
			(else
				(self addPicObj: faceN faceS faceN)
			)
		)
	)

	(method (notify)
		(if (and picObj (== picObj faceN) local0 (proc1111_24 123))
			(proc70_1 3 1)
			(self setScript: sqwaukBoxScript)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 6112
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 6101 exitStyle: 0 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6111
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 123)
			(defaultExit nextRoom: 6103 exitStyle: 256 init:)
			(gCurRoom exitN: defaultExit)
			(securityConsole_0 init:)
		else
			(SecDefDoor_0 init:)
			(portHole init:)
			(microphone init:)
		)
		(super init:)
		(topDoor init: global117)
		(bottomDoor init: global117)
		(screenView init: global117)
		(screenKnob init: global117)
		(blankNumbers init: global117)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance portHole of Feature
	(properties
		nsBottom 160
		nsLeft 254
		nsRight 337
		nsTop 76
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 6108) ; securityDoorWindow
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance microphone of Feature
	(properties
		noun 12
		nsBottom 210
		nsLeft 263
		nsRight 321
		nsTop 180
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

(instance screenView of Prop
	(properties
		view 6121
	)

	(method (init)
		(self setPri: 1)
		(self setCycle: 0)
		(switch global234
			(1
				(if (== global233 2)
					(self x: 249 y: 149 loop: 1 cel: 0)
					(self setCycle: Fwd)
					(super init: &rest)
				)
			)
		)
	)
)

(instance screenKnob of View
	(properties
		view 6121
	)

	(method (init)
		(self setPri: 0)
		(switch global233
			(0)
			(1
				(self x: 191 y: 207 loop: 0 cel: 2)
				(super init: &rest)
			)
			(2
				(self x: 189 y: 177 loop: 0 cel: 0)
				(super init: &rest)
			)
			(3
				(self x: 191 y: 208 loop: 0 cel: 3)
				(super init: &rest)
			)
		)
	)
)

(instance blankNumbers of View
	(properties
		x 255
		y 133
		cel 5
		view 6121
	)

	(method (init)
		(self setPri: 0)
		(if (!= global233 2)
			(super init: &rest)
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
				(defaultExit nextRoom: 6103 init:)
				(gCurRoom exitN: defaultExit)
				(portHole dispose:)
				(microphone dispose:)
				(SecDefDoor_0 dispose:)
				(securityConsole_0 init:)
				(gGame handsOn:)
			)
		)
	)
)

(instance bottomDoor of Prop
	(properties
		x 88
		y 292
		view 6171
	)

	(method (init)
		(self setPri: 255)
		(if (IsFlag 123)
			(= cel 9)
		)
		(super init: &rest)
	)
)

(instance topDoor of Prop
	(properties
		x 132
		y 1
		loop 1
		view 6171
	)

	(method (init)
		(self setPri: 255)
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

(instance SecDefDoor_0 of Feature
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
					init: 100 288 172 2 431 6 493 285
					yourself:
				)
		)
	)
)

(instance securityConsole_0 of Feature
	(properties
		noun 56
		x 236
		y 179
		nsBottom 227
		nsLeft 179
		nsRight 293
		nsTop 132
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

