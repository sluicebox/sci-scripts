;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12410)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm12v41 0
)

(local
	local0
	local1
	local2
	local3 = 10
	local4
	local5
	local6
	[local7 10] = [0 5 4 0 5 4 6 3 1 0]
)

(instance rm12v41 of ShiversRoom
	(properties
		picture 12410
	)

	(method (init)
		(proc951_18 21201)
		(proc951_18 21202)
		(proc951_18 21203)
		(proc951_18 21204)
		(proc951_18 21205)
		(proc951_18 21206)
		(proc951_18 21207)
		(= local5 (List new:))
		(efBack init: 8)
		(= local6 1)
		(= local2 0)
		(hsClam1 init:)
		(hsClam2 init:)
		(hsClam3 init:)
		(hsClam4 init:)
		(hsClam5 init:)
		(hsClam6 init:)
		(hsClam7 init:)
		(if (IsFlag 9)
			(colossus cel: (colossus lastCel:) init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(if local1
			(clamClosed dispose:)
			(bubbles dispose:)
			(= local1 0)
		)
		(if local0
			(= local0 0)
		)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(gSounds fade: (+ 21201 temp0) 0 5 16 1 0)
			(proc951_19 (+ 21201 temp0))
		)
		(efBack init: 8)
		(= local6 1)
		(hsBack dispose:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 12370
	)

	(method (init)
		(self
			createPoly:
				0
				0
				0
				143
				21
				143
				25
				81
				60
				14
				83
				0
				180
				0
				197
				13
				212
				75
				240
				83
				246
				143
				264
				144
				264
				0
		)
		(super init: &rest)
	)
)

(instance hsBack of HotSpot
	(properties)

	(method (doVerb)
		(if (gCurRoom script:)
			(playNoteScript cue:)
		)
	)

	(method (init)
		(self
			createPoly:
				0
				0
				52
				95
				218
				95
				218
				111
				52
				111
				52
				95
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

(instance hsClam1 of HotSpot
	(properties
		nsLeft 52
		nsTop 95
		nsRight 74
		nsBottom 111
	)

	(method (doVerb)
		(local5 addToEnd: 0)
		(PrintDebug {list:%d 0} (local5 size:))
		(if (not (gCurRoom script:))
			(gCurRoom setScript: playNoteScript)
		else
			(playNoteScript cue:)
		)
	)
)

(instance hsClam2 of HotSpot
	(properties
		nsLeft 76
		nsTop 95
		nsRight 98
		nsBottom 111
	)

	(method (doVerb)
		(local5 addToEnd: 1)
		(PrintDebug {list:%d 1} (local5 size:))
		(if (not (gCurRoom script:))
			(gCurRoom setScript: playNoteScript)
		else
			(playNoteScript cue:)
		)
	)
)

(instance hsClam3 of HotSpot
	(properties
		nsLeft 100
		nsTop 95
		nsRight 122
		nsBottom 111
	)

	(method (doVerb)
		(local5 addToEnd: 2)
		(PrintDebug {list:%d 2} (local5 size:))
		(if (not (gCurRoom script:))
			(gCurRoom setScript: playNoteScript)
		else
			(playNoteScript cue:)
		)
	)
)

(instance hsClam4 of HotSpot
	(properties
		nsLeft 124
		nsTop 95
		nsRight 146
		nsBottom 111
	)

	(method (doVerb)
		(local5 addToEnd: 3)
		(PrintDebug {list:%d 3} (local5 size:))
		(if (not (gCurRoom script:))
			(gCurRoom setScript: playNoteScript)
		else
			(playNoteScript cue:)
		)
	)
)

(instance hsClam5 of HotSpot
	(properties
		nsLeft 148
		nsTop 95
		nsRight 170
		nsBottom 111
	)

	(method (doVerb)
		(local5 addToEnd: 4)
		(PrintDebug {list:%d 4} (local5 size:))
		(if (not (gCurRoom script:))
			(gCurRoom setScript: playNoteScript)
		else
			(playNoteScript cue:)
		)
	)
)

(instance hsClam6 of HotSpot
	(properties
		nsLeft 172
		nsTop 95
		nsRight 194
		nsBottom 111
	)

	(method (doVerb)
		(local5 addToEnd: 5)
		(PrintDebug {list:%d 5} (local5 size:))
		(if (not (gCurRoom script:))
			(gCurRoom setScript: playNoteScript)
		else
			(playNoteScript cue:)
		)
	)
)

(instance hsClam7 of HotSpot
	(properties
		nsLeft 196
		nsTop 95
		nsRight 218
		nsBottom 111
	)

	(method (doVerb)
		(local5 addToEnd: 6)
		(PrintDebug {list:%d 6} (local5 size:))
		(if (not (gCurRoom script:))
			(gCurRoom setScript: playNoteScript)
		else
			(playNoteScript cue:)
		)
	)
)

(instance colossus of Prop
	(properties
		priority 5
		fixPriority 1
		view 12411
		cycleSpeed 20
	)
)

(instance bubbles of Prop
	(properties
		view 12410
		loop 7
		cycleSpeed 3
	)

	(method (init)
		(self setPri: 100 1 setCycle: Fwd)
		(switch local4
			(0
				(self posn: 69 72)
			)
			(1
				(self posn: 90 72)
				(= loop 8)
			)
			(2
				(self posn: 111 72)
			)
			(3
				(self posn: 130 72)
			)
			(4
				(self posn: 151 72)
				(= loop 8)
			)
			(5
				(self posn: 172 72)
			)
			(6
				(self posn: 192 72)
				(= loop 8)
			)
		)
		(super init: &rest)
	)
)

(instance clamClosed of View
	(properties
		view 12410
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100 setLoop: local4 1)
	)
)

(instance playNoteScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local6
					(= local6 0)
					(efBack dispose:)
					(= local2 0)
					(hsBack init:)
				)
				(if (local5 size:)
					(= local4 (local5 at: 0))
					(local5 delete: local4)
					(clamClosed init:)
					(bubbles init:)
				else
					(= local4 -1)
				)
				(if local0
					(gSounds stop: local0)
					(proc951_18 local0)
				)
				(if local1
					(gSounds fade: local1 0 6 6 0 0)
				)
				(= local0 local1)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(if (>= local4 0)
					(if (== local1 (+ 21201 local4))
						(= local0 0)
						(= cycles 1)
					else
						(= local1 (+ 21201 local4))
						(gSounds play: local1 -1 50 0)
						(PrintDebug
							{note:%d-%d (%d)}
							local4
							[local7 local2]
							local2
						)
						(if
							(and
								(not (IsFlag 9))
								(== local4 [local7 local2])
							)
							(if (== (++ local2) local3)
								(colossus init: setCycle: End)
								(SetFlag 9)
								(proc951_15 6750)
								(gSounds play: 11201 0 75 0)
								(= seconds 2)
							)
						else
							(= local2 0)
						)
					)
				else
					(= local1 0)
					(if local0
						(= seconds 2)
					else
						(= seconds 1)
					)
				)
			)
			(2
				(= seconds 0)
				(cond
					(local1
						(clamClosed dispose:)
						(bubbles dispose:)
						(= state -1)
						(= cycles 1)
					)
					(local0
						(= state -1)
						(= cycles 1)
					)
					(else
						(efBack init: 8)
						(= local6 1)
						(hsBack dispose:)
						(self dispose:)
					)
				)
			)
		)
	)
)

