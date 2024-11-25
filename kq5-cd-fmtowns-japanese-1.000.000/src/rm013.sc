;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)
(use n762)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm013 0
)

(local
	local0
	local1
	local2
	[local3 18] = [10 113 240 113 260 120 260 128 209 128 170 134 107 134 107 128 10 129]
	[local21 8] = [0 161 103 176 108 189 0 189]
	[local29 8] = [319 189 173 189 166 163 319 163]
	[local37 8] = [0 0 319 0 319 102 0 102]
	[local45 8] = [127 117 143 117 143 125 127 125]
	local53
	local54
	local55
	[local56 9] = [1003 10 62 4 11 25 23 31 31]
	[local65 9] = [1013 170 63 4 9 26 23 27 26]
	[local74 9] = [1000 55 70 4 11 24 19 23 30]
	[local83 6] = [1 3049 0 960 0 0]
)

(instance rm013 of KQ5Room
	(properties
		picture 13
		east 9
		south 12
		west 14
	)

	(method (init)
		(super init:)
		(= global320 69)
		(= global321 137)
		(= global325 3053)
		(= local54 (gEgo illegalBits:))
		(gEgo illegalBits: $8000 ignoreHorizon: 1)
		(if (!= (gGlobalSound number:) 24)
			(gGlobalSound number: 24 loop: -1 play:)
		)
		(if (== ((gInventory at: 6) owner:) 200) ; Brass_Bottle
			(if (== ((gInventory at: 34) owner:) 13) ; Tambourine
				(tambourine init:)
				(glint init: setScript: glimmer)
				(self addObstacle: poly5)
			)
			(self setFeatures: grassRoom)
		else
			(gGlobalSound2 number: 803 loop: -1 vol: 127 playBed:)
			(Load rsVIEW 344)
			(chair init: stopUpd:)
			(body setCycle: Fwd cycleSpeed: 3 init:)
			(oxHead cycleSpeed: 2 init:)
			(if (== (gGame detailLevel:) 3)
				(oxTail cycleSpeed: 2 init: setScript: oxScript)
				(coals setCycle: Fwd init:)
			else
				(coals init: stopUpd:)
				(oxTail init: stopUpd:)
			)
			(barrel init:)
			(shovel init:)
			(camp init:)
			(wagon init:)
			(ox init:)
			(gAddToPics add: barrel shovel camp wagon doit:)
			(self setFeatures: camp barrel shovel wagon addObstacle: poly1)
		)
		(poly1 points: @local3 size: 9)
		(poly2 points: @local21 size: 4)
		(poly3 points: @local29 size: 4)
		(poly4 points: @local37 size: 4)
		(poly5 points: @local45 size: 4)
		(self addObstacle: poly2 poly3 poly4)
		(self setRegions: 202) ; owl
		(gEgo normal: 1 view: 0 setPri: -1 init:)
		(switch gPrevRoomNum
			(west
				(gEgo posn: -20 129 loop: 0)
				(HandsOff)
				(self setScript: relievedScript)
			)
			(east
				(gEgo posn: 315 125)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(south
				(gEgo posn: 133 180)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(else
				(gEgo posn: 187 127)
				(HandsOff)
				(self setScript: egoWalk)
			)
		)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(not (IsFlag 51))
					(gCast contains: body)
					(< (gEgo y:) 188)
				)
				(SetFlag 51)
				(self setScript: warnScript)
			)
			((= local0 (self edgeToRoom: (gEgo edgeHit:)))
				(if (== local0 (gCurRoom west:))
					(gEgo loop: 1)
					(RedrawCast)
					(proc762_1 @local74 3048)
					(gCurRoom newRoom: local0)
				else
					((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				)
			)
			(
				(and
					(gEgo inRect: 170 120 217 145)
					(not (gCast contains: gypsy))
					(gCast contains: chair)
				)
				(HandsOff)
				(gEgo setMotion: 0)
				(self setScript: standScript)
			)
			((and (> (gEgo distanceTo: gypsy) 50) (gCast contains: gypsy))
				(self setScript: sitDown)
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
		(gEgo illegalBits: local54)
		(gGlobalSound fade:)
		(gGlobalSound2 fade:)
		(super dispose:)
	)
)

(instance glimmer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(glint setCycle: End)
				(-- state)
				(= seconds 10)
			)
		)
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
				(proc762_1 @local74 3054)
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
				(= cycles 5)
			)
			(1
				(gEgo setMotion: MoveTo 4 129 self)
			)
			(2
				(proc762_0 @local56 @local74 @local83 self)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance standScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(body dispose:)
				(chair view: 346 loop: 4 cel: 0 setCycle: End self)
			)
			(1
				(chair view: 346 loop: 0 cel: 1 stopUpd:)
				(gypsy
					setCycle: Walk
					setLoop: 0
					illegalBits: 0
					setMotion: MoveTo 187 128 self
					init:
				)
			)
			(2
				(gypsy setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(if (not local2)
					(++ local2)
					(proc762_1 @local65 9036)
				else
					(proc762_1 @local65 9037)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gypsy
					setCycle: Walk
					setLoop: 1
					illegalBits: 0
					setMotion: MoveTo 214 127 self
				)
			)
			(1
				(gypsy dispose:)
				(chair
					view: 346
					loop: 4
					cel: (- (NumCels chair) -1)
					setCycle: Beg self
				)
			)
			(2
				(body setCycle: Fwd cycleSpeed: 3 init:)
				(chair loop: 0 cel: 0 forceUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance giveCoinSit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(body dispose:)
				(chair view: 346 loop: 4 cel: 0 setCycle: End self)
				(gEgo setMotion: PolyPath 200 132 self)
			)
			(1)
			(2
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 24
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(chair view: 346 loop: 0 cel: 1 stopUpd:)
				(gypsy
					cel: 0
					cycleSpeed: 2
					x: 224
					setLoop: 3
					illegalBits: 0
					setCycle: End self
					init:
				)
			)
			(4
				(gypsy setLoop: 4 cel: 0 setCycle: End self)
			)
			(5
				(if local55
					(proc762_1 @local65 9038)
				else
					(proc762_1 @local65 9039)
				)
				(gEgo
					normal: 1
					view: 0
					setCycle: Walk
					cycleSpeed: 0
					ignoreControl: 2
					setMotion: MoveTo 187 127 self
				)
				((gEgo head:) show:)
			)
			(6
				(gCurRoom newRoom: 77)
			)
		)
	)
)

(instance giveCoinStand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 187 137 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 24
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gypsy
					cel: 0
					setLoop: 3
					illegalBits: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(gypsy setLoop: 4 cel: 0 setCycle: End self)
			)
			(4
				(if local55
					(proc762_1 @local65 9038)
				else
					(proc762_1 @local65 9039)
				)
				(gypsy
					setCycle: Walk
					setLoop: 1
					illegalBits: 0
					cycleSpeed: 0
					setMotion: MoveTo 200 127 self
				)
			)
			(5
				(gEgo
					normal: 1
					view: 0
					setCycle: Walk
					cycleSpeed: 0
					ignoreControl: 2
					setMotion: MoveTo 187 127 self
				)
				((gEgo head:) show:)
			)
			(6
				(gCurRoom newRoom: 77)
			)
		)
	)
)

(instance oxScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (< (Random 1 100) 10)
			(oxTail setCycle: Beg)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oxHead loop: 1 setCycle: End)
				(= seconds 5)
			)
			(1
				(oxHead setCycle: Beg self)
			)
			(2
				(oxHead loop: 5 cel: 0 setCycle: CT 1 1)
				(gGlobalSound3 number: 880 loop: 1 vol: 127 play:)
				(= cycles 30)
			)
			(3
				(oxHead setCycle: Fwd)
				(= state -1)
				(= seconds (Random 5 20))
			)
		)
	)
)

(instance egoWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 146 self)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getTambourine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 146 122 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 56 loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(tambourine dispose:)
				((gCurRoom obstacles:) delete: poly5)
				(glint setScript: 0 dispose:)
				(SetScore 2)
				(gEgo get: 34 setCycle: Beg self) ; Tambourine
			)
			(3
				(Say 291)
				(gEgo
					normal: 1
					view: 0
					setCycle: Walk
					cycleSpeed: 0
					loop: 7
					cel: 1
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance wagon of RPicView
	(properties
		x 120
		y 125
		view 342
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
					(Say 283)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance door of Prop ; UNUSED
	(properties
		view 342
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
					(Say 284)
					(event claimed: 1)
				)
				(3 ; Do
					(gEgo setMotion: PolyPath 186 120)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance oxHead of Prop
	(properties
		x 89
		y 112
		view 342
		loop 1
		priority 8
		signal 16400
	)

	(method (doVerb)
		(ox doVerb: &rest)
	)
)

(instance oxTail of Prop
	(properties
		x 15
		y 145
		z 28
		view 342
		loop 2
		priority 8
		signal 16400
	)

	(method (doVerb)
		(ox doVerb: &rest)
	)
)

(instance ox of Prop
	(properties
		x 20
		y 83
		view 342
		loop 7
	)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(2
					(Say 285)
				)
				(3
					(Say 292)
				)
				(5
					(Say 295)
				)
				(4
					(switch invItem
						(28 1)
						(else
							(Say 297)
						)
					)
				)
			)
		)
	)
)

(instance body of Prop
	(properties
		x 232
		y 127
		z 17
		view 346
		loop 1
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
					(Say 286)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 293)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(11
							(if (gEgo has: 27) ; Amulet
								(proc762_1 @local65 9040)
							else
								(gEgo put: 11 13) ; Gold_Coin
								(SetScore 3)
								(HandsOff)
								(gCurRoom setScript: giveCoinSit)
							)
							(event claimed: 1)
						)
						(3
							(if (gEgo has: 27) ; Amulet
								(proc762_1 @local65 9040)
							else
								(= local55 1)
								(gEgo put: 3 13) ; Golden_Needle
								(HandsOff)
								(gCurRoom setScript: giveCoinSit)
							)
							(event claimed: 1)
						)
						(4
							(proc762_1 @local65 9041)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
					)
				)
				(5 ; Talk
					(Say 296)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance chair of Prop
	(properties
		x 235
		y 127
		view 346
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
				(4 ; Inventory
					(if (not (gCast contains: gypsy))
						(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
							(11
								(if (gEgo has: 27) ; Amulet
									(proc762_1 @local65 9040)
								else
									(gEgo put: 11 13) ; Gold_Coin
									(SetScore 3)
									(HandsOff)
									(gCurRoom setScript: giveCoinSit)
								)
								(event claimed: 1)
							)
							(3
								(if (gEgo has: 27) ; Amulet
									(proc762_1 @local65 9040)
								else
									(= local55 1)
									(gEgo put: 3 13) ; Golden_Needle
									(HandsOff)
									(gCurRoom setScript: giveCoinSit)
								)
								(event claimed: 1)
							)
							(28
								(event claimed: 0)
							)
							(4
								(proc762_1 @local65 9041)
								(event claimed: 1)
							)
							(else
								(proc762_1 @local65 9042)
								(event claimed: 1)
							)
						)
					)
				)
				(5 ; Talk
					(if (and (not (gCast contains: gypsy)) (not local53))
						(Say 296)
						(++ local53)
						(event claimed: 1)
					)
				)
				(2 ; Look
					(if (not (gCast contains: gypsy))
						(Say 286)
						(event claimed: 1)
					)
				)
				(3 ; Do
					(if (not (gCast contains: gypsy))
						(Say 293)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance gypsy of Actor
	(properties
		x 214
		y 127
		view 344
		cel 7
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
					(Say 287)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 293)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(11
							(if (gEgo has: 27) ; Amulet
								(proc762_1 @local65 9040)
							else
								(SetScore 3)
								(gEgo put: 11 13) ; Gold_Coin
								(HandsOff)
								(gCurRoom setScript: giveCoinStand)
							)
							(event claimed: 1)
						)
						(3
							(if (gEgo has: 27) ; Amulet
								(proc762_1 @local65 9040)
							else
								(= local55 1)
								(gEgo put: 3 13) ; Golden_Needle
								(HandsOff)
								(gCurRoom setScript: giveCoinStand)
							)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(4
							(proc762_1 @local65 9041)
							(event claimed: 1)
						)
						(else
							(proc762_1 @local65 9042)
							(event claimed: 1)
						)
					)
				)
				(5 ; Talk
					(Say 296)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance barrel of RPicView
	(properties
		x 121
		y 128
		view 342
		loop 3
		signal 16384
	)
)

(instance shovel of RPicView
	(properties
		x 134
		y 129
		view 342
		loop 3
		cel 1
		signal 16384
	)
)

(instance coals of Prop
	(properties
		x 152
		y 132
		z 7
		view 342
		loop 4
		cel 1
		signal 16384
		cycleSpeed 2
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
					(Say 288)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 294)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance camp of RPicView
	(properties
		x 152
		y 132
		view 342
		loop 3
		cel 2
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
					(Say 288)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 294)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance grassRoom of RFeature
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
					(Say 289)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance glint of Prop
	(properties
		x 135
		y 120
		view 342
		loop 6
		signal 16401
		cycleSpeed 2
	)
)

(instance tambourine of Prop
	(properties
		x 135
		y 127
		view 342
		loop 3
		cel 4
		priority 3
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
					(Say 290)
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getTambourine)
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

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

