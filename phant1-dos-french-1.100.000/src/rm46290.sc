;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46290)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use Feature)
(use User)
(use System)

(public
	rm46290 0
)

(instance rm46290 of ScaryRoom
	(properties
		picture 15240
	)

	(method (init &tmp temp0)
		(= temp0 (Str newWith: 2 {06}))
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
		(conservatory init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
		(southExit init: 3 approachVerbs: 0)
		((ScriptID 45951 0) setReal: gCurRoom 30) ; chap7Timer
		(cond
			((== global165 9)
				(= global165 7)
			)
			((OneOf global165 2 8)
				(= global165 3)
			)
		)
		(cond
			((IsFlag 135)
				(gCurRoom setScript: playBack)
			)
			((== gPrevRoomNum 46320)
				(gCurRoom setScript: sToNorthHall)
			)
			(else
				(gCurRoom setScript: sToConserv)
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

	(method (cue)
		(if (not (gCurRoom script:))
			(gCurRoom setScript: caughtScript)
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
						(self setScript: sEnterRoom self)
					)
					(2
						(self setScript: caughtScript self)
					)
					(3
						(self setScript: sToConserv self)
					)
					(4
						(self setScript: sToNorthHall self)
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
			(7
				(gCurRoom newRoom: 46320)
			)
			(3
				(gCurRoom newRoom: 46040)
			)
			(15
				(gCurRoom newRoom: 46790)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {01}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if (not (IsFlag 135))
						(gGame handsOn:)
						(User canControl: 0)
					)
					(self dispose:)
				)
			)
		)
	)
)

(instance caughtScript of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 2])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 135))
					(= temp0 (Str newWith: 2 {02}))
					((ScriptID 45951 2) writeString: temp0) ; chase_dat
					(temp0 dispose:)
				)
				(SetFlag 150)
				(= global159 46290)
				(if (IsFlag 135)
					(self dispose:)
				else
					(gCurRoom newRoom: 46790)
				)
			)
		)
	)
)

(instance sToConserv of Script
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
					(DoRobot 9230 -10 -38 0)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46320)
					)
				)
			)
		)
	)
)

(instance sToNorthHall of Script
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
					(DoRobot 9231 -10 -38 0)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46040)
					)
				)
			)
		)
	)
)

(instance conservatory of Feature
	(properties
		nsLeft 150
		nsTop 5
		nsRight 180
		nsBottom 100
		approachX 135
		approachY 90
		x 125
		y 73
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sToConserv)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 5
		nsTop 101
		nsRight 320
		nsBottom 134
		nextRoom 46040
		appYOffset 50
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sToNorthHall)
		else
			(super doVerb: theVerb)
		)
	)
)

