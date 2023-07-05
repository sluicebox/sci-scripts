;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18250)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm18v25 0
)

(local
	local0
)

(instance rm18v25 of ShiversRoom
	(properties
		picture 18250
	)

	(method (init)
		(= local0 0)
		(efExitBack1 init: 8)
		(efExitBack2 init: 8)
		(circle0 init: (* (Random 0 3) 2))
		(circle1 init: (* (Random 0 3) 2))
		(circle2 init: (* (Random 0 3) 2))
		(circle3 init: (* (Random 0 3) 2))
		(circle4 init: (* (Random 0 3) 2))
		(circle5 init: (* (Random 0 3) 2))
		(circle6 init: (* (Random 0 3) 2))
		(circle7 init: (* (Random 0 3) 2))
		(super init: &rest)
	)
)

(instance efExitBack1 of ExitFeature
	(properties
		nextRoom 18080
	)

	(method (init)
		(self createPoly: 0 0 0 142 44 142 44 1 0 1)
		(super init: &rest)
	)
)

(instance efExitBack2 of ExitFeature
	(properties
		nextRoom 18080
	)

	(method (init)
		(self createPoly: 222 0 222 142 262 142 262 1 222 1)
		(super init: &rest)
	)
)

(instance circle0 of ShiversProp
	(properties
		priority 107
		fixPriority 1
		view 18250
	)

	(method (init param1)
		(= cel param1)
		(self
			createPoly:
				133
				51
				117
				56
				109
				70
				117
				87
				134
				92
				152
				85
				158
				71
				151
				57
				133
				51
		)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sClick)
	)
)

(instance circle1 of ShiversProp
	(properties
		priority 106
		fixPriority 1
		view 18250
		loop 1
	)

	(method (init param1)
		(= cel param1)
		(self
			createPoly:
				132
				44
				112
				50
				100
				69
				108
				89
				131
				99
				159
				90
				167
				71
				159
				52
				133
				44
		)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sClick)
	)
)

(instance circle2 of ShiversProp
	(properties
		priority 105
		fixPriority 1
		view 18250
		loop 2
	)

	(method (init param1)
		(= cel param1)
		(self
			createPoly:
				132
				36
				108
				44
				92
				66
				100
				90
				122
				104
				137
				105
				164
				95
				176
				71
				166
				48
				133
				36
		)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sClick)
	)
)

(instance circle3 of ShiversProp
	(properties
		priority 104
		fixPriority 1
		view 18250
		loop 3
	)

	(method (init param1)
		(= cel param1)
		(self
			createPoly:
				133
				30
				105
				37
				88
				55
				84
				71
				90
				90
				111
				108
				134
				113
				159
				108
				177
				92
				184
				71
				179
				52
				161
				36
				134
				30
		)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sClick)
	)
)

(instance circle4 of ShiversProp
	(properties
		priority 103
		fixPriority 1
		view 18250
		loop 4
	)

	(method (init param1)
		(= cel param1)
		(self
			createPoly:
				134
				22
				103
				29
				82
				49
				75
				71
				82
				93
				102
				112
				133
				120
				161
				116
				183
				98
				193
				71
				185
				47
				169
				32
				134
				22
		)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sClick)
	)
)

(instance circle5 of ShiversProp
	(properties
		priority 102
		fixPriority 1
		view 18250
		loop 5
	)

	(method (init param1)
		(= cel param1)
		(self
			createPoly:
				132
				15
				99
				23
				76
				42
				67
				69
				72
				93
				93
				115
				127
				127
				161
				123
				188
				103
				202
				70
				194
				47
				177
				28
				151
				17
				133
				15
		)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sClick)
	)
)

(instance circle6 of ShiversProp
	(properties
		priority 101
		fixPriority 1
		view 18250
		loop 6
	)

	(method (init param1)
		(= cel param1)
		(self
			createPoly:
				132
				8
				108
				12
				88
				22
				72
				36
				59
				58
				59
				78
				64
				95
				77
				114
				97
				126
				124
				134
				149
				132
				172
				126
				194
				110
				207
				87
				211
				70
				204
				45
				189
				28
				171
				16
				133
				8
		)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sClick)
	)
)

(instance circle7 of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 18250
		loop 7
	)

	(method (init param1)
		(= cel param1)
		(self
			createPoly:
				132
				1
				102
				7
				77
				19
				61
				36
				50
				57
				50
				83
				57
				102
				74
				123
				99
				135
				131
				142
				163
				137
				191
				123
				212
				102
				218
				74
				217
				52
				203
				32
				182
				12
				158
				5
				132
				0
		)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sClick)
	)
)

(instance sClick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client cel: (+ (client cel:) 1))
				(gSounds stop: 11803)
				(gSounds play: 11803 0 82 0)
				(UpdateScreenItem client)
				(= seconds 2)
			)
			(1
				(gSounds stop: 11808)
				(gSounds play: 11808 0 82 0)
				(client cel: (mod (+ (client cel:) 1) 8))
				(UpdateScreenItem client)
				(= cycles 1)
			)
			(2
				(if
					(and
						(== (circle0 cel:) 0)
						(== (circle1 cel:) 0)
						(== (circle2 cel:) 0)
						(== (circle3 cel:) 0)
						(== (circle4 cel:) 0)
						(== (circle5 cel:) 0)
						(== (circle6 cel:) 0)
						(== (circle7 cel:) 0)
					)
					(SetFlag 30)
					(= local0 1)
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(3
				(if (== local0 1)
					(proc951_15 6750)
					(gGame handsOn:)
					(gSounds play: 11807 0 82 0)
					(gCurRoom newRoom: 18080) ; rm18v8
				)
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

