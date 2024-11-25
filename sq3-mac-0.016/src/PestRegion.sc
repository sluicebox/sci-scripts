;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 503)
(include sci.sh)
(use Main)
(use Interface)
(use Follow)
(use Chase)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	PestRegion 0
)

(local
	local0
	local1
)

(instance guard of Act
	(properties)
)

(instance beam of View ; UNUSED
	(properties)
)

(instance blast of Act
	(properties)
)

(instance PestRegion of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsVIEW 92)
		(Load rsSOUND 44)
	)

	(method (notify)
		(self setScript: guardActions)
	)

	(method (doit)
		(super doit:)
		(if (and (== global105 1) (<= (-- global121) 0))
			(= global105 0)
			(= global120 2)
			(gEgo view: 0)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(if
						(or
							(Said '/area')
							(Said '/around')
							(Said '[<around][/!*]')
						)
						(Print 503 0) ; "You are in"
					)
				)
				((or (Said 'turn<on/belt') (Said 'activate/belt'))
					(cond
						((== global120 2)
							(Print 503 1) ; "The invisibility belt is now out of power."
						)
						((== global120 1)
							(Print 503 2) ; "It's already on."
						)
						(else
							(Print 503 3) ; "OK"
							(= global120 1)
							(= global105 1)
							(gEgo view: 123)
						)
					)
				)
				((or (Said 'turn<off/belt') (Said 'deactivate/belt'))
					(cond
						((== global120 2)
							(Print 503 4) ; "It's already dead."
						)
						((== global120 0)
							(Print 503 5) ; "It's already off."
						)
						(else
							(Print 503 3) ; "OK"
							(= global105 0)
							(= global120 1)
							(gEgo view: 0)
						)
					)
				)
				((Said 'talk/guard')
					(= global114 3)
					(self notify:)
				)
			)
		)
	)
)

(instance guardActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== global122 2) (== global105 1) (>= state 2))
			(Print 503 6) ; "Where'd he go? I could have sworn... Nah, couldn't be."
			(= global122 4)
			(guard setMotion: 0)
		)
		(if (and (== global122 4) (== global105 0))
			(= global122 2)
			(= state 1)
			(guard setMotion: Chase gEgo 250)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 503 7) ; "You here someone coming toward you."
				(= seconds global114)
			)
			(1
				(= global122 2)
				(= local1 (Random (- (gEgo y:) 20) (+ (gEgo y:) 20)))
				(if (< (gEgo y:) (+ (gCurRoom horizon:) 2))
					(= local1 (+ (gCurRoom horizon:) 2))
				)
				(if (< (Random 1 10000) 5000)
					(= local0 326)
				else
					(= local0 -7)
				)
				(guard
					view: 593
					setCycle: Walk
					illegalBits: $8000
					setAvoider: Avoid
					posn: local0 local1
					setMotion: Chase gEgo 250 self
					init:
				)
			)
			(2
				(cond
					((or (< (guard x:) 3) (> (guard x:) 316))
						(-- state)
						(guard setMotion: Follow gEgo 5)
						(= seconds 1)
					)
					((and (!= global122 4) (== global105 0))
						(Print 503 8) ; "There he is!"
						(guard
							setMotion: 0
							setLoop: (if (== (guard loop:) 0) 2 else 3)
							cel: 255
							setCycle: End self
						)
					)
				)
			)
			(3
				(gLongSong number: 44 loop: 1 priority: 2 play:)
				(guard
					setLoop: (if (== (guard loop:) 2) 4 else 5)
					cel: 255
					setCycle: End self
				)
			)
			(4
				(HandsOff)
				(blast
					view: 593
					setLoop: (if (== (guard loop:) 0) 6 else 7)
					cel: 255
					setCycle: End
					setStep: 30 10
					ignoreActors:
					illegalBits: 0
					setPri: (gEgo priority:)
					x:
						(if (== (guard loop:) 4)
							(+ (guard x:) 3)
						else
							(- (guard x:) 3)
						)
					y: (- (guard y:) 16)
					init:
				)
				(RedrawCast)
				(blast setMotion: MoveTo (gEgo x:) (- (gEgo y:) 18) self)
			)
			(5
				(blast dispose:)
				(gEgo view: 92 setLoop: 2 cel: 0 setCycle: Fwd)
				(= seconds 7)
			)
			(6
				(EgoDead 901 0 7 999)
			)
		)
	)
)

