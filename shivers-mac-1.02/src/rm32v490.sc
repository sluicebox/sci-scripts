;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32490)
(include sci.sh)
(use Main)
(use n951)
(use n32001)
(use Motion)
(use System)

(public
	rm32v490 0
)

(instance rm32v490 of ShiversRoom
	(properties
		picture 32490
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(spSwitch init:)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32530
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32500
	)
)

(instance spSwitch of ShiversProp
	(properties
		priority 5
		fixPriority 1
		view 32490
	)

	(method (init)
		(if (IsFlag 63)
			(= cel (self lastCel:))
		)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 157)
		(if cel
			(ClearFlag 63)
			(gSounds play: 13201 0 82 0)
			(self setCycle: Beg)
			(if (proc951_11 7 32000)
				(proc951_9 23201)
				(gSounds play: 23201 -1 0 0)
				(gSounds fade: 23201 82 5 16 0 0)
				(proc32001_0)
				(gSounds fade: 23210 0 5 16 1 0)
			)
			(gSounds fade: 13215 0 5 8 1 0)
		else
			(gCurRoom setScript: sChairOn)
		)
	)
)

(instance sChairOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 63)
				(gSounds play: 13201 0 82 self)
				(spSwitch setCycle: End)
			)
			(1
				(gGame handsOn:)
				(proc951_9 13215)
				(gSounds stop: 13215)
				(gSounds play: 13215 -1 98 0)
				(if (proc951_11 7 32000)
					(proc32001_1)
					(gSounds interruptChain:)
					(proc951_9 23210)
					(gSounds play: 23210 -1 82 0)
					(gSounds fade: 23201 0 5 16 1 0)
				)
				(self dispose:)
			)
		)
	)
)

