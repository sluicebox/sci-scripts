;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 303)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Stage)
(use TryToMoveTo)
(use Elemental)
(use LoadMany)
(use Rev)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm303 0
)

(local
	[string 25]
	bits = -130
	outOfStuff
	lampDown
	theDiag
	egoCycler
	[owTable 25] = [0 {Ow!  Hey!} {Man, that's hot!} {Wowf!} {Yowp!} {Watch out!} {Ouch!} {Yikes!} {Geez!} 2 3 0 2 0 1 2 3 -15 -15 15 -15 -15 15 15 15]
)

(instance rm303 of Stage
	(properties
		picture 303
		style 15
		north 704
		south 704
		bottomFromX 158
		bottomFromY 250
		bottomToX 158
	)

	(method (init &tmp [temp0 22])
		(LoadMany rsVIEW 0 1 18 19 21 47 61 340 700 701)
		(LoadMany rsSCRIPT 969)
		(= gXEgo 40)
		(= gYEgo 1)
		(NormalEgo)
		(gEgo view: 18 loop: 3 illegalBits: bits init:)
		(= entranceScript enterScript)
		(AFeat_1 init:)
		(AFeat_2 init:)
		(AFeat_3 init:)
		(AFeat_4 init:)
		(AFeat_5 init:)
		(AFeat_6 init:)
		(AFeat_7 init:)
		(super init:)
	)

	(method (cue)
		(super cue:)
		(= egoCycler (gEgo cycler:))
	)

	(method (doit)
		(super doit:)
		(cond
			((& (gEgo onControl: 1) $0080)
				(gEgo hide:)
				(gCurRoom newRoom: 704) ; alleyRoom
			)
			(
				(and
					(== (fireElemental loop:) 0)
					(== (fireElemental attackDist:) 15)
				)
				(fireElemental attackDist: 1)
			)
			(
				(and
					(fleeTimer client:)
					(== (gEgo y:) (fireElemental y:))
					(== (fireElemental attackDist:) 1)
				)
				(fleeTimer cue:)
			)
			((and (< (gEgo y:) 115) (not outOfStuff) (not (gEgo script:)))
				(HighPrint 303 0) ; "You're out of incense!"
				(NormalEgo)
				(gEgo use: 13 1 loop: 2 illegalBits: bits) ; Incense
				(= outOfStuff 1)
			)
		)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(EgoGait 0 0) ; walking
		(super dispose:)
	)

	(method (handleEvent event &tmp spellNum)
		(cond
			((super handleEvent: event))
			((Said 'run')
				(EgoGait 1 0) ; running
				(gEgo setMotion: MoveTo 160 0)
			)
			(
				(Said
					'drop,use,done,spread,sprinkle,strew,dust/trail,frankincense'
				)
				(if (OneOf (gEgo view:) 18 21)
					(HighPrint 303 1) ; "You're already layin' it out as fast as you can!"
				else
					(HighPrint 303 2) ; "Unless you feel like scraping some off the alley floor, you'd better get used to the fact that you are incenseless."
				)
			)
			((gEgo has: 13) ; Incense
				(event claimed: 1)
				(HighPrint 303 3) ; "You should lead the Elemental farther into the alley."
			)
			((Said '/lamp>')
				(cond
					((not (gEgo has: 33)) ; BrassLamp
						(event claimed: 1)
						(DontHave)
					)
					((Said 'put<down')
						(HighPrint 303 4) ; "Ok, "You worthless, second-hand, unpolishable, thriftstore-hatched piece of unwanted brass! Your kind makes me sick! (and various grumblings)." How's that?"
						(gEgo setScript: doLamp 0 1)
					)
					((Said 'drop')
						(HighPrint 303 5) ; "You drop the lamp. It is very hurt and angry.  "I have a new flame now," you say to the lamp, "and she's the light of my life. You couldn't hold a candle to her." But inside your heart burns with the loss of your bright young friend, the lamp."
						(gEgo setScript: doLamp 0 1)
					)
					((Said 'use,set')
						(if (== gElementalState 1)
							(gEgo setScript: doLamp 0 1)
						else
							(event claimed: 0)
						)
					)
				)
			)
			(
				(or
					(Said
						'spray,squirt,splash/fire,(elemental[<fire]),water,waterbag'
					)
					(Said 'douse,(put<out)/fire,(elemental[<fire])')
					(Said 'throw,use/water,waterbag')
				)
				(cond
					((<= gDrinksLeft 0)
						(HighPrint 303 6) ; "You have no water."
					)
					((> (fireElemental y:) 180)
						(HighPrint 303 7) ; "You should let the elemental get farther into the alley first."
					)
					((> (gEgo distanceTo: fireElemental) 50)
						(HighPrint 303 8) ; "The Elemental is too far away to douse."
					)
					(else
						(= gDrinksLeft 0)
						(fireElemental setScript: douseElemental)
					)
				)
			)
		)
	)
)

(instance getBurned of Script
	(properties)

	(method (init)
		(super init: &rest)
		(HandsOff)
	)

	(method (changeState newState &tmp theX theY)
		(switch (= state newState)
			(0
				(gEgo
					view: 19
					setLoop: (if (< (gEgo x:) 160) 1 else 0)
					setCycle: End self
				)
			)
			(1
				(= theY
					(if (gCast contains: lamp)
						(lamp y:)
					else
						115
					)
				)
				(= theX (+ (gEgo x:) (if (< (gEgo x:) 160) 8 else -8)))
				(if (< (gEgo y:) theY)
					(HighPrint 303 9) ; "You barely manage to escape the Fire Elemental's searing heat."
					(gEgo hide:)
					(gCurRoom newRoom: 704) ; alleyRoom
				else
					(gEgo
						view: 0
						setLoop: 2
						setCycle: Rev
						setMotion: MoveTo theX (- (gEgo y:) 15) self
					)
				)
			)
			(2
				(HighPrint (Format @string 303 10 [owTable (Random 1 8)])) ; "%s"
				(if (not (TakeDamage 40))
					(EgoDead ; "Being fired really burns you up, doesn't it? Welcome to our exclusive, embers-only club."
						0
						303
						11
						#title
						{All your joints feel inflamed...}
						#icon
						19
						2
						4
					)
				else
					(self cue:)
				)
			)
			(3
				(NormalEgo)
				(gEgo
					view: (egoCycler vWalking:)
					loop: 2
					illegalBits: bits
					setCycle: gEgoStopWalk (egoCycler vStopped:)
				)
				(HandsOn 1)
				(= cycles 12)
			)
			(4
				(fireElemental cue:)
				(gEgo hurtScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance douseElemental of HandsOffScript
	(properties)

	(method (changeState newState &tmp theX theY elemX elemY)
		(switch (= state newState)
			(0
				(= elemX (fireElemental x:))
				(= elemY (fireElemental y:))
				(if (> elemX 160)
					(= theX (- elemX 30))
					(= theDiag 0)
				else
					(= theX (+ elemX 30))
					(= theDiag 1)
				)
				(= theY (- elemY 8))
				(client setMotion: 0)
				(gEgo setMotion: MoveTo theX theY self)
			)
			(1
				(gEgo view: 61 loop: theDiag setCycle: Fwd)
				(fireElemental loop: 4 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(2
				(gEgo
					view: 0
					loop: (+ (gEgo loop:) 4)
					setCycle: gEgoStopWalk 4
				)
				(fireElemental loop: 0 cycleSpeed: 0 setCycle: Fwd)
				(StartTimer fleeTimer 15)
				(= cycles 1)
			)
			(3
				(NormalEgo)
				(gEgo illegalBits: bits)
				(if lampDown
					(fireElemental setScript: jumpIntoLamp)
					(fleeTimer dispose:)
				else
					(fireElemental setPri: -1)
				)
				(self dispose:)
			)
		)
	)
)

(instance jumpIntoLamp of HandsOffScript
	(properties)

	(method (changeState newState &tmp theX theY)
		(switch (= state newState)
			(0
				(if (>= (gEgo heading:) 180)
					(gEgo
						setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
					)
				else
					(gEgo
						setMotion: MoveTo (+ (gEgo x:) 10) (gEgo y:) self
					)
				)
			)
			(1
				(Face gEgo fireElemental)
				(= theX (+ (lamp x:) 20))
				(= theY (+ (lamp y:) 3))
				(fireElemental setPri: -1 setMotion: MoveTo theX theY self)
			)
			(2
				(Face gEgo lamp)
				(fireElemental loop: 5 setCycle: End self)
			)
			(3
				(SolvePuzzle 622 20)
				(SkillUsed 14 100) ; honor
				(fireElemental dispose: delete:)
				(gCSound fade:)
				(ClearFlag 181) ; fBurntTailSign
				(++ gElementalState)
				(lamp setCycle: Fwd)
				(gEgo setScript: doLamp 0 0)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fireElemental posn: 158 250 setCycle: Fwd init:)
				(gEgo setCycle: gEgoStopWalk 21)
				(self dispose:)
			)
		)
	)
)

(instance doLamp of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register 0)
					(gEgo setMotion: MoveTo 160 (+ (lamp y:) 3) self)
				else
					(gEgo setMotion: MoveTo 160 (gEgo y:) self)
				)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo view: 47 loop: 1 setCycle: End self)
			)
			(3
				(if (== register 1)
					(lamp posn: 145 (- (gEgo y:) 3) init:)
					(gEgo use: 33) ; BrassLamp
					(= lampDown 1)
				else
					(lamp dispose:)
					(gEgo get: 33) ; BrassLamp
					(if (fleeTimer client:)
						(fleeTimer dispose:)
					)
					(= lampDown 0)
				)
				(gEgo setCycle: Beg self)
			)
			(4
				(if (== register 1)
					(EgoGait 0 0) ; walking
					(gEgo setMotion: MoveTo 180 (- (gEgo y:) 15) self)
				else
					(if (== gElementalState 2)
						(HighPrint 303 12) ; "As you pick up the lamp and rub it, a small flame appears. When you rub it again, the flame goes away. You now have a magic lamp. You put the lamp safely away in your backpack."
					else
						(HighPrint 303 13) ; "You put the lamp away."
					)
					(self cue:)
				)
			)
			(5
				(if (gCast contains: lamp)
					(Face gEgo lamp 0 self)
				else
					(= cycles 1)
				)
			)
			(6
				(NormalEgo)
				(gEgo illegalBits: bits)
				(if (fleeTimer client:)
					(fleeTimer cue:)
				)
				(self dispose:)
			)
		)
	)
)

(instance fireElemental of Elemental
	(properties
		x 160
		y 160
		noun '/elemental'
		description {the fire elemental}
		lookStr {You see a magical mass of fire.}
		view 340
		loop 2
		priority 14
		signal 26640
		following 1
	)

	(method (attack)
		(gEgo hurtScript: getBurned)
		(super attack:)
	)

	(method (follow &tmp chanceLeft theChance xDiff)
		(= xDiff (- x (gEgo x:)))
		(= chanceLeft (* 5 xDiff))
		(if (< (= theChance (Random 1 100)) chanceLeft)
			(= newX (- x (Random 1 (+ 10 xDiff))))
		else
			(= xDiff (Abs xDiff))
			(= newX (+ x (Random 1 (+ 10 xDiff))))
		)
		(cond
			((gEgo script:))
			((< y 105)
				(= newX 160)
				(= newY 70)
			)
			((> y (gEgo y:))
				(= newY (- y 7))
			)
			(else
				(= newY (gEgo y:))
			)
		)
		(self setMotion: TryToMoveTo newX newY 500 self)
	)
)

(instance lamp of Prop
	(properties
		x 150
		y 150
		noun '/lamp'
		description {the lamp}
		view 340
		loop 7
		cel 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '(lockpick<up)/lamp')
				(if lampDown
					(gEgo setScript: doLamp 0 0)
				else
					(HighPrint 303 14) ; "You don't see a lamp here."
				)
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1)
				(if (!= gElementalState 1)
					(HighPrint 303 15) ; "You can see the Fire Elemental burning brightly inside the brass lamp."
				else
					(HighPrint 303 16) ; "The lamp is made of brass."
				)
			)
			((== theVerb 7)
				(if lampDown
					(gEgo setScript: doLamp 0 0)
				else
					(HighPrint 303 17) ; "You don't see one here."
				)
			)
		)
	)
)

(instance fleeTimer of Timer
	(properties)

	(method (cue)
		(HighPrint 303 18) ; "Without any means of containment, the Fire Elemental makes a hasty retreat back into the plaza."
		(fireElemental
			cycleSpeed: 0
			yStep: 5
			setMotion: MoveTo (fireElemental x:) 250
		)
		(self dispose:)
	)
)

(instance AFeat_1 of View
	(properties
		x 118
		y 118
		noun '/door'
		description {the door}
		lookStr {It's a door to nowhere.}
		view 701
		cel 4
		priority 8
		signal 24596
	)
)

(instance AFeat_2 of View
	(properties
		x 188
		y 90
		noun '/door'
		description {the door}
		lookStr {It's another door to nowhere.}
		view 701
		loop 1
		cel 8
		priority 5
		signal 24596
	)
)

(instance AFeat_3 of View
	(properties
		x 136
		y 45
		noun '/sconce,light,torch'
		description {the sconce}
		lookStr {At least there's SOME light in here.}
		view 701
		loop 4
		cel 12
		priority 15
		signal 24596
	)
)

(instance AFeat_4 of View
	(properties
		x 176
		y 69
		noun '/door'
		description {the door}
		lookStr {It's the door to success.}
		view 701
		loop 1
		cel 12
		priority 3
		signal 24596
	)
)

(instance AFeat_5 of View
	(properties
		x 160
		y 80
		noun '/door'
		description {the door}
		lookStr {Through this door lies the other side.}
		view 700
		priority 1
		signal 24596
	)
)

(instance AFeat_6 of View
	(properties
		x 160
		y 102
		noun '/door'
		description {the door}
		lookStr {I'll take what's behind door number 3.}
		view 700
		priority 1
		signal 24596
	)
)

(instance AFeat_7 of View
	(properties
		x 160
		y 140
		noun '/door'
		description {the door}
		lookStr {Huh?  It's only PAINTED on.}
		view 700
		priority 1
		signal 24596
	)
)

