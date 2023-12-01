;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13100)
(include sci.sh)
(use Main)
(use movieScr)
(use Trigger)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm13100 0
)

(local
	local0
)

(procedure (localproc_0 param1)
	(if
		(and
			(not (IsFlag 53))
			(> global172 2)
			(== gChapter 1)
			(not (IsFlag 83))
		)
		(SetFlag 53)
	)
	(if (and (== gChapter 1) (!= param1 4200) (IsFlag 82) (not (IsFlag 181)))
		(SetFlag 181)
	)
)

(instance rm13100 of ScaryRoom
	(properties
		picture 13100
		stepSound 4
	)

	(method (init &tmp temp0)
		(if (== gPrevRoomNum 111)
			(= gPrevRoomNum 12100)
			(= gChapter 6)
			(SetFlag 43)
			(ClearFlag 223)
		)
		(= temp0 0)
		(KillRobot)
		(switch gPrevRoomNum
			(900
				(gEgo init: normalize: setScaler: Scaler 181 50 165 87)
				(gGame handsOn:)
			)
			(4200
				(= picture 13200)
				(= temp0 sFromReception)
			)
			(10100
				(= temp0 sFromCarno)
			)
			(10200
				(= temp0 sFromCarno)
			)
			(12100
				(if (and (== gChapter 6) (IsFlag 43) (not (IsFlag 223)))
					(SetFlag 223)
					(= picture 13410)
					(= temp0 sHearMarie)
				else
					(= temp0 sFromMarie)
				)
			)
			(13400
				(= temp0 sEnterFromHallway)
			)
			(13200
				(if (== global125 33)
					(= picture 13110)
					(= temp0 sLookOverRailing)
				else
					(gEgo
						view: 2
						normalize: 2
						heading: 180
						x: 157
						y: 105
						setScaler: Scaler 181 50 165 87
						init:
					)
				)
			)
			(else
				(gEgo
					view: 3
					normalize: 3
					heading: 0
					x: 164
					y: 128
					setScaler: Scaler 181 50 165 87
					init:
				)
				(southExit approachY: 189)
			)
		)
		(if (not (OneOf gChapter 1 7))
			(darkDoorView
				view: 13100
				setLoop: 0 1
				cel: 0
				x: 139
				y: 56
				setPri: 4
				init:
				approachVerbs: 0
			)
		)
		(super init:)
		(carnoDoor init:)
		(marieDoor init:)
		(if (< gChapter 6)
			(banister init: approachVerbs: 0 setHotspot: 4 3 21) ; Do, Move, Exit
		)
		(southExit init:)
		(northExit init:)
		(if temp0
			(self setScript: temp0 0 0)
		else
			(gGame handsOn:)
		)
		((ScriptID 30) init:) ; FidgetCode
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(== gChapter 4)
				(OneOf newRoomNumber 10200 12100)
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
				(OneOf newRoomNumber 10200 12100)
				(IsFlag 5)
				(not (IsFlag 325))
			)
			(SetFlag 325)
			(ClearFlag 264)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance banister of Feature
	(properties
		sightAngle 360
		approachX 55
		approachY 124
		approachDist 10
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 15 73 40 76 42 81 34 82 36 86 94 84 107 84 107 82 125 78 142 82 141 85 139 85 139 95 134 95 134 104 128 105 132 129 107 129 115 104 113 103 112 97 109 97 110 116 107 129 100 129 105 124 106 117 106 97 102 94 94 93 93 120 98 123 93 128 93 129 90 129 85 125 85 122 89 118 89 95 84 91 75 92 73 98 72 121 77 125 76 127 73 128 64 130 64 125 67 120 68 98 65 95 60 95 55 101 58 129 51 129 51 101 46 97 36 97 36 115 28 119 30 129 25 129 25 106 19 108 16 123 19 129 -1 129 1 77
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sLookOverRailing 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of Trigger
	(properties
		approachX 178
		approachY 131
		approachDist 10
		exitDir 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 131 124 131 134 233 134 223 124
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(gCurRoom setScript: sWalkDownStairs 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance northExit of Trigger
	(properties
		approachX 147
		approachY 70
		approachDist 10
		exitDir 1
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 131 41 131 80 150 82 169 76 171 42
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(gCurRoom setScript: sExitNorth 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance carnoDoor of Trigger
	(properties
		approachX 82
		approachY 94
		approachDist 10
		exitDir 13
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 66 42 68 38 80 38 86 29 93 40 102 41 103 48 101 54 102 82 66 84
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(gCurRoom setScript: sEnterCarnosRoom 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance marieDoor of Trigger
	(properties
		approachX 214
		approachY 107
		approachDist 10
		exitDir 2
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 205 45 215 23 223 31 229 29 228 35 231 36 229 90 210 89 210 99 205 98
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 21) ; Do, Exit
			(gCurRoom setScript: sEnterMariesRoom 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sEnterCarnosRoom of Script
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
			(KillRobot)
			(= global115 0)
		)
		(localproc_0 10200)
		(gCurRoom newRoom: 10200)
		(super dispose: &rest)
	)
)

(instance sExitNorth of Script
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
			(KillRobot)
			(= global115 0)
		)
		(gCurRoom newRoom: 13400)
		(super dispose: &rest)
	)
)

(instance sFromCarno of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 4
						normalize: 4
						heading: 135
						cel: 6
						x: 96
						y: 103
						setScaler: Scaler 181 50 165 87
						setLoop: 0 1
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
			(gEgo
				view: 4
				normalize: 4
				heading: 135
				x: 96
				y: 103
				setScaler: Scaler 181 50 165 87
				setLoop: 0 1
			)
		)
		(carnoDoor approachX: 85 approachY: 85)
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
					(gEgo
						view: 2
						normalize: 2
						heading: 180
						cel: 0
						x: 154
						y: 87
						setScaler: Scaler 181 50 165 87
						setLoop: 0 1
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
			(gEgo
				view: 2
				normalize: 2
				heading: 180
				x: 154
				y: 87
				setScaler: Scaler 181 50 165 87
				init:
			)
		)
		(marieDoor approachX: 154 approachY: 105)
		(carnoDoor approachX: 95 approachY: 105)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sFromMarie of Script
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
						cel: 7
						x: 200
						y: 105
						setScaler: Scaler 181 50 165 87
						setLoop: 0 1
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
			(gEgo
				view: 5
				normalize: 5
				heading: 225
				x: 200
				y: 105
				setScaler: Scaler 181 50 165 87
			)
		)
		(marieDoor approachX: 210 approachY: 95)
		(southExit approachX: 200)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sFromReception of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 671
						cel: 15
						x: 199
						y: 81
						setScaler: 0
						setScale: 0
						setLoop: 0 1
						init:
					)
					(if (gCast contains: darkDoorView)
						(darkDoorView dispose:)
						(= local0 1)
					)
					(= cycles 2)
				)
				(1
					(gEgo setCycle: CT 40 1 self)
				)
				(2
					(gEgo
						view: 3
						cel: 6
						setScaler: Scaler 181 50 165 87
						x: 164
						y: 128
					)
					(gCurRoom drawPic: 13100 picture: 13100)
					(if local0
						(darkDoorView init:)
					)
					(= cycles 2)
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
			(KillRobot)
			(= global115 0)
			(gEgo
				view: 3
				normalize: 3
				heading: 0
				x: 164
				y: 128
				setScaler: Scaler 181 50 165 87
			)
			(if local0
				(darkDoorView init:)
			)
		)
		(if (!= (gCurRoom picture:) 13100)
			(gCurRoom drawPic: 13100 picture: 13100)
		)
		(southExit approachY: 189)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance darkDoorFeat of Feature
	(properties
		sightAngle 360
		approachX 147
		approachY 70
		approachDist 10
		y 2
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 139 55 149 55 149 75 138 76
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Move
			(gCurRoom setScript: sEnterDarkroom 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance darkDoorView of View
	(properties)

	(method (doVerb theVerb)
		(darkDoorFeat doVerb: theVerb)
	)
)

(instance sEnterDarkroom of Script
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
			(KillRobot)
			(= global115 0)
		)
		(if (and (== gChapter 4) (not (IsFlag 222)))
			(= global125 0)
		else
			(= global125 9)
		)
		(gCurRoom newRoom: 13400)
		(super dispose: &rest)
	)
)

(instance sWalkDownStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_13 register self)
				)
				(1
					(if (== (gEgo x:) 164)
						(gEgo
							view: 670
							x: 161
							y: 81
							setLoop: 0 1
							cel: 15
							setScale: 0
							setScaler: 0
							setCycle: CT 30 1 self
						)
					else
						(gEgo
							view: 670
							x: 161
							y: 81
							setLoop: 0 1
							cel: 19
							setScale: 0
							setScaler: 0
							setCycle: CT 30 1 self
						)
					)
					(gCurRoom drawPic: 13200 picture: 13200)
					(if
						(and
							(== gChapter 2)
							(not (IsFlag 55))
							(not global184)
						)
						(global114 pause:)
					)
					(if (gCast contains: darkDoorView)
						(darkDoorView dispose:)
					)
				)
				(2
					(gEgo y: 82 setCycle: CT 32 1 self)
				)
				(3
					(gEgo y: 83 setCycle: CT 34 1 self)
				)
				(4
					(gEgo y: 84 setCycle: CT 36 1 self)
				)
				(5
					(gEgo y: 85 setCycle: End self)
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
		(localproc_0 4200)
		(gCurRoom newRoom: 4200)
		(super dispose: &rest)
	)
)

(instance sEnterMariesRoom of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_13 register self)
				)
				(1
					(if (== (gEgo x:) 154)
						(gEgo
							view: 3
							setScaler: Scaler 92 56 105 85
							x: 154
							y: 91
							setPri: 80
							cel: 0
						)
						(gCurRoom drawPic: 13200 picture: 13200)
						(if (gCast contains: darkDoorView)
							(darkDoorView dispose:)
						)
						(= cycles 2)
					else
						(self dispose:)
					)
				)
				(2
					(gEgo setCycle: End self)
				)
				(3
					(gEgo view: 7301 cel: 10 setCycle: End self)
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
			(KillRobot)
			(= global115 0)
		)
		(localproc_0 12100)
		(SetFlag 36)
		(gCurRoom newRoom: 12100)
		(super dispose: &rest)
	)
)

(instance sLookOverRailing of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (!= (gEgo x:) 49)
						(proc1111_13 register self)
					else
						(= cycles 2)
					)
				)
				(1
					(if (gCast contains: darkDoorView)
						(darkDoorView dispose:)
						(= local0 1)
					)
					(gEgo
						view: 710
						setLoop: 0 1
						x: 76
						y: 104
						setScale: 0
						setScaler: 0
						cel: 0
					)
					(if (!= (gCurRoom picture:) 13110)
						(gCurRoom drawPic: 13110 picture: 13110)
					)
					(if (not (gCast contains: gEgo))
						(gEgo init:)
					)
					(= cycles 2)
				)
				(2
					(gEgo setCycle: End self)
				)
				(3
					(cond
						((>= gChapter 6)
							(= seconds 4)
						)
						((< gVideoSpeed 425)
							(PlayVMD 0 {3005.vmd} 0) ; Open
							(proc26_0 3005 self)
						)
						(else
							(PlayVMD 0 {300.vmd} 0) ; Open
							(proc26_0 300 self)
						)
					)
				)
				(4
					(gEgo view: 711 cel: 0 setCycle: End self)
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
		(if local0
			(darkDoorView init:)
		)
		(= global125 0)
		(gEgo
			view: 5
			normalize: 5
			heading: 225
			x: 49
			y: 127
			setScaler: Scaler 181 50 165 87
		)
		(gCurRoom drawPic: 13100 picture: 13100)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sHearMarie of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gCast contains: darkDoorView)
						(darkDoorView dispose:)
						(= local0 1)
					)
					(gEgo z: 1000 init:)
					(DoRobot 5500 -7 -34)
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
		(if (not (gCast contains: gEgo))
			(gEgo init:)
		)
		(gEgo
			view: 5
			normalize: 5
			heading: 225
			z: 0
			x: 49
			y: 127
			setScaler: Scaler 181 50 165 87
		)
		(gCurRoom drawPic: 13100 picture: 13100)
		(if local0
			(darkDoorView init:)
		)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

