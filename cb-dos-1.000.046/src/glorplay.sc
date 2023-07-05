;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 233)
(include sci.sh)
(use Main)
(use servent)
(use atsgl)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	glorplay 0
)

(synonyms
	(actress person woman)
)

(local
	local0
	[local1 5] = [220 221 225 226 0]
)

(instance Jeeves of servent
	(properties)
)

(instance glorplay of Rgn
	(properties)

	(method (init)
		(super init:)
		(LoadMany rsSOUND 99 220 221 225 226)
		(LoadMany rsMESSAGE 243)
		(if (== gAct 2)
			(if (not (& gMustDos $0008))
				(LoadMany rsFONT 41)
				(LoadMany rsSOUND 29 94 95 96)
				(Load rsVIEW 642)
				(Load rsSCRIPT 406)
			)
			(Load rsVIEW 902)
			(LoadMany rsMESSAGE 258)
			(= [global377 2] 258)
			(= global199 2)
		)
		(= global208 4)
		(if (not (& global145 $0002))
			(Load rsSCRIPT 985)
		)
		(Gloria view: 370 loop: 0 illegalBits: 0 posn: 293 94 stopUpd:)
		(Arm setPri: 6 init:)
		(Ash setPri: 6 init:)
		(Head setPri: 6 init:)
		(Smoke setPri: 6 init:)
		(self setScript: Smoking)
		(Gloria init:)
		(Leg init: setScript: crossLeg)
		(record init: setScript: playRecord)
		(if (and (== gAct 0) (not (& global194 $0004)))
			(|= global194 $0004)
			(Jeeves
				view: 444
				posn: 320 98
				setCycle: Walk
				guest1: Gloria
				exitX: 320
				exitY: 98
				itemX: 295
				itemY: 100
				setAvoider: ((Avoid new:) offScreenOK: 1)
				init:
			)
			(= global167 1)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(if (< global159 3)
			(++ global159)
		else
			(= global159 0)
		)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(DisposeScript 990)
		(if (== (event type:) evSAID)
			(cond
				(
					(or
						(Said
							'play,attach,change/music,record[/(gramophone,(player<record))<on]'
						)
						(Said
							'(rotate<on,off),(wind<up)/gramophone,(player<record)'
						)
					)
					(if global224
						(Print 233 0) ; "You don't have a record that will work."
					else
						(Print 233 1) ; "Since you're an unfamiliar guest here, you should leave the Victrola and records alone."
					)
				)
				((Said '/boa>')
					(cond
						((Said 'look')
							(Print 233 2) ; "That's a beautiful feather boa Gloria is wearing."
						)
						((Said 'get')
							(Print 233 3) ; "It's not yours to take!"
						)
					)
				)
				((Said '/cigarette>')
					(cond
						((Said 'look')
							(Print 233 4) ; "It appears that Gloria has acquired a bad habit."
						)
						((Said 'smoke')
							(Print 233 5) ; "You don't smoke!"
						)
						((Said 'get')
							(Print 233 6) ; "You don't want it!"
						)
					)
				)
				((and (<= gAct 1) (Said 'give,show/*'))
					(if (and global219 global224)
						(Print 233 7) ; "It appears that Gloria is more in the mood to listen to music than to talk to you."
					else
						(DontHave) ; "You don't have it."
					)
				)
			)
		)
	)
)

(instance Smoking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gAct 2)
					(cond
						((not global216)
							(= state -1)
						)
						((not (& gMustDos $0008))
							(|= gMustDos $0008)
							(self setScript: (ScriptID 406 0)) ; Clock
							(= state -1)
						)
						((self script:)
							(= state -1)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(Arm cycleSpeed: 1 loop: 1 cel: 0 setCycle: End)
				(= seconds 3)
			)
			(2
				(Arm setCycle: Beg self)
			)
			(3
				(Smoke setCycle: End)
				(if (< (Random 1 100) 30)
					(= state 6)
				)
				(= seconds (Random 6 12))
			)
			(4
				(Arm loop: 2 setCycle: End self)
			)
			(5
				(Arm loop: 3 setCycle: Fwd)
				(if (!= (Gloria script:) goSee)
					(Ash show: setCycle: End self)
				)
			)
			(6
				(Ash hide:)
				(Arm loop: 2 cel: 2 setCycle: Beg)
				(= seconds (Random 6 12))
				(= state 0)
			)
			(7
				(Head setCycle: End)
				(= seconds (Random 6 12))
			)
			(8
				(Head setCycle: Beg)
				(= seconds (Random 6 12))
				(= state 0)
			)
		)
	)
)

(instance goSee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(HandsOff)
				(if (gEgo inRect: 43 113 100 125)
					(gEgo
						setMotion:
							MoveTo
							(+ (gEgo x:) 20)
							(+ (gEgo y:) 20)
					)
				)
				(Gloria
					view: 360
					setCycle: Walk
					setAvoider: (Avoid new:)
					setMotion: MoveTo 72 118 self
				)
				(Leg hide:)
				(Arm hide:)
				(Head hide:)
				(Ash hide:)
				(Smoke hide:)
			)
			(1
				(global373 setCycle: End self)
				(global374 setCycle: End)
			)
			(2
				(Gloria illegalBits: 0 setMotion: MoveTo 35 118 self)
			)
			(3
				(global373 setCycle: Beg)
				(global374 setCycle: Beg self)
			)
			(4
				(= seconds 5)
			)
			(5
				(global373 setCycle: End self)
				(global374 setCycle: End)
			)
			(6
				(if (gEgo inRect: 271 84 320 98)
					(gEgo setMotion: MoveTo 268 104)
				)
				(Gloria setMotion: MoveTo 72 118 self)
			)
			(7
				(cls)
				(global373 setCycle: Beg self)
				(global374 setCycle: Beg)
			)
			(8
				(= global213 3)
				(Say 1 233 8) ; "You're very mean! There's NOTHING there!"
				(global373 stopUpd:)
				(global374 stopUpd:)
				(Gloria setMotion: MoveTo 293 94 self)
			)
			(9
				(Gloria view: 370 loop: 0 setAvoider: 0)
				(DisposeScript 985)
				(Arm show:)
				(Head show:)
				(Leg show:)
				(Ash show:)
				(Smoke show:)
				(HandsOn)
				(client setScript: Smoking)
			)
		)
	)
)

(instance crossLeg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Leg setCycle: End)
				(= seconds (Random 6 12))
			)
			(1
				(Leg setCycle: Beg)
				(= seconds (Random 12 18))
				(= state -1)
			)
		)
	)
)

(instance Gloria of Act
	(properties
		y 134
		x 187
		view 369
	)

	(method (handleEvent event &tmp temp0)
		(= global213 3)
		(cond
			(
				(and
					(IsFlag 51)
					(Said 'tell[/actress]/(death<gertie),gertie<about')
				)
				(if (& gCorpseFlags $0001) ; Gertie
					(if (& global145 $0002)
						(= temp0
							(switch gAct
								(2 50)
								(else 43)
							)
						)
						(= global212 2)
						(= global209 event)
						(proc243_1 temp0 233 9)
					else
						(DisposeScript 990)
						(|= global145 $0002)
						(Say 1 233 10) ; "Mother??? Oh, no! It can't be!"
						(Gloria setScript: goSee)
					)
				else
					(Say 1 233 11) ; "Dahling, please leave my mother alone."
				)
			)
			((and (<= gAct 1) (Said 'ask,tell//*<about'))
				(Print 233 7) ; "It appears that Gloria is more in the mood to listen to music than to talk to you."
			)
			((and (<= gAct 1) (Said 'give,show'))
				(if (and global219 global224)
					(Print 233 7) ; "It appears that Gloria is more in the mood to listen to music than to talk to you."
				else
					(DontHave) ; "You don't have it."
				)
				(event claimed: 1)
			)
			(
				(and
					(not (& global207 $0004))
					(or (MousedOn self event 3) (Said 'look/actress[/!*]'))
				)
				(event claimed: 1)
				(|= global207 $0004)
				(Say 0 233 12) ; "Gloria Swansong, a beautiful platinum-blonde, is the Colonel's other niece and Gertie's daughter. She seems so glamorous with her long feather boa, stunning jewels, and lovely gown. You've been told that she's a successful actress in Hollywood, although you've never heard of her."
			)
			(
				(and
					(& global207 $0004)
					(or (MousedOn self event 3) (Said 'look/actress[/!*]'))
				)
				(event claimed: 1)
				(if (== gAct 2)
					(Print 233 13) ; "Gloria is alone here in the billiard room, listening to her favorite songs."
				else
					(Print 233 14) ; "Gloria has a dreamy look on her face as she listens to the music playing on the Victrola."
				)
			)
			((Said '/actress>')
				(cond
					((Said 'listen')
						(Print 233 15) ; "Gloria isn't talking."
					)
					((Said 'talk')
						(if (== gAct 2)
							(switch global172
								(0
									(Say 1 233 16) ; "Really, dahling! You're interrupting my music!"
								)
								(1
									(Say 1 233 17) ; "What is it?!"
								)
								(2
									(Say 1 233 18) ; "Honestly! Why do you insist on pestering everybody?!"
								)
								(else
									(Print 233 19) ; "Gloria ignores you as she hums along with the record."
								)
							)
							(++ global172)
						else
							(Print 233 7) ; "It appears that Gloria is more in the mood to listen to music than to talk to you."
						)
					)
					((Said 'get')
						(Print 233 20) ; "You can't get her!"
					)
					((Said 'kill')
						(Print 233 21) ; "There's no need for THAT sort of thing!"
					)
					((Said 'kiss')
						(Print 233 22) ; "You don't feel like kissing her."
					)
					((Said 'embrace')
						(Print 233 23) ; "You don't feel like hugging her."
					)
				)
			)
		)
	)
)

(instance Arm of Prop
	(properties
		y 56
		x 289
		view 370
		loop 1
	)
)

(instance Smoke of Prop
	(properties
		y 54
		x 292
		view 370
		loop 6
	)
)

(instance Ash of Prop
	(properties
		y 89
		x 274
		view 370
		loop 7
	)
)

(instance Head of Prop
	(properties
		y 56
		x 294
		view 370
		loop 4
	)
)

(instance Leg of Prop
	(properties
		y 94
		x 293
		view 370
		loop 8
	)
)

(instance recordMusic of Sound
	(properties)
)

(instance record of Prop
	(properties
		y 67
		x 98
		view 136
		loop 5
		priority 6
		signal 16
	)
)

(instance playRecord of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(record setCycle: Fwd)
				(recordMusic number: [local1 global159] loop: 1 play: self)
			)
			(1
				(recordMusic number: 99 loop: -1 play:)
				(if (< global159 3)
					(++ global159)
				else
					(= global159 0)
				)
				(if (== global199 2)
					(= state -1)
				)
				(= cycles 50)
			)
			(2
				(record setCycle: 0)
				(recordMusic stop:)
				(client setScript: 0)
			)
		)
	)
)

