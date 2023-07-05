;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14160)
(include sci.sh)
(use Main)
(use Osc)

(public
	rm14v16 0
)

(instance rm14v16 of ShiversRoom
	(properties
		picture 14160
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(camera init:)
		(super init: &rest)
	)
)

(instance camera of ShiversProp
	(properties
		x 87
		y 21
		view 14160
		cel 5
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 4)
		(self setCycle: Osc 7)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14150
	)
)

