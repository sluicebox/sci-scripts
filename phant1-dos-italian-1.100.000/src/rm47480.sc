;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47480)
(include sci.sh)
(use Main)
(use chap7Timer)
(use Str)
(use System)

(public
	rm47480 0
)

(local
	local0
)

(instance rm47480 of ScaryRoom
	(properties
		stepSound 1
	)

	(method (init &tmp temp0)
		(cond
			((IsFlag 135))
			((== gPrevRoomNum 900)
				((ScriptID 45951 2) open: 0) ; chase_dat
			)
			(else
				(= temp0 (Str newWith: 2 {21}))
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
				(temp0 dispose:)
			)
		)
		(super init: &rest)
		(if (IsFlag 135)
			(gCurRoom setScript: playBack)
		else
			(gCurRoom setScript: sEnding)
		)
	)
)

(instance playBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc45951_3)
				(switch global179
					(1
						(self setScript: sEnding self)
					)
					(99
						(gCurRoom newRoom: 44) ; chapEndRm
					)
				)
			)
			(1
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance playNextRoom of Script ; UNUSED
	(properties)

	(method (changeState)
		(proc45951_3)
		(proc45951_3)
		(switch global179
			(1
				(gCurRoom newRoom: 45950)
			)
			(else
				(proc45951_5)
				(= gQuit 1)
			)
		)
	)
)

(instance sEnding of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(proc45951_5)
			(gCurRoom newRoom: 92) ; endRoom
		else
			(switch (= state newState)
				(0
					(gEgo hide:)
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {01}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= seconds 2)
				)
				(1
					(proc45951_5)
					(gCurRoom newRoom: 92) ; endRoom
				)
			)
		)
	)
)

