;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10100)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Osc)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	rm10100 0
)

(local
	local0
	local1
)

(instance rm10100 of ScaryRoom
	(properties
		picture 10100
		stepSound 4
	)

	(method (notify)
		(gGame handsOff:)
		((self script:) changeState: 7)
		((ScriptID 0 14) dispose:) ; exitButt
	)

	(method (init)
		(if (> gChapter 5)
			(SetFlag 38)
		)
		(gEgo init: setScaler: Scaler 128 55 125 85 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(else
				(if (< global125 20)
					(switch global125
						(4
							(gEgo posn: 232 112 normalize: 7)
							(= global125 7)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(5
							(gEgo posn: 232 112 normalize: 7)
							(= global125 7)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(10
							(gEgo posn: 232 112 normalize: 7)
							(= global125 7)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(else
							(gEgo posn: 154 112 normalize: 6)
							(= global125 1)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
					)
				else
					(switch global125
						(21
							(gEgo posn: 154 112 normalize: 7)
							(= global125 1)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(25
							(gEgo posn: 68 112 normalize: 7)
							(= global125 8)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(26
							(gEgo posn: 68 112 normalize: 3)
							(= global125 8)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(29
							(gEgo posn: 68 112 normalize: 3)
							(= global125 8)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(30
							(gEgo posn: 68 112 normalize: 7)
							(= global125 8)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
						(else
							(gEgo posn: 154 112 normalize: 3)
							(= global125 1)
							(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
						)
					)
				)
			)
		)
		(if (and (not (IsFlag 38)) (!= gChapter 4))
			(bed init: setHotspot: 4 3) ; Do, Move
		)
		(dresser init: setHotspot: 4 3) ; Do, Move
		(if (or (< gChapter 6) (and (> gChapter 5) (IsFlag 379)))
			(vanity init: setHotspot: 4 3) ; Do, Move
		)
		(southwestExit init: 3 approachVerbs: 0)
		(southeastExit init: 11 approachVerbs: 0)
		(jewelryBox init:)
		(if (and (== gChapter 4) (not (IsFlag 294)))
			(necklace init:)
		)
		(if (== gChapter 5)
			(nightWindow init:)
		)
		(super init:)
	)
)

(instance sDoNecklace of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					((ScriptID 0 14) dispose:) ; exitButt
					(ClearFlag 248)
					(gGame handsOff:)
					(proc1111_9)
					(= local0 0)
					(SetFlag 294)
					(necklace view: 10191 posn: 122 116 setHotspot: 0)
					(jewelryBox view: 10190 posn: 167 117 setHotspot: 0)
					(proc1111_7 4050 -16 -42)
					(gCurRoom drawPic: 10190)
				)
				(1
					(necklace dispose:)
					(jewelryBox view: 10160 posn: 99 93)
					(proc1111_7 4051 -55 -44)
					(gCurRoom drawPic: 10160)
				)
				(2
					(jewelryBox view: 10190 posn: 167 117)
					(proc1111_7 4052 -17 -42)
					(gCurRoom drawPic: 10190)
				)
				(3
					(SetFlag 294)
					(jewelryBox view: 10100 posn: 182 73)
					(if (gCast contains: nightWindow)
						(nightWindow show:)
					)
					(gEgo
						posn: 165 91
						normalize: 4
						setScaler: Scaler 128 55 125 85
						show:
					)
					(= global125 2)
					(gCurRoom drawPic: 10100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(ClearFlag 248)
			(if local0
				(proc1111_9)
			)
			(if (gCast contains: necklace)
				(necklace dispose:)
			)
			(SetFlag 294)
			(jewelryBox view: 10100 posn: 182 73)
			(if (gCast contains: nightWindow)
				(nightWindow show:)
			)
			(gEgo
				posn: 165 91
				normalize: 4
				setScaler: Scaler 128 55 125 85
				show:
			)
			(= global125 2)
			(gCurRoom drawPic: 10100)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sDoBed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 121)
				(switch global125
					(1
						(gEgo setHeading: 0 self 15)
					)
					(2
						(gEgo setHeading: 270 self 15)
					)
					(3
						(gEgo setHeading: 270 self)
					)
					(8
						(gEgo setHeading: 90 self)
					)
					(else
						(gEgo setHeading: 315 self)
					)
				)
			)
			(1
				(gEgo
					posn: 232 112
					normalize: 1
					setScaler: Scaler 128 55 125 85
				)
				(gCurRoom drawPic: 10100)
				(UpdateScreenItem gEgo)
				(if (== gChapter 1)
					(PlayVMD 0 {740.vmd} 0) ; Open
					(proc26_0 740 self)
				else
					(PlayVMD 0 {745.vmd}) ; Open
					(proc26_0 745 self)
				)
			)
			(2
				(ClearFlag 121)
				(SetFlag 38)
				(bed setHotspot: 0)
				(gEgo
					posn: 232 112
					normalize: 1
					setScaler: Scaler 128 55 125 85
				)
				(gCurRoom drawPic: 10100)
				(UpdateScreenItem gEgo)
				(= global125 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoDresser of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 45 self)
						)
						(2
							(self changeState: 1)
						)
						(8
							(gEgo setHeading: 90 self)
						)
						(else
							(gEgo setHeading: 315 self)
						)
					)
				)
				(1
					(if (gCast contains: nightWindow)
						(nightWindow hide:)
					)
					(if (gCast contains: necklace)
						(necklace view: 10131 posn: 191 83)
					)
					(jewelryBox view: 10132 posn: 237 81)
					(proc1111_7 860 118 8)
					(gCurRoom drawPic: 10130)
				)
				(2
					(SetFlag 248)
					(SetFlag 121)
					(proc1111_8)
					(cigCase init:)
					(if (gCast contains: necklace)
						(necklace hide:)
					)
					(jewelryBox hide:)
					(theCase init: setHotspot: 4 3) ; Do, Move
					(theDrawer init: setHotspot: 4 3) ; Do, Move
					(gCurRoom drawPic: 10140)
					(gGame handsOn: 0)
				)
				(3
					(gGame handsOff:)
					(ClearFlag 248)
					(ClearFlag 121)
					(proc1111_9)
					(if (gCast contains: necklace)
						(necklace view: 10131 posn: 191 83 show:)
					)
					(jewelryBox view: 10132 posn: 237 81 show:)
					(proc1111_7 861 120 5)
					(gCurRoom drawPic: 10130)
				)
				(4
					(ClearFlag 248)
					(ClearFlag 121)
					(if (gCast contains: necklace)
						(necklace view: 10101 posn: 166 78 show:)
					)
					(jewelryBox view: 10100 posn: 182 73 show:)
					(if (gCast contains: nightWindow)
						(nightWindow show:)
					)
					(gEgo posn: 165 91 normalize: 7)
					(= global125 2)
					(gCurRoom drawPic: 10100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(ClearFlag 248)
			(ClearFlag 121)
			(if (gFeatures contains: theDrawer)
				(theDrawer dispose:)
				(theCase dispose:)
				(cigCase dispose:)
				(proc1111_9)
			)
			(if (gCast contains: necklace)
				(necklace view: 10101 posn: 166 78 show:)
			)
			(jewelryBox view: 10100 posn: 182 73 show:)
			(if (gCast contains: nightWindow)
				(nightWindow show:)
			)
			(gEgo posn: 165 91 normalize: 7)
			(= global125 2)
			(gCurRoom drawPic: 10100)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sLookCigaretteCase of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(ClearFlag 121)
					(gGame handsOff:)
					(proc1111_9)
					(theCase dispose:)
					(cigCase hide:)
					(if (gCast contains: necklace)
						(necklace view: 10131 posn: 191 83 show:)
					)
					(jewelryBox view: 10132 posn: 237 81 show:)
					(proc1111_7 4900 117 6)
					(gCurRoom drawPic: 10130)
				)
				(1
					(gEgo hide:)
					(cond
						((< gChapter 5)
							(SetFlag 260)
							(cigCase
								view: 10140
								cel: 0
								show:
								posn: 166 65
								setHotspot: 0
							)
						)
						((> gChapter 4)
							(cigCase
								view: 10140
								cel: 1
								show:
								posn: 166 65
								setHotspot: 0
							)
						)
					)
					(if (gCast contains: necklace)
						(necklace hide:)
					)
					(jewelryBox hide:)
					(gCurRoom drawPic: 10140)
					(= seconds 5)
				)
				(2
					(cigCase view: 10141 posn: 48 72 loop: 0 cel: 0 dispose:)
					(if (gCast contains: necklace)
						(necklace view: 10131 posn: 191 83 show:)
					)
					(jewelryBox view: 10132 posn: 237 81 show:)
					(cond
						((or (< gChapter 5) (IsFlag 261))
							(proc1111_7 4902 124 3)
						)
						((and (IsFlag 260) (not (IsFlag 259)))
							(SetFlag 261)
							(proc1111_7 4901 103 3)
						)
						((and (IsFlag 260) (IsFlag 259))
							(SetFlag 261)
							(proc1111_7 4903 123 4)
						)
						(else
							(SetFlag 261)
							(proc1111_7 4902 124 3)
						)
					)
					(gCurRoom drawPic: 10130)
				)
				(3
					(ClearFlag 248)
					(ClearFlag 121)
					(if (gCast contains: necklace)
						(necklace view: 10101 posn: 166 78)
					)
					(jewelryBox view: 10100 posn: 182 73)
					(if (gCast contains: nightWindow)
						(nightWindow show:)
					)
					(gEgo show: posn: 165 91 normalize: 7)
					(= global125 2)
					(gCurRoom drawPic: 10100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(ClearFlag 248)
			(ClearFlag 121)
			(if (< gChapter 5)
				(SetFlag 260)
			else
				(SetFlag 261)
			)
			(if (gCast contains: cigCase)
				(cigCase view: 10141 posn: 48 72 loop: 0 cel: 0 dispose:)
			)
			(if (gCast contains: necklace)
				(necklace view: 10101 posn: 166 78 show:)
			)
			(jewelryBox view: 10100 posn: 182 73 show:)
			(if (gCast contains: nightWindow)
				(nightWindow show:)
			)
			(gEgo show: posn: 165 91 normalize: 7)
			(= global125 2)
			(gCurRoom drawPic: 10100)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sDoVanity of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 45 self)
						)
						(2
							(gEgo setHeading: 90 self 15)
						)
						(3
							(gEgo setHeading: 45 self 15)
						)
						(8
							(gEgo setHeading: 90 self)
						)
						(else
							(gEgo setHeading: 315 self)
						)
					)
				)
				(1
					(if (gCast contains: nightWindow)
						(nightWindow hide:)
					)
					(if (gCast contains: necklace)
						(necklace view: 10181 posn: 112 86)
					)
					(jewelryBox hide:)
					(proc1111_7 844 2 16)
					(gCurRoom drawPic: 10180)
				)
				(2
					(proc1111_8)
					(= local0 1)
					(gEgo hide:)
					(if (gCast contains: necklace)
						(necklace view: 10161 posn: 36 116 setHotspot: 4 3) ; Do, Move
					)
					(jewelryBox
						show:
						view: 10160
						posn: 99 93
						cel: 0
						setHotspot: 4 3 ; Do, Move
					)
					(SetFlag 248)
					(gGame handsOn: 0)
					(gCurRoom drawPic: 10160)
					((ScriptID 0 14) init:) ; exitButt
				)
				(3
					(gGame handsOff:)
					((ScriptID 0 14) dispose:) ; exitButt
					(if (gCast contains: necklace)
						(necklace view: 10181 posn: 112 86 setHotspot: 0)
					)
					(jewelryBox hide: setHotspot: 0)
					(if (> gChapter 5)
						(self changeState: 10)
					else
						(proc1111_7 845 2 16)
					)
					(= local1 1)
					(gCurRoom drawPic: 10180)
				)
				(4
					(ring init: setHotspot: 4 3) ; Do, Move
					(theLid init: setHotspot: 4 3) ; Do, Move
					(if (gCast contains: necklace)
						(necklace view: 10161 posn: 36 116)
					)
					(SetFlag 297)
					(SetFlag 121)
					(WalkieTalkie showFrame: 842 0 -4 -9)
					(gGame handsOn: 0)
					(gCurRoom drawPic: 10160)
				)
				(5
					(gGame handsOff:)
					(ClearFlag 297)
					(ClearFlag 121)
					(SetFlag 379)
					(theLid dispose:)
					(ring dispose:)
					(jewelryBox hide:)
					(proc1111_6)
					(proc1111_7 842 -4 -9)
				)
				(6
					(jewelryBox hide:)
					(if (gCast contains: necklace)
						(necklace view: 10181 posn: 112 86)
					)
					(= local1 0)
					(proc1111_7 846 2 16)
					(gCurRoom drawPic: 10180)
				)
				(7
					(proc1111_9)
					(= local0 0)
					(jewelryBox hide: setHotspot: 0)
					(if (gCast contains: necklace)
						(necklace view: 10181 posn: 112 86 setHotspot: 0)
					)
					(proc1111_7 847 2 16)
					(gCurRoom drawPic: 10180)
				)
				(8
					(jewelryBox view: 10100 posn: 182 73 show:)
					(if (gCast contains: necklace)
						(necklace view: 10101 posn: 166 78)
					)
					(if (gCast contains: nightWindow)
						(nightWindow show:)
					)
					(ClearFlag 248)
					(gEgo
						show:
						posn: 185 93
						normalize: 5
						setScaler: Scaler 128 55 125 85
						cel: 8
						setCycle: End self
					)
					(= global125 3)
					(gCurRoom drawPic: 10100)
				)
				(9
					(gGame handsOn:)
					(self dispose:)
				)
				(10
					(proc1111_9)
					(= local0 0)
					(proc1111_7 843 2 16)
				)
				(11
					(jewelryBox view: 10100 posn: 182 73 show:)
					(if (gCast contains: necklace)
						(necklace view: 10101 posn: 166 78)
					)
					(if (gCast contains: nightWindow)
						(nightWindow show:)
					)
					(ClearFlag 248)
					(gEgo
						show:
						normalize: 5
						posn: 185 93
						setScaler: Scaler 128 55 125 85
						cel: 8
						setCycle: End self
					)
					(= global125 3)
					(gCurRoom drawPic: 10100)
				)
				(12
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(ClearFlag 248)
			(= local1 0)
			(if local0
				(proc1111_9)
				(= local0 0)
			)
			(jewelryBox view: 10100 posn: 182 73 show:)
			(if (gCast contains: necklace)
				(necklace view: 10101 posn: 166 78)
			)
			(if (gFeatures contains: theLid)
				(theLid dispose:)
			)
			(if (gFeatures contains: ring)
				(ring dispose:)
			)
			(if (gCast contains: nightWindow)
				(nightWindow show:)
			)
			(gEgo
				show:
				posn: 185 93
				normalize: 5
				setScaler: Scaler 128 55 125 85
			)
			(= global125 3)
			(gCurRoom drawPic: 10100)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sExitSouthWest of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 180 self)
				)
				(1
					(gCurRoom newRoom: 10200)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(gCurRoom newRoom: 10200)
		)
	)
)

(instance sExitSouthEast of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 135 self)
				)
				(1
					(+= global125 20)
					(gCurRoom newRoom: 10200)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (< global125 20)
				(+= global125 20)
			)
			(gCurRoom newRoom: 10200)
		)
	)
)

(instance necklace of Prop
	(properties
		x 166
		y 78
		priority 70
		fixPriority 1
		view 10101
		cycleSpeed 10
	)

	(method (init)
		(super init:)
		(self setCycle: Osc cycleSpeed: 10)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sDoNecklace)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cigCase of View
	(properties
		x 48
		y 72
		view 10141
	)
)

(instance nightWindow of View
	(properties
		x 90
		y 33
		view 10100
		loop 1
	)
)

(instance theCase of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 91 37 116 37 122 56 95 58 91 38
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(theDrawer dispose:)
			(gCurRoom setScript: sLookCigaretteCase)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance ring of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 131 81 146 81 147 76 142 69 130 69 129 75 132 81
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			((gCurRoom script:) cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance jewelryBox of View
	(properties
		x 182
		y 73
		priority 80
		fixPriority 1
		view 10100
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			((gCurRoom script:) cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vanity of Feature
	(properties
		nsLeft 174
		nsTop 65
		nsRight 205
		nsBottom 77
		approachX 175
		approachY 91
		x 189
		y 73
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sDoVanity)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bed of Feature
	(properties
		nsLeft 55
		nsTop 69
		nsRight 135
		nsBottom 95
		approachX 138
		approachY 108
		x 95
		y 82
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sDoBed)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance dresser of Feature
	(properties
		nsLeft 140
		nsTop 58
		nsRight 164
		nsBottom 80
		approachX 162
		approachY 85
		x 152
		y 69
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sDoDresser)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theDrawer of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 79 283 62 259 93 0 118
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(theCase dispose:)
			(cigCase dispose:)
			(gGame handsOff:)
			((gCurRoom script:) cue:)
			(self dispose:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theLid of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 123 17 205 37 196 72 120 52
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(ring dispose:)
			(gGame handsOff:)
			(ClearFlag 121)
			((gCurRoom script:) changeState: 6)
			(self dispose:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance southwestExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 123
		nsRight 147
		nsBottom 129
		x 147
		y 126
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthWest)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southeastExit of ExitFeature
	(properties
		nsLeft 147
		nsTop 123
		nsRight 294
		nsBottom 129
		x 147
		y 126
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthEast)
		else
			(super doVerb: theVerb)
		)
	)
)

