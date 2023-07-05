;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 204)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
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
				(boyHead setCycle: Fwd init:)
				(= temp0 8)
				(switch global363
					(0
						(Print 204 0 #at 90 10 #dispose) ; "The shipment of carving wood hasn't come in yet. What should we do?"
					)
					(1
						(Print 204 1 #at 90 10 #dispose) ; "Papa, where did you put those new doll clothes Mama made?"
					)
					(2
						(Print 204 2 #at 90 10 #dispose) ; "Papa, Mama wants you to know that it's almost lunchtime."
					)
					(3
						(Print 204 3 #at 90 10 #dispose) ; "I'm going to count up the cash receipts from yesterday, okay?"
					)
					(4
						(Print 204 4 #at 90 10 #dispose) ; "Is Katrina behaving herself, Papa?"
						(= temp0 6)
					)
					(5
						(Print 204 5 #at 90 10 #dispose) ; "Papa, where is the puppet string?"
						(= temp0 6)
					)
					(else
						(Print 204 6 #at 90 10 #dispose) ; "Papa, don't forget Mr. Richards is coming by tomorrow to pick up the wagon for his son."
						(= temp0 12)
					)
				)
				(= seconds temp0)
			)
			(2
				(boyHead hide:)
				(theMouth x: 161 setCycle: Fwd init:)
				(= temp0 8)
				(switch global363
					(0
						(Print 204 7 #at 10 10 #dispose) ; "If it's not in by tomorrow I'll send you to visit the sawmill."
						(= temp0 10)
					)
					(1
						(Print 204 8 #at 10 10 #dispose) ; "Look in the trunk upstairs. I think I put them there."
					)
					(2
						(Print 204 9 #at 10 10 #dispose) ; "Okay, son. Tell her I'll be in soon."
					)
					(3
						(Print 204 10 #at 10 10 #dispose) ; "That's a good idea, son."
						(= temp0 5)
					)
					(4
						(Print 204 11 #at 10 10 #dispose) ; "She's fine, son. I've got my eye on her."
					)
					(5
						(Print 204 12 #at 10 10 #dispose) ; "Hmmmm. I think it's in the small cupboard. Look there."
					)
					(else
						(Print 204 13 #at 10 10 #dispose) ; "I haven't forgotten. It's all ready to go."
						(= temp0 6)
					)
				)
				(= seconds temp0)
			)
			(3
				(theMouth setCycle: 0 setCel: 0)
				(boyHead show:)
				(= temp0 3)
				(switch global363
					(0
						(Print 204 14 #at 90 10 #dispose) ; "Okay, Papa."
					)
					(1
						(Print 204 15 #at 90 10 #dispose) ; "I'll do that."
					)
					(4
						(Print 204 16 #at 90 10 #dispose) ; "Okay, but let me know if she's bothering you."
						(= temp0 6)
					)
					(5
						(Print 204 17 #at 90 10 #dispose) ; "Okay."
					)
					(else
						(= temp0 1)
					)
				)
				(= seconds temp0)
			)
			(4
				(boyHead dispose:)
				(cls)
				(door setCycle: Beg self)
			)
			(5
				(gTheIconBar enable:)
				(theMouth dispose:)
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
				(= cycles 5)
			)
			(1
				(gEgo setMotion: MoveTo 215 140 self)
			)
			(2
				(proc0_28 192 204 18 67 10 10 25 7) ; "Come on in! Look around! Let me know if you're interested in anything."
				(HandsOn)
				(cls)
				(client setScript: 0)
				(toyMaker setScript: buildToy)
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
				(proc0_28 192 204 19 67 10 10 25 7) ; "That's a fine sled, isn't it? Any child would love to have it."
				(proc0_28 160 204 20 67 10 10 25 6) ; "Yes. I was just admiring the workmanship."
				(RedrawCast)
				(proc0_28 192 204 21 67 10 10 25 7) ; "Thank you. If you'd like to buy it, let me know."
				(= cycles 1)
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
				(girlHead setCycle: Fwd init:)
				(PrintDC 204 22 #at 10 10 #dispose) ; "Grandpapa?"
				(= seconds 3)
			)
			(2
				(toyHead loop: 15 x: 158 init:)
				(= cycles 1)
			)
			(3
				(girlHead hide:)
				(PrintDC 204 23 #at 110 10 #dispose) ; "Yes, my darling?"
				(= seconds 3)
				(theMouth setCycle: Fwd x: 157 init:)
			)
			(4
				(girlHead show:)
				(PrintDC 204 24 #at 10 10 #dispose) ; "Can I keep this doll? I really like her."
				(= seconds 6)
				(theMouth hide:)
			)
			(5
				(girlHead hide:)
				(PrintDC 204 25 #at 110 10 #dispose) ; "Now, Katrina. You know these toys are for sale for other children. Besides, you've got plenty of dolls. You can play with her, but just be careful."
				(= seconds 10)
				(theMouth show:)
			)
			(6
				(girlHead show:)
				(theMouth dispose:)
				(PrintDC 204 26 #at 10 10 #dispose) ; "All right, Grandpapa. I'll take care of her."
				(= seconds 6)
			)
			(7
				(girlHead dispose:)
				(theMouth dispose:)
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
				(proc0_28 160 204 27 67 10 10 25 8) ; "This is a fine little toyshop you have here. You must be very proud."
				(RedrawCast)
				(proc0_28 192 204 28 67 10 10 25 10) ; "Thank you, son. I've worked very hard at it over the years. But you know, you need to really love it... and I do."
				(RedrawCast)
				(proc0_28 160 204 29 67 10 10 25 5) ; "Are most of these toys your creations?"
				(RedrawCast)
				(proc0_28 192 204 30 67 10 10 25 10) ; "Yes, most of them. But not all. Some my son made, some I bought, some I traded for."
				(RedrawCast)
				(proc0_28 160 204 31 67 10 10 25 5) ; "You're very talented."
				(RedrawCast)
				(proc0_28 192 204 32 67 10 10 25 8) ; "Thank you, thank you. Well, let me know if I can help you."
				(= cycles 1)
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
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(6
				(switch local4
					(0
						(proc0_28 192 204 33 67 10 10 25 8) ; "Where did you get this wonderful marionette? The craftmanship is excellent!"
						(RedrawCast)
						(proc0_28 160 204 34 67 10 10 25 8) ; "Well, I don't know if you'll believe me or not, but I got it from a little gnome."
						(RedrawCast)
						(proc0_28 192 204 35 67 10 10 25 6) ; "I must have it! Can I buy it from you?"
						(RedrawCast)
						(proc0_28 160 204 36 67 10 10 25 6) ; "Actually, you may have it...IF you'll give me the sled in trade."
						(RedrawCast)
						(proc0_28 192 204 37 67 10 10 70 210 25 14) ; "Why, of course! But I must tell you...I think I'm getting the better deal. I can always make another sled, but finding another marionette of this quality...I don't know."
						(RedrawCast)
						(proc0_28 160 204 38 67 10 10 25 5) ; "So, I can have the sled?"
						(RedrawCast)
						(proc0_28 192 204 39 67 10 10 25 5) ; "Yes, yes! Take it. It's yours."
					)
					(1
						(proc0_28 160 204 40 67 10 10 25 5) ; "Will you take a golden needle in trade for the sled?"
						(RedrawCast)
						(proc0_28 192 204 41 67 10 10 25 10) ; "This is an awfully small needle, but... I'm in a generous mood today. Okay, why not! Go ahead and take the sled. It's all yours!"
					)
					(2
						(proc0_28 160 204 42 67 10 10 25 7) ; "Will you take a golden heart in trade for the sled?"
						(RedrawCast)
						(proc0_28 192 204 43 67 10 10 25 10) ; "This beautiful golden heart is worth MUCH more than the little sled! Are you sure about this?"
						(RedrawCast)
						(proc0_28 160 204 44 67 10 10 25 7) ; "Yes, I'm sure. I would like to have the sled."
						(RedrawCast)
						(proc0_28 192 204 45 67 10 10 25 10) ; "Well...okay. But I'm getting the MUCH better deal. Go ahead and take the sled."
					)
					(3
						(proc0_28 160 204 46 67 10 10 25 7) ; "Will you take a gold coin in trade for the sled?"
						(RedrawCast)
						(proc0_28 192 204 47 67 10 10 25 10) ; "This gold coin is worth MUCH more than the little sled! Are you sure about this?"
						(RedrawCast)
						(proc0_28 160 204 48 67 10 10 25 7) ; "Yes, I'm sure. I would like to have the sled."
						(RedrawCast)
						(proc0_28 192 204 49 67 10 10 25 10) ; "Well...okay. But I'm getting the MUCH better deal. Go ahead and take the sled."
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
				(proc0_28 160 204 50 67 10 100 25 5) ; "Thank you very much. I think I'll find this sled very useful."
				(RedrawCast)
				(switch local4
					(0
						(proc0_28 192 204 51 67 10 10 25 7) ; "Well, you enjoy it. And thank YOU for the marionette."
					)
					(else
						(proc0_28 192 204 52 67 10 10 25 4) ; "Well, you enjoy it."
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
					setCycle: KQ5SyncWalk
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
					(PrintDC 204 53 #at 10 10) ; "The plump old toymaker, who seems a jolly sort, carefully mends a toy while sitting comfortably behind the counter."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 204 54 #at 10 10) ; "The old toymaker gives Graham the courtesy to look around the shop without pestering him."
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
						(PrintDC 204 55 #at 10 10) ; "Not wanting to bother the toymaker again, Graham instead looks around the toyshop."
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
								(PrintDC 204 56) ; "Graham sees nothing else of interest in the toyshop."
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
								(PrintDC 204 56) ; "Graham sees nothing else of interest in the toyshop."
							)
							(event claimed: 1)
						)
						(9
							(if (not (gEgo has: 29)) ; Sled
								(= local4 2)
								(toyShop setScript: getSled)
							else
								(PrintDC 204 56) ; "Graham sees nothing else of interest in the toyshop."
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
								(proc0_28 160 204 57 67 10 10 25 6) ; "Can I buy the sled with a silver coin?"
								(proc0_28 192 204 58 67 10 10 25 8) ; "No, I'm sorry. I'd love to sell it to you, but I'm afraid I need a bit more than that."
							else
								(PrintDC 204 56) ; "Graham sees nothing else of interest in the toyshop."
							)
							(event claimed: 1)
						)
						(11
							(if (not (gEgo has: 29)) ; Sled
								(= local4 3)
								(toyShop setScript: getSled)
							else
								(PrintDC 204 56) ; "Graham sees nothing else of interest in the toyshop."
							)
							(event claimed: 1)
						)
						(else
							(PrintDC 204 59 #at 10 10) ; "The toymaker wouldn't find that suitable for his business."
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
					(PrintDC 204 60 #at 10 10) ; "Hanging on a side wall, Graham notices a strong little sled."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local2)
						(++ local2)
						(toyShop setScript: lookSled)
					else
						(PrintDC 204 61 #at 10 10) ; "The little sled has captured Graham's interest."
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
							(proc0_28 160 204 57 67 10 10 25 6) ; "Can I buy the sled with a silver coin?"
							(proc0_28 192 204 58 67 10 10 25 8) ; "No, I'm sorry. I'd love to sell it to you, but I'm afraid I need a bit more than that."
							(event claimed: 1)
						)
						(else
							(PrintDC 204 59 #at 10 10) ; "The toymaker wouldn't find that suitable for his business."
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
					(PrintDC 204 62 #at 10 10) ; "Apparently the toymaker's son, working in the back room, is learning the toy business from his father."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 204 63 #at 10 10) ; "The back door is for employees only."
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
					(PrintDC 204 64 #at 10 10) ; "A pet goldfish swims endlessly around its fishbowl."
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
					(PrintDC 204 65 #at 10 10) ; "A pretty little girl, who must be the toymaker's granddaughter, plays with a doll while Grandfather looks on."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 204 66 #at 10 10) ; "The little girl seems happy enough playing with the doll. She needs nothing more."
					(event claimed: 1)
				)
				(5 ; Talk
					(PrintDC 204 67 #at 10 10) ; "The little girl is too interested in her doll. She pays no attention to Graham."
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 204 68) ; "The little girl only seems to care about the doll she's playing with."
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
					(PrintDC 204 69 #at 10 10) ; "A child's wonderland of toys fills this cute little toyshop."
					(event claimed: 1)
				)
			)
		)
	)
)

