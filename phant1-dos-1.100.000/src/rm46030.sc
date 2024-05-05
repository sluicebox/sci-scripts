;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46030)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use Actor)
(use System)

(public
	rm46030 0
)

(local
	local0
	local1
)

(instance rm46030 of ScaryRoom
	(properties
		picture 13420
		stepSound 4
	)

	(method (init &tmp temp0 [temp1 2])
		(= temp0 (Str newWith: 2 {02}))
		(cond
			((IsFlag 135)
				(gCurRoom setScript: playBack)
			)
			((or (not (IsFlag 130)) (IsFlag 151))
				(temp0 dispose:)
				(= temp0 (Str newWith: 13 {0102041499\0d\n02}))
				((ScriptID 45951 2) open: 2 writeString: temp0) ; chase_dat
				(ClearFlag 151)
				(ClearFlag 150)
				(= gPrevRoomNum 45950)
			)
			((IsFlag 150)
				(ClearFlag 150)
				(proc45951_4)
				((ScriptID 45951 2) writeString: temp0) ; chase_dat
			)
			((== gPrevRoomNum 900)
				((ScriptID 45951 2) open: 0) ; chase_dat
			)
			(else
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
			)
		)
		(Load 140 10672) ; WAVE
		(Lock 140 10672 1) ; WAVE
		(global114 play: 10671)
		(temp0 dispose:)
		(cond
			((OneOf global165 6 8)
				(= global165 3)
			)
			((== global165 5)
				(= global165 4)
			)
		)
		(darkroomDoor init: 4)
		(southExit init: 3 approachVerbs: 0)
		(eastExit init: 2 approachVerbs: 0)
		(cond
			((IsFlag 135)
				(if (== gPrevRoomNum 46040)
					(= picture 13440)
				)
			)
			((== gPrevRoomNum 45950)
				(gCurRoom setScript: sEnterRoom)
			)
			((== gPrevRoomNum 46050)
				(gCurRoom setScript: fromSouth)
			)
			((== gPrevRoomNum 46790)
				(gCurRoom setScript: sEnterRoom)
			)
			(else
				(= picture 13440)
				(gCurRoom setScript: downTheStairs)
			)
		)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
		(if (not (gCurRoom script:))
			(gGame handsOn: 0)
		)
	)

	(method (cue)
		(if (and (not (IsFlag 135)) (not (gCurRoom script:)))
			(gCurRoom setScript: caughtScript)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(if (and (not (== newRoomNumber 46790)) (not (IsFlag 130)))
			(SetFlag 130)
		)
		(gGDacSound stop:)
		(Lock 140 10672 0) ; WAVE
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
		(super newRoom: newRoomNumber &rest)
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
						(self setScript: sEnterRoom self)
					)
					(2
						(self setScript: toDarkRoom self)
					)
					(3
						(self setScript: caughtScript self)
					)
					(4
						(self setScript: upTheStairs self)
					)
					(5
						(self setScript: enterDarkroom self)
					)
					(6
						(self setScript: downTheStairs self)
					)
					(7
						(self setScript: fromSouth self)
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
			(1
				(gCurRoom newRoom: 45950)
			)
			(3
				(gCurRoom newRoom: 46040)
			)
			(4
				(gCurRoom newRoom: 46050)
			)
			(15
				(gCurRoom newRoom: 46790)
			)
		)
	)
)

(instance fromSouth of Script
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
					(DoRobot 9300 -2 -33 0 -1 1)
				)
				(1
					(if (IsFlag 135)
						(= local1 1)
						(proc45951_3)
						(if (!= global179 3)
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

(instance downTheStairs of Script
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
					(DoRobot 9304 -1 -48 0)
				)
				(1
					(DoRobot 9301 -2 -35 0 -1 1)
					(gCurRoom drawPic: 13420 picture: 13420)
				)
				(2
					(if (IsFlag 135)
						(= local1 1)
						(proc45951_3)
						(if (!= global179 3)
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

(instance upTheStairs of Script
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
					(gGDacSound stop:)
					(if (and (gEgo has: 5) (!= gPrevRoomNum 46050)) ; invHammer
						(DoRobot 9270 -18 -41 0 -1 1)
					else
						(DoRobot 9271 -13 -37 0 -1 1)
					)
					(gCurRoom drawPic: 13440 picture: 13440)
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

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			((ScriptID 45951 1) doit:) ; checkInv
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
					(cond
						((IsFlag 67)
							(ClearFlag 67)
							(= local0 1)
							(DoRobot 9253 0 -42 0 -1 1)
						)
						((not (IsFlag 130))
							(gGDacSound number: 10672 setLoop: -1 play:)
							(DoRobot 9252 59 -40 0 -1 1)
						)
						(else
							(DoRobot 9302 -6 -43 0 -1 1)
						)
					)
				)
				(1
					((ScriptID 45951 1) doit: self) ; checkInv
				)
				(2
					(cond
						((IsFlag 135)
							(= local1 1)
							(proc45951_3)
							(if (!= global179 3)
								(self dispose:)
							)
						)
						((not (IsFlag 143))
							(gGame handsOn:)
						)
					)
				)
				(3
					(gGDacSound stop:)
					(gGame handsOff:)
				)
				(4
					(if local0
						(SetFlag 67)
					)
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

(instance book of View
	(properties
		x 147
		y 70
		view 13450
	)
)

(instance toDarkRoom of Script
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
					(gGDacSound stop:)
					(if (and (== gPrevRoomNum 45950) (gEgo has: 16)) ; invSpellBook
						(DoRobot 9261 0 0 0 -1 1)
					else
						(DoRobot 9260 -12 -20 0 -1 1)
					)
					(if (not (gEgo has: 16)) ; invSpellBook
						(book init: setPri: 0)
					)
					(gCurRoom drawPic: 13450 picture: 13450)
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

(instance enterDarkroom of Script
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
					(DoRobot 9262 -4 -7 0 -1 1)
					(if (not (gEgo has: 16)) ; invSpellBook
						(book init: setPri: 0)
					)
					(gCurRoom drawPic: 13450 picture: 13450)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 45950)
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
					(= temp2 (Str newWith: 2 {03}))
					((ScriptID 45951 2) writeString: temp2) ; chase_dat
					(temp2 dispose:)
				)
				(SetFlag 150)
				(= global159 46030)
				(if (IsFlag 135)
					(self dispose:)
				else
					(gCurRoom newRoom: 46790)
				)
			)
		)
	)
)

(instance darkroomDoor of ExitFeature
	(properties
		nsLeft 74
		nsTop 45
		nsRight 100
		nsBottom 113
		approachX 86
		approachY 123
		x 86
		y 113
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(if (or (gEgo has: 16) (== global165 1) (IsFlag 151)) ; invSpellBook
					(gCurRoom setScript: toDarkRoom)
				else
					(gCurRoom setScript: enterDarkroom)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 5
		nsTop 70
		nsRight 193
		nsBottom 134
		x 160
		y 100
		nextRoom 46050
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 193
		nsTop 0
		nsRight 307
		nsBottom 134
		x 299
		y 69
		appXOffset 20
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (== (gCurRoom picture:) 13440)
				(gCurRoom newRoom: 46040)
			else
				(gCurRoom setScript: upTheStairs)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

