;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18100)
(include sci.sh)
(use Main)
(use Trigger)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm18100 0
)

(local
	[local0 4]
	local4 = 5
	local5
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

(instance rm18100 of ScaryRoom
	(properties
		west 15200
		stepSound 4
	)

	(method (init &tmp temp0)
		(= temp0 0)
		(= global115 0)
		(proc1111_6)
		(if (!= gChapter 5)
			(= picture 18100)
		else
			(= picture 18101)
		)
		(gEgo init: normalize: setScaler: Scaler 149 84 135 102)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(18200
				(cond
					((== global125 52)
						(= temp0 sTurnOnShower)
					)
					((== global125 80)
						(sEnterFrom18200 register: 1)
						(= temp0 sEnterFrom18200)
					)
					(else
						(sEnterFrom18200 register: 0)
						(= temp0 sEnterFrom18200)
					)
				)
			)
			(18210
				(gEgo
					view: 612
					x: 262
					y: 189
					z: 0
					init:
					setScaler: Scaler 127 96 190 130
					setPri: 70
					cel: (gEgo lastCel:)
				)
				(gGame handsOn:)
			)
			(else
				(= picture 15110)
				(= temp0 sEnterFrom15200)
			)
		)
		(super init:)
		(hallDoor init:)
		(if (!= (gEgo x:) 262)
			(southExit init:)
		)
		(sink init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(if (!= global181 gChapter)
			(toilet init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		)
		(shower init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(if temp0
			(self setScript: temp0)
		else
			(gGame handsOn:)
		)
		(if (!= gPrevRoomNum 18210)
			((ScriptID 30) init:) ; FidgetCode
		)
		(chair init:)
	)

	(method (handleEvent event)
		(if
			(and
				(not script)
				(not (event claimed:))
				(chair onMe: gMouseX gMouseY)
			)
			(++ local5)
		)
		(super handleEvent: event)
	)
)

(instance hallDoor of Trigger
	(properties
		approachX 62
		approachY 126
		exitDir 4
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 62 0 62 129 81 129 86 117 86 10 81 0
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 21) ; Do, Exit
			(gCurRoom setScript: sExitToHallway 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance toilet of Feature
	(properties
		sightAngle 360
		approachX 137
		approachY 106
		approachDist 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 125 29 134 29 144 25 144 57 140 57 140 43 137 42 137 37 134 37 134 72 147 79 142 83 142 97 136 100 129 98 131 91 126 81 124 77 132 73 132 37 130 37 130 43 125 43
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sUseToilet)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance shower of Feature
	(properties
		sightAngle 360
		approachX 206
		approachY 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 221 77 202 74 199 86 208 83 211 89 220 84
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(Load rsVIEW 7001)
			(gCurRoom setScript: sTurnOnShower 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance doorView of Prop
	(properties)
)

(instance southExit of Trigger
	(properties
		approachX 95
		approachY 150
		exitDir 3
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 81 127 77 134 209 136 201 127
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 21) ; Do, Exit
			(gCurRoom setScript: sExitSouth 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sink of Feature
	(properties
		sightAngle 360
		approachX 268
		approachY 189
		approachDist 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 206 129 294 119 297 133 230 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(if (== (gEgo x:) 262)
				(gCurRoom newRoom: 18250)
			else
				(gCurRoom setScript: sUseSink 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sEnterFrom15200 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 613
						normalize: 613
						heading: 0
						x: 149
						y: 118
						init:
						setScaler: Scaler 68 51 126 109
						cel: 0
						setLoop: 0 1
					)
					(= cycles 2)
				)
				(1
					(gEgo setCycle: CT 9 1 self)
				)
				(2
					(if (IsFlag 264)
						(self dispose:)
					else
						(gEgo
							view: 0
							normalize: 0
							x: 95
							y: 127
							cel: 0
							setLoop: 0 1
							heading: 0
							setPri: 100
							setScaler: Scaler 149 84 135 102
						)
						(localproc_0 18100)
						(= cycles 2)
					)
				)
				(3
					(gEgo setCycle: End self)
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
		(if (IsFlag 264)
			(super dispose: &rest)
			(gCurRoom newRoom: 18200)
		else
			(localproc_0 18100)
			(gEgo
				view: 0
				normalize: 0
				x: 95
				y: 127
				setPri: -1
				setScaler: Scaler 149 84 135 102
			)
			(gGame handsOn:)
			(super dispose: &rest)
		)
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
						((== (gEgo x:) 130)
							(gEgo setPri: 200)
							(proc1111_13 register self)
						)
						((== (gEgo x:) 159)
							(proc1111_13 register self 1)
						)
						(else
							(proc1111_13 register self)
						)
					)
					(= register 0)
				)
				(1
					(gEgo
						view: 3
						normalize: 3
						x: 175
						y: 105
						cel: 0
						heading: 0
						setLoop: 0 1
						setScaler: Scaler 156 84 152 97
					)
					(localproc_0 18200)
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
		(if global115
			(proc1111_6)
			(= global115 0)
			(gEgo
				view: 3
				normalize: 3
				x: 175
				y: 105
				cel: (gEgo lastCel:)
				heading: 0
				setLoop: 0 1
				setScaler: Scaler 156 84 152 97
			)
		)
		(gCurRoom newRoom: 18250)
		(super dispose: &rest)
	)
)

(instance sEnterFrom18200 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if register
						(gEgo
							view: 7
							normalize: 7
							setLoop: 0 1
							cel: 0
							x: 130
							y: 138
							setScaler: Scaler 149 84 135 102
						)
					else
						(gEgo
							view: 3
							normalize: 3
							setLoop: 0 1
							cel: 0
							x: 117
							y: 129
							setScaler: Scaler 149 84 135 102
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
			(proc1111_6)
			(= global115 0)
		)
		(if register
			(gEgo
				view: 7
				normalize: 7
				setPri: 100
				setScaler: Scaler 149 84 135 102
			)
			(shower approachY: 70)
		else
			(gEgo
				view: 3
				normalize: 3
				setPri: 70
				setScaler: Scaler 149 84 135 102
			)
		)
		(southExit approachX: (gEgo x:))
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sExitToHallway of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((OneOf (gEgo x:) 95 120)
							(+= state 3)
							(gEgo setPri: 100)
							(proc1111_13 register self)
						)
						((== (gEgo x:) 159)
							(+= state 3)
							(proc1111_13 register self)
						)
						((== (gEgo x:) 262)
							(gEgo
								view: 6201
								cel: 0
								setLoop: 0 1
								setCycle: End self
							)
						)
						(else
							(+= state 3)
							(proc1111_13 register self)
						)
					)
				)
				(1
					(gEgo
						view: 6400
						setLoop: 0 1
						cel: 11
						x: 206
						y: 152
						setPri: -1
						setScaler: 0
						setScale: 0
					)
					(gCurRoom drawPic: 18290 picture: 18290)
					(= cycles 1)
				)
				(2
					(gEgo setCycle: End self)
				)
				(3
					(self dispose:)
				)
				(4
					(gEgo
						view: 612
						normalize: 612
						show:
						x: 149
						y: 126
						z: 0
						setScaler: Scaler 68 51 126 109
						setLoop: 0 1
						cel: 0
						show:
					)
					(gCurRoom drawPic: 15110 picture: 15110)
					(= cycles 2)
				)
				(5
					(gEgo setCycle: CT 8 1 self)
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
		(= global115 0)
		(= global125 0)
		(gCurRoom newRoom: 15200)
		(super dispose: &rest)
	)
)

(instance sTurnOnShower of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo x:) 262) (> (gEgo view:) 7))
							(gEgo
								view: 7302
								x: 146
								y: 133
								cel: 0
								setLoop: 0 1
								setScaler: Scaler 170 162 130 127
								setCycle: CT 17 1 self
							)
							(localproc_0 18290)
						)
						(
							(and
								register
								(== (gEgo heading:) 90)
								(== (gEgo x:) 159)
							)
							(-- state)
							(= cycles 2)
							(= register 0)
						)
						((and register (== (gEgo x:) 126))
							(-- state)
							(gEgo
								view: 7204
								cel: 0
								setLoop: 0 1
								setCycle: CT 16 1 self
							)
							(= register 0)
						)
						((and register (== (gEgo x:) 159))
							(-- state)
							(proc1111_13 register self 1)
							(= register 0)
						)
						(register
							(-- state)
							(gEgo setPri: -1)
							(proc1111_13 register self)
							(= register 0)
						)
						(else
							(= cycles 1)
						)
					)
				)
				(1
					(= register (gEgo cycleSpeed:))
					(gEgo
						view: 1490
						setScaler: 0
						setScale: 0
						setLoop: 0 1
						cel: 0
						x: 116
						y: 130
						setPri: -1
						cycleSpeed: 8
					)
					(localproc_0 18200)
					(= cycles 2)
				)
				(2
					(gEgo setCycle: CT 9 1 self)
				)
				(3
					(proc1111_1 18011 1)
					(gEgo cycleSpeed: 8 setCycle: End self)
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
		(gGDacSound stop:)
		(gEgo
			view: 0
			normalize: 0
			heading: 90
			x: 159
			y: 127
			setScaler: Scaler 149 84 135 102
			cycleSpeed: register
		)
		(localproc_0 18100)
		(southExit approachX: 150)
		(sink approachX: (gEgo x:))
		(= global125 0)
		(gGame handsOn:)
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
					(if (OneOf (gEgo x:) 120 95 117)
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
		(gCurRoom newRoom: 18200)
		(super dispose: &rest)
	)
)

(instance sUseToilet of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo view:) 1) (== (gEgo x:) 95))
							(= cycles 2)
						)
						((not (OneOf (gEgo x:) 95 130))
							(proc1111_13 hallDoor self)
						)
						(else
							(proc1111_13 hallDoor self 1)
						)
					)
				)
				(1
					(= global181 gChapter)
					(gCurRoom drawPic: 15110 picture: 15110)
					(doorView
						view: 15110
						setLoop: 1 1
						x: 155
						y: 113
						cel: 8
						init:
					)
					(gEgo z: 1000)
					(= cycles 2)
				)
				(2
					(doorView setCycle: CT 16 1 self)
				)
				(3
					(proc1111_1 18025 1)
					(doorView cel: 17)
					(= ticks 10)
				)
				(4
					(doorView cel: 18)
					(= seconds 8)
				)
				(5
					(if (> local5 3)
						(-- state)
						(= local5 0)
						(self setScript: sToiletFx self)
					else
						(= local4 5)
						(proc1111_1 18026 1 self)
					)
				)
				(6
					(= seconds 4)
				)
				(7
					(proc1111_1 18027 1 self)
				)
				(8
					(= seconds 4)
				)
				(9
					(proc1111_1 3011 1)
					(doorView setCycle: CT 8 -1 self)
				)
				(10
					(self dispose:)
				)
			)
		else
			(if script
				(script dispose:)
			)
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(gGDacSound stop:)
		(doorView dispose:)
		(gEgo
			view: 1
			normalize: 1
			x: 120
			y: 130
			z: 0
			setLoop: 0 1
			heading: 270
			setPri: -1
			setScaler: Scaler 149 84 135 102
			cel: (gEgo lastCel:)
		)
		(hallDoor approachX: 107 approachY: 130)
		(shower approachX: 197 approachY: 139)
		(localproc_0 18100)
		(southExit approachX: (gEgo x:))
		(toilet dispose:)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sToiletFx of Script
	(properties)

	(method (dispose)
		(proc1111_1 0)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 5)
				(switch (Random 1 4)
					(1
						(= state 9)
					)
					(2
						(= state 19)
					)
					(3
						(= state 29)
					)
					(4
						(= state 39)
					)
				)
				(= cycles 2)
			)
			(10
				(if (-- local4)
					(-- state)
				)
				(switch local4
					(4
						(proc1111_1 18037 1 self)
					)
					(3
						(proc1111_1 24031 1 self)
					)
					(2
						(proc1111_1 18030 1 self)
					)
					(1
						(proc1111_1 18047 1 self)
					)
					(else
						(self dispose:)
					)
				)
			)
			(20
				(proc1111_1 18032 1 self)
			)
			(21
				(= ticks 60)
			)
			(22
				(proc1111_1 18033 1 self)
			)
			(23
				(switch (Random 1 3)
					(1
						(proc1111_1 18029 1 self)
					)
					(2
						(proc1111_1 18030 1 self)
					)
					(3
						(proc1111_1 18031 1 self)
					)
				)
			)
			(24
				(proc1111_1 18047 1 self)
			)
			(25
				(self dispose:)
			)
			(30
				(proc1111_1 18036 1 self)
			)
			(31
				(switch (Random 1 2)
					(1
						(proc1111_1 18033 1 self)
					)
					(2
						(proc1111_1 18032 1 self)
					)
				)
			)
			(32
				(proc1111_1 18037 1 self)
			)
			(33
				(proc1111_1 18045 1 self)
			)
			(34
				(= ticks 60)
			)
			(35
				(proc1111_1 18038 1 self)
			)
			(36
				(self dispose:)
			)
			(40
				(proc1111_1 18039 -1)
				(= seconds (Random 6 10))
			)
			(41
				(proc1111_1 0)
				(= ticks 30)
			)
			(42
				(proc1111_1 18041 1 self)
			)
			(43
				(= ticks 30)
			)
			(44
				(proc1111_1 18041 1 self)
			)
			(45
				(= ticks 30)
			)
			(46
				(proc1111_1 18047 1 self)
			)
			(47
				(self dispose:)
			)
		)
	)
)

(instance chair of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 152 100 152 85 157 83 157 72 163 68 170 73 167 82 169 86 167 101
					yourself:
				)
		)
		(super init: &rest)
	)
)

