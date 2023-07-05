;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 435)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	mantrayArena 0
	mantray 1
)

(local
	[local0 200]
	local200
	local201 = 150
	local202 = 123
	local203
	local204
	local205
	local206
)

(procedure (localproc_0 param1)
	(param1 posn: (+ (param1 x:) local203) (+ (param1 y:) local204))
)

(procedure (localproc_1)
	(if (== gHowFast 0)
		(return)
	)
	(= local203 (Random 2 4))
	(= local204 (Random 1 2))
	(if local205
		(= local203 (- local203))
	)
	(if local206
		(= local204 (- local204))
	)
	(localproc_0 body)
	(localproc_0 mouth)
	(localproc_0 leftEye)
	(localproc_0 rightEye)
	(localproc_0 leftWing)
	(localproc_0 rightWing)
	(localproc_0 mantray)
)

(procedure (localproc_2)
	(if (== gHowFast 0)
		(return)
	)
	(localproc_0 body)
	(localproc_0 mouth)
	(localproc_0 leftEye)
	(localproc_0 rightEye)
	(localproc_0 leftWing)
	(localproc_0 rightWing)
	(localproc_0 mantray)
)

(instance body of View
	(properties
		view 437
		loop 9
	)
)

(instance leftEye of Prop
	(properties
		view 437
	)
)

(instance rightEye of Prop
	(properties
		view 437
		loop 1
	)
)

(instance leftWing of Prop
	(properties
		view 437
		loop 7
	)
)

(instance rightWing of Prop
	(properties
		view 437
		loop 8
	)
)

(instance mouth of Prop
	(properties
		view 437
		loop 2
	)
)

(instance mantrayArena of Arena
	(properties
		picture 400
	)

	(method (dispose)
		(stingerMusic stop:)
		(gEndBattle number: (SoundFX 38) play:)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 437)
		(= local205 (Random 0 1))
		(= local206 (Random 0 1))
		(= monster mantray)
		(= global332 435)
		(super init: &rest)
		(stingerMusic number: (SoundFX 2) loop: -1 play:)
		(monster setScript: mantrayScript)
	)

	(method (doit)
		(cond
			((and local205 (< (mantray x:) (- local201 20)))
				(= local205 0)
			)
			((and (not local205) (> (mantray x:) (+ local201 20)))
				(= local205 1)
			)
		)
		(cond
			((and local206 (< (mantray y:) (- local202 8)))
				(= local206 0)
			)
			((and (not local206) (> (mantray y:) (+ local202 8)))
				(= local206 1)
			)
		)
		(if (>= local200 3)
			(= local200 0)
			(localproc_1)
		else
			(++ local200)
		)
		(if (and (IsFlag 233) (== (mantrayScript state:) 0))
			(mantrayScript setScript: mantrayHurt)
		)
		(super doit:)
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
		y 115
		x 150
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
		warriorX 185
		warriorY 210
		flameX 169
		flameY 92
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
		(client
			view: 437
			ignoreActors:
			setLoop: 3
			setPri: 0
			cel: 0
			posn: (- local201 1) (+ local202 1)
			setCycle: Fwd
		)
		(leftWing
			posn: (- local201 56) (- local202 27)
			ignoreActors:
			setPri: 2
			init:
			setCycle: Fwd
		)
		(rightWing
			posn: (+ local201 56) (- local202 27)
			ignoreActors:
			setPri: 2
			init:
			setCycle: Fwd
		)
		(body setPri: 2 ignoreActors: posn: local201 local202 init: stopUpd:)
		(leftEye
			posn: (- local201 36) (- local202 20)
			ignoreActors:
			setPri: 3
			init:
		)
		(rightEye
			posn: (+ local201 37) (- local202 20)
			ignoreActors:
			setPri: 3
			init:
		)
		(mouth
			posn: (+ local201 1) (- local202 19)
			ignoreActors:
			setPri: 3
			init:
		)
		(if (== gHowFast 0)
			(leftEye addToPic:)
			(rightEye addToPic:)
			(mouth addToPic:)
			(body addToPic:)
		else
			(leftEye cycleSpeed: 1 setCycle: Fwd)
			(rightEye cycleSpeed: 1 setCycle: Fwd)
			(mouth cycleSpeed: 3 setCycle: Fwd)
		)
	)

	(method (doit)
		(if (and global251 (== state 0) (not script))
			(+= cycles global251)
			(= global251 0)
			(ClearFlag 233)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 3 setCycle: Fwd action: 0)
				(if (< cycles 12)
					(= cycles (Random 7 18))
				)
			)
			(1
				(client action: 1 setLoop: (Random 4 6) setCel: 0)
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1)
				)
				(= cycles 3)
			)
			(2
				(if (client ateEgo:)
					(client doDamage: (client opponent:) ateEgo: 0)
				)
				(client setCycle: End self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance mantrayHurt of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 233)
				(= local203 -3)
				(= local204 -12)
				(localproc_2)
				(mouth setLoop: 9 setCel: 1)
				(= cycles 4)
			)
			(1
				(= local203 2)
				(= local204 8)
				(localproc_2)
				(= cycles 2)
			)
			(2
				(mouth setLoop: 2 setCel: -1)
				(client changeState: 0)
				(self dispose:)
			)
		)
	)
)

