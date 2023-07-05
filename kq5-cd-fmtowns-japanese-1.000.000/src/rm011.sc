;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Interface)
(use Waters)
(use n762)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use RFeature)
(use Avoid)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm011 0
)

(local
	local0
	local1
	local2
	[local3 6] = [261 188 80 141 188 80]
	local9
	[local10 12] = [0 167 71 175 108 159 142 157 168 189 0 189]
	[local22 16] = [0 122 86 118 108 124 175 126 145 140 109 140 46 149 0 149]
	[local38 10] = [319 107 251 105 205 100 216 91 319 89]
	local48
	[local49 6] = [0 3049 1 960 0 0]
	[local55 9] = [1000 126 33 4 11 24 19 23 30]
	[local64 9] = [1006 40 50 5 10 32 26 31 30]
	[local73 6] = [0 1053 0 1054 0 0]
	[local79 9] = [1003 10 62 4 11 25 23 31 31]
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

(instance rm011 of KQ5Room
	(properties
		picture 11
		horizon 115
		north 12
		east 27
		west 14
	)

	(method (init)
		(super init:)
		(= global320 141)
		(= global321 66)
		(= global325 3045)
		(self setFeatures: tree anthill setRegions: 202) ; owl
		(if (== (gGame detailLevel:) 3)
			(water init:)
		)
		(if (gEgo has: 5) ; Fish
			(LoadMany rsVIEW 320)
			(Load rsSCRIPT 991)
			(bear init: setScript: bearScript)
		else
			(LoadMany rsVIEW 314 316)
		)
		(if (== ((gInventory at: 16) owner:) 11) ; Stick
			(stick init:)
		)
		(hive init: stopUpd:)
		(bees ignoreHorizon: 1 ignoreActors: 1 setCycle: Fwd init:)
		(gGlobalSound number: 16 loop: -1 vol: 127 play:)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 314 130)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(north
				(gEgo posn: 165 118)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(else
				(gEgo posn: -20 164)
				(HandsOff)
				(self setScript: relievedScript)
			)
		)
		(gEgo view: 0 ignoreHorizon: 1 setStep: 3 2 init:)
		(poly1 points: @local10 size: 6)
		(poly2 points: @local22 size: 8)
		(poly3 points: @local38 size: 5)
		(self addObstacle: poly1 poly2 poly3)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((not local9)
				(++ local9)
				(cond
					((gCast contains: bear)
						(if (not (IsFlag 85))
							(SetFlag 85)
							(proc762_1 @local55 3046)
							(if (== (gGlobalSound3 prevSignal:) -1)
								(gGlobalSound3 number: 851 loop: 1 vol: 127 play:)
							)
						)
					)
					((and (not (IsFlag 86)) (not (IsFlag 36)))
						(SetFlag 86)
						(proc762_1 @local55 3047)
					)
				)
			)
			((= local0 (self edgeToRoom: (gEgo edgeHit:)))
				(if (== local0 (gCurRoom west:))
					(gEgo loop: 1)
					(RedrawCast)
					(cls)
					(proc762_1 @local55 3048)
					(gCurRoom newRoom: local0)
				else
					((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				)
			)
			((& (gEgo onControl: 0) $0002)
				(HandsOff)
				(self setScript: drownHim)
			)
			(
				(and
					(& (gEgo onControl: 0) $0010)
					(not (IsFlag 36))
					(not (gCast contains: bear))
				)
				(HandsOff)
				(self setScript: deathByBees)
			)
		)
	)

	(method (handleEvent event)
		(if
			(or
				script
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 257)
					(event claimed: 1)
				)
				(3 ; Do
					(gEgo
						setMotion:
							PolyPath
							(if (< (gEgo x:) 172)
								172
							else
								(gEgo x:)
							)
							189
					)
					(event claimed: 1)
				)
			)
		)
	)

	(method (dispose)
		(gGlobalSound fade:)
		(DisposeScript 985)
		(DisposeScript 991)
		(DisposeScript 401)
		(super dispose:)
	)
)

(instance relievedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gEgo setMotion: MoveTo 7 164 self)
			)
			(2
				(proc762_0 @local55 @local79 @local49 self)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance drownHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc762_1 @local55 3032)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 69
					loop:
						(if (and (< (gEgo x:) 251) (> (gEgo x:) 203))
							1
						else
							0
						)
					cel: 0
					setPri: 15
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(gGlobalSound3 number: 68 loop: 1 vol: 127 play:)
				(gEgo
					setLoop: 2
					x:
						(if (and (< (gEgo x:) 251) (> (gEgo x:) 203))
							(- (gEgo x:) 39)
						else
							(+ (gEgo x:) 39)
						)
					y: (+ (gEgo y:) 22)
					setCycle: Fwd
					setStep: 3 1
					illegalBits: -32768
					setMotion: PolyPath (gEgo x:) 225 self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(cls)
				(= global330 254)
				(EgoDead)
			)
		)
	)
)

(instance throwFish of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (== (gEgo cel:) 7))
			(fish
				init:
				setLoop: 2
				x:
					(if (< (gEgo x:) 181)
						(+ (gEgo x:) 24)
					else
						(- (gEgo x:) 7)
					)
				y: (- (gEgo y:) 4)
				cel: (if (< (gEgo x:) 181) 4 else 4)
				setCycle: Walk
				setPri: (gEgo priority:)
				setMotion: JumpTo 181 138 self
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& (gEgo onControl: 0) $0400)
					(gEgo setMotion: PolyPath 20 159 self)
				else
					(gEgo setMotion: PolyPath 296 127 self)
				)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 320
					loop: (if (< (gEgo x:) 181) 0 else 1)
					cel: 0
					setCycle: End self
				)
			)
			(2)
			(3
				(gEgo
					normal: 1
					view: 0
					loop: (if (< (gEgo x:) 181) 0 else 1)
					setCycle: SyncWalk
				)
				((gEgo head:) show:)
				(fish setPri: -1 cel: 0 stopUpd:)
				(SetScore 4)
				(= local1 2)
				(client setScript: 0)
			)
		)
	)
)

(instance bearScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (== state 5) (== (bear cel:) 1))
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 304
					setLoop: 3
					cel: 0
					cycleSpeed: 0
					setCycle: End
				)
			)
			((and (== local1 2) (< state 7))
				(= state 7)
				(self cue:)
			)
			((and (== (bear cel:) 2) (== state 9))
				(fish dispose:)
			)
			(
				(and
					(> (gEgo y:) (bear y:))
					(& (gEgo onControl: 0) $0040)
					(!= local1 1)
					(< state 4)
				)
				(HandsOff)
				(= local1 1)
				(= state 3)
				(self cue:)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(bear loop: 0 cycleSpeed: 2 cel: 0 setCycle: End self)
			)
			(1
				(bear
					x: 121
					y: 138
					cycleSpeed: 2
					loop: 1
					cel: 0
					setCycle: End self
				)
				(= state (Random 0 2))
			)
			(2
				(bear loop: 2 cel: 0 setCycle: End self)
				(= state (Random 0 2))
			)
			(3
				(bear loop: 3 cel: 0 setCycle: End self)
				(if (and (== (gGlobalSound3 prevSignal:) -1) (not (Random 0 3)))
					(gGlobalSound3 number: 851 loop: 1 vol: 127 play:)
				)
				(= state (Random 0 2))
			)
			(4
				(gGlobalSound number: 17 loop: 1 vol: 127 play: self)
				(bear
					view: 304
					posn: 101 142
					loop: 0
					cel: 0
					cycleSpeed: 0
					setCycle: End self
				)
				(gGlobalSound3 number: 851 loop: 1 vol: 127 play:)
			)
			(5
				(bear posn: 92 142 loop: 1 cel: 0 setCycle: End self)
			)
			(6)
			(7
				(if
					(or
						(!= (gEgo view:) 304)
						(!= (gEgo cel:) (gEgo lastCel:))
					)
					(-- state)
					(= cycles 1)
				else
					(= global330 255)
					(EgoDead 262)
				)
			)
			(8
				(bear loop: 4 cel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(9
				(bear
					view: 308
					loop: 3
					cel: 0
					x: (+ (bear x:) 36)
					setCycle: End self
				)
			)
			(10
				(bear
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setLoop: 1
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 380 (bear y:) self
				)
			)
			(11
				(bear view: 0 setAvoider: 0)
				(= cycles 1)
			)
			(12
				(= cycles 1)
				(gGlobalSound fade:)
			)
			(13
				(SetFlag 36)
				(gGlobalSound4 number: 63 loop: 1 vol: 127 play:)
				(proc762_0 @local64 @local64 @local73 self)
			)
			(14
				(= cycles 1)
			)
			(15
				(cls)
				(= cycles 1)
				(gGlobalSound number: 16 loop: -1 vol: 127 play:)
				(gGlobalSound4 fade:)
			)
			(16
				(HandsOn)
				(bear dispose:)
				(gCurRoom setScript: 0)
				(client setScript: 0)
			)
		)
	)
)

(instance getWax of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl: 0) $0010)
				(not (IsFlag 36))
				(not (gCast contains: bear))
				(not local48)
			)
			(++ local48)
			(HandsOff)
			(self setScript: deathByBees)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 93 143 self)
			)
			(1
				(gEgo
					illegalBits: 0
					setPri: 12
					setMotion: MoveTo 94 136 self
				)
			)
			(2
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 312
					loop: 4
					cel: 0
					cycleSpeed: 2
					setCycle: End self
					get: 17 ; Honeycomb
				)
				(SetScore 2)
			)
			(3
				(Say 264)
				(gEgo setCycle: Beg self)
			)
			(4
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 105 148 self
				)
			)
			(5
				(gEgo setPri: -1 illegalBits: -32768)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance deathByBees of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 1)
				(gGlobalSound number: 15 loop: 1 vol: 127 play:)
				(bees
					view: 314
					loop: 0
					setPri: 14
					posn:
						(+ ((gEgo head:) x:) 30)
						(- ((gEgo head:) y:) 25)
					cel: 0
					setCycle: End self
				)
			)
			(1
				(bees
					posn: (gEgo x:) (- (gEgo y:) 15)
					setLoop: 1
					setCycle: Fwd
				)
				(gEgo
					view: 316
					normal: 0
					cycleSpeed: 3
					setLoop: 1
					setCycle: End self
				)
				((gEgo head:) hide:)
			)
			(2
				(gEgo setLoop: 0 setCycle: End self)
			)
			(3
				(gEgo setLoop: 2 cel: 0 setMotion: 0 setCycle: End self)
			)
			(4
				(= seconds 3)
			)
			(5
				(= global330 256)
				(EgoDead 263)
			)
		)
	)
)

(instance getStick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 146 143 self)
				(if (gCast contains: bear)
					(bear setScript: bearScript)
					(gCurRoom setScript: 0)
				)
			)
			(1
				(Say 265)
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 56 loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(SetScore 2)
				(stick dispose:)
				(gEgo get: 16 setCycle: Beg self) ; Stick
			)
			(3
				(gEgo normal: 1 view: 0 setCycle: Walk loop: 7 cel: 1)
				((gEgo head:) show:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance water of Waters
	(properties
		x 1000
		y 1000
		view 299
		priority 1
		cycleSpeed 5
	)

	(method (getLoop)
		(= x [local3 pos])
		(= y [local3 (++ pos)])
		(= cel [local3 (++ pos)])
	)

	(method (saveLoop)
		(= [local3 pos] cel)
		(++ pos)
	)

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
					(Say 257)
					(event claimed: 1)
				)
				(3 ; Do
					(gEgo
						setMotion:
							PolyPath
							(if (< (gEgo x:) 172)
								172
							else
								(gEgo x:)
							)
							189
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance tree of RFeature
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
					(Say 258)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance hive of Prop
	(properties
		x 93
		y 90
		view 298
		loop 7
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
					(Say 259)
					(event claimed: 1)
				)
				(3 ; Do
					(if (!= ((gInventory at: 17) owner:) 11) ; Honeycomb
						(Say 266)
					else
						(HandsOff)
						(gCurRoom setScript: getWax)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance anthill of RFeature
	(properties
		nsTop 64
		nsLeft 202
		nsBottom 75
		nsRight 238
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
					(Say 260)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bear of Actor
	(properties
		x 108
		y 138
		view 302
		illegalBits 0
		xStep 5
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
					(Say 261)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 267)
					(event claimed: 1)
				)
				(5 ; Talk
					(Say 269)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(5
							(gEgo put: 5 11) ; Fish
							(HandsOff)
							(gEgo setScript: throwFish)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(Say 271)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance bees of Actor
	(properties
		x 91
		y 62
		view 312
		priority 10
		signal 16400
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if (and (< (Random 0 100) 50) (not local2))
			(bees loop: (Random 0 2))
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
			(switch (event message:)
				(2 ; Look
					(Say 258)
					(event claimed: 1)
				)
				(5 ; Talk
					(Say 270)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 268)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(event claimed: 0)
						)
						(else
							(Say 272)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance stick of Prop
	(properties
		x 132
		y 149
		view 312
		loop 3
		priority 2
		signal 16401
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
					(Say 263)
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getStick)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance fish of Actor
	(properties
		view 320
		loop 2
		signal 16384
	)
)

(instance cloud of Prop ; UNUSED
	(properties
		x 94
		y 80
		view 214
		priority 14
		signal 16
	)
)

(instance body of Prop ; UNUSED
	(properties
		x 94
		y 80
		view 298
		cel 1
		priority 10
		signal 16
	)

	(method (init)
		(super init:)
		(theMouth init:)
		(antenna init:)
		(theEyes init:)
		(bodyWest init:)
		(bodyEast init:)
	)

	(method (dispose)
		(super dispose:)
		(theMouth dispose:)
		(antenna dispose:)
		(theEyes dispose:)
		(bodyWest dispose:)
		(bodyEast dispose:)
	)
)

(instance theMouth of Prop
	(properties
		x 91
		y 70
		view 298
		loop 1
		cel 4
		priority 11
		signal 16
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance antenna of Prop
	(properties
		x 90
		y 51
		view 298
		loop 5
		cel 2
		priority 11
		signal 16
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 60)
			(1
				(self setCycle: End)
			)
		)
	)
)

(instance theEyes of Prop
	(properties
		x 91
		y 65
		view 298
		loop 6
		priority 12
		signal 16
	)

	(method (doit)
		(super doit:)
		(if (not (self script:))
			(switch (Random 1 30)
				(1
					(self setScript: (moveScript new:))
				)
			)
		)
	)
)

(instance bodyWest of Prop
	(properties
		x 64
		y 72
		view 298
		loop 3
		cel 2
		priority 11
		signal 16
	)

	(method (doit)
		(super doit:)
		(if (not (self script:))
			(switch (Random 1 30)
				(1
					(self setScript: (moveScript new:))
				)
			)
		)
	)
)

(instance bodyEast of Prop
	(properties
		x 104
		y 95
		view 298
		loop 4
		cel 2
		priority 11
		signal 16
	)

	(method (doit)
		(super doit:)
		(if (not (self script:))
			(switch (Random 1 50)
				(1
					(self setScript: (moveScript new:))
				)
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
				(client setScript: 0)
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

