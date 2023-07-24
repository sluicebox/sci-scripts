;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2650)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v65 0
)

(instance rm2v65 of ShiversRoom
	(properties
		picture 2150
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2801)
			(efExitRightDark init: 1)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2660
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2660
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2050
	)

	(method (init)
		(self createPoly: 64 142 123 71 131 63 139 70 197 142)
		(super init: &rest)
	)
)

(instance efExitRightDark of ExitFeature
	(properties
		nextRoom 2040
	)

	(method (init)
		(self
			createPoly: 181 102 179 66 163 51 153 46 137 45 134 72 143 80 146 101 180 125
		)
		(super init: &rest)
	)
)

