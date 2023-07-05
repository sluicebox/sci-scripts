;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm46100 0
)

(local
	local0
	local1
	local2
)

(instance rm46100 of ScaryRoom
	(properties
		picture 3820
		stepSound 7
	)

	(method (init &tmp temp0)
		(= temp0 (Str newWith: 2 {05}))
		(cond
			((IsFlag 135))
			((== gPrevRoomNum 900)
				((ScriptID 45951 2) open: 0) ; chase_dat
			)
			((IsFlag 150)
				(= global165 0)
				(ClearFlag 150)
				(proc45951_4)
				((ScriptID 45951 2) writeString: temp0) ; chase_dat
			)
			(else
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
			)
		)
		(temp0 dispose:)
		(Load rsVIEW 6120)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
		(cond
			((IsFlag 135)
				(gCurRoom setScript: playBack)
			)
			((== gPrevRoomNum 900)
				(= global165 5)
			)
			((== gPrevRoomNum 46790)
				(= global165 5)
			)
			(else
				(= global165 5)
			)
		)
		(southExit init: 3 approachVerbs: 0)
		(stairs init: 1 approachVerbs: 0)
		(westExit init: 4 approachVerbs: 0)
		(if (not (IsFlag 135))
			(gCurRoom setScript: sDwnStairs)
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
						(self setScript: dawdle self)
					)
					(3
						(self setScript: sDwnStairs self)
					)
					(4
						(self setScript: sUpTheStairs self)
					)
					(5)
					(6
						(self setScript: caughtFromLib self)
					)
					(7
						(self setScript: sDoor self)
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
			(4
				(gCurRoom newRoom: 46050)
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
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 135))
					(= temp2 (Str newWith: 2 {01}))
					((ScriptID 45951 2) writeString: temp2) ; chase_dat
					(temp2 dispose:)
				)
				(SetFlag 150)
				(if (or (not (gEgo has: 5)) (IsFlag 140)) ; invHammer
					(= global159 46030)
				else
					(= global159 46100)
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

(instance sDwnStairs of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(if (not (IsFlag 140))
				(SetFlag 140)
			)
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
					(ClearFlag 131)
					(if (IsFlag 140)
						(proc1111_7 9421 -11 -18 0 -1 1)
					else
						(proc1111_7 9411 -11 -26 0 -1 1)
					)
				)
				(1
					(cond
						((IsFlag 140)
							(if (IsFlag 135)
								(self dispose:)
							else
								(gCurRoom setScript: caughtScript)
							)
						)
						((IsFlag 135)
							(= local1 1)
							(proc45951_3)
							(if (!= global179 1)
								(SetFlag 140)
								(self dispose:)
							)
						)
						(else
							(SetFlag 140)
							(gGame handsOn:)
						)
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

(instance sUpTheStairs of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not local2)
						(proc1111_6 0 0)
					)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {04}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if local2
						(proc1111_7 9420 -10 -36 0 -1 1)
						(if (gCast contains: door3830)
							(door3830 dispose:)
						)
						(if (gCast contains: door3940)
							(door3940 dispose:)
						)
						(gCurRoom drawPic: 3820)
					else
						(gEgo
							view: 6120
							x: 154
							y: 76
							init:
							cycleSpeed: 8
							setCycle: End self
						)
						(if (gCast contains: door3830)
							(door3830 dispose:)
						)
						(if (gCast contains: door3940)
							(door3940 dispose:)
						)
						(gCurRoom drawPic: 3890)
					)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46050)
					)
				)
			)
		)
	)
)

(instance caughtFromLib of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 150)
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
					(proc1111_7 9410 -37 -37 0 -1 1)
					(if (gCast contains: door3830)
						(door3830 dispose:)
					)
					(if (gCast contains: door3940)
						(door3940 dispose:)
					)
					(gCurRoom drawPic: 3925)
				)
				(1
					(SetFlag 150)
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

(instance dawdle of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= local2 1)
					(westExit
						nsTop: 83
						nsBottom: 134
						nsRight: 319
						nsLeft: 0
						exitDir: 3
					)
					(southExit dispose:)
					(stairs nsLeft: 0 nsRight: 73 nsTop: 0 nsBottom: 117)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {02}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(proc1111_7 9247 -38 -14 0 -1 1)
				)
				(1
					(if (IsFlag 135)
						(= local1 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(gGame handsOn: 0)
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

(instance sDoor of Script
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
					(if (gCast contains: door3940)
						(door3940 dispose:)
					)
					(gGDacSound stop:)
					(door3830 init:)
					(proc1111_7 5941 77 22 0)
					(gCurRoom drawPic: 3830)
				)
				(1
					(door3830 dispose:)
					(door3940 init:)
					(gCurRoom drawPic: 3940)
					(if (not (IsFlag 135))
						(gGame handsOn: 0)
						(gCurRoom setScript: dawdle)
					)
					(gGDacSound number: 10671 play:)
					(self dispose:)
				)
			)
		)
	)
)

(instance frontDoor of Feature ; UNUSED
	(properties
		nsLeft 230
		nsTop 49
		nsRight 320
		nsBottom 101
		sightAngle 40
		approachX 196
		approachY 98
		x 190
		y 187
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sDoor)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 0
		nsRight 73
		nsBottom 117
		approachX 36
		approachY 58
		x 36
		y 58
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: caughtFromLib)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 83
		nsRight 319
		nsBottom 134
		x 51
		y 135
		interRoom 15
		appYOffset 20
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sDoor)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance stairs of ExitFeature
	(properties
		nsLeft 125
		nsTop -1
		nsRight 245
		nsBottom 117
		approachX 185
		approachY 58
		x 185
		y 58
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(gCurRoom setScript: sUpTheStairs)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door3830 of View
	(properties
		x 157
		y 44
		view 3831
	)
)

(instance door3940 of View
	(properties
		x 229
		y 8
		view 3940
	)
)

