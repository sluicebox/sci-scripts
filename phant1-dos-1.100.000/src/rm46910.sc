;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46910)
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
	rm46910 0
)

(local
	local0
	local1
	[local2 7]
	local9
)

(instance rm46910 of ScaryRoom
	(properties
		picture 27250
		stepSound 4
	)

	(method (init &tmp temp0)
		(Load 140 27070) ; WAVE
		(Lock 140 27070 1) ; WAVE
		(= global165 16)
		(= temp0 (Str newWith: 2 {16}))
		(cond
			((IsFlag 135))
			((== gPrevRoomNum 900)
				((ScriptID 45951 2) open: 0) ; chase_dat
			)
			((IsFlag 150)
				(ClearFlag 150)
				(if (gEgo has: 17) ; invXmasOrn
					(gEgo put: 17) ; invXmasOrn
				)
				(proc45951_4)
				((ScriptID 45951 2) writeString: temp0) ; chase_dat
			)
			(else
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
			)
		)
		(temp0 dispose:)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
		(armoire approachVerbs: 0 setHotspot: 4 3 init:) ; Do, Move
		(cond
			((and (not (IsFlag 390)) (not (gEgo has: 17))) ; invXmasOrn
				(coat approachVerbs: 0 setHotspot: 4 3 init:) ; Do, Move
				(if (IsFlag 135)
					(gCurRoom setScript: playBack)
				else
					(gCurRoom setScript: enterRoom)
				)
			)
			((IsFlag 135)
				(gCurRoom setScript: playBack)
			)
			(else
				(gCurRoom setScript: enterRoom)
			)
		)
		(if (not (gEgo has: 4)) ; invPoker
			(southExit init: 3 approachVerbs: 0)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(gGDacSound stop:)
		(Lock 140 27070 0) ; WAVE
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
						(= temp0 (Str newWith: 2 {11}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(gGDacSound number: 27070 setLoop: 1 play:)
					(if (gEgo has: 4) ; invPoker
						(DoRobot 9730 -10 -42 0 -1 1)
					else
						(DoRobot 9733 -10 -42 0 -1 1)
					)
				)
				(1
					(if (IsFlag 135)
						(= local9 1)
						(proc45951_3)
						(if (!= global179 2)
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

(instance smackDon of Script
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
					(armoireDoor init: setPri: 143)
					(if (gCast contains: coat)
						(coat dispose:)
					)
					(gGDacSound stop:)
					(DoRobot 9744 -12 -31 0 200 1)
					(gCurRoom drawPic: 27200)
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

(instance playBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local9
					(= local9 0)
				else
					(proc45951_3)
				)
				(switch global179
					(2
						(self setScript: caughtScript self)
					)
					(3
						(self setScript: sIntoArmoire self)
					)
					(4
						(self setScript: sPokeDon self)
					)
					(5
						(self setScript: sAdrienneOut self)
					)
					(6
						(self setScript: sGetOrn self)
					)
					(7
						(self setScript: whackDon self)
					)
					(8
						(self setScript: stabDon self)
					)
					(9
						(self setScript: smackDon self)
					)
					(10
						(self setScript: strangleAdrienne self)
					)
					(11
						(self setScript: enterRoom self)
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
		(gCurRoom newRoom: 46790)
	)
)

(instance strangleAdrienne of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {10}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if (gCast contains: coat)
						(coat dispose:)
					)
					(gGDacSound stop:)
					(DoRobot 9745 -12 -31 0 200 1)
					(gCurRoom drawPic: 27200)
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

(instance caughtScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2)
		(if (IsFlag 390)
			(SetFlag 150)
			(= global159 46910)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp2 (Str newWith: 2 {02}))
						((ScriptID 45951 2) writeString: temp2) ; chase_dat
						(temp2 dispose:)
					)
					(gGDacSound stop:)
					(SetFlag 150)
					(= global159 46910)
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

(instance whackDon of Script
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
					(if (gCast contains: coat)
						(coat dispose:)
					)
					(DoRobot 9741 37 0 0 200 1)
					(gCurRoom drawPic: 27200)
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

(instance sIntoArmoire of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(= local1 1)
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
					(if (gCast contains: coat)
						(coat dispose:)
					)
					(gGDacSound stop:)
					(DoRobot 9740 -11 0 0 200 1)
					(gCurRoom drawPic: 27200)
				)
				(1
					(= local1 1)
					(coat init:)
					(DoRobot 9732 -9 -39 0)
					(gCurRoom drawPic: 27250)
				)
				(2
					(cond
						((IsFlag 135)
							(self dispose:)
						)
						((not (IsFlag 143))
							(armoire setHotspot: 4 3 10 11 27) ; Do, Move, invPoker, invHammer, invCutter
							(gGame handsOn:)
						)
					)
				)
				(3
					(if (gCast contains: coat)
						(coat dispose:)
					)
					(gGame handsOff:)
					(gCurRoom setScript: strangleAdrienne)
				)
			)
		)
	)
)

(instance stabDon of Script
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
					(if (gCast contains: coat)
						(coat dispose:)
					)
					(DoRobot 9742 23 8 0 200 1)
					(gCurRoom drawPic: 27200)
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

(instance sPokeDon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 141)
			(gEgo put: 4) ; invPoker
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
					(if (gCast contains: coat)
						(coat dispose:)
					)
					(SetFlag 141)
					(gEgo put: 4) ; invPoker
					(global114 pause:)
					(DoRobot 9743 0 0 0 200 1)
					(gCurRoom drawPic: 27200)
				)
				(1
					(global114 endPause:)
					(DoRobot 9750 -11 -41 0 -1 1)
					(gCurRoom drawPic: 27231)
				)
				(2
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

(instance sAdrienneOut of Script
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
						(= temp0 (Str newWith: 2 {05}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if (gCast contains: coat)
						(coat dispose:)
					)
					(DoRobot 9750 -11 -41 0 -1 1)
					(gCurRoom drawPic: 27231)
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

(instance sGetOrn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(gEgo get: 17) ; invXmasOrn
			((ScriptID 45951 1) doit:) ; checkInv
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
					(coat dispose:)
					(if
						(and
							(gEgo has: 16) ; invSpellBook
							(or (gEgo has: 14) (gEgo has: 15)) ; invCrucifix, invBeads
							(or (gEgo has: 10) (gEgo has: 19)) ; invBrooch, invCutter
						)
						(DoRobot 9761 -10 -44 0 -1 1)
					else
						(DoRobot 9760 -1 -43 0 -1 1)
					)
					(gCurRoom drawPic: 27260)
				)
				(1
					(gEgo get: 17) ; invXmasOrn
					((ScriptID 45951 1) doit: self) ; checkInv
				)
				(2
					(cond
						((IsFlag 143)
							(gGame handsOff:)
							(if (IsFlag 135)
								(self dispose:)
							else
								(gCurRoom setScript: caughtScript)
							)
						)
						((not (IsFlag 135))
							(gGDacSound number: 27070 setLoop: 1 play:)
							(gGame handsOn:)
						)
						(else
							(= local9 1)
							(proc45951_3)
							(if (!= global179 2)
								(self dispose:)
							)
						)
					)
				)
				(3
					(gGDacSound stop:)
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

(instance armoireDoor of View
	(properties
		x 114
		y 132
		view 27200
	)
)

(instance coat of View
	(properties
		sightAngle 40
		approachX 201
		approachY 106
		x 240
		y 107
		view 27250
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 50)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gEgo has: 17)) ; invXmasOrn
				(gCurRoom setScript: sGetOrn)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance armoire of Feature
	(properties
		nsLeft 140
		nsTop 18
		nsRight 198
		nsBottom 97
		approachX 169
		approachY 57
		x 135
		y 68
	)

	(method (doVerb theVerb)
		(cond
			(local1
				(switch theVerb
					(4 ; Do
						(gCurRoom setScript: smackDon)
					)
					(10 ; invPoker
						(gCurRoom setScript: sPokeDon)
					)
					(11 ; invHammer
						(gCurRoom setScript: whackDon)
					)
					(27 ; invCutter
						(gCurRoom setScript: stabDon)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			((== theVerb 4) ; Do
				(gCurRoom setScript: sIntoArmoire)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 116
		nsRight 255
		nsBottom 140
		nextRoom 46790
		interRoom 15
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sAdrienneOut)
		else
			(super doVerb: theVerb)
		)
	)
)

