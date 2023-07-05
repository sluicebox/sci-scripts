;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13007)
(include sci.sh)
(use Main)

(public
	rm13v007 0
)

(instance rm13v007 of ShiversRoom
	(properties
		picture 13040
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13006
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13004
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13003
	)

	(method (init)
		(self createPoly: 67 143 111 95 116 48 148 48 153 96 187 141)
		(super init: &rest)
	)
)

