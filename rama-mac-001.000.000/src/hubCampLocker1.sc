;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1010)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use SaveManager)
(use RegionSFX)
(use n1111)
(use Feature)
(use Sound)
(use User)
(use Actor)
(use System)

(public
	hubCampLocker1 0
)

(local
	local0
)

(instance hubCampLocker1 of CloseupLocation
	(properties)

	(method (init)
		(self heading: 0)
		(cond
			((IsFlag 80)
				(if local0
					(super init: 1120)
				else
					(super init: 1125)
				)
			)
			(local0
				(super init: 1020)
			)
			(else
				(super init: 1025)
			)
		)
		(lockerHandle init:)
	)

	(method (newRoom)
		(if (not (OneOf curPic 1125 1025))
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
		nsLeft 295
		nsTop 168
		nsRight 398
		nsBottom 246
	)

	(method (init)
		(if (not local0)
			(super init:)
			(if (IsFlag 86)
				(self setHotspot: 2)
			else
				(self setHotspot: 115)
			)
		else
			(playersComputer init:)
			(playersKnife init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(115
				(self setHotspot: 2)
				(lockerClick play:)
				(SetFlag 86)
			)
			(2
				(if (IsFlag 80)
					(gCurRoom drawPic: 1120)
				else
					(gCurRoom drawPic: 1020)
				)
				(= local0 1)
				(playersComputer init:)
				(playersKnife init:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance playersComputer of View
	(properties
		x 296
		y 270
		view 1025
	)

	(method (init)
		(if (proc1111_24 84)
			(if (IsFlag 90)
				(= cel 1)
				(= x 293)
				(= y 260)
			)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 90)
					(self hide:)
					(proc70_1 39)
					(SetFlag 84)
					(if (and (IsFlag 83) (IsFlag 85))
						(ClearFlag 79)
						(gCurRoom setScript: chairComeBack)
					)
					(self dispose:)
				else
					(= x 293)
					(= y 260)
					(= cel 1)
					(SetFlag 90)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chairComeBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(sChairReturns play: 100 self pan: 20)
			)
			(1
				(User canControl: 1)
				(self dispose:)
			)
		)
	)
)

(instance sChairReturns of RegionSFX
	(properties
		number 1054
		loop 1
	)
)

(instance playersKnife of View
	(properties
		x 260
		y 211
		view 1025
		loop 1
	)

	(method (init)
		(if (== (proc70_9 45) 1010)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(SetFlag 85)
				(proc70_1 45)
				(if (and (IsFlag 83) (IsFlag 84))
					(ClearFlag 79)
					(gCurRoom setScript: chairComeBack)
				)
				(self dispose:)
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
				(playersComputer dispose:)
				(playersKnife dispose:)
				(if (IsFlag 80)
					(gCurRoom drawPic: 1125)
				else
					(gCurRoom drawPic: 1025)
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

