;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13400)
(include sci.sh)
(use Main)
(use cObj)
(use Trigger)
(use n1111)
(use Scaler)
(use Polygon)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm13400 0
)

(local
	local0
	local1
	local2 = 13400
	local3 = -1
	local4
)

(procedure (localproc_0 param1)
	(if
		(and
			(== gChapter 1)
			(== param1 9100)
			(not (IsFlag 53))
			(>= global172 3)
			(not (IsFlag 83))
		)
		(SetFlag 53)
	)
	(if (and (== gChapter 1) (== param1 9100) (IsFlag 82) (not (IsFlag 181)))
		(SetFlag 181)
	)
	(if
		(and
			(== gChapter 1)
			(OneOf param1 10700 10701 10702 10703 10704)
			(IsFlag 82)
			(not (IsFlag 181))
		)
		(SetFlag 181)
	)
)

(procedure (localproc_1)
	(cond
		((IsFlag 53))
		((or (not (IsFlag 345)) (and (not (IsFlag 322)) (IsFlag 77)))
			(if (== gPrevRoomNum 10703)
				(SetFlag 322)
			)
			(don
				view: 13392
				x: 158
				y: 98
				setScaler: Scaler 86 86 99 98
				init:
				cycleSpeed: 6
				setCycle: Fwd
			)
		)
		((and (== global172 2) (not (IsFlag 339)))
			(don
				view: 13394
				x: 118
				y: 90
				setScaler: Scaler 76 76 94 93
				init:
				cycleSpeed: 6
				setCycle: CT 77 1
			)
		)
		((and (== global172 2) (or (IsFlag 344) (not (IsFlag 340))))
			(don
				view: 13393
				x: 121
				y: 105
				setScaler: Scaler 83 70 107 97
				init:
				cycleSpeed: 6
				setCycle: Fwd
			)
			(ClearFlag 344)
		)
		(else
			(don
				view: 13391
				x: 145
				y: 98
				setScaler: Scaler 1 76 99 98
				init:
				cycleSpeed: 6
				setCycle: Fwd
			)
		)
	)
)

(procedure (localproc_2 &tmp temp0)
	(darkDoorView z: 1000)
	(if (gCast contains: darkDoorView)
		(UpdateScreenItem darkDoorView)
	)
	(= temp0 0)
	(cond
		((OneOf gChapter 1 7)
			(darkDoorExit init:)
			(darkDoorView dispose:)
		)
		((OneOf (gCurRoom picture:) 13400 13401)
			(darkDoorView view: local2 x: 1 y: 1 priority: 4)
			(= temp0 1)
		)
		((== (gCurRoom picture:) 13350)
			(darkDoorView view: 13350 x: 126 y: 0 priority: 4)
			(= temp0 1)
		)
		((== (gCurRoom picture:) 13300)
			(darkDoorView view: 13300 x: 75 y: 49)
			(= temp0 1)
		)
		((== (gCurRoom picture:) 13360)
			(darkDoorView view: 13360 x: 141 y: 129)
			(= temp0 1)
		)
	)
	(if temp0
		(darkDoorView
			setLoop: 0 1
			setScale: 0
			cel: 0
			priority: 4
			approachVerbs: 0
			z: 0
		)
		(if (not (gCast contains: darkDoorView))
			(darkDoorView init:)
		)
		(if (!= gChapter 4)
			(darkDoorView setHotspot: 4 1 3 2 21) ; Do, ???, Move, ???, Exit
		)
		(UpdateScreenItem darkDoorView)
	)
)

(instance rm13400 of ScaryRoom
	(properties
		picture 13300
		stepSound 4
	)

	(method (init &tmp temp0)
		(proc1111_6)
		(= temp0 0)
		(if (not (OneOf gPrevRoomNum 10701 10702 10703))
			(gEgo view: 0 init: normalize: setScaler: Scaler 165 67 155 106)
		)
		(switch gPrevRoomNum
			(900
				(= picture 13300)
			)
			(13500
				(switch global125
					(13
						(= global125 0)
						(gEgo
							view: 1
							normalize: 1
							heading: 270
							posn: 132 111
						)
						(= temp0 (ScriptID 0 5)) ; takeLastStep
					)
					(15
						(= global125 0)
						(gEgo view: 1 normalize: 1 heading: 270 posn: 96 115)
						(darkDoorExit doVerb: 4)
					)
					(else
						(if (== gChapter 5)
							(= local2 13401)
						)
						(= temp0 sComeDownStairs)
					)
				)
			)
			(13200
				(gEgo view: 3 normalize: 3 heading: 360 posn: 125 126)
				(= temp0 (ScriptID 0 5)) ; takeLastStep
			)
			(9100
				(if (== gChapter 5)
					(= local2 (= picture 13401))
				else
					(= local2 (= picture 13400))
				)
				(= temp0 sEnterFromCollect)
			)
			(13100
				(if (== global125 9)
					(= temp0 sFromSouth2Dkrm)
				else
					(= temp0 sFromSouth)
				)
			)
			(else
				(= picture 13390)
				(= temp0 sFromDarkroom)
			)
		)
		(super init: &rest)
		(collectDoor init:)
		(southExit init:)
		(stairs init:)
		((ScriptID 0 5) register: 10) ; takeLastStep
		(if temp0
			(self setScript: temp0)
		else
			(gGame handsOn:)
		)
		(if (!= gChapter 7)
			((ScriptID 30) init:) ; FidgetCode
		)
		(localproc_2)
		(cond
			((< gChapter 3)
				(global114 play: 911)
			)
			((== gChapter 3)
				(global114 play: 912)
			)
			((== gChapter 4)
				(global114 play: 9120)
			)
			((== gChapter 5)
				(global114 play: 913)
			)
			((== gChapter 6)
				(global114 play: 914)
				(if (not (IsFlag 385))
					(Load 140 13060) ; WAVE
					(Load 140 13061) ; WAVE
					(Load 140 13062) ; WAVE
					(Load 140 13063) ; WAVE
					(Load 140 13064) ; WAVE
					(Lock 140 13060 1) ; WAVE
					(Lock 140 13061 1) ; WAVE
					(Lock 140 13062 1) ; WAVE
					(Lock 140 13063 1) ; WAVE
					(Lock 140 13064 1) ; WAVE
					(= local4 1)
					(donSounds cue:)
				)
			)
			((== gChapter 7)
				(global114 play: 9140)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(== gChapter 4)
				(== newRoomNumber 9100)
				(IsFlag 265)
				(not (IsFlag 3))
				(not (IsFlag 247))
			)
			(SetFlag 247)
			(ClearFlag 52)
		)
		(if
			(and
				(== gChapter 4)
				(== newRoomNumber 9100)
				(IsFlag 5)
				(not (IsFlag 325))
			)
			(SetFlag 325)
			(ClearFlag 264)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(if (or local4 (== gChapter 6))
			(Lock 140 13060 0) ; WAVE
			(Lock 140 13061 0) ; WAVE
			(Lock 140 13062 0) ; WAVE
			(Lock 140 13063 0) ; WAVE
			(Lock 140 13064 0) ; WAVE
			(UnLoad 140 13060)
			(UnLoad 140 13061)
			(UnLoad 140 13062)
			(UnLoad 140 13063)
			(UnLoad 140 13064)
		)
		(super dispose: &rest)
	)
)

(instance southExit of Trigger
	(properties
		approachX 143
		approachY 173
		approachDist 10
		exitDir 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 65 125 64 136 199 137 195 125
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

(instance stairs of Trigger
	(properties
		approachX 210
		approachY 90
		approachDist 10
		exitDir 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 35 216 29 222 129 183 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not (OneOf theVerb 21 4)) ; Exit, Do
				(super doVerb: theVerb)
			)
			((and (== gChapter 4) (IsFlag 189) (not (IsFlag 222)))
				(gCurRoom setScript: sScene404 0 0)
			)
			(else
				(gCurRoom setScript: sClimbStairs 0 self)
			)
		)
	)
)

(instance collectDoor of Trigger
	(properties
		approachX 173
		approachY 101
		approachDist 10
		exitDir 1
	)

	(method (init)
		(if (== gPrevRoomNum 9100)
			(= approachX 166)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 146 57 147 45 165 32 181 37 190 47 188 103 183 109 149 106 145 101
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not (OneOf theVerb 21 4)) ; Exit, Do
				(super doVerb: theVerb)
			)
			((and (== gChapter 4) (IsFlag 189) (not (IsFlag 222)))
				(gCurRoom setScript: sScene404 0 0)
			)
			(else
				(gCurRoom setScript: sExitToCollect 0 self)
			)
		)
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
		(localproc_0 13100)
		(gCurRoom newRoom: 13100)
		(super dispose: &rest)
	)
)

(instance don of Actor
	(properties)
)

(instance darkDoorView of View
	(properties
		fixPriority 1
	)

	(method (doVerb theVerb)
		(darkDoorExit doVerb: theVerb)
	)
)

(instance sFromSouth2Dkrm of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 7307
						heading: 45
						cel: 15
						x: 137
						y: 124
						setLoop: 0 1
					)
					(if (not (gCast contains: gEgo))
						(gEgo init:)
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
		(= global115 0)
		(cond
			(local0)
			((!= gChapter 1)
				(= next sScene489)
			)
			(else
				(sExit2Dkrm register: 0)
				(= next sExit2Dkrm)
			)
		)
		(super dispose: &rest)
	)
)

(instance sExit2Dkrm of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(++ global172)
					(proc1111_13 register self)
				)
				(1
					(gEgo
						view: 613
						setLoop: 0 1
						x: 141
						y: 124
						cel: 0
						setScaler: Scaler 78 53 130 119
					)
					(localproc_1)
					(gCurRoom drawPic: 13390 picture: 13390)
					(= cycles 2)
				)
				(2
					(gEgo setCycle: CT 10 1 self)
				)
				(3
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose &tmp temp0)
		(= global115 0)
		(cond
			((== global172 2)
				(= temp0 10702)
			)
			((and (IsFlag 83) (not (IsFlag 322)))
				(= temp0 10703)
			)
			(else
				(= temp0 10701)
			)
		)
		(localproc_0 temp0)
		(gCurRoom newRoom: temp0)
		(super dispose: &rest)
	)
)

(instance sFromDarkroom of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 612
						setLoop: 0 1
						cel: 0
						heading: 125
						x: 143
						y: 140
						z: 0
						init:
						setScaler: Scaler 79 74 130 126
					)
					(localproc_1)
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
		(gEgo
			view: 4
			normalize: 4
			heading: 135
			x: 105
			y: 117
			z: 0
			setScaler: Scaler 165 67 155 106
		)
		(southExit approachX: (gEgo x:))
		(don dispose:)
		(gCurRoom drawPic: 13300 picture: 13300)
		(localproc_2)
		(collectDoor approachX: 165 approachY: 101)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sEnterFromCollect of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 2
						normalize: 2
						heading: 180
						setScaler: Scaler 126 104 129 122
						x: 160
						y: 124
						setLoop: 0 1
						cel: 0
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
		(= global115 0)
		(gEgo
			view: 2
			normalize: 2
			heading: 180
			x: 166
			y: 113
			setScaler: Scaler 165 67 155 106
			cel: (gEgo lastCel:)
		)
		(gCurRoom drawPic: 13300 picture: 13300)
		(stairs approachY: (gEgo y:))
		(southExit approachX: (gEgo x:))
		(localproc_2)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sFromSouth of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 3
						normalize: 3
						heading: 360
						cel: 4
						setLoop: 0 1
						x: 143
						y: 126
					)
					(if (not (gCast contains: gEgo))
						(gEgo init:)
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
			(= global115 0)
			(gEgo
				view: 3
				normalize: 3
				heading: 360
				x: 143
				y: 126
				cel: (gEgo lastCel:)
			)
		)
		(localproc_2)
		(collectDoor approachX: (gEgo x:))
		(gGame handsOn:)
		(= global125 0)
		(super dispose: &rest)
	)
)

(instance sComeDownStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 5
						normalize: 5
						heading: 225
						cel: 0
						setLoop: 0 1
						x: 143
						y: 126
					)
					(if (not (gCast contains: gEgo))
						(gEgo init:)
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
			(= global115 0)
			(gEgo view: 5 x: 143 y: 126 cel: (gEgo lastCel:))
		)
		(localproc_2)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sExitToCollect of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if
						(and
							(or
								(not (gEgo heading:))
								(== (gEgo heading:) 360)
							)
							(== (gEgo x:) 143)
						)
						(gEgo
							view: 7306
							cel: 0
							setLoop: 0 1
							setCycle: CT 7 1 self
						)
					else
						(proc1111_13 register self)
					)
				)
				(1
					(gEgo
						view: 7303
						setScaler: Scaler 126 104 129 122
						setLoop: 0 1
						x: 156
						y: 132
						cel: 6
					)
					(if (== gChapter 5)
						(gCurRoom drawPic: 13401 picture: 13401)
						(= local2 13401)
					else
						(gCurRoom drawPic: 13400 picture: 13400)
						(= local2 13400)
					)
					(localproc_2)
					(= cycles 2)
				)
				(2
					(gEgo setCycle: End self)
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
		(= global115 0)
		(localproc_0 9100)
		(gCurRoom newRoom: 9100)
		(super dispose: &rest)
	)
)

(instance sGiveAcid of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (and register (!= (gEgo x:) 105))
						(-- state)
						(proc1111_13 register self 1)
						(= register 0)
					else
						(if (!= (gCurRoom picture:) 13360)
							(gCurRoom drawPic: 13360 picture: 13360)
						)
						(darkDoorView
							view: 13360
							x: 158
							y: 132
							z: 0
							priority: 100
						)
						(if (not (gCast contains: darkDoorView))
							(darkDoorView init:)
						)
						(UpdateScreenItem darkDoorView)
						(proc1111_7 3030 -8 -32 gEgo 40)
					)
				)
				(1
					(gCurRoom drawPic: 13370 picture: 13370)
					(localproc_2)
					(proc1111_7 3031 5 0)
				)
				(2
					(gCurRoom drawPic: 13380 picture: 13380)
					(localproc_2)
					(proc1111_7 3032 16 -43)
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
		(gEgo put: 13) ; invDrainCln
		(SetFlag 163)
		(if local0
		else
			(= next sEndChapter2)
		)
		(super dispose: &rest)
	)
)

(instance scene302Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						(local0
							(= cycles 2)
						)
						((== (gEgo x:) 105)
							(proc1111_13 register self 1)
						)
						(else
							(proc1111_13 register self)
						)
					)
				)
				(1
					(gEgo hide:)
					(if (!= (gCurRoom picture:) 13380)
						(gCurRoom drawPic: 13380 picture: 13380)
					)
					(localproc_2)
					(proc1111_7 3020 8 -43)
				)
				(2
					(proc1111_7 3021 6 0 gEgo -1 1)
					(darkDoorView view: 3022 x: 162 y: 130 z: 1000)
					(gCurRoom drawPic: 13370 picture: 13370)
					(UpdateScreenItem darkDoorView)
				)
				(3
					(darkDoorView z: 0)
					(UpdateScreenItem darkDoorView)
				)
				(4
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
		(darkDoorView z: 1000)
		(if (gEgo has: 13) ; invDrainCln
			(= next sGiveAcid)
		else
			(= next scene305Scr)
		)
		(super dispose: &rest)
	)
)

(instance sScene489 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (!= (gEgo x:) 105)
						(proc1111_13 register self)
					else
						(proc1111_13 register self 1)
					)
				)
				(1
					(if (!= (gCurRoom picture:) 13350)
						(gCurRoom drawPic: 13350 picture: 13350)
					)
					(localproc_2)
					(proc1111_7 4890 115 11)
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
		(gEgo
			view: 4
			normalize: 4
			x: 105
			y: 117
			setScaler: Scaler 165 67 155 106
		)
		(southExit approachX: (gEgo x:))
		(gCurRoom drawPic: 13300 picture: 13300)
		(localproc_2)
		(darkDoorExit dispose:)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance scene236Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						(local0
							(= cycles 2)
						)
						((== (gEgo x:) 105)
							(proc1111_13 register self 1)
						)
						(else
							(proc1111_13 register self)
						)
					)
				)
				(1
					(gCurRoom drawPic: 13360 picture: 13360)
					(darkDoorView view: 13360 x: 142 y: 130 z: 0 priority: 4)
					(if (not (gCast contains: darkDoorView))
						(darkDoorView init:)
					)
					(UpdateScreenItem darkDoorView)
					(proc1111_7 2360 1 0)
				)
				(2
					(darkDoorView z: 1000)
					(UpdateScreenItem darkDoorView)
				)
				(3
					(gCurRoom drawPic: 13380 picture: 13380)
					(localproc_2)
					(proc1111_7 2361 24 -27)
				)
				(4
					(darkDoorView view: 13360 x: 141 y: 131 z: 1000 init:)
					(proc1111_7 2362 9 0)
					(gCurRoom drawPic: 13360 picture: 13360)
				)
				(5
					(darkDoorView z: 0)
					(UpdateScreenItem darkDoorView)
				)
				(6
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
		(SetFlag 375)
		(gEgo
			view: 7
			normalize: 7
			heading: 315
			x: 105
			y: 117
			setScaler: Scaler 165 67 155 106
		)
		(southExit approachX: (gEgo x:))
		(gCurRoom drawPic: 13300 picture: 13300)
		(SetFlag 220)
		(localproc_2)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance scene237Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (!= (gEgo x:) 105)
						(proc1111_13 register self)
					else
						(proc1111_13 register self 1)
					)
				)
				(1
					(if (!= (gCurRoom picture:) 13360)
						(gCurRoom drawPic: 13360 picture: 13360)
					)
					(proc1111_7 2370 -14 -19)
					(darkDoorView view: 13360 x: 141 y: 132 z: 0 priority: 4)
					(if (not (gCast contains: darkDoorView))
						(darkDoorView init:)
					)
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
		(proc1111_6)
		(= global115 0)
		(gEgo
			view: 7
			normalize: 7
			heading: 315
			x: 105
			y: 117
			setScaler: Scaler 165 67 155 106
		)
		(southExit approachX: (gEgo x:))
		(if (!= (gCurRoom picture:) 13300)
			(gCurRoom drawPic: 13300 picture: 13300)
		)
		(localproc_2)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sScene404 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 4040 1 0)
					(if (!= (gCurRoom picture:) 13360)
						(gCurRoom drawPic: 13360 picture: 13360)
					)
					(darkDoorView view: 13360 x: 142 y: 130 z: 0 priority: 100)
					(if (not (gCast contains: darkDoorView))
						(darkDoorView init:)
					)
					(UpdateScreenItem darkDoorView)
				)
				(1
					(darkDoorView z: 1000)
					(UpdateScreenItem darkDoorView)
				)
				(2
					(darkDoorView z: 0)
					(UpdateScreenItem darkDoorView)
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
		(gEgo
			view: 7
			normalize: 7
			heading: 315
			x: 105
			y: 117
			setScaler: Scaler 165 67 155 106
		)
		(southExit approachX: (gEgo x:))
		(darkDoorExit dispose:)
		(gCurRoom drawPic: 13300 picture: 13300)
		(localproc_2 1)
		(SetFlag 222)
		(proc1111_0 0)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sNoDon3 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (!= (gEgo x:) 105)
						(proc1111_13 register self)
					else
						(proc1111_13 register self 1)
					)
				)
				(1
					(gEgo hide:)
					(if (and (not (IsFlag 403)) (IsFlag 405))
						(self cue:)
					else
						(gCurRoom drawPic: 13350 picture: 13350)
						(localproc_2)
						(proc1111_7 4891 113 12)
					)
				)
				(2
					(if (not (IsFlag 405))
						(self dispose:)
					else
						(if (!= (gCurRoom picture:) 13380)
							(gCurRoom drawPic: 13380 picture: 13380)
						)
						(localproc_2)
						(if (IsFlag 221)
							(proc1111_7 3090 5 -43)
						else
							(proc1111_7 3020 8 -43)
						)
					)
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
		(gEgo
			view: 7
			normalize: 7
			heading: 315
			x: 105
			y: 117
			setScaler: Scaler 165 67 155 106
		)
		(gEgo show:)
		(southExit approachX: (gEgo x:))
		(if (!= (gCurRoom picture:) 13300)
			(gCurRoom drawPic: 13300 picture: 13300)
		)
		(localproc_2)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sNoDon4 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== (gEgo x:) 105)
						(proc1111_13 register self 1)
					else
						(proc1111_13 register self)
					)
				)
				(1
					(gEgo hide:)
					(if (!= (gCurRoom picture:) 13380)
						(gCurRoom drawPic: 13380 picture: 13380)
					)
					(localproc_2)
					(proc1111_7 3090 5 -43)
				)
				(2
					(darkDoorView view: 13360 x: 141 y: 132 z: 0 init:)
					(UpdateScreenItem darkDoorView)
					(gCurRoom drawPic: 13360 picture: 13360)
					(proc1111_7 3091 5 -25)
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
		(gEgo
			view: 7
			normalize: 7
			heading: 315
			x: 105
			y: 117
			setScaler: Scaler 165 67 155 106
		)
		(gEgo show:)
		(southExit approachX: (gEgo x:))
		(if (!= (gCurRoom picture:) 13300)
			(gCurRoom drawPic: 13300 picture: 13300)
		)
		(localproc_2)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sWasteTime of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc1111_6)
				(gEgo z: 0 show:)
				(gCurRoom drawPic: 13300 picture: 13300)
				(localproc_2)
				(proc1111_0 {One moment, please...})
				(= seconds 5)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sClimbStairs of Script
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
		(= global115 0)
		(= global125 65)
		(gCurRoom newRoom: 13500)
		(super dispose: &rest)
	)
)

(instance darkDoorExit of Trigger
	(properties
		approachX 90
		approachY 110
		approachDist 10
		exitDir 13
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 71 44 104 49 104 105 74 118
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(= global163 0)
		(if (OneOf theVerb 4 21) ; Do, Exit
			(cond
				((== gChapter 1)
					(gCurRoom setScript: sExit2Dkrm 0 self)
				)
				((== gChapter 3)
					(cond
						((not (IsFlag 403))
							(gCurRoom setScript: sNoDon3 0 self)
						)
						((IsFlag 406)
							(gCurRoom setScript: sNoDon4)
						)
						((and (IsFlag 164) (IsFlag 221))
							(SetFlag 406)
							(gCurRoom setScript: scene237Scr 0 self)
						)
						((not (IsFlag 221))
							(SetFlag 221)
							(gCurRoom setScript: sNoDon3 0 self)
						)
						(else
							(super doVerb: theVerb)
						)
					)
				)
				((== gChapter 4))
				((== gChapter 5)
					(gCurRoom setScript: sScene489 0 self)
				)
				((== gChapter 6)
					(if (IsFlag 225)
						(gCurRoom setScript: scene237Scr 0 self)
					else
						(gCurRoom setScript: scene552Scr 0 self)
					)
				)
				((== gChapter 7)
					(SetFlag 134)
					(global114 stop: 1)
					(Sounds eachElementDo: #stop)
					(if (and (gEgo has: 14) (gEgo has: 10)) ; invCrucifix, invBrooch
						(SetFlag 274)
						(gEgo put: 10) ; invBrooch
					)
					(if (!= (gGame getDisc: 7) 99)
						(gCurRoom newRoom: 45950)
					)
				)
				(
					(and
						(not (IsFlag 375))
						(not (gEgo has: 13)) ; invDrainCln
						(not (IsFlag 163))
					)
					(gCurRoom setScript: scene236Scr 0 self)
				)
				((and (IsFlag 375) (not (gEgo has: 13)) (not (IsFlag 163))) ; invDrainCln
					(gCurRoom setScript: scene237Scr 0 self)
				)
				((not (IsFlag 292))
					(gCurRoom setScript: scene237Scr 0 self)
				)
				(else
					(gCurRoom setScript: scene302Scr)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sEndChapter2 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (!= (gEgo x:) 105)
						(proc1111_13 register self)
					else
						(proc1111_13 register self 1)
					)
				)
				(1
					(if (!= (gCurRoom picture:) 13360)
						(gCurRoom drawPic: 13360 picture: 13360)
					)
					(darkDoorView view: 13361 x: 181 y: 130 z: 0 priority: 30)
					(if (not (gCast contains: darkDoorView))
						(darkDoorView init:)
					)
					(UpdateScreenItem darkDoorView)
					(gEgo hide:)
					(proc1111_7 3060 60 -9 gEgo 40)
				)
				(2
					(darkDoorView z: 1000)
					(UpdateScreenItem darkDoorView)
					(proc1111_7 3061 -2 0)
					(gCurRoom drawPic: 13370 picture: 13370)
				)
				(3
					(darkDoorView view: 13360 x: 141 y: 132 z: 0 init:)
					(UpdateScreenItem darkDoorView)
					(gCurRoom drawPic: 13360 picture: 13360)
					(proc1111_7 3062 16 -26 gEgo -1 1)
				)
				(4
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(= global115 0)
		(gGame fadeSpeed: 4)
		(gCurRoom newRoom: 44) ; chapEndRm
	)
)

(instance scene305Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (!= (gEgo x:) 105)
						(proc1111_13 register self)
					else
						(proc1111_13 register self 1)
					)
				)
				(1
					(gCurRoom drawPic: 13380 picture: 13380)
					(localproc_2)
					(proc1111_7 3051 0 -27)
				)
				(2
					(gCurRoom drawPic: 13360 picture: 13360)
					(darkDoorView view: 13362 priority: 100 x: 178 y: 130 z: 0)
					(if (not (gCast contains: darkDoorView))
						(darkDoorView init:)
					else
						(UpdateScreenItem darkDoorView)
					)
					(proc1111_7 3052 20 -19 gEgo 4 1)
				)
				(3
					(gCurRoom drawPic: 13380 picture: 13380)
					(localproc_2)
					(proc1111_7 3032 16 -43)
				)
				(4
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
		(darkDoorView z: 1000)
		(if (not local0)
			(= next sEndChapter2)
		)
		(super dispose: &rest)
	)
)

(instance scene552Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 225)
					(if (!= (gEgo x:) 105)
						(proc1111_13 register self)
					else
						(proc1111_13 register self 1)
					)
					(roomFx stop:)
				)
				(1
					(donSounds dispose:)
					(proc1111_7 5520 106 6)
					(darkDoorView x: 125 y: -1 z: 0 view: 13350 init:)
					(if (!= (gCurRoom picture:) 13350)
						(gCurRoom drawPic: 13350 picture: 13350)
					)
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
		(SetFlag 385)
		(proc1111_6)
		(= global115 0)
		(gEgo
			view: 4
			normalize: 4
			heading: 134
			x: 105
			y: 117
			setScaler: Scaler 165 67 155 106
		)
		(southExit approachX: (gEgo x:))
		(darkDoorExit dispose:)
		(if (!= (gCurRoom picture:) 13300)
			(gCurRoom drawPic: 13300 picture: 13300)
		)
		(localproc_2)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance donSounds of cObj
	(properties)

	(method (dispose)
		(roomFx client: 0 stop:)
		(super dispose: &rest)
	)

	(method (cue &tmp temp0)
		(switch (Random 1 15)
			(5
				(if
					(and
						(OneOf (roomFx number:) 13063 13064)
						(!= local3 13060)
					)
					(roomFx
						number: 13060
						loop: 1
						setLoop: 1
						play: (Random 90 127) self
					)
					(= local3 13060)
				else
					(self cue:)
				)
			)
			(10
				(if
					(and
						(OneOf (roomFx number:) 13063 13064)
						(!= local3 13061)
					)
					(roomFx
						number: 13061
						loop: 1
						setLoop: 1
						play: (Random 90 127) self
					)
					(= local3 13061)
				else
					(self cue:)
				)
			)
			(15
				(if
					(and
						(OneOf (roomFx number:) 13063 13064)
						(!= local3 13062)
					)
					(roomFx
						number: 13062
						loop: 1
						setLoop: 1
						play: (Random 90 127) self
					)
					(= local3 13062)
				else
					(self cue:)
				)
			)
			(else
				(cond
					((<= (= temp0 (Random 1 100)) 40)
						(roomFx
							number: 13063
							loop: 1
							setLoop: 1
							play: (Random 90 127) self
						)
					)
					((<= temp0 70)
						(roomFx
							number: 13064
							loop: 1
							setLoop: 1
							play: (Random 90 127) self
						)
					)
					(else
						(roomFx stop:)
						(roomTimer setTicks: self (Random 30 120))
					)
				)
			)
		)
	)
)

(instance roomTimer of Timer
	(properties)
)

(instance roomFx of Sound
	(properties)
)

