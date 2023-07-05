;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use Interface)
(use n824)
(use LoadMany)
(use Wander)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	pierRm 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 11]
)

(procedure (localproc_0 param1)
	(return (== (param1 onControl: 1) 16384))
)

(instance pierRm of Rm
	(properties
		picture 23
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 123 23 423 23 523)
		(gEgo
			view: 123
			loop: 0
			ignoreControl: 16384
			ignoreControl: 16
			observeControl: -32768
			posn: 20 145
			init:
			setScript: egoControlScript
		)
		(officer init: setLoop:)
		(flag init:)
		(wave init:)
		(wave2 init:)
		(harborSound play:)
		((Clone bird) init:)
		(bird init:)
		(gAddToPics add: hatch eachElementDo: #init doit:)
		(proc824_0)
		(self setScript: waveScript)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look>')
				(cond
					((Said '[<around,at][/room,sub,sub,boat,blackhawk]')
						(Print 23 0) ; "You look and see the USS Blackhawk tied to the pier."
					)
					((Said '<up')
						(proc0_36) ; "You see nothing special."
					)
					((Said '<down')
						(Print 23 1) ; "You see nothing unusual about the pier."
					)
					((Said '<man,officer')
						(Print 23 2) ; "Officer of the Deck."
					)
					((Said '/entrance,bridge,walkway,deck,pier')
						(Print 23 3) ; "You look at the gangplank spanning from the dock to the submarine."
					)
					((Said '/crane')
						(Print 23 4) ; "The crane is of no interest."
					)
				)
			)
			(
				(or
					(Said 'come<aboard<ask<permission<to')
					(Said 'ask/permission/board')
				)
				(if (& (gEgo onControl:) $4000)
					(proc0_34) ; "You're not close enough."
				else
					(= local3 2)
					(gCurRoom setScript: comeAboardScript)
				)
			)
			((Said 'talk[/man]')
				(if (& (gEgo onControl:) $4000)
					(proc0_34) ; "You're not close enough."
				else
					(++ local3)
					(gCurRoom setScript: comeAboardScript)
				)
			)
			((Said 'board/boat,sub')
				(Print 23 5) ; "Just walk up the plank."
			)
		)
	)

	(method (dispose)
		(gEgo cycleSpeed: 0)
		(super dispose:)
	)
)

(instance harborSound of Sound
	(properties
		number 68
		loop -1
	)
)

(instance egoControlScript of Script
	(properties)

	(method (doit)
		(if (or (== (gEgo onControl: 1) 16) (Said 'walk/plank'))
			(gEgo setMotion: 0 setScript: walkUpPlankScript)
		)
	)
)

(instance officer of Act
	(properties
		y 115
		x 156
		view 523
		priority 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/officer,man]>')
				(cond
					((Said 'look[<at]')
						(Print 23 2) ; "Officer of the Deck."
					)
					((Said 'salute')
						(cond
							(local1
								(Print 23 6) ; "You don't need to salute a second time."
							)
							(
								(or
									(> (gEgo distanceTo: self) 15)
									(< (gEgo distanceTo: self) 5)
								)
								(Print 23 7) ; "Not proper to salute from here."
							)
							(else
								(if (== (++ local4) 2)
									(++ local4)
								)
								(Print 23 8 #at -1 120 #dispose) ; "You salute the officer of the Deck."
								(User canInput: 0)
								(gEgo setScript: saluteOfficerScript)
							)
						)
					)
				)
			)
			((localproc_0 gEgo))
			((Said 'come<aboard<ask<permission<to')
				(if (& (gEgo onControl:) $4000)
					(proc0_34) ; "You're not close enough."
				else
					(= local3 2)
					(gCurRoom setScript: comeAboardScript)
				)
			)
			((Said 'talk[/man]')
				(if (& (gEgo onControl:) $4000)
					(proc0_34) ; "You're not close enough."
				else
					(++ local3)
					(gCurRoom setScript: comeAboardScript)
				)
			)
		)
	)
)

(instance walkUpPlankScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 43 140 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 161 116 self)
			)
			(2
				(User canInput: 1 canControl: 0)
			)
		)
	)
)

(instance comeAboardScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(gEgo heading: 0 setLoop: -1)
				((gEgo looper:) doit: gEgo 0 self)
			)
			(1
				(if (> local3 1)
					(= cycles 3)
				else
					(Print 23 9) ; ""Good morning." says the Officer of the Deck."
					(User canInput: 1)
				)
			)
			(2
				(Print 23 10 #at 25 10) ; "You ask the Officer of the Deck, "Request permission to come aboard, sir.""
				(Print 23 11 #at 25 10) ; "The Officer of the Deck says, "Your orders please, sir.""
				(Print 23 12 #at 25 10) ; "You hand the Officer of the Deck the manila envelope containing your orders."
				(Print 23 13 #at 25 10) ; "After confirming your orders, the Officer of the Deck hands them back to you and says..."
				(= cycles 1)
			)
			(3
				(Print 23 14 #at 25 10) ; "Permission granted Commander Westland!"
				(Print 23 15 #at 25 10) ; "Welcome aboard the USS Blackhawk."
				(= seconds 1)
			)
			(4
				(Print 23 16 #at 25 10) ; "Continuing he says, "The Captain is expecting you, sir.""
				(= cycles 5)
			)
			(5
				(gEgo setScript: downTheHatchScript self)
			)
			(6
				(HandsOn)
				(if (== local4 3)
					(Print 23 17) ; "You got 3 extra points for following proper military procedures!!"
					(gGame changeScore: 3)
				)
				(gCurRoom newRoom: 31) ; egosQuartersRm
			)
		)
	)
)

(instance saluteFlagScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 heading: 90)
				((gEgo looper:) doit: gEgo (gEgo heading:) self)
			)
			(1
				(gEgo
					view: 23
					setLoop: 1
					setCel: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(2
				(Print 23 18 #at -1 120 #dispose) ; "Proudly, you whip a snappy salute towards "Old Glory.""
				(= seconds 3)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(proc0_3)
				(gEgo view: 123 cycleSpeed: 0 setLoop: 0 setCel: 16)
				(= local0 1)
				(= cycles 2)
			)
			(5
				(User canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance saluteOfficerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo heading: 0 cel: 2 setLoop: -1)
				((gEgo looper:) doit: gEgo (gEgo heading:) self)
			)
			(1
				(gEgo
					view: 23
					setLoop: 2
					setCel: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(proc0_3)
				(gEgo setCycle: Beg self)
				(= local1 1)
			)
			(4
				(gEgo
					view: 123
					setLoop: 3
					cycleSpeed: 0
					cel: 2
					setCycle: Walk
				)
				(User canInput: 1)
			)
		)
	)
)

(instance downTheHatchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 123
					setCycle: Walk
					setLoop: -1
					illegalBits: 0
					setMotion: MoveTo 206 121 self
				)
			)
			(1
				(gEgo setAvoider: 0 setLoop: -1 heading: 270)
				(harborSound fade:)
				((gEgo looper:) doit: gEgo (gEgo heading:) self)
			)
			(2
				(gEgo
					view: 23
					loop: 4
					setPri: 10
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(gEgo hide:)
				(= cycles 5)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance wave of Prop
	(properties
		y 189
		x 61
		view 423
		priority 14
		cycleSpeed 2
	)

	(method (init)
		(super init:)
	)

	(method (addToPic)
		(wave2 addToPic:)
		(waveScript register: 1)
		(super addToPic:)
	)

	(method (handleEvent)
		(if (Said 'look[<at]/wave')
			(Print 23 19) ; "You see waves."
		)
	)
)

(instance wave2 of Prop
	(properties
		y 189
		x 181
		view 423
		loop 1
		priority 14
		cycleSpeed 2
	)

	(method (handleEvent)
		(if (Said 'look[<at]/wave')
			(Print 23 19) ; "You see waves."
		)
	)
)

(instance waveScript of Script
	(properties)

	(method (init)
		(if register
			(self dispose:)
		else
			(super init: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wave cel: 0 setCycle: End self)
				(wave2 cel: 0 setCycle: End self)
			)
			(1)
			(2
				(wave stopUpd:)
				(wave2 stopUpd:)
				(= cycles (Random 10 30))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance flag of Prop
	(properties
		y 42
		x 267
		view 23
		cel 2
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1)
	)

	(method (addToPic)
		(self cel: 8)
		(super addToPic:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]/man,officer')
				(Print 23 20) ; "You see an officer."
			)
			((Said '[/flag,ensign]>')
				(cond
					((Said 'look[<at]')
						(Print 23 21) ; "You see Old Glory waving in the breeze."
					)
					((Said 'salute')
						(cond
							(local0
								(Print 23 6) ; "You don't need to salute a second time."
							)
							(
								(or
									(> (gEgo distanceTo: self) 130)
									(< (gEgo distanceTo: self) 115)
								)
								(Print 23 22) ; "Not proper to salute the flag from here."
							)
							(else
								(++ local4)
								(User canInput: 0)
								(gEgo setScript: saluteFlagScript)
							)
						)
					)
				)
			)
		)
	)
)

(instance hatch of RPicView
	(properties
		y 127
		x 238
		view 23
		loop 3
		priority 9
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/hatch]>')
				(cond
					((Said 'look[<at]')
						(Print 23 23) ; "Looking down into the open hatch, you see a ladder giving access to the submarine."
					)
					((Said 'open,close')
						(Print 23 24) ; "You must follow proper boarding procedure."
					)
					((or (Said 'climb<down') (Said 'down[<the]'))
						(gEgo setScript: downTheHatchScript)
					)
				)
			)
		)
	)
)

(instance bird of Act
	(properties
		y 20
		x 100
		view 23
	)

	(method (init)
		(super init:)
		(self
			setMotion: Wander 100
			setCycle: Fwd
			x: (Random 50 270)
			setLoop: 5
			setPri: 0
		)
	)

	(method (canBeHere)
		(return (and (< -20 y 50) (< -50 x 370)))
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look/bird')
				(Print 23 25) ; "You see the seagulls lazily riding the breeze."
			)
		)
	)
)

