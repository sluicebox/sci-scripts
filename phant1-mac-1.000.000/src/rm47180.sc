;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47180)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm47180 0
)

(local
	local0
)

(instance rm47180 of ScaryRoom
	(properties
		picture 22200
		stepSound 7
	)

	(method (cue)
		(gCurRoom setScript: caughtScript)
	)

	(method (init &tmp temp0)
		(Load rsVIEW 22202 22200 22201 22340 22341 22380)
		(Load 140 22071) ; WAVE
		(= temp0 (Str newWith: 2 {19}))
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
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
		(if (and (or (gEgo has: 15) (gEgo has: 14)) (not (IsFlag 142))) ; invBeads, invCrucifix
			(statue init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		)
		((ScriptID 45951 1) doit:) ; checkInv
		(if (not (IsFlag 390))
			(if (or (gEgo has: 15) (gEgo has: 14)) ; invBeads, invCrucifix
				(sMarieLid init: approachVerbs: 0 setHotspot: 0 10) ; invPoker
			)
			(if
				(and
					(not (IsFlag 59))
					(not (or (gEgo has: 15) (gEgo has: 14))) ; invBeads, invCrucifix
				)
				(rosaryBeads
					init:
					setCycle: Fwd
					setPri: 116 1
					approachVerbs: 0
					setHotspot: 4 3 ; Do, Move
				)
			)
			(lid1 init:)
			(lid2 init:)
		)
		(doorExit init: 10 approachVerbs: 0)
		(cond
			((IsFlag 135)
				(gCurRoom setScript: playBack)
			)
			((and (not (gEgo has: 15)) (not (gEgo has: 14))) ; invBeads, invCrucifix
				(ClearFlag 142)
				(gCurRoom setScript: enterRoom)
			)
			((IsFlag 142)
				(gCurRoom setScript: enterGetCaught)
			)
			(else
				(gCurRoom setScript: enterRoom)
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
						(self setScript: sToppleStatue self)
					)
					(2
						(self setScript: caughtScript self)
					)
					(3
						(self setScript: sHideWithMarie self)
					)
					(4
						(self setScript: enterRoom self)
					)
					(5
						(self setScript: sGetBeads self)
					)
					(6
						(self setScript: caughtInCasket self)
					)
					(7
						(self setScript: doorCaught self)
					)
					(8
						(self setScript: enterGetCaught self)
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
			(18
				(gCurRoom newRoom: 47020)
			)
			(else
				(gCurRoom newRoom: 46980)
			)
		)
	)
)

(instance enterGetCaught of Script
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
					(DoRobot 9822 55 31 0 -1 1)
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

(instance enterRoom of Script
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
					(DoRobot 9820 54 33 0 -1 1)
				)
				(1
					(if (IsFlag 135)
						(= local0 1)
						(proc45951_3)
						(if (!= global179 2)
							(self dispose:)
						)
					else
						(gGame handsOn: 0)
					)
				)
				(2
					(sfxSound1 stop:)
					(sfxSound2 stop:)
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

(instance sToppleStatue of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 142)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(sfxSound1 stop:)
					(sfxSound2 stop:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {01}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if (gCast contains: rosaryBeads)
						(rosaryBeads dispose:)
					)
					(if (IsFlag 143)
						((View new:) view: 22380 x: 194 y: 37 init:)
						(DoRobot 9831 -13 -40 0 -1 1)
					else
						(DoRobot 9830 -14 -41 0 10 1)
					)
					(lid1 dispose:)
					(lid2 dispose:)
					(gCurRoom drawPic: 22380)
				)
				(1
					(SetFlag 142)
					(cond
						((IsFlag 135)
							(self dispose:)
						)
						((IsFlag 143)
							(gCurRoom setScript: caughtScript)
						)
						(else
							(gCurRoom newRoom: 47020)
						)
					)
				)
			)
		)
	)
)

(instance caughtInCasket of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(sfxSound1 stop:)
					(sfxSound2 stop:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {06}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(bigLidView init:)
					(DoRobot 7250 -11 -39 0 115)
					(lid1 dispose:)
					(lid2 dispose:)
					(gCurRoom drawPic: 22340)
				)
				(1
					(DoRobot 7251 -7 -38 0 1)
				)
				(2
					(bigLidView dispose:)
					(DoRobot 7252 -13 -39 0)
					(gCurRoom drawPic: 22390)
				)
				(3
					(bigLidView init:)
					(DoRobot 7253 -11 -38 0 -1 1)
					(gCurRoom drawPic: 22340)
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

(instance doorCaught of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(sfxSound1 stop:)
					(sfxSound2 stop:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {07}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					((View new:) view: 22380 x: 194 y: 37 init:)
					(DoRobot 9831 -7 -43 0 -1 1)
					(if (gCast contains: rosaryBeads)
						(rosaryBeads dispose:)
					)
					(lid1 dispose:)
					(lid2 dispose:)
					(gCurRoom drawPic: 22380)
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

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 150)
			(if (IsFlag 142)
				(= global159 46980)
			else
				(= global159 47180)
			)
			(if (and (not (gEgo has: 15)) (not (gEgo has: 14))) ; invBeads, invCrucifix
				(ClearFlag 59)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(sfxSound1 stop:)
					(sfxSound2 stop:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {02}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if (not (gEgo has: 14)) ; invCrucifix
						(ClearFlag 59)
					)
					(SetFlag 150)
					(if (IsFlag 142)
						(= global159 46980)
					else
						(= global159 47180)
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

(instance sHideWithMarie of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 59)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(sfxSound1 stop:)
					(sfxSound2 stop:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {03}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if (gCast contains: rosaryBeads)
						(rosaryBeads dispose:)
					)
					(SetFlag 59)
					(DoRobot 7230 -3 -2 0)
					(lid1 dispose:)
					(lid2 dispose:)
					(gCurRoom drawPic: 22340)
				)
				(1
					(bigLidView init:)
					(DoRobot 7231 -10 -42 0)
				)
				(2
					(bigLidView dispose:)
					(DoRobot 7232 -11 -40 0)
					(gCurRoom drawPic: 22390)
				)
				(3
					(bigLidView init:)
					(DoRobot 7234 -79 -32 0 150)
					(gCurRoom drawPic: 22340)
				)
				(4
					(if (or (IsFlag 142) (IsFlag 143))
						(gGame handsOff:)
						(DoRobot 9822 55 31 0)
					else
						(sfxSound1 number: 22071 play:)
						(DoRobot 9821 55 31 0)
					)
					(bigLidView dispose:)
					(lid1 init:)
					(lid2 view: 22209 x: 139 y: 97 init:)
					(gCurRoom drawPic: 22200)
				)
				(5
					(sfxSound1 stop:)
					(sMarieLid setHotspot: 4 3) ; Do, Move
					(cond
						((IsFlag 135)
							(= local0 1)
							(proc45951_3)
							(if (!= global179 2)
								(self dispose:)
							)
						)
						((or (IsFlag 142) (IsFlag 143))
							(gCurRoom setScript: caughtScript)
						)
						(else
							(gGame handsOn: 0)
							(doorExit init: 10 approachVerbs: 0)
						)
					)
				)
				(6
					(gGame handsOff:)
				)
				(7
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

(instance sGetBeads of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(gEgo get: 15) ; invBeads
			((ScriptID 45951 1) doit:) ; checkInv
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(sfxSound1 stop:)
					(sfxSound2 stop:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {05}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(rosaryBeads dispose:)
					(closedLidView init:)
					(DoRobot 7220 -9 -43 0)
					(lid1 dispose:)
					(lid2 dispose:)
					(gCurRoom drawPic: 22340)
				)
				(1
					(gEgo get: 15) ; invBeads
					((ScriptID 45951 1) doit: self) ; checkInv
				)
				(2
					(if (or (IsFlag 142) (IsFlag 143))
						(gGame handsOff:)
						(DoRobot 9822 55 31 0 -1 1)
					else
						(sfxSound2 number: 22071 setLoop: 1 play:)
						(DoRobot 9821 55 31 0 -1 1)
					)
					(closedLidView dispose:)
					(lid1 init:)
					(lid2 init:)
					(gCurRoom drawPic: 22200)
				)
				(3
					(if (IsFlag 59)
						(sMarieLid init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
					else
						(sMarieLid init: approachVerbs: 0 setHotspot: 0 10) ; invPoker
					)
					(statue init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
					(cond
						((IsFlag 135)
							(= local0 1)
							(proc45951_3)
							(if (or (!= global179 2) (IsFlag 143))
								(self dispose:)
							)
						)
						((or (IsFlag 142) (IsFlag 143))
							(gCurRoom setScript: caughtScript)
						)
						(else
							(gGame handsOn:)
							(doorExit init: 10 approachVerbs: 0)
						)
					)
				)
				(4
					(gGame handsOff:)
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

(instance rosaryBeads of Prop
	(properties
		sightAngle 40
		approachX 120
		approachY 126
		x 121
		y 94
		view 22203
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetBeads)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sMarieLid of Feature
	(properties
		nsLeft 124
		nsTop 89
		nsRight 202
		nsBottom 120
		sightAngle 40
		approachY 126
		x 163
		y 81
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 59)
						(gCurRoom setScript: caughtInCasket)
					)
					((and (not (gEgo has: 15)) (not (gEgo has: 14))) ; invBeads, invCrucifix
						(gCurRoom setScript: sGetBeads)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(10 ; invPoker
				(if (not (IsFlag 59))
					(gCurRoom setScript: sHideWithMarie)
				else
					(gCurRoom setScript: caughtInCasket)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance statue of Feature
	(properties
		nsLeft 206
		nsTop 45
		nsRight 226
		nsBottom 87
		sightAngle 40
		approachX 224
		approachY 105
		x 160
		y 95
		z 68
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sToppleStatue)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lid1 of View
	(properties
		x 191
		y 108
		priority 125
		fixPriority 1
		view 22200
	)
)

(instance lid2 of View
	(properties
		x 121
		y 95
		priority 115
		fixPriority 1
		view 22201
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (not (gEgo has: 15)) (not (gEgo has: 14))) ; invBeads, invCrucifix
					(gCurRoom setScript: sGetBeads)
				else
					(super doVerb: theVerb)
				)
			)
			(10 ; invPoker
				(if (not (IsFlag 59))
					(gCurRoom setScript: sHideWithMarie)
				else
					(gCurRoom setScript: caughtInCasket)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bigLidView of View
	(properties
		x 178
		y 113
		view 22340
	)
)

(instance closedLidView of View
	(properties
		x 142
		y 111
		view 22341
	)
)

(instance doorExit of ExitFeature
	(properties
		nsLeft 180
		nsTop 30
		nsRight 209
		nsBottom 81
		x 292
		y 93
		nextRoom 35110
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (IsFlag 142)
				(= global165 19)
				(gCurRoom newRoom: 47020)
			else
				(gCurRoom setScript: doorCaught)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sfxSound1 of Sound
	(properties)
)

(instance sfxSound2 of Sound
	(properties)
)

