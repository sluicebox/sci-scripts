;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 107)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Follow)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Gaza 0
	muleFollow 1
	proc107_2 2
)

(synonyms
	(jerusalem city)
	(hamid arab guide man)
)

(local
	local0
	[local1 7] = [0 165 190 160 190 100 160]
	[local8 7] = [0 130 60 65 0 95 100]
	[local15 7] = [0 265 270 260 260 195 240]
	[local22 7] = [0 165 90 100 100 140 120]
	local29
	local30
	local31
	local32
	local33
)

(procedure (proc107_2)
	(switch (Random 0 2)
		(0
			(Print 107 0) ; "There are countless rocks in this desert. This is yet another one."
		)
		(1
			(Print 107 1) ; "Aye, 'tis a rock. A very hot rock."
		)
		(2
			(Print 107 2) ; "One rock is much like any other in this merciless terrain."
		)
	)
)

(instance Gaza of Rgn
	(properties)

	(method (dispose)
		(if (== global189 8)
			(= global189 9)
		)
		(super dispose:)
		(DisposeScript 971)
	)

	(method (init)
		(Load rsVIEW 59)
		(Load rsVIEW 58)
		(Load rsVIEW 57)
		(Load rsSCRIPT 144)
		(Load rsSCRIPT 910)
		(Load rsSCRIPT 912)
		(if (!= global189 10)
			(Load rsSCRIPT 130)
		)
		(if (IsFlag 20)
			(Load rsSCRIPT 116)
			(Load rsSCRIPT 971)
		)
		(Load rsSOUND 91)
		(Load rsSOUND 58)
		(super init:)
		(if (== global204 0)
			(= global204 8000)
			(ClearFlag 98)
		)
		(if (== global205 0)
			(= global205 10000)
			(ClearFlag 107)
		)
		(if (< gPrevRoomNum 36)
			(SetFlag 20)
		)
		(if (IsFlag 20)
			(gCurRoom setRegions: 116) ; muleReg
			(gMuleObj setScript: muleFollow)
		)
		(switch gCurRoomNum
			(37
				(= local0 1)
			)
			(38
				(= local0 2)
			)
			(42
				(= local0 3)
			)
			(46
				(= local0 4)
			)
			(48
				(= local0 5)
			)
			(49
				(= local0 6)
			)
		)
		(cond
			((IsFlag 111)
				(= local32 1)
			)
			((IsFlag 106)
				(= local33 1)
			)
		)
		(if (== global177 gCurRoomNum)
			((= local30 (View new:))
				view: 397
				setLoop: global176
				setCel: 5
				posn: global174 global175
				init:
				stopUpd:
			)
		)
		(gEgo view: (if global124 6 else 0) looper: 0)
		(if (or (!= (gRegMusic number:) 58) (== gPrevRoomNum 41) (== gPrevRoomNum 35))
			(gRegMusic number: 58 priority: 1 loop: -1 play:)
		)
	)

	(method (doit)
		(if (IsFlag 124)
			(ClearFlag 124)
			(EgoDead 107 3) ; "This treacherous false guide has claimed yet another victim! Would that you had been a bit quicker with your sword on this occasion."
		)
		(cond
			(
				(and
					(== global189 9)
					(not local29)
					(gEgo
						inRect:
							[local1 local0]
							[local8 local0]
							[local15 local0]
							[local22 local0]
					)
					(or
						(== (gEgo loop:) (if (== gCurRoomNum 48) 1 else 0))
						(== (gEgo loop:) 3)
					)
				)
				(= local29 1)
				(User canControl: 0)
				(gEgo setMotion: 0)
				(SetMenu 1281 112 0)
				((ScriptID 130 0) setScript: (ScriptID 180 0)) ; Jabir, killKing
			)
			((and (IsFlag 122) (not global154) (== global189 10))
				(= global154 1)
				(ClearFlag 122)
				((ScriptID 130 0) dispose:) ; Jabir
				((= local30 (View new:))
					view: 397
					setLoop: global176
					setCel: 5
					posn: global174 global175
					init:
					stopUpd:
				)
			)
		)
		(cond
			((> global137 1)
				(-- global137)
			)
			((== global137 1)
				(= global137 0)
				(SetFlag 113)
			)
		)
		(cond
			((and (< global204 3000) (not (IsFlag 98)))
				(SetFlag 98)
			)
			((> global204 1)
				(if global124
					(-= global204 2)
				else
					(-- global204)
				)
			)
			((== global204 1)
				(= global204 0)
				(SetFlag 92)
			)
		)
		(cond
			((and (< global205 3000) (not (IsFlag 107)))
				(SetFlag 107)
			)
			((> global205 1)
				(-- global205)
			)
			((== global205 1)
				(= global205 2999)
			)
		)
		(cond
			(
				(and
					(not (IsFlag 98))
					(not (IsFlag 92))
					(== (gEgo view:) 57)
					(not (gEgo script:))
					(not global124)
				)
				(gEgo view: 0)
			)
			(
				(and
					(or (IsFlag 98) (IsFlag 92))
					(== (gEgo view:) 0)
					(not (gEgo script:))
					(not global124)
				)
				(gEgo view: 57)
				(if (not (IsFlag 85))
					(SetFlag 85)
					(Print 107 4) ; "Arthur, you must find water at once or you will perish!"
				)
			)
			((and (IsFlag 107) (IsFlag 20) (!= (gMuleObj view:) 404))
				(gMuleObj view: 423)
				(if (not (IsFlag 108))
					(SetFlag 108)
					(Print 107 5) ; "Your mule is dying from lack of water!"
				)
			)
			(
				(and
					(not (gCurRoom goingOut:))
					(not (gCurRoom comingIn:))
					(not (gEgo script:))
					(not (gCurRoom script:))
					(not global169)
					global124
					(IsFlag 113)
				)
				(ClearFlag 113)
				(Print 107 6) ; "Arthur, holding your sword constantly at the ready only serves to tire you more quickly."
				(= global125 2)
			)
			(
				(and
					(not (gCurRoom goingOut:))
					(not (gCurRoom comingIn:))
					(not (gCurRoom script:))
					(not (gEgo script:))
					(not (IsFlag 82))
					(not global124)
					(not global169)
					(IsFlag 92)
				)
				(if (IsFlag 20)
					(gMuleObj setMotion: 0)
					(DisposeScript 971)
				)
				(gEgo setScript: (ScriptID 144 0)) ; crawler
				(ClearFlag 92)
				(gRmMusic number: 91 priority: 4 loop: 1 play:)
				(gRegMusic stop:)
			)
		)
		(super doit:)
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
			((Said 'draw/blade')
				(if (and (not global169) (!= global189 9))
					(= global137 100)
				)
			)
			((Said 'crawl')
				(= global204 10)
			)
			((Said '/thirst')
				(= global204 1000)
			)
			((or (Said 'look<down') (Said 'look/dirt'))
				(Print 107 7) ; "The ground is rocky and as hot as the furnaces of Hades."
			)
			((or (Said 'look<up') (Said 'look/sky,cloud,sun'))
				(Print 107 8) ; "You dare not look long at the glaring sky, unbroken by any cloud, where the sun burns as mercilessly as a demon's eye."
			)
			((Said 'exit,abandon,remove,(get<off)/armor')
				(Print 107 9) ; "Hot as it is, you are better off wearing it than carrying it, and you must not even consider leaving it behind."
			)
			((Said 'ride,(climb,get<on)/ass')
				(if (IsFlag 20)
					(Print 107 10) ; "In this heat, such a burden would soon kill her."
				else
					(Print 107 11) ; "You sold the mule, Arthur."
				)
			)
			((Said 'look,use,get,find/canteen,(fur<water)')
				(Print 107 12) ; "You have no waterskin, sad to say."
			)
			((Said 'get,capture,eat,kill/lizard,reptile')
				(Print 107 13) ; "First you must find one."
			)
			((Said 'get,capture,eat,kill/adder')
				(Print 107 14) ; "There is no snake here."
			)
			((Said 'get,(pick<up)/boulder,slab')
				(Print 107 15) ; "The last thing you need to carry is a rock hot enough to burn your fingers."
			)
			((Said 'climb/cliff,hill,plateau,mesa')
				(Print 107 16) ; "It would be a staggering waste of energy, even if it were possible, but these cliffs are steep and offer no grip for hand or foot."
			)
			((Said 'get,buy,bargain/canteen,fur')
				(Print 107 17) ; "It is a terrible shame that Gaza was closed to you, or you might have obtained a waterskin there."
			)
			(
				(or
					(Said 'talk,follow,go,hire/hamid')
					(Said 'go//hamid')
					(Said 'get//jerusalem,desert')
					(Said 'accept/advice,give,help[<hamid]')
					(Said 'accept/[hamid]/advice,give,help')
				)
				(Print 107 18) ; "You waste precious breath talking to the air."
			)
			((Said 'get,capture,kill,attack,annihilate/hamid')
				(cond
					((== global189 10)
						(Print 107 19) ; "Rather redundant, Arthur, since he is dead."
					)
					((not global169)
						(Print 107 20) ; "The heat must be affecting your brain. There is no sign of Jabir."
					)
					((not global124)
						(= global125 1)
					)
				)
			)
			((Said 'sat[<on][/boulder]')
				(Print 107 21) ; "You would not enjoy that. These rocks are hot enough to toast nuts."
			)
			((or (Said 'look<below/boulder') (Said 'lift/boulder'))
				(Print 107 22) ; "You would find only barren ground."
			)
			((Said 'get,find,(pick<up)/dagger')
				(if (== global189 10)
					(if (== gCurRoomNum global177)
						(Print 107 23) ; "It broke under the ferocity of your assault and is of no use whatsoever."
					else
						(Print 107 24) ; "You can hardly do that from here."
					)
				else
					(event claimed: 0)
				)
			)
			((or (Said 'search,smell/hamid,body') (Said 'look/body,flea,lice'))
				(if (== global189 10)
					(if (== gCurRoomNum global177)
						(Print 107 25) ; "There are fleas and lice, drying blood and a ripe smell. There is nothing of any worth."
					else
						(Print 107 24) ; "You can hardly do that from here."
					)
				else
					(Print 107 26) ; "The heat has affected your thinking, I perceive."
				)
			)
			(
				(or
					(Said 'ask/merlin[/advice]')
					(Said 'ask/advice[<merlin][/!*]')
					(Said 'talk/merlin[/!*]')
				)
				(if local33
					(Print 107 27) ; "You must return to Jerusalem at once and finish your dealings with Fatima."
				else
					(Print 107 28) ; "I can give you little more than encouragement and observation where this desert is concerned."
				)
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
							(Said '/desert,gaza,cliff,mesa,terrain,wadi')
							(Said '//desert,gaza,cliff,mesa,terrain,wadi')
						)
						(Print 107 29) ; "This is a desert of extreme terrain. Sudden cliffs rise and block your way, while wadis unexpectedly appear in the ground."
					)
					((or (Said '/boulder') (Said '//boulder'))
						(proc107_2)
					)
					((or (Said '/guenevere') (Said '//guenevere'))
						(if (IsFlag 65)
							(Print 107 30) ; "She is well. She prays daily for your safety and ministers to Launcelot as he recovers from the Ice Maiden's spell."
						else
							(Print 107 31) ; "She prays daily for your well-being and success, and for the safe return of Launcelot."
						)
					)
					((or (Said '/lancelot') (Said '//lancelot'))
						(if (IsFlag 65)
							(Print 107 32) ; "With the tender help of Gwenhyver and her ladies, he is recovering very well from his frozen sojourn."
						else
							(Print 107 33) ; "Alas, you have not saved Launcelot. Thus you have jeopardized the success of your entire mission."
						)
					)
					(
						(or
							(Said '/ass')
							(Said '//ass')
							(MouseClaimed gMuleObj event)
						)
						(cond
							((IsFlag 20)
								(if (IsFlag 107)
									(Print 107 34) ; "Your mule suffers and needs water as urgently as you do."
								else
									(event claimed: 0)
								)
							)
							(local33
								(Print 107 35) ; "You sold her to Mohammed, as you should remember."
							)
						)
					)
					(
						(or
							(Said '/jerusalem,wall,gate')
							(Said '//jerusalem,wall,gate')
						)
						(if (IsFlag 114)
							(Print 107 36) ; "I hope you remember the way back to Jerusalem. It would not do to get lost now."
						else
							(Print 107 37) ; "There is no sign of Jerusalem yet."
						)
					)
					((or (Said '/plateau') (Said '//plateau'))
						(Print 107 38) ; "You should avoid the huge, flat areas of desert plateau, unless you have reason to think there is water there."
					)
					((or (Said '/hill') (Said '//hill'))
						(Print 107 39) ; "There are some hills in the distance, and the ground rises steadily toward the north and east."
					)
					((or (Said '/adder') (Said '//adder'))
						(Print 107 40) ; "There is no snake here, fortunately, for the cobras of this desert are quite lethal."
					)
					((or (Said '/lizard,reptile') (Said '//lizard,reptile'))
						(Print 107 41) ; "The lizards in this area are swift and harmless."
					)
					((or (Said '/wadi,oasis') (Said '//wadi,oasis'))
						(if (or local32 local33)
							(Print 107 42) ; "That is not important now. You must get back to Jerusalem."
						else
							(Print 107 43) ; "I have no knowledge of where water may be hidden in a wadi or oasis. You must search."
						)
					)
					(
						(or
							(Said '/water,lake,pool,spring')
							(Said '//water,lake,pool,spring')
						)
						(if (or local32 local33)
							(Print 107 44) ; "Well, you know where the Pool of Siloam is."
						else
							(Print 107 45) ; "I cannot help you find water. I have no such intimate knowledge of this desert."
						)
					)
					(
						(or
							(Said '/direction,path,path')
							(Said '//direction,path,path')
						)
						(if (or local32 local33)
							(Print 107 46) ; "Let us hope you remember the way well enough."
						else
							(Print 107 47) ; "There is no hint of where to go in this trackless desert."
						)
					)
					((or (Said '/shade') (Said '//shade'))
						(Print 107 48) ; "Even the shadows provide little relief from the heat."
					)
					((or (Said '/sand,dune') (Said '//sand,dune'))
						(Print 107 49) ; "The shifting sands erase any traces of where you have been."
					)
					((or (Said '/hamid') (Said '//hamid'))
						(cond
							((== global189 10)
								(Print 107 50) ; "You have most prudently slain him."
							)
							(global169
								(Print 107 51) ; "He looks a dry and hard man, as one might look from a lifetime in harsh deserts."
							)
							(else
								(Print 107 52) ; "There is no apparent sign of him, but that means little with such a cunning desert dweller."
							)
						)
					)
					((or (Said '/delusion') (Said '//delusion'))
						(if (IsFlag 110)
							(Print 107 53) ; "Your brain invents delusions from lack of water and the intense heat. Do not dwell upon it."
						else
							(Print 107 54) ; "A mirage is usually an illusion of water, a bizarre phenomenon of the deserts."
						)
					)
					(
						(and
							(== global189 10)
							(== gCurRoomNum global177)
							(MouseClaimed local30 event)
						)
						(Print 107 25) ; "There are fleas and lice, drying blood and a ripe smell. There is nothing of any worth."
					)
				)
			)
			((Said 'get,find,drink/water')
				(Print 107 55) ; "Aye, an excellent idea, provided you can find some."
			)
		)
	)
)

(instance muleFollow of Script
	(properties)

	(method (doit)
		(if
			(and
				(not (gCurRoom goingOut:))
				(not (gCurRoom comingIn:))
				(not local31)
				(gEgo mover:)
				(not (gEgo script:))
				(not global169)
				(!= global189 9)
				(> (gEgo distanceTo: gMuleObj) 50)
			)
			(= local31 1)
			(gMuleObj setStep: 3 2 setMotion: Follow gEgo 50 setScript: 0)
		)
		(super doit:)
	)
)

