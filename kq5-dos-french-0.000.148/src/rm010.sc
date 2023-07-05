;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm010 0
)

(local
	[local0 18] = [0 142 97 142 113 151 107 161 115 168 108 179 95 182 95 189 0 189]
	[local18 8] = [153 189 120 139 319 133 319 189]
	[local26 24] = [319 101 250 99 268 65 254 65 262 52 245 51 245 48 248 44 264 35 278 35 288 0 319 0]
	[local50 40] = [0 0 128 0 127 34 161 29 250 26 242 53 240 88 205 90 204 93 200 96 180 98 142 98 137 90 121 88 119 96 69 100 56 90 35 93 27 85 0 93]
	local90
	local91
	local92
)

(procedure (localproc_0 param1 param2) ; UNUSED
	(if (< argc 2)
		(= param2 5)
	)
	(OnControl
		CONTROL
		(- (param1 x:) param2)
		(- (param1 y:) param2)
		(+ (param1 x:) param2)
		(+ (param1 y:) param2)
	)
)

(instance rm010 of KQ5Room
	(properties
		picture 10
		horizon 70
		north 9
		east 7
		south 27
		west 12
	)

	(method (init)
		(super init:)
		(= global320 195)
		(= global321 36)
		(= global325
			{"Let's get a move-on, Graham. There isn't anything here."}
		)
		(self setRegions: 202) ; owl
		(gGlobalSound number: 24 loop: -1 play:)
		(= local92 (gEgo illegalBits:))
		(switch gPrevRoomNum
			(west
				(gEgo posn: 15 110)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(east
				(gEgo posn: 310 110)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(north
				(gEgo posn: 246 75)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(south
				(gEgo posn: 150 186)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(else
				(gEgo posn: 5 110)
			)
		)
		(gEgo view: 0 illegalBits: -32768 ignoreHorizon: 1 init:)
		(if (!= ((gInventory at: 9) owner:) 9) ; Heart
			(= local90 1)
			(gAddToPics add: wTree)
		)
		(gAddToPics add: stool doit:)
		(if (!= ((gInventory at: 15) owner:) 10) ; Spinning_Wheel
			(self setFeatures: RPuppet)
			(gGlobalSound2 number: 21 loop: -1 play:)
			(oldGnome setScript: smoke init:)
			(youngGnome setScript: boyScript init:)
		)
		(self setFeatures: stool wind door house lake)
		(poly1 points: @local0 size: 9)
		(poly2 points: @local18 size: 4)
		(poly3 points: @local26 size: 12)
		(poly4 points: @local50 size: 20)
		(self addObstacle: poly1 poly2 poly3 poly4)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
				(self setScript: (ScriptID 202 2)) ; stdWalkOut
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(gEgo illegalBits: local92)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gGlobalSound2 fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance smoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oldGnome cycleSpeed: 2 cel: 0 loop: 0 setCycle: End)
				(= seconds (Random 5 10))
				(if (< (Random 0 100) 50)
					(= state 1)
				)
			)
			(1
				(oldGnome loop: 7 cel: 0 setCycle: End)
				(= seconds (Random 5 10))
				(if (< (Random 0 100) 50)
					(= state -1)
				)
			)
			(2
				(oldGnome loop: 8 cel: 0 setCycle: End)
				(= seconds (Random 5 10))
				(if (< (Random 0 100) 50)
					(= state 0)
				)
			)
			(3
				(oldGnome loop: 10 cel: 0 setCycle: End)
				(= seconds (Random 5 10))
			)
			(4
				(oldGnome loop: 9 cel: 0 setCycle: End)
				(= seconds (Random 5 10))
				(if (< (Random 0 100) 50)
					(= state 3)
				)
			)
			(5
				(oldGnome loop: 10 cel: 5 setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance giveWheel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound2 number: 22 loop: -1 play:)
				(gEgo setMotion: PolyPath 228 96 self)
			)
			(1
				(proc0_7 gEgo oldGnome 5)
				(oldGnome
					cycleSpeed: 0
					loop: 3
					cel: 0
					setCycle: End self
					setScript: 0
				)
			)
			(2
				(oldGnome loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(oldGnome loop: 6 cel: 0 setCycle: End self)
			)
			(4
				(oldGnome setCycle: Beg self)
			)
			(5
				(proc0_28 81 10 0 67 10 10 25 8) ; "Where did you git this? I thought I had lost it."
				(RedrawCast)
				(proc0_28 160 10 1 67 10 90 25 8) ; "Oh, is it yours? I found it in the old witch's house in the Dark Forest."
				(RedrawCast)
				(proc0_28 81 10 2 67 10 10 25 12) ; "So that's where it got to...the old hag took it, eh? You know, this ain't no ordinary spinning wheel."
				(RedrawCast)
				(proc0_28 160 10 3 67 10 90 25 7) ; "It's not? What's so special about it?"
				(RedrawCast)
				(proc0_28 81 10 4 67 10 10 25 12) ; "Why, this spinning wheel can spin straw into GOLD, that's what! 'Cept...you gotta know how to use it."
				(RedrawCast)
				(proc0_28 81 10 5 67 10 10 25 12) ; "I doubt even the witch could figger that out. Thankee for bringin' it back to me."
				(RedrawCast)
				(proc0_28 160 10 6 67 10 80 25 15) ; "Wait! Not so fast! How about that marionette? Don't you think the price of the spinning wheel is worth at least twice that of the puppet? I'd love to have it."
				(youngGnome setScript: 0 loop: 4 cel: 0 setCycle: End self)
			)
			(6
				(proc0_28 81 10 7 67 10 10 25 10) ; "Yeah...I guess so. Boy! Give that there marionette to the man here. I'll make ya a new one."
				(youngGnome loop: 5 cel: 0 setCycle: End self)
			)
			(7
				(youngGnome loop: 6 cel: 0 setCycle: End self)
			)
			(8
				(gEgo setMotion: MoveTo 170 100 self)
			)
			(9
				(proc0_7 gEgo youngGnome 5)
				(youngGnome loop: 7 cel: 0 setCycle: End self)
				(RPuppet dispose:)
				(gEgo get: 12) ; Marionette
			)
			(10
				(cls)
				(youngGnome loop: 8 cel: 0 setCycle: End self)
			)
			(11
				(proc0_28 81 10 8 67 10 10 25 9) ; "Come on, boy. Let's go gather up some wood for a new puppet."
				(youngGnome
					view: 282
					cycleSpeed: 1
					setCycle: Walk
					illegalBits: 0
					moveSpeed: 1
					setMotion: MoveTo 340 110 self
				)
				(oldGnome
					view: 282
					setCycle: Walk
					illegalBits: 0
					moveSpeed: 1
					cycleSpeed: 1
					setLoop: 2
					setMotion: MoveTo 360 110 self
				)
			)
			(12)
			(13
				(gGlobalSound2 fade:)
				(oldGnome dispose:)
				(youngGnome dispose:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance boyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(youngGnome loop: 0 cycleSpeed: 2 cel: 0 setCycle: End self)
			)
			(1
				(youngGnome loop: 1 cel: 0 setCycle: End self)
				(= state (- (Random 0 3) 1))
			)
			(2
				(youngGnome loop: 2 cel: 0 setCycle: End self)
				(= state (- (Random 0 3) 1))
			)
			(3
				(youngGnome loop: 3 cel: 0 setCycle: End self)
				(= state (- (Random 0 3) 1))
			)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 229 99 self)
			)
			(1
				(proc0_7 gEgo oldGnome 5)
				((gEgo head:) cel: 6)
				(oldGnome setScript: 0)
				(= cycles 2)
			)
			(2
				(proc0_28 160 10 9 67 10 90 25 3) ; "Excuse me, sir..."
				(RedrawCast)
				(proc0_28 81 10 10 67 10 10 25 8) ; "What're you doin' here? Don't you know this is private property?"
				(RedrawCast)
				(proc0_28 160 10 11 67 10 80 25 8) ; "Oh! I'm terribly sorry to bother you. I was just noticing your son's marionette. It's very interesting. Where did you get it?"
				(RedrawCast)
				(proc0_28 81 10 12 67 10 10 25 8) ; "It's grandson, not son...and I made it fer him. Why d'ya care?"
				(RedrawCast)
				(proc0_28 160 10 13 67 10 90 25 9) ; "I just wanted to comment on its artistry. It's very well done. I don't suppose it could be bought?"
				(RedrawCast)
				(proc0_28 81 10 14 67 10 10 25 14) ; "If it could, the price would be very steep; I reckon you couldn't afford it. Now...leave me and my grandson be!"
				(cls)
				(HandsOn)
				(gnomeHead dispose:)
				(oldGnome setScript: smoke)
				(client setScript: 0)
			)
		)
	)
)

(instance shutTight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local91
					(gEgo setMotion: PolyPath 179 100 self)
				else
					(gEgo setMotion: PolyPath 130 95 self)
				)
			)
			(1
				(gEgo loop: 3)
				(= cycles 2)
			)
			(2
				(if local91
					(PrintDC 10 15) ; "Graham attempts to open the little window but finds it bolted shut."
				else
					(PrintDC 10 16) ; "Graham tries to open the small door but finds it locked."
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance door of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 10 17) ; "The entrance to the small house is through a crudely-constructed door."
					(event claimed: 1)
				)
				(3 ; Do
					(if (gCast contains: oldGnome)
						(PrintDC 10 18) ; "Graham has not been invited into the gnomes' home."
					else
						(HandsOff)
						(= local91 0)
						(gCurRoom setScript: shutTight)
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(1
							(PrintDC 10 19) ; "The key won't fit this lock."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance wind of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 10 20) ; "One small, shuttered window fronts the gnome house."
					(event claimed: 1)
				)
				(3 ; Do
					(if (gCast contains: oldGnome)
						(PrintDC 10 21) ; "The shuttered window is closed tight."
					else
						(HandsOff)
						(= local91 1)
						(gCurRoom setScript: shutTight)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance house of RFeature
	(properties
		nsTop 36
		nsLeft 116
		nsBottom 86
		nsRight 195
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 10 22) ; "Utilizing fallen logs, a gnome has built himself a little forest home."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance RPuppet of RFeature
	(properties
		nsTop 78
		nsLeft 148
		nsBottom 94
		nsRight 163
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 10 23) ; "A young gnome happily plays with an exquisite marionette."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 10 24) ; "The marionette belongs to the boy gnome!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance gnomeHead of Prop
	(properties
		x 215
		y 89
		z 17
		view 284
		loop 2
	)
)

(instance oldGnome of Actor
	(properties
		x 214
		y 88
		view 284
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 10 25) ; "An old grandfather gnome sits contentedly on an old stump and smokes a large pipe. He watches his grandson at play."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 10 26) ; "The old gnome seems to ignore Graham."
					(event claimed: 1)
				)
				(5 ; Talk
					(if (not (IsFlag 10))
						(SetFlag 10)
						(gCurRoom setScript: converse)
					else
						(PrintDC 10 27) ; "The old gnome has nothing more to say."
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(15
							(event claimed: 1)
							(gEgo put: 15 10) ; Spinning_Wheel
							(HandsOff)
							(SetScore 4)
							(gCurRoom setScript: giveWheel)
						)
						(28
							(event claimed: 0)
						)
						(else
							(proc0_28 81 10 28) ; "I don't take charity, young man. I got everythin' I need."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance youngGnome of Actor
	(properties
		x 163
		y 96
		view 274
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
				(MousedOn RPuppet event)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 10 29) ; "Sitting on a stool in front of his house, a young gnome happily plays with an exquisite marionette."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 10 30) ; "The young gnome is more interested in his marionette than in Graham."
					(event claimed: 1)
				)
				(5 ; Talk
					(PrintDC 10 31) ; "Graham attempts to speak to the young gnome but the boy seems to be very shy and doesn't answer."
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 10 32) ; "The young gnome is too bashful to respond."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance stool of RPicView
	(properties
		x 164
		y 93
		view 282
		loop 1
	)
)

(instance wTree of RPicView
	(properties
		x 256
		y 16
		view 282
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(event claimed: 1)
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance lake of RFeature
	(properties
		nsTop 1
		nsLeft 214
		nsBottom 20
		nsRight 293
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (== local90 1)
						(PrintDC 10 33) ; "In the distance to the north, Graham can see a lovely willow tree surrounded by a small pond."
					else
						(PrintDC 10 34) ; "Graham can see a small pond in the distance to the north."
					)
					(event claimed: 1)
				)
			)
		)
	)
)

