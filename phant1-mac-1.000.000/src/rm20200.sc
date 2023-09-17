;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20200)
(include sci.sh)
(use Main)
(use movieScr)
(use Trigger)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm20200 0
)

(local
	local0
)

(instance rm20200 of ScaryRoom
	(properties
		picture 20200
		stepSound 4
	)

	(method (drawPic param1)
		(cond
			(
				(and
					(or (== gChapter 6) (and (== gChapter 5) (IsFlag 291)))
					(== param1 20200)
					(not (IsFlag 216))
				)
				(if (gCast contains: myShimmer)
					(myShimmer show:)
				else
					(myShimmer init:)
				)
				(myShimmer setCycle: Fwd)
			)
			((gCast contains: myShimmer)
				(myShimmer hide:)
			)
		)
		(super drawPic: param1 &rest)
	)

	(method (init &tmp temp0)
		(proc1111_6)
		(= temp0 0)
		(if (and (< gChapter 6) (not (IsFlag 33)))
			(milStone init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		)
		(if (not (IsFlag 28))
			(dustyL init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
			(dustyR init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
		)
		(if (and (< 2 gChapter 6) (not (IsFlag 351)))
			(gGDacSound setVol: 80)
		)
		(switch gPrevRoomNum
			(900
				(gEgo
					init:
					normalize:
					setIntensity: 80 1
					setScaler: Scaler 135 77 130 97
				)
				(if (== (gEgo x:) 95)
					(gEgo setPri: 101)
				)
				(gGame handsOn:)
			)
			(20210
				(if (and (not (IsFlag 26)) (< 2 gChapter 6))
					(= picture 20220)
					(= temp0 sHearRat)
				else
					(= temp0 sEnterFromAlcove)
				)
			)
			(911 ; altStartupRoom
				(= global201 0)
				(gEgo
					view: 5
					normalize: 5
					heading: 225
					x: 154
					y: 111
					z: 0
					setScaler: Scaler 135 77 130 97
					init:
				)
				(gGame handsOn:)
			)
			(else
				(cond
					((IsFlag 109)
						(gEgo
							view: 4
							x: 154
							y: 111
							z: 0
							heading: 135
							normalize: 4
							setScaler: Scaler 135 77 130 97
							init:
						)
						(= temp0 sFinishHammerShit)
					)
					((== global125 13)
						(= temp0 sItsDusty)
					)
					((== global125 46)
						(gEgo
							view: 6
							heading: 45
							normalize: 6
							x: 258
							y: 112
							z: 0
							cel: 0
							setScaler: Scaler 135 77 130 97
							init:
						)
						(= picture 20310)
						(= temp0 sLookMilstone)
					)
					(else
						(switch global201
							(11
								(gEgo
									view: 6
									heading: 45
									normalize: 6
									x: 258
									y: 112
									z: 0
									cel: 0
									setScaler: Scaler 135 77 130 97
									init:
								)
							)
							(4
								(gEgo
									view: 3
									normalize: 3
									x: 95
									y: 96
									z: 0
									cel: (gEgo lastCel:)
									heading: 0
									init:
									setPri: 101
									setScaler: Scaler 135 77 130 97
								)
							)
							(3
								(gEgo
									view: 6
									heading: 45
									x: 96
									y: 111
									z: 0
									normalize: 6
									init:
									setScaler: Scaler 135 77 130 97
								)
							)
							(2
								(gEgo
									view: 6
									heading: 45
									x: 147
									y: 126
									z: 0
									normalize: 6
									init:
									setScaler: Scaler 135 77 130 97
								)
							)
							(else
								(gEgo
									view: 6
									heading: 45
									x: 236
									y: 134
									z: 0
									normalize: 6
									init:
									setScaler: Scaler 135 77 130 97
								)
							)
						)
						(= global115 0)
						(= temp0 enterFrom20100)
					)
				)
			)
		)
		(super init:)
		(southExitL init:)
		(southExitM init:)
		(southExitR init:)
		(alcoveDoor init:)
		((ScriptID 30) init:) ; FidgetCode
		(if (and (!= temp0 sHearRat) (not (gEgo has: 5)) (not (IsFlag 128))) ; invHammer
			(hammer x: 241 y: 122 view: 602 init: show:)
		)
		(if
			(or
				(and (== gChapter 6) (not (IsFlag 216)))
				(and (!= gChapter 6) (not (IsFlag 29)))
			)
			(spikot init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		)
		(if temp0
			(self setScript: temp0 0 0)
		)
		(global114 play: 20000)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 20210 20100))
			(gEgo setIntensity: 100 1)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance rat of Prop
	(properties
		view 3171
	)
)

(instance myShimmer of Prop
	(properties
		x 6
		y 70
		priority 5
		view 20200
	)
)

(instance dust of Prop
	(properties
		x 163
		y 50
		view 20250
	)
)

(instance spikot of Feature
	(properties
		sightAngle 360
		approachDist 10
	)

	(method (init)
		(if (== (gEgo x:) 95)
			(= approachX 20)
			(= approachY 149)
		else
			(= approachX 40)
			(= approachY 103)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 21 15 24 23 34 18 44 24 47 35 49 41 58 37 66 53 70 53 96 46 97 38 95 36 99 25 100 18 97 10 98 11 102 -1 104
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sDoSpikot 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance dustyL of Feature
	(properties
		sightAngle 360
		approachX 179
		approachY 104
		approachDist 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 114 92 159 100 159 51 147 53 132 51 121 55 121 72 114 74
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sItsDusty 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance dustyR of Feature
	(properties
		sightAngle 360
		approachX 179
		approachY 104
		approachDist 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 49 193 49 199 52 206 51 218 56 218 70 221 72 220 92 199 105 185 104
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sItsDusty 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance milStone of Feature
	(properties
		sightAngle 360
		approachX 282
		approachY 105
		approachDist 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 293 24 289 24 288 51 267 60 267 67 259 70 258 75 261 79 262 99 293 108
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(self setHotspot: 0)
			(gCurRoom setScript: sLookMilstone 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExitL of Trigger
	(properties
		approachX 7
		approachY 189
		approachDist 10
		exitDir 12
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 0 104 42 98 54 107 68 106 101 115 74 132 0 133
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

(instance southExitM of Trigger
	(properties
		approachX 53
		approachY 189
		approachDist 10
		exitDir 12
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 103 115 158 129 158 135 71 135
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

(instance southExitR of Trigger
	(properties
		approachX 299
		approachY 162
		approachDist 10
		exitDir 3
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 183 128 183 140 300 140 300 128
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(if (== (gEgo x:) 40)
				(gCurRoom setScript: sExitSouth 0 southExitM)
			else
				(gCurRoom setScript: sExitSouth 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance alcoveDoor of Trigger
	(properties
		approachX 117
		approachY 83
		approachDist 20
		exitDir 1
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 107 39 110 32 117 30 126 37 127 52 121 56 120 65 122 66 121 72 112 72 113 76 114 74 114 94 107 89
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
			((and (< 2 gChapter 6) (not (IsFlag 25)))
				(gCurRoom setScript: sHearWoman 0 self)
			)
			(else
				(gCurRoom setScript: sExit2Alcove 0 self)
			)
		)
	)
)

(instance hammer of Prop
	(properties
		sightAngle 360
		approachX 235
		approachY 140
		approachDist 10
		x 241
		y 122
		view 602
		signal 26657
	)

	(method (init)
		(self approachVerbs: 0 setHotspot: 4 1 3 2 21 setPri: 4) ; Do, ???, Move, ???, Exit
		(hammerFeat init:)
		(super init: &rest)
	)

	(method (dispose)
		(hammerFeat dispose:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sGetHammer 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sFinishHammerShit of Script
	(properties)

	(method (dispose)
		(ClearFlag 109)
		(= global115 0)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(self dispose:)
				)
			)
		else
			(self dispose:)
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
					(switch register
						(southExitL
							(= global201 1)
						)
						(southExitM
							(= global201 2)
						)
						(southExitR
							(= global201 3)
						)
					)
				)
				(1
					(gCurRoom newRoom: 20100)
				)
			)
		else
			(= global115 0)
			(gCurRoom newRoom: 20100)
		)
	)
)

(instance sHearRat of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 2)
				)
				(1
					(sFx number: 20032 setLoop: 1 setVol: 80 play: self)
					(rat
						x: 93
						y: 134
						setLoop: 0 1
						cel: 0
						ignoreActors: 1
						setCycle: End self
						init:
					)
				)
				(2
					(if (not (rat cycler:))
						(rat dispose:)
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
		(sFx stop:)
		(if global115
			(proc1111_6)
		)
		(= global115 0)
		(SetFlag 26)
		(rat dispose:)
		(gCurRoom drawPic: 20200 picture: 20200)
		(if (and (not (gEgo has: 5)) (not (IsFlag 128))) ; invHammer
			(hammer x: 241 y: 122 view: 602 init: show:)
		)
		(= next sEnterFromAlcove)
		(super dispose: &rest)
	)
)

(instance sEnterFromAlcove of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 5
						normalize: 5
						x: 95
						y: 96
						z: 0
						cel: 0
						setLoop: 0 1
						heading: 225
						init:
						setScaler: Scaler 135 77 130 97
					)
					(= cycles 2)
				)
				(1
					(if (and (not (IsFlag 26)) (> gChapter 3))
						(rat init: setCycle: End)
					)
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
		)
		(= global115 0)
		(gEgo
			view: 5
			heading: 225
			normalize: 5
			setPri: 101
			setScaler: Scaler 135 77 130 97
		)
		(= global201 0)
		(milStone approachX: 236 approachY: 133)
		(spikot approachX: 45 approachY: 111)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance hammerFeat of Feature
	(properties
		sightAngle 360
		approachDist 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 119 255 113 265 126 238 128
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(hammer doVerb: theVerb)
	)
)

(instance sFx of Sound
	(properties)
)

(instance sGetHammer of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 20011) ; WAVE
					(if (== (gEgo x:) 258)
						(proc1111_13 register self 1)
					else
						(proc1111_13 register self)
					)
				)
				(1
					(hammer dispose:)
					(gEgo
						setPri: -1
						view: 600
						setScale: 0
						setScaler: 0
						cel: 0
						setLoop: 0 1
						x: 252
						y: 91
						setCycle: CT 15 1 self
					)
					(gCurRoom drawPic: 20310 picture: 20310)
				)
				(2
					(sFx number: 20011 setLoop: 1 play:)
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
		(if global115
			(proc1111_6)
		)
		(= global115 0)
		(hammer dispose:)
		(gEgo
			view: 6
			heading: 315
			normalize: 6
			get: 5 ; invHammer
			x: 219
			y: 129
			setScaler: Scaler 135 77 130 97
		)
		(if (!= (gCurRoom picture:) 20200)
			(gCurRoom drawPic: 20200 picture: 20200)
		)
		(southExitR approachX: (gEgo x:))
		(SetFlag 128)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sDoTheCask of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCurRoom drawPic: -1)
					(gEgo hide:)
					(PlayVMD 0 {5440.vmd} 0) ; Open
					(proc26_0 5440 self)
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
			(else
				(global114 play: 9140)
			)
		)
		(SetFlag 216)
		(gCurRoom newRoom: 1100)
		(super dispose: &rest)
	)
)

(instance sWineTurn of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= global125 0)
					(proc1111_7 590 108 8)
					(gCurRoom drawPic: 20260 picture: 20260)
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
		)
		(= global115 0)
		(if (and (not (gEgo has: 5)) (not (IsFlag 128))) ; invHammer
			(hammer view: 602 init:)
		)
		(gEgo x: 40 y: 103 z: 0 heading: 270 view: 1 normalize: 1)
		(gCurRoom drawPic: 20200 picture: 20200)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sExit2Alcove of Script
	(properties)

	(method (changeState newState)
		(if global115
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((== (gEgo x:) 40)
							(proc1111_13 register self 1)
						)
						(
							(and
								(< 2 gChapter 6)
								(not (IsFlag 25))
								(== (gEgo x:) 95)
							)
							(gEgo setPri: 95)
							(proc1111_13 register self 1)
						)
						((== (gEgo x:) 95)
							(gEgo setPri: 95)
							(proc1111_13 register self)
						)
						(else
							(proc1111_13 register self)
						)
					)
					(= register 0)
				)
				(1
					(self dispose:)
				)
			)
		)
	)

	(method (dispose)
		(= global115 0)
		(gCurRoom newRoom: 20210)
		(super dispose: &rest)
	)
)

(instance sLookMilstone of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((== global125 46)
							(++ state)
							(self cue:)
						)
						((not register)
							(= cycles 2)
						)
						((OneOf (gEgo x:) 258 40 95)
							(++ state)
							(proc1111_13 register self 1)
						)
						(else
							(++ state)
							(proc1111_13 register self)
						)
					)
				)
				(1
					(gEgo setCycle: End self)
				)
				(2
					(gEgo
						view: 630
						setCycle: 0
						setScale: 0
						setScaler: 0
						cel: 0
						setLoop: 0 1
						x: 202
						y: 137
						cycleSpeed: 8
					)
					(if (gCast contains: hammer)
						(hammer view: 20310 x: 255 y: 90)
					)
					(if (!= (gCurRoom picture:) 20310)
						(gCurRoom drawPic: 20310 picture: 20310)
					)
					(= cycles 2)
				)
				(3
					(if (IsFlag 33)
						(= seconds 4)
					else
						(++ state)
						(gEgo setCycle: End self)
					)
				)
				(4
					(self dispose:)
				)
				(5
					(if (gCast contains: hammer)
						(hammer z: 1000)
					)
					(proc1111_7 631 75 16)
					(gCurRoom drawPic: 20320 picture: 20320)
				)
				(6
					(if (gCast contains: hammer)
						(hammer z: 0)
					)
					(gEgo view: 630 cel: (gEgo lastCel:))
					(gCurRoom drawPic: 20310 picture: 20310)
					(= cycles 2)
				)
				(7
					(gEgo setCycle: Beg self)
				)
				(8
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
		)
		(= global115 0)
		(= global125 0)
		(= global201 0)
		(gEgo
			view: 6
			heading: 45
			normalize: 6
			x: 258
			y: 112
			z: 0
			setScaler: Scaler 135 77 130 97
		)
		(southExitR approachX: 230)
		(if (!= (gCurRoom picture:) 20200)
			(gCurRoom drawPic: 20200 picture: 20200)
		)
		(if (gCast contains: hammer)
			(hammer view: 602 x: 241 y: 122 z: 0 approachX: 245 approachY: 140)
		)
		(SetFlag 33)
		(milStone dispose:)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance enterFrom20100 of Script
	(properties)

	(method (changeState newState)
		(if (and state global115)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((== global201 11)
							(gEgo
								view: 6
								heading: 45
								normalize: 6
								x: 258
								y: 112
								z: 0
								cel: 0
								setScaler: Scaler 135 77 130 97
							)
							(southExitR approachX: 230)
						)
						((== global201 1)
							(gEgo
								view: 3
								heading: 45
								normalize: 3
								x: 258
								y: 112
								z: 0
								cel: 0
								setLoop: 0 1
								setScaler: Scaler 135 77 130 97
							)
							(southExitR approachX: 230)
						)
						((< global201 4)
							(gEgo
								view: 6
								heading: 45
								normalize: 6
								x: 154
								y: 111
								z: 0
								cel: 0
								setLoop: 0 1
								setScaler: Scaler 135 77 130 97
							)
						)
						(else
							(gEgo
								view: 3
								normalize: 3
								x: 95
								y: 96
								z: 0
								cel: 0
								heading: 0
								setScaler: Scaler 135 77 130 97
							)
							(gEgo setPri: 101)
						)
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
		)
	)

	(method (dispose)
		(= global115 0)
		(if (== global201 4)
			(gEgo view: 3 heading: 0 normalize: 3 z: 0 setPri: 101)
		)
		(gEgo cel: (gEgo lastCel:))
		(= global201 0)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sDoSpikot of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== (gEgo x:) 40)
						(proc1111_13 register self 2)
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
			(
				(or
					(and (== gChapter 6) (not (IsFlag 216)))
					(and (== gChapter 5) (IsFlag 291) (not (IsFlag 216)))
				)
				(= next sDoTheCask)
			)
			((not (IsFlag 29))
				(= next sWineTaste)
			)
			(else
				(gGame handsOn:)
			)
		)
		(if (gCast contains: hammer)
			(hammer dispose:)
		)
		(super dispose: &rest)
	)
)

(instance sWineTaste of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 580 120 9)
					(gCurRoom drawPic: 20260 picture: 20260)
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
		)
		(= global115 0)
		(SetFlag 29)
		(if (and (not (gEgo has: 5)) (not (IsFlag 128))) ; invHammer
			(hammer view: 602 x: 241 y: 122 z: 0 approachVerbs: 0 init:)
		)
		(= global125 0)
		(gEgo x: 40 y: 103 z: 0 heading: 270 view: 1 normalize: 1)
		(gCurRoom drawPic: 20200 picture: 20200)
		(spikot dispose:)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sItsDusty of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gCast contains: hammer)
						(= local0 1)
					)
					(cond
						((and (== (gEgo heading:) 45) (== (gEgo x:) 154))
							(++ state)
							(= cycles 2)
						)
						((OneOf (gEgo x:) 154 95)
							(++ state)
							(proc1111_13 register self 1)
						)
						(register
							(++ state)
							(proc1111_13 register self)
						)
						(else
							(gEgo
								view: 6
								normalize: 6
								setLoop: 0 1
								cel: 0
								x: 154
								y: 111
								z: 0
								init:
								setScaler: Scaler 135 77 130 97
							)
							(= ticks 30)
						)
					)
				)
				(1
					(gEgo setCycle: End self)
				)
				(2
					(Load rsVIEW 20250)
					(Lock rsVIEW 20250 1)
					(dust z: 1000 init:)
					(= ticks 30)
				)
				(3
					(= global125 0)
					(gEgo setPri: -1)
					(proc1111_7 570 92 8)
					(gCurRoom drawPic: 20250 picture: 20250)
					(if local0
						(hammer dispose:)
					)
				)
				(4
					(dust cel: 0 z: 0 setCycle: End)
					(UpdateScreenItem dust)
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
			(proc1111_6)
		)
		(= global115 0)
		(dust dispose:)
		(SetFlag 28)
		(gEgo
			view: 6
			heading: 45
			normalize: 6
			x: 154
			y: 111
			z: 0
			setScaler: Scaler 135 77 130 97
		)
		(if local0
			(hammer view: 602 x: 241 y: 122 init:)
			(= local0 0)
		)
		(gCurRoom drawPic: 20200 picture: 20200)
		(dustyR setHotspot: 0)
		(dustyL setHotspot: 0)
		(Lock rsVIEW 20250 0)
		(UnLoad 128 20250)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sHearWoman of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(if global115
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= temp0 (gEgo x:))
					(= temp1 (gEgo y:))
					(gEgo setScaler: Scaler 100 47 130 98)
					(cond
						((and (== temp0 154) (== temp1 111))
							(gEgo
								normalize: 2
								x: 123
								y: 127
								setHeading: 225 self
							)
						)
						((and (== temp0 258) (== temp1 112))
							(gEgo
								normalize: 6
								x: 169
								y: 112
								setHeading: 180 self
							)
						)
						((and (== temp0 95) (== temp1 96))
							(gEgo
								normalize: 7
								x: 54
								y: 139
								setHeading: 315 self
							)
						)
						((and (== temp0 96) (== temp1 111))
							(gEgo
								normalize: 7
								x: 129
								y: 133
								setHeading: 270 self
							)
						)
						((and (== temp0 147) (== temp1 126))
							(gEgo
								normalize: 7
								x: 190
								y: 128
								setHeading: 270 self
							)
						)
						((and (== temp0 236) (== temp1 134))
							(gEgo
								normalize: 7
								x: 175
								y: 115
								setHeading: 225 self
							)
						)
						((and (== temp0 219) (== temp1 129))
							(gEgo
								normalize: 7
								x: 195
								y: 108
								setHeading: 225 self
							)
						)
						((and (== temp0 40) (== temp1 103))
							(gEgo
								normalize: 5
								x: 71
								y: 152
								setHeading: 315 self
							)
						)
						(else
							(self cue:)
						)
					)
					(= register 0)
					(gCurRoom drawPic: 20100 picture: 20100)
					(if (gCast contains: hammer)
						(hammer
							view: 609
							loop: 0
							cel: 0
							x: 179
							y: 107
							approachVerbs: 0
							setHotspot: 4 3 ; Do, Move
							z: 0
						)
						(UpdateScreenItem hammer)
					)
					(SetFlag 25)
				)
				(1
					(gEgo hide:)
					(proc1111_7 3160 60 5 gEgo 100 1)
					(if (gCast contains: hammer)
						(hammer x: 241 y: 122 view: 602)
						(UpdateScreenItem hammer)
					)
					(gCurRoom drawPic: 20200 picture: 20200)
				)
				(2
					(proc1111_7 3161 56 12 gEgo -1 1)
				)
				(3
					(self dispose:)
				)
			)
		)
	)

	(method (dispose)
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(SetFlag 25)
		(= global125 74)
		(gCurRoom newRoom: 20210)
		(super dispose: &rest)
	)
)

