;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 66)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use RFeature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm066 0
)

(local
	[local0 52] = [0 0 319 0 319 189 0 189 0 186 306 186 306 180 263 180 288 161 281 152 269 150 276 154 280 159 268 172 238 176 95 172 95 156 116 146 97 149 84 157 81 172 64 174 65 163 72 155 24 154 0 165]
	local52
	local53
	local54
)

(instance rm066 of KQ5Room
	(properties
		picture 66
		west 65
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 744 745)
		(gEgo view: 0 posn: 10 179 setStep: 3 2 init:)
		(poly1 points: @local0 size: 26)
		(self
			setRegions: 550 ; castle
			addObstacle: poly1
			setFeatures:
				gadget
				((Clone gadget)
					nsLeft: 286
					nsTop: 11
					nsRight: 319
					nsBottom: 148
					yourself:
				)
				machine
		)
		(if (== ((gInventory at: 28) owner:) gCurRoomNum) ; Wand
			(cWand init:)
		)
		(if (== ((gInventory at: 35) owner:) gCurRoomNum) ; Mordack_s_Wand
			(mWand init:)
		)
		(if (== (gGame detailLevel:) 3)
			(steam init: z: 1000 setScript: steamScript)
		)
		(gGlobalSound number: 865 loop: -1 priority: 1 playBed:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(local52
				(if (!= local53 (GetTime 1)) ; SysTime12
					(= local53 (GetTime 1)) ; SysTime12
					(if (not (-- local52))
						(self newRoom: 124) ; battle
					)
				)
			)
			((== global331 3)
				(gCurRoom newRoom: 124) ; battle
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 100])
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
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance steamScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 10 40))
			)
			(1
				(steam z: 0 cel: 0 setCycle: End self)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance putCWandScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo put: 28 gCurRoomNum) ; Wand
				(HandsOff)
				(gEgo setMotion: PolyPath 266 149 self)
			)
			(1
				(if (IsObject (gEgo head:))
					((gEgo head:) hide:)
				)
				(gEgo
					normal: 0
					view: 745
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(if (not (IsFlag 81))
					(SetFlag 81)
					(SetScore 4)
				)
				(cWand init: cel: 0)
				(if (IsFlag 60)
					(cWand setCycle: Fwd)
				)
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(if (IsObject (gEgo head:))
					((gEgo head:) show:)
				)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					loop: 1
					cycleSpeed: 0
					setCycle: SyncWalk
				)
				(HandsOn)
				(= global103 0)
				(if local52
					(User canControl: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance putMWandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 35 gCurRoomNum) ; Mordack_s_Wand
				(HandsOff)
				(gEgo setMotion: PolyPath 116 146 self)
			)
			(1
				(if (IsObject (gEgo head:))
					((gEgo head:) hide:)
				)
				(gEgo
					normal: 0
					view: 745
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(if (not (IsFlag 82))
					(SetFlag 82)
					(SetScore 4)
				)
				(mWand init: setCycle: Fwd)
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(if (IsObject (gEgo head:))
					((gEgo head:) show:)
				)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					loop: 0
					cycleSpeed: 0
					setCycle: SyncWalk
				)
				(HandsOn)
				(= global103 0)
				(if local52
					(User canControl: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance getCWandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 266 149 self)
			)
			(1
				(if (IsObject (gEgo head:))
					((gEgo head:) hide:)
				)
				(gEgo
					normal: 0
					view: 745
					setLoop: 3
					setCel: 16
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(2
				(cWand dispose:)
				(gEgo setLoop: 1 get: 28 setCel: 16 setCycle: Beg self) ; Wand
			)
			(3
				(if (IsObject (gEgo head:))
					((gEgo head:) show:)
				)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					loop: 1
					cycleSpeed: 0
					setCycle: SyncWalk
				)
				(if (IsFlag 60)
					(gCurRoom newRoom: 124) ; battle
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance getMWandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 116 146 self)
			)
			(1
				(if (IsObject (gEgo head:))
					((gEgo head:) hide:)
				)
				(gEgo
					normal: 0
					view: 745
					setLoop: 2
					setCel: 16
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(2
				(mWand dispose:)
				(gEgo setLoop: 0 get: 35 setCel: 16 setCycle: Beg self) ; Mordack_s_Wand
			)
			(3
				(if (IsObject (gEgo head:))
					((gEgo head:) show:)
				)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					loop: 0
					cycleSpeed: 0
					setCycle: SyncWalk
				)
				(HandsOn)
				(= global103 0)
				(if local52
					(User canControl: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance machineScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 32) ; Moldy_Cheese
				(HandsOff)
				(LoadMany rsSOUND 865 866 867 869 870 871 872 873 874 875 876 877)
				(gEgo setMotion: PolyPath 152 175 self)
			)
			(1
				(if (IsObject (gEgo head:))
					((gEgo head:) hide:)
				)
				(gEgo
					normal: 0
					view: 745
					setLoop: 6
					cycleSpeed: 2
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gGame setCursor: gWaitCursor 1)
				(gEgo setCycle: Beg self)
			)
			(3
				(SetScore 5)
				(PrintDC 66 0) ; "Graham tosses the moldy cheese into the machine's bubblingliquid."
				(if (IsObject (gEgo head:))
					((gEgo head:) show:)
				)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					setCycle: SyncWalk
					cycleSpeed: 0
					setMotion: PolyPath 265 178 self
				)
				(gGlobalSound number: 866 loop: -1 playBed:)
			)
			(4
				(gEgo normal: 0 setLoop: 7 setCel: 1)
				((gEgo head:) moveHead: 0 setCel: 6)
				(= cycles 1)
			)
			(5
				(self setScript: flashScript self)
			)
			(6
				(if
					(and
						(== ((gInventory at: 28) owner:) gCurRoomNum) ; Wand
						(== ((gInventory at: 35) owner:) gCurRoomNum) ; Mordack_s_Wand
					)
					(PrintDC 66 1) ; "Mordack's wand now barely glows; perhaps its power has weakened while Crispin's old wand now appears completely energized."
					(cWand setCycle: Fwd)
					(SetFlag 60)
				else
					(PrintDC 66 2) ; "The machine put on quite a show but didn't seem to accomplish anything!"
					(mWand setCycle: Fwd)
				)
				(gEgo normal: 1 setLoop: -1 setCel: -1)
				((gEgo head:) moveHead: 1 setCel: -1)
				(if (IsFlag 60)
					(= local52 15)
					(HandsOn)
					(User canControl: 0)
				else
					(mWand setCycle: 0 dispose:)
					(gCurRoom newRoom: 124) ; battle
				)
				(self dispose:)
			)
		)
	)
)

(instance flashScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound2 number: 875 loop: 1 priority: 2 play: self)
			)
			(1
				(gGlobalSound2 number: 876 loop: -1 play:)
				(glow1 init: setScript: glow1Script)
				(glow2 init: setCycle: End self)
			)
			(2
				(glow2 cel: 0 setCycle: End self)
			)
			(3
				(if (> (++ register) 2)
					(= register 0)
					(= cycles 1)
				else
					(= start 2)
					(self init:)
				)
			)
			(4
				(glow3 init: setCycle: End self)
				(glow3a init:)
				(gGlobalSound3 number: 869 loop: 1 priority: 10 play:)
			)
			(5
				(if (> (++ local54) 1)
					(= cycles 1)
				else
					(= start 2)
					(self init:)
				)
			)
			(6
				(glow13 init: setCycle: End self)
				(gGlobalSound3 number: 871 loop: 1 priority: 10 play:)
			)
			(7
				(glow2 dispose:)
				(glow4 init: setCycle: End self)
			)
			(8
				(glow3 setScript: glow3Script)
				(glow5 init: setCycle: RandCycle)
				(glow6 init: setCycle: RandCycle)
				(glow7 init: setCycle: RandCycle)
				(glow8 init: setCycle: RandCycle)
				(lightningSound number: 870 priority: 4 play:)
				(= seconds 2)
			)
			(9
				(glow5 z: 1000)
				(glow6 z: 1000)
				(glow7 z: 1000)
				(glow8 z: 1000)
				(lightningSound stop:)
				(= seconds 1)
			)
			(10
				(glow5 z: 0)
				(glow6 z: 0)
				(glow7 z: 0)
				(glow8 z: 0)
				(lightningSound number: 870 play:)
				(= seconds 2)
			)
			(11
				(glow5 z: 1000)
				(glow6 z: 1000)
				(glow7 z: 1000)
				(glow8 z: 1000)
				(lightningSound stop:)
				(= seconds 1)
			)
			(12
				(glow5 z: 0)
				(glow6 z: 0)
				(glow7 z: 0)
				(glow8 z: 0)
				(lightningSound number: 870 play:)
				(= seconds 2)
			)
			(13
				(glow5 z: 1000)
				(glow6 z: 1000)
				(glow7 z: 1000)
				(glow8 z: 1000)
				(lightningSound stop:)
				(= seconds 1)
			)
			(14
				(glow0 init:)
				(glow9 init: setScript: glow9Script)
				(glow5 z: 0)
				(glow6 z: 0)
				(glow7 z: 0)
				(glow8 z: 0)
				(lightningSound number: 870 play:)
				(= seconds 2)
			)
			(15
				(mWand setCycle: 0 cel: 0)
				(glow10 init: setCycle: RandCycle)
				(glow11 init: setCycle: RandCycle)
				(glow12 init: setCycle: RandCycle)
				(glow14 init: setCycle: RandCycle)
				(pointySound play:)
				(= seconds 15)
			)
			(16
				(gGlobalSound2 number: 877 loop: 1 play:)
				(glow0 dispose:)
				(glow1 dispose:)
				(= seconds 1)
			)
			(17
				(glow5 dispose:)
				(glow6 dispose:)
				(glow7 dispose:)
				(glow8 dispose:)
				(lightningSound stop:)
				(glow3 dispose:)
				(glow3a dispose:)
				(glow13 dispose:)
				(= seconds 1)
			)
			(18
				(gGlobalSound number: 865 loop: -1 playBed:)
				(glow9 dispose:)
				(glow10 dispose:)
				(glow11 dispose:)
				(glow12 dispose:)
				(glow14 dispose:)
				(pointySound stop:)
				(= seconds 2)
			)
			(19
				(self dispose:)
			)
		)
	)
)

(instance glow1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(glow1 cel: 0 setCycle: End self)
				(glow1Sound number: 867 priority: 3 play:)
			)
			(1
				(self init:)
			)
		)
	)
)

(instance glow3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 2 30))
			)
			(1
				(if (> (Random 0 99) 69)
					(client cel: 0 setCycle: End self)
					(gGlobalSound3 number: 869 loop: 1 priority: 10 play:)
					(= register 1)
				else
					(glow13 cel: 0 setCycle: End self)
					(gGlobalSound3 number: 871 loop: 1 priority: 10 play:)
					(= register 0)
				)
			)
			(2
				(if register
					(glow4 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance glow9Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 8))
			)
			(1
				(client cel: 0 setCycle: End self)
				(glow9Sound number: 874 play:)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance glow9Sound of Sound
	(properties
		number 874
	)
)

(instance glow1Sound of Sound
	(properties
		number 867
	)
)

(instance lightningSound of Sound
	(properties
		number 870
		loop -1
	)
)

(instance pointySound of Sound
	(properties
		number 873
		priority 5
		loop -1
	)
)

(instance glow0 of Actor
	(properties
		x 186
		y 34
		view 744
		priority 4
		signal 26640
		moveSpeed 1
	)

	(method (init)
		(super init:)
		(self y: 34 setCycle: Fwd setMotion: MoveTo (self x:) -10 self)
		(gGlobalSound4 number: 872 loop: 1 play:)
	)

	(method (cue)
		(super cue:)
		(self init:)
	)
)

(instance glow1 of Prop
	(properties
		x 201
		y 109
		view 744
		loop 1
		priority 7
		signal 26640
		cycleSpeed 3
	)
)

(instance glow2 of Prop
	(properties
		x 170
		y 130
		view 744
		loop 2
		priority 9
		signal 26640
	)
)

(instance glow3 of Prop
	(properties
		x 179
		y 86
		view 744
		loop 3
		priority 5
		signal 26640
	)
)

(instance glow3a of Prop
	(properties
		x 185
		y 52
		view 744
		loop 14
		priority 5
		signal 26640
	)

	(method (doit)
		(self cel: (glow3 cel:))
		(super doit:)
	)
)

(instance glow4 of Prop
	(properties
		x 204
		y 60
		view 744
		loop 4
		priority 2
		signal 26640
	)
)

(instance glow5 of Prop
	(properties
		x 130
		y 61
		view 744
		loop 5
		priority 2
		signal 26640
		cycleSpeed 1
	)
)

(instance glow6 of Prop
	(properties
		x 132
		y 68
		view 744
		loop 6
		priority 3
		signal 26640
	)
)

(instance glow7 of Prop
	(properties
		x 244
		y 57
		view 744
		loop 7
		priority 2
		signal 26640
		cycleSpeed 1
	)
)

(instance glow8 of Prop
	(properties
		x 244
		y 69
		view 744
		loop 8
		priority 3
		signal 26640
	)
)

(instance glow9 of Prop
	(properties
		x 92
		y 71
		view 744
		loop 9
		priority 3
		signal 26640
		cycleSpeed 1
	)
)

(instance glow10 of Prop
	(properties
		x 131
		y 119
		view 744
		loop 10
		priority 8
		signal 26640
	)
)

(instance glow11 of Prop
	(properties
		x 246
		y 119
		view 744
		loop 11
		priority 8
		signal 26640
	)
)

(instance glow12 of Prop
	(properties
		x 131
		y 102
		view 744
		loop 12
		priority 12
		signal 26640
	)
)

(instance glow14 of Prop
	(properties
		x 245
		y 101
		view 744
		loop 12
		priority 12
		signal 26640
	)
)

(instance glow13 of Prop
	(properties
		x 188
		y 134
		view 744
		loop 13
		priority 12
		signal 26640
	)
)

(instance steam of Prop
	(properties
		x 208
		y 132
		view 744
		loop 15
		priority 4
		signal 26640
		cycleSpeed 6
	)
)

(instance cWand of Prop
	(properties
		x 245
		y 118
		view 745
		loop 5
		signal 24576
		cycleSpeed 2
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 66 3) ; "Atop the iron platter of the bizarre contraption lies Crispin's wand."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getCWandScript)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance mWand of Prop
	(properties
		x 135
		y 118
		view 745
		loop 4
		signal 24576
		cycleSpeed 2
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 66 4) ; "Upon the iron platter of the strange machine lies Mordack's wand."
					(event claimed: 1)
				)
				(3 ; Do
					(if (IsFlag 60)
						(PrintDC 66 5) ; "Mordack's wand looks dim and powerless. Graham doesn't wantit."
						(event claimed: 1)
					else
						(HandsOff)
						(gCurRoom setScript: getMWandScript)
						(event claimed: 1)
					)
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

(instance gadget of RFeature
	(properties
		nsTop 74
		nsBottom 121
		nsRight 93
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 66 6) ; "Behind Mordack's strange contraption lurk other baffling magical implements."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 66 7) ; "Mordack's other gadgets don't interest Graham."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance machine of RFeature
	(properties
		nsLeft 126
		nsBottom 155
		nsRight 263
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (IsFlag 60)
						(PrintDC 66 8) ; "The strange device has returned to its original placid state. Graham is still awestruck by the incredible display of power he has just witnessed. Mordack obviously is a wizard with extraordinary talents to have harnessed such amazing power."
					else
						(PrintDC 66 9) ; "Graham has no idea what Mordack does with this strange contraption, but it couldn't be good! Inside the lower portion a foul-smelling liquid bubbles while two dangling spiked gizmos hang on a massive yoke above a couple of flat iron platters."
					)
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 66 10) ; "The bizarre machine looks very intimidating and confusing which makes Graham reluctant to touch it; conversely, it also intrigues him."
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(gCurRoom setScript: putCWandScript)
							(event claimed: 1)
						)
						(35
							(gCurRoom setScript: putMWandScript)
							(event claimed: 1)
						)
						(32
							(gCurRoom setScript: machineScript)
							(event claimed: 1)
						)
						(else
							(PrintDC 66 11) ; "Graham hesitates. This may be the wrong thing to do."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

