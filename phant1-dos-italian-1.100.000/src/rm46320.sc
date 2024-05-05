;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46320)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use Feature)
(use System)

(public
	rm46320 0
)

(local
	local0
)

(instance rm46320 of ScaryRoom
	(properties
		picture 16290
	)

	(method (init &tmp temp0)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
		(= temp0 (Str newWith: 2 {07}))
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
		(southExit init: 2 approachVerbs: 0 setHotspot: 21 3 10 11 27) ; Exit, Move, invPoker, invHammer, invCutter
		(secretPanel init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(couch init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(cond
			((IsFlag 135)
				(gCurRoom setScript: playBack)
			)
			((== gPrevRoomNum 46290)
				(= global165 6)
				(self setScript: enterFromHall)
			)
			((== gPrevRoomNum 46570)
				(= global165 9)
				(self setScript: fromPassage)
			)
			(else
				(gGame handsOn: 0)
			)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(if (== newRoomNumber 46790)
			(= global159 46320)
		)
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
				(if local0
					(= local0 0)
				else
					(proc45951_3)
				)
				(switch global179
					(1
						(self setScript: hideCouch self)
					)
					(2
						(self setScript: passageOpen self)
					)
					(3
						(self setScript: caughtScript self)
					)
					(4
						(self setScript: pokeDon self)
					)
					(5
						(self setScript: hammerDon self)
					)
					(6
						(self setScript: stabDon self)
					)
					(7)
					(8
						(self setScript: toHall self)
					)
					(9
						(self setScript: hallDeath self)
					)
					(10
						(self setScript: enterFromHall self)
					)
					(11
						(self setScript: fromPassage self)
					)
					(12
						(self setScript: caughtFromPillar self)
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
			(6
				(gCurRoom newRoom: 46290)
			)
			(9
				(gCurRoom newRoom: 46570)
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

(instance fromPassage of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {11}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9501 170 43 0 130 1)
				)
				(1
					(if (IsFlag 135)
						(= local0 1)
						(proc45951_3)
						(if (!= global179 3)
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

(instance caughtFromPillar of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {12}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9531 -1 -42 0 -1 1)
					(gCurRoom drawPic: 16285)
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

(instance hallDeath of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {09}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9540 46 25 0 -1 1)
					(gCurRoom drawPic: 16260)
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

(instance enterFromHall of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {10}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9500 143 35 0 -1 1)
				)
				(1
					(if (IsFlag 135)
						(= local0 1)
						(proc45951_3)
						(if (!= global179 3)
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

(instance hideCouch of Script
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
					(DoRobot 9545 0 -44 0)
					(gCurRoom drawPic: 16260)
				)
				(1
					(DoRobot 9510 -6 -41 0 200 1)
					(gCurRoom drawPic: 16270)
				)
				(2
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

(instance passageOpen of Script
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
					(DoRobot 9546 -5 -42 0)
					(gCurRoom drawPic: 16260)
				)
				(1
					(DoRobot 9520 0 0 0 -1 1)
					(gCurRoom drawPic: 16296)
				)
				(2
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46570)
					)
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
					(= temp0 (Str newWith: 2 {03}))
					((ScriptID 45951 2) writeString: temp0) ; chase_dat
					(temp0 dispose:)
				)
				(SetFlag 150)
				(= global159 46320)
				(if (IsFlag 135)
					(self dispose:)
				else
					(gCurRoom newRoom: 46790)
				)
			)
		)
	)
)

(instance pokeDon of Script
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
						(= temp0 (Str newWith: 2 {04}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9543 -8 -42 0 -1 1)
					(gCurRoom drawPic: 16260)
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

(instance hammerDon of Script
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
					(DoRobot 9542 -10 -42 0 -1 1)
					(gCurRoom drawPic: 16260)
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

(instance stabDon of Script
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
					(DoRobot 9544 -10 -45 0 -1 1)
					(gCurRoom drawPic: 16260)
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

(instance toHall of Script
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
					(DoRobot 9541 48 26 0 -1 1)
					(gCurRoom drawPic: 16260)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46290)
					)
				)
			)
		)
	)
)

(instance secretPanel of Feature
	(properties
		nsLeft 183
		nsTop 54
		nsRight 213
		nsBottom 111
		approachX 198
		approachY 82
		x 236
		y 89
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 3 4) ; Move, Do
				(gCurRoom setScript: passageOpen)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance couch of Feature
	(properties
		nsLeft 1
		nsTop 35
		nsRight 39
		nsBottom 63
		approachX 42
		approachY 67
		x 20
		y 49
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 4) ; Move, Do
			(gCurRoom setScript: hideCouch)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 274
		nsTop 68
		nsRight 294
		nsBottom 129
		approachX 284
		approachY 98
		x 284
		y 98
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(if (== global165 6)
					(gCurRoom setScript: hallDeath)
				else
					(gCurRoom setScript: toHall)
				)
			)
			(10 ; invPoker
				(gCurRoom setScript: pokeDon)
			)
			(11 ; invHammer
				(gCurRoom setScript: hammerDon)
			)
			(27 ; invCutter
				(gCurRoom setScript: stabDon)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

