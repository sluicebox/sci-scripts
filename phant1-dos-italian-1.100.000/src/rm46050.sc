;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46050)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use User)
(use Actor)
(use System)

(public
	rm46050 0
)

(local
	local0
)

(instance rm46050 of ScaryRoom
	(properties
		picture 13430
		stepSound 4
	)

	(method (init &tmp temp0)
		(= temp0 (Str newWith: 2 {04}))
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
		(if (== gPrevRoomNum 46030)
			(= global165 2)
			(if (not (IsFlag 135))
				(if (not (gEgo has: 5)) ; invHammer
					(donBody init:)
				)
				(self setScript: fromNorth)
			)
		else
			(= global165 5)
			(= picture 13410)
			(self setScript: fromStairs)
		)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
		(southExit init: 3 approachVerbs: 0)
		(northExit init: 1 approachVerbs: 0)
		(cond
			((IsFlag 135)
				(gCurRoom setScript: playBack)
			)
			((not (gCurRoom script:))
				(gGame handsOn: 0)
			)
		)
	)

	(method (cue)
		(if (and (not script) (not (IsFlag 135)))
			(gCurRoom setScript: caughtScript)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
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
						(self setScript: caughtScript self)
					)
					(2
						(self setScript: sExitRoom self)
					)
					(3
						(self setScript: sSouthExit self)
					)
					(4
						(self setScript: fromNorth self)
					)
					(5
						(self setScript: toDarkroom self)
					)
					(6
						(self setScript: donRecovers self)
					)
					(7
						(self setScript: fromStairs self)
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
			(5
				(gCurRoom newRoom: 46100)
			)
			(2
				(gCurRoom newRoom: 46030)
			)
			(1
				(gCurRoom newRoom: 45950)
			)
			(15
				(gCurRoom newRoom: 46790)
			)
		)
	)
)

(instance fromStairs of Script
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
					(DoRobot 9281 -23 -45 0 -1 1)
				)
				(1
					(if (IsFlag 135)
						(= local0 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					else
						(northExit exitDir: 4 nsRight: 100)
						(southExit exitDir: 2 nsLeft: 200 nsTop: 0)
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

(instance donRecovers of Script
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
					(DoRobot 9293 134 40 0 -1 1)
					(gCurRoom drawPic: 13430)
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
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {04}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(DoRobot 9292 103 32 0)
				)
				(1
					(donBody dispose:)
					(DoRobot 9280 -23 -43 0 -1 1)
					(gCurRoom drawPic: 13410)
				)
				(2
					(if (not (IsFlag 135))
						(gGame handsOn:)
						(User canControl: 0)
						(northExit exitDir: 4 nsRight: 100)
						(southExit exitDir: 2 nsLeft: 200 nsTop: 0)
					else
						(= local0 1)
						(proc45951_3)
						(if (!= global179 1)
							(self dispose:)
						)
					)
				)
				(3
					(gGame handsOff:)
				)
				(4
					(if (not (IsFlag 135))
						(gCurRoom setScript: caughtScript)
					else
						(self dispose:)
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
				(= global159 46050)
				(SetFlag 150)
				(if (IsFlag 135)
					(self dispose:)
				else
					(gCurRoom newRoom: 46790)
				)
			)
		)
	)
)

(instance sExitRoom of Script
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
					(DoRobot 9294 126 39 0 -1 1)
					(gCurRoom drawPic: 13430)
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

(instance toDarkroom of Script
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
					(DoRobot 9294 129 39 0 -1 1)
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

(instance sSouthExit of Script
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
					(DoRobot 9290 -3 -41 0 -1 1)
					(gCurRoom drawPic: 13430)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46100)
					)
				)
			)
		)
	)
)

(instance donBody of View
	(properties
		x 137
		y 78
		view 9297
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 100
		nsTop 95
		nsRight 237
		nsBottom 135
		approachX 173
		approachY 140
		nextRoom 46100
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sSouthExit)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 5
		nsTop 5
		nsRight 320
		nsBottom 94
		x 142
		y 77
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sExitRoom)
		else
			(super doVerb: theVerb)
		)
	)
)

