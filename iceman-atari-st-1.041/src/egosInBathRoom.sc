;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 303)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	egosInBathRoom 0
)

(local
	local0
	local1
)

(instance egosInBathRoom of Script
	(properties)

	(method (handleEvent event)
		(cond
			((Said 'look[<at,around][/room,bathroom]')
				(Print 303 0) ; "You look around the small but adequate bathroom facility."
				(Print 303 1) ; "It is equipped with a small sink, mirror, shower and marine toilet. A small light is above the toilet."
			)
			((Said 'look/sink')
				(Print 303 2) ; "It's small and made of stainless steel."
			)
			((or (Said 'use/sink') (Said 'wash/hand') (Said 'turn<on/water'))
				(Print 303 3) ; "In an effort to conserve the water supply, you quickly wash your hands then turn off the water."
			)
			((Said 'look/mirror')
				(Print 303 4) ; "You look into the mirror and think, "Yep, I still look the same.""
			)
			((Said 'comb/hair')
				(Print 303 5) ; "Since cleanliness and grooming are part of Navy life, you look into the mirror and comb your hair."
			)
			((Said 'look/shower')
				(Print 303 6) ; "The only thing special about this shower is that it's small."
			)
			((Said '(turn<on),use,get/shower')
				(Print 303 7) ; "In record time you take a hot shower."
			)
			((Said 'look/light')
				(= local1 (Random 0 1))
				(Print 303 8) ; "This is a typical marine toilet that dumps waste into the ship's holding tanks."
				(Print 303 9) ; "When the holding tanks are full, they are pressurized to force the waste into the open ocean."
				(Print 303 10) ; "If you flush the toilet when this light is on, the pressure will forcibly expelled the contents of the holding tanks through your toilet."
				(if local1
					(Print 303 11) ; "The light is currently on."
				else
					(Print 303 12) ; "The light is currently not on."
				)
			)
			((Said 'look[/toilet]')
				(Print 303 8) ; "This is a typical marine toilet that dumps waste into the ship's holding tanks."
				(Print 303 9) ; "When the holding tanks are full, they are pressurized to force the waste into the open ocean."
				(Print 303 13) ; "It is highly recommended that the toilet not be flushed when the tanks are pressurized."
			)
			((Said 'flush[/toilet]')
				(cond
					(local0
						(= local0 0)
						(Print 303 14) ; "Your failure to follow explicit instruction has left you a stinking mess."
						(Print 303 15) ; "As you hurriedly clean the enormous amount of human waste off your body, we are busy deducting 3 points from your score."
						(gGame changeScore: -3)
					)
					(local1
						(Print 303 16) ; "The holding tanks are pressurized. Flushing is not recommended."
						(= local1 (Random 0 1))
						(= local0 1)
					)
					(else
						(Print 303 17) ; "You flush the toilet."
						(= local1 (Random 0 1))
					)
				)
			)
			((Said 'sit,use/toilet,bathroom')
				(Print 303 18) ; "You use the toilet, flush it, then wash your hands."
			)
			((or (Said 'leak') (Said 'get//leak'))
				(Print 303 19) ; "Step closer, Johnny, it's shorter than you think."
			)
			((or (Said 'shit') (Said 'get//shit'))
				(Print 303 20) ; "The human process of waste elimination has made you two pounds lighter."
			)
			((Said 'get/*')
				(Print 303 21) ; "You don't need it."
			)
			((Said 'look/*')
				(Print 303 22) ; "That's not important to you now."
			)
			((or (Said 'open[/door]>') (Said 'exit[/bathroom]>'))
				((ScriptID 30 1) handleEvent: event) ; bathDoor
			)
			((Said '*')
				(Print 303 23) ; "Not in here."
			)
		)
	)
)

