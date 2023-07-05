;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 385)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	RudySearch 0
)

(synonyms
	(rudolph person man)
)

(local
	[local0 6] = [246 158 76 150 192 112]
	local6
	local7
	local8
)

(instance Rudy of Act
	(properties
		y 146
		x 173
		view 380
	)

	(method (handleEvent event)
		(cond
			((and (not (& global207 $0100)) (MousedOn self event 3))
				(event claimed: 1)
				(|= global207 $0100)
				(Say 0 385 0) ; "It seems that Rudy Dijon is Gloria Swansong's brother, and Gertie's son. (You surmise that "Swansong" must be Gloria's stagename.) Rudy is a handsome man and any woman would be attracted to him. But, you sense an undercurrent of hostility in Rudy; a sense that he should not be crossed."
			)
			(
				(and
					(& global207 $0100)
					(or (MousedOn self event 3) (Said 'look/rudolph'))
				)
				(event claimed: 1)
				(Print 385 1) ; "Rudy appears to be frantically searching for something in your room. He seems to be very upset."
			)
			((Said 'ask,tell//*<about')
				(= global213 9)
				(switch local8
					(0
						(Say 1 385 2) ; "Leave me alone! I'm busy right now!"
						(++ local8)
					)
					(1
						(Print 385 3) ; "Rudy's not paying any attention. He's too busy looking for something else."
					)
				)
			)
			((Said 'show,give/*')
				(if (and global219 global224)
					(Print 385 3) ; "Rudy's not paying any attention. He's too busy looking for something else."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said '/rudolph>')
				(cond
					((Said 'talk')
						(= global213 9)
						(switch local7
							(0
								(Say 1 385 4) ; ""Beat it, kid! This ain't none of your business!"
							)
							(1
								(Say 1 385 5) ; "Did ya hear me!! If you know what's good for you, you'll leave me alone right now!"
							)
							(else
								(Print 385 6) ; "Rudy ignores you as he continues his seemingly futile searching."
							)
						)
						(++ local7)
					)
					((Said 'get')
						(Print 385 7) ; "You can't get Rudy!"
					)
					((Said 'kill')
						(Print 385 8) ; "Now, now! There's no need for that!"
					)
					((Said 'kiss,embrace')
						(Print 385 9) ; "Even though he IS attractive, you'll pass."
					)
				)
			)
			((Said 'flirt//rudolph<with')
				(Print 385 10) ; "It's tempting, but it's not you."
			)
		)
	)
)

(instance RudySearch of Rgn
	(properties)

	(method (init)
		(super init:)
		(= global195 256)
		(Load rsVIEW 393)
		(self setScript: searching)
		(Rudy
			setAvoider: ((Avoid new:) offScreenOK: 1)
			illegalBits: -32768
			init:
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
	)
)

(instance searching of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0004))
						(|= gMustDos $0004)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(Rudy
					view: 380
					cycleSpeed: 0
					setCycle: Walk
					setMotion:
						MoveTo
						[local0 (* local6 2)]
						[local0 (+ (* local6 2) 1)]
						self
				)
			)
			(2
				(Rudy view: 393 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(= seconds 3)
			)
			(4
				(Rudy setCycle: Beg self)
				(if (< local6 2)
					(++ local6)
					(= state -1)
				)
			)
			(5
				(Rudy
					view: 380
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo -20 152 self
				)
			)
			(6
				(Rudy dispose:)
				(client setScript: 0)
			)
		)
	)
)

