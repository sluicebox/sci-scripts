;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29040)
(include sci.sh)
(use Main)
(use Motion)

(public
	rm29v040 0
)

(local
	local0
)

(instance rm29v040 of ShiversRoom
	(properties
		picture 29040
	)

	(method (init)
		(if (== gPrevRoomNum 29045) ; rm29v045
			(gSounds play: 12910 0 82 0)
		)
		(= local0 0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(spPuzzle init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (== local0 1) (!= newRoomNumber 29045)) ; rm29v045
			(gSounds play: 12910 0 82 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance spPuzzle of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 29041
	)

	(method (doVerb)
		(if (== cel (self lastCel:))
			(gCurRoom newRoom: 29045) ; rm29v045
		else
			(= local0 1)
			(gSounds play: 12909 0 82 0)
			(self setCycle: End)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29050
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 29045
	)

	(method (init)
		(self createPoly: 30 30 100 30 100 150 30 150 30 30)
		(super init: &rest)
	)
)

