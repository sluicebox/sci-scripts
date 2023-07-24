;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19170)
(include sci.sh)
(use Main)

(public
	rm19v170 0
)

(instance rm19v170 of ShiversRoom
	(properties
		picture 19170
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
		nextRoom 19200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19130
	)

	(method (init)
		(self
			createPoly: 68 143 78 119 78 106 71 97 70 63 90 62 95 56 102 56 110 73 122 74 143 105 142 113 148 117 140 120 140 127 169 143
		)
		(super init: &rest)
	)
)

