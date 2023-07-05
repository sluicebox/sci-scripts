;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)

(public
	rgTroll 0
)

(procedure (localproc_0)
	(localproc_2)
	(Print &rest #title {Troll} #font 4 #at 100 18 #width 200)
)

(procedure (localproc_1)
	(Print 601 34) ; "There is no troll here."
)

(procedure (localproc_2)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (localproc_3)
	(Printf 601 35 &rest) ; "You do not have the %s."
)

(procedure (localproc_4 param1 param2)
	(if (IsFlag 13)
		(if (gEgo has: param1)
			(if (localproc_5)
				(Printf 601 36 &rest) ; "You give the %s to the troll, and it appears to satisfy him. He tromps off leaving the bridge clear for you to cross."
				(gGame changeScore: (if (!= param2 0) param2 else -6))
				(ClearFlag 13)
				(gEgo put: param1)
				(SetFlag 4)
			else
				(Print 601 37) ; "If you want to try that, you should get a little closer."
			)
		else
			(localproc_3 &rest)
		)
	else
		(localproc_1)
	)
)

(procedure (localproc_5)
	(return (< (gEgo distanceTo: gMenace) 45))
)

(instance rgTroll of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 120)
		(self keep: 0)
		(super init:)
		(if (IsFlag 4)
			(ClearFlag 5)
			(ClearFlag 4)
		)
		(gMenace
			view: 120
			setStep: 6 4
			setCycle: Walk
			setLoop: -1
			setPri: -1
			ignoreHorizon:
			init:
			hide:
		)
		(ClearFlag 13)
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if
			(and
				(or (== (gEgo view:) 54) (== (gEgo view:) 14))
				(== (event type:) evSAID)
			)
			(if
				(not
					(or
						(Said 'swim/')
						(Said 'get,get,drink/water,drink')
						(Said 'fill/bucket')
					)
				)
				(Print 601 0) ; "Unfortunately, drowning in the river is taking up all of your attention."
				(event claimed: 1)
			else
				(event claimed: 0)
			)
		)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((or (Said 'look,look/troll,man') (MousedOn gMenace event 3))
				(gMenace doVerb: 1)
			)
			((Said 'look,look>')
				(cond
					((Said '<across[/brook,water,brook]')
						(Print 601 1) ; "There is a green meadow on the other side of the river."
					)
					((Said '/brook,water,brook')
						(Print 601 2) ; "The stream appears placid enough, but appearances can be deceiving."
					)
					((Said '<below,below/bridge')
						(Print 601 3) ; "You glance under the old bridge, but see nothing unusual."
					)
					((Said '/bridge')
						(switch (gCurRoomNum)
							(39
								(Print 601 4) ; "This natural rock bridge connects the Daventry mainland to a small island."
							)
							(else
								(Print 601 5) ; "This is an old, rickety bridge which seems to be one of the only ways cross the river."
								(event claimed: 1)
							)
						)
					)
				)
			)
			((Said 'use/dagger')
				(if (gEgo has: 0) ; Dagger
					(Print 601 6) ; "How do you use the dagger?"
				else
					(Print 601 7) ; "You don't have the dagger."
				)
			)
			((Said 'hit,kill,shoot/troll,man')
				(if (IsFlag 13)
					(Print 601 8) ; "The troll is bigger than you, stronger than you, and much, MUCH meaner than you. Better not even try it."
				else
					(localproc_1)
				)
			)
			((Said 'kill>')
				(if (Said '/goat')
					(cond
						((not (IsFlag 2))
							(Print 601 9) ; "There is no goat here."
						)
						((gEgo has: 0) ; Dagger
							(Print 601 10) ; "You throw the dagger and it lands in the river, lost for all time."
							(gEgo put: 0) ; Dagger
							(gGame changeScore: -5)
						)
					)
				)
			)
			((Said 'use/shot')
				(if (IsFlag 13)
					(Print 601 8) ; "The troll is bigger than you, stronger than you, and much, MUCH meaner than you. Better not even try it."
				else
					(Print 601 11) ; "There is no need for that now."
				)
			)
			((and (not (IsFlag 13)) (Said '/troll,man'))
				(localproc_1)
			)
			((not (IsFlag 13))
				(return)
			)
			((Said 'give>')
				(cond
					(
						(or
							(Said '/diamond/troll,man')
							(Said '/bag[<diamond]/troll,man')
						)
						(localproc_4
							11
							(if (not (IsFlag 62)) -3 else 0)
							601
							12
						)
					)
					((Said '/egg[<gold]/troll,man')
						(localproc_4 15 0 601 13)
					)
					((Said '/scepter/troll,man')
						(localproc_4 12 0 601 14)
					)
					(
						(or
							(Said '/treasure/troll,man')
							(Said '/chest[<treasure]/troll,man')
						)
						(localproc_4 1 0 601 15)
					)
					((Said '/nut<gold/troll,man')
						(if (IsFlag 67)
							(localproc_4 18 0 601 16)
						else
							(localproc_3 601 17)
						)
					)
					((Said '/nut/troll,man')
						(if (IsFlag 13)
							(if (gEgo has: 18) ; Walnut
								(if (not (IsFlag 67))
									(Print 601 18) ; "The troll isn't interested in a plain walnut."
								else
									(localproc_4 18 0 601 16)
								)
							else
								(localproc_3 601 19)
							)
						else
							(localproc_1)
						)
					)
					((Said '/diamond,egg,scepter,treasure,nut')
						(Print 601 20) ; "Why? To what?"
					)
					(
						(and
							(= temp0 (gInventory firstTrue: #saidMe))
							(temp0 ownedBy: gEgo)
						)
						(Print 601 21) ; "Your skimpy offering doesn't impress the troll."
					)
				)
			)
			((Said 'pull/troll,man')
				(if (IsFlag 13)
					(if (localproc_5)
						(Print 601 22) ; "You push the troll as hard as you can. Unfortunately, the troll doesn't budge an inch."
					else
						(Print 601 23) ; "You certainly cannot do that from here."
					)
				else
					(localproc_1)
				)
			)
			((Said 'beg/troll,man')
				(if (IsFlag 13)
					(if (localproc_5)
						(Print 601 24) ; "The troll turns a very large and pointy deaf ear on your pleas."
					else
						(Print 601 25) ; "The troll cannot hear you from there."
					)
				else
					(localproc_1)
				)
			)
			((Said 'pay/toll,troll,man')
				(localproc_0 601 26) ; "TROLL: "Dat's right. Gimme somethin' valuable and maybe, JUST maybe, I'll letcha cross dis bridge. If I feel like it. Which I ain't sure I do.""
			)
			((Said 'throw,throw/pebble,boulder,pebble')
				(cond
					((not (IsFlag 13))
						(Print 601 27) ; "You should save your pebbles. You may need them later."
					)
					((gEgo has: 9) ; Pebbles
						(Print 601 28) ; "You throw a pebble at the troll, but it merely bounces off his thick hide. He barely notices it."
						(UpdatePebbles)
					)
					(else
						(Print 601 29) ; "You don't have any pebbles to throw."
					)
				)
			)
			((Said 'throw/dagger')
				(if (IsFlag 13)
					(if (gEgo has: 0) ; Dagger
						(if (localproc_5)
							(Print 601 30) ; "You throw the dagger and the troll deftly snatches it out of the air. What are you going to do now?"
						else
							(Print 601 31) ; "You throw the dagger wildly and it sails away, never to be found."
						)
						(gEgo put: 0) ; Dagger
						(gGame changeScore: -5)
					else
						(localproc_3 601 32)
					)
				else
					(Print 601 33) ; "There is no one here to throw the dagger at."
				)
			)
		)
	)
)

