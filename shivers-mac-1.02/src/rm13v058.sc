;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13058)
(include sci.sh)
(use Main)

(public
	rm13v058 0
)

(instance rm13v058 of ShiversRoom
	(properties
		picture 13640
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
		nextRoom 13059
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13062
	)

	(method (init)
		(self createPoly: 66 143 94 111 94 31 165 31 165 109 189 142)
		(super init: &rest)
	)
)

