;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1200)
(include sci.sh)
(use Main)
(use movieScr)
(use cObj)
(use Trigger)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm1200 0
)

(local
	local0
	local1
	local2
)

(instance rm1200 of ScaryRoom
	(properties
		picture 1200
		north 2200
		east 1500
		stepSound 4
	)

	(method (init &tmp temp0)
		(if (== gChapter 5)
			(= picture 1201)
		)
		(= temp0 0)
		(KillRobot)
		(gEgo init: normalize: setScaler: Scaler 121 32 126 71)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
				(if (and (== (gEgo x:) 92) (== (gEgo y:) 78))
					(pantryDoorFeat approachX: 260 approachY: 130)
				)
			)
			(2200
				(if (and (== gChapter 1) (IsFlag 181) (not (IsFlag 83)))
					(SetFlag 83)
					(= picture -1)
					(gEgo hide:)
					(= temp0 sInRefer)
				else
					(= temp0 sFromDiningRoom)
				)
			)
			(1140
				(gEgo
					posn: (- (drawer approachX:) 2) (drawer approachY:)
					loop: 0
					setCycle: 0
					setScale: 0
				)
				(= temp0 sCloseDrawer)
			)
			(1160
				(if (== global125 73)
					(gEgo view: 6 normalize: 6 heading: 45 x: 139 y: 78)
				else
					(gEgo view: 2 normalize: 2 heading: 180 x: 139 y: 78)
				)
				(adrChair approachX: 160)
				(door approachX: 88 approachY: 73)
				(fridge approachX: 132 approachY: 75)
				(= global125 0)
				(gGame handsOn:)
			)
			(1100
				(cond
					((and (== gChapter 1) (IsFlag 181) (not (IsFlag 83)))
						(SetFlag 83)
						(= picture -1)
						(gEgo hide:)
						(= temp0 sInRefer)
					)
					((== global125 4)
						(gEgo
							x: 89
							y: 113
							setLoop: 0 1
							cel: 0
							setCycle: 0
							setScale: 0
						)
						(= global125 0)
						(= temp0 sOpenDrawer)
					)
					(else
						(= temp0 sEnterFrom1100)
					)
				)
			)
			(else
				(if (and (== gChapter 1) (IsFlag 181) (not (IsFlag 83)))
					(SetFlag 83)
					(= picture -1)
					(gEgo hide:)
					(= temp0 sInRefer)
				else
					(= temp0 sFromDiningRoom)
				)
			)
		)
		(if (== gChapter 4)
			(if
				(and
					(not (IsFlag 190))
					(not (IsFlag 51))
					(not (IsFlag 52))
					(not (IsFlag 247))
					(IsFlag 175)
				)
				(harriet init:)
				(SetFlag 49)
			else
				(ClearFlag 175)
			)
		)
		(if (and (< gChapter 6) (not (gCast contains: harriet)))
			(fridge init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
			(sink init:)
		)
		(door init:)
		(pantryDoorFeat init:)
		(super init: &rest)
		(adrChair init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(southExitL init:)
		(southExitR init:)
		(if (and (< gChapter 6) (not (IsFlag 2)))
			(drawer init:)
		)
		(if (== gChapter 1)
			(bothCups init:)
		)
		(cond
			((and local2 temp0)
				(self setScript: temp0 automationControl)
			)
			(temp0
				(self setScript: temp0 0 0)
			)
			(else
				(gGame handsOn:)
			)
		)
		((ScriptID 30) init:) ; FidgetCode
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
			)
			((== gChapter 7)
				(global114 play: 9140)
			)
		)
	)
)

(instance sOpenDrawer of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if local1
						(= local1 0)
						(= register 18)
					else
						(= register 0)
					)
					(Load 140 10014) ; WAVE
					(gEgo
						view: 160
						x: 39
						y: 119
						setScaler: 0
						setScale: 0
						cycleSpeed: 4
						cel: register
						setLoop: 0 1
						setCycle: CT 36 1 self
					)
				)
				(1
					(gEgo setCycle: End self)
					(gGDacSound number: 10014 setLoop: 1 setVol: 120 play:)
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
			(= global115 0)
		)
		(gGDacSound stop:)
		(gEgo hide:)
		(= global204 2)
		(gCurRoom newRoom: 1140)
		(super dispose: &rest)
	)
)

(instance pantryDoorView of View
	(properties
		x 105
		y 81
		view 1104
	)
)

(instance pantryDoorFeat of Trigger
	(properties
		approachX 270
		approachY 120
		exitDir 10
	)

	(method (init)
		(self
			approachVerbs: 0
			setHotspot: 4 3 ; Do, Move
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 271 0 267 2 259 105 297 120 300 -4
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not (OneOf theVerb 4 21)) ; Do, Exit
				(super doVerb: theVerb)
			)
			((and (IsFlag 179) (not (IsFlag 12)) (gCast contains: harriet))
				(gCurRoom setScript: sGetReading 0 harriet)
			)
			(else
				(gCurRoom setScript: sExitToPantry 0 self)
			)
		)
	)
)

(instance harriet of Prop
	(properties
		approachX 143
		approachY 77
		approachDist 10
		x 143
		y 77
		view 4181
	)

	(method (dispose)
		(gGDacSound client: 0 stop:)
		(super dispose:)
	)

	(method (cue)
		(gGDacSound number: (Random 1040 1043) setLoop: 1 play: self)
	)

	(method (hide)
		(gGDacSound client: 0 stop:)
		(super hide: &rest)
	)

	(method (show)
		(self cue:)
		(super show: &rest)
	)

	(method (init)
		(self ignoreActors: 1 approachVerbs: 0 setHotspot: 4 3 15 setCycle: Fwd) ; Do, Move, invTarot
		(self cue:)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (not (IsFlag 176)) (not (IsFlag 45)))
						(SetFlag 45)
						(gCurRoom setScript: sHarrietNoBuild 0 self)
					)
					((and (IsFlag 176) (not (IsFlag 153)))
						(SetFlag 153)
						(gCurRoom setScript: sHarrietBuild 0 self)
					)
					(else
						(gCurRoom setScript: sHarrietDone 0 self)
					)
				)
			)
			(15 ; invTarot
				(if (gEgo has: 9) ; invTarot
					(gEgo put: 9) ; invTarot
					(gCurRoom setScript: sGiveTarot 0 self)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance adrChair of Feature
	(properties
		sightAngle 360
		approachX 197
		approachY 128
	)

	(method (init)
		(self
			approachVerbs: 0
			setHotspot: 4 3 ; Do, Move
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 105 178 110 181 111 179 119 185 125 177 129 189 130 189 125 198 133 206 132 216 133 209 125 218 96 220 69 209 72 204 68 204 90 198 101 192 98
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 4) ; Do
				(super doVerb: theVerb)
			)
			((and (IsFlag 179) (not (IsFlag 12)) (gCast contains: harriet))
				(gCurRoom setScript: sGetReading 0 harriet)
			)
			(else
				(gCurRoom setScript: sSitChair 0 self)
			)
		)
	)
)

(instance fridge of Feature
	(properties
		approachX 117
		approachY 73
	)

	(method (init)
		(self
			sightAngle: 360
			approachVerbs: 0
			setHotspot: 4 3 ; Do, Move
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 109 55 121 54 128 55 128 74 115 76 109 73
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sLookInFridge 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drawer of Feature
	(properties)

	(method (init)
		(self
			approachX: 74
			approachY: 117
			sightAngle: 360
			approachVerbs: 0
			setHotspot: 4 3 ; Do, Move
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 39 84 60 77 81 78 82 109 62 119 41 117
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sDoDrawer 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of Trigger
	(properties)

	(method (init)
		(self
			exitDir: 13
			sightAngle: 360
			approachX: 88
			approachY: 63
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 79 40 99 40 99 69 79 64 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not (OneOf theVerb 21 4)) ; Exit, Do
				(super doVerb: theVerb)
			)
			((and (IsFlag 179) (not (IsFlag 12)) (gCast contains: harriet))
				(gCurRoom setScript: sGetReading 0 harriet)
			)
			(else
				(gCurRoom setScript: sExitToDining 0 self)
			)
		)
	)
)

(instance southExitR of Trigger
	(properties)

	(method (init)
		(self
			exitDir: 11
			sightAngle: 360
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 211 112 268 112 295 120 293 132 209 132 213 122
					yourself:
				)
			approachX: 290
			approachY: 189
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not (OneOf theVerb 21 4)) ; Exit, Do
				(super doVerb: theVerb)
			)
			((and (IsFlag 179) (not (IsFlag 12)) (gCast contains: harriet))
				(gCurRoom setScript: sGetReading 0 harriet)
			)
			(else
				(= global125 66)
				(gCurRoom setScript: sExitTo1100 0 self)
			)
		)
	)
)

(instance sExitToDining of Script
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
		(gCurRoom newRoom: 2200)
		(super dispose: &rest)
	)
)

(instance sExitToPantry of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== (gEgo x:) 102)
						(proc1111_13 register self 1)
					else
						(proc1111_13 register self)
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
		(= global115 0)
		(= global125 26)
		(= global204 3)
		(gCurRoom newRoom: 1100)
		(super dispose: &rest)
	)
)

(instance sSitChair of Script
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
		(= global125 3)
		(gCurRoom newRoom: 1100)
		(super dispose: &rest)
	)
)

(instance southExitL of Trigger
	(properties)

	(method (init)
		(self
			exitDir: 12
			sightAngle: 360
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 8 130 40 117 62 119 75 111 115 112 120 132
					yourself:
				)
			approachX: 60
			approachY: 189
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not (OneOf theVerb 21 4)) ; Exit, Do
				(super doVerb: theVerb)
			)
			((and (IsFlag 179) (not (IsFlag 12)) (gCast contains: harriet))
				(gCurRoom setScript: sGetReading 0 harriet)
			)
			(else
				(= global125 67)
				(gCurRoom setScript: sExitTo1100 0 self)
			)
		)
	)
)

(instance sEnterFrom1100 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo y: 100)
					(switch global204
						(3
							(gEgo
								x: 193
								view: 7
								normalize: 7
								heading: 315
								cel: 0
								setLoop: 0 1
							)
						)
						(2
							(gEgo
								x: 102
								y: 112
								heading: 45
								view: 3
								normalize: 3
								cel: 0
								setLoop: 0 1
							)
						)
						(5
							(gEgo
								x: 118
								y: 96
								heading: 315
								view: 7
								normalize: 7
								cel: 0
								setLoop: 0 1
							)
							(drawer approachX: 95 approachY: 117)
							(pantryDoorFeat approachX: 200)
							(door approachX: (gEgo x:))
						)
						(1
							(if (IsFlag 106)
								(gEgo
									x: 200
									view: 6
									normalize: 6
									heading: 45
									cel: 0
									setLoop: 0 1
								)
							else
								(gEgo
									x: 200
									view: 7
									normalize: 7
									heading: 315
									cel: 0
									setLoop: 0 1
								)
							)
						)
						(else
							(gEgo
								view: 7
								normalize: 7
								heading: 315
								x: 222
								cel: 0
								setLoop: 0 1
							)
						)
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
			(KillRobot)
			(= global115 0)
		)
		(ClearFlag 106)
		(gGame handsOn:)
		(= global125 0)
		(super dispose: &rest)
	)
)

(instance sExitTo1100 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (OneOf (gEgo x:) 102 118)
						(proc1111_13 register self 1)
					else
						(proc1111_13 register self)
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
		(= global115 0)
		(cond
			((and (== register southExitR) (== global125 67) (== global204 5))
				(SetFlag 106)
				(= global204 3)
			)
			((and (== global125 67) (OneOf global204 3 1 4))
				(SetFlag 106)
				(= global204 2)
			)
			((and (== global125 66) (== global204 5))
				(= global204 3)
				(SetFlag 106)
			)
			((and (== global125 66) (OneOf global204 2 5))
				(= global204 3)
				(SetFlag 106)
			)
			((== global125 67)
				(= global204 2)
			)
			((and (== global125 66) (== global204 6))
				(= global204 1)
			)
		)
		(gCurRoom newRoom: 1100)
		(super dispose: &rest)
	)
)

(instance sFromDiningRoom of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 2
						normalize: 2
						x: 92
						y: 78
						cel: 0
						setLoop: 0 1
						setScaler: Scaler 121 32 126 71
						init:
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
			(KillRobot)
			(= global115 0)
		)
		(= global204 6)
		(pantryDoorFeat approachX: 260 approachY: 130)
		(if (and (IsFlag 179) (not (IsFlag 12)) (gCast contains: harriet))
			(sGetReading register: harriet)
			(= next sGetReading)
		else
			(gGame handsOn:)
		)
		(super dispose: &rest)
	)
)

(instance soapAndStuff of View
	(properties)
)

(instance coffeeCup of View
	(properties)
)

(instance glass of View
	(properties)
)

(instance mat of View
	(properties)
)

(instance bothCups of View
	(properties
		x 157
		y 92
		priority 120
		fixPriority 1
		view 1203
	)

	(method (init)
		(cond
			((!= gChapter 1)
				(self dispose:)
				(return 0)
			)
			((== (gCurRoom picture:) 1200)
				(= view 1203)
				(= cel (= loop 0))
				(= x 157)
				(= y 92)
				(= priority 120)
				(= fixPriority 1)
				(super init: &rest)
			)
			((== (gCurRoom picture:) 1105)
				(= view 11051)
				(= x 153)
				(= y 83)
				(= priority -1)
				(= fixPriority 0)
				(super init: &rest)
			)
		)
	)
)

(instance sink of Feature
	(properties
		sightAngle 360
		approachX 138
		approachY 71
	)

	(method (init)
		(self
			approachVerbs: 0
			setHotspot: 4 3 ; Do, Move
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 138 58 135 73 149 77 159 75 159 61
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(and
						(gCast contains: harriet)
						(IsFlag 175)
						(harriet scratch:)
						((harriet scratch:) respondsTo: #scaleX)
					)
					(harriet doVerb: theVerb)
				else
					(gCurRoom setScript: sUseSink 0 self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sDoDrawer of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== global204 2)
						(proc1111_13 register self 1)
						(= register 0)
					else
						(proc1111_13 register self)
					)
				)
				(1
					(if (OneOf global204 5 6 4)
						(Load rsVIEW 7300 3)
						(Lock rsVIEW 7300 1)
						(Lock rsVIEW 3 1)
						(gEgo
							view: 3
							normalize: 3
							heading: 0
							x: 216
							y: 113
							cel: 0
							setLoop: 0 1
						)
						(+= state 2)
						(= cycles 2)
					else
						(gEgo
							view: 166
							cel: 0
							setScaler: 0
							setScale: 0
							heading: 90
							x: 213
							y: 113
							setLoop: 0 1
						)
						(= local1 1)
						(= cycles 2)
					)
					(gCurRoom drawPic: 1105 picture: 1105)
					(if (== gChapter 1)
						(bothCups init:)
					)
				)
				(2
					(gEgo setCycle: End self)
				)
				(3
					(self dispose:)
				)
				(4
					(gEgo setCycle: End self)
				)
				(5
					(gEgo
						view: 7300
						cel: 0
						setLoop: 0 1
						setCycle: CT 10 1 self
					)
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
			(KillRobot)
			(= global115 0)
		)
		(Lock rsVIEW 7300 0)
		(Lock rsVIEW 3 0)
		(UnLoad 128 7300)
		(UnLoad 128 3)
		(gEgo x: 89 y: 113 setLoop: 0 1 cel: 0 setCycle: 0 setScale: 0)
		(if (== gChapter 5)
			(gCurRoom drawPic: 1201 picture: 1201)
		else
			(gCurRoom drawPic: 1200 picture: 1200)
		)
		(if (== gChapter 1)
			(bothCups init:)
		)
		(= global204 2)
		(= global125 0)
		(= next sOpenDrawer)
		(super dispose: &rest)
	)
)

(instance sCloseDrawer of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (IsFlag 2)
						(gEgo hide: get: 8) ; invMatch
						(DoRobot 161 35 40 gEgo 200 1)
					else
						(Load rsVIEW 160)
						(gGDacSound number: 10017 setLoop: 1 setVol: 120 play:)
						(gEgo
							view: 160
							x: 39
							y: 119
							setScaler: 0
							setScale: 0
							cycleSpeed: 6
							cel: 49
							setLoop: 0 1
							setCycle: CT 30 -1 self
						)
					)
				)
				(1
					(gGDacSound stop:)
					(gEgo setCycle: Beg self)
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
			(= global115 0)
		)
		(gGDacSound stop:)
		(ClearFlag 106)
		(= global125 4)
		(= global204 2)
		(gCurRoom newRoom: 1100)
		(super dispose: &rest)
	)
)

(instance sInRefer of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(pantryDoorView dispose:)
					(pantryDoorFeat init:)
					(PlayVMD 0 {1540.vmd} 0) ; Open
					(proc26_0 1540 self)
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
			(= global115 0)
		)
		(gEgo
			normalize: 4
			heading: 135
			x: 127
			y: 80
			setScaler: Scaler 121 32 126 71
			cel: (gEgo lastCel:)
			show:
		)
		(gCurRoom drawPic: 1200 picture: 1200)
		(bothCups init:)
		(pantryDoorFeat init:)
		(ClearFlag 53)
		(adrChair approachX: 130)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sHarrietDone of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (and register (!= (gEgo x:) 151))
						(-- state)
						(proc1111_13 register self)
						(= register 0)
					else
						(gEgo hide:)
						(harriet hide:)
						(soapAndStuff
							view: 1165
							setLoop: 0 1
							cel: 1
							setPri: 200
							x: 118
							y: 131
							init:
						)
						(coffeeCup
							view: 1165
							setLoop: 4 1
							cel: 2
							setPri: 200
							x: 207
							y: 124
							init:
						)
						(DoRobot 4200 -57 -29 gEgo 40)
						(gCurRoom drawPic: 1165 picture: 1165)
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
		(KillRobot)
		(= global115 0)
		(soapAndStuff dispose:)
		(coffeeCup dispose:)
		(gEgo show: x: 151 y: 82 view: 3 normalize: 3 heading: 0)
		(harriet show:)
		(if (== gChapter 5)
			(gCurRoom drawPic: 1201 picture: 1201)
		else
			(gCurRoom drawPic: 1200 picture: 1200)
		)
		(pantryDoorFeat init:)
		(if (IsFlag 179)
			(harriet setHotspot: 0)
		else
			(harriet approachVerbs: 0 setHotspot: 0 15) ; invTarot
		)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sHarrietNoBuild of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (and register (!= (gEgo x:) 151))
						(-- state)
						(proc1111_13 register self)
						(= register 0)
					else
						(gEgo hide:)
						(harriet hide:)
						(soapAndStuff
							view: 1165
							setLoop: 0 1
							cel: 0
							setPri: 200
							x: 106
							y: 133
							init:
						)
						(coffeeCup
							view: 1165
							setLoop: 1 1
							cel: 2
							setPri: 180
							x: 235
							y: 120
							init:
						)
						(DoRobot 4180 -70 -32 gEgo 40)
						(gCurRoom drawPic: 1165 picture: 1165)
						(glass
							view: 1165
							setLoop: 1
							cel: 0
							x: 230
							y: 120
							z: 1000
							setPri: 100
							init:
						)
					)
				)
				(1
					(glass z: 0)
					(UpdateScreenItem glass)
				)
				(2
					(glass z: 0)
					(UpdateScreenItem glass)
				)
				(3
					(glass z: 0)
					(UpdateScreenItem glass)
				)
				(4
					(glass z: 0)
					(UpdateScreenItem glass)
				)
				(5
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
			(= global115 0)
		)
		(soapAndStuff dispose:)
		(glass dispose:)
		(coffeeCup dispose:)
		(gEgo show: x: 151 y: 82 view: 3 normalize: 3 heading: 0)
		(harriet show:)
		(if (== gChapter 5)
			(gCurRoom drawPic: 1201 picture: 1201)
		else
			(gCurRoom drawPic: 1200 picture: 1200)
		)
		(pantryDoorFeat init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance automationControl of cObj
	(properties)

	(method (cue)
		(if global115
			(= global115 0)
			(KillRobot)
			(gGame handsOn:)
		else
			(switch (++ local0)
				(1
					(gEgo show: x: 151 y: 82 view: 3 normalize: 3 heading: 0)
					(gCurRoom setScript: sGiveTarot self harriet)
				)
				(2
					(gCurRoom setScript: sWasteTime self)
				)
				(3
					(gCurRoom setScript: sHarrietBuild self harriet)
				)
				(4
					(gCurRoom setScript: sWasteTime self)
				)
				(5
					(gCurRoom setScript: sHarrietDone self harriet)
				)
				(6
					(gCurRoom setScript: sWasteTime self)
				)
				(7
					(gCurRoom setScript: sGetReading self harriet)
				)
				(8
					(gCurRoom setScript: sWasteTime self)
				)
				(9
					(gCurRoom setScript: sHarrietNoBuild self harriet)
				)
				(10
					(gCurRoom setScript: sWasteTime self)
				)
				(11
					(= global125 27)
					(gCurRoom newRoom: 1100)
				)
			)
		)
	)
)

(instance sWasteTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(KillRobot)
				(harriet show:)
				(gEgo show:)
				(if (== gChapter 5)
					(gCurRoom drawPic: 1201 picture: 1201)
				else
					(gCurRoom drawPic: 1200 picture: 1200)
				)
				(= seconds 4)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sHarrietBuild of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (and register (!= (gEgo x:) 151))
						(-- state)
						(proc1111_13 register self)
						(= register 0)
					else
						(gEgo hide:)
						(harriet hide:)
						(soapAndStuff
							view: 1165
							setLoop: 0 1
							cel: 1
							setPri: 200
							x: 118
							y: 134
							init:
						)
						(mat
							view: 1165
							setLoop: 1 1
							cel: 2
							setPri: 200
							x: 236
							y: 120
							init:
						)
						(DoRobot 4190 -34 -18 gEgo 40)
						(gCurRoom drawPic: 1165 picture: 1165)
					)
				)
				(1
					(glass
						view: 1165
						setLoop: 1
						cel: 0
						x: 230
						y: 115
						setPri: 200
						init:
					)
					(UpdateScreenItem glass)
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
			(= global115 0)
		)
		(soapAndStuff dispose:)
		(mat dispose:)
		(glass dispose:)
		(gEgo show: x: 151 y: 82 view: 3 normalize: 3 heading: 0)
		(harriet show:)
		(if (== gChapter 5)
			(gCurRoom drawPic: 1201 picture: 1201)
		else
			(gCurRoom drawPic: 1200 picture: 1200)
		)
		(pantryDoorFeat init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sGetReading of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (and register (!= (gEgo x:) 151))
						(-- state)
						(proc1111_13 register self)
						(= register 0)
					else
						(gEgo z: 1000)
						(harriet z: 1000)
						(DoRobot 4220 -46 -32 gEgo 40 1)
						(soapAndStuff
							view: 1165
							setLoop: 0 1
							cel: 0
							setPri: 200
							x: 117
							y: 131
							init:
						)
						(coffeeCup
							view: 1165
							setLoop: 1 1
							cel: 2
							setPri: 180
							x: 235
							y: 120
							init:
						)
						(gCurRoom drawPic: 1165 picture: 1165)
					)
				)
				(1
					(glass
						view: 1165
						setLoop: 1
						cel: 0
						x: 236
						y: 118
						setPri: 200
						init:
					)
					(UpdateScreenItem glass)
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
			(= global115 0)
		)
		(if (not local2)
			(= global125 27)
			(gCurRoom newRoom: 1100)
		else
			(glass dispose:)
			(soapAndStuff dispose:)
			(coffeeCup dispose:)
			(gEgo z: 0)
			(harriet z: 0)
			(if (not (OneOf (gCurRoom picture:) 1200 1201))
				(if (== gChapter 5)
					(gCurRoom drawPic: 1201 picture: 1201)
				else
					(gCurRoom drawPic: 1200 picture: 1200)
				)
			)
		)
		(super dispose: &rest)
	)
)

(instance sGiveTarot of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 179)
					(if (and register (!= (gEgo x:) 151))
						(-- state)
						(proc1111_13 register self)
						(= register 0)
					else
						(gEgo hide:)
						(harriet hide:)
						(soapAndStuff
							view: 1165
							setLoop: 0 1
							cel: 1
							setPri: 200
							x: 110
							y: 132
							init:
						)
						(coffeeCup
							view: 1165
							setLoop: 4 1
							cel: 2
							setPri: 200
							x: 207
							y: 124
							init:
						)
						(DoRobot 4210 -75 -49 gEgo 40 1)
						(gCurRoom drawPic: 1165 picture: 1165)
					)
				)
				(1
					(soapAndStuff cel: 0)
					(UpdateScreenItem soapAndStuff)
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
			(= global115 0)
		)
		(if (not local2)
			(= global125 27)
			(gCurRoom newRoom: 1100)
		else
			(soapAndStuff dispose:)
			(coffeeCup dispose:)
		)
		(super dispose: &rest)
	)
)

(instance sLookInFridge of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (OneOf (gEgo x:) 127 139)
						(proc1111_13 register self 1)
					else
						(proc1111_13 register self)
					)
					(= register 0)
				)
				(1
					(DoRobot 170 17 29)
					(if (== gChapter 5)
						(gCurRoom drawPic: 1206 picture: 1206)
					else
						(gCurRoom drawPic: 1205 picture: 1205)
					)
					(if (== gChapter 1)
						(bothCups dispose:)
					)
				)
				(2
					(gEgo
						view: 4
						normalize: 4
						heading: 135
						x: 127
						y: 80
						setScaler: Scaler 121 32 126 71
					)
					(if (== gChapter 5)
						(gCurRoom drawPic: 1201 picture: 1201)
					else
						(gCurRoom drawPic: 1200 picture: 1200)
					)
					(if (== gChapter 1)
						(bothCups init:)
					)
					(= cycles 2)
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
			(KillRobot)
			(= global115 0)
			(gEgo
				view: 4
				normalize: 4
				heading: 135
				x: 127
				y: 80
				setScaler: Scaler 121 32 126 71
			)
			(if (== gChapter 5)
				(gCurRoom drawPic: 1201 picture: 1201)
			else
				(gCurRoom drawPic: 1200 picture: 1200)
			)
		)
		(pantryDoorFeat init:)
		(if (== gChapter 1)
			(bothCups init:)
		)
		(= global204 4)
		(adrChair approachX: 130)
		(gGame handsOn:)
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
					(cond
						((and (== (gEgo heading:) 45) (== (gEgo x:) 139))
							(= cycles 2)
						)
						((OneOf (gEgo x:) 139 127)
							(proc1111_13 register self 1)
						)
						(else
							(proc1111_13 register self)
						)
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
			(KillRobot)
			(= global115 0)
		)
		(gCurRoom newRoom: 1160)
		(super dispose: &rest)
	)
)

