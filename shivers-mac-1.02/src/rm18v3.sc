;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18030)
(include sci.sh)
(use Main)

(public
	rm18v3 0
)

(instance rm18v3 of ShiversRoom
	(properties
		picture 18030
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16750
	)

	(method (init)
		(self
			createPoly:
				57
				143
				57
				65
				67
				37
				86
				17
				118
				5
				157
				5
				182
				13
				205
				33
				217
				52
				220
				67
				220
				143
		)
		(super init: &rest)
	)
)

