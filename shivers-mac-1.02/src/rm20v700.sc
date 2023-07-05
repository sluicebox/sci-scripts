;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20700)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Motion)
(use System)

(public
	rm20v700 0
)

(local
	local0
)

(instance rm20v700 of ShiversRoom
	(properties
		picture 20700
	)

	(method (init)
		(= local0 0)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(if (IsFlag 16)
			(= picture 20701)
		else
			(spCover init:)
		)
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not local0)
				(proc951_11 4 20000)
				(IsFlag 16)
				(not (gCurRoom script:))
			)
			(gCurRoom setScript: sAttack)
			(= local0 1)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 4 20000) (IsFlag 16))
			(gSounds fade: 22512 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20690
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20690
	)
)

(instance spCover of ShiversProp
	(properties
		priority 1
		fixPriority 1
		view 20700
	)

	(method (doVerb)
		(proc951_16 151)
		(gCurRoom setScript: sOpenCover)
	)
)

(instance sOpenCover of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spCover cycleSpeed: 12 setCycle: End)
				(gSounds play: 12013 0 82 self)
			)
			(1
				(gCurRoom drawPic: 20701)
				(spCover dispose:)
				(if (proc951_11 4 20000)
					(gSounds fade: 22001 0 5 32 1 self)
					(proc951_9 22002)
					(gSounds play: 22002 -1 50 0)
				else
					(= cycles 1)
				)
			)
			(2
				(if (proc951_11 4 20000)
					(proc951_9 22512)
					(gSounds play: 22512 -1 0 0)
					(gSounds fade: 22512 50 5 16 0 0)
				)
				(gGame handsOn:)
				(SetFlag 16)
				(self dispose:)
			)
		)
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 54200 self)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(proc925_0 self)
			)
			(2
				(efExitRight init: 6)
				(efExitLeft init: 7)
				(if (proc951_11 4 20000)
					(proc951_7 22002)
					(proc951_9 22002)
					(gSounds play: 22002 -1 50 0)
					(proc951_9 22512)
					(gSounds play: 22512 -1 50 0)
					(proc925_1 54200 self 0 1)
					(= state 0)
				else
					(proc951_9 22001)
					(gSounds play: 22001 -1 98 0)
					(self dispose:)
				)
			)
		)
	)
)

