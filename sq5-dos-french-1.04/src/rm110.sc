;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use starCon)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm110 0
)

(local
	[local0 160] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 9 9 9 9 9 9 9]
)

(instance rm110 of Rm
	(properties
		style -32758
	)

	(method (init)
		(self setRegions: 109) ; starCon
		(super init:)
		(LoadMany rsVIEW 107 105)
		(LoadMany rsSOUND 104 106 105 107 108 109 110)
		(self setScript: sDoAll)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance simulator of Actor
	(properties
		x 61
		y 55
		view 105
		loop 6
		priority 1
		signal 16400
	)
)

(instance top1 of Actor
	(properties
		x 110
		y 1
		view 105
		loop 1
		priority 11
		signal 16400
	)
)

(instance leftTop of Actor
	(properties
		x 89
		y 1
		view 105
		loop 1
		cel 3
		priority 12
		signal 16400
	)
)

(instance rightTop of Actor
	(properties
		x 148
		y -1
		view 105
		loop 1
		cel 1
		priority 12
		signal 16400
	)
)

(instance bottomLeft of Actor
	(properties
		x 91
		y 64
		view 105
		loop 1
		cel 4
		priority 12
		signal 16400
	)
)

(instance bottomRight of Actor
	(properties
		x 143
		y 64
		view 105
		loop 1
		cel 2
		priority 12
		signal 16400
	)
)

(instance leftLight of Actor
	(properties
		x 139
		y 49
		view 105
		loop 2
		priority 12
		signal 16400
		cycleSpeed 0
	)

	(method (doit)
		(super doit:)
		(switch (self cel:)
			(1
				(Palette palSET_INTENSITY 0 219 100)
			)
			(2
				(Palette palSET_INTENSITY 0 219 85)
			)
		)
	)
)

(instance chair of View
	(properties
		x 128
		y 87
		view 105
		loop 5
		priority 14
		signal 16400
	)
)

(instance rightLight of Actor
	(properties
		x 160
		y 49
		view 105
		loop 3
		priority 12
		signal 16400
		cycleSpeed 0
	)
)

(instance mouse1 of Actor
	(properties
		x 147
		y 116
		yStep 7
		view 107
		cel 3
		priority 15
		signal 24592
		xStep 7
	)
)

(instance mouse2 of Actor
	(properties
		x 105
		y 113
		yStep 7
		view 107
		loop 2
		cel 4
		priority 15
		signal 24592
		xStep 7
	)
)

(instance mouse3 of Actor
	(properties
		x 107
		y 116
		yStep 7
		view 107
		loop 1
		cel 3
		priority 15
		signal 24592
		xStep 7
	)
)

(instance mouse4 of Actor
	(properties
		x 72
		y 122
		yStep 7
		view 107
		loop 3
		cel 4
		priority 15
		signal 24592
		xStep 7
	)
)

(instance mouse5 of Actor
	(properties
		x 205
		y 104
		yStep 7
		view 107
		loop 1
		priority 15
		signal 24592
		xStep 7
	)
)

(instance mouse6 of Actor
	(properties
		x 196
		y 113
		yStep 7
		view 107
		loop 1
		priority 15
		signal 24592
		xStep 7
	)
)

(instance mouse7 of Actor
	(properties
		x 174
		y 121
		yStep 7
		view 107
		loop 3
		cel 2
		priority 15
		signal 24592
		xStep 7
	)
)

(instance mouse8 of Actor
	(properties
		x 200
		y 119
		yStep 7
		view 107
		loop 1
		cel 3
		priority 15
		signal 24592
		xStep 7
	)
)

(instance bigRat of Prop
	(properties
		x 256
		y 167
		view 106
		priority 15
		signal 16
	)
)

(instance sDoAll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 0)
				(= seconds 2)
			)
			(1
				(DrawPic 20)
				(simulator init:)
				(bigRat init:)
				(rightLight init: setLoop: 3 setCycle: Fwd)
				(leftLight init: setLoop: 2 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(gSq5Music2 number: 104 priority: 0 setLoop: -1 play:)
				(gSq5Music1 number: 106 priority: 15 setLoop: 1 play: self)
				(Palette palSET_FLAG 0 254 10)
				(Palette palSET_FROM_RESOURCE 600 2)
				(gGame handsOff:)
			)
			(3
				(gSq5Music1 flags: 1 priority: 4 number: 105 setLoop: -1 play:)
				(= seconds 5)
			)
			(4
				(gSq5Music2 number: 107 setLoop: 1 play:)
				(rightLight
					cycleSpeed: 0
					moveSpeed: 0
					setLoop: 3
					setMotion: MoveTo 160 80
				)
				(leftLight
					cycleSpeed: 0
					moveSpeed: 0
					setLoop: 2
					setMotion: MoveTo 139 80
				)
				(simulator
					cycleSpeed: 0
					moveSpeed: 0
					setLoop: 6
					setCel: 0
					setMotion: MoveTo 61 79 self
				)
			)
			(5
				(leftLight dispose:)
				(rightLight dispose:)
				(theMusic3 stop:)
				(PalVary pvINIT 600 3)
				(gSq5Music1 number: 109 setLoop: 1 play:)
				(= seconds 4)
			)
			(6
				(PalVary pvUNINIT)
				(Palette palSET_FROM_RESOURCE 600 2)
				(= cycles 2)
			)
			(7
				(PalVary pvINIT 602 3)
				(gEgo
					view: 105
					loop: 4
					cel: 0
					posn: 149 98
					signal: 16400
					priority: 1
					init:
				)
				(top1
					setLoop: 1
					setCel: 0
					init:
					posn: 110 25
					setMotion: MoveTo 110 1 self
				)
				(rightTop
					setLoop: 1
					setCel: 1
					init:
					posn: 148 23
					setMotion: MoveTo 171 7
				)
				(leftTop
					setLoop: 1
					setCel: 3
					init:
					posn: 89 22
					setMotion: MoveTo 70 8
				)
				(bottomRight
					setLoop: 1
					setCel: 2
					init:
					posn: 143 88
					setMotion: MoveTo 167 88
				)
				(simulator setLoop: 0 setCel: 0)
				(bottomLeft
					setLoop: 1
					setCel: 4
					init:
					posn: 91 88
					setMotion: MoveTo 64 86
				)
				(simulator stopUpd:)
				(bigRat setCycle: End)
				(gSq5Music1 number: 108 setLoop: 1 play:)
			)
			(8
				(gSq5Music2 number: 110 setLoop: 1 play:)
				(mouse1 init: setScript: sMouse1Go)
				(mouse2 init: setScript: sMouse2Go)
				(mouse3 init: setScript: sMouse3Go)
				(mouse4 init: setScript: sMouse4Go)
				(mouse5 init: setScript: sMouse5Go)
				(mouse6 init: setScript: sMouse6Go)
				(mouse7 init: setScript: sMouse7Go)
				(mouse8 init: setScript: sMouse8Go)
				(= seconds 4)
			)
			(9
				(top1 addToPic:)
				(bottomLeft addToPic:)
				(bottomRight addToPic:)
				(rightTop addToPic:)
				(gEgo cel: 0 setCycle: End self)
			)
			(10
				(chair init: stopUpd:)
				(NormalEgo 1 2)
				(gEgo posn: 148 110 setScale: 173 setPri: 15 setLoop: 2)
				(PalVary pvUNINIT)
				(= cycles 1)
			)
			(11
				(gSq5Music2 stop:)
				(gMessager say: 1 0 0 0 self) ; "His illusions of spacefaring grandeur cruelly shattered by Captain Quirk, Roger Wilco exits from the bridge simulator into the hallways of the Star Confederacy Space Academy, where he has enrolled himself in an attempt to realize his life-long dream of becoming a starship captain."
			)
			(12
				(gSq5Music2 number: 4 setLoop: -1 play:)
				(gEgo setLoop: 2 looper: 0 setMotion: MoveTo 90 235 self)
			)
			(13
				(starCon setScript: (ScriptID 109 1)) ; sTestTimer
				(gEgo get: 0) ; Buckazoids
				(gSq5Music2 fade: 0 10 10 1)
				(gSq5Music1 stop:)
				(= seconds 2)
			)
			(14
				(gCurRoom newRoom: 122)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMouse1Go of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(mouse1
					setMotion: MoveTo 92 189 self
					setCycle: Fwd
					setLoop: 0
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(2
				(mouse1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMouse2Go of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(client
					setMotion: MoveTo 64 112 self
					setCycle: Fwd
					setLoop: 2
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(2
				(client
					setMotion: MoveTo 29 117 self
					setCycle: Fwd
					setLoop: 2
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(3
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMouse3Go of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(client
					setMotion: MoveTo 115 120 self
					setCycle: Fwd
					setLoop: 0
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(2
				(client
					setMotion: MoveTo 111 135 self
					setCycle: Fwd
					setLoop: 4
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(3
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMouse4Go of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(client
					setMotion: MoveTo 60 130 self
					setCycle: Fwd
					setLoop: 3
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(2
				(client
					setMotion: MoveTo 81 156 self
					setCycle: Fwd
					setLoop: 3
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(3
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMouse5Go of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(client
					setMotion: MoveTo 219 109 self
					setCycle: Fwd
					setLoop: 1
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(2
				(client
					setMotion: MoveTo 269 119 self
					setCycle: Fwd
					setLoop: 1
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(3
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMouse6Go of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(client
					setMotion: MoveTo 270 118 self
					setCycle: Fwd
					setLoop: 1
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(2
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMouse7Go of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(client
					setMotion: MoveTo 186 135 self
					setCycle: Fwd
					setLoop: 1
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(2
				(client
					setMotion: MoveTo 173 157 self
					setCycle: Fwd
					setLoop: 1
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(3
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMouse8Go of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(client
					setMotion: MoveTo 238 125 self
					setCycle: Fwd
					setLoop: 1
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(2
				(client
					setMotion: MoveTo 238 126 self
					setCycle: Fwd
					setLoop: 2
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(3
				(client
					setMotion: MoveTo 218 133 self
					setCycle: Fwd
					setLoop: 2
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(4
				(client
					setMotion: MoveTo 176 129 self
					setCycle: Fwd
					setLoop: 2
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(5
				(client
					setMotion: MoveTo 176 132 self
					setCycle: Fwd
					setLoop: 3
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(6
				(client
					setMotion: MoveTo 173 154 self
					setCycle: Fwd
					setLoop: 3
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 15 15
				)
			)
			(7
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

