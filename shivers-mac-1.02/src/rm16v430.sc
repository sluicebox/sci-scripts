;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16430)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm16v430 0
)

(instance rm16v430 of ShiversRoom
	(properties
		picture 16430
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16434)
			(if (!= [global118 19] 0)
				(vPotView init:)
			)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(hsPaper init:)
		(super init: &rest)
	)
)

(instance vPotView of View
	(properties
		x 237
		y 121
		view 0
	)

	(method (init)
		(self view: [global118 19] loop: 2)
		(super init: &rest)
		(self setScale: scaleX: 20 scaleY: 20 setPri: 15)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16440
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16440
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16420
	)

	(method (init)
		(if (IsFlag 13)
			(self createPoly: 153 142 163 106 183 22 243 14 243 143)
		else
			(self
				createPoly: 154 142 153 115 182 96 185 41 218 41 218 114 224 146
			)
		)
		(super init: &rest)
	)
)

(instance hsPaper of HotSpot
	(properties)

	(method (init)
		(self createPoly: 117 112 65 88 96 85 138 104)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 104)
		(spPaper init: setPri: 15 1)
	)
)

(instance spPaper of ShiversProp
	(properties
		view 16374
	)

	(method (doVerb)
		(self dispose:)
	)

	(method (init)
		(if (IsFlag 13)
			(= view 16434)
		)
		(hsPaper dispose:)
		(efExitLeft dispose:)
		(efExitRight dispose:)
		(efExitForward dispose:)
		(super init:)
	)

	(method (dispose)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(hsPaper init:)
		(super dispose:)
	)
)

