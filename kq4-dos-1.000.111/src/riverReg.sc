;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 512)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use System)

(public
	riverReg 0
)

(synonyms
	(brook brook brook)
)

(local
	local0
	local1
)

(instance riverReg of Rgn
	(properties)

	(method (init)
		(super init:)
		(self setScript: riverActions)
		(Load rsVIEW 21)
	)

	(method (dispose)
		((ScriptID 0 4) dispose: delete:) ; timer1
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look<in/brook')
					(if
						(or
							(& (= local0 (NearControl gEgo 20)) $0008)
							(& local0 $0800)
							(& local0 $0002)
							(& local0 $0200)
						)
						(Print 512 0) ; "You peer into the rushing river and see nothing but sand and pebbles."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((or (Said 'look/brook') (Said 'look/water'))
					(Print 512 1) ; "The cold water of the river rushes westward."
				)
				((or (Said 'bathe/brook') (Said 'bathe') (Said 'enter/bathe'))
					(Print 512 2) ; "The river is too shallow for swimming."
				)
				(
					(or
						(Said 'fish[/!*]')
						(Said 'fish<enter')
						(Said 'look,capture/fish')
						(Said 'cast/pole')
					)
					(Print 512 3) ; "You don't see any fish here."
				)
				((Said 'wade/brook')
					(if (== global105 0)
						(Print 512 4) ; "Just enter the river."
					else
						(Print 512 5) ; "You're already in the water."
					)
				)
				((or (Said 'drink') (Said 'get/drink'))
					(cond
						((!= global105 0)
							(Print 512 6) ; "Ahhhh! It tastes good!"
						)
						(
							(or
								(& (= local0 (NearControl gEgo 10)) $0008)
								(& local0 $0800)
								(& local0 $0002)
								(& local0 $0200)
							)
							(= global120 (Print 512 7 #at -1 20 #dispose)) ; "You kneel down and take a drink of the cool river water. Ahhhh! It tastes good!"
							(riverActions changeState: 1)
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				)
				((Said 'get/water')
					(Print 512 8) ; "You have no reason to carry water."
				)
			)
		)
	)
)

(instance riverActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(= local1 (gEgo viewer:))
				(gEgo viewer: 0 view: 21 cel: 0 setCycle: End self)
			)
			(2
				((ScriptID 0 4) setReal: self 6) ; timer1
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 2 setCycle: Walk viewer: local1)
				(cls)
				(HandsOn)
			)
		)
	)
)

