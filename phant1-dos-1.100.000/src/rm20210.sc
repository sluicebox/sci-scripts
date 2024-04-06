;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20210)
(include sci.sh)
(use Main)
(use Trigger)
(use n1111)
(use Scaler)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm20210 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 227
	local5 = 43
	local6 = 146
	local7 = 43
)

(instance rm20210 of ScaryRoom
	(properties
		picture 20210
		stepSound 4
	)

	(method (init &tmp temp0)
		(KillRobot)
		(if (and (< 2 gChapter 6) (not (IsFlag 351)))
			(gGDacSound setVol: 127)
		)
		(= temp0 0)
		(= global115 0)
		(gEgo init: normalize: setIntensity: 80 1 hide:)
		(if (!= gPrevRoomNum 900)
			(gEgo
				view: 5
				normalize: 5
				x: 108
				y: 79
				cel: 0
				setLoop: 0 1
				setPri: 30
				setScaler: Scaler 124 96 111 71
			)
		else
			(gGame handsOn:)
		)
		(if (== global125 74)
			(= global125 0)
			(SetFlag 353)
		)
		(cond
			((IsFlag 352)
				(= temp0 sDoRat)
			)
			((IsFlag 353)
				(SetFlag 352)
				(RemapColors 2 243 150) ; ByPercent
				(Load rsVIEW 20211)
				(Lock rsVIEW 20211 1)
				(= temp0 sDoClawLikeHand)
			)
			((== global125 74)
				(SetFlag 353)
				(= local0 121)
				(= local1 16)
				(SetFlag 297)
				(Robot 0 612 gThePlane 60 local0 local1) ; Open
				(Robot 1 0) ; DisplayFrame
				(gGame handsOn:)
			)
			((not (IsFlag 30))
				(= temp0 sLookAround)
			)
			(else
				(= temp0 sComeIn)
			)
		)
		(= global125 0)
		(floor view: 20212 x: 155 y: 106 setPri: 50 ignoreActors: 1 init:)
		(super init:)
		(alcoveDoor init:)
		(manacles init:)
		(if temp0
			(self setScript: temp0 0 0)
		else
			(gGame handsOn:)
		)
		(if (ResCheck rsSOUND 20230)
			(global114 play: 20030)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 20200)
			(gEgo setIntensity: 100 1)
		)
		(ClearFlag 297)
		(super newRoom: newRoomNumber)
	)
)

(instance floor of View
	(properties)
)

(instance sFx of Sound
	(properties
		flags 4
	)
)

(instance manacles of View
	(properties
		sightAngle 40
		view 20210
	)

	(method (init)
		(self x: local4 y: local5 approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(self setHotspot: 0 approachVerbs: 0)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sDoMans)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance alcoveDoor of Trigger
	(properties
		nsLeft 115
		nsRight 154
		nsBottom 88
		approachX 152
		approachY 108
		exitDir 13
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(gCurRoom setScript: sExit)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(if (IsFlag 353)
						(ClearFlag 353)
						(sFx number: 20031 setLoop: 1 play:)
					)
					(DoRobot 612 local0 local1 gEgo 90 1)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
		)
		(= global115 0)
		(gCurRoom newRoom: 20200)
		(super dispose: &rest)
	)
)

(instance hand1 of Prop
	(properties)

	(method (cue)
		(super cue: &rest)
		(if (== cel 10)
			(self setCycle: Beg self)
		else
			(= local2 1)
			(self dispose:)
		)
	)
)

(instance hand2 of Prop
	(properties)

	(method (cue)
		(super cue: &rest)
		(if (== cel 10)
			(self setCycle: Beg self)
		else
			(= local3 1)
			(self dispose:)
		)
	)
)

(instance sDoClawLikeHand of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 610 118 10)
				)
				(1
					(hand1
						view: 20211
						cel: 0
						init:
						x: 123
						y: 70
						ignoreActors: 1
						cycleSpeed: 12
						setCycle: End hand1
						setPri: 100
					)
					(hand2
						view: 20211
						cel: 0
						init:
						x: 123
						y: 70
						setPri: 200
						ignoreActors: 1
						cycleSpeed: 12
						setCycle: End hand2
						setPri: 100
					)
				)
				(2
					(gGDacSound stop:)
				)
				(3
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(KillRobot)
		(gGDacSound stop:)
		(if global115
			(gEgo hide: setCycle: 0)
		)
		(= global115 0)
		(= local0 121)
		(= local1 16)
		(SetFlag 297)
		(Robot 0 612 gThePlane 60 local0 local1) ; Open
		(Robot 1 0) ; DisplayFrame
		(RemapColors 0) ; Off
		(SetFlag 351)
		(Lock rsVIEW 20211 0)
		(UnLoad 128 20211)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sComeIn of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(if (> (Random 0 75) 50)
						(rat init:)
						(self setScript: runAway self)
					else
						(self cue:)
					)
				)
				(1
					(DoRobot 611 121 16 gEgo -1 1)
				)
				(2
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(gEgo hide: setCycle: 0)
		)
		(= global115 0)
		(= local0 121)
		(= local1 16)
		(SetFlag 297)
		(Robot 0 612 gThePlane 60 local0 local1) ; Open
		(Robot 1 0) ; DisplayFrame
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance rat of Prop
	(properties
		view 3170
	)
)

(instance sDoRat of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(sFx number: 20033 setLoop: 1 play:)
					(gEgo hide:)
					(rat
						view: 3170
						setLoop: 0 1
						cel: 55
						cycleSpeed: 8
						x: 231
						y: 137
						setPri: 100
						ignoreActors: 1
						init:
						show:
						setCycle: End self
					)
				)
				(1
					(rat dispose:)
					(sFx stop:)
					(DoRobot 611 121 16 gEgo -1 1)
				)
				(2
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(gEgo hide: setCycle: 0)
			(rat dispose:)
		)
		(= global115 0)
		(= local0 121)
		(= local1 16)
		(SetFlag 297)
		(Robot 0 612 gThePlane 60 local0 local1) ; Open
		(Robot 1 0) ; DisplayFrame
		(ClearFlag 352)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance runAway of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not global115)
			(switch (= state newState)
				(0
					(Load 140 20033) ; WAVE
					(Lock 140 20033 1) ; WAVE
					(rat
						view: 3170
						setLoop: 0 1
						cel: 55
						cycleSpeed: 8
						x: 231
						y: 137
						setPri: 100
						ignoreActors: 1
					)
					(= ticks 120)
				)
				(1
					(sFx number: 20033 setLoop: 1 play:)
					(rat setCycle: End self)
				)
				(2
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(sFx stop:)
		(Lock 140 20033 0) ; WAVE
		(rat dispose:)
		(super dispose:)
	)
)

(instance sDoMans of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== local0 125)
						(= local4 227)
						(= local5 43)
						(= local6 146)
						(= local7 8)
					else
						(= local4 224)
						(= local5 45)
						(= local6 143)
						(= local7 11)
					)
					(DoRobot 620 local6 local7 gEgo -1 1)
				)
				(1
					(manacles z: 1000)
					(UpdateScreenItem manacles)
				)
				(2
					(manacles x: local4 y: local5 z: 0)
					(UpdateScreenItem manacles)
				)
				(3
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(KillRobot)
		(= global115 0)
		(manacles x: local4 y: local5 z: 0)
		(SetFlag 297)
		(+= local0 3)
		(+= local1 2)
		(Robot 0 612 gThePlane 60 local0 local1) ; Open
		(Robot 1 0) ; DisplayFrame
		(SetFlag 32)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sLookAround of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(DoRobot 611 121 16 gEgo -1 1)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(gEgo hide: setCycle: 0)
		)
		(= global115 0)
		(= local0 121)
		(= local1 16)
		(SetFlag 297)
		(Robot 0 612 gThePlane 60 local0 local1) ; Open
		(Robot 1 0) ; DisplayFrame
		(SetFlag 30)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

