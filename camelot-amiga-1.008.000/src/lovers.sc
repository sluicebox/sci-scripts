;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 141)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	lovers 0
)

(local
	local0
)

(procedure (localproc_0)
	(Print &rest #at -1 local0)
)

(instance lovers of Prop
	(properties
		view 139
	)

	(method (dispose)
		(ClearFlag 82)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(SetFlag 101)
		(SetFlag 82)
		(self posn: 0 1000 ignoreActors: 1 setScript: comeAndGo)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(gModelessDialog
				(clr)
				(event claimed: 1)
				(script cue:)
			)
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
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said '/lancelot,man,knight')
							(Said '//lancelot,man,knight')
						)
						(localproc_0 141 0) ; "Aye, you see Launcelot making love to Gwenhyver, but it is only a mirage, a torment from your own mind."
					)
					(
						(or
							(Said '/guenevere,woman,girl,guenevere')
							(Said '//guenevere,woman,girl,guenevere')
						)
						(localproc_0 141 1) ; "You see the image of Gwenhyver making love to Launcelot, but it is only a mirage created from your inner fears in your fevered state."
					)
					(
						(or
							(Said '/lover,couple,people')
							(Said '//lover,couple,people')
							(MouseClaimed self event)
						)
						(localproc_0 141 2) ; "The mirage takes the shapes of Gwenhyver and Launcelot in a lovers' embrace. This is a delusion, Arthur, caused by the torment of your own mind."
					)
					((or (Said '/delusion') (Said '//delusion'))
						(localproc_0 141 3) ; "It is indeed an illusion, created by your own eyes, shaped by your fevered and tormented mind."
					)
					(
						(or
							(Said '/camelot,island,britain,home')
							(Said '//camelot,island,britain,home')
						)
						(localproc_0 141 4) ; "Your land and your people will die unless you fulfill your quest. Do not give up."
					)
				)
			)
		)
	)
)

(instance comeAndGo of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(MenuBar state: 0)
				(HandsOff)
				(gRmMusic number: 70 priority: 3 loop: -1 play:)
				(if (< (gEgo y:) 95)
					(= temp1 151)
					(= local0 20)
				else
					(= temp1 75)
					(= local0 100)
				)
				(if (< (gEgo x:) 160)
					(= temp0 (Random 160 290))
				else
					(= temp0 (Random 30 160))
				)
				(lovers posn: temp0 temp1 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(HandsOn)
				(User canControl: 0)
				(localproc_0 141 5 88) ; "Images shimmer and appear in the veils of rising heat. It is Gwenhyver and Launcelot embracing."
				(lovers setLoop: 1 cel: 0 setCycle: Fwd)
			)
			(2
				(localproc_0 141 6 88) ; "This image is but a vision of your own fears and jealousies, driven to the surface by your fevered, desperate brain."
			)
			(3
				(lovers setLoop: 0 cel: 8 setCycle: Beg self)
			)
			(4
				(gRmMusic stop:)
				(User canControl: 1)
				(ClearFlag 101)
				(SetFlag 110)
				(lovers dispose: delete:)
				(MenuBar state: 1)
				(DisposeScript 141)
			)
		)
	)
)

