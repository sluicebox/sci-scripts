;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46620)
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
	rm46620 0
)

(local
	local0
	local1
	local2
)

(instance rm46620 of ScaryRoom
	(properties
		picture 37200
		stepSound 4
	)

	(method (cue)
		(if (not (gCurRoom script:))
			(gCurRoom setScript: caughtScript)
		)
	)

	(method (init &tmp temp0)
		(Load rsVIEW 37200)
		(Lock rsVIEW 37200 1)
		(= temp0 (Str newWith: 2 {10}))
		(cond
			((IsFlag 135))
			((== gPrevRoomNum 900)
				((ScriptID 45951 2) open: 0) ; chase_dat
				(gGame handsOn:)
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
		(if (== gPrevRoomNum 46630)
			(rightCrank init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
			(southExit
				nsLeft: 5
				nsRight: 319
				nsBottom: 129
				nsTop: 73
				init: 3
				approachVerbs: 0
			)
		else
			(liftExit init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
			(southExit init: 3 approachVerbs: 0)
			(if (not (IsFlag 123))
				(marieDoor init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
			)
		)
		(cond
			((IsFlag 135)
				(if (== gPrevRoomNum 46630)
					(= picture 37300)
				)
				(if (== gPrevRoomNum 46570)
					(if (or (IsFlag 409) global125)
						(= picture 37311)
					else
						(= picture 37200)
					)
				)
				(gCurRoom setScript: playBack)
			)
			((== gPrevRoomNum 46630)
				(= local1 1)
				(= global165 11)
				(= picture 37300)
				(gCurRoom setScript: fromLift)
			)
			((== gPrevRoomNum 46570)
				(= global165 9)
				(if (or (IsFlag 409) global125)
					(= picture 37311)
					(gCurRoom setScript: runSouth)
				else
					(= picture 37200)
					(self setScript: enterFromSouth)
				)
			)
		)
		(if (IsFlag 390)
			(= picture -1)
		)
		(if (== picture 37200)
			(lift37200 init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(Lock rsVIEW 37200 0)
		(if (!= newRoomNumber 46790)
			(ClearFlag 409)
		)
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
				(if local2
					(= local2 0)
				else
					(proc45951_3)
				)
				(switch global179
					(1
						(self setScript: caughtScript self)
					)
					(2
						(self setScript: mikeFallsOut self)
					)
					(3
						(self setScript: liftDown self)
					)
					(4
						(self setScript: changeView self)
					)
					(5
						(self setScript: runSouth self)
					)
					(6
						(self setScript: northCaught self)
					)
					(7
						(self setScript: enterFromSouth self)
					)
					(8
						(self setScript: toLift self)
					)
					(9
						(self setScript: caughtAtLift self)
					)
					(10
						(self setScript: fromLift self)
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
			(11
				(gCurRoom newRoom: 46630)
			)
			(9
				(gCurRoom newRoom: 46570)
			)
			(15
				(gCurRoom newRoom: 46790)
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
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {07}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(liftExit nsLeft: 36 nsTop: 27 nsRight: 65 nsBottom: 114)
					(proc1111_7 9307 -5 -40 0 200 1)
				)
				(1
					(if (IsFlag 135)
						(= local2 1)
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

(instance northCaught of Script
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
					(if (gCast contains: thatOldLift)
						(thatOldLift dispose:)
					)
					(proc1111_7 9621 -11 -41 0 -1 1)
					(if (IsFlag 123)
						(gCurRoom drawPic: 37315)
					else
						(gCurRoom drawPic: 37310)
					)
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

(instance runSouth of Script
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
					(proc1111_7 9620 -1 -41 0 200)
					(lift37311 init:)
					(if global125
						(= global125 0)
					)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: toLift)
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
			(= global159 46620)
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
					(= cycles 2)
				)
				(1
					(if (gTimers contains: (ScriptID 45951 0)) ; chap7Timer
						((ScriptID 45951 0) dispose:) ; chap7Timer
					)
					(= global159 46620)
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

(instance mikeFallsOut of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 123)
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
					(global114 pause:)
					(proc1111_7 6630 -68 -26 0 200 1)
					(if (gCast contains: thatOldLift)
						(thatOldLift dispose:)
					)
					(lift37200 init:)
					(gCurRoom drawPic: 37200)
				)
				(1
					(SetFlag 123)
					(marieDoor dispose:)
					(global114 endPause:)
					(if (not (IsFlag 135))
						(gCurRoom setScript: toLift)
					else
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance liftDown of Script
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
					(proc1111_7 9640 0 0 0 -1 1)
					(if (gCast contains: thatOldLift)
						(thatOldLift dispose:)
					)
					(gCurRoom drawPic: 37320 0 1)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46630)
					)
				)
			)
		)
	)
)

(instance fromLift of Script
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
					(proc1111_7 9631 -15 -25 0 -1 1)
				)
				(1
					(if (IsFlag 135)
						(= local2 1)
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

(instance toLift of Script
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
					(if (gCast contains: lift37311)
						(lift37311 dispose:)
					)
					(if (gCast contains: lift37200)
						(lift37200 dispose:)
					)
					(= local1 1)
					(thatOldLift init:)
					(proc1111_7 9630 -12 -41 0)
					(gCurRoom drawPic: 37300 0 1)
				)
				(1
					(if (IsFlag 135)
						(= local2 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(gGame handsOn:)
						(rightCrank init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
						(if (gFeatures contains: marieDoor)
							(marieDoor dispose:)
						)
						(southExit
							nsLeft: 5
							nsRight: 319
							nsBottom: 129
							nsTop: 73
						)
						(liftExit dispose:)
					)
				)
				(2
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtAtLift)
					)
				)
			)
		)
	)
)

(instance caughtAtLift of Script
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
							(= temp0 (Str newWith: 2 {09}))
							((ScriptID 45951 2) writeString: temp0) ; chase_dat
							(temp0 dispose:)
						)
						(proc1111_7 9308 60 -45 0 200 1)
						(if (gCast contains: thatOldLift)
							(thatOldLift dispose:)
						)
						(deathLift init:)
						(gCurRoom drawPic: 37320)
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
)

(instance changeView of Script
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
					(= local1 0)
					(proc1111_7 9622 -9 -31 0 -1 1)
					(liftExit nsLeft: 93 nsTop: 10 nsRight: 134 nsBottom: 129)
					(if (gCast contains: thatOldLift)
						(thatOldLift dispose:)
					)
					(if (IsFlag 123)
						(gCurRoom drawPic: 37315 0 1)
					else
						(gCurRoom drawPic: 37310 0 1)
					)
					(liftExit init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(rightCrank dispose:)
					(if (not (IsFlag 123))
						(marieDoor init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					)
				)
				(1
					(if (IsFlag 135)
						(= local2 1)
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

(instance rightCrank of Feature
	(properties
		nsLeft 99
		nsTop 49
		nsRight 120
		nsBottom 72
		sightAngle 40
		approachX 109
		approachY 60
		x 257
		y 88
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local1
				(gCurRoom setScript: liftDown)
			else
				(gCurRoom setScript: liftDown)
			)
		else
			(super doVerb: &rest)
		)
	)
)

(instance marieDoor of Feature
	(properties
		nsLeft 140
		nsTop 10
		nsRight 160
		nsBottom 129
		approachX 113
		approachY 69
		x 113
		y 69
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: mikeFallsOut)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 2
		nsTop 105
		nsRight 293
		nsBottom 130
		sightAngle 40
		approachX 237
		approachY 105
		x 237
		y 105
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(cond
				((and (== gPrevRoomNum 46570) (OneOf global165 6 7))
					(gCurRoom setScript: northCaught)
				)
				(local1
					(gCurRoom setScript: changeView)
				)
				(else
					(gCurRoom setScript: toLift)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance liftExit of Feature
	(properties
		nsLeft 93
		nsTop 10
		nsRight 134
		nsBottom 129
		approachX 51
		approachY 74
		x 51
		y 74
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (and (== gPrevRoomNum 46570) (OneOf global165 6 7))
				(gCurRoom setScript: northCaught)
			else
				(gCurRoom newRoom: 46570)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lift37200 of View
	(properties
		x 34
		y 119
		view 37200
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

(instance lift37311 of View
	(properties
		x 99
		y 87
		view 37311
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

(instance deathLift of View
	(properties
		x 73
		y 133
		view 37320
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

(instance thatOldLift of View
	(properties
		x 80
		y 127
		view 37300
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

