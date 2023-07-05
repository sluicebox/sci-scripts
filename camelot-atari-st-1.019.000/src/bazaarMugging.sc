;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 159)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	bazaarMugging 0
)

(instance thief of Act
	(properties
		yStep 5
		view 354
		xStep 5
	)
)

(instance moAct of Act
	(properties
		y 140
		x 204
		view 347
		xStep 4
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(Said 'look[/mohammed,merchant,guard,man]')
					(MouseClaimed self event)
				)
				(Print 159 0) ; "A most formidable looking man, but with an honest face. I would say he was previously a soldier who has gone into business selling what he knows best."
			)
			(
				(or
					(Said 'look/dagger,scimitar,blade')
					(Said 'ask/merlin/dagger,scimitar,blade')
				)
				(Print 159 1) ; "He wears an extremely good scimitar and dagger and from the looks of him, he knows how to use them."
			)
			(
				(or
					(Said 'talk,give,buy,sell,bargain')
					(Said 'ask[/man,mohammed,merchant]')
				)
				(Print 159 2) ; "Mohammed is busy closing his shop."
			)
			((Said 'look,use/lodestone')
				(if (gEgo has: 2) ; lodestone
					(Print 159 3) ; "You wish to waste time with your lodestone when a thief has just stolen your purse?!"
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
		)
	)
)

(instance fakeMari of Act
	(properties
		y 34
		x 126
		view 351
		priority 10
		signal 16
		illegalBits 0
	)
)

(instance moLLeftShutter of Prop
	(properties
		y 85
		x 57
		view 156
		loop 2
		priority 10
		signal 16
	)
)

(instance moRLeftShutter of Prop
	(properties
		y 85
		x 103
		view 156
		loop 3
		priority 10
		signal 16
	)
)

(instance moLRightShutter of Prop
	(properties
		y 84
		x 148
		view 156
		loop 2
		priority 10
		signal 16
	)
)

(instance moRRightShutter of Prop
	(properties
		y 84
		x 192
		view 156
		loop 3
		priority 10
		signal 16
	)
)

(instance bazaarMugging of Script
	(properties)

	(method (init)
		(super init: &rest)
		(thief loop: 0 posn: 135 142 setCycle: Walk init:)
		(moAct setLoop: 2 posn: 78 140 init:)
		((= global184 fakeMari) setLoop: 1 setCel: 0 init:)
		(moRRightShutter init: setCel: 0 stopUpd:)
		(moLRightShutter init: setCel: 0 stopUpd:)
		(moRLeftShutter init: setCel: 0 stopUpd:)
		(moLLeftShutter init: setCel: 0 stopUpd:)
		(self changeState: 1)
	)

	(method (dispose)
		(thief dispose:)
		(moAct dispose:)
		(global184 dispose:)
		(moRRightShutter dispose:)
		(moLRightShutter dispose:)
		(moRLeftShutter dispose:)
		(moLLeftShutter dispose:)
		(thief delete:)
		(moAct delete:)
		(global184 delete:)
		(= global184 0)
		(moRRightShutter delete:)
		(moLRightShutter delete:)
		(moRLeftShutter delete:)
		(moLLeftShutter delete:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(if (IsFlag 20)
					(gMuleObj loop: 0 setMotion: MoveTo 50 180)
				)
				(moAct setLoop: 2 setCel: 0)
				(gEgo posn: 0 154 setMotion: MoveTo 15 154)
				(moAct setLoop: 2 setCel: 0 cycleSpeed: 2 setCycle: End)
				(moRLeftShutter setCel: 1 cycleSpeed: 1 setCycle: End self)
				(moLLeftShutter setCel: 1 cycleSpeed: 1 setCycle: End)
			)
			(2
				(Print 159 4 #width 280) ; "So this is the bazaar of Jerusalem. Tiny shops line both sides of the street. And such smells! Delicious foods combined with the raw sewage in the gutter. Watch where you step."
				(gEgo setMotion: MoveTo 70 154)
				(moRLeftShutter stopUpd:)
				(moLLeftShutter stopUpd:)
				(moAct setLoop: 3 setCel: 0 setCycle: End self)
			)
			(3
				(thief setScript: doMugging)
				(= cycles 16)
			)
			(4
				(global184 setScript: (ScriptID 56 2)) ; closeShutters
				(moAct setLoop: 4 setCel: 0)
				(= cycles 16)
			)
			(5
				(moAct
					setLoop: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 168 140 self
				)
			)
			(6
				(moAct setLoop: 2 setCel: 0 cycleSpeed: 2 setCycle: End)
				(moRRightShutter setCel: 1 cycleSpeed: 1 setCycle: End self)
				(moLRightShutter setCel: 1 cycleSpeed: 1 setCycle: End)
			)
			(7
				(moRRightShutter setCycle: 0 stopUpd:)
				(moLRightShutter setCycle: 0 stopUpd:)
				(moAct
					setLoop: 0
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 230 140 self
				)
			)
			(8
				(moAct setLoop: 4 cel: 0 setCycle: 0 setMotion: 0)
				(= cycles 1)
			)
			(9
				(client setScript: 0)
			)
		)
	)
)

(instance doMugging of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thief ignoreActors: setLoop: 1 setMotion: MoveTo 93 154 self)
			)
			(1
				(if (gEgo has: 3) ; purse
					(PutItem 3) ; purse
				)
				(thief setLoop: 2 setCel: 0 ignoreActors: 1 setCycle: End self)
			)
			(2
				(SetMenu 1281 112 0)
				(clr)
				(Print 159 5 #dispose) ; "Arthur! That little thief has grabbed your purse!"
				(thief setLoop: 3 setCycle: Walk setMotion: MoveTo 197 230)
				(= cycles 20)
			)
			(3
				(clr)
				(thief setMotion: MoveTo 197 230 self)
				(HandsOn)
				(SetFlag 143)
			)
			(4
				(thief setCycle: 0 setMotion: 0 setScript: 0)
			)
		)
	)
)

