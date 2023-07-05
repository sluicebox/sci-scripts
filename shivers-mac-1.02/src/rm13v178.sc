;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13178)
(include sci.sh)
(use Main)

(public
	rm13v178 0
)

(instance rm13v178 of ShiversRoom
	(properties
		picture 13700
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13179
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13179
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13180
	)

	(method (init)
		(self createPoly: 63 142 97 108 97 34 176 34 176 123 191 142)
		(super init: &rest)
	)
)

