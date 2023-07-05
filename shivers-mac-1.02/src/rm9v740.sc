;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9740)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v740 0
)

(instance rm9v740 of ShiversRoom
	(properties
		picture 9740
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efLeftForward init: 3)
		(efGlass init: 0)
		(efRightForward init: 3)
		(efPlaque init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 42) (< 9000 newRoomNumber 9200)) ; rm9v20
			(gSounds fade: 10908 0 20 3 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9710
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9730
	)
)

(instance efLeftForward of ExitFeature
	(properties
		nextRoom 9300
	)

	(method (init)
		(self createPoly: 84 82 93 60 100 60 100 41 30 41 21 42 21 94 81 94)
		(super init: &rest)
	)
)

(instance efRightForward of ExitFeature
	(properties
		nextRoom 9140
	)

	(method (init)
		(self createPoly: 201 94 199 72 203 28 243 28 243 106 204 105)
		(super init: &rest)
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 9800
	)

	(method (init)
		(self
			createPoly:
				92
				60
				82
				81
				79
				112
				104
				113
				108
				141
				147
				142
				151
				115
				170
				113
				168
				80
				161
				60
		)
		(super init: &rest)
	)
)

(instance efGlass of ExitFeature
	(properties
		nextRoom 9741
	)

	(method (init)
		(self createPoly: 190 76 165 71 158 27 197 27 203 31 199 69)
		(super init: &rest)
	)
)

