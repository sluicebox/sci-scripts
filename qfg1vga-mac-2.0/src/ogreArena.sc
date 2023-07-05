;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 455)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use TCyc)
(use n814)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	ogreArena 0
	ogre 1
	ogreScript 2
	ogreLegs 3
)

(local
	[local0 3]
	[local3 7] = [4 0 4 5 4 0 -32768]
)

(instance ogreArena of Arena
	(properties
		picture 430
	)

	(method (dispose)
		(ogreMusic dispose:)
		(DisposeScript 419)
		(gLongSong2 number: 38 loop: 1 play:)
		(super dispose:)
	)

	(method (init)
		(= monster ogre)
		(= global279 455)
		(monster drawStatus:)
		TCyc
		(super init: &rest)
		(Load rsVIEW 457)
		(ogreLegs init: setPri: 2 stopUpd:)
		(ogreMusic number: 2 loop: -1 play:)
		(monster init: setScript: ogreScript)
	)
)

(instance ogreMusic of Sound
	(properties
		number 2
		priority 2
		loop -1
	)
)

(instance ogre of Monster
	(properties
		x 165
		y 80
		view 457
		priority 10
		illegalBits 0
		strength 70
		intell 15
		agil 50
		vit 50
		luck 40
		weap 50
		dodge 40
		armorValue 3
		weapValue 7
		attackRange 40
		warriorX 97
		warriorY 161
		flameX 159
		flameY 77
	)

	(method (init)
		(super init:)
	)

	(method (die)
		(SolvePuzzle 739 2 0)
		(self canFight: 0)
	)
)

(instance ogreScript of Script
	(properties)

	(method (doit)
		(if (and global230 (== state 0))
			(self changeState: 9)
			(ClearFlag 233)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 284)
				(client
					loop: 0
					cel: 0
					setPri: 10
					x: 165
					y: 80
					ateEgo: 0
					action: 3
					cycleSpeed: 20
				)
				(ogreLegs cel: 0 x: 166 y: 88 show: forceUpd:)
				(cond
					((IsFlag 285)
						(ClearFlag 285)
						(self cue:)
					)
					((Random 0 1)
						(client setCycle: End self)
					)
					(else
						(client cel: 3 setCycle: Beg self)
					)
				)
			)
			(1
				(= ticks 20)
			)
			(2
				(ClearFlag 284)
				(client action: 1 loop: 3 cel: 0 x: 123 y: 25 forceUpd:)
				(ogreLegs hide: forceUpd:)
				(= ticks (Random 12 18))
			)
			(3
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1 setPri: 14)
				)
				(ogreLegs cel: 1 x: 156 y: 94 show: forceUpd:)
				(client
					loop: 4
					cel: 0
					x: 164
					y: 79
					cycleSpeed: 18
					forceUpd:
					setCycle: CT 4 1 self
				)
			)
			(4
				(if (client ateEgo:)
					(client ateEgo: 0 doDamage: (client opponent:))
				)
				(= ticks 18)
			)
			(5
				(cond
					((client ateEgo:)
						(ShakeScreen 2 ssUPDOWN)
					)
					((Random 0 2)
						(client ateEgo: 0)
						(= state 2)
					)
				)
				(client setCel: 5)
				(= ticks 20)
			)
			(6
				(client action: 0 cycleSpeed: 24 setCycle: TCyc @local3 self)
			)
			(7
				(client action: 3 loop: 3 cel: 0 x: 123 y: 25 forceUpd:)
				(ogreLegs hide: forceUpd:)
				(client ateEgo: 0)
				(= ticks (Random 12 18))
			)
			(8
				(self changeState: 0)
			)
			(9
				(client action: 0)
				(client setCycle: 0)
				(= state -1)
				(= ticks (* global230 3))
				(= global230 0)
			)
		)
	)
)

(instance ogreLegs of View
	(properties
		x 166
		y 88
		view 457
		loop 2
	)
)

