;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use n117)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm11 0
	hunter 1
)

(synonyms
	(coin copper dirham dinar)
	(forester man hugo)
)

(local
	local0
)

(instance hunterWindow of SysWindow
	(properties
		color 15
		back 2
		title {Hunter}
		brLeft 10
		brBottom 85
		brRight 180
	)
)

(instance Rm11 of Rm
	(properties
		picture 11
	)

	(method (init)
		(super init:)
		(Load rsVIEW 335)
		(proc0_13 32)
		(gAddToPics doit:)
		(self setRegions: 102) ; forestPerilous
		(if (not (IsFlag 24))
			(gAddToPics add: rack1 rack2 doit:)
			(spearRack setCel: (if (gEgo has: 8) 1 else 0) init: stopUpd:) ; boar_spear | grain | medallion
			(hunter init:)
			(gTObj
				tLoop: 0
				tWindow: hunterWindow
				cSpeed: 2
				actor: hunter
				init:
			)
		)
		(gEgo init:)
		(= local0 0)
		(if (IsFlag 20)
			(gMuleObj init:)
			(if (not (IsFlag 24))
				(gMuleObj setScript: muleRunAway)
			)
		)
		(self setScript: (ScriptID 210 0)) ; EnterRoom
	)

	(method (doit)
		(super doit:)
		(cond
			((> (gEgo x:) 315)
				(SetFlag 32)
				(gCurRoom newRoom: 10)
			)
			((< (gEgo x:) 10)
				(SetFlag 32)
				(gCurRoom newRoom: 12)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(== (event type:) evMOUSEBUTTON)
				(& (event modifiers:) emSHIFT)
				(gCast contains: hunter)
			)
			(cond
				((and (IsItemAt 8) (OnButton event 218 85 221 124)) ; boar_spear | grain | medallion
					(Print 11 0) ; "There is a spear leaning on the rack behind the Hunter."
				)
				((MouseClaimed hunter event)
					(Print 11 1) ; "From the simplicity of the Hunter's clothing and his worn face, I would say that he is a poor man."
				)
				((MouseClaimed spearRack event)
					(Print 11 2) ; "It is a makeshift rack."
				)
				(
					(or
						(OnButton event 135 103 180 116)
						(OnButton event 246 93 291 107)
					)
					(Print 11 3) ; "The hunter has several pelts drying upon simple racks made of sticks."
				)
				(
					(or
						(OnButton event 60 169 143 182)
						(OnButton event 128 144 169 182)
						(OnButton event 169 149 206 182)
						(OnButton event 205 163 255 181)
						(OnButton event 237 153 279 163)
						(OnButton event 259 148 310 156)
						(OnButton event 285 129 310 149)
						(OnButton event 63 120 72 130)
						(OnButton event 95 120 128 130)
					)
					(Print 11 4) ; "'Tis a rock."
				)
				(
					(or
						(OnButton event 8 20 25 169)
						(OnButton event 25 7 68 59)
						(OnButton event 22 57 47 166)
						(OnButton event 54 56 71 94)
						(OnButton event 80 50 140 85)
						(OnButton event 89 87 116 105)
						(OnButton event 51 7 295 49)
						(OnButton event 227 20 310 69)
						(OnButton event 282 63 310 115)
					)
					(Print 11 5) ; "'Tis a tree."
				)
				(
					(or
						(OnButton event 150 57 206 111)
						(OnButton event 203 67 285 105)
					)
					(Print 11 6) ; "'Tis a bush."
				)
			)
		)
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
					(
						(or
							(Said '/spear,weapon,(rack<spear)')
							(Said '//spear,weapon,(rack<spear)')
						)
						(cond
							((IsFlag 30)
								(Print 11 7) ; "Did you expect the spear to be here? You were warned that it could not leave the forest."
							)
							((IsFlag 24)
								(Print 11 8) ; "The spear remains wedged in the carcass of the boar."
							)
							((gEgo has: 8) ; boar_spear | grain | medallion
								(event claimed: 0)
							)
							(else
								(Print 11 0) ; "There is a spear leaning on the rack behind the Hunter."
							)
						)
					)
					(
						(and
							(not (IsFlag 31))
							(or (Said '/gawain') (Said '//gawain'))
						)
						(Print 11 9) ; "He is clearly not here."
					)
					((Said '//brownie,creature')
						(Print 11 10) ; "It would be best to avoid the creature, unless you have copper or tin to give it."
					)
					(
						(or
							(Said 'look[/room,forest][/!*]')
							(Said 'ask//room,forest')
						)
						(cond
							((not (IsFlag 32))
								(Print 11 11) ; "In this small clearing, a Hunter has set up his skins on racks to dry. Next to him are three spears. He is a bold man or a desperate one to seek his living in the Forest Perilous."
							)
							((gCast contains: hunter)
								(Print 11 12) ; "It is the same as when you passed through here before. The Hunter is still here with his spears and his skins."
							)
							(else
								(Print 11 13) ; "This clearing seems larger without the Hunter in it."
							)
						)
					)
					((or (Said '/fur,rack,stick') (Said '//fur,rack,stick'))
						(if (gCast contains: hunter)
							(Print 11 3) ; "The hunter has several pelts drying upon simple racks made of sticks."
						else
							(Print 11 14) ; "The Hunter has left and taken everything with him."
						)
					)
					((gCast contains: hunter) 0)
					((or (Said '/forester') (Said '//forester'))
						(Print 11 15) ; "Like a true man of the forest, he has vanished leaving no trace that he was ever here."
					)
					((or (Said '/lance') (Said '//lance'))
						(Print 11 16) ; "There is no lance here, nor did the Hunter have one."
					)
					((Said '//boar,doug,knight,crone')
						(Print 11 17) ; "Your best source of such information, the Hunter, is now gone."
					)
				)
			)
			((Said 'use/rose,crystal,sleeve')
				(Print 11 18) ; "There is no use for it here."
			)
			((Said 'use,throw,draw/spear')
				(if (gEgo has: 8) ; boar_spear | grain | medallion
					(Print 11 19) ; "If you are threatened by a boar, that will be the time to make use of it."
				else
					(Print 11 20) ; "You cannot use what you do not have."
				)
			)
			((Said 'appropriate,grab,rob/spear,fur,forester')
				(Print 11 21) ; "You are talking nonsense."
			)
			((or (Said 'get/piss,leak') (Said 'piss,shit,urinate,shit'))
				(Print 11 22) ; "I am sure you will find a likely bush somewhere in the forest for that."
			)
			((gCast contains: hunter) 0)
			((Said '/me/((arthur<king),king,arthur,ruler,pendragon)<am')
				(Print 11 23) ; "I know who you are, Arthur."
			)
			((Said 'collect/tax')
				(Print 11 24) ; "I did not know that trees could pay taxes."
			)
			((Said 'give,sell,bargain/ass')
				(if (IsFlag 20)
					(Print 11 25) ; "There is no one here save you and the mule."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'get/coin')
				(Print 11 26) ; "From whom? There is no-one here."
			)
			((Said 'talk[/forester]')
				(Print 11 27) ; "Difficult, since he is not here."
			)
			((Said 'smell/forester')
				(Print 11 28) ; "He is no longer here, though a trace of him does linger on."
			)
			((or (Said 'give/coin') (Said 'pay/forester,coin'))
				(event claimed: 0)
			)
			((Said '*/forester')
				(Print 11 29) ; "But the Hunter is gone."
			)
		)
	)
)

(instance muleRunAway of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (< (gEgo x:) 200)
			(gMuleObj setScript: (ScriptID 210 1)) ; RunAway
		)
	)
)

(instance DrawSword of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(Talk 11 30) ; "Is something wrong, m'lord?"
				(= global125 2)
			)
			(1
				(gTObj talkCue: self)
				(Talk 11 31) ; "I sense no danger here, but you are wise to be at readiness at all times in this forest."
			)
			(2
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance HunterGetSpear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo illegalBits: 0 ignoreActors: 1)
				(cond
					((gEgo inRect: 0 113 99 125)
						(gEgo setMotion: MoveTo (gEgo x:) 125 self)
					)
					((gEgo inRect: 0 126 100 139)
						(gEgo setMotion: MoveTo (gEgo x:) 140 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(if (and (== (gEgo x:) 217) (== (gEgo y:) 122))
					(= cycles 1)
				else
					(gEgo setMotion: MoveTo 217 122 self)
				)
			)
			(3
				(hunter loop: 2 cel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(4
				(gTObj actor: 0 talkCue: self)
				(Talk 11 32 11 33) ; "The staff of this boar spear is made of the sacred oak and the spearhead forged by the Black Knight himself."
			)
			(5
				(gEgo setMotion: MoveTo 215 122 self)
			)
			(6
				(hunter loop: 0 cel: 0)
				(gTObj actor: hunter)
				(Talk 11 34) ; "'Tis done. But be warned, m'lord, the spear draws its power from the Forest itself and cannot be taken away from it."
				(gEgo
					illegalBits: -32768
					ignoreActors: 0
					get: 8 ; boar_spear | grain | medallion
					setScript: 0
				)
				(SetFlag 21)
				(SetScore 246 0 3)
				(HandsOn)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== (hunter loop:) 2) (== (hunter cel:) 6))
			(spearRack setCel: 1)
		)
		(if (and (== (hunter loop:) 2) (== (hunter cel:) 5))
			(spearRack setCel: 0)
		)
	)
)

(instance hunter of Prop
	(properties
		view 335
	)

	(method (init)
		(super init:)
		(self setLoop: 0 posn: 212 116)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (& (event modifiers:) emSHIFT))
			(return)
		)
		(cond
			((or (Said 'ask/name') (Said 'ask[/forester]/name'))
				(Talk 11 35) ; "I am called Hugo the Bold."
			)
			((or (Said 'look/forester') (Said 'ask/merlin/forester'))
				(Print 11 1) ; "From the simplicity of the Hunter's clothing and his worn face, I would say that he is a poor man."
			)
			((Said 'ask/merlin/gawain')
				(Print 11 36) ; "Ask the Hunter."
			)
			((Said 'ask/merlin/boar,doug,knight,crone')
				(Print 11 37) ; "The Hunter would likely know more than I."
			)
			((or (Said 'ask[/forester]/*>') (Said 'are<where/*>'))
				(cond
					((or (Said '/spear,weapon') (Said '//spear,weapon'))
						(Talk 11 38) ; "This boar spear once belonged to the Black Knight and is powerful enough to kill even the giant boars of this Forest. He has laid an enchantment on it so that it belongs to the Forest and cannot be taken from here."
					)
					((or (Said '/family') (Said '//family'))
						(Talk 11 39) ; "We are very poor and I have five children to feed."
					)
					((or (Said '/lance') (Said '//lance'))
						(Talk 11 40) ; "I have no lances, only my spears."
					)
					((or (Said '/fur') (Said '//fur'))
						(Talk 11 41) ; "You see the results of many weary days of work, m'lord -- hare, fox and squirrel pelts."
					)
					((or (Said '/rack') (Said '//rack'))
						(Talk 11 42) ; "I notch together branches and sticks and use them for drying skins."
					)
					((or (Said '/ass') (Said '//ass'))
						(if (IsFlag 20)
							(Talk 11 43) ; "That is a most unhappy looking mule you have, m'lord."
						else
							(Talk 11 44) ; "I fear the danger of the forest was too much for it. That is one reason I never bring a pack animal with me."
						)
					)
					((Said '//brownie,creature')
						(Talk 11 45) ; "Aye, it is a noxious pest. I give it bits of tin to keep it happy."
					)
					(
						(Said
							'/forester/cernnunnos,(god[<chase,fertility,celt,celt])'
						)
						(Talk 11 46) ; "Cernunnos is the God of the Hunt."
					)
					((not global221)
						(event claimed: 1)
						(Talk 11 47) ; "Even one copper coin would be of much use to me, sire, and help greatly to loosen my tongue."
					)
					((Said '[/forester]/forest')
						(Talk 11 48) ; "The forest is full of terrible dangers. I survive by remaining carefully upon the outskirts of it."
					)
					((Said '[/forester]/knight<black')
						(SetScore 248 1 1)
						(Talk 11 49) ; "He is a part of this forest, binding its power to him with dark magicks. You must face his challenge, m'lord, if you wish to reach the Tor."
					)
					((Said '[/forester]/knight')
						(Talk 11 50) ; "Which knight, m'lord?"
					)
					((Said '[/forester]/gawain')
						(Talk 11 51 11 52) ; "Aye, that goodly knight came this way and rode on into the Forest to reach the Tor where he hoped to find the Grail."
					)
					((Said '[/forester]/lancelot,galahad')
						(Talk 11 53) ; "I know nothing of him, m'lord."
					)
					((Said '[/forester]/grail,legend,arimathea')
						(Talk 11 54 11 55) ; "The local legend goes that Joseph of Arimathea brought the holy cup here from Jerusalem and hid it upon Glastonbury Tor. That is all I know of it."
					)
					((Said '[/forester]/doug,glastenbury,slab')
						(Talk 11 56) ; "Sire, a strange monk has taken up residence in the ruins atop Glastonbury Tor. He has surrounded the base of the Tor with a sorcerous barrier and stones that speak!"
					)
					((Said '[/forester]/boar')
						(Talk 11 57) ; "The giant boars of this forest are especially dangerous. Only a boar spear of the greatest strength is effective against them."
					)
					((Said '[/forester]/crone')
						(Talk 11 58) ; "Aye, there is a dreadful hag that turns men to stone. Beware of her."
					)
					((Said '[/forester]/knight<dead')
						(Talk 11 59) ; "The bones of knights vanquished by the Black Knight are often left in the forest as a warning. I pray yours will not be amongst them."
					)
					((Said '[/forester]/*')
						(Talk 11 60) ; "Nothing I can tell you about that would be of value to you, m'lord."
					)
				)
			)
			((Said 'get/coin')
				(if global221
					(Print 11 61) ; "What a mean and petty demand for a king to make. Leave such venal matters to your tax collectors."
				else
					(Talk 11 62) ; "Forgive me, m'lord, but the tax collector came by last week and took my last copper coin."
				)
			)
			((Said 'collect/tax')
				(Print 11 63) ; "Leave that to the tax collectors, Arthur. It is far beneath your dignity to do such a job."
			)
			((Said 'hello,hello')
				(Talk 11 64) ; "A strange word, m'lord. I do not understand its meaning."
			)
			((Said 'greet,greet')
				(Talk 11 65) ; "Tis an honor to be acknowledged by you, m'lord."
			)
			((Said '/me/((arthur<king),king,arthur,ruler,pendragon)<am')
				(gTObj preLoop: 1)
				(Talk 11 66) ; "Aye, m'lord. So I judged from your royal bearing, magnificent horse, and the symbol of Pendragon upon your shield."
			)
			((Said 'talk[/forester]')
				(if global221
					(Talk 11 67) ; "Having spoken with Sir Gawaine, I know something of what you seek. You have but to ask and I will gladly share what I know, especially about the Mad Monk of Glastonbury and the Grail."
				else
					(Talk 11 68) ; "I am but a poor man, m'lord, but perhaps in some small way I may be of service to you. Aye, tis a hard life in the forest to earn a few thin coins to feed my family."
				)
			)
			((Said 'smell/forester')
				(Print 11 69) ; "He is a good fellow, but smells a bit gamy."
			)
			((Said 'help/forester')
				(Print 11 70) ; "From the impoverished look of him, that might best be accomplished by giving him money."
			)
			((Said 'draw/blade')
				(hunter setScript: DrawSword)
			)
			((Said 'kill,cut,attack,hit,hit/forester')
				(Print 11 71) ; "You have no cause to attack his man. If you are angry for some reason, look to your own faults and remember that a king must set an example by his behavior."
			)
			((Said 'kiss,hug,fuck,fuck/forester')
				(Talk 11 72) ; "By Cernunnos, I am a true man, not a bloody courtier!"
			)
			((Said 'piss,shit<on/forester')
				(Talk 11 73) ; "I may be a loyal servant, but if you dare to insult me in such a fashion, you may find an intimate portion of yourself skinned and hung to dry!"
			)
			(
				(or
					(Said 'get,drop<in/fur/pack')
					(Said 'get<along/fur')
					(Said 'get/fur/me<with')
					(Said 'give/fur<me')
					(Said 'give<to/fur/me')
					(Said 'drop<on/fur/charger')
				)
				(if (IsFlag 22)
					(Print 11 74) ; "There is no room in your pack. The Hunter has sworn to deliver them to Camelot and that is good enough."
				else
					(Print 11 75) ; "They do not belong to you."
				)
			)
			((Said 'appropriate,grab,rob/spear')
				(if (gEgo has: 8) ; boar_spear | grain | medallion
					(Talk 11 76) ; "But, m'lord, you already have the spear."
				else
					(Print 11 77) ; "You are the king, Arthur, not some common bandit. The Hunter seems a reasonable man. Obtain the spear in a manner that befits you."
				)
			)
			((Said 'appropriate,grab,rob/fur,dagger,blade,forester,possession')
				(Print 11 78) ; "What rubbish is this? You are a king. Behave like one."
			)
			((Said 'get,buy>')
				(= local0 0)
				(cond
					((Said '/tin')
						(Talk 11 79) ; "I gave my last bit of tin to Widdershins."
					)
					((Said '/rack')
						(Talk 11 80) ; "My racks are but a few branches notched together. Nothing of worth to you, m'lord."
					)
					((Said '/dagger')
						(Talk 11 81) ; "As you have guessed, I do carry a knife for hunting and skinning, but I could not part with it and still practice my trade."
					)
					((Said '/fur')
						(cond
							((IsFlag 22)
								(Talk 11 82) ; "They are yours, m'lord. I will deliver them to Camelot for you, by my oath as your loyal man."
							)
							((>= global221 5)
								(Talk 11 83 11 84) ; "You have generously given me the price of the skins already, m'lord. Consider them yours."
								(SetScore 245 2 2)
								(SetFlag 22)
							)
							(else
								(Talk 11 85) ; "I would be happy to sell them to you, m'lord, for but a single silver coin."
								(= local0 1)
							)
						)
					)
					((Said '/spear')
						(cond
							((gEgo has: 8) ; boar_spear | grain | medallion
								(Talk 11 76) ; "But, m'lord, you already have the spear."
							)
							((>= global221 25)
								(HandsOff)
								(hunter setScript: HunterGetSpear)
								(gTObj preLoop: 1 talkCue: HunterGetSpear)
								(Talk 11 86) ; "You have been more than generous to me. Allow me to give the spear to you."
							)
							(else
								(Talk 11 87) ; "I would sell this spear to no other man save you, m'lord. Forgive my audacity, but the spear is of such value, I could not part with it for less than the price of a gold coin."
								(= local0 2)
							)
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((or (Said 'pay[/forester,coin]/fur') (Said 'pay/fur'))
				(= local0 1)
				(if (DoPurse)
					(gEgo setScript: GiveMoney)
				)
			)
			((or (Said 'pay[/forester,coin]/spear') (Said 'pay/spear'))
				(= local0 2)
				(if (DoPurse)
					(gEgo setScript: GiveMoney)
				)
			)
			((Said 'pay[/forester,coin]')
				(cond
					((not local0)
						(Talk 11 88) ; "But sire, you have not asked to buy anything from me."
					)
					((DoPurse)
						(gEgo setScript: GiveMoney)
					)
				)
			)
			((Said 'sell,give,bargain/>')
				(cond
					((Said '/moneybag,moneybag')
						(Talk 11 89) ; "Your entire purse, m'lord? I could not! I am not a greedy man, only a needy one."
					)
					((Said '/shield,tunic,armor,armor,scabbard')
						(Talk 11 90) ; "I am not a man of war. Such things are not for me."
					)
					((Said '/blade,excaliber,weapon,blade')
						(Talk 11 91) ; "I would not dare to even lay hands upon it!"
					)
					((Said '/charger')
						(if (== global116 0)
							(Talk 11 92) ; "I beg your pardon, sire, but I see no horse."
						else
							(Talk 11 93) ; "A noble offer! Yet as a poor man, I could never afford to care for such a huge beast."
						)
					)
					((Said '/ass')
						(if (IsFlag 20)
							(Talk 11 94) ; "I have never been fond of mules since I was badly bitten by one. I beg you to keep it."
						else
							(Talk 11 95) ; "Even if you find the mule, what use would I have for a creature that would run away when I enter the Forest?"
						)
					)
					((Said '/gear,bridle')
						(if (== global116 0)
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						else
							(Talk 11 96) ; "Without a horse, m'lord, such things are of no use to me."
						)
					)
					((Said '/pack,food,water,clothes,blanket,pack')
						(Talk 11 97) ; "Your generosity is a credit to your name, but you will need it more than I."
					)
					((Said '/rose')
						(if (gEgo has: 4) ; rose | apple | green_apple
							(Talk 11 98) ; "Tis a lovely thing, but of no use to me."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/lodestone')
						(if (gEgo has: 2) ; lodestone
							(Talk 11 99) ; "I have heard of such wondrous things, but I will not touch it, thank you all the same."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/sleeve')
						(if (gEgo has: 5) ; sleeve | elixir
							(Talk 11 100) ; "Nay, pardon me, but I shall not touch this lady's sleeve. It belongs to a man who died for her love at the hands of the Black Knight and I would not disturb his ghost."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/spear')
						(if (gEgo has: 8) ; boar_spear | grain | medallion
							(Talk 11 101) ; "Nay, m'lord. It is yours now. May it serve you well."
						else
							(event claimed: 0)
						)
					)
					((Said '/*/rack')
						(Talk 11 102) ; "My racks are naught but a few branches notched together. Nothing of worth to you, m'lord."
					)
					((Said '/coin,(bargain<legal)>')
						(cond
							((not (gEgo has: 3)) ; purse
								(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
								(event claimed: 1)
							)
							((not (DoPurse))
								(event claimed: 1)
							)
							((Said '//fur')
								(= local0 1)
								(gEgo setScript: GiveMoney)
							)
							((Said '//spear')
								(= local0 2)
								(gEgo setScript: GiveMoney)
							)
							(else
								(event claimed: 1)
								(gEgo setScript: GiveMoney)
							)
						)
					)
					((Said '/*/fur')
						(Talk 11 103 11 104) ; "Though I love to barter as much as the next man, I sense that your mission is important and you are anxious to ride on."
					)
					((Said '[/!*][/!*]')
						(Talk 11 105) ; "I am open to offers, m'lord, if you can but make them clear to my simple mind."
					)
					((Said '*/forester')
						(Print 11 106) ; "Why, m'lord?"
					)
					((Said '/*[/forester]')
						(Talk 11 107) ; "For what, m'lord?"
					)
					(else
						(Print 11 108) ; "Why would you want to do that?"
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance GiveMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors: 1)
				(cond
					((gEgo inRect: 0 113 99 125)
						(gEgo setMotion: MoveTo (gEgo x:) 125 self)
					)
					((gEgo inRect: 0 126 100 139)
						(gEgo setMotion: MoveTo (gEgo x:) 140 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(if (and (== (gEgo x:) 217) (== (gEgo y:) 122))
					(= cycles 1)
				else
					(gEgo setMotion: MoveTo 217 122 self)
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(gTObj talkCue: self noWidth: 1)
				(switch local0
					(1
						(if (>= global132 5)
							(= local0 0)
							(+= global221 global132)
							(= global132 0)
							(Talk 11 109) ; "Thank you, m'lord! And by my word as your loyal man, I will deliver them personally to Camelot."
							(SetScore 245 2 2)
							(SetFlag 22)
						else
							(Talk 11 110) ; "With all respect, sire, this is not quite enough."
							(proc0_18)
						)
					)
					(2
						(if (>= global132 25)
							(HandsOff)
							(+= global221 global132)
							(= global132 0)
							(= local0 0)
							(hunter setScript: HunterGetSpear)
							(gTObj preLoop: 1 talkCue: HunterGetSpear)
							(Talk 11 111) ; "Bless you, m'lord! I will fetch the spear."
						else
							(Talk 11 110) ; "With all respect, sire, this is not quite enough."
							(proc0_18)
						)
					)
					(0
						(SetScore 247 2 3)
						(cond
							((>= global132 25)
								(gTObj preLoop: 1)
								(Talk 11 112) ; "I--I am nearly speechless at such a gift! A thousand blessings upon you! My family and I will pray for you every night and light candles in your name at church."
							)
							((>= global132 5)
								(gTObj preLoop: 1)
								(Talk 11 113) ; "Bless you, m'lord, bless you! I shall sing your praises to every man I meet!"
							)
							(else
								(Talk 11 114) ; "May Cernunnos, God of the Hunt, bless you! If there is any advice I may give you, you have but to ask. And heed this warning: beware the Mad Monk of Glastonbury!"
							)
						)
					)
				)
				(+= global221 global132)
				(= global132 0)
			)
			(4
				(HandsOn)
				(gEgo illegalBits: -32768 ignoreActors: 0)
				(self dispose:)
			)
		)
	)
)

(instance spearRack of Prop
	(properties
		view 335
	)

	(method (init)
		(super init:)
		(self setLoop: 6 posn: 215 115)
	)
)

(instance rack1 of PV
	(properties
		y 111
		x 270
		view 335
		loop 4
		signal -32735
	)
)

(instance rack2 of PV
	(properties
		y 120
		x 157
		view 335
		loop 5
		signal -32735
	)
)

