;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 181)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)

(public
	Thief 0
)

(synonyms
	(aphrodite aphrodite goddess woman)
)

(instance Thief of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 94)
		(Load rsSOUND (proc0_20 108))
		(Load rsSOUND 115)
		(Load rsSOUND 114)
		(Load rsSCRIPT 198)
		(Load rsSCRIPT 195)
		(super init:)
		(cond
			((not (IsFlag 207)) 0)
			((not (IsFlag 208))
				(if (!= (gRegMusic number:) 109)
					(gRegMusic number: 109 loop: -1 play:)
				)
			)
			((not (IsFlag 196))
				(if (!= (gRegMusic number:) 110)
					(gRegMusic number: 110 loop: -1 play:)
				)
			)
			((!= (gRegMusic number:) 115)
				(gRegMusic number: 115 loop: -1 play:)
			)
		)
		(ClearFlag 217)
		(gEgo
			view:
				(cond
					(global124 6)
					((>= 2000 global167 2) 57)
					(else 0)
				)
			init:
		)
		(proc0_13 113)
		(if (not (IsFlag 197))
			(= global193 0)
		else
			(= global109 6)
		)
	)

	(method (doit)
		(if (and (IsFlag 197) (> global193 1))
			(if (and (gEgo mover:) (> global193 2))
				(-= global193 2)
			else
				(-- global193)
			)
		)
		(if
			(and
				(not (gEgo script:))
				(gEgo inRect: 53 36 292 176)
				(or
					(and (IsFlag 197) (< global193 100) (< gCurRoomNum 79))
					(IsFlag 316)
				)
			)
			(if (not (IsFlag 316))
				(Print 181 0) ; "By all that is holy, you have dallied shamelessly and the Thief has escaped. There is no hope for you, Arthur. You may as well fall upon your sword."
			)
			(gEgo setScript: (ScriptID 198 0)) ; fallOnSword
		)
		(if (IsFlag 317)
			(ClearFlag 317)
			(gEgo setCycle: Walk)
			(HandsOn)
		)
		(if global167
			(-=
				global167
				(if (and (gEgo mover:) (not (gEgo isStopped:))) 8 else 4)
			)
			(if global124
				(-= global167 4)
			)
			(cond
				(
					(and
						(>= 2000 global167 2)
						(not (IsFlag 194))
						(not (gEgo script:))
					)
					(if (not global124)
						(gEgo view: 57)
					else
						(= global149 57)
					)
					(SetFlag 194)
					(Print 181 1) ; "Your strength is fading. The remorseless hand of Death draws near."
				)
				((< global167 1)
					(if (and (not (gEgo script:)) (not global80))
						(gEgo setScript: (ScriptID 195 2)) ; egoKeelsOvr
					else
						(+= global167 30)
					)
				)
			)
		)
	)

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
					((Said '//dove')
						(cond
							((IsFlag 208)
								(Print 181 2) ; "You will see neither the dove nor Aphrodite again."
							)
							((gEgo has: 10) ; lamb | dove
								(Print 181 3) ; "You still carry the stone dove given to you by the statue of Aphrodite. I hope you paid attention to the statue's instructions."
							)
							(else
								(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
							)
						)
					)
					((or (Said '/spiral') (Said '//spiral'))
						(Print 181 4) ; "Spirals are very ancient symbols. They represent the unending cycle of life. A solar spiral turns to the right. A lunar spiral turns to the left."
					)
					((Said '//galahad')
						(cond
							((IsFlag 206)
								(Print 181 5) ; "Had you searched the catacombs, you might have found him. I fear now it is too late for such thoughts."
							)
							((IsFlag 206)
								(Print 181 6) ; "He will recover soon enough. Look to your own needs. You must find the Grail before you die of the rat's poison!"
							)
							(else
								(Print 181 7) ; "He is dead and his death weighs heavily upon your soul."
							)
						)
					)
					((Said '//apple')
						(if (gEgo has: 4) ; rose | apple | green_apple
							(Print 181 8) ; "The Seeress said that eating the apple would relieve hunger and thirst and give you renewed strength. How long such an effect will last is another question, however."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((or (Said '/bone') (Said '//bone'))
						(if (IsFlag 212)
							(Print 181 9) ; "The bone is gone. You must have dropped it on the stairs. Just as well. It was a useless thing to carry around."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '//aphrodite,aphrodite')
						(if (not (IsFlag 208))
							(if (not (IsFlag 207))
								(Print 181 10) ; "Her presence is here. She waits for you to prove yourself with sword and shield, as she requires."
							else
								(Print 181 11) ; "Only you can summon her, Arthur. And waste no time going about it!"
							)
						else
							(Print 181 12) ; "She has abandoned this place at last and will not return."
						)
					)
					((and (IsFlag 208) (Said '//column<sixth'))
						(if (IsFlag 208)
							(Print 181 13) ; "You must locate this pillar by yourself."
						)
					)
					((and (IsFlag 208) (Said '//grail'))
						(if (IsFlag 208)
							(Print 181 14) ; "If you follow Aphrodite's instructions, the Grail will surely be yours."
						)
					)
					((and (IsFlag 208) (Said '//turn,turning,start,starting'))
						(if (IsFlag 208)
							(Print 181 15) ; "You must unravel Aphrodite's words for yourself."
						)
					)
					((and (IsFlag 208) (Said '//number'))
						(Print 181 16) ; "You should know Aphrodite's sacred number by now."
					)
					(
						(and
							(IsFlag 208)
							(Said '//holy<of<holies')
							(Print 181 17) ; "Not even I know such secrets, though certainly the Sacred Cup was one of them."
						))
					((or (Said '/bandit') (Said '//bandit'))
						(Print 181 18) ; "I see no thief. Perhaps your experience with the thief in the bazaar still preys upon your mind."
					)
					((or (Said '/saracen') (Said '//saracen'))
						(cond
							((IsFlag 207)
								(Print 181 19) ; "You vanquished him, as you must surely remember."
							)
							((and (IsFlag 213) (IsFlag 214) (IsFlag 215))
								(Print 181 20) ; "He looks to be a formidable opponent. And he is no ordinary mortal, but a mystic guardian. Defeating him will require strategy and wits more than brute strength."
							)
							(else
								(Print 181 21) ; "There is no Saracen here."
							)
						)
					)
				)
			)
			((Said 'throw/dove')
				(if (gEgo has: 10) ; lamb | dove
					(Print 181 22) ; "That would be exceedingly foolish."
				else
					(Print 181 23) ; "What ARE you blathering about?"
				)
			)
			((Said 'use/medal')
				(if (gEgo has: 8) ; boar_spear | grain | medallion
					(Print 181 24) ; "It has no further use for the moment."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((or (Said 'remove,exit,abandon/medal') (Said 'get<off,medal'))
				(if (gEgo has: 8) ; boar_spear | grain | medallion
					(Print 181 25) ; "Nay, keep it. It is a valuable talisman."
				else
					(Print 181 26) ; "You are talking nonsense."
				)
			)
			((Said 'use,drop,exit,abandon/bone')
				(if (IsFlag 212)
					(Print 181 9) ; "The bone is gone. You must have dropped it on the stairs. Just as well. It was a useless thing to carry around."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'summon,call/aphrodite,aphrodite')
				(if (IsFlag 208)
					(Print 181 12) ; "She has abandoned this place at last and will not return."
				else
					(Print 181 27) ; "Only you can do that. As for when and how, your own wits must guide you."
				)
			)
			((Said 'talk[<to]/aphrodite,aphrodite')
				(if (IsFlag 208)
					(Print 181 12) ; "She has abandoned this place at last and will not return."
				else
					(Print 181 28) ; "I suspect that when the time comes, it will be the Goddess who does the talking, not you."
				)
			)
			((Said 'ask/aphrodite,aphrodite/*<about')
				(Print 181 29) ; "She does not answer. I cannot imagine why she would."
			)
			((Said 'get/grail')
				(Print 181 30) ; "Aye, that IS the purpose of your mission."
			)
			((or (Said 'talk/saracen') (Said 'ask/saracen/*<about'))
				(if (IsFlag 207)
					(Print 181 31) ; "If you dredge your feeble memory, you may recall that you have killed him."
				else
					(Print 181 32) ; "Ahem. Arthur, there is no Saracen here."
				)
			)
			(
				(and
					(IsFlag 208)
					(or
						(Said
							'give,sell,bargain/aphrodite/apple,elixer,lodestone,medal'
						)
						(Said
							'give,sell,bargain/apple,elixer,lodestone,medal[<to]/aphrodite'
						)
					)
				)
				(Print 181 33) ; "She would have no interest in mortal trinkets."
			)
			(
				(or
					(Said 'stop,get,kill,attack,prevent,search/bandit')
					(Said 'capture/bandit')
				)
				(Print 181 18) ; "I see no thief. Perhaps your experience with the thief in the bazaar still preys upon your mind."
			)
			((Said 'use,drink/elixer')
				(if (gEgo has: 5) ; sleeve | elixir
					(gEgo setScript: (ScriptID 195 0)) ; DrinkElix
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'eat/apple')
				(if (gEgo has: 4) ; rose | apple | green_apple
					(gEgo setScript: (ScriptID 195 1)) ; EatAppl
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'draw/blade')
				(= global124 1)
				(if (gEgo has: 7) ; crystal_heart | charcoal | helm
					(SetFlag 198)
				)
			)
		)
	)
)

