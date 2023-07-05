;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13164)
(include sci.sh)
(use Main)

(public
	rm13v164 0
)

(instance rm13v164 of ShiversRoom
	(properties
		picture 13680
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13167
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13166
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13178
	)

	(method (init)
		(self createPoly: 64 142 104 97 104 47 157 47 157 100 193 142)
		(super init: &rest)
	)
)

