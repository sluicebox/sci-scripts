;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46720)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use Feature)
(use System)

(public
	rm46720 0
)

(local
	local0
)

(instance rm46720 of ScaryRoom
	(properties
		picture 490
	)

	(method (init &tmp temp0)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
		(= temp0 (Str newWith: 2 {13}))
		(cond
			((IsFlag 135))
			((== gPrevRoomNum 900)
				((ScriptID 45951 2) open: 0) ; chase_dat
			)
			((IsFlag 150)
				(ClearFlag 150)
				(proc45951_4)
				((ScriptID 45951 2) writeString: temp0) ; chase_dat
			)
			(else
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
			)
		)
		(temp0 dispose:)
		(chapelExit init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
		(southExit init: 3)
		(cond
			((IsFlag 135)
				(gCurRoom setScript: playBack)
			)
			((== gPrevRoomNum 46630)
				(= global165 11)
				(if (not script)
					(gCurRoom setScript: toChapel)
				)
			)
			((== gPrevRoomNum 46980)
				(= global165 17)
				(self setScript: fromChapel)
			)
			(else
				(self setScript: fromChapel)
			)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(cond
			((== newRoomNumber 91) ; saveRest
				((ScriptID 45951 2) close:) ; chase_dat
			)
			((not (IsFlag 135))
				(= temp0 (Str newWith: 3 {99\0d\n}))
				((ScriptID 45951 2) writeString: temp0 close:) ; chase_dat
				(temp0 dispose:)
			)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance playBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc45951_3)
				(switch global179
					(2
						(self setScript: toChapel self)
					)
					(3
						(self setScript: fromChapel self)
					)
					(99
						(gCurRoom setScript: playNextRoom)
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

(instance playNextRoom of Script
	(properties)

	(method (changeState)
		(proc45951_3)
		(proc45951_3)
		(switch global179
			(17
				(gCurRoom newRoom: 46980)
			)
			(11
				(gCurRoom newRoom: 46630)
			)
			(15
				(gCurRoom newRoom: 46790)
			)
		)
	)
)

(instance toChapel of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {02}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9670 20 -22 0 -1 1)
				)
				(1
					(if (not (IsFlag 135))
						(gCurRoom newRoom: 46980)
					else
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance fromChapel of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {03}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9671 -5 -42 0 -1 1)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46630)
					)
				)
			)
		)
	)
)

(instance chapelExit of Feature
	(properties
		nsLeft 122
		nsTop 6
		nsRight 175
		nsBottom 101
		x 148
		y 53
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: toChapel)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 5
		nsTop 100
		nsRight 320
		nsBottom 134
		approachX 110
		approachY 124
		x 173
		y 126
		nextRoom 46720
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom newRoom: 46630)
		else
			(super doVerb: theVerb)
		)
	)
)

