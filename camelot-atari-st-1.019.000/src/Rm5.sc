;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use n117)
(use Interface)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm5 0
)

(synonyms
	(chest box)
	(treasurer man)
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(= global122 0)
	(= global121 0)
	(= global120 0)
	(= global123 0)
)

(instance torch of Prop
	(properties)
)

(instance mouse of Act
	(properties)
)

(instance treasWindow of SysWindow
	(properties
		color 15
		back 2
		title {Treasurer}
		brLeft 160
		brBottom 80
	)
)

(instance roomBlock of Cage
	(properties
		top 5
		left -5
		bottom 200
		right 325
	)
)

(instance clinkSound of Sound
	(properties)
)

(instance Rm5 of Rm
	(properties
		picture 5
	)

	(method (init)
		(Load rsVIEW 105)
		(super init:)
		(gEgo
			view: (if (IsFlag 3) 0 else 2)
			posn: 150 170
			init:
			observeBlocks: roomBlock
			setScript: stairScript
		)
		(stairScript changeState: 1)
		(torch
			view: 105
			loop: 0
			cel: 1
			posn: 176 48
			setCycle: Fwd
			cycleSpeed: global103
			init:
		)
		(mouse
			view: 105
			setLoop: 2
			cel: 0
			illegalBits: 0
			posn: 68 134
			setPri: 9
			init:
			setScript: mouseRuns
			hide:
		)
		(treasurer view: 105 loop: 4 illegalBits: 0 init:)
		(gTObj
			tWindow: treasWindow
			tLoop: 3
			cSpeed: 2
			actor: treasurer
			init:
		)
		(clinkSound number: (proc0_20 21))
		(proc0_13 258)
		(gAddToPics doit:)
		(gCurRoom setScript: treasurerActions)
	)

	(method (doit)
		(super doit:)
		(if (and (& (gEgo onControl: 1) $2000) (== (gEgo script:) 0))
			(gEgo setScript: stairScript)
			(stairScript changeState: 3)
		)
	)

	(method (handleEvent event)
		(treasurer handleEvent: event)
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
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(Print 5 0) ; "I am certain that if you talk to your Treasurer or question him correctly, you will learn all you need."
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(= local1 0)
				(cond
					(
						(and
							(Said 'ask,(are<where)>')
							(Said '[/merlin]/coin,advice')
						)
						(Print 5 1) ; "Remember, 25 copper coins equals 5 silver coins and 5 silver coins equals one gold coin."
					)
					((or (Said '/floor') (Said '//floor') (Said 'look<down'))
						(Print 5 2) ; "It is made of heavy oak planks, with a trapdoor for the only entrance."
					)
					(
						(or
							(Said 'look[/!*][/!*]')
							(Said 'look/room,stronghold,treasury')
						)
						(Print 5 3) ; "This tower stronghold was built to protect your store of coins and other valuables. The bundles on the right are new, however."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 5 4) ; "They are made of the same grey stone as the rest of Camelot. Only thicker."
					)
					((or (Said '/camelot,castle') (Said '//camelot,castle'))
						(Print 5 5) ; "You cannot see much of it from this tower stronghold."
					)
					((or (Said '/door') (Said '//door'))
						(Print 5 6) ; "The trap door is heavy and easily defended."
					)
					(
						(or
							(Said '/torch,fire')
							(Said '//torch,fire')
							(OnButton event 174 15 198 53)
						)
						(Print 5 7) ; "Aye, 'tis a torch."
					)
					((or (Said '/treasure') (Said '//treasure'))
						(Print 5 8) ; "The huge jars contain your entire wealth of gold, silver and copper coins. The chests contain other forms of wealth. I do not know what is in the bundles."
					)
					(
						(or
							(Said '/column')
							(Said '//column')
							(OnButton event 32 7 68 153)
							(OnButton event 70 7 94 99)
							(OnButton event 224 7 247 102)
							(OnButton event 249 7 287 156)
						)
						(Print 5 9) ; "The pillars of this tower are quite strong and thick."
					)
					(
						(or
							(Said '/bundle')
							(Said '//bundle')
							(OnButton event 235 101 310 143)
						)
						(Print 5 10) ; "They are bundles that are stored here."
					)
					(
						(or
							(Said '/stair')
							(Said '//stair')
							(OnButton event 139 107 184 138)
						)
						(Print 5 11) ; "They lead down to the main floor of Camelot."
					)
					(
						(or
							(Said '/chest,chest,treasure,gem,goblet,plate')
							(Said '//chest,chest,treasure,gem,goblet,plate')
							(OnButton event 9 95 100 125)
						)
						(Print 5 12) ; "The chests contain gems and jewels set in gold and silver, plates and goblets of gold and silver and other such fine items."
					)
					(
						(or
							(MouseClaimed treasurer event)
							(Said 'look/treasurer')
							(Said 'ask//treasurer')
						)
						(Print 5 13) ; "He is a powerfully built man, well able to defend this tower and your treasure. Heed his advice."
					)
					((or (Said 'look/dinar') (OnButton event 146 62 172 90))
						(Print 5 14) ; "There is gold in the jar on the right."
					)
					((or (Said 'look/dirham') (OnButton event 125 64 149 94))
						(Print 5 15) ; "There is silver in the middle jar."
					)
					((or (Said 'look/copper') (OnButton event 97 67 125 95))
						(Print 5 16) ; "There is copper in the leftmost jar."
					)
					((or (Said '/barrel,jar,pot') (Said '//barrel,jar,pot'))
						(Print 5 17) ; "The three large jars contain gold, silver, and copper coins."
					)
					(
						(or
							(Said '/blade[<treasurer]')
							(Said '//blade[<treasurer]')
						)
						(Print 5 18) ; "Your treasurer has a huge sword and knows how to use it."
					)
				)
			)
			((Said 'smell')
				(Print 5 19) ; "In this enclosed room, the odor of a sweaty man, oily torch, and cold metal is most concentrated."
			)
			((Said 'get,open/bag')
				(Print 5 20) ; "Arthur, you are here to prepare for your journey, not to play with trinkets of wealth."
			)
			((Said 'open/door')
				(Print 5 21) ; "The trap door is already open."
			)
			((Said '(drop<out),douse/torch,fire')
				(Print 5 22) ; "That is the Treasurer's only source of light."
			)
			((and (IsItemAt 3) (Said 'open/moneybag')) ; purse
				(Print 5 23) ; "You could, if you were holding it."
			)
			((Said 'use/lodestone')
				(if (gEgo has: 2) ; lodestone
					(Print 5 24) ; "There is too much metal all around and it confuses the workings of the lodestone."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'get/torch')
				(Print 5 25) ; "The Treasurer needs it more than you do."
			)
			((Said 'annihilate/seal')
				(Print 5 26) ; "You have no business doing that until you know Gawaine is dead."
			)
			((and (Said '<ham>') (Said '<jam>') (Said '<spam>') (Said '/land'))
				(gEgo setScript: Camelot_)
			)
		)
	)
)

(instance mouseRuns of Script
	(properties)

	(method (init)
		(super init:)
		(= seconds (Random 15 40))
		(if (not global103)
			(= seconds 0)
		)
		(= register 0)
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
			((Said '/mice,rat>')
				(cond
					((not local3)
						(event claimed: 1)
						(Print 5 27) ; "I am sure you could find one anywhere in Camelot if you looked hard enough."
					)
					((Said 'look')
						(Print 5 28) ; "When you have seen one rodent, you have seen them all."
					)
					((Said 'get,capture')
						(Print 5 29) ; "You have more important things to think about."
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(mouse
					view: 105
					setLoop: 2
					cel: 0
					posn: 68 134
					priority: 9
					show:
				)
				(= local3 1)
				(= cycles (Random 3 30))
			)
			(2
				(mouse cel: 2 posn: 84 134)
				(= cycles 2)
			)
			(3
				(mouse cel: 3 posn: 104 134)
				(= cycles 2)
			)
			(4
				(mouse cel: 4 posn: 110 134)
				(= cycles 2)
			)
			(5
				(mouse cel: 5 posn: 115 138)
				(= cycles 2)
			)
			(6
				(mouse cel: 6 posn: 115 137)
				(= cycles 2)
			)
			(7
				(mouse hide:)
				(= seconds (Random 20 60))
				(if (< (++ register) 4)
					(= state 0)
				)
			)
		)
	)
)

(instance treasurerActions of Script
	(properties)

	(method (init)
		(super init:)
		(treasurer
			cycleSpeed: global103
			moveSpeed: 2
			setStep: 4 1
			setLoop: 4
			posn: 129 68
		)
	)

	(method (handleEvent event)
		(= local1 1)
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
			((Said 'hello')
				(Talk 5 30) ; "Is this some sort of odd Pictish word?"
			)
			(
				(or
					(Said 'get/coin<all')
					(and
						(Said 'get/copper>')
						(or (Said 'get/dirham') (Said 'get/dinar'))
					)
					(and
						(Said 'get/dirham>')
						(or (Said 'get/copper') (Said 'get/dinar'))
					)
					(and
						(Said 'get/dinar>')
						(or (Said 'get/copper') (Said 'get/dirham'))
					)
				)
				(Talk 5 31) ; "Which one first, m'lord?"
			)
			((Said '[get]/tin,(coin<tin)')
				(Talk 5 32) ; "Coins of tin? Never heard'o such a thing."
			)
			((Said '[get]/aluminum,(coin<aluminum)')
				(Talk 5 33) ; "We have no coins made of bronze, sire."
			)
			(
				(Said
					'[get]/dinar,(coin<dinar),dirham,(coin<dirham),copper,(coin<copper)>'
				)
				(cond
					((and (gEgo has: 3) (or global120 global121 global122)) ; purse
						(event claimed: 1)
						(Talk 5 34) ; "You have coins already, my king, but if you wish to change them, please give me the purse."
					)
					((not (IsItemAt 3)) ; purse
						(event claimed: 1)
						(Talk 5 35) ; "Aye, gladly, if you will but provide me with the purse to fill."
					)
					((== global123 3)
						(event claimed: 1)
						(Talk 5 36) ; "Your purse is full, my liege."
					)
					((Said '/copper,(coin<copper)')
						(SetScore 235 0 1 1 1)
						(self changeState: 7)
					)
					((Said '/dirham,(coin<dirham)')
						(SetScore 234 0 1 1 1)
						(self changeState: 1)
					)
					((Said '/dinar,(coin<dinar)')
						(SetScore 233 0 1 1 1)
						(self changeState: 4)
					)
				)
			)
			((Said 'look<in/moneybag')
				(event claimed: 0)
			)
			((Said 'get/moneybag')
				(cond
					((gEgo has: 3) ; purse
						(if (== global122 global121 global120 0)
							(Talk 5 37) ; "I have no purse to give you. If you have brought your own, I can fill it for you."
						else
							(Talk 5 38) ; "But you have it, sire."
						)
					)
					((not (IsItemAt 3)) ; purse
						(Talk 5 39) ; "I have no purse to give you, m'lord."
					)
					((not (gEgo inRect: 100 70 180 106))
						(Talk 5 40) ; "You must come closer, m'lord."
					)
					((and (== global122 0) (== global121 0) (== global120 0))
						(Talk 5 41) ; "Here you are, m'lord, but the purse is empty. I beg you to let me fill it for you ere you go."
						(gEgo get: 3) ; purse
						(SetMenu 1281 112 1)
					)
					((!= global123 3)
						(Talk 5 42) ; "There is room for more, m'lord, but here it is, as you command."
						(gEgo get: 3) ; purse
						(SetMenu 1281 112 1)
						(SetFlag 0)
					)
					(else
						(Talk 5 43) ; "Here it is, m'lord, as you command."
						(gEgo get: 3) ; purse
						(SetMenu 1281 112 1)
						(SetFlag 0)
					)
				)
			)
			((Said 'rob/dinar,dirham,copper,coin')
				(Talk 5 44) ; "Steal? But, my lord, it is already yours."
			)
			((or (Said 'get/coin') (Said 'fill/moneybag'))
				(cond
					((gEgo has: 3) ; purse
						(if (== global122 global121 global120 0)
							(Talk 5 35) ; "Aye, gladly, if you will but provide me with the purse to fill."
						else
							(Talk 5 45) ; "But, m'lord, you have coins in your purse. Still, if you wish to change what you have, you have but to give me the purse again."
						)
					)
					((not (IsItemAt 3)) ; purse
						(Talk 5 35) ; "Aye, gladly, if you will but provide me with the purse to fill."
					)
					((!= global123 3)
						(Talk 5 46) ; "What coins would you be wantin', m'lord?"
					)
					(else
						(switch local0
							(0
								(Talk 5 47) ; "Your purse is full and I have no other purses or bags to fill."
							)
							(1
								(Talk 5 48) ; "Travelling with bulging moneybags would only bring bandits and outlaws down upon you like a plague of locusts."
							)
							(else
								(Print 5 49) ; "Take your purse and cease badgering your Treasurer. He is wise in these matters and greed does not become a King."
							)
						)
						(++ local0)
					)
				)
			)
			((Said 'give/moneybag')
				(cond
					((IsItemAt 3) ; purse
						(Talk 5 50) ; "I have it in hand, m'lord. I await your commands."
					)
					((not (gEgo has: 3)) ; purse
						(Print 5 51) ; "You do not have the purse with you, Arthur."
					)
					((not (gEgo inRect: 100 70 180 106))
						(Talk 5 40) ; "You must come closer, m'lord."
					)
					(else
						(if (== global122 global121 global120 0)
							(Talk 5 52) ; "Thank you, m'lord. I shall fill it according to your wishes."
						else
							(Talk 5 53) ; "I have emptied the purse, so we may begin again. What is your command?"
						)
						(localproc_0)
						(PutItem 3) ; purse
						(SetMenu 1281 112 0)
					)
				)
			)
			((or (Said 'give/coin,dinar,dirham,copper') (Said 'tip/treasurer'))
				(cond
					((gEgo has: 3) ; purse
						(cond
							((not (DoPurse)) 0)
							(global132
								(Talk 5 54) ; "No need to give me money, m'lord. You reward me well enough."
								(proc0_18)
							)
							(else
								(Print 5 55) ; "You must get money before you can give money."
							)
						)
					)
					((not (IsItemAt 3)) ; purse
						(Print 5 56) ; "If you had a purse, you would be able to acquire money to give away."
					)
					((== global122 global121 global120)
						(Talk 5 57) ; "I am the one who should be giving you money, m'lord. What are your commands?"
					)
					(else
						(Talk 5 58) ; "I have no need to take any for myself. You reward me well enough already."
					)
				)
			)
			(
				(or
					(Said
						'change,bargain,replace,remove/coin,dinar,dirham,copper'
					)
					(Said 'empty/moneybag')
				)
				(cond
					((gEgo has: 3) ; purse
						(Talk 5 59) ; "As you wish. Give me the purse, then."
					)
					((not (IsItemAt 3)) ; purse
						(Print 5 60) ; "You do not even have the purse."
					)
					((== global122 global121 global120 0)
						(Talk 5 61) ; "The purse is empty, m'lord. I await your commands."
					)
					(else
						(self changeState: 10)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gTObj endTalk:)
				(= local2 1)
				(= register 2)
				(treasurer
					setLoop: 4
					setCycle: Fwd
					moveSpeed: 2
					setMotion: MoveTo 129 68 self
				)
			)
			(2
				(clinkSound play:)
				(treasurer setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(if (-- register)
					(self changeState: 2)
				else
					(treasurer setLoop: 4 setCycle: 0)
					(RedrawCast)
					(= local2 0)
					(Talk 5 62) ; "There are silver coins in your purse."
					(+= global121 10)
					(++ global123)
					(HandsOn)
				)
			)
			(4
				(HandsOff)
				(gTObj endTalk:)
				(= local2 1)
				(treasurer
					setLoop: 4
					setCycle: Fwd
					moveSpeed: 2
					setMotion: MoveTo 146 68 self
				)
			)
			(5
				(clinkSound play:)
				(treasurer setLoop: 1 setCel: 0 setCycle: End self)
			)
			(6
				(treasurer setLoop: 4 setCycle: 0)
				(RedrawCast)
				(= local2 0)
				(Talk 5 63) ; "You now have gold coins, my King."
				(+= global122 5)
				(++ global123)
				(HandsOn)
			)
			(7
				(HandsOff)
				(gTObj endTalk:)
				(= local2 1)
				(= register 3)
				(treasurer
					setLoop: 4
					setCycle: Fwd
					moveSpeed: 2
					setMotion: MoveTo 109 68 self
				)
			)
			(8
				(clinkSound play:)
				(treasurer setLoop: 1 setCel: 0 setCycle: End self)
			)
			(9
				(if (-- register)
					(self changeState: 8)
				else
					(treasurer setLoop: 4 setCycle: 0)
					(RedrawCast)
					(= local2 0)
					(Talk 5 64) ; "I have given you copper coins, m'lord."
					(+= global120 15)
					(++ global123)
					(HandsOn)
				)
			)
			(10
				(gTObj talkCue: self)
				(Talk 5 65) ; "The purse has coins in it, m'lord, but if that is your wish..."
			)
			(11
				(clinkSound play:)
				(treasurer setLoop: 1 setCel: 0 setCycle: End self)
			)
			(12
				(treasurer setLoop: 3)
				(localproc_0)
				(Talk 5 66) ; "The purse is now empty. What is your command?"
			)
		)
	)
)

(instance stairScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					posn: 163 144
					setPri: 8
					setMotion: MoveTo 124 124 self
				)
			)
			(2
				(gEgo illegalBits: -32768 ignoreActors: 0 setPri: -1)
				(client setScript: 0)
				(HandsOn)
			)
			(3
				(HandsOff)
				(gEgo
					illegalBits: 0
					setPri: 8
					setLoop: 0
					ignoreActors:
					setMotion: MoveTo 163 144 self
				)
			)
			(4
				(gCurRoom newRoom: 1)
			)
		)
	)
)

(instance treasurer of Act
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
			((Said 'give/lodestone')
				(if (gEgo has: 2) ; lodestone
					(Talk 5 67) ; "Ah, a good luck charm! I thank you, m'lord."
					(PutItem 2) ; lodestone
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'show/lodestone')
				(if (gEgo has: 2) ; lodestone
					(Talk 5 68) ; "Ah, a good luck charm!"
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((and (IsItemAt 2) (Said 'get/lodestone')) ; lodestone
				(Talk 5 69) ; "Here you are, m'lord."
				(gEgo get: 2) ; lodestone
			)
			(
				(or
					(Said 'get,ask/advice[/treasurer]')
					(Said 'get,ask[/treasurer]/advice')
					(Said 'talk[/treasurer]')
				)
				(cond
					((== global122 global121 global120 0)
						(if (not local4)
							(Talk 5 70) ; "My king, if you seek my advice, I say this -- take with you coins of all three value: copper, silver and gold. Each has its use."
							(= local4 1)
						else
							(Talk 5 71) ; "If you have brought your purse with you, m'lord, I will be happy to fill it for you."
						)
					)
					((not local4)
						(Talk 5 72) ; "I am here to serve you as I may, though, to speak bluntly, I hope you will soon be in search of the Grail."
						(= local4 1)
					)
					(else
						(Talk 5 73) ; "Please tell me how I may serve you."
					)
				)
			)
			((Said 'kill/treasurer')
				(Print 5 74) ; "Hands that shed innocent blood will never touch the Grail."
			)
			((Said 'attack/treasurer')
				(Print 5 75) ; "He is your loyal servant. Why would you want to fight him?"
			)
			((Said 'kiss/treasurer')
				(Talk 5 76) ; "Gar! Keep away, you pox-cursed pooftah!"
			)
			((Said 'hug/treasurer')
				(Talk 5 77) ; "Where I come from, that is not a manly thing to do."
			)
			((Said 'count/coin,dinar,dirham,copper')
				(if (not (gEgo has: 3)) ; purse
					(Talk 5 78) ; "Pardon me, Sire, but that would take months."
				else
					(event claimed: 0)
				)
			)
			((Said 'get,open,search,unseal/bundle,possession')
				(Talk 5 79) ; "It was sealed by Sir Gawaine when he left it here, and he charged me to see that the seal is not broken except by his own hand...unless he is dead."
			)
			((Said 'get,open/chest,gem,plate,goblet')
				(Talk 5 80) ; "Nay, leave it be. Your mission must be kept humble, for safety as well as your soul's sake."
			)
			((Said 'close/door')
				(Talk 5 81) ; "By your leave, m'lord, I keep it open so that fresh air may enter the room. And so the mice may leave it."
			)
			((or (Said '(are<where)>') (Said 'ask[/treasurer]/>'))
				(cond
					((Said '/merlin')
						(event claimed: 0)
					)
					((Said '//bundle,possession')
						(Talk 5 82) ; "Those bundles belong to Sir Gawaine. They are all his worldly possessions which he left in my keeping, for I was the last man to see him ere he left."
					)
					((and (IsItemAt 3) (Said '//moneybag')) ; purse
						(Talk 5 83) ; "I have it, Sire, and await your instructions."
					)
					((Said '//bag,grain')
						(Talk 5 84) ; "The bags contain gold and silver cups and platters and other booty from the battles you have won."
					)
					((Said '//coin,dinar,copper,dirham')
						(if (== global122 global121 global120 0)
							(Talk 5 85) ; "Each jar before me is filled with coins: one with gold coins, one with silver coins and one with copper coins."
						else
							(event claimed: 0)
						)
					)
					((Said '//jar,barrel')
						(Talk 5 86 5 87) ; "Greetings, my King. The jar to your left contains copper coins, the jar in the center holds silver coins and the jar to your right is filled with gold coins."
					)
					((Said '//name')
						(Talk 5 88) ; "You have forgotten my name after years of service? Awr, you are having a joke. Hawrh! Hawrh! Hawrh!"
					)
					((or (Said '/gawain') (Said '//gawain'))
						(SetScore 236 1 2)
						(Talk 5 89 5 90) ; "I was the last to see Sir Gawaine. He made sure to take copper coins along with silver and gold. He told me he planned to search for the Grail in the ruins of Glastonbury Tor."
					)
					(else
						(event claimed: 1)
						(Talk 5 91) ; "I wish I could tell you something useful, m'lord."
					)
				)
			)
		)
	)
)

(instance guards of Act
	(properties
		y 165
		view 103
		signal 16384
		illegalBits 0
	)
)

(instance legs1 of Act
	(properties
		y 165
		view 103
		signal 16384
		cycleSpeed 1
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if (not cycler)
			(if (== loop 1)
				(self setLoop: 2 setCycle: End)
			else
				(self setLoop: 1 setCycle: End)
			)
		)
		(= x (- (guards x:) 17))
		(if (and (== loop 2) (== cel 1))
			(++ x)
		)
	)
)

(instance legs2 of Act
	(properties
		y 165
		view 103
		signal 16384
		cycleSpeed 1
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if (not cycler)
			(if (== loop 1)
				(self setLoop: 2 setCycle: End)
			else
				(self setLoop: 1 setCycle: End)
			)
		)
		(if (and (== loop 2) (== cel 0))
			(+= x 1)
		)
		(if (and (== loop 2) (== cel 1))
			(-= x 1)
		)
		(= x (+ (guards x:) 1))
		(if (and (== loop 2) (== cel 1))
			(++ x)
		)
	)
)

(instance legs3 of Act
	(properties
		y 165
		view 103
		signal 16384
		cycleSpeed 1
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if (not cycler)
			(if (== loop 1)
				(self setLoop: 2 setCycle: End)
			else
				(self setLoop: 1 setCycle: End)
			)
		)
		(if (and (== loop 2) (== cel 0))
			(+= x 1)
		)
		(if (and (== loop 2) (== cel 1))
			(-= x 1)
		)
		(= x (+ (guards x:) 19))
		(if (and (== loop 2) (== cel 1))
			(++ x)
		)
	)
)

(instance Camelot_ of Script
	(properties
		name {Camelot!}
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 2)
				(== (gRmMusic number:) 63)
				(== (gRmMusic prevSignal:) -1)
			)
			(self changeState: 3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gRmMusic stop: number: 63 loop: 1 play:)
				(guards init: setLoop: 0 cycleSpeed: 1 setCycle: Fwd)
				(legs1 init:)
				(legs2 init:)
				(legs3 init:)
				(= cycles 1)
			)
			(1
				(guards setMotion: MoveTo 260 165 self)
				(legs1 setMotion: MoveTo 500 165)
				(legs2 setMotion: MoveTo 500 165)
				(legs3 setMotion: MoveTo 500 165)
			)
			(2
				(guards setMotion: MoveTo -50 165)
				(legs1 setMotion: MoveTo -500 165)
				(legs2 setMotion: MoveTo -500 165)
				(legs3 setMotion: MoveTo -500 165)
			)
			(3
				(Print 5 92 #at -1 120 #dispose) ; "In memory of Graham Chapman"
				(= seconds 6)
			)
			(4
				(clr)
				(guards dispose:)
				(legs1 dispose:)
				(legs2 dispose:)
				(legs3 dispose:)
				(gRmMusic fade:)
				(gEgo setScript: 0)
				(HandsOn)
			)
		)
	)
)

