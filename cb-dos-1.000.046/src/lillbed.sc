;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 265)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Actor)

(public
	lillbed 0
)

(local
	local0
	local1
)

(procedure (localproc_0) ; UNUSED
	(Print &rest #at 40 10 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance lillbed of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(Lillian setPri: 11 init:)
		(= global213 6)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(= global213 6)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(cond
			((Said 'talk[/lil]')
				(switch local1
					(0
						(Say 1 265 0) ; "Well, there you are again, Laura!"
						(Say 1 265 1) ; "You're not following me, are you?"
					)
					(1
						(Say 1 265 2) ; "I'd like to rest, Laura. Could you please leave for awhile?"
					)
					(2
						(Say 1 265 3) ; "Please, Laura? I just want to be left alone right now."
					)
					(else
						(Print 265 4) ; "You can sense that Lillian is not in the mood to talk right now. It would probably be better to leave."
					)
				)
				(++ local1)
			)
			((Said 'listen/lil')
				(Print 265 5) ; "She's not talking."
			)
			((Said 'ask,tell,give,show')
				(Say 1 265 6) ; "I'm tired, Laura. I don't want to do anything right now."
			)
			((Said 'get/lil')
				(Print 265 7) ; "You can't get her!"
			)
			((Said 'kill/lil')
				(Print 265 8) ; "There's no need for THAT sort of thing!"
			)
			((Said 'kiss/lil')
				(Print 265 9) ; "You don't feel like kissing her."
			)
			((Said 'embrace/lil')
				(Print 265 10) ; "You don't feel like hugging her."
			)
		)
	)
)

(instance Lillian of Act
	(properties
		y 134
		x 285
		view 514
		loop 1
		illegalBits 0
	)

	(method (handleEvent event)
		(= global213 6)
		(if (or (MousedOn self event 3) (Said 'look/lil'))
			(if (& global207 $0020)
				(Print 265 11) ; "You see Lillian sitting up in bed."
			else
				(|= global207 $0020)
				(Print 265 12) ; "Your friend Lillian Prune, is a rebellious flapper. Like you, she is twenty years old, but unlike you, she has been known to hang out in speakeasies, smoke, and run around with several young men. She is assertive and out-going, to the point of obnoxiousness, but underneath it all you believe her to be a lonely, insecure girl."
			)
			(event claimed: 1)
		)
	)
)

(instance lHead of Prop ; UNUSED
	(properties
		y 133
		x 265
		view 512
		loop 4
	)
)

