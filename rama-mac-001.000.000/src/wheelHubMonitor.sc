;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2028)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	wheelHubMonitor 0
)

(instance wheelHubMonitor of CloseupLocation
	(properties
		picture 2283
	)

	(method (init)
		(super init: picture)
		(buttonA init:)
		(buttonB init:)
		(monitorDisplay init:)
		(monitorFeat init:)
	)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)
)

(instance buttonA of View
	(properties
		x 215
		y 263
		view 2283
	)

	(method (init)
		(if (== global201 1)
			(= cel 1)
		)
		(&= signal $efff)
		(super init: global117)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (!= global201 1)
					(= cel 1)
					(buttonB cel: 0)
					(= global201 1)
					(monitorDisplay cel: 1)
					(gate dispose:)
					(monitorStatic dispose:)
					(londonSwitch init:)
				else
					(londonSwitch dispose:)
					(= global201 (= cel 0))
					(monitorDisplay cel: 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buttonB of View
	(properties
		x 342
		y 262
		view 2283
		loop 1
	)

	(method (init)
		(if (OneOf global201 2 3)
			(= cel 1)
		)
		(&= signal $efff)
		(super init: global117)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(cond
					(global297
						(if (!= global201 3)
							(londonSwitch dispose:)
							(= cel 1)
							(buttonA cel: 0)
							(= global201 3)
							(monitorDisplay cel: 3)
							(if (proc1111_24 119)
								(gCurRoom setScript: spider_Release)
								(SetFlag 119)
							)
							(gate init:)
						else
							(= global201 (= cel 0))
							(monitorDisplay cel: 0)
							(gate dispose:)
						)
					)
					((!= global201 2)
						(= cel 1)
						(buttonA cel: 0)
						(= global201 2)
						(monitorDisplay cel: 2)
						(monitorStatic init:)
					)
					(else
						(= global201 (= cel 0))
						(monitorDisplay cel: 0)
						(monitorStatic dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance monitorDisplay of View
	(properties
		x 221
		y 67
		view 2283
		loop 2
	)

	(method (init)
		(= cel global201)
		(super init: global117)
		(switch cel
			(3
				(if (proc1111_24 119)
					(gCurRoom setScript: spider_Release)
					(SetFlag 119)
				)
				(= cel 3)
				(gate init:)
			)
			(1
				(londonSwitch init:)
			)
			(2
				(monitorStatic init:)
			)
		)
		(self setPri: 1)
	)
)

(instance gate of View
	(properties
		x 331
		y 169
		view 2283
		loop 4
	)

	(method (init)
		(if (and (== global201 3) (!= (proc70_9 46) 2054))
			(self setPri: 2)
			(super init: global117)
		)
	)
)

(instance londonSwitch of View
	(properties
		x 299
		y 182
		view 2283
		loop 3
	)

	(method (init)
		(if (== global201 1)
			(= cel global297)
			(self setPri: 2)
			(super init: global117)
		)
	)
)

(instance spider_Release of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc1111_7 2283 219 65 0 0 70 0 self)
			)
			(1
				(= global161 0)
				(proc1111_6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance monitorStatic of Prop
	(properties
		x 221
		y 228
		view 2283
		loop 5
	)

	(method (init)
		(super init: global117)
		(self setCycle: Fwd)
	)
)

(instance monitorFeat of Feature
	(properties
		noun 17
		nsLeft 168
		nsTop 14
		nsRight 450
		nsBottom 291
		x 309
		y 152
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

