;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 115)
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
	(properties)
)

(instance muleReg of Rgn
	(properties)

	(method (init)
		(if (<= 8 gCurRoomNum 17)
			(Load rsVIEW 405)
			(Load rsVIEW 412)
		else
			(Load rsVIEW 402)
			(Load rsVIEW 417)
		)
		(super init:)
		(if (<= 8 gCurRoomNum 17)
			(Load rsVIEW 412)
			(gMuleObj view: 405)
			(muleLooper viewChange: 412)
		else
			(Load rsVIEW 417)
			(gMuleObj view: 402)
			(muleLooper viewChange: 417)
		)
		(gMuleObj setLoop: -1 looper: muleLooper setCycle: Walk init:)
		(if (== (gMuleObj view:) 405)
			(gMuleObj setStep: 3 2)
		else
			(gMuleObj setStep: 4 2)
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
					(Said 'look/ass')
					(Said 'ask[/merlin]/ass')
					(MouseClaimed gMuleObj event)
				)
				(Print 115 0) ; "Though the mule is here, she looks even more unhappy than when you started this trip."
			)
			(
				(or
					(Said 'look/pack,pack,clothes,blanket')
					(Said 'ask[/merlin]/pack,pack,clothes,blanket')
				)
				(Print 115 1) ; "Your mule carries your pack containing extra clothes, water and provisions."
			)
			((Said 'remove/pack,food,water,drink,clothes,blanket')
				(Print 115 2) ; "That is best left where it is."
			)
			((Said 'get,open/pack')
				(Print 115 3) ; "For what purpose?"
			)
			((Said 'get,use,change/clothes')
				(Print 115 4) ; "What you are wearing will do for now."
			)
			((Said 'get,use/blanket')
				(if (<= 24 gCurRoomNum 25)
					(Print 115 5) ; "The frost and ice chill the soul more than the body."
				else
					(Print 115 6) ; "It is not THAT cold."
				)
			)
			((Said 'carry,keep,get/pack,pack,clothes,blanket,water')
				(Print 115 7) ; "You are carrying quite enough as it is. That is why you have a pack mule."
			)
			((Said 'hide/ass/blanket[<with]')
				(Print 115 8) ; "The mule does not need the blanket, nor do you need a blanket that smells like a mule."
			)
			((Said 'talk,ask/ass')
				(Print 115 9) ; "You may talk to your mule all you like, Arthur, as long as you do not expect her to talk back."
			)
			((Said 'ride/ass')
				(if (!= global116 0)
					(Print 115 10) ; "She already carries the pack and you have your horse."
				else
					(Print 115 11) ; "The weight of the pack is enough. Your own two feet will serve to carry you."
				)
			)
			((Said 'get,drink,eat/water,food,pack')
				(cond
					((<= 10 gCurRoomNum 17)
						(Print 115 12) ; "You must be on your guard here. Best to wait until you are free of the forest to take your ease."
					)
					((<= 24 gCurRoomNum 25)
						(Print 115 13) ; "You did that during your journey here."
					)
					(else
						(Print 115 14) ; "Time enough for that later. 135 For now, think only of your mission."
					)
				)
			)
		)
	)
)

