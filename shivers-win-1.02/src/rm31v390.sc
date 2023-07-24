;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31390)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm31v390 0
)

(instance rm31v390 of ShiversRoom
	(properties
		picture 31390
	)

	(method (init)
		(if (IsFlag 73)
			(proc951_16 161)
			(spSymbol init:)
		else
			(= picture 31395)
		)
		(efExitBack init: 8)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 9420) ; rm9v42
			(gSounds fade: 23109 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance spSymbol of ShiversProp
	(properties
		priority 20
		fixPriority 1
		view 31391
	)

	(method (doVerb)
		(self setScript: sDoMovie)
	)
)

(instance sDoMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 13123 0 82 0)
				(spSymbol setCycle: End self)
			)
			(1
				(gSounds fade: 23109 0 1 30 1 self)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: 936) ; slideRm
				(self dispose:)
			)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 31360
	)

	(method (init)
		(self
			createPoly: 0 0 131 0 131 5 113 6 92 15 77 24 63 38 56 57 54 67 57 87 66 103 84 121 116 132 150 132 173 120 195 105 206 76 205 52 198 38 177 19 152 10 133 5 133 0 262 0 262 144 0 144 0 0
		)
		(super init: &rest)
	)
)

