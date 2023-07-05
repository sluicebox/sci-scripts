;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 274)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	trunk 0
)

(synonyms
	(lil person woman)
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0) ; UNUSED
	(Lillian setCycle: Fwd)
	(Print &rest #at 80 145 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance trunk of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (not (& gMustDos $0002))
			(LoadMany rsFONT 4 41)
			(LoadMany rsMESSAGE 406)
			(Load rsVIEW 642)
			(LoadMany rsSOUND 29 94 95 96)
		)
		(LHead setPri: 11 ignoreActors: 1)
		(suit2 setPri: 11 ignoreActors: 1 init: stopUpd:)
		(Lillian setPri: 11 ignoreActors: 1 init:)
		(= global195 32)
		(self setScript: suitCase)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
	)
)

(instance suitCase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0002))
						(|= gMustDos $0002)
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
				(if (== global179 5)
					(= cycles 1)
					(= state 3)
				else
					(Lillian cycleSpeed: 1 setCycle: Fwd)
					(++ global179)
					(= seconds 2)
				)
			)
			(2
				(Lillian loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(if (not global179)
					(Print 274 0) ; "Oh! H-hi, Laura."
				)
				(= cycles 1)
			)
			(4
				(LHead init: setScript: headActions)
				(= cycles 1)
			)
			(5
				(Lillian loop: 4 cycleSpeed: 1 setCycle: End)
				(= seconds (Random 6 15))
			)
			(6
				(Lillian setCycle: Beg)
				(= seconds (Random 6 15))
				(= state 4)
			)
		)
	)
)

(instance headActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LHead setCycle: End)
				(= seconds (Random 6 15))
			)
			(1
				(LHead setCycle: Beg)
				(= seconds (Random 6 15))
				(= state -1)
			)
		)
	)
)

(instance Lillian of Prop
	(properties
		y 149
		x 270
		view 511
		loop 3
	)

	(method (handleEvent event)
		(= global213 6)
		(cond
			(
				(and
					(not (& global207 $0020))
					(or (MousedOn self event 3) (Said 'look/lil'))
				)
				(|= global207 $0020)
				(= global213 6)
				(event claimed: 1)
				(Say 0 274 1) ; "Your friend Lillian Prune, is a rebellious flapper. Like you, she is twenty years old, but unlike you, she has been known to hang out in speakeasies, smoke, and run around with several young men. She is assertive and outgoing, to the point of obnoxiousness, but underneath it all you believe her to be a lonely, insecure girl."
			)
			(
				(and
					(& global207 $0020)
					(or (MousedOn self event 3) (Said 'look/lil'))
				)
				(event claimed: 1)
				(Print 274 2) ; "Lillian looks clearly agitated as she sits on the bed by her suitcase."
			)
			((Said 'ask//*<about')
				(switch local2
					(0
						(Say 1 274 3) ; "Not now. I have to do something first."
						(++ local2)
					)
					(1
						(Print 274 4) ; "Lillian looks irritated as you continue to pester her. She doesn't answer."
					)
				)
			)
			((Said 'tell//*<about')
				(Print 274 5) ; "Lillian gets a disgusted look on her face as you try to talk to her. She clearly doesn't care right now."
			)
			((Said 'give/*')
				(if (and global219 global224)
					(Print 274 6) ; "It's obvious that Lillian doesn't want it."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'show/*')
				(if (and global219 global224)
					(Print 274 7) ; "She shows no interest in it at all."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said '/lil>')
				(cond
					((Said 'talk')
						(switch local0
							(0
								(Say 1 274 8) ; "I know we're sharing a room, Laura, but I would like to be alone for a little while. I need to do something...privately."
							)
							(1
								(Say 1 274 9) ; "I realize it's getting late, Laura, but I only need the room alone for a little while. I promise I'll hurry!"
							)
							(2
								(Say 1 274 10) ; "Are you listening to me, Laura?! Please go out of the room for a few minutes!"
							)
							(3
								(Say 1 274 11) ; "This isn't fair, Laura! I invite you, as a friend, to my uncle's estate, and this is the thanks I get! You don't listen to me...and you don't even care what I want! You know, you're no different from everybody else!"
							)
							(4
								(Say 1 274 12) ; "I want nothing more to do with you, Laura! JUST LEAVE ME ALONE!!"
							)
							(else
								(Print 274 13) ; "Lillian sits on the bed in angry silence and you can tell that she is furious at you. You wonder what you did to bring on her anger."
							)
						)
						(++ local0)
					)
					((Said 'listen')
						(Print 274 14) ; "Lillian's not talking at the moment."
					)
					((Said 'get')
						(Print 274 15) ; "You can't get her!"
					)
					((Said 'kill')
						(Print 274 16) ; "There's no need for THAT sort of thing!"
					)
					((Said 'kiss')
						(Print 274 17) ; "You don't feel like kissing her."
					)
					((Said 'embrace')
						(Print 274 18) ; "You don't feel like hugging her."
					)
				)
			)
		)
	)
)

(instance suit2 of Prop
	(properties
		y 137
		x 262
		view 511
		loop 2
	)
)

(instance LHead of Prop
	(properties
		y 148
		x 273
		z 32
		view 511
		loop 5
	)
)

