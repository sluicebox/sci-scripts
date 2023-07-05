;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1271)
(include sci.sh)
(use Main)

(public
	rm1v271 0
)

(instance rm1v271 of ShiversRoom
	(properties
		picture 1271
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1261
	)

	(method (init)
		(self
			createPoly:
				27
				131
				75
				120
				66
				65
				100
				65
				104
				51
				135
				40
				155
				36
				166
				42
				155
				45
				141
				52
				143
				66
				183
				66
				178
				115
				228
				126
				29
				131
		)
		(super init: &rest)
	)
)

