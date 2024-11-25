;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use n117)
(use Interface)
(use Avoid)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm33 0
	splash 1
	harborMaster 2
	hbHead 3
)

(synonyms
	(spice bead amber ivory bolt fur)
	(wax honey wine oil)
	(deck keel anchor hatch)
	(pirate saracen viking)
	(crew sailor)
	(man jack master harbormaster)
	(line rigging)
	(greet greet ahoy)
	(thessalonica athens greece)
)

(local
	local0
	local1
	local2
	[local3 2]
	local5
	local6
	local7
	[local8 6] = [0 75 50 25 10 5]
	local14
	local15
	local16
)

(procedure (localproc_0)
	(if (not (DoPurse))
		(Talk 33 0) ; "I need a bit more, m'lud, if you wish to go to the port you have chosen."
	else
		(+= global133 global132)
		(+= local5 global129)
		(+= local6 global130)
		(+= local7 global131)
		(= global132 0)
		(cond
			((not global133)
				(proc0_18)
			)
			((< global133 [local8 local16])
				(Talk 33 1) ; "Beggin' m'lud's pardon, but this is not enough for the port you have chosen. I will return your coins, so you may count them out again."
				(= global133 0)
				(proc0_18)
			)
			((> global133 [local8 local16])
				(Talk 33 2) ; "That is too much money, m'lud. I cannot in all honesty accept more than is needed."
				(= global133 0)
				(proc0_18)
			)
			(else
				(switch local16
					(1
						(Talk 33 3) ; "Thankee, m'lud. You have booked passage to Gaza."
						(= global128 0)
					)
					(2
						(Talk 33 4) ; "Thankee, m'lud. You have booked passage to Thessalonica."
						(= global128 1)
					)
					(3
						(Talk 33 5) ; "Thankee, m'lud. You have booked passage to Rome."
						(= global128 3)
					)
					(4
						(Talk 33 6) ; "Thankee, m'lud. You have booked passage to Rennes."
						(= global128 2)
					)
					(5
						(Talk 33 7) ; "Thankee, m'lud. You have booked passage to Dublin."
						(= global128 4)
					)
				)
				(SetScore 0 0 5)
				(gCurRoom setScript: (ScriptID 197 0)) ; board
			)
		)
	)
)

(instance wave1 of Prop
	(properties
		y 78
		x 144
		view 133
		cycleSpeed 6
	)
)

(instance wave2 of Prop
	(properties
		y 80
		x 207
		view 133
		cel 1
		cycleSpeed 6
	)
)

(instance wave3 of Prop
	(properties
		y 83
		x 273
		view 133
		loop 2
		cel 2
		cycleSpeed 6
	)
)

(instance splash of Prop
	(properties
		view 38
		loop 2
	)
)

(instance harborMaster of Act
	(properties
		y 148
		x 275
		view 341
		loop 2
		illegalBits $8102
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
			((MouseClaimed self event)
				(Print 33 8) ; "He has the rolling gait of a retired sailor, and the portly bearing of a man who well enjoys his food and grog."
			)
			((Said 'ask[/man]/boat<foreign')
				(Talk 33 9) ; "'Tis a foreign ship, m'lud, recently sold to yet another foreigner."
			)
			((Said 'ask[/man]/boat')
				(Talk 33 10) ; "There are many ships that use this port, m'lud, like the foreign ship behind me that arrived a few days ago."
			)
			(
				(or
					(Said 'ask[/man]/bound,direction')
					(Said 'ask,get/bound,direction[/boat]')
				)
				(if local15
					(SetScore 287 1 1)
					(Talk 33 11 33 12 33 13 33 14) ; "The "Conal Cearnach" sails for Dublin, m'lud, in the land of Eire. The "Frastrada" will dock somewhere along the coast of Brittany to deliver supplies for the scholars of Rennes in the Kingdom of the Franks."
				else
					(Talk 33 15) ; "I bid you to return later, m'lud, when the ships may be ready to sail."
					(= local0 1)
				)
			)
			((or (Said 'give,exit/ass') (Said 'ask[/man]/ass'))
				(if local15
					(Talk 33 16) ; "No need to part with it, m'lud. Being small, it should fit on a ship well enough."
				else
					(gTObj noWidth: 1)
					(if (IsFlag 20)
						(Talk 33 17) ; "I know little about mules, m'lud."
					else
						(Talk 33 18) ; "Beg pardon, m'lud?"
						(++ local2)
					)
				)
			)
			((or (Said 'give,exit/charger') (Said 'ask[/man]/charger'))
				(if local15
					(Talk 33 19) ; "There will not be enough room for your horse, m'lud."
				else
					(gTObj noWidth: 1)
					(if (!= global116 0)
						(Talk 33 20) ; "Aye, 'tis a fine horse."
					else
						(Talk 33 21) ; "Beg pardon, m'lud?"
						(++ local2)
					)
				)
			)
			((or (Said 'get/fare,cost') (Said 'ask[/man]/fare,cost'))
				(if local15
					(Talk 33 22 33 23) ; "The fare to Dublin is one silver coin. The fare to Rennes is two silver coins. The fare to Rome is one gold coin. The fare to Thessalonica is two gold coins. The fare to Gaza is three gold coins."
				else
					(= local0 1)
					(Talk 33 24) ; "Please return later, m'lud, when ships are ready to sail. Then I will be able to help you book passage."
				)
			)
			((or (Said 'ask[/man]>') (Said 'are<where>'))
				(cond
					((or (Said '/jerusalem') (Said '//jerusalem'))
						(Talk 33 25) ; "Jerusalem is a city in the desert near the easternmost end of the Mediterranean Sea."
					)
					((or (Said '/christy,peter') (Said '//christy,peter'))
						(Talk 33 26) ; "Eh? Sounds like some foreign word to me."
					)
					((or (Said '/grail') (Said '//grail'))
						(gTObj noWidth: 1)
						(Talk 33 27) ; "I know nothing of such things."
					)
					((or (Said '/gawain,lancelot') (Said '/gawain,lancelot'))
						(Talk 33 28) ; "Of these good knights, I have heard no tale."
					)
					((or (Said '/galahad') (Said '//galahad'))
						(Talk 33 29) ; "Aye, he took ship from here to the Far East. He said he had heard tales that made him believe he should seek the Grail in Jerusalem."
						(SetScore 286 1 1)
						(SetFlag 76)
					)
					((or (Said '/name[<boat]') (Said '//name[<boat]'))
						(Talk 33 30) ; "There be five ships in port today, m'lud. They are called the Conal Cearnach, the Frastrada, the Al-Uzza, the Athene and the Remus."
					)
					((Said '//name,man')
						(gTObj noWidth: 1)
						(Talk 33 31) ; "My name is Rollin' Jack, m'lud."
					)
					((or (Said '/baldness') (Said '//baldness'))
						(Talk 33 32) ; "Aye, m'lud, it were a hard life what does it to a man."
					)
					(
						(or
							(Said '/cearnach,dublin,eire')
							(Said '//cearnach,dublin,eire')
						)
						(Talk 33 33) ; "The "Conal Cearnach" sails for Dublin, m'lud, in the land of Eire."
					)
					(
						(or
							(Said '/frastrada,rennes,bretagne,channel,frank')
							(Said '//frastrada,rennes,bretagne,channel,frank')
						)
						(Talk 33 34) ; "The "Frastrada" will dock somewhere along the coast of Brittany to deliver supplies for the scholars of Rennes in the Kingdom of the Franks."
					)
					(
						(or
							(Said '/remus,rome,empire')
							(Said '//remus,rome,empire')
						)
						(Talk 33 35) ; "The Captain of the "Remus" seeks to reach Rome, but will stop in two Muslim-held ports, Malaga and Tunis."
					)
					(
						(or
							(Said '/athena,thessalonica')
							(Said '//athena,thessalonica')
						)
						(Talk 33 36) ; "The "Athene" sails for Thessalonica, seeking also to trade in Malaga and Tunis."
					)
					(
						(or
							(Said
								'/aluzza,(uzza<al),(east<far),gaza,tunis,malaga,alexandria'
							)
							(Said
								'//aluzza,(uzza<al),(east<far),gaza,tunis,malaga,alexandria'
							)
						)
						(Talk 33 13) ; "A ship called "Al-Uzza" is bound for the Far East, by way of Malaga, Tunis, and Alexandria, and if God wills, coming at last to distant Gaza."
					)
					(
						(or
							(Said '/air,ocean,water,cloud,weather,breaker,tide')
							(Said
								'//air,ocean,water,cloud,weather,breaker,tide'
							)
						)
						(Talk 33 37) ; "Aye, 'tis fair seas for sailing at this time of year."
					)
					((or (Said '/gangplank') (Said '//gangplank'))
						(Talk 33 38) ; "I be guarding this gangplank, m'lud, while the Captain is ashore."
					)
					((or (Said '/passage,journey') (Said '//passage,journey'))
						(if local15
							(if (!= global116 0)
								(Talk 33 39 33 40) ; "There will be only enough room for you and your mule, m'lud. I will see that your horse is delivered safely to Camelot, as I did for Sir Galahad when he departed from here some months ago."
							else
								(Talk 33 41) ; "Aye, there should be enough room for you as a passenger.  If you seek to travel, you may book passage through me, m'lud."
							)
						else
							(= local0 1)
							(Talk 33 42) ; "I cannot book a passage for you yet, m'lud. Return later and I may be able to help you."
						)
					)
					(
						(or
							(Said '/deck,line,bow,stern,mainmast')
							(Said '//deck,line,bow,stern,mainmast')
						)
						(Talk 33 43) ; "Aye, 'tis part of a ship, m'lud."
					)
					((or (Said '/sail,sale') (Said '//sail,sale'))
						(Talk 33 44) ; "Sail? Did you say sail? A ship will not get far without one, m'lud."
					)
					(
						(or
							(Said '/business,shipping,bargain')
							(Said '//business,shipping,bargain')
						)
						(if local15
							(Talk 33 45) ; "There are five ships in the port ready to depart. Their destinations are Dublin, Rennes, Rome, Thessalonica and Gaza."
						else
							(= local0 1)
							(Talk 33 46 33 47 33 48) ; "Several ships are in port, but none will be ready to sail again for some days."
						)
					)
					((or (Said '/crew') (Said '//crew'))
						(Talk 33 49) ; "They be ashore in search of grog and women, m'lud."
					)
					((or (Said '/brew,woman') (Said '//brew,woman'))
						(Talk 33 50) ; "You cannot deny the sailors a bit of fun while they are in port, not after months at sea."
					)
					((or (Said '/captain') (Said '//captain'))
						(Talk 33 51) ; "We have a number of foreign captains in port this day. They are doing business with the port merchants."
					)
					((or (Said '/port,hampton') (Said '//port,hampton'))
						(Talk 33 52) ; "We do a fair business here, m'lud. Mostly we trade our tin, furs and some weapons, and receive trade goods of many kinds."
					)
					(
						(or
							(Said '/tin,wax,spice,weapon,good')
							(Said '//tin,wax,spice,weapon,good')
						)
						(Talk 33 53) ; "We commonly trade it to foreign lands, as m'lud surely knows."
					)
					(
						(or
							(Said '/cargo,jar,pot,bundle,package')
							(Said '//cargo,jar,pot,bundle,package')
						)
						(Talk 33 54) ; "It is just some honey and tin waiting to be loaded onto the proper ship."
					)
					(
						(or
							(Said '/shore,land,spit,peninsula')
							(Said '//shore,land,spit,peninsula')
						)
						(Talk 33 55) ; "The shore is green this time of year."
					)
					((or (Said '/pirate') (Said '//pirate'))
						(Talk 33 56) ; "Aye, there are Vikings around Dublin and Saracen pirates in the Mediterranean. They are the scourge of honest merchants, m'lord."
					)
					((or (Said '/eye') (Said '//eye'))
						(Talk 33 57) ; "Aye aye, an eye for an eye, say I."
					)
					((or (Said '/moslem') (Said '//moslem'))
						(Talk 33 58) ; "Awrr, they are the heathen worshippers of a foreign god, but they rule most of the Mediterranean now, so we must deal with them."
					)
					((or (Said '/hearing') (Said '//hearing'))
						(if (not local1)
							(= local1 1)
							(Talk 33 59) ; "Fearing? I be afeared of nothing but the sea, m'lud."
						else
							(Talk 33 60) ; "My hearing? Aye, the roar of sea and wind has deafened me a trifle."
						)
					)
					(else
						(event claimed: 1)
						(gTObj noWidth: 1)
						(Talk 33 21) ; "Beg pardon, m'lud?"
						(++ local2)
					)
				)
			)
			(
				(or
					(Said 'pay,give/fare,coin,copper,dinar,dirham,man[/!*]')
					(Said 'pay[/!*][/!*]')
				)
				(cond
					((not local15)
						(= local0 1)
						(Talk 33 61) ; "Pray pardon me, m'lud, but I cannot accept your fare now, until I have a ship on which to book you a passage. I beg you to return later."
					)
					((== global116 1)
						(Print 33 62) ; "For this transaction, it would be better to dismount."
					)
					((> (gEgo distanceTo: harborMaster) 30)
						(Print 33 63) ; "Move closer to the Harbourmaster."
					)
					((== local16 0)
						(Talk 33 64) ; "Beg pardon, m'lud, but I did not hear you ask for a port of call yet."
					)
					(else
						(localproc_0)
					)
				)
			)
			(
				(Said
					'go/(east<far),gaza,thessalonica,rome,rennes,dublin,eire,bretagne'
				)
				(Print 33 65) ; "If you wish. I am sure the Harbourmaster can help you with that."
			)
			(
				(or
					(Said
						'get,book,buy,(pay<for)/boat,ticket,ride,journey,passage>'
					)
					(Said 'pay,give/fare,coin,copper,dinar,dirham,man>')
					(Said 'go,pay,sail>')
				)
				(cond
					((not local15)
						(= local0 1)
						(Talk 33 42) ; "I cannot book a passage for you yet, m'lud. Return later and I may be able to help you."
						(event claimed: 1)
					)
					((== global116 1)
						(Print 33 62) ; "For this transaction, it would be better to dismount."
						(event claimed: 1)
					)
					((> (gEgo distanceTo: harborMaster) 30)
						(Print 33 63) ; "Move closer to the Harbourmaster."
						(event claimed: 1)
					)
					(
						(or
							(Said '/jerusalem')
							(Said '//jerusalem')
							(Said '//passage,ticket,fare,journey<jerusalem<to')
						)
						(Talk 33 66) ; "Pardon, m'lud, but that is not a port and no ship sails there."
					)
					(
						(or
							(Said '/(east<far),gaza')
							(Said '//(east<far),gaza')
							(Said '//aluzza,(uzza<al)')
							(Said
								'//passage,ticket,fare,journey<(east<far),gaza<to'
							)
							(Said
								'//passage,ticket,fare,journey<aluzza,(uzza<al)<on'
							)
						)
						(= local16 1)
						(localproc_0)
					)
					(
						(or
							(Said '/thessalonica')
							(Said '//thessalonica')
							(Said '//athena')
							(Said
								'//passage,ticket,fare,journey<thessalonica<to'
							)
							(Said '//passage,ticket,fare,journey<athena<on')
						)
						(= local16 2)
						(localproc_0)
					)
					(
						(or
							(Said '/rennes,bretagne')
							(Said '//rennes,bretagne')
							(Said '//frastrada')
							(Said
								'//passage,ticket,fare,journey<rennes,bretagne<to'
							)
							(Said '//passage,ticket,fare,journey<frastrada<on')
						)
						(= local16 4)
						(localproc_0)
					)
					(
						(or
							(Said '/dublin,eire')
							(Said '//dublin,eire')
							(Said '//cearnach')
							(Said
								'//passage,ticket,fare,journey<dublin,eire<to'
							)
							(Said '//passage,ticket,fare,journey<cearnach<on')
						)
						(= local16 5)
						(localproc_0)
					)
					(
						(or
							(Said '/rome')
							(Said '//rome')
							(Said '//remus')
							(Said '//passage,ticket,fare,journey<rome<to')
							(Said '//passage,ticket,fare,journey<remus<on')
						)
						(= local16 3)
						(localproc_0)
					)
					((Said '/[/!*]')
						(if local16
							(localproc_0)
						else
							(Talk 33 67) ; "Beggin' m'lud's pardon, but I be a trifle hard of hearing. I did not hear where you wished to go."
							(event claimed: 1)
						)
					)
					((Said '//*')
						(Talk 33 68) ; "Eh? Never heard of it. 'Tis some piddling little foreign rathole, I suppose."
						(event claimed: 1)
					)
				)
			)
			((Said 'get,refund/coin,copper,dirham,dinar,refund')
				(if (== global133 0)
					(Talk 33 69) ; "But m'lud has paid nothing that I might refund."
				else
					(Talk 33 70) ; "As you command, m'lud. I shall return what you have given me."
					(+= gGold local5)
					(+= gSilver local6)
					(+= gCopper global133)
					(= global133 (= local5 (= local6 (= local7 0))))
				)
			)
			((or (Said 'greet') (Said 'talk[/man]'))
				(cond
					((not (IsFlag 70))
						(if local15
							(Talk 33 71 33 72 33 45 33 73) ; "Others might be surprised to see you here, m'lud, but not I. Ever since Sir Galahad sailed from here and did not return, I felt another would follow in his steps."
						else
							(= local0 1)
							(Talk 33 71 33 72 33 74) ; "Others might be surprised to see you here, m'lud, but not I. Ever since Sir Galahad sailed from here and did not return, I felt another would follow in his steps."
						)
					)
					(local15
						(Talk 33 75 33 76) ; "Ah, m'lud, your return is most timely. I have five ships leaving port. They are sailing for Dublin, Rennes, Rome, Thessalonica and Gaza."
					)
					(else
						(= local0 1)
						(Talk 33 77 33 78) ; "Greetings, m'lud. I fear you have returned too soon. We have had some trouble at the docks. Drunken brawls amongst the sailors, that sort of thing."
					)
				)
			)
			((Said 'bargain/*')
				(Talk 33 79) ; "Beggin' m'lud's pardon, but only coin may be collected for fare."
			)
			((Said 'get,buy,bargain/pot,jar,bundle,package,cargo')
				(Talk 33 80) ; "Sorry, m'lud, it is already sold."
			)
			(
				(or
					(Said 'ask,get/bound,direction')
					(Said '(are,are)<where/(bound,bound)')
				)
				(if local15
					(Talk 33 81) ; "I have five ships bound for different parts of the world on which you might book passage. They sail for Dublin, Rennes, Rome, Thessalonica and Gaza."
				else
					(Talk 33 82) ; "If you wish to book passage on one of them, m'lud, I will be most happy to tell you the fare for each."
				)
			)
			((Said 'give/rose,lodestone,key,sleeve,heart')
				(Talk 33 83) ; "Beggin' m'lud's pardon, but I may accept only coin as the proper fare."
			)
			((and local15 (Said 'give,exit/ass'))
				(Talk 33 84) ; "No need to part with it, m'lud. There will be just enough room on the ship for it."
			)
			((and local15 (Said 'sell/ass'))
				(Talk 33 85) ; "I am not in the mule buying business, m'lud."
			)
		)
	)
)

(instance hbHead of Prop
	(properties
		y 148
		x 275
		z 39
		view 341
		loop 3
		signal 16384
	)
)

(instance harborWindow of SysWindow
	(properties
		color 15
		back 3
		title {Harbourmaster}
		brLeft 50
		brBottom 120
		brRight 300
	)
)

(instance Rm33 of Rm
	(properties
		picture 33
	)

	(method (dispose)
		(SetFlag 70)
		(DisposeScript 985)
		(super dispose: &rest)
	)

	(method (init)
		(Load rsVIEW 133)
		(Load rsVIEW 341)
		(Load rsVIEW 38)
		(Load rsSOUND 47)
		(Load rsSCRIPT 196)
		(Load rsSCRIPT 197)
		(super init:)
		(= global112 2)
		(if (IsFlag 20)
			(self setRegions: 115) ; muleReg
			(gMuleObj
				posn: 280 192
				loop: 3
				setMotion: MoveTo 277 179
				setScript: 0
			)
		)
		(= local15
			(if (and (IsFlag 20) (IsFlag 31))
				(IsFlag 66)
			)
		)
		(wave1 init: setCycle: Fwd)
		(wave2 init: setCycle: Fwd)
		(wave3 init: setCycle: Fwd)
		(if (== global116 1)
			(self setRegions: 113) ; horseReg
			(gEgo observeControl: 64)
			(gEgo view: 8)
		else
			(gEgo view: 0)
		)
		(gEgo loop: 3 posn: 233 187 setMotion: MoveTo 233 174 init:)
		(gTObj actor: hbHead tLoop: 3 tWindow: harborWindow)
		(hbHead init:)
		(harborMaster init:)
		(proc0_13 64)
		(gAddToPics doit:)
		(gRmMusic number: 47 loop: -1 play:)
	)

	(method (doit)
		(super doit:)
		(cond
			((or global80 (gEgo script:)) 0)
			((and (>= local2 3) (not gModelessDialog))
				(= local2 0)
				(Print 33 86) ; "Methinks the man is hard of hearing, Arthur."
			)
			((and (== global116 1) (& (gEgo onControl:) $0022))
				(gEgo setScript: (ScriptID 196 0)) ; moveHorseAway
			)
			((& (gEgo onControl: 1) $0022)
				(if (!= global116 1)
					(gEgo setScript: (ScriptID 196 1)) ; fallingOffDock
				)
			)
			((or (> (gEgo x:) 310) (> (gEgo y:) 187))
				(if (and (== global116 2) (== global115 33))
					(Print 33 87) ; "You will find the trip even longer and more tiring without your horse, Arthur."
					(if (> (gEgo y:) 187)
						(gEgo setMotion: MoveTo (gEgo x:) 181)
					else
						(gEgo setMotion: MoveTo 295 (gEgo y:))
					)
				else
					(gCurRoom newRoom: 103)
				)
			)
			(else
				(= local14 0)
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
			((Said 'open,get,(look<in)/pot,jar,bundle,package,cargo')
				(Print 33 88) ; "It would improper of you to break the seals on merchandise that does not belong to you."
			)
			((or (Said 'talk/merlin') (Said 'ask/advice'))
				(if (IsFlag 76)
					(Print 33 89) ; "Did you not hear, Arthur? Galahad went to Jerusalem."
				else
					(Print 33 90) ; "If you want to know about ship destinations, booking passage or fares, you should ask the Harbourmaster about them."
				)
			)
			((Said 'look<up')
				(Print 33 91) ; "It is fairly calm, indicating light wind."
			)
			((Said 'look<down')
				(Print 33 92) ; "Beneath you is the dock."
			)
			((Said 'ask<about//boat<foreign')
				(Print 33 93) ; "Ask the Harbourmaster."
			)
			((Said 'look<in/boat')
				(if local15
					(Print 33 94) ; "It is fully loaded and ready to sail."
				else
					(Print 33 95) ; "It has not yet finished with loading and unloading of cargo and supplies. But the Harbourmaster would know more than I about such things."
				)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/>')
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '/dock,port,hampton')
							(Said '//dock,port,hampton')
						)
						(Print 33 96) ; "A foreign ship is moored along one side of the dock. Yonder portly fellow is the Harbourmaster, who has authority over all ships that enter and leave Southampton.  Some cargo has been off-loaded from the ship and awaits delivery."
					)
					((or (Said '/hearing') (Said '//hearing'))
						(Print 33 97) ; "My hearing is excellent, thank you."
					)
					(
						(or
							(Said '/name,nameplate[<boat]')
							(Said '//name,nameplate[<boat]')
							(OnButton event 69 95 83 106)
							(OnButton event 84 101 103 114)
							(OnButton event 104 106 124 119)
						)
						(Print 33 98) ; "It is Greek for "Kristi"."
					)
					((or (Said '/christy,peter') (Said '//christy,peter'))
						(Print 33 99) ; "Peter loves Christy and Christy loves Peter and that is all you need to know."
					)
					((or (Said '/galahad') (Said '//galahad'))
						(if (IsFlag 76)
							(Print 33 89) ; "Did you not hear, Arthur? Galahad went to Jerusalem."
						else
							(Print 33 100) ; "His whereabouts are yet unknown."
						)
					)
					((or (Said '/man') (Said '//man'))
						(Print 33 8) ; "He has the rolling gait of a retired sailor, and the portly bearing of a man who well enjoys his food and grog."
					)
					(
						(or
							(Said '/mainmast')
							(Said '//mainmast')
							(OnButton event 230 5 237 116)
						)
						(Print 33 101) ; "Aye, 'tis a mast.  It holds the sail."
					)
					(
						(or
							(Said '/gangplank')
							(Said '//gangplank')
							(OnButton event 244 115 298 148)
						)
						(Print 33 102) ; "The gangplank is in place. The ship must still be engaged in business."
					)
					((or (Said '/tin,wax,spice') (Said '//tin,wax,spice'))
						(Print 33 93) ; "Ask the Harbourmaster."
					)
					((or (Said '/sail') (Said '//sail'))
						(Print 33 103) ; "It is furled atop the mast."
					)
					(
						(or
							(Said '/crew,caupona,drink')
							(Said '//crew,caupona,drink')
						)
						(Print 33 104) ; "Perhaps the crews are having a final round of drinks at a local inn before departure."
					)
					((or (Said '/captain') (Said '//captain'))
						(Print 33 105) ; "He will surely appear once the Harbourmaster decrees the ship is cleared to leave."
					)
					(
						(or
							(Said '/water,sky,ocean,weather,tide')
							(Said '//water,ocean,sky,weather,tide')
						)
						(Print 33 91) ; "It is fairly calm, indicating light wind."
					)
					(
						(or
							(Said '/breaker')
							(Said '//breaker')
							(MouseClaimed wave1 event)
							(MouseClaimed wave2 event)
							(MouseClaimed wave3 event)
						)
						(Print 33 106) ; "The waves break on the shoreline of Southampton."
					)
					((or (Said '/line') (Said '//line'))
						(Print 33 107) ; "Aye, a ship has many ropes."
					)
					((or (Said '/deck') (Said '//deck'))
						(Print 33 108) ; "Every ship has one."
					)
					(
						(or
							(Said '/eye')
							(Said '//eye')
							(OnButton event 73 107 84 114)
						)
						(Print 33 109) ; "'Tis not an uncommon practice among foreign seaman to paint an eye upon the prow so that the ship may better see where it is going."
					)
					(
						(or
							(Said '/boat')
							(Said '//boat')
							(OnButton event 60 92 312 138)
						)
						(Print 33 110) ; "It is a typical merchant ship bringing foreign cargo to trade for British goods such as tin."
					)
					((or (Said '/bow') (Said '//bow'))
						(Print 33 111) ; "There is a small bit of shelter in the prow, but no cabins. These ships are built for cargo, not comfort."
					)
					((or (Said '/stern,rudder') (Said '//stern,rudder'))
						(Print 33 112) ; "The ship's stern has a rudder, as might be expected."
					)
					(
						(or
							(Said '/shore,land')
							(Said '//shore,land')
							(OnButton event 157 57 250 78)
							(OnButton event 246 42 312 78)
						)
						(Print 33 113) ; "It is, not surprisingly, the shoreline of Southampton."
					)
					(
						(or
							(Said '/cloud')
							(Said '//cloud')
							(OnButton event 0 0 155 66)
						)
						(Print 33 114) ; "The clouds do not look threatening and should not delay the ship from sailing."
					)
					(
						(or
							(Said '/pot,jar')
							(Said '//pot,jar')
							(OnButton event 86 156 148 179)
						)
						(Print 33 115) ; "The earthenware pots and jars might contain wax, oil, wine or honey."
					)
					(
						(or
							(Said '/bundle,package')
							(Said '//bundle,package')
							(OnButton event 150 153 194 177)
						)
						(Print 33 116) ; "The packets are wrapped in oil cloth and could be any number of common trade items: spices, furs, cloth, ivory, amber, glass beads, pottery."
					)
					((or (Said '/carp,gull') (Said '//carp,gull'))
						(Print 33 117) ; "There are many fish in the sea, Arthur, and seagulls to feast upon them."
					)
					((or (Said '/cargo') (Said '//cargo'))
						(Print 33 118) ; "The cargo on the dock consists of earthenware pots and jars and some wrapped packets."
					)
					((Said 'look>') 0)
					(
						(or
							(Said '/shipping,business,bargain')
							(Said '//shipping,business,bargain')
						)
						(if local0
							(Print 33 119) ; "Since a goodly portion of your tax revenues come from shipping, I suppose it must be doing well enough."
						else
							(Print 33 120) ; "Ask the Harbourmaster about that."
						)
					)
					(
						(or
							(Said '/malaga,tunis,bretagne')
							(Said '//malaga,tunis,bretagne')
						)
						(Print 33 121) ; "They are ports held by Muslim rulers."
					)
					(
						(or
							(Said '/bretagne,celt,gaul')
							(Said '//bretagne,celt,gaul')
						)
						(Print 33 122) ; "Brittany, or Bretagne, is held by wild and unruly Celtic tribes known as Gauls."
					)
					((or (Said '/dublin,eire') (Said '//dublin,eire'))
						(Print 33 123) ; "Dublin is on the island of Eire."
					)
					(
						(or
							(Said '/rennes,channel,frank')
							(Said '//rennes,channel,frank')
						)
						(Print 33 124) ; "Rennes is in the land of the Franks, across the channel."
					)
					((or (Said '/rome,empire') (Said '//rome,empire'))
						(Print 33 125) ; "Rome was once the center of the Roman Empire, but the power of this ancient city has much declined."
					)
					((or (Said '/thessalonica') (Said '//thessalonica'))
						(Print 33 126) ; "Thessalonica is in northern Greece, above Athens."
					)
					((or (Said '/(east<far),gaza') (Said '//(east<far),gaza'))
						(Print 33 127) ; "Gaza is at the easternmost end of the Mediterranean Sea."
					)
					((or (Said '/jerusalem') (Said '//jerusalem'))
						(Print 33 128) ; "To reach Jerusalem, you must take ship to the port nearest it in that part of the world."
					)
					(
						(or
							(Said '/cearnach,cearnach,christ')
							(Said '//cearnach,cearnach,christ')
						)
						(Print 33 129) ; "An Irish legend says Conal Cearnach was a prisoner of the Romans in Jerusalem and witnessed the crucifixion of Christ."
					)
					(
						(or
							(Said '/frastrada,charlemagne,crone')
							(Said '//frastrada,charlemagne,crone')
						)
						(Print 33 130) ; "Frastrada was a wife of Charlemagne, ruler of the Franks. Rumour said she was a witch from the East."
					)
					((or (Said '/remus,romulus') (Said '//remus,romulus'))
						(Print 33 131) ; "The legendary founders of Rome were twin brothers, Remus and Romulus, who were suckled by a she-wolf."
					)
					(
						(or
							(Said '/athena,(goddess<greek)')
							(Said '//athena,(goddess<greek)')
						)
						(Print 33 132) ; "The powerful Greek Goddess, Athene, is the patroness of sailors. The city of Athens is named after her."
					)
					(
						(or
							(Said
								'/aluzza,mohammed,(uzza<al),(goddess<arabic,arab)'
							)
							(Said
								'//aluzza,mohammed,(uzza<al),(goddess<arabic,arab)'
							)
						)
						(Print 33 133) ; "The name Al-Uzza, means "Powerful One". It was the title of an Arabic Goddess associated with the founding of Mohammed's tribe."
					)
				)
			)
			((Said 'board,enter,(get<on)/boat')
				(Print 33 134) ; "That is a matter to discuss with the Harbourmaster."
			)
			((Said 'search/boat')
				(Print 33 135) ; "This is a foreign merchant's ship, not subject to your whim, King Arthur."
			)
			((Said 'climb/mainmast,line,shroud')
				(Print 33 136) ; "That is work for sailors, not a warrior-king."
			)
			((Said 'press,shove,move/man')
				(Print 33 137) ; "He is doing his duty and will move only when he should move. As a king, you must set an example and respect him as master of this port."
			)
			((Said 'replace,send/ass[/camelot]')
				(if local15
					(Print 33 138) ; "Not a wise idea, Arthur."
				else
					(event claimed: 0)
				)
			)
			((or (Said 'draw/blade') (Said 'kill,attack,annihilate,hit/man'))
				(if (< (gEgo distanceTo: harborMaster) 50)
					(Print 33 139) ; "Arthur! Do not disgrace yourself by threatening this good man."
				else
					(Talk 33 140) ; "I do not mean to anger you, m'lud, but it is my duty to collect fare before a passenger may board a ship."
				)
				(if global124
					(= global125 2)
				)
			)
			((Said 'give/moneybag')
				(Print 33 141) ; "The purse itself is of no value to him. And you may yet need it."
			)
			(
				(and
					local15
					(or
						(Said 'get,drink/water')
						(Said 'get,eat/food')
						(Said 'get/clothes,blanket')
					)
				)
				(Print 33 142) ; "You already did that during your ride here. No need to do it again now."
			)
			(
				(and
					local15
					(Said 'remove,exit/pack,water,drink,food,clothes,blanket')
				)
				(Print 33 143) ; "That would be absurd."
			)
			((Said 'smell[/water,carp,dock,hampton]')
				(Print 33 144) ; "The sharp tang of salt water mingles with the pungent smell of fish."
			)
			((Said 'listen')
				(Print 33 145) ; "The wooden ship creaks and bumps against the pier. Water washes across wood and stone and waves dash upon the shore. Seagulls cry raucously from above."
			)
			((Said 'dismount,(get<off)[/charger]')
				(if (!= global116 1)
					(Print 33 146) ; "You must be on a horse to get off a horse."
				else
					(gEgo setScript: getOffHorse)
				)
			)
		)
	)
)

(instance getOffHorse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: (Avoid new:) illegalBits: 0)
				(= cycles 2)
			)
			(1
				(cond
					(
						(and
							(gEgo inRect: 194 160 197 161)
							(== (gEgo loop:) 0)
						)
						(self changeState: 3)
					)
					((gEgo inRect: 84 176 196 190)
						(-- state)
						(gEgo setMotion: MoveTo 215 182 self)
					)
					((gEgo inRect: 8 170 84 190)
						(-- state)
						(gEgo setMotion: MoveTo 80 160 self)
					)
					((gEgo inRect: 230 140 320 190)
						(gEgo setMotion: MoveTo 192 160 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gEgo setMotion: MoveTo 194 160 self)
			)
			(3
				(gEgo setAvoider: 0 setCycle: Walk illegalBits: $8000)
				(DisposeScript 985)
				(HandsOn)
				(= global116 5)
				(gEgo setScript: 0)
			)
		)
	)
)

