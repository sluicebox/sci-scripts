;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16150)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v150 0
)

(instance rm16v150 of ShiversRoom
	(properties
		picture 16150
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16154)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16160
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16170
	)

	(method (init)
		(self
			createPoly:
				94
				143
				102
				132
				101
				108
				68
				93
				21
				90
				21
				77
				96
				82
				128
				95
				132
				75
				133
				72
				110
				72
				107
				79
				87
				77
				87
				37
				100
				32
				225
				32
				225
				141
				224
				147
		)
		(super init: &rest)
	)
)

