;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6550)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Plane)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm6550 0
)

(instance rm6550 of KQRoom
	(properties
		picture 6550
		south 6500
	)

	(method (init)
		(SetFlag 21)
		(if (IsFlag 213)
			(gThePlane back: 0 drawPic: -1)
			(FrameOut)
		)
		(super init:)
		(win1 init: setCycle: Fwd)
		(win2 init: setCycle: Fwd)
		(win3 init: setCycle: Fwd)
		(gKqMusic1 number: 6550 setLoop: -1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 143 184 142 207 103 178 103 162 115 145 115 138 103 127 103
					yourself:
				)
		)
		(Load rsMESSAGE 6550)
		(gEgo x: 156 y: 135 init: normalize: setScaler: Scaler 55 30 147 50)
		(if (IsFlag 213)
			(PalVary 0 6551 0 100 104 236) ; PalVaryStart
			(gEgo setMotion: PolyPath 156 130)
			(gEgo disableHotspot:)
			(gGame handsOn:)
			(mab view: 6552 loop: 0 cel: 0 x: 156 y: 95 init:)
		else
			(gCurRoom setScript: asleep)
		)
	)

	(method (newRoom newRoomNumber)
		(PalVary 3) ; PalVaryKill
		(super newRoom: newRoomNumber)
	)
)

(instance asleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mab init:)
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 156 130 self)
			)
			(1
				(= ticks 120)
				(PalVary 0 6551 5 100 104 236) ; PalVaryStart
			)
			(2
				(gEgo setCycle: 0)
				(gEgo cel: 3 loop: 8 setMotion: MoveTo 156 115 self)
			)
			(3
				(SetFlag 207)
				(mab setCycle: End self)
				(gKqSound1 number: -35 setLoop: -1 play:)
			)
			(4
				(gEgo view: 8283 loop: 0 cel: 0 setCycle: End)
				(= cycles 30)
			)
			(5
				(PalVary 3) ; PalVaryKill
				((= register (Plane new:))
					setRect: 0 0 319 (gThePlane bottom:)
					back: 0
					picture: 6560
					priority: 1000
					init:
				)
				(gKqSound1 stop: number: 6551 setLoop: 1 play: self)
			)
			(6
				(= ticks 240)
			)
			(7
				(PalVary 0 6551 0 100 104 236) ; PalVaryStart
				(register dispose:)
				(= ticks 120)
			)
			(8
				(gKqMusic1 fade: 0 4 2 1)
				(PalVary 3) ; PalVaryKill
				(gCurRoom newRoom: 4200)
			)
		)
	)
)

(instance touchMab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8105 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(if register
					(gKqSound1 number: 6552 setLoop: 1 play:)
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rugEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rug init: setCycle: CT 11 1 self)
			)
			(1
				(rug fixPriority: 1 priority: 108 setCycle: End self)
			)
			(2
				(rug hide:)
				(mab view: 6553 loop: 2 cel: 0 x: 154 y: 110 setCycle: End self)
			)
			(3
				(rug show: loop: 3 cel: 0 x: 164 y: 109 setCycle: End self)
				(mab loop: 0 cel: 0)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance mabWakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 210)
				(gEgo view: 8105 loop: 0 cel: 0 setCycle: End self)
				(gKqMusic1 number: 6553 setLoop: 1 play: self)
				((= register (Actor new:))
					view: 6552
					setLoop: 2 1
					ignoreActors: 1
					cel: 0
					x: 148
					y: 95
					fixPriority: 1
					priority: 98
					init:
					cycleSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 148 83
				)
			)
			(1)
			(2
				(gKqMusic1 number: 6554 setLoop: 1 play: self)
				(= ticks 120)
			)
			(3
				(mab view: 6552 loop: 3 cel: 0 setCycle: End self)
				(PalVary 1 6 0) ; PalVaryReverse
			)
			(4)
			(5
				(gKqMusic1 number: 6550 setLoop: -1 play:)
				(register setCycle: End self)
			)
			(6
				(gEgo setCycle: Beg self)
				(register dispose:)
				(gEgo put: 71 -1) ; Crystal_Shaft
				(gEgo put: 70 -1) ; Tapestry_of_Dreams
				(gKqSound1 number: 6555 setLoop: 1 play:)
			)
			(7
				(gEgo normalize: 6)
				(gMessager say: 1 87 1 1 self) ; "(DISORIENTED)...What? Who are you?"
				(self setScript: rugEntrance self)
			)
			(8
				(gMessager say: 1 87 1 2) ; "(PLEASED THAT MAB IS ALL RIGHT, BUT URGENT)I am Valanice of Daventry, my lady Mab. I urgently need your help. Malicia has ignited the volcaon, and Oberon and Titania cannot be found!"
			)
			(9
				(mab setCycle: End self)
				(gMessager say: 1 87 1 3 self) ; "(ANGRY)Malicia! That vicious creature enchanted me so that she could destroy us all! Well, she won't succeed. You must send the winds to find the King and Queen."
			)
			(10)
			(11
				(gMessager say: 1 87 1 4 self) ; "(UNSURE)I? How am I to do that?"
			)
			(12
				(gMessager say: 1 87 1 5 self) ; "(FIERCE, INTENSE)You must harness the wind Sirocco, and ride him to the top of the Mountain of Winds. King Levanter will surely help you. I must go, brave Valanice. I must try to hold back the volcano's explosion."
				(mab view: 6554 loop: 0 cel: 0 setCycle: End self)
			)
			(13
				(gEgo view: 8075 loop: 0 cel: 0 setCycle: End self)
			)
			(14)
			(15
				(gEgo get: 69 setCycle: Beg self) ; Magic_Bridle
				(mab loop: 1 cel: 0 setCycle: End self)
			)
			(16)
			(17
				(gEgo normalize: 6)
				(mab loop: 2 cel: 0 setCycle: End self)
				(gMessager say: 1 87 1 6 self) ; "(INTENSE)Thank you for freeing me from my prison of ice. If we all survive this, I will send you only sweet dreams for the rest of your life."
			)
			(18)
			(19
				(mab loop: 3 cel: 0 setCycle: End self)
			)
			(20
				(gKqSound1 number: 6556 setLoop: 1 play: self)
				((= register (Prop new:))
					view: 6554
					loop: 4
					cel: 0
					x: (+ (gEgo x:) 5)
					y: (- (gEgo y:) 10)
					fixPriority: 1
					priority: (+ (gEgo priority:) 1)
					init:
					setCycle: End self
				)
				(gKqMusic1 fade: 0 4 2 1)
				(= cycles 1)
			)
			(21
				(gEgo hide:)
			)
			(22
				(register hide:)
			)
			(23
				(gCurRoom newRoom: 6250)
			)
		)
	)
)

(instance mab of Actor
	(properties
		noun 1
		approachX 140
		approachY 112
		x 156
		y 65
		view 6551
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 87 setHotspot: 8 10 87) ; Do, Crystal_Shaft, Do, Exit, Crystal_Shaft
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: touchMab 0 0)
				(return 1)
			)
			(87 ; Crystal_Shaft
				(if (IsFlag 214)
					(gCurRoom setScript: mabWakes)
				else
					(gCurRoom setScript: touchMab 0 1)
				)
				(return 1)
			)
		)
	)
)

(instance win1 of Actor
	(properties
		x 263
		y 52
		view 6550
		cel 9
		cycleSpeed 10
	)
)

(instance win2 of Actor
	(properties
		x 133
		y 52
		view 6550
		loop 1
		cel 8
		cycleSpeed 10
	)
)

(instance win3 of Actor
	(properties
		x 127
		y 13
		view 6550
		loop 2
		cel 8
		cycleSpeed 10
	)
)

(instance rug of Actor
	(properties
		x 137
		y 90
		view 6553
		loop 1
	)
)

