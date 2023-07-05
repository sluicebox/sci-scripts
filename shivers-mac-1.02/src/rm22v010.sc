;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22010)
(include sci.sh)
(use Main)
(use n951)
(use n22001)

(public
	rm22v010 0
)

(instance rm22v010 of ShiversRoom
	(properties
		picture 22010
	)

	(method (init)
		(efExitForward init: 3)
		(super init: &rest)
		(if (< 1000 gPrevRoomNum 22000) ; rm1v00
			(proc951_9 22201)
			(gSounds play: 22201 -1 0 0)
			(gSounds fade: 22201 74 5 16 0 0)
			(proc22001_0)
		)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22020
	)

	(method (init)
		(self createPoly: 85 142 103 114 103 42 156 42 156 114 171 142 86 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature ; UNUSED
	(properties
		nextRoom 22010
	)
)

(instance efExitLeft of ExitFeature ; UNUSED
	(properties
		nextRoom 22010
	)
)

