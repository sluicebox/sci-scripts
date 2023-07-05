;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39130)
(include sci.sh)
(use Main)

(public
	rm39v130 0
)

(instance rm39v130 of ShiversRoom
	(properties
		picture 39130
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39140
	)
)

(instance efForward of ExitFeature
	(properties
		nextRoom 39100
	)

	(method (init)
		(self
			createPoly:
				62
				115
				60
				65
				110
				61
				111
				74
				135
				83
				151
				109
				178
				115
				174
				122
				77
				124
		)
		(super init: &rest)
	)
)

