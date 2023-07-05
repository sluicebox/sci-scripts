;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18200)
(include sci.sh)
(use Main)
(use movieScr)
(use scaryInvInit)
(use Trigger)
(use n1111)
(use Print)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm18200 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1)
	(if
		(and
			(== gChapter 5)
			(OneOf param1 18200 18220 18210 18100 18290)
		)
		(++ param1)
	)
	(if (!= (gCurRoom picture:) param1)
		(gCurRoom drawPic: param1 picture: param1)
	)
)

(instance rm18200 of ScaryRoom
	(properties
		west 15200
		stepSound 4
	)

	(method (init &tmp temp0)
		(if (== gChapter 5)
			(= picture 18201)
		else
			(= picture 18200)
		)
		(= temp0 0)
		(proc1111_6)
		(gEgo init: normalize: setScaler: Scaler 156 84 152 97)
		(switch gPrevRoomNum
			(900
				(if (IsFlag 226)
					(ClearFlag 226)
					(proc28_2)
					(gEgo view: 3 posn: 173 109 init:)
					(if (== gChapter 4)
						(gEgo z: 1000)
						(= picture -1)
						(= temp0 noRapeScr)
					else
						(= picture 18220)
						(gEgo y: -10)
						(= temp0 chap6Scr)
					)
				else
					(proc28_2)
					(if (and (== (gEgo x:) 0) (== (gEgo y:) 0))
						(gEgo normalize: 3 posn: 173 109 init:)
						(if (== gChapter 4)
							(gEgo z: 1000)
							(= picture -1)
							(if (IsFlag 411)
								(= temp0 noRapeScr)
							else
								(= temp0 rapeScr)
							)
						else
							(= picture 18220)
							(gEgo y: -10)
							(= temp0 chap6Scr)
						)
					else
						(gGame handsOn:)
					)
				)
			)
			(44 ; chapEndRm
				(gGame fadeSpeed: 4)
				(gGame handsOff:)
				(ClearFlag 226)
				(proc28_2)
				(gEgo normalize: 3 posn: 173 109)
				(if (== gChapter 4)
					(gEgo z: 1000)
					(= picture -1)
					(= temp0 rapeScr)
				else
					(= picture 18220)
					(gEgo y: -10)
					(= temp0 chap6Scr)
				)
			)
			(9100
				(gEgo view: 3 normalize: 3 posn: 173 109)
				(= temp0 afterChokingScr)
			)
			(18250
				(gEgo view: 7302 setLoop: 0 1 cel: 0 x: 175 y: 111)
				(= temp0 sGoto18100)
			)
			(else
				(cond
					(local0)
					((and (== gChapter 4) (IsFlag 264))
						(SetFlag 5)
						(= temp0 sEnterFromHallway)
					)
					((OneOf gPrevRoomNum 14100 14200)
						(gEgo view: 3 normalize: 3 posn: 173 109)
						(= temp0 afterNurseryScr)
					)
					(else
						(= temp0 sEnterFrom18100)
					)
				)
			)
		)
		(gGame fadeSpeed: 100)
		(hallDoor init:)
		(if (not (IsFlag 264))
			(southExit init:)
			(if (< gChapter 4)
				(theMirror init: approachVerbs: 0 setHotspot: 4 3 21) ; Do, Move, Exit
			)
			(theSink init: approachVerbs: 0 setHotspot: 4 3 21) ; Do, Move, Exit
			(shower init: approachVerbs: 0 setHotspot: 0 4) ; Do
		)
		(super init:)
		(if temp0
			(self setScript: temp0 0 0)
		else
			(gGame handsOn:)
		)
	)
)

(instance shower of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 71 81 100 77 106 92 76 99
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= global125 52)
			(gCurRoom newRoom: 18100)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance afterChokingScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Prints
						{Scene 401 cont'd: Adrienne is splashing water on her face and recovering from when she's just seen in the collectibles room.}
					)
					(= cycles 2)
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
			(proc1111_6)
			(= global115 0)
		)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance rapeScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(PlayVMD 0 {3980.vmd} 0) ; Open
					(proc26_0 3980 self)
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
			(proc1111_6)
			(= global115 0)
		)
		(SetFlag 180)
		(gCurRoom newRoom: 17100)
		(gEgo z: 0)
		(super dispose: &rest)
	)
)

(instance noRapeScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(= cycles 2)
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
			(proc1111_6)
			(= global115 0)
		)
		(SetFlag 180)
		(gCurRoom newRoom: 17100)
		(gEgo z: 0)
		(super dispose: &rest)
	)
)

(instance afterNurseryScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Prints
						{Scene 244 cont'd: Adrienne is splashing water on her face and recovering from when she's just seen in the nursery.}
					)
					(= cycles 2)
				)
				(1
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sEnterFrom18100 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 3
						normalize: 3
						x: 196
						y: 119
						cel: 0
						setLoop: 0 1
					)
					(= cycles 2)
				)
				(1
					(gEgo setCycle: End self)
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
			(proc1111_6)
			(= global115 0)
		)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance southExit of Trigger
	(properties
		approachX 196
		approachY 129
		exitDir 3
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 114 127 104 133 235 136 230 127
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(gCurRoom setScript: sExitSouth 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance hallDoor of Trigger
	(properties
		approachX 219
		approachY 126
		exitDir 2
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 238 19 268 -4 268 130 238 131
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(gCurRoom setScript: sExitToHallway 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theMirror of Feature
	(properties
		approachX 180
		approachY 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 162 68 162 59 156 56 159 44 182 41 193 47 194 53 185 61 185 68
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= global125 70)
			(gCurRoom setScript: sUseSink 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theSink of Feature
	(properties
		approachX 180
		approachY 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 156 69 152 84 192 84 192 69
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sUseSink 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sTalkHarriet1 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(harriet dispose:)
					(proc1111_7 4350 20 -2 gEgo 10)
					(localproc_0 18290)
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
			(proc1111_6)
			(= global115 0)
		)
		(SetFlag 153)
		(harriet init:)
		(localproc_0 18200)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance harriet of Prop
	(properties
		x 113
		y 127
		view 4270
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 126 72 131 65 127 57 136 44 145 62 153 66 162 86 153 100 152 115 149 119 149 126 144 128 135 125 136 117 131 105 137 96
					yourself:
				)
			approachVerbs: 0
			setHotspot: 4 15 3 ; Do, invTarot, Move
			setPri: 90
			setScript: sCleanShower 0 0
			cycleSpeed: 8
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (IsFlag 176) (not (IsFlag 153)))
					(SetFlag 153)
					(gCurRoom setScript: sTalkHarriet1)
				else
					(gCurRoom setScript: sTalkHarriet2)
				)
			)
			(15 ; invTarot
				(gCurRoom setScript: sGiveHarrietTarot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sGiveHarrietTarot of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(harriet dispose:)
					(proc1111_7 4271 -2 -35 gEgo 10)
					(localproc_0 18290)
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
			(proc1111_6)
			(= global115 0)
		)
		(harriet init:)
		(localproc_0 18200)
		(gEgo put: 9) ; invTarot
		(SetFlag 179)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sTalkHarriet2 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(harriet dispose:)
					(proc1111_7 4360 21 -17 gEgo 10)
					(localproc_0 18290)
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
			(proc1111_6)
			(= global115 0)
		)
		(harriet init:)
		(localproc_0 18200)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sEnterFromHallway of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(harriet init:)
					(gEgo
						view: 611
						x: 227
						y: 133
						heading: 270
						init:
						setLoop: 0 1
						cel: 3
						setScaler: Scaler 76 62 137 124
					)
					(= cycles 2)
				)
				(1
					(gEgo setCycle: End self)
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(gEgo setCycle: 0 cel: (gEgo lastCel:))
			(gGame handsOn:)
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance sExitToHallway of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (IsFlag 264)
						(gEgo
							view: 6100
							cel: 0
							setLoop: 0 1
							setCycle: End self
						)
					else
						(gEgo setHeading: 180 self)
					)
				)
				(1
					(harriet dispose:)
					(gEgo
						view: 612
						x: 149
						y: 126
						setScaler: Scaler 68 51 126 109
						setLoop: 0 1
						cel: 0
						show:
					)
					(gCurRoom drawPic: 15110 picture: 15110)
					(= cycles 2)
				)
				(2
					(gEgo setCycle: CT 8 1 self)
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
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(= global125 0)
		(gCurRoom newRoom: 15200)
		(super dispose: &rest)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_13 register self)
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
			(proc1111_6)
			(= global115 0)
		)
		(= global125 0)
		(gCurRoom newRoom: 18100)
		(super dispose: &rest)
	)
)

(instance hairBrush of View
	(properties)
)

(instance sGoto18100 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 2)
				)
				(1
					(gEgo setCycle: End self)
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
			(proc1111_6)
			(= global115 0)
		)
		(= global125 80)
		(gCurRoom newRoom: 18100)
		(super dispose: &rest)
	)
)

(instance chap6Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gGame setIntensity: 0)
					(proc1111_7 5390 -35 -47 gEgo -1 1)
					((= register (View new:))
						view: 18200
						x: 127
						y: 102
						setPri: 255
						init:
					)
					(hairBrush view: 18220 x: 145 y: 120 z: 1000 init:)
					(gGame fade: 0 100 10)
				)
				(1
					(UpdatePlane (gCast plane:))
					(FrameOut)
				)
				(2
					(register dispose:)
					(= register 0)
					(hairBrush z: 0)
					(UpdateScreenItem hairBrush)
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
		(if register
			(register dispose:)
		)
		(if (Robot 6) ; Exists
			(Robot 10) ; Pause
		)
		(gGame fade: 100 0 5)
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(hairBrush dispose:)
		(ClearFlag 99)
		(gCurRoom newRoom: 3430)
		(super dispose: &rest)
	)
)

(instance sCleanShower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGDacSound number: (Random 18050 18052) setLoop: 1 play:)
				(switch (++ register)
					(1
						(client cel: 0 setCycle: End self)
					)
					(2
						(client setCycle: Beg self)
					)
					(3
						(client cel: 4 setCycle: CT 12 1 self)
					)
					(4
						(client setCycle: CT 4 -1 self)
					)
					(5
						(client setCycle: CT 12 1 self)
						(= register 0)
					)
				)
			)
			(1
				(self init:)
			)
		)
	)

	(method (dispose)
		(gGDacSound stop:)
		(super dispose: &rest)
	)
)

(instance sUseSink of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if register
						(= local1 register)
					)
					(if (and register (== (gEgo x:) 196))
						(-- state)
						(proc1111_13 register self 1)
						(= register 0)
					else
						(self dispose:)
					)
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
			(proc1111_6)
			(= global115 0)
		)
		(switch local1
			(theMirror
				(gCurRoom newRoom: 18210)
			)
			(theSink
				(gCurRoom newRoom: 18250)
			)
		)
		(super dispose: &rest)
	)
)

