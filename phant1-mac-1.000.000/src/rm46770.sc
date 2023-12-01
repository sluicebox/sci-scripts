;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46770)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use Feature)
(use System)

(public
	rm46770 0
)

(instance rm46770 of ScaryRoom
	(properties
		picture 100
	)

	(method (init &tmp temp0)
		(= temp0 (Str newWith: 2 {14}))
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
		(theatreExit init: setHotspot: 4 3) ; Do, Move
		(if (IsFlag 151)
			(= picture 110)
		)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
		(southExit init: 3 approachVerbs: 0)
		(cond
			((IsFlag 135)
				(gCurRoom setScript: playBack)
			)
			((== gPrevRoomNum 46790)
				(= global165 15)
				(self setScript: fromTheatre)
			)
			((== gPrevRoomNum 46630)
				(= global165 11)
				(self setScript: toTheatre)
			)
			((== gPrevRoomNum 46790)
				(self setScript: fromTheatre)
			)
			(else
				(self setScript: toTheatre)
			)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(cond
			((== newRoomNumber 91) ; saveRest
				((ScriptID 45951 2) close:) ; chase_dat
			)
			((not (IsFlag 135))
				(= temp0 (Str newWith: 3 {99\r\n}))
				((ScriptID 45951 2) writeString: temp0 close:) ; chase_dat
				(temp0 dispose:)
			)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance toTheatre of Script
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
					(DoRobot 9680 2 -43 0 -1 1)
				)
				(1
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

(instance toInterSection of Script
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
					(DoRobot 9681 -7 -41 0 -1 1)
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

(instance fromTheatre of Script
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
					(DoRobot 9684 -9 -43 0 -1 1)
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

(instance playBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc45951_3)
				(switch global179
					(2
						(self setScript: toTheatre self)
					)
					(3
						(self setScript: toInterSection self)
					)
					(4
						(self setScript: fromTheatre self)
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
			(15
				(gCurRoom newRoom: 46790)
			)
			(11
				(gCurRoom newRoom: 46630)
			)
		)
	)
)

(instance theatreExit of Feature
	(properties
		nsLeft 153
		nsTop 33
		nsRight 195
		nsBottom 82
		approachX 174
		approachY 57
		x 184
		y 83
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom newRoom: 46790)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 5
		nsTop 83
		nsRight 300
		nsBottom 134
		approachX 110
		approachY 124
		x 173
		y 126
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: toInterSection)
		else
			(super doVerb: theVerb)
		)
	)
)

