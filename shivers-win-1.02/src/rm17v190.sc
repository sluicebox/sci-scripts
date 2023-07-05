;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17190)
(include sci.sh)
(use Main)
(use n951)

(public
	rm17v190 0
)

(instance rm17v190 of ShiversRoom
	(properties
		picture 17181
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 13)
			(= picture 17190)
		)
		(if (and (== gPrevRoomNum 17180) (IsFlag 43)) ; rm17v180
			(= picture 17182)
		)
		(super init: &rest)
		(if (and (== gPrevRoomNum 17180) (IsFlag 43)) ; rm17v180
			(ClearFlag 43)
			(gSounds stopAll:)
			(gCurRoom newRoom: 934) ; theatreMovie
		)
		(if (== gPrevRoomNum 934) ; theatreMovie
			(gSounds adjChainVol: 35)
			(gSounds playChain: 21701 -1 -1 -2 21701 -1 -1 -2 21702 -1 -1 -2)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17180
	)
)

