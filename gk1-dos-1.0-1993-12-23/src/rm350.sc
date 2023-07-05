;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use n013)
(use GKTeller)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Cursor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm350 0
)

(local
	local0 = 1
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
)

(instance rm350 of Room
	(properties
		noun 11
		picture 350
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 350)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 184 145 224 125 244 104 319 116 319 108 134 78 121 80 208 94 207 102 193 118 131 145
					yourself:
				)
		)
		(gEgo
			view: 4792
			loop: 0
			cel: 0
			signal: (| (gEgo signal:) $1000)
			setCycle: StopWalk -1
			init:
			state: 2
			ignoreActors: 1
			posn: 127 155
		)
		(leftTree init:)
		(rightTree init:)
		(leftRose init:)
		(rightRose init:)
		(steps init:)
		(windows init:)
		(shutters init:)
		(thePath init:)
		(knocker init:)
		(doorKnob init:)
		(frontDoor init:)
		(leftHedge init:)
		(rightHedge init:)
		(gWalkHandler add: thePath)
		(gWalkHandler add: self)
		(gGkMusic1
			number: 350
			setLoop: -1
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(if (== gPrevRoomNum 360)
			(gEgo hide:)
			(gCurRoom setScript: fromMansion)
		else
			(gCurRoom setScript: enterEgo)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if (== local14 8)
					(= local14 0)
					(= local10 1)
					(super doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: thePath)
		(gWalkHandler delete: self)
		(gGkMusic1 fade:)
		(DisposeScript 64939)
		(DisposeScript 51)
		(DisposeScript 920)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if local0
			(if (leftReturn onMe: gEgo)
				(gEgo setScript: walkRight)
			)
			(if (rightReturn onMe: gEgo)
				(gEgo setScript: walkLeft)
			)
		)
		(cond
			((thePath onMe: gMouseX (- gMouseY 10))
				(if (== gTheCursor ((gTheIconBar at: 0) cursorView:))
					(gGame setCursor: mansionExitCursor 1)
					(= local12 1)
				)
			)
			(local12
				(gGame setCursor: ((gTheIconBar at: 0) cursorView:) 1)
				(= local12 0)
			)
		)
	)
)

(instance enterEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 157 142 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance walkRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 148 83 self)
				(gMessager say: 11 13 13 0) ; "This is private property. Gabriel should stay near the front door until invited to do otherwise."
			)
			(1
				(gGame handsOn:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance walkLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 290 107 self)
				(gMessager say: 11 13 13 0) ; "This is private property. Gabriel should stay near the front door until invited to do otherwise."
			)
			(1
				(gGame handsOn:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance knockTheKnocker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (== (gEgo x:) 231) (== (gEgo y:) 95))
					(self changeState: 2)
				else
					(gEgo setMotion: PolyPath 224 96 self)
				)
			)
			(1
				(gEgo
					view: 351
					setCel: 0
					setLoop: 0
					posn: 230 94
					setCycle: End self
				)
			)
			(2
				(gGkSound1 number: 219 setLoop: 1 play:)
				(gEgo
					view: 351
					setCel: 0
					setLoop: 1
					posn: 231 95
					setCycle: Osc 6 self
				)
			)
			(3
				(gEgo normalize: 6 4792)
				(= seconds 3)
			)
			(4
				(butler init: show: setCycle: End self)
				(gGkSound1 number: 373 setLoop: 1 play:)
			)
			(5
				(butler setLoop: 1 setCycle: End self)
				(butlerTeller init: butler)
			)
			(6
				(switch gDay
					(2
						(if (IsFlag 243)
							(if (IsFlag 107)
								(gMessager say: 4 8 10 0 self) ; "(IRRITATED, SNOTTY)Ms. Gedde is busy, OFFICER, and has instructed me to wish you good luck. That is all."
							else
								(gMessager say: 4 8 9 1) ; "(RRCC. STUCK-UP ACCENT)Ah, Officer Mosely. I'll see if Ms. Gedde wishes to speak with you again."
								(= local9 1)
								(gCurRoom setScript: showTheBadge)
							)
						else
							(gMessager say: 4 8 7 0 self) ; "(RRCC. COOL, INTELLECTUAL)May I help you?"
							(= local8 1)
						)
					)
					(3
						(if (IsFlag 244)
							(gMessager say: 4 8 12 0 self) ; "(RRCC. THREATENING)I told you, Ms. Gedde is out."
						else
							(SetFlag 244)
							(gMessager say: 4 8 11 0 self) ; "(DISREGARDING)Ah, it's you. Ms. Gedde is not at home, Sir."
						)
					)
					(else
						(gMessager say: 4 8 17 0 self) ; "(RRCC)Ms. Gedde is unavailable, Mr. Knight."
					)
				)
			)
			(7
				(if local9
					(butler setCel: 0 setLoop: 3 setCycle: End self)
				else
					(if local8
						(= local8 0)
						(butlerTeller doVerb: 11)
						(if local10
							(= local10 0)
							(gGame handsOn:)
						)
						(= local11 1)
						(if local5
							(gCurRoom setScript: shutTheDoor)
						)
					else
						(gCurRoom setScript: shutTheDoor)
					)
					(self dispose:)
				)
			)
			(8
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance shutTheDoor of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (self state:) 0) local10)
			(self seconds: 0 changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local14 8)
				(if local11
					(gGame handsOn:)
					(= seconds 12)
					(gTheIconBar disable: 10)
				else
					(self cue:)
				)
			)
			(1
				(if local11
					(gMessager say: 12 0 6 0 self) ; "(RRCC)Just as I thought. Good day, SIR."
				else
					(self cue:)
				)
			)
			(2
				(gGame handsOff:)
				(butler setCel: 4 setLoop: 0 setCycle: CT 2 -1 self)
			)
			(3
				(gGkSound1 number: 374 setLoop: 1 play:)
				(butler setCel: 1 setLoop: 0 setCycle: Beg self)
			)
			(4
				(= local14 0)
				(gEgo normalize: 6 4792)
				(butlerTeller dispose:)
				(= local5 1)
				(butler dispose:)
				(if local11
					(gTheIconBar enable: 10)
					(= local11 0)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromMansion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(butler setCel: 4 setLoop: 0 init: setCycle: Beg self)
				(gEgo posn: 231 95 show: setMotion: PolyPath 223 104 self)
				(if (IsFlag 107)
					(gMessager say: 12 0 18 0) ; "(LOUDLY, BEING SARCASTIC)Thank you very much! I had a lovely time!"
				)
			)
			(1
				(gGkSound1 number: 374 setLoop: 1 play:)
			)
			(2
				(butler dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showTheBadge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(if local9
					(self changeState: 2)
				else
					(gTheIconBar enable: 0)
					(gEgo view: 351 setCel: 0 setLoop: 2 setCycle: End self)
					(gMessager sayRange: 1 79 0 1 3 self) ; "(HEAVY FAKE 'OFFICIAL' VOICE)My name is Detective Mosely. I'm here on police business."
				)
			)
			(1 1)
			(2
				2
				(butler setCel: 4 setLoop: 0 setCycle: Beg self)
				(gEgo normalize: 6 4792)
			)
			(3
				(= seconds 3)
			)
			(4
				4
				(gEgo
					view: 352
					setCel: 0
					setLoop: 2
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(5
				5
				(= seconds 3)
			)
			(6
				6
				(butler setCel: 0 setLoop: 0 setCycle: End self)
				(if local9
					(gMessager say: 4 8 9 2 self) ; "(RRCC)Right this way, Officer."
				else
					(gMessager say: 1 79 0 4 self) ; "Ms. Gedde will see you. Right this way."
				)
			)
			(7 7)
			(8
				8
				(butler setCel: 0 setLoop: 3 setCycle: End self)
				(gEgo getPoints: 161 3)
			)
			(9
				9
				(SetFlag 243)
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance leaveTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 162 145 self)
			)
			(1
				(gCurRoom newRoom: 205)
			)
		)
	)
)

(instance butlerTeller of GKTeller
	(properties
		curNoun 6
		sayNoun 7
		verb 78
	)

	(method (cue)
		(= local14 iconValue)
		(switch iconValue
			(4 ; Magazine subscriptions for sale.
				(= local1 1)
				(= local11 0)
				(gCurRoom setScript: shutTheDoor)
			)
			(2 ; I'd like to see Malia Gedde, please.
				(= local2 1)
				(= local6 1)
				(self doVerb: 11)
			)
			(15 ; I'd really like to see Malia Gedde.
				(= local6 1)
				(= local3 1)
				(self doVerb: 11)
			)
			(8 ; I DO have official business.
				(gGame handsOn:)
				(= local11 1)
				(gCurRoom setScript: shutTheDoor)
			)
			(3 ; Silverware polish, anyone?
				(= local7 1)
				(= local11 0)
				(gCurRoom setScript: shutTheDoor)
			)
			(5 ; Please let me in!
				(= local11 0)
				(gCurRoom setScript: shutTheDoor)
			)
			(22 ; Wrong house. Never mind.
				(= local11 0)
				(gCurRoom setScript: shutTheDoor)
			)
			(1 ; I'm selling encyclopedias.
				(= local4 1)
				(= local11 0)
				(gCurRoom setScript: shutTheDoor)
			)
			(else
				(= local6 0)
				(self doVerb: 11)
			)
		)
	)

	(method (showCases)
		(super
			showCases:
				4 ; Magazine subscriptions for sale.
				(not local1)
				1 ; I'm selling encyclopedias.
				(and local1 (not local4))
				2 ; I'd like to see Malia Gedde, please.
				(not local2)
				8 ; I DO have official business.
				local6
				15 ; I'd really like to see Malia Gedde.
				(and local2 local5 (not local3))
				5 ; Please let me in!
				local7
				3 ; Silverware polish, anyone?
				(and (not local7) local4)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== (gCurRoom script:) shutTheDoor)
			(= local13 1)
			(shutTheDoor dispose:)
		)
		(if (and (== theVerb 11) (!= iconValue 8)) ; Talk, I DO have official business.
			(SetCursor -2)
			(= temp0 (gGame setCursor: mansionArrowCursor))
			(while 1
				(if (self respond:)
					(break)
				)
			)
			(gGame setCursor: temp0)
			(SetCursor 0 0 319 155)
		else
			(client doVerb: theVerb)
		)
		(return 1)
	)
)

(instance butler of Prop
	(properties
		noun 1
		x 229
		y 90
		view 352
	)

	(method (doVerb theVerb)
		(switch theVerb
			(79 ; badge
				(if (== (gCurRoom script:) shutTheDoor)
					(shutTheDoor dispose:)
				)
				(= local13 0)
				(gEgo setScript: showTheBadge)
			)
			(else
				(super doVerb: theVerb)
			)
		)
		(if local13
			(= local13 0)
			(gCurRoom setScript: shutTheDoor)
		)
	)
)

(instance leftRose of Feature
	(properties
		noun 8
		sightAngle 20
		x 185
		y 98
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 197 95 190 105 175 105 170 95 184 81
					yourself:
				)
		)
	)
)

(instance rightRose of Feature
	(properties
		noun 8
		sightAngle 20
		x 255
		y 115
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 267 106 261 119 241 119 236 107 250 87
					yourself:
				)
		)
	)
)

(instance shutters of Feature
	(properties
		noun 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 295 54 306 66 307 92 295 91
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 216 49 215 79 205 79 205 48
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 190 46 192 76 171 75 172 45
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 159 45 159 71 152 71 152 45
					yourself:
				)
		)
		(super init:)
	)
)

(instance steps of Feature
	(properties
		noun 13
		sightAngle 20
		x 218
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 190 115 205 100 244 108 229 124
					yourself:
				)
		)
		(super init:)
	)
)

(instance windows of Feature
	(properties
		noun 15
		nsLeft 275
		nsTop 51
		nsRight 295
		nsBottom 91
	)
)

(instance knocker of Feature
	(properties
		noun 4
		nsLeft 235
		nsTop 61
		nsRight 244
		nsBottom 69
		sightAngle 20
		x 235
		y 70
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(gEgo setScript: knockTheKnocker)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftReturn of Feature
	(properties
		nsLeft 115
		nsTop 71
		nsRight 143
		nsBottom 81
	)
)

(instance rightReturn of Feature
	(properties
		nsLeft 310
		nsTop 95
		nsRight 319
		nsBottom 120
	)
)

(instance leftTree of Feature
	(properties
		noun 14
		sightAngle 20
		x 6
		y 103
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 22 30 22 10 38 3 53 10 67 33 60 49 41 34 21 61 22 50 34 58 41 69 37 64 22 82 22 71 46 54 51 41 70 11 88 17 112 51 118 41 122 5 121 10 134 33 138 15 143 0 136
					yourself:
				)
		)
		(super init:)
	)
)

(instance rightTree of Feature
	(properties
		noun 14
		sightAngle 20
		x 318
		y 86
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 100 312 75 291 51 264 40 247 42 231 34 202 55 177 48 181 40 217 22 247 35 267 34 292 39 283 22 319 22 319 38 299 44 319 57
					yourself:
				)
		)
		(super init:)
	)
)

(instance thePath of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 131 146 192 118 224 125 185 146
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gEgo setScript: leaveTheRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorKnob of Feature
	(properties
		noun 2
		nsLeft 227
		nsTop 70
		nsRight 230
		nsBottom 78
		sightAngle 30
		x 228
		y 65
	)
)

(instance frontDoor of Feature
	(properties
		noun 3
		nsLeft 225
		nsTop 52
		nsRight 249
		nsBottom 96
		sightAngle 30
		x 240
		y 57
	)
)

(instance leftHedge of Feature
	(properties
		noun 9
		sightAngle 30
		x 131
		y 100
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 84 145 165 114 70 92 68 83 85 80 166 98 166 110 181 113 183 120 123 147
					yourself:
				)
		)
	)
)

(instance rightHedge of Feature
	(properties
		noun 9
		sightAngle 30
		x 266
		y 131
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 189 145 232 124 258 128 272 116 319 126 319 147 288 146 247 135 220 145
					yourself:
				)
		)
	)
)

(instance mansionArrowCursor of Cursor
	(properties
		view 999
	)
)

(instance mansionExitCursor of Cursor
	(properties
		view 964
	)
)

