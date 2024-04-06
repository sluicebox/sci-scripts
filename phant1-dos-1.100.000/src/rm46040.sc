;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46040)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use System)

(public
	rm46040 0
)

(local
	local0
)

(instance rm46040 of ScaryRoom
	(properties
		picture 15210
		stepSound 4
	)

	(method (init &tmp temp0)
		(= temp0 (Str newWith: 2 {03}))
		(cond
			((and (not (IsFlag 135)) (IsFlag 150))
				(ClearFlag 150)
				(proc45951_4)
				((ScriptID 45951 2) writeString: temp0) ; chase_dat
			)
			((not (IsFlag 135))
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
			)
		)
		(temp0 dispose:)
		(nurseryDoor init: 4)
		(ClearFlag 131)
		(if (OneOf global165 1 4 5)
			(= global165 2)
		)
		(northExit init: 1 approachVerbs: 0)
		(southExit init: 3 approachVerbs: 0)
		(cond
			((IsFlag 135)
				(gCurRoom setScript: playBack)
			)
			((== gPrevRoomNum 46290)
				(gCurRoom setScript: enterFromSouth)
			)
			((and (== gPrevRoomNum 46340) (IsFlag 18))
				(Load 140 10672) ; WAVE
				(Lock 140 10672 1) ; WAVE
				(gCurRoom setScript: escapeNursery)
			)
			(else
				(gCurRoom setScript: enterFromNorth)
			)
		)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(gGDacSound stop:)
		(Lock 140 10672 0) ; WAVE
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
						(self setScript: toSecondFloor self)
					)
					(3
						(self setScript: sToNursery self)
					)
					(4
						(self setScript: sSouthToHall self)
					)
					(5
						(self setScript: enterFromSouth self)
					)
					(6
						(self setScript: escapeNursery self)
					)
					(7
						(self setScript: enterFromNorth self)
					)
					(8
						(self setScript: deadAtTheBottom self)
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
			(2
				(gCurRoom newRoom: 46030)
			)
			(6
				(gCurRoom newRoom: 46290)
			)
			(8
				(gCurRoom newRoom: 46340)
			)
			(15
				(gCurRoom newRoom: 46790)
			)
		)
	)
)

(instance enterFromNorth of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {07}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9312 -7 -39 0 -1 1)
				)
				(1
					(if (IsFlag 135)
						(= local0 1)
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

(instance deadAtTheBottom of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gGDacSound stop:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {08}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9303 -7 -42 0 -1 1)
					(gCurRoom drawPic: 13440)
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

(instance escapeNursery of Script
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
					(gGDacSound number: 10672 setLoop: -1 play:)
					(DoRobot 9203 29 -31 0 -1 1)
				)
				(1
					(if (IsFlag 135)
						(= local0 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(gGame handsOn:)
					)
				)
				(2
					(gGDacSound stop:)
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

(instance enterFromSouth of Script
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
					(DoRobot 9202 -5 -41 0 200 1)
				)
				(1
					(if (not (IsFlag 135))
						(gGame handsOn:)
					else
						(= local0 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
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

(instance caughtScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 135))
					(= temp0 (Str newWith: 2 {01}))
					((ScriptID 45951 2) writeString: temp0) ; chase_dat
					(temp0 dispose:)
				)
				(SetFlag 150)
				(= global159 46040)
				(if (IsFlag 135)
					(self dispose:)
				else
					(gCurRoom newRoom: 46790)
				)
			)
		)
	)
)

(instance toSecondFloor of Script
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
					(DoRobot 9210 0 -40 0 -1 1)
					(gCurRoom drawPic: 15220 picture: 15220)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46030)
					)
				)
			)
		)
	)
)

(instance sToNursery of Script
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
					(if (== (gCurRoom picture:) 15220)
						(DoRobot 9221 -14 -34 0 -1 1)
						(gCurRoom drawPic: 15230 picture: 15230)
					else
						(DoRobot 9211 27 -34 0 -1 1)
						(gCurRoom drawPic: 15220 picture: 15220)
					)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46340)
					)
				)
			)
		)
	)
)

(instance sSouthToHall of Script
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

(instance nurseryDoor of ExitFeature
	(properties
		nsLeft 100
		nsTop 5
		nsRight 131
		nsBottom 96
		approachX 132
		approachY 93
		x 120
		y 76
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sToNursery)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 134
		nsTop 5
		nsRight 177
		nsBottom 97
		nextRoom 46090
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (gEgo has: 16) ; invSpellBook
				(KillRobot 0 0)
				(gCurRoom setScript: deadAtTheBottom)
			else
				(KillRobot 0 0)
				(gCurRoom setScript: toSecondFloor)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 5
		nsTop 98
		nsRight 320
		nsBottom 132
		nextRoom 46290
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(KillRobot 0 0)
			(gCurRoom newRoom: 46290)
		else
			(super doVerb: theVerb)
		)
	)
)

