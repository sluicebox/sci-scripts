;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12240)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm12v24 0
)

(instance rm12v24 of ShiversRoom
	(properties
		picture 12240
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efPlaque init: 3)
		(if (IsFlag 9)
			((View new:) view: 12240 cel: 0 setPri: 25 1 init:)
			(efTunnel init: 3)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (>= newRoomNumber 13000) ; rm13v000
			(gSounds fade: 21210 0 15 15 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12180
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 12570
	)

	(method (init)
		(self createPoly: 211 109 207 93 236 92 243 107)
		(super init: &rest)
	)
)

(instance efTunnel of ExitFeature
	(properties
		nextRoom 13522
	)

	(method (init)
		(self
			createPoly: 81 142 83 46 101 31 125 25 151 31 165 40 173 52 173 143
		)
		(super init: &rest)
	)
)

