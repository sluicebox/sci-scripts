;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31280)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm31v280 0
)

(instance rm31v280 of ShiversRoom
	(properties
		picture 31280
	)

	(method (init)
		(ClearFlag 43)
		(pDoor init:)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)

	(method (newRoom)
		(if (IsFlag 43)
			(gSounds play: 13120 0 82 0)
			(ClearFlag 43)
		)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31250
	)

	(method (init)
		(self
			createPoly:
				88
				143
				83
				114
				83
				78
				96
				67
				115
				62
				109
				43
				115
				27
				132
				24
				145
				28
				152
				34
				153
				44
				147
				62
				171
				70
				181
				82
				179
				103
				180
				119
				179
				128
				177
				142
				89
				142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31290
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31290
	)
)

(instance pDoor of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 31280
	)

	(method (doVerb)
		(if (not (IsFlag 43))
			(self setCycle: End)
			(gSounds play: 13116 0 82 0)
			(SetFlag 43)
			(efExitForward init: 3)
			(self createPoly: 0 0 0 0 0 0)
		)
	)

	(method (init)
		(self
			createPoly:
				88
				143
				83
				114
				83
				78
				96
				67
				115
				62
				109
				43
				115
				27
				132
				24
				145
				28
				152
				34
				153
				44
				147
				62
				171
				70
				181
				82
				179
				103
				180
				119
				179
				128
				177
				142
				89
				142
		)
		(super init: &rest)
	)
)

