;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 455)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	ogreArena 0
	ogre 1
)

(local
	local0
	local1
	local2
	local3
)

(instance ogreArena of Arena
	(properties
		picture 400
	)

	(method (dispose)
		(ogreMusic stop:)
		(gEndBattle number: (SoundFX 38) loop: 1 play:)
		(super dispose:)
	)

	(method (init)
		(= monster ogre)
		(= global332 455)
		(Load rsVIEW 457)
		(super init: &rest)
		(ogre cycleSpeed: 1 setPri: 5)
		(ogreLegs init:)
		(gAddToPics add: ogreLegs doit:)
		(ogreMusic number: (SoundFX 2) loop: -1 play:)
		(monster setScript: ogreScript)
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
		y 105
		x 150
		view 457
		priority 10
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
		warriorX 176
		warriorY 212
		flameX 166
		flameY 74
	)

	(method (die)
		(SolvePuzzle 739 2 0)
		(self canFight: 0)
	)
)

(instance ogreScript of Script
	(properties)

	(method (doit)
		(if (and (== (ogre cel:) 0) (== (ogre loop:) 4))
			(ClearFlag 233)
		)
		(if (and global251 (== state 0))
			(+= cycles global251)
			(= global251 0)
			(ClearFlag 233)
		)
		(if (and (IsFlag 233) (or (== (ogre loop:) 0) (== (ogre loop:) 4)))
			(= cycles 0)
			(ogre setCycle: 0)
			(client setScript: ogreHurt)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(= local1 1)
		(client view: 457 setLoop: 0 setPri: 10 illegalBits: 0 cel: 8)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client action: 0 stopUpd:)
				(if local2
					(= local2 0)
					(= cycles 1)
				else
					(= cycles (Random 8 14))
				)
			)
			(1
				(client
					action: 1
					startUpd:
					setLoop: (if (Random 0 1) 0 else 4)
					cel: 0
					setCycle: End self
				)
			)
			(2
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1)
				)
				(= cycles 8)
			)
			(3
				(client
					setLoop: (if (Random 0 1) 1 else 5)
					cel: 0
					setCycle: End self
				)
			)
			(4
				(client setLoop: (- (client loop:) 1) cel: 0)
				(RedrawCast)
				(if (and (client ateEgo:) (not local3))
					(client doDamage: (client opponent:) ateEgo: 0)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance ogreLegs of PV
	(properties
		y 184
		x 156
		view 457
		loop 2
		priority 2
	)
)

(instance ogreFace of Prop
	(properties
		view 457
		loop 3
	)
)

(instance ogreHurt of Script
	(properties)

	(method (dispose)
		(= local2 1)
		(ogreFace dispose:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 233)
				(ogre ignoreActors:)
				(switch (ogre loop:)
					(0
						(if (ogre cel:)
							(ogreFace posn: 136 83)
						else
							(ogreFace posn: 147 74)
						)
					)
					(4
						(if (ogre cel:)
							(ogreFace posn: 157 86)
						else
							(ogreFace posn: 142 79)
						)
					)
				)
				(ogreFace init: setLoop: 3 setPri: 14 setCycle: End self)
			)
			(1
				(client setScript: ogreScript)
			)
		)
	)
)

