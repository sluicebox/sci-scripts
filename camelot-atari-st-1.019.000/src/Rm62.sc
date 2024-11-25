;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62)
(include sci.sh)
(use Main)
(use n117)
(use n128)
(use n150)
(use Bazaar)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm62 0
	proc62_1 1
	proc62_2 2
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (localproc_0)
	(Face gEgo ismail)
	(gTObj
		tWindow: ismailWindow
		actor: ismail
		tLoop: (Random 3 4)
		cSpeed: 1
	)
	(if (== (ismail script:) ismailWalkIn)
		(gTObj actor: 0)
	)
)

(procedure (proc62_1)
	(localproc_0)
	(Talk &rest)
)

(procedure (localproc_1)
	(Face gEgo fawaz)
	(if (and (not local2) (== (fawaz script:) 0))
		(fawaz setScript: angryTalk)
	)
	(gTObj tWindow: fawazWindow actor: fawazHead tLoop: 0 cSpeed: 2)
)

(procedure (proc62_2)
	(localproc_1)
	(Talk &rest)
)

(instance chicken of PV
	(properties
		y 84
		x 275
		view 162
	)
)

(instance beef of PV
	(properties
		y 109
		x 209
		view 162
		loop 1
	)
)

(instance lamb of View
	(properties
		y 84
		x 228
		view 162
		loop 2
	)
)

(instance curtain of PV
	(properties
		y 54
		x 56
		view 162
		loop 8
		priority 10
		signal 16
	)
)

(instance table of PV
	(properties
		y 132
		x 74
		view 162
		loop 6
		priority 9
		signal 16
	)
)

(instance bust of PV
	(properties
		y 106
		x 69
		view 162
		loop 6
		cel 1
		priority 9
		signal 16
	)
)

(instance lowerBody of View
	(properties
		y 127
		x 89
		view 365
		loop 2
		signal 18432
	)
)

(instance ismailFace of Prop
	(properties
		y 128
		x 88
		z 39
		view 365
		loop 5
		signal 18432
		cycleSpeed 1
	)
)

(instance fawazHead of Prop
	(properties
		y 85
		x 256
		view 366
		priority 9
	)
)

(instance dog of Prop
	(properties
		y 139
		x 200
		view 162
		loop 4
	)
)

(instance dogTail of Prop
	(properties
		y 138
		x 184
		view 162
		loop 5
		cycleSpeed 4
	)
)

(instance windowCurtain of View
	(properties
		y 95
		x 154
		view 162
		loop 7
	)
)

(instance ismailWindow of SysWindow
	(properties
		back 14
		title {Ismail ibn Hamid}
		brTop 5
		brLeft 10
		brBottom 80
		brRight 180
	)
)

(instance fawazWindow of SysWindow
	(properties
		color 15
		back 4
		title {Fawaz ibn Nafi}
		brTop 10
		brLeft 140
		brBottom 85
		brRight 310
	)
)

(instance Rm62 of Rm
	(properties
		picture 62
	)

	(method (init)
		(super init:)
		(Load rsVIEW 366)
		(Load rsVIEW 365)
		(= global112 2)
		(= local2 (IsItemAt 9 58)) ; herbs | bone
		(gCurRoom setRegions: 152) ; Bazaar
		(switch gPrevRoomNum
			(61
				(gEgo posn: (- 320 (gEgo x:)) 180 loop: 3)
			)
			(63
				(if (< (gEgo y:) 142)
					(gEgo y: 142)
				)
				(if (> (gEgo y:) 175)
					(gEgo y: 175)
				)
				(gEgo posn: 20 (gEgo y:) loop: 0)
			)
			(59
				(gEgo posn: 300 (gEgo y:) loop: 1)
			)
			(else
				(gEgo posn: 150 170)
			)
		)
		(if (not (IsFlag 137))
			(ismail init:)
			(curtain cel: 0)
		else
			(curtain cel: 255)
			(gEgo illegalBits: $c000)
		)
		(if (not (IsFlag 137))
			(lamb init: startUpd:)
		)
		(if (not (IsItemAt 10)) ; lamb | dove
			(lamb setCel: 1)
		)
		(dog init: stopUpd:)
		(dogTail init: setScript: dogScript)
		(if (and local2 (not (IsFlag 20)) (< global170 2) (== (Random 1 8) 1))
			(++ global170)
			(SetFlag 159)
		)
		(if (not (IsFlag 159))
			(gAddToPics add: windowCurtain)
		)
		(gAddToPics add: beef chicken table bust curtain)
		(gAddToPics doit:)
		(fawaz init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((> (gEgo x:) 310)
				(gCurRoom newRoom: 59)
			)
			((< (gEgo x:) 20)
				(gCurRoom newRoom: 63)
			)
			((> (gEgo y:) 180)
				(gCurRoom newRoom: 61)
			)
		)
		(if
			(and
				(gTObj tCount:)
				(or
					(and (== (gTObj actor:) ismail) (> (gEgo x:) 130))
					(and
						(== (gTObj actor:) fawazHead)
						(<= (gEgo x:) 130)
					)
				)
			)
			(gTObj endTalk: actor: 0)
		)
	)

	(method (notify)
		(cond
			((gEgo inRect: 0 0 130 200)
				(localproc_0)
			)
			((gEgo inRect: 130 0 320 200)
				(localproc_1)
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
			((Said 'look<above,behind/counter')
				(Print 62 0) ; "There is nothing to see."
			)
			((Said 'call,yell[/ismail]')
				(Print 62 1) ; "No one answers."
			)
			(
				(or
					(Said 'look<across/street')
					(Said 'look/caupona')
					(Said 'ask/merlin/caupona')
				)
				(Print 62 2) ; "Across the street is an inn."
			)
			(
				(or
					(Said 'look[<around][/!*][/!*]')
					(Said 'look/room,bazaar,street,jerusalem')
					(Said 'ask[/merlin]/room,bazaar,street,jerusalem')
				)
				(Print 62 3) ; "There is some sort of antiquities shop and a butcher's shop."
			)
			((Said '*/ismail')
				(cond
					((IsFlag 137)
						(Print 62 4) ; "I have the most profound suspicion that Ismail will not return."
					)
					((not (gCast contains: ismail))
						(Print 62 5) ; "He has vanished into his back room."
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance dogEndLoop of End
	(properties)
)

(instance dogBegLoop of Beg
	(properties)
)

(instance dogScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dog stopUpd:)
				(= seconds (Random 4 8))
			)
			(1
				(dog setCel: 0 cycleSpeed: 3 setCycle: dogEndLoop self)
			)
			(2
				(= seconds (Random 4 8))
			)
			(3
				(dog setCycle: dogBegLoop self)
			)
			(4
				(= seconds (Random 4 8))
			)
			(5
				(self changeState: 0)
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
			(
				(or
					(MouseClaimed dog event)
					(Said 'look/dog')
					(Said 'ask/merlin/dog')
				)
				(Print 62 6) ; "The dog looks like it is well fed from the butcher's scraps."
			)
			((Said 'pet/dog')
				(Print 62 7) ; "Nice try, but I do not think that being nice to Fawaz's dog will do anything to improve Fawaz's temper."
			)
			((Said '*/dog')
				(Print 62 8) ; "Do not bother the dog, he may bite."
			)
		)
	)
)

(instance ismail of Act
	(properties
		view 365
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setScript: ismailWalkIn)
	)

	(method (doit)
		(super doit:)
		(cond
			(
				(and
					(== (gTObj actor:) ismail)
					(gTObj tCount:)
					(not (ismailFace cycler:))
				)
				(ismailFace setCycle: Fwd)
			)
			((and (ismailFace cycler:) (== (gTObj tCount:) 0))
				(ismailFace setCycle: 0 setCel: 0)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (gEgo inRect: 0 0 130 200))
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
					(OnButton event 80 75 95 128)
					(Said 'look/ismail')
					(Said 'ask/merlin/ismail')
					(and
						temp0
						(or
							(Said 'look/man,merchant')
							(Said 'ask/merlin/man,(merchant[<relic])')
						)
					)
				)
				(Print 62 9) ; "Would you buy a used chariot from this man?"
			)
			(
				(or
					(and temp0 (Said 'look,read/sign,lettering'))
					(OnButton event 44 7 114 32)
				)
				(Print 62 10) ; "It loosely translates as "Ismail, King of Antiquities". The rest is Arabic and Hebrew graffiti."
			)
			((OnButton event 12 24 40 45)
				(Print 62 11) ; "Alas, I have let my Greek fade with disuse and cannot translate."
			)
			((OnButton event 13 110 47 128)
				(Print 62 12) ; "My Arabic is not quite good enough to translate that."
			)
			((OnButton event 144 63 166 98)
				(Print 62 13) ; "It is dark and empty."
			)
			(
				(and
					(not (IsFlag 137))
					(or (Said 'look/bust') (OnButton event 60 83 78 102))
				)
				(Print 62 14) ; "You should recognize the countenance of the greatest of Roman generals, Julius Caesar."
			)
			(
				(or
					(and temp0 (Said 'look<in/window'))
					(OnButton event 18 65 33 95)
				)
				(Print 62 15) ; "It is pitch black inside."
			)
			((not temp0)
				(return)
			)
			((Said 'look/business,goods,building')
				(if (not (IsFlag 137))
					(Print 62 16) ; "He has nothing displayed except a Roman bust. Behind that is only a short, empty hall leading to a door. He must keep his antiquities locked in another room."
				else
					(Print 62 17) ; "Ismail's shop is closed."
				)
			)
			((Said 'look/design')
				(Print 62 18) ; "There are no symbols on the antiquities shop."
			)
			(
				(or
					(Said 'look/relic,bone,finger,blood,sliver,cross,antique')
					(Said
						'ask/merlin/relic,bone,finger,blood,sliver,cross,antique'
					)
				)
				(Print 62 19) ; "There are no wares in sight. He must keep them in a back room."
			)
			((Said 'talk[/ismail,man,merchant]')
				(if (IsFlag 134)
					(switch local0
						(0
							(proc62_1 62 20 62 21) ; "Truly if I could have anything in the world, I would have your money. Yes, that is what I most desire. Your money."
							(= local0 1)
						)
						(else
							(proc62_1 62 22) ; "My storehouse of relics is a miracle unto itself! If it is holy, I will have it."
						)
					)
				else
					(switch local0
						(0
							(proc62_1 62 23 62 24 62 25) ; "Ahalan, habibi. I am Ismail and within my vaults I have wonders, I have miracles, I have relics of the holy saints and prophets."
							(= local0 1)
						)
						(else
							(proc62_1 62 22) ; "My storehouse of relics is a miracle unto itself! If it is holy, I will have it."
						)
					)
				)
				(= local0 1)
			)
			((Said 'call,yell[/ismail]')
				(proc62_1 62 26) ; "No need to yell, habibi. I am right here."
			)
			((Said 'draw/blade')
				(if (!= (ismail script:) ismailWalkIn)
					(gEgo setScript: runFromSword)
				else
					(event claimed: 0)
				)
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(cond
					((not (DoPurse))
						(if (gEgo has: 3) ; purse
							(proc62_1 62 27) ; "Habibi, you accidentally closed your purse without giving me money."
						else
							(event claimed: 0)
						)
					)
					((and global151 (!= global151 2) (not (IsItemAt 12))) ; relic
						(Print 62 28) ; "Buying one relic from this fraud is more than enough."
						(proc0_18)
					)
					((proc150_0 self self -6 12) 0)
					(
						(or
							(and (== global151 3) (< global132 32))
							(and (== global151 1) (< global132 16))
							(and (== global151 2) (< global132 16))
						)
						(proc62_1 62 29) ; "Keep counting, habibi, keep counting."
						(proc0_18)
					)
					((== global151 0)
						(proc62_1 62 30) ; "What do you wish to buy, habibi?"
						(proc0_18)
					)
					(else
						(= global132 0)
						(SetScore 0 0 5)
						(gEgo setScript: buyRelicFromIsmail)
					)
				)
			)
			((or (Said 'get,buy/>') (Said 'ask[/ismail,man,merchant]/*>'))
				(cond
					((or (Said '/grail') (Said '//grail'))
						(if (not (IsFlag 161))
							(= global185 ismail)
							(= global186 lowerBody)
							(= global187 ismailFace)
							(gEgo setScript: (ScriptID 168 0)) ; grailConversation
						else
							(proc62_1 62 31) ; "Sorry, I am all out of grails today. Try me again in a few weeks. Something is bound to turn up."
						)
					)
					((or (Said '/blood') (Said '//blood'))
						(proc62_1 62 32) ; "Ah, well, the truth is I am forbidden by law to sell relics of the Great Prophet Mohammed. But I have a special on saints' relics."
					)
					((or (Said '/sliver,cross') (Said '//sliver,cross'))
						(= global185 ismail)
						(= global186 lowerBody)
						(= global187 ismailFace)
						(gEgo setScript: (ScriptID 167 0)) ; buyingBogusRelic
					)
					(
						(or
							(Said '/hair,beard,guruka')
							(Said '/(hair,beard,relic)<guruka')
							(Said '//hair,beard,guruka')
						)
						(proc62_1 62 33) ; "That is rare and valuable. Have you ever tried to shave a Sikh? It is most dangerous. Normally, I would ask no less than 10 dinars! But for you, only 4 dinars."
						(= global151 3)
					)
					(
						(or
							(Said '/relic,fingerbone,prophet,goods,item')
							(Said
								'//relic,fingerbone,prophet,goods,item,business'
							)
						)
						(if (not (IsItemAt 12)) ; relic
							(Print 62 28) ; "Buying one relic from this fraud is more than enough."
						else
							(= global185 ismail)
							(gEgo setScript: (ScriptID 209 0)) ; getWhatRelic
						)
					)
					((or (Said '/fingernail') (Said '//fingernail'))
						(proc62_1 62 34) ; "I sell holy fingerbones! Not fingernails. Of course, for the right price, it could be arranged."
					)
					(
						(or
							(Said '/lamb,ham,chicken,goat,beef,venison')
							(Said '//lamb,ham,chicken,goat,beef,venison')
						)
						(proc62_1 62 35) ; "Do I look like a pig-headed Nubian? Go next door."
					)
					((Said '//butcher,(merchant<meat)')
						(proc62_1 62 36) ; "He is a bad-tempered, pig-headed Nubian? Ah, but you should see his daughter!"
					)
					((Said '//galahad')
						(proc62_1 62 37) ; "Saint Galahad? Did you wish a relic of Saint Galahad? I can sell you one, only 2 dirhams."
						(= global151 1)
					)
					((Said '//bust')
						(proc62_1 62 38) ; "Ahhh, this is an authentic bust of the great Julius Caesar. Pure marble. Only 5 dinars."
					)
					((Said '/bust')
						(Print 62 39) ; "I doubt that it is worth any price that this crook asks for it."
					)
					((or (Said '/antique') (Said '//antique'))
						(proc62_1 62 40) ; "I sell antiquities from the holy land. Holy relics and holy fingerbones!"
					)
					((Said '//antiquarius,antiquarius')
						(proc62_1 62 41) ; "I am the king of antiquities! No one can beat my selection or prices!"
					)
					((Said '//bandit')
						(proc62_1 62 42) ; "Thief? Heh-heh, that is a harsh word. I am an honest merchant, that I can assure you."
					)
					(global140
						(event claimed: 1)
						(proc62_1 62 43) ; "You are in the wrong place. I deal in antiquities only."
					)
					((and (Said 'ask//*>') (not (proc152_2 event)))
						(event claimed: 1)
						(proc62_1 62 44) ; "Do not worry about that, habib. My relics, though, are something to talk about!"
					)
				)
			)
			((Said 'give,sell,bargain/ass')
				(if (IsFlag 20)
					(proc62_1 62 45) ; "Please keep it, habibi. I do not get along well with animals."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'sell/relic')
				(if (gEgo has: 12) ; relic
					(proc62_1 62 46) ; "That is like selling bricks to the Bedouin. I have a room full of relics. Want to buy another?"
				)
			)
			((and global140 (Said 'sell,bargain'))
				(if (gEgo has: global140)
					(proc62_1 62 47) ; "I cannot say that what you offer is entirely without interest, but it does not fit my speciality."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'give,show')
				(cond
					((or (not global140) (not (gEgo has: global140)))
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((proc150_0 self self -6 12) 0)
					(else
						(proc62_1 62 48) ; "What? You want nothing in return? Is this a trick? Nobody gives away something for nothing. No, I will not take it."
					)
				)
			)
			((Said 'get,kill,attack,annihilate/dog')
				(proc62_1 62 49) ; "Please do. I hate that dog."
			)
			((Said 'smell')
				(Print 62 50) ; "This man is unfamiliar with the concept of cleanliness. He has the aroma of a billy goat."
			)
		)
	)
)

(instance ismailWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 16)
				(ismail setLoop: 0 setPri: 5)
			)
			(1
				(if (Random 1 3)
					(ismail
						posn: 85 116
						setCycle: Walk
						setMotion: MoveTo 88 128 self
					)
				else
					(ismail posn: 88 128)
					(self cue:)
				)
			)
			(2
				(ismailFace init: stopUpd:)
				(ismail setLoop: 1 setCel: 0 z: 26 setCycle: 0 stopUpd:)
				(lowerBody
					init:
					posn: 88 128
					setPri: (ismail priority:)
					stopUpd:
				)
				(client setScript: 0)
			)
		)
	)
)

(instance runFromSword of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(lowerBody hide:)
				(ismailFace hide:)
				(ismail
					view: 383
					setLoop: 0
					setCel: 0
					posn: 88 128 0
					setCycle: End self
				)
			)
			(1
				(ismail
					setLoop: 1
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 88 114 self
				)
			)
			(2
				(ismail dispose:)
				(RedrawCast)
				(Print 62 51) ; "Brilliant move, Arthur. The sight of your sword has sent him into hiding in his back room."
				(= global125 2)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance buyRelicFromIsmail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= global185 ismail)
				(= global186 lowerBody)
				(= global187 ismailFace)
				(gEgo
					setScript: 0
					setScript:
						(if (== global151 2)
							(ScriptID 168 1) ; buyGrail
						else
							(ScriptID 167 1) ; buyRelic
						)
				)
				(= global151 0)
			)
		)
	)
)

(instance fawaz of Act
	(properties
		y 126
		x 256
		view 366
		loop 2
		illegalBits 0
	)

	(method (init)
		(super init:)
		(fawaz ignoreActors: stopUpd:)
		(if local2
			(fawaz setLoop: 2 setCel: 0)
		)
		(fawazHead init: posn: (fawaz x:) (fawaz y:) 42 setPri: 7 stopUpd:)
		(if (IsFlag 159)
			(= global188 windowCurtain)
			((ScriptID 169 0) init:) ; daughter
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(IsFlag 159)
				(not (gEgo script:))
				(== (gEgo loop:) 3)
				(gEgo inRect: 146 140 165 145)
			)
			(= global185 fawaz)
			(= global186 fawazHead)
			(gEgo setScript: (ScriptID 169 1)) ; peepingTom
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (gEgo inRect: 130 0 320 200))
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
					(MouseClaimed fawazHead event)
					(Said 'look/butcher')
					(Said 'ask/merlin/butcher')
					(and
						temp0
						(or
							(Said 'look/man,merchant')
							(Said 'ask/merlin/man,(merchant[<meat])')
						)
					)
				)
				(Print 62 52) ; "He is an extraordinarily mean-looking Nubian."
			)
			(
				(or
					(and temp0 (Said 'look,read/sign,lettering'))
					(OnButton event 223 15 293 28)
					(OnButton event 182 43 307 54)
				)
				(Print 62 53) ; ""Tabulae Lanius" is a term meaning "butcher", though more literally from the Latin it is "butcher's block". I cannot read the Hebrew graffiti above the door."
			)
			((or (Said 'look/design') (OnButton event 220 28 277 35))
				(Print 62 54) ; "It is a symbol unknown to me. It looks like a flying eye."
			)
			((or (Said 'look/goat') (OnButton event 200 62 215 106))
				(Print 62 55) ; "That is quite a large goat."
			)
			((or (Said 'look/chicken') (OnButton event 261 65 284 81))
				(Print 62 56) ; "There are three chickens hung upon hooks."
			)
			(
				(or
					(Said 'look/lamb')
					(and (not (IsFlag 137)) (OnButton event 222 63 232 84))
				)
				(if (not (IsFlag 137))
					(Print 62 57) ; "There is one leg of lamb hanging on a hook."
				else
					(Print 62 58) ; "He has sold all of his lamb."
				)
			)
			((Said 'look/blade,dagger,cleaver')
				(Print 62 59) ; "Beware of that cleaver, Arthur. I fear the Nubian may use it on more than animal flesh."
			)
			(
				(or
					(Said 'look[<in,at]/window,curtain')
					(and (IsFlag 159) (Said 'look/girl,daughter'))
				)
				(cond
					((not (IsFlag 159))
						(Print 62 60) ; "It is dark inside. You can see nothing."
					)
					((== (gEgo script:) (ScriptID 169 1)) ; peepingTom
						(Print 62 61) ; "You already are."
					)
					(else
						(gEgo setScript: (ScriptID 169 1)) ; peepingTom
					)
				)
			)
			((not (gEgo inRect: 130 0 320 200))
				(return)
			)
			((Said 'look/business,goods,meat,building')
				(if (IsFlag 137)
					(Print 62 62) ; "The butcher has sold his stock of meat for the day."
				else
					(Print 62 63) ; "He has a goat, a leg of lamb and chickens hanging in his shop."
				)
			)
			((Said 'talk[/butcher,man,merchant]')
				(cond
					((or (IsFlag 137) (not (IsItemAt 10))) ; lamb | dove
						(proc62_2 62 64) ; "If you have come back for more meat, you are out of luck. I have sold it all."
					)
					((not (IsFlag 134))
						(proc62_2 62 65) ; "Be gone, heathen. I do not like the look of you and I serve only who I please and today it does not please me to serve anyone."
					)
					((not (IsItemAt 9 58)) ; herbs | bone
						(proc62_2 62 66 62 67) ; "Do you wonder why I am angry? It is the stink of fish I must endure every day. The foul, damnable stink of fish would drive any man to fury!"
					)
					(else
						(proc62_2 62 68) ; "Ya'Allah! The wind blows sweet today. As for you, you look like a foreign heathen, but if you have good coin I will sell to you."
					)
				)
			)
			((Said 'draw/blade')
				(if (not local4)
					(= local4 1)
					(proc62_2 62 69) ; "Put up your weapon, infidel dog, or I will call the city guard. And I will chop up whatever pieces of you they leave behind."
					(++ global168)
					(= global125 2)
				else
					(event claimed: 0)
				)
			)
			((Said 'buy/dog')
				(proc62_2 62 70) ; "He is not for sale."
			)
			((Said 'get,kill,attack,annihilate/dog')
				(if (not local5)
					(proc62_2 62 71) ; "Touch my dog and you die, infidel."
				else
					(proc62_2 62 72) ; "GUARDS!"
					(EgoDead 62 73) ; "Mercenaries chop you up here."
				)
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(cond
					((not local2)
						(if local1
							(proc62_2 62 74) ; "I told you to be gone! I do not want your money or your business."
						else
							(= local1 1)
							(proc62_2 62 65) ; "Be gone, heathen. I do not like the look of you and I serve only who I please and today it does not please me to serve anyone."
						)
						(proc0_18)
					)
					((not (DoPurse))
						(if (gEgo has: 3) ; purse
							(proc62_2 62 75) ; "I am not amused, stranger. Either do business or get lost."
						else
							(event claimed: 0)
						)
					)
					((and local6 (not (IsItemAt 10))) ; lamb | dove
						(proc62_2 62 76) ; "You are beginning to annoy me again, little man. Go away."
						(proc0_18)
					)
					((proc150_0 self self -10 16) 0)
					((and local6 (< global132 6))
						(proc62_2 62 77) ; "I do not bargain. Pay my price or be gone."
						(proc0_18)
					)
					(local6
						(= local6 0)
						(= global132 0)
						(= global185 fawaz)
						(= global186 fawazHead)
						(= global187 lamb)
						(SetScore 0 0 5)
						(gEgo setScript: (ScriptID 170 0)) ; buyLamb
					)
					(else
						(proc62_2 62 78) ; "So, do you want to buy something? Speak up!"
						(proc0_18)
					)
				)
			)
			((and (not local2) (Said 'ask[/butcher,man,merchant]'))
				(proc62_2 62 79) ; "Stop bothering me!"
			)
			((and (not local2) (Said 'get,buy,give,sell,bargain,show/*'))
				(if local1
					(proc62_2 62 74) ; "I told you to be gone! I do not want your money or your business."
				else
					(= local1 1)
					(proc62_2 62 65) ; "Be gone, heathen. I do not like the look of you and I serve only who I please and today it does not please me to serve anyone."
				)
			)
			((or (Said 'get,buy/>') (Said 'ask[/butcher,merchant,man]>'))
				(cond
					((or (Said '/ham') (Said '//ham'))
						(= local6 0)
						(proc62_2 62 80) ; "Are you trying to insult me, infidel?! How dare you suggest I would touch an unclean meat!"
					)
					((or (Said '/chicken') (Said '//chicken'))
						(= local6 0)
						(proc62_2 62 81) ; "They are already spoken for by regular customers."
					)
					((or (Said '/goat') (Said '//goat'))
						(= local6 0)
						(proc62_2 62 82) ; "That was only brought to me for butchering by a customer. It is not mine to sell."
					)
					((or (Said '/beef,venison') (Said '//beef,venison'))
						(proc62_2 62 83) ; "In Jerusalem?!"
					)
					((Said '/leg<lamb')
						(Print 62 84) ; "What would you do with an entire large leg of lamb, Arthur?"
					)
					((or (Said '/lamb') (Said '//lamb'))
						(if (or (IsItemAt 10) (IsFlag 137)) ; lamb | dove
							(proc62_2 62 85) ; "The whole leg is 5 dinars, but I will sell a single cut for 6 fals."
							(= local6 1)
						else
							(proc62_2 62 76) ; "You are beginning to annoy me again, little man. Go away."
						)
					)
					(
						(or
							(Said '/meat,goods,item')
							(Said '//meat,goods,item,business')
						)
						(proc62_2 62 86) ; "I have goat, lamb, and chicken."
					)
					((Said '//dog')
						(proc62_2 62 87) ; "I feed him scraps and he guards my shop. Dogs are far more trustworthy than men."
					)
					((Said '//daughter')
						(proc62_2 62 88) ; "Do not even think about my daughter, you foreign swine!"
					)
					((Said '//ismail,(merchant<relic)')
						(proc62_2 62 89) ; "Bah, he is crook. All merchants are crooks. I am the only honest man here."
					)
					((Said '//lanius,lanius')
						(proc62_2 62 90) ; "Pretty dumb you are, if you do not know the sign of a butcher's shop."
					)
					((Said '//bandit')
						(proc62_2 62 91) ; "Bah, no thief dares to rob me!"
					)
					(global140
						(= local6 0)
						(proc62_2 62 92) ; "Can you not read? I am a butcher."
					)
					((and (Said 'ask//*>') (not (proc152_2 event)))
						(event claimed: 1)
						(proc62_2 62 93) ; "You annoy me, little man. Go away."
					)
				)
			)
			((and global140 (Said 'sell,bargain'))
				(if (gEgo has: global140)
					(proc62_2 62 94) ; "If you have money, fine. If you do not have money, go somewhere else. I do not buy or trade."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'give,sell,bargain/ass')
				(if (IsFlag 20)
					(proc62_2 62 95) ; "Have you ever tried to eat mule meat? Very tough. But I hear Mohammed is looking for a pack mule, if he has not already left on his trip."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'give,show/*>')
				(cond
					((or (not global140) (not (gEgo has: global140)))
						(event claimed: 1)
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((Said '/grail,relic')
						(proc62_2 62 96) ; "Is that some piece of Ismail's junk? You bought that? You infidels are dumber than I thought."
					)
					(else
						(event claimed: 1)
						(proc62_2 62 97) ; "I do not take gifts from strangers."
					)
				)
			)
			((Said 'smell')
				(Print 62 98) ; "I am not sure which smell is stronger: Fawaz or the meat."
			)
		)
	)
)

(instance angryTalk of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (gTObj tCount:) 0)
			(fawaz setCycle: 0 cycleSpeed: 0 setLoop: 1 cel: 0)
			(client setScript: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 2))
			)
			(1
				(fawaz setLoop: (Random 1 4) cycleSpeed: 1 setCycle: End self)
			)
			(2
				(= seconds (Random 1 2))
			)
			(3
				(fawaz cycleSpeed: 2 setCycle: Beg self)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

