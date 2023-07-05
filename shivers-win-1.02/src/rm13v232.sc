;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13232)
(include sci.sh)
(use Main)

(public
	rm13v232 0
)

(instance rm13v232 of ShiversRoom
	(properties
		picture 13880
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
		nextRoom 13233
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13231
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13234
	)

	(method (init)
		(self createPoly: 62 143 92 111 92 31 185 31 185 134 192 142)
		(super init: &rest)
	)
)

