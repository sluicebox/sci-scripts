;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Interface)
(use n762)
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
	[local71 10] = [1 961 0 962 1 963 0 964 0 0]
	[local81 6] = [0 3049 1 960 0 0]
	[local87 9] = [1022 200 64 2 9 28 29 25 34]
	[local96 9] = [1000 140 25 4 11 24 19 23 30]
	[local105 9] = [1003 170 70 4 11 25 23 31 31]
	[local114 9] = [1003 10 62 4 11 25 23 31 31]
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
		(= global325 3051)
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
			(dog setScript: dogScript init:)
			(dogHead setPri: 9 init: hide:)
			(ants1 setCycle: Fwd init:)
			(ants2 cycleSpeed: 1)
			(ants3 cycleSpeed: 1)
			(ants4 cycleSpeed: 1)
			(ants5 cycleSpeed: 1)
			(gGlobalSound number: 14 loop: -1 vol: 127 playBed:)
		else
			(gGlobalSound number: 13 loop: -1 vol: 127 playBed:)
			(ants1 setCycle: Fwd init:)
		)
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
			((and (not local1) (gCast contains: dog))
				(= local1 1)
				(HandsOff)
				(self setScript: warnScript)
			)
			((= local0 (self edgeToRoom: (gEgo edgeHit:)))
				(if (== local0 (gCurRoom west:))
					(HandsOff)
					(gEgo loop: 1)
					(RedrawCast)
					(proc762_1 @local96 3048)
					(gGlobalSound fade:)
					(HandsOn)
					(gCurRoom newRoom: local0)
				else
					(gGlobalSound fade:)
					((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				)
			)
			(
				(and
					(gCast contains: dog)
					(< (gEgo distanceTo: dog) 50)
					(not (& (gEgo onControl: 0) $0010))
				)
				(HandsOff)
				(dog setScript: 0)
				(self setScript: growlAtEgoScript)
			)
			(
				(or
					(< (gEgo distanceTo: ants1) 10)
					(< (gEgo distanceTo: ants2) 10)
					(< (gEgo distanceTo: ants3) 10)
					(< (gEgo distanceTo: ants4) 10)
					(< (gEgo distanceTo: ants5) 10)
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
				(Say 273)
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
				(proc762_0 @local96 @local114 @local81 self)
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
				(gEgo cel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gEgo cel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(cls)
				(gEgo cel: 0 setLoop: 3 setCycle: End self)
			)
			(4
				(gEgo
					view: 0
					setCel: -1
					normal: 1
					setLoop: -1
					setStep: 3 2
					setCycle: SyncWalk
				)
				((gEgo head:) show:)
				(= cycles 1)
			)
			(5
				(gEgo loop: 2)
				(= cycles 5)
			)
			(6
				(proc762_1 @local96 3052)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance throwStick of Script
	(properties)

	(method (doit &tmp [temp0 2])
		(super doit: &rest)
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
				(Say 969 0 1)
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
				(gEgo normal: 1 view: 0 setCycle: SyncWalk)
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
					illegalBits: -32768
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
				(= cycles 1)
			)
			(10
				(proc762_0 @local105 @local87 @local71 self)
			)
			(11
				(dogHead dispose:)
				(cls)
				(= cycles 3)
			)
			(12
				(= global322 50)
				(gGlobalSound fade:)
				(= cycles 20)
			)
			(13
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
				(dog loop: 0)
				(dogHead show: loop: 3 cel: 0 cycleSpeed: 3 setCycle: End self)
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
					(proc762_1 @local96 3013)
				)
				(dog loop: 0)
				(dogHead show: loop: 1 cel: 0 setCycle: End self)
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
					setCycle: End self
				)
			)
			(2
				(gEgo
					normal: 1
					view: 0
					setCycle: SyncWalk
					setLoop: -1
					loop: (if (== (gEgo loop:) 7) 0 else 1)
				)
				((gEgo head:) show:)
				(dog setScript: dogScript)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance moveScript of Script ; UNUSED
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
					(Say 274)
					(event claimed: 1)
				)
				(5 ; Talk
					(Say 281)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 277)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(16
							(Say 279)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(Say 279)
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
				(== (self cel:) 1)
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
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(!= ((gInventory at: 16) owner:) 12) ; Stick
				(== (self cel:) 1)
				(self script:)
			)
			(gGlobalSound3 number: 862 loop: 1 vol: 127 play:)
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
					(Say 275)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 278)
					(event claimed: 1)
				)
				(5 ; Talk
					(Say 282)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(16
							(gTheIconBar state: 0)
							(User canControl: 0)
							(gEgo put: 16 12) ; Stick
							(= local2 0)
							(SetScore 4)
							(gCurRoom setScript: throwStick)
							(event claimed: 1)
						)
						(8
							(gTheIconBar state: 0)
							(User canControl: 0)
							(SetScore 4)
							(gEgo put: 8 12) ; Shoe
							(= local2 2)
							(gCurRoom setScript: throwStick)
							(event claimed: 1)
						)
						(19
							(gTheIconBar state: 0)
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
							(Say 280)
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
					(Say 276)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance wAnt of Prop ; UNUSED
	(properties)
)

(instance eAnt of Prop ; UNUSED
	(properties)
)

(instance theMouth of Prop ; UNUSED
	(properties)
)

(instance kingAnt of Prop ; UNUSED
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

(instance blink of Prop ; UNUSED
	(properties
		x 229
		y 43
		view 325
		loop 4
		priority 14
		signal 16
	)
)

(instance wArm of Prop ; UNUSED
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

(instance eArm of Prop ; UNUSED
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

