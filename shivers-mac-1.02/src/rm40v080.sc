;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40080)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	rm40v080 0
)

(instance rm40v080 of ShiversRoom
	(properties
		picture 40050
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
		(if (not (Random 0 3))
			(spShadow init:)
		)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40100
	)

	(method (init)
		(self createPoly: 84 126 78 0 139 0 139 83 221 122 225 123 85 126)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40090
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40090
	)
)

(instance spShadow of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 40050
		cycleSpeed 15
	)

	(method (init)
		(self setScript: sShadow)
		(super init: &rest)
	)
)

(instance sShadow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spShadow setCycle: End self)
			)
			(1
				(= seconds 1)
			)
			(2
				(spShadow hide:)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

