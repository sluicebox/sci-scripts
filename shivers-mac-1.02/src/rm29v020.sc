;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29020)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm29v020 0
)

(instance rm29v020 of ShiversRoom
	(properties
		picture 29020
	)

	(method (init)
		(if (IsFlag 68)
			(self picture: 29021)
		else
			(self picture: 29020)
		)
		(if (IsFlag 86)
			(vPhoto init:)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29030
	)

	(method (init)
		(self createPoly: 191 118 191 42 88 42 88 118 191 118)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 29800
	)

	(method (init)
		(self
			createPoly: 164 144 156 128 157 122 178 112 187 112 192 119 193 129 187 142 164 144
		)
		(super init: &rest)
	)
)

(instance vPhoto of View
	(properties
		priority 25
		fixPriority 1
		view 29020
		cel 1
	)
)

