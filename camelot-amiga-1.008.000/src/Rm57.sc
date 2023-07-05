;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use n117)
(use n142)
(use n150)
(use n151)
(use Bazaar)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm57 0
	proc57_1 1
	proc57_2 2
	proc57_3 3
	proc57_4 4
	proc57_5 5
)

(synonyms
	(sarah woman)
	(ibrahim man)
	(joshua child boy)
)

(local
	local0
	local1
	local2
	local3
	[local4 20]
	local24
)

(procedure (proc57_5 &tmp temp0)
	(for ((= temp0 0)) (< temp0 global144) ((++ temp0))
		(= [local4 temp0] [local4 (+ temp0 1)])
	)
	(if (== (-- global144) 0)
		(holdFelafel seconds: 0)
		(PutItem 14) ; felafel
	)
)

(procedure (proc57_4)
	(ibr view: 353)
	(gTObj tWindow: ibrWindow actor: ibrHead tLoop: 5 cSpeed: 2)
)

(procedure (proc57_1)
	(Face gEgo ibr)
	(proc57_4)
	(Talk &rest)
)

(procedure (localproc_0)
	(Face gEgo ibr)
	(proc57_4)
	(if (not (ibr script:))
		(ibr setScript: talkingIbr)
	)
	(Talk &rest)
)

(procedure (proc57_2)
	(if (== (sarahActions state:) 1)
		(gTObj preLoop: 1)
	)
	(gTObj tWindow: sarahWindow actor: sarah tLoop: 5 postLoop: 0 cSpeed: 3)
)

(procedure (proc57_3)
	(proc57_2)
	(Talk &rest)
)

(instance ibrWindow of SysWindow
	(properties
		color 15
		back 5
		title {Ibrahim ibn Bushir}
		brTop 10
		brLeft 50
		brBottom 85
		brRight 250
	)
)

(instance sarahWindow of SysWindow
	(properties
		color 6
		back 14
		title {Sarah}
		brTop 10
		brLeft 120
		brBottom 70
		brRight 290
	)
)

(instance ibrDoor of Prop
	(properties
		y 123
		x 106
		view 157
		priority 7
		signal 16
	)
)

(instance rawFelafels of PV
	(properties
		y 112
		x 265
		view 157
		loop 1
		cel 2
		priority 8
	)
)

(instance cauldron of PV
	(properties
		y 110
		x 264
		view 157
		loop 1
		priority 5
	)
)

(instance cookedFelafels of View
	(properties
		y 112
		x 230
		view 157
		loop 2
		priority 8
		signal 16
	)
)

(instance steam of Prop
	(properties
		y 94
		x 265
		view 157
		loop 3
		cycleSpeed 5
	)
)

(instance ibrLower of Prop
	(properties
		y 138
		x 129
		view 353
		loop 4
		signal 16384
	)
)

(instance ibrHead of Prop
	(properties
		y 138
		x 129
		z 43
		view 353
		loop 5
		signal 16384
	)
)

(instance Rm57 of Rm
	(properties
		picture 57
	)

	(method (init)
		(Load rsVIEW 355)
		(Load rsVIEW 356)
		(if (not (IsItemAt 13)) ; veil
			(Load rsVIEW 352)
			(Load rsVIEW 353)
		)
		(super init:)
		(= global112 2)
		(self setRegions: 152) ; Bazaar
		(gAddToPics add: cauldron rawFelafels)
		(ClearFlag 160)
		(switch gPrevRoomNum
			(59
				(gEgo posn: 20 (gEgo y:) loop: 0)
			)
			(60
				(gEgo posn: 22 127 loop: 2)
			)
			(56
				(gEgo posn: (- 320 (gEgo x:)) 180 loop: 3)
			)
			(54
				(gEgo posn: 300 170 loop: 1)
				(if (IsFlag 20)
					(gMuleObj posn: 300 180 loop: 1)
				)
			)
			(else
				(gEgo posn: 150 170 loop: 3)
			)
		)
		(if (not (IsFlag 146))
			(ibr init:)
		)
		(ibrDoor init: stopUpd:)
		(urchin init:)
		(sarah init:)
		(cookedFelafels init: stopUpd:)
		(steam init: setCycle: Fwd)
		(gAddToPics doit:)
		(if (IsFlag 143)
			((ScriptID 160 0) init:) ; thief
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 160)
		(DisposeScript 161)
		(DisposeScript 162)
	)

	(method (notify)
		(cond
			((gEgo inRect: 200 0 320 200)
				(Face gEgo sarah)
				(proc57_2)
			)
			((not (IsFlag 146))
				(Face gEgo ibr)
				(proc57_4)
			)
			(else
				(return 0)
			)
		)
		(return 1)
	)

	(method (newRoom newRoomNumber)
		(= global144 0)
		(PutItem 14) ; felafel
		(if (and (IsFlag 143) (!= newRoomNumber 60))
			(ClearFlag 143)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((< (gEgo x:) 20)
				(gCurRoom newRoom: 59)
			)
			((> (gEgo x:) 300)
				(if (IsFlag 223)
					(Print 57 0) ; "The guards remain and will not let you leave. Do not annoy them, Arthur. There are many more of them and they are all well armed."
					(gEgo setMotion: MoveTo (- (gEgo x:) 4) (gEgo y:))
				else
					(gCurRoom newRoom: 54)
				)
			)
			((< (gEgo y:) 125)
				(gCurRoom newRoom: 60)
			)
			((> (gEgo y:) 180)
				(gCurRoom newRoom: 56)
			)
		)
		(if
			(and
				(gTObj tCount:)
				(or
					(and
						(== (gTObj actor:) sarah)
						(not (gEgo inRect: 200 0 320 200))
					)
					(and
						(== (gTObj actor:) ibr)
						(not (gEgo inRect: 0 140 200 200))
					)
				)
			)
			(gTObj endTalk: actor: 0)
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
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said 'look<across/street')
							(Said 'look/business<weapon')
						)
						(Print 57 1) ; "Across the street is a weapons shop."
					)
					(
						(or
							(Said 'look[<around][/!*][/!*]')
							(Said 'look/room,bazaar,street,jerusalem')
							(Said 'ask[/merlin]/room,bazaar,street,jerusalem')
						)
						(cond
							((IsFlag 137)
								(Print 57 2) ; "The felafel seller does business as usual. Ibrahim has still not returned, however."
							)
							((not (IsFlag 146))
								(Print 57 3) ; "There is a textile merchant and a woman selling felafels."
							)
							(else
								(Print 57 4) ; "The woman sells her felafels, but as I suspected, Ibrahim has forsaken his business for the pleasure of his wife's company. And who can blame him?"
							)
						)
					)
					(
						(or
							(Said '/falafel,food')
							(Said '//falafel,food')
							(MouseClaimed cookedFelafels event)
						)
						(cond
							(global144
								(Print 57 5) ; "It is golden fried and hot from oil. You must either eat it or give it to someone, Arthur. It will crumble to bits if you carry it about."
							)
							((IsFlag 138)
								(Print 57 6) ; "You were warned they are delicate. It has crumbled away to nothing."
							)
							(else
								(Print 57 7) ; "There is a basket of crisp, golden brown felafels, fresh from the oil on the woman's table."
							)
						)
					)
					(
						(or
							(Said '/door')
							(Said '//door')
							(OnButton event 82 81 106 123)
						)
						(Print 57 8) ; "It is closed."
					)
					(
						(or
							(Said '/window')
							(Said '//window')
							(OnButton event 107 7 133 32)
						)
						(Print 57 9) ; "It is dark and empty."
					)
					(
						(or
							(Said '/bolt,silk,linen,wool')
							(Said '/merlin/bolt,silk,linen,wool')
							(OnButton event 47 108 85 131)
							(OnButton event 101 86 171 130)
						)
						(Print 57 10) ; "He has quite a lot of it."
					)
					(
						(or
							(Said '/basket')
							(Said '//basket')
							(OnButton event 252 104 278 112)
						)
						(Print 57 11) ; "There is a basket of raw felafel balls and a basket of fried felafels."
					)
					(
						(or
							(Said '/alley')
							(Said '//alley')
							(OnButton event 19 8 39 117)
						)
						(Print 57 12) ; "It looks uninviting."
					)
					((and (== global202 2) (or (Said '/ass') (Said '//ass')))
						(Print 57 13) ; "Your mule is across the street with the weapons merchant."
					)
				)
			)
			((Said 'use/lamb')
				(Print 57 14) ; "How?"
			)
			((Said 'smell')
				(Print 57 15) ; "The felafels do smell especially good."
			)
			((or (Said 'open/door') (Said 'knock[/door]'))
				(if (IsFlag 146)
					(Print 57 16) ; "Nay, do not disturb Ibrahim and his wife at such a moment."
				else
					(Print 57 17) ; "If Ibrahim wanted you to enter, he would invite you."
				)
			)
			((Said 'talk/ibrahim')
				(if (IsFlag 146)
					(Print 57 18) ; "Ibrahim has not returned."
				else
					(Print 57 19) ; "Perhaps you should move closer."
				)
			)
			((Said '*/ibrahim')
				(if (IsFlag 146)
					(Print 57 20) ; "I do not think you will see Ibrahim any time soon."
				else
					(event claimed: 0)
				)
			)
			((Said 'eat/falafel,food')
				(cond
					(global144
						(gEgo setScript: eatOneFelafel)
					)
					(local2
						(proc57_3 57 21) ; "No need to stand there drooling. Help yourself, I said."
					)
					(else
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
				)
			)
		)
	)
)

(instance ibr of Act
	(properties
		y 138
		x 129
		z 30
		view 353
		loop 3
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self stopUpd:)
		(ibrLower init: stopUpd:)
		(ibrHead init: stopUpd:)
	)

	(method (handleEvent event)
		(if (IsFlag 146)
			(return)
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
					(MouseClaimed self event)
					(MouseClaimed ibrLower event)
					(MouseClaimed ibrHead event)
					(Said 'look/ibrahim')
					(Said 'ask/merlin/ibrahim')
					(and
						(gEgo inRect: 0 140 200 200)
						(or
							(Said 'look/merchant')
							(Said 'ask/merlin/merchant[<bolt]')
						)
					)
				)
				(Print 57 22) ; "He has rather a taste for bright colours, I note."
			)
			((not (gEgo inRect: 0 140 200 200))
				(return)
			)
			(
				(or
					(Said 'look/business,goods,building')
					(Said 'ask/merlin/business,goods,building')
				)
				(Print 57 23) ; "The textile merchant has quite an array of cloth."
			)
			((Said 'look<in/business,building')
				(Print 57 24) ; "You cannot see through the door."
			)
			((Said 'talk[/ibrahim,merchant]')
				(if (not (IsFlag 134))
					(switch local0
						(0
							(= local0 1)
							(localproc_0 57 25 57 26 57 27 57 28) ; "Observe, if you will, the quality of my fabrics. You will find none finer even if you journeyed to Constantinople, and indeed, some have come from twice as far."
						)
						(else
							(proc57_1 57 29) ; "You are undoubtedly awed by the selection. Take your time."
						)
					)
				else
					(switch local0
						(0
							(= local0 1)
							(= global185 ibr)
							(= global186 ibrDoor)
							(= global187 ibrHead)
							(= global188 ibrLower)
							(gEgo setScript: (ScriptID 163 0)) ; tellOfWoe
						)
						(else
							(proc57_1 57 30) ; "My anguish overwhelms me. I cannot speak."
						)
					)
				)
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(if (gEgo has: 3) ; purse
					(proc57_1 57 31) ; "But you are not buying anything."
					(proc0_18)
				else
					(event claimed: 0)
				)
			)
			((Said 'give,sell,bargain/ass')
				(if (IsFlag 20)
					(proc57_1 57 32) ; "Keep it away! I once had a mule who ate cloth. I will never keep one again."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'show/veil[/ibrahim,merchant]')
				(if (gEgo has: 13) ; veil
					(proc57_1 57 33) ; "Ahh! You have it, habibi! If only I could have it, I would be the happiest man in the world!"
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'give,show/*[/ibrahim,merchant]>')
				(cond
					((Said '/lamb')
						(if (gEgo has: 10) ; lamb | dove
							(proc57_1 57 34) ; "No thank you. I do not eat meat."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/falafel')
						(if global144
							(proc57_1 57 35) ; "Forgive my ingratitude, but I have eaten more of Sarah's felafels than the sky has stars."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((or (not global140) (not (gEgo has: global140)))
						(event claimed: 1)
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((proc150_0 self self -6 12) 0)
					((Said '/veil')
						(if (gEgo has: 13) ; veil
							(SetScore 0 0 5 2 5)
							(SetFlag 151)
							(= global185 ibr)
							(= global186 ibrDoor)
							(= global187 ibrHead)
							(= global188 ibrLower)
							(ibr setScript: (ScriptID 162 0)) ; giveVeil
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					(else
						(event claimed: 1)
						(proc57_1 57 36) ; "You wish me to accept this gift? I cannot imagine why. I must respectfully decline."
					)
				)
			)
			((Said 'sell,bargain>')
				(cond
					((or (not global140) (not (gEgo has: global140)))
						(event claimed: 1)
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((Said '/lamb')
						(proc57_1 57 37) ; "No, I do not eat meat."
					)
					((proc150_0 self self -6 12) 0)
					((Said '/veil')
						(SetScore 0 2 -5)
						(ClearFlag 151)
						(= global185 ibr)
						(= global186 ibrDoor)
						(= global187 ibrHead)
						(= global188 ibrLower)
						(ibr setScript: (ScriptID 162 0)) ; giveVeil
					)
					(else
						(event claimed: 1)
						(proc57_1 57 38) ; "I think not today, thank you. May Allah guide you elsewhere."
					)
				)
			)
			((or (Said 'get,buy/>') (Said 'ask[/ibrahim,merchant]/*>'))
				(cond
					((Said '/bolt,silk,linen,wool')
						(Print 57 39) ; "Rather ostentatious for you, I deem, and not of much use without the skills of a tailor."
					)
					((and (IsItemAt 11) (Said '/mirror')) ; mirror | golden_apple
						(proc57_1 57 40) ; "If you wish, here it is."
						(PutItem 11) ; mirror | golden_apple
					)
					((or (Said '/veil') (Said '//veil'))
						(proc57_1 57 41) ; "Do not mention the word veil to me! It is a word of misery."
					)
					((Said '//guenevere')
						(proc57_1 57 42) ; "She is beautiful and trusting. I fear I do not deserve such a good wife."
					)
					((or (Said '/carpet') (Said '//carpet'))
						(proc57_1 57 43) ; "I do not have rugs for sale."
					)
					((Said '//grail')
						(proc57_1 57 44) ; "Perhaps Ismail the relic merchant can help you."
					)
					((Said '//galahad')
						(proc57_1 57 45) ; "I do not know him."
					)
					((Said '//bolt,linen,goods')
						(localproc_0 57 46) ; "Just feel the marvelous fabric, habib. They can make a pauper look like a prince!"
					)
					((Said '//wool')
						(localproc_0 57 47) ; "My woolens are the finest in Jerusalem."
					)
					((Said '//silk')
						(localproc_0 57 48) ; "The silks come from the Orient, very rare and very beautiful."
					)
					((Said '//bandit')
						(proc57_1 57 49) ; "Yes, they plague and the city guards seldom catch them. For this, I pay taxes?"
					)
					((Said '//alley')
						(proc57_1 57 50) ; "That alley goes nowhere and is most unpleasant."
					)
					((Said '//mari')
						(proc57_1 57 51) ; "Do not speak her cursed name! I wish I had never seen her!"
					)
					((Said '//food')
						(proc57_1 57 52) ; "My neighbor, Sarah, sells excellent felafels."
					)
					((Said '//sarah,(merchant<falafel)')
						(proc57_1 57 53) ; "Her felafels are the best in Jerusalem."
					)
					((Said '//bolt')
						(proc57_1 57 54) ; "It means cloth, of course."
					)
					((Said '//bandit')
						(proc57_1 57 55) ; "The thieves are a dreadful nuisance."
					)
					((Said '//constantinople,orient')
						(proc57_1 57 56) ; "Even if you travelled there, you would find no finer fabrics than mine."
					)
					((and (Said 'ask//*>') (not (proc152_2 event)))
						(event claimed: 1)
						(proc57_1 57 57) ; "What can I say about that, habibi."
					)
				)
			)
		)
	)
)

(instance talkingIbr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (gTObj tCount:) 0)
			(ibr setCycle: 0 cycleSpeed: 0 setLoop: 1 cel: 0)
			(client setScript: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ibr setLoop: (Random 0 3) cycleSpeed: 1 setCycle: End self)
			)
			(1
				(= seconds (Random 2 6))
				(= state -1)
			)
		)
	)
)

(instance sarah of Act
	(properties
		y 123
		x 244
		view 355
		cycleSpeed 4
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setPri: 6 setScript: sarahActions)
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
			(
				(or
					(OnButton event 231 75 251 105)
					(Said 'look/sarah,sarah')
					(Said 'ask/merlin/sarah,sarah')
					(and
						(gEgo inRect: 200 0 320 200)
						(or
							(Said 'look/merchant')
							(Said 'ask/merlin/merchant[<food,falafel]')
						)
					)
				)
				(Print 57 58) ; "It appears she partakes liberally of her own food."
			)
			(
				(or
					(Said 'look/pot,cauldron,oil')
					(OnButton event 255 92 273 104)
				)
				(Print 57 59) ; "It is a heavy metal cauldron filled with bubbling hot oil."
			)
			((or (Said 'look/table') (Said 'ask/merlin/table'))
				(Print 57 60) ; "One basket of raw felafels and one basket of cooked felafels sits on the table."
			)
			((Said 'look/boob')
				(Print 57 61) ; "Stop that, Arthur. You have been away from Gwenhyver for too long."
			)
			(
				(or
					(and (not (IsFlag 139)) (Said 'look/girl'))
					(Said 'talk,ask/girl')
				)
				(Print 57 62) ; "I see no girl, only the matronly felafel seller."
			)
			((not (gEgo inRect: 200 0 320 200))
				(return)
			)
			(
				(or
					(Said 'look/business,goods')
					(Said 'ask/merlin/business,goods')
				)
				(Print 57 63) ; "'Tis no more than a little stall with a canopy to keep out the rain and sun, a cauldron of bubbling oil and the felafels, raw and cooked."
			)
			((Said 'talk[/sarah,merchant]')
				(cond
					((IsItemAt 10) ; lamb | dove
						(proc57_3 57 64) ; "Ah, it is you! How good to see your face again. If you want a felafel, just speak up."
					)
					((not (IsFlag 134))
						(if (not local1)
							(= local1 1)
							(proc57_3 57 65) ; "Fresh, hot felafels for a hungry man. Made from the finest ground chick peas and ground sesame seed. Flavored with parsley, onion and garlic."
						else
							(proc57_3 57 66) ; "Golden fried felafels cooked in pure sesame oil. If you are hungry, a felafel would work wonders for your belly. See what it has done for mine!"
						)
					)
					((not local1)
						(= local1 1)
						(proc57_3 57 67 57 68) ; "Well, I should not be telling you this, but all day long I cook felafels. Every day I eat felafels. Not that they are not delicious!"
					)
					(else
						(proc57_3 57 69) ; "I do not mind paying his prices, but I am terrified of the meat merchant, that evil-tempered ox! That is why I go without lamb."
					)
				)
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(cond
					((not (DoPurse))
						(if (not local2)
							(proc57_3 57 70) ; "Do not try to cheat me now! No coin, no felafel."
						else
							(event claimed: 0)
						)
					)
					((> global144 20)
						(Print 57 71) ; "You can carry no more felafels without making a mess of yourself."
						(proc0_18)
					)
					(else
						(+= local2 global132)
						(= global132 0)
						(= local3 1)
						(gEgo setScript: buyFelafel)
					)
				)
			)
			((Said 'get,buy>')
				(cond
					((Said '/falafel<raw,uncooked')
						(Print 57 72) ; "They are not very good uncooked."
					)
					((Said '/falafel,food')
						(cond
							((not local2)
								(proc57_3 57 73) ; "Only 1 fals for one of my delicious felafels."
							)
							((> global144 20)
								(proc57_3 57 74) ; "Gluttony is what the Christians call one of the Seven Deadly Sins, you know. That is quite enough with the felafels already."
							)
							(else
								(gEgo setScript: buyFelafel)
							)
						)
					)
					((Said '/basket,cauldron')
						(Print 57 75) ; "I rather doubt she would wish to part with that."
					)
					((and (IsItemAt 10) (Said '/lamb')) ; lamb | dove
						(proc57_3 57 76) ; "I have been craving a bit of lamb. Thank you for bringing it."
					)
					((or global140 (Said '/ass'))
						(event claimed: 1)
						(proc57_3 57 77) ; "Why are you asking ME?"
					)
				)
			)
			((Said 'give,show/*[/sarah]>')
				(cond
					((Said '/falafel')
						(if global144
							(proc57_3 57 78) ; "That would be like giving wool to the sheep, do you not think?"
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/ass')
						(if (IsFlag 20)
							(proc57_3 57 79) ; "I have no room for it, thank you all the same."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((or (not global140) (not (gEgo has: global140)))
						(event claimed: 1)
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((proc150_0 self self -10 20) 0)
					((Said '/lamb')
						(= global185 sarah)
						(= global186 urchin)
						(SetScore 0 0 5 2 5)
						(gEgo setScript: (ScriptID 161 0)) ; giveLamb
					)
					(else
						(event claimed: 1)
						(proc57_3 57 80) ; "Really, you are too kind, but I could not take it."
					)
				)
			)
			((Said 'sell,bargain/>')
				(cond
					((Said '/lamb')
						(if (gEgo has: 10) ; lamb | dove
							(SetScore 0 2 -5)
							(gEgo setScript: (ScriptID 161 1)) ; sellLamb
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/veil')
						(if (not (gEgo has: 13)) ; veil
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						else
							(proc57_3 57 81) ; "Very pretty. Maybe my neighbor, Ibrahim, would be interested."
						)
					)
					(else
						(event claimed: 1)
						(proc57_3 57 82) ; "What, do I look rich?"
					)
				)
			)
			((Said 'ask[/sarah]>')
				(cond
					((Said '//falafel,food,goods,business')
						(if local2
							(proc57_3 57 83) ; "Buy another one, if you please."
						else
							(proc57_3 57 73) ; "Only 1 fals for one of my delicious felafels."
						)
					)
					((Said '//grail')
						(proc57_3 57 84) ; "You mean like a cup? Farabi across the street sells cups."
					)
					((Said '//galahad')
						(proc57_3 57 85) ; "Galahad? What a strange name."
					)
					((Said '//cook')
						(proc57_3 57 86) ; "I am cooking felafels, of course."
					)
					((Said '//joshua')
						(proc57_3 57 87) ; "He simply appeared days ago and never says a word. An orphan, no doubt."
					)
					((Said '//onion')
						(proc57_3 57 88) ; "I use very fine ingredients in my felafels."
					)
					((Said '//cauldron,pot')
						(proc57_3 57 89) ; "I cook the felafels in my cauldron, until they are just right."
					)
					((Said '//ibrahim,(merchant<bolt)')
						(proc57_3 57 90) ; "He knows cloth well, but he has much to learn about women."
					)
					((Said '//butcher')
						(proc57_3 57 69) ; "I do not mind paying his prices, but I am terrified of the meat merchant, that evil-tempered ox! That is why I go without lamb."
					)
					((and (Said 'ask//*>') (not (proc152_2 event)))
						(event claimed: 1)
						(proc57_3 57 91) ; "I cannot help you with that."
					)
				)
			)
		)
	)
)

(instance sarahActions of Script
	(properties)

	(method (doit)
		(return
			(if (and (== (gTObj actor:) sarah) (!= (gTObj tCount:) 0))
				0
			else
				(super doit:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sarah cel: 0 setLoop: 0 cycleSpeed: 5 setCycle: Fwd)
				(= cycles (Random 30 80))
			)
			(1
				(sarah cel: 0 setLoop: 1 cycleSpeed: 2 setCycle: End self)
			)
			(2
				(if
					(and
						(== (mod (++ local24) 10) 1)
						(< (cookedFelafels cel:) 3)
					)
					(cookedFelafels setCel: (+ (cookedFelafels cel:) 1))
				)
				(sarah cel: 0 setLoop: 2 cycleSpeed: 4 setCycle: End self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance buyFelafel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 138)
				(if (not (gEgo inRect: 240 139 245 142))
					(gEgo setMotion: MoveTo 242 140 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if local3
					(= local3 0)
					(proc151_0 2 self self)
				else
					(= cycles 1)
				)
			)
			(2
				(gTObj talkCue: self)
				(proc57_3 57 92 57 93) ; "Help yourself."
			)
			(3
				(proc151_0 1 self self)
			)
			(4
				(gCurRoom setScript: holdFelafel)
				(gEgo get: 14) ; felafel
				(++ global144)
				(-- local2)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance eatOneFelafel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc142_1 self)
			)
			(1
				(proc57_5)
				(if (or (IsFlag 160) (IsFlag 142))
					(Print 57 94) ; "I can sense how much you enjoyed that crisp, hot felafel."
				else
					(Print 57 95) ; "I fail to see how you could have enjoyed that with the eyes of that poor hungry urchin upon you."
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance urchin of Act
	(properties
		y 150
		x 305
		view 356
		illegalBits 0
	)

	(method (init)
		(super init:)
		(if (IsFlag 142)
			(self setLoop: 0 setCel: 3 posn: 219 128 setPri: 7)
		else
			(self setScript: urchinActions)
		)
		(self stopUpd:)
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
			((or (Said 'look/joshua') (MouseClaimed self event))
				(if (IsFlag 142)
					(Print 57 96) ; "Under Sarah's care, he will be happy and healthy. Right you are to feel proud of this deed."
				else
					(Print 57 97) ; "He is only a young boy, a half-starved, ragged urchin who is surely alone in the world. What a pathetic sight!"
				)
			)
			(
				(not
					(or
						(and
							(gEgo inRect: 260 0 320 200)
							(== (gEgo loop:) 0)
						)
						(and
							(gEgo inRect: 283 149 310 180)
							(== (gEgo loop:) 3)
						)
						(and
							(gEgo inRect: 200 0 320 200)
							(or (Said '//joshua>') (Said '/joshua>'))
						)
					)
				)
				(if (Said '/joshua')
					(Print 57 98) ; "You will need to move closer to the boy, but gently! He is alone and afraid."
				else
					(return)
				)
			)
			(else
				(= global185 urchin)
				((ScriptID 164 0) handleEvent: event) ; urchinSaids
			)
		)
	)
)

(instance urchinActions of Script
	(properties)

	(method (init)
		(super init:)
		(if (== gPrevRoomNum 54)
			(self changeState: 4)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (> (gEgo x:) 175))
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(urchin setLoop: 0 cel: 0 posn: 258 140)
			)
			(1
				(= cycles 3)
			)
			(2
				(urchin setLoop: 1 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(3
				(urchin
					setLoop: 2
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 298 140 self
				)
			)
			(4
				(urchin
					setLoop: 0
					setCel: 4
					cycleSpeed: 2
					posn: 300 140
					setCycle: 0
				)
			)
		)
	)
)

(instance holdFelafel of Script
	(properties)

	(method (doit &tmp [temp0 2])
		(if (not (gEgo script:))
			(super doit:)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= [local4 global144] (- 30 seconds))
				(self cue:)
			)
			(1
				(if (not seconds)
					(= seconds [local4 0])
				)
			)
			(2
				(proc57_5)
				(if global144
					(Print 57 99) ; "One of your felafels is reduced to crumbs from too much handling."
					(self changeState: 1)
				else
					(Print 57 100) ; "Your only felafel is reduced to crumbs from too much handling."
					(client setScript: 0)
				)
			)
		)
	)
)

