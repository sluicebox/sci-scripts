;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20120)
(include sci.sh)
(use Main)

(public
	rm20v120 0
)

(instance rm20v120 of ShiversRoom
	(properties
		picture 20120
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
		nextRoom 20190
	)

	(method (init)
		(self
			createPoly: 125 50 132 47 139 51 139 60 136 62 139 65 142 62 152 62 157 68 154 73 142 74 140 71 135 76 138 80 138 86 132 90 124 87 124 83 124 77 128 76 124 72 120 74 110 74 107 69 109 62 121 63 123 66 127 62 124 60 125 50
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20130
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20110
	)
)

