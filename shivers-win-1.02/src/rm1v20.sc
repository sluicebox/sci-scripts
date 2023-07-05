;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1020)
(include sci.sh)
(use Main)

(public
	rm1v20 0
)

(instance rm1v20 of ShiversRoom
	(properties
		picture 1020
	)

	(method (init)
		(efExitLeftHigh init: 2)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForwardSign init: 9)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeftHigh of ExitFeature
	(properties
		nextRoom 1060
	)

	(method (init)
		(self createPoly: 1 1 33 1 33 29 1 29)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1060
	)

	(method (init)
		(self createPoly: 1 119 18 119 46 127 46 143 1 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1021
	)
)

(instance efExitForwardSign of ExitFeature
	(properties
		nextRoom 1030
	)

	(method (init)
		(self createPoly: 116 116 116 60 174 60 174 116)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1050
	)

	(method (init)
		(self
			createPoly:
				1
				30
				33
				30
				33
				78
				59
				83
				59
				111
				151
				130
				169
				143
				97
				143
				91
				137
				13
				117
				1
				116
		)
		(super init: &rest)
	)
)

