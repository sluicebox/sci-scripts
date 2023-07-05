;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1016)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use SaveManager)
(use n1111)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	hubCampLocker4 0
)

(local
	local0
)

(instance hubCampLocker4 of CloseupLocation
	(properties)

	(method (init)
		(self heading: 0)
		(cond
			((IsFlag 80)
				(if local0
					(super init: 1136)
				else
					(super init: 1135)
				)
			)
			(local0
				(super init: 1036)
			)
			(else
				(super init: 1035)
			)
		)
		(lockerHandle init:)
		(locker6 init:)
	)

	(method (newRoom)
		(if (not (OneOf curPic 1135 1035))
			(gGame handsOff:)
			(self setScript: doorClose self)
		else
			(super newRoom: &rest)
		)
	)

	(method (dispose)
		(= local0 0)
		(super dispose: &rest)
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1 0)
			(= local0 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local0)
		)
	)
)

(instance lockerHandle of Feature
	(properties
		nsBottom 239
		nsLeft 295
		nsRight 431
		nsTop 167
	)

	(method (init)
		(if (not local0)
			(super init:)
			(if (IsFlag 88)
				(self setHotspot: 2)
			else
				(self setHotspot: 37)
			)
		else
			(mil_Data_Cube12 init:)
			(straight_Lense init:)
			(locker6 dispose:)
			(self dispose:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(37
				(self setHotspot: 2)
				(lockerClick play:)
				(SetFlag 88)
			)
			(2
				(if (IsFlag 80)
					(gCurRoom drawPic: 1136)
				else
					(gCurRoom drawPic: 1036)
				)
				(= local0 1)
				(mil_Data_Cube12 init:)
				(straight_Lense init:)
				(locker6 dispose:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mil_Data_Cube12 of View
	(properties
		x 337
		y 232
		view 1035
	)

	(method (init)
		(if (== (proc70_9 26) 1016)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 26)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance straight_Lense of View
	(properties
		x 294
		y 201
		loop 1
		view 1035
	)

	(method (init)
		(if (== (proc70_9 105) 1016)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 105)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance locker6 of Feature
	(properties
		nsBottom 268
		nsLeft 1
		nsRight 149
		nsTop 18
	)

	(method (init)
		(super init:)
		(if (IsFlag 87)
			(self setHotspot: 2)
		else
			(self setHotspot: 2 65)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 1011) ; hubCampLocker2
			)
			(65
				(gCurRoom newRoom: 1011) ; hubCampLocker2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lockerClick of Sound
	(properties
		number 6900
	)
)

(instance doorClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mil_Data_Cube12 dispose:)
				(straight_Lense dispose:)
				(if (IsFlag 80)
					(gCurRoom drawPic: 1135)
				else
					(gCurRoom drawPic: 1035)
				)
				(FrameOut)
				(= seconds 2)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

