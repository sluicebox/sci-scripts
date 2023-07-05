;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
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
	cheetaurArena 0
	cheetaur 1
	aFightScript 2
)

(local
	local0
	[local1 37] = [0 0 0 0 0 0 0 0 0 2 0 0 1 2 2 0 0 0 1 0 2 3 0 0 0 -32768 0 0 2 0 0 0 3 0 0 0 -32768]
	[local38 11] = [0 0 0 1 0 2 0 1 0 0 -32768]
)

(instance cheetMusic of Sound
	(properties
		number 2
		priority 2
		loop -1
	)
)

(instance cheetRoar of Sound
	(properties
		flags -1
		number 107
		priority 1
	)
)

(instance legs of View
	(properties
		x 164
		y 105
		view 442
		loop 4
		priority 5
	)
)

(instance cheetaur of Monster
	(properties
		x 165
		y 105
		view 442
		strength 70
		intell 65
		agil 70
		vit 50
		luck 30
		weap 40
		dodge 60
		armorValue 3
		weapValue 5
		attackRange 65
		warriorX 115
		warriorY 145
		flameX 152
		flameY 80
	)

	(method (init)
		(= global451 1442)
		(PalVary pvCHANGE_TARGET 1442)
		(AssertPalette 442)
		(super init:)
	)

	(method (die)
		(SolvePuzzle 612 4 0)
		(= local0 1)
	)
)

(instance cheetaurArena of Arena
	(properties
		picture 430
	)

	(method (dispose)
		(= global451 0)
		(cheetMusic stop:)
		(cheetRoar dispose:)
		(gLongSong2 number: (SoundFX 38) loop: 1 play:)
		(DisposeScript 419)
		(super dispose:)
	)

	(method (init)
		TCyc
		(= monster cheetaur)
		(monster drawStatus:)
		(= global279 440)
		(super init: &rest)
		(legs init: stopUpd:)
		(Load rsVIEW 442)
		(cheetaur
			init:
			ignoreControl: -32768
			ignoreActors:
			stopUpd:
			setScript: aFightScript
		)
		(cheetMusic number: (SoundFX 2) init: play:)
		(cheetRoar init: play:)
	)
)

(instance aFightScript of Script
	(properties)

	(method (doit)
		(cond
			(local0
				(= local0 (= cycles 0))
			)
			((and global230 (== state 0) (not script))
				(self changeState: 7)
				(ClearFlag 233)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 284)
				(cheetaur
					view: 442
					action: 0
					cycleSpeed: 25
					ateEgo: 0
					setLoop: 0
					setCel: 0
					setPri: -1
				)
				(legs setPri: 5 stopUpd:)
				(if (IsFlag 285)
					(ClearFlag 285)
					(self cue:)
				)
				(switch (Random 0 1)
					(0
						(client setCycle: TCyc @local38 self)
					)
					(1
						(cheetRoar play:)
						(cheetaur setCycle: End self)
					)
				)
			)
			(1
				(client stopUpd:)
				(if (not (Random 0 3))
					(= state -1)
				)
				(= ticks 25)
			)
			(2
				(ClearFlag 284)
				(if (cheetaur tryAttack: (cheetaur opponent:))
					(cheetaur ateEgo: 1 setPri: 14)
				)
				(client action: 1 setCel: 0 cycleSpeed: 25)
				(switch (Random 0 1)
					(0
						(= register 2)
						(client view: 443 setLoop: 0)
						(client setCycle: CT 1 1 self)
					)
					(1
						(cheetRoar play:)
						(= register 3)
						(client view: 444 setLoop: 0)
						(client setCycle: CT 2 1 self)
					)
				)
			)
			(3
				(if (cheetaur ateEgo:)
					(cheetaur
						ateEgo: 0
						doDamage: (cheetaur opponent:)
						action: 3
					)
				)
				(= ticks 18)
			)
			(4
				(if (== register 2)
					(client setPri: -1)
					(legs setPri: 5 stopUpd:)
				)
				(client setCycle: End self)
			)
			(5
				(cheetaur stopUpd:)
				(if (== register 3)
					(= ticks 18)
				else
					(= ticks 1)
				)
			)
			(6
				(cheetaur ateEgo: 0)
				(self changeState: 0)
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

