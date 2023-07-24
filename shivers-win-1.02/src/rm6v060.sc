;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6060)
(include sci.sh)
(use Main)
(use n951)

(public
	rm6v060 0
)

(instance rm6v060 of ShiversRoom
	(properties
		picture 6060
	)

	(method (init)
		(super init: &rest)
		(if (and (== gPrevRoomNum 6030) (IsFlag 43)) ; rm6v030
			(ClearFlag 43)
			(gSounds play: 10614 0 40 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitDesk init: 3)
		(efExitDoor init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6030
	)
)

(instance efExitDesk of ExitFeature
	(properties
		nextRoom 6090
	)

	(method (init)
		(self
			createPoly: 210 130 197 129 188 122 189 120 193 110 180 108 178 92 195 90 261 95 261 112 236 116 194 110 190 120 201 120 213 125 208 131
		)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 6100
	)

	(method (init)
		(self
			createPoly: 103 115 81 110 75 82 85 74 98 95 100 110 105 110 106 56 132 57 132 112
		)
		(super init: &rest)
	)
)

