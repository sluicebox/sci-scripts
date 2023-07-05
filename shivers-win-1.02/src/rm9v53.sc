;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9530)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v53 0
)

(instance rm9v53 of ShiversRoom
	(properties
		picture 9530
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (proc951_11 6 9000)
			(gSounds fade: 20903 0 10 16 1 0)
			(proc951_9 20908)
			(gSounds play: 20908 -1 50 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9521
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9540
	)
)

