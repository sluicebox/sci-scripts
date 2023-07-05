;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use Interface)
(use CodeCue)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	owl 0
	stdWalkIn 1
	stdWalkOut 2
	rotate 3
	cedric 4
)

(local
	[local0 10] = [1000 116 62 4 11 24 19 23 30 0]
	local10
	local11
	local12
	local13
	[local14 19] = [2 6 7 8 10 11 12 27 29 30 31 35 44 45 46 52 53 54 -1]
	[local33 19] = [0 2 4 6 100 100 8 9 11 100 100 12 100 100 13 100 100 100 -1]
	[local52 19] = [57 58 59 60 61 62 63 64 65 66 66 67 68 69 70 71 72 73 74]
	[local71 14] = [3005 3006 3007 3008 3009 3010 3011 3012 3013 3014 3015 3016 3017 3018]
	local85
)

(procedure (localproc_0)
	(= [local0 1] (Min (Max 0 (- (cedric x:) 40)) 239))
	(= [local0 2] (Min (Max 0 (- (cedric y:) 40)) 239))
)

(instance owl of Rgn
	(properties)

	(method (init)
		(super init:)
		(= local10 138)
		(if
			(or
				(== gCurRoomNum 29)
				(== gCurRoomNum 30)
				(== gCurRoomNum 27)
				(== gCurRoomNum 1)
				(== gCurRoomNum 52)
			)
			(= local10 140)
			(cedric view: 136)
		else
			(cedric view: 137)
		)
		(cedric
			ignoreHorizon: 1
			setPri: 14
			loop: 8
			cel: 0
			setCycle: (if (== (gGame detailLevel:) 3) Walk else 0)
			ignoreActors: 1
			posn: global320 global321
			init:
			stopUpd:
		)
		(if (or (== gCurRoomNum 9) (== gCurRoomNum 32) (== gCurRoomNum 30))
			(cedric setPri: -1)
		)
		(if (or (== ((gInventory at: 16) owner:) 12) (not (gEgo has: 16))) ; Stick, Stick
			(= [local71 8] 3048)
		)
		(= global322 cedric)
		(self setScript: messageTime)
	)

	(method (doit)
		(cond
			((== global322 50)
				(= global322 cedric)
				(= [local71 8] 3048)
			)
			(script
				(script doit:)
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
)

(instance messageTime of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (or (gCurRoom script:) (== (User controls:) 0))
			(= state -1)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 120 240))
			)
			(1
				(if global322
					(localproc_0)
					(proc762_1 @local0 global325 self)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(class regOwl of Actor
	(properties
		speak 0
	)
)

(instance cedric of regOwl
	(properties
		view 138
		illegalBits 0
	)

	(method (delete)
		(if (& signal $8000)
			(if (!= mover -1)
				(self setMotion: 0)
			)
			(self setScript: 0 setCycle: 0)
		)
		(if (& signal $8000)
			(&= signal $7fff)
			(gCast delete: self)
			(if underBits
				(UnLoad 133 underBits)
				(= underBits 0)
			)
			(if (& signal $0020)
				(gAddToPics
					add:
						((PicView new:)
							view: view
							loop: loop
							cel: cel
							x: x
							y: y
							z: z
							priority: priority
							signal: signal
							yourself:
						)
				)
				(gFeatures addToFront: self)
			else
				(DisposeClone self)
			)
			(if (IsObject actions)
				(actions dispose:)
			)
			(= actions 0)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(= temp1 0)
			(switch (event message:)
				(2 ; Look
					(for ((= temp0 0)) (<= temp0 17) ((++ temp0))
						(if (== gCurRoomNum [local14 temp0])
							(= temp1 1)
							(Say [local52 temp0])
							(break)
							(return)
						)
					)
					(if (not temp1)
						(Say [local52 temp0])
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(event claimed: 0)
						)
						(else
							(localproc_0)
							(proc762_1 @local0 3019)
							(event claimed: 1)
						)
					)
				)
				(5 ; Talk
					(for ((= temp0 0)) (<= temp0 15) ((++ temp0))
						(if (== gCurRoomNum [local14 temp0])
							(= temp1 [local33 temp0])
							(= temp2 [local33 (+ temp0 1)])
							(if
								(and
									(== local13 1)
									(or (== temp2 100) (== (- temp2 temp1) 1))
								)
								(= temp1 0)
								(break)
							)
							(if (or (== temp1 100) (== local13 2))
								(= temp1 0)
								(break)
							else
								(localproc_0)
								(proc762_1 @local0 [local71 (+ local13 temp1)])
								(event claimed: 1)
								(++ local13)
								(return)
							)
						)
					)
					(if (not temp1)
						(switch (Random 0 3)
							(0
								(Say 75)
							)
							(1
								(Say 76)
							)
							(2
								(Say 77)
							)
							(else
								(Say 78)
							)
						)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance stdWalkIn of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 2])
		(switch (= state newState)
			(0
				(if (< (gGame detailLevel:) 3)
					(= local85 1)
					(gEgo edgeHit: 0)
					(HandsOff)
					(= register (gCurRoom roomToEdge: gPrevRoomNum))
					(= temp5
						(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
					)
					(= temp4
						(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
					)
					(= temp2 (gEgo x:))
					(= temp3 (gEgo y:))
					(switch register
						(3
							(= temp0 temp2)
							(= temp1 (+ 189 temp5))
						)
						(2
							(= temp1 temp3)
							(= temp0 (+ 319 temp4))
						)
						(4
							(= temp1 temp3)
							(= temp0 (- 0 temp4))
						)
						(1
							(= temp0 temp2)
							(= temp1 (- temp3 2))
						)
					)
					(gEgo
						posn: temp0 temp1
						init:
						setLoop: -1
						ignoreActors: 1
						setMotion: MoveTo temp2 temp3
					)
					(cedric
						view:
							(if (OneOf gCurRoomNum 29 30 27 1 52) 136 else 137)
						loop: 8
						cel: 2
						addToPic:
					)
					(= cycles 1)
				else
					(if (OneOf gCurRoomNum 29 30 27 1 52)
						(cedric view: 140)
					else
						(cedric view: 138)
					)
					(gEgo edgeHit: 0)
					(HandsOff)
					(= register (gCurRoom roomToEdge: gPrevRoomNum))
					(= temp5
						(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
					)
					(= temp4
						(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
					)
					(= temp2 (gEgo x:))
					(= temp3 (gEgo y:))
					(switch register
						(3
							(= temp0 temp2)
							(= temp1 (+ 189 temp5))
							(= temp6 3)
						)
						(2
							(= temp1 temp3)
							(= temp0 (+ 319 temp4))
							(= temp6 1)
						)
						(4
							(= temp1 temp3)
							(= temp0 (- 0 temp4))
							(= temp6 0)
						)
						(1
							(= temp0 temp2)
							(= temp1 (- temp3 2))
							(= temp6 2)
						)
					)
					(gEgo
						posn: temp0 temp1
						init:
						setLoop: -1
						ignoreActors: 1
						setMotion: MoveTo temp2 temp3
					)
					(cedric loop: temp6 cel: 0 cycleSpeed: 3 setCycle: End self)
				)
			)
			(1
				(if (not local85)
					(cedric setScript: rotate)
				)
				(= cycles 1)
			)
			(2
				(if (gEgo mover:)
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(gEgo ignoreActors: 0)
				(client setScript: 0)
			)
		)
	)
)

(instance stdWalkOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local85
					(= temp0 (gEgo x:))
					(= temp1 (gEgo y:))
					(= temp3 5)
					(switch register
						(1
							(-= temp1 10)
							(= temp2 7)
						)
						(3
							(+= temp1 60)
							(= temp2 0)
						)
						(2
							(+= temp0 20)
							(= temp2 4)
						)
						(4
							(-= temp0 20)
							(= temp2 4)
							(= temp3 4)
						)
					)
					(if (!= register 1)
						(gEgo
							ignoreActors: 1
							setMotion: MoveTo temp0 temp1 self
						)
					else
						(gEgo loop: 3)
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if local85
					(= cycles 1)
				else
					(cedric
						view: local10
						loop: local11
						cel: local12
						setScript: 0
					)
					(= temp0 (gEgo x:))
					(= temp1 (gEgo y:))
					(= temp3 5)
					(switch register
						(1
							(-= temp1 10)
							(= temp2 7)
						)
						(3
							(+= temp1 60)
							(= temp2 0)
						)
						(2
							(+= temp0 20)
							(= temp2 4)
						)
						(4
							(-= temp0 20)
							(= temp2 4)
							(= temp3 4)
						)
					)
					(if (!= temp2 0)
						(cedric
							loop: temp3
							cycleSpeed: 0
							setCycle: CT temp2 1 self
						)
					else
						(= cycles 1)
					)
					(if (!= register 1)
						(gEgo ignoreActors: 1 setMotion: MoveTo temp0 temp1)
					else
						(gEgo loop: 3)
					)
				)
			)
			(2
				(cond
					(local85
						(= local85 0)
						(= cycles 1)
					)
					((== register 1)
						(cedric
							cycleSpeed: 1
							loop: 9
							cel: 0
							setCycle: CT 4 1 self
						)
					)
					(else
						(cedric
							cycleSpeed: 1
							loop:
								(switch register
									(2 6)
									(4 7)
									(else 8)
								)
							cel: 0
							setCycle: End self
						)
					)
				)
			)
			(3
				(HandsOn)
				(gCurRoom newRoom: (gCurRoom edgeToRoom: register))
			)
		)
	)
)

(instance rotate of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if (!= (client loop:) 2)
					(client
						cycleSpeed: 0
						cel: (if (< (client loop:) 2) 4 else 7)
						loop: (if (== (client loop:) 0) 5 else 4)
						setCycle: CT 0 -1 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== (client view:) 138)
					(= temp2 137)
				else
					(= temp2 136)
				)
				(= local10 (client view:))
				(= local11 (client loop:))
				(= local12 (client cel:))
				(client view: temp2 loop: 8 cycleSpeed: 3 cel: 2)
				(= cycles 1)
			)
			(2
				(cond
					((> (= temp1 (Random 0 4)) (client cel:))
						(= temp0 1)
					)
					((< temp1 (client cel:))
						(= temp0 -1)
					)
					((== temp1 4)
						(-- temp1)
						(= temp0 -1)
					)
					(else
						(++ temp1)
						(= temp0 1)
					)
				)
				(client setCycle: CT temp1 temp0)
				(-- state)
				(= seconds (Random 5 10))
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

