;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32030)
(include sci.sh)
(use Main)
(use n32001)

(public
	rm32v030 0
)

(instance rm32v030 of ShiversRoom
	(properties
		picture 32030
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 32010) ; rm32v010
			(proc32001_0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32080
	)

	(method (init)
		(self
			createPoly: 130 124 130 111 141 102 147 88 148 79 147 67 146 58 138 47 126 37 111 30 96 29 81 29 62 37 45 51 38 62 36 80 40 92 50 107 58 114 58 123 129 123
		)
		(super init: &rest)
	)
)

