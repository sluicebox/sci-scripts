;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 203)
(include sci.sh)
(use Main)
(use Gaza)
(use Interface)
(use System)

(public
	GazaSaid 0
)

(instance GazaSaid of Script
	(properties)

	(method (handleEvent event &tmp [temp0 4])
		(cond
			((Said 'sat[<on][/boulder]')
				(Print 203 0) ; "You would not enjoy that. These rocks are hot enough to toast nuts."
			)
			((or (Said 'look<down') (Said 'look/dirt'))
				(Print 203 1) ; "The ground is rocky and as hot as the furnaces of Hades."
			)
			((or (Said 'look<up') (Said 'look/sky,cloud,sun'))
				(Print 203 2) ; "You dare not look long at the glaring sky, unbroken by any cloud, where the sun burns as mercilessly as a demon's eye."
			)
			((Said 'exit,abandon,remove,(get<off)/armor')
				(Print 203 3) ; "Hot as it is, you are better off wearing it than carrying it, and you must not even consider leaving it behind."
			)
			((Said 'ride,(climb,get<on)/ass')
				(cond
					((IsFlag 20)
						(Print 203 4) ; "In this heat, such a burden would soon kill her."
					)
					((>= global202 2)
						(Print 203 5) ; "You sold the mule, Arthur."
					)
					(else
						(Print 203 6) ; "The mule is not here."
					)
				)
			)
			((Said 'look,use,get,find/canteen,(fur<water)')
				(Print 203 7) ; "You have no waterskin, sad to say."
			)
			((Said 'get,capture,eat,kill/lizard,reptile')
				(Print 203 8) ; "First you must find one."
			)
			((Said 'get,capture,eat,kill/adder')
				(Print 203 9) ; "There is no snake here."
			)
			((Said 'get,(pick<up)/boulder,slab')
				(Print 203 10) ; "The last thing you need to carry is a rock hot enough to burn your fingers."
			)
			((Said 'climb/cliff,hill,plateau,mesa')
				(Print 203 11) ; "It would be a staggering waste of energy, even if it were possible, but these cliffs are steep and offer no grip for hand or foot."
			)
			((Said 'get,buy,bargain/canteen,fur')
				(Print 203 12) ; "It is a terrible shame that Gaza was closed to you, or you might have obtained a waterskin there."
			)
			(
				(or
					(Said 'follow,go,hire/hamid')
					(Said 'go//hamid')
					(Said 'get//jerusalem,desert')
					(Said 'accept/advice,give,help[<hamid]')
					(Said 'accept/[hamid]/advice,give,help')
				)
				(if global169
					(if (== global189 9)
						(Print 203 13) ; "Now???"
					else
						(switch gCurRoomNum
							(36
								(= global189 2)
								((ScriptID 130 0) setScript: (ScriptID 183 0)) ; Jabir, thanksBuddy
							)
							(44
								(Talk 203 14) ; "We are here, habib, at the water."
							)
							(else
								(Talk 203 15) ; "We are on our way to water now, habib."
							)
						)
					)
				else
					(Print 203 16) ; "You waste precious breath talking to the air."
				)
			)
			((Said 'get,capture,kill,attack,annihilate/hamid')
				(cond
					((== global189 10)
						(Print 203 17) ; "Rather redundant, Arthur, since he is dead."
					)
					((not global169)
						(Print 203 18) ; "The heat must be affecting your brain. There is no sign of Jabir."
					)
					((not global124)
						(= global125 1)
					)
				)
			)
			((or (Said 'look<below/boulder') (Said 'lift/boulder'))
				(Print 203 19) ; "You would find only barren ground."
			)
			((Said 'get,find,(pick<up)/dagger')
				(if (== global189 10)
					(if (== gCurRoomNum global177)
						(Print 203 20) ; "It broke under the ferocity of your assault and is of no use whatsoever."
					else
						(Print 203 21) ; "You can hardly do that from here."
					)
				else
					(event claimed: 0)
				)
			)
			((or (Said 'search,smell/hamid,body') (Said 'look/body,flea,lice'))
				(if (== global189 10)
					(if (== gCurRoomNum global177)
						(Print 203 22) ; "There are fleas and lice, drying blood and a ripe smell. There is nothing of any worth."
					else
						(Print 203 21) ; "You can hardly do that from here."
					)
				else
					(Print 203 23) ; "The heat has affected your thinking, I perceive."
				)
			)
			((Said 'get,find,drink/water')
				(Print 203 24) ; "Aye, an excellent idea, provided you can find some."
			)
			(
				(or
					(Said 'ask/merlin[/advice]')
					(Said 'ask/advice[<merlin][/!*]')
					(Said 'talk/merlin[/!*]')
				)
				(if (IsFlag 106)
					(Print 203 25) ; "You must return to Jerusalem at once and finish your dealings with Fatima."
				else
					(Print 203 26) ; "I can give you little more than encouragement and observation where this desert is concerned."
				)
			)
			((or (Said 'talk,ask[/merlin]>') (Said 'tell[/me]>') (Said 'look>'))
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '/desert,gaza,cliff,mesa,terrain,wadi')
							(Said '//desert,gaza,cliff,mesa,terrain,wadi')
						)
						(Print 203 27) ; "This is a desert of extreme terrain. Sudden cliffs rise and block your way, while wadis unexpectedly appear in the ground."
					)
					((or (Said '/boulder') (Said '//boulder'))
						(proc107_2)
					)
					((or (Said '/guenevere') (Said '//guenevere'))
						(if (IsFlag 65)
							(Print 203 28) ; "She is well. She prays daily for your safety and ministers to Launcelot as he recovers from the Ice Maiden's spell."
						else
							(Print 203 29) ; "She prays daily for your well-being and success, and for the safe return of Launcelot."
						)
					)
					((or (Said '/lancelot') (Said '//lancelot'))
						(if (IsFlag 65)
							(Print 203 30) ; "With the tender help of Gwenhyver and her ladies, he is recovering very well from his frozen sojourn."
						else
							(Print 203 31) ; "Alas, you have not saved Launcelot. Thus you have jeopardized the success of your entire mission."
						)
					)
					(
						(or
							(Said '/jerusalem,wall,gate')
							(Said '//jerusalem,wall,gate')
						)
						(if (IsFlag 114)
							(Print 203 32) ; "I hope you remember the way back to Jerusalem. It would not do to get lost now."
						else
							(Print 203 33) ; "There is no sign of Jerusalem yet."
						)
					)
					((or (Said '/plateau') (Said '//plateau'))
						(Print 203 34) ; "You should avoid the huge, flat areas of desert plateau, unless you have reason to think there is water there."
					)
					((or (Said '/hill') (Said '//hill'))
						(Print 203 35) ; "There are some hills in the distance, and the ground rises steadily toward the north and east."
					)
					((or (Said '/adder') (Said '//adder'))
						(Print 203 36) ; "There is no snake here, fortunately, for the cobras of this desert are quite lethal."
					)
					((or (Said '/lizard,reptile') (Said '//lizard,reptile'))
						(Print 203 37) ; "The lizards in this area are swift and harmless."
					)
					((or (Said '/wadi,oasis') (Said '//wadi,oasis'))
						(if (or (IsFlag 111) (IsFlag 106))
							(Print 203 38) ; "That is not important now. You must get back to Jerusalem."
						else
							(Print 203 39) ; "I have no knowledge of where water may be hidden in a wadi or oasis. You must search."
						)
					)
					(
						(or
							(Said '/water,lake,pool,spring')
							(Said '//water,lake,pool,spring')
						)
						(if (or (IsFlag 111) (IsFlag 106))
							(Print 203 40) ; "Well, you know where the Pool of Siloam is."
						else
							(Print 203 41) ; "I cannot help you find water. I have no such intimate knowledge of this desert."
						)
					)
					(
						(or
							(Said '/direction,path,path')
							(Said '//direction,path,path')
						)
						(if (or (IsFlag 111) (IsFlag 106))
							(Print 203 42) ; "Let us hope you remember the way well enough."
						else
							(Print 203 43) ; "There is no hint of where to go in this trackless desert."
						)
					)
					((or (Said '/shade') (Said '//shade'))
						(Print 203 44) ; "Even the shadows provide little relief from the heat."
					)
					((or (Said '/sand,dune') (Said '//sand,dune'))
						(Print 203 45) ; "The shifting sands erase any traces of where you have been."
					)
					((or (Said '/hamid') (Said '//hamid'))
						(cond
							((== global189 10)
								(Print 203 46) ; "You have most prudently slain him."
							)
							(global169
								(Print 203 47) ; "He looks a dry and hard man, as one might look from a lifetime in harsh deserts."
							)
							((< 0 global189 8)
								(Print 203 48) ; "Jabir waits for you to follow him."
							)
							(else
								(Print 203 49) ; "There is no apparent sign of him, but that means little with such a cunning desert dweller."
							)
						)
					)
					((or (Said '/delusion') (Said '//delusion'))
						(if (IsFlag 110)
							(Print 203 50) ; "Your brain invents delusions from lack of water and the intense heat. Do not dwell upon it."
						else
							(Print 203 51) ; "A mirage is usually an illusion of water, a bizarre phenomenon of the deserts."
						)
					)
				)
			)
		)
		(DisposeScript 203)
	)
)

