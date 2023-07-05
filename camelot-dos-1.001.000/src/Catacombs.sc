;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 125)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use System)

(public
	Catacombs 0
)

(local
	local0
	[local1 8] = [68 71 67 -1 72 74 0 0]
)

(procedure (localproc_0 &tmp temp0)
	(if
		(or
			(== (= temp0 [local1 (- gCurRoomNum 67)]) 0)
			(== gPrevRoomNum temp0)
			(and (== gCurRoomNum 72) (== gPrevRoomNum 72))
		)
		(return 1)
	else
		(return 0)
	)
)

(instance Catacombs of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 48)
		(Load rsVIEW 418)
		(Load rsVIEW 419)
		(Load rsVIEW 420)
		(Load rsSOUND 67)
		(Load rsSOUND (proc0_20 68))
		(Load rsSOUND 66)
		(if global171
			(Load rsVIEW 57)
		)
		(super init:)
		(gEgo
			view:
				(cond
					(global124 6)
					((>= 2000 global167 2) 57)
					(else 0)
				)
			illegalBits: (if (gEgo has: 10) -32768 else -16384) ; lamb | dove
			init:
		)
		(if (== gCurRoomNum 74)
			(gEgo illegalBits: -16384)
		)
		(if (IsFlag 324)
			(SetFlag 181)
			(if (or (not (localproc_0)) (and (== gPrevRoomNum 73) (== gCurRoomNum 71)))
				(Load rsSOUND (proc0_20 84))
				(Load rsSOUND (proc0_20 87))
				(SetFlag 171)
				(SetFlag 172)
				(if (not (and (== gCurRoomNum 72) (== gPrevRoomNum 69)))
					(gEgo setScript: (ScriptID 173 0)) ; trappedByDoors
				)
			)
		)
		(if (and (!= (gRegMusic number:) 66) (!= (gRegMusic number:) 94))
			(gRegMusic number: 66 loop: -1 play:)
		)
		(if (or (== gPrevRoomNum 0) (== gPrevRoomNum 66))
			(SetFlag 184)
			(SetFlag 185)
			(SetFlag 186)
			(SetFlag 187)
			(SetFlag 188)
			(SetFlag 189)
			(SetFlag 190)
			(SetFlag 191)
		)
		(proc0_13 640)
	)

	(method (dispose)
		(DisposeScript 126)
		(DisposeScript 917)
		(DisposeScript 172)
		(super dispose:)
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if (and (IsFlag 322) (== (gEgo view:) 6))
			(ClearFlag 322)
			(Print 125 0) ; "Rather than waste your time in fruitless endeavors, I advise you to simply avoid the mummies and the urns and concentrate upon your task -- finding a way out of here."
		)
		(if global171
			(doPoisonTimer doit:)
		)
		(if
			(and
				(== global125 4)
				global136
				(== (gEgo cel:) (- (NumCels gEgo) 1))
				(> (++ local0) 2)
			)
			(= local0 0)
			(Print 125 1) ; "The rats are too quick and can hide too easily from your sword. You are wasting precious time, Arthur."
		)
		(cond
			((or (not (= temp0 (gEgo onControl:))) (& temp0 $8000)) 0)
			(
				(and
					(& (gEgo onControl: 1) $2000)
					(not (IsFlag 183))
					(not (gEgo script:))
				)
				(gEgo setScript: warnedAboutRats)
			)
			((and (& (gEgo onControl: 1) $0400) (not (IsFlag 183)))
				(SetFlag 179)
			)
			((== temp0 1)
				(if (== (gEgo priority:) 1)
					(gEgo setPri: -1)
				)
			)
			(
				(and
					(& temp0 $007c)
					(!= (gEgo priority:) 1)
					(not (& (gEgo signal:) $0010))
				)
				(gEgo setPri: 1)
			)
		)
	)

	(method (handleEvent event)
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
			((Said 'look,find/elixer')
				(if (IsFlag 175)
					(Print 125 2) ; "The elixir is gone and I did not keep track of where you dropped the empty vial."
				else
					(event claimed: 0)
				)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said 'ask//north,south,east,west')
							(Said
								'(<are<what<direction),show/north,south,east,west'
							)
						)
						(Print 125 3) ; "I am quite disoriented in these catacombs. You could be facing in any direction, for all I can tell."
					)
					((Said '<in/pot,jar,pot')
						(Print 125 4) ; "The red eyes of a poisonous rat glare back at you."
					)
					((Said '<below/body')
						(Print 125 5) ; "There is a plenty of dust and rat droppings."
					)
					((Said '<above,behind/body')
						(Print 125 6) ; "The lethal rats of the catacombs lurk behind these mummies."
					)
					((Said 'look<up')
						(Print 125 7) ; "There is a vaulted stone ceiling."
					)
					((or (Said 'look<down') (Said 'look/floor'))
						(Print 125 8) ; "The floor is made of cold, cold stone."
					)
					((or (Said '/rat') (Said '//rat'))
						(Print 125 9) ; "The poisonous rats are everywhere, but seem to favor the mummies and urns. Best to stay clear of them."
						(Print 125 10) ; "Remember the hierophant's warning: one bite means a slow but certain death. To be bitten more than once, will hasten that terrible fate."
					)
					((or (Said '/niche') (Said '//niche'))
						(Print 125 11) ; "The niches hold the mummies, as you can clearly see."
					)
					(
						(or
							(and (not (gEgo has: 9)) (Said '/bone')) ; herbs | bone
							(Said '//bone')
						)
						(Print 125 12) ; "There are a great many bones around, as might be expected in catacombs."
					)
					((Said '/door,door')
						(Print 125 13) ; "The doorways are quite low and show how thick the walls are between the rooms."
					)
					((Said '//warding,incantation')
						(Print 125 14) ; "A spell of warding is one which repels evil spirits or creatures."
					)
					((Said '//grail')
						(Print 125 15) ; "I suppose it could be hidden in these catacombs. You must be alert to any possibility."
					)
					((Said '//galahad')
						(cond
							((IsFlag 173)
								(Print 125 16) ; "You let him die, Arthur. Your soul will never be cleansed of this sin."
							)
							((IsFlag 177)
								(Print 125 17) ; "So close was he to death, that it may take some time for the elixir to work. Your only chance is to find the Grail so that it may heal you."
							)
							(else
								(Print 125 18) ; "Though you have not found him, he may yet be in some undiscovered chamber."
							)
						)
					)
					(
						(Said
							'//aphrodite,legend,adonis,charioteer,pygmalion,ares,cyprus,persephone,phaedra,poseidon,theseus,zeus'
						)
						(Print 125 19) ; "If you seek such knowledge, consult your Liber ex Doctrina."
					)
					((Said '//mosaic')
						(Print 125 20) ; "There is no mural here."
					)
					((Said '//gnostic')
						(SetScore 302 1 1)
						(Print 125 21) ; "Gnostic means "knowledge." It refers to secretive Christian cults who seek after heavenly knowledge, disdain all matters of the flesh, and worship Sophia, the Great Mother of all wisdom."
						(Print 125 22) ; "For the past four centuries they have been heavily persecuted by the Christian sect ruling from Rome and may have met here to worship in secret."
					)
					((Said '//sophia')
						(SetScore 303 1 1)
						(Print 125 23) ; "To the Gnostics, she is the Great Mother of wisdom, creator of the universe, mother and wife to the god who came after her."
						(Print 125 24) ; "Because of this belief, the Gnostics also allow women to be priests. And for this reason, the Christians in Rome particularly hate them."
					)
					((Said '//sculpture')
						(if (IsFlag 176)
							(Print 125 25) ; "The only statue present in the catacombs is that of Aphrodite."
						else
							(Print 125 26) ; "What statue? I see no statue."
						)
					)
					((Said '/dust')
						(Print 125 27) ; "It is quite dusty."
					)
					((Said '/apple>')
						(if
							(and
								(gEgo has: 11) ; mirror | golden_apple
								(gEgo has: 4) ; rose | apple | green_apple
								(Said '/[<!*]')
							)
							((gInventory at: 11) showSelf:) ; mirror | golden_apple
							((gInventory at: 4) showSelf:) ; rose | apple | green_apple
						)
					)
					(
						(or
							(Said 'ask//apple<(golden,dinar)')
							(and (not (gEgo has: 4)) (Said 'ask//apple')) ; rose | apple | green_apple
						)
						(if (gEgo has: 11) ; mirror | golden_apple
							(Print 125 28) ; "The apple made of solid gold was probably once a sacred object in a temple of the Goddess."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '//apple')
						(if (gEgo has: 4) ; rose | apple | green_apple
							(Print 125 29) ; "The Seeress gave you the green apple, do you not remember?"
							(Print 125 30) ; "She said that eating it would relieve all your hunger and thirst and give you renewed strength."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said 'ask//dove')
						(if (not (gEgo has: 10)) ; lamb | dove
							(Print 125 31) ; "Doves are a fertility symbol sacred to Aphrodite. But also it is widely believed that the soul becomes a dove at death and flies to heaven."
						else
							(Print 125 32) ; "The best I can tell you at the moment is that the stone dove you carry seems to be a stone dove."
						)
					)
				)
			)
			((Said 'call,yell,talk/galahad')
				(cond
					((not (IsFlag 177))
						(Print 125 33) ; "These solid, musty rooms absorb your voice. You will have to search room by room."
					)
					((IsFlag 173)
						(Print 125 34) ; "Like the other dead souls in this place, he can no longer answer you."
					)
					(else
						(Print 125 35) ; "Do not expect him to answer. Even if he could hear you, he will not yet be healed and conscious."
					)
				)
			)
			((Said 'eat/rat')
				(Print 125 36) ; "There are poisonous."
			)
			((Said 'get[<!*]/dust')
				(Print 125 37) ; "No need. If you do not find a way out of these catacombs, you will BE dust."
			)
			((or (Said 'get[<!*]/bone') (Said 'pick<up/bone'))
				(if (gEgo has: 9) ; herbs | bone
					(Print 125 38) ; "One disgusting old bone is quite enough."
				else
					(Print 125 39) ; "There are no loose bones here to pick up, Arthur, and there are rats lurking around the mummies."
				)
			)
			((Said 'drop,exit,(drop<down),abandon/bone')
				(cond
					((not (gEgo has: 9)) ; herbs | bone
						(Print 125 40) ; "You don't have one."
					)
					((gEgo script:)
						(Print 125 41) ; "Not now. Keep your mind on what you are doing."
					)
					(else
						(gEgo setScript: (ScriptID 173 2)) ; dropBone
					)
				)
			)
			((and (gEgo has: 9) (Said 'use/bone')) ; herbs | bone
				(Print 125 42) ; "I cannot imagine a use for it....except for rats to gnaw upon."
			)
			((Said 'eat,eat,(gnaw[<on]),lick,eat/bone')
				(Print 125 43) ; "Disgusting. You are a king, not a ghoul."
			)
			((and (gEgo has: 10) (Said 'use/dove')) ; lamb | dove
				(Print 125 44) ; "Nothing happens."
			)
			(
				(Said
					'get,annihilate,poke,grab,attack,pull,unwind/body,skeleton,skull,ash,organ'
				)
				(Print 125 45) ; "Treat the dead with respect and caution. Especially in this place. And beware the rats."
			)
			((Said 'kill,stab/body')
				(Print 125 46) ; "It is a mummy. It has been dead for perhaps hundreds of years. Do try to show some sense."
			)
			((Said 'talk/body')
				(Print 125 47) ; "Mummies are not known for their witty conversation."
			)
			((Said 'talk/rat')
				(Print 125 48) ; "It is good that no-one else is here to see you having a one-sided conversation with a poisonous rat."
			)
			((Said 'get,capture,trap/rat')
				(Print 125 49) ; "Considering the danger of their bite, you are best to avoid these rats at all costs."
			)
			((Said 'give/bone/rat')
				(if (gEgo has: 9) ; herbs | bone
					(Print 125 50) ; "They have plenty of bones to gnaw on."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'exit,drop,abandon/dove')
				(if (gEgo has: 10) ; lamb | dove
					(Print 125 51) ; "That would be exceedingly foolish."
				else
					(Print 125 52) ; "What ARE you blathering about?"
				)
			)
			((or (Said 'wear,(drop<on)/medal') (Said 'drop/medal/neck<around'))
				(if (gEgo has: 8) ; boar_spear | grain | medallion
					(Print 125 53) ; "You are already wearing it."
				else
					(Print 125 54) ; "You do not have a medallion."
				)
			)
			((Said 'remove,(get<off),exit,abandon/medal')
				(if (gEgo has: 8) ; boar_spear | grain | medallion
					(Print 125 55) ; "That would not be wise. It has a powerful warding spell upon it."
				else
					(Print 125 56) ; "You are talking nonsense."
				)
			)
			((Said 'eat>')
				(cond
					(
						(and
							(gEgo has: 11) ; mirror | golden_apple
							(gEgo has: 4) ; rose | apple | green_apple
							(Said '/apple[<!*]')
						)
						(Print 125 57) ; "You have both a green apple and a golden apple."
					)
					(
						(and
							(gEgo has: 11) ; mirror | golden_apple
							(or
								(Said '/apple<golden,dinar')
								(and (not (gEgo has: 4)) (Said '/apple')) ; rose | apple | green_apple
							)
						)
						(Print 125 58) ; "Even King Midas could not eat a golden apple."
					)
					((and (gEgo has: 4) (Said '/apple')) ; rose | apple | green_apple
						(gEgo setScript: (ScriptID 195 1)) ; EatAppl
					)
					(else
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						(event claimed: 1)
					)
				)
			)
			((Said 'use/apple>')
				(if (and (gEgo has: 4) (gEgo has: 11) (Said '/[<!*]')) ; rose | apple | green_apple, mirror | golden_apple
					(Print 125 59) ; "You have two apples to choose from. The green apple and the golden apple."
				else
					(event claimed: 1)
					(Print 125 60) ; "Aye, but how?"
				)
			)
			((Said 'use,drink/elixer')
				(if (gEgo has: 5) ; sleeve | elixir
					(gEgo setScript: (ScriptID 195 0)) ; DrinkElix
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'kill,attack/rat')
				(= global124 1)
				(= global125 1)
				(SetFlag 322)
			)
			((Said 'draw/blade') 0)
			((or (Said 'talk/merlin') (Said 'ask/advice'))
				(Print 125 61) ; "Clearly your challenge is to escape these catacombs. You must use your wits to discover the means."
			)
			(
				(Said
					'give,sell,bargain/(apple<green),(apple<golden),elixer,grail,lodestone'
				)
				(if (and global140 (gEgo has: global140))
					(Print 125 62) ; "There is no-one here who still desires mortal things."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'get/grail')
				(Print 125 63) ; "That is the purpose of your mission. I pray you will succeed."
			)
		)
	)
)

(instance warnedAboutRats of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(Print 125 64) ; "Arthur! Beware the rats! Any closer and you will be bitten!"
				(= temp1
					(if (= temp0 (gEgo mover:))
						(temp0 dx:)
					else
						0
					)
				)
				(= temp2
					(if temp0
						(temp0 dy:)
					else
						4
					)
				)
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) temp1)
						(- (gEgo y:) temp2)
				)
				(= cycles 30)
			)
			(1
				(client setScript: 0)
			)
		)
	)
)

(instance doPoisonTimer of Script
	(properties)

	(method (doit &tmp [temp0 100])
		(super doit:)
		(if (and (not (gEgo script:)) (not (IsFlag 288)))
			(if (IsFlag 195)
				(-- global167)
			else
				(-=
					global167
					(if (and (gEgo mover:) (not (gEgo isStopped:)))
						8
					else
						4
					)
				)
				(if global124
					(-= global167 4)
				)
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
					(Print 125 65) ; "Your strength is fading. The remorseless hand of Death draws near."
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
)

