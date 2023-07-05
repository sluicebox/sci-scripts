;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30090)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm30v090 0
)

(local
	local0
)

(instance rm30v090 of ShiversRoom
	(properties
		picture 30090
	)

	(method (init)
		(if (or (== gPrevRoomNum 30120) (== gPrevRoomNum 30100)) ; rm30v120, rm30v100
			(ClearFlag 43)
		)
		(pTrunk init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(= local0 0)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 43) (or (== newRoomNumber 30120) (== newRoomNumber 30100))) ; rm30v120, rm30v100
			(ClearFlag 43)
			(gSounds play: 13002 0 82 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30070
	)

	(method (init)
		(self
			createPoly: 177 140 177 90 166 84 92 84 79 91 78 91 78 142 177 142
		)
		(super init: &rest)
	)
)

(instance pTrunk of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 30090
	)

	(method (init)
		(if (IsFlag 43)
			(self cel: (self lastCel:))
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (IsFlag 43)
			(++ local0)
			(gSounds play: 13002 0 82 0)
			(self setCycle: Beg)
			(ClearFlag 43)
		else
			(if (> local0 0)
				(self setScript: sPlay)
			else
				(= local0 0)
				(gSounds play: 13001 0 82 0)
			)
			(self setCycle: End)
			(self createPoly: 0 0 0 0 0 0)
			(efExitForward init: 3)
			(SetFlag 43)
			(++ local0)
		)
	)
)

(instance sPlay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSounds play: 35128 0 90 0)
				(= ticks 45)
			)
			(1
				(gSounds play: 35134 0 90 0)
				(= ticks 45)
			)
			(2
				(self dispose:)
			)
		)
	)
)

