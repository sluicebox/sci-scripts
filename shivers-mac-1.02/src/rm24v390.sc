;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24390)
(include sci.sh)
(use Main)

(public
	rm24v390 0
)

(instance rm24v390 of ShiversRoom
	(properties
		picture 24390
	)

	(method (init)
		(efExitBackPack init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (== gPrevRoomNum 24501) ; rm24v501
			(gSounds play: 12408 0 82 0)
		)
		(super init: &rest)
	)
)

(instance efExitBackPack of ExitFeature
	(properties
		nextRoom 24501
	)

	(method (init)
		(self
			createPoly: 151 121 161 116 170 116 182 123 190 133 190 137 155 138 148 129 150 120
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24410
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24400
	)
)

