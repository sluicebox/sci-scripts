;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1162)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm1v162 0
)

(instance rm1v162 of ShiversRoom
	(properties
		picture 1162
	)

	(method (init)
		(if (== gPrevRoomNum 1160) ; rm1v160
			(gSounds play: 10127 0 82 0)
		)
		(dial1 init:)
		(dial2 init:)
		(dial3 init:)
		(redButton init:)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance redButton of ShiversProp
	(properties
		x 94
		y 85
		view 1010
		loop 3
	)

	(method (doVerb)
		(if (and (== (dial1 cel:) 0) (== (dial2 cel:) 2) (== (dial3 cel:) 9))
			(if (not (IsFlag 62))
				(proc951_15 6750)
			)
			(SetFlag 62)
			(self setScript: openPanel)
		else
			(ClearFlag 62)
		)
	)
)

(instance dial1 of ShiversProp
	(properties
		x 138
		y 71
		priority 255
		fixPriority 1
		view 1010
	)

	(method (init)
		(if (IsFlag 62)
			(self cel: 0)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gSounds stop: 10105)
		(gSounds play: 10105 0 90 0)
		(= cel (mod (+ cel 1) 10))
	)
)

(instance dial2 of ShiversProp
	(properties
		x 138
		y 83
		priority 255
		fixPriority 1
		view 1010
		loop 1
	)

	(method (init)
		(if (IsFlag 62)
			(self cel: 2)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gSounds stop: 10105)
		(gSounds play: 10105 0 90 0)
		(= cel (mod (+ cel 1) 10))
	)
)

(instance dial3 of ShiversProp
	(properties
		x 139
		y 96
		priority 255
		fixPriority 1
		view 1010
		loop 2
	)

	(method (init)
		(if (IsFlag 62)
			(self cel: 9)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gSounds stop: 10105)
		(gSounds play: 10105 0 90 0)
		(= cel (mod (+ cel 1) 10))
	)
)

(instance openPanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10104 0 90 0)
				(client setCycle: End self)
			)
			(1
				(client setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: 1160) ; rm1v160
				(self dispose:)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1161
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1161
	)
)

