;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 369)
(include sci.sh)
(use Main)
(use Interface)
(use n821)
(use Motion)
(use User)
(use System)

(public
	stacyInScript 0
)

(instance stacyInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 15)
			)
			(1
				(User controls: 0)
				(if (gEgo inRect: 84 142 142 160)
					(gEgo setMotion: MoveTo 80 140)
				)
				((ScriptID 310 3) ; agent
					init:
					ignoreActors: 0
					setCycle: Walk
					setMotion: MoveTo ((ScriptID 310 3) x:) 160 ; agent
				)
				(Print 369 0) ; "Just then Stacy enters the room and says..."
				(Print 369 1) ; "Did you find the weapon and my notes?"
			)
			(2
				(if register
					(Print 369 2) ; "We must work fast," urges the agent, "I just received word the Ambassador is going to be moved."
					(Print 369 3) ; "I have to leave now," she says, "I must contact my superior and arrange for the helicopter."
					(Print 369 4) ; "She advises you to take the caterer's van and begin the rescue."
					(Print 369 5) ; "Just before walking out she says, "Don't forget to conceal the weapon!""
					((ScriptID 310 3) ; agent
						setMotion: MoveTo ((ScriptID 310 3) x:) 200 self ; agent
					)
					(HandsOn)
				else
					(HandsOff)
					(Print 369 6) ; "Oh, well," she says, "it doesn't matter anyway."
					(Print 369 7) ; "They have relocated the Ambassador and we have no idea at this time where he is."
					(= seconds 2)
				)
			)
			(3
				(if register
					(client cue:)
				else
					(EgoDead 918 0 0 369 8) ; "Faster action might have saved the Ambassador. You have caused the mission to fail."
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((< state 1))
			((Said 'yes')
				(= register 1)
				(self cue:)
			)
			((Said 'no')
				(self cue:)
			)
			((Said '/film')
				(Print 369 9) ; "Stacy says to you, "I'm happy to know the microfilm helped you out.""
				(Print 369 1) ; "Did you find the weapon and my notes?"
			)
		)
	)
)

