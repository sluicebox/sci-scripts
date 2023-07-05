;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 505)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use PolyFeature)
(use Print)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use System)

(public
	rm505 0
	rideTram 1
)

(local
	local0
	local1
)

(instance rm505 of LarryRoom
	(properties
		noun 1
		picture 505
		horizon 0
		east 660
		west 500
	)

	(method (init)
		(if global100
			(= local1 2)
		else
			(= local1 4)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 139 319 139 319 100 261 100 257 94 237 94 236 101 177 102 152 93 152 44 148 47 148 93 136 94 81 122 53 95 103 104 108 102 108 34 61 34 104 100 51 91 14 91 3 95 0 101
					yourself:
				)
		)
		(super init: &rest)
		(if (not (IsFlag 35))
			(gEgo
				normalize: 900 8
				ignoreActors: 0
				setScaler: Scaler 100 75 98 74
				init:
			)
		)
		(if (not (OneOf gPrevRoomNum 500 660))
			(gGlobalSound2 number: 200 loop: -1 play:)
		)
		(cond
			((== gPrevRoomNum 500)
				(gEgo x: 10 cel: 0)
				(gGame handsOn:)
			)
			((== gPrevRoomNum 660)
				(gEgo x: 310 cel: 1)
				(gGame handsOn:)
			)
			(else
				(switch gPrevRoomNum
					(230
						(self setScript: fromPoolScr)
					)
					(else
						(self setScript: fromBarScr)
					)
				)
			)
		)
		(bluesBarExitPoly init:)
		(hallDoor init:)
		(pornPic init:)
		(poolExit init:)
		(sculpture1 init:)
		(sculpture2 init:)
		(banister init:)
		(carpet init:)
		(windowFrame init:)
		(if (IsFlag 35)
			(if (IsFlag 36)
				((ScriptID 825 1) z: 0 view: 90 posn: 0 126 init:) ; tram
			else
				((ScriptID 825 1) z: 0 view: 90 posn: 319 126 init:) ; tram
			)
			((ScriptID 825 2) play: setLoop: -1) ; tramSoundFx
			(self setScript: rideTram)
		)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 500 660))
			(gGlobalSound2 fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (edgeToRoom param1)
		(switch param1
			(2
				(self setScript: toHallScr)
			)
			(4
				(self setScript: toLobbyScr)
			)
		)
		(return 0)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script 0)
			((bluesBarExitPoly onMe: (gEgo x:) (gEgo y:))
				(self setScript: bailToBarScr)
			)
			((gEgo inRect: 136 85 161 92)
				(gCurRoom setScript: toPoolScr)
			)
			((gEgo inRect: 70 90 83 108)
				(if (not local0)
					(= local0 1)
					(gEgo setPri: 30)
				)
			)
			(local0
				(gEgo setPri: -1)
				(= local0 0)
			)
		)
	)

	(method (dispose)
		(bluesBarExitPoly dispose:)
		(super dispose: &rest)
	)
)

(instance rideTram of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar
					disableIcon:
						(ScriptID 0 3) ; icon0
						(ScriptID 0 5) ; icon2
						(ScriptID 0 6) ; icon3
						(ScriptID 0 9) ; icon6
					enableIcon: (ScriptID 0 4) (ScriptID 0 7) ; icon1, icon4
					show:
				)
				(if (OneOf global166 (ScriptID 0 4) (ScriptID 0 7)) ; icon1, icon4
					(gTheIconBar curIcon: global166)
				else
					(gTheIconBar curIcon: (ScriptID 0 7)) ; icon4
				)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				(User canInput: 1 canControl: 1)
				(cond
					((and (IsFlag 36) (> ((ScriptID 825 1) x:) 319)) ; tram
						(self cue:)
					)
					((IsFlag 36)
						((ScriptID 825 1) ; tram
							setCycle: Walk
							setMotion: MoveTo 319 126 self
						)
					)
					((< ((ScriptID 825 1) x:) 0) ; tram
						(self cue:)
					)
					(else
						((ScriptID 825 1) ; tram
							setCycle: Walk
							setMotion: MoveTo 0 126 self
						)
					)
				)
			)
			(1
				(DisposeScript 826)
				(if (IsFlag 36)
					(gCurRoom newRoom: 660)
				else
					(gCurRoom newRoom: 500)
				)
			)
		)
	)
)

(instance toLobbyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -15 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance toHallScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 335 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 660)
			)
		)
	)
)

(instance toPoolScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 150 74 self)
			)
			(1
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance fromPoolScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 150 74 setMotion: MoveTo 150 98 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromBarScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 102 103 setPri: 30 setMotion: MoveTo 46 92 self)
			)
			(1
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bailToBarScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 102 103 self)
			)
			(1
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance enterEastWestScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 500)
					(gEgo posn: -8 119 setMotion: MoveTo 12 119 self)
				else
					(gEgo posn: 329 119 setMotion: MoveTo 309 119 self)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sculpture1 of Feature
	(properties
		noun 7
		sightAngle 40
		x 200
		y 97
	)

	(method (init)
		(super init: &rest)
		(self setPolygon: (sculpturePoly1 init: yourself:))
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(cond
			((or (IsFlag 35) (!= theVerb 4)) ; Do
				(super doVerb: theVerb)
			)
			((and (== theVerb 4) (not (-- local1))) ; Do
				(gEgo get: 22 35 2) ; roomkey
				(SetFlag 72)
				(SetFlag 156)
				(SetFlag 168)
				(= global213 gTheCursor)
				(gGame setCursor: gNormalCursor)
				(SetCursor 230 110)
				(while (== (= temp1 (Random 1 61)) 9)
				)
				(DoAudio audPLAY 611 1 4 temp1 1)
				(if
					(Print
						width: 160
						font: gUserFont
						addTitle: {Carlos, are you cheating again?}
						addText: 1 4 temp1 1 50 1 611
						fore: 66
						addText:
							{Giving you the swim suit and your room key and the beaver.}
							50
							17
						fore: 16
						addText: {Inflate the beaver?} 50 38
						fore: 0
						addIcon: 1592 1 0 0 0
						addButton: 0 {NO} 50 48
						addButton: 1 {YES} 160 48
						init:
					)
					(SetFlag 223)
					((= temp0 (gInventory at: 2)) ; beaver
						noun: 16
						message: 49
						view: 51
						setCursor: 51 0 0
						yourself:
					)
					(if (not (& (temp0 signal:) $0004))
						(temp0 signal: (| (temp0 signal:) $0004))
						(DeleteScreenItem temp0)
					)
					(gInventory show:)
				)
				(gGame setCursor: global213)
			)
			(else
				(gCurRoom setScript: touchSculptureScr)
			)
		)
	)
)

(instance sculpture2 of Feature
	(properties
		noun 5
		sightAngle 40
		x 200
		y 97
	)

	(method (init)
		(super init: &rest)
		(self setPolygon: (sculpturePoly2 init: yourself:))
	)
)

(instance hallDoor of Feature
	(properties
		noun 2
		modNum 205
		approachX 247
		approachY 97
		x 247
		y 90
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 4 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 236 44 268 44 265 92 227 92
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: (ScriptID 96 0)) ; knockOnDoorScr
		else
			(super doVerb: theVerb)
		)
	)
)

(instance poolExit of Feature
	(properties
		noun 2
		sightAngle 40
		x 156
		y 61
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 176 34 171 100 131 96 127 61 131 32
					yourself:
				)
		)
	)
)

(instance pornPic of Feature
	(properties
		noun 3
		sightAngle 40
		x 107
		y 101
		z 37
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 89 57 99 55 102 95 90 99
					yourself:
				)
		)
	)
)

(instance banister of Feature
	(properties
		noun 8
		sightAngle 40
		x 49
		y 87
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 59 78 70 78 84 38 73 6 73 6 59
					yourself:
				)
		)
	)
)

(instance windowFrame of PolyFeature
	(properties
		noun 5
		modNum 205
		sightAngle 40
		y 205
		variableX 1
	)

	(method (init)
		(self
			addPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 56 127 114 131 108 115 100 78 101 44 106 0 126 0 120 27 118 51 121 92 131 135 193 134 282 123 319 125 319 137 299 136 273 139 38 139 0 129 0 119
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance carpet of PolyFeature
	(properties
		noun 1
		modNum 205
		variableX 1
		variableY 1
	)

	(method (init)
		(self
			addPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 94 12 90 54 91 77 97 77 111 85 117 131 93 138 72 157 73 171 99 226 99 227 93 265 93 269 97 319 99 319 139 0 140
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bluesBarExitPoly of Polygon
	(properties)

	(method (init)
		(super init: 91 89 91 109 85 111 80 107 80 89)
	)
)

(instance sculpturePoly2 of Polygon
	(properties)

	(method (init)
		(super init: 319 18 319 65 292 65 289 17)
	)
)

(instance sculpturePoly1 of Polygon
	(properties)

	(method (init)
		(super init: 227 18 219 67 186 64 187 17)
	)
)

(instance touchSculptureScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 186) (!= (gEgo y:) 102))
					(gEgo setMotion: PolyPath 186 102 self)
				else
					(self cue:)
				)
			)
			(1
				(if (!= (gEgo heading:) 90)
					(gEgo setHeading: 90 self)
				else
					(self cue:)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo view: 901 setLoop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(gMessager say: 7 4 0 0 self) ; "You touch it briefly while fantasizing about Sally Fields."
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo normalize: 900 0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

