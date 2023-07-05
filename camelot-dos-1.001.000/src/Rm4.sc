;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm4 0
)

(synonyms
	(blade excaliber)
)

(local
	local0
	local1
)

(instance door of Prop
	(properties)
)

(instance armourStand of View
	(properties
		y 108
		x 270
		view 104
		loop 1
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
			((MouseClaimed self event)
				(if (IsFlag 3)
					(Print 4 0) ; "Do I really need to tell you that this is the rack upon which your mail tunic was hung?"
				else
					(Print 4 1) ; "Your mail tunic is made of overlapping metal scales, a design copied from Roman cavalry armour."
				)
			)
			((or (Said 'look/armor,tunic') (Said 'ask[/merlin]/armor,tunic'))
				(Print 4 1) ; "Your mail tunic is made of overlapping metal scales, a design copied from Roman cavalry armour."
			)
		)
	)
)

(instance rshield of View
	(properties
		y 61
		x 175
		view 104
		loop 2
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
					(MouseClaimed self event)
					(and
						(or
							(== (event type:) evMOUSEBUTTON)
							(Said 'look,ask,(are<where)>')
						)
						(or
							(Said '/shield,pendragon,dragon')
							(Said '//shield,pendragon,dragon')
							(Said '/design/shield')
							(Said '/design<shield')
							(Said '//design<shield')
						)
					)
				)
				(Print 4 2) ; "Upon this shield is the Red Dragon, in token of your surname, Pendragon, which comes from the Welsh words meaning "supreme war chief"."
			)
		)
	)
)

(instance rsword of View
	(properties
		y 70
		x 200
		view 104
		loop 2
		cel 1
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
					(MouseClaimed self event)
					(Said 'look/blade')
					(Said 'ask[/merlin]/blade')
				)
				(Print 4 3) ; "You received your sword, Excaliber, from the Lady in the Lake. By Her Blessings, may it serve you well."
			)
		)
	)
)

(instance pouch of View
	(properties)

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
					(MouseClaimed self event)
					(and
						(or
							(== (event type:) evMOUSEBUTTON)
							(Said 'look,ask,(are<where)>')
						)
						(or (Said '/moneybag') (Said '//moneybag'))
					)
				)
				(if (not (gEgo has: 3)) ; purse
					(Print 4 4) ; "Your purse remains where you last put it, upon your table."
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance Rm4 of Rm
	(properties
		picture 4
	)

	(method (init)
		(super init:)
		(Load rsVIEW 0)
		(Load rsVIEW 14)
		(= global112 5)
		(global59 brTop: 150)
		(door
			view: 104
			setLoop: 0
			setCel: 255
			posn: 45 113
			setPri: 2
			ignoreActors:
			init:
			setScript: doorActions
		)
		(HandsOff)
		(gEgo
			view: (if (IsFlag 3) 0 else 2)
			loop: 0
			posn: 36 110
			init:
			illegalBits: -32768
			setMotion: MoveTo 70 110 doorActions
		)
		(if (not (IsFlag 3))
			(gCurRoom setScript: armorInRoom)
		)
		(armourStand cel: (if (IsFlag 3) 0 else 1) init:)
		(if (IsItemAt 3) ; purse
			(pouch view: 104 setLoop: 3 setCel: 0 posn: 180 76 setPri: 6 init:)
		)
		(proc0_13 258)
		(gAddToPics doit:)
		(gRmMusic number: 17 loop: -1 play:)
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
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
						)
						(Print 4 5) ; "When you are in need of solitude, this is your room. It is sparsely furnished, as befits a warrior-king."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 4 6) ; "They are made of the same grey stone as the rest of Camelot."
					)
					((or (Said '/rack') (Said '//rack'))
						(Print 4 7) ; "There are two stands in your room. One holds your mail tunic. In the other corner is the rack holding your clothes."
					)
					(
						(Said
							'//goddess,celt,virgin,mother,crone,life,creation,death'
						)
						(Print 4 8) ; "The Celts, like many others, worshipped a Triple Goddess in her three forms: virgin, mother, and crone, which in turn represent creation, life and death."
					)
					(
						(or
							(Said '/window')
							(Said '//window')
							(OnButton event 115 6 133 55)
							(OnButton event 231 6 250 55)
						)
						(Print 4 9) ; "From these windows you see the outer wall of Camelot and the hills, fields and forest beyond."
						(Print 4 10) ; "Unfortunately, you cannot see the Queen's bower from here. Rumour in the palace has it that she placed her bower deliberately out of your sight. But that is only rumour."
					)
					((or (Said '/tree') (Said '//tree'))
						(Print 4 11) ; "Aye, they are nice trees. Now, kindly get your mind on your mission."
					)
					(
						(or
							(Said '/door')
							(Said '//door')
							(OnButton event 31 47 57 112)
						)
						(Print 4 12) ; "It is a heavy wood and metal door."
					)
					((or (Said '/clothes,corner') (Said '//clothes,corner'))
						(if (IsFlag 3)
							(Print 4 13 #icon 104 5 1) ; "Your court clothes hang upon the stand in the corner."
						else
							(Print 4 14 #icon 104 5 0) ; "A sturdy set of travelling clothes hangs upon a wooden stand in the south corner of your room. Another stand against the northeastern wall holds your tunic and armour."
						)
					)
					((or (Said '/crest') (Said '//crest'))
						(Print 4 15) ; "Aye, the lack of helmet is a serious oversight, m'lord.  You will have to compensate with extra caution. You must keep your head if you are to keep your head."
					)
					(
						(or
							(Said '/blanket,bedspread')
							(Said '//blanket,bedspread')
						)
						(Print 4 16) ; "Your bedspread was lovingly made by your wife."
					)
					(
						(or
							(Said '/guenevere,guenevere')
							(Said '//guenevere,guenevere')
						)
						(Print 4 17) ; "Alas, the queen is not here now."
					)
					((or (Said '/bower') (Said '//bower'))
						(Print 4 18) ; "You cannot see it from here."
					)
					((Said 'look<below/carpet')
						(Print 4 19) ; "You should have a word with your servant. A great deal of dust has been swept under this rug."
					)
					((Said 'look<below/bed')
						(Print 4 20) ; "Aside from stirring up the dust, this will not accomplish much."
					)
					((Said 'look<below/table')
						(Print 4 21) ; "There is clearly nothing under the table."
					)
					((Said 'look<in/bed')
						(Print 4 22) ; "Gwen is in the bower, not here."
					)
					(
						(or
							(Said '/bed')
							(Said '//bed')
							(OnButton event 205 158 317 183)
						)
						(Print 4 23) ; "It is a bed, of course. Even a King must sometimes sleep alone when the Queen is indisposed."
					)
					(
						(and
							(IsItemAt 3) ; purse
							(or
								(OnButton event 173 75 186 79)
								(Said '/moneybag')
								(Said '//moneybag')
							)
						)
						(Print 4 4) ; "Your purse remains where you last put it, upon your table."
					)
					((and (IsItemAt 3) (or (Said '/table') (Said '//table'))) ; purse
						(if (IsItemAt 3) ; purse
							(Print 4 24) ; "Your purse lies where you tossed it upon the table last night."
						else
							(Print 4 25) ; "It is a sturdy, oak table."
						)
					)
					(
						(or
							(OnButton event 146 72 220 86)
							(Said '/table')
							(Said '//table')
						)
						(Print 4 25) ; "It is a sturdy, oak table."
					)
					((or (Said '/closet') (Said '//closet'))
						(Print 4 26) ; "Closet? Sounds like the French word "clos", but there is no enclosure in this room."
					)
					(
						(or
							(Said '<down')
							(Said '/carpet,floor')
							(Said '/design/carpet')
							(Said '//carpet,floor')
							(Said '/design<carpet')
							(Said '//design<carpet')
							(OnButton event 95 108 253 150)
						)
						(Print 4 27) ; "A three-armed Celtic symbol adorns your rug, perhaps a reminder of the three-fold Great Goddess of creation, life and death."
					)
					((or (Said '/design') (Said '//design'))
						(Print 4 28) ; "There are two symbols here. One is upon your shield, the other upon your rug."
					)
					((or (Said '/dragon') (Said '//dragon'))
						(Print 4 29) ; "The red dragon upon your shield is your symbol. You are Arthur Pendragon."
					)
					(
						(or
							(Said '/preparation,journey,journey')
							(Said '/preparation,journey,journey')
						)
						(Print 4 30) ; "Preparation is vital. Body, heart, mind, and spirit must all be in readiness before you leave Camelot."
					)
				)
			)
			((Said 'open/door')
				(Print 4 31) ; "Just walk through it."
			)
			((Said 'close/door')
				(Print 4 32) ; "It is a heavy door which swings shut by its own weight."
			)
			((Said 'lift,move/carpet')
				(Print 4 33) ; "The floor beneath it is the same as the rest of your floor."
			)
			(
				(or
					(Said '(sleep,lie[<down,on])[/bed]')
					(Said 'go[<to]/bed')
					(Said 'jump,get/bed')
					(Said 'sleep<to<go')
					(Said 'sleep<go')
				)
				(Print 4 34) ; "This is no time for a nap. Your mission is urgent and every second you delay, your people suffer."
			)
			((Said 'drop,exit/coin,moneybag')
				(Print 4 35) ; "What an incredibly foolish notion."
			)
			((Said 'climb,jump/window,table,wall')
				(Print 4 36) ; "That would get you nowhere fast."
			)
			((Said 'lift,move/table')
				(Print 4 37) ; "It is quite satisfied being where it is."
			)
			((Said 'drop,exit/rose')
				(Print 4 38) ; "A token from Gwenhyver is better kept close to your heart."
			)
			((Said 'get,wear,change,(pick<up),(drop<on)/clothes<court')
				(if (IsFlag 3)
					(Print 4 39) ; "They are not sturdy enough for your mission. Leave them here."
				else
					(Print 4 40) ; "You are already wearing them."
				)
			)
			(
				(and
					(IsFlag 3)
					(Said 'get,wear,(drop<on)/armor,tunic,shield,blade')
				)
				(Print 4 41) ; "You are wearing your armour...as if I should need to tell you that."
			)
			(
				(or
					(Said 'get<dress')
					(Said 'disrobe,dress')
					(Said 'get,wear,change,(drop<on)/clothes')
					(Said '(get<off),replace,remove/armor,shield,blade,clothes')
				)
				(if (IsFlag 3)
					(event claimed: 1)
					(switch local1
						(0
							(Print 4 42) ; "Why?"
							(= local1 1)
						)
						(else
							(gEgo setScript: suitDown)
							(= local1 0)
						)
					)
				else
					(if local0
						(Print 4 43) ; "I sincerely hope you have made up your mind this time."
					)
					(SetScore 232 0 3 1 1)
					(gEgo setScript: suitUp)
				)
			)
			((Said 'get,wear,change,(drop<on),(pick<up)>')
				(cond
					((Said '/blanket,bedspread')
						(Print 4 44) ; "Your servants are already preparing a pack for your journey. It will surely contain a sturdier blanket than this."
					)
					((Said '/table')
						(Print 4 45) ; "A bit large to carry about, one would think."
					)
					((Said '/stand')
						(Print 4 46) ; "It would only get in the way."
					)
					((Said '/crest')
						(Print 4 15) ; "Aye, the lack of helmet is a serious oversight, m'lord.  You will have to compensate with extra caution. You must keep your head if you are to keep your head."
					)
					((Said '/moneybag')
						(cond
							((gEgo has: 3) ; purse
								(Print 4 47) ; "It is in your possession."
							)
							((not (IsItemAt 3)) ; purse
								(Print 4 48) ; "It's not here."
							)
							(else
								(SetScore 0 0 3)
								(gEgo setScript: getPurse)
							)
						)
					)
					((Said '/shield')
						(if (IsFlag 3)
							(Print 4 49) ; "Your shield is upon your arm."
						else
							(Print 4 50) ; "A shield gets in the way of putting on other armour. You need to get your mail tunic and sword first."
						)
					)
					((Said '/blade')
						(if (IsFlag 3)
							(Print 4 51) ; "Your sword is strapped at your side."
						else
							(Print 4 52) ; "Before you can strap on your sword, you need to be wearing your mail tunic."
						)
					)
					((Said '/armor,tunic')
						(if (IsFlag 3)
							(Print 4 53) ; "You are already wearing your armor."
						else
							(Print 4 54) ; "You cannot wear armour over your court clothes. Your travelling clothes are in the south corner of your room."
						)
					)
					((Said '/clothes<court')
						(if (IsFlag 3)
							(Print 4 55) ; "They would not do for this trip. Leave them here."
						else
							(Print 4 56) ; "You already are wearing them."
						)
					)
				)
			)
			((Said 'because')
				(if (== local1 2)
					(= local1 1)
					(Print 4 57) ; "That is not a very good reason."
				else
					(event claimed: 0)
				)
			)
		)
		(switch local1
			(1
				(++ local1)
			)
			(2
				(++ local1)
			)
			(else
				(= local1 0)
			)
		)
		(super handleEvent: event)
	)
)

(instance getPurse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (< (gEgo y:) 98)
					(-- state)
					(gEgo setMotion: MoveTo (gEgo x:) 100 self)
				else
					(gEgo setMotion: MoveTo 170 102 self)
				)
			)
			(1
				(HandsOn)
				(Face gEgo pouch)
				(gEgo get: 3) ; purse
				(gEgo illegalBits: -32768)
				(pouch posn: 0 0 hide:)
				(SetMenu 1281 112 1)
				(client setScript: 0)
			)
		)
	)
)

(instance armorInRoom of Script
	(properties)

	(method (init)
		(super init:)
		(rshield init:)
		(rsword init:)
	)
)

(instance doorActions of Script
	(properties)

	(method (doit)
		(if (and (== (doorActions state:) 2) (& (gEgo onControl: 0) $4000))
			(self changeState: 3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(door setCycle: Beg self)
			)
			(2
				(door stopUpd:)
				(HandsOn)
			)
			(3
				(HandsOff)
				(door setCycle: End self)
				(gEgo illegalBits: 0 ignoreActors: setMotion: MoveTo 45 110)
			)
			(4
				(gCurRoom newRoom: 1)
			)
		)
	)
)

(instance clothes of Act
	(properties)
)

(instance suitUp of Script
	(properties)

	(method (init)
		(super init:)
		(self changeState: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(rsword startUpd:)
				(rshield startUpd:)
				(RedrawCast)
				(if (not local0)
					(Print 4 58 #dispose) ; "How wise of you."
				)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 49 172 self
				)
			)
			(2
				(= register 0)
				(clothes
					view: 104
					setLoop: 6
					setCel: 3
					setStep: 4 8
					posn: 50 140
					illegalBits: 0
					ignoreActors:
					init:
				)
				(= cycles 1)
			)
			(3
				(clothes setCel: register setMotion: MoveTo 50 116 self)
			)
			(4
				(clothes setMotion: MoveTo 50 140 self)
				(if (< (++ register) 4)
					(= state 2)
				)
			)
			(5
				(clr)
				(gEgo view: 14 setLoop: 4 setMotion: MoveTo 250 109 self)
			)
			(6
				(armourStand hide:)
				(gEgo
					setLoop: 0
					setCel: 0
					posn: (armourStand x:) (armourStand y:)
					setCycle: CT 2 1 self
				)
			)
			(7
				(armourStand setCel: 0 show:)
				(gEgo setCycle: End self)
			)
			(8
				(gEgo setLoop: 1 setCel: 0 posn: 253 108 setCycle: End self)
				(SetFlag 3)
			)
			(9
				(gEgo
					setLoop: 6
					setCycle: Walk
					setMotion: MoveTo 188 97 self
				)
			)
			(10
				(rsword posn: 0 0 hide:)
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
				(gEgo get: 0) ; sword
			)
			(11
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(12
				(gEgo get: 1) ; shield
				(rshield posn: 0 0 hide:)
				(gEgo view: 0 setLoop: 3)
				(= cycles 6)
			)
			(13
				(gEgo
					setLoop: -1
					ignoreActors: 0
					illegalBits: -32768
					setCycle: Walk
					setMotion: MoveTo 180 110 self
				)
			)
			(14
				(= local0 0)
				(SetMenu 1283 112 1)
				(gCurRoom setScript: 0)
				(gEgo setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance suitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: illegalBits: 0 setCycle: Walk)
				(= cycles 2)
			)
			(1
				(if (< (gEgo y:) 97)
					(-- state)
					(gEgo setMotion: MoveTo (gEgo x:) 97 self)
				else
					(gEgo setMotion: MoveTo 188 97 self)
				)
			)
			(2
				(PutItem 1) ; shield
				(gEgo view: 14 setLoop: 3 setCel: 255 setCycle: Beg self)
			)
			(3
				(PutItem 0) ; sword
				(rshield posn: 175 61 show:)
				(if (not (gCast contains: rshield))
					(rshield init:)
				)
				(gEgo setLoop: 2 setCel: 255 setCycle: Beg self)
			)
			(4
				(rsword posn: 200 70 show:)
				(if (not (gCast contains: rsword))
					(rsword init:)
				)
				(gEgo
					setLoop: 7
					setCycle: Walk
					setMotion: MoveTo 250 109 self
				)
			)
			(5
				(armourStand setCel: 0 show:)
				(gEgo
					setLoop: 1
					setCel: 255
					posn: 253 108
					setCycle: Beg self
				)
			)
			(6
				(gEgo
					setLoop: 0
					setCel: 255
					posn: (armourStand x:) (armourStand y:)
					setCycle: CT 3 -1 self
				)
			)
			(7
				(armourStand hide:)
				(gEgo setCycle: Beg self)
			)
			(8
				(armourStand setCel: 1 show:)
				(gEgo
					posn: 250 109
					setLoop: 5
					setCycle: Walk
					setMotion: MoveTo 49 172 self
				)
			)
			(9
				(gEgo
					view: 2
					ignoreActors: 0
					illegalBits: -32768
					setLoop: -1
					loop: 3
					setMotion: MoveTo 83 130 self
				)
			)
			(10
				(ClearFlag 3)
				(SetMenu 1283 112 0)
				(gCurRoom setScript: armorInRoom)
				(gEgo loop: 2 setScript: 0)
				(= local0 1)
				(HandsOn)
				(Print 4 59) ; "Hmmph. That was truly pointless."
			)
		)
	)
)

