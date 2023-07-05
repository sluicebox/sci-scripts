;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	Room21 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance Room21 of Rm
	(properties
		picture 21
	)

	(method (init)
		(= north 15)
		(= south 27)
		(= east 22)
		(= west 20)
		(= horizon 68)
		(= gIndoors 0)
		(gEgo edgeHit: 0)
		(super init:)
		(if gNight
			(gCurRoom overlay: 121)
		)
		(self setRegions: 507 501 512) ; Woods_Region, waterReg, riverReg
		(Load rsVIEW 518)
		(Load rsVIEW 21)
		(Load rsVIEW 23)
		(= local1 (Prop new:))
		(= local2 (Prop new:))
		(= local3 (Prop new:))
		(local3
			isExtra: 1
			view: 657
			loop: 2
			cel: 0
			posn: 295 118
			setPri: 0
			cycleSpeed: 1
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local1
			isExtra: 1
			view: 657
			loop: 0
			cel: 2
			posn: 13 181
			setPri: 0
			cycleSpeed: 1
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local2
			isExtra: 1
			view: 657
			loop: 1
			cel: 0
			posn: 122 154
			setPri: 0
			cycleSpeed: 1
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(if (< (gEgo y:) horizon)
			(gEgo y: (+ horizon 2))
		)
		(if ((Inv at: 5) ownedBy: 21) ; Gold_Ball
			(= local0 (View new:))
			(local0 view: 518 loop: 1 cel: 0 x: 164 y: 129 stopUpd: init:)
		)
		(switch gPrevRoomNum
			(0
				(gEgo posn: 160 185)
			)
			(26
				(cond
					((!= (gEgo view:) 2)
						(gEgo posn: 1 174)
					)
					((< (gEgo x:) 191)
						(gEgo posn: 1 136)
					)
					(else
						(gEgo posn: 7 186)
					)
				)
				(RedrawCast)
			)
			(22
				(cond
					((!= (gEgo view:) 2)
						(gEgo posn: 318 116)
					)
					(
						(and
							(>= (gEgo y:) 105)
							(< (gEgo y:) 121)
							(== (gEgo view:) 2)
						)
						(gEgo posn: 318 102)
					)
					(else
						(gEgo posn: 318 (gEgo y:))
					)
				)
			)
			(20
				(if (> (gEgo y:) 140)
					(gEgo posn: 1 139)
				else
					(gEgo posn: 1 (gEgo y:))
				)
			)
			(27
				(gEgo posn: (gEgo x:) (- 189 (gEgo yStep:)))
			)
			(15
				(gEgo posn: (gEgo x:) (+ horizon 2))
			)
		)
		((gEgo viewer:) doit:)
		(gEgo init:)
		(if (== gPrevRoomNum 0)
			(gEgo x: 180 y: 188)
		)
	)

	(method (newRoom newRoomNumber)
		(if (gEgo inRect: -6 166 20 192)
			(super newRoom: 26)
		else
			(super newRoom: newRoomNumber)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((Said '<under/bridge')
					(cond
						((gEgo inRect: 120 130 195 139)
							(gEgo setScript: egoActions)
						)
						(
							(or
								(gEgo inRect: 70 115 254 169)
								(gEgo inRect: 189 93 318 139)
							)
							(Print 21 0) ; "You peek under the bridge, but do not see anything of importance from where you're standing."
						)
						(else
							(Print 800 1) ; "You're not close enough."
						)
					)
				)
				((Said '/bridge')
					(Print 21 1) ; "A rustic stone bridge adds a bit of charm to this part of the woods."
				)
				((Said '[<around][/room]')
					(Print 21 2) ; "A gentle stream meanders its way through the trees. A rustic stone bridge crosses its path."
				)
			)
		)
	)
)

(instance egoActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: Avoid setMotion: MoveTo 141 133 self)
			)
			(1
				(= local4 (gEgo viewer:))
				(gEgo setAvoider: 0 viewer: 0)
				(gEgo loop: 0 view: 21 cel: 255 setCycle: End self)
			)
			(2
				(gEgo view: 23 loop: 0 cel: 255 setCycle: End self)
			)
			(3
				(if ((Inv at: 5) ownedBy: 21) ; Gold_Ball
					(local0 dispose:)
					(gGame changeScore: 2)
					(Print 21 3 #draw) ; "You kneel down and peer under the bridge. Aha! You have found a small golden ball! You pick it up and carry it with you."
					(= global182 1)
					((Inv at: 5) moveTo: gEgo) ; Gold_Ball
				else
					(Print 21 4 #draw) ; "You see nothing of importance under the bridge."
				)
				(gEgo loop: 2 cel: 255 setCycle: End self)
			)
			(4
				(gEgo view: 21 setCel: 255 setCycle: Beg self)
			)
			(5
				(gEgo view: 2 setCycle: Walk)
				(gEgo viewer: local4)
				(HandsOn)
			)
		)
	)
)

