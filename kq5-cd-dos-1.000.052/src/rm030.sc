;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
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
	rm030 0
)

(local
	[local0 8] = [23 177 41 173 63 172 41 179]
	[local8 19] = [0 0 319 0 319 167 180 167 135 153 112 159 75 159 52 164 0 163 0]
	local27
	local28
	[local29 9] = [1000 27 66 4 11 24 19 23 30]
)

(instance rm030 of KQ5Room
	(properties
		picture 30
		east 31
		west 29
	)

	(method (init)
		(super init:)
		(= global320 63)
		(= global321 132)
		(= global325 3059)
		(self setFeatures: rock cliff path30 ledge setRegions: 202) ; owl
		(Load rsSOUND 892)
		(branch init: stopUpd:)
		(if (== ((gInventory at: 20) owner:) 30) ; Rope
			(rope
				view: 479
				posn: 131 24
				loop: 4
				cel: (- (NumCels rope) 1)
				init:
				stopUpd:
			)
		)
		(if (== ((gInventory at: 20) owner:) 31) ; Rope
			(rope cel: (- (NumCels rope) 1) init: stopUpd:)
		)
		(switch gPrevRoomNum
			(31
				(gEgo
					normal: 1
					view: 488
					posn: 127 23
					loop: 0
					setCel: 16
					cycleSpeed: 5
					setPri: 10
					init:
				)
				(if (IsObject (gEgo head:))
					((gEgo head:) hide:)
				)
				(rope hide:)
				(self setScript: climbDownScript)
			)
			(29
				(gEgo view: (if (IsFlag 15) 12 else 106) posn: 6 171 init:)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(else
				(gEgo view: (if (IsFlag 15) 12 else 106) posn: 6 171 init:)
			)
		)
		(poly1 points: @local0 size: 4)
		(poly2 points: @local8 size: 9)
		(self addObstacle: poly1 poly2)
	)

	(method (doit &tmp temp0)
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
			((& (gEgo onControl: 0) $2000)
				(HandsOff)
				(self setScript: falling)
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
			((MousedOn gEgo event)
				(switch (event message:)
					(4 ; Inventory
						(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
							(26
								(if (not (IsFlag 15))
									(if (not (IsFlag 48))
										(SetFlag 48)
										(SetScore 4)
									)
									(SetFlag 15)
									(Say 415)
									(gEgo view: 12)
									((gEgo head:) show:)
									(event claimed: 1)
								)
							)
							(28
								(event claimed: 0)
							)
							(else
								(if (not (IsFlag 15))
									(Say 416)
									(event claimed: 1)
								)
							)
						)
					)
				)
			)
		)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)
)

(instance climbDownScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global322 view: 140 loop: 2 cel: 0 cycleSpeed: 3 setCycle: End)
				(gEgo setCycle: Beg self)
			)
			(1
				(rope show: stopUpd:)
				(gEgo
					normal: 1
					view: 479
					loop: 5
					setCel: 16
					posn: 127 157
					setCycle: Beg self
				)
			)
			(2
				(global322 setScript: (ScriptID 202 3)) ; rotate
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: (if (IsFlag 15) 12 else 106)
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					setLoop: -1
					setPri: -1
					loop: 3
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance ropeOnBranch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 15))
					(HandsOff)
					(gCurRoom setScript: freeze)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 48 165 self)
			)
			(2
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 479
					cel: 0
					loop: 0
					cycleSpeed: 2
					setCycle: CT 6 1 self
				)
				(gGlobalAudio number: 8069 loop: 1 play:)
			)
			(3
				(gEgo
					normal: 1
					view: 12
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
					loop: 11
					cel: 6
				)
				((gEgo head:) show:)
				(rope
					view: 479
					setLoop: 1
					posn: 79 21
					cycleSpeed: 1
					cel: 0
					setCycle: End self
					setMotion: MoveTo 82 35 self
					init:
				)
			)
			(4
				(rope stopUpd:)
				(cls)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance ropeOnRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 15))
					(HandsOff)
					(gCurRoom setScript: freeze)
				else
					(self cue:)
				)
			)
			(1
				(if (and (not (IsFlag 14)) (not (IsFlag 16)))
					(SetFlag 14)
					(Say 418)
				)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: PolyPath 93 166 self)
			)
			(3
				(= local27 (gEgo view:))
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 479
					setAvoider: 0
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(gGlobalAudio number: 8069 loop: 1 play:)
			)
			(4
				(gEgo
					normal: 1
					view: local27
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
					loop: 11
					cel: 0
				)
				((gEgo head:) show:)
				(rope
					view: 479
					posn: 131 24
					loop: 4
					cycleSpeed: 1
					cel: 0
					setPri: 10
					setCycle: End self
					init:
				)
			)
			(5
				(rope stopUpd:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance climbRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self register: (== ((gInventory at: 20) owner:) 30)) ; Rope
				(if register
					(gEgo setMotion: PolyPath 127 160 self)
				else
					(gEgo setMotion: PolyPath 83 173 self)
				)
			)
			(1
				(if (not (IsFlag 15))
					(gEgo setScript: freeze)
				else
					(gEgo
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 3) self
					)
				)
			)
			(2
				((gEgo head:) hide:)
				(gEgo normal: 1 view: 479 loop: 5 cel: 0 setCycle: End self)
				(if (not (IsFlag 88))
					(proc762_1 @local29 3061)
				)
				(if (== ((gInventory at: 20) owner:) 31) ; Rope
					(branch setCycle: End)
				)
			)
			(3
				(if register
					(rope hide:)
					(gEgo
						normal: 0
						view: 488
						posn: 127 23
						loop: 0
						cel: 0
						cycleSpeed: 5
						setPri: 10
						setCycle: End self
					)
				else
					(rope hide:)
					(gEgo
						normal: 0
						view: 485
						posn: 84 38
						loop: 0
						cel: 0
						cycleSpeed: 5
						setPri: 10
						setCycle: End self
					)
				)
			)
			(4
				(cls)
				(if register
					(if (== (gGame detailLevel:) 3)
						(global322
							view: 140
							loop: 5
							cycleSpeed: 0
							setScript: 0
							setCycle: CT 7 1 self
						)
					else
						(= cycles 1)
					)
				else
					(gEgo
						loop: 1
						posn: 70 165
						cel: 0
						cycleSpeed: 3
						setPri: 10
						setCycle: End self
					)
					(branch loop: 3 cel: 0 cycleSpeed: 2 setCycle: End)
					(gGlobalAudio number: 8856 loop: 1 play: self)
				)
			)
			(5
				(if (not register)
					(gGlobalAudio number: 8892 loop: 1 play:)
				)
				(= cycles 1)
			)
			(6
				(if register
					(if (== (gGame detailLevel:) 3)
						(global322
							cycleSpeed: 1
							loop: 9
							cel: 0
							setCycle: CT 4 1 self
						)
					else
						(= cycles 1)
					)
				else
					(= seconds 5)
				)
			)
			(7
				(if register
					(if (not (IsFlag 88))
						(SetFlag 88)
						(SetScore 5)
					)
					(gCurRoom newRoom: 31)
				else
					(EgoDead)
				)
			)
		)
	)
)

(instance freeze of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) 75)
					(gEgo setMotion: MoveTo 93 (gEgo y:) self)
				else
					(gEgo setMotion: MoveTo 93 (gEgo y:) self)
				)
			)
			(1
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 501 cycleSpeed: 5 setCycle: End self)
			)
			(2
				(= seconds 5)
			)
			(3
				(= global330 419)
				(EgoDead 245)
			)
		)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc762_1 @local29 3060 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: (if (== (gEgo view:) 106) 70 else 78)
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
					setPri: 5
					illegalBits: 0
				)
				(gGlobalAudio number: 7053 play:)
				(gGlobalSound3 number: 83 loop: 1 vol: 127 priority: 15 play:)
			)
			(2
				(gEgo
					yStep: 8
					setMotion: MoveTo (- (gEgo x:) 20) 230 self
				)
			)
			(3
				(= seconds 3)
			)
			(4
				(= global330 434)
				(EgoDead)
			)
		)
	)
)

(instance path30 of RFeature
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
					(Say 421)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cliff of RFeature
	(properties
		nsTop 5
		nsBottom 147
		nsRight 139
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
					(Say 422)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 431)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance ledge of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0008))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 423)
					(Say 424)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance rock of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (== ((gInventory at: 20) owner:) 30) ; Rope
						(Say 425)
					else
						(Say 426)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 432)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(20
							(gEgo put: 20 30) ; Rope
							(HandsOff)
							(gCurRoom setScript: ropeOnRock)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance branch of Prop
	(properties
		x 65
		y 28
		view 479
		loop 2
		priority 8
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
					(if (== ((gInventory at: 20) owner:) 31) ; Rope
						(Say 427)
					else
						(Say 428)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 433)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(20
							(gEgo put: 20 31) ; Rope
							(HandsOff)
							(gCurRoom setScript: ropeOnBranch)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance rope of Actor
	(properties
		x 82
		y 35
		view 479
		loop 1
		priority 9
		signal 16400
		illegalBits 0
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
					(if (== ((gInventory at: 20) owner:) 30) ; Rope
						(Say 429)
					else
						(Say 430)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: climbRope)
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

