;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	boatRegion 0
	sailIn 1
)

(local
	[local0 8] = [319 145 216 145 216 153 319 153]
	[local8 8] = [211 167 211 175 319 175 319 167]
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
				(if (or (== gCurRoomNum 45) (== gCurRoomNum 46))
					(poly5 points: @local8 size: 4)
					(gCurRoom addObstacle: poly5)
				else
					(poly5 points: @local0 size: 4)
					(gCurRoom addObstacle: poly5)
				)
				(gCurRoom setScript: sailIn)
			)
			((== gCurRoomNum global361)
				(if (or (== gCurRoomNum 45) (== gCurRoomNum 46))
					(poly5 points: @local8 size: 4)
					(gCurRoom addObstacle: poly5)
				else
					(poly5 points: @local0 size: 4)
					(gCurRoom addObstacle: poly5)
				)
				(sailBoat
					init:
					y: (if (== gCurRoomNum 44) 153 else 173)
					stopUpd:
					ignoreActors:
				)
				(sail
					posn: (+ (sailBoat x:) 7) (sailBoat y:)
					setCycle: (if (== global81 3) 0 else Fwd)
					cycleSpeed: 30
					setPri: (sailBoat priority:)
					init:
				)
				(wake
					init:
					posn: (sailBoat x:) (sailBoat y:)
					setCycle: Fwd
					cycleSpeed: 5
				)
				(if (!= global81 3)
					(wake setCycle: 0)
				)
				(if (IsFlag 106)
					(gCurRoom setScript: leave)
				)
			)
		)
	)

	(method (doit)
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
				(Say 75 220 0 67 10 10 25 5) ; "Good! I was getting a little seasick!"
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
			(sail posn: (+ (sailBoat x:) 7) (sailBoat y:))
			(gEgo posn: (+ (sailBoat x:) 22) (- (sailBoat y:) 15))
			(bird posn: (- (sailBoat x:) 35) (- (sailBoat y:) 17))
		else
			(sail stopUpd:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (not (IsFlag 55)) (not (IsFlag 56)))
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
				(wake
					init:
					posn: (sailBoat x:) (sailBoat y:)
					setCycle: Fwd
					cycleSpeed: 5
				)
				(if (!= global81 3)
					(wake setCycle: 0)
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
				(sail
					init:
					setCycle: Fwd
					ignoreActors:
					cycleSpeed: 20
					setPri: (+ (sailBoat priority:) 2)
					show:
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
				(sailBoat stopUpd:)
			)
			(3
				((gEgo head:) show:)
				(gEgo
					view: 28
					setPri: -1
					loop: 1
					posn: (gEgo x:) (+ (gEgo y:) 5)
				)
				(sailBoat setPri: -1)
				(sail setPri: -1 stopUpd:)
				(wake
					init:
					posn: (sailBoat x:) (sailBoat y:)
					setCycle: Fwd
					cycleSpeed: 5
				)
				(if (!= global81 3)
					(wake setCycle: 0)
				)
				(NormalEgo)
				(= cycles 1)
			)
			(4
				(if (and (not (IsFlag 56)) (not (IsFlag 55)))
					(Say 160 220 1 67 200 10 25 4) ; "Here we are, Cedric!"
				)
				(= cycles 1)
			)
			(5
				((gEgo head:) show:)
				(if (and (not (IsFlag 56)) (not (IsFlag 55)))
					(client setScript: flyIn)
				else
					(HandsOn)
					(client setScript: 0)
				)
			)
		)
	)
)

(instance leave of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (sailBoat mover:)
			(sail posn: (+ (sailBoat x:) 7) (sailBoat y:))
		)
		(if
			(and
				(or
					(& (gEgo onControl: 1) $0040)
					(& (gEgo onControl: 1) $2000)
				)
				(!= (gEgo view:) 26)
				(== state 1)
			)
			(gEgo view: 26)
		)
		(if
			(and
				(!= (gEgo view:) 0)
				(== state 1)
				(not (& (gEgo onControl: 1) $0040))
				(not (& (gEgo onControl: 1) $2000))
				(not (& (gEgo onControl: 1) $0200))
				(not (& (gEgo onControl: 1) $0400))
				(not (& (gEgo onControl: 1) $0010))
			)
			(gEgo view: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 108)
				(gEgo
					setCycle: Walk
					setStep: 3 2
					setLoop: -1
					moveSpeed: global289
					illegalBits: 0
					ignoreActors:
					normal: 0
				)
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(- (sailBoat x:) 86)
						(+ (sailBoat y:) 2)
						self
				)
			)
			(2
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
			(3
				(gEgo
					setLoop: 3
					posn: (+ (gEgo x:) 31) (gEgo y:)
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(4
				(if
					(and
						(not (IsFlag 104))
						(== global100 0)
						(or (not (IsFlag 94)) (== (Random 1 4) 1))
					)
					(if
						((ScriptID 754) ; CPCheck
							doit:
								{Graham's energy has suddenly run out. Use Crispin's wand to cast a spell giving Graham more strength.}
						)
						(SetFlag 94)
						(SetFlag 104)
						(= cycles 1)
					else
						(SetFlag 95)
						(client setScript: flunkedProtection)
					)
					(DisposeScript 754)
				else
					(= cycles 1)
				)
			)
			(5
				(sailBoat
					setStep: 1 1
					moveSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 400 (sailBoat y:)
				)
				(gEgo setStep: 1 1 setMotion: MoveTo 400 (gEgo y:))
				(= seconds 2)
			)
			(6
				(gEgo
					posn: (gEgo x:) (- (gEgo y:) 18)
					setLoop: 0
					setCycle: End self
				)
				(sailBoat setStep: 2 1)
				(gEgo setStep: 2 1 setMotion: MoveTo 400 (gEgo y:))
			)
			(7
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(8
				(gEgo
					view: 618
					loop: 4
					posn: (+ (gEgo x:) 20) (+ (gEgo y:) 2)
				)
				(= seconds 2)
			)
			(9
				(if (gCast contains: global322)
					(Say 160 220 2 67 100 10 25 4) ; "Come on, Cedric. Get in the boat!"
				)
				(= cycles 1)
			)
			(10
				(if (gCast contains: global322)
					(Say 75 220 3 67 10 10 25 4) ; "Aye, aye, Captain!"
				)
				(= cycles 1)
			)
			(11
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
			(12
				(if (IsFlag 106)
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
				(HandsOff)
				(gEgo
					setMotion:
						PolyPath
						(- (sailBoat x:) 41)
						(- (sailBoat y:) 10)
						self
				)
			)
			(1
				(gEgo loop: 2)
				(= cycles 1)
			)
			(2
				((gEgo head:) hide:)
				(gEgo view: 56 loop: 3 cycleSpeed: 1 setCycle: End self)
				(gEgo put: 18) ; Beeswax
				(SetScore 5)
			)
			(3
				(= seconds 3)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				((gEgo head:) show:)
				(gEgo view: 0 setCycle: Walk cycleSpeed: 0 loop: 2)
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

(instance sailBoat of Act
	(properties
		y 173
		x 280
		view 618
		cel 1
		priority -1
		signal 16385
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(cond
						((and (not (IsFlag 56)) (IsFlag 55) (IsFlag 72))
							(PrintDC 220 5) ; "Having found help for Cedric from the hermit, Graham decides it would be best to sail there rather than risk hurting him further by carrying him."
						)
						((and (not (IsFlag 56)) (IsFlag 55))
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
					(if (not (IsFlag 95))
						(gCurRoom setScript: leave)
						(event claimed: 1)
					else
						(PrintDC 220 9) ; "Graham is not strong enough to push the massive boat."
					)
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(18 ; Beeswax
							(event claimed: 1)
							(gCurRoom setScript: fixBoat)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 220 10) ; "That has no effect on the boat."
							(event claimed: 1)
						)
					)
				)
				(4 ; Talk
					(if (and (not (IsFlag 56)) (IsFlag 55))
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

(instance sail of Act
	(properties
		z 15
		view 618
		loop 3
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(cond
						((and (not (IsFlag 56)) (IsFlag 55))
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
					(if (not (IsFlag 95))
						(gCurRoom setScript: leave)
						(event claimed: 1)
					else
						(PrintDC 220 9) ; "Graham is not strong enough to push the massive boat."
					)
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(18 ; Beeswax
							(event claimed: 1)
							(gCurRoom setScript: fixBoat)
						)
						(28 ; Wand
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
			(self posn: (sailBoat x:) (sailBoat y:))
		)
	)
)

(instance bird of Act
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
					setCycle: Walk
					setPri: -1
					ignoreActors: 0
					setLoop: -1
					illegalBits: $8000
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

