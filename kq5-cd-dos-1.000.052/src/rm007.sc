;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use Interface)
(use CodeCue)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm007 0
)

(local
	[local0 16] = [144 149 0 149 0 0 202 0 206 63 266 76 76 98 163 134]
	[local16 14] = [319 129 162 124 95 101 288 78 218 61 219 0 319 0]
	[local30 8] = [319 189 152 189 211 169 319 156]
	[local38 10] = [0 168 99 168 96 181 74 189 0 189]
	[local48 14] = [0 1233 1 1234 0 1235 1 1236 0 1237 1 1238 0 0]
	[local62 9] = [1004 200 60 4 7 27 25 28 28]
	[local71 9] = [1003 230 90 4 11 25 23 31 31]
	[local80 9] = [1000 160 10 4 11 24 19 23 30]
)

(instance rm007 of KQ5Room
	(properties
		picture 7
		horizon 75
		north 8
		east 2
		south 6
		west 10
	)

	(method (init)
		(super init:)
		(= global320 181)
		(= global321 35)
		(gEgo normal: 1 setStep: 3 2 view: 0 illegalBits: -32768)
		(= global325 3033)
		(gGlobalSound number: 24 loop: -1 play:)
		(if (and (not (IsFlag 26)) (!= ((gInventory at: 9) owner:) 9)) ; Heart
			(SetFlag 26)
			(gGlobalSound2 number: 26 loop: 1 play:)
			(prince init: stopUpd:)
		)
		(self setFeatures: bath path7 room setRegions: 202) ; owl
		(switch gPrevRoomNum
			(west
				(gEgo posn: 2 148)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(east
				(gEgo posn: 286 131)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(north
				(gEgo view: 2 setStep: 2 1 posn: 265 77)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(south
				(gEgo posn: 120 186)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(else
				(gEgo posn: 120 186)
			)
		)
		(gEgo setCycle: KQ5SyncWalk init:)
		(bird setCycle: Fwd init:)
		(poly1 points: @local0 size: 8)
		(poly2 points: @local16 size: 7)
		(poly3 points: @local30 size: 4)
		(poly4 points: @local38 size: 5)
		(self addObstacle: poly1 poly2 poly3 poly4)
	)

	(method (doit &tmp temp0)
		(cond
			((& (gEgo onControl: 1) $2000)
				(gEgo view: 0 setStep: 3 2)
			)
			((& (gEgo onControl: 1) $4000)
				(gEgo view: 2 setStep: 2 1)
			)
		)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
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

	(method (newRoom newRoomNumber)
		(gGlobalSound2 fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance birdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bird z: 0 x: 108 y: 85 setLoop: 11 cycleSpeed: 0 setCycle: Fwd)
				(= cycles 20)
			)
			(1
				(bird x: 105 setLoop: 12 setCycle: End self)
			)
			(2
				(bird
					setLoop: 9
					cycleSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo -20 72 self
				)
			)
			(3
				(bird dispose:)
				(self dispose:)
			)
		)
	)
)

(instance princeLeaveCD of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 259 145 self)
			)
			(1
				(proc0_7 gEgo prince 5)
				((gEgo head:) moveHead: 0 cel: 6)
				(= cycles 3)
			)
			(2
				(prince cycleSpeed: 2 setCycle: CT 2 1 self)
			)
			(3
				(prince setLoop: 4 cel: 0 setCycle: End self)
			)
			(4
				(prince stopUpd:)
				(proc762_0 @local71 @local62 @local48 self)
			)
			(5
				(RedrawCast)
				(prince
					cycleSpeed: 0
					moveSpeed: 0
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 340 (prince y:) self
				)
				((gEgo head:) moveHead: 1)
			)
			(6
				(gGlobalSound2 fade:)
				(HandsOn)
				(prince dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance path7 of RFeature
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
					(Say 217)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bath of RFeature
	(properties
		nsTop 68
		nsLeft 87
		nsBottom 95
		nsRight 128
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
					(Say 218)
					(event claimed: 1)
				)
				(3 ; Do
					(if (!= (bird x:) 108)
						(Say 221)
						(event claimed: 1)
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance prince of Actor
	(properties
		x 237
		y 123
		view 146
		loop 3
	)

	(method (handleEvent event)
		(cond
			((and (MousedOn global322 event) (== (event message:) 5)) ; Talk
				(proc762_1 @local80 3034)
				(event claimed: 1)
			)
			(
				(or
					(event claimed:)
					(not (== (event type:) evVERB))
					(not (MousedOn self event))
				)
				(return)
			)
			(else
				(switch (event message:)
					(2 ; Look
						(Say 219)
						(event claimed: 1)
					)
					(3 ; Do
						(Say 222)
						(event claimed: 1)
					)
					(5 ; Talk
						(HandsOff)
						(gCurRoom setScript: princeLeaveCD)
						(event claimed: 1)
					)
					(4 ; Inventory
						(if (!= (gInventory indexOf: (gTheIconBar curInvIcon:)) 28)
							(Say 224)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance bird of Actor
	(properties
		x 108
		y 135
		z 55
		view 146
		loop 8
		priority 10
		signal 24592
		cycleSpeed 2
		detailLevel 3
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(> (gGame detailLevel:) 0)
				(not script)
				(< (gEgo distanceTo: self) 30)
			)
			(self setScript: birdScript)
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
					(Say 220)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 223)
					(event claimed: 1)
				)
				(5 ; Talk
					(Say 226)
					(event claimed: 1)
				)
				(4 ; Inventory
					(if (!= (gInventory indexOf: (gTheIconBar curInvIcon:)) 28)
						(Say 225)
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

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
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
					(Say 217)
					(event claimed: 1)
				)
			)
		)
	)
)

