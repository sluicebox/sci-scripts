;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	rm14200 0
)

(instance rm14200 of ScaryRoom
	(properties
		picture 14100
		stepSound 4
		baseView 6000
	)

	(method (init)
		(proc1111_6)
		(gEgo
			init:
			setScaler: Scaler 69 35 130 93
			normalize: 613
			heading: 0
			posn: 180 125
		)
		(southExit init: 3 approachX: (gEgo x:))
		(cloud init: setCycle: Fwd setPri: 0)
		(if (< gChapter 6)
			(cloud approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(teddy init:)
		(if (and (< gChapter 6) (not (IsFlag 312)))
			(teddy approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(super init: &rest)
		(if (and (OneOf gChapter 2 3) (IsFlag 120) (not (IsFlag 119)))
			(ClearFlag 120)
			(SetFlag 119)
			(gCurRoom setScript: sChairRocks)
		else
			(chair init:)
			(if global125
				(gGame handsOn:)
			else
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
		)
		(= global125 0)
	)
)

(instance sExamineCloud of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(cloud view: (+ 14120 (== gChapter 5)) x: 123 y: 92)
					(global114 pause:)
					(teddy hide:)
					(chair hide:)
					(proc1111_7 1221 101 30)
					(gCurRoom drawPic: (+ 14120 (== gChapter 5)))
					(SetFlag 58)
				)
				(1
					(cloud view: 14200 x: 220 y: 55)
					(global114 endPause:)
					(gEgo posn: 212 103 normalize: 617)
					(teddy show:)
					(chair show:)
					(gCurRoom drawPic: 14100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(global114 endPause: 1)
					(cloud view: 14200 x: 220 y: 55)
					(proc1111_6)
					(gEgo posn: 212 103 normalize: 613)
					(teddy show:)
					(chair show:)
					(gCurRoom drawPic: 14100)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sChairRocks of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(global114 pause:)
					(Load rsPIC 14110)
					(Lock rsPIC 14110 1)
					(if (ResCheck rsAUDIO 14020)
						(Load rsAUDIO 14020)
						(Lock rsAUDIO 14020 1)
					else
						(Load 140 14020) ; WAVE
						(Lock 140 14020 1) ; WAVE
					)
					(proc1111_7 2440 -16 28)
				)
				(1
					(DoAudio 12 0) ; AudMixCheck
					(DoAudio 18 1) ; AudDACCritical
					(gGDacSound number: 14020 play:)
					(gGDacSound setLoop: 1)
				)
				(2
					(cloud hide:)
					(teddy hide:)
					(gCurRoom drawPic: 14110)
					(proc1111_7 2441 -3 -16)
				)
				(3
					(gGDacSound stop:)
				)
				(4
					(cloud show:)
					(teddy show:)
					(DoAudio 12 1) ; AudMixCheck
					(DoAudio 18 0) ; AudDACCritical
					(gCurRoom drawPic: 14100)
					(proc1111_7 2442 -6 41 gEgo -1 1)
				)
				(5
					(Lock rsPIC 14110 0)
					(if (ResCheck rsAUDIO 14020)
						(Lock rsAUDIO 14020 0)
					else
						(Lock 140 14020 0) ; WAVE
					)
					(gEgo hide:)
					(global114 endPause:)
					(gCurRoom newRoom: 15100)
				)
			)
		else
			(gGDacSound stop:)
			(proc1111_6)
			(Lock rsPIC 14110 0)
			(DoAudio 12 1) ; AudMixCheck
			(if (ResCheck rsAUDIO 14020)
				(Lock rsAUDIO 14020 0)
			else
				(Lock 140 14020 0) ; WAVE
			)
			(global114 endPause: 1)
			(= global115 0)
			(gCurRoom newRoom: 15100)
		)
	)
)

(instance cloud of Actor
	(properties
		approachX 203
		approachY 105
		x 220
		y 55
		view 14200
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 8)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sExamineCloud)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance teddy of View
	(properties
		approachX 100
		approachY 150
		x 54
		y 42
		view 14101
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global125 9)
				(gCurRoom newRoom: 14100)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chair of View
	(properties
		approachX 185
		approachY 110
		x 154
		y 98
		view 14100
	)

	(method (init)
		(if (IsFlag 119)
			(= cel 1)
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance southExit of ExitFeature
	(properties
		approachY 150
		nextRoom 14100
	)

	(method (handleEvent)
		(= approachX (gEgo x:))
		(super handleEvent: &rest)
	)
)

