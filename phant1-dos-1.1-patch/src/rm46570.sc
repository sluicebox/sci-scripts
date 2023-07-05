;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46570)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use Feature)
(use Actor)
(use System)

(public
	rm46570 0
)

(local
	local0
	local1
)

(instance rm46570 of ScaryRoom
	(properties
		picture 38120
	)

	(method (init &tmp temp0)
		(= temp0 (Str newWith: 2 {09}))
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
		(crank init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(westExit init: 4 approachVerbs: 0)
		(cond
			((IsFlag 135)
				(if (== gPrevRoomNum 46620)
					(= picture 38130)
				)
				(gCurRoom setScript: playBack)
			)
			((== gPrevRoomNum 46620)
				(= global165 10)
				(= picture 38130)
				(gCurRoom setScript: upLift)
			)
			((== gPrevRoomNum 46320)
				(= global165 7)
				(gCurRoom setScript: enterFromConserv)
			)
			(else
				(= picture 38130)
				(gCurRoom setScript: upLift)
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
				(= temp0 (Str newWith: 3 {99\r\n}))
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
				(if local1
					(= local1 0)
				else
					(proc45951_3)
				)
				(switch global179
					(1
						(self setScript: caughtScript self)
					)
					(2
						(self setScript: turnCrank self)
					)
					(3
						(self setScript: sJump self)
					)
					(4
						(self setScript: enterFromConserv self)
					)
					(5
						(self setScript: toConserv self)
					)
					(6
						(self setScript: upLift self)
					)
					(7
						(self setScript: runIntoDon self)
					)
					(8
						(self setScript: downLift self)
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
			(10
				(gCurRoom newRoom: 46620)
			)
			(15
				(gCurRoom newRoom: 46790)
			)
		)
	)
)

(instance runIntoDon of Script
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
					(proc1111_7 9562 -3 -22 0 -1 1)
					(gCurRoom drawPic: 38110)
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

(instance downLift of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff: 0)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {08}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(proc1111_7 9701 0 0 0 -1 1)
					(gCurRoom drawPic: 38130)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46620)
					)
				)
			)
		)
	)
)

(instance toConserv of Script
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
					(proc1111_7 9560 -39 -41 0 -1 1)
					(gCurRoom drawPic: 38110)
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

(instance enterFromConserv of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {04}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(proc1111_7 9550 0 -8 0 -1 1)
				)
				(1
					(if (IsFlag 135)
						(= local1 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(gGame handsOn:)
					)
				)
				(2
					(gGame handsOff:)
				)
				(3
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

(instance upLift of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {06}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(proc1111_7 9700 0 0 0)
				)
				(1
					(proc1111_7 9551 -12 -39 0 -1 1)
					(gCurRoom drawPic: 38120)
				)
				(2
					(if (IsFlag 135)
						(= local1 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(gGame handsOn:)
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

(instance caughtScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 135))
					(= temp2 (Str newWith: 2 {01}))
					((ScriptID 45951 2) writeString: temp2) ; chase_dat
					(temp2 dispose:)
				)
				(SetFlag 150)
				(= global125 0)
				(= global159 46570)
				(if (IsFlag 135)
					(self dispose:)
				else
					(gCurRoom newRoom: 46790)
				)
			)
		)
	)
)

(instance turnCrank of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(cond
			((IsFlag 390)
				(self dispose:)
			)
			((not global115)
				(switch (= state newState)
					(0
						(gGame handsOff:)
						(if (not (IsFlag 135))
							(= temp0 (Str newWith: 2 {02}))
							((ScriptID 45951 2) writeString: temp0) ; chase_dat
							(temp0 dispose:)
						)
						(proc1111_7 9561 71 1 0)
						(gCurRoom drawPic: 38110)
					)
					(1
						(proc1111_7 9570 0 0 0)
						(gCurRoom drawPic: 38130)
					)
					(2
						(proc1111_7 9580 81 12 0)
						(gCurRoom drawPic: 38140)
					)
					(3
						(proc1111_7 9571 0 0 0)
						(if (not (IsFlag 135))
							(gGame handsOn:)
						)
						(gCurRoom drawPic: 38130)
						(westExit dispose:)
						(crank dispose:)
						(southExit init: 13)
					)
					(4
						(if (IsFlag 135)
							(= local1 1)
							(proc45951_3)
							(if (!= global179 1)
								(self dispose:)
							)
						)
						(gGame handsOff:)
						(proc1111_7 9595 -9 -43 0 -1 1)
						(liftView init:)
						(gCurRoom drawPic: 38150)
					)
					(5
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
)

(instance sJump of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 311)
			(SetFlag 409)
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
					(southExit dispose:)
					(proc1111_7 9590 -12 -42 0 -1 1)
					(liftView init:)
					(gCurRoom drawPic: 38150)
				)
				(1
					(southExit init: 3)
					(SetFlag 311)
					(SetFlag 409)
					(= global125 1)
					(if (IsFlag 135)
						(= local1 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(gGame handsOn:)
						(= global118 0)
						(= global162 1)
					)
				)
				(2
					(ClearFlag 311)
					(ClearFlag 409)
					(gGame handsOff:)
				)
				(3
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

(instance crank of Feature
	(properties
		nsLeft 182
		nsTop 34
		nsRight 214
		nsBottom 90
		x 138
		y 109
		z 46
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (IsFlag 311)
				(gCurRoom setScript: downLift)
			else
				(gCurRoom setScript: turnCrank)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 5
		nsTop 50
		nsRight 320
		nsBottom 130
		approachX 128
		approachY 122
		x 128
		y 122
		nextRoom 46620
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (not (IsFlag 311))
				(gCurRoom setScript: sJump)
			else
				(gCurRoom newRoom: 46620)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		nsLeft 5
		nsTop 5
		nsRight 185
		nsBottom 134
		approachX 72
		approachY 78
		x 72
		y 78
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (not (IsFlag 311))
				(gCurRoom setScript: runIntoDon)
			else
				(gCurRoom setScript: toConserv)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance liftView of View
	(properties
		x 144
		y 117
		view 38150
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

