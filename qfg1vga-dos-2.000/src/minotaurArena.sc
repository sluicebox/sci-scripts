;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 425)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use TCyc)
(use n814)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	minotaurArena 0
	minotaur 1
	minotaurScript 2
	ball 3
)

(local
	local0
	local1
	local2
	[local3 11] = [0 0 0 1 0 2 0 1 0 0 -32768]
	[local14 11] = [0 0 0 2 0 0 0 2 0 0 -32768]
)

(instance minotaurArena of Arena
	(properties
		picture 430
	)

	(method (dispose)
		(= global451 0)
		(minoMusic dispose:)
		(gLongSong2 number: (SoundFX 38) loop: 1 play:)
		(DisposeScript 956)
		(DisposeScript 419)
		(super dispose:)
	)

	(method (init)
		(minoMusic init:)
		ForwardCounter
		TCyc
		(= monster minotaur)
		(monster ignoreActors: ignoreControl: -32768 drawStatus:)
		(super init: &rest)
		(if gNight
			(Animate (gCast elements:) 0)
		)
		(ball init:)
		(gAddToPics add: legs doit:)
		(minoMusic number: (SoundFX 2) loop: -1 play:)
		(minotaur init: setScript: minotaurScript)
	)
)

(instance minotaur of Monster
	(properties
		x 190
		y 100
		view 427
		strength 80
		intell 40
		agil 60
		vit 100
		luck 50
		weap 70
		dodge 40
		armorValue 5
		weapValue 10
		attackRange 65
		warriorX 124
		warriorY 152
		flameX 174
		flameY 81
	)

	(method (init)
		(= global451 1427)
		(PalVary pvCHANGE_TARGET 1427)
		(AssertPalette 427)
		(super init:)
	)

	(method (die)
		(SolvePuzzle 737 5 0)
		(self canFight: 0)
	)
)

(instance minotaurScript of Script
	(properties)

	(method (doit)
		(cond
			((and global230 (== state 0) (not script))
				(self changeState: 7)
				(ClearFlag 233)
			)
			(local0
				(= local1 (= cycles 0))
			)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(= global279 425)
		(client view: 427 setLoop: 0 cel: 0 setPri: 4 cycleSpeed: 20)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(SetFlag 284)
				(ball posn: 500 500 forceUpd: show:)
				(client action: 0 setLoop: 0 setCel: 0 cycleSpeed: 20 ateEgo: 0)
				(cond
					((IsFlag 285)
						(ClearFlag 285)
						(= state 2)
						(self cue:)
					)
					((Random 0 1)
						(client setCycle: TCyc @local3 self)
					)
					(else
						(client setCycle: TCyc @local14 self)
					)
				)
			)
			(1
				(= ticks 10)
			)
			(2
				(client action: 3 setLoop: 4 setCel: 0)
				(if (< (= temp0 (Random 1 3)) 2)
					(= state -1)
				)
				(ball cel: 0 posn: 141 59 setCycle: ForwardCounter temp0 self)
			)
			(3
				(ClearFlag 284)
				(ball posn: 500 500)
				(client action: 1)
				(client setCel: 0 setLoop: 0 setCycle: CT 3 1 self)
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1)
					(if (gEgo has: 2) ; sword
						(client setPri: 14)
					)
				)
			)
			(4
				(if (client ateEgo:)
					(client ateEgo: 0 doDamage: (client opponent:))
					(ShakeScreen 2 ssUPDOWN)
				)
				(= ticks 8)
			)
			(5
				(client setCycle: End)
				(= ticks 30)
			)
			(6
				(client setPri: -1 ateEgo: 0)
				(= state -1)
				(= ticks 12)
			)
			(7
				(client action: 0)
				(client setCycle: 0)
				(= state -1)
				(= ticks (* global230 3))
				(= global230 0)
			)
		)
	)
)

(instance legs of View
	(properties
		x 190
		y 100
		view 427
		loop 2
		priority 2
	)
)

(instance ball of Prop
	(properties
		x 500
		y 500
		view 427
		loop 3
	)
)

(instance minoMusic of Sound
	(properties
		number 2
		priority 2
		loop -1
	)
)

