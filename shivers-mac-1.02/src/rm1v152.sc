;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1152)
(include sci.sh)
(use Main)

(public
	rm1v152 0
)

(instance rm1v152 of ShiversRoom
	(properties
		picture 1152
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
		nextRoom 1151
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1150
	)

	(method (init)
		(self createPoly: 216 1 262 1 262 143 244 143)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1180
	)

	(method (init)
		(self createPoly: 75 142 104 109 168 98 183 99 196 104 149 114 148 142)
		(super init: &rest)
	)
)

