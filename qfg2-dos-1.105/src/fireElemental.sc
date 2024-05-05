;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 309)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Flame)
(use TryToMoveTo)
(use Elemental)
(use Rev)
(use Chase)
(use Motion)
(use System)

(public
	fireElemental 0
)

(local
	theDiag
	index
	kattaInnSign
	[owTable 9] = [0 {Ow!__Hey!} {Man, that's hot!} {Wowf!} {Yowp!} {Watch out!} {Ouch!} {Yikes!} {Geez!}]
	[diagLoops 8] = [2 3 0 2 0 1 2 3]
	[deltaPosn 8] = [-15 -15 15 -15 -15 15 15 15]
	[moveList 18] = [0 0 40 180 50 130 110 100 290 180 265 130 205 100 140 155 180 155]
	[string 25]
)

(procedure (FindWhere thePoint)
	(= index (* thePoint 2))
	(fireElemental newX: [moveList index] newY: [moveList (+ index 1)])
)

(instance beginIncense of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (fireElemental x:) (gEgo x:))
					(fireElemental setMotion: MoveTo 120 135)
				else
					(fireElemental setMotion: MoveTo 200 135)
				)
				(gEgo setMotion: MoveTo 160 135 self)
			)
			(1
				(gEgo setHeading: 0)
				(fireElemental setMotion: MoveTo 160 180)
				(= cycles 8)
			)
			(2
				(client illegalBits: 0 following: 1 wandering: 0 cue:)
				(gEgo view: 18 loop: 3 setCycle: gEgoStopWalk 21)
				(self dispose:)
			)
		)
	)
)

(instance getBurned of HandsOffScript
	(properties)

	(method (init)
		(super init: &rest)
		(gEgo illegalBits: -32512)
	)

	(method (changeState newState &tmp theX theY dmgAmount theLoop)
		(switch (= state newState)
			(0
				(Face gEgo fireElemental 0 self)
			)
			(1
				(= theDiag [diagLoops (gEgo loop:)])
				(gEgo view: 19 setLoop: theDiag setCycle: End self)
			)
			(2
				(if (fireElemental following:)
					(= theX (- (gEgo x:) 5))
					(= theY (- (gEgo y:) 15))
					(= theLoop 2)
				else
					(= index (* theDiag 2))
					(= theX (+ (gEgo x:) [deltaPosn index]))
					(= theY (+ (gEgo y:) [deltaPosn (+ index 1)]))
					(= theLoop (+ theDiag 4))
				)
				(gEgo
					view: 0
					setLoop: theLoop
					setCycle: Rev
					setMotion: TryToMoveTo theX theY 500 self
				)
			)
			(3
				(HighPrint (Format @string 309 0 [owTable (Random 1 8)])) ; "%s"
				(= dmgAmount (+ 20 (* 20 (fireElemental following:))))
				(if (not (TakeDamage dmgAmount))
					(EgoDead ; "Being fired really burns you up, doesn't it? Welcome to our exclusive, embers-only club."
						0
						309
						1
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
			(4
				(NormalEgo)
				(gEgo
					view: (if (fireElemental following:) 18 else 0)
					loop: (if (== index 2) 2 else 3)
					hurtScript: 0
				)
				(fireElemental cue:)
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
				(= theX (gEgo x:))
				(= theY (gEgo y:))
				(cond
					((and (< theX elemX) (< theY elemY))
						(= theX (- elemX 30))
						(= theY (- elemY 8))
						(= theDiag 0)
					)
					((and (>= theX elemX) (< theY elemY))
						(= theX (+ elemX 30))
						(= theY (- elemY 8))
						(= theDiag 1)
					)
					((and (< theX elemX) (>= theY elemY))
						(= theX (- elemX 33))
						(= theY (+ elemY 8))
						(= theDiag 2)
					)
					(else
						(= theX (+ elemX 33))
						(= theY (+ elemY 8))
						(= theDiag 3)
					)
				)
				(if (< theY 100)
					(= theY (+ elemY 8))
				)
				(if (> theY 190)
					(= theY (- elemY 8))
				)
				(if (< theX 25)
					(= theX (+ elemX (- elemX theX)))
				)
				(if (> theX 295)
					(= theX (- elemX (- theX elemX)))
				)
				(gEgo setMotion: MoveTo theX theY self)
			)
			(1
				(gEgo view: 61 loop: theDiag setCycle: Fwd)
				(fireElemental loop: 4 cel: 0 setCycle: End self)
			)
			(2
				(= elemX (fireElemental x:))
				(= elemY (fireElemental y:))
				(switch (gEgo loop:)
					(0
						(= theX (+ elemX 25))
						(= theY (+ elemY 25))
					)
					(1
						(= theX (- elemX 25))
						(= theY (+ elemY 25))
					)
					(2
						(= theX (+ elemX 25))
						(= theY (- elemY 25))
					)
					(3
						(= theX (- elemX 25))
						(= theY (- elemY 25))
					)
				)
				(fireElemental
					loop: 0
					illegalBits: (| (fireElemental illegalBits:) $0040)
					setCycle: Fwd
					setMotion: TryToMoveTo theX theY 500 self
				)
			)
			(3
				(fireElemental
					loop: 4
					cel: 6
					illegalBits: -32768
					setCycle: Beg self
				)
				(NormalEgo)
				(= cycles 1)
			)
			(4
				(HighPrint 309 2) ; "The elemental dodges easily in the open plaza."
				(fireElemental loop: 2 following: 0 setCycle: Fwd species)
				(gEgo loop: (+ theDiag 4))
				(self dispose:)
			)
		)
	)
)

(instance fireElemental of Elemental
	(properties
		x 160
		y 160
		noun '/elemental[<fire]'
		description {the Fire Elemental}
		lookStr {It is a magical mass of fire.}
		view 340
		loop 2
		signal 26624
		wandering 1
		wanderList 8
	)

	(method (init)
		(super init: &rest)
		(self baseSetter: fireBase)
		(if (== gDay 6)
			(self setMotion: Chase gEgo 25)
		)
		(= kattaInnSign (ScriptID 300 1)) ; kattaInnSign
	)

	(method (attack)
		(gEgo hurtScript: getBurned)
		(super attack:)
		(if (not following)
			(self wander:)
		)
	)

	(method (wander)
		(super wander:)
		(FindWhere wandering)
		(self setMotion: TryToMoveTo newX newY 500 self)
	)

	(method (doit)
		(if (and (fireElemental inRect: 210 90 244 126) (== (kattaInnSign cel:) 5))
			((littleFire new:) posn: 243 48 priority: 8 signal: 16 init:)
			(kattaInnSign
				view: 340
				loop: 9
				cel: 1
				description: {the very burnt sign}
				forceUpd:
			)
			(SetFlag 181) ; fBurntTailSign
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/courtyard')
				)
				(HighPrint 309 3) ; "There is a Fire Elemental loose in the plaza!"
			)
			(
				(Said
					'drop,use,done,spread,sprinkle,strew,dust/trail,frankincense'
				)
				(if (not (OneOf (gEgo view:) 18 21))
					(if (not (gEgo has: 13)) ; Incense
						(HighPrint 309 4) ; "Hey, now there's an idea! Maybe you should see about getting some."
					else
						(self setScript: beginIncense)
					)
				else
					(HighPrint 309 5) ; "You are currently leaving a trail of incense. I wouldn't stand in one spot if I were you."
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
						(HighPrint 309 6) ; "You don't have any water."
					)
					((> (gEgo distanceTo: fireElemental) 50)
						(HighPrint 309 7) ; "Your waterskin won't squirt that far."
					)
					(else
						(if (< (-= gDrinksLeft 3) 0)
							(= gDrinksLeft 0)
						)
						(self
							setMotion: 0
							following: 1
							setScript: douseElemental
						)
					)
				)
			)
		)
	)

	(method (ignite)
		(gSpareSound number: 561 loop: 1 vol: 60 play:)
		((littleFire new:) posn: x y init:)
	)

	(method (detectMe)
		(HighPrint 309 8) ; "There is a strong sense of magic upon the Fire Elemental."
	)

	(method (hurtMe damage whatHurt)
		(switch whatHurt
			(25
				(HighPrint 309 9) ; "The Fire Elemental seems to like that a lot."
			)
			(27
				(HighPrint 309 10) ; "That doesn't seem to affect the living flames of the Elemental."
			)
		)
	)

	(method (fetchMe)
		(HighPrint 309 11) ; "You can't seem to fetch the flames."
	)
)

(instance fireBase of Code
	(properties)

	(method (doit theActor &tmp theX)
		(= theX (theActor x:))
		(BaseSetter theActor)
		(theActor brLeft: (- theX 9) brRight: (+ theX 9))
	)
)

(instance littleFire of Fire
	(properties
		noun '/fire'
		description {the baby fire}
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (and (== x 243) (== y 48))
				(HighPrint 309 12) ; "The Katta's Tail Inn sign is aflame!"
			else
				(HighPrint 309 13) ; "It's a Fire Elemental dropping."
			)
		)
	)
)

