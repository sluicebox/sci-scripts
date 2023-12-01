;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46630)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use Feature)
(use System)

(public
	rm46630 0
)

(local
	local0
	local1
)

(instance rm46630 of ScaryRoom
	(properties
		picture 110
		stepSound 4
	)

	(method (cue)
		(gCurRoom setScript: caughtScript)
	)

	(method (init &tmp temp0)
		(gGame handsOff:)
		(= temp0 (Str newWith: 2 {11}))
		(cond
			((IsFlag 135))
			((== gPrevRoomNum 900)
				((ScriptID 45951 2) open: 0) ; chase_dat
			)
			((IsFlag 150)
				(ClearFlag 150)
				(ClearFlag 151)
				(proc45951_4)
				(if (IsFlag 408)
					(proc45951_4)
					(ClearFlag 408)
				)
				((ScriptID 45951 2) writeString: temp0) ; chase_dat
			)
			(else
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
			)
		)
		(temp0 dispose:)
		(westExit init: 12 approachVerbs: 0)
		(eastExit init: 1 approachVerbs: 0)
		(southExit init: 2 approachVerbs: 0)
		(northExit init: setHotspot: 4 3) ; Do, Move
		(cond
			((IsFlag 135)
				(if (== gPrevRoomNum 46620)
					(= picture 480)
				)
				(gCurRoom setScript: playBack)
			)
			((== gPrevRoomNum 46620)
				(= global165 10)
				(= picture 480)
				(gCurRoom setScript: fromNorth)
			)
			((== gPrevRoomNum 46770)
				(= global165 14)
				(gCurRoom setScript: fromSouth)
			)
			((== gPrevRoomNum 46720)
				(= global165 13)
				(gCurRoom setScript: fromChapel)
			)
			(else
				(gCurRoom setScript: fromChapel)
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
						(self setScript: tryRitualWay self)
					)
					(3
						(self setScript: fromSouth self)
					)
					(4
						(self setScript: exitSouth self)
					)
					(5
						(self setScript: upLift self)
					)
					(6
						(self setScript: fromNorth self)
					)
					(7
						(self setScript: fromChapel self)
					)
					(8
						(self setScript: theatreClosed self)
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
			(10
				(gCurRoom newRoom: 46620)
			)
			(14
				(gCurRoom newRoom: 46770)
			)
			(13
				(gCurRoom newRoom: 46720)
			)
			(15
				(gCurRoom newRoom: 46790)
			)
		)
	)
)

(instance theatreClosed of Script
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
					(DoRobot 9683 -14 0 0 -1 1)
					(gCurRoom drawPic: 100)
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

(instance fromNorth of Script
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
					(DoRobot 9661 0 0 0)
				)
				(1
					(DoRobot 9817 -15 -3 0 -1 1)
					(gCurRoom drawPic: 110)
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

(instance fromChapel of Script
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
						(gGame handsOn:)
					)
					(DoRobot 9816 -6 -7 0 -1 1)
				)
				(1
					(if (IsFlag 135)
						(= local1 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(gGame handsOff:)
					)
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

(instance fromSouth of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {03}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
						(gGame handsOn:)
					)
					(DoRobot 9815 -10 -9 0 -1 1)
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

(instance caughtScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2)
		(if (IsFlag 390)
			(SetFlag 150)
			(= global159 46630)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp2 (Str newWith: 2 {01}))
						((ScriptID 45951 2) writeString: temp2) ; chase_dat
						(temp2 dispose:)
					)
					(SetFlag 150)
					(= global159 46630)
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

(instance tryRitualWay of Script
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
					(if (== global165 10)
						(DoRobot 9693 2 27 0 -1 1)
					else
						(DoRobot 9691 4 28 0 -1 1)
					)
					(gCurRoom drawPic: 220)
				)
				(1
					(northExit dispose:)
					(southExit dispose:)
					(westExit dispose:)
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

(instance exitSouth of Script
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
						(gCurRoom newRoom: 46770)
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
						(= temp0 (Str newWith: 2 {05}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9660 0 0 0 -1 1)
					(gCurRoom drawPic: 480)
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

(instance westExit of ExitFeature
	(properties
		nsLeft 22
		nsTop 120
		nsRight 249
		nsBottom 128
		approachX 51
		approachY 64
		x 51
		y 64
		nextRoom 46720
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 252
		nsTop 0
		nsRight 294
		nsBottom 127
		approachX 155
		approachY 118
		x 155
		y 118
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (gEgo has: 17) ; invXmasOrn
				(gCurRoom setScript: theatreClosed)
			else
				(gCurRoom setScript: exitSouth)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 101
		nsTop 20
		nsRight 209
		nsBottom 113
		approachX 253
		approachY 65
		x 253
		y 65
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(KillRobot 0 0)
			(gCurRoom setScript: tryRitualWay)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance northExit of Feature
	(properties
		nsLeft 23
		nsTop 27
		nsRight 71
		nsBottom 120
		sightAngle 40
		approachX 63
		approachY 138
		x 53
		y 108
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(KillRobot 0 0)
			(gCurRoom setScript: upLift)
		else
			(super doVerb: theVerb)
		)
	)
)

