;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23600)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm23v600 0
)

(local
	local0
	local1
)

(instance rm23v600 of ShiversRoom
	(properties
		picture 23600
	)

	(method (init)
		(= local1 0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 24)
			(pDoor init:)
			(if (== gPrevRoomNum 23601) ; JigsawPuzzleRm
				(pDoor doVerb:)
			)
		)
		(if (== gPrevRoomNum 23601) ; JigsawPuzzleRm
			(= local0 1)
		else
			(= local0 0)
		)
		(pTLD init:)
		(PrintDebug {cel:%d} (pTLD cel:))
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 1)
		(if (and local0 (or (== newRoomNumber 23630) (== newRoomNumber 23610))) ; rm23v630, rm23v610
			(PrintDebug {Door closing sfx:10609})
			(gSounds play: 10609 0 98 0)
		)
		(if (== newRoomNumber 24750) ; rm24v750
			(gSounds fade: 22301 0 15 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23610
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23630
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24750
	)

	(method (init)
		(self createPoly: 94 27 162 27 162 142 94 142 94 28)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance pTLD of ShiversProp
	(properties
		priority 125
		fixPriority 1
		view 23600
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if local0
			(= cel (self lastCel:))
		else
			(= cel 0)
		)
	)

	(method (doVerb)
		(if local0
			(gCurRoom newRoom: 23601) ; JigsawPuzzleRm
		else
			(gSounds play: 10608 0 98 0)
			(self setCycle: End)
			(= local0 1)
		)
	)
)

(instance pDoor of ShiversProp
	(properties
		priority 125
		fixPriority 1
		view 23601
		cycleSpeed 12
	)

	(method (init)
		(if (IsFlag 67)
			(self view: 23604)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(PrintDebug {doVerb: pDoor})
		(if (not local1)
			(gSounds play: 12309 0 90 0)
			(self setCycle: End)
			(SetFlag 43)
			(= local1 1)
			(efExitForward init: 3)
		)
	)
)

