;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10062)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v062 0
)

(local
	local0
)

(instance rm10v062 of ShiversRoom
	(properties
		picture 10062
	)

	(method (init)
		(proc951_16 99)
		(= local0 0)
		(super init: &rest)
		(efExitBack init: 8)
		(hsLipStick init:)
	)
)

(instance hsLipStick of HotSpot
	(properties)

	(method (init)
		(self
			createPoly:
				133
				8
				113
				9
				109
				11
				113
				130
				122
				136
				135
				137
				150
				131
				156
				11
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if local0
			(gSounds play: 11012 0 82 0)
			(gCurRoom drawPic: 10062)
			(= local0 0)
		else
			(gSounds play: 11011 0 82 0)
			(gCurRoom drawPic: 10063)
			(= local0 1)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 10060
	)

	(method (init)
		(self
			createPoly:
				0
				0
				0
				142
				264
				142
				263
				0
				1
				0
				108
				12
				122
				8
				142
				8
				156
				11
				151
				130
				137
				136
				122
				136
				113
				131
				108
				12
		)
		(super init: &rest)
	)
)

