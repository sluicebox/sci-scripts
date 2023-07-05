;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32500)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use n32001)
(use RandCycle)
(use Actor)
(use System)

(public
	rm32v500 0
)

(instance rm32v500 of ShiversRoom
	(properties
		picture 32500
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 63)
			(zap init:)
			(if (== gPrevRoomNum 32510) ; rm32v510
				(gSounds setVol: 13215 98)
			)
			(if (proc951_11 7 32000)
				(proc951_9 22903)
				(gSounds play: 22903 -1 50 0)
				(self setScript: sAttack)
			)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 63) (proc951_11 7 32000))
			(gSounds fade: 22903 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32490
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32520
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 32530
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

(instance zap of Prop
	(properties
		priority 5
		fixPriority 1
		view 32500
	)

	(method (init &tmp temp0)
		(if (IsFlag 35)
			(PrintDebug {isFast})
			(= temp0 3)
		else
			(PrintDebug {isSlow})
			(= temp0 1)
		)
		(self setCycle: RandCycle cycleSpeed: temp0)
		(super init: &rest)
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 57320 self zap)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(gSounds stop: 13215)
				(proc925_0 self)
			)
			(2
				(proc951_9 13215)
				(gSounds play: 13215 -1 98 0)
				(efExitLeft init: 2)
				(efExitRight init: 1)
				(if (proc951_11 7 32000)
					(proc951_9 23210)
					(gSounds play: 23210 -1 82 0)
					(proc951_9 22903)
					(gSounds play: 22903 -1 50 0)
					(= state 0)
					(proc925_1 57320 self zap 1)
				else
					(proc951_9 23201)
					(proc32001_0)
					(gSounds play: 23201 -1 82 0)
					(self dispose:)
				)
			)
		)
	)
)

