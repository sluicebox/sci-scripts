;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26020)
(include sci.sh)
(use Main)

(public
	rm26v020 0
)

(instance rm26v020 of ShiversRoom
	(properties
		picture 26020
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29140
	)

	(method (init)
		(self
			createPoly:
				106
				130
				178
				130
				174
				46
				166
				30
				149
				21
				137
				21
				119
				30
				114
				43
				106
				130
		)
		(super init: &rest)
	)
)

