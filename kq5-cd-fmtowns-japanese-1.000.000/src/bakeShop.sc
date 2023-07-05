;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 206)
(include sci.sh)
(use Main)
(use Interface)
(use n762)
(use KQ5Room)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	bakeShop 0
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
	local6
	[local7 36] = [0 0 319 0 319 189 176 189 176 170 226 170 207 141 261 141 244 119 144 119 144 112 107 112 95 126 127 126 102 170 146 170 146 189 0 189]
	[local43 9] = [1003 153 74 3 9 24 21 30 29]
	[local52 9] = [1003 183 60 3 9 24 21 30 29]
	[local61 9] = [1018 190 44 4 9 31 22 27 26]
	[local70 9] = [1020 200 67 4 9 26 28 27 33]
	[local79 9] = [1021 178 74 4 11 27 29 22 33]
	[local88 12] = [1 1154 0 1155 1 1156 0 1157 1 1158 0 0]
	[local100 14] = [0 1159 1 1160 0 1161 1 1162 0 1163 1 1164 0 0]
	[local114 6] = [0 1171 1 1188 0 0]
	[local120 8] = [0 1043 1 1044 0 1045 0 0]
	[local128 6] = [0 1046 1 1047 0 0]
	local134
)

(procedure (localproc_0)
	(baker setScript: 0 loop: 3 cel: 0)
)

(instance bakeShop of KQ5Room
	(properties
		picture 924
	)

	(method (init)
		(super init:)
		(HandsOff)
		(gGlobalSound vol: 0 stop:)
		(self
			setFeatures: kitchenDoor counterTop shop
			addObstacle: poly1
			setScript: walkInScript
		)
		(if (IsFlag 25)
			(++ local3)
		)
		(if (gEgo has: 2) ; Pie
			(++ local3)
		)
		(if (and (== ((gInventory at: 2) owner:) 206) (IsFlag 50)) ; Pie
			(pie init:)
		)
		(if (not (IsFlag 50))
			(woman init:)
			(boy init:)
			(arm init:)
			(pie init:)
			(baker cel: 7)
		)
		(smoke init:)
		(cedric init:)
		(baker init:)
		(brother init:)
		(cat init:)
		(if (== (gGame detailLevel:) 3)
			(cat setScript: catScript)
		else
			(cat stopUpd:)
		)
		(tail init: cycleSpeed: 2 setCycle: Fwd)
		(gEgo view: 0 setStep: 3 2 posn: 168 200 setPri: -1 init:)
		(poly1 points: @local7 size: 18)
	)

	(method (doit &tmp temp0)
		(if (and (!= local3 3) (== ((gInventory at: 2) owner:) 1)) ; Pie
			(= local3 3)
		)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 0) $4000)
				(HandsOff)
				(gCurRoom setScript: walkOutScript)
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
		(DisposeScript 941)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(SetFlag 50)
		(gGlobalSound fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance doWinners of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if
			(and
				(OneOf state 1 2 5 9 10 13 15)
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
				(= cycles 3)
			)
			(1
				(Say 1048 self)
				(gTheIconBar enable:)
			)
			(2
				(cls)
				(bakerMouth init: setCycle: RandCycle)
				(Say 1181 self)
			)
			(3
				(bakerMouth z: 1000)
				(cls)
				(arm cycleSpeed: 7 setCycle: End self)
			)
			(4
				(woman cycleSpeed: 2 setCycle: CT 1 1 self)
				(RedrawCast)
			)
			(5
				(Say 1049 self)
			)
			(6
				(cls)
				(arm cel: 0)
				(= cycles 1)
			)
			(7
				(arm dispose:)
				(boy loop: 5 cycleSpeed: 2 setCycle: End self)
				(woman setCycle: Beg)
			)
			(8
				(= seconds 1)
			)
			(9
				(Say 1050 self)
			)
			(10
				(bakerMouth z: 0)
				(Say 1182 self)
			)
			(11
				(bakerMouth dispose:)
				(cls)
				(pie hide:)
				(baker loop: 3 cel: 6)
				(= cycles 15)
			)
			(12
				(woman loop: 2 cel: 1)
				(= cycles 15)
			)
			(13
				(baker view: 226 loop: 3 cel: 7)
				(Say 1051 self)
			)
			(14
				(cls)
				(woman setCycle: End self)
			)
			(15
				(Say 1052 self)
			)
			(16
				(cls)
				(woman loop: 3 cel: 0 setCycle: End self)
			)
			(17
				(gTheIconBar enable:)
				(gTheIconBar disable: 0)
				(User canInput: 1)
				(gGame setCursor: 995 1)
				(= cycles 1)
			)
			(18
				(boy
					setLoop: 0
					cycleSpeed: 4
					moveSpeed: 4
					setCycle: Fwd
					setMotion: PolyPath 168 200
				)
				(= seconds 1)
			)
			(19
				(woman
					setLoop: 1
					cycleSpeed: 4
					moveSpeed: 4
					setCycle: Fwd
					setMotion: PolyPath 224 128 self
				)
			)
			(20
				(woman setMotion: PolyPath 168 200 self)
			)
			(21
				(boy dispose:)
				(woman dispose:)
				(gCurRoom setScript: greet)
			)
		)
	)
)

(instance walkInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(gGlobalSound number: 61 loop: -1 playBed:)
				(gEgo setMotion: MoveTo 168 148 self)
			)
			(2
				(if (not (IsFlag 50))
					(gCurRoom setScript: doWinners)
				else
					(if (> (gGame detailLevel:) 1)
						(brother setScript: brotherScript)
					else
						(brother stopUpd:)
					)
					(gCurRoom setScript: greetAgain)
				)
			)
		)
	)
)

(instance walkOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 168 200 self)
			)
			(1
				(gCurRoom newRoom: 6)
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
				(= cycles 10)
			)
			(1
				(brother cycleSpeed: 2 setCycle: Beg self)
			)
			(2
				(brother loop: 12 setCycle: CT 2 1 self)
			)
			(3
				(baker view: 226 loop: 3 cel: 0)
				(theMouth init: setCycle: RandCycle)
				(Say 1178 self)
			)
			(4
				(cls)
				(brother setCycle: End)
				(baker setCycle: End self)
				(theMouth dispose:)
			)
			(5
				(pie show:)
				(= cycles 20)
			)
			(6
				(proc762_1 @local61 1179)
				(= cycles 1)
			)
			(7
				(if (> (gGame detailLevel:) 1)
					(brother setScript: brotherScript)
				else
					(brother stopUpd:)
				)
				(proc762_1 @local61 1180)
				(= cycles 1)
			)
			(8
				(gTheIconBar enable: 0)
				(baker setScript: bakerScript)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance greetAgain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baker view: 225 loop: 0 setCycle: End self)
			)
			(1
				(cond
					((== ((gInventory at: 2) owner:) 206) ; Pie
						(proc762_1 @local61 1175)
					)
					((== ((gInventory at: 2) owner:) gEgo) ; Pie
						(proc762_1 @local61 1176)
					)
					(else
						(proc762_1 @local61 1177)
					)
				)
				(= cycles 1)
			)
			(2
				(if (== ((gInventory at: 2) owner:) 206) ; Pie
					(greet start: 7)
					(gCurRoom setScript: greet)
				else
					(baker setScript: bakerScript)
					(HandsOn)
					(client setScript: 0)
				)
			)
		)
	)
)

(instance doPie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 198 120 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 226 loop: 4 cel: 0 setCycle: CT 3 1)
				(= seconds 2)
			)
			(2
				(localproc_0)
				(= cycles 1)
			)
			(3
				(proc762_0 @local52 @local61 @local88 self)
			)
			(4
				(gEgo setCycle: End)
				(= cycles 1)
			)
			(5
				(gEgo
					view: 0
					setLoop: 0
					setMotion: 0
					setCycle: SyncWalk
					normal: 1
				)
				((gEgo head:) show:)
				(gEgo setLoop: -1)
				(= cycles 1)
			)
			(6
				(baker setScript: bakerScript)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance talkBakerScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0
					(GetAngle (gEgo x:) (gEgo y:) (baker x:) (baker y:))
				)
				(gEgo
					cel:
						(cond
							((< temp0 45) 3)
							((< temp0 135) 0)
							((< temp0 225) 2)
							((< temp0 315) 1)
							(else 3)
						)
				)
				(localproc_0)
				(proc762_0 @local52 @local61 @local100 self)
			)
			(1
				(baker setScript: bakerScript)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getPie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 198 120 self)
			)
			(1
				(proc0_7 gEgo baker)
				(= cycles 2)
			)
			(2
				(proc762_1 @local52 1165)
				(localproc_0)
				(= cycles 1)
			)
			(3
				(proc762_1 @local61 1166)
				(= cycles 1)
			)
			(4
				(switch local6
					(0
						(proc762_1 @local52 1167)
					)
					(3
						(proc762_1 @local52 1168)
					)
					(1
						(proc762_1 @local52 1169)
					)
					(2
						(proc762_1 @local52 1170)
					)
				)
				(= cycles 1)
			)
			(5
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 226
					loop: 4
					cel: 0
					setCycle: CT 3 1 self
				)
				(gEgo get: 2) ; Pie
				(= local3 2)
				(SetFlag 25)
				(SetScore 2)
				(switch local6
					(0
						(gEgo put: 4 206) ; Coin
					)
					(3
						(gEgo put: 11 206) ; Gold_Coin
					)
					(1
						(gEgo put: 3 206) ; Golden_Needle
					)
					(2
						(gEgo put: 9 206) ; Heart
					)
				)
			)
			(6
				(switch local6
					(0
						(proc762_1 @local61 1171)
					)
					(else
						(proc762_1 @local61 1172)
					)
				)
				(= cycles 1)
			)
			(7
				(gEgo setCycle: End)
				(switch local6
					(0
						(proc762_1 @local52 1173)
					)
					(else
						(proc762_1 @local52 1174)
					)
				)
				(pie dispose:)
				(= cycles 1)
			)
			(8
				(gEgo
					view: 0
					setLoop: 0
					setMotion: 0
					setCycle: SyncWalk
					normal: 1
				)
				((gEgo head:) show:)
				(gEgo setLoop: -1)
				(baker setScript: bakerScript)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance bakerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baker view: 225 loop: 3 cel: 0 setCycle: End)
				(= cycles (Random 80 140))
			)
			(1
				(baker setCycle: CT 1 -1)
				(= cycles 6)
			)
			(2
				(baker setCycle: End self)
				(= cycles (Random 50 100))
			)
			(3
				(baker setCycle: Beg)
				(= cycles (Random 60 120))
			)
			(4
				(baker loop: 4 cel: 0 setCycle: CT 6 1)
				(= cycles 12)
			)
			(5
				(if (Random 0 1)
					(baker setCycle: CT 3 -1 self)
				else
					(baker setCycle: End self)
				)
			)
			(6
				(baker setCycle: End)
				(= cycles (Random 60 120))
			)
			(7
				(baker loop: 1 setCycle: Fwd)
				(= cycles (Random 40 60))
			)
			(8
				(if (gCurRoom script:)
					(= cycles 1)
				else
					(baker loop: 0 cel: 7 setCycle: Beg self)
				)
			)
			(9
				(baker setCycle: End self)
			)
			(10
				(baker view: 225 loop: 3 cel: 0 setCycle: End)
				(= cycles (Random 80 140))
			)
			(11
				(baker setCycle: CT 1 -1)
				(= cycles (Random 50 100))
			)
			(12
				(baker setCycle: End)
				(= cycles (Random 80 140))
			)
			(13
				(baker setCycle: Beg)
				(= cycles (Random 80 140))
			)
			(14
				(if (gCurRoom script:)
					(self init:)
				else
					(baker loop: 2 setCycle: CT 3 1)
					(= cycles 50)
				)
			)
			(15
				(baker setCycle: End self)
			)
			(16
				(self init:)
			)
		)
	)
)

(instance catScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (Random 1 1000) 100)
					(= state 2)
				)
				(= cycles (Random 5 12))
			)
			(1
				(cat loop: 6 setCycle: End self)
			)
			(2
				(cat loop: 6 setCycle: Beg self)
				(= state -1)
			)
			(3
				(tail hide:)
				(cat loop: (+ 2 register) cel: 0 setCycle: CT 4 1 self)
			)
			(4
				(cat
					cycleSpeed: 1
					setCycle: Walk
					xStep: 1
					setMotion:
						MoveTo
						(if register
							(- (cat x:) 20)
						else
							(+ (cat x:) 20)
						)
						(cat y:)
						self
				)
			)
			(5
				(cat
					loop: (+ 4 register)
					cel: 0
					cycleSpeed: 2
					setCycle: CT 5 1 self
				)
			)
			(6
				(if (Random 0 1)
					(cat cel: 1)
				)
				(cat setCycle: End self)
			)
			(7
				(tail show: setCycle: Fwd)
				(= cycles (Random 200 400))
			)
			(8
				(= register (not register))
				(self init:)
			)
		)
	)
)

(instance brotherScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(brother
					setLoop: (brother loop:)
					setCel: (brother cel:)
					setMotion: MoveTo 221 80 self
				)
			)
			(1
				(brother
					setCel: -1
					cel: 0
					setLoop: -1
					loop: 7
					setCycle: End self
				)
			)
			(2
				(brother loop: 9 cel: 0 cycleSpeed: 3 setCycle: End)
				(= seconds (Random 1 3))
				(if (< (Random 1 100) 50)
					(-- state)
				)
			)
			(3
				(brother loop: 7 cel: 6 cycleSpeed: 2 setCycle: Beg self)
			)
			(4
				(brother loop: 8 cel: 2 cycleSpeed: 3 setCycle: Beg self)
			)
			(5
				(brother loop: 11 cycleSpeed: 2 setCycle: Fwd)
				(= cycles (Random 80 200))
			)
			(6
				(brother loop: 8 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(7
				(if (Random 0 1)
					(brother
						setLoop: 14
						setCycle: Fwd
						setMotion:
							MoveTo
							(if (Random 0 1)
								(- (brother x:) 140)
							else
								167
							)
							(brother y:)
							self
					)
				else
					(self init:)
				)
			)
			(8
				(= cycles (Random 10 40))
			)
			(9
				(brother setLoop: 13 setMotion: MoveTo 221 (brother y:) self)
			)
			(10
				(brother setLoop: -1)
				(if (Random 0 1)
					(self start: 4)
				else
					(self start: 0)
				)
				(self init:)
			)
		)
	)
)

(instance boyTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(= local134 (gGame setCursor: 69))
				(proc762_0 @local43 @local79 @local120 self)
			)
			(1
				(gGame setCursor: local134)
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance womanTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(= local134 (gGame setCursor: 69))
				(proc762_0 @local43 @local70 @local128 self)
			)
			(1
				(gGame setCursor: local134)
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance baker of Actor
	(properties
		x 206
		y 88
		view 226
		loop 3
		priority 7
		signal 16
		cycleSpeed 2
		illegalBits 0
	)

	(method (handleEvent event &tmp temp0)
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
					(Say 1)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 9056)
					(event claimed: 1)
				)
				(5 ; Talk
					(if (not (gCurRoom script:))
						(switch local3
							(0
								(++ local3)
								(HandsOff)
								(gCurRoom setScript: talkBakerScript)
								(event claimed: 1)
							)
							(1
								(SetFlag 25)
								(Say 9057)
								(event claimed: 1)
							)
							(2
								(= temp0 (gGame setCursor: 51))
								(proc762_0 @local61 @local52 @local114)
								(gGame setCursor: temp0)
								(event claimed: 1)
							)
							(3
								(SetFlag 25)
								(Say 13)
								(event claimed: 1)
							)
						)
					)
				)
				(4 ; Inventory
					(cond
						((== (gInventory indexOf: (gTheIconBar curInvIcon:)) 28)
							(event claimed: 0)
						)
						((not (gCurRoom script:))
							(cond
								((== ((gInventory at: 2) owner:) 206) ; Pie
									(switch
										(gInventory
											indexOf: (gTheIconBar curInvIcon:)
										)
										(4
											(event claimed: 1)
											(= local6 0)
											(gCurRoom setScript: getPie)
										)
										(11
											(event claimed: 1)
											(= local6 3)
											(gCurRoom setScript: getPie)
										)
										(3
											(event claimed: 1)
											(= local6 1)
											(gCurRoom setScript: getPie)
										)
										(9
											(event claimed: 1)
											(= local6 2)
											(gCurRoom setScript: getPie)
										)
										(else
											(Say 19)
											(event claimed: 1)
										)
									)
								)
								((== ((gInventory at: 2) owner:) gEgo) ; Pie
									(Say 20)
									(event claimed: 1)
								)
								(else
									(Say 13)
									(event claimed: 1)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance theMouth of Prop
	(properties
		x 220
		y 61
		view 225
		loop 5
		priority 15
		signal 16400
		cycleSpeed 2
	)
)

(instance bakerMouth of Prop
	(properties
		x 207
		y 70
		view 225
		loop 6
		priority 15
		signal 16400
		cycleSpeed 2
	)
)

(instance brother of Actor
	(properties
		x 221
		y 80
		view 224
		loop 8
		cel 2
		signal 16384
		cycleSpeed 3
		illegalBits 0
		xStep 2
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
				(& (OnControl CONTROL (event x:) (event y:)) $0004)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 2)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 9)
					(event claimed: 1)
				)
				(5 ; Talk
					(Say 14)
					(event claimed: 1)
				)
				(4 ; Inventory
					(if (== (gInventory indexOf: (gTheIconBar curInvIcon:)) 28)
						(event claimed: 0)
					else
						(Say 21)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance tail of Prop
	(properties
		x 126
		y 107
		view 224
		loop 15
		signal 16384
		cycleSpeed 2
	)

	(method (doit)
		(super doit:)
		(switch (cat loop:)
			(4
				(self x: (- (cat x:) 7))
			)
			(5
				(self x: (+ (cat x:) 6))
			)
			(6
				(self x: (cat x:))
			)
		)
	)
)

(instance cat of Actor
	(properties
		x 126
		y 107
		view 224
		loop 6
		cycleSpeed 2
		xStep 1
		moveSpeed 1
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
					(Say 3)
					(event claimed: 1)
				)
				(5 ; Talk
					(Say 15)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 10)
					(event claimed: 1)
				)
				(4 ; Inventory
					(if (== (gInventory indexOf: (gTheIconBar curInvIcon:)) 28)
						(event claimed: 0)
					else
						(Say 22)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance pie of Prop
	(properties
		x 206
		y 93
		view 224
		loop 10
		cel 1
		priority 8
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
					(Say 4)
					(event claimed: 1)
				)
				(3 ; Do
					(if (not (gCurRoom script:))
						(cond
							(
								(and
									(not local2)
									(== ((gInventory at: 2) owner:) 206) ; Pie
								)
								(++ local2)
								(HandsOff)
								(gCurRoom setScript: doPie)
								(event claimed: 1)
							)
							((gEgo has: 2) ; Pie
								(Say 11)
								(event claimed: 1)
							)
							(else
								(Say 12)
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance kitchenDoor of RFeature
	(properties
		nsTop 53
		nsLeft 122
		nsBottom 104
		nsRight 155
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
					(Say 5)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 16)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance shop of RFeature
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
					(Say 6)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance counterTop of RFeature
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
					(Say 4)
					(event claimed: 1)
				)
				(3 ; Do
					(if (not (gCurRoom script:))
						(cond
							(
								(and
									(not local2)
									(== ((gInventory at: 2) owner:) 206) ; Pie
								)
								(++ local2)
								(HandsOff)
								(gCurRoom setScript: doPie)
								(event claimed: 1)
							)
							((gEgo has: 2) ; Pie
								(Say 11)
								(event claimed: 1)
							)
							(else
								(Say 12)
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 146
		y 5
		view 221
		loop 7
		cycleSpeed 5
	)
)

(instance boy of Actor
	(properties
		x 215
		y 120
		view 550
		loop 6
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
					(Say 7)
					(event claimed: 1)
				)
				(5 ; Talk
					(event claimed: 1)
					(if (or local5 (> (boy y:) (+ (gEgo y:) 25)))
						(Say 17)
					else
						(++ local5)
						(User canInput: 0)
						(boy setScript: boyTalk)
					)
				)
			)
		)
	)
)

(instance woman of Actor
	(properties
		x 214
		y 118
		view 550
		loop 4
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
					(Say 8)
					(event claimed: 1)
				)
				(5 ; Talk
					(event claimed: 1)
					(if (or local4 (> (woman y:) (+ (gEgo y:) 25)))
						(Say 18)
					else
						(++ local4)
						(User canInput: 0)
						(woman setScript: womanTalk)
					)
				)
			)
		)
	)
)

(instance arm of Actor
	(properties
		x 226
		y 99
		view 550
		loop 7
		priority 8
		signal 16
	)
)

(instance cedric of View
	(properties
		x 46
		y 121
		view 225
		loop 7
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

