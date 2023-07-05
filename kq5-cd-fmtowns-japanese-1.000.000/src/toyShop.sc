;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 204)
(include sci.sh)
(use Main)
(use Interface)
(use n762)
(use Sync)
(use PolyPath)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	toyShop 0
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	[local9 9] = [1019 140 48 3 11 26 20 24 27]
	[local18 9] = [1003 140 70 4 11 25 23 31 31]
	[local27 9] = [1003 200 70 4 11 25 23 31 31]
	[local36 8] = [0 5007 1 5008 0 5009 0 0]
	[local44 14] = [0 5010 1 5011 0 5012 1 5013 0 5014 1 5015 0 0]
	[local58 16] = [0 5016 1 5017 0 5018 1 5019 0 5020 1 5021 0 5022 0 0]
	[local74 6] = [0 5023 1 5024 0 0]
	[local80 10] = [0 5025 1 5026 0 5027 1 5028 0 0]
	[local90 10] = [0 5029 1 5030 0 5031 1 5032 0 0]
	[local100 6] = [0 5036 1 5037 0 0]
)

(instance toyShop of Rgn
	(properties)

	(method (init)
		(super init:)
		(gCurRoom setFeatures: fishBowl shopRoom)
		(gGlobalSound number: 61 loop: -1 play:)
		(door init:)
		(fish cycleSpeed: 3 setCycle: Fwd init:)
		(toyMaker init:)
		(gCurRoom setScript: greet)
		(lArm init:)
		(rArm init:)
		(girl setScript: girlPlay init:)
		(if (== ((gInventory at: 29) owner:) 204) ; Sled
			(sled init:)
		)
		(= local8 100)
	)

	(method (doit &tmp [temp0 2])
		(if (< global363 7)
			(++ local5)
		else
			(= global363 0)
		)
		(if (< local6 1005)
			(++ local6)
		)
		(cond
			(script
				(script doit:)
			)
			((and (>= local5 local8) (not (gCurRoom script:)))
				(= local8 1000)
				(gTheIconBar disable:)
				(HandsOff)
				(self setScript: sonScript)
			)
			(
				(and
					(>= local6 200)
					(not local7)
					(not (gCurRoom script:))
					(== (girl loop:) 2)
				)
				(gTheIconBar disable:)
				(HandsOff)
				(= local5 0)
				(++ local7)
				(self setScript: girlTalk)
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
		(super dispose:)
	)
)

(instance sonScript of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (Event new:))
		(if (or (== (temp0 type:) evMOUSEBUTTON) (== (temp0 type:) evKEYBOARD))
			(= seconds 0)
			(= cycles 1)
		)
		(temp0 dispose:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(door setCycle: End self)
			)
			(1
				(toyMaker setScript: 0 setCycle: 0)
				(toyHead loop: 14 x: 159 show: init:)
				(boyHead init:)
				(= temp0 8)
				(switch global363
					(0
						(boyHead setCycle: MouthSync 5038)
						(Say 5038 self)
					)
					(1
						(boyHead setCycle: MouthSync 5039)
						(Say 5039 self)
					)
					(2
						(boyHead setCycle: MouthSync 5040)
						(Say 5040 self)
					)
					(3
						(boyHead setCycle: MouthSync 5041)
						(Say 5041 self)
					)
					(4
						(boyHead setCycle: MouthSync 5042)
						(Say 5042 self)
					)
					(5
						(boyHead setCycle: MouthSync 5043)
						(Say 5043 self)
					)
					(else
						(boyHead setCycle: MouthSync 5044)
						(Say 5044 self)
					)
				)
			)
			(2
				(theMouth x: 161 init:)
				(boyHead setCycle: 0 hide:)
				(= temp0 8)
				(switch global363
					(0
						(theMouth setCycle: MouthSync 5049)
						(Say 5049 self)
					)
					(1
						(theMouth setCycle: MouthSync 5050)
						(Say 5050 self)
					)
					(2
						(theMouth setCycle: MouthSync 5051)
						(Say 5051 self)
					)
					(3
						(theMouth setCycle: MouthSync 5052)
						(Say 5052 self)
					)
					(4
						(theMouth setCycle: MouthSync 5053)
						(Say 5053 self)
					)
					(5
						(theMouth setCycle: MouthSync 5054)
						(Say 5054 self)
					)
					(else
						(theMouth setCycle: MouthSync 5055)
						(Say 5055 self)
					)
				)
			)
			(3
				(theMouth setCycle: 0 dispose:)
				(boyHead show:)
				(= temp0 3)
				(switch global363
					(0
						(boyHead setCycle: MouthSync 5045)
						(Say 5045 self)
					)
					(1
						(boyHead setCycle: MouthSync 5046)
						(Say 5046 self)
					)
					(4
						(boyHead setCycle: MouthSync 5047)
						(Say 5047 self)
					)
					(5
						(boyHead setCycle: MouthSync 5048)
						(Say 5048 self)
					)
					(else
						(= seconds 1)
					)
				)
			)
			(4
				(boyHead setCycle: 0 dispose:)
				(cls)
				(door setCycle: Beg self)
			)
			(5
				(gTheIconBar enable:)
				(toyHead dispose:)
				(= local5 0)
				(++ global363)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance greet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(toyMaker setScript: buildToy)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: MoveTo 215 140 self)
			)
			(2
				(proc762_1 @local9 5006)
				(HandsOn)
				(cls)
				(client setScript: 0)
			)
		)
	)
)

(instance lookSled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 225 139 self)
			)
			(1
				(proc0_7 gEgo toyMaker 5)
				(= cycles 3)
			)
			(2
				(proc762_0 @local9 @local18 @local36 self)
			)
			(3
				(= local5 0)
				(= local6 0)
				(theMouth dispose:)
				(HandsOn)
				(cls)
				(toyMaker setScript: buildToy)
				(client setScript: 0)
			)
		)
	)
)

(instance buildToy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lArm show: loop: 5 stopUpd:)
				(rArm show: loop: 6 x: 160 setCycle: Fwd)
				(= seconds (Random 3 8))
			)
			(1
				(rArm setCycle: End)
				(= seconds (Random 3 8))
				(= state -1)
			)
			(2
				(toyMaker loop: 0 cycleSpeed: 3 setCycle: Fwd)
			)
		)
	)
)

(instance girlPlay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(girl loop: 0 cycleSpeed: 2 setCycle: End)
				(= seconds (Random 3 8))
			)
			(1
				(girl setCycle: Beg self)
			)
			(2
				(girl loop: 1 setCycle: End self)
			)
			(3
				(girl loop: 3 cycleSpeed: 4 setCycle: Fwd)
				(= seconds (Random 5 10))
			)
			(4
				(girl loop: 1 cycleSpeed: 1 setCycle: Beg self)
			)
			(5
				(girl loop: 2 cycleSpeed: 4 setCycle: Fwd)
				(= seconds (Random 5 10))
				(= state -1)
			)
		)
	)
)

(instance girlTalk of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (Event new:))
		(if (or (== (temp0 type:) evMOUSEBUTTON) (== (temp0 type:) evKEYBOARD))
			(= seconds 0)
			(= cycles 1)
		)
		(temp0 dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(girl loop: 4 cel: 0 setScript: 0 setCycle: End self)
			)
			(1
				(girlHead init: setCycle: MouthSync 5001)
				(Say 5001 self)
			)
			(2
				(toyHead loop: 15 x: 158 init:)
				(= cycles 1)
			)
			(3
				(girlHead setCycle: 0 hide:)
				(theMouth x: 157 init: setCycle: MouthSync 5002)
				(Say 5002 self)
			)
			(4
				(theMouth setCycle: 0 hide:)
				(girlHead show: setCycle: MouthSync 5003)
				(Say 5003 self)
			)
			(5
				(girlHead setCycle: 0 hide:)
				(theMouth show: setCycle: MouthSync 5004)
				(Say 5004 self)
			)
			(6
				(theMouth setCycle: 0 dispose:)
				(girlHead show: setCycle: MouthSync 5005)
				(Say 5005 self)
			)
			(7
				(girlHead setCycle: 0 dispose:)
				(toyHead hide:)
				(cls)
				(HandsOn)
				(gTheIconBar enable:)
				(toyMaker setScript: buildToy)
				(girl setScript: girlPlay)
				(client setScript: 0)
			)
		)
	)
)

(instance manTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(toyMaker setScript: 0)
				(rArm setCycle: 0 loop: 7)
				(= cycles 1)
			)
			(2
				(proc762_0 @local18 @local9 @local44 self)
			)
			(3
				(= local5 0)
				(= local6 0)
				(HandsOn)
				(theMouth dispose:)
				(cls)
				(toyMaker setScript: buildToy)
				(client setScript: 0)
			)
		)
	)
)

(instance getSled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local4
					(0
						(gEgo put: 12 204) ; Marionette
					)
					(1
						(gEgo put: 3 204) ; Golden_Needle
					)
					(2
						(gEgo put: 9 204) ; Heart
					)
					(3
						(gEgo put: 11 204) ; Gold_Coin
					)
				)
				(HandsOff)
				(toyMaker setScript: 0)
				(gEgo setMotion: PolyPath 172 134 self)
			)
			(1
				(if (== local4 0)
					((gEgo head:) hide:)
					(gEgo
						normal: 0
						view: 178
						loop: 12
						cel: 0
						cycleSpeed: 3
						setCycle: CT 1 1 self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(lArm hide:)
				(rArm hide:)
				(toyMaker
					view: 178
					loop: 6
					cel: 0
					cycleSpeed: 3
					setCycle: CT 2 1 self
				)
			)
			(3
				(if (== local4 0)
					(gEgo setCycle: End self)
					(toyMaker setCycle: End self)
				else
					(toyMaker setCycle: Beg self)
					(= cycles 1)
				)
			)
			(4)
			(5
				(gEgo
					normal: 1
					view: 0
					loop: 3
					cycleSpeed: 0
					setCycle: SyncWalk
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(6
				(switch local4
					(0
						(proc762_0 @local9 @local18 @local58)
					)
					(1
						(proc762_0 @local18 @local9 @local74)
					)
					(2
						(proc762_0 @local18 @local9 @local80)
					)
					(3
						(proc762_0 @local18 @local9 @local90)
					)
				)
				(gEgo setMotion: MoveTo 232 131 self)
				(if (== local4 0)
					(toyMaker loop: 11 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(7)
			(8
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 178
					loop: 7
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(9
				(gEgo setCycle: End)
				(sled dispose:)
				(gEgo get: 29) ; Sled
				(proc762_1 @local27 5033)
				(RedrawCast)
				(switch local4
					(0
						(proc762_1 @local9 5035)
					)
					(else
						(proc762_1 @local9 5034)
					)
				)
				(= local5 0)
				(= local6 0)
				(theMouth dispose:)
				(toyMaker view: 182 loop: 1 setScript: buildToy)
				(gEgo
					normal: 1
					view: 0
					loop: 7
					cel: 0
					setCycle: SyncWalk
					setMotion: MoveTo 229 139 self
				)
				((gEgo head:) show:)
			)
			(10
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance rArm of Prop
	(properties
		x 175
		y 87
		view 182
		priority 5
		signal 16
		cycleSpeed 3
	)
)

(instance theMouth of Prop
	(properties
		y 83
		view 182
		loop 2
		priority 6
		signal 16
		cycleSpeed 2
	)
)

(instance lArm of Prop
	(properties
		x 143
		y 85
		view 182
		loop 3
		priority 5
		signal 16
	)
)

(instance toyHead of Prop
	(properties
		y 85
		view 178
		loop 14
		priority 5
		signal 17
		cycleSpeed 2
	)
)

(instance toyMaker of Prop
	(properties
		x 156
		y 97
		view 182
		loop 1
		priority 4
		signal 16
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
					(Say 838)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 9071)
					(event claimed: 1)
				)
				(5 ; Talk
					(if (not (IsFlag 108))
						(SetFlag 108)
						(self setScript: 0)
						(proc0_7 gEgo toyMaker 5)
						(HandsOff)
						(toyShop setScript: manTalk)
					else
						(Say 847)
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(12
							(if (not (gEgo has: 29)) ; Sled
								(SetScore 4)
								(= local4 0)
								(toyShop setScript: getSled)
							else
								(Say 849)
							)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(3
							(if (not (gEgo has: 29)) ; Sled
								(= local4 1)
								(toyShop setScript: getSled)
							else
								(Say 849)
							)
							(event claimed: 1)
						)
						(9
							(if (not (gEgo has: 29)) ; Sled
								(= local4 2)
								(toyShop setScript: getSled)
							else
								(Say 849)
							)
							(event claimed: 1)
						)
						(4
							(if (not (gEgo has: 29)) ; Sled
								(proc0_7 gEgo toyMaker 5)
								(RedrawCast)
								((gEgo head:)
									cel:
										(switch (gEgo loop:)
											(0 1)
											(1 5)
											(2 3)
											(3 7)
										)
									forceUpd:
								)
								(RedrawCast)
								(proc762_0 @local18 @local9 @local100)
							else
								(Say 849)
							)
							(event claimed: 1)
						)
						(11
							(if (not (gEgo has: 29)) ; Sled
								(= local4 3)
								(toyShop setScript: getSled)
							else
								(Say 849)
							)
							(event claimed: 1)
						)
						(else
							(Say 850)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance sled of Prop
	(properties
		x 243
		y 125
		view 178
		loop 1
		priority 9
		signal 17
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
					(Say 839)
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local2)
						(++ local2)
						(toyShop setScript: lookSled)
					else
						(Say 844)
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(12
							(SetScore 4)
							(= local4 0)
							(toyShop setScript: getSled)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(3
							(= local4 1)
							(toyShop setScript: getSled)
							(event claimed: 1)
						)
						(9
							(= local4 2)
							(toyShop setScript: getSled)
							(event claimed: 1)
						)
						(4
							(proc762_0 @local18 @local9 @local100)
							(event claimed: 1)
						)
						(else
							(Say 850)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance boyHead of Prop
	(properties
		x 184
		y 77
		view 178
		loop 13
		priority 2
		signal 17
		cycleSpeed 2
	)
)

(instance door of Prop
	(properties
		x 191
		y 98
		view 178
		loop 2
		priority 1
		signal 17
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
					(Say 840)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 845)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance fish of Prop
	(properties
		x 213
		y 100
		view 178
		priority 9
		signal 16
	)
)

(instance fishBowl of RFeature
	(properties
		nsTop 90
		nsLeft 205
		nsBottom 103
		nsRight 225
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
					(Say 841)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance girlHead of Prop
	(properties
		x 99
		y 119
		view 190
		loop 5
		priority 5
		signal 17
		cycleSpeed 2
	)
)

(instance girl of Actor
	(properties
		x 99
		y 132
		view 190
		priority 2
		signal 16
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
					(Say 842)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 846)
					(event claimed: 1)
				)
				(5 ; Talk
					(Say 848)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(event claimed: 0)
						)
						(else
							(Say 851)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance shopRoom of RFeature
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
					(Say 843)
					(event claimed: 1)
				)
			)
		)
	)
)

