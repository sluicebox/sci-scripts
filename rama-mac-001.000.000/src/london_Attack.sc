;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3071)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Feature)
(use Actor)
(use System)

(public
	london_Attack 0
)

(instance london_Attack of CloseupLocation
	(properties
		heading 180
	)

	(method (init)
		(self edgeW: 0 edgeE: 0)
		(if (proc1111_24 114)
			(super init: 3312)
			(monitorSwitch init:)
			(inventory_Medallion init:)
			(wheelPic init:)
			(self setScript: spiderKilling)
		else
			(super init: 3325)
			(monitor init:)
			(monitorSwitch init:)
			(wheelPic init:)
		)
	)

	(method (pitch)
		(self newRoom: 3063) ; london_33
	)
)

(instance monitor of Feature
	(properties
		noun 30
		nsLeft 205
		nsTop 4
		nsRight 397
		nsBottom 127
	)

	(method (init)
		(super init:)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 3070) ; london_Monitor
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inventory_Medallion of View
	(properties
		x 11
		y 285
		view 3312
		cel 2
	)

	(method (init)
		(if (== (proc70_9 40) 3063)
			(self setPri: 0)
			(super init: global117)
		)
	)
)

(instance monitorSwitch of View
	(properties
		noun 30
	)

	(method (init)
		(if (proc1111_24 114)
			(= view 3312)
			(= loop 0)
			(= x 124)
			(= y 185)
		else
			(= view 3301)
			(= loop 4)
			(= x 228)
			(= y 291)
		)
		(= cel global297)
		(&= signal $efff)
		(self setPri: 0)
		(super init: global117)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(= cel (mod (++ cel) 2))
				(= global297 cel)
				(if cel
					(wheelPic init:)
					(if (== global201 3)
						(= global201 2)
					)
				else
					(wheelPic dispose:)
				)
				(FrameOut)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wheelPic of View
	(properties)

	(method (init)
		(if (proc1111_24 114)
			(= view 3312)
			(= loop 0)
			(= cel 3)
			(= x 125)
			(= y 135)
		else
			(= view 3301)
			(= loop 4)
			(= cel 2)
			(= x 234)
			(= y 176)
			(if (and global297 (== (proc70_9 46) 2027))
				(ladder init: global117)
			)
		)
		(if global297
			(self setPri: 0)
			(super init: global117)
		)
	)

	(method (dispose)
		(ladder dispose:)
		(super dispose: &rest)
	)
)

(instance ladder of View
	(properties
		x 263
		y 244
		view 3301
		loop 4
		cel 3
	)
)

(instance spiderKilling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(proc1111_7 3312 256 90 global161 0 1 1 self)
			)
			(2
				(gCurRoom drawPic: 3313)
				(FrameOut)
			)
			(3
				(= seconds 2)
			)
			(4
				((gCurRoom picObj:) showBlack: 0)
				(gCurRoom setScript: (ScriptID 97 0)) ; shiftToRed
			)
		)
	)
)

