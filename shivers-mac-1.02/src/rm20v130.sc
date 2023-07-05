;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20130)
(include sci.sh)
(use Main)

(public
	rm20v130 0
)

(instance rm20v130 of ShiversRoom
	(properties
		picture 20130
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20220
	)

	(method (init)
		(self createPoly: 77 143 177 143 177 26 165 2 90 2 76 26 76 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20140
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20120
	)
)

