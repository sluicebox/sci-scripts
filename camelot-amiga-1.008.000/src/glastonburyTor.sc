;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use n117)
(use Interface)
(use Save)
(use Game)
(use Actor)

(public
	glastonburyTor 0
)

(synonyms
	(ones elemental spirit)
	(doug man)
)

(procedure (localproc_0)
	(Print 104 0) ; "It is made of the purest crystal, as best I can tell, and it contains enormous power such as only a wizard or enchantress could control."
)

(instance monkWindow of SysWindow
	(properties
		color 15
		back 6
		title {Mad Monk}
		brLeft 50
		brBottom 120
		brRight 250
	)
)

(instance madMonk of Act
	(properties)
)

(instance glastonburyTor of Rgn
	(properties)

	(method (init)
		(super init:)
		(proc0_13 48)
		(if (not (>= 22 gPrevRoomNum 18))
			(= global201 20)
		)
		(gEgo view: (if global124 6 else 0) init:)
		(if (not (IsFlag 49))
			(gTObj tWindow: monkWindow actor: 0 init:)
		)
		(= gMadMonk madMonk)
		(cond
			(
				(and
					(IsFlag 48)
					(not (IsFlag 49))
					(!= gCurRoomNum 20)
					(!= gCurRoomNum 22)
					(Random 0 2)
					(!= global201 gPrevRoomNum)
				)
				(= global201 gCurRoomNum)
				(gCurRoom setRegions: 111) ; monkAttack
				(if (!= (gRegMusic number:) 23)
					(gRegMusic stop: number: 23 loop: -1 play:)
				)
			)
			((!= (gRegMusic number:) 18)
				(gRegMusic stop: number: 18 loop: -1 play:)
			)
		)
		(if (and (== global201 gCurRoomNum) (not (IsFlag 48)) (not (IsFlag 49)))
			(gTObj tWindow: monkWindow)
			(gMadMonk
				view: 337
				init:
				illegalBits: 0
				setScript: (ScriptID 132 1) ; monkActions
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
					(Said 'find,search/ones,ghost,(ones[<old])')
					(Said 'find,search//ones,ghost,(ones[<old])')
					(Said 'where/ones[<old]')
					(Said '/where/ones[<old]')
				)
				(Print 104 1) ; "Such beings tend to manifest near some spot where they were once worshipped."
			)
			(
				(Said
					'talk,summon,(call[<to]),apologize,calm,invoke/ones,ghost,(ones<old)'
				)
				(cond
					((and (not (IsFlag 49)) (not (IsFlag 321)))
						(event claimed: 0)
					)
					((or (gEgo has: 6) (== gCurRoomNum 22)) ; iron_key | broom | grail
						(Print 104 2) ; "They will not answer you now."
					)
					(else
						(Print 104 3) ; "You must find a place where they will answer you."
						(event claimed: 1)
					)
				)
			)
			((Said 'climb[<onto,up]/wall')
				(Print 104 4) ; "These walls are ancient and most likely would collapse beneath you."
			)
			((Said 'get,move,press/boulder,slab,tree,bush,plant')
				(Print 104 5) ; "What a useless idea."
			)
			(
				(or
					(Said 'look,get,find/ass')
					(Said 'ask,look,search/[<merlin]/ass')
				)
				(Print 104 6) ; "She is undoubtedly grazing at the bottom of the hill."
			)
			((or (Said 'search,look//doug,body') (Said 'find/doug,body'))
				(cond
					((IsFlag 49)
						(Print 104 7) ; "Not a trace of the Monk is left. The Old Ones have taken him, body and soul."
					)
					((!= global201 gCurRoomNum)
						(Print 104 8) ; "If he is in these ruins, you will surely find him."
					)
					((IsFlag 48)
						(Print 104 9) ; "Are YOU mad?! He is here!"
					)
					((and (< (gEgo x:) 250) (> (gEgo y:) 105))
						(Talk 104 10) ; "You have the air of a man who is searching for someone, but I assure you I am the only other soul upon this Tor."
					)
					(else
						(Print 104 11) ; "He appears to be just on the other side of the wall."
					)
				)
			)
			(
				(or
					(Said 'look<down[/!*]')
					(Said 'look/dirt')
					(Said 'look<in/ruin')
				)
				(Print 104 12) ; "There is little to be found but rubble."
			)
			((Said 'look<in/rubble')
				(Print 104 13) ; "Inside the rubble is....nothing."
			)
			((Said 'look<below/ruin,rubble')
				(Print 104 14) ; "The ruins are nothing but bits of wall and fallen rock with only the Tor beneath them."
			)
			((Said 'look/rubble')
				(Print 104 15) ; "It is only debris from the collapsed walls and roof of whatever once stood here."
			)
			((or (Said 'look<up') (Said 'look/sky,ceiling'))
				(Print 104 16) ; "The sky is open overhead. Not a bit of the original roof remains."
			)
			((Said 'look[<at,in]/ruin')
				(Print 104 17) ; "These could possibly be the ruins of the shrine built by Joseph of Arimathea, but no one, not even I, can be sure of that."
			)
			((Said 'pick,get/blossom')
				(Print 104 18) ; "You have more important things to do."
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'are<where>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said '/glastenbury,glastenbury')
							(Said '//glastenbury,glastenbury')
						)
						(Print 104 19) ; "It has been a sacred hill for centuries."
					)
					(
						(or
							(Said '/doug')
							(Said '//doug')
							(MouseClaimed gMadMonk event)
						)
						(cond
							((IsFlag 49)
								(Print 104 20) ; "The Old Ones took his body and soul away."
							)
							((!= global201 gCurRoomNum)
								(if (and (not (IsFlag 58)) (!= gCurRoomNum 20))
									(Print 104 21) ; "Perhaps the Monk no longer dwells here. As yet, there is no sign of him."
								else
									(Print 104 22) ; "There is no monk in sight here."
								)
							)
							((IsFlag 48)
								(Print 104 23) ; "Those glazed, fanatical eyes filled with hatred, those snarling lips flecked with foam! The Monk truly is a madman!"
							)
							((IsFlag 62)
								(Print 104 24) ; "Ah, so THIS is why he is called the Mad Monk of Glastonbury."
							)
							((not (gCast contains: gMadMonk))
								(Print 104 22) ; "There is no monk in sight here."
							)
							(else
								(Print 104 25) ; "This Monk seems calm enough. Perhaps he is not the one they call the Mad Monk. We shall see."
							)
						)
					)
					((Said '//escape')
						(if (gEgo has: 7) ; crystal_heart | charcoal | helm
							(Print 104 26) ; "The spell of Circular Entrapment is broken now that you possess this crystal heart, for this was the object of power which held the spell in place."
						else
							(Print 104 27) ; "There is a spell of Circular Entrapment cast over Glastonbury Tor. You cannot leave here unless you break it."
							(Print 104 28) ; "I sense only minor sorcerous ability in the monk, so there must be some other source of extraordinary power to hold the spell in place."
						)
					)
					((or (Said '/delusion') (Said '//delusion'))
						(if (not (IsFlag 59))
							(Print 104 29) ; "There are many illusions. Some say life itself is an illusion. But this is no time for philosophical discourse."
						else
							(Print 104 30) ; "This monk has minor sorcerous powers, enough to generate two illusions of himself to confuse you."
							(Print 104 31) ; "The illusions are harmless, but the monk is armed with a deadly club and can do you great harm indeed."
						)
					)
					(
						(or
							(Said '/incantation,entrapment')
							(Said '//incantation,entrapment')
						)
						(if (gEgo has: 7) ; crystal_heart | charcoal | helm
							(Print 104 26) ; "The spell of Circular Entrapment is broken now that you possess this crystal heart, for this was the object of power which held the spell in place."
						else
							(Print 104 27) ; "There is a spell of Circular Entrapment cast over Glastonbury Tor. You cannot leave here unless you break it."
							(Print 104 28) ; "I sense only minor sorcerous ability in the monk, so there must be some other source of extraordinary power to hold the spell in place."
						)
					)
					((or (Said '/key') (Said '//key'))
						(if (gEgo has: 6) ; iron_key | broom | grail
							(event claimed: 0)
						else
							(Print 104 32) ; "I do not know of any key."
						)
					)
					(
						(or
							(Said '/heart[<crystal,about]')
							(Said '//heart[<crystal,about]')
						)
						(if (gEgo has: 7) ; crystal_heart | charcoal | helm
							(localproc_0)
							((gInventory at: 7) showSelf:) ; crystal_heart | charcoal | helm
						else
							(Print 104 33) ; "I know nothing of a crystal heart. What a peculiar thing to ask about."
						)
					)
					((or (Said '/heart') (Said '//heart'))
						(if (gEgo has: 7) ; crystal_heart | charcoal | helm
							(localproc_0)
							((gInventory at: 7) showSelf:) ; crystal_heart | charcoal | helm
						else
							(Print 104 34) ; "My heart is fine, thank you."
						)
					)
					((or (Said '/arimathea') (Said '//arimathea'))
						(Print 104 35) ; "Joseph of Arimathea is a legendary figure, supposedly a man who helped to bury Christ and who then brought the Grail to our island and established a shrine upon this Tor."
					)
					((or (Said '/door') (Said '//door'))
						(Print 104 36) ; "Any doors this building once had are long gone."
					)
					((or (Said '/wall') (Said '//wall'))
						(if (IsFlag 48)
							(Print 104 37) ; "The ruins offer little in the way of defense or concealment."
						else
							(Print 104 38) ; "Grass, rubble, some bushes....not much to see, really."
						)
					)
					((or (Said '/ghost') (Said '//ghost'))
						(if (IsFlag 49)
							(Print 104 39) ; "The ghost of the Mad Monk is here, but cannot be seen, heard or felt. He can do you no harm."
						else
							(Print 104 40) ; "There are no ghosts here."
						)
					)
					((or (Said '/body') (Said '//body'))
						(cond
							((IsFlag 49)
								(Print 104 7) ; "Not a trace of the Monk is left. The Old Ones have taken him, body and soul."
							)
							((!= global201 gCurRoomNum)
								(Print 104 41) ; "There is no body to see here."
							)
							(else
								(Print 104 42) ; "He is a stout man with powerful arms."
							)
						)
					)
					((or (Said '/clothes,hood') (Said '//clothes,hood'))
						(if (and (== global201 gCurRoomNum) (not (IsFlag 49)))
							(Print 104 43) ; "The Monk's garb is very old, very worn and very smelly."
						else
							(Print 104 44) ; "You cannot see what is not here."
						)
					)
					((or (Said '/club') (Said '//club'))
						(cond
							((!= global201 gCurRoomNum)
								(Print 104 44) ; "You cannot see what is not here."
							)
							((IsFlag 49)
								(Print 104 45) ; "The Old Ones took the club along with the Monk's body."
							)
							((and (IsFlag 48) (IsFlag 58))
								(Print 104 46) ; "It is a crude but lethal weapon."
							)
							(else
								(Print 104 47) ; "What club?"
							)
						)
					)
					((or (Said '/tree') (Said '//tree'))
						(Print 104 48) ; "There are no true trees on Glastonbury Tor. There are only some common bushes."
					)
					((or (Said '/bush,plant') (Said '//bush,plant'))
						(Print 104 49) ; "They are common bushes."
					)
					((or (Said '/boulder,slab') (Said '//boulder,slab'))
						(Print 104 50) ; "Most of the rocks on this hill are fallen from the ancient walls."
					)
					((or (Said '/blossom') (Said '//blossom'))
						(Print 104 51) ; "The flowers seem cheerful amid the ancient ruins."
					)
					(
						(and
							(Said 'ask,(are<where)>')
							(or (Said '/ones[<old]') (Said '//ones[<old]'))
						)
						(SetScore 256 1 1)
						(cond
							((IsFlag 60)
								(Print 104 52) ; "You will not hear from these spirits again.  They have taken their silver and gone elsewhere."
							)
							((IsFlag 49)
								(Print 104 53) ; "You will have to find a way to appease these Old Ones, Arthur, if you are ever to leave this Tor."
								(Print 104 54) ; "Such beings tend to manifest in some spot where they were once worshipped."
							)
							(else
								(Print 104 55) ; "The "Old Ones" is a name sometimes given to ancient, elemental spirits. Often our ancestors worshipped them as gods, but they are not, though they can be powerful."
							)
						)
					)
					((or (Said '/ones[<old]') (Said '//ones[<old]'))
						(Print 104 56) ; "The Old Ones cannot be seen unless they will it."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((or (Said 'climb<(on,above)/wall,ruin') (Said 'jump/wall,ruin'))
				(Print 104 57) ; "It would be more advisable to go around. In times of danger, it is best to keep both feet on the ground."
			)
			((Said 'listen')
				(if
					(and
						(IsFlag 48)
						(not (IsFlag 49))
						(== global201 gCurRoomNum)
					)
					(Print 104 58) ; "The confusing swish of his robes does nothing to help you."
				else
					(Print 104 59) ; "There is an eerie quality to the wind as it blows through these ruins. Almost like voices chanting."
				)
			)
			((Said 'get/club')
				(cond
					((!= global201 gCurRoomNum)
						(Print 104 47) ; "What club?"
					)
					((IsFlag 49)
						(Print 104 45) ; "The Old Ones took the club along with the Monk's body."
					)
					((IsFlag 48)
						(Print 104 60) ; "You will get it the hard way if you do not defend yourself!"
					)
					(else
						(Print 104 61) ; "Why should you want a club? You have Excaliber."
					)
				)
			)
			((Said 'get/doug')
				(cond
					((IsFlag 49)
						(Print 104 62) ; "He no longer exists on this earth."
					)
					((!= gCurRoomNum global201)
						(Print 104 63) ; "He is not even here."
					)
					((IsFlag 48)
						(Print 104 64) ; "Do something, Arthur, before HE gets YOU!"
					)
					(else
						(Print 104 65) ; "Frankly, I think you would be better off without him."
					)
				)
			)
			((Said 'get/clothes,hood')
				(if (== global201 gCurRoomNum)
					(Print 104 66) ; "Personally, I would touch the Monk's garb as little as possible."
				else
					(event claimed: 0)
				)
			)
			((Said 'get,throw/rubble,boulder,brick')
				(Print 104 67) ; "You should feel no need for anything as common as a rock when you have Excaliber and your shield."
			)
			((Said 'get,find/key')
				(if (gEgo has: 6) ; iron_key | broom | grail
					(Print 104 68) ; "You already have it."
				else
					(Print 104 69) ; "Key? What key?"
				)
			)
			((Said 'get,find/heart')
				(if (gEgo has: 7) ; crystal_heart | charcoal | helm
					(Print 104 68) ; "You already have it."
				else
					(Print 104 70) ; "You must know something I do not know."
				)
			)
			((Said 'apologize,soothe/ones[<old]')
				(Print 104 71) ; "Only they can tell you what will appease them."
			)
			((Said 'use/heart[<crystal]')
				(Print 104 72) ; "Merely possessing the crystal heart has broken the Spell of Circular Entrapment that has kept you trapped upon this Tor."
				(Print 104 73) ; "But it is an object of great power. Keep it safe."
			)
			(
				(and
					(Said 'ask,talk>')
					(Said (if (== global201 gCurRoomNum) '[/doug]>' else '/doug>'))
				)
				(cond
					((IsFlag 48)
						(Print 104 74) ; "You waste your time. The monk truly IS mad!"
						(event claimed: 1)
					)
					((IsFlag 49)
						(Print 104 75) ; "A lot of good that will do you."
						(event claimed: 1)
					)
					((== global201 gCurRoomNum)
						(Print 104 76) ; "He is too busy ranting and raving to talk to you."
						(event claimed: 1)
					)
					((Said '/doug')
						(Print 104 77) ; "There is no monk here."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said '/me/arthur,king')
				(if (== global201 gCurRoomNum)
					(Print 104 78) ; "I do not think the Monk cares very much who you are."
				else
					(event claimed: 0)
				)
			)
			((Said 'smell')
				(if
					(and
						(== global201 gCurRoomNum)
						(not (and (== gCurRoomNum 20) (IsFlag 48)))
					)
					(Print 104 79) ; "He is a pungent fellow."
				else
					(Print 104 80) ; "The Tor smells of crushed grass and misty air."
				)
			)
			((Said '/spring')
				(if (!= gCurRoomNum 20)
					(Print 104 81) ; "The well is elsewhere on the Tor."
				else
					(event claimed: 0)
				)
			)
			((Said 'search/doug,clothes')
				(cond
					((IsFlag 49)
						(Print 104 82) ; "There is nothing left to search."
					)
					((!= global201 gCurRoomNum)
						(Print 104 83) ; "It would help to find the monk first."
					)
					(else
						(Print 104 84) ; "You will never be able to do that while he is alive, I fear."
					)
				)
			)
			((Said 'talk/doug')
				(cond
					((and (IsFlag 48) (!= global201 gCurRoomNum))
						(Print 104 85) ; "What can you hope to hear from a madman? But you may try it when you find him."
					)
					((or (!= global201 gCurRoomNum) (not (IsFlag 58)))
						(Print 104 86) ; "But there is no Monk here."
					)
					((IsFlag 49)
						(Print 104 87) ; "He has nothing to say now that he is dead. Just as well. His conversation was a bit limited."
					)
					(else
						(Talk 104 88) ; "Kill! Kill! Kill!"
					)
				)
			)
			((Said 'give/copper,dirham,dinar,coin,moneybag[/doug]')
				(cond
					((not (DoPurse)) 0)
					((!= global201 gCurRoomNum)
						(proc0_18)
						(Print 104 89) ; "There is no one here."
					)
					((IsFlag 49)
						(proc0_18)
						(Print 104 90) ; "The dead have no use for money."
					)
					((IsFlag 48)
						(proc0_18)
						(Print 104 91) ; "He does not want money. He wants your life."
					)
					(else
						(proc0_18)
						(if (and (< (gEgo x:) 250) (> (gEgo y:) 105))
							(Talk 104 92) ; "You must keep your money. I have taken a monk's vows of poverty."
						else
							(NotClose) ; "Perhaps you should move closer."
						)
					)
				)
			)
			((Said 'draw/blade')
				(event claimed: 1)
			)
		)
	)
)

