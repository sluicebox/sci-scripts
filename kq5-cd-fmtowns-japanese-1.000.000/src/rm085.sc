;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use Interface)
(use n762)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use Chase)
(use RFeature)
(use Avoid)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm085 0
)

(local
	local0
	[local1 28] = [0 0 319 0 319 183 290 183 248 133 212 133 217 148 145 148 145 140 97 140 97 145 124 145 117 185 0 185]
	[local29 9] = [1003 135 77 4 11 25 23 31 31]
	[local38 9] = [1016 130 64 4 8 26 21 27 24]
)

(instance rm085 of KQ5Room
	(properties
		picture 85
	)

	(method (init)
		(super init:)
		(HandsOn)
		(gAddToPics add: smokeOut1 smokeOut2 thug2Bottom doit:)
		(self setFeatures: thug2Bottom backRoom room addObstacle: poly1)
		(switch gPrevRoomNum
			(28
				(HandsOff)
				(gEgo view: 0 posn: 55 143 init:)
				(self setScript: getKilled)
			)
			(else
				(gEgo view: 0 posn: 165 170 init:)
			)
		)
		(dog init:)
		(smoke1 init:)
		(smoke2 init:)
		(IKHead setScript: headScript init:)
		(thug1 setMotion: 0 setScript: (drinkScript new:) init:)
		(thug2 setScript: (drinkScript new:) init:)
		(IKArm setCycle: Fwd cycleSpeed: 2 init:)
		(innKeeper init:)
		(gGlobalSound number: 119 loop: -1 vol: 127 play:)
		(poly1 points: @local1 size: 14)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(or (< (gEgo y:) 155) (& (gEgo onControl: 0) $0040))
					(not local0)
				)
				(gGlobalSound number: 120 loop: -1 play:)
				(HandsOff)
				(++ local0)
				(if (not (IsFlag 39))
					(proc762_1 @local38 5400)
				else
					(proc762_1 @local38 5405)
				)
				(gEgo setMotion: MoveTo (gEgo x:) 148)
			)
			((< (gEgo y:) 150)
				(HandsOff)
				(self setScript: attack)
			)
			((& (gEgo onControl: 0) $4000)
				(gCurRoom newRoom: 27)
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
		(gGlobalSound fade:)
		(DisposeScript 972)
		(DisposeScript 985)
		(super dispose:)
	)
)

(instance getKilled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 158 149 self)
			)
			(1
				(client setScript: 0)
			)
		)
	)
)

(instance headScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End)
				(= seconds (Random 3 8))
			)
			(1
				(client setCycle: Beg)
				(= state -1)
				(= seconds (Random 3 8))
			)
		)
	)
)

(instance attack of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if
			(and
				(or (== state 5) (== state 6))
				(not (User canInput:))
				(not (User controls:))
			)
			(= temp1 ((= temp0 (Event new:)) type:))
			(if (OneOf temp1 1 4)
				(= seconds 0)
				(= cycles 1)
			)
			(temp0 dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(IKHead dispose:)
				(IKArm dispose:)
				(thug2 setCycle: Beg setScript: 0)
				(innKeeper
					view: 800
					setScript: 0
					setCycle: Walk
					setLoop: -1
					moveSpeed: 1
					setMotion: MoveTo 78 132 self
					startUpd:
				)
				(gEgo setMotion: 0)
				(if (not (IsFlag 39))
					(proc762_1 @local29 5401)
				)
			)
			(1
				(innKeeper setMotion: MoveTo 78 142 self)
			)
			(2
				(dog setCycle: End)
				(thug1
					view: 806
					setScript: 0
					illegalBits: $0800
					setCycle: Walk
					ignoreActors: 1
					moveSpeed: 1
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
				(innKeeper
					observeControl: 2048
					ignoreActors: 1
					setAvoider: (Avoid new:)
					setMotion: Chase gEgo 20 self
				)
			)
			(3)
			(4
				(cls)
				(innKeeper setMotion: 0 loop: 5)
				(gEgo loop: 1)
				(thug1 loop: 7)
				(= cycles 3)
			)
			(5
				(if (not (IsFlag 39))
					(proc762_1 @local38 5402)
					(thugHead
						x: (thug1 x:)
						y: (- (thug1 y:) 40)
						setPri: (+ (thug1 priority:) 1)
						setCycle: Fwd
						init:
					)
					(Say 5403 self)
				else
					(= cycles 1)
				)
			)
			(6
				(Load rsSOUND 121)
				(thugHead dispose:)
				(innHead
					x: (+ (innKeeper x:) 1)
					y: (- (innKeeper y:) 34)
					setPri: (+ (innKeeper priority:) 1)
					setCycle: Fwd
					init:
				)
				(if (not (IsFlag 39))
					(Say 5404 self)
				else
					(Say 5406 self)
				)
			)
			(7
				(innHead dispose:)
				(cls)
				(thug1 view: 810 loop: 0 cel: 0 setCycle: End self)
			)
			(8
				(gGlobalSound number: 121 loop: 1 play:)
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 810 loop: 1 cel: 0 setCycle: End self)
			)
			(9
				(if (not (IsFlag 39))
					(Graph grFILL_BOX 0 0 200 320 3 0 0)
					(Graph grUPDATE_BOX 0 0 200 320 1)
					(gCast eachElementDo: #dispose)
					(SetFlag 39)
					(gCurRoom newRoom: 86)
				else
					(= global330 719)
					(EgoDead)
				)
			)
		)
	)
)

(instance drinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 8))
			)
			(1
				(client setCycle: CT 3 1)
				(= seconds 3)
			)
			(2
				(client setCycle: End self)
				(if (< (Random 1 100) 25)
					(= state -1)
				)
			)
			(3
				(client setCycle: CT 1 1)
				(= seconds 1)
			)
			(4
				(client setCycle: CT 0 -1)
				(= seconds 1)
				(if (< (Random 1 100) 25)
					(= state -1)
				else
					(= state 2)
				)
			)
		)
	)
)

(instance IKArm of Prop
	(properties
		x 159
		y 98
		view 802
		loop 1
		priority 10
		signal 16
	)
)

(instance IKHead of Prop
	(properties
		x 159
		y 88
		view 802
		loop 2
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
					(Say 720)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 724)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance innHead of Prop
	(properties
		view 800
		loop 4
		cycleSpeed 4
	)
)

(instance innKeeper of Actor
	(properties
		x 160
		y 129
		view 802
		signal 1
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
					(Say 720)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 724)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance thugHead of Prop
	(properties
		view 806
		loop 6
		cycleSpeed 4
	)
)

(instance thug1 of Actor
	(properties
		x 170
		y 141
		view 808
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
					(Say 720)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 724)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance thug2Bottom of RPicView
	(properties
		x 150
		y 141
		view 814
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
					(Say 720)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 724)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance thug2 of Prop
	(properties
		x 145
		y 114
		view 814
		loop 1
		priority 10
		signal 16400
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
					(Say 720)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 724)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance dog of Prop
	(properties
		x 233
		y 128
		view 798
		signal 1
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
					(Say 721)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 725)
					(event claimed: 1)
				)
				(5 ; Talk
					(Say 727)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance backRoom of RFeature
	(properties
		nsTop 69
		nsLeft 215
		nsBottom 122
		nsRight 251
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
					(Say 722)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 726)
					(event claimed: 1)
				)
			)
		)
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
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 723)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(10
							(Say 728)
							(++ local0)
							(gEgo setMotion: MoveTo (gEgo x:) 145)
						)
					)
				)
				(5 ; Talk
					(HandsOff)
					(gGlobalSound number: 120 loop: -1 play:)
					(++ local0)
					(gEgo setMotion: MoveTo (gEgo x:) 145)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance smoke1 of View
	(properties
		x 187
		y 3
		view 798
		loop 3
	)
)

(instance smoke2 of View
	(properties
		x 294
		y 7
		view 798
		loop 3
		cel 1
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance smokeOut1 of PicView
	(properties
		x 187
		y 3
		view 292
		loop 3
	)
)

(instance smokeOut2 of PicView
	(properties
		x 294
		y 7
		view 292
		loop 4
	)
)

