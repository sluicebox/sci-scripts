;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3800)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	rm3800 0
)

(local
	local0
	local1
)

(instance rm3800 of ScaryRoom
	(properties
		stepSound 4
	)

	(method (init)
		(= picture (+ 3800 (== gChapter 5)))
		((ScriptID 30) init:) ; FidgetCode
		(gEgo init: setScaler: Scaler 133 55 105 72 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(3200
				(switch global125
					(9
						(gEgo posn: 250 104 normalize: 5)
						(= global125 12)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(10
						(gEgo posn: 250 104 normalize: 5)
						(= global125 12)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(else
						(gEgo posn: 160 92 normalize: 2)
						(= global125 11)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
				)
			)
			(3700
				(switch global125
					(13
						(gEgo posn: 250 104 normalize: 5)
						(= global125 12)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(14
						(gEgo posn: 160 92 normalize: 2)
						(= global125 11)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(else
						(gEgo posn: 160 92 normalize: 4)
						(= global125 11)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
				)
			)
		)
		(if (global114 script:)
			(if (and (not (IsFlag 376)) (not global184))
				(keys
					view: (+ 3802 (== gChapter 5))
					posn: 118 105
					init:
					cycleSpeed: 5
					setCycle: RandCycle
				)
			)
		else
			(harpSwitch init: setHotspot: 4 3) ; Do, Move
		)
		(northExit init: 1 approachVerbs: 0)
		(if (not (IsFlag 376))
			(gGDacSound number: 2010 init: setVol: 25 setLoop: -1 play:)
		)
		(super init:)
	)

	(method (doit)
		(if (and (not (global114 script:)) (gCast contains: keys))
			(keys dispose:)
			(harpSwitch init: setHotspot: 4 3) ; Do, Move
		)
		(super doit: &rest)
	)
)

(instance sDoHarpy of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(Load rsVIEW 3880)
					(cond
						((< (= local0 (Random 0 1000)) 333)
							(Load rsSOUND 3014)
							(= local1 3014)
						)
						((< local0 666)
							(Load rsSOUND 3015)
							(= local1 3015)
						)
						(else
							(Load rsSOUND 3016)
							(= local1 3016)
						)
					)
					(switch global125
						(11
							(gEgo setHeading: 180 self 19)
						)
						(else
							(gEgo setHeading: 270 self 13)
						)
					)
				)
				(1
					(gEgo hide:)
					(crank init:)
					(tdoors init:)
					(proc1111_7 520 133 18 gEgo -1 1)
					(gCurRoom drawPic: 3880)
				)
				(2
					(crank hide:)
				)
				(3
					(crank show: cel: 1)
					(keys
						init:
						view: 3880
						posn: 40 87
						cycleSpeed: 5
						setCycle: RandCycle
					)
					(global114 pause: local1)
					(global114 setVol: 120 1)
				)
				(4
					(tdoors dispose:)
					(gEgo hide:)
					(= global125 11)
					(gCurRoom newRoom: 3700)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (not (global114 script:))
				(cond
					(local1
						(global114 pause: local1)
					)
					((< (= local0 (Random 0 1000)) 333)
						(global114 pause: 3014)
					)
					((< local0 666)
						(global114 pause: 3015)
					)
					(else
						(global114 pause: 3016)
					)
				)
			)
			(tdoors dispose:)
			(global114 setVol: 120 1)
			(= global125 11)
			(gCurRoom newRoom: 3700)
		)
	)
)

(instance sExitDining of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(12
							(gEgo setHeading: 315 self)
						)
						(11
							(gEgo setHeading: 45 self)
						)
					)
				)
				(1
					(= global125 0)
					(gCurRoom newRoom: 2200)
				)
			)
		else
			(= global115 0)
			(= global125 0)
			(gCurRoom newRoom: 2200)
		)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 0 self)
				)
				(1
					(gCurRoom newRoom: 3700)
				)
			)
		else
			(= global115 0)
			(gCurRoom newRoom: 3700)
		)
	)
)

(instance keys of Prop
	(properties
		x 40
		y 96
		priority 200
		fixPriority 1
		view 3880
	)
)

(instance tdoors of View
	(properties
		x 171
		priority 1
		fixPriority 1
		view 3882
	)

	(method (init)
		(if (> gChapter 5)
			(super init: &rest)
		)
	)
)

(instance crank of View
	(properties
		x 151
		y 80
		priority 200
		fixPriority 1
		view 520
	)
)

(instance harpSwitch of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 172 84 170 80 158 76 117 92 129 103 131 113
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sDoHarpy)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance ExitDining of ExitFeature ; UNUSED
	(properties
		nsLeft 222
		nsTop 41
		nsRight 237
		nsBottom 63
		x 229
		y 52
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitDining)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance northExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 161 95 291 95 292 66 144 58 144 66 160 66 174 82
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitNorth)
		else
			(super doVerb: theVerb)
		)
	)
)

