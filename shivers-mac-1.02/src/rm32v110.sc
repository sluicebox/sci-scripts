;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32110)
(include sci.sh)
(use Main)
(use n951)

(public
	rm32v110 0
)

(instance rm32v110 of ShiversRoom
	(properties
		picture 32110
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 7)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32100
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32090
	)

	(method (init)
		(self
			createPoly:
				91
				117
				174
				117
				188
				95
				187
				70
				178
				52
				157
				26
				129
				23
				102
				25
				95
				32
				73
				56
				69
				68
				67
				91
				75
				105
				90
				117
		)
		(super init: &rest)
	)
)

