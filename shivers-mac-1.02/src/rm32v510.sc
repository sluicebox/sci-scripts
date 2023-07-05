;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32510)
(include sci.sh)
(use Main)
(use n951)
(use n32001)
(use RandCycle)
(use Motion)
(use Actor)

(public
	rm32v510 0
)

(instance rm32v510 of ShiversRoom
	(properties
		picture 32510
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(spSwitch init:)
		(if (IsFlag 63)
			(zap init:)
			(gSounds setVol: 13215 32)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32540
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32540
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32500
	)

	(method (init)
		(self createPoly: 167 137 161 130 161 55 104 55 104 130 99 137 167 137)
		(super init: &rest)
	)
)

(instance zap of Prop
	(properties
		priority 5
		fixPriority 1
		view 32511
	)

	(method (init)
		(self setCycle: RandCycle cycleSpeed: 4)
		(super init: &rest)
	)
)

(instance spSwitch of ShiversProp
	(properties
		priority 5
		fixPriority 1
		view 32510
	)

	(method (init)
		(if (IsFlag 63)
			(= cel (self lastCel:))
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if cel
			(ClearFlag 63)
			(gSounds play: 13201 0 82 0)
			(self setCycle: Beg)
			(zap dispose:)
			(gSounds stop: 13215)
			(if (proc951_11 7 32000)
				(proc951_9 23201)
				(gSounds play: 23201 -1 0 0)
				(proc32001_0)
				(gSounds fade: 23201 82 5 16 0 0)
				(gSounds fade: 23210 0 5 16 1 0)
			)
		else
			(SetFlag 63)
			(gSounds play: 13201 0 82 0)
			(self setCycle: End)
			(zap init:)
			(proc951_9 13215)
			(gSounds play: 13215 -1 50 0)
			(if (proc951_11 7 32000)
				(proc951_9 23210)
				(gSounds play: 23210 -1 66 0)
				(proc32001_1)
				(gSounds fade: 23201 0 5 16 1 0)
			)
		)
	)
)

