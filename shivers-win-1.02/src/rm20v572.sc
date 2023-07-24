;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20572)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use System)

(public
	rm20v572 0
)

(local
	local0
)

(instance rm20v572 of ShiversRoom
	(properties
		picture 20572
	)

	(method (init)
		(efExitBack init: 8)
		(hsMouth init:)
		(gSounds fade: 22001 66 5 8 0 0)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(gSounds fade: 22001 98 5 8 0 0)
		(gSounds fade: 32010 0 15 8 1 0)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 20570
	)

	(method (init)
		(self
			createPoly: 0 0 262 0 263 142 0 142 0 1 69 39 73 85 89 119 122 131 149 131 179 118 190 94 197 17 132 4 68 15 69 39
		)
		(super init: &rest)
	)
)

(instance hsMouth of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 113 88 152 88 148 96 143 101 138 103 123 103 114 99 113 89
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sNarrative)
	)
)

(instance sNarrative of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 32010)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(if (IsFlag 39)
					(= local0
						(Str
							format:
								{ The heretics that lay beyond hath driven out all other gods save Aten... so begins Egypt's decline. If thou art wise thou shalt know that the names of this     pharaoh and his queen be placed forever in shame on the columns of Ra. }
						)
					)
					(gCurRoom drawText: local0 0 0)
					(local0 data: 0 dispose:)
					(gSounds play: 32010 0 82 self)
				else
					(gSounds play: 32010 0 82 self)
				)
			)
			(2
				(if (IsFlag 39)
					(gCurRoom eraseText:)
				)
				(self dispose:)
			)
		)
	)
)

