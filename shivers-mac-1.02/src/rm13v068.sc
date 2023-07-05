;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13068)
(include sci.sh)
(use Main)

(public
	rm13v068 0
)

(instance rm13v068 of ShiversRoom
	(properties
		picture 13970
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
		nextRoom 13069
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13067
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13034
	)

	(method (init)
		(self createPoly: 77 142 99 112 99 30 193 30 193 133 202 142)
		(super init: &rest)
	)
)

