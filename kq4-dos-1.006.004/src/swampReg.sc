;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 513)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	swampReg 0
)

(synonyms
	(water water marsh)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance poofSound of Sound
	(properties
		number 59
	)
)

(instance swampReg of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 5)
		(Load rsVIEW 6)
		(Load rsVIEW 7)
		(Load rsVIEW 10)
		(Load rsVIEW 372)
		(Load rsVIEW 377)
		(Load rsVIEW 193)
		(Load rsVIEW 680)
		(Load rsVIEW 370)
		(= local0 0)
		(gEgo viewer: swamp)
		(super init:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'bathe,dive,wade[<enter][/ocean]')
					(Print 513 0) ; "Just enter the swamp if you wish to try that."
				)
				(
					(or
						(Said 'enter/fish')
						(Said 'fish[/!*]')
						(Said 'capture/fish')
						(Said 'cast/pole')
					)
					(Print 513 1) ; "You don't see any fish here."
				)
				((Said 'get/water')
					(Print 513 2) ; "You have no reason to carry water."
				)
				((or (Said 'drink') (Said 'get/drink'))
					(if (== (gEgo view:) 2)
						(if
							(or
								(& (= local4 (NearControl gEgo 12)) $0008)
								(& local4 $0800)
								(& local4 $0002)
								(& local4 $0200)
							)
							(= global164 (gEgo script:))
							(gEgo setScript: drinking)
						else
							(Print 800 1) ; "You're not close enough."
						)
					else
						(Print 513 3) ; "Yech!! It tastes AWFUL!"
					)
				)
				((Said 'look<in/water')
					(Print 513 4) ; "The water is too murky."
				)
				((Said 'look,climb/boulder<[gray]')
					(Print 513 5) ; "You don't see many rocks."
				)
				((Said 'look>')
					(cond
						((Said '/water')
							(Print 513 6) ; "The mucky swamp spreads in all directions."
						)
						((Said '/cliff')
							(Print 513 7) ; "The steep mountain rises sharply to the west."
						)
						((Said '/dirt')
							(Print 513 8) ; "The ground is mostly covered with a swampy quagmire. You notice tufts of swamp grass poking up from the murky water."
						)
						((Said '/tuft')
							(Print 513 9) ; "You notice some grass tufts leading eastward."
						)
						((Said '/grass')
							(Print 513 10) ; "Swamp grass and reeds line the edges of the swamp. Tufts of thick grass poke up from the water."
						)
						((Said '/bush')
							(Print 513 11) ; "Large shrubs encircle the mucky bog."
						)
						((Said '/flora')
							(Print 513 12) ; "The marsh is filled with plant life; from thick reeds, to moss hanging from tall swamp trees."
						)
						((Said '/blossom')
							(Print 513 13) ; "You don't see many flowers in a swamp."
						)
						((Said '/forest')
							(Print 513 14) ; "Large, moss-draped trees grow abundantly here."
						)
					)
				)
				((Said 'climb,cross/cliff')
					(Print 513 15) ; "The mountain is too difficult to climb."
				)
				((Said 'get/blossom')
					(Print 513 13) ; "You don't see many flowers in a swamp."
				)
				((or (Said 'wear/crown') (Said 'place/crown'))
					(cond
						(
							(and
								(gEgo inRect: 115 149 274 181)
								(== gCurRoomNum 78)
							)
							(Print 513 16) ; "That wouldn't be a good idea right now."
						)
						((!= (gEgo view:) 2)
							(Print 513 17) ; "Not here."
						)
						((gEgo has: 10) ; Small_Crown
							(swamp changeState: 20)
						)
						(else
							(Print 800 2) ; "You don't have it."
						)
					)
				)
				((or (Said 'detach/crown') (Said 'get<off/crown'))
					(if (== global105 13)
						(swamp changeState: 30)
					else
						(Print 513 18) ; "You're not wearing it."
					)
				)
			)
		)
	)
)

(instance swamp of Script
	(properties)

	(method (doit)
		(super doit:)
		(= local0 (= local1 (gEgo onControl: 1)))
		(cond
			((and (== global105 12) (== global132 0))
				(switch local1
					(1
						(gEgo illegalBits: $8000 view: 2)
					)
					(2048
						(gEgo illegalBits: $8400 view: 5)
					)
					(512
						(gEgo illegalBits: $8400 view: 6)
					)
					(8
						(gEgo illegalBits: $8400 view: 7)
					)
					(2
						(self changeState: 1)
					)
				)
			)
			((== global105 13)
				(if (== (gEgo mover:) 0)
					(gEgo cel: 0)
				)
				(switch local1
					(1
						(gEgo illegalBits: $c000 view: 372)
					)
					(2048
						(gEgo illegalBits: $8000 view: 377)
					)
					(512
						(gEgo illegalBits: $8000 view: 377)
					)
					(8
						(gEgo view: 377 illegalBits: $8000)
					)
					(2
						(self changeState: 10)
					)
					(1024
						(gEgo illegalBits: $8000 view: 372)
					)
					(else
						(gEgo illegalBits: $c400 view: 377)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(= global105 0)
				(gEgo
					illegalBits: $0001
					view: 73
					cel: 0
					loop: (& (gEgo loop:) $0001)
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gEgo hide:)
				(Print 513 19) ; "Uh, oh! What did you do, Rosella?!"
				(Print 513 20) ; "Don't you know that some swamps are quagmires that will suck you under?! As you take your last breath, you contemplate this final information."
				(Timer setReal: self 5)
			)
			(3
				(= gDeathFlag 1)
			)
			(10
				(HandsOff)
				(= global105 0)
				(= local3 (Act new:))
				(local3
					view: 193
					posn: (gEgo x:) (- (gEgo y:) 5)
					loop: 0
					cel: 0
					ignoreActors:
					setCycle: End self
					init:
				)
				((Sound new:) number: 47 play:)
			)
			(11
				(gEgo hide:)
				(= global105 0)
				(local3 loop: 1 cel: 0 setCycle: End self)
			)
			(12
				(local3 loop: 2 cel: 0 setCycle: Fwd)
				(Timer setReal: self 4)
			)
			(13
				(Print 513 21 #at -1 10) ; "Oh, boy! I sure love frog legs!"
				(local3 cel: 0 loop: 3 setCycle: End self)
			)
			(14
				(local3 dispose:)
				(Timer setReal: self 5)
			)
			(15
				(= gDeathFlag 1)
			)
			(20
				(HandsOff)
				(gSounds eachElementDo: #stop 0)
				(poofSound play:)
				(= local2 (Prop new:))
				(local2
					posn: (gEgo x:) (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					view: 680
					cel: 0
					loop: 0
					ignoreActors:
					setCycle: CT 5 1 self
					init:
				)
			)
			(21
				(local2 setCycle: End self)
				(= global105 13)
				(gEgo observeControl: 16384)
				(gEgo view: 370)
			)
			(22
				(Timer setReal: self 3)
				(local2 dispose:)
			)
			(23
				(gEgo view: 372 setCycle: Walk)
				(HandsOn)
			)
			(30
				(HandsOff)
				(gSounds eachElementDo: #stop 0)
				(poofSound play:)
				(= local2 (Prop new:))
				(local2
					posn: (gEgo x:) (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					view: 680
					cel: 0
					loop: 0
					ignoreActors:
					setCycle: CT 5 1 self
					init:
				)
			)
			(31
				(local2 setCycle: End self)
				(= global105 12)
				(gEgo view: 2 ignoreControl: 16384 setCycle: Walk)
				(HandsOn)
			)
			(32
				(local2 dispose:)
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
				(= local5 (gEgo viewer:))
				(gEgo viewer: 0 view: 21 cel: 0 setCycle: End self)
			)
			(1
				(= global120 (Print 513 22 #at -1 10 #dispose)) ; "You kneel down and drink the mucky swamp water. Yech!! It tastes AWFUL!"
				(Timer setReal: self 4)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(cls)
				(gEgo view: 2 setCycle: Walk)
				(gEgo viewer: local5 script: global164)
				(HandsOn)
			)
		)
	)
)

