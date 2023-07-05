;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 116)
(include sci.sh)
(use Main)
(use Interface)
(use TurnLooper)
(use Motion)
(use Game)

(public
	muleReg 0
)

(instance muleLooper of TurnLooper
	(properties
		viewChange 404
	)
)

(instance muleReg of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 404)
		(Load rsVIEW 403)
		(if (<= 36 gCurRoomNum 49)
			(Load rsVIEW 423)
		)
		(super init:)
		(gMuleObj
			view: 403
			setLoop: -1
			looper: muleLooper
			setCycle: Walk
			setStep: 3 2
			setPri: -1
			init:
		)
	)

	(method (handleEvent event)
		(cond
			((not (IsFlag 20)) 0)
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
					(Said '*/pack,clothes,pack,blanket')
					(Said '*//pack,clothes,pack,blanket')
				)
				(Print 116 0) ; "The pack washed overboard in the storm, remember?"
			)
			(
				(or
					(Said 'ask[/merlin]/ass')
					(Said 'look/ass')
					(MouseClaimed gMuleObj event)
				)
				(Print 116 1) ; "Though the mule is here, she looks even more unhappy than when you started this trip."
			)
			((Said '/ass>')
				(cond
					((Said 'talk,ask')
						(Print 116 2) ; "You may talk to your mule all you like, Arthur, as long as you do not expect her to talk back."
					)
					((Said 'get,get,guide,pull,find,stay')
						(Print 116 3) ; "No need. She will follow you as usual."
					)
					((Said 'ride')
						(Print 116 4) ; "A mule is not for riding. Your own two feet will serve to carry you."
					)
					((Said 'kill,eat,hit')
						(Print 116 5) ; "Arthur! The mule is an innocent animal and should be valued. Do try to show some sense."
					)
					((Said 'tie')
						(Print 116 6) ; "Your mule does not need to be tied."
					)
				)
			)
		)
	)
)

