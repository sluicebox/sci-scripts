;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use MuseumRgn)
(use Scaler)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Rev)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm610 0
	northDoor 1
	eastDoor 2
)

(local
	[local0 15] = [-1 195 200 208 216 234 172 167 161 148 129 79 64 46 23]
	[local15 15] = [-1 132 136 145 151 150 127 132 136 144 154 138 139 143 150]
	[local30 15] = [-1 82 90 112 118 130 82 90 97 112 130 94 98 111 125]
	[local45 15] = [-1 10 13 22 32 41 10 13 20 29 41 17 20 22 30]
	local60
	local61 = -1
	local62 = -1
	local63
)

(instance rm610 of LBRoom
	(properties
		noun 29
		picture 610
		north 630
		east 640
		south 600
		vanishingX 165
		vanishingY 88
	)

	(method (init)
		(gEgo init: normalize: 831 setScale: Scaler 123 0 190 88)
		(self setRegions: 90) ; MuseumRgn
		(switch gPrevRoomNum
			(north
				(gEgo edgeHit: EDGE_NONE setHeading: 180)
				(northDoor caller: self)
			)
			(east
				(gEgo edgeHit: EDGE_NONE setHeading: 270)
				(eastDoor caller: self)
			)
			(south
				(gCurRoom setScript: sEnterSouth self)
			)
			(620
				(self setScript: sClimbDownVat)
				(if (gEgo has: 11) ; daggerOfRa
					(gTheIconBar enable: 7)
				)
			)
			(666
				(Palette palSET_INTENSITY 0 255 100)
				(gEgo posn: 84 132)
				(self setScript: sEnterFromTunnel)
			)
			(26 ; actBreak
				(self setScript: sClimbDownVat)
			)
			(else
				(gEgo wearingGown: 1 posn: 160 160)
				(gGame handsOn:)
			)
		)
		(gGameMusic2 number: 610 loop: -1 flags: 1 play:)
		(super init:)
		(LoadMany rsVIEW 611 612)
		(northDoor init:)
		(if
			(or
				(and (== gAct 3) (TimeCheck $1008)) ; has 1:00 am occurred?
				(>= gAct 4)
				(not (IsFlag 50))
			)
			(northDoor locked: 0)
		else
			(northDoor locked: 1)
		)
		(eastDoor init:)
		(if (and (IsFlag 18) (not (IsFlag 4)))
			(eastDoor locked: 1)
		)
		(oilJar
			setCel:
				(cond
					((IsFlag 105) 3)
					((IsFlag 106) 2)
					((IsFlag 107) 1)
					(else 0)
				)
			approachVerbs: 1 4 8 25 ; Look, Do, magnifier, snakeOil
			init:
		)
		(sink approachVerbs: 25 8 init:) ; snakeOil, magnifier
		(desk approachVerbs: 25 8 init:) ; snakeOil, magnifier
		(drain approachVerbs: 25 8 init:) ; snakeOil, magnifier
		(light init:)
		(funnel init:)
		(longPipe init:)
		(shortPipe init:)
		(southExit init:)
		(if (and (IsFlag 20) (not (== gPrevRoomNum 620)) (not (== gPrevRoomNum 26))) ; actBreak
			(sHeimlichMusic play:)
			(MuseumRgn loadPolyList:)
			((ScriptID 32 0) ; aHeimlich
				init:
				view: 814
				room: 610
				posn: 228 153
				setScale: 156
				loop: 1
			)
			(= local60 1)
		else
			(Load rsSOUND 40)
			(vat1
				approachVerbs: 4 ; Do
				approachX: [local0 1]
				approachY: [local15 1]
				init:
			)
			(vat2
				approachVerbs: 4 ; Do
				approachX: [local0 2]
				approachY: [local15 2]
				init:
			)
			(vat3
				approachVerbs: 4 ; Do
				approachX: [local0 3]
				approachY: [local15 3]
				init:
			)
			(vat4
				approachVerbs: 4 ; Do
				approachX: [local0 4]
				approachY: [local15 4]
				init:
			)
			(vat5
				approachVerbs: 4 ; Do
				approachX: [local0 5]
				approachY: [local15 5]
				init:
			)
			(vat6
				approachVerbs: 4 ; Do
				approachX: [local0 6]
				approachY: [local15 6]
				init:
			)
			(vat7
				approachVerbs: 4 ; Do
				approachX: [local0 7]
				approachY: [local15 7]
				init:
			)
			(vat8
				approachVerbs: 4 ; Do
				approachX: [local0 8]
				approachY: [local15 8]
				init:
			)
			(vat9
				approachVerbs: 4 ; Do
				approachX: [local0 9]
				approachY: [local15 9]
				init:
			)
			(vat10
				approachX: [local0 10]
				approachY: [local15 10]
				approachVerbs: 4 ; Do
				init:
			)
			(vat11
				approachVerbs: 4 ; Do
				approachX: [local0 11]
				approachY: [local15 11]
				init:
			)
			(vat12
				approachVerbs: 4 ; Do
				approachX: [local0 12]
				approachY: [local15 12]
				init:
			)
			(vat13
				approachVerbs: 4 ; Do
				approachX: [local0 13]
				approachY: [local15 13]
				init:
			)
			(vat14
				approachVerbs: 4 ; Do
				approachX: [local0 14]
				approachY: [local15 14]
				init:
			)
		)
	)

	(method (doit)
		(if (and (== (gEgo edgeHit:) EDGE_BOTTOM) (& ((gTheIconBar at: 7) signal:) $0004))
			(gTheIconBar enable: 7)
		)
		(if (and (not (gCurRoom script:)) (StepOn gEgo 64))
			(gCurRoom setScript: sExitSouth)
		)
		(super doit:)
	)

	(method (cue)
		(if (not (gEgo has: 11)) ; daggerOfRa
			(gTheIconBar disable: 7)
		)
		(cond
			(local60
				(gCurRoom setScript: sKickOut)
			)
			(
				(and
					(not (IsFlag 154))
					(not (IsFlag 4))
					(not
						(and
							(== gAct 3)
							(TimeCheck $b102) ; has 11:15 pm occurred?
							(not (TimeCheck $1310)) ; has 1:45 am occurred?
						)
					)
				)
				(eastDoor setScript: sWaterPrompt)
			)
		)
		(if (and (== gAct 4) (TimeCheck $3002 1) (not (TimeCheck $3002))) ; can 3:00 am occur?, has 3:00 am occurred?
			((ScriptID 90 15) seconds: 2) ; meetingTimer
			(= global111 15)
		)
	)

	(method (dispose)
		(if (and (not (== gNewRoomNum 620)) (IsFlag 20))
			(ClearFlag 21)
			((ScriptID 90 13) setReal: (ScriptID 90 13) 30) ; fumeTimer, fumeTimer
		)
		(if (!= gNewRoomNum 620)
			(gGameMusic2 fade:)
		)
		(kickTimer dispose: delete:)
		(sHeimlichMusic fade:)
		(super dispose:)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar enable: 7)
				(gGame handsOff:)
				(gEgo setHeading: 180 setMotion: MoveFwd 80 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 120 y: 270)
				(= cycles 1)
			)
			(1
				(gEgo setHeading: 0 setMotion: MoveFwd 100 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWaterPrompt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(gMessager say: 32 0 0 0 self) ; "You hear muffled voices coming through the door to Ernie's office."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromTunnel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 58 144 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbUpVat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local61 -1)
				(= local62 -1)
				(if (> (gEgo x:) 180)
					(= register 1)
				else
					(= register 0)
				)
				(gEgo
					view: 612
					setLoop: register
					setCel: 0
					code: footstepCode
					scaleX: [local30 global129]
					scaleY: [local30 global129]
					setScale:
					setCycle: End self
				)
			)
			(1
				(gEgo
					setLoop: (+ register 2)
					setCel: 0
					setCycle: Fwd
					setMotion:
						MoveTo
						(gEgo x:)
						(- (gEgo y:) [local45 global129])
						self
				)
			)
			(2
				(gEgo setMotion: 0 code: 0)
				(gCurRoom newRoom: 620)
				(self dispose:)
			)
		)
	)
)

(instance footstepCode of Code
	(properties)

	(method (doit)
		(cond
			((> (gEgo loop:) 1)
				(if
					(and
						(or (== (gEgo cel:) 1) (== (gEgo cel:) 4))
						(!= local62 (gEgo cel:))
					)
					(sFX play:)
					(= local62 (gEgo cel:))
				)
			)
			(
				(and
					(or
						(== (gEgo cel:) 4)
						(== (gEgo cel:) 7)
						(== (gEgo cel:) 11)
					)
					(!= local61 (gEgo cel:))
				)
				(sFX play:)
				(= local61 (gEgo cel:))
			)
		)
	)
)

(instance sClimbDownVat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> [local0 global129] 180)
					(= register 1)
				else
					(= register 0)
				)
				(gEgo
					view: 612
					setLoop: (+ register 2)
					setCel: (gEgo lastCel:)
					posn:
						[local0 global129]
						(- [local15 global129] [local45 global129])
					code: footstepCode
					scaleX: [local30 global129]
					scaleY: [local30 global129]
					setScale:
					setCycle: Rev
					setMotion:
						MoveTo
						[local0 global129]
						[local15 global129]
						self
				)
			)
			(1
				(gEgo setLoop: register setCel: 13 setCycle: Beg self)
			)
			(2
				(gEgo
					normalize: 831
					code: 0
					loop: (if register 0 else 1)
					setScale: Scaler 123 0 190 88
				)
				(= cycles 1)
			)
			(3
				(if (IsFlag 21)
					(gMessager say: 27 0 2) ; "The strong fumes are making you dizzy."
				else
					(gMessager say: 27 0 1) ; "Boy, the alcohol fumes sure are strong in here!"
				)
				(gGame handsOn:)
				(if (not (gEgo has: 11)) ; daggerOfRa
					(gTheIconBar disable: 7)
				)
				(self dispose:)
			)
		)
	)
)

(instance sKickOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 28 0 5) ; "Fraulein Bow! This laboratory is dangerous and verboten to the public. You will leave now!"
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(if (not (gEgo has: 11)) ; daggerOfRa
					(gTheIconBar disable: 7)
				)
				(kickTimer setReal: kickTimer 7)
				(self dispose:)
			)
		)
	)
)

(instance sKickOut2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar enable: 7)
				(gGame handsOff:)
				(gMessager say: 28 0 6) ; "I will NOT warn you AGAIN, fraulein! Leave this laboratory IMMEDIATELY!"
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 108 252 self)
			)
			(2
				(gCurRoom newRoom: (gCurRoom south:))
				(self dispose:)
			)
		)
	)
)

(instance sDumpIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 611 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(1
				(= ticks 20)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 831 loop: 0)
				(= cycles 1)
			)
			(4
				(gMessager say: 3 25 14 0 self) ; "Nice going, Ace! You just emptied your Snake Oil down the drain!"
			)
			(5
				(gGame handsOn:)
				(= global150 0)
				(= local63 1)
				(self dispose:)
			)
		)
	)
)

(instance northDoor of Door
	(properties
		x 187
		y 120
		noun 1
		approachX 189
		approachY 125
		view 611
		priority 8
		signal 16
		entranceTo 630
		moveToX 184
		moveToY 118
		enterType 0
		exitType 0
	)

	(method (createPoly)
		(super createPoly: 173 122 173 117 189 117 189 122 172 122)
	)
)

(instance eastDoor of Door
	(properties
		x 306
		y 149
		noun 2
		approachX 311
		approachY 155
		view 611
		loop 1
		priority 10
		signal 16
		entranceTo 640
		listenVerb 38
		moveToX 315
		moveToY 147
		enterType 0
		exitType 0
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 38) ; Do, waterGlass
	)

	(method (createPoly)
		(super createPoly: 311 150 318 152 318 156 310 153)
	)

	(method (listen)
		(if
			(or
				(IsFlag 154)
				(IsFlag 4)
				(and (== gAct 3) (TimeCheck $b102) (not (TimeCheck $1310))) ; has 11:15 pm occurred?, has 1:45 am occurred?
			)
			(super listen:)
		else
			(gMessager say: 2 38 4) ; "Interesting. I never noticed that before."
			(gGame points: 1 154)
		)
	)
)

(instance kickTimer of Timer
	(properties)

	(method (cue)
		(if (not (gCurRoom script:))
			(gCurRoom setScript: sKickOut2)
		)
	)
)

(instance oilJar of View
	(properties
		x 25
		y 165
		z 11
		noun 31
		approachX 68
		approachY 181
		view 611
		loop 2
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 105)
						(gMessager say: 31 1 10) ; "The container is empty."
					)
					((IsFlag 106)
						(gMessager say: 31 1 9) ; "The container is one-third full of an oily liquid."
					)
					((IsFlag 107)
						(gMessager say: 31 1 8) ; "The container is two-thirds full of an oily liquid."
					)
					(else
						(gMessager say: 31 1 7) ; "The container is full of an oily liquid."
					)
				)
			)
			(8 ; magnifier
				(if (gEgo has: 14) ; snakeOil
					(if (IsFlag 105)
						(gMessager say: 31 8 10) ; "You see an oily coating on the glass of the empty container."
					else
						(gMessager say: 31 8 11) ; "The strong smell of the oily liquid reminds you of the Snake Oil, leading you to speculate that it is, in fact, Snake Oil."
					)
				else
					(gMessager say: 31 8 12) ; "The oily liquid has a strong smell. Phew!"
				)
			)
			(4 ; Do
				(if (IsFlag 105)
					(gMessager say: 31 4 10) ; "When you stick your finger in the empty container, you feel an oily residue on the glass. You also note that the container is too heavy for you to move, even when it's empty."
				else
					(gMessager say: 31 4 17) ; "The liquid in the container feels oily. You also note that the container is too heavy for you to move."
				)
			)
			(25 ; snakeOil
				(if (< cel 3)
					(++ cel)
					(= global150 4)
					(cond
						((IsFlag 106)
							(ClearFlag 106)
							(SetFlag 105)
						)
						((IsFlag 107)
							(ClearFlag 107)
							(SetFlag 106)
						)
						(else
							(SetFlag 107)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sink of Feature
	(properties
		x 180
		y 167
		noun 3
		nsTop 157
		nsLeft 162
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 2
		approachX 161
		approachY 184
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local63
					(gMessager say: 3 1 13) ; "An oily specimen examination table with an oily drain at one end."
				else
					(gMessager say: 3 1) ; "A dusty specimen examination table with a drain at one end."
				)
			)
			(8 ; magnifier
				(if local63
					(gMessager say: 3 8 13) ; "The specimen table is oily and has a strong smell as if someone poured Snake Oil down the drain."
				else
					(gMessager say: 3 8) ; "The specimen table is thick with dust. The dusty drain smells like alcohol."
				)
			)
			(25 ; snakeOil
				(if global150
					(gCurRoom setScript: sDumpIt)
				else
					(gMessager say: 3 25 15) ; "As much as you would enjoy pouring your Snake Oil down this drain, your empty flask makes that impossible."
				)
			)
			(4 ; Do
				(if local63
					(gMessager say: 3 4 13) ; "The specimen table and the drain feel oily."
				else
					(gMessager say: 3 4) ; "The specimen table and the drain feel dusty."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat1 of Feature
	(properties
		x 206
		y 102
		noun 4
		nsTop 75
		nsLeft 204
		nsBottom 130
		nsRight 208
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 1)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat2 of Feature
	(properties
		x 213
		y 101
		noun 5
		nsTop 71
		nsLeft 210
		nsBottom 132
		nsRight 216
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 2)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat3 of Feature
	(properties
		x 221
		y 102
		noun 6
		nsTop 66
		nsLeft 217
		nsBottom 138
		nsRight 225
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 3)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat4 of Feature
	(properties
		x 230
		y 100
		noun 7
		nsTop 56
		nsLeft 225
		nsBottom 145
		nsRight 236
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 4)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat5 of Feature
	(properties
		x 266
		y 100
		noun 8
		nsTop 44
		nsLeft 237
		nsBottom 156
		nsRight 295
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 5)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat6 of Feature
	(properties
		x 161
		y 102
		noun 9
		nsTop 78
		nsLeft 159
		nsBottom 126
		nsRight 163
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 6)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat7 of Feature
	(properties
		x 155
		y 102
		noun 10
		nsTop 74
		nsLeft 152
		nsBottom 130
		nsRight 159
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 7)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat8 of Feature
	(properties
		x 146
		y 100
		noun 11
		nsTop 66
		nsLeft 141
		nsBottom 135
		nsRight 152
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 8)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat9 of Feature
	(properties
		x 134
		y 99
		noun 12
		nsTop 57
		nsLeft 128
		nsBottom 142
		nsRight 140
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 9)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat10 of Feature
	(properties
		x 98
		y 99
		noun 13
		nsTop 44
		nsLeft 72
		nsBottom 154
		nsRight 125
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 10)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat11 of Feature
	(properties
		x 65
		y 100
		noun 14
		nsTop 67
		nsLeft 59
		nsBottom 133
		nsRight 71
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 11)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat12 of Feature
	(properties
		x 50
		y 100
		noun 15
		nsTop 64
		nsLeft 42
		nsBottom 136
		nsRight 58
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 12)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat13 of Feature
	(properties
		x 31
		y 100
		noun 16
		nsTop 59
		nsLeft 20
		nsBottom 141
		nsRight 42
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 13)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vat14 of Feature
	(properties
		x 9
		y 92
		noun 17
		nsTop 51
		nsBottom 133
		nsRight 19
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global129 14)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 27
		y 161
		noun 18
		nsTop 134
		nsBottom 189
		nsRight 54
		sightAngle 40
		onMeCheck 4
		approachX 78
		approachY 183
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25 ; snakeOil
				(if global150
					(gMessager say: 18 25 14) ; "Worried that there might be snakes hiding in this desk, you sprinkle a little Snake Oil around just to make sure it's safe. It seems to work, since no snakes jump out and attack you."
					(-- global150)
				else
					(gMessager say: 18 25 15) ; "As much as you would enjoy sprinkling Snake Oil on the desk, your empty flask makes that impossible."
				)
			)
			(6 ; Ask
				(gMessager say: 18 6 3) ; "The desk maintains a wooden expression and refuses to respond."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drain of Feature
	(properties
		x 110
		y 172
		noun 19
		nsTop 169
		nsLeft 98
		nsBottom 176
		nsRight 122
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25 ; snakeOil
				(if global150
					(gMessager say: 19 25 14) ; "You hear a distant hiss down the pipe below the grate as you sprinkle a little Snake Oil down the drain."
					(-- global150)
				else
					(gMessager say: 19 25 15) ; "As much as you would enjoy pouring some Snake Oil down the drain, your empty flask makes that impossible."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance light of Feature
	(properties
		x 38
		y 195
		z 100
		noun 20
		nsTop 90
		nsLeft 29
		nsBottom 100
		nsRight 48
		sightAngle 40
		onMeCheck 8
	)
)

(instance funnel of Feature
	(properties
		x 208
		y 150
		noun 21
		nsTop 145
		nsLeft 201
		nsBottom 155
		nsRight 216
		sightAngle 40
	)
)

(instance longPipe of Feature
	(properties
		x 159
		y 31
		noun 22
		nsTop 29
		nsBottom 33
		nsRight 319
		sightAngle 40
	)
)

(instance shortPipe of Feature
	(properties
		x 263
		y 17
		noun 23
		nsTop 15
		nsLeft 208
		nsBottom 20
		nsRight 319
		sightAngle 40
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 185
		nsLeft 52
		nsBottom 189
		nsRight 159
		cursor 11
		exitDir 3
		noun 30
	)
)

(instance sFX of Sound
	(properties
		flags 1
		number 613
	)
)

(instance sHeimlichMusic of Sound
	(properties
		flags 1
		number 19
		loop -1
	)
)

