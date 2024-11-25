;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 59)
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
	Rm59 0
)

(synonyms
	(seeress seeress woman)
	(tariq man)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0)
	(gTObj tWindow: tamraWindow actor: tamra tLoop: 2 cSpeed: 2 postLoop: 4)
)

(procedure (localproc_1)
	(Face gEgo tamra)
	(localproc_0)
	(Talk &rest)
)

(procedure (localproc_2)
	(gTObj tWindow: tariqWindow actor: tariq tLoop: 0 cSpeed: 2)
)

(procedure (localproc_3)
	(Face gEgo tariq)
	(localproc_2)
	(Talk &rest)
)

(procedure (localproc_4)
	(Face gEgo tariq)
	(gTObj tWindow: tariqWindow actor: tariq tLoop: 1 cSpeed: 1)
	(Talk &rest)
)

(instance tamraWindow of SysWindow
	(properties
		color 10
		back 0
		title {Tamra}
		brTop 20
		brLeft 150
		brBottom 110
		brRight 310
	)
)

(instance tariqWindow of SysWindow
	(properties
		color 14
		back 6
		title {Tariq ibn Rashid}
		brTop 10
		brLeft 10
		brBottom 85
		brRight 190
	)
)

(instance hangingLamps of View
	(properties
		y 72
		x 78
		view 159
		loop 3
	)
)

(instance lowerBody of Prop
	(properties
		y 132
		x 109
		view 362
		loop 8
		priority 9
	)
)

(instance bunchOfApples of PV
	(properties
		y 135
		x 234
		view 159
		priority 10
	)
)

(instance oneApple of View
	(properties
		y 127
		x 241
		view 159
		cel 1
		priority 10
		signal 16
	)
)

(instance hangingHerbs of View
	(properties
		y 78
		x 110
		view 159
		loop 1
		priority 10
		signal 16
	)
)

(instance broom of View
	(properties
		y 131
		x 136
		view 159
		loop 2
	)
)

(instance Rm59 of Rm
	(properties
		picture 59
	)

	(method (init)
		(super init:)
		(Load rsVIEW 363)
		(Load rsVIEW 362)
		(= global112 2)
		(self setRegions: 152) ; Bazaar
		(switch gPrevRoomNum
			(58
				(gEgo posn: (- 320 (gEgo x:)) 180 loop: 3)
			)
			(62
				(gEgo posn: 20 (gEgo y:) loop: 0)
			)
			(57
				(if (< (gEgo y:) 142)
					(gEgo y: 142)
				)
				(gEgo posn: 300 (gEgo y:) loop: 1)
			)
			(else
				(gEgo posn: 150 170)
			)
		)
		(tariq init:)
		(tamra init:)
		(if (IsItemAt 9) ; herbs | bone
			(hangingHerbs init:)
		)
		(if (IsItemAt 4) ; rose | apple | green_apple
			(oneApple init: stopUpd:)
		)
		(if (IsItemAt 6) ; iron_key | broom | grail
			(broom init: stopUpd:)
		)
		(gAddToPics add: bunchOfApples hangingLamps doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((< (gEgo x:) 20)
				(gCurRoom newRoom: 62)
			)
			((> (gEgo x:) 300)
				(gCurRoom newRoom: 57)
			)
			((> (gEgo y:) 180)
				(gCurRoom newRoom: 58)
			)
		)
		(if
			(and
				(gTObj tCount:)
				(or
					(and (== (gTObj actor:) tamra) (< (gEgo x:) 152))
					(and (== (gTObj actor:) tariq) (>= (gEgo x:) 152))
				)
			)
			(gTObj endTalk: actor: 0)
		)
	)

	(method (notify)
		(cond
			((gEgo inRect: 152 0 320 200)
				(Face gEgo tamra)
				(localproc_0)
			)
			((gEgo inRect: 0 0 152 200)
				(Face gEgo tariq)
				(localproc_2)
			)
			(else
				(return 0)
			)
		)
		(return 1)
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
					(Said 'look,read/sign,lettering')
					(Said 'ask/merlin/sign,lettering')
					(OnButton event 42 20 126 57)
				)
				(Print 59 0) ; ""Lucernae" means "lamps". As for the Greek underneath, I cannot translate it. My Greek is too long out of use."
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((Said 'look<across/street')
						(Print 59 1) ; "Across the street are several merchants."
					)
					(
						(or
							(Said 'look[<around][/!*][/!*]')
							(Said 'look/room,bazaar,street,jerusalem')
							(Said 'ask[/merlin]/room,bazaar,street,jerusalem')
						)
						(cond
							((IsFlag 137)
								(Print 59 2) ; "You should know the lamp shop well enough and the Seeress is still with her apples."
							)
							((IsFlag 134)
								(Print 59 3) ; "There is the lamp shop. And you now know that the old woman is far more than she appears to be."
							)
							(else
								(Print 59 4) ; "Upon the left is a lamp shop. The old woman on the right is selling apples."
							)
						)
					)
					((or (Said '/lucernae') (Said '//lucernae'))
						(Print 59 5) ; ""Lucernae" means that he sells lamps."
					)
					(
						(or
							(Said '/lamp')
							(Said '//lamp')
							(OnButton event 63 55 99 72)
							(OnButton event 52 55 67 72)
						)
						(Print 59 6) ; "They are ceramic, made in the yoni style. When filled with oil, a flame will burn in the lamp's spout."
					)
					((Said '//yoni,(style<yoni)')
						(Print 59 7) ; "The yoni style is...ahem...well, shaped after a certain part of a woman."
					)
					(
						(and
							(IsItemAt 6) ; iron_key | broom | grail
							(or
								(Said '/broom')
								(Said '//broom')
								(MouseClaimed broom event)
							)
						)
						(Print 59 8) ; "It looks like an ordinary, well-made broom."
					)
					(
						(or
							(Said '/herb')
							(Said '//herb')
							(MouseClaimed hangingHerbs event)
						)
						(Print 59 9) ; "He has a bundle of sweetly pungent herbs hanging in the doorway."
					)
					((or (Said '/charcoal') (Said '//charcoal'))
						(Print 59 10) ; "Aye, he has charcoal for sale."
					)
					(
						(or
							(Said '/jar,pot,(oil<lamp)')
							(Said '//jar,pot,(oil<lamp)')
							(OnButton event 60 97 76 129)
							(OnButton event 60 81 94 120)
							(OnButton event 103 93 134 103)
						)
						(Print 59 11) ; "I suppose some of these jars contain various scented oils for the lamps, though some of the vases seem to be purely decorative."
					)
					((or (Said '/bookshelf') (Said '//bookshelf'))
						(Print 59 12) ; "On the lamp merchant's shelves are jars, bottles, and vases."
					)
					(
						(or
							(Said '/beaker')
							(Said '//beaker')
							(OnButton event 39 72 59 131)
						)
						(Print 59 13) ; "They are finely made, perhaps designed to hold ground herbs or spices or perfumed oils."
					)
					((or (Said '/table,bench') (Said '//table,bench'))
						(Print 59 14) ; "It looks quite ordinary."
					)
					(
						(or
							(Said '/basket')
							(Said '//basket')
							(OnButton event 204 118 268 142)
						)
						(Print 59 15) ; "The old woman's basket is filled with the small green apples common to this area."
					)
					((Said 'ask/merlin/seeress,seeress')
						(if (IsFlag 140)
							(Print 59 16) ; "Do as she instructs. That is the best advice I can give you."
						else
							(Print 59 17) ; "You are meant to find her by your own devices."
						)
					)
					((and (not (IsFlag 139)) (Said '/girl'))
						(Print 59 18) ; "You surely do not refer to the old woman selling apples? It has been many decades since she was a girl."
					)
				)
			)
			(
				(or
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(if (IsFlag 134)
					(Print 59 19) ; "Your wisdom and character are being tested. Act wisely."
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance tariq of Act
	(properties
		y 132
		x 109
		z 27
		view 362
		illegalBits 0
	)

	(method (init)
		(super init:)
		(lowerBody init: stopUpd:)
		(tariq setPri: 9 stopUpd:)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (gEgo inRect: 0 0 152 200))
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
					(OnButton event 100 81 117 142)
					(Said 'look/tariq')
					(Said 'ask/merlin/tariq')
					(and
						temp0
						(or
							(Said 'look/(merchant[<lamp]),tariq')
							(Said 'ask/merlin/(merchant[<lamp]),tariq')
						)
					)
				)
				(Print 59 20) ; "He appears to be a typical, prosperous Arab merchant."
			)
			((not temp0)
				(return)
			)
			((Said 'look/business,goods,building')
				(Print 59 21) ; "The lamp shop appears to carry quite a few other items besides oil lamps."
			)
			(
				(or
					(and
						(not (IsItemAt 12)) ; relic
						(not (IsFlag 134))
						(not local1)
						(Said 'talk[/tariq,merchant,tariq]')
					)
					(Said 'ask[/tariq,merchant,tariq]/sale,item,business')
				)
				(tariq setScript: talkToTariq)
				(++ local1)
			)
			((Said 'talk[/tariq,merchant,tariq]')
				(cond
					((IsItemAt 12) ; relic
						(localproc_3 59 22) ; "I am most pleased to see such a fine customer return. I am at your service."
					)
					((IsFlag 134)
						(switch local1
							(0
								(localproc_3 59 23) ; "'Tis odd. I feel I must tell you that although I am content with my lot, for I am an honest man, I would be happier still if my cousin, Achmed, had not broken his oath to me and thus ruined our friendship."
							)
							(else
								(localproc_3 59 24) ; "Let us not dwell on Achmed the Oathbreaker. My wares include lamps, oil, vases, jars, bottles, herbs and charcoal. How may I serve you?"
							)
						)
						(++ local1)
					)
					(else
						(localproc_3 59 25) ; "Please do not hesitate to ask for something."
					)
				)
			)
			((Said 'give,sell/ass')
				(if (IsFlag 20)
					(localproc_3 59 26) ; "A thousand apologies, but I have no use for a mule."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(cond
					((not (DoPurse))
						(if (gEgo has: 3) ; purse
							(localproc_3 59 27) ; "Have you changed your mind? Well, no matter. Come back any time."
						else
							(event claimed: 0)
						)
					)
					((and (not local4) (not local3))
						(localproc_3 59 28) ; "I am sorry, I must not have been listening properly. What did you wish to purchase?"
						(proc0_18)
					)
					((proc150_0 self self -10 15) 0)
					(
						(or
							(and local4 (< global132 4))
							(and local3 (< global132 2))
						)
						(localproc_3 59 29) ; "Forgive a humble merchant, habib, but this is not enough for what you wish to buy."
						(proc0_18)
					)
					(local4
						(= local4 0)
						(= global132 0)
						(SetScore 0 0 5)
						(gEgo setScript: buyHerbs)
					)
					(local3
						(= local3 0)
						(= global132 0)
						(SetScore 0 0 5)
						(gEgo setScript: buyCharcoal)
					)
				)
			)
			((Said 'give,show>')
				(cond
					((Said '/broom,charcoal,herb')
						(if (and global140 (gEgo has: global140))
							(localproc_3 59 30) ; "But, habib, I sold it to you. What sort of merchant would I be to take it back?"
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((or (not global140) (not (gEgo has: global140)))
						(event claimed: 1)
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((proc150_0 self self -10 15) 0)
					((Said '/relic')
						(SetScore 0 0 10 2 5)
						(gEgo setScript: giveRelic)
					)
					(else
						(event claimed: 1)
						(if (gEgo has: global140)
							(localproc_3 59 31) ; "Surely you need it more than I."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
				)
			)
			((or (Said 'get,buy/>') (Said 'ask[/tariq,merchant]/*>'))
				(cond
					((Said '//goods,item,business')
						(tariq setScript: talkToTariq)
					)
					((or (Said '/herb') (Said '//herb'))
						(if (IsItemAt 9) ; herbs | bone
							(localproc_3 59 32) ; "Some of these herbs are quite rare, but for you only 1 dirham."
							(= local4 1)
							(= local3 0)
						else
							(localproc_3 59 33) ; "I sold you the last bundle."
						)
					)
					((or (Said '/charcoal') (Said '//charcoal'))
						(if
							(or
								(IsItemAt 7) ; crystal_heart | charcoal | helm
								(and
									(not (IsItemAt 7 66)) ; crystal_heart | charcoal | helm
									(not (gEgo has: 7)) ; crystal_heart | charcoal | helm
								)
							)
							(localproc_3 59 34) ; "A good-sized bag of charcoal is only 2 fals."
							(= local3 1)
							(= local4 0)
						else
							(Print 59 35) ; "It is messy stuff to carry about. Once is enough."
						)
					)
					((or (Said '/broom') (Said '//broom'))
						(cond
							((not (IsItemAt 6)) ; iron_key | broom | grail
								(localproc_3 59 36) ; "But you took the only broom, habibi."
							)
							((IsFlag 141)
								(localproc_4 59 37 59 38 59 39) ; "I am not fooled. I saw you speaking with my cousin, Achmed the Oathbreaker, and I can guess what he has sent you here to do."
							)
							(else
								(localproc_3 59 40) ; "It is not for sale. I keep it here in plain sight and refuse to sell it because it annoys my cousin, Achmed, against whom I have a grudge."
							)
						)
					)
					((or (Said '/line') (Said '//line'))
						(localproc_3 59 41) ; "I had rope, but it was all stolen by a miserable little thief who preys upon this bazaar."
					)
					((Said 'get,buy/lamp,oil,jar,beaker,perfume,spice')
						(Print 59 42) ; "Do not overburden yourself with something you do not truly need."
					)
					((Said '//lamp,oil,jar,beaker,perfume,spice')
						(localproc_3 59 43) ; "They are of the finest quality."
					)
					((and (IsItemAt 12) (Said '//relic')) ; relic
						(localproc_3 59 44) ; "Thanks to you, habibi, my cousin and I will be friends again. I admit, I have missed visiting his inn."
					)
					((Said '//oath,grudge,relic')
						(localproc_3 59 45) ; "Achmed promised me that he would bring back a holy relic from his pilgrimage, but he did not, so I curse him as an oathbreaker."
					)
					((Said '//achmed,cousin')
						(if (IsItemAt 12) ; relic
							(localproc_3 59 44) ; "Thanks to you, habibi, my cousin and I will be friends again. I admit, I have missed visiting his inn."
						else
							(localproc_3 59 46) ; "He broke a solemn oath to me for which I cannot forgive him."
						)
					)
					((Said '//(merchant<apple),seeress,seeress')
						(localproc_3 59 47) ; "She is a strange old woman, but her apples are marvelous."
					)
					((Said '//prophet')
						(localproc_3 59 48) ; "Any relic would satisfy me, though a relic of the holy Elzer would make me truly joyous."
					)
					((Said '//lucernae')
						(localproc_3 59 49) ; "Why, surely you can guess that it means lamps."
					)
					((Said '//bandit')
						(localproc_3 59 50) ; "I would do much to get my hands on the thief who keeps stealing all my rope!"
					)
					(global140
						(event claimed: 1)
						(localproc_3 59 51) ; "Perhaps I can interest you in something else, habib. I have many fine wares."
					)
					((and (Said 'ask//*>') (not (proc152_2 event)))
						(event claimed: 1)
						(localproc_3 59 52) ; "Of what interest is that?"
					)
				)
			)
			((Said 'sell,bargain/>')
				(cond
					((and (IsFlag 20) (Said '/ass'))
						(localproc_3 59 26) ; "A thousand apologies, but I have no use for a mule."
					)
					((or (not global140) (not (gEgo has: global140)))
						(event claimed: 1)
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((Said '/apple,grain,lamb,lodestone,mirror,veil')
						(localproc_3 59 53) ; "I am sorry, but I am not interested."
					)
					((Said '/broom,charcoal,herb')
						(localproc_3 59 54) ; "Why should I buy back what I am selling?"
					)
					((Said '/relic')
						(localproc_3 59 55) ; "A genuine relic! It is not as pleasurable as receiving it from my cousin, Achmed, but....I will give you 1 dirham."
						(PutItem global140)
						(++ gSilver)
						(SetFlag 136)
					)
					(global140
						(event claimed: 1)
						(localproc_3 59 56) ; "No, keep it. I have no need for it."
					)
				)
			)
		)
	)
)

(instance talkToTariq of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(localproc_3 59 57 59 58) ; "Sa'alam aleikem, good sir. You look like a man of taste. Notice the fine craftsmanship of my lamps. My lamp oils are of the purest quality."
			)
			(1
				(localproc_3 59 59 59 60 59 61 59 62) ; "Are not these herbs sublimely fragrant? They sweeten the air and lend freshness to even the foulest room."
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance buyHerbs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj endTalk:)
				(proc151_0 2 self self)
			)
			(1
				(= seconds 1)
			)
			(2
				(tariq setLoop: 4 setCel: 0 setCycle: CT 4 1 self)
			)
			(3
				(hangingHerbs dispose:)
				(tariq setCycle: End self)
			)
			(4
				(= seconds 1)
			)
			(5
				(proc151_0 2 self self)
			)
			(6
				(gTObj talkCue: self)
				(localproc_3 59 63) ; "Here are the herbs, habibi. A pleasure to do business with you."
				(gEgo get: 9) ; herbs | bone
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance buyCharcoal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj endTalk:)
				(proc151_0 2 self self)
			)
			(1
				(lowerBody hide:)
				(tariq
					setLoop: 5
					cel: 0
					posn: (tariq x:) (tariq y:) 0
					setCycle: End self
				)
			)
			(2
				(tariq setLoop: 0 posn: (tariq x:) (tariq y:) 27)
				(lowerBody show:)
				(localproc_3 59 64) ; "Here is the charcoal. Return any time I may be of further service."
				(proc151_0 1 self self)
			)
			(3
				(tariq setLoop: 0 cel: 0)
				(gEgo get: 7) ; crystal_heart | charcoal | helm
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance giveRelic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc151_0 2 self self)
				(gTObj endTalk:)
			)
			(1
				(tariq setLoop: 2 setCycle: End self)
			)
			(2
				(gTObj talkCue: self)
				(localproc_3 59 65) ; "Good sir, I am speechless! Surely my cousin, Achmed, has sent this through you as an offering of peace between us."
				(SetFlag 153)
				(++ global146)
				(PutItem 12) ; relic
			)
			(3
				(gTObj talkCue: self)
				(localproc_3 59 66) ; "Now I am ashamed that I behaved in such a petty way. Please, I beg you, take this broom and give it to Achmed and he will know that this is my apology."
			)
			(4
				(lowerBody hide:)
				(tariq
					setLoop: 6
					cel: 0
					posn: (tariq x:) (tariq y:) 0
					cycleSpeed: 2
					setCycle: CT 5 1 self
				)
			)
			(5
				(broom dispose:)
				(tariq setCycle: End self)
			)
			(6
				(tariq setLoop: 7 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(7
				(gEgo cycleSpeed: 2)
				(proc151_0 2 self self)
			)
			(8
				(lowerBody show:)
				(tariq
					setLoop: 0
					cel: 0
					cycleSpeed: 0
					posn: (tariq x:) (tariq y:) 27
				)
				(gEgo get: 6) ; iron_key | broom | grail
				(gEgo cycleSpeed: 0)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance tamra of Act
	(properties
		y 141
		x 192
		view 363
		loop 4
		illegalBits 0
	)

	(method (init)
		(super init:)
		(tamra stopUpd:)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (gEgo inRect: 152 0 320 200))
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
					(Said 'look/seeress')
					(Said 'ask/merlin/seeress')
					(and
						temp0
						(or
							(Said 'look/merchant[<apple]')
							(Said 'ask/merlin/merchant[<apple]')
						)
					)
				)
				(Print 59 67) ; "I detect an unusual look of wisdom in this old woman's eyes."
			)
			(
				(or
					(Said 'look/basket')
					(and (not (gEgo has: 4)) (Said 'look/apple')) ; rose | apple | green_apple
				)
				(Print 59 68) ; "The small green apples in her basket are native to this region and rather tart, I believe."
			)
			((Said 'talk,ask,look/girl')
				(Print 59 18) ; "You surely do not refer to the old woman selling apples? It has been many decades since she was a girl."
			)
			((not temp0)
				(return)
			)
			((Said 'look/business,goods')
				(Print 59 68) ; "The small green apples in her basket are native to this region and rather tart, I believe."
			)
			((Said 'kill,attack/seeress')
				(Print 59 69) ; "That would be most unwise."
			)
			((Said 'talk[/seeress,merchant]')
				(cond
					((IsItemAt 4 65) ; rose | apple | green_apple
						(gEgo setScript: getSecondApple)
					)
					((IsFlag 137)
						(localproc_1 59 70) ; "I hope you find what you seek, but I have no further help to give you."
					)
					((and (not (IsFlag 136)) (IsFlag 156))
						(if (not (IsFlag 135))
							(gEgo setScript: getSecondApple)
						else
							(localproc_1 59 71) ; "Seek Fatima now! You have no time to waste."
						)
					)
					((and (IsFlag 136) (IsFlag 156))
						(localproc_1 59 72) ; "Your greed has betrayed you. You chose to sell what you should have given freely. You are not worthy. Be gone from my sight."
						(= global190 1000)
					)
					((and (IsFlag 134) (not (IsFlag 135)))
						(localproc_1 59 73) ; "Nothing more will I say or give until you have completed every task."
					)
					((== global142 3)
						(localproc_1 59 74) ; "You have made your choice. Now you must live with it."
					)
					(else
						(SetFlag 140)
						(switch local0
							(0
								(localproc_1 59 75 59 76 59 77) ; "King Arthur, I know your purpose here. It is given to me to know such things, for I am a seeress."
							)
							(else
								(localproc_1 59 78) ; "Buying the apple is but the first test I shall place before you, if you are ready."
							)
						)
						(++ local0)
					)
				)
			)
			(
				(or
					(Said 'get,buy/apple')
					(Said 'ask[/seeress,merchant]/apple,goods,item,business')
				)
				(cond
					((IsItemAt 4 65) ; rose | apple | green_apple
						(gEgo setScript: getSecondApple)
					)
					((gEgo has: 4) ; rose | apple | green_apple
						(localproc_1 59 79) ; "You have the apple that ends hunger, slakes thirst, and eases weariness. May it comfort you in time of greatest need."
					)
					(global142
						(localproc_1 59 80) ; "You have purchased the only apple I will sell you."
					)
					(else
						(localproc_1 59 81 59 82 59 83 59 84) ; "One apple, and one only, I will sell you. Here are your choices."
						(= local2 1)
					)
				)
			)
			((and global140 (Said 'get,buy'))
				(localproc_1 59 85) ; "It is obvious what I have and do not have."
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(cond
					((not (DoPurse))
						(if (gEgo has: 3) ; purse
							(localproc_1 59 86) ; "Give me nothing and you gain nothing."
						else
							(event claimed: 0)
						)
					)
					((IsFlag 144)
						(localproc_1 59 87) ; "You have already bought the only apple I will sell you."
						(proc0_18)
					)
					((not local2)
						(localproc_1 59 88) ; "If you wish to buy an apple, please say so."
						(proc0_18)
					)
					(else
						(= local2 0)
						(SetFlag 144)
						(gEgo setScript: buyApple)
					)
				)
			)
			((Said 'give,sell,bargain,show/>')
				(cond
					((Said '/ass')
						(if (IsFlag 20)
							(localproc_1 59 89) ; "Nay, I need it not."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((or (not global140) (not (gEgo has: global140)))
						(event claimed: 1)
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((Said '/relic')
						(localproc_1 59 90) ; "Such things are not sacred to the Goddess."
					)
					(else
						(event claimed: 1)
						(localproc_1 59 56) ; "No, keep it. I have no need for it."
					)
				)
			)
			((Said 'ask[/seeress,merchant]/*>')
				(cond
					((Said '//grail')
						(SetScore 273 1 1)
						(localproc_1 59 91) ; "I am a lesser servant of the Goddess and do not know where it is to be found. Only Fatima can provide the guidance you need."
					)
					((Said '//goddess')
						(localproc_1 59 92) ; "She is the great mother of all, whom we call Aphrodite"
					)
					((Said '//aphrodite')
						(localproc_1 59 93) ; "She is the Great Goddess, mother of the universe, creator of gods."
					)
					((Said '//servant')
						(localproc_1 59 94) ; "I serve Aphrodite."
					)
					((Said '//fatima')
						(cond
							((IsFlag 137)
								(localproc_1 59 95) ; "You have seen her. What more is there to say?"
							)
							((not (IsFlag 135))
								(localproc_1 59 96) ; "You will learn about Fatima if you are found worthy."
							)
							(else
								(localproc_1 59 97) ; "You will find her with the symbols of the Goddess, the star and crescent."
							)
						)
					)
					((Said '//galahad')
						(SetScore 274 1 1)
						(localproc_1 59 98) ; "He came here only recently, after long weeks of search in other places. But I have not seen him for many days."
					)
					((Said '//gawain,lancelot')
						(localproc_1 59 99) ; "I know nothing of them."
					)
					((Said '//hierophant')
						(localproc_1 59 100) ; "You must be a wise man to find a wise man."
					)
					((and (IsFlag 137) (Said '//(incantation<truth)'))
						(localproc_1 59 101) ; "Whosoever you speak with in this bazaar will be compelled to speak the truth about what he or she most deeply needs or wants."
					)
					((and (IsFlag 134) (Said '//job,test'))
						(localproc_1 59 70) ; "I hope you find what you seek, but I have no further help to give you."
					)
					((and (IsFlag 134) (Said '//job,test'))
						(localproc_1 59 102) ; "Your task is to do as your soul and heart dictate. Only you can decide what that means."
					)
					((Said '//(merchant<lamp),tariq')
						(localproc_1 59 103) ; "Speak with him and judge his character for yourself."
					)
					((Said '//wisdom,truth')
						(localproc_1 59 104) ; "Only by seeking it will you be able to attain it."
					)
					((Said '//guardian')
						(localproc_1 59 105) ; "There are six Guardians whose tests you must pass. I am one of them."
					)
					((Said '//bandit')
						(localproc_1 59 106) ; "It was not planned as a part of your test, if that is what you wonder."
					)
					((and (Said 'ask//*>') (not (proc152_2 event)))
						(event claimed: 1)
						(localproc_1 59 107) ; "A seeress knows which questions are worth answering and which should be ignored."
					)
				)
			)
		)
	)
)

(instance buyApple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj endTalk:)
				(gEgo illegalBits: 0 setMotion: MoveTo 220 152 self)
			)
			(1
				(gEgo loop: 3 illegalBits: $8000)
				(RedrawCast)
				(tamra setLoop: 0 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(2
				(= seconds 3)
			)
			(3
				(localproc_0)
				(gTObj tLoop: 3 talkCue: self)
				(Talk 59 108) ; "Take this, and by my command, eat of it."
			)
			(4
				(= cycles 2)
			)
			(5
				(tamra setLoop: 1 cel: 2)
				(= seconds 1)
			)
			(6
				(gEgo
					view: 70
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(7
				(tamra setLoop: 4)
				(gEgo setCycle: Beg self)
			)
			(8
				(gEgo view: 0 loop: 1)
				(proc142_0 self)
			)
			(9
				(gEgo view: 0 loop: 1 cycleSpeed: 0 setCycle: 0)
				(cond
					((> global132 15)
						(SetScore 0 0 5 1 5 2 5)
						(gTObj talkCue: self)
						(localproc_1 59 109 59 110) ; "You have chosen wisely, for the apple has conferred upon you a Truth Spell. Whoever you speak with in this bazaar from this moment on will confide to you his or her most secret and urgent need."
						(SetFlag 134)
						(= local1 0)
						(= global142 1)
					)
					((<= global132 3)
						(gTObj talkCue: self)
						(localproc_1 59 111) ; "You have eaten, but gained nothing. You failed my test and you will never possess the Grail. Your hopes die here."
						(= global142 3)
						(SetFlag 167)
						(= global190 2000)
					)
					(else
						(Print 59 112) ; "She spoke true. The apple has eased all your hunger and thirst. New strength flows into your limbs."
						(gTObj talkCue: self)
						(localproc_1 59 113) ; "You feel refreshed, yet you have failed miserably to pass my test. Your quest ends here. The Grail is denied to you."
						(SetFlag 167)
						(= global142 3)
						(= global190 2000)
					)
				)
			)
			(10
				(= global132 0)
				(gEgo cycleSpeed: 0 setCycle: Walk setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance getSecondApple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(if (not (IsFlag 135))
					(localproc_1 59 114 59 115) ; "I greet you with reverence, King Arthur, for you are indeed worthy. Knowledge is your reward."
				else
					(localproc_1 59 116) ; "So you have suffered a misfortune? Very well, I will help you again."
				)
			)
			(1
				(if (not (IsFlag 135))
					(gTObj talkCue: self)
					(localproc_1 59 117) ; "Take also this gift."
				else
					(= seconds 2)
				)
			)
			(2
				(tamra setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo illegalBits: 0 setMotion: MoveTo 216 152 self)
			)
			(4
				(gEgo loop: 3 illegalBits: $8000)
				(= cycles 4)
			)
			(5
				(proc151_0 1 self self)
			)
			(6
				(tamra setLoop: 4 cel: 0)
				(gEgo view: 0 loop: 1)
				(gTObj talkCue: self)
				(if (not (IsFlag 135))
					(localproc_1 59 118) ; "It is the apple that ends hunger, slakes thirst, and eases weariness. May it comfort you in time of greatest need. The Goddess be with you."
				else
					(localproc_1 59 119 59 120) ; "Here is an apple that will relieve all hunger and thirst and renew your strength."
				)
			)
			(7
				(gEgo get: 4) ; rose | apple | green_apple
				(= global142 2)
				(SetFlag 135)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

