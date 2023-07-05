;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10202)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm10v202 0
)

(instance rm10v202 of ShiversRoom
	(properties
		picture 10202
	)

	(method (init)
		(proc951_16 96)
		(if (<= 10204 gPrevRoomNum 10213) ; rm10v204
			(= picture 10203)
			(hsPurseOpen init:)
			(efAddressBook init: 0)
		else
			(hsPurse init:)
			(= picture 10202)
			(gSounds stop: 11014)
			(gSounds play: 11014 0 82 0)
		)
		(super init: &rest)
		(efExitBack init: 8)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 10204) ; rm10v204
			(gSounds stop: 11016)
			(gSounds play: 11016 0 82 0)
		else
			(gSounds stop: 11014)
			(gSounds play: 11014 0 82 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 10200
	)

	(method (init)
		(self
			createPoly:
				0
				0
				73
				77
				171
				5
				192
				15
				188
				70
				127
				140
				119
				139
				81
				120
				73
				77
				0
				0
				0
				143
				263
				143
				263
				0
		)
		(super init: &rest)
	)
)

(instance efAddressBook of ExitFeature
	(properties
		nextRoom 10204
	)

	(method (init)
		(self createPoly: 104 87 92 50 152 27 162 38)
		(super init: &rest)
	)
)

(instance hsPurse of HotSpot
	(properties)

	(method (init)
		(self createPoly: 119 139 81 120 73 77 171 5 192 15 188 70 127 140)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sOpenPurse)
	)
)

(instance hsPurseOpen of HotSpot
	(properties)

	(method (init)
		(self
			createPoly:
				121
				140
				69
				115
				56
				70
				87
				48
				92
				51
				103
				87
				162
				38
				153
				27
				91
				50
				87
				48
				151
				1
				155
				1
				184
				20
				186
				65
				184
				72
				127
				138
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sClosePurse)
	)
)

(instance sOpenPurse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 11015 0 82 0)
				(gCurRoom drawPic: 10203)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(hsPurse dispose:)
				(hsPurseOpen init:)
				(efAddressBook init: 0)
				(self dispose:)
			)
		)
	)
)

(instance sClosePurse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 11021 0 82 0)
				(gCurRoom drawPic: 10202)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(hsPurse init:)
				(hsPurseOpen dispose:)
				(efAddressBook dispose:)
				(self dispose:)
			)
		)
	)
)

