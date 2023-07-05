;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 325)
(include sci.sh)
(use Main)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm325 0
	cliffy 1
)

(local
	[local0 16] = [70 74 78 82 87 91 94 99 103 108 112 116 120 124 128 137]
	[local16 16] = [0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7]
	[local32 16] = [70 74 78 82 87 91 94 99 99 104 110 114 120 124 128 137]
	[local48 16] = [70 74 78 82 87 89 91 94 97 102 108 112 118 122 125 134]
	[local64 18] = [0 1 2 3 4 5 5 6 6 7 8 9 9 9 9 10 11 12]
	[local82 18] = [199 197 195 193 188 183 178 173 163 152 142 133 114 95 74 59 44 29]
	[local100 18] = [139 144 155 157 161 163 165 167 166 166 165 162 157 152 147 142 137 132]
	local118
	local119
	local120
	local121
	local122
)

(instance rm325 of Rm
	(properties
		noun 7
		picture 65
		style -32758
		vanishingY 80
	)

	(method (init)
		(self setRegions: 350) ; kiz
		(LoadMany rsVIEW 0 20 440 435 6 33 442 441)
		(NormalEgo 0)
		(gEgo actions: (ScriptID 350 1)) ; yoFlo
		(switch gPrevRoomNum
			(330
				(if (gEgo has: 12) ; Cloaking_Device
					(self picture: 92)
				else
					(self picture: 65)
				)
				(if (not (& global169 $0020))
					(cliffy view: 20 x: 274 y: 159 init:)
				)
			)
			(240)
			(else
				(if (IsFlag 20)
					(NormalEgo 0)
					(gEgo x: 276 y: 184 setScale: 0 init:)
				else
					(gEgo hide:)
					(self picture: 92)
					(light1 init: setCycle: Fwd)
					(light2 init: setCycle: Fwd)
				)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 319 189 265 153 234 137 236 126 208 121 156 128 163 133 190 129 211 132 211 142 251 157 268 189
					yourself:
				)
		)
		(ship init: setOnMeCheck: 1 8)
		(plateau init: setOnMeCheck: 1 4)
		(if (IsFlag 110)
			(elevator loop: 1 cel: 7 y: 137)
			(hatch setLoop: 2 setCel: 0 init:)
		)
		(elevator init:)
		(super init:)
		(gWalkHandler addToFront: elevator)
		(switch gPrevRoomNum
			(330
				(gCurRoom setScript: sRogDown)
			)
			(240
				(gCurRoom setScript: sRogAndCliffy)
			)
			(else
				(if (IsFlag 20)
					(gEgo setMotion: MoveTo 270 170)
				else
					(gCurRoom setScript: sWD40Down)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(
				(and
					(StepOn gEgo 2)
					(not (< 90 (gEgo heading:) 270))
					(not (gCurRoom script:))
				)
				(gCurRoom setScript: sRogJumpToBack)
			)
			(
				(and
					(StepOn gEgo 16384)
					(< 90 (gEgo heading:) 270)
					(not (gCurRoom script:))
				)
				(gCurRoom setScript: sRogJumpToFront)
			)
			((and (StepOn gEgo 64) (not (gCurRoom script:)))
				(gCurRoom setScript: sTriedToLeave)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: elevator)
		(PalVary pvUNINIT)
		(super dispose: &rest)
	)
)

(instance sWD40Down of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(gSq5Music2 number: 160 setLoop: 1 play:)
				(hatch init: setCycle: End self)
			)
			(2
				(= local118 1)
				(gSq5Music2 number: 128 setLoop: -1 play:)
				(elevator
					loop: 1
					y: [local0 local118]
					setCel: [local16 local118]
					init:
				)
				(hatch setLoop: 2 setCel: 0)
				(++ local118)
				(= ticks 5)
			)
			(3
				(elevator y: [local0 local118] setCel: [local16 local118])
				(wd40_depart posn: (wd40_depart x:) [local32 local118])
				(if (== (++ local118) 3)
					(wd40_depart init:)
				)
				(if (== local118 9)
					(wd40_depart setPri: 11)
				)
				(if (< local118 16)
					(-- state)
				)
				(= ticks 5)
			)
			(4
				(gSq5Music2 stop:)
				(wd40_depart setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(gSq5Music2 number: 400 setLoop: 1 play: self)
			)
			(6
				(gSq5Music2 number: 404 setLoop: 1 play:)
				(light1 dispose:)
				(light2 dispose:)
				(DrawPic 65 9)
				(= ticks 5)
			)
			(7
				(wd40_depart setCycle: Beg self)
			)
			(8
				(gSq5Music2 number: 401 setLoop: -1 play:)
				(wd40_depart setLoop: 1 setCycle: End self)
			)
			(9
				(= seconds 2)
			)
			(10
				(wd40_depart setScript: sWD40FlyAway)
				(= cycles 1)
			)
			(11
				(-- local118)
				(= ticks 3)
			)
			(12
				(elevator
					loop: 1
					y: [local0 local118]
					setCel: [local16 local118]
				)
				(if (> (-- local118) 1)
					(-- state)
				)
				(= ticks 4)
			)
			(13
				(elevator dispose:)
				(hatch setLoop: 0 setCel: 7 setCycle: Beg self)
			)
			(14
				(SetFlag 20)
				(hatch dispose:)
				(gCurRoom newRoom: 300)
				(self dispose:)
			)
		)
	)
)

(instance sWD40FlyAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local119 0)
				(= cycles 1)
			)
			(1
				(wd40_depart
					setLoop: 3
					setCel: [local64 local119]
					x: [local82 local119]
					y: [local100 local119]
				)
				(if (< (++ local119) 18)
					(-- state)
				)
				(= ticks 5)
			)
			(2
				(wd40_depart dispose:)
				(gSq5Music2 fade:)
				(self dispose:)
			)
		)
	)
)

(instance sRogDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hatch loop: 2 cel: 0 init:)
				(= seconds 2)
			)
			(1
				(= local118 1)
				(gSq5Music2 number: 128 setLoop: -1 play:)
				(elevator
					loop: 1
					y: [local0 local118]
					setCel: [local16 local118]
					init:
				)
				(++ local118)
				(= ticks 5)
			)
			(2
				(if (== local118 2)
					(gEgo
						view: 0
						cel: 2
						x: 187
						y: 76
						setPri: 9
						scaleSignal: 1
						scaleX: 121
						scaleY: 121
						setLoop: -1
						setLoop: 2
						setCycle: 0
						init:
					)
				)
				(elevator
					loop: 1
					y: [local0 local118]
					setCel: [local16 local118]
				)
				(gEgo posn: (gEgo x:) [local48 local118])
				(if (== (++ local118) 3)
					(hatch setLoop: 2 setCel: 0)
				)
				(if (== local118 9)
					(gEgo setPri: 11)
				)
				(if (< local118 16)
					(-- state)
				)
				(= ticks 5)
			)
			(3
				(gSq5Music2 stop:)
				(NormalEgo 0)
				(if (and (gEgo has: 12) (not (& global169 $0020))) ; Cloaking_Device
					(gMessager say: 6 0 5 0 self) ; "|f3|I got it! Let's move before this thing blows!"
				else
					(= cycles 1)
				)
			)
			(4
				(if (gEgo has: 12) ; Cloaking_Device
					(gEgo
						view: 4
						setPri: 11
						loop: 2
						setMotion: MoveTo 212 134 self
					)
				else
					(gEgo setPri: 11 setMotion: MoveTo 212 134 self)
				)
			)
			(5
				(gEgo setPri: -1)
				(SetFlag 110)
				(if (gEgo has: 12) ; Cloaking_Device
					(= next sRogJumpToFront)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sRogerUpElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(NormalEgo 0)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 187 137 self)
			)
			(2
				(= local118 15)
				(gEgo setPri: 11 setHeading: 180 self)
			)
			(3
				(gSq5Music2 number: 128 setLoop: -1 play:)
				(= cycles 1)
			)
			(4
				(elevator
					loop: 1
					y: [local0 local118]
					setCel: [local16 local118]
				)
				(gEgo posn: (gEgo x:) [local48 local118])
				(if (== local118 8)
					(gEgo setPri: 9)
				)
				(if (>= (-- local118) 0)
					(-- state)
				)
				(= ticks 5)
			)
			(5
				(gSq5Music2 stop:)
				(ClearFlag 110)
				(gCurRoom newRoom: 330)
				(self dispose:)
			)
		)
	)
)

(instance sRogJumpToFront of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 440
					loop: 2
					cel: 0
					setPri: 10
					setScale: 0
					x: 250
					y: 160
					setCycle: CT 2 1 self
				)
			)
			(1
				(gEgo setPri: 11 setCycle: End self)
			)
			(2
				(if (gEgo has: 12) ; Cloaking_Device
					(= next sShipBlows)
					(self dispose:)
				else
					(NormalEgo 0)
					(gEgo setMotion: MoveTo 274 172 self)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogJumpToBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 18)
					(+= state 4)
				)
				(= cycles 1)
			)
			(1
				(gSq5Music2 number: 416 setLoop: 1 play:)
				(gEgo
					view: 440
					cel: 0
					setCycle: 0
					setLoop: -1
					setLoop: 0
					setCycle: End self
				)
			)
			(2
				(if (not (IsFlag 110))
					(gMessager say: 9 0 0 0 self) ; "Hey!... What gives? This must be the cloaked ship of that killer android. Neat!"
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo
					view: 440
					cel: 0
					setCycle: 0
					setLoop: -1
					setLoop: 5
					setCycle: End self
				)
			)
			(4
				(gEgo
					view: 440
					cel: 0
					x: (- (gEgo x:) 1)
					y: (- (gEgo y:) 10)
					setCycle: 0
					setLoop: -1
					setLoop: 1
					setCycle: Osc 1 self
				)
				(= global132 2)
			)
			(5
				(gEgo
					view: 440
					loop: 3
					cel: 0
					setPri: 11
					x: 248
					y: 154
					setCycle: CT 5 1 self
				)
			)
			(6
				(gEgo setPri: 10 setCycle: End self)
			)
			(7
				(NormalEgo 0)
				(gEgo
					scaleSignal: 1
					scaleX: 121
					scaleY: 121
					x: 226
					y: 149
					setMotion: MoveTo 220 130 self
				)
			)
			(8
				(if (not (IsFlag 18))
					(SetFlag 18)
					(if (not (& global169 $0020))
						(= next sCliffyGetsStuck)
					else
						(gGame handsOn:)
					)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sShipBlows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PalVary pvUNINIT)
				(PalVary pvINIT 921 1)
				(gSq5Music2 number: 203 setLoop: 1 play:)
				(gEgo
					view: 435
					loop: 0
					cel: 0
					x: 260
					y: 179
					init:
					setCycle: End
				)
				(if (not (& global169 $0020))
					(cliffy
						view: 435
						loop: 1
						cel: 0
						x: 278
						y: 176
						setCycle: End
					)
				)
				(= seconds 4)
			)
			(1
				(gSq5Music2 fade:)
				(gCurRoom newRoom: 240)
				(self dispose:)
			)
		)
	)
)

(instance sRogAndCliffy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(gEgo
					view: 6
					cel: 0
					x: 265
					y: 173
					setScale: 0
					setCycle: 0
					setLoop: -1
					setLoop: 0
					init:
					actions: myDoorOpen
					setCycle: End self
				)
				(if (not (& global169 $0020))
					(cliffy
						view: 33
						cel: 0
						x: 293
						y: 165
						setCycle: 0
						setLoop: -1
						setLoop: 0
						init:
						setCycle: End
					)
					(ClearFlag 18)
				)
			)
			(2
				(NormalEgo 0 2)
				(gEgo setHeading: 315 self)
				(if (not (& global169 $0020))
					(cliffy view: 20 loop: 2 setHeading: 315)
				)
			)
			(3
				(if (not (& global169 $0020))
					(cliffy setScript: sCliffy)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCliffyGetsStuck of Script
	(properties)

	(method (doit)
		(if (and (== (cliffy loop:) 4) (== (cliffy cel:) 5))
			(gSq5Music2 number: 136 setLoop: 1 play:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sCliffy dispose:)
				(= cycles 1)
			)
			(1
				(cliffy
					view: 440
					loop: 4
					cel: 0
					x: 274
					y: 159
					setCycle: End self
				)
			)
			(2
				(cliffy setCycle: Beg self)
			)
			(3
				(gMessager say: 1 0 0 0 self) ; "Mrrph! Ugh!"
			)
			(4
				(cliffy setScript: sCliffy)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sElevatorDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(1
				(gEgo
					view: 440
					setLoop: -1
					setLoop: 8
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gSq5Music2 number: 160 setLoop: 1 play:)
				(hatch init: setCycle: End self)
			)
			(3
				(gSq5Music2 number: 128 setLoop: -1 play:)
				(= local118 1)
				(elevator loop: 1 y: [local0 1] setCel: [local16 1] init:)
				(hatch setLoop: 2 setCel: 0)
				(++ local118)
				(Face gEgo 173 137)
				(= ticks 15)
			)
			(4
				(elevator
					loop: 1
					y: [local0 local118]
					setCel: [local16 local118]
				)
				(if (< (++ local118) 16)
					(-- state)
				)
				(= ticks 15)
			)
			(5
				(gSq5Music2 stop:)
				(gEgo setCycle: Beg self)
			)
			(6
				(SetFlag 110)
				(NormalEgo 0 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTriedToLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 9))
					(gEgo setMotion: MoveTo 300 210 self)
				else
					(gMessager say: 4 0 0 0 self) ; "You don't have time to go wandering all over the planet. You need the cloaking device."
				)
			)
			(1
				(if (not (IsFlag 9))
					(gCurRoom newRoom: 320)
				else
					(gEgo setMotion: MoveTo 280 170 self)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCliffy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 5))
			)
			(1
				(cliffy view: 26 loop: (Random 0 2) cel: 0 x: 293 y: 165)
				(if (== (cliffy loop:) 1)
					(cliffy setCycle: End self)
				else
					(= state -1)
					(cliffy setCycle: Osc 1 self)
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(= state -1)
				(cliffy setCycle: Beg self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance cliffy of Actor
	(properties
		x 278
		y 176
		noun 2
		view 435
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(switch global132
					(0
						(gMessager say: 2 2 4 0) ; "You sure this is where she parked her ship, Cap'n? Kinda unstable!"
						(= global132 1)
					)
					(1
						(gMessager say: 2 2 2 0) ; "Cliffy just stands there with a slightly puzzled look on his face."
					)
					(2
						(gMessager say: 3 0 3 0) ; "Well cap'n, there's your ship! Now we just hafta figure out a way to get inside the thing."
						(= global132 3)
					)
					(3
						(if (>= global142 2)
							(gMessager say: 2 2 3 (Random 1 5))
						else
							(gMessager say: 2 2 3 (Random 1 4))
						)
					)
					(4
						(if (< local121 3)
							(gMessager say: 2 2 1 local121)
							(++ local121)
						else
							(gMessager say: 2 2 3 5) ; "This ship's cloaking device is the only way were gonna get within a comet's tail of Quirk without being blasted into atoms."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wd40_depart of Actor
	(properties
		x 187
		y 76
		view 442
		priority 9
		signal 16400
	)
)

(instance hatch of Prop
	(properties
		x 146
		y 63
		noun 10
		view 441
		priority 1
		signal 16400
		cycleSpeed 12
	)
)

(instance light1 of Prop
	(properties
		x 233
		y 30
		view 440
		loop 6
		priority 15
		signal 16400
		cycleSpeed 12
	)
)

(instance light2 of Prop
	(properties
		x 286
		y 29
		view 440
		loop 7
		priority 15
		signal 16400
		cycleSpeed 12
	)
)

(instance elevator of View
	(properties
		x 173
		y 3
		noun 11
		view 441
		loop 3
		priority 10
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 110)
					(gEgo setScript: sRogerUpElevator)
				)
			)
			(3 ; Walk
				(if (IsFlag 110)
					(gEgo setScript: sRogerUpElevator)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plateau of Feature
	(properties
		x 189
		y 129
		noun 5
		onMeCheck 4
	)
)

(instance ship of Feature
	(properties
		x 131
		y 36
		noun 8
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== (gCurRoom picture:) 65)
					(gMessager say: 8 1 4 0) ; "You can't see W-D40's ship but your razor sharp intellect tells you it must be around here somewhere."
				else
					(gMessager say: 8 1 6 0) ; "W-D40's ship is both large and imposing, much like many of Roger's recent dates."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance myDoorOpen of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Ship_Opener
				(if (not (IsFlag 110))
					(gCurRoom setScript: sElevatorDown)
					(SetScore 211 100)
					(= global132 4)
					(= local121 0)
					(return 1)
				else
					(return 0)
				)
			)
			(32 ; Communicator
				(gCurRoom setScript: (ScriptID 350 2)) ; sBeamOut
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

