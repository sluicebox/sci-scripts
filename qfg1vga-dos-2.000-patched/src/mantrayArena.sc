;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 435)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use n814)
(use DPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	mantrayArena 0
	mantray 1
	recoilScript 2
)

(local
	[local0 5] = [0 150 123 0 0]
	local5
	local6
)

(instance tail of Prop
	(properties
		x 197
		y 51
		view 437
		loop 2
	)

	(method (doit)
		(if (mantray mover:)
			(self x: (+ (mantray x:) 3) y: (+ (mantray y:) 3) forceUpd:)
		)
		(super doit:)
	)
)

(instance mantrayArena of Arena
	(properties
		picture 430
	)

	(method (dispose)
		(= global451 0)
		(stingerMusic dispose:)
		(gLongSong2 number: (SoundFX 38) play:)
		(DisposeScript 964)
		(super dispose:)
	)

	(method (init)
		DPath
		(= local5 (Random 0 1))
		(= local6 (Random 0 1))
		(= monster mantray)
		(monster drawStatus:)
		(= global279 435)
		(super init: &rest)
		(if gNight
			(Animate (gCast elements:) 0)
		)
		(stingerMusic number: (SoundFX 2) loop: -1 play:)
		(Load rsVIEW 437)
		(mantray init: setScript: mantrayScript)
		(tail init: setPri: 3 ignoreActors:)
		(stinger init: ignoreActors: setPri: 8 setLoop: 3)
	)
)

(instance stingerMusic of Sound
	(properties
		number 2
		priority 2
		loop -1
	)
)

(instance mantray of Monster
	(properties
		x 194
		y 48
		view 437
		loop 3
		strength 50
		intell 20
		agil 70
		vit 40
		luck 40
		weap 50
		dodge 50
		armorValue 3
		weapValue 6
		attackRange 85
		warriorX 87
		warriorY 168
		flameX 169
		flameY 92
	)

	(method (init)
		(= global451 1437)
		(PalVary pvCHANGE_TARGET 1437)
		(AssertPalette 437)
		(super init:)
	)

	(method (die)
		(SolvePuzzle 738 2 0)
		(self canFight: 0)
	)
)

(instance mantrayScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(client view: 437 setPri: 5 ignoreActors:)
	)

	(method (doit)
		(if (and global230 (== state 0) (not script))
			(+= cycles global230)
			(= global230 0)
			(ClearFlag 233)
		)
		(if (and (< (client x:) 194) (not register))
			(= register 1)
			(tail setScript: attackScript)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(if (not (tail script:))
					(tail
						setLoop: 4
						setCel: 0
						cycleSpeed: 15
						setPri: 1
						setCycle: Fwd
					)
				)
				(client
					setLoop: 0
					moveSpeed: 5
					cycleSpeed: 10
					ateEgo: 0
					setCel: 0
					setCycle: Fwd
					action: 3
				)
				(client setMotion: DPath 219 50 223 62 240 68 self)
			)
			(1
				(client setMotion: MoveTo 169 64 self)
			)
			(2
				(if (== (client x:) 169)
					(client action: 1)
				)
				(if (not (tail script:))
					(= register 1)
					(tail setScript: attackScript)
				)
				(client setMotion: MoveTo (+ (client x:) 10) (client y:))
				(if (== (client action:) 1)
					(= ticks 200)
				else
					(= ticks 45)
				)
			)
			(3
				(= state -1)
				(client action: 3 setMotion: MoveTo 194 48 self)
			)
		)
	)
)

(instance recoilScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tail setLoop: 4 setCycle: 0)
				(client
					setLoop: 0
					cycleSpeed: 7
					moveSpeed: 3
					setCycle: Fwd
					setMotion: MoveTo 194 48 self
				)
				(if (and (not (Random 0 3)) (not (tail script:)))
					(tail setScript: attackScript)
				)
			)
			(1
				(client setScript: mantrayScript)
			)
		)
	)
)

(instance attackScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tail setCycle: 0 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(1
				(stinger
					setCel: 0
					posn: (- (tail x:) 57) (- (tail y:) 15)
					setCycle: CT 2 1 self
				)
				(if (mantray tryAttack: (mantray opponent:))
					(mantray ateEgo: 1)
				)
			)
			(2
				(if (mantray ateEgo:)
					(stinger setMotion: MoveTo 95 80 self)
				else
					(stinger setMotion: MoveTo 0 103 self)
				)
			)
			(3
				(stinger posn: 500 500 stopUpd:)
				(if (mantray ateEgo:)
					(mantray doDamage: (mantray opponent:) ateEgo: 0)
				)
				(tail setLoop: 4 setCel: 0 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance stinger of Actor
	(properties
		x 500
		y 500
		yStep 40
		view 437
		loop 3
		cycleSpeed 12
		illegalBits 0
		xStep 60
		moveSpeed 0
	)
)

