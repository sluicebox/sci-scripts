;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9100)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm9100 0
)

(instance rm9100 of ScaryRoom
	(properties
		stepSound 4
		baseView 6000
	)

	(method (drawPic param1)
		(if (gCast contains: mist)
			(switch param1
				(9006
					(mist posn: 266 89 show:)
				)
				(9001
					(mist posn: 260 84 show:)
				)
				(else
					(mist hide:)
				)
			)
		)
		(super drawPic: param1 &rest)
	)

	(method (init)
		(= picture (+ 9005 (== gChapter 5)))
		(if (and (== gChapter 5) (not (IsFlag 54)))
			(mist init:)
		)
		(gEgo init: setScaler: Scaler 94 45 144 114 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(else
				(gEgo normalize: 614 posn: 63 142)
				(= global125 1)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(door init: 13 approachVerbs: 0)
		(chokeMachine init:)
		(if (not (IsFlag 404))
			(chokeMachine setHotspot: 4 3) ; Do, Move
		)
		(phonograph init: setHotspot: 4 3) ; Do, Move
		(if (and (not (IsFlag 62)) (< gChapter 6))
			(mirror init: setHotspot: 4 3) ; Do, Move
		)
		(if (and global184 (not (IsFlag 55)))
			(gCurRoom setScript: sTurnOffPhono)
			(= picture 9000)
		)
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(if (and (not (== newRoomNumber 900)) global184)
			(global114 endPause:)
			(= global184 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance tryPhonoScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 90 self 15)
						)
						(2
							(self changeState: 1)
						)
						(3
							(gEgo setHeading: 225 self 15)
						)
						(else
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(SetFlag 177)
					(chokeMachine posn: 189 136 view: 9111)
					(proc1111_7 1150 77 29)
					(gCurRoom drawPic: 9110)
				)
				(2
					(chokeMachine
						posn: 152 133
						view: (+ 9005 (== gChapter 5))
						setPri: 117
					)
					(gEgo posn: 130 136 normalize: 617)
					(= global125 2)
					(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(SetFlag 177)
			(chokeMachine
				posn: 152 133
				view: (+ 9005 (== gChapter 5))
				setPri: 117
			)
			(gEgo posn: 130 136 normalize: 617)
			(= global125 2)
			(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance tryPhonoAgainScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 90 self 15)
						)
						(2
							(self changeState: 1)
						)
						(4
							(gEgo setHeading: 180 self 18)
						)
						(else
							(gEgo setHeading: 225 self 15)
						)
					)
				)
				(1
					(chokeMachine
						posn: 174 148
						view: (+ 9220 (== gChapter 5))
						setPri: 200
					)
					(proc1111_7 1160 171 46)
					(gCurRoom drawPic: (+ 9220 (== gChapter 5)))
				)
				(2
					(chokeMachine
						posn: 152 133
						view: (+ 9005 (== gChapter 5))
						setPri: 117
					)
					(gEgo posn: 130 136 normalize: 617)
					(= global125 2)
					(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(chokeMachine
				posn: 152 133
				view: (+ 9005 (== gChapter 5))
				setPri: 117
			)
			(gEgo posn: 130 136 normalize: 617)
			(= global125 2)
			(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sTurnOffPhono of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(chokeMachine posn: 145 100 view: 9000)
					(record init: setCycle: Fwd cycleSpeed: 14)
					(proc1111_7 2401 -12 21)
				)
				(1
					(record dispose:)
					(if (global114 script:)
						(global114 stop: 0)
					)
				)
				(2
					(SetFlag 55)
					(SetFlag 177)
					(chokeMachine posn: 152 133 view: 9005 setPri: 117)
					(gEgo posn: 130 136 normalize: 616)
					(= global125 2)
					(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (gCast contains: record)
				(record dispose:)
			)
			(SetFlag 55)
			(if (global114 script:)
				(global114 stop: 0)
			)
			(chokeMachine
				posn: 152 133
				view: (+ 9005 (== gChapter 5))
				setPri: 117
			)
			(gEgo posn: 130 136 normalize: 616)
			(= global125 2)
			(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance scene241Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 90 self)
						)
						(2
							(self changeState: 1)
						)
						(3
							(gEgo setHeading: 225 self 15)
						)
						(else
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(chokeMachine posn: 174 148 view: (+ 9220 (== gChapter 5)))
					(proc1111_7 2410 108 49 gEgo 10)
					(gCurRoom drawPic: (+ 9220 (== gChapter 5)))
				)
				(2
					(chokeMachine
						posn: 152 133
						view: (+ 9005 (== gChapter 5))
						setPri: 117
					)
					(gEgo posn: 130 136 normalize: 617)
					(= global125 2)
					(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(chokeMachine
				posn: 152 133
				view: (+ 9005 (== gChapter 5))
				setPri: 117
			)
			(gEgo posn: 130 136 normalize: 617)
			(= global125 2)
			(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sElectricArc of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 90 self)
						)
						(2
							(gEgo setHeading: 45 self 10)
						)
						(3
							(self changeState: 1)
						)
						(4
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(chokeMachine posn: 145 100 view: (+ 9000 (== gChapter 5)))
					(proc1111_7 1130 99 36)
					(gCurRoom drawPic: (+ 9000 (== gChapter 5)))
				)
				(2
					(chokeMachine
						posn: 152 133
						view: (+ 9005 (== gChapter 5))
						setPri: 117
					)
					(gEgo posn: 180 136 normalize: 613)
					(= global125 3)
					(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(chokeMachine
				posn: 152 133
				view: (+ 9005 (== gChapter 5))
				setPri: 117
			)
			(gEgo posn: 180 136 normalize: 613)
			(= global125 3)
			(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sNoArc of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 90 self)
						)
						(2
							(gEgo setHeading: 45 self 10)
						)
						(3
							(self changeState: 1)
						)
						(4
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(SetFlag 404)
					(chokeMachine
						posn: 145 100
						view: (+ 9000 (== gChapter 5))
						setPri: 100
					)
					(proc1111_7 4030 110 41)
					(gCurRoom drawPic: (+ 9000 (== gChapter 5)))
				)
				(2
					(chokeMachine
						posn: 152 133
						view: (+ 9005 (== gChapter 5))
						setPri: 117
						setHotspot: 0
					)
					(gEgo posn: 180 136 normalize: 613)
					(= global125 3)
					(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(SetFlag 404)
			(chokeMachine
				posn: 152 133
				view: (+ 9005 (== gChapter 5))
				setPri: 117
				setHotspot: 0
			)
			(gEgo posn: 180 136 normalize: 613)
			(= global125 3)
			(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sLookIntoMirror of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(Load 140 9000) ; WAVE
					(switch global125
						(1
							(gEgo setHeading: 90 self)
						)
						(2
							(gEgo setHeading: 90 self)
						)
						(3
							(gEgo setHeading: 135 self)
						)
						(4
							(gEgo setHeading: 45 self 15)
						)
					)
				)
				(1
					(chokeMachine posn: 133 117 view: (+ 9210 (== gChapter 5)))
					(proc1111_7 1140 -36 -38 gEgo 126)
					(gCurRoom drawPic: (+ 9210 (== gChapter 5)))
				)
				(2
					(if (not (IsFlag 62))
						(global114 pause:)
						(sfx number: 9000 init: setVol: 76 setLoop: 1 play:)
						(chokeMachine loop: 1 setCycle: Fwd cycleSpeed: 10)
					)
				)
				(3
					(if (not (IsFlag 62))
						(chokeMachine loop: 0 setCycle: 0)
					)
				)
				(4
					(if (not (IsFlag 62))
						(global114 endPause:)
						(sfx dispose:)
					)
					(chokeMachine
						posn: 152 133
						view: (+ 9005 (== gChapter 5))
						setPri: 117
					)
					(gEgo posn: 251 118 normalize: 615)
					(= global125 4)
					(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(global114 endPause: 1)
			(chokeMachine
				posn: 152 133
				view: (+ 9005 (== gChapter 5))
				setPri: 117
			)
			(gEgo posn: 251 118 normalize: 615)
			(= global125 4)
			(gCurRoom drawPic: (+ 9005 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sChokeScene of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch global125
					(1
						(gEgo setHeading: 90 self)
					)
					(2
						(gEgo setHeading: 90 self)
					)
					(3
						(gEgo setHeading: 135 self)
					)
					(4
						(gEgo setHeading: 45 self 15)
					)
				)
			)
			(1
				(gCurRoom drawPic: -1)
				(gEgo dispose:)
				(chokeMachine dispose:)
				(SetFlag 54)
				(PlayVMD 0 {4010.vmd} 0) ; Open
				(proc26_0 4010 self)
			)
			(2
				(= global125 0)
				(gCurRoom newRoom: 13400)
			)
		)
	)
)

(instance sAfterChoke of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 90 self)
						)
						(2
							(gEgo setHeading: 90 self)
						)
						(3
							(gEgo setHeading: 135 self)
						)
						(4
							(gEgo setHeading: 45 self 15)
						)
					)
				)
				(1
					(global114 pause:)
					(chokeMachine posn: 131 147 view: 9200)
					(proc1111_7 4020 41 -43 gEgo 200)
					(gCurRoom drawPic: 9200)
				)
				(2
					(global114 endPause:)
					(SetFlag 62)
					(mirror dispose:)
					(chokeMachine posn: 152 133 view: 9005 setPri: 117)
					(gEgo posn: 251 118 normalize: 615)
					(= global125 4)
					(gCurRoom drawPic: 9005)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(if (gFeatures contains: mirror)
				(mirror dispose:)
			)
			(global114 endPause: 1)
			(SetFlag 62)
			(chokeMachine posn: 152 133 view: 9005 setPri: 117)
			(gEgo posn: 251 118 normalize: 615)
			(= global125 4)
			(gCurRoom drawPic: 9005)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sExitDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 315 self)
						)
						(2
							(gEgo setHeading: 270 self)
						)
						(3
							(gEgo setHeading: 225 self)
						)
						(4
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(= global125 0)
					(gCurRoom newRoom: 13400)
				)
			)
		else
			(= global115 0)
			(= global125 0)
			(gCurRoom newRoom: 13400)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance door of ExitFeature
	(properties
		nsLeft 1
		nsTop 14
		nsRight 42
		nsBottom 128
		x 21
		y 71
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitDoor)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance phonograph of Feature
	(properties
		nsLeft 88
		nsTop 64
		nsRight 122
		nsBottom 108
		x 105
		y 86
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (IsFlag 55) (== gChapter 2))
						(gGame handsOff:)
						(gCurRoom setScript: scene241Scr)
					)
					((not (IsFlag 177))
						(gGame handsOff:)
						(gCurRoom setScript: tryPhonoScr)
					)
					(else
						(gGame handsOff:)
						(gCurRoom setScript: tryPhonoAgainScr)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance record of Prop
	(properties
		x 105
		y 81
		view 9000
		loop 1
	)
)

(instance mist of Prop
	(properties
		scaleX 45
		scaleY 64
		fixPriority 1
		view 12304
		scaleSignal 1
	)

	(method (init)
		(RemapColors 2 244 115) ; ByPercent
		(RemapColors 2 243 120) ; ByPercent
		(RemapColors 2 242 125) ; ByPercent
		(RemapColors 2 241 130) ; ByPercent
		(RemapColors 2 240 135) ; ByPercent
		(RemapColors 2 239 140) ; ByPercent
		(RemapColors 2 238 145) ; ByPercent
		(RemapColors 2 237 150) ; ByPercent
		(RemapColors 2 236 155) ; ByPercent
		(super init: &rest)
		(= cycleSpeed 6)
		(self setCycle: Fwd)
	)

	(method (dispose)
		(RemapColors 0) ; Off
		(super dispose:)
	)
)

(instance chokeMachine of Prop
	(properties
		x 152
		y 133
		priority 117
		fixPriority 1
	)

	(method (init)
		(|= signal $1000)
		(self view: (+ 9005 (== gChapter 5)))
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 54)
					(gGame handsOff:)
					(gCurRoom setScript: sNoArc)
				else
					(gGame handsOff:)
					(gCurRoom setScript: sElectricArc)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mirror of Feature
	(properties
		nsLeft 253
		nsTop 51
		nsRight 282
		nsBottom 88
		x 267
		y 69
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 54)
						(gGame handsOff:)
						(gCurRoom setScript: sAfterChoke)
					)
					((== gChapter 5)
						(gGame handsOff:)
						(gCurRoom setScript: sChokeScene)
					)
					(else
						(gGame handsOff:)
						(gCurRoom setScript: sLookIntoMirror)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

