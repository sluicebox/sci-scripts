;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 811)
(include sci.sh)
(use Main)
(use n814)
(use PolyPath)
(use Game)
(use System)

(public
	Street 0
)

(local
	local0
	local1
)

(instance Street of Rgn
	(properties)

	(method (init)
		(if
			(and
				(not gNight)
				(or (!= (gLongSong number:) 93) (== (gLongSong prevSignal:) -1))
			)
			(gLongSong priority: 0 number: 93 loop: -1 play:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((== theVerb 52) ; Sleep
				(cond
					((< 700 gClock 2550)
						(gMessager say: 1 52 7 1 0 811) ; "You're too awake to sleep now."
					)
					((!= (gEgo onControl: 1) 1)
						(gMessager say: 1 52 5 1 0 811) ; "This doesn't look like a good place to curl up."
					)
					((== gCurRoomNum 334)
						(gEgo setScript: (ScriptID 88 0) self) ; SleepAllNight
					)
					(else
						(gEgo setScript: egoSleepsInStreet)
					)
				)
			)
			((or (== theVerb 17) (== theVerb 18)) ; lockPick, thiefKit
				(= temp0 (gEgo onControl: 1))
				(cond
					((not gNight)
						(gMessager say: 1 17 7 1 0 811) ; "In broad daylight? You've got to be kidding! You'd be arrested for certain."
					)
					((not [gEgoStats 9]) ; pick locks
						(gMessager say: 1 17 4 1 0 811) ; "You don't know how to pick locks."
					)
					((== temp0 16384)
						(gCurRoom notify: 1)
					)
					((or (== temp0 4096) (== temp0 1024) (== temp0 8192))
						(if (<= (Random 3 10) (++ local0))
							(EgoDead 151 152 1 0 503) ; "Uh oh. You made too much noise. The Sheriff and Otto arrive on the scene and arrest you for "criminal carelessness". Work a little faster next time!"
						else
							(TrySkill 9 0 0) ; pick locks
							(gMessager say: 1 17 2 1 0 811) ; "The door is securely barred from the inside, but you do get some practice."
						)
					)
					(else
						(gMessager say: 1 17 6 1 0 811) ; "There are no doors within reach."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoSleepsInStreet of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 1 52 8 1 self 811) ; "You curl up on the hard ground and try to get some rest."
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(switch gCurRoomNum
					(320
						(gEgo setMotion: PolyPath 159 168 self)
					)
					(330
						(gEgo setMotion: PolyPath 159 168 self)
					)
					(else
						(= ticks 20)
					)
				)
			)
			(2
				(gEgo setScript: (ScriptID 88 0) self) ; SleepAllNight
			)
			(3
				(= temp0 gCurRoomNum)
				(= gCurRoomNum 999)
				(= ticks 90)
			)
			(4
				(gCurRoom newRoom: temp0) ; UNINIT
			)
		)
	)
)

