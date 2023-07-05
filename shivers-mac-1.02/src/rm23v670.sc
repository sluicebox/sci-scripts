;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23670)
(include sci.sh)
(use Main)

(public
	rm23v670 0
)

(instance rm23v670 of ShiversRoom
	(properties
		picture 23670
	)

	(method (init)
		(efExitForward init: 3)
		(efExitDoor init: 3)
		(efExitPlaque init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23380
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23370
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 23950
	)

	(method (init)
		(self
			createPoly:
				157
				110
				178
				98
				185
				98
				200
				105
				200
				110
				198
				116
				177
				142
				167
				142
				187
				111
				189
				104
				162
				118
				156
				110
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23610
	)

	(method (init)
		(self createPoly: 64 128 64 39 20 47 20 117)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 23600
	)

	(method (init)
		(self createPoly: 64 128 64 39 129 30 128 141)
		(super init: &rest)
	)
)

