;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46980)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use System)

(public
	rm46980 0
)

(local
	local0
)

(instance rm46980 of ScaryRoom
	(properties
		picture 6591
		stepSound 4
	)

	(method (init &tmp temp0)
		(= temp0 (Str newWith: 2 {17}))
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
		(eastExit init: 2 approachVerbs: 0)
		(westExit init: 4 approachVerbs: 0)
		(cond
			((IsFlag 135)
				(if (== gPrevRoomNum 46720)
					(= picture 6570)
				else
					(= picture 6580)
				)
				(gCurRoom setScript: playBack)
			)
			((== gPrevRoomNum 46720)
				(= global165 18)
				(= picture 6570)
				(self setScript: enterFromLeft)
			)
			(else
				(= global165 13)
				(= picture 6580)
				(self setScript: enterFromRight)
			)
		)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
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

(instance exitLeft of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {04}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9791 69 9 0 -1 1)
					(gCurRoom drawPic: 6570)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46720)
					)
				)
			)
		)
	)
)

(instance leftCaught of Script
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
					(DoRobot 9792 70 17 0 -1 1)
					(gCurRoom drawPic: 6570)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance enterFromRight of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {06}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9802 -3 25 0)
				)
				(1
					(DoRobot 9785 -12 -41 0 -1 1)
					(gCurRoom drawPic: 6591)
				)
				(2
					(if (IsFlag 135)
						(= local0 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(gGame handsOn: 0)
					)
				)
				(3
					(gGame handsOff:)
				)
				(4
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance enterFromLeft of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {03}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9790 38 -36 0)
				)
				(1
					(DoRobot 9784 -12 -41 0 -1 1)
					(gCurRoom drawPic: 6591)
				)
				(2
					(if (IsFlag 135)
						(= local0 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(gGame handsOn: 0)
					)
				)
				(3
					(gGame handsOff:)
				)
				(4
					(if (not (IsFlag 135))
						(gCurRoom setScript: caughtScript)
					else
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance playBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(= local0 0)
				else
					(proc45951_3)
				)
				(switch global179
					(1
						(self setScript: caughtScript self)
					)
					(2
						(self setScript: leftCaught self)
					)
					(3
						(self setScript: enterFromLeft self)
					)
					(4
						(self setScript: exitLeft self)
					)
					(5
						(self setScript: exitRight self)
					)
					(6
						(self setScript: enterFromRight self)
					)
					(7
						(self setScript: rightCaught self)
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
			(18
				(gCurRoom newRoom: 47020)
			)
			(11
				(gCurRoom newRoom: 46630)
			)
			(13
				(gCurRoom newRoom: 46720)
			)
			(15
				(gCurRoom newRoom: 46790)
			)
		)
	)
)

(instance caughtScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2)
		(if (IsFlag 390)
			(SetFlag 150)
			(= global159 46980)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp2 (Str newWith: 2 {01}))
						((ScriptID 45951 2) writeString: temp2) ; chase_dat
						(temp2 dispose:)
					)
					(SetFlag 150)
					(if (and (IsFlag 142) (== gPrevRoomNum 47020))
						(= global159 47020)
					else
						(= global159 46980)
					)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46790)
					)
				)
			)
		)
	)
)

(instance exitRight of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {05}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9800 -8 -42 0 -1 1)
					(gCurRoom drawPic: 6580)
				)
				(1
					(if (not (IsFlag 135))
						(gCurRoom newRoom: 47020)
					else
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance rightCaught of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {07}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9801 13 16 0 -1 1)
					(gCurRoom drawPic: 6580)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 172
		nsTop 1
		nsRight 292
		nsBottom 129
		approachX 232
		approachY 65
		x 232
		y 65
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (or (== gPrevRoomNum 47020) (IsFlag 142))
				(gCurRoom setScript: rightCaught)
			else
				(gCurRoom setScript: exitRight)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		nsLeft 1
		nsTop 0
		nsRight 71
		nsBottom 129
		sightAngle 40
		approachX 131
		approachY 61
		x 131
		y 61
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (== gPrevRoomNum 46720)
				(gCurRoom setScript: leftCaught)
			else
				(gCurRoom setScript: exitLeft)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

