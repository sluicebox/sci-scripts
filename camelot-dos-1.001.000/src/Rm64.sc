;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use n117)
(use Interface)
(use CPath)
(use QSnd)
(use Save)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Rm64 0
	proc64_1 1
	proc64_2 2
	fatima 4
	egoPath 5
	fatimaPath 6
	bellySound 7
)

(synonyms
	(fatima woman)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	[local8 17] = [270 160 305 122 255 90 150 91 20 95 35 132 60 160 160 170 -32768]
	local25
	local26
	[local27 30] = [0 1 1 2 3 5 7 7 8 6 2 3 3 2 2 5 6 1 1 5 8 9 7 7 6 1 2 3 4 -1]
	[local57 11] = [5 7 7 8 7 8 7 8 7 7 -1]
	[local68 13] = [6 1 1 2 1 3 3 2 1 4 1 2 -1]
	[local81 9] = [0 0 1 4 0 4 7 0 0]
	[local90 9] = [0 5 6 7 8 1 2 3 4]
	local99
	local100
	local101
	local102 = -1
	[local103 49] = [61 173 109 162 141 185 174 151 230 173 252 154 292 158 293 141 312 127 294 116 299 96 264 89 233 80 200 90 157 86 118 95 75 89 40 100 17 100 28 117 12 131 30 144 27 167 55 174 -32768]
)

(procedure (proc64_2 param1)
	(return
		(cond
			((param1 inRect: 229 125 319 200) 1)
			((param1 inRect: 184 101 320 125) 2)
			((param1 inRect: 183 71 320 102) 3)
			((param1 inRect: 108 75 184 108) 4)
			((param1 inRect: 0 80 109 119) 5)
			((param1 inRect: 0 118 130 148) 6)
			((param1 inRect: 0 147 131 200) 7)
			((param1 inRect: 130 124 227 200) 8)
		)
	)
)

(procedure (localproc_0)
	(if (> (fatima y:) (gEgo y:))
		(fatima setLoop: 6)
	else
		(fatima setLoop: 5)
	)
)

(procedure (proc64_1)
	(Face gEgo fatima)
	(if (>= (fatima x:) 160)
		(fatimaWindow brLeft: 0 brRight: 200 brTop: 85 brBottom: 185)
	else
		(fatimaWindow brLeft: 150 brRight: 320 brTop: 85 brBottom: 185)
	)
	(if (and (not global219) (== global217 -1))
		(fatima view: 371)
		(gTObj actor: fatima cSpeed: 2)
		(if (> (fatima y:) (gEgo y:))
			(gTObj tLoop: 6)
		else
			(gTObj tLoop: 5)
		)
	)
	(gTObj tWindow: fatimaWindow)
	(Talk &rest)
)

(procedure (localproc_1)
	(return
		(switch global218
			(1 [local57 global217])
			(2 [local68 global217])
			(else [local27 global217])
		)
	)
)

(instance fatimaWindow of SysWindow
	(properties
		color 15
		back 5
		title {Fatima}
	)
)

(instance entryDoor of Prop
	(properties
		y 81
		x 87
		view 164
		priority 1
		signal 16
	)
)

(instance reflection of Prop
	(properties
		y 112
		x 212
		view 164
		loop 3
		priority 8
		signal 16
		cycleSpeed 5
	)
)

(instance sideDoor of Prop
	(properties
		y 77
		x 291
		view 164
		loop 1
		signal 16384
	)

	(method (cue param1)
		(cond
			((== argc 0) 0)
			((== param1 1)
				(= local2 1)
				(sideDoor setCycle: End)
			)
			((== param1 0)
				(sideDoor setCycle: Beg)
			)
		)
	)
)

(instance fatimaPath of CPath
	(properties)

	(method (init param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= index (- (* (= temp0 (proc64_2 param1)) 2) 1))
		(= temp1 (- index endOfPath))
		(= temp3 (self findEnd:))
		(if
			(or
				(>= (/ (= temp2 (- 0 (+ temp3 1))) 2) temp1 temp2)
				(>= (/ temp3 2) temp1 -1)
			)
			(= dir -1)
			(+= index 1)
		else
			(-= index 2)
		)
		(cond
			((<= index 0)
				(= index temp3)
			)
			((> index temp3)
				(= index 0)
			)
		)
		(super init: param1 param2)
	)

	(method (at param1)
		(return [local8 param1])
	)
)

(instance egoPath of CPath
	(properties)

	(method (init param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= index (- (* (= temp0 (proc64_2 param1)) 2) 1))
		(= temp1 (- index endOfPath))
		(= temp3 (self findEnd:))
		(if
			(or
				(>= (/ (= temp2 (- 0 (+ temp3 1))) 2) temp1 temp2)
				(>= (/ temp3 2) temp1 -1)
			)
			(= dir -1)
			(+= index 1)
		else
			(-= index 2)
		)
		(cond
			((<= index 0)
				(= index temp3)
			)
			((> index temp3)
				(= index 0)
			)
		)
		(super init: param1 param2)
	)

	(method (at param1)
		(return [local8 param1])
	)
)

(instance bellySound of QSnd
	(properties
		number 60
		priority 10
		loop -1
	)

	(method (check)
		(if (and signal (u< signal prevSignal))
			(= prevSignal signal)
		)
		(super check:)
	)
)

(instance Rm64 of Rm
	(properties
		picture 64
	)

	(method (init)
		(Load rsSCRIPT 176)
		(Load rsSCRIPT 193)
		(Load rsVIEW 368)
		(Load rsVIEW 369)
		(Load rsVIEW 370)
		(Load rsVIEW 371)
		(Load rsVIEW 91)
		(Load rsVIEW 89)
		(Load rsSOUND 74)
		(Load rsSOUND (proc0_20 73))
		(Load rsSOUND 60)
		(Load rsSOUND 77)
		(super init:)
		(= global218 -1)
		(= global217 -1)
		(= global215 0)
		(= global216 0)
		(= global219 0)
		(= global220 0)
		(SetFlag 137)
		(gEgo view: 0 posn: 70 75 loop: 2 init: illegalBits: $8004)
		(entryDoor init: setCel: (if (== gPrevRoomNum 83) 0 else 255))
		(sideDoor init: stopUpd:)
		(reflection init: setCycle: Fwd)
		(= global185 fatima)
		(= global186 sideDoor)
		(= global187 entryDoor)
		(fatima init:)
		(proc0_13 1120)
		(gAddToPics doit:)
		(if (IsFlag 158)
			(gRmMusic number: 74 loop: -1 play:)
		)
		(if (== gPrevRoomNum 83)
			(gEgo setScript: (ScriptID 176 0)) ; fromSymbolRoom
		else
			(= global215 5)
			(= global216 1)
			(gEgo setScript: enterFatimasHouse)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 176)
		(DisposeScript 193)
		(DisposeScript 917)
		(DisposeScript 959)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			(
				(and
					(IsFlag 163)
					(& (gEgo onControl: 1) $0008)
					(not (gEgo script:))
				)
				(bellySound stop:)
				(gEgo setScript: (ScriptID 176 3)) ; fallDownTrap
			)
			((and (not (IsFlag 163)) (gEgo inRect: 53 80 96 92))
				(gEgo setScript: leaveFatimas)
			)
			((and local2 (& (gEgo onControl:) $0004))
				(ClearFlag 323)
				(gCurRoom newRoom: 83)
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
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((Said 'look/room<other')
						(Print 64 0) ; "You may try, but I do not think you will succeed."
					)
					((Said 'look<below/bed,couch')
						(Print 64 1) ; "I really think you are better off keeping your eyes on Fatima."
					)
					((or (Said '/girl') (Said '//girl'))
						(Print 64 2) ; "This is no girl, Arthur!"
					)
					((or (Said '/room<other') (Said '//room<other'))
						(Print 64 3) ; "I can tell you nothing."
					)
					((Said 'look<up')
						(Print 64 4) ; "Above you is an unadorned ceiling."
					)
					(
						(or
							(Said 'look[/!*]')
							(Said '/room,bedroom')
							(Said '//room,bedroom')
						)
						(if (not (IsFlag 137))
							(Print 64 5) ; "Fatima awaits you upon the other side of a tiled pool. Water splashes from a bronze dolphin fountain. At the other end is a couch amply decorated with pillows. There is only one other door from the room."
						else
							(Print 64 6) ; "Nothing has changed, except perhaps your level of caution."
						)
					)
					((Said 'look/bench')
						(Print 64 7) ; "There is no bench, but there is a couch."
					)
					((or (Said '/door') (Said '//door'))
						(Print 64 8) ; "There is the front door, through which you entered, and a side door which seems to be the only other exit."
					)
					((OnButton event 52 14 88 81)
						(Print 64 9) ; "That is the front door, through which you entered."
					)
					((OnButton event 290 29 311 81)
						(Print 64 10) ; "That side door is the only other door in this room besides the front door."
					)
					((OnButton event 52 84 111 91)
						(Print 64 11) ; "It is a piece of dark slate with a painted edge."
					)
					(
						(or
							(Said '/crescent,design')
							(Said '//crescent,design')
							(OnButton event 296 17 308 27)
						)
						(Print 64 12) ; "The crescent over the side door is a lunar symbol associated with the Goddess."
					)
					(
						(or
							(Said '/sculpture,dolphin,fountain')
							(Said '//sculpture,dolphin,fountain')
							(OnButton event 232 71 252 104)
						)
						(Print 64 13) ; "It is a beautifully sculpted bronze dolphin."
					)
					(
						(or
							(Said '/plant')
							(Said '//plant')
							(OnButton event 231 84 278 115)
						)
						(Print 64 14) ; "I do not recognize her plants, but I doubt they are important."
					)
					(
						(or
							(Said '/pool,water')
							(Said '//pool,water')
							(OnButton event 123 103 242 113)
						)
						(Print 64 15) ; "The utterly clear water ripples in a most mesmerizing way."
					)
					(
						(or
							(Said '/bolster,couch')
							(Said '//bolster,couch')
							(OnButton event 39 100 100 139)
							(OnButton event 70 97 140 145)
						)
						(Print 64 16) ; "The couch with its wealth of lush pillows suggests the pursuit of physical pleasures."
					)
					((or (Said '/trap') (Said '//trap'))
						(if (not (IsFlag 137))
							(Print 64 17) ; "Everything in this room, including Fatima, should be considered a possible trap."
						else
							(Print 64 18) ; "Aye, you had best avoid it unless you have reason to think it is safe."
						)
					)
					((or (Said '/floor') (Said '//floor'))
						(Print 64 19) ; "It is paved with squares of terra cotta."
					)
					((or (Said '/window,glass') (Said '//window,glass'))
						(Print 64 20) ; "The room has no windows. The alcoves are filled with tiles glazed with complex Arabian patterns."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 64 21) ; "The walls have arches and recessed tiled alcoves."
					)
					(
						(or
							(Said '/alcove')
							(Said '//alcove')
							(OnButton event 114 17 136 66)
							(OnButton event 168 16 190 65)
							(OnButton event 218 17 242 64)
							(OnButton event 8 20 25 73)
						)
						(Print 64 22) ; "The alcoves look primarily decorative, covered with brightly glazed, patterned tiles."
					)
					(
						(or
							(Said '/tile,decoration')
							(Said '//tile,decoration')
							(OnButton event 96 92 229 99)
							(OnButton event 144 116 272 123)
						)
						(Print 64 23) ; "The glazed tiles are bright and dazzle the eye."
					)
				)
			)
			((or (Said 'sleep') (Said '(lie<on)/couch'))
				(Print 64 24) ; "Really, Arthur, that would be most unwise here."
			)
		)
	)
)

(instance enterFatimasHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: loop: 2 setMotion: MoveTo 70 85 self)
			)
			(1
				(entryDoor setCycle: Beg)
				(gEgo setMotion: MoveTo 70 100 self)
			)
			(2
				(if (not (IsFlag 158))
					(fatima setScript: fatimaDance)
				)
				(cond
					((not (IsFlag 162))
						(= cycles 1)
					)
					((IsFlag 158)
						(gTObj talkCue: self)
						(proc64_1 64 25) ; "It is good that you have returned for you have yet to pass the Test of Symbols."
					)
					(else
						(gTObj talkCue: self)
						(proc64_1 64 26) ; "Welcome back, seeker. You have learned a difficult lesson. There is but one way to walk through my outer door in safety and that is when I will it."
					)
				)
			)
			(3
				(SetFlag 163)
				(entryDoor setCel: 0 addToPic:)
				(gEgo ignoreActors: 0)
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 176)
			)
		)
	)
)

(instance leaveFatimas of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(entryDoor setCycle: End self)
			)
			(1
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 70 80 self
				)
			)
			(2
				(gCurRoom newRoom: 63)
			)
		)
	)
)

(instance fatima of Act
	(properties
		y 150
		x 250
		view 368
		loop 4
		illegalBits 0
	)

	(method (init)
		(super init:)
		(if (!= gPrevRoomNum 83)
			(fatima setLoop: 3 setCycle: Walk)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (IsFlag 158) (not global80))
			(localproc_0)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (not (IsFlag 158))
			(seduction handleEvent: event)
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
					(Said 'look/fatima')
					(Said 'ask/merlin/fatima')
					(MouseClaimed fatima event)
				)
				(gTObj endTalk:)
				(= temp1 (Graph grSAVE_BOX 12 25 179 150 1))
				(DrawCel 371 0 0 25 12 -1)
				(Print 64 27 #at 160 40 #width 135) ; "She is so exquisite, that even I am moved by her beauty. And she is no ordinary woman. I feel a power here that rivals my own."
				(Graph grRESTORE_BOX temp1)
				(Graph grREDRAW_BOX 12 25 179 150)
			)
			((Said '*/girl')
				(Print 64 2) ; "This is no girl, Arthur!"
			)
			((Said 'talk[/fatima]')
				(proc64_1 64 28) ; "You have earned the right to question me. Ask of me what you will."
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(cond
					((not (DoPurse))
						(event claimed: 0)
					)
					((not (IsFlag 164))
						(proc64_1 64 29) ; "When I want something of you, seeker, I will ask it."
					)
					(else
						(proc64_1 64 30) ; "I care not what amount of coin you have. I ask for the entire purse, be it empty or full, for the purse represents attachment to material wealth."
					)
				)
			)
			((Said 'get/coin')
				(proc64_1 64 31) ; "What I have to offer you is greater than any sum of money."
			)
			((Said 'give/moneybag')
				(cond
					((not (gEgo has: 3)) ; purse
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((> (gEgo distanceTo: fatima) 50)
						(NotClose) ; "Perhaps you should move closer."
					)
					(else
						(gEgo setScript: (ScriptID 193 1)) ; givePurse
					)
				)
			)
			((Said 'kiss/fatima,her')
				(cond
					((not (IsFlag 158))
						(event claimed: 0)
					)
					((> (gEgo distanceTo: fatima) 30)
						(Print 64 32) ; "Your lips will not reach that far. And I do NOT advise getting closer."
					)
					((not local3)
						(= local3 1)
						(proc64_1 64 33) ; "By refusing my seductions, you have proven yourself to be a man of moral worth. But beware that you do not undo it all with a passing moment of weakness."
					)
					(else
						(gEgo setScript: (ScriptID 193 0)) ; kissFatima
					)
				)
			)
			((Said 'dance')
				(Print 64 34) ; "You would look like a fool."
			)
			((Said 'get,buy/gift,elixer')
				(proc64_1 64 35) ; "For that, you must find the hierophant."
			)
			((Said 'get,throw/bolster')
				(Print 64 36) ; "I cannot see what good that would do you."
			)
			((Said 'get,drink/water')
				(if
					(or
						(gEgo inRect: 40 79 280 108)
						(gEgo inRect: 66 128 320 189)
					)
					(gEgo setScript: (ScriptID 176 2)) ; getWater
				else
					(NotClose) ; "Perhaps you should move closer."
				)
			)
			((Said 'get/key')
				(Print 64 37) ; "There is no key to be gotten."
			)
			((Said '(get<out),escape')
				(Print 64 38) ; "There is but one way out, through the front door."
			)
			((Said 'knock')
				(cond
					((gEgo inRect: 226 76 320 119)
						(gEgo setScript: (ScriptID 176 1)) ; knockOnSideDoor
					)
					((gEgo inRect: 10 88 150 101)
						(Print 64 39) ; "Would you expect anyone to answer?"
					)
					(else
						(NotClose) ; "Perhaps you should move closer."
					)
				)
			)
			((Said 'open/door')
				(if (not local2)
					(proc64_1 64 40) ; "You may leave by the front door at any time, though I advise you not to do so unless I give you my blessing. The inner door opens only at my command."
				else
					(proc64_1 64 41) ; "You may leave by the front door at any time, though I advise you not to do so unless I give you my blessing. The inner door is open. The Test awaits you."
				)
			)
			((Said 'give/lodestone,apple')
				(proc64_1 64 42) ; "It is good that you have brought this. Keep it close to you."
			)
			((Said 'sell,bargain,buy/*')
				(proc64_1 64 43) ; "I should think you have had more than your share of merchants this day."
			)
			((Said 'eat/apple')
				(if (gEgo has: 4) ; rose | apple | green_apple
					(proc64_1 64 44) ; "No, do not eat it now. You may have need for it later."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			(
				(or
					(Said 'climb,stair,walk,wade,dive/pool,fountain,water')
					(Said 'ask//pool[<fatima,her]')
				)
				(proc64_1 64 45) ; "My sacred waters are protected by a spell to keep them clean of any defilement, though I will allow you to drink of it."
			)
			((Said 'bathe/*')
				(proc64_1 64 46) ; "My sacred waters are not for such mundane uses."
			)
			((Said 'smell')
				(Print 64 47) ; "Fatima's heady perfume and musky incense overwhelms your senses with sensual pleasure."
			)
			((Said 'kill,annihilate,attack/fatima')
				(if (not local4)
					(= local4 1)
					(proc64_1 64 48) ; "You cannot draw your sword and if you turn to violence against me, I will punish you."
				else
					(gCurRoom newRoom: 65)
				)
			)
			((Said 'draw/blade')
				(proc64_1 64 49) ; "You are far from the enchantress who gave you this sword and my power is supreme here. Your sword will not leave its scabbard in my presence."
				(= global125 2)
			)
			((Said 'hug,grab,fuck,poke,caress,pinch/fatima')
				(if (IsFlag 158)
					(proc64_1 64 50) ; "Do not seek to lose the good favor you have won from me."
				else
					(proc64_1 64 51) ; "Soon enough, my handsome one."
				)
			)
			((or (Said 'ask[/fatima]/test') (Said 'get,start/test'))
				(cond
					((not (IsFlag 158))
						(proc64_1 64 52) ; "Knowledge must be earned before it will be given."
					)
					((IsFlag 157)
						(proc64_1 64 53) ; "You have passed my Test and are truly you are the most worthy of all men who have passed my door. Go with my blessings and find the hierophant."
					)
					((IsFlag 323)
						(proc64_1 64 54) ; "Enter the door and take my test."
					)
					(else
						(gEgo setScript: (ScriptID 193 2)) ; askAboutTest
					)
				)
			)
			((Said 'ask[/fatima]/*>')
				(cond
					((not (IsFlag 158))
						(event claimed: 1)
						(proc64_1 64 52) ; "Knowledge must be earned before it will be given."
					)
					((Said '//door')
						(proc64_1 64 55) ; "You are acquainted with my front door. This inner door leads to my Test of Symbols."
					)
					((Said '//grail')
						(if (IsFlag 157)
							(proc64_1 64 56) ; "If you persevere, you will find the Grail. Now, you must seek out the hierophant and gain entrance to the catacombs, as did Galahad before you."
						else
							(proc64_1 64 57 64 58 64 59) ; "You have trials of body, spirit and heart yet to face if you are to wrest the Cup of Regeneration from the Goddess and take it with you as the Grail."
						)
					)
					((Said '//galahad')
						(proc64_1 64 60 64 61) ; "He, too, resisted my seductions. I have learned from the hierophant that Galahad entered the catacombs to continue his search."
					)
					((Said '//gawain,lancelot')
						(proc64_1 64 62) ; "I judge from your words that these men also sought the Grail. But I know them not. They have not come to me."
					)
					((Said '//(pool<siloam),aquaduct')
						(proc64_1 64 63) ; "Hezekiah's Aqueduct feeds the Pool of Siloam by bringing it waters from the Spring of Gihon, the same waters I draw upon for my own pool."
					)
					((Said '//catacomb')
						(if (IsFlag 157)
							(proc64_1 64 64) ; "The catacombs lie beneath the city. You must find the hierophant if you wish to enter them."
						else
							(proc64_1 64 65 64 66) ; "The hierophant will guide you to the catacombs, when you are ready. But first I entreat you to pass my Test of Symbols."
						)
					)
					((Said '//hierophant')
						(proc64_1 64 67) ; "Ancient he is, and he is wise, yet shunned by fools who fear his guise."
					)
					((Said '//beggar')
						(proc64_1 64 68) ; "You have seen the leprous beggar. Look to your own knowledge."
					)
					((Said '//design')
						(proc64_1 64 69) ; "The crescent above my inner door signifies that behind it lies the Test of Symbols."
					)
					((Said '//gift,elixer,rat')
						(proc64_1 64 70) ; "You will learn about that from the hierophant, if ever you meet him."
					)
					((Said '//goddess')
						(proc64_1 64 71 64 72) ; "She who I serve has infinite names. Yet in all times and in all places she is known by her three natures."
						(SetScore 301 1 1)
					)
					((Said '//guardian')
						(proc64_1 64 73) ; "You have three more Guardians to face."
					)
					(else
						(event claimed: 1)
						(proc64_1 64 74) ; "Some questions are more worthy of my answers than others. This one is less worthy."
					)
				)
			)
		)
	)
)

(instance seduction of Script
	(properties)

	(method (handleEvent event)
		(cond
			((and (not local6) (Said 'talk[/fatima]'))
				(= local6 1)
				(gEgo setScript: speech1)
			)
			(
				(or
					(and local6 (Said 'yes'))
					(Said 'kiss,love/fatima,her')
					(Said 'be/lover')
					(Said 'make/love')
				)
				(gCurRoom setScript: (ScriptID 208 0)) ; moveEgoAndFatimaToCouch
			)
			((not local6)
				(return)
			)
			((or (Said 'no,never') (Said '/me/refuse') (Said '/will<me/not'))
				(if (not local5)
					(= local5 1)
					(SetScore 328 1 10 2 10)
					(gEgo setScript: speech2)
				else
					(SetScore 329 1 10 2 10)
					(gEgo setScript: arthurResists)
				)
			)
			(else
				(event claimed: 1)
				(proc64_1 64 75) ; "You shall not move until my dance is through. No other words but a yes or a no will do."
			)
		)
	)
)

(instance speech1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(proc64_1 64 76 64 77 64 78) ; "O' handsome stranger from a distant land, this is my dance of love. I offer you pleasures such as you have never known."
			)
			(1
				(gTObj talkCue: self)
				(proc64_1 64 79 64 80) ; "Kiss me and I will give you forgetfulness and bliss in an earthly paradise. All the pains of your heart and soul will be cured."
			)
			(2
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance speech2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(proc64_1 64 81) ; "Then if the delights of the flesh are not enough for you, I can offer more powerful gifts, for I serve the Goddess herself and I have drunk from her sacred cup."
			)
			(1
				(= global219 0)
				(proc64_1 64 82) ; "Behold! A vision of the Holy Grail!"
				(fatima
					view: 371
					setLoop: 1
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(fatima setLoop: 2 setCel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(3
				(fatima setLoop: 1 setCel: 10 cycleSpeed: 0 setCycle: Beg self)
			)
			(4
				(= global219 1)
				(fatima setLoop: 4 cycleSpeed: 0)
				(gTObj talkCue: self)
				(proc64_1 64 83 64 84 64 85) ; "I have the power to give you immortality! With but one kiss, you will become invincible. No man, woman or beast will ever overcome you."
			)
			(5
				(client setScript: 0)
				(User canInput: 1)
			)
		)
	)
)

(instance arthurResists of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (== (bellySound prevSignal:) -1))
			(= seconds 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(gTObj talkCue: self)
				(proc64_1 64 86) ; "Then I find you worthy, King Arthur, and will help you to find what you seek."
			)
			(1
				(if (= local1 [local81 global216])
					(SetFlag 331)
				else
					(self changeState: 2)
				)
			)
			(2
				(HandsOn)
				(= global219 0)
				(fatima
					view: 371
					setLoop: 5
					cycleSpeed: 0
					moveSpeed: 0
					setScript: 0
				)
				(localproc_0)
				(gTObj talkCue: self)
				(proc64_1 64 87) ; "Ask of me what you will."
			)
			(3
				(fatima setCel: 0)
				(SetFlag 158)
				(= global217 -1)
				(= global109 0)
				(gEgo cycleSpeed: 0 moveSpeed: 0)
				(bellySound fade:)
				(= seconds 4)
			)
			(4
				(gRmMusic number: 74 loop: -1 play:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance fatimaDancingAround of CPath ; UNUSED
	(properties)

	(method (at param1)
		(return [local103 param1])
	)
)

(instance fatimaDance of Script
	(properties)

	(method (init)
		(super init: &rest)
		(fatima view: 368 loop: 0 moveSpeed: 1)
		(gEgo moveSpeed: 1 cycleSpeed: 1)
		(= global219 1)
		(= global217 0)
		(= local26 1)
		(= global218 0)
		(fatCue cue:)
		(bellySound play: fatCue)
		(= global109 6)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 [temp4 100])
		(switch (= state newState)
			(0
				(= local0
					(if (IsFlag 331)
						[local90 local1]
					else
						(proc64_2 gEgo)
					)
				)
				(= temp2 (- (= global216 (proc64_2 fatima)) local0))
				(= temp3 global216)
				(if (!= (Abs temp2) 4)
					(cond
						((or (>= -1 temp2 -4) (>= temp2 4))
							(if (< (-- temp3) 1)
								(= temp3 8)
							)
						)
						((> (++ temp3) 8)
							(= temp3 1)
						)
					)
				)
				(= temp0 (fatima x:))
				(= temp1 (fatima y:))
				(if (!= global216 temp3)
					(= local100 [local8 (* (- temp3 1) 2)])
					(= local101 [local8 (+ (* (- temp3 1) 2) 1)])
					(self changeState: 1)
				else
					(-- state)
					(= cycles 4)
				)
			)
			(1
				(= local99 1)
			)
			(2
				(fatima setMotion: MoveTo local100 local101 self)
				(= local100 (= local101 0))
			)
			(3
				(if (and (IsFlag 331) (== (proc64_2 fatima) local1))
					(ClearFlag 331)
					(arthurResists cue:)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance fatCue of Script
	(properties)

	(method (cue &tmp temp0 temp1 temp2)
		(if global219
			(= temp2 0)
			(= temp1 (fatima cel:))
			(fatima setCel: (+ temp1 local26))
			(cond
				((and (== local26 1) (== (fatima cel:) (- (NumCels fatima) 1)))
					(if (== local25 1)
						(= local26 -1)
					else
						(= temp2 1)
					)
				)
				((and (== local26 -1) (== (fatima cel:) 0))
					(= temp2 1)
				)
			)
			(if temp2
				(= global220 1)
				(= temp2 0)
				(if (or (fatima mover:) local99)
					(fatimaMoveLooper doit:)
					(if local99
						(= local99 0)
						(fatimaDance changeState: 2)
					)
				else
					(fatimaDanceLooper doit:)
				)
			else
				(= global220 0)
			)
		)
	)
)

(instance fatimaDanceLooper of Code
	(properties)

	(method (doit &tmp temp0)
		(fatima view: 368)
		(++ global217)
		(if (== (= temp0 (localproc_1)) -1)
			(= global217 1)
			(= temp0 (localproc_1))
		)
		(if (== temp0 4)
			(= local25 1)
		else
			(= local25 0)
		)
		(fatima setLoop: temp0 setCel: 0)
		(= local26 1)
	)
)

(instance fatimaMoveLooper of Script
	(properties)

	(method (doit &tmp temp0)
		(= temp0 (fatima heading:))
		(fatima view: 369 setCel: 0 setStep: 3 3)
		(cond
			((<= 45 temp0 135)
				(switch (Random 0 2)
					(0
						(fatima setLoop: 3 xStep: 4)
					)
					(1
						(fatima setLoop: 6 xStep: 6)
					)
				)
			)
			((<= 135 temp0 225)
				(switch (Random 0 2)
					(0
						(fatima setLoop: 0)
					)
					(1
						(fatima setLoop: 1)
					)
					(2
						(fatima setLoop: 3 xStep: 4)
					)
				)
			)
			((<= 225 temp0 315)
				(switch (Random 0 1)
					(0
						(fatima setLoop: 4 xStep: 4)
					)
					(1
						(fatima setLoop: 5 xStep: 6)
					)
				)
			)
			(else
				(switch (Random 0 2)
					(0
						(fatima setLoop: 2 yStep: 4)
					)
					(1
						(fatima setLoop: 4 xStep: 4)
					)
					(2
						(fatima setLoop: 7)
					)
				)
			)
		)
		(fatima setStep: (fatima xStep:) (fatima yStep:))
	)
)

