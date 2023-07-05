;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	saracenDead 0
)

(local
	[local0 40] = [9 -2 15 5 -3 10 -30 4 -34 -10 -23 -26 23 -30 59 -23 80 -14 92 -6 98 2 85 6 72 10 46 20 25 26 2 34 -255 0 0 0 0 0 0 0]
	local40
	local41
	local42
	local43
)

(instance deadSaracen of Act
	(properties
		view 379
	)

	(method (init)
		(super init:)
		(self
			illegalBits: 0
			ignoreActors:
			posn: global196 global197
			loop: global179
			cel: (- (NumCels self))
		)
	)

	(method (doit &tmp [temp0 3])
		(super doit:)
		(if (and (== view 275) (== loop 2))
			(+= z 2)
		)
		(if (== view 175)
			(+= z 2)
			(|= signal $0800)
			(cond
				((< heading 112)
					(= loop 6)
				)
				((> heading 248)
					(= loop 5)
				)
				((> heading 180)
					(= loop 1)
				)
				(else
					(= loop 2)
				)
			)
		)
		(if (and local42 (not mover))
			(if (== [local0 local43] -255)
				(= local43 0)
			else
				(self
					setMotion:
						MoveTo
						(+ local40 [local0 local43])
						(+ local41 [local0 (+ local43 1)])
				)
				(+= local43 2)
			)
		)
	)
)

(instance doveShadow of Act
	(properties
		view 175
		signal 16384
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(self
			posn:
				(- (deadSaracen x:) (/ (deadSaracen z:) 4))
				(+ (deadSaracen y:) (/ (deadSaracen z:) 5))
				0
		)
		(cond
			((< (deadSaracen z:) 200)
				(= loop (+ (deadSaracen loop:) 2))
				(= cel (deadSaracen cel:))
			)
			((!= view 275)
				(self
					view: 275
					setLoop: 3
					cycleSpeed: 4
					setCycle: End saracenDead
				)
			)
		)
		(self
			setPri:
				(if (and (== gCurRoomNum 76) (doveShadow inRect: -20 104 266 300))
					3
				else
					1
				)
		)
	)
)

(instance radFade of Prop
	(properties
		view 275
	)

	(method (init)
		(super init:)
		(switch (deadSaracen loop:)
			(0
				(self posn: (- (deadSaracen x:) 28) (- (deadSaracen y:) 2))
			)
			(1
				(self posn: (- (deadSaracen x:) 7) (deadSaracen y:))
			)
			(2
				(self posn: (- (deadSaracen x:) 7) (+ (deadSaracen y:) 8))
			)
			(3
				(self posn: (- (deadSaracen x:) 43) (+ (deadSaracen y:) 2))
			)
			(else
				(self posn: (- (deadSaracen x:) 34) (+ (deadSaracen y:) 2))
			)
		)
		(self
			setPri: (+ (deadSaracen priority:) 1)
			cycleSpeed: 1
			setCycle: End saracenDead
		)
	)
)

(instance saracenDead of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 175)
				(Load rsVIEW 379)
				(Load rsVIEW 275)
				(= global167 0)
				(if (== global196 0)
					(= global196 150)
					(= global197 130)
				)
				(deadSaracen init:)
				(= seconds 2)
			)
			(1
				(radFade init:)
			)
			(2
				(radFade loop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(deadSaracen
					posn: (- (radFade x:) 2) (radFade y:) 25
					view: 275
					loop: 2
					cel: 0
					setCycle: End self
				)
				(= global198 30)
			)
			(4
				(= temp0 (if (> (deadSaracen x:) 160) 15 else 120))
				(Print 202 0 #dispose #at temp0 110) ; "You have killed the Saracen in a fair fight, and now his soul transforms into a dove and rises into the sky and vanishes from sight."
				(= local42 1)
				(= local40 (deadSaracen x:))
				(= local41 (deadSaracen y:))
				(deadSaracen view: 175 illegalBits: 0 setCycle: Fwd)
				(doveShadow init:)
				(radFade loop: 0 cel: 4 setCycle: Beg self)
			)
			(5
				(radFade dispose:)
			)
			(6
				(clr)
				(doveShadow dispose:)
				(deadSaracen dispose:)
				(= cycles 2)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

