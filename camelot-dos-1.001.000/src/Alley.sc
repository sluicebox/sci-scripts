;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 184)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	Alley 0
)

(instance Alley of Rgn
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
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
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((Said '<up')
						(Print 184 0) ; "The buildings rise all around you to a narrow band of sky overhead."
					)
					((Said '<down')
						(Print 184 1) ; "You trod upon hard-packed earth as firm as stone."
					)
					(
						(or
							(Said '/aphrodite,goddess')
							(Said '//aphrodite,goddess')
						)
						(if (IsFlag 208)
							(Print 184 2) ; "You will never see her again."
						else
							(Print 184 3) ; "I doubt you will see the Goddess in this alley."
						)
					)
					((or (Said '/building,house') (Said '//building,house'))
						(Print 184 4) ; "I cannot tell if these buildings are empty or occupied, but they seem deliberately built to prevent anyone from entering or even seeing the Temple."
					)
					((or (Said '/plant') (Said '//plant'))
						(Print 184 5) ; "Merely common weeds, of no consequence."
					)
					((and (gEgo has: 10) (Said '//dove')) ; lamb | dove
						(Print 184 6) ; "The Goddess said to use it after you had proven yourself by sword and shield."
					)
					((or (Said '/wall,brick') (Said '//wall,brick'))
						(Print 184 7) ; "These are brick walls covered with plaster."
					)
					((or (Said '/door') (Said '//door'))
						(Print 184 8) ; "There is none."
					)
					((or (Said '/bandit') (Said '//bandit'))
						(Print 184 9) ; "Ahem, there is no-one in this alley but you, Arthur."
					)
				)
			)
			((Said 'talk[<to]/aphrodite,goddess')
				(if (IsFlag 208)
					(Print 184 2) ; "You will never see her again."
				else
					(Print 184 3) ; "I doubt you will see the Goddess in this alley."
				)
			)
			((Said 'talk[<to]/bandit')
				(Print 184 10) ; "Who? There is no-one else here."
			)
			((Said 'get/bandit')
				(Print 184 10) ; "Who? There is no-one else here."
			)
			((Said 'use/dove')
				(if (gEgo has: 10) ; lamb | dove
					(Print 184 11) ; "It does nothing here."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'kill,attack,annihilate/bandit')
				(Print 184 10) ; "Who? There is no-one else here."
			)
			(
				(or
					(Said 'open,annihilate,enter/window,grate')
					(Said 'open,bend,annihilate/bar')
				)
				(Print 184 12) ; "It would be a waste of time, even if you had the means."
			)
		)
	)
)

