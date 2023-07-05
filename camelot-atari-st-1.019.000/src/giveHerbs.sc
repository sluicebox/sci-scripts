;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 206)
(include sci.sh)
(use Main)
(use Rm58)
(use n151)
(use Motion)
(use System)

(public
	giveHerbs 0
)

(instance giveHerbs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj endTalk:)
				(gEgo
					setMotion:
						MoveTo
						(- (global185 x:) 10)
						(+ (global185 y:) 15)
						self
				)
			)
			(1
				(PutItem 9) ; herbs | bone
				(++ global146)
				(Face gEgo global185)
				(proc151_0 2 self self)
			)
			(2
				(if (IsFlag 152)
					(gTObj talkCue: self)
					(proc58_1 206 0) ; "Eh, what is this? Why are you--ah, what a wonderful smell these herbs have! How very potent and aromatic! I shall hang them up at once."
				else
					(gTObj talkCue: self)
					(proc58_1 206 1 206 2) ; "What, are you a merchant, too? What do I want with herbs? Ah, but they do smell good. In fact, they are so strongly aromatic, they might help disguise the smell of my fish."
					(+= global120 2)
				)
			)
			(3
				(global185 setLoop: 1 cycleSpeed: 2 setCycle: CT 7 1 self)
			)
			(4
				(global186 posn: 231 94)
				(global185 setLoop: 1 cycleSpeed: 2 setCycle: End self)
			)
			(5
				(global185 setLoop: 2 cycleSpeed: 0)
				(RedrawCast)
				(if (IsFlag 152)
					(gTObj talkCue: self)
					(proc58_1 206 3 206 4) ; "You have taught me something, habibi. Rather than dwelling only upon my problems, had I but sought a solution, I would have been a happier man."
				else
					(= cycles 1)
				)
			)
			(6
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 206)
			)
		)
	)
)

