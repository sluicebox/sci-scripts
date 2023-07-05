;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19160)
(include sci.sh)
(use Main)
(use n951)

(public
	rm19v160 0
)

(instance rm19v160 of ShiversRoom
	(properties
		picture 19160
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (and (proc951_11 8 19000) (== gPrevRoomNum 19130)) ; rm19v130
			(gSounds adjChainVol: 16)
			(gSounds fade: 21909 0 15 8 1 0)
			(gSounds playChain: -1 -5 21901 -1 -1 -5 21901 -1 -1 -5 21904 -1)
			(gSounds play: 21903 -1 48 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19130
	)
)

