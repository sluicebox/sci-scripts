;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3310)
(include sci.sh)
(use Main)

(public
	rm3v310 0
)

(instance rm3v310 of ShiversRoom
	(properties
		picture 3310
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if gPBoatView
			(gPBoatView setView: 2)
		else
			((ScriptID 3001) init: setView: 2) ; pBoatView
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3280
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 3350
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

