;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1220)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v220 0
)

(instance rm1v220 of ShiversRoom
	(properties
		picture 1220
	)

	(method (init)
		(if (IsFlag 1)
			(= picture 1221)
			(efExitForward init: 9)
		else
			(efExitPuzzle init: 9)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1211
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1212
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1230
	)

	(method (init)
		(self
			createPoly: 158 126 133 84 86 90 79 85 79 79 93 76 132 80 148 91 159 112 168 104 185 117 198 113 182 87 151 67 111 57 73 59 30 78 14 90 52 82 34 114 76 130 126 130
		)
		(super init: &rest)
	)
)

(instance efExitPuzzle of ExitFeature
	(properties
		nextRoom 50150
	)

	(method (init)
		(self
			createPoly: 1 60 54 18 60 17 137 7 210 29 217 32 227 89 221 93 82 127 69 127 0 71
		)
		(super init: &rest)
	)
)

