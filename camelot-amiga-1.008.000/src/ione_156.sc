;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 156)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	ione 0
	proc156_1 1
)

(local
	local0
	local1 = 1
	local2
)

(procedure (localproc_0)
	(proc156_1)
	(Talk &rest)
)

(procedure (proc156_1)
	(gTObj tWindow: ioneWindow actor: 0)
)

(instance ioneWindow of SysWindow
	(properties
		color 11
		back 1
		title {Ione}
		brTop 10
		brLeft 70
		brBottom 95
		brRight 200
	)
)

(instance cage of Prop
	(properties
		y 150
		x 115
		view 256
		loop 4
	)
)

(instance doves2 of Act
	(properties
		view 156
		loop 4
		priority 12
		signal 16400
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(= view (doves view:))
		(= loop (doves loop:))
		(= cel (+ (doves cel:) 3))
		(if (> cel 4)
			(-= cel 5)
		)
		(if local2
			(self posn: (- (doves x:) 7) (+ (doves y:) 2))
		else
			(self posn: (- (doves x:) 9) (+ (doves y:) 2))
		)
	)
)

(instance doves of Act
	(properties
		y 82
		x 74
		view 156
		loop 4
		priority 12
		signal 16400
		illegalBits 0
	)

	(method (init)
		(super init:)
		(doves2 init:)
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
					(MouseClaimed doves event)
					(Said 'look/dove,bird')
					(Said 'ask/merlin/dove,bird')
				)
				(if (IsFlag 156)
					(Print 156 0) ; "The doves are safely in their cage."
				else
					(Print 156 1) ; "There are some doves up on the awning above you."
				)
			)
			((and (not (IsFlag 156)) (Said 'look/awning,balcony'))
				(Print 156 2) ; "There are some doves up on the awning and balcony above you."
			)
			((Said 'get,capture/dove,bird')
				(if (not (IsFlag 156))
					(Print 156 3) ; "Aye, but how?"
				else
					(Print 156 4) ; "They are in the cage. You have caught them all."
				)
			)
			((Said 'call/dove,bird')
				(if (not (IsFlag 156))
					(Print 156 5) ; "You would be taken for a lunatic if you stood here making bird calls."
				else
					(Print 156 4) ; "They are in the cage. You have caught them all."
				)
			)
		)
	)
)

(instance grainOnGround of View
	(properties
		y 151
		x 90
		view 67
		loop 1
	)
)

(instance ione of Act
	(properties
		y 146
		x 105
		view 349
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(if local1
			(ione setLoop: 0 setCycle: Fwd)
			(cage init: stopUpd:)
			(doves init: cycleSpeed: 3 setCycle: Fwd)
			(Load rsVIEW 67)
		)
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
					(Said 'look/ione,girl,woman')
					(Said 'ask/merlin/ione,girl,woman')
					(MouseClaimed self event)
				)
				(if local1
					(Print 156 6) ; "How bitterly this poor girl weeps! She is much distressed."
				else
					(Print 156 7) ; "She waits for you to follow her advice."
				)
			)
			((or (MouseClaimed cage event) (Said 'look/birdcage'))
				(if (IsFlag 156)
					(Print 156 8) ; "Six doves sit in the cage."
				else
					(Print 156 9) ; "The cage is empty."
				)
			)
			((Said 'talk[/ione,girl,woman]')
				(cond
					((not local1)
						(localproc_0 156 10) ; "Your tasks are done. Go now to the Seeress, for she awaits you."
					)
					((not local0)
						(= local0 1)
						(gEgo setScript: ioneConversation)
					)
					(else
						(Print 156 11) ; "The poor girl is crying too much to speak again."
					)
				)
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(if local1
					(Print 156 12) ; "Money will not solve this poor girl's problem."
				else
					(localproc_0 156 13) ; "As an initiate of the Goddess, I may not accept money from a man."
				)
				(proc0_18)
			)
			((Said 'give,bargain/grain[/ione,girl,woman]')
				(if (gEgo has: 8) ; boar_spear | grain | medallion
					(localproc_0 156 14) ; "But, sir, of what use is grain to me?"
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			(
				(or
					(Said 'feed/bird,dove')
					(Said 'feed/*/bird,dove')
					(Said 'give/grain/bird,dove')
				)
				(if local1
					(Print 156 15) ; "How do you intend to feed them?"
				else
					(Print 156 16) ; "Ione will take care of them now."
				)
			)
			(
				(or
					(Said 'scatter,throw/grain[/bird,dove,dirt]')
					(Said 'throw,throw,drop,pour,drop/grain/dirt,birdcage')
					(Said 'exit/path[<grain]')
				)
				(if (not (gEgo has: 8)) ; boar_spear | grain | medallion
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				else
					(gEgo setScript: getDoves)
				)
			)
			((Said 'drop,drop/grain')
				(if (not (gEgo has: 8)) ; boar_spear | grain | medallion
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				else
					(Print 156 17) ; "But what would that accomplish? Perhaps if you explained more clearly."
				)
			)
			((Said 'use/grain')
				(if (not (gEgo has: 8)) ; boar_spear | grain | medallion
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				else
					(Print 156 3) ; "Aye, but how?"
				)
			)
			((Said 'sell/grain[/ione,girl,woman]')
				(if (not (gEgo has: 8)) ; boar_spear | grain | medallion
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				else
					(localproc_0 156 18) ; "But I have no money."
				)
			)
			((Said 'help/ione,girl,woman')
				(if local1
					(Print 156 19) ; "And how do you propose to do that, Arthur?"
				else
					(Print 156 20) ; "She does not need any help."
				)
			)
			((Said 'ask[/ione,girl,woman]/*>')
				(cond
					(local1
						(event claimed: 1)
						(if (not local0)
							(Print 156 21) ; "Perhaps once her problem is solved, the poor girl will feel more like having a casual conversation."
						else
							(Print 156 22) ; "She is too distraught to speak."
						)
					)
					((Said '//grail')
						(localproc_0 156 23) ; "Only the Seeress can answer this question."
					)
					((Said '//galahad')
						(localproc_0 156 24) ; "Seek your answers from the Seeress."
					)
					((Said '//mistress')
						(localproc_0 156 24) ; "Seek your answers from the Seeress."
					)
					(else
						(event claimed: 1)
						(localproc_0 156 24) ; "Seek your answers from the Seeress."
					)
				)
			)
			((Said '*/ione,girl,woman')
				(Print 156 25) ; "That would not help."
			)
		)
	)
)

(instance getDoves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: illegalBits: 0)
				(cond
					((gEgo inRect: 100 100 121 152)
						(-- state)
						(gEgo setMotion: MoveTo 85 140 self)
					)
					((gEgo inRect: 120 100 320 152)
						(-- state)
						(gEgo setMotion: MoveTo 120 140 self)
					)
					((gEgo inRect: 100 152 320 200)
						(-- state)
						(gEgo setMotion: MoveTo 90 153 self)
					)
					(else
						(gEgo setMotion: MoveTo 85 148 self)
					)
				)
			)
			(1
				(gEgo
					view: 67
					setLoop: 0
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(grainOnGround init:)
				(gEgo setCel: 0 setCycle: End self)
			)
			(3
				(grainOnGround setCel: 1)
				(gEgo setCel: 0 setCycle: End self)
			)
			(4
				(gEgo
					view: 0
					setLoop: -1
					loop: 2
					cycleSpeed: 0
					setCycle: Walk
				)
				(grainOnGround setCel: 2)
				(= seconds 1)
			)
			(5
				(gEgo setMotion: MoveTo 55 145 self)
			)
			(6
				(gEgo loop: 0 ignoreActors: 0 illegalBits: $8000)
				(doves
					view: 256
					setLoop: 6
					cycleSpeed: 0
					setMotion: MoveTo 81 77 self
				)
			)
			(7
				(doves setLoop: 6 setMotion: MoveTo 95 145 self)
			)
			(8
				(doves
					setLoop: 5
					setCel: 0
					setCycle: End
					setMotion: MoveTo 95 150 self
				)
			)
			(9
				(doves setLoop: 7 setPri: -1 setCycle: Fwd cycleSpeed: 2)
				(ione setLoop: 4 cel: 0 setCycle: End)
				(= seconds 3)
			)
			(10
				(grainOnGround setCel: 1)
				(= seconds 3)
			)
			(11
				(grainOnGround dispose:)
				(= seconds 2)
			)
			(12
				(= local2 1)
				(doves
					setLoop: 8
					setCel: 0
					moveSpeed: 3
					setMotion: MoveTo (- (cage x:) 5) (- (cage y:) 1) self
				)
			)
			(13
				(doves2 dispose:)
				(doves setLoop: 1 setPri: 10 setCycle: End self)
				(= seconds 2)
			)
			(14
				(ione setLoop: 3 setCel: 0 posn: 104 149 setCycle: CT 4 1 self)
			)
			(15
				(ione setCycle: CT 7 1 self)
				(cage cycleSpeed: (ione cycleSpeed:) setCycle: End)
			)
			(16
				(ione setCycle: End self)
			)
			(17
				(ione setLoop: 5 cel: 0 setCycle: Fwd)
				(gTObj talkCue: self)
				(localproc_0 156 26 156 27) ; "You thought me only a simple girl, but I am an initiate of the Goddess sent to watch and test you."
			)
			(18
				(SetScore 0 0 5 1 5 2 5)
				(ione setCycle: 0)
				(PutItem 8) ; boar_spear | grain | medallion
				(SetFlag 156)
				(HandsOn)
				(= local1 0)
				(client setScript: 0)
			)
		)
	)
)

(instance ioneConversation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(localproc_0 156 28) ; "I dropped the cage and all my mistress' doves escaped. They will not come back and they are prize doves, hand fed by my mistress from hatchlings!"
				(= seconds 2)
			)
			(1
				(ione setLoop: 1 cycleSpeed: 3 setCycle: End)
			)
			(2
				(gTObj talkCue: self)
				(localproc_0 156 29) ; "She trusted me with them. I dare not go back without them! Oh, misery!"
			)
			(3
				(ione setLoop: 0 setCycle: Fwd)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

