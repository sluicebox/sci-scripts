;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12130)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm12v13 0
)

(instance rm12v13 of ShiversRoom
	(properties
		picture 12130
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(if (IsFlag 10)
			((View new:) view: 12130 cel: 0 setPri: 25 1 init:)
		)
		(if (IsFlag 9)
			((View new:) view: 12130 cel: 1 setPri: 25 1 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12420
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12170
	)

	(method (init)
		(self
			createPoly:
				44
				143
				89
				105
				124
				87
				137
				77
				137
				52
				160
				52
				159
				94
				186
				103
				244
				143
		)
		(super init: &rest)
	)
)

