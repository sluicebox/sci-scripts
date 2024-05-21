;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	boatRegion 0
	sailIn 1
)

(local
	[local0 8] = [319 143 319 154 211 154 218 143]
	[local8 8] = [319 164 319 175 212 175 218 164]
	[local16 8] = [319 164 319 175 212 175 224 164]
)

(class boatRegion of Rgn
	(properties)

	(method (init)
		(super init: &rest)
		(if (and (!= global361 45) (!= global361 46) (!= global361 44))
			(= global361 45)
		)
		(cond
			((== gPrevRoomNum 47)
				(= global361 gCurRoomNum)
				(poly5
					points:
						(switch gCurRoomNum
							(45 @local8)
							(46 @local16)
							(44 @local0)
						)
					size: 4
				)
				(gCurRoom addObstacle: poly5)
				(gCurRoom setScript: sailIn)
			)
			((== gCurRoomNum global361)
				(if (or (== gCurRoomNum 45) (== gCurRoomNum 46))
					(poly5 points: @local8 size: 4)
				else
					(poly5 points: @local0 size: 4)
				)
				(gCurRoom addObstacle: poly5)
				(sailBoat
					init:
					y: (if (== gCurRoomNum 44) 153 else 173)
					stopUpd:
					ignoreActors:
				)
				(sail
					posn: (+ (sailBoat x:) 8) (sailBoat y:)
					setCycle: (if (== (gGame detailLevel:) 3) 0 else Fwd)
					cycleSpeed: 30
					ignoreActors:
					setPri: (sailBoat priority:)
					init:
				)
				(if (== (gGame detailLevel:) 3)
					(wake
						init:
						posn: (sailBoat x:) (sailBoat y:)
						setCycle: Fwd
						cycleSpeed: 5
					)
				else
					(wake init: posn: (sailBoat x:) (sailBoat y:) stopUpd:)
				)
				(if (IsFlag 105)
					(gCurRoom setScript: leave)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(if
			(and
				(not
					(OneOf (gEgo view:) 628 624 615 616 0 56 100 97 618)
				)
				(not (& (gEgo onControl: 1) $2650))
			)
			(gEgo view: 0)
		)
		(if script
			(script doit:)
		)
	)
)

(instance flyIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bird
					view: 618
					setLoop: 9
					posn: (- (bird x:) 20) (- (bird y:) 17)
					setCycle: Fwd
					moveSpeed: 0
					cycleSpeed: 0
					setPri: 15
					setStep: 4 3
					setMotion: MoveTo global320 (- global321 10) self
				)
			)
			(1
				(bird
					view: 138
					setLoop: 1
					posn: (bird x:) (+ (bird y:) 10)
					setCycle: End self
				)
			)
			(2
				(bird view: 138 setLoop: 4 cel: 3 setCycle: Beg self)
			)
			(3
				(bird dispose:)
				(gCurRoom setRegions: 202) ; owl
				(if (== gCurRoomNum 45)
					(global322 setPri: 8)
				)
				(proc0_28 75 220 0 67 10 10 25 5) ; "Good! I was getting a little seasick!"
				(= cycles 1)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance sailIn of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (gCast contains: global322)
			(global322 hide:)
		)
		(if
			(and
				(& (gEgo onControl: 1) $2000)
				(== (gEgo view:) 0)
				(not (sailBoat mover:))
			)
			(gEgo view: 28)
		)
		(if (sailBoat mover:)
			(gEgo x: (+ (sailBoat x:) 22) y: (- (sailBoat y:) 15))
			(bird x: (- (sailBoat x:) 35) y: (- (sailBoat y:) 17))
		else
			(sail stopUpd:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (not (IsFlag 54)) (not (IsFlag 55)))
					(bird
						init:
						view: 138
						setLoop: 4
						setCel: 3
						setPri: 10
						ignoreActors:
						illegalBits: 0
					)
				)
				(if (== (gGame detailLevel:) 3)
					(wake
						init:
						posn: (sailBoat x:) (sailBoat y:)
						setCycle: Fwd
						cycleSpeed: 5
					)
				else
					(wake init: posn: (sailBoat x:) (sailBoat y:) stopUpd:)
				)
				(sailBoat
					x: 320
					y: (if (== gCurRoomNum 44) 153 else 173)
					setLoop: 0
					illegalBits: 0
					setPri: -1
					ignoreActors:
					init:
				)
				(gEgo
					view: 618
					loop: 5
					z: 0
					init:
					posn: (+ (sailBoat x:) 22) (- (sailBoat y:) 15)
					show:
				)
				((gEgo head:) hide:)
				(= cycles 1)
			)
			(1
				(if (== (gGame detailLevel:) 3)
					(sail
						init:
						setCycle: Fwd
						ignoreActors:
						cycleSpeed: 20
						setPri: (+ (sailBoat priority:) 2)
						show:
					)
				else
					(sail
						init:
						ignoreActors:
						setPri: (+ (sailBoat priority:) 2)
						stopUpd:
						show:
					)
				)
				(sailBoat setMotion: MoveTo 280 (sailBoat y:) self)
			)
			(2
				(gEgo
					view: 624
					setLoop: 0
					posn: (gEgo x:) (- (sailBoat y:) 17)
					normal: 0
					cel: 0
					setPri: (- (sailBoat priority:) 1)
					ignoreActors: 1
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(3
				((gEgo head:) show:)
				(gEgo
					view: 28
					setPri: -1
					loop: 1
					posn: (gEgo x:) (+ (gEgo y:) 5)
				)
				(sailBoat setPri: -1 stopUpd:)
				(sail setPri: -1)
				(if (== (gGame detailLevel:) 3)
					(wake
						init:
						posn: (sailBoat x:) (sailBoat y:)
						setCycle: Fwd
						cycleSpeed: 5
					)
				else
					(wake init: posn: (sailBoat x:) (sailBoat y:) stopUpd:)
				)
				(NormalEgo)
				(= cycles 1)
			)
			(4
				(if (and (not (IsFlag 55)) (not (IsFlag 54)))
					(proc0_28 160 220 1 67 50 10 25 4) ; "Here we are, Cedric!"
				)
				(= cycles 1)
			)
			(5
				((gEgo head:) show:)
				(if (and (not (IsFlag 55)) (not (IsFlag 54)))
					(client setScript: flyIn)
				else
					(HandsOn)
					(client setScript: 0)
				)
				(wake cycleSpeed: 16)
			)
		)
	)
)

(instance leave of Script
	(properties)

	(method (doit &tmp temp0)
		(if
			(and
				(or (& (= temp0 (gEgo onControl: 1)) $0040) (& temp0 $2000))
				(!= (gEgo view:) 26)
				(== state 1)
			)
			(gEgo view: 26)
		)
		(if (and (!= (gEgo view:) 0) (== state 4))
			(gEgo view: 0)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(ClearFlag 107)
				(gEgo
					setCycle: KQ5SyncWalk
					setStep: 3 2
					setLoop: -1
					moveSpeed: (gGame egoMoveSpeed:)
					illegalBits: 0
					ignoreActors:
					normal: 0
				)
				(HandsOff)
				(= cycles 1)
			)
			(1
				(if (and (== (gEgo view:) 2) (== gCurRoomNum 44))
					(gEgo setMotion: MoveTo 114 45 self)
				else
					(= state 3)
					(= cycles 1)
				)
			)
			(2
				(gEgo
					view: 9
					setPri: 15
					setLoop: 0
					setCycle: End self
					cel: 0
					moveSpeed: 0
					illegalBits: 0
					posn: 113 44
					setMotion: MoveTo 68 55
				)
				((gEgo head:) hide:)
			)
			(3
				(gEgo
					view: 0
					setCycle: KQ5SyncWalk
					setLoop: -1
					setPri: -1
					illegalBits: -32768
					moveSpeed: (gGame egoMoveSpeed:)
					setMotion: MoveTo 68 55 self
				)
				((gEgo head:) show:)
			)
			(4
				(gEgo
					setMotion:
						PolyPath
						(- (sailBoat x:) 86)
						(+ (sailBoat y:) 2)
						self
				)
			)
			(5
				((gEgo head:) hide:)
				(gEgo
					view: 615
					loop: 2
					setPri: (+ (sailBoat priority:) 1)
					cel: 0
					setCycle: End self
				)
				(sail setPri: (+ (gEgo priority:) 1))
			)
			(6
				(gEgo
					setLoop: 3
					posn: (+ (gEgo x:) 31) (gEgo y:)
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(7
				(if
					(and
						(not (IsFlag 103))
						(== global100 0)
						(not (IsFlag 93))
					)
					(= temp0 (sail priority:))
					(sail setPri: 14)
					(Animate (gCast elements:) 0)
					(if
						((ScriptID 754) ; CPCheck
							doit:
								{Graham's energy has suddenly run out. Use Crispin's wand to cast a spell giving Graham more strength.}
						)
						(SetFlag 93)
						(SetFlag 103)
						(= cycles 1)
					else
						(SetFlag 94)
						(client setScript: flunkedProtection)
					)
					(sail setPri: temp0)
				else
					(= cycles 1)
				)
			)
			(8
				(sailBoat
					setStep: 1 1
					moveSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 400 (sailBoat y:)
				)
				(gEgo setStep: 1 1 setMotion: MoveTo 400 (gEgo y:))
				(= seconds 2)
			)
			(9
				(gEgo
					posn: (gEgo x:) (- (gEgo y:) 18)
					setLoop: 0
					setCycle: End self
				)
				(sailBoat setStep: 2 1)
				(gEgo setStep: 2 1 setMotion: MoveTo 400 (gEgo y:))
			)
			(10
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(11
				(gEgo
					view: 618
					loop: 4
					posn: (+ (gEgo x:) 20) (+ (gEgo y:) 2)
				)
				(= seconds 2)
			)
			(12
				(if
					(and
						(gCast contains: global322)
						(not (IsFlag 55))
						(not (IsFlag 54))
					)
					(proc0_28 160 220 2 67 50 10 25 4) ; "Come on, Cedric. Get in the boat!"
				)
				(= cycles 1)
			)
			(13
				(if
					(and
						(gCast contains: global322)
						(not (IsFlag 55))
						(not (IsFlag 54))
					)
					(proc0_28 75 220 3 67 10 10 25 4) ; "Aye, aye, Captain!"
				)
				(= cycles 1)
			)
			(14
				(gEgo setMotion: 0)
				(sailBoat setMotion: 0)
				(sail setMotion: 0)
				(if (gCast contains: global322)
					(cls)
					(global322 view: 138 setLoop: 6 setCycle: End self)
					(= cycles 5)
				else
					(= cycles 1)
				)
			)
			(15
				(if (IsFlag 105)
					(gCurRoom newRoom: 113) ; hermit4
				else
					(gCurRoom newRoom: 47)
				)
			)
		)
	)
)

(instance fixBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 18) ; Beeswax
				(SetScore 5)
				(HandsOff)
				(gEgo
					setMotion:
						PolyPath
						(if (and (< (gEgo x:) 319) (< (gEgo y:) 170))
							(- (sailBoat x:) 41)
						else
							(- (sailBoat x:) 73)
						)
						(if (and (< (gEgo x:) 319) (< (gEgo y:) 170))
							(- (sailBoat y:) 10)
						else
							(sailBoat y:)
						)
						self
				)
			)
			(1
				(gEgo
					setPri: (- (sailBoat priority:) 1)
					loop: 2
					setMotion:
						PolyPath
						(- (sailBoat x:) 41)
						(- (sailBoat y:) 10)
						self
				)
			)
			(2
				((gEgo head:) hide:)
				(gEgo
					view: 56
					loop: 3
					setPri: (- (sailBoat priority:) 1)
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(= seconds 3)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				((gEgo head:) show:)
				(gEgo
					view: 0
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					setPri: -1
					loop: 2
				)
				(= cycles 1)
			)
			(6
				(PrintDC 220 4) ; "Graham firmly wedges the softened piece of beeswax into the small hole in the boat's hull. Hopefully, the wax will hold and make her seaworthy."
				(HandsOn)
				(= cycles 1)
			)
			(7
				(client setScript: 0)
			)
		)
	)
)

(instance sailBoat of Actor
	(properties
		x 280
		y 173
		view 618
		cel 1
		priority -1
		signal 16385
		detailLevel 3
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
					(cond
						((and (not (IsFlag 55)) (IsFlag 54) (IsFlag 71))
							(PrintDC 220 5) ; "Having found help for Cedric from the hermit, Graham decides it would be best to sail there rather than risk hurting him further by carrying him."
						)
						((and (not (IsFlag 55)) (IsFlag 54))
							(PrintDC 220 6) ; "With Cedric quietly moaning from the bottom of the boat, Graham decides it would be best to leave him there and go find help."
						)
						(
							(or
								(> (gEgo distanceTo: self) 40)
								(not (gEgo has: 18)) ; Beeswax
							)
							(PrintDC 220 7) ; "An old, cast-off sailboat sits forlornly on the narrow, sandy beach."
						)
						(else
							(PrintDC 220 8) ; "Graham notices a small hole in the bottom of the old sailboat."
						)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (not (IsFlag 94))
						(gCurRoom setScript: leave)
						(event claimed: 1)
					else
						(PrintDC 220 9) ; "Graham is not strong enough to push the massive boat."
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(18
							(event claimed: 1)
							(gCurRoom setScript: fixBoat)
						)
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 220 10) ; "That has no effect on the boat."
							(event claimed: 1)
						)
					)
				)
				(5 ; Talk
					(if (and (not (IsFlag 55)) (IsFlag 54))
						(PrintDC 220 11) ; "Moooaaannnn!"
						(event claimed: 1)
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance sail of Actor
	(properties
		z 15
		view 618
		loop 3
		detailLevel 3
	)

	(method (doit)
		(if (sailBoat mover:)
			(sail posn: (+ (sailBoat x:) 8) (sailBoat y:))
		)
		(super doit:)
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
					(cond
						((and (not (IsFlag 55)) (IsFlag 54))
							(PrintDC 220 12) ; "Cedric quietly moans from the bottom of the boat."
						)
						(
							(or
								(> (gEgo distanceTo: self) 40)
								(not (gEgo has: 18)) ; Beeswax
							)
							(PrintDC 220 7) ; "An old, cast-off sailboat sits forlornly on the narrow, sandy beach."
						)
						(else
							(PrintDC 220 8) ; "Graham notices a small hole in the bottom of the old sailboat."
						)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (not (IsFlag 94))
						(gCurRoom setScript: leave)
						(event claimed: 1)
					else
						(PrintDC 220 9) ; "Graham is not strong enough to push the massive boat."
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(18
							(event claimed: 1)
							(gCurRoom setScript: fixBoat)
						)
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 220 10) ; "That has no effect on the boat."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance wake of Prop
	(properties
		view 618
		loop 8
	)

	(method (doit)
		(super doit:)
		(if (sailBoat mover:)
			(self x: (sailBoat x:) y: (sailBoat y:))
		)
	)
)

(instance bird of Actor
	(properties)
)

(instance flunkedProtection of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) hide:)
				(gEgo
					view: 615
					posn: (- (gEgo x:) 31) (gEgo y:)
					loop: 2
					setPri: (+ (sailBoat priority:) 1)
				)
				(gEgo
					cel: (- (NumCels gEgo) 1)
					cycleSpeed: 2
					setCycle: Beg self
				)
				(sail setPri: (sailBoat priority:))
			)
			(1
				(gEgo
					normal: 1
					view: 0
					setCycle: KQ5SyncWalk
					setPri: -1
					ignoreActors: 0
					setLoop: -1
					illegalBits: -32768
					cycleSpeed: 0
					setStep: 3 2
				)
				((gEgo head:) show:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

