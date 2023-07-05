;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29010)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm29v010 0
)

(instance rm29v010 of ShiversRoom
	(properties
		picture 29010
	)

	(method (init)
		(cond
			((IsFlag 61)
				(self picture: 29010)
				(if (IsFlag 68)
					((View new:) view: 29011 setPri: 10 1 init:)
				)
			)
			((IsFlag 68)
				(self picture: 29012)
			)
			(else
				(self picture: 29011)
			)
		)
		(if (IsFlag 69)
			(efExitForward init: 3)
		)
		(if (IsFlag 61)
			(efExitPool init: 3)
		)
		(efExitPlaque init: 3)
		(efExitForwardLeft init: 3)
		(efExitForwardRight init: 3)
		(efExitUp init: 4)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 30
		nextRoom 29240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 233
		nextRoom 29020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29260
	)

	(method (init)
		(self
			createPoly: 146 99 136 107 110 107 78 94 74 70 125 43 177 65 176 98
		)
		(super init: &rest)
	)
)

(instance efExitPool of ExitFeature
	(properties
		nextRoom 29510
	)

	(method (init)
		(self
			createPoly:
				163
				117
				154
				121
				107
				122
				89
				120
				89
				116
				110
				111
				140
				110
				157
				112
		)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 29810
	)

	(method (init)
		(self createPoly: 155 109 146 99 163 99 170 107)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 29250
	)

	(method (init)
		(self createPoly: 89 120 30 137 30 40 79 40 79 67 74 70 78 94 88 115)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 29300
	)

	(method (init)
		(self createPoly: 20 1 20 20 243 20 243 1 20 1)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 29060
	)

	(method (init)
		(self createPoly: 164 118 233 136 233 40 176 40 176 98 170 107)
		(super init: &rest)
	)
)

