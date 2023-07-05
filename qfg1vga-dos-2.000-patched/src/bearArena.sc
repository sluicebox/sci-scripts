;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
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
	bearArena 0
	bear 1
	aFightScript 2
)

(local
	local0
	[local1 11] = [0 0 0 0 0 0 0 0 0 0 5]
	[local12 11] = [0 0 0 1 0 2 0 1 0 0 -32768]
	[local23 7] = [1 0 1 1 1 0 -32768]
)

(instance bearLegs of Prop
	(properties
		x 149
		y 91
		view 422
		loop 3
	)
)

(instance bearMusic of Sound
	(properties
		number 2
		priority 2
		loop -1
	)
)

(instance bear of Monster
	(properties
		view 422
		strength 70
		intell 25
		agil 40
		vit 65
		luck 25
		weap 50
		dodge 60
		armorValue 3
		weapValue 5
		attackRange 65
		warriorX 100
		warriorY 133
		flameX 164
		flameY 67
	)

	(method (init)
		(= global451 1422)
		(PalVary pvCHANGE_TARGET 1422)
		(AssertPalette 422)
		(super init:)
	)

	(method (die)
		(opponent canFight: 0)
		(self setScript: 0)
		(= canFight 0)
		(= action 10)
		(= local0 1)
		(SetFlag 169)
		(SolvePuzzle 601 -25)
		(gCurRoom newRoom: 171) ; rmBear
	)
)

(instance bearArena of Arena
	(properties
		picture 425
	)

	(method (dispose)
		(= global451 0)
		(bearMusic dispose:)
		(DisposeScript 419)
		(gLongSong2 number: (SoundFX 38) loop: 1 play:)
		(super dispose:)
	)

	(method (init)
		TCyc
		(= monster bear)
		(= global279 420)
		(= gPrevRoomNum 171) ; rmBear
		(super init: &rest)
		(bear drawStatus:)
		(gAddToPics add: bearLegs doit:)
		(bear ignoreActors: ignoreControl: -32768)
		(Load rsVIEW 422)
		(bear
			view: 422
			setLoop: 0
			cel: 0
			posn: 206 88
			setPri: 10
			cycleSpeed: 15
			init:
			setScript: aFightScript
		)
		(bearMusic number: (SoundFX 2) init: play:)
	)
)

(instance aFightScript of Script
	(properties)

	(method (doit)
		(cond
			(local0
				(= local0 (= cycles 0))
			)
			((and global230 (== state 0))
				(ClearFlag 233)
				(self changeState: 7)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 284)
				(bear
					setLoop: 0
					setCel: 0
					setCycle: 0
					ateEgo: 0
					setPri: 5
					stopUpd:
					action: 0
				)
				(if (IsFlag 285)
					(ClearFlag 285)
					(self cue:)
				)
				(if (not (Random 0 2))
					(= state -1)
				)
				(switch (Random 0 1)
					(0
						(client setCycle: TCyc @local12 self)
					)
					(1
						(client setCycle: TCyc @local23 self)
					)
				)
			)
			(1
				(bear setLoop: 1 setCel: 0)
				(= ticks 25)
				(if (bear tryAttack: (bear opponent:))
					(bear ateEgo: 1)
				)
			)
			(2
				(ClearFlag 284)
				(if (bear ateEgo:)
					(bear setPri: 14 action: 3)
				else
					(bear action: 1)
				)
				(if (Random 0 1)
					(client setLoop: 2)
					(bear setCel: 0 setCycle: CT 2 1 self)
				else
					(client setLoop: 0)
					(bear setCel: 0 setCycle: CT 3 1 self)
				)
			)
			(3
				(if (bear ateEgo:)
					(bear setPri: 5)
					(bear doDamage: (bear opponent:) ateEgo: 0)
				)
				(= ticks 15)
			)
			(4
				(bear setCycle: End self)
			)
			(5
				(= ticks 15)
			)
			(6
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

