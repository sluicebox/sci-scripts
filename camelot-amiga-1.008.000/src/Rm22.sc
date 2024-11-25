;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use n117)
(use eRoom)
(use Interface)
(use Save)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	Rm22 0
)

(synonyms
	(doug man)
)

(local
	local0
	local1
	local2
	local3
)

(instance oldOneWindow of SysWindow
	(properties
		color 11
		back 5
		title { Old Ones }
		brTop 140
		brLeft 60
		brBottom 180
		brRight 250
	)
)

(instance magicStuff of Prop
	(properties
		y 103
		x 151
		z 20
		view 332
		loop 2
	)
)

(instance Rm22 of eRoom
	(properties
		picture 22
	)

	(method (dispose)
		(DisposeScript 132)
		(DisposeScript 111)
		(DisposeScript 972)
		(DisposeScript 917)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(18 4)
					(19 2)
					(20 5)
					(21 3)
					(else 8)
				)
		)
		(if (IsFlag 49)
			(Load rsVIEW 70)
			(Load rsVIEW 69)
			(Load rsVIEW 332)
			(Load rsSCRIPT 960)
			(Load rsSOUND 101)
		)
		(super init:)
		(self setRegions: 104) ; glastonburyTor
		(if (and (== global201 gCurRoomNum) (not (IsFlag 48)) (not (IsFlag 49)))
			((gTObj tWindow:) brLeft: 50 brRight: 250 brBottom: 290)
			(if (or (== gPrevRoomNum 19) (== gPrevRoomNum 18))
				(gMadMonk posn: 68 97 loop: 1)
				(= local1 1)
			else
				((gTObj tWindow:) brLeft: 12)
				(gMadMonk posn: 264 106 loop: 0)
				(= local1 2)
			)
		else
			(gTObj tWindow: oldOneWindow actor: 0)
		)
		(switch gPrevRoomNum
			(18
				(cond
					((IsFlag 53)
						(ClearFlag 53)
						(self enterRoom: 13 220 13 184)
					)
					((IsFlag 54)
						(ClearFlag 54)
						(self enterRoom: 301 220 301 184)
					)
					(else
						(self enterRoom: 160 235 160 184)
					)
				)
			)
			(19
				(self enterRoom: 320 135 290 135)
			)
			(20
				(self enterRoom: 151 60 151 82)
			)
			(else
				(self enterRoom: -10 135 25 135)
			)
		)
		(magicStuff
			cel:
				(cond
					((IsFlag 51) 6)
					(global178 1)
					(else 0)
				)
			setPri: 8
			ignoreActors: 1
			init:
		)
		(gAddToPics doit:)
	)

	(method (notify)
		(gMadMonk setScript: runAway)
	)

	(method (doit)
		(super doit:)
		(cond
			((or (self goingOut:) (self comingIn:)) 0)
			((> (gEgo x:) 310)
				(self leaveRoom: 19 320 (gEgo y:))
			)
			((< (gEgo x:) 10)
				(self leaveRoom: 21 -10 (gEgo y:))
			)
			((> (gEgo y:) 188)
				(gEgo illegalBits: 0)
				(cond
					((< (gEgo x:) 30)
						(SetFlag 53)
					)
					((> (gEgo x:) 280)
						(SetFlag 54)
					)
				)
				(self leaveRoom: 18 (gEgo x:) 235)
			)
			((< (gEgo y:) 75)
				(self leaveRoom: (if (IsFlag 52) 17 else 20) (gEgo x:) 60)
			)
			(
				(or
					(and
						(== local1 1)
						(not local0)
						(gEgo inRect: 8 70 103 140)
					)
					(and
						(== local1 2)
						(not local0)
						(gEgo inRect: 209 74 321 140)
					)
				)
				(gMadMonk setScript: runAway)
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
			((or (OnButton event 9 42 36 72) (OnButton event 101 13 152 35))
				(Print 22 0) ; "They are bushes."
			)
			(
				(or
					(OnButton event 136 125 171 139)
					(OnButton event 164 11 184 25)
					(OnButton event 260 104 283 117)
				)
				(Print 22 1) ; "They are rocks."
			)
			(
				(or
					(OnButton event 25 129 60 182)
					(OnButton event 263 143 294 182)
				)
				(Print 22 2) ; "The ruins are nothing but bits of wall and fallen rock with only the Tor beneath them."
			)
			(
				(or
					(OnButton event 61 150 106 182)
					(OnButton event 217 127 274 182)
					(Said 'look/blossom')
				)
				(Print 22 3) ; "The flowers seem cheerful amid the ancient ruins."
			)
			((or (OnButton event 36 7 94 70) (OnButton event 200 7 282 70))
				(Print 22 4) ; "The arch supports its roof no longer."
			)
			((Said 'alter,stand,climb,get/altar')
				(Print 22 5) ; "Unwise. Desecrating a sacred object is a good way to bring a curse down upon yourself."
			)
			((Said 'genuflect')
				(Print 22 6) ; "Not in this place or you will offend your own god by kneeling to false gods."
			)
			((Said 'pray')
				(Print 22 7) ; "I hope your god is listening."
			)
			((Said 'talk,ask/merlin/dirham')
				(event claimed: 0)
			)
			(
				(Said
					'ask,talk,summon,call,apologize,calm,invoke/spirit,ghost,(ones<old)>'
				)
				(cond
					((not (IsFlag 49))
						(event claimed: 0)
					)
					((IsFlag 60)
						(event claimed: 1)
						(Print 22 8) ; "The Old Ones have taken their silver and gone away."
					)
					(
						(or
							(Said 'talk,apologize,calm,summon,call')
							(Said '//copper,dinar,spirit')
						)
						(= local3 1)
						(self setScript: oldOnesTalk)
					)
					((Said '//dirham')
						(= local3 2)
						(self setScript: oldOnesTalk)
					)
					((Said '//moonlight')
						(= local3 3)
						(self setScript: oldOnesTalk)
					)
					(
						(Said
							'//crescent,mother,(child[<5]),earth,air,water,fire,spirit'
						)
						(= local3 4)
						(SetScore 300 1 1)
						(self setScript: oldOnesTalk)
					)
					(else
						(event claimed: 1)
						(= local3 0)
						(self setScript: oldOnesTalk)
					)
				)
			)
			((Said 'get,remove/coin,dirham')
				(cond
					((or (gEgo has: 6) (IsFlag 51)) ; iron_key | broom | grail
						(Print 22 9) ; "The Old Ones have taken it."
					)
					(global178
						(if
							(or
								(gEgo inRect: 67 116 222 138)
								(gEgo inRect: 68 81 220 114)
							)
							(= local2 1)
							(self setScript: releaseScript)
						else
							(NotClose) ; "Perhaps you should move closer."
						)
					)
					(else
						(Print 22 10) ; "You cannot take back what you have not given."
					)
				)
			)
			((Said 'drop,exit,give/coin,coin,copper,dirham,dinar[/altar]')
				(cond
					((or (not (IsFlag 49)) (gEgo has: 6) (IsFlag 50)) ; iron_key | broom | grail
						(Print 22 11) ; "There is no need."
					)
					((not (DoPurse)) 0)
					((or (IsFlag 52) (IsFlag 60))
						(proc0_18)
						(Print 22 8) ; "The Old Ones have taken their silver and gone away."
					)
					(
						(not
							(or
								(gEgo inRect: 67 116 222 138)
								(gEgo inRect: 68 81 220 114)
							)
						)
						(NotClose) ; "Perhaps you should move closer."
						(proc0_18)
					)
					(global130
						(+= global178 global130)
						(= global130 0)
						(proc0_18)
						(self setScript: releaseScript)
					)
					(global132
						(proc0_18)
						(= local3 5)
						(self setScript: oldOnesTalk)
					)
				)
			)
			((and (IsFlag 49) (Said 'ask/ones<old/loss'))
				(Talk 22 12) ; "The Monk had not the means to buy his freedom, so we kept him as our servant. He was mad, but any servant is better than none."
			)
			((Said 'get,(pick<up)/key,gift')
				(cond
					((not (IsFlag 51))
						(Print 22 13) ; "Of what are you speaking? There is nothing like that here."
					)
					(
						(not
							(or
								(gEgo inRect: 67 116 222 138)
								(gEgo inRect: 68 81 220 114)
							)
						)
						(NotClose) ; "Perhaps you should move closer."
					)
					((gEgo has: 6) ; iron_key | broom | grail
						(event claimed: 0)
					)
					(else
						(SetScore 0 0 1)
						(self setScript: getKey)
					)
				)
			)
			((Said 'exit,abandon/key')
				(if (gEgo has: 6) ; iron_key | broom | grail
					(Print 22 14) ; "What an utterly foolish notion."
				else
					(event claimed: 0)
				)
			)
			((Said 'look<below/altar')
				(Print 22 15) ; "It is too heavy for that."
			)
			((Said 'look<in/altar')
				(Print 22 16) ; "It is solid stone."
			)
			((Said 'look<behind/altar')
				(Print 22 17) ; "There is nothing but grass and weeds."
			)
			((Said 'read,carving,carving')
				(Print 22 18) ; "They are too old and weathered to be made out."
			)
			((Said 'look/gift')
				(cond
					((gEgo has: 6) ; iron_key | broom | grail
						((gInventory at: 6) showSelf:) ; iron_key | broom | grail
					)
					((IsFlag 51)
						(Print 22 19) ; "An iron key lies upon the altar in place of your silver."
					)
					(else
						(event claimed: 0)
					)
				)
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
							(Said '/ruin')
							(Said '//ruin')
						)
						(Print 22 20) ; "In this part of the ruins there are the remains of some kind of altar."
					)
					((and (IsFlag 51) (or (Said '/key') (Said '//key')))
						(Print 22 19) ; "An iron key lies upon the altar in place of your silver."
					)
					((or (Said '/dirham,coin') (Said '//dirham,coin'))
						(cond
							(global178
								(Print 22 21) ; "Your silver coins lie upon the altar."
							)
							((IsFlag 60)
								(Print 22 8) ; "The Old Ones have taken their silver and gone away."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((or (Said '/gift') (Said '//gift'))
						(cond
							((IsFlag 51)
								(Print 22 19) ; "An iron key lies upon the altar in place of your silver."
							)
							((gEgo has: 6) ; iron_key | broom | grail
								(Print 22 22) ; "It is a key, Arthur."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					(
						(or
							(Said '/altar,slab,boulder')
							(Said '//altar,slab,boulder')
							(OnButton event 78 71 226 118)
						)
						(SetScore 257 1 1)
						(cond
							((IsFlag 51)
								(Print 22 19) ; "An iron key lies upon the altar in place of your silver."
							)
							(global178
								(Print 22 23) ; "Some of your silver lies upon the altar."
							)
							(else
								(Print 22 24) ; "It is an extremely ancient altar, of a most peculiar configuration. Its three parts may hint at the worship of a trinity of some sort."
							)
						)
					)
					((or (Said '/carving') (Said '//carving'))
						(Print 22 18) ; "They are too old and weathered to be made out."
					)
					(
						(Said
							'//(crescent<mother),(child<5),crescent,moonlight,earth,air,water,fire,spirit'
						)
						(if (and (IsFlag 49) (not (IsFlag 60)))
							(Print 22 25) ; "Ask the Old Ones."
						else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

(instance oldies of Act
	(properties
		y 88
		x 149
		view 332
		signal 16384
		illegalBits 0
	)
)

(instance oldOnesTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(oldies
					setLoop: 1
					setCel: 0
					setPri: 7
					init:
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(oldies setLoop: 0 setCycle: Fwd)
				(gTObj talkCue: self)
				(switch local3
					(1
						(Talk 22 26 22 27) ; "Copper is for the lowest spirits of the earth. Gold is for young gods. You cannot appease us with those metals."
					)
					(2
						(Talk 22 28) ; "It is the purest of metals. Silver shines with the light of mother-moon. You may win your freedom by giving us as much silver as the mother-moon had children."
					)
					(3
						(Talk 22 29) ; "Moonlight is the gift of mother-moon, so that total darkness will never rule upon the earth."
					)
					(4
						(Talk 22 30) ; "Mother-moon had five children: earth, wind, water, fire and spirit."
					)
					(5
						(Talk 22 31) ; "We do not want that! There is only one metal we cherish."
					)
					(else
						(Talk 22 32) ; "Stay and be our servant and we will tell you wondrous secrets."
					)
				)
			)
			(2
				(oldies setLoop: 1 cel: 6 setCycle: Beg self)
			)
			(3
				(if (== local3 0)
					(Print 22 33) ; "Ignore them, Arthur. Such spirits are notorious liars."
				)
				(oldies dispose:)
				(= cycles 4)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance releaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setMotion:
						MoveTo
						(if (> (gEgo y:) 115)
							(if (> (gEgo x:) 155) 165 else 140)
						else
							167
						)
						(if (> (gEgo y:) 115) 120 else 111)
						self
				)
			)
			(1
				(gEgo
					view: (if (> (gEgo y:) 115) 70 else 69)
					loop:
						(if (> (gEgo y:) 115)
							(if (> (gEgo x:) 155) 0 else 1)
						else
							0
						)
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: Beg self)
				(if local2
					(magicStuff cel: 0)
				else
					(magicStuff cel: 1)
				)
			)
			(3
				(gEgo
					cycleSpeed: 0
					setCycle: Walk
					view: 0
					setMotion:
						MoveTo
						194
						(if (> (gEgo y:) 115) 126 else 84)
						self
				)
			)
			(4
				(if local2
					(= local2 0)
					(+= gSilver global178)
					(= global178 0)
					(gEgo illegalBits: $8000)
					(HandsOn)
					(client setScript: 0)
				else
					(User canControl: 1)
					(gEgo
						illegalBits: $8000
						loop: (if (> (gEgo y:) 115) 3 else 2)
					)
					(gRmMusic number: 101 loop: -1 play:)
					(oldies
						setLoop: 1
						cel: 0
						cycleSpeed: 2
						setCycle: End self
						setPri: 7
						init:
					)
				)
			)
			(5
				(oldies setLoop: 0 setCycle: Fwd)
				(gTObj talkCue: self)
				(if (< global178 5)
					(Talk 22 34) ; "We need more silver to appease us."
				else
					(Talk 22 35) ; "Glorious silver! How pure and perfect it is! Having silver is better than having a servant!"
				)
			)
			(6
				(if (< global178 5)
					(self changeState: 8)
				else
					(magicStuff loop: 2 setCycle: End self)
					(SetFlag 51)
				)
			)
			(7
				(SetScore 258 0 1 1 1)
				(magicStuff stopUpd:)
				(gTObj talkCue: self)
				(Talk 22 36) ; "We release you from our service and leave you a gift."
				(= global178 0)
				(SetFlag 60)
			)
			(8
				(oldies setLoop: 1 cel: 6 setCycle: Beg self)
				(gRmMusic fade:)
			)
			(9
				(HandsOn)
				(oldies dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance getKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setMotion:
						MoveTo
						(if (> (gEgo y:) 115)
							(if (> (gEgo x:) 155) 165 else 140)
						else
							167
						)
						(if (> (gEgo y:) 115) 120 else 111)
						self
				)
			)
			(1
				(gEgo
					view: (if (> (gEgo y:) 115) 70 else 69)
					loop:
						(if (> (gEgo y:) 115)
							(if (> (gEgo x:) 155) 0 else 1)
						else
							0
						)
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(magicStuff dispose:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo
					view: 0
					cycleSpeed: 0
					setCycle: Walk
					illegalBits: $8000
					loop: (if (> (gEgo y:) 115) 3 else 2)
				)
				(gEgo get: 6) ; iron_key | broom | grail
				(ClearFlag 51)
				(HandsOn)
			)
		)
	)
)

(instance runAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gTObj actor: 0 talkCue: 0 endTalk:)
				(gMadMonk
					setCycle: Walk
					setStep: 6 5
					illegalBits: 0
					ignoreActors: 1
				)
				(if (== local1 1)
					(gMadMonk setLoop: 5 setMotion: MoveTo -5 109 self)
					(= register 21)
				else
					(gMadMonk setLoop: 4 setMotion: MoveTo 326 109 self)
					(= register 19)
				)
			)
			(1
				(= global201 register)
				(gMadMonk setMotion: 0 setCycle: 0 dispose:)
			)
		)
	)
)

