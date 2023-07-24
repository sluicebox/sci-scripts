;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12010)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use Actor)
(use System)

(public
	rm12v01 0
)

(local
	local0
)

(instance rm12v01 of ShiversRoom
	(properties
		picture 12010
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(if (IsFlag 10)
			((View new:) view: 12010 cel: 0 setPri: 25 1 init:)
		)
		(if (IsFlag 9)
			((View new:) view: 12010 cel: 1 setPri: 25 1 init:)
		)
		(narrateButton init: setPri: 15 1)
		(super init: &rest)
		(if (== gPrevRoomNum 11120) ; rm11v120
			(gSounds interruptChain:)
			(self setScript: sEnter)
		)
	)

	(method (newRoom newRoomNumber)
		(gSounds fade: 31250 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12810
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12810
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12020
	)

	(method (init)
		(self
			createPoly: 39 133 81 75 116 85 135 74 117 52 121 45 160 45 166 60 178 63 235 133
		)
		(super init: &rest)
	)
)

(instance narrateButton of ShiversProp
	(properties
		view 12010
		loop 1
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
								{ You are now entering the unfathomable depths of the sea, where countless ships have sunk, taking with them untold riches. The wisdom known only to       the ancients may also reside here in the lost city of Atlantis. }
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

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc951_7 21210)
				(proc951_9 21210)
				(proc951_7 11107)
				(= cycles 1)
			)
			(1
				(gSounds play: 11107 0 64 self)
			)
			(2
				(gSounds stop: 11107)
				(gSounds play: 21210 -1 25 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

