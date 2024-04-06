;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6500)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm6500 0
)

(local
	local0
)

(procedure (localproc_0)
	(if (== gChapter 5)
		(bible view: 6609)
		(chest view: 6609)
	else
		(bible view: 6608)
		(chest view: 6608)
	)
	(if (IsFlag 209)
		(bible posn: 196 66)
		(chest setCel: 0)
	)
	(if (IsFlag 206)
		(chest setCel: 3 posn: 157 123)
	else
		(chest posn: 148 88)
	)
)

(procedure (localproc_1)
	(if (== gChapter 5)
		(bible view: -486)
		(chest view: -486)
	else
		(bible view: -535)
		(chest view: -535)
	)
	(if (IsFlag 209)
		(bible posn: 90 63)
		(chest setCel: 3)
	)
	(if (IsFlag 206)
		(chest setCel: 5 posn: 88 125)
	else
		(chest posn: 67 83)
	)
)

(procedure (localproc_2)
	(if (IsFlag 209)
		(bible hide:)
	)
	(chest hide:)
)

(procedure (localproc_3)
	(chest show:)
	(if (IsFlag 209)
		(bible show:)
	)
)

(instance rm6500 of ScaryRoom
	(properties
		picture 6500
		stepSound 4
	)

	(method (drawPic param1)
		(if (and (ResCheck rsPIC (+ param1 5)) (== gChapter 5))
			(super drawPic: (+ param1 5) &rest)
		else
			(super drawPic: param1 &rest)
		)
	)

	(method (notify)
		(gGame handsOff:)
		((ScriptID 0 14) dispose:) ; exitButt
		(ClearFlag 248)
		((gCurRoom script:) cue:)
	)

	(method (init)
		(gEgo
			init:
			setScale: 0
			setScaler: Scaler 140 98 126 102
			normalize: 1
		)
		(if global184
			(global114 endPause:)
		)
		(if (!= gPrevRoomNum 6400)
			(global114 stop: 1 play: 6005)
		)
		(SetFlag 208)
		(if (IsFlag 209)
			(chest setCel: 3 setPri: 115 init:)
			(bible approachVerbs: 0 setHotspot: 4 3 init:) ; Do, Move
		else
			(chest setPri: 115 init:)
		)
		(switch gPrevRoomNum
			(900
				(if (and (== (gEgo x:) 238) (== (gEgo y:) 125))
					(gEgo setScaler: Scaler 90 76 126 114)
					(altarExit init: 4)
				else
					(chest approachVerbs: 0 setHotspot: 4 3) ; Do, Move
				)
				(gGame handsOn:)
			)
			(6400
				(altarExit init: 4)
				(gEgo
					normalize: 7
					posn: 238 125
					setScaler: Scaler 104 83 119 105
					show:
				)
				(if (== global125 9)
					(= global125 0)
					(gCurRoom setScript: toLibScr)
				else
					(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
				)
			)
			(36300
				(KillRobot)
				(gEgo hide:)
				(= picture 6570)
				(secretDoor init: setPri: 90 cel: 100)
				(WalkieTalkie showFrame: 6571 0 -6 -15 12)
				(self setScript: fromCryptScr)
			)
			(else
				(KillRobot)
				(= picture 6400)
				(if (== gChapter 7)
					(chest view: 64001 x: 280 y: 123 setPri: 300)
				else
					(chest hide:)
				)
				(if (gCast contains: bible)
					(bible hide:)
				)
				(gCurRoom setScript: enterScr)
			)
		)
		(fireplaceExit init: 2)
		(if (IsFlag 215)
			(passageExit init: 11)
			(cryptExit init: setHotspot: 4 3) ; Do, Move
		)
		(super init: &rest)
	)

	(method (dispose)
		(if global184
			(global114 pause: 3020 0 -1)
			(global114 setVol: (= global184 31) 1)
		)
		(super dispose: &rest)
	)
)

(instance enterScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 2130 71 51 gEgo 119)
				)
				(1
					(gEgo
						normalize: 1
						posn: 238 125
						setScaler: Scaler 90 76 126 114
					)
					(altarExit init: 4)
					(localproc_3)
					(localproc_1)
					(gCurRoom drawPic: 6500)
					(= cycles 2)
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(localproc_3)
					(localproc_1)
					(gEgo
						normalize: 1
						posn: 238 125
						setScaler: Scaler 90 76 126 114
					)
					(altarExit init: 4)
					(gCurRoom drawPic: 6500)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sSpellBookGone of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(localproc_0)
					(DoRobot 2179 136 49)
					(gCurRoom drawPic: 6600)
				)
				(1
					(localproc_1)
					(gEgo
						normalize: 1
						posn: 106 118
						setScaler: Scaler 140 98 126 102
						show:
					)
					(gCurRoom drawPic: 6500)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(localproc_1)
					(gEgo
						normalize: 1
						posn: 106 118
						setScaler: Scaler 140 98 126 102
						show:
					)
					(gCurRoom drawPic: 6500)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance toAltarScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(localproc_0)
					(if (not (IsFlag 412))
						(SetFlag 412)
						(DoRobot 2131 144 40)
					else
						(DoRobot 2132 144 42)
					)
					(gCurRoom drawPic: 6600)
				)
				(1
					(localproc_1)
					(chest approachVerbs: 0 setHotspot: 4 3) ; Do, Move
					(gEgo
						normalize: 1
						posn: 106 118
						setScaler: Scaler 140 98 126 102
						show:
					)
					(altarExit dispose:)
					(gCurRoom drawPic: 6500)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(SetFlag 208)
					(localproc_1)
					(chest approachVerbs: 0 setHotspot: 4 3) ; Do, Move
					(gEgo
						normalize: 1
						posn: 106 118
						setScaler: Scaler 140 98 126 102
						show:
					)
					(altarExit dispose:)
					(gCurRoom drawPic: 6500)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance toLibScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(cond
						((and (== (gEgo x:) 68) (== (gEgo y:) 100))
							(gEgo setHeading: 180 self)
						)
						((and (== (gEgo x:) 238) (== (gEgo y:) 125))
							(gEgo setHeading: 45 self 10)
						)
						(else
							(localproc_0)
							(DoRobot 2242 164 46)
							(gCurRoom drawPic: 6600)
						)
					)
				)
				(1
					(localproc_2)
					(gEgo hide:)
					(chest view: 64001 x: 280 y: 123 setPri: 300 show:)
					(DoRobot 2240 66 51 gEgo 119 1)
					(gCurRoom drawPic: 6400)
				)
				(2
					(gCurRoom newRoom: 5100)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gEgo hide:)
					(KillRobot)
					(gCurRoom newRoom: 5100)
				)
			)
		)
	)
)

(instance toPassageScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(Load 140 6021) ; WAVE
					(cond
						((and (== (gEgo x:) 68) (== (gEgo y:) 100))
							(gEgo setHeading: 180 self)
						)
						((and (== (gEgo x:) 238) (== (gEgo y:) 125))
							(gEgo setHeading: 90 self)
						)
						(else
							(gEgo hide:)
							(localproc_0)
							(gCurRoom drawPic: 6600)
							(DoRobot 2242 164 46 gEgo -1 1)
						)
					)
				)
				(1
					(gCurRoom newRoom: 6400)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gCurRoom newRoom: 6400)
				)
			)
		)
	)
)

(instance toCryptScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(Load 140 6021) ; WAVE
					(if (== gChapter 5)
						(Load rsVIEW 6575)
					else
						(Load rsVIEW 6570)
					)
					(cond
						((and (== (gEgo x:) 68) (== (gEgo y:) 100))
							(gEgo setHeading: 180 self)
						)
						((and (== (gEgo x:) 238) (== (gEgo y:) 125))
							(gEgo setHeading: 0 self)
						)
						(else
							(localproc_0)
							(gCurRoom drawPic: 6600)
							(DoRobot 2242 164 46)
						)
					)
				)
				(1
					(Load 140 6021) ; WAVE
					(gEgo hide:)
					(localproc_2)
					(secretDoor init: cel: 100)
					(gCurRoom drawPic: 6570)
					(DoRobot 6570 14 12 gEgo 120 1)
				)
				(2
					(sOpen setLoop: 1 play:)
					(secretDoor setCycle: Beg)
				)
				(3
					(sOpen stop:)
					(sOpen setLoop: 1 play:)
					(secretDoor setPri: 130 setCycle: End self)
				)
				(4)
				(5
					(sOpen stop:)
					(sClose stop:)
					(gCurRoom newRoom: 36300)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(sClose stop:)
					(sOpen stop:)
					(gCurRoom newRoom: 36300)
				)
			)
		)
	)
)

(instance fromCryptScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(localproc_2)
					(gEgo hide:)
					(if (== gChapter 5)
						(Load rsVIEW 6575)
					else
						(Load rsVIEW 6570)
					)
					(Load 140 6021) ; WAVE
					(= cycles 2)
				)
				(1
					(sOpen setLoop: 1 play:)
					(secretDoor init: cel: 100 setCycle: Beg self)
				)
				(2
					(sOpen stop:)
					(DoRobot 6571 -6 -15 gEgo 120 1)
				)
				(3
					(sOpen setLoop: 1 play:)
					(secretDoor setCycle: End self)
				)
				(4)
				(5
					(sOpen stop:)
					(sClose stop:)
					(secretDoor dispose:)
					(KillRobot)
					(gEgo
						normalize: 4
						cel: 0
						posn: 238 125
						setScaler: Scaler 104 83 119 105
						show:
						setCycle: End self
					)
					(localproc_1)
					(gCurRoom drawPic: 6500)
					(localproc_3)
					(altarExit init: 4)
				)
				(6
					(gEgo setCycle: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(sOpen stop:)
					(sClose stop:)
					(if (gCast contains: secretDoor)
						(secretDoor dispose:)
					)
					(localproc_1)
					(localproc_3)
					(gEgo
						normalize: 4
						posn: 238 125
						setScaler: Scaler 104 83 119 105
						setCycle: 0
						show:
					)
					(gCurRoom drawPic: 6500)
					(= global115 0)
					(altarExit init: 4)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance moveBibleScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(PlayVMD 0 {2140.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 2140 self)
				)
				(1
					(bible
						view: -535
						posn: 90 63
						approachVerbs: 0
						setHotspot: 4 3 ; Do, Move
						init:
					)
					(SetFlag 209)
					(chest
						view: -535
						setHotspot: 4 3 ; Do, Move
						setCel: 3
						posn: 67 83
						setPri: 111
						approachVerbs: 0
						show:
					)
					(gEgo normalize: 1 posn: 106 118)
					(gCurRoom drawPic: 6500)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(SetFlag 209)
					(if (not (gCast contains: bible))
						(bible
							view: -535
							posn: 90 63
							approachVerbs: 0
							setHotspot: 4 3 ; Do, Move
							init:
						)
					)
					(chest
						view: -535
						posn: 67 83
						setPri: 111
						setHotspot: 4 3 ; Do, Move
						setCel: 3
						approachVerbs: 0
						show:
					)
					(gEgo normalize: 1 posn: 106 118 show:)
					(gCurRoom drawPic: 6500)
					(localproc_3)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookBible1stScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(= local0 0)
					(localproc_0)
					(chest setPri: 111)
					(if (gCast contains: bible)
						(bible hide:)
					)
					(DoRobot 2152 142 36 gEgo 111)
					(gCurRoom drawPic: 6600)
				)
				(1
					(gEgo hide:)
					(gCurRoom drawPic: 6601)
					(proc1111_8)
					(= local0 1)
					(SetFlag 248)
					(gGame handsOn: 0)
					((ScriptID 0 14) init:) ; exitButt
				)
				(2
					(ClearFlag 248)
					(= local0 0)
					(proc1111_9)
					((ScriptID 0 14) dispose:) ; exitButt
					(gGame handsOff:)
					(DoRobot 2157 144 35 gEgo 111)
					(gCurRoom drawPic: 6600)
				)
				(3
					(gCurRoom drawPic: 6500)
					(localproc_1)
					(if (gCast contains: bible)
						(bible show:)
					)
					(gEgo
						normalize: 1
						posn: 106 118
						setScaler: Scaler 140 98 126 102
						show:
					)
					(SetFlag 210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(if local0
						(= local0 0)
						(proc1111_9)
					)
					(KillRobot)
					(localproc_1)
					(gCurRoom drawPic: 6500)
					(ClearFlag 248)
					((ScriptID 0 14) dispose:) ; exitButt
					(SetFlag 210)
					(if (gCast contains: bible)
						(bible show:)
					)
					(= global115 0)
					(gEgo
						normalize: 1
						posn: 106 118
						setScaler: Scaler 140 98 126 102
						show:
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookBibleStandScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(= local0 0)
					(DoRobot 2154 141 42 gEgo 120)
					(localproc_2)
					(gCurRoom drawPic: 6600)
				)
				(1
					(gEgo hide:)
					(gCurRoom drawPic: 6601)
					(= local0 1)
					(proc1111_8)
					(SetFlag 248)
					(gGame handsOn: 0)
					((ScriptID 0 14) init:) ; exitButt
				)
				(2
					((ScriptID 0 14) dispose:) ; exitButt
					(ClearFlag 248)
					(DoRobot 2155 140 44 gEgo 120)
					(gCurRoom drawPic: 6600)
				)
				(3
					(= local0 0)
					(proc1111_9)
					(localproc_1)
					(localproc_3)
					(gEgo
						normalize: 1
						posn: 106 118
						setScaler: Scaler 140 98 126 102
						show:
					)
					(gCurRoom drawPic: 6500)
					(SetFlag 210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(ClearFlag 248)
					(if local0
						(= local0 0)
						(proc1111_9)
					)
					(localproc_1)
					(localproc_3)
					(if (gFeatures contains: (ScriptID 0 14)) ; exitButt
						((ScriptID 0 14) dispose:) ; exitButt
					)
					(gEgo
						normalize: 1
						posn: 106 118
						setScaler: Scaler 140 98 126 102
						show:
					)
					(gCurRoom drawPic: 6500)
					(SetFlag 210)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookBibleNextScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(= local0 0)
					(localproc_0)
					(chest setPri: 111)
					(DoRobot 2160 148 45 gEgo 111)
					(gCurRoom drawPic: 6600)
				)
				(1
					(gEgo hide:)
					(gCurRoom drawPic: 6601)
					(= local0 1)
					(proc1111_8)
					(SetFlag 248)
					(gGame handsOn: 0)
					((ScriptID 0 14) init:) ; exitButt
				)
				(2
					(ClearFlag 248)
					(= local0 0)
					(proc1111_9)
					((ScriptID 0 14) dispose:) ; exitButt
					(gGame handsOff:)
					(DoRobot 2161 143 46 gEgo 111)
					(gCurRoom drawPic: 6600)
				)
				(3
					(localproc_1)
					(gCurRoom drawPic: 6500)
					(gEgo
						normalize: 1
						posn: 106 118
						setScaler: Scaler 140 98 126 102
						show:
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(ClearFlag 248)
					(if local0
						(= local0 0)
						(proc1111_9)
					)
					((ScriptID 0 14) dispose:) ; exitButt
					(localproc_1)
					(= global115 0)
					(gEgo
						normalize: 1
						posn: 106 118
						setScaler: Scaler 140 98 126 102
						show:
					)
					(gCurRoom drawPic: 6500)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance releaseEntityScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 39)
					(if (== (gEgo x:) 68)
						(gEgo setHeading: 145 self)
					else
						(= cycles 2)
					)
				)
				(1
					(gEgo hide:)
					(localproc_2)
					(gCurRoom picture: -1)
					(gCurRoom drawPic: -1)
					(PlayVMD 0 {2170.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 2170 self)
				)
				(2
					(gCurRoom drawPic: -1)
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(SetFlag 39)
		(KillRobot)
		(= global115 0)
		(gGame fadeSpeed: 4)
		(gGDacSound fade: 0 4 2 1)
		(gCurRoom newRoom: 44) ; chapEndRm
		(super dispose: &rest)
	)
)

(instance lookBook1stScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 2190 141 51 gEgo 111)
					(localproc_2)
					(SetFlag 112)
					(gCurRoom drawPic: 6600)
				)
				(1
					(gCurRoom drawPic: -1)
					(theBook init:)
					(= seconds 5)
				)
				(2
					(theBook dispose:)
					(DoRobot 2193 122 34 gEgo 111)
					(gCurRoom drawPic: 6600)
				)
				(3
					(gEgo normalize: 1 posn: 106 118)
					(localproc_3)
					(gCurRoom drawPic: 6500)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(theBook dispose:)
					(localproc_3)
					(= global115 0)
					(gEgo normalize: 1 posn: 106 118)
					(gCurRoom drawPic: 6500)
					(SetFlag 112)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookBook2ndScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(localproc_2)
					(DoRobot 2220 143 50 gEgo 111)
					(SetFlag 113)
					(gCurRoom drawPic: 6600)
				)
				(1
					(localproc_3)
					(gCurRoom drawPic: 6500)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(localproc_3)
					(KillRobot)
					(= global115 0)
					(gCurRoom drawPic: 6500)
					(SetFlag 113)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance secretDoor of Prop
	(properties
		x 69
		y 102
		view 6570
	)

	(method (init)
		(if (== gChapter 5)
			(self view: 6575)
		)
		(super init: &rest)
	)
)

(instance cryptDoor of Prop ; UNUSED
	(properties
		x 146
		y 103
		view 6580
	)

	(method (init)
		(if (== gChapter 5)
			(self view: 6585 posn: 146 100)
		)
		(super init: &rest)
	)
)

(instance theBook of View
	(properties
		x -1
		y 130
		view 2190
	)
)

(instance chest of View
	(properties
		sightAngle 40
		approachX 153
		approachY 125
		x 67
		y 83
		view -535
		cel 2
	)

	(method (init)
		(if (== gChapter 5)
			(= view -486)
		)
		(if (IsFlag 206)
			(self cel: 5 posn: 88 125)
		)
		(self setPri: 111)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(cond
				((IsFlag 206)
					(gCurRoom setScript: sSpellBookGone)
				)
				((not (IsFlag 209))
					(gCurRoom setScript: moveBibleScr)
				)
				((not (IsFlag 39))
					(gCurRoom setScript: releaseEntityScr)
				)
				((IsFlag 112)
					(gCurRoom setScript: lookBook2ndScr)
				)
				(else
					(gCurRoom setScript: lookBook1stScr)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bible of View
	(properties
		sightAngle 40
		approachX 95
		approachY 115
		x 90
		y 63
		view -535
		cel 1
	)

	(method (init)
		(if (== gChapter 5)
			(= view -486)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(cond
				((IsFlag 210)
					(gCurRoom setScript: lookBibleNextScr)
				)
				((and (== (gEgo x:) 68) (== (gEgo y:) 100))
					(gCurRoom setScript: lookBibleStandScr)
				)
				(else
					(gCurRoom setScript: lookBible1stScr)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance cryptExit of Feature
	(properties
		nsLeft 148
		nsTop 62
		nsRight 175
		nsBottom 88
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 21) ; Do, Exit
			(gGame handsOff:)
			(gCurRoom setScript: toCryptScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance altarExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 0
		nsRight 110
		nsBottom 127
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: toAltarScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance passageExit of ExitFeature
	(properties
		nsLeft 277
		nsTop 59
		nsRight 319
		nsBottom 127
		approachX 277
		approachY 113
		nextRoom 6400
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: toPassageScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fireplaceExit of ExitFeature
	(properties
		nsLeft 225
		nsTop 59
		nsRight 264
		nsBottom 110
		approachX 217
		approachY 113
		x 240
		y 114
		nextRoom 5500
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(= global125 9)
			(gCurRoom setScript: toLibScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sOpen of Sound
	(properties
		number 6021
	)
)

(instance sClose of Sound
	(properties
		number 6022
	)
)

