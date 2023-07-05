;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5215)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use newYorkRegion)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	NY_Human_Plaza_15 0
)

(instance NY_Human_Plaza_15 of CloseupLocation
	(properties
		noun 32
		heading 270
	)

	(method (init)
		(super init: 5251 &rest)
		(humanKey init:)
		(humanTalisman init:)
		(keyHole init:)
		(talismanHole init:)
		(keypad_270 init:)
		(KeyPadChecker init:)
	)
)

(class KeyPadChecker of Obj
	(properties)

	(method (notify)
		(cond
			((and (== (proc70_9 36) gCurRoomNum) (== (proc70_9 37) gCurRoomNum))
				(gCurRoom setScript: doorOpens)
			)
			((IsFlag 156)
				(gCurRoom setScript: doorShuts)
			)
		)
	)
)

(instance humanKey of View
	(properties
		x 229
		y 183
		view 5251
	)

	(method (init)
		(if (== (proc70_9 36) gCurRoomNum)
			(super init: global117 &rest)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 36)
				(keyHole init:)
				(KeyPadChecker notify:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance humanTalisman of View
	(properties
		x 327
		y 173
		cel 1
		view 5251
	)

	(method (init)
		(if (== (proc70_9 37) gCurRoomNum)
			(super init: global117 &rest)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 37)
				(talismanHole init:)
				(KeyPadChecker notify:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keyHole of Feature
	(properties
		nsBottom 173
		nsLeft 230
		nsRight 284
		nsTop 123
	)

	(method (init)
		(if (!= (proc70_9 36) gCurRoomNum)
			(super init: &rest)
			(self setHotspot: 19)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(19
				(keyInsertSnd play:)
				(proc70_3 36)
				(proc70_10 36 gCurRoomNum)
				(humanKey init:)
				(KeyPadChecker notify:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance talismanHole of Feature
	(properties
		nsBottom 173
		nsLeft 321
		nsRight 373
		nsTop 123
	)

	(method (init)
		(if (!= (proc70_9 37) gCurRoomNum)
			(super init: &rest)
			(self setHotspot: 59)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(59
				(keyInsertSnd play:)
				(proc70_3 37)
				(proc70_10 37 gCurRoomNum)
				(humanTalisman init:)
				(KeyPadChecker notify:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(doorSnd setVol: 127 play: self)
			)
			(1
				(proc201_1 27)
				(SetFlag 156)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doorShuts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(doorSnd setVol: 127 play: self)
			)
			(1
				(ClearFlag 156)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doorSnd of Sound
	(properties
		number 5250
		flags 5
	)
)

(instance keyInsertSnd of Sound
	(properties
		number 5215
		flags 5
	)
)

(instance keypad_270 of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 243 56 354 54 409 148 356 246 238 245 187 149
					yourself:
				)
		)
	)
)

