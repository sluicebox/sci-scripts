;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use OccCyc)
(use n1111)
(use Scaler)
(use Feature)
(use WalkieTalkie)
(use Sound)
(use Actor)
(use System)

(public
	rm30100 0
)

(local
	local0 = -1
)

(instance rm30100 of ScaryRoom
	(properties
		picture 30100
		stepSound 4
	)

	(method (init)
		(gGDacSound fade: 0 4 2 1)
		((ScriptID 30) init:) ; FidgetCode
		(gGame handsOff:)
		(gEgo init: setScaler: Scaler 165 66 140 89 normalize:)
		(Load 140 30014 30015 30016 30017) ; WAVE
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(30400
				(gEgo posn: 202 104 normalize: 1)
				(gGame handsOn:)
			)
			(34400
				(cond
					((== gChapter 1)
						(= picture 30130)
						(cond
							((not (IsFlag 94))
								(self setScript: sFirstEntry)
							)
							(
								(and
									(not (IsFlag 263))
									(not (gEgo has: 0)) ; invLibKey
									(not (IsFlag 95))
								)
								(self setScript: sSecondEntry)
							)
							(
								(and
									(not (IsFlag 97))
									(not (gEgo has: 0)) ; invLibKey
									(IsFlag 95)
								)
								(self setScript: sSecondEntryAsked)
							)
							(else
								(self setScript: sWhatNow)
							)
						)
					)
					((== gChapter 3)
						(= picture 30130)
						(if (IsFlag 270)
							(self setScript: sWhatNowCh3)
						else
							(gEgo view: 3 posn: 160 109)
							(self setScript: sEnterChapter3)
						)
					)
					((== gChapter 2)
						(= picture 30130)
						(gEgo hide:)
						(SetFlag 11)
						(self setScript: sLastMeeting)
					)
					(else
						(= picture 30130)
						(gCurRoom setScript: enterRoom)
					)
				)
			)
			(else
				(= picture 30130)
				(gCurRoom setScript: enterRoom)
			)
		)
		(bob init:)
		(if (not (IsFlag 97))
			(fileCabinet init: approachVerbs: 0)
		)
		(desk init:)
		(magazine init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(couch init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(door init: 4)
		(super init: &rest)
		(if (and (self script:) (!= (self script:) (ScriptID 0 5))) ; takeLastStep
			(bob hide:)
		)
		(if (and (IsFlag 95) (not (IsFlag 97)))
			(fileCabinet setHotspot: 4 3) ; Do, Move
		)
	)

	(method (dispose)
		(Lock 140 30014 0) ; WAVE
		(Lock 140 30015 0) ; WAVE
		(Lock 140 30016 0) ; WAVE
		(Lock 140 30017 0) ; WAVE
		(super dispose:)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(gEgo view: 3 posn: 160 109)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCast eachElementDo: #hide)
					(proc1111_7 1798)
				)
				(1
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(gEgo view: 3 posn: 160 109)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCast eachElementDo: #hide)
					(proc1111_7 1799 0 0 gEgo -1 1)
					(gCurRoom drawPic: 30130)
				)
				(1
					(gCurRoom newRoom: 34400)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(proc1111_6)
					(gCurRoom newRoom: 34400)
				)
			)
		)
	)
)

(instance sFirstEntry of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(SetFlag 94)
					(chair dispose:)
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(gEgo normalize: 3 posn: 160 102)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1798)
				)
				(1
					(SetFlag 94)
					(chair init:)
					(proc1111_7 1802 -18 -13)
					(gCurRoom drawPic: 30160)
				)
				(2
					(chair dispose:)
				)
				(3
					(proc1111_7 1803 -7 -8)
					(gCurRoom drawPic: 30170)
				)
				(4
					(proc1111_7 1804 -8 -36)
					(gCurRoom drawPic: 30180)
				)
				(5
					(proc1111_7 1808 -18 0)
					(gCurRoom drawPic: 30160)
				)
				(6
					(proc1111_7 1809 -5 -4)
					(gCurRoom drawPic: 30170)
				)
				(7
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(gEgo normalize: 3 posn: 160 102)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sSecondEntry of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(gCurRoom drawPic: 30100)
					(chair dispose:)
					(desk setHotspot: 0)
					(bob setHotspot: 0)
					(gCast eachElementDo: #show)
					(gEgo posn: 160 102 normalize: 3)
					(= global115 0)
					(SetFlag 95)
					(SetFlag 263)
					(fileCabinet setHotspot: 4 3) ; Do, Move
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1798)
				)
				(1
					(desk setHotspot: 0)
					(bob setHotspot: 0)
					(SetFlag 95)
					(SetFlag 263)
					(gCast eachElementDo: #hide)
					(chair init:)
					(proc1111_7 1880 52 -6)
					(gCurRoom drawPic: 30160)
				)
				(2
					(gCurRoom drawPic: 30100)
					(chair dispose:)
					(gCast eachElementDo: #show)
					(gEgo posn: 160 102 normalize: 3)
					(fileCabinet setHotspot: 4 3) ; Do, Move
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sSecondEntryAsked of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(gCurRoom drawPic: 30100)
					(chair dispose:)
					(gCast eachElementDo: #show)
					(gEgo posn: 160 102 normalize: 3)
					(= global115 0)
					(if (not (IsFlag 97))
						(fileCabinet setHotspot: 4 3) ; Do, Move
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1798)
				)
				(1
					(SetFlag 263)
					(gCast eachElementDo: #hide)
					(chair init:)
					(proc1111_7 1890 -21 -42)
					(gCurRoom drawPic: 30160)
				)
				(2
					(gCurRoom drawPic: 30100)
					(chair dispose:)
					(gCast eachElementDo: #show)
					(gEgo posn: 160 102 normalize: 3)
					(if (not (IsFlag 97))
						(fileCabinet setHotspot: 4 3) ; Do, Move
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sWhatNow of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gCurRoom drawPic: 30100)
					(desk setHotspot: 0)
					(bob setHotspot: 0)
					(gCast eachElementDo: #show)
					(gEgo normalize: 3 posn: 160 102)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1798)
				)
				(1
					(gCast eachElementDo: #hide)
					(proc1111_7 1900 -13 -41)
					(gCurRoom drawPic: 30140)
				)
				(2
					(proc1111_7 1901 -20 -31)
					(gCurRoom drawPic: 30170)
				)
				(3
					(proc1111_7 1902 -14 -42)
					(gCurRoom drawPic: 30140)
				)
				(4
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(gEgo normalize: 3 posn: 160 102)
					(gGame handsOn:)
					(desk setHotspot: 0)
					(bob setHotspot: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance sEnterChapter3 of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(SetFlag 270)
					(gEgo normalize: 3)
					(if (gCast contains: deskStuff)
						(deskStuff dispose:)
					)
					(gCast eachElementDo: #show)
					(gCurRoom drawPic: 30100)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1798)
				)
				(1
					(gGame handsOff:)
					(SetFlag 270)
					(gCast eachElementDo: #hide)
					(deskStuff init:)
					(proc1111_7 3890 -14 -40)
					(gCurRoom drawPic: 30140)
				)
				(2
					(deskStuff dispose:)
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(gEgo normalize: 3)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance talkToBob of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(if (gCast contains: deskStuff)
						(deskStuff dispose:)
					)
					(gCast eachElementDo: #show)
					(gEgo normalize: 3)
					(gCurRoom drawPic: 30100)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCast eachElementDo: #hide)
					(proc1111_7 3900 4 -35)
					(gCurRoom drawPic: 30160)
				)
				(1
					(proc1111_7 3901 -12 -42)
					(gCurRoom drawPic: 30140)
				)
				(2
					(proc1111_7 3902 -34 -36)
					(gCurRoom drawPic: 30170)
				)
				(3
					(deskStuff init:)
					(proc1111_7 3903 -12 -37)
					(gCurRoom drawPic: 30140)
				)
				(4
					(deskStuff dispose:)
					(proc1111_7 3904 7 -32)
					(gCurRoom drawPic: 30160)
				)
				(5
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(gEgo normalize: 3)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sWhatNowCh3 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1798)
				)
				(1
					(gCast eachElementDo: #hide)
					(deskStuff init:)
					(proc1111_7 3910 -11 -43)
					(gCurRoom drawPic: 30140)
				)
				(2
					(deskStuff dispose:)
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(gEgo normalize: 3 posn: 160 109)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(if (gCast contains: deskStuff)
						(deskStuff dispose:)
					)
					(= global115 0)
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(gEgo normalize: 3 posn: 160 109)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance bimboBugsBob of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCast eachElementDo: #hide)
					(proc1111_7 3910 -11 -36)
					(deskStuff init:)
					(gCurRoom drawPic: 30140)
				)
				(1
					(deskStuff dispose:)
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(gEgo normalize: 3 posn: 160 109)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(if (gCast contains: deskStuff)
						(deskStuff dispose:)
					)
					(gEgo normalize: 3 posn: 160 109)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLastMeeting of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1798)
				)
				(1
					(proc1111_7 5630 -11 -42)
					(gCurRoom drawPic: 30160)
				)
				(2
					(WalkieTalkie showFrame: 5630 422 -11 -42)
					(gCurRoom newRoom: 34400)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gCurRoom newRoom: 34400)
				)
			)
		)
	)
)

(instance sAskForKeys of Script
	(properties)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(gCurRoom drawPic: 30100)
			(chair dispose:)
			(SetFlag 95)
			(gCast eachElementDo: #show)
			(gEgo posn: 160 102 normalize: 3)
			(fileCabinet setHotspot: 4 3) ; Do, Move
			(gGame handsOn:)
			(desk setHotspot: 0)
			(bob setHotspot: 0)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 95)
					(gCast eachElementDo: #hide)
					(chair init: posn: 26 134)
					(proc1111_7 1810 50 -5)
					(gCurRoom drawPic: 30160)
				)
				(1
					(gCurRoom drawPic: 30100)
					(chair dispose:)
					(gCast eachElementDo: #show)
					(gEgo posn: 160 102 normalize: 3)
					(fileCabinet setHotspot: 4 3) ; Do, Move
					(desk setHotspot: 0)
					(bob setHotspot: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookInCabinet of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(SetFlag 95)
					(= global115 0)
					(SetFlag 97)
					(chair dispose:)
					(gEgo get: 0 posn: 160 102 normalize: 3) ; invLibKey
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(fileCabinet setHotspot: 0)
					(= global125 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 95)
					(gCast eachElementDo: #hide)
					(chair init:)
					(proc1111_7 1820 -20 -40)
					(if register
						(gCurRoom drawPic: 30160)
					)
				)
				(1
					(chair dispose:)
					(gCurRoom drawPic: 30241)
					(= seconds 5)
				)
				(2
					(chair init:)
					(proc1111_7 1821 56 -18)
					(gCurRoom drawPic: 30160)
				)
				(3
					(chair dispose:)
					(gEgo get: 0 posn: 160 102 normalize: 3) ; invLibKey
					(SetFlag 97)
					(gCurRoom drawPic: 30100)
					(gCast eachElementDo: #show)
					(fileCabinet setHotspot: 0)
					(= global125 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance bob of Prop
	(properties
		approachX 149
		approachY 10
		x 126
		y 75
		view 1800
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 cycleSpeed: 9 setCycle: OccCyc self 10 360) ; Do
		(if (not (and (!= gChapter 3) (IsFlag 95)))
			(self setHotspot: 4 3) ; Do, Move
		)
	)

	(method (doit)
		(if (self isNotHidden:)
			(switch cel
				(0
					(if
						(and
							(!= local0 0)
							(or
								(!= (bobSound number:) 30014)
								(not (bobSound handle:))
							)
						)
						(= local0 0)
						(bobSound number: 30014 play:)
					)
				)
				(26
					(if
						(and
							(!= local0 26)
							(or
								(!= (bobSound number:) 30015)
								(not (bobSound handle:))
							)
						)
						(= local0 26)
						(bobSound number: 30015 play:)
					)
				)
				(90
					(if
						(and
							(!= local0 90)
							(or
								(!= (bobSound number:) 30016)
								(not (bobSound handle:))
							)
						)
						(= local0 90)
						(bobSound number: 30016 play:)
					)
				)
				(152
					(if
						(and
							(or
								(!= (bobSound number:) 30017)
								(not (bobSound handle:))
							)
							(!= local0 152)
						)
						(= local0 152)
						(bobSound number: 30017 play:)
					)
				)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(desk doVerb: theVerb)
	)
)

(instance bobSound of Sound
	(properties)
)

(instance fileCabinet of Feature
	(properties
		nsLeft 78
		nsTop 77
		nsRight 96
		nsBottom 95
		approachX 88
		approachY 103
		x 84
		y 96
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: lookInCabinet 0 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance chair of View
	(properties
		x 26
		y 134
		view 30160
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

(instance desk of Feature
	(properties
		nsLeft 111
		nsTop 70
		nsRight 173
		nsBottom 94
		sightAngle 40
		approachX 142
		approachY 10
		x 142
		y 107
		z 25
	)

	(method (init)
		(super init:)
		(if (not (and (!= gChapter 3) (IsFlag 95)))
			(self approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gChapter 3)
					(if (IsFlag 296)
						(gCurRoom setScript: bimboBugsBob)
					else
						(SetFlag 296)
						(gCurRoom setScript: talkToBob)
					)
				else
					(gCurRoom setScript: sAskForKeys)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance magazine of Feature
	(properties
		nsLeft 202
		nsTop 99
		nsRight 233
		nsBottom 117
		sightAngle 40
		approachX 180
		approachY 116
		x 217
		y 108
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 30400)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance couch of Feature
	(properties
		nsLeft 235
		nsTop 91
		nsRight 293
		nsBottom 130
		sightAngle 40
		approachX 200
		approachY 105
		x 264
		y 110
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 30400)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 1
		nsTop 10
		nsRight 10
		nsBottom 129
		approachX 151
		approachY 257
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: leaveRoom)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance deskStuff of View
	(properties
		x 131
		y 130
		view 30140
	)
)

