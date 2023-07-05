;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1250)
(include sci.sh)
(use Main)
(use Motion)

(public
	rm1v250 0
)

(local
	local0
)

(instance rm1v250 of ShiversRoom
	(properties
		picture 1250
	)

	(method (init)
		(= local0 0)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(door init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber &rest)
		(if (and local0 (== newRoomNumber 1251)) ; rm1v251
			(gSounds play: 10126 0 90 0)
		)
		(if (== newRoomNumber 2010) ; rm2v1
			(gSounds fadeChain:)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1251
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1251
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2010
	)

	(method (init)
		(self
			createPoly:
				84
				142
				71
				81
				71
				45
				93
				16
				129
				6
				152
				12
				170
				26
				183
				48
				185
				73
				171
				142
		)
		(super init: &rest)
	)
)

(instance door of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 1250
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
				(not local0)
			)
			(gSounds play: 10125 0 60 0)
			(self cycleSpeed: 12 setCycle: End)
			(efExitForward init: 9)
			(event claimed: 1)
			(= local0 1)
		)
	)
)

