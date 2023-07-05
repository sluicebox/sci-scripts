;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20810)
(include sci.sh)
(use Main)

(public
	rm20v810 0
)

(instance rm20v810 of ShiversRoom
	(properties
		picture 20810
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20920
	)

	(method (init)
		(self
			createPoly:
				130
				92
				148
				92
				148
				104
				144
				104
				142
				127
				155
				134
				149
				137
				127
				137
				120
				132
				124
				129
				136
				128
				132
				104
				129
				104
				130
				93
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20440
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20790
	)
)

