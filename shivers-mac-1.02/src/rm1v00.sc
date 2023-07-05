;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1000)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm1v00 0
)

(local
	local0
	local1
)

(instance rm1v00 of ShiversRoom
	(properties
		picture 1000
	)

	(method (init)
		(= local1 0)
		(chain init:)
		(mailbox init:)
		(efExitBack1 init: 8)
		(efExitBack2 init: 8)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(if (IsFlag 33)
			(efExitDown init: 5)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 1003) ; rm1v03
			(gSounds play: 10621 0 82 0)
			(= local1 1)
			(self setScript: sLetterSlidesOut)
		)
		(if (< gPrevRoomNum 1000) ; rm1v00
			(ClearFlag 43)
		)
	)

	(method (dispose)
		(if (== local1 1)
			(SetFlag 43)
		)
		(super dispose:)
	)
)

(instance efExitBack1 of ExitFeature
	(properties
		nextRoom 1021
	)

	(method (init)
		(self createPoly: 199 0 199 116 242 116 242 0 199 0)
		(super init: &rest)
	)
)

(instance efExitBack2 of ExitFeature
	(properties
		nextRoom 1021
	)

	(method (init)
		(self createPoly: 23 0 23 116 53 116 53 99 61 77 114 11 157 0 23 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1012
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 1002
	)

	(method (init)
		(self createPoly: 1 117 263 117 263 141 1 141 1 117)
		(super init: &rest)
	)
)

(instance mailbox of Prop
	(properties
		priority 250
		fixPriority 1
		view 1007
	)

	(method (init)
		(if (== gPrevRoomNum 1003) ; rm1v03
			(self cel: 1)
		)
		(super init: &rest)
	)
)

(instance chain of ShiversProp
	(properties
		x 184
		priority 250
		fixPriority 1
		view 1007
		loop 1
		cel 2
	)

	(method (init)
		(if (== gPrevRoomNum 1003) ; rm1v03
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 143)
		(if (== local1 0)
			(self setScript: sPullChain)
		)
	)
)

(instance efLetter of ExitFeature
	(properties
		nextRoom 1003
	)

	(method (init)
		(self createPoly: 114 80 96 93 129 99 149 80 142 77 114 79)
		(super init: &rest)
	)
)

(instance sPullChain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(gSounds stop: 10101)
				(gSounds play: 10101 0 90 0)
				(chain cycleSpeed: 12 setCycle: Beg self)
			)
			(1
				(if (not (IsFlag 33))
					(mailbox cel: 1)
					(efLetter init: 0)
				else
					(mailbox cel: 4)
				)
				(UpdateScreenItem mailbox)
			)
		)
	)
)

(instance sLetterSlidesOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(gSounds play: 10103 0 82 0)
				(mailbox cycleSpeed: 10 setCycle: End self)
				(SetFlag 33)
				(efExitDown init: 5)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

