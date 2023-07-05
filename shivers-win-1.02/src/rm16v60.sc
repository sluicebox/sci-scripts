;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16060)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v60 0
)

(instance rm16v60 of ShiversRoom
	(properties
		picture 16060
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16064)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16070
	)
)

