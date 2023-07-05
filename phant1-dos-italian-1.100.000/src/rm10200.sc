;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Osc)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm10200 0
)

(instance rm10200 of ScaryRoom
	(properties
		picture 10260
		stepSound 4
	)

	(method (notify)
		((gCurRoom script:) cue:)
	)

	(method (init)
		(switch gPrevRoomNum
			(900
				(proc1111_6)
				(switch global125
					(44
						(gEgo
							view: 770
							setScaler: 0
							cycleSpeed: 6
							loop: 0
							cel: 100
							posn: 167 88
							init:
							setCycle: 0
						)
						(= picture 10200)
						(gCurRoom setScript: sRestore)
					)
					(46
						(gEgo
							view: 790
							setScaler: 0
							cycleSpeed: 6
							loop: 0
							cel: 100
							posn: 246 85
							init:
							setPri: 185
							setCycle: 0
						)
						(= picture 10200)
						(gCurRoom setScript: sRestore)
					)
					(else
						(gEgo
							init:
							setScaler: Scaler 116 53 114 65
							normalize:
						)
						(gGame handsOn:)
					)
				)
			)
			(10100
				(gEgo init: setScaler: Scaler 116 53 114 65 normalize:)
				(if (< global125 20)
					(switch global125
						(1
							(gEgo posn: 227 121 normalize: 6)
							(= global125 9)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(2
							(gEgo posn: 101 115 normalize: 6)
							(= global125 5)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(8
							(gEgo posn: 227 121 normalize: 6)
							(= global125 9)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(else
							(gEgo posn: 188 115 normalize: 6)
							(= global125 6)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
					)
				else
					(switch global125
						(21
							(gEgo posn: 101 115 normalize: 7)
							(= global125 5)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(28
							(gEgo posn: 41 121 normalize: 7)
							(= global125 10)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(else
							(gEgo posn: 41 121 normalize: 6)
							(= global125 10)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
					)
				)
			)
			(else
				(gEgo init: setScaler: Scaler 116 53 114 65 normalize:)
				(gGame handsOff:)
				(gCurRoom setScript: sFromDoor)
				(= picture 10200)
			)
		)
		(door init: 1 approachVerbs: 0)
		(if (< gChapter 6)
			(chair init: setHotspot: 4 3) ; Do, Move
			(sofa init: setHotspot: 4 3) ; Do, Move
		)
		(portrait init: setHotspot: 4 3) ; Do, Move
		(southwestExit init: 12 approachVerbs: 0)
		(southeastExit init: 3 approachVerbs: 0)
		(super init:)
	)
)

(instance sFromDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(necklace init:)
					)
					(jBox init:)
					(proc1111_7 730 161 13)
				)
				(1
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(gGDacSound
							number: 10040
							init:
							setVol: 100
							setLoop: 1
							play:
						)
					)
				)
				(2
					(if (gCast contains: necklace)
						(necklace dispose:)
					)
					(jBox dispose:)
					(gEgo
						posn: 101 115
						normalize: 5
						cel: 0
						setCycle: End self
					)
					(= global125 5)
					(gCurRoom drawPic: 10260)
				)
				(3
					(gEgo setCycle: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (gCast contains: necklace)
				(necklace dispose:)
			)
			(if (gCast contains: jBox)
				(jBox dispose:)
			)
			(gEgo posn: 101 115 normalize: 5)
			(= global125 5)
			(gCurRoom drawPic: 10260)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sLookAtPortrait of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(Load rsAUDIO 3019)
					(switch global125
						(4
							(gEgo setHeading: 270 self 15)
						)
						(10
							(gEgo setHeading: 0 self 10)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(necklace init:)
					)
					(jBox init:)
					(gEgo
						view: 10201
						posn: 146 92
						loop: 0
						cel: 0
						setScaler: 0
						setCycle: End self
					)
					(gCurRoom drawPic: 10200)
				)
				(2
					(gGDacSound
						number: 3019
						init:
						setVol: 127
						setLoop: 1
						play: self
					)
					(global114 pause:)
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(necklace hide:)
					)
					(jBox hide:)
					(gEgo hide:)
					(gCurRoom drawPic: 10120)
				)
				(3
					(global114 endPause:)
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(necklace show:)
					)
					(jBox show:)
					(gEgo
						view: 10201
						posn: 146 92
						loop: 1
						cel: 0
						setScaler: 0
						setCycle: End self
						show:
					)
					(gCurRoom drawPic: 10200)
				)
				(4
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(necklace dispose:)
					)
					(jBox dispose:)
					(gEgo
						posn: 89 109
						normalize: 4
						setScaler: Scaler 116 53 114 65
					)
					(= global125 4)
					(gCurRoom drawPic: 10260)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (== (gGDacSound number:) 3019)
				(gGDacSound stop:)
			)
			(global114 endPause: 1)
			(if (gCast contains: jBox)
				(jBox dispose:)
			)
			(if (gCast contains: necklace)
				(necklace dispose:)
			)
			(gEgo show: posn: 89 109 normalize: 4)
			(= global125 4)
			(gCurRoom drawPic: 10260)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sRestore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(proc1111_8)
				(floor init: setHotspot: 4 3) ; Do, Move
				(gGame handsOn: 0)
				(SetFlag 121)
				(switch global125
					(44
						(gEgo
							view: 770
							setScaler: 0
							cycleSpeed: 6
							loop: 0
							cel: 100
							posn: 167 88
							init:
							setCycle: 0
						)
						(gCurRoom setScript: sChairFidget)
					)
					(46
						(gEgo
							view: 790
							setScaler: 0
							cycleSpeed: 6
							loop: 0
							cel: 100
							posn: 246 85
							init:
							setPri: 185
							setCycle: 0
						)
						(gCurRoom setScript: sSofaFidget)
					)
				)
			)
		)
	)
)

(instance sSitDownOnChair of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(4
							(self changeState: 1)
						)
						(5
							(gEgo setHeading: 0 self)
						)
						(10
							(gEgo setHeading: 0 self)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(necklace init:)
					)
					(jBox init:)
					(= global125 44)
					(gEgo
						view: 770
						cycleSpeed: 6
						loop: 0
						cel: 0
						setScaler: 0
						posn: 167 88
						setScaler: 0
						setCycle: End self
					)
					(gCurRoom drawPic: 10200)
				)
				(2
					(proc1111_8)
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(necklace posn: 4 74)
					)
					(jBox posn: 10 74)
					(gEgo posn: 167 88)
					(floor init: setHotspot: 4 3) ; Do, Move
					(gGame handsOn: 0)
					(SetFlag 121)
					(gCurRoom setScript: sChairFidget)
				)
			)
		else
			(= global115 0)
			(= global125 44)
			(proc1111_8)
			(if (and (== gChapter 4) (not (IsFlag 294)))
				(necklace posn: 4 74)
			)
			(jBox posn: 10 74)
			(floor init: setHotspot: 4 3) ; Do, Move
			(gGame handsOn: 0)
			(gEgo
				view: 770
				loop: 0
				cel: 100
				posn: 167 88
				setScaler: 0
				setCycle: 0
			)
			(gCurRoom drawPic: 10200)
			(SetFlag 121)
			(gCurRoom setScript: sChairFidget)
		)
	)
)

(instance sChairFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (* (Random 1 3) 180))
			)
			(1
				(switch (Random 1 4)
					(1
						(self changeState: 2)
					)
					(2
						(self changeState: 5)
					)
					(3
						(self changeState: 8)
					)
					(4
						(self changeState: 11)
					)
				)
			)
			(2
				(gEgo
					view: 770
					cycleSpeed: 6
					loop: 1
					cel: 0
					posn: 167 88
					setScaler: 0
					setCycle: End self
				)
			)
			(3
				(= ticks (* (Random 1 3) 180))
			)
			(4
				(switch (Random 1 3)
					(1
						(self changeState: 5)
					)
					(2
						(self changeState: 8)
					)
					(3
						(self changeState: 11)
					)
				)
			)
			(5
				(gEgo
					view: 770
					cycleSpeed: 6
					loop: 2
					cel: 0
					posn: 167 88
					setScaler: 0
					setCycle: End self
				)
			)
			(6
				(= ticks (* (Random 1 3) 180))
			)
			(7
				(switch (Random 1 3)
					(1
						(self changeState: 2)
					)
					(2
						(self changeState: 8)
					)
					(3
						(self changeState: 11)
					)
				)
			)
			(8
				(gEgo
					view: 770
					cycleSpeed: 6
					loop: 3
					cel: 0
					posn: 167 88
					setScaler: 0
					setCycle: End self
				)
			)
			(9
				(= ticks (* (Random 1 3) 180))
			)
			(10
				(switch (Random 1 3)
					(1
						(self changeState: 2)
					)
					(2
						(self changeState: 5)
					)
					(3
						(self changeState: 11)
					)
				)
			)
			(11
				(gEgo
					view: 770
					cycleSpeed: 6
					loop: 4
					cel: 0
					posn: 167 88
					setScaler: 0
					setCycle: End self
				)
			)
			(12
				(= ticks (* (Random 1 3) 180))
			)
			(13
				(switch (Random 1 3)
					(1
						(self changeState: 2)
					)
					(2
						(self changeState: 5)
					)
					(3
						(self changeState: 8)
					)
				)
			)
		)
	)
)

(instance sSitDownOnSofa of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(6
							(self changeState: 1)
						)
						(9
							(gEgo setHeading: 270 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(necklace init:)
					)
					(jBox init:)
					(gEgo
						view: 790
						setScaler: 0
						cycleSpeed: 6
						loop: 0
						cel: 0
						posn: 246 85
						setScaler: 0
						setPri: 185
						setCycle: End self
					)
					(gCurRoom drawPic: 10200)
				)
				(2
					(= global125 46)
					(proc1111_8)
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(necklace posn: 4 74)
					)
					(jBox posn: 10 74)
					(gEgo posn: 246 85)
					(floor init: setHotspot: 4 3) ; Do, Move
					(gGame handsOn: 0)
					(SetFlag 121)
					(gCurRoom setScript: sSofaFidget)
				)
			)
		else
			(= global115 0)
			(= global125 46)
			(proc1111_8)
			(if (and (== gChapter 4) (not (IsFlag 294)))
				(necklace posn: 4 74)
			)
			(jBox posn: 10 74)
			(floor init: setHotspot: 4 3) ; Do, Move
			(gGame handsOn: 0)
			(gEgo
				view: 790
				setScaler: 0
				cycleSpeed: 6
				loop: 0
				cel: 100
				posn: 246 85
				setPri: 185
				setScaler: 0
				setCycle: 0
			)
			(gCurRoom drawPic: 10200)
			(SetFlag 121)
			(gCurRoom setScript: sSofaFidget)
		)
	)
)

(instance sSofaFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (* (Random 1 3) 180))
			)
			(1
				(switch (Random 1 4)
					(1
						(self changeState: 2)
					)
					(2
						(self changeState: 5)
					)
					(3
						(self changeState: 8)
					)
					(4
						(self changeState: 11)
					)
				)
			)
			(2
				(gEgo
					view: 790
					cycleSpeed: 6
					loop: 1
					cel: 0
					posn: 246 85
					setScaler: 0
					setPri: 185
					setCycle: End self
				)
			)
			(3
				(= ticks (* (Random 1 3) 180))
			)
			(4
				(switch (Random 1 3)
					(1
						(self changeState: 5)
					)
					(2
						(self changeState: 8)
					)
					(3
						(self changeState: 11)
					)
				)
			)
			(5
				(gEgo
					view: 790
					cycleSpeed: 6
					loop: 2
					cel: 0
					posn: 246 85
					setScaler: 0
					setPri: 185
					setCycle: End self
				)
			)
			(6
				(= ticks (* (Random 1 3) 180))
			)
			(7
				(switch (Random 1 3)
					(1
						(self changeState: 2)
					)
					(2
						(self changeState: 8)
					)
					(3
						(self changeState: 11)
					)
				)
			)
			(8
				(gEgo
					view: 790
					cycleSpeed: 6
					loop: 3
					cel: 0
					posn: 246 85
					setScaler: 0
					setPri: 185
					setCycle: End self
				)
			)
			(9
				(= ticks (* (Random 1 3) 180))
			)
			(10
				(switch (Random 1 3)
					(1
						(self changeState: 2)
					)
					(2
						(self changeState: 5)
					)
					(3
						(self changeState: 11)
					)
				)
			)
			(11
				(gEgo
					view: 790
					cycleSpeed: 6
					loop: 4
					cel: 0
					posn: 246 85
					setScaler: 0
					setPri: 185
					setCycle: End self
				)
			)
			(12
				(= ticks (* (Random 1 3) 180))
			)
			(13
				(switch (Random 1 3)
					(1
						(self changeState: 2)
					)
					(2
						(self changeState: 5)
					)
					(3
						(self changeState: 8)
					)
				)
			)
		)
	)
)

(instance sStandUp of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(floor dispose:)
					(proc1111_9)
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(necklace posn: 4 74)
					)
					(jBox posn: 10 74)
					(if (== global125 44)
						(gEgo
							view: 770
							cycleSpeed: 6
							loop: 0
							cel: 100
							posn: 167 88
							setScaler: 0
							setCycle: Beg self
						)
					else
						(gEgo
							view: 790
							cycleSpeed: 6
							loop: 0
							cel: 100
							posn: 246 85
							setScaler: 0
							setCycle: Beg self
							setPri: 185
						)
					)
				)
				(1
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(necklace dispose:)
					)
					(jBox dispose:)
					(if (== global125 44)
						(gEgo
							show:
							posn: 89 109
							setScaler: Scaler 116 53 114 65
							normalize: 2
						)
						(= global125 4)
					else
						(gEgo
							show:
							posn: 188 115
							setScaler: Scaler 116 53 114 65
							normalize: 2
							setPri: -1
						)
						(= global125 6)
					)
					(gCurRoom drawPic: 10260)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(ClearFlag 121)
			(if (gFeatures contains: floor)
				(floor dispose:)
				(proc1111_9)
			)
			(if (and (== gChapter 4) (not (IsFlag 294)))
				(necklace posn: 4 74 dispose:)
			)
			(jBox posn: 10 74 dispose:)
			(if (== global125 44)
				(gEgo
					posn: 89 109
					setScaler: Scaler 116 53 114 65
					normalize: 2
					show:
				)
				(= global125 4)
			else
				(gEgo
					posn: 188 115
					setScaler: Scaler 116 53 114 65
					normalize: 2
					setPri: -1
					show:
				)
				(= global125 6)
			)
			(gCurRoom drawPic: 10260)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sToDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(4
							(gEgo setHeading: 90 self)
						)
						(5
							(gEgo setHeading: 45 self)
						)
						(10
							(gEgo setHeading: 45 self 15)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(gEgo hide:)
					(if (and (== gChapter 4) (not (IsFlag 294)))
						(necklace init:)
					)
					(jBox init:)
					(proc1111_7 740 167 16 gEgo -1 1)
					(gCurRoom drawPic: 10200)
				)
				(2
					(= global125 0)
					(gCurRoom newRoom: 13100)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(= global125 0)
			(gCurRoom newRoom: 13100)
		)
	)
)

(instance sExitSouthWest of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 225 self)
				)
				(1
					(gCurRoom newRoom: 10100)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(gCurRoom newRoom: 10100)
		)
	)
)

(instance sExitSouthEast of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(10
							(gEgo setHeading: 135 self)
						)
						(else
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(+= global125 20)
					(gCurRoom newRoom: 10100)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (< global125 20)
				(+= global125 20)
			)
			(gCurRoom newRoom: 10100)
		)
	)
)

(instance necklace of Prop
	(properties
		x 4
		y 74
		view 10200
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 10 setCycle: Osc)
	)
)

(instance jBox of Prop
	(properties
		x 10
		y 74
		view 10200
	)
)

(instance floor of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 121 86 156 85 159 88 179 88 180 86 191 86 202 88 226 90 224 93 238 94 243 93 254 96 292 97 292 129 118 129 110 124 107 103 110 90 120 90 120 86
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= global115 0)
			(ClearFlag 121)
			(gGame handsOff:)
			(gCurRoom setScript: sStandUp)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance portrait of Feature
	(properties
		nsLeft 15
		nsTop 12
		nsRight 56
		nsBottom 62
		x 35
		y 37
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sLookAtPortrait)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sofa of Feature
	(properties
		nsLeft 174
		nsTop 77
		nsRight 246
		nsBottom 108
		x 210
		y 92
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sSitDownOnSofa)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance chair of Feature
	(properties
		nsLeft 78
		nsTop 57
		nsRight 102
		nsBottom 99
		x 90
		y 78
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sSitDownOnChair)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 209
		nsTop 27
		nsRight 235
		nsBottom 65
		x 222
		y 46
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sToDoor)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southwestExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 120
		nsRight 147
		nsBottom 129
		x 147
		y 126
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sExitSouthWest)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southeastExit of ExitFeature
	(properties
		nsLeft 147
		nsTop 120
		nsRight 294
		nsBottom 129
		x 147
		y 126
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sExitSouthEast)
		else
			(super doVerb: theVerb)
		)
	)
)

