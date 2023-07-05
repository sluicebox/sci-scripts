;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use n117)
(use n128)
(use eRoom)
(use Interface)
(use Yoyo)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	Rm35 0
	jabir 1
	jHead 2
	jabirWindow 3
	hazm 4
	hazmWindow 5
)

(synonyms
	(line rigging)
	(waterhole oasis)
	(wadi canyon)
	(galahad englishman foreigner knight)
	(alsirat master)
	(man guide hamid)
	(boy hazm)
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
	(EgoDead 35 87) ; "Your armour and steel drag you to the bottom and there you will lie until you are rotten, soggy and pulpy and truly forgotten."
)

(procedure (localproc_1)
	(jHead setCycle: 0 cel: 0)
	(gTObj
		actor: hazm
		tLoop: (if (and (== (hazm loop:) 6) (== (hazm cel:) 5)) 9 else 4)
		noWidth: 1
		tWindow: hazmWindow
		postLoop: 6
		cSpeed: 2
	)
	(Talk &rest)
)

(procedure (localproc_2)
	(gTObj actor: jHead tLoop: 7 noWidth: 1 tWindow: jabirWindow cSpeed: 1)
	(Talk &rest)
)

(procedure (localproc_3 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
	(= temp8 1)
	(= temp9 (gEgo x:))
	(= temp10 (gEgo y:))
	(= temp4 (gEgo x:))
	(= temp5 (gEgo y:))
	(= temp0 (- param1 (gEgo x:)))
	(= temp1 (- param2 (gEgo y:)))
	(if (< (= temp7 (- (GetAngle 0 0 temp0 temp1) 90)) 0)
		(+= temp7 360)
	)
	(for
		((= temp6 0))
		(and (!= temp6 (- (GetDistance 0 0 temp0 temp1) 3)) temp8)
		((++ temp6))
		
		(= temp2 (+ (CosMult temp7 temp6) temp4))
		(= temp3 (+ (SinMult temp7 temp6) temp5))
		(gEgo x: temp2 y: temp3)
		(if (not (gEgo canBeHere:))
			(= temp8 0)
		)
	)
	(gEgo posn: temp9 temp10)
	(return (not temp8))
)

(instance splash of Prop
	(properties
		view 35
		loop 3
	)

	(method (cue)
		(gCurRoom newRoom: (followOut register:))
	)
)

(instance hazm of Act
	(properties
		view 390
		loop 4
	)

	(method (doit)
		(super doit:)
		(cond
			((gEgo script:) 0)
			((gTObj tS1:)
				(= local5 1)
			)
			(local5
				(if (> (gEgo x:) 160)
					(hazm setLoop: 6 cel: 5)
				)
				(= local5 0)
			)
			(local2 0)
			((and (< (gEgo y:) y) (!= cel 0) (not cycler))
				(hazm cycleSpeed: 0 setLoop: 6 setCycle: Beg)
			)
			((and (> (gEgo y:) y) (!= cel 5) (not cycler))
				(hazm cycleSpeed: 0 setLoop: 6 setCycle: End)
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
					(Said 'hire,follow,go,see,man/boy,alsirat')
					(Said 'accept/advice,give,help[<boy]')
					(Said 'accept/[boy]/advice,give,help')
					(Said 'go//boy')
					(Said 'talk,visit/alsirat')
				)
				(SetScore 0 1 1)
				(if (hazm script:)
					(event claimed: 0)
				else
					(gEgo setScript: goWithHazm)
				)
			)
			(
				(or
					(Said 'look,ask,visit,see,go/governer')
					(Said 'get,go,see//governer')
				)
				(localproc_1 35 0) ; "Oh, no, this mukhtar is an evil man and would make you a slave. He must not find you."
			)
			((or (Said 'give/ass[/boy]') (Said 'give/boy/ass'))
				(localproc_1 35 1) ; "Oh, sir, I could not keep her. And you will need her for your journey."
			)
			((or (Said 'give/lodestone[/boy]') (Said 'give/boy/lodestone'))
				(localproc_1 35 2) ; "I am not allowed to accept gifts, sir, except from my Master."
			)
			((or (Said 'give/moneybag[/boy]') (Said 'give/boy/moneybag'))
				(localproc_1 35 3) ; "I am not allowed to accept gifts for doing my duty, sir."
			)
			((Said 'get,buy/water,canteen,canteen,food,pack,pack[/boy]')
				(localproc_1 35 4) ; "You cannot seek it in Gaza, sir, or the mukhtar will imprison you. Perhaps my Master can help you with this problem."
			)
			(
				(or
					(and
						(Said 'ask,(are<where)>')
						(Said '/boy/direction,desert,jerusalem')
					)
					(Said 'get/direction/boy')
				)
				(localproc_1 35 5) ; "I have never been anywhere but Gaza, but my Master can surely answer you."
			)
			((Said 'talk[/boy]')
				(localproc_1 35 6 35 7) ; "It is true my Master is poor, but he is a good man and he knows so many things. And while you speak with Al-Sirat, I can care for your poor mule after her long sea journey."
			)
			((or (Said '/greet') (Said 'greet'))
				(if (gCast contains: jabir)
					(localproc_2 35 8) ; "Sa'alam aleikem"
				)
				(localproc_1 35 9) ; "Sa'alam aleikem. Peace be unto you."
			)
			(
				(or
					(Said 'look/boy')
					(Said 'ask[/merlin]/boy')
					(MouseClaimed self event)
				)
				(Print 35 10) ; "He is a young boy, poor but healthy, with an open, honest face and intelligence in his eyes."
			)
			((or (== (event type:) evMOUSEBUTTON) (Said 'look,ask,(are<where)>'))
				(cond
					((Said '[/boy]/wadi,waterhole')
						(localproc_1 35 11) ; "Please come and ask my Master. He knows so much more than I."
					)
					((Said '[/boy]/grail')
						(localproc_1 35 12) ; "Al-Sirat will know. He is the most learned of men."
					)
					((Said '[/boy]/galahad')
						(localproc_1 35 13) ; "He did not choose to visit my Master, but hurried off into the desert alone."
					)
					((Said '[/boy]/*')
						(localproc_1 35 14) ; "Sir, my Master is the wisest man in the whole world. He can answer any question. Please, let us go to him."
					)
				)
			)
		)
	)
)

(instance jHead of Prop
	(properties
		y 500
		x 500
		z 40
		view 392
		loop 7
		cycleSpeed 2
	)
)

(instance jabir of Act
	(properties
		view 389
		loop 4
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
					(Said 'follow,hire,go/man')
					(Said 'go//man')
					(Said 'get//jerusalem,desert')
					(Said 'accept/advice,give,help[<man]')
					(Said 'accept/[man]/advice,give,help')
				)
				(= local4 0)
				(gEgo setScript: goWithJabir)
			)
			((Said 'talk[/man]')
				(localproc_2 35 15 35 16) ; "Ignore the brat and let us do business. The mukhtar could have spies about, so we should act quickly. You have no pack, I see, and no waterskin. You can buy nothing in Gaza without being arrested."
			)
			((or (Said '/governer') (Said '[/man]/governer'))
				(localproc_2 35 17) ; "You want to avoid the mukhtar. I give you good advice. Trust me in all things."
			)
			((Said 'get,buy/water,canteen,canteen,food,pack,pack[/man]')
				(localproc_2 35 18) ; "No man in Gaza will deal with you because of the mukhtar's edicts. If you are spotted by his men, you will be arrested."
			)
			((or (Said 'give,bargain/ass[/man]') (Said 'give[/man]/ass'))
				(localproc_2 35 19) ; "Most generous, habib. She will make a fine payment for being your guide, if you let me take you to Jerusalem."
			)
			((or (Said 'give/lodestone[/man]') (Said 'give[/man]/lodestone'))
				(localproc_2 35 20) ; "An odd looking trinket, but of no interest to me."
			)
			((or (Said 'give/moneybag[/man]') (Said 'give[/man]/moneybag'))
				(localproc_2 35 21) ; "I am content to wait until I bring you safely to Jerusalem to receive my reward."
			)
			(
				(or
					(Said '/man/direction,desert,jerusalem')
					(Said 'get/direction/man')
				)
				(localproc_2 35 22) ; "Trust me in all things. Only I know the secret paths of the desert and where to find water. Only I can guide you safely through."
			)
			((or (== (event type:) evMOUSEBUTTON) (Said 'look,ask,(are<where)>'))
				(cond
					(
						(or
							(Said '//man')
							(Said '[/merlin]/man')
							(MouseClaimed jabir event)
						)
						(Print 35 23) ; "He looks a dry and hard man, as one might look from a lifetime in harsh deserts."
					)
					((Said 'look>') 0)
					((Said '[/man]/boy')
						(localproc_2 35 24) ; "Ignore the brat and let us do business."
					)
					((Said '[/man]/alsirat')
						(localproc_2 35 25) ; "He is an impoverished old scholar. Do not waste your time with him."
					)
					((Said '[/man]/grail')
						(localproc_2 35 26) ; "Never heard of it."
					)
					((Said '[/man]/wadi,waterhole')
						(localproc_2 35 27) ; "Trust me in all things. I can lead you safely to all waterholes and wadis."
					)
					((Said '[/man]/galahad')
						(localproc_2 35 28) ; "There was another like you, but he was gone from here before I could offer my services."
					)
					((Said '[/man]/*')
						(localproc_2 35 29) ; "If you must ask questions, let us at least get started on the trip and talk later."
					)
				)
			)
		)
	)
)

(instance hazmWindow of SysWindow
	(properties
		color 8
		back 11
		title {Hazm ibn Salim}
		brTop 32
		brLeft 186
		brBottom 120
		brRight 238
	)
)

(instance jabirWindow of SysWindow
	(properties
		color 14
		back 0
		title {Jabir ibn Hamid}
		brTop 24
		brLeft 50
		brBottom 80
		brRight 200
	)
)

(instance wave1 of Prop
	(properties
		y 164
		x 9
		view 135
		priority 1
		signal 16400
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setScript: crashingWave)
	)
)

(instance waveEnd of End
	(properties)
)

(instance crashingWave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					cel: 0
					x: (Random 7 25)
					y: (Random 163 185)
					setCycle: waveEnd self
				)
			)
			(1
				(= seconds (Random 4 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance wave2 of Prop
	(properties
		y 103
		x 4
		view 135
		loop 1
		priority 1
		signal 16400
		cycleSpeed 6
	)
)

(instance Rm35 of eRoom
	(properties
		picture 35
	)

	(method (init)
		(self style: (if (== gPrevRoomNum 34) 0 else 15)) ; Voyage
		(Load rsVIEW 35)
		(Load rsVIEW 90)
		(Load rsVIEW 135)
		(Load rsVIEW 390)
		(Load rsVIEW 389)
		(Load rsVIEW 392)
		(Load rsSCRIPT 960)
		(super init:)
		(proc0_13 64)
		(gAddToPics doit:)
		(gRmMusic number: 86 priority: 1 loop: -1 play:)
		(gEgo view: 0 init:)
		(gTObj tLoop: 4 init:)
		(= local3 0)
		(wave1 init:)
		(wave2 init: setCycle: Fwd)
		(switch gPrevRoomNum
			(36
				(if (IsFlag 78)
					(hazm setScript: hazmWaiting)
				else
					(self enterRoom: 250 235 170 177 1)
				)
				(if (IsFlag 20)
					(gCurRoom setRegions: 116) ; muleReg
					(self muleEnterRoom: 310 210 272 180)
				)
			)
			(else
				(self comingIn: 0)
				(gEgo get: 3) ; purse
				(SetMenu 1281 112 1)
				(if (IsFlag 72)
					(gEgo get: 2) ; lodestone
				)
				(SetFlag 20)
				(jabir init:)
				(jHead init:)
				(hazm init:)
				(gCurRoom setRegions: 116) ; muleReg
				(gEgo setScript: (ScriptID 194 0)) ; fromShip
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((and (== (gEgo onControl: 1) 4) (not (IsFlag 128)))
					(if (< (gEgo y:) 133)
						(= local0 1)
					)
					(gEgo setScript: fallOffPier)
				)
				((and (== (gEgo onControl: 1) 2) (not (IsFlag 128)))
					(gEgo setScript: fallDownRocks)
				)
				((and (== (gEgo onControl: 1) 8192) (not (IsFlag 128)))
					(gEgo setScript: turnFromRamp)
				)
				((and (> (gEgo x:) 310) (not local3))
					(gRmMusic stop:)
					(gMuleObj setMotion: MoveTo 320 220)
					(self leaveRoom: 36 320 (gEgo y:))
				)
				(
					(and
						(> (gEgo y:) 185)
						(not (IsFlag 128))
						(not local3)
						(not local6)
					)
					(gRmMusic stop:)
					(gMuleObj setMotion: MoveTo 320 220)
					(self leaveRoom: 36 (gEgo x:) 235)
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
			((OnButton event 22 75 46 94)
				(Print 35 30) ; "It is an old tower on a spit of land."
			)
			((OnButton event 91 7 240 55)
				(Print 35 31) ; "The sail was carefully repaired after the storm."
			)
			(
				(or
					(OnButton event 222 85 310 148)
					(OnButton event 81 100 226 142)
				)
				(Print 35 32) ; "By my beard, you must know every plank of the ship by now, having been aboard for weeks."
			)
			((or (Said 'look/ass') (MouseClaimed gMuleObj event))
				(Print 35 33) ; "Though the mule is here, she looks even more unhappy than when you started this trip."
			)
			((OnButton event 9 154 75 183)
				(Print 35 34) ; "The rocks alongside the dock are slippery. Avoid them."
			)
			((OnButton event 21 133 310 183)
				(Print 35 35) ; "This is one of the stone docks at Gaza port."
			)
			(
				(or
					(Said 'ask/merlin[/advice]')
					(Said 'ask[/merlin]/advice')
					(Said 'talk/merlin[/!*]')
				)
				(if (gCast contains: hazm)
					(Print 35 36) ; "I would strongly advise you to heed this boy."
				else
					(Print 35 37) ; "I would advise you to remember the advice the Captain offered you during the voyage."
				)
			)
			((or (Said 'no') (Said '<no') (Said 'yes') (Said '<yes'))
				(Print 35 38) ; "It is not clear what you want. Try to be more specific."
			)
			(
				(or
					(and (Said 'ask,(are<where)>') (Said '/boy'))
					(Said '/alsirat')
				)
				(if (IsFlag 91)
					(Print 35 39) ; "I suspect that no matter how hard you look, you will not find Al-Sirat or Hazm again."
				else
					(Print 35 40) ; "You should have paid more attention to Hazm. You would undoubtedly know a great deal more than you do now."
				)
			)
			(
				(or
					(Said 'follow,go/man')
					(Said 'go//man')
					(Said 'get//jerusalem,desert')
					(Said 'accept/advice,give,help[/man]')
				)
				(Print 35 41) ; "There is no guide here. You are on your own."
			)
			(
				(or
					(Said 'look,ask,visit,see,go/governer')
					(Said 'get,go,see//governer')
				)
				(Print 35 42) ; "From what we have heard, the mukhtar is the last man you wish to find. Or to have find you. You should dally here no longer."
			)
			((Said 'get,buy/water,canteen,canteen,food,pack,pack')
				(Print 35 43) ; "You will have to make do with what you have or can find."
			)
			((Said 'climb/mainmast,line,shroud')
				(Print 35 44) ; "That is work for sailors, not a warrior-king."
			)
			((Said 'board,enter/boat')
				(Print 35 45) ; "You should be well and truly sick of this ship by now."
			)
			((Said 'kill,attack,annihilate/boy,man,ass')
				(Print 35 46) ; "It seems I must warn you often that such violent urges against those who have done you no wrong will stain your soul and make you unworthy of the Grail."
			)
			(
				(or
					(Said 'get,drink,eat,eat/water,food')
					(Said
						'get,remove,exit,give/clothes,blanket,pack,water,food,canteen'
					)
				)
				(Print 35 47) ; "Unfortunately, you lost nearly everything when the storm washed your pack overboard."
			)
			((Said 'smell')
				(Print 35 48) ; "All seaports share similar odors, mainly the tang of salt and fish."
			)
			((Said 'search/boat')
				(Print 35 49) ; "It has been emptied. Do not waste your time."
			)
			(
				(or
					(Said 'pay[/!*]>')
					(Said 'give,pay,count/coin,copper,dirham,dinar>')
				)
				(cond
					(
						(or
							(not (gCast contains: jabir))
							(Said '//boy')
							(Said '/<boy')
						)
						(gTObj noWidth: 1 tWindow: hazmWindow)
						(if (and (gCast contains: hazm) (DoPurse))
							(event claimed: 1)
							(localproc_1 35 50) ; "Thank you, sir, but I cannot accept money. My reward is serving my Master well."
							(proc0_18)
						else
							(event claimed: 0)
						)
					)
					((DoPurse)
						(event claimed: 1)
						(= global132
							(= global129 (= global130 (= global131 0)))
						)
						(= local4 1)
						(gEgo setScript: goWithJabir)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(
				(Said
					'get,move,press,annihilate,attack/boat,mainmast,sail,line,gangplank'
				)
				(Print 35 51) ; "You have no business doing so."
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
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
						)
						(if (== gPrevRoomNum 34) ; Voyage
							(Print 35 52) ; "It would appear that you slept through the entire unloading of the ship. Even the crew is gone."
						)
						(Print 35 53) ; "Before you lies the sun-baked village of Gaza. Beyond the town lie hills, and beyond them is the desert."
					)
					((or (Said '/hill,mountain') (Said '//hill,mountain'))
						(Print 35 54) ; "The land rises in rocky hills to the east."
					)
					(
						(or
							(Said 'follow,go/boy')
							(Said 'go//boy')
							(Said 'get//alsirat')
						)
						(Print 35 55) ; "Only Hazm could have shown you the way. You should have followed him when you had the chance."
					)
					((or (Said '/boy') (Said '//boy'))
						(Print 35 56) ; "I presume he is with his Master."
					)
					((or (Said '/man') (Said '//man'))
						(Print 35 57) ; "He is not here."
					)
					((or (Said '/boat,aluzza') (Said '//boat,aluzza'))
						(Print 35 58) ; "It is now quite empty."
					)
					((or (Said '/cargo') (Said '//cargo'))
						(Print 35 59) ; "It has been removed."
					)
					(
						(or
							(Said '/tower,turret,fort,building')
							(Said '//tower,turret,fort,building')
						)
						(Print 35 60) ; "It is made of stone, part of an old fortification."
					)
					((or (Said '/dock') (Said '//dock'))
						(Print 35 61) ; "It is built of stone, solid and functional."
					)
					(
						(or
							(Said '/water,ocean,breaker')
							(Said '//water,ocean,breaker')
						)
						(Print 35 62) ; "You have been looking at the waves for week upon weary week. There is nothing new to see."
					)
					(
						(or
							(Said '/ass,pack,food,water,possession')
							(Said '//ass,pack,food,water,possession')
						)
						(Print 35 63) ; "At this moment, everything you possess is upon your person, except for your mule."
					)
					((or (Said '/mainmast') (Said '//mainmast'))
						(Print 35 64) ; "Aye, 'tis a mast. It holds the sail."
					)
					((or (Said '/gangplank') (Said '//gangplank'))
						(Print 35 65) ; "Aye, it connects the ship to the dock."
					)
					((or (Said '/sail') (Said '//sail'))
						(Print 35 66) ; "It looks the same as it has for weeks."
					)
					((or (Said '/crew') (Said '//crew'))
						(Print 35 67) ; "They are gone."
					)
					((or (Said '/captain') (Said '//captain'))
						(Print 35 68) ; "He is gone."
					)
					((or (Said '/line') (Said '//line'))
						(Print 35 69) ; "Aye, a ship has many ropes."
					)
					((or (Said '/eye') (Said '//eye'))
						(Print 35 70) ; "'Tis not an uncommon practice among foreign seaman to paint an eye upon the prow so that the ship may better see where it is going."
					)
					((or (Said '/bow') (Said '//bow'))
						(Print 35 71) ; "There is a small bit of shelter in the prow, but no cabins. These ships are built for cargo, not comfort."
					)
					((or (Said '/stern') (Said '//stern'))
						(Print 35 72) ; "It has a rudder, as might be expected."
					)
					((or (Said '/shore,land') (Said '//shore,land'))
						(Print 35 73) ; "There is a tower on a spit of land and other hills in the distance in one direction, and the town of Gaza in the other."
					)
					((or (Said '/gaza,city') (Said '//gaza,city'))
						(Print 35 74) ; "It is not much to look at it. Poor dwellings, empty streets, much dirt and an air of hostility."
					)
					((or (Said '/cloud') (Said '//cloud'))
						(Print 35 75) ; "Aye, they are pleasant enough, as clouds go."
					)
					((Said 'look>') 0)
					((Said '/wadi,waterhole')
						(Print 35 76) ; "It is a valley cut into the earth by running water. Sometimes a wadi will still have water, but often they are dry."
					)
					(
						(or
							(Said '[/merlin]/direction,desert,jerusalem')
							(Said '/direction,desert,jerusalem')
						)
						(Print 35 77) ; "I have much book knowledge, but I cannot guide you step by step to a place where I have never been."
					)
				)
			)
		)
	)
)

(instance fallOffPier of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 128)
				(gEgo view: 35 illegalBits: 0 setPri: 5 setLoop: 1 setCel: 1)
				(= cycles 2)
			)
			(1
				(gEgo setCel: 2)
				(= cycles 2)
			)
			(2
				(gEgo
					setCel: 3
					posn: (+ (gEgo x:) 15) (+ (gEgo y:) 24)
				)
				(= cycles 2)
			)
			(3
				(gEgo setCel: 4 posn: (+ (gEgo x:) 3) (+ (gEgo y:) 17))
				(= cycles 2)
			)
			(4
				(gEgo posn: (+ (gEgo x:) 7) (+ (gEgo y:) 15))
				(= cycles 2)
			)
			(5
				(splash
					posn: (gEgo x:) (if local0 145 else 154)
					setPri: 5
					init:
					setCycle: End self
				)
			)
			(6
				(localproc_0)
			)
		)
	)
)

(instance turnFromRamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 128)
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
				)
			)
			(1
				(Print 35 45) ; "You should be well and truly sick of this ship by now."
				(ClearFlag 128)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fallDownRocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 128)
				(if (IsFlag 20)
					(gMuleObj setScript: 0 setMotion: 0)
				)
				(gEgo
					view: 35
					illegalBits: 0
					setLoop: 0
					setCel: 1
					posn: (- (gEgo x:) 5) (- (gEgo y:) 1)
				)
				(= cycles 2)
			)
			(1
				(gEgo setCel: 2 posn: (- (gEgo x:) 4) (+ (gEgo y:) 5))
				(= cycles 2)
			)
			(2
				(gEgo setCel: 3 posn: (- (gEgo x:) 2) (+ (gEgo y:) 7))
				(= cycles 2)
			)
			(3
				(gEgo setCel: 4 posn: (- (gEgo x:) 6) (+ (gEgo y:) 8))
				(= cycles 2)
			)
			(4
				(gEgo posn: (- (gEgo x:) 20) (+ (gEgo y:) 25))
				(= cycles 10)
			)
			(5
				(localproc_0)
			)
		)
	)
)

(instance goWithHazm of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and local1 (> (hazm y:) 170))
				(= local1 0)
				(gEgo setScript: followOut 0 82)
			)
			(
				(or
					(& (hazm signal:) $0400)
					(and (& (gEgo signal:) $0400) (gEgo mover:))
				)
				(self changeState: 3)
			)
			((> (gEgo y:) 185)
				(gMuleObj setMotion: MoveTo 320 220)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo hazm)
				(hazm illegalBits: -32768)
				(= local1 1)
				(= local3 1)
				(gTObj talkCue: self)
				(localproc_1 35 78) ; "You are the wisest of men, sir, except for my Master! Please follow me."
			)
			(1
				(if (< (gEgo x:) 150)
					(hazm cycleSpeed: 0 setCycle: End self)
				else
					(hazm cel: 5)
					(= cycles 1)
				)
			)
			(2
				(jabir setLoop: 0 cel: 2 setCycle: Beg)
				(localproc_2 35 79) ; "The desert lies ahead. You will never cross it without my help."
				(ClearFlag 78)
				(hazm
					setCycle: Walk
					setLoop: 7
					setCel: -1
					setMotion: MoveTo 260 250
				)
			)
			(3
				(if (< (gEgo x:) 127)
					(gEgo
						setMotion: MoveTo (+ (jabir x:) 20) (gEgo y:) self
					)
				else
					(gEgo
						setMotion: MoveTo (- (hazm x:) 15) (gEgo y:) self
					)
				)
			)
			(4
				(if (not (gEgo mover:))
					(gEgo setScript: followOut 0 82)
				)
			)
		)
	)
)

(instance goWithJabir of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and local1 (> (jabir y:) 175))
				(= local1 0)
				(gEgo setScript: followOut 0 36)
			)
			(
				(or
					(& (jabir signal:) $0400)
					(and (& (gEgo signal:) $0400) (gEgo mover:))
				)
				(self changeState: 2)
			)
			((> (gEgo y:) 185)
				(gMuleObj setMotion: MoveTo 320 220)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local1 1)
				(gTObj talkCue: self)
				(jabir illegalBits: -32768)
				(if local4
					(localproc_2 35 80) ; "You need not pay now, but I could not insult your generosity by refusing. Let us set out at once!"
				else
					(localproc_2 35 81) ; "Excellent! Let us waste no time! Follow me."
				)
				(if (!= (hazm cel:) 5)
					(hazm cycleSpeed: 0 setCycle: End)
				)
			)
			(1
				(hazm
					setLoop: 7
					setCel: -1
					setCycle: Walk
					setMotion: MoveTo 185 165
				)
				(gEgo
					view: 0
					setPri: -1
					setLoop: -1
					setCel: -1
					loop: 2
					cel: 0
					illegalBits: -32768
					cycleSpeed: 0
					moveSpeed: 0
					ignoreActors: 0
					setCycle: Walk
				)
				(jHead dispose:)
				(jabir
					setCycle: Walk
					view: 389
					setLoop: 2
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 290 270 self
				)
				(RedrawCast)
				(= global189 1)
			)
			(2
				(if (not (gEgo mover:))
					(if (< (gEgo x:) 127)
						(gEgo
							setMotion:
								MoveTo
								(- (jabir x:) 20)
								(gEgo y:)
								self
						)
					else
						(gEgo
							setMotion: MoveTo (- (hazm x:) 25) (gEgo y:) self
						)
					)
				)
			)
			(3
				(if (not (gEgo mover:))
					(gEgo setScript: followOut 0 36)
				)
			)
		)
	)
)

(instance followOut of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(or
				(not (localproc_3 230 235))
				(and
					(== (gMuleObj y:) 165)
					(gEgo inRect: (gMuleObj x:) 158 340 210)
				)
			)
			(gEgo
				ignoreActors: 1
				illegalBits: 0
				setMotion: MoveTo 230 235 splash
			)
			(= local6 1)
			(self dispose:)
		)
		(if (not (gEgo mover:))
			(gEgo setMotion: MoveTo -500 (gEgo y:))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register 36)
					(jabir ignoreActors: 1)
				else
					(hazm ignoreActors: 1)
				)
			)
		)
	)
)

(instance hazmWaiting of Script
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
					(Said 'yes')
					(Said '<yes')
					(Said 'hire,follow,go,see/boy,alsirat')
					(Said 'go//boy')
					(Said 'talk,visit/alsirat')
					(Said 'get,man//alsirat')
					(Said 'accept/advice,give,help[<boy]')
					(Said 'accept/[boy]/advice,give,help')
				)
				(self changeState: 8)
			)
			((or (Said 'no') (Said '<no'))
				(if (> (self state:) 3)
					(self changeState: 5)
				else
					(Print 35 38) ; "It is not clear what you want. Try to be more specific."
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and local1 (> (hazm y:) 170))
				(= local1 0)
				(gEgo setScript: followOut 0 82)
			)
			((and (& (hazm signal:) $0400) (< state 11))
				(self changeState: 11)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 78)
				(gEgo
					loop: 1
					posn: 250 235
					init:
					setMotion: MoveTo 170 177 self
				)
				(hazm loop: 3 cel: 0 posn: 120 160 init:)
			)
			(1
				(hazm loop: 6 setCycle: Yoyo 1 self cycleSpeed: 0)
			)
			(2
				(gTObj
					talkCue: self
					noWidth: 1
					tWindow: hazmWindow
					actor: 0
				)
				(Talk 35 82) ; "Oh, sir! I am so happy you have returned!"
			)
			(3
				(gTObj talkCue: self noWidth: 1)
				(Talk 35 83) ; "Please, will you come with me now and accept the hospitality of my Master, Al-Sirat?"
			)
			(4
				(gCurRoom comingIn: 0)
				(HandsOn)
			)
			(5
				(HandsOff)
				(gTObj talkCue: self noWidth: 1)
				(Talk 35 84) ; "Al-Sirat is only poor in worldly goods, but in knowledge and wisdom he is the richest man on earth!"
			)
			(6
				(gTObj talkCue: self noWidth: 1)
				(Talk 35 85) ; "If you change your mind, sir, I will still gladly lead you to him. But I must return to him soon, either with or without you."
			)
			(7
				(self changeState: 3)
				(HandsOn)
			)
			(8
				(HandsOff)
				(= local1 1)
				(= local2 1)
				(= local3 1)
				(ClearFlag 78)
				(gEgo setMotion: 0)
				(gTObj talkCue: self noWidth: 1)
				(Talk 35 86) ; "You are the wisest of men, sir, except for my Master!  Please follow me."
			)
			(9
				(if (< (gEgo y:) 150)
					(hazm cycleSpeed: 0 setCycle: End self)
				else
					(hazm cel: 5)
					(= cycles 1)
				)
			)
			(10
				(hazm
					setLoop: 7
					setCel: -1
					setCycle: Walk
					setMotion: MoveTo 260 250
				)
			)
			(11
				(if (not (gEgo mover:))
					(gEgo
						setMotion: MoveTo (- (hazm x:) 15) (gEgo y:) self
					)
				)
			)
			(12
				(gEgo setScript: followOut 0 82)
			)
		)
	)
)

