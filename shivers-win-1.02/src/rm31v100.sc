;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31100)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm31v100 0
)

(local
	local0
)

(instance rm31v100 of ShiversRoom
	(properties
		picture 31100
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 31430
	)

	(method (init)
		(self
			createPoly: 0 0 0 142 262 142 262 0 1 0 86 28 86 116 173 121 173 27 84 27
		)
		(super init: &rest)
	)
)

(instance spNarrative of ShiversProp
	(properties)

	(method (init)
		(self
			createPoly: 118 92 124 87 132 87 138 91 139 98 135 104 127 106 120 104 117 98 118 92
		)
		(super init: &rest)
	)
)

(instance sNarrative of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spNarrative cel: 0)
				(UpdateScreenItem spNarrative)
				(spNarrative cel: 1)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(if (IsFlag 39)
					(= local0 (Str format: { ;text in here }))
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
				)
			)
			(2
				(if (IsFlag 39)
					(gCurRoom eraseText:)
				)
				(spNarrative cel: 0)
				(self dispose:)
			)
		)
	)
)

