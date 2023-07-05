;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 604)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use System)

(public
	gardenReg 0
)

(instance gardenReg of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 1)
		(super init:)
		(ClearFlag 49)
		(ClearFlag 50)
	)

	(method (doit)
		(super doit: &rest)
		(if (& (gEgo onControl: 1) $0006)
			(gEgo z: -5)
		else
			(gEgo z: 0)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event))
			(
				(and
					(& (event modifiers:) emSHIFT)
					(or (IsFlag 49) (IsFlag 50))
				)
				(ClearFlag 50)
				(ClearFlag 49)
				(event claimed: 1)
			)
			(
				(or
					(Said 'look,look/garden,grass,bury,bush')
					(and
						(& $0404 (OnControl CONTROL (event x:) (event y:)))
						(& (event modifiers:) emSHIFT)
						(not (IsFlag 49))
					)
				)
				(SetFlag 49)
				(Print 604 0) ; "This is a well-tended carrot patch. The carrots look tempting to a hungry traveler."
				(event claimed: 1)
			)
			(
				(or
					(Said 'look,look/brick,border')
					(and
						(& $4000 (OnControl CONTROL (event x:) (event y:)))
						(& (event modifiers:) emSHIFT)
						(not (IsFlag 50))
					)
				)
				(SetFlag 50)
				(Print 604 1) ; "A brick border surrounds a well-kept garden."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room]')
						(Print 604 2) ; "You see a brick border surrounding a well-kept garden."
					)
					((Said '<down')
						(if (& (gEgo onControl: 1) $0006)
							(Print 604 3) ; "There are many large, plump carrots in the garden."
						else
							(event claimed: 0)
						)
					)
					((Said '/carrot')
						(cond
							((gEgo has: 2) ; Carrot
								(event claimed: 0)
							)
							((& (gEgo onControl: 1) $0006)
								(Print 604 3) ; "There are many large, plump carrots in the garden."
							)
							(else
								(Print 604 4) ; "The carrots are buried in the ground. You must get closer to see them."
							)
						)
					)
				)
			)
			((Said 'get,get,pick/carrot')
				(cond
					((gEgo has: 2) ; Carrot
						(Print 604 5) ; "You already have a carrot."
					)
					((gCurRoom script:)
						(Print 604 6) ; "You're too busy to pick a carrot."
					)
					((IsFlag 1)
						(Print 604 7) ; "You can't pick a carrot while you're invisible."
					)
					((& (gEgo onControl: 1) $0006)
						(gCurRoom setScript: pickCarrot)
					)
					(else
						(Print 604 8) ; "You must be in the carrot patch to pick a carrot."
					)
				)
			)
		)
	)
)

(instance pickCarrot of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (gEgo isStopped:) (== state 0) (gEgo isBlocked:))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 134 135)
			)
			(1
				(gEgo
					view: 1
					setLoop:
						(if
							(and
								(< 120 (gEgo heading:) 260)
								(< (gEgo loop:) 2)
							)
							2
						else
							-1
						)
					setMotion: 0
					setCycle: End self
				)
				(ClearFlag 10)
			)
			(2
				((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
				(Print 604 9) ; "You pluck a plump, orange carrot from the ground."
				(gEgo get: 2) ; Carrot
				(if (not (IsFlag 5))
					(SetScore 64 2)
				)
				(= cycles 4)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(proc0_1)
				(gEgo illegalBits: -31744)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

