;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1100)
(include sci.sh)
(use Main)
(use movieScr)
(use scaryInvInit)
(use Trigger)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm1100 0
)

(local
	[local0 2]
	local2
	local3 = -1
)

(procedure (localproc_0)
	(if (and (!= global125 26) (== (gCurRoom picture:) 1100))
		(pantryDoorView init:)
		(pantryDoorFeat dispose:)
		(if (not (gEgo script:))
			(gEgo setScaler: Scaler 118 61 127 83)
		)
	else
		(pantryDoorFeat init:)
		(pantryDoorView dispose:)
		(gEgo setScaler: Scaler 143 78 130 94)
	)
	(donsCup init:)
	(southExitL init:)
	(southExitR init:)
	(if (and (< gChapter 6) (not (IsFlag 2)))
		(drawer init:)
	)
	(if (!= (gEgo script:) sAtTableFidgeting)
		(adrChair init:)
		(theFloor dispose:)
	else
		(theFloor init:)
		(southExitL dispose:)
		(southExitR dispose:)
	)
	(if (and (== (gCurRoom picture:) 1100) (== gChapter 1))
		(aCup init:)
	)
)

(procedure (localproc_1 param1)
	(if (== gChapter 1)
		(gEgo
			view: 91
			x: 123
			y: 91
			setLoop: 0 1
			cel: 0
			setScale: 0
			setScaler: 0
			setPri: 100
		)
		(tableLegs init:)
		(donsCup z: 0)
	else
		(gEgo
			view: 90
			x: 137
			y: 91
			setLoop: 0 1
			cel: 0
			setScale: 0
			setScaler: 0
			setPri: 96
		)
		(donsCup z: 0 init:)
	)
	(if argc
		(gEgo setCycle: End param1)
	else
		(gEgo cel: (gEgo lastCel:))
	)
	(if (!= (gCurRoom picture:) 1100)
		(gCurRoom drawPic: 1100 picture: 1100)
	)
	(if (not (gCast contains: gEgo))
		(gEgo init:)
	)
	(aCup dispose:)
)

(procedure (localproc_2 param1)
	(if (== gChapter 1)
		(gEgo
			view: 101
			x: 143
			y: 92
			setLoop: 0 1
			setCel: 0
			setPri: 96
			setScript: 0
		)
	else
		(gEgo
			view: 100
			x: 138
			y: 91
			setLoop: 0
			setCel: 0
			setPri: 96
			setScript: 0
		)
	)
	(if argc
		(gEgo setCycle: End param1)
	else
		(gEgo cel: (gEgo lastCel:))
	)
)

(instance rm1100 of ScaryRoom
	(properties
		picture 1100
		south 1200
		west 1700
		stepSound 4
	)

	(method (init &tmp temp0)
		(= temp0 0)
		(proc1111_6)
		(gEgo z: 0)
		(switch gPrevRoomNum
			(900
				(proc28_2)
				(cond
					((IsFlag 226)
						(ClearFlag 226)
						(= picture -1)
						(= temp0 sOpening)
					)
					(
						(OneOf
							(gEgo view:)
							90
							112
							113
							115
							116
							91
							117
							118
							119
							120
						)
						(if (== gChapter 1)
							(gEgo
								view: 91
								x: 123
								y: 91
								setPri: 100
								init:
								setScale: 0
								setScaler: 0
								cel: (gEgo lastCel:)
							)
						else
							(gEgo
								view: 90
								x: 137
								y: 91
								init:
								setScale: 0
								setScaler: 0
								setPri: -1
							)
						)
						(= temp0 sAtTableFidgeting)
					)
					(else
						(= picture 1105)
						(gEgo
							init:
							setScaler: Scaler 143 78 130 94
							normalize:
						)
						(if (and (not (gEgo x:)) (not (gEgo y:)))
							(= global204 1)
							(switchto1105 doit:)
						)
						(gGame handsOn:)
					)
				)
			)
			(1200
				(switch global125
					(28
						(gEgo
							view: 2
							setScaler: Scaler 118 61 127 83
							normalize: 2
							init:
						)
					)
					(27
						(gEgo
							init:
							posn: 126 89
							setScaler: Scaler 118 61 127 83
							normalize: 2
						)
						(= picture 1710)
						(= temp0 sDoReading)
					)
					(3
						(= global204 1)
						(if (== gChapter 1)
							(gEgo
								view: 91
								setScale: 0
								x: 123
								y: 91
								setPri: 100
								setCel: 0
								init:
							)
						else
							(gEgo
								view: 90
								setScale: 0
								x: 137
								y: 91
								setPri: 96
								setCel: 0
								init:
							)
						)
						(= temp0 sSitDown)
					)
					(26
						(gEgo
							normalize: 3
							setScaler: Scaler 118 61 127 83
							posn: 85 116
							scaleSignal: 1
							init:
						)
						(= temp0 sExitToPantry)
					)
					(else
						(= picture 1105)
						(= temp0 sEnterFrom1200)
					)
				)
			)
			(1700
				(gEgo
					view: 70
					x: 93
					y: 85
					loop: 0
					setCel: 18
					init:
					setScale: 0
					setScaler: 0
				)
				(ClearFlag 4)
				(gGame setIntensity: 100)
				(pantryDoorView z: 1000)
				(= temp0 sEnterFromPantry)
			)
			(20200
				(gThePlane drawPic: -1 13)
				(= picture -1)
				(ClearFlag 4)
				(gEgo
					view: 2
					normalize: 2
					heading: 180
					x: 55
					y: 119
					z: 1000
					setScaler: Scaler 118 61 127 83
					init:
				)
				(= global204 3)
				(= temp0 sFromBasement)
			)
			(else
				(= picture 1105)
				(= global204 1)
				(gEgo
					view: 4
					normalize: 4
					x: 90
					y: 106
					setScaler: Scaler 143 78 130 94
					init:
				)
				(gGame handsOn:)
			)
		)
		(localproc_0)
		(if (== temp0 sAtTableFidgeting)
			(if (== gChapter 1)
				(gEgo setPri: 100)
			)
			(theFloor init:)
			(pantryDoorView setHotspot: 0)
			(southExitL dispose:)
			(southExitR dispose:)
			(adrChair dispose:)
			(pantryDoorFeat dispose:)
			(drawer dispose:)
			(= global204 1)
			((ScriptID 0 14) init:) ; exitButt
		)
		(super init: &rest)
		(if temp0
			(self setScript: temp0)
		else
			(gGame handsOn:)
		)
		(if (!= gPrevRoomNum 900)
			(switch gChapter
				(1
					(global114 play: 911)
				)
				(2
					(global114 play: 911)
				)
				(3
					(global114 play: 912)
				)
				(4
					(global114 play: 9120)
				)
				(5
					(global114 play: 913)
				)
				(6
					(global114 play: 914)
				)
				(7
					(global114 play: 9140)
				)
			)
		)
		((ScriptID 30) init:) ; FidgetCode
	)

	(method (notify)
		(gGame handsOff:)
		(= local2 1)
		(if (not ((gCurRoom script:) state:))
			((gCurRoom script:) cue:)
		)
	)

	(method (dispose)
		(if (global116 contains: (ScriptID 0 14)) ; exitButt
			((ScriptID 0 14) dispose:) ; exitButt
		)
		(super dispose:)
	)
)

(instance theFloor of Feature
	(properties
		sightAngle 360
	)

	(method (init)
		(self
			approachVerbs: 0
			setHotspot: 4 3 ; Do, Move
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 40 129 254 129 255 126 242 120 245 114 235 108 226 105 226 87 184 82 178 94 152 98 130 97 125 91 125 80 106 81 85 87 64 94 64 99 57 113 51 113
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(= local2 1)
				(if (not ((gCurRoom script:) state:))
					((gCurRoom script:) cue:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pantryDoorFeat of Trigger
	(properties
		exitDir 13
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 20 23 62 34 63 102 19 114
					yourself:
				)
		)
		(if (== global204 3)
			(= approachX 32)
			(= approachY 102)
		else
			(= approachX 42)
			(= approachY 115)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(gCurRoom setScript: sExitToPantry 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pantryDoorView of View
	(properties
		sightAngle 360
		approachX 93
		approachY 83
		x 82
		y 86
		view 1104
	)

	(method (init)
		(if (not (gEgo script:))
			(self approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		else
			(self approachVerbs: 0 setHotspot: 0)
		)
		(super init: &rest)
	)
)

(instance drawer of Feature
	(properties
		sightAngle 360
	)

	(method (init)
		(if (== (gCurRoom picture:) 1105)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 238 77 238 108 250 116 277 117 276 81 262 78
						yourself:
					)
			)
			(= approachX 245)
			(= approachY 112)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 231 74 225 80 225 105 235 107 235 105 246 104 249 75
						yourself:
					)
			)
			(= approachX 222)
			(= approachY 102)
		)
		(if (not (gEgo script:))
			(self approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		else
			(self approachVerbs: 0 setHotspot: 0)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sToDrawer 0 self)
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
	)

	(method (init)
		(cond
			((== (gCurRoom picture:) 1105)
				(= approachX 125)
				(= approachY 102)
				(self
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 106 59 117 61 125 61 124 74 135 88 129 107 111 107 107 84
							yourself:
						)
				)
			)
			((== (gCurRoom picture:) 1100)
				(= approachX 144)
				(= approachY 87)
				(self
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 138 55 143 57 149 54 149 63 147 65 151 71 138 71 140 62
							yourself:
						)
				)
			)
		)
		(self approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gEgo script:) sAtTableFidgeting)
					(gCurRoom setScript: sGetUp 0 0)
				else
					(gCurRoom setScript: sSitDown 0 self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExitL of Trigger
	(properties
		approachX 72
		approachY 189
		exitDir 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 124 15 119 147 122 147 129 0 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(= global125 67)
			(gCurRoom setScript: sExitSouth 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExitR of Trigger
	(properties
		approachX 230
		approachY 189
		exitDir 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 146 123 277 117 293 125 293 129 147 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(= global125 66)
			(gCurRoom setScript: sExitSouth 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance donsCup of View
	(properties
		x 163
		y 74
		priority 100
		fixPriority 1
		view 1100
	)

	(method (init)
		(cond
			((!= gChapter 1)
				(self dispose:)
				(return 0)
			)
			((== (gCurRoom picture:) 1100)
				(= view 1100)
				(= x 163)
				(= y 74)
				(= priority 100)
				(= fixPriority 1)
				(super init: &rest)
			)
			(else
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

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== register southExitR) (== global204 1))
							(proc1111_13 register self 1)
						)
						(
							(and
								(OneOf register drawer adrChair)
								(== global204 1)
							)
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
		(= global115 0)
		(cond
			((and (OneOf global204 1 3) (== global125 66))
				(SetFlag 106)
				(= global204 5)
			)
			((and (== global125 67) (== global204 2))
				(SetFlag 106)
				(= global204 1)
			)
			((== global125 66)
				(= global204 2)
			)
		)
		(gCurRoom newRoom: 1200)
		(super dispose: &rest)
	)
)

(instance sEnterFrom1200 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(donsCup init:)
					(switch global204
						(3
							(if (IsFlag 106)
								(gEgo
									view: 7
									normalize: 7
									x: 55
									y: 119
									cel: 0
									heading: 315
									setLoop: 0 1
								)
							else
								(gEgo
									view: 3
									normalize: 3
									x: 55
									y: 119
									cel: 0
									heading: 0
									setLoop: 0 1
								)
								(= global204 3)
							)
							(adrChair approachY: 80)
							(= register 1)
						)
						(2
							(cond
								((IsFlag 106)
									(gEgo
										view: 6
										normalize: 6
										x: 216
										y: 113
										cel: 0
										heading: 45
										setLoop: 0 1
									)
									(= register 1)
								)
								((== global125 4)
									(gEgo
										view: 0
										heading: 90
										normalize: 0
										x: 216
										y: 113
									)
								)
								(else
									(gEgo
										view: 3
										normalize: 3
										x: 216
										y: 113
										cel: 0
										heading: 0
										setLoop: 0 1
									)
									(= register 1)
								)
							)
						)
						(1
							(if (IsFlag 106)
								(gEgo
									view: 7
									normalize: 7
									x: 90
									y: 106
									cel: 0
									heading: 315
									setLoop: 0 1
								)
							else
								(gEgo
									view: 3
									normalize: 3
									x: 90
									y: 106
									cel: 0
									setLoop: 0 1
									heading: 0
								)
							)
							(= register 1)
						)
						(else
							(gEgo
								view: 3
								normalize: 3
								x: 55
								y: 119
								cel: 0
								heading: 0
								setLoop: 0 1
							)
							(adrChair approachY: 80)
							(= global204 3)
							(= register 1)
						)
					)
					(gEgo init: setScaler: Scaler 143 78 130 94)
					(if (not register)
						(++ state)
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
		(ClearFlag 106)
		(= global125 0)
		(= global115 0)
		(localproc_0)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sFromBasement of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 2)
				)
				(1
					(gEgo z: 0)
					(UpdateScreenItem gEgo)
					(switchto1105 doit:)
					(gGame fade: 0 100 1)
					(= cycles 150)
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
			(gEgo z: 0)
			(switchto1105 doit:)
			(= global115 0)
			(gGame fade: 0 100 1)
		)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sEnterFromPantry of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_2 1011)
					(gEgo cel: 18 setScaler: 0 setScale: 0 setLoop: 0 1)
					(if (== gChapter 1)
						(donsCup init:)
					)
					(= cycles 2)
				)
				(1
					(gEgo setCycle: CT 40 1 self)
				)
				(2
					(proc1111_1 1011 1)
					(gEgo cel: 41)
					(= ticks 20)
				)
				(3
					(gEgo cel: 42)
					(= ticks 20)
				)
				(4
					(gEgo setCycle: End self)
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
		(proc1111_1 0)
		(= global204 3)
		(= global115 0)
		(pantryDoorView z: 0)
		(gEgo setCycle: 0 view: 2 normalize: 2)
		(switchto1105 doit:)
		(localproc_0)
		(gGame handsOn:)
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
					(proc1111_2 1010)
					(switch global204
						(2
							(proc1111_13 register self 1 22)
						)
						(3
							(proc1111_13 register self 1)
						)
						(1
							(proc1111_13 register self 1)
						)
						(else
							(proc1111_13 register self)
						)
					)
				)
				(1
					(gEgo
						view: 40
						setScale: 0
						setScaler: 0
						x: 83
						y: 93
						setLoop: 0 1
					)
					(if (not register)
						(gEgo cel: 0)
					else
						(gEgo cel: 19)
					)
					(if (!= (gCurRoom picture:) 1100)
						(gCurRoom drawPic: 1100 picture: 1100)
					)
					(if (== gChapter 1)
						(aCup init:)
						(donsCup init:)
					)
					(= cycles 4)
				)
				(2
					(gEgo setCycle: CT 20 1 self)
				)
				(3
					(proc1111_1 1010 1)
					(gEgo setCycle: CT 28 1 self)
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
			(gEgo
				view: 40
				setScale: 0
				setScaler: 0
				x: 83
				y: 93
				setLoop: 0 1
				cel: 28
			)
		)
		(proc1111_1 0)
		(= global204 3)
		(gCurRoom newRoom: 1700)
	)
)

(instance sToDrawer of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo heading:) 90) (== global204 2))
							(proc1111_13 register self 2)
						)
						((OneOf global204 1 2)
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
		(= global204 2)
		(= global125 4)
		(= global115 0)
		(gCurRoom newRoom: 1200)
		(super dispose: &rest)
	)
)

(instance sAtTableFidgeting of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (not register)
						((ScriptID 0 14) init:) ; exitButt
						(gGame handsOn:)
						(gUser canControl: 0)
						(adrChair setHotspot: 0)
						(aCup dispose:)
						(donsCup init:)
						(= register 1)
					)
					(if (gFeatures contains: southExitL)
						(theFloor init:)
						(southExitL dispose:)
						(southExitR dispose:)
					)
					(if (== local3 -1)
						(= local3 (gEgo cycleSpeed:))
					)
					(gEgo setScale: 0 setScaler: 0 cycleSpeed: 8)
					(if (!= gChapter 1)
						(switch (Random 1 4)
							(1
								(gEgo
									view: 112
									setLoop: 0 1
									setCel: 0
									setCycle: End self
								)
							)
							(2
								(gEgo
									view: 113
									loop: 0
									setCel: 0
									setCycle: End self
								)
							)
							(3
								(gEgo
									view: 115
									loop: 0
									setCel: 0
									setCycle: End self
								)
							)
							(4
								(gEgo
									view: 116
									loop: 0
									setCel: 0
									setCycle: End self
								)
							)
						)
					else
						(switch (Random 1 4)
							(1
								(gEgo
									view: 117
									setLoop: 0 1
									setCel: 0
									x: 144
									y: 92
									setPri: 100
									setCycle: End self
								)
							)
							(2
								(gEgo
									view: 118
									setLoop: 0 1
									setCel: 0
									x: 143
									y: 92
									setPri: 100
									setCycle: End self
								)
							)
							(3
								(gEgo
									view: 119
									setLoop: 0 1
									setCel: 0
									x: 143
									y: 93
									setPri: 100
									setCycle: End self
								)
							)
							(4
								(gEgo
									view: 120
									setLoop: 0 1
									setCel: 0
									x: 143
									y: 92
									setPri: 100
									setCycle: End self
								)
							)
						)
					)
				)
				(1
					(if (not local2)
						(= ticks (Random 90 240))
					else
						(self dispose:)
					)
				)
				(2
					(if (not local2)
						(self init:)
					else
						(self dispose:)
					)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(= global115 0)
		(gEgo cycleSpeed: local3)
		(= local3 -1)
		(if local2
			(= next sGetUp)
		)
		(= register 0)
		(super dispose: &rest)
	)
)

(instance sSitDown of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= local2 0)
					(cond
						((== global204 2)
							(proc1111_13 register self 1 22)
						)
						((== global204 1)
							(proc1111_13 register self 1)
						)
						(else
							(proc1111_13 register self)
						)
					)
				)
				(1
					(localproc_1 self)
					(if (== gChapter 1)
						(donsCup init:)
					)
					(pantryDoorView init:)
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
			(localproc_1)
		)
		(pantryDoorView init: setHotspot: 0)
		(= global115 0)
		(theFloor init:)
		(southExitL dispose:)
		(southExitR dispose:)
		(adrChair dispose:)
		(pantryDoorFeat dispose:)
		(drawer dispose:)
		(= next sAtTableFidgeting)
		(super dispose: &rest)
	)
)

(instance sGetUp of Script
	(properties)

	(method (changeState newState)
		(if global115
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					((ScriptID 0 14) dispose:) ; exitButt
					(localproc_2 self)
				)
				(1
					(self dispose:)
				)
			)
		)
	)

	(method (dispose)
		(if global115
			(localproc_2)
		)
		(tableLegs dispose:)
		(= global115 0)
		(= global204 1)
		(adrChair init:)
		(= local2 0)
		(switchto1105 doit:)
		(localproc_0)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance tableLegs of View
	(properties
		x 124
		y 96
		priority 222
		fixPriority 1
		view 1101
	)
)

(instance sOpening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 121)
				(SetFlag 248)
				(gGame handsOff:)
				(donsCup z: 1000)
				(PlayVMD 0 {30.vmd} 0) ; Open
				(proc26_0 30 self)
			)
			(1
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(ClearFlag 121)
		(ClearFlag 248)
		(global114 play: 911)
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(localproc_1)
		(localproc_0)
		(pantryDoorView init: setHotspot: 0)
		(= global115 0)
		(theFloor init:)
		(southExitL dispose:)
		(southExitR dispose:)
		(adrChair dispose:)
		(pantryDoorFeat dispose:)
		(drawer dispose:)
		(= global204 1)
		((ScriptID 0 14) init:) ; exitButt
		(= next sAtTableFidgeting)
		(gGame save:)
		(super dispose: &rest)
	)
)

(instance switchto1105 of Code
	(properties)

	(method (doit)
		(if (not (gCast contains: gEgo))
			(gEgo init:)
		)
		(gEgo show: setScaler: Scaler 143 78 130 94)
		(switch global204
			(1
				(gEgo view: 4 normalize: 4 heading: 135 x: 90 y: 106)
			)
			(3
				(gEgo view: 2 normalize: 2 heading: 180 x: 55 y: 119)
				(adrChair approachY: 80)
			)
			(2
				(gEgo view: 5 normalize: 5 heading: 225 x: 216 y: 113)
			)
		)
		(if (!= (gCurRoom picture:) 1105)
			(gCurRoom drawPic: 1105 picture: 1105)
		)
		(aCup dispose:)
	)
)

(instance aCup of View
	(properties
		x 140
		y 72
		priority 100
		fixPriority 1
		view 1100
	)
)

(instance sDoReading of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(donsCup hide:)
					(proc1111_7 4230 -5 -33)
				)
				(1
					(proc1111_7 4231 -7 -7)
					(gCurRoom drawPic: 1730 picture: 1730)
				)
				(2
					(proc1111_7 42395 48 -3)
					(gCurRoom drawPic: 1770 picture: 1770)
				)
				(3
					(proc1111_7 4234 27 8)
					(gCurRoom drawPic: 1730 picture: 1730)
				)
				(4
					(proc1111_7 4235 74 10)
					(gCurRoom drawPic: 1710 picture: 1710)
				)
				(5
					(proc1111_7 4236 57 -6)
					(gCurRoom drawPic: 1770 picture: 1770)
				)
				(6
					(proc1111_7 4237 34 8)
					(gCurRoom drawPic: 1730 picture: 1730)
				)
				(7
					(proc1111_7 4238 58 -3)
					(gCurRoom drawPic: 1770 picture: 1770)
				)
				(8
					(proc1111_7 4239 26 16)
					(gCurRoom drawPic: 1730 picture: 1730)
				)
				(9
					(proc1111_7 42390 72 4)
					(gCurRoom drawPic: 1770 picture: 1770)
				)
				(10
					(proc1111_7 42391 34 16)
					(gCurRoom drawPic: 1730 picture: 1730)
				)
				(11
					(proc1111_7 42394 -9 -1)
					(gCurRoom drawPic: 1710 picture: 1710)
				)
				(12
					(proc1111_7 42393 113 27 gEgo 30)
					(gCurRoom drawPic: 1200 picture: 1200)
				)
				(13
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
		(= global204 1)
		(switchto1105 doit:)
		(if (gCast contains: donsCup)
			(donsCup show:)
		)
		(localproc_0)
		(gEgo view: 2 heading: 180 normalize: 2)
		(SetFlag 12)
		(SetFlag 49)
		(ClearFlag 190)
		(ClearFlag 51)
		(ClearFlag 52)
		(ClearFlag 247)
		(SetFlag 175)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

