;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39140)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm39v140 0
)

(instance rm39v140 of ShiversRoom
	(properties
		picture 39140
	)

	(method (init)
		(proc951_16 142)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(cond
			((IsFlag 80)
				(= picture 39141)
				(efPanel init: 3)
				(efBeth init: 5)
				(vDoor init:)
			)
			((== global547 9)
				(vPanel init:)
				(efPanel init: 3)
			)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39150
	)
)

(instance efPanel of ExitFeature
	(properties
		nextRoom 39300
	)

	(method (init)
		(proc951_16 159)
		(self createPoly: 111 55 103 49 102 0 170 0 168 48 157 55)
		(super init: &rest)
	)
)

(instance efBeth of ExitFeature
	(properties
		nextRoom 39310
	)

	(method (init)
		(self createPoly: 105 135 106 59 167 59 170 135)
		(super init: &rest)
	)
)

(instance vDoor of View
	(properties
		priority 25
		fixPriority 1
		view 39141
		loop 1
	)

	(method (init)
		(= cel (self lastCel:))
		(super init: &rest)
	)
)

(instance vPanel of View
	(properties
		priority 25
		fixPriority 1
		view 39140
		cel 1
	)
)

