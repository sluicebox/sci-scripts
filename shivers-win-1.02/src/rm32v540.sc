;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32540)
(include sci.sh)
(use Main)
(use n951)

(public
	rm32v540 0
)

(instance rm32v540 of ShiversRoom
	(properties
		picture 32540
	)

	(method (init)
		(if (IsFlag 81)
			(= picture 32541)
		else
			(= picture 32540)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(if (IsFlag 63)
			(gSounds setVol: 13215 32)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32510
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32510
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 32510
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

