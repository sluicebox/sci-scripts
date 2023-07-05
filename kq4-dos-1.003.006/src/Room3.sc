;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	Room3 0
)

(synonyms
	(kiss kiss embrace)
	(cupid cupid cupid cupid man cupid cupid animal cupid boy baby)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(instance fallSound of Sound
	(properties)
)

(instance cupidCage of Cage
	(properties)
)

(instance theme of Sound
	(properties
		number 9
	)
)

(instance Room3 of Rm
	(properties
		picture 3
	)

	(method (init)
		(= north 27)
		(= south 9)
		(= east 4)
		(= west 2)
		(= horizon 75)
		(= gIndoors 0)
		(self setRegions: 507) ; Woods_Region
		(gEgo view: 2 init:)
		(gEgo edgeHit: 0 setScript: fall)
		(super init:)
		(if gNight
			(gCurRoom overlay: 103)
		)
		(gCurRoom setScript: egoActions)
		(Load rsVIEW 7)
		(Load rsVIEW 5)
		(Load rsVIEW 6)
		(Load rsVIEW 19)
		(Load rsVIEW 17)
		(Load rsVIEW 21)
		(Load rsSOUND 51)
		(Load rsSOUND 9)
		(cupidCage top: 118 left: 118 bottom: 135 right: 235 init:)
		(= local8 (Prop new:))
		(local8
			isExtra: 1
			view: 650
			loop: 0
			cel: 1
			posn: 209 132
			setCycle: Fwd
			cycleSpeed: 0
			ignoreActors:
			init:
		)
		(if (and (<= (Random 1 100) 33) ((Inv at: 14) ownedBy: 202)) ; Cupid_s_Bow
			(= local9 (Act new:))
			(local9
				view: 160
				posn: 5 71
				illegalBits: 0
				setPri: 7
				ignoreHorizon:
				setCycle: Fwd
				xStep: 4
				yStep: 2
				init:
			)
			(local9 setScript: doCupid)
		)
		(if ((Inv at: 14) ownedBy: 3) ; Cupid_s_Bow
			((Inv at: 14) moveTo: 202) ; Cupid_s_Bow
		)
		(switch gPrevRoomNum
			(2
				(if (<= (gEgo y:) horizon)
					(gEgo x: 1 y: (+ horizon (gEgo yStep:) 1))
				else
					(gEgo x: 1)
				)
			)
			(4
				(if (< (gEgo y:) horizon)
					(gEgo posn: 318 (+ horizon (gEgo yStep:) 1))
				else
					(gEgo posn: 318 (gEgo y:))
				)
			)
			(9
				(gEgo y: 187)
			)
			(27
				(gEgo posn: (gEgo x:) (+ horizon 2))
			)
			(0
				(gEgo x: 98 y: 176)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if ((Inv at: 14) ownedBy: 3) ; Cupid_s_Bow
			((Inv at: 14) moveTo: 202) ; Cupid_s_Bow
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look<under,in/water')
					(Print 3 0) ; "You see nothing of interest in the water."
				)
				((or (Said 'look/pool') (Said 'look/water'))
					(if (== (gEgo view:) 2)
						(Print 3 1) ; "The beautiful pool is lined with tall marble columns. Its crystal clear water looks very inviting."
					else
						(Print 3 2) ; "The beautiful pool is lined with tall marble columns."
					)
				)
				(
					(or
						(Said 'look/room')
						(Said 'look/around')
						(Said 'look[<around][/!*]')
					)
					(if (== (gEgo view:) 2)
						(Print 3 3) ; "The beautiful pool, with its elegant marble columns, has a wonderful setting in these woods. The water looks so cool and inviting; you're almost tempted to jump in."
					else
						(Print 3 4) ; "The beautiful pool, with its elegant marble columns, has a wonderful setting in these woods."
					)
				)
				(
					(or
						(Said 'fish<enter')
						(Said 'capture/fish')
						(Said 'cast/pole')
					)
					(Print 3 5) ; "You don't see any fish here."
				)
				((Said 'look/column')
					(Print 3 6) ; "The marble columns flank the lovely pool."
				)
				((Said 'get/water')
					(Print 3 7) ; "You have no reason to carry water."
				)
				(
					(or
						(Said 'enter/bathe')
						(Said 'bathe,dive')
						(Said 'enter/bathe')
					)
					(if (== (gEgo view:) 2)
						(Print 3 8) ; "Just enter the water."
					else
						(Print 3 9) ; "The water is too shallow to swim."
					)
				)
				((Said 'look/stair')
					(Print 3 10) ; "There are steps at the north end of the pool."
				)
				((Said 'exit,(climb,get<out)')
					(if (!= (gEgo view:) 2)
						(Print 3 10) ; "There are steps at the north end of the pool."
					else
						(Print 3 11) ; "You're not in the pool."
					)
				)
				((Said 'hop,dive/pool,water')
					(Print 3 12) ; "Just do that yourself."
				)
				((or (Said 'drink') (Said 'get/drink'))
					(cond
						((!= (gEgo view:) 2)
							(Print 3 13) ; "You drink some of the pool water, it quenches your thirst."
						)
						((& (= local0 (NearControl gEgo 20)) $0008)
							(= local4 1)
							(egoActions changeState: 10)
						)
						(else
							(Print 800 1) ; "You're not close enough."
						)
					)
				)
				((Said 'get/arrow,arrow')
					(cond
						(
							(and
								((Inv at: 14) ownedBy: 3) ; Cupid_s_Bow
								(or (== local1 2) (== local1 1) (== local1 7))
							)
							(if (< (gEgo distanceTo: local7) 10)
								((Inv at: 14) moveTo: gEgo) ; Cupid_s_Bow
								(gGame changeScore: 2)
								(egoActions changeState: 1)
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((gEgo has: 14) ; Cupid_s_Bow
							(Print 3 14) ; "You already have that."
						)
						(
							(and
								(not (gCast contains: local9))
								(not ((Inv at: 14) ownedBy: 3)) ; Cupid_s_Bow
							)
							(Print 3 15) ; "You don't see one here."
						)
						((!= local1 2)
							(Print 3 16) ; "Cupid won't give it to you."
						)
						((gEgo has: 14) ; Cupid_s_Bow
							(Print 3 17) ; "You already have the bow and arrows."
						)
						(else
							(Print 3 18) ; "You can't do that now."
						)
					)
				)
				((Said 'rob/arrow')
					(Print 3 19) ; "You were taught never to steal!"
				)
				((Said 'look/dirt')
					(if ((Inv at: 14) ownedBy: 3) ; Cupid_s_Bow
						(Print 3 20) ; "You see a little golden bow, and two golden arrows, on the ground by the pool."
					else
						(Print 3 21) ; "You see nothing of importance on the ground."
					)
				)
			)
		)
	)
)

(instance fall of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (== local3 0) (== local4 0))
				(cond
					((and (== (gEgo onControl: 0) 1) (!= (gEgo view:) 21))
						(gEgo view: 2)
					)
					(
						(and
							(& (gEgo onControl: 0) $0004)
							(== (gEgo view:) 2)
						)
						(= local3 1)
						(fall changeState: 1)
					)
					((& (gEgo onControl: 1) $0800)
						(gEgo view: 5)
					)
					((& $0200 (gEgo onControl: 1))
						(gEgo view: 6)
					)
					((& $0008 (gEgo onControl: 1))
						(gEgo view: 7)
					)
					((& $0010 (gEgo onControl: 0))
						(gEgo view: 2)
					)
				)
			)
			((and (== (gEgo onControl: 1) 4096) (< (fall state:) 2))
				(gEgo setMotion: 0)
				(self changeState: 2)
				(if (gTimers contains: local5)
					(local5 dispose: delete:)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gSounds eachElementDo: #stop 1)
				(fallSound number: 51 play:)
				(HandsOff)
				(gEgo
					view: 17
					loop: (+ (& (gEgo loop:) $0001) 2)
					illegalBits: 0
					setCycle: Fwd
				)
				(= local5 (Timer setCycle: self 20))
				(gEgo xStep: 8 yStep: 4 setMotion: MoveTo 170 122)
			)
			(2
				(gEgo
					view: 19
					setMotion: 0
					loop: (& (gEgo loop:) $0001)
					cel: 0
					setCycle: End self
				)
				(gEgo setStep: 3 2)
			)
			(3
				(= local3 0)
				(gEgo view: 7)
				(gEgo illegalBits: -1 ignoreControl: 8 4096 setCycle: Walk)
				(= seconds 2)
			)
			(4
				(gEgo illegalBits: -32768)
				(HandsOn)
				(self changeState: 0)
			)
		)
	)
)

(instance doCupid of Script
	(properties)

	(method (init param1)
		(Load rsVIEW 160)
		(Load rsVIEW 161)
		(Load rsVIEW 162)
		(Load rsVIEW 163)
		(Load rsVIEW 165)
		(Load rsVIEW 166)
		(Load rsVIEW 167)
		(Load rsVIEW 509)
		(super init: param1)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 5)
				(or
					(gEgo inRect: 220 100 305 140)
					(< (gEgo distanceTo: local9) 48)
				)
			)
			(if (and (> (gEgo x:) 210) (< (gEgo y:) 140))
				(self changeState: 30)
			else
				(self changeState: 20)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look/cupid')
					(cond
						((== local1 0)
							(Print 3 22) ; "Baby Cupid beats his little wings furiously as he flies through the air. In his chubby hands, he carries a golden bow, and two golden arrows."
						)
						((== local1 4)
							(Print 3 23) ; "Cupid happily splashes and frolics in the clear water of the pool."
						)
						((== local1 1)
							(Print 3 24) ; "Baby Cupid beats his little wings furiously as he flies through the air."
						)
						((== local1 2)
							(Print 3 25) ; "Oh, oh! You've startled Cupid! He quickly jumps out of the pool and flies away in fear."
						)
						((== local1 3)
							(Print 3 26) ; "Cupid appears to be getting ready to go swimming."
						)
						((== local1 5)
							(Print 3 27) ; "Cupid is through with his swim and is now leaving."
						)
					)
				)
				((Said 'play/cupid')
					(Print 3 28) ; "You might frighten Cupid if you come too close."
				)
				((Said 'get/cupid')
					(Print 3 29) ; "You couldn't get Cupid."
				)
				((Said 'kiss')
					(Print 3 30) ; "You can't get close enough to do that."
				)
				((Said 'talk')
					(cond
						((not (gCast contains: local9))
							(event claimed: 0)
						)
						((== local1 0)
							(Print 3 31) ; "You speak to Cupid, but he doesn't seem to hear you."
						)
						((== local1 2)
							(Print 3 32) ; "Cupid only wants to get away from you."
						)
						((== local1 4)
							(if (< (gEgo distanceTo: local9) 40)
								(Print 3 33) ; "You speak out and startle baby Cupid as he plays in the water. He quickly climbs out of the pool and flies away in fright."
								(if
									(and
										(> (gEgo x:) 210)
										(< (gEgo y:) 140)
									)
									(self changeState: 30)
								else
									(self changeState: 20)
								)
							else
								(Print 3 31) ; "You speak to Cupid, but he doesn't seem to hear you."
							)
						)
						(else
							(Print 3 31) ; "You speak to Cupid, but he doesn't seem to hear you."
						)
					)
				)
				((and (Said 'give>') (= temp0 (gInventory saidMe:)))
					(if (gEgo has: (gInventory indexOf: temp0))
						(Print 3 34) ; "Cupid would not be interested in anything of yours."
					else
						(DontHave) ; "You don't have it."
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 0)
				(theme play:)
				(local9 ignoreActors: setMotion: MoveTo 164 70 self)
			)
			(1
				(if (gEgo inRect: 171 101 317 183)
					(self changeState: 10)
				else
					(local9 setPri: -1 setMotion: MoveTo 250 119 self)
				)
			)
			(2
				(= local1 3)
				(local9
					view: 162
					ignoreActors: 0
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(3
				(local9 setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(local9
					ignoreActors: 1
					view: 165
					xStep: 6
					setLoop: 1
					setCycle: End
				)
				(= local7 (View new:))
				((Inv at: 14) moveTo: 3) ; Cupid_s_Bow
				(local7
					ignoreActors:
					view: 509
					x: (+ (local9 x:) 10)
					y: (local9 y:)
					stopUpd:
					init:
				)
				(local9 setMotion: MoveTo 206 126 self)
			)
			(5
				(= local1 4)
				(local9
					view: 167
					setLoop: -1
					observeControl: 1
					xStep: 1
					yStep: 1
					loop: 1
					cycleSpeed: 1
					setCycle: Fwd
					setMotion: Wander 6
					moveSpeed: 1
				)
				(local9 observeBlocks: cupidCage)
				(= local6 (Timer setReal: self 15))
			)
			(6
				(= local1 5)
				(self changeState: 40)
			)
			(10
				(local9 setMotion: MoveTo 61 83 self)
				(if (gTimers contains: local6)
					(local6 dispose: delete:)
				)
			)
			(11
				(local9 setMotion: MoveTo 4 72 self)
			)
			(12
				(local9 dispose:)
			)
			(20
				(Print 3 35) ; "Oh, oh! You've startled Cupid!"
				(if (gTimers contains: local6)
					(local6 dispose: delete:)
				)
				(local9 ignoreBlocks: cupidCage)
				(local9
					ignoreControl: 1
					setLoop: 0
					xStep: 3
					yStep: 2
					moveSpeed: 0
					setMotion: MoveTo 230 129 self
				)
				(= local1 2)
			)
			(21
				(local9 view: 166 setCel: 0)
				(local9 setMotion: MoveTo 240 129)
				(local9 cycleSpeed: 0 setCycle: End self)
			)
			(22
				(local9 view: 164 cel: 0 setLoop: 1 setCycle: End self)
			)
			(23
				(local9
					view: 161
					xStep: 4
					yStep: 3
					setPri: 7
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 168 70 self
				)
			)
			(24
				(local9 setMotion: MoveTo 41 70 self)
			)
			(25
				(local9 dispose:)
			)
			(30
				(Print 3 35) ; "Oh, oh! You've startled Cupid!"
				(if (gTimers contains: local6)
					(local6 dispose: delete:)
				)
				(local9
					ignoreBlocks: cupidCage
					ignoreControl: 1
					xStep: 6
					yStep: 2
					setLoop: 1
					moveSpeed: 0
					setMotion: MoveTo 100 129 self
				)
				(= local1 2)
			)
			(31
				(local9 xStep: 3 setMotion: MoveTo 85 129)
				(local9 view: 166 setLoop: 1 cel: 0 setCycle: End self)
			)
			(32
				(local9 posn: 80 124 loop: 3 setCycle: End self)
			)
			(33
				(local9 view: 164 cel: 0 setLoop: 1 setCycle: End self)
			)
			(34
				(= local1 1)
				(local9
					view: 161
					xStep: 4
					yStep: 3
					setPri: 7
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 41 70 self
				)
			)
			(35
				(self changeState: 11)
			)
			(40
				(local9 ignoreBlocks: cupidCage)
				(local9
					ignoreControl: 1
					setLoop: 0
					xStep: 3
					yStep: 2
					moveSpeed: 0
					setMotion: MoveTo 230 129 self
				)
				((Inv at: 14) moveTo: 202) ; Cupid_s_Bow
			)
			(41
				(local9 view: 166 setCel: 0)
				(local9 setMotion: MoveTo 240 129)
				(local9 cycleSpeed: 0 setCycle: End self)
			)
			(42
				(local9
					ignoreActors:
					posn: (- (local7 x:) 10) (- (local7 y:) 4)
				)
				(local9 view: 163 loop: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(43
				(local7 dispose:)
				(local9 cel: 6 setCycle: End self)
			)
			(44
				(= local1 0)
				(local9 view: 160 setLoop: 1 setCel: 0 setCycle: Fwd)
				(local9 setPri: 7 setMotion: MoveTo 171 80 self)
			)
			(45
				(self changeState: 10)
			)
		)
	)
)

(instance egoActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(LookAt gEgo local7)
				(gEgo view: 21 setMotion: 0 cel: 0 setCycle: End self)
			)
			(2
				(= global182 1)
				(local7 dispose:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 2 setCycle: Walk)
				(HandsOn)
			)
			(10
				(HandsOff)
				(gEgo view: 21 cel: 0 setCycle: End self)
			)
			(11
				(= seconds 5)
				(= global120 (Print 3 36 #at -1 20 #dispose)) ; "You kneel down and drink some of the pool water. At least it quenches your thirst."
			)
			(12
				(gEgo setCycle: Beg self)
			)
			(13
				(cls)
				(HandsOn)
				(gEgo view: 2 setCycle: Walk)
				(= local4 0)
			)
		)
	)
)

