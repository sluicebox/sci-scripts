;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use RFeature)
(use Avoid)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm012 0
)

(local
	local0
	local1
	local2
	[local3 6] = [0 178 59 189 0 189]
	[local9 12] = [96 160 144 167 145 172 98 175 51 170 51 165]
	[local21 8] = [0 109 61 113 62 124 0 124]
	[local29 8] = [0 60 68 65 43 79 0 79]
	[local37 6] = [123 48 143 60 94 60]
	[local43 18] = [319 127 197 135 172 138 123 138 108 123 166 99 251 97 251 40 319 40]
	[local61 10] = [319 189 254 189 284 176 195 156 319 137]
)

(instance rm012 of KQ5Room
	(properties
		picture 12
		horizon 100
		north 13
		east 10
		south 11
		west 14
	)

	(method (init)
		(super init:)
		(= global320 155)
		(= global321 51)
		(= global325 {"Let's go! There isn't anything to do here!"})
		(self setFeatures: anthill setRegions: 202) ; owl
		(switch gPrevRoomNum
			(east
				(gEgo posn: 315 135)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(south
				(gEgo posn: 165 187)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(north
				(gEgo posn: 85 105)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(else
				(gEgo posn: -20 141)
				(HandsOff)
				(self setScript: relievedScript)
			)
		)
		(if (!= ((gInventory at: 6) owner:) 200) ; Brass_Bottle
			(wagon init: stopUpd:)
		)
		(LoadMany rsVIEW 338 325)
		(gEgo ignoreHorizon: 1 illegalBits: 0 init:)
		(if (and (or (gEgo has: 8) (gEgo has: 16)) (not (IsFlag 106))) ; Shoe, Stick
			(LoadMany rsVIEW 332)
			(Load rsSCRIPT 991)
			(if (== (gGame detailLevel:) 3)
				(dog init: setScript: dogScript)
			else
				(dog init: stopUpd:)
			)
			(dogHead setPri: 9 init: hide:)
			(ants2 cycleSpeed: 1)
			(ants3 cycleSpeed: 1)
			(ants4 cycleSpeed: 1)
			(ants5 cycleSpeed: 1)
			(gGlobalSound number: 14 loop: -1 vol: 127 playBed:)
		else
			(gGlobalSound number: 13 loop: -1 vol: 127 playBed:)
		)
		(ants1 setCycle: Fwd init:)
		(ants2 setCycle: Fwd init:)
		(ants3 setCycle: Fwd init:)
		(ants4 setCycle: Fwd init:)
		(ants5 setCycle: Fwd init:)
		(poly1 points: @local3 size: 3)
		(poly2 points: @local9 size: 6)
		(poly3 points: @local21 size: 4)
		(poly4 points: @local29 size: 4)
		(poly5 points: @local37 size: 3)
		(poly6 points: @local43 size: 9)
		(poly7 points: @local61 size: 5)
		(self addObstacle: poly1 poly2 poly3 poly4 poly5 poly6 poly7)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo edgeHit:)
					(= local0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				(if (== local0 (gCurRoom west:))
					(self setScript: goingToDesert)
				else
					(gGlobalSound fade:)
					((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				)
			)
			(
				(and
					(< 169 (gEgo x:) 231)
					(< 81 (gEgo y:) 140)
					(or
						(< (gEgo distanceTo: ants1) 10)
						(< (gEgo distanceTo: ants2) 10)
						(< (gEgo distanceTo: ants3) 10)
						(< (gEgo distanceTo: ants4) 10)
						(< (gEgo distanceTo: ants5) 10)
					)
				)
				(HandsOff)
				(self setScript: antDance)
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
		(DisposeScript 991)
		(DisposeScript 985)
		(DisposeScript 970)
		(DisposeScript 951)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gGlobalSound fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance warnScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(PrintDC 12 0 #at 20 10 #time 7) ; "A bully of a dog terrorizes the poor ants as he digs up their large anthill."
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance relievedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(gEgo setMotion: MoveTo 7 141 self)
			)
			(2
				(proc0_28 75 12 1 67 20 100 25 5) ; "Well, there you are! I was starting to get concerned!"
				(proc0_28 160 12 2 67 20 20 25 5) ; "Don't worry about me, Cedric. I'm used to this kind of thing."
				(= cycles 1)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance antDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) hide:)
				(gEgo
					view: 338
					setLoop: 0
					normal: 0
					cel: 0
					setStep: 1 1
					setMotion: MoveTo 188 145
					setCycle: End self
				)
			)
			(1
				(gEgo cycleSpeed: 5 cel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gEgo cel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(cls)
				(gEgo cel: 0 setLoop: 3 setCycle: End self)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo
					view: 0
					setCel: -1
					normal: 1
					setLoop: -1
					setStep: 3 2
					setCycle: KQ5SyncWalk
				)
				(= cycles 1)
			)
			(6
				(gEgo loop: 2)
				((gEgo head:) show:)
				(= cycles 5)
			)
			(7
				(proc0_28 75 12 3 67 10 10 25 4) ; "Is that a new dance, Graham? The BUG-a-loo?"
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance throwStick of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if (and (>= state 10) (not (User canInput:)) (not (User controls:)))
			(= temp1 ((= temp0 (Event new:)) type:))
			(if (OneOf temp1 1 4)
				(= seconds 0)
				(= cycles 1)
			)
			(temp0 dispose:)
		)
		(if (and (== state 1) (== (gEgo cel:) 8))
			(stick
				setLoop:
					(switch local2
						(2
							(+ 14 (gEgo loop:))
						)
						(3
							(+ 10 (gEgo loop:))
						)
						(0
							(+ 4 (gEgo loop:))
						)
					)
				x:
					(if (< (gEgo x:) 181)
						(+ (gEgo x:) 24)
					else
						(- (gEgo x:) 23)
					)
				y: (- (gEgo y:) 15)
				setCycle: Walk
				setPri: (gEgo priority:)
				setMotion: JumpTo 120 138 self
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					(
						(or
							(& (gEgo onControl: 0) $0004)
							(& (gEgo onControl: 0) $0010)
						)
						(gEgo setMotion: PolyPath 200 161 self)
					)
					((& (gEgo onControl: 0) $0002)
						(= cycles 1)
					)
					(else
						(gEgo setMotion: PolyPath 23 136 self)
					)
				)
			)
			(1
				(PrintDC 12 4 #at 100 10 #dispose) ; "Here, boy!"
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 296
					loop: (if (< (gEgo x:) 151) 0 else 1)
					cel: 0
					setCycle: End self
				)
				(stick
					setLoop:
						(switch local2
							(2
								(+ 12 (gEgo loop:))
							)
							(3
								(+ 8 (gEgo loop:))
							)
							(0
								(+ 2 (gEgo loop:))
							)
						)
					view: (gEgo view:)
					x: (gEgo x:)
					y: (gEgo y:)
					cel: 0
					setCycle: End
					cycleSpeed: (gEgo cycleSpeed:)
					init:
				)
			)
			(2)
			(3
				(gEgo normal: 1 view: 0 setCycle: KQ5SyncWalk)
				((gEgo head:) show:)
				(proc0_7 gEgo stick)
				(stick setPri: -1 cel: 6 stopUpd:)
				(dog setScript: 0)
				(dogScript client: 0)
				(= cycles 1)
			)
			(4
				(dogHead dispose:)
				(dog
					setStep: 4 4
					setLoop: 5
					setCycle: Walk
					cycleSpeed: 0
					moveSpeed: 0
					ignoreActors: 1
					setMotion: MoveTo 135 143 self
				)
				(gGlobalSound3 number: 861 loop: 1 vol: 127 play:)
			)
			(5
				(dog view: 332 posn: 129 146 setLoop: 0 setCycle: CT 5 1 self)
				(gGlobalSound3 number: 861 loop: 1 vol: 127 play:)
			)
			(6
				(cls)
				(stick dispose:)
				(dog setCycle: End self)
				(gGlobalSound3 number: 861 loop: 1 vol: 127 play:)
			)
			(7
				(dog
					view: 330
					ignoreActors: 0
					setLoop: 4
					illegalBits: $8000
					setCycle: Walk
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setMotion: MoveTo -45 143 self
				)
				(gGlobalSound fade:)
			)
			(8
				(dog dispose:)
				(gEgo setMotion: PolyPath 185 142 self)
			)
			(9
				(gGlobalSound3 stop:)
				(ants2 cycleSpeed: 2)
				(ants3 cycleSpeed: 2)
				(ants4 cycleSpeed: 2)
				(ants5 cycleSpeed: 2)
				(proc0_7 gEgo cloud 5)
				(cloud init: setCycle: End self)
			)
			(10
				(cloud hide:)
				(kingAnt init:)
				(wAnt
					view: 325
					loop: 1
					cel: 4
					setPri: 14
					ignoreActors: 1
					posn: 211 24
					init:
					setScript: (moveScript new:)
				)
				(eAnt
					view: 325
					loop: 2
					cel: 4
					setPri: 14
					ignoreActors: 1
					posn: 244 26
					init:
					setScript: (moveScript new:)
				)
				(theMouth
					view: 325
					loop: 3
					cel: 7
					posn: 230 52
					setPri: 14
					init:
					setCycle: Fwd
				)
				(blink init: setScript: (moveScript new:))
				(wArm init: setScript: (moveScript new:))
				(eArm init: setScript: (moveScript new:))
				(RedrawCast)
				(gGlobalSound number: 63 loop: -1 vol: 127 play:)
				(PrintDC 12 5 #at 20 20 #width 140 #dispose) ; "Allow me to introduce myself. I'm King Antony the Great. May I ask who you are?"
				(= seconds 7)
			)
			(11
				(cls)
				(wArm setScript: 0)
				(eArm setScript: 0)
				(theMouth setCycle: 0)
				(RedrawCast)
				(proc0_28 160 12 6 67 15 70 25 20 70 280) ; "Why certainly. I'm King Graham of Daventry and this is my friend, Cedric. We're seeking a way to cross the Great Mountains to the ocean on the other side."
				(RedrawCast)
				(= cycles 1)
			)
			(12
				(PrintDC 12 7 #at 10 10 #width 140 #dispose) ; "That is a very perilous undertaking. I wish you would reconsider. But if you shall not, in return for rescuing our home from that flea-bitten cur I wish to offer you our help if perchance you may ever need it."
				(wArm setScript: (moveScript new:))
				(eArm setScript: (moveScript new:))
				(theMouth setCycle: Fwd)
				(= seconds 12)
			)
			(13
				(cls)
				(wArm setScript: 0)
				(eArm setScript: 0)
				(theMouth setCycle: 0)
				(RedrawCast)
				(proc0_28 160 12 8 67 15 80 70 280 25 15) ; "Thank you very much, King Antony. Cedric and I appreciate your kind offer. We look forward to meeting you again."
				(cloud show: setCycle: Beg)
				(kingAnt dispose:)
				(theMouth dispose:)
				(dogHead dispose:)
				(wAnt dispose:)
				(eAnt dispose:)
				(wArm dispose:)
				(eArm dispose:)
				(blink dispose:)
				(cls)
				(= cycles 3)
			)
			(14
				(= global322 50)
				(gGlobalSound fade:)
				(= cycles 20)
			)
			(15
				(SetFlag 106)
				(gGlobalSound number: 13 loop: -1 vol: 127 playBed:)
				(HandsOn)
				(gEgo setStep: 3 2)
				(client setScript: 0)
				(dog setAvoider: 0 dispose:)
			)
		)
	)
)

(instance dogScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dogHead hide:)
				(dog loop: 6 setCycle: Fwd)
				(= seconds (Random 3 8))
			)
			(1
				(dogHead show: loop: 3 cycleSpeed: 4 setCycle: Fwd)
				(dog loop: 0)
				(self cue:)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance growlAtEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not register)
					(++ register)
					(cls)
					(proc0_28 75 12 9 67 20 20 25 7) ; "Oh, Graham! That dog looks mean! I don't like dogs!"
				)
				(dog loop: 0)
				(dogHead show: loop: 1 cel: 0 cycleSpeed: 4 setCycle: End self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 330
					x:
						(if (< (gEgo x:) (dog x:))
							(- (gEgo x:) 7)
						else
							(+ (gEgo x:) 7)
						)
					y: (+ (gEgo y:) 1)
					loop: (if (< (gEgo x:) (dog x:)) 7 else 8)
					cel: 0
					setMotion: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(2
				(gEgo
					normal: 1
					view: 0
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
					setLoop: -1
					loop: (if (== (gEgo loop:) 7) 0 else 1)
				)
				(= cycles 1)
				((gEgo head:) show:)
				(dogHead setCycle: Beg self)
			)
			(3
				(= seconds 2)
			)
			(4
				(gEgo
					normal: 1
					view: 0
					setCycle: KQ5SyncWalk
					setLoop: -1
					loop: 0
				)
				((gEgo head:) show:)
				(if (> (gGame detailLevel:) 0)
					(dog setScript: dogScript)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance moveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= cycles 10)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(= state -1)
				(= seconds (Random 3 10))
			)
		)
	)
)

(instance anthill of RFeature
	(properties
		nsTop 82
		nsLeft 173
		nsBottom 127
		nsRight 245
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
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 12 10) ; "A colony of large ants parade up and down a huge anthill built amid some scrubby bushes."
					(event claimed: 1)
				)
				(5 ; Talk
					(PrintDC 12 11) ; "The ants are too busy to engage in conversation with Graham."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 12 12) ; "The ants don't seem to take kindly to uninvited trespassing."
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(16
							(PrintDC 12 13) ; "The ants aren't interested in it."
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 12 13) ; "The ants aren't interested in it."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance dogHead of Prop
	(properties
		x 230
		y 123
		view 330
		loop 3
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== (gGlobalSound3 prevSignal:) -1)
				(== cel 1)
				(!= ((gInventory at: 16) owner:) 12) ; Stick
			)
			(gGlobalSound3
				number: (if (== (self loop:) 1) 863 else 861)
				loop: 1
				vol: 127
				play:
			)
		)
	)
)

(instance dog of Actor
	(properties
		x 243
		y 130
		view 330
		loop 6
		cycleSpeed 1
		detailLevel 3
		illegalBits 0
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((and script (== cel 1) (!= ((gInventory at: 16) owner:) 12)) ; Stick
				(gGlobalSound3 number: 862 loop: 1 vol: 127 play:)
			)
			((gCurRoom script:) 0)
			((not local1)
				(= local1 1)
				(HandsOff)
				(gCurRoom setScript: warnScript)
			)
			(
				(and
					(< (gEgo distanceTo: self) 50)
					(not (& (gEgo onControl: 0) $0010))
				)
				(HandsOff)
				(self setScript: 0)
				(gCurRoom setScript: growlAtEgoScript)
			)
		)
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
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 12 14) ; "A mangy old dog digs playfully at the huge anthill while the poor ants scurry frantically around."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 12 15) ; "The dog doesn't seem to be a friendly sort at all!"
					(event claimed: 1)
				)
				(5 ; Talk
					(PrintDC 12 16) ; "The dog doesn't pay any attention to Graham."
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(16
							(gTheIconBar enable:)
							(User canControl: 0)
							(gEgo put: 16 12) ; Stick
							(= local2 0)
							(SetScore 4)
							(gCurRoom setScript: throwStick)
							(event claimed: 1)
						)
						(8
							(gTheIconBar enable:)
							(User canControl: 0)
							(SetScore 4)
							(gEgo put: 8 12) ; Shoe
							(= local2 2)
							(gCurRoom setScript: throwStick)
							(event claimed: 1)
						)
						(19
							(gTheIconBar enable:)
							(User canControl: 0)
							(gEgo put: 19 12) ; Leg_of_Lamb
							(= local2 3)
							(gCurRoom setScript: throwStick)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 12 17) ; "That wouldn't divert the dog's attention from the anthill."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance wagon of Prop
	(properties
		x 75
		y 37
		view 328
		loop 5
		signal 1
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
			(cls)
			(switch (event message:)
				(2 ; Look
					(PrintDC 12 18) ; "A gypsy wagon can be seen in the distance to the north."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance wAnt of Prop
	(properties)
)

(instance eAnt of Prop
	(properties)
)

(instance theMouth of Prop
	(properties)
)

(instance kingAnt of Prop
	(properties
		x 231
		y 80
		view 325
		priority 13
		signal 17
	)
)

(instance stick of Actor
	(properties
		view 296
		signal 24576
	)
)

(instance blink of Prop
	(properties
		x 229
		y 43
		view 325
		loop 4
		priority 14
		signal 16
	)
)

(instance wArm of Prop
	(properties
		x 211
		y 69
		view 325
		loop 5
		cel 6
		priority 14
		signal 16
	)
)

(instance eArm of Prop
	(properties
		x 256
		y 74
		view 325
		loop 6
		cel 6
		priority 14
		signal 16
	)
)

(instance ants1 of Prop
	(properties
		x 221
		y 128
		view 328
		priority 9
		signal 16
		cycleSpeed 2
	)
)

(instance ants2 of Prop
	(properties
		x 179
		y 129
		view 328
		loop 1
		priority 9
		signal 16
		cycleSpeed 2
	)
)

(instance ants3 of Prop
	(properties
		x 191
		y 130
		view 328
		loop 2
		priority 9
		signal 16
		cycleSpeed 2
	)
)

(instance ants4 of Prop
	(properties
		x 192
		y 91
		view 328
		loop 3
		priority 9
		signal 16
		cycleSpeed 2
	)
)

(instance ants5 of Prop
	(properties
		x 194
		y 126
		view 328
		loop 4
		priority 9
		signal 16
		cycleSpeed 2
	)
)

(instance cloud of Prop
	(properties
		x 231
		y 52
		view 214
		priority 12
		signal 16
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

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly6 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly7 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance goingToDesert of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo loop: 1)
				(proc0_28 75 12 19 67 10 10 25 10) ; "There's nothing but a hot, dry desert further west. Most people avoid it, because there are bandits out there! If you insist on going, I'll wait for you HERE!"
				(= cycles 1)
			)
			(1
				(gGlobalSound fade:)
				(HandsOn)
				(gCurRoom newRoom: local0)
			)
		)
	)
)

