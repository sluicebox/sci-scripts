;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13167)
(include sci.sh)
(use Main)

(public
	rm13v167 0
)

(instance rm13v167 of ShiversRoom
	(properties
		picture 13590
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
		nextRoom 13166
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13164
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13163
	)

	(method (init)
		(self createPoly: 36 142 36 12 191 12 191 130 200 142)
		(super init: &rest)
	)
)

