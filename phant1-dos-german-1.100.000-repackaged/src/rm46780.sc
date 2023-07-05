;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46780)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use chap7Timer)
(use Str)
(use Feature)
(use Window)
(use System)

(public
	rm46780 0
)

(local
	local0
	local1
)

(instance rm46780 of ScaryRoom
	(properties)

	(method (init &tmp temp0)
		(= temp0 (Str newWith: 2 {20}))
		(cond
			((IsFlag 135)
				(gGame handsOff:)
			)
			((== gPrevRoomNum 900)
				((ScriptID 45951 2) open: 0) ; chase_dat
			)
			((IsFlag 151)
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
			)
			((IsFlag 150)
				(SetFlag 151)
				(proc45951_4)
				((ScriptID 45951 2) writeString: temp0) ; chase_dat
			)
			(else
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
			)
		)
		(temp0 dispose:)
		(SetFlag 151)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
		(if (IsFlag 135)
			(gCurRoom setScript: playBack)
		else
			(gCurRoom setScript: enterRoom)
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
		((ScriptID 26 2) dispose:) ; myHotSet
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
						(self setScript: enterRoom self)
					)
					(2
						(self setScript: rubbleDeath self)
					)
					(3
						(self setScript: toStairs self)
					)
					(4
						(self setScript: itEatsYourFace self)
					)
					(5
						(self setScript: grabPipe self)
					)
					(6
						(self setScript: jumpInPit self)
					)
					(7
						(self setScript: northEatFace self)
					)
					(8
						(self setScript: toTheatreDeath self)
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
			(12
				(gCurRoom newRoom: 40100)
			)
		)
	)
)

(instance enterRoom of Script
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
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1500.vmd}) ; Open
					(proc26_0 1500 self)
				)
				(2
					(= cycles 2)
				)
				(3
					(PlayVMD 0 {1501.vmd}) ; Open
					(if (not (IsFlag 135))
						(rubble init: setHotspot: 4 3) ; Do, Move
						(theatreExit init: 3)
						(ritualExit
							nsLeft: 142
							nsTop: 1
							nsRight: 244
							nsBottom: 127
							init: 2
						)
						((ScriptID 26 2) ; myHotSet
							add:
								(theatreRect setRect: theatreExit)
								(ritRect setRect: ritualExit)
								(rubbleRect setRect: rubble)
							activate:
						)
						(gGame handsOn:)
						(proc26_0 1501 self 1)
					else
						(proc26_0 1501 self)
					)
				)
				(4
					(= local0 1)
					(if (IsFlag 135)
						(self dispose:)
					else
						((ScriptID 26 2) dispose:) ; myHotSet
						(gCurRoom setScript: itEatsYourFace)
					)
				)
			)
		)
	)
)

(instance northEatFace of Script
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
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1720.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 1720 self)
				)
				(2
					(= local0 0)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: itEatsYourFace)
					)
				)
			)
		)
	)
)

(instance rubbleDeath of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (not (IsFlag 135))
						(gGame handsOff:)
						(= temp0 (Str newWith: 2 {02}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1600.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 1600 self)
				)
				(2
					(= local0 0)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: itEatsYourFace)
					)
				)
			)
		)
	)
)

(instance toStairs of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 157)
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
					(SetFlag 157)
					(rubble dispose:)
					(theatreExit dispose:)
					(ritualExit dispose:)
					((ScriptID 26 2) dispose:) ; myHotSet
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1530.vmd} 0) ; Open
					(proc26_0 1530 self)
				)
				(2
					(= cycles 2)
				)
				(3
					(PlayVMD 0 {1531.vmd} 0) ; Open
					(if (not (IsFlag 135))
						(pipe init: setHotspot: 4 3) ; Do, Move
						(hole init: setHotspot: 4 3) ; Do, Move
						(wayBack init: 13)
						((ScriptID 26 2) ; myHotSet
							add:
								(pipeRect setRect: pipe)
								(holeRect setRect: hole)
								(wayBackRect setRect: wayBack)
							activate:
						)
						(gGame handsOn:)
						(PlayVMD 16 1) ; ShowCursor
					)
					(proc26_0 1531 self 1)
				)
				(4
					(= local0 1)
					(gGame handsOff:)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: itEatsYourFace)
					)
				)
			)
		)
	)
)

(instance itEatsYourFace of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(if (IsFlag 390)
			(= global159 46780)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp1 (Str newWith: 2 {04}))
						((ScriptID 45951 2) writeString: temp1) ; chase_dat
						(temp1 dispose:)
					)
					(= cycles 2)
				)
				(1
					(if local0
						(PlayVMD 0 {1502.vmd} 0) ; Open
						(PlayVMD 16 0) ; ShowCursor
						(proc26_0 1502 self)
					else
						(self cue:)
					)
				)
				(2
					(= global159 46780)
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

(instance grabPipe of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(ClearFlag 157)
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
					(ClearFlag 157)
					((ScriptID 26 2) dispose:) ; myHotSet
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1740.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 1740 self)
				)
				(2
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 40100)
					)
				)
				(3
					(if (IsFlag 135)
						(self dispose:)
					else
						(self setScript: itEatsYourFace)
					)
				)
			)
		)
	)
)

(instance toTheatreDeath of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {08}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1520.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 1520 self)
				)
				(2
					(= local0 0)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: itEatsYourFace)
					)
				)
			)
		)
	)
)

(instance jumpInPit of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(if (IsFlag 390)
			(= global159 46780)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp1 (Str newWith: 2 {06}))
						((ScriptID 45951 2) writeString: temp1) ; chase_dat
						(temp1 dispose:)
					)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1730.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 1730 self)
				)
				(2
					(= global159 46780)
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

(instance rubble of Feature
	(properties
		nsLeft 70
		nsTop 19
		nsRight 133
		nsBottom 113
		x 101
		y 66
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Move
			((ScriptID 26 1) caller: 0 dispose:) ; movieScr
			(gCurRoom setScript: rubbleDeath)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance ritualExit of ExitFeature
	(properties
		nsLeft 150
		nsTop 6
		nsRight 196
		nsBottom 115
		x 173
		y 60
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			((ScriptID 26 1) caller: 0 dispose:) ; movieScr
			(gCurRoom setScript: toStairs)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theatreExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 100
		nsRight 320
		nsBottom 129
		x 102
		y 122
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			((ScriptID 26 1) caller: 0 dispose:) ; movieScr
			(gCurRoom setScript: toTheatreDeath)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pipe of Feature
	(properties
		nsLeft 60
		nsTop 2
		nsRight 130
		nsBottom 57
		x 41
		y 22
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Move
			((ScriptID 26 1) caller: 0 dispose:) ; movieScr
			(gCurRoom setScript: grabPipe)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance hole of Feature
	(properties
		nsLeft 110
		nsTop 77
		nsRight 320
		nsBottom 126
		x 194
		y 114
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Move
			((ScriptID 26 1) caller: 0 dispose:) ; movieScr
			(gCurRoom setScript: jumpInPit)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance wayBack of ExitFeature
	(properties
		nsLeft 2
		nsTop 3
		nsRight 36
		nsBottom 65
		x 66
		y 94
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			((ScriptID 26 1) caller: 0 dispose:) ; movieScr
			(gCurRoom setScript: northEatFace)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theatreRect of HotRectangle
	(properties)
)

(instance ritRect of HotRectangle
	(properties)
)

(instance rubbleRect of HotRectangle
	(properties)
)

(instance pipeRect of HotRectangle
	(properties)
)

(instance holeRect of HotRectangle
	(properties)
)

(instance wayBackRect of HotRectangle
	(properties)
)

