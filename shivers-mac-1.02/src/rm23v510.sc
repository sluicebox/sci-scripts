;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23510)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm23v510 0
)

(instance rm23v510 of ShiversRoom
	(properties
		picture 23510
	)

	(method (init)
		(if (IsFlag 23)
			(vBullBelly init:)
			(vBullBack init:)
			(if (!= [global118 29] 0)
				(vPotView init:)
			)
		)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
		(gSounds fade: 22301 0 15 15 1 0)
		(proc951_7 22310)
		(proc951_9 22310)
		(gSounds play: 22310 -1 0 0)
		(gSounds fade: 22310 98 15 8 0 0)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23500
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23500
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23540
	)

	(method (init)
		(self
			createPoly:
				173
				137
				173
				107
				168
				102
				168
				39
				102
				48
				102
				105
				106
				112
				106
				138
				173
				140
		)
		(super init: &rest)
	)
)

(instance vBullBack of View
	(properties
		view 23510
	)

	(method (init)
		(self setPri: 25 1)
		(super init: &rest)
	)
)

(instance vBullBelly of View
	(properties
		view 23510
		loop 1
	)

	(method (init)
		(self setPri: 1 1)
		(super init: &rest)
	)
)

(instance vPotView of View
	(properties
		x 192
		y 89
		view 0
	)

	(method (init)
		(self view: [global118 29] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 17 scaleY: 17 setPri: 10 1)
	)
)

