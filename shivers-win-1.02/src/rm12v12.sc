;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12120)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm12v12 0
)

(local
	local0
)

(instance rm12v12 of ShiversRoom
	(properties
		picture 12120
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(narrateButton init: setPri: 15 1)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 9)
		(gSounds fade: 31250 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12810
	)

	(method (init)
		(self
			createPoly: 20 131 20 110 66 63 66 17 194 17 194 62 233 105 233 128 233 130
		)
		(super init: &rest)
	)
)

(instance narrateButton of ShiversProp
	(properties
		view 12120
	)

	(method (doVerb)
		(proc951_16 68)
		(gCurRoom setScript: sNarration)
	)
)

(instance sNarration of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 31250)
				(proc951_9 31250)
				(narrateButton cel: 0)
				(UpdateScreenItem narrateButton)
				(narrateButton cel: 1)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(if (IsFlag 39)
					(= local0
						(Str
							format:
								{ You are now entering the unfathomable depths of the sea, where countless ships have sunk, taking with them untold riches. The wisdom known only to_______the ancients may also reside here in the lost city of Atlantis. }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
				)
				(gSounds play: 31250 0 75 self)
			)
			(2
				(if (IsFlag 39)
					(gCurRoom eraseText:)
				)
				(narrateButton cel: 0)
				(self dispose:)
			)
		)
	)
)

