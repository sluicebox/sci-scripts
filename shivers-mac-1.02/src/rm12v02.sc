;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12020)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm12v02 0
)

(instance rm12v02 of ShiversRoom
	(properties
		picture 12020
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 10)
			((View new:) view: 12020 cel: 0 setPri: 25 1 init:)
		)
		(if (IsFlag 9)
			((View new:) view: 12020 cel: 1 setPri: 25 1 init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 3)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12110
	)

	(method (init)
		(self
			createPoly:
				101
				124
				125
				114
				119
				89
				133
				76
				137
				59
				153
				59
				149
				87
				155
				90
				161
				90
				181
				107
				192
				107
				223
				125
		)
		(super init: &rest)
	)
)

