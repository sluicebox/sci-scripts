;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32610)
(include sci.sh)
(use Main)

(public
	rm32v610 0
)

(local
	local0
)

(instance rm32v610 of ShiversRoom
	(properties
		picture 32610
	)

	(method (init)
		(efExitBack init: 8)
		(efExitRight init: 1)
		(= local0 0)
		(hsPitcher init:)
		(hsGlass init:)
		(hsSlim init:)
		(super init: &rest)
	)
)

(instance hsPitcher of HotSpot
	(properties)

	(method (init)
		(self
			createPoly:
				35
				104
				33
				110
				31
				116
				33
				120
				37
				122
				45
				122
				49
				118
				49
				113
				46
				110
				47
				105
				35
				104
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== local0 0)
			(= local0 1)
		else
			(= local0 0)
		)
	)
)

(instance hsGlass of HotSpot
	(properties)

	(method (init)
		(self createPoly: 62 112 62 120 66 121 70 113 63 111)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== local0 1)
			(= local0 2)
		else
			(= local0 0)
		)
	)
)

(instance hsSlim of HotSpot
	(properties)

	(method (init)
		(self
			createPoly:
				153
				68
				142
				77
				147
				85
				144
				90
				128
				94
				126
				72
				114
				72
				102
				110
				85
				113
				85
				126
				108
				120
				135
				118
				133
				123
				149
				126
				147
				116
				186
				116
				177
				102
				173
				90
				166
				90
				169
				76
				154
				67
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== local0 2)
			(gSounds play: 35115 0 90 0)
		)
		(= local0 0)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32620
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 32120
	)

	(method (init)
		(self
			createPoly:
				233
				0
				233
				141
				154
				141
				154
				127
				194
				121
				194
				111
				169
				64
				151
				64
				112
				69
				78
				109
				68
				100
				30
				100
				15
				118
				16
				130
				0
				130
				0
				0
				232
				0
		)
		(super init: &rest)
	)
)

