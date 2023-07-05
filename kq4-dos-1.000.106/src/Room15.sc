;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
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
	Room15 0
)

(synonyms
	(lake lake)
	(prince prince prince prince man)
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
	local10
	local11
	local12
)

(instance Room15 of Rm
	(properties
		picture 15
	)

	(method (init)
		(= north 9)
		(= south 21)
		(= east 16)
		(= west 14)
		(= horizon 75)
		(if gNight
			(= picture 115)
		)
		(= gIndoors 0)
		(if (<= (gEgo y:) horizon)
			(gEgo posn: (gEgo x:) (- horizon 2))
		)
		(if (< (gEgo x:) 29)
			(gEgo x: 29)
		)
		(super init:)
		(self setRegions: 507) ; Woods_Region
		(gEgo view: 2 setStep: 2 1 init:)
		(Load rsVIEW 518)
		(Load rsVIEW 375)
		(Load rsVIEW 376)
		(Load rsVIEW 377)
		(Load rsVIEW 370)
		(Load rsVIEW 378)
		(Load rsVIEW 26)
		(Load rsVIEW 27)
		(Load rsVIEW 29)
		(Load rsVIEW 21)
		(Load rsVIEW 6)
		(Load rsVIEW 27)
		(Load rsVIEW 28)
		(Load rsVIEW 680)
		(Load rsVIEW 225)
		(Load rsVIEW 226)
		(Load rsVIEW 227)
		(Load rsVIEW 2)
		(= local8 (Prop new:))
		(= local9 (Prop new:))
		(= local10 (Prop new:))
		(= local11 (Prop new:))
		(local8
			isExtra: 1
			view: 650
			loop: 2
			cel: 0
			posn: 242 154
			setPri: 11
			ignoreActors:
			cycleSpeed: 1
			setCycle: Fwd
			init:
		)
		(local9
			isExtra: 1
			view: 650
			loop: 3
			cel: 0
			posn: 187 147
			setPri: 10
			ignoreActors:
			cycleSpeed: 1
			setCycle: Fwd
			init:
		)
		(local10
			isExtra: 1
			view: 650
			loop: 4
			cel: 0
			posn: 89 142
			setPri: 10
			ignoreActors:
			cycleSpeed: 1
			setCycle: Fwd
			init:
		)
		(local11
			isExtra: 1
			view: 650
			loop: 5
			cel: 1
			posn: 220 139
			setPri: 10
			ignoreActors:
			cycleSpeed: 1
			setCycle: Fwd
			init:
		)
		(if (== gPrevRoomNum 0)
			(gEgo x: 1 y: 150)
		)
		((View new:)
			view: 518
			loop: 0
			cel: (if gNight 1 else 0)
			setPri: 10
			posn: 204 148
			init:
			addToPic:
		)
		(if ((Inv at: 10) ownedBy: 200) ; Small_Crown
			(= local3 (Act new:))
			(= local4 (Sound new:))
			(local4 number: 28 play:)
			(= global110 0)
			(local3
				view: 370
				cycleSpeed: 2
				setCycle: Fwd
				x: 206
				y: 145
				ignoreActors:
				init:
			)
		)
		(if ((Inv at: 5) ownedBy: 15) ; Gold_Ball
			(= local7 (View new:))
			(local7
				view: 518
				loop: 1
				cel: 0
				posn: 265 135
				ignoreActors:
				stopUpd:
				init:
			)
		)
		(gCurRoom setScript: frogActions)
	)

	(method (doit)
		(super doit:)
		(if (and (== (= local0 (gEgo onControl: 1)) 512) (== global110 0))
			(frogActions changeState: 1)
		)
		(if (!= local1 local0)
			(= local1 local0)
			(switch local0
				(1
					(if (not (gEgo has: 11)) ; Frog
						(= global105 0)
						(gEgo view: 2)
					)
				)
				(512
					(if (not (gEgo has: 11)) ; Frog
						(gEgo view: 6)
						(= global105 2)
					)
				)
			)
		)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if
			(and
				(== global110 4)
				(or
					(!= (gEgo xLast:) (gEgo x:))
					(!= (gEgo yLast:) (gEgo y:))
					(== (event type:) $0040) ; direction
					(== (event type:) evMOUSEBUTTON)
				)
			)
			((Inv at: 11) moveTo: 15) ; Frog
			(= global110 3)
			(frogActions changeState: 60)
		)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said '/prince>')
					(if (and (== global110 5) (gCast contains: local3))
						(cond
							((Said 'look')
								(Print 15 0) ; "This prince may be handsome, but he's also obnoxiously conceited."
							)
							((Said 'talk')
								(Print 15 1) ; "The prince does not answer you."
							)
							((Said 'get')
								(Print 15 2) ; "You couldn't get the prince."
							)
							((Said 'kiss')
								(Print 15 3) ; "He's too conceited. You wouldn't want to."
							)
						)
					else
						(Print 15 4) ; "You can't see a prince here."
						(event claimed: 1)
					)
				)
				(
					(or
						(Said 'fish<enter')
						(Said 'capture/fish')
						(Said 'cast/pole')
					)
					(Print 15 5) ; "You can't see any fish here."
				)
				((Said 'look,find,look/frog')
					(cond
						((gEgo has: 11) ; Frog
							((Inv at: 11) showSelf:) ; Frog
						)
						((or (== global110 0) (== global110 3))
							(Print 15 6) ; "The large frog stares back at you with big bulging eyes."
						)
						((== global110 1)
							(Print 15 7) ; "The water is too murky to see anything."
						)
						((== global110 2)
							(Print 15 8) ; "The frog appears to be retrieving your gold ball."
						)
						((== global110 4)
							(Print 15 9) ; "The frog sits calmly in the palm of your hand. Its big eyes stare into yours. A little gold crown rests upon its head."
						)
						(else
							(Print 15 10) ; "You can't see one here."
						)
					)
				)
				((Said 'look>')
					(cond
						((Said '<under,in/water')
							(Print 15 7) ; "The water is too murky to see anything."
						)
						((Said '/lake,water')
							(Print
								(Format ; "This is a very pretty little pond. Floating upon it are many beautiful water lilies. %s"
									@global300
									15
									11
									(if (== global110 0)
										{You spy a large frog sitting on top of a big lily pad, and YES!...it's wearing a little gold crown!}
									else
										{ }
									)
								)
							)
						)
						((or (Said '<down[/dirt]') (Said '/dirt'))
							(cond
								(
									(and
										((Inv at: 5) ownedBy: 15) ; Gold_Ball
										(== global110 3)
									)
									(Print 15 12) ; "The frog is sitting with the gold ball at the east edge of the pond."
								)
								(((Inv at: 5) ownedBy: 15) ; Gold_Ball
									(Print 15 13) ; "Your golden ball is lying by the east edge of the pond."
								)
								((== global110 3)
									(Print 15 14) ; "The frog is sitting on the ground near the edge of the pond."
								)
								(else
									(Print 15 15) ; "There is nothing of interest on the ground."
								)
							)
						)
						((Said '/lilies,pad')
							(Print
								(Format ; "Many water lilies float upon this little pond. %s"
									@global300
									15
									16
									(if (== global110 0)
										{Atop one large lily pad, sits a big frog.}
									else
										{}
									)
								)
							)
						)
						((Said '/crown')
							(cond
								((== global110 4)
									(Print 15 17) ; "It's a nice little gold crown."
								)
								((gEgo has: 10) ; Small_Crown
									((Inv at: 10) showSelf:) ; Small_Crown
								)
								(else
									(Print 800 1) ; "You're not close enough."
								)
							)
						)
						((Said '/blossom')
							(Print 15 18) ; "You see flowers here and there."
						)
						((Said '[<around][/room]')
							(Print
								(Format ; "Numerous water lilies float serenely upon the lovely little pond nestled in these woods. %s"
									@global300
									15
									19
									(if (== global110 0)
										{Atop one of the bigger lily pads, you notice a rather large frog...wearing a little gold crown!}
									else
										{}
									)
								)
							)
						)
					)
				)
				((Said 'get/blossom')
					(Print 15 20) ; "It would waste your precious time to stop and pick flowers."
				)
				((Said 'bathe,dive')
					(Print 15 21) ; "The water is too shallow."
				)
				((Said 'wade')
					(Print 15 22) ; "Just do that yourself."
				)
				((or (Said 'get/drink') (Said 'drink[/water]'))
					(= local2 (NearControl gEgo 12))
					(cond
						((== (gEgo view:) 2)
							(if (& local2 $0200)
								(= global164 (gEgo script:))
								(gEgo setScript: drinking)
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((== (gEgo view:) 6)
							(Print 15 23) ; "Well, it's not wonderful, but it satisfies your thirst."
						)
						(else
							(Print 15 24) ; "You can't do that now."
						)
					)
				)
				((Said 'get,get,capture/frog')
					(cond
						((== global110 4)
							(Print 800 0) ; "You already took it."
						)
						((== global110 1)
							(Print 15 25) ; "You can't see the frog."
						)
						((== global110 5)
							(Print 15 26) ; "You don't see one here."
						)
						((!= global110 3)
							(Print 15 27) ; "You're too far away from it."
						)
						((== (gEgo view:) 6)
							(Print 15 28) ; "Not while you're in the pond."
						)
						((gEgo inRect: 249 133 266 139)
							(Print 15 29) ; "You are too close to the water."
						)
						((== global110 3)
							(if (< (gEgo distanceTo: local3) 13)
								(LookAt gEgo local3)
								(Print 15 30) ; "Squinching up your nose in disgust, you catch the large frog and hold it in your hand. It stares at you with its big bulgy eyes, and wobbles its throat."
								(frogActions changeState: 10)
							else
								(Print 15 31) ; "You're not near enough."
							)
						)
					)
				)
				((Said 'get/lilies,pad')
					(Print 15 32) ; "You have no need for a lily pad."
				)
				((Said 'talk[/frog]')
					(if (or (== global110 0) (== global110 3) (== global110 4))
						(Print 15 33) ; "Ribbit! Ribbit!"
						(Print 15 34) ; "Well, what else did you expect from a frog?"
					else
						(Print 15 35) ; "There's no one nearby."
					)
				)
				((Said 'throw,drop,place,give/ball')
					(if (gEgo has: 5) ; Gold_Ball
						(cond
							((== global110 0)
								(if ((Inv at: 10) ownedBy: 200) ; Small_Crown
									(if
										(and
											(&
												(= local2 (NearControl gEgo 15))
												$0200
											)
											(== (gEgo view:) 2)
										)
										(HandsOff)
										(LookAt gEgo local3)
										(Print 15 36 #draw) ; "You "accidentally" drop the golden ball into the pond. From atop a lily pad, a large green frog leaps into the water, and disappears from view. A moment later, the frog emerges with...YES!...your lost ball in its mouth! It seems as if the frog is kindly returning your gold ball to you."
										(= global110 2)
										(frogActions changeState: 3)
									else
										(Print 15 37) ; "Try another spot."
									)
								else
									(Print 15 38) ; "That's not necessary any more."
								)
							)
							((!= (gEgo view:) 2)
								(Print 15 39) ; "Not here."
							)
							(else
								(Print 15 40) ; "Not now."
							)
						)
					else
						(Print 15 41) ; "You don't have it."
					)
				)
				((or (Said 'kiss/frog') (Said 'kiss[/!*]'))
					(if (== global110 4)
						(Print 15 42) ; "You look at the frog's green lips. Mmmmm. Good. You feel silly doing this, as you slowly put your mouth against the frog's."
						(frogActions changeState: 50)
						(= global110 5)
					else
						(Print 15 43) ; "First, you need to get the frog."
					)
				)
				((Said 'get/ball')
					(if (== (gEgo view:) 2)
						(cond
							(((Inv at: 5) ownedBy: 15) ; Gold_Ball
								(if (< (gEgo distanceTo: local7) 10)
									(gEgo setScript: ballActions)
									(ballActions changeState: 1)
								else
									(Print 800 1) ; "You're not close enough."
								)
							)
							((gEgo has: 5) ; Gold_Ball
								(Print 800 0) ; "You already took it."
							)
							(else
								(Print 15 44) ; "How can you do that?"
							)
						)
					else
						(CantDo) ; "You can't do that now."
					)
				)
				((Said 'give>')
					(if (= temp0 (gInventory saidMe:))
						(if (gEgo has: (gInventory indexOf: temp0))
							(if (gCast contains: local3)
								(Print 15 45) ; "He is not interested."
							else
								(Print 15 46) ; "There's no one here to give anything to."
							)
						else
							(DontHave) ; "You don't have it."
						)
					)
				)
				((Said 'get,rob/crown')
					(cond
						((gEgo has: 10) ; Small_Crown
							(Print 800 0) ; "You already took it."
						)
						((== global110 4)
							(Print 15 47) ; "Ok."
							((Inv at: 10) moveTo: gEgo) ; Small_Crown
							(= global182 1)
							(gEgo
								view: 2
								loop: 1
								cycleSpeed: 0
								setCycle: Walk
								put: 11 999 ; Frog
							)
							(gGame changeScore: 2)
							(= global110 6)
							(frogActions changeState: 70)
						)
						(else
							(Print 15 43) ; "First, you need to get the frog."
						)
					)
				)
			)
		)
	)
)

(instance frogActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= global110 1)
				(Print 15 48 #time 3) ; "Oops, you scared the frog away!"
				(local3
					view: 373
					cycleSpeed: 0
					loop: 0
					cel: 0
					setCycle: End
					illegalBits: 0
					setMotion: MoveTo (+ (local3 x:) 10) (- (local3 y:) 5) self
				)
			)
			(2
				(local3 hide:)
				(frogActions changeState: 100)
			)
			(3
				(= seconds 2)
				(Load rsVIEW 377)
				(Load rsVIEW 372)
				(Load rsVIEW 373)
			)
			(4
				(gEgo setMotion: 0)
				(local3
					view: 373
					show:
					cycleSpeed: 0
					setLoop: 0
					cel: 0
					xStep: 2
					yStep: 2
					illegalBits: 0
					ignoreActors: 0
					setCycle: End self
					setMotion: MoveTo (+ (local3 x:) 8) (local3 y:)
				)
				((Inv at: 5) moveTo: 15) ; Gold_Ball
			)
			(5
				(local3 ignoreActors: hide:)
				(= seconds 4)
			)
			(6
				(if (gEgo inRect: 247 132 278 140)
					(gEgo setScript: ballActions)
					(ballActions changeState: 10)
				)
				(local3
					view: 377
					setLoop: 0
					cel: 0
					xStep: 2
					setAvoider: (Avoid new:)
					setCycle: Fwd
					illegalBits: 0
					cycleSpeed: 0
					moveSpeed: 0
					show:
					setMotion: MoveTo 250 139 self
				)
			)
			(7
				(local3
					view: 372
					xStep: 2
					setLoop: -1
					cel: 0
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 265 137 self
				)
			)
			(8
				(local3
					view: 370
					cel: 0
					ignoreActors: 0
					cycleSpeed: 2
					setCycle: Fwd
				)
				(= global110 3)
				(= local7 (View new:))
				(local7
					view: 518
					loop: 1
					cel: 0
					posn: (+ (local3 x:) 5) (local3 y:)
					ignoreActors:
					stopUpd:
					init:
				)
				(HandsOn)
			)
			(10
				(HandsOff)
				(LookAt gEgo local3)
				(gEgo view: 21 ignoreActors: setCycle: End self)
			)
			(11
				(local3 dispose:)
				((Inv at: 11) moveTo: gEgo) ; Frog
				(gEgo view: 27 ignoreActors: 0 setCycle: End self)
			)
			(12
				(gEgo view: 28 setCycle: Walk setMotion: MoveTo 294 134 self)
			)
			(13
				(gEgo view: 30 loop: 0 cycleSpeed: 1 setCycle: Fwd)
				(= global110 4)
				(HandsOn)
			)
			(50
				(HandsOff)
				(gEgo
					view: 29
					loop: 1
					cel: 0
					cycleSpeed: 0
					setCycle: End self
					put: 11 999 ; Frog
				)
				(gGame changeScore: 3)
			)
			(51
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(52
				(= local5 (Prop new:))
				((Sound new:) number: 59 play:)
				(local5
					posn: (- (gEgo x:) 15) (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					view: 680
					cel: 0
					loop: 0
					ignoreActors:
					setCycle: CT 5 1 self
					init:
				)
			)
			(53
				(local5 setCycle: End self)
				(= local3 (Act new:))
				(local3
					posn: (- (gEgo x:) 19) (gEgo y:)
					view: 225
					cel: 0
					setLoop: 2
					illegalBits: -32256
					init:
				)
				(gEgo view: 2)
				(LookAt gEgo local3 1)
			)
			(54
				(local5 dispose:)
				(Print 15 49 #at -1 20) ; "Suddenly, the little green frog changes into a handsome prince!"
				(Print 15 50 #at -1 20) ; ""Who are you?" the prince demands. "I thought you were supposed to be a princess?! Why, you're nothing more than a PEASANT girl!" You blanch a bit at that remark, but say nothing."
				(local3 cycleSpeed: 1 setAvoider: (Avoid new:))
				(Print 15 51) ; ""Well, ta, ta," he says. "I'm off. Here, you may keep THIS!" To your surprise, he tosses the little golden crown to you as he takes his leave. Good riddance, you think."
				((Inv at: 10) moveTo: gEgo) ; Small_Crown
				(= global182 1)
				(gGame changeScore: 2)
				(if (< (local3 x:) (gEgo x:))
					(= local6 0)
				else
					(= local6 1)
				)
				(local3
					view: 226
					setStep: 2 1
					setLoop: -1
					loop: local6
					setCycle: End self
				)
			)
			(55
				(local3
					view: 227
					cycleSpeed: 0
					setCycle: Walk
					setAvoider: (Avoid new:)
				)
				(if (< (local3 x:) 150)
					(local3 setMotion: MoveTo -10 150 self)
				else
					(local3 setMotion: MoveTo 330 150 self)
				)
			)
			(56
				(HandsOn)
				(gEgo setCycle: Walk)
				(local3 dispose:)
			)
			(60
				(gEgo view: 2 setLoop: -1 cycleSpeed: 0 setCycle: Walk)
				(= local3 (Act new:))
				(local3
					view: 372
					setCycle: Walk
					posn: (- (gEgo x:) 10) (gEgo y:)
					setMotion: MoveTo (- (local7 x:) 3) (local7 y:) self
					init:
				)
			)
			(61
				(local3 view: 370 loop: 0 cycleSpeed: 3 setCycle: Fwd)
			)
			(70
				(= global110 1)
				(= local3 (Act new:))
				(local3
					view: 378
					posn: (- (gEgo x:) 6) (+ (gEgo y:) 4)
					illegalBits: 0
					setAvoider: (Avoid new:)
					setCycle: Walk
					setMotion: MoveTo 244 142 self
					init:
				)
			)
			(71
				(local3 dispose:)
			)
			(100
				(= seconds (Random 3 8))
			)
			(101
				(if (== (gEgo onControl: 1) 512)
					(self changeState: 100)
				else
					(local3
						view: 378
						loop: 1
						posn: 216 140
						cel: 0
						cycleSpeed: 1
						setCycle: End self
						setMotion: MoveTo 206 145
						show:
					)
				)
			)
			(102
				(local3
					view: 370
					loop: 0
					illegalBits: -32768
					cycleSpeed: 2
					setCycle: Fwd
				)
				(= global110 0)
			)
		)
	)
)

(instance ballActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(LookAt gEgo local7)
				(gEgo view: 21 cel: 0 setCycle: End self)
			)
			(2
				(local7 dispose:)
				(gEgo get: 5) ; Gold_Ball
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 2 setCycle: Walk)
				(HandsOn)
				(if (or (== global110 4) (== global110 3))
					(local3
						illegalBits: 0
						ignoreActors:
						view: 373
						cel: 0
						setLoop: 1
						setMotion: MoveTo 244 142
						cycleSpeed: 1
						setCycle: End self
					)
				)
			)
			(4
				(= global110 1)
				(frogActions changeState: 100)
				(local3 hide:)
			)
			(10
				(HandsOff)
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) 10)
						(- (gEgo y:) 10)
						self
				)
			)
			(11
				(HandsOn)
				(gEgo loop: 1)
			)
		)
	)
)

(instance drinking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 21 cel: 0 setCycle: End self)
			)
			(1
				(= seconds 5)
				(= global120 (Print 15 52 #at -1 20 #dispose)) ; "You bend down and drink a bit of the pond water. Well, it's not wonderful, but it satisfies your thirst."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(HandsOn)
				(cls)
				(gEgo view: 2 setCycle: Walk)
				(gEgo script: global164)
			)
		)
	)
)

