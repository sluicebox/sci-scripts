;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13008)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v008 0
)

(instance rm13v008 of ShiversRoom
	(properties
		picture 13090
	)

	(method (init)
		(if (IsFlag 31)
			(self picture: 13091)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13009
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13009
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13010
	)

	(method (init)
		(self createPoly: 66 143 91 116 91 27 174 27 174 116 195 142)
		(super init: &rest)
	)
)

